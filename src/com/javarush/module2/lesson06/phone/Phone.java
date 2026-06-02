package com.javarush.module2.lesson06.phone;

public class Phone {
    private final String vendor;
    private final String model;
    private final String ram;
    private final String color;
    private final double discountPrice;
    private final double fullPrice;

    public Phone(String vendor, String model, String ram, String color, double discountPrice, double fullPrice) {
        this.vendor = vendor;
        this.model = model;
        this.ram = ram;
        this.color = color;
        this.discountPrice = discountPrice;
        this.fullPrice = fullPrice;
    }

    public String getVendor() {
        return vendor;
    }

    public String getModel() {
        return model;
    }

    public String getRam() {
        return ram;
    }

    public String getColor() {
        return color;
    }

    public double getDiscountPrice() {
        return discountPrice;
    }

    public double getFullPrice() {
        return fullPrice;
    }

    @Override
    public String toString() {
        return "Phone{" +
               "vendor='" + vendor + '\'' +
               ", model='" + model + '\'' +
               ", ram='" + ram + '\'' +
               ", color='" + color + '\'' +
               ", discountPrice=" + discountPrice +
               ", fullPrice=" + fullPrice +
               '}';
    }
}
