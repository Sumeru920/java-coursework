package t1;
import java.util.Scanner;

public class ProcessString {
    public static void main(String []args){
        System.out.println("请输入昵称：");
        Scanner input = new Scanner(System.in);
        String nickName = input.nextLine().trim().replace(' ','_');

        System.out.println("整理后的昵称:" + nickName);
        System.out.println("大写形式:" + nickName.toUpperCase());
        System.out.println("小写形式:" + nickName.toLowerCase());
        System.out.println("长度:" + nickName.length());

        //调用stream API求字母数字个数
        long letterCount = nickName.chars()
                .filter(Character::isLetter)
                .count();

        long digitCount = nickName.chars()
                .filter(Character::isDigit)
                .count();
        System.out.println("字母个数:" + letterCount);
        System.out.println("数字个数:" + digitCount);
        System.out.println((isValid(nickName,letterCount,digitCount))?"昵称合法":"昵称不合法");
    }
    public static boolean isValid(String name,long letter,long digit){
        int underline = name.length() - name.replace("_","").length();
        return (name.length() >= 4 && name.length() <= 12
                && (Character.isLetter(name.charAt(0)))
                && letter + digit + underline == name.length());

    }
}
