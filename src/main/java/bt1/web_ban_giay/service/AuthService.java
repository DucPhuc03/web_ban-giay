package bt1.web_ban_giay.service;

import bt1.web_ban_giay.dto.request.UserTokenDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.oauth2.jwt.JwsHeader;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

import static org.springframework.security.oauth2.jose.jws.MacAlgorithm.HS256;

@Service
public class AuthService {
    @Autowired
    JwtEncoder jwtEncoder;
    @Value("${bt1.jwt-expiration}")
    private long jwtExpiration;
    public String createToken(UserTokenDTO userDTO){
        Instant now=Instant.now();
        Instant expriration=now.plus(jwtExpiration, ChronoUnit.SECONDS);
        JwtClaimsSet jwtClaimsSet=JwtClaimsSet.builder()
                .issuedAt(now)
                .expiresAt(expriration)
                .claim("user", userDTO)
                .subject(userDTO.getUsername())
                .build();
        JwsHeader jwsHeader=JwsHeader.with(HS256).build();
        return jwtEncoder.encode(JwtEncoderParameters.from(jwsHeader, jwtClaimsSet)).getTokenValue();
    }
}
