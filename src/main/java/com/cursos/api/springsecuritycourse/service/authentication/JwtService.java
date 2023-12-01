package com.cursos.api.springsecuritycourse.service.authentication;

import com.cursos.api.springsecuritycourse.persistence.entity.User;
import io.jsonwebtoken.Header;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class JwtService {

    //variable declarada en el application.properties
    @Value("${security.jwt.expiration-in-minutes}")
    private Long EXPIRATION_IN_MINUTES;
    @Value("${security.jwt.secret-key}")
    private String SECRET_KEY;

    public String generateToken(UserDetails user,Map<String,Object> extraClaims) {
        Date issuedAt = new Date(System.currentTimeMillis());
        //fecha de expiracion en milisegundos
        Date expiration= new Date((EXPIRATION_IN_MINUTES*60*1000)+issuedAt.getTime());
        String jwt = Jwts.builder()
                .setClaims(extraClaims)
                .setSubject(user.getUsername())
                .setIssuedAt(issuedAt)
                .setExpiration(expiration)
                .setHeaderParam(Header.TYPE,Header.JWT_TYPE)
                //firmas y algoritmo de cifrado
                .signWith(generateKey(), SignatureAlgorithm.HS256)
                //para devolver el string
                .compact();

        return jwt;
    }

    //genera la clave del token
    private Key generateKey(){
        //esto se hace porque la clave está codificada
        byte[] passwordDecoded = Decoders.BASE64.decode(SECRET_KEY);
        System.out.println(new String(passwordDecoded));

        return Keys.hmacShaKeyFor(passwordDecoded);
        //esto se hace si no tenemos codificada la clave en el application.properties
        //byte[] key = SECRET_KEY.getBytes();
        //return Keys.hmacShaKeyFor(key);
    }
}