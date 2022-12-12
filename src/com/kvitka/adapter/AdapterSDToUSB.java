package com.kvitka.adapter;

public class AdapterSDToUSB implements USBInterface {

    private SDCard sdCard;

    public SDCard getSdCard() {
        return sdCard;
    }

    public void insertSdCard(SDCard sdCard) {
        System.out.println("Подключение SD карты к USB адаптеру");
        this.sdCard = sdCard;
    }

    @Override
    public String readUSB() {
        String sdData = sdCard.readSD();
        System.out.println("Чтение данных на USB с SD карты");
        return sdData;
    }

    @Override
    public void writeUSB(String data) {
        System.out.println("Передача данных через USB для записи на SD карту");
        sdCard.writeSD(data);
    }
}
