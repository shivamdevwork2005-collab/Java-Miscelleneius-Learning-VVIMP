package Example2;

public abstract class Vehicle {

    void start(){
        System.out.println("Vehicle starting");
    }

    void stop(){
        System.out.println("Vehicle stopping");
    }

    abstract void shiftGear();

}
