abstract class Vehicle {
    private String color;
    public Vehicle(String color) {
        this.color = color;
    }
    public void startEngine() {
        System.out.println("Engine started.");
    }
    public abstract void drive();
    public String getColor() {
        return color;
    }
}
class Car extends Vehicle {
    public Car(String color) {
        super(color);
    }
    @Override
    public void drive() {
        System.out.println("The " + getColor() + " car is driving.");
    }
}
interface Drivable {
    void accelerate();
    void brake();
}
class Bike implements Drivable {
    @Override
    public void accelerate() {
        System.out.println("Bike is pedaling faster.");
    }
    @Override
    public void brake() {
        System.out.println("Bike is slowing down with hand brakes.");
    }
}
class Truck implements Drivable {
    @Override
    public void accelerate() {
        System.out.println("Truck is using heavy acceleration.");
    }
    @Override
    public void brake() {
        System.out.println("Truck is using air brakes.");
    }
}
public class Main {
    public static void main(String[] args) {
        Car myCar = new Car("Red");
        myCar.startEngine();
        myCar.drive();
        Bike myBike = new Bike();
        Truck myTruck = new Truck();
        myBike.accelerate();
    }
}