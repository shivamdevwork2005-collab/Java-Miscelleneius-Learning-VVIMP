package InterfaceLearnign_03;

public class Mobile extends ElectronicDevices implements Camera,MusicPlayer{

    String model;

    Mobile(String model) {
        this.model = model;
    }

    @Override
    public void clickPhoto(int pixels) {
        System.out.println(model+" is clicking photo having pixels of "+pixels);
    }

    @Override
    public void playMusic(String type) {
        System.out.println(model +" is playing music having type "+type);
    }
}
