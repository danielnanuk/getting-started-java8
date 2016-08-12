package me.nielcho.jdk8.api;

import java.util.Optional;
import java.util.concurrent.RunnableFuture;

/**
 * Created by daniel on 16/8/11.
 */
public class Optionals {


    public static void main(String[] args) {
        // Optional.of() : no null
        // Optional.ofNullable : nullable
        Optional<String> optionalString = Optional.ofNullable(null);

        // check if the value is present
        if(optionalString.isPresent()){
            System.out.println(optionalString.get());
        }else{
            System.out.println("hello");
        }

        // code above equals

        // if the value is null, return the second value
        System.out.println(optionalString.orElseGet(()->"hello"));
        System.out.println(optionalString.orElse("hello"));
        try{
            System.out.println(optionalString.orElseThrow(() -> new RuntimeException("hello")));
        }catch (Exception e){
            System.err.println(e.getMessage());
        }


        // If a value is present, invoke the specified consumer with the value, otherwise do nothing.
        optionalString.ifPresent(System.out::println);

        // If a value is present, apply the provided mapping function to it, and if the result is non-null, return an Optional describing the result.
        optionalString.map(Integer::valueOf);

        // If a value is present, and the value matches the given predicate, return an Optional describing the value, otherwise return an empty Optional.
        optionalString.filter((e) -> "a".equals(e));

        // If a value is present, apply the provided Optional-bearing mapping function to it, return that result, otherwise return an empty Optional.
        optionalString.flatMap((e)-> Optional.ofNullable(Integer.valueOf(e)));



    }

}
