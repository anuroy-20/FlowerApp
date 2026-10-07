package com.example.flowerapp;

public class ColorTheme {
    private String name;
    private int primaryColor;
    private int lightColor;
    private String hexCode;

    public ColorTheme(String name, int primaryColor, int lightColor, String hexCode) {
        this.name = name;
        this.primaryColor = primaryColor;
        this.lightColor = lightColor;
        this.hexCode = hexCode;
    }

    public String getName() { return name; }
    public int getPrimaryColor() { return primaryColor; }
    public int getLightColor() { return lightColor; }
    public String getHexCode() { return hexCode; }
}
