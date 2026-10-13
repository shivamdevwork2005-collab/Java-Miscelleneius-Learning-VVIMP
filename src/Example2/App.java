package Example2;

public class App {

    public static void main(String[] args) {
        ElectricCar car = new ElectricCar();
        car.start();
        car.openBoot();
        car.shiftGear();
        car.stop();

        System.out.println('\n');

        Car c1  = new ElectricCar(); // parent class can access its property and its parent prop also.
        c1.openBoot();
        c1.start();
        c1.stop();
        c1.shiftGear();

        System.out.println("\n");

        Vehicle v1 = new ElectricCar();  // parent class can access only its property not child ones
        v1.start();
        v1.start();
        v1.shiftGear();

        System.out.println("\n");



    }


}
