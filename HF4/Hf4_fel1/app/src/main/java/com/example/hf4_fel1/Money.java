package com.example.hf4_fel1;

public class Money {

    private Integer image;
    private String currency;
    private String extraInformation;
    private double sellValue;
    private double buyValue;

    public Money(Integer image, String currency, String extraInformation, double buyValue, double sellValue) {
        this.image = image;
        this.currency = currency;
        this.extraInformation = extraInformation;
        this.sellValue = sellValue;
        this.buyValue = buyValue;
    }

    public Integer getImage() {
        return image;
    }

    public String getCurrency() {
        return currency;
    }

    public String getExtraInformation() {
        return extraInformation;
    }

    public double getSellValue() {
        return sellValue;
    }

    public double getBuyValue() {
        return buyValue;
    }
}
