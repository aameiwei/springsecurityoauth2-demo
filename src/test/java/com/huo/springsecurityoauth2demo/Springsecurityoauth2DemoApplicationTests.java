package com.huo.springsecurityoauth2demo;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.Base64Codec;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootTest
class Springsecurityoauth2DemoApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    public void testCreateToken() {
        JwtBuilder jwtBuilder = Jwts.builder()
                //声明标识（"jti"：”8888“）
                .setId("8888")
                //主题（"sub":"xiaoyuan"）
                .setSubject("xiaoyuan")
                //创建日期（"ita":"*******"）
                .setIssuedAt(new Date())
                //设置过期时间  10分钟
                .setExpiration(new Date(System.currentTimeMillis() + 60 * 10000))
                //设置签名
                .signWith(SignatureAlgorithm.HS256, "yuan")
                //自定义申明
                .claim("roles","admin")
                .claim("logo","***.jpg")
                //可以直接传入map
//                .addClaims(map)
                ;
        String token = jwtBuilder.compact();
        System.out.println(token);
        System.out.println("===========================================");
        String[] split = token.split("\\.");
        for (String s : split) System.out.println(Base64Codec.BASE64.decodeToString(s));
    }

    @Test
    public void testParseToken() {
        String token = "eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiI4ODg4Iiwic3ViIjoieGlhb3l1YW4iLCJpYXQiOjE2NjcxODA3MDIsImV4cCI6MTY2NzE4MTMwMiwicm9sZXMiOiJhZG1pbiIsImxvZ28iOiIqKiouanBnIn0.YtjZFFjtLmYd-MLs4ax69ABiurp8BcWhG8iXbsRrqgc";

        Claims claims = Jwts.parser().setSigningKey("yuan").parseClaimsJws(token).getBody();

        System.out.println("id:" + claims.getId());
        System.out.println("sub:" + claims.getSubject());
        System.out.println("sub:" + claims.getSubject());
        System.out.println("roles:" + claims.get("roles"));
        System.out.println("logo:" + claims.get("logo"));
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("签发时间:" + simpleDateFormat.format(claims.getIssuedAt()));
        System.out.println("过期时间:" + simpleDateFormat.format(claims.getExpiration()));
        System.out.println("当前时间:" + simpleDateFormat.format(new Date()));
    }


}
