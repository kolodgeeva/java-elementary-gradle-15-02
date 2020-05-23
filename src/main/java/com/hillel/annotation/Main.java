package com.hillel.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

@ClassAnnotation(Main.class)
@MyAnnotation
public class Main {

    @MyAnnotationOne("first_name")
    String firstName;

    @MyAnnotationTwo
    @MyAnnotationOne("last_name")
    String lastName;

    @MyAnnotationTwo(val = "setName method", number = 100)
    public void setName(@MyAnnotationOne("name") String name) {
        this.lastName = name;
    }

    @Override
    @MyAnnotationTwo(val = "Another string", number = 0)
    public String toString() {
        return null;
    }

    @MyAnnotationTwo(number = 100)
    public static void main(String[] args) {


        Main main = new Main();

        Class<? extends Main> mainClass = main.getClass();

        System.out.println("MyAnnotation present: " + mainClass.isAnnotationPresent(MyAnnotation.class));

        Annotation[] classDeclaredAnnotations = mainClass.getDeclaredAnnotations();

        Arrays.stream(classDeclaredAnnotations).forEach(System.out::println);


        try {
            Field field = mainClass.getDeclaredField("firstName");
            System.out.println(field);

            MyAnnotationOne myAnnotationOne = field.getAnnotation(MyAnnotationOne.class);
            System.out.println("annotation value: " + myAnnotationOne.value());

            Field field1 = mainClass.getDeclaredField("lastName");

            System.out.println(field1);

            Annotation[] annotations = field1.getDeclaredAnnotations();

            Arrays.stream(annotations).forEach(System.out::println);


        } catch (NoSuchFieldException e) {
            System.out.println("Field not found!");
            e.printStackTrace();
        }

        try {
            Method method = mainClass.getMethod("setName", String.class);
            System.out.println(method);

            MyAnnotationTwo myAnnotationTwo = method.getAnnotation(MyAnnotationTwo.class);

            System.out.println("annotation number " + myAnnotationTwo.number());
            System.out.println("annotation val " + myAnnotationTwo.val());

        } catch (NoSuchMethodException e) {
            System.out.println("Method not found!");
            e.printStackTrace();
        }

    }


}
