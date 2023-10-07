package com.recancheros.fieldsservice.config.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtUtils {

    private static final long ACCESS_TOKEN_EXPIRATION_MS = 15 * 60 * (long) 1000;
    @Value("${jwt.secret}")
    private String key;


    // Método para generar un token JWT
    public String generateToken(Authentication authentication) {
        UserDetails user = (UserDetails) authentication.getPrincipal();
        Date now = new Date();
        Date expiration = new Date(now.getTime() + ACCESS_TOKEN_EXPIRATION_MS);

        return Jwts.builder()
                .setSubject(user.getUsername())
                .setIssuedAt(now)
                .setExpiration(expiration)
                .signWith(SignatureAlgorithm.HS512, key)
                .compact();
    }

    // Método para resolver el token desde la solicitud
    public String resolveToken(HttpServletRequest request) {
        String bearerToken = request.getHeader("Authorization");
        if (bearerToken != null && bearerToken.startsWith("Bearer ")) {
            return bearerToken.substring(7); // Quita "Bearer " para obtener el token
        }
        return null;
    }

    public Claims extractAllClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(key.getBytes())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    // Método para validar un token JWT
    public boolean validateToken(String token) {
        try {
            Jwts.parser().setSigningKey(key.getBytes()).parseClaimsJws(token);
            return true;
        } catch (JwtException | IllegalArgumentException e) {
            // El token es inválido o ha expirado
            return false;
        }
    }

    // Método para obtener la autenticación a partir del token
    public Authentication getAuthentication(String token) {
        String username = Jwts.parser().setSigningKey(key).parseClaimsJws(token).getBody().getSubject();
        // Aquí, puedes cargar los roles del usuario desde tu sistema de autenticación o bases de datos si es necesario.
        // Luego, puedes configurar la autenticación con esos roles.
        // Por ejemplo:
        // List<GrantedAuthority> authorities = loadAuthoritiesByUsername(username);
        // UserDetails userDetails = new User(username, "", authorities);
        // return new UsernamePasswordAuthenticationToken(userDetails, "", authorities);
        return null; // Implementa la carga de roles y UserDetails según tu sistema
    }
}
