package com.kvitka.factory;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class FactoryMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String coffeeType = scanner.nextLine();
        CoffeeFactory coffeeShop = createFactoryByType(coffeeType);

        Coffee coffee = coffeeShop.getCoffee();

        coffee.info();
    }

    public static CoffeeFactory createFactoryByType(String coffeeType) {
        coffeeType = coffeeType.toLowerCase();
        if (AMERICANO_NAMES.contains(coffeeType))       return new AmericanoFactory();
        else if (ESPRESSO_NAMES.contains(coffeeType))   return new EspressoFactory();
        throw new IllegalArgumentException("Coffee type \"" + coffeeType + "\" doesn't exist (yet)");

    }

    private static final List<String> ESPRESSO_NAMES = Arrays.asList("эспрессо", "espresso");
    private static final List<String> AMERICANO_NAMES = Arrays.asList("американо", "americano");
}
