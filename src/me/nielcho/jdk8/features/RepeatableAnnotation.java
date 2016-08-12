package me.nielcho.jdk8.features;

import java.lang.annotation.*;

/**
 * Created by daniel on 16/8/11.
 */
public class RepeatableAnnotation {


    // 为了兼容1.8以下
    @Target(ElementType.TYPE)
    @Retention(RetentionPolicy.RUNTIME)
    @interface Filters {
        Filter[] value();
    }

    @Target(ElementType.TYPE)
    @Retention(RetentionPolicy.RUNTIME)
    @Repeatable(Filters.class)
    @interface Filter {
        String value();
    }

    @Filter("hello")
    @Filter("hello2")
    public interface Filterable{

    }


    public static void main(String[] args) {
        // if the jdk version is above 1.8, use this api to get the Filter annotations
        for(Filter filter: Filterable.class.getAnnotationsByType(Filter.class)){
            System.out.println(filter.value());
        }

        // if the jdk version is below 1.8
        Filters filters = Filterable.class.getAnnotation(Filters.class);
        for(Filter filter:filters.value()){
            System.out.println(filter.value());
        }

    }

}
