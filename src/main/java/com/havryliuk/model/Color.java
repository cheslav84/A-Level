package com.havryliuk.model;

public enum Color {
    RED,
    GREEN,
    BLUE;

    @Override
    public String toString() {
        return "Color: " + this.name();
    }
}
