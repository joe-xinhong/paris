package com.commune.paris.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
* @Description:    Jwt工具类
* @Author:         Joe
* @CreateDate:     2020/6/5 20:32
*/
@Data
@Component
@Slf4j
public class JwtUtils {
    /**
     * 秘钥
     */
    @Value("${markerhub.jwt.secret}")
    private String secret;
    /**
     * 有效时长
     */
    @Value("${markerhub.jwt.expire}")
    private long expire;
    /**
     * header
     */
    @Value("${markerhub.jwt.header}")
    private String header;

    /**
     * 生成jwt token
     * @param userId
     * @return
     */
    public String generateToken(Integer userId){
        Date nowDate = new Date();
        Date expireDate = new Date(nowDate.getTime() + expire * 1000);
        return Jwts.builder()
                .setHeaderParam("typ","JWT")
                .setSubject(userId+"")
                .setIssuedAt(nowDate)
                .setExpiration(expireDate)
                .signWith(SignatureAlgorithm.HS512,secret)
                .compact();

    }

    public Claims getClaimByToken(String token){
        try {
            return Jwts.parser()
                    .setSigningKey(secret)
                    .parseClaimsJws(token)
                    .getBody();
        }catch (Exception e){
            log.debug("验证 token error:",e);
            return null;
        }

    }

    /**
     * token是否过期
     * @param expiration true 过期
     * @return
     */
    public boolean isTokenExpired(Date expiration){
        return expiration.before(new Date());
    }


}
