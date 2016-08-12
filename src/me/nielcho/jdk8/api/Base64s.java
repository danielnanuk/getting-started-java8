package me.nielcho.jdk8.api;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

/**
 * Created by daniel on 16/8/12.
 */
public class Base64s {

    private String encoded;

    public static void main(String[] args) {
        final String oo = "Hello, Base64 in java";

        final String encoded = Base64.getEncoder().encodeToString(oo.getBytes(StandardCharsets.UTF_8));
        System.out.println(encoded);

        final String decoded = new String(Base64.getDecoder().decode(encoded),StandardCharsets.UTF_8);
        System.out.println(decoded);
    }
}
