package com.study.designpattern.factory.factoryMethod;

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

interface Driver {
   public Car driveCar();
}

class BenzDriver implements Driver {
    @Override
    public Car driveCar() {
        return new Benz();
    }
}

class BmwDriver implements Driver {
    @Override
    public Car driveCar() {
        return new Bmw();
    }
}

public class FactoryMethod {
    public static void main(String[] args) {
        try {
            Driver driver = new BenzDriver();
            Car car = driver.driveCar();
            car.drive();
        } catch (Exception e) {

        }

    }

}
