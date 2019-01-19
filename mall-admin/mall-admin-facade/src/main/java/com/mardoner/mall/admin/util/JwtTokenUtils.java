package com.mardoner.mall.admin.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
* @description:  Jwt token生成工具类
 * 生成格式为：header.payload.signature
 * header格式：（算法，token类型）：{"alg": "HS512","typ": "JWT"}
 * payload的格式（用户名、创建时间、生成时间）：{"sub":"wang","created":1489079981393,"exp":1489684781}
 * signature的生成算法：HMACSHA256(base64UrlEncode(header) + "." +base64UrlEncode(payload),secret)
* @className: JwtTokenUtils
* @author whuan-QQ:2500129268
* @email: mardoner12p@gmail.com
* @date 2019/1/19 10:40
* @version 1.0
*/
@Component
public class JwtTokenUtils {
    private static final Logger LOGGER = LoggerFactory.getLogger(JwtTokenUtils.class);

    private static final String CLAIM_KEY_USERNAME = "sub";
    private static final String CLAIM_KEY_CREATED = "created";

    @Value("${jwt.expiration}")
    private Long expiration;
    @Value("${jwt.secret}")
    private String secret;

    /**
     * 从token中获取用户名
     */
    public String getUsernameFromToken(String token) {
        Claims claims = getClaimsFromToken(token);
        return claims.getSubject();
    }

    /**
     * 验证token是否还有效
     * @param token 客户端传递的token
     * @param userDetails 数据库查询的用户信息
     */
    public boolean validateToken(String token, UserDetails userDetails){
        String username = getUsernameFromToken(token);
        return username.equals(userDetails.getUsername()) && !isExpired(token);
    }

    /**
     * 验证token是否过期,
     * @return true过期
     */
    public boolean isExpired(String token){
        Date expirationDate = getExpirationDate(token);
        return expirationDate.before(new Date());           // 与当前时间进行比较
    }

    /**
     * 根据用户信息生成token
     */
    public String generateToken(UserDetails userDetails){
        Map<String, Object> claims = new HashMap<>();
        claims.put(CLAIM_KEY_CREATED,new Date());
        claims.put(CLAIM_KEY_USERNAME, userDetails.getUsername());
        return generateToken(claims);
    }

    /**
     * 刷新token
     */
    public String refreshToken(String token){
        Claims claims = getClaimsFromToken(token);
        claims.put(CLAIM_KEY_CREATED, new Date());
        return generateToken(claims);
    }

    /**
     * 负责生成jwt的token
     */
    private String generateToken(Map<String, Object> claims){
        return Jwts.builder()
                .setClaims(claims)          // 钥匙生成负载
                .setExpiration(generateExpirationDate())
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }

    /**
     * 从token中获取jwt负载
     */
    private Claims getClaimsFromToken(String token){
        Claims claims = null;
        try{
            claims = Jwts.parser().setSigningKey(secret).
                    parseClaimsJws(token).getBody();
        }catch(Exception e){
            LOGGER.info("jwt格式验证失败：{}", token);
        }
        return claims;
    }

    /**
     * 生成token过期时间
     * @return
     */
    private Date generateExpirationDate() {
        return new Date(System.currentTimeMillis() +  expiration * 1000);
    }

    /**
     * 从token中获取过期时间
     */
    private Date getExpirationDate(String token){
        Claims claims = getClaimsFromToken(token);
        return claims.getExpiration();
    }
}
