package me.nielcho.jdk8.features;

import java.util.Arrays;
import java.util.List;

/**
 * Created by daniel on 16/8/11.
 */
public class Lambdas {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("a", "b");
        list.forEach(e -> System.out.println(e));
        list.forEach((String e) -> System.out.println(e));
        list.forEach(e -> {
            System.out.println(e);
            System.out.println(e);
        });

        list.sort((e1,e2) -> e1.compareTo(e2));
        list.sort((e1, e2) -> {
            return e1.compareTo(e2);
        });
    }
}
