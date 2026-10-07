package com.example.flowerapp;

public class FlowerModel {
    private String emoji;
    private String name;
    private String description;
    private String fact1;
    private String fact2;
    private String fact3;
    private int themeColor;
    private String colorName;
    private String colorHex;

    public FlowerModel(String emoji, String name, String description,
                       String fact1, String fact2, String fact3,
                       int themeColor, String colorName, String colorHex) {
        this.emoji = emoji;
        this.name = name;
        this.description = description;
        this.fact1 = fact1;
        this.fact2 = fact2;
        this.fact3 = fact3;
        this.themeColor = themeColor;
        this.colorName = colorName;
        this.colorHex = colorHex;
    }

    public String getEmoji() { return emoji; }
    public String getName() { return name; }
    public String getDescription() { return description; }
    public String getFact1() { return fact1; }
    public String getFact2() { return fact2; }
    public String getFact3() { return fact3; }
    public int getThemeColor() { return themeColor; }
    public String getColorName() { return colorName; }
    public String getColorHex() { return colorHex; }
}
