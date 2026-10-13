package Example2;

public class ElectricCar extends Car{       // concrete class

    @Override
    void openBoot() {
        System.out.println("Open Boot");
    }

    @Override
    void shiftGear() {
        System.out.println("Shifting Gear from electric car");
    }
}
