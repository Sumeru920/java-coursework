package t1;
import java.util.Scanner;

public class numberformatexception {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the lottery number: ");
        String lottery = input.nextLine();

        try {
            int lotteryNumber = Integer.parseInt(lottery);//转换
            System.out.println("The lottery number you input is: " + lotteryNumber);
            if (lotteryNumber % 7 == 0) {
                System.out.println("It is a lucky number.");
            } else {
                System.out.println("It is not a lucky number.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input!");
            System.out.println(lottery + " has number format exception.");
        }
    }
}
