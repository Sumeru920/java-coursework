import java.util.Scanner;
public class SurplusAnalysis1 {
    public static void main(String []args){
        int [] n = getSurplus();
        findMax(n);
        Analysis(n);
        getSum(n);
    }
    static int[] getSurplus(){
        System.out.print("请输入12个月的结余数据：");
        Scanner input = new Scanner(System.in);
        int [] surplus = new int[12];
        for(int i = 0; i < 12; i++){
            surplus[i] = input.nextInt();
        }
        return surplus;
    }
    static void findMax(int [] n){
        int MAX = 1;
        int amount = n[0];
        for(int i = 0; i < 12; i++){
            if(n[i] > amount){
                MAX = i + 1;
                amount = n[i];
            }
        }
        System.out.println("结余最高的月份：第" +
                MAX + "个月，金额为" + n[MAX - 1]);
    }
    static void Analysis(int [] n){
        int positive = 0;
        int negative = 0;
        int even = 0;
        for(int i = 0; i < 12; i++){
            if(n[i] > 0){
                positive++;
            }else if(n[i] < 0){
                negative++;
            }else{
                even++;
            }
        }
        System.out.println("结余月份数：" + positive);
        System.out.println("超支月份数：" + negative);
        System.out.println("平衡月份数：" + even);
    }
    static void getSum(int [] n){
        int sum = 0;
        for(int i = 0; i < 12; i++){
            sum += n[i];
        }
        System.out.println("全年结余总和：" + sum);
    }
}
