package com.example.module1mp;

import android.graphics.Color;

public class Element {
    private int number;
    private int color= Color.argb(155,200,200,200);

    public Element(int number) {
        this.number = number;
    }
    public int getNumber() {
        return number;
    }

    public int getColor() {
        return color;
    }
}
