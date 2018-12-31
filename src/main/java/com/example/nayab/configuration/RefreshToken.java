package com.example.nayab.configuration;

import com.example.nayab.domain.user.Role;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;

import java.util.List;
import java.util.Optional;

public class RefreshToken{

    private Jws<Claims> claims;



    private RefreshToken(Jws<Claims> claims) {
        this.claims = claims;
    }

    public static Optional<RefreshToken> create(String token, String signingKey) {

        Jws<Claims> claims = Jwts.parser().setSigningKey(signingKey).parseClaimsJws(token);

//        Jws<Claims> claims = token.parseClaims(signingKey);

        List<String> scopes = claims.getBody().get("auth", List.class);
        if (scopes == null || scopes.isEmpty()
                || !scopes.stream().filter(scope -> Role.ROLE_ADMIN.getAuthority().equals(scope)).findFirst().isPresent()) {
            return Optional.empty();
        }

        return Optional.of(new RefreshToken(claims));
    }

    public Jws<Claims> getClaims() {
        return claims;
    }

    public String getJti() {
        return claims.getBody().getId();
    }

    public String getSubject() {
        return claims.getBody().getSubject();
    }
}
