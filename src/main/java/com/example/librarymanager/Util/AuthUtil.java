package com.example.librarymanager.Util;

import com.example.librarymanager.Dto.auth.UserAuthentication;
import com.example.librarymanager.Exception.AuthException;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Date;
import java.util.Map;
import java.util.Optional;

/**
 * Ulit : class không được kế thừa (thường dùng là final class)
 */
public final class AuthUtil {


    //    dùng để Hash Password lại, mã hóa lại password
    public static String hashPassword(String password) {
        return DigestUtils.sha256Hex(password);
    }

    public static String generateToken(Map<String, Object> payload, String secretKey) {
        Date now = new Date();
        return Jwts.builder()
                .setClaims(payload)
                .setIssuedAt(now)
                .setExpiration(new Date(now.getTime() + 10 * 60 * 1000))
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .compact();
    }

    @SuppressWarnings("unchecked")
    public static Map<String, Object> getPayloadJwt(String token, String secretKey) throws AuthException {
        try {
            return (Map<String, Object>) Jwts.parser().setSigningKey(secretKey).parse(token).getBody();     // bắt lỗi Token hết hạn
        } catch (ExpiredJwtException e) {
            throw new AuthException("TOKEN_EXPIRED", "Phiên đăng nhập đã hết hạn");
        } catch (Exception e) {
            throw new AuthException("TOKEN_FAIL", "Token không khả dụng");
        }
    }

    public static UserAuthentication getUserAuthentication() {
        return (UserAuthentication) SecurityContextHolder.getContext()
                .getAuthentication()
                .getPrincipal();

    }

    public static Long getUserId() {
        UserAuthentication userAuthentication = getUserAuthentication();
        return Optional.ofNullable(userAuthentication).map(UserAuthentication::getUserId)
                .orElse(null);
    }

}