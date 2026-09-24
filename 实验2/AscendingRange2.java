import java.util.Scanner;
public class AscendingRange2 {
    public static void main(){
        int [] arr = getnumber();
        findLongest(arr);
    }
    static int[] getnumber(){
        int n;
        Scanner input = new Scanner(System.in);
        System.out.print("请输入数组长度：");
        n = input.nextInt();
        int [] arr = new int[n + 1];
        System.out.print("请输入" + n + "个整数：");
        for(int i = 0; i < n; i++){
            arr[i] = input.nextInt();
        }
        return arr;
    }
    static void findLongest(int [] arr){
        int start = 0;
        int end = 0;
        int length = 1;
        int l = 1;
        int s = 0;
        int e ;
        boolean flag = false;
        for(int i = 0; i < arr.length - 1 ; i++){
            if(arr[i] < arr[i + 1] && !flag){
                flag = true;
                s = i;
                l++;
            }else if(arr[i] < arr[i + 1] && flag){
                l++;
            }else{
                flag = false;
                e = i;
                if(length < l){
                    length = l;
                    start = s;
                    end = e;
                }
                l = 1;
            }
        }
        System.out.println("最长连续充能阶段起点下标：" + start +
                "\n最长连续充能阶段终点下标：" + end +
                "\n阶段长度：" + length);
        showRange(start,end,arr);
    }
    static void showRange(int i, int j, int [] arr){
        System.out.print("该阶段能量值为：");
        for(int k = i; i <= j; i++){
            System.out.print(arr[i] + " ");
        }
    }
}
