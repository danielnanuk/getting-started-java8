package me.nielcho.jdk8.features;

/**
 * Created by daniel on 16/8/11.
 */
public class Functional {


    // declare some functional interface
    @FunctionalInterface
    interface SomeFunc<T,F> {
        F hello(T t);


        // default method, the implementer may or may not implement this
        default void print(T t){
            System.out.println(t);
        }

        // Interfaces now allow static methods
        static void println(Object object){
            System.out.println(object);
        }
    }

    public static void main(String[] args) {
        // create a instance with giving implementation
        SomeFunc<String, Integer>  someFunc = (from) -> Integer.valueOf(from);
        System.out.println(someFunc.hello("1"));
        someFunc.print("hello");
        SomeFunc.println("bb");

    }

}
