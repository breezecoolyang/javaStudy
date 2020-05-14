package com.study.designpattern.factory.simpleFactory;

interface Car {
    void drive();
}

class Benz implements Car {
    @Override
    public void drive() {
        System.out.println("Driving Benz");
    }
}

class Bmw implements Car {
    @Override
    public void drive() {
        System.out.println("Driving Bmw");
    }
}

class Driver {
    public static Car driverCar(String str) throws Exception {
        if (str.equalsIgnoreCase("Benz")) {
            return new Benz();
        } else if (str.equalsIgnoreCase("Bmw")) {
            return new Bmw();
        } else {
            throw new Exception();
        }
    }
}

public class SimpleFactory {
    public static void main(String[] args) {
        try {
            Car car = Driver.driverCar("Benz");
            car.drive();
        } catch (Exception e) {

        }

    }

}
