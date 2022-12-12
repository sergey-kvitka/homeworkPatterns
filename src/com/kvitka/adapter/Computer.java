package com.kvitka.adapter;

public class Computer {

    private USBInterface usbInterface;

    public USBInterface getUsbInterface() {
        System.out.println("Взаимодействие ПК с USB...");
        return usbInterface;
    }

    public void setUsbInterface(USBInterface usbInterface) {
        System.out.println("*звук втыкания USB в ПК*");
        this.usbInterface = usbInterface;
    }
}
