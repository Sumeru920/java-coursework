import java.util.Scanner;
public class Snack {
    private String name;
    private double price;
    private int number;
    public Snack(String name,double price,int number){
        this.name = name;
        this.price = price;
        this.number = number;
    }
    public double getTotalPrice(){//单种总价
        return this.price * this.number;
    }
    public String getName(){
        return this.name;
    }
    public void showInfo(){//展示信息
        System.out.println("name:"+this.name);
        System.out.println("price:"+this.price);
        System.out.println("number:"+this.number);
    }
    public static void main(String []args){
        System.out.println("Enter the type of snack:");
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        input.nextLine();
        Snack[] s = new Snack[n];//为对象数组开辟空间
        double sum = 0;
        double[] sumlist = new double[n];//各类价格数组
        for(int i = 0; i < n; i++){
            System.out.println("name:");
            String str = input.nextLine();
            System.out.println("price:");
            double p = input.nextDouble();
            System.out.println("number:");
            int num = input.nextInt();
            input.nextLine();
            s[i] = new Snack(str,p,num);//实例化
            sumlist[i] = p*num;
            sum += sumlist[i];
        }
        double max = sumlist[0];
        String s1 = s[0].getName();
        for(int i = 0; i < n; i++){//遍历求最大值
            if(sumlist[i] > max){
                s1 = s[i].getName();//获取对应零食名
                max = sumlist[i];
            }
        }
        System.out.println("The totoal price of the snack:" + sum);
        System.out.println("The one with the highest total price:" + s1);
    }
}
