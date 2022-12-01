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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Engine engine = (Engine) o;

        if (power != engine.power) return false;
        return type != null ? type.equals(engine.type) : engine.type == null;
    }

    @Override
    public int hashCode() {
        int result = power;
        result = 31 * result + (type != null ? type.hashCode() : 0);
        return result;
    }
}
