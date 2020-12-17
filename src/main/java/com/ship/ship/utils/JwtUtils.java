package com.ship.ship.utils;

import com.ship.ship.constants.JwtConstants;
import com.ship.ship.dto.UserDTO;
import com.ship.ship.jwt.JWTResponse;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

@Component
public class JwtUtils {

    public JWTResponse generateJWTToken(UserDTO userDTO){
        JWTResponse jwtResponse;
        long timestamp = System.currentTimeMillis();
        LocalDateTime currentTime = LocalDateTime.now();
        LocalDateTime nextTime = addMinutes(JwtConstants.EXPIRATION_TIME,currentTime);
        Date expirationDate = Date.from(nextTime.atZone(ZoneId.systemDefault()).toInstant());
        String token = Jwts.builder().signWith(SignatureAlgorithm.HS256, JwtConstants.API_SECRET_KEY)
                .setIssuedAt(new Date(timestamp))
                .setExpiration(expirationDate)
                .claim("User", userDTO)
                .compact();
        jwtResponse = new JWTResponse(token,expirationDate,userDTO);
        return jwtResponse;
    }

    public LocalDateTime addHour(Long value, LocalDateTime currentTime){
        return currentTime.plusHours(value);
    }

    public LocalDateTime addMinutes(Long value, LocalDateTime currentTime){
        return currentTime.plusSeconds(90);
    }
}
