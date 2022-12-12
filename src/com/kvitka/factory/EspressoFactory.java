package com.kvitka.factory;

public class EspressoFactory implements CoffeeFactory {
    @Override
    public Coffee getCoffee() {
        return new Espresso();
    }
}
