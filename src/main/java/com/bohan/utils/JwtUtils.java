package com.bohan.utils;

import com.bohan.entity.User;
import io.jsonwebtoken.*;

import java.util.Date;

public class JwtUtils {


    public static final String SUBJECT = "bohanStudy";

    public static final long EXPIRE = 1000 * 60 * 60 * 24 * 7;

    public static final String APPSECRET = "bhx1995!@#";

    public static String geneJsonWebToken(User user) {
        if(user ==null || user.getId() == null || user.getName() == null ||user.getHeadImg() == null){
            return null;
        }
        String token = Jwts.builder().setSubject(SUBJECT)
                .claim("id", user.getId())
                .claim("name", user.getName())
                .claim("img", user.getHeadImg())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRE))
                .signWith(SignatureAlgorithm.HS256, APPSECRET).compact();
        return token;
    }

    public static Claims checkJwt(String token){

        try {
            final Claims claims = Jwts.parser().setSigningKey(APPSECRET).parseClaimsJws(token).getBody();
            return claims;
        } catch (ExpiredJwtException e) {
            e.printStackTrace();
            return null;
        } catch (UnsupportedJwtException e) {
            e.printStackTrace();
            return null;
        } catch (MalformedJwtException e) {
            e.printStackTrace();
            return null;

        } catch (SignatureException e) {
            e.printStackTrace();
            return null;

        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return null;
        }

    }
}
