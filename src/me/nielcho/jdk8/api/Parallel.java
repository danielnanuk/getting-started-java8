package me.nielcho.jdk8.api;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by daniel on 16/8/12.
 */
public class Parallel {

    public static void main(String[] args) {
        long[] arrayOfLong = new long[20000];

        Arrays.parallelSetAll(arrayOfLong, index -> ThreadLocalRandom.current().nextInt(100000));

        Arrays.stream(arrayOfLong).limit(10).forEach(System.out::println);

        Arrays.parallelSort(arrayOfLong);

        Arrays.stream(arrayOfLong).limit(10).forEach(System.out::println);
    }
}
