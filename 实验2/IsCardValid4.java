import java.util.Scanner;
public class IsCardValid4 {
    public static void main(String []args){
        long card;
        Scanner input = new Scanner(System.in);
        card = input.nextLong();//读入
        if(isValid(card)){
            System.out.println("合法");
        }else{
            System.out.println("不合法");
        }
    }
    public static boolean isValid(long number){//判断
         return (sumOfDoubleEvenPlace(number) + sumOfOddPlace(number)) % 10 == 0 && prefixMatched(number, getSize(number))
                && getSize(number)>= 13 && getSize(number) <= 16;
    }
    public static int sumOfDoubleEvenPlace(long number){//奇数位
        int sum = 0;
        int len = getSize(number);
        number /= 10;
        while(number > 0){
            int d = (int)(number % 10) * 2;
            d = getDigit(d);
            sum += d;
            number /= 100;
        }
        return sum;
    }
    public static int sumOfOddPlace(long number){
        int sum = 0;
        int len = getSize(number);
        while(number > 0){
            int d = (int)(number % 10);
            sum += d;
            number /= 100;
        }
        return sum;
    }
    public static int getDigit(int number){//奇数位处理
        return number % 10 + number / 10;
    }
    public static boolean prefixMatched(long number, int k){//前缀判断
        int p = getPrefix(number, k);
        return p >= 40 && p <= 69 || p ==37;
    }
    public static int getSize(long d){//求长度
        int i = 0;
        while(d > 0){
            d /= 10;
            i++;
        }
        return i;
    }
    public static int getPrefix(long number, int k){//求前缀
        for(int i = 0; i < k - 2; i++){
            number /= 10;
        }
        return (int)number;
    }
}

