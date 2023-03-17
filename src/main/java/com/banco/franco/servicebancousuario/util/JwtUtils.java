package com.banco.franco.servicebancousuario.util;

import com.banco.franco.servicebancousuario.dto.JwtResponse;
import com.banco.franco.servicebancousuario.security.SecurityUser;
import io.jsonwebtoken.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class JwtUtils {
    private static final Logger logger = LoggerFactory.getLogger(JwtUtils.class);

    private static final String secret = "secreto";

    private static final DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hhmmss");


    public static String generateJwtToken(Authentication authentication) {

        SecurityUser userPrincipal = (SecurityUser) authentication.getPrincipal();

        return Jwts.builder()
                .setSubject((userPrincipal.getUsername()))
                .setIssuedAt(new Date())
                .setExpiration(new Date((new Date()).getTime() + 360000))
                .signWith(SignatureAlgorithm.HS512, secret).compact();
    }

    public static JwtResponse generateJwtTokenDTO(Authentication authentication) {

        SecurityUser userPrincipal = (SecurityUser) authentication.getPrincipal();

        String token = Jwts.builder()
                .setSubject((userPrincipal.getUsername()))
                .setIssuedAt(new Date())
                .setExpiration(new Date((new Date()).getTime() + 36000))
                .signWith(SignatureAlgorithm.HS512, secret).compact();



        return new JwtResponse(token, dateFormat.format(new Date()), dateFormat.format(new Date((new Date()).getTime() + 36000)));
    }

    public static String getUsernameFromJwtToken(String token) {
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody().getSubject();
    }

    public static boolean validateJwtToken(String authToken) {
        try {
            Jwts.parser().setSigningKey(secret).parseClaimsJws(authToken);
            return true;
        } catch (SignatureException e) {
            logger.error("Invalid JWT signature: {}", e.getMessage());
        } catch (MalformedJwtException e) {
            logger.error("Invalid JWT token: {}", e.getMessage());
        } catch (ExpiredJwtException e) {
            logger.error("JWT token is expired: {}", e.getMessage());
        } catch (UnsupportedJwtException e) {
            logger.error("JWT token is unsupported: {}", e.getMessage());
        } catch (IllegalArgumentException e) {
            logger.error("JWT claims string is empty: {}", e.getMessage());
        }

        return false;
    }
}
