package InterfaceLearnign_03;

public class Dclr extends ElectronicDevices implements Camera {

    int pixels;

    Dclr(int pixels){
        this.pixels =pixels;
    }

    @Override
    public void clickPhoto(int pixels) {
        System.out.println("We are clicking photo by dclr with a pixel of "+pixels);
    }
}
