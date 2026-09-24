import java.util.Scanner;
public class DeskLamp {
    private String brand;
    private boolean isOn;
    public DeskLamp(){
    }
    public DeskLamp(String brand, boolean isOn){
        this.brand = brand;
        this.isOn = isOn;
    }
    public void turnOn(){
        this.isOn = true;
    }
    public void turnOff(){
        this.isOn = false;
    }
    public void showInfo(){
        String s = this.isOn ? "On" : "Off";//化boolean为开关
        System.out.println("Current state:" + s);
    }
    public void menuBar(){
        int i;
        System.out.print("""
                Enter 1 to turn on the lamp
                2 to turn off the lamp
                3 to show the current state of the lamp
                4 to exit""");
        Scanner input = new Scanner(System.in);
        i = input.nextInt();
        do{
            switch(i){
                case 1:this.turnOn();break;
                case 2:this.turnOff();break;
                case 3:this.showInfo();break;
                case 4: return;
                default:
                    System.out.print("Input again!\n");
                    break;
            }
            i = input.nextInt();
        }while(true);
        //菜单
    }
    public static void main(String []args){

        Scanner input = new Scanner(System.in);
        System.out.print("Input the brand of the lamp:");
        String brand = input.nextLine();//品牌
        DeskLamp d = new DeskLamp(brand,false);//创建对象
        d.menuBar();
    }
}


