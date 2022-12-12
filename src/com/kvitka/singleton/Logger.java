package com.kvitka.singleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Logger {

    private static Logger logger;

    public static Logger getInstance() {
        if (logger == null) logger = new Logger();
        return logger;
    }

    private Logger() {
    }

    public void info(Object object) {
        List<String> result = new ArrayList<>();

        Class<?> objectClass = object.getClass();
        Class<?> superclass = objectClass.getSuperclass();
        Field[] fields = objectClass.getDeclaredFields();
        Method[] methods = objectClass.getDeclaredMethods();
        Constructor<?>[] constructors = objectClass.getDeclaredConstructors();

        List<String> annotations = Arrays.stream(objectClass.getDeclaredAnnotations())
                .map(annotation -> annotation.annotationType().getSimpleName())
                .collect(Collectors.toList());
        List<String> interfaces = Arrays.stream(objectClass.getInterfaces())
                .map(Class::getSimpleName)
                .collect(Collectors.toList());

        result.add("Информация о классе " + objectClass.getSimpleName() + ":");
        result.add("  > Аннотации:" + (annotations.size() == 0 ? " пусто" : ""));

        for (String annotation : annotations) {
            result.add("\t - " + annotation);
        }

        result.add("  > Класс-родитель: " + (superclass == null ? "пусто" : superclass.getSimpleName()));
        result.add("  > Интерфейсы:" + (interfaces.size() == 0 ? " пусто" : ""));

        for (String anInterface : interfaces) {
            result.add("\t - " + anInterface);
        }

        result.add("  > Поля:" + (fields.length == 0 ? " пусто" : ""));

        for (Field field : fields) {
            result.add(String.format("\t - %s %s", field.getType().getSimpleName(), field.getName()));
        }

        result.add("  > Конструкторы:" + (constructors.length == 0 ? " пусто" : ""));
        String parameters;

        for (Constructor<?> constructor : constructors) {
            parameters = Arrays.stream(constructor.getParameters())
                    .map(parameter -> String.format("%s %s",
                            parameter.getType().getSimpleName(), parameter.getName()))
                    .collect(Collectors.joining(", "));
            result.add(String.format("\t - %s(%s)", constructor.getDeclaringClass().getSimpleName(), parameters));
        }

        result.add("  > Методы:" + (methods.length == 0 ? " пусто" : ""));

        for (Method method : methods) {
            parameters = Arrays.stream(method.getParameters())
                    .map(parameter -> String.format("%s %s",
                            parameter.getType().getSimpleName(), parameter.getName()))
                    .collect(Collectors.joining(", "));
            result.add(String.format("\t - %s(%s): %s",
                    method.getName(), parameters, method.getReturnType().getSimpleName()));
        }

        System.out.println(String.join("\n", result));
    }
}