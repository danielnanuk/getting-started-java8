package me.nielcho.jdk8.features;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.Arrays;
import java.util.function.Supplier;

/**
 * Created by daniel on 16/8/11.
 */
public class ConstructorRefAndMethodRef {
    private interface Defaultable{

        default void sayHello(){
            System.out.println("I'm defaultable");
        }

    }

    private static class DefaultableImpl implements  Defaultable{

    }
    private static class OverridableImpl implements  Defaultable{
        @Override
        public void sayHello() {
            System.out.println("I'm overridableImpl");
        }
    }


    private interface DefaultableFactory{

        static Defaultable create(Supplier<Defaultable> supplier){
            return supplier.get();
        }
    }


    private static class Car{

        public static void collide(final Car car){
            System.out.println("Collied "+ car.toString());
        }
        public void repair(){
            System.out.println(this +" is repairing itself");
        }
    }

    private static class PoliceCar{

        public void follow(Car car){
            System.out.println(this +" is following " + car);
        }
    }

    public static void main(String[] args) {
        // constructor reference
        Defaultable defaultable = DefaultableFactory.create(DefaultableImpl::new);
        defaultable.sayHello();
        defaultable = DefaultableFactory.create(OverridableImpl::new);
        defaultable.sayHello();


        // 1. static method reference, the method should accept a car instance
        Car car = new Car();
        Arrays.asList(car).forEach(Car::collide);

        // 2. instance method reference, this method should accept nothing
        Arrays.asList(car).forEach(Car::repair);

        // 3. reference to a specific instance, this method should accept a car instance
        PoliceCar policeCar = new PoliceCar();
        Arrays.asList(car).forEach(policeCar::follow);
    }


}
