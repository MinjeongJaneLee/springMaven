package com.spring.system.security;

import org.apache.commons.codec.binary.Base64;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.util.StringUtils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 사용자 인증시 패스워드 인코딩을 위한 클래스 이다.
 */
public class CustomPasswordEncoder implements PasswordEncoder {
    @Override
    public String encode(CharSequence rawPassword) {
        return sha512Encode(rawPassword.toString());
    }

    @Override
    public boolean matches(CharSequence rawPassword, String password) {
        String _password = password;
        if (password.length() != 128) {
            _password = sha512Encode(base64Decode(password));
        }
        return _password.equals(encode(rawPassword));
    }

    private String base64Encode(String rawPassword) {
        if (StringUtils.isEmpty(rawPassword)) {
            return "";
        } else {
            return Base64.encodeBase64URLSafeString(rawPassword.getBytes());
        }
    }

    private String base64Decode(String rawPassword) {
        if (StringUtils.isEmpty(rawPassword)) {
            return "";
        } else {
            return new String(Base64.decodeBase64(rawPassword));
        }
    }

    private String sha512Encode(String rawPassword) {
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("SHA-512");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
        md.update(rawPassword.getBytes());
        byte byteData[] = md.digest();

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < byteData.length; i++) {
            sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
        }

        StringBuffer hexString = new StringBuffer();
        for (int i=0;i<byteData.length;i++) {
            String hex=Integer.toHexString(0xff & byteData[i]);
            if(hex.length()==1){
                hexString.append('0');
            }
            hexString.append(hex);
        }
        return hexString.toString();
    }
}
