package t1;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class test {
    public static void main(String []args){
        ArrayList<StudentScore> scores = new ArrayList<>();
        scores.add(new StudentScore("123","李华",89.1,90.5));
        scores.add(new StudentScore("124","李文",90,83.4));
        scores.add(new StudentScore("125","李明",82.6,95));
        scores.add(new StudentScore("126","李月",81,97.5));
        scores.add(new StudentScore("127","张三",81,97.5));
        scores.add(new StudentScore("128","王五",82,97.5));

        System.out.println("---排序前---");
        for(StudentScore score:scores){
            score.showScore();
        }

        Collections.sort(scores);

        System.out.println("---排序后---");
        for(StudentScore score:scores){
            score.showScore();
        }

    }
}
