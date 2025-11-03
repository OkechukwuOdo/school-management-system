package com.justintime.schoolmanagement.paymentService;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.time.Instant;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

public class PaystackUtil {

    public static boolean verifySignature(String payload, String paystackSignature, String secretKey) {
        try {
            Mac sha512_HMAC = Mac.getInstance("HmacSHA512");
            SecretKeySpec keySpec = new SecretKeySpec(secretKey.getBytes(), "HmacSHA512");
            sha512_HMAC.init(keySpec);
            byte[] hash = sha512_HMAC.doFinal(payload.getBytes());
            String computedHash = bytesToHex(hash);
            return computedHash.equalsIgnoreCase(paystackSignature);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private static String bytesToHex(byte[] hash) {
        StringBuilder hexString = new StringBuilder(2 * hash.length);
        for (byte b : hash) {
            String hex = Integer.toHexString(0xff & b);
            if(hex.length() == 1) hexString.append('0');
            hexString.append(hex);
        }
        return hexString.toString();
    }
    public static String generateReference(String purpose, String email) {
        String date = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyyMMdd"));
        String random = UUID.randomUUID().toString().substring(0, 6).toUpperCase();

        return purpose.toUpperCase() + "_" + email + "_" + date + "_" + random;
    }
}
