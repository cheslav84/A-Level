package com.havryliuk.model;

public class Engine {

    private int power;
    private String type;

    public Engine() {
    }

    public Engine(int power, String type) {
        checkPower(power);
        this.power = power;
        this.type = type;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        checkPower(power);
        this.power = power;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    private void checkPower (int power) {
        if (power < 0 || power > 1001) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public String toString() {
        return "Engine: " + type +
                ", " + power + " hp";
    }
}
