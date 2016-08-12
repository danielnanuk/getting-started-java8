package me.nielcho.jdk8.features;

/**
 * Created by daniel on 16/8/11.
 */
public class BetterTypeInference {


    public static void main(String[] args) {
        // the return type of this method can be infer
        String defaultString = Value.defaultValue();
        System.out.println(defaultString);

        Value<String> value = new Value<>();

        String str = value.getOrDefault("123", Value.defaultValue());
        System.out.println(str);
    }

    private static class Value<T> {
        public static <T> T defaultValue() {
            return null;
        }

        public T getOrDefault(T value, T defaultValue) {
            return value != null ? value : defaultValue;
        }
    }

}
