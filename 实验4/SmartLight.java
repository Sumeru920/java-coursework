public class SmartLight extends SmartDevice{
    public int brightness = 50;
    String color = "white";
    public SmartLight(){};
    public SmartLight(String deviceId,String deviceName,int brightness,String color){
        this.deviceId = deviceId;
        this.deviceName = deviceName;
        this.brightness = brightness;
        this.color = color;
    }
    public void turnOn(){
        this.isOn = true;
        this.brightness = 50;
    }
    public void setBrightness(int level){
        this.brightness = level;
    }
    public void changeColor(String newColor){
        this.color = newColor;
    }
    public void getStatus(){
        System.out.println("ID:" + this.deviceId + "\nName:" + this.deviceName
                + "\nisOn:" + this.isOn + "\nbrightness:" + this.brightness + "\ncolor:" + this.color);
    }
}
