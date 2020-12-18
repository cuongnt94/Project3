package com.timesheet.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.timesheet.vo.JWTPayload;

import javax.xml.bind.DatatypeConverter;

import static java.security.KeyRep.Type.SECRET;
import static javax.crypto.Cipher.SECRET_KEY;

/**
 * Description: <br>
 *
 * @author: Billy <br>
 * @createDate: 2020-12-18 <br>
 */
public class JWTToken {

    public static DecodedJWT getTokens(String tokens){
        return JWT.require(Algorithm.HMAC256(String.valueOf(SECRET))).build().verify(tokens);
    }

    public static JWTPayload getPayload(String token){
        DecodedJWT decodedJWT = JWT.decode(token);
        JWTPayload payload = new JWTPayload(decodedJWT.getClaim("id").asString(),decodedJWT.getClaim("role").asString());
        return payload;
    }
}
