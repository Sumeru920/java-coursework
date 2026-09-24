package t1;

public class SmartCurtain extends SmartHome {
    public String toString(){
        return ("SmartCurtain类：设备名为" + this.deviceName + "，状态为" + (this.state?"开。":"关。"));
    }
    public void displayStatus(){
        System.out.println("设备" + this.deviceName + "：窗帘已" + (this.state?"打开。":"关闭。"));
    }
}
