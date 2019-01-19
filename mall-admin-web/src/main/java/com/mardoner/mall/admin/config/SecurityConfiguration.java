package com.mardoner.mall.admin.config;

import com.mardoner.mall.admin.component.JwtAuthenticationTokenFilter;
import com.mardoner.mall.admin.entity.ums.UmsAdmin;
import com.mardoner.mall.admin.entity.ums.UmsPermission;
import com.mardoner.mall.admin.service.ums.UmsAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import javax.annotation.Resource;
import java.util.List;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Resource(name = "umsAdminServiceImpl")
    UmsAdminService adminService;
    @Autowired
    AccessDeniedHandler deniedHandler;
    @Autowired
    AuthenticationEntryPoint authenticationEntryPoint;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()           // 基于jwt无需csrf
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)     //基于token,无需session
                .and().authorizeRequests()
                .antMatchers(HttpMethod.GET,            // 静态资源无需授权
                        "/","/favicon.ico","/*.html",
                        "/**/.css,/**/.js","/swagger*/**","/v2/api-docs/**","/webjars/**").permitAll()
                .antMatchers("/admin/login","/admin/register").permitAll()      //登录与注册页匿名访问
                .antMatchers(HttpMethod.OPTIONS).permitAll()                // 跨域嗅探
//                .antMatchers("/**").permitAll()                 // 测试全部可以访问
                .anyRequest().authenticated();          // 其他资源全部需要鉴定权限
        // 禁用缓存
        http.headers().cacheControl();
        // 添加jwt token过滤器
        http.addFilterBefore(jwtAuthenticationTokenFilter(), UsernamePasswordAuthenticationFilter.class);
        // 添加自定义未登录和未授权处理
        http.exceptionHandling()
                .accessDeniedHandler(deniedHandler)
                .authenticationEntryPoint(authenticationEntryPoint);
        http.csrf().disable();
    }

    @Bean
    public AuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService());
        authProvider.setPasswordEncoder(passwordEncoder());
        authProvider.setHideUserNotFoundExceptions(false);
        return authProvider;
    }

    @Bean
    public UserDetailsService userDetailsService(){
        return username -> {
            UmsAdmin umsAdmin = adminService.getAdminByUsername(username);
            if(umsAdmin != null){
                List<UmsPermission> permissionList = adminService.getPermissionList(umsAdmin.getId());
                return new AdminUserDetails(umsAdmin,permissionList);
            }
            throw new UsernameNotFoundException("用户名或者密码错误！");
        };
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    /**
     * JWT token FILTER
     */
    @Bean
    public JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter(){
        return new JwtAuthenticationTokenFilter();
    }

    /**
     * 跨域过滤器配置
     */
    @Bean
    public CorsFilter corsFilter(){
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
        config.addAllowedOrigin("*");
        config.addAllowedMethod("*");
        config.addAllowedHeader("*");
        source.registerCorsConfiguration("/**",config);

        return new CorsFilter(source);
    }

}
