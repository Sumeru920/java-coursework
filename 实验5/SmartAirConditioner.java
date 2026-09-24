package t1;

public class SmartAirConditioner extends SmartHome {
    private double temperature;
    private String mode;

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }
    public String toString(){
        return ("SmartAirConditioner类：设备名为" + this.deviceName + "，状态为" + (this.state?"开":"关")
                + "，模式为" + this.mode + "，当前室温为" + this.temperature);
    }
    public void displayStatus(){
        System.out.println("设备" + this.deviceName + "：当前模式为" + this.mode + "，室内温度为" + this.temperature + "℃。请注意体感是否舒适");
    }
}
