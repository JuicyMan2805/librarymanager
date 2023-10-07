package com.example.librarymanager.Util;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * Ulit : class không được kế thừa (thường dùng là final class)
 */
public final class AuthUtil {

    //    dùng để Hash Password lại
    public static String hashPassword(String password) {
        return DigestUtils.sha256Hex(password);
    }

//    public static String generateToken(Map<String, Objects> payload, String secretkey){
//        Date now = new Date();
//        Jwts.builder()
//                .setHeader(payload)
//                .setIssuer();
//
//    }

}