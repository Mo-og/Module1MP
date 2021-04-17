package com.example.module1mp;

import android.graphics.Color;

public class Element {
    private String text;
    private final int color = Color.argb(155, 200, 200, 200);

    public Element(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getColor() {
        return color;
    }
}
