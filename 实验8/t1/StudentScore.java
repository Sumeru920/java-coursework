package t1;

public class StudentScore implements Comparable<StudentScore> {
    private String studentID;
    private String name;
    private double dailyScore;
    private double projectScore;
    private double finalScore;
    public StudentScore(){};
    public StudentScore(String studentID,String name,double daily,double project){
        this.studentID = studentID;
        this.name = name;
        this.dailyScore = daily;
        this.projectScore = project;
        this.finalScore = this.dailyScore*0.4 + this.projectScore*0.6;
    }

    public int compareTo(StudentScore other){
        if(this.finalScore != other.finalScore){
            return Double.compare(other.finalScore,this.finalScore);//降序
        }
        if(this.projectScore != other.projectScore){
            return Double.compare(other.projectScore,this.projectScore);
        }
        return this.studentID.compareTo(other.studentID);//学号升序
    }

    public void showScore(){
        System.out.println("学号：" + this.studentID + " 姓名：" + this.name + " 平时成绩：" + this.dailyScore
                + " 项目成绩：" + this.projectScore + " 总评成绩：" + this.finalScore);
    }
}
