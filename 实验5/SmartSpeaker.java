package t1;

public class SmartSpeaker extends SmartHome {
    private String currentTrack;
    private String nextTrack;

    public String getCurrentTrack() {
        return currentTrack;
    }

    public void setCurrentTrack(String currentTrack) {
        this.currentTrack = currentTrack;
    }

    public String getNextTrack() {
        return nextTrack;
    }

    public void setNextTrack(String nextTrack) {
        this.nextTrack = nextTrack;
    }
    public String toString(){
        return("SmartSpeaker类：设备名为" + this.deviceName + "，状态为" + (this.state?"开":"关")
                + "，当前播放曲目为" + this.currentTrack + "，下一首曲目为" + this.nextTrack);
    }

    public void displayStatus(){
        System.out.println("设备" + this.deviceName + "：当前播放《" + this.currentTrack + "》，请享受音乐");
    }
}
