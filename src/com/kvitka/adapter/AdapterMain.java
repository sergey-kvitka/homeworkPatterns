package com.kvitka.adapter;

public class AdapterMain {
    public static void main(String[] args) {

        Computer computer = new Computer();

        SDCard card = new SDCard();

        AdapterSDToUSB adapterSDToUSB = new AdapterSDToUSB();

        adapterSDToUSB.insertSdCard(card);
        l();
        computer.setUsbInterface(adapterSDToUSB);
        l();
        computer.getUsbInterface().writeUSB("hello world");
        l();
        String dataFromSD = computer.getUsbInterface().readUSB();
        l();
        System.out.println("Данные с SD карты: " + dataFromSD);
    }

    private static void l() { System.out.println(); }
}
