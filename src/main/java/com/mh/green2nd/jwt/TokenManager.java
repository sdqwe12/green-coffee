package com.mh.green2nd.jwt;

import com.mh.green2nd.user.Role;
import com.mh.green2nd.user.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

import static io.jsonwebtoken.security.Keys.hmacShaKeyFor;

@Component
public class TokenManager {

    @Value("${mh.jwt.secret}")
    private String mykey;


    // 토큰 발급해주는 함수
    public String generateToken(User user) {
        return Jwts.builder()
                .subject("mhToken")
                .claim("user_id", user.getUser_id())
                .claim("nickname", user.getNickname())
                .claim("email", user.getEmail())
                .claim("role", Role.USER)
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24))
                .signWith(hmacShaKeyFor(mykey.getBytes()))
                .compact();
    }

    // 리프레시 토큰 발급해주는 함수
    public String generateRefreshToken(Long userId) {
        return Jwts.builder()
                .setId(Long.toString(userId))
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24 * 7)) // 7 days
                .signWith(hmacShaKeyFor(mykey.getBytes()))
                .compact();
    }

    // 토큰 검증해주는 함수.
    public Jws<Claims> validateToken(String token) {
        Jws<Claims> jws = Jwts.parser()// 번역해라
                .setSigningKey(hmacShaKeyFor(mykey.getBytes()))// 비밀번호로...
                .build()
                .parseClaimsJws(token); // claim 들을 번역해라 컬렉션타입으로 만들어줘
        System.out.println(jws);
        return jws;
    }

}
