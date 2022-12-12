package com.kvitka.factory;

public class AmericanoFactory implements CoffeeFactory {
    @Override
    public Coffee getCoffee() {
        return new Americano();
    }
}
