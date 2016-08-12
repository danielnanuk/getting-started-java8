package me.nielcho.jdk8.features;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Arrays;

/**
 * Created by daniel on 16/8/11.
 */
public class MoreAnnotations {

    @Retention(RetentionPolicy.RUNTIME)
    @Target({ElementType.TYPE_PARAMETER,ElementType.TYPE_USE})
    @interface Anno {

    }

    public static class M<@Anno T>  implements @Anno Runnable{

        @Anno String string;
        @Override
        public void run() {

        }
        void justWannaThrowSomething(@Anno String s) throws  @Anno Exception{

        }
    }

    public static void main(String[] args) throws Exception {

        // as you can see from the output
        // there are more ElementType...like:
        // TYPE_PARAMETER: use it  M<@Anno T>
        // TYPE_USE : you can use it in anywhere you like
        Arrays.asList(ElementType.values()).forEach(System.out::println);

    }




}
