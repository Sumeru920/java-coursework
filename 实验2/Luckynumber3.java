import java.util.Scanner;
public class Luckynumber3 {
    public static void main(){
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        if(isLucky(n)){
            System.out.println(n + "是幸运数字");
        }else{
            System.out.println(n + "不是幸运数字");
        }
    }
    static boolean isLucky(int n){//是否是幸运数
        int former = n;
        int [] seen = new int[1000];
        while(n != 1){
            if(seen[n] == 1) {
                return false;
            }else{
                seen[n] = 1;
            }
            int [] arr = transfer(n);
            n = calculate(arr);
        }
        return true;
    }
    static int[] transfer(int n){//取每位数
        int [] arr = new int[20];
        int i = 0;
        while(n != 0){
            arr[i] = n%10;
            n /= 10;
            i++;
        }
        return arr;
    }
    static int calculate(int [] arr){//计算
        int sum = 0;
        for(int i = 0; i < arr.length; i++){
            sum += arr[i] * arr[i];
        }
        return sum;
    }
}
