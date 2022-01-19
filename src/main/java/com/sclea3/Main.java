package com.sclea3;

public class Main {
    public static void main(String[] args) {

        Car myCar = new Car("Volga", 1.0);

        myCar.automaticTransmission = true;
        myCar.setColor("green");

        Wheels round = new Wheels("round");

        myCar.wheels(round);
        myCar.showCar();
    }
}
