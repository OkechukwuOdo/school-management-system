package com.justintime.schoolmanagement.utilz.config;

import java.util.UUID;

public class HelperFunction {
    public static String generateUniqueReference() {
        return "Fee_" + UUID.randomUUID().toString().replace("-", "").substring(0, 20).toUpperCase();
    }
}
