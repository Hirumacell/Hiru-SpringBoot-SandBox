package hiru.demospringboot.security;

import hiru.demospringboot.entity.UserEntity;
import hiru.demospringboot.repository.UserRepository;
import io.jsonwebtoken.*;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Component;

import javax.naming.AuthenticationException;
import java.util.Date;
import java.util.Enumeration;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

@Component
public class JwtUtil {

    private final String secret_key = "QTo5RQ2p0E";
    private long accessTokenValidity = 24 * 60 * 60 * 1000;

    private final JwtParser jwtParser;

    private final String TOKEN_HEADER = "Authorization";
    private final String TOKEN_PREFIX = "Bearer ";

    private UserRepository UserRepo;


    public JwtUtil() {
        jwtParser = Jwts.parser().setSigningKey(secret_key);
    }

    public String createToken(UserEntity user) {
        System.out.println("UserEntity -" + user);
        Claims claims = Jwts.claims();

        claims.put("UserId", user.getId());


        Date tokenCreateTime = new Date();
        Date tokenValidity = new Date(tokenCreateTime.getTime() + TimeUnit.MINUTES.toMillis(accessTokenValidity));
        return Jwts.builder()
                .setClaims(claims)
                .setExpiration(tokenValidity)
                .signWith(SignatureAlgorithm.HS256, secret_key)
                .compact();
    }

    private Claims parseJwtClaims(String token) {
        return jwtParser.parseClaimsJws(token).getBody();
    }

    public Claims resolveClaims(HttpServletRequest req) {
        try {
            String token = resolveToken(req);
            if (token != null) {
                return parseJwtClaims(token);
            }
            return null;
        } catch (ExpiredJwtException ex) {
            req.setAttribute("expired", ex.getMessage());
            throw ex;
        } catch (Exception ex) {
            req.setAttribute("invalid", ex.getMessage());
            throw ex;
        }
    }

    public String resolveToken(HttpServletRequest request) {
        String bearerToken = request.getHeader(TOKEN_HEADER);

        Enumeration<String> headerNames = request.getHeaderNames();

        while (headerNames.hasMoreElements()) {
            String headerName = headerNames.nextElement();
            System.out.println("Header Name: " + headerName + ", Value: " + request.getHeader(headerName));
        }

        System.out.println("Bearer Token: " + bearerToken);

        if (bearerToken != null && bearerToken.startsWith(TOKEN_PREFIX)) {
            return bearerToken.substring(TOKEN_PREFIX.length());
        }
        return null;
    }

    public boolean validateClaims(Claims claims) throws AuthenticationException {
        try {
            return claims.getExpiration().after(new Date());
        } catch (Exception e) {
            throw e;
        }
    }

    public boolean checkToken(String token) {
        try {
            Claims claims = parseJwtClaims(token);
            return validateClaims(claims);
        } catch (Exception e) {
            return false;
        }
    }

    public String getUsername(Claims claims) { return claims.get("Username").toString();}

    public String getId(Claims claims) {
        return claims.get("UserId").toString();
    }



}