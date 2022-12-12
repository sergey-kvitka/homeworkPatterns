package com.kvitka.singleton;

import java.util.function.Predicate;

@SuppressWarnings("deprecation")
public class SingletonMain {
    public static void main(String[] args) {
        Logger logger = Logger.getInstance();

        Test test = new Test();

        int number = 8;

        Object object = new Object();

        String[] lines = {"a", "b", "c"};

        logger.info(test);
        System.out.println();
        logger.info(number);
        System.out.println();
        logger.info(object);
        System.out.println();
        logger.info(lines);
    }
}

@Deprecated
@SuppressWarnings("")
class Test extends SingletonMain implements Predicate<Test>, Inter1 {

    int number;
    String line;

    Test() {
    }

    public Test(int number, String line) {
        this.number = number;
        this.line = line;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public boolean test(Test test) {
        return false;
    }
}

interface Inter1 {
}