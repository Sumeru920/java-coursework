public class SmartDevice {
    public String deviceId;
    public String deviceName;
    public boolean isOn = false;
    public SmartDevice(){}
    public SmartDevice(String deviceId,String deviceName){
        this.deviceId = deviceId;
        this.deviceName = deviceName;
    }
    public void turnOn (){
        this.isOn = true;
    }
    public void turnOff(){
        this.isOn = false;
    }
    public void getStatus(){
        System.out.println("isOn:" + this.isOn);
    }
    public static void main(){
        SmartLight l1 = new SmartLight();
        l1.turnOn();
        l1.getStatus();
        l1.setBrightness(80);
        l1.changeColor("warm white");
        l1.getStatus();
        SmartLight l2 = new SmartLight("light_001","客厅主灯",70,"yellow");
        l2.turnOn();
        l2.getStatus();
        l2.changeColor("blue");
        l2.getStatus();
        SmartDevice d1 = new SmartLight();
        d1.getStatus();
    }
}
