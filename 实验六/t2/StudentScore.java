package t2;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.ArrayList;

public class StudentScore {
    String course;
    private double score;
    public StudentScore(){};
    public StudentScore(String course,double score) throws ScoreOutOfRangeException{
        if(score < 0||score > 100){
            throw new ScoreOutOfRangeException();
        }
        this.course = course;
        this.score = score;
    }

    public double getScore() {
        return score;
    }

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        String isContinue = "Yes";
        int num = 0;
        ArrayList<StudentScore> list = new ArrayList<>();

        do{
            System.out.println("Enter the course name:");
            String name = input.nextLine();
            System.out.println("Enter the score:");

            for(int i = 0; i < 3; i++){
                try{
                    double score = input.nextDouble();
                    StudentScore s = new StudentScore(name,score);
                    list.add(s);
                    break;
                }catch(ScoreOutOfRangeException e){
                    System.out.println("Score of out range!Input again: ");
                }catch (NumberFormatException e){
                    System.out.println("Number format mismatch!Input again: ");
                }
            }

            System.out.println("Do you want to continue?(Yes/No)");
            input.nextLine();
            isContinue = input.nextLine();
            num++;
        }while(isContinue.equalsIgnoreCase("Yes"));
        System.out.println("-------------------------------");
        double n = 0;
        for(int i = 0; i < list.size(); i++){
            n += list.get(i).score;
        }
        n /= list.size();
        System.out.println("Course number : " + list.size());
        System.out.println("Average score : " + n);
    }

}
