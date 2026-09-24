package t1;

public class SmartHome {
    String deviceName;
    boolean state;

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public String toString(){
        return ("SmartHome类：设备名为" + this.deviceName + "，状态为" + (isState()?"开":"关"));
    }

    public static void m1(SmartHome device){
        System.out.println(device.getDeviceName());
    }
    public static void m2(SmartHome device){
        System.out.println(device.toString());
    }
    public static void m3(SmartHome device){
        if(device instanceof SmartCurtain){
            ((SmartCurtain) device).displayStatus();
        }else if(device instanceof SmartAirConditioner){
            ((SmartAirConditioner) device).displayStatus();
        }else if(device instanceof SmartSpeaker){
            ((SmartSpeaker) device).displayStatus();
        }
    }
    public static void main(String []args){
        SmartHome s1 = new SmartHome();
        System.out.println("将SmartHome依次传入m1m2m3:");
        m1(s1);
        m2(s1);
        m3(s1);
        SmartHome s2 = new SmartCurtain();
        System.out.println("将SmartCurtain依次传入m1m2m3:");
        m1(s2);
        m2(s2);
        m3(s2);
        SmartHome s3 = new SmartAirConditioner();
        System.out.println("将SmartAirConditioner依次传入m1m2m3:");
        m1(s3);
        m2(s3);
        m3(s3);
        SmartHome s4 = new SmartSpeaker();
        System.out.println("将SmartSpeaker依次传入m1m2m3:");
        m1(s4);
        m2(s4);
        m3(s4);
    }
}
