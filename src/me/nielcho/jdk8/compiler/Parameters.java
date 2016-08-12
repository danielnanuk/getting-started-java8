package me.nielcho.jdk8.compiler;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

/**
 * Created by daniel on 16/8/11.
 */
public class Parameters {

    public static void main(String[] args) throws  Exception{
        Method method = Parameters.class.getMethod("main",String[].class);
        Parameter[] parameters = method.getParameters();
        for (Parameter parameter : parameters) {
            System.out.println("Parameter : " + parameter.getName());
        }

        // if you compile and run the code above without -parameters
        // the output should be : "Parameter : arg0"


        // if you compile with -parameters
        // the output should be : "Parameter : args"

    }
}

