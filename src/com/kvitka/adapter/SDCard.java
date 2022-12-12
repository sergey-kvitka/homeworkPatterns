package com.kvitka.adapter;

public class SDCard {

    private String data;

    public String readSD() {
        System.out.println("Данные считаны с SD карты");
        return data;
    }

    public void writeSD(String data) {
        System.out.println("Данные записаны на SD карту");
        this.data = data;
    }
}
