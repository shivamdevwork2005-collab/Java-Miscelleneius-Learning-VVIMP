package InterfaceLearnign_03;

public class ButoothSpeaker extends ElectronicDevices implements MusicPlayer {

    @Override
    public void playMusic(String type) {
        System.out.println(type+" is playing the music by Bluetooth speaker");
    }
}
