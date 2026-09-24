package t2;

import java.util.ArrayList;
public class CoursePlan implements Cloneable{
    private String courseName;
    private String Teacher;
    private int weekHour;
    private ArrayList<String> tasks;

    public CoursePlan(){
        this.tasks = new ArrayList<>();
    };
    public CoursePlan(String name,String teacher,int hour,ArrayList<String> a){
        this.courseName = name;
        this.Teacher = teacher;
        this.weekHour = hour;
        this.tasks = new ArrayList<>(a);
    }
    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getTeacher() {
        return Teacher;
    }

    public void setTeacher(String teacher) {
        Teacher = teacher;
    }

    public int getWeekHour() {
        return weekHour;
    }

    public void setWeekHour(int weekHour) {
        this.weekHour = weekHour;
    }

    public ArrayList<String> getTasks() {
        return tasks;
    }

    public void setTasks(ArrayList<String> tasks) {
        this.tasks = tasks;
    }

    public void addTask(String task){
        this.tasks.add(task);
    }

    public void removeTask(String task){
        tasks.remove(task);
    }
    public CoursePlan clone() throws CloneNotSupportedException{
        CoursePlan cloned = (CoursePlan)super.clone();//浅克隆
        cloned.tasks = new ArrayList<>(this.tasks);
        //新建独立的task
        return cloned;
    }

    public void showCourse(){

        System.out.println("课程名称：" + this.getCourseName());
        System.out.println("任课教师：" + this.getTeacher());
        System.out.println("周学时：" + this.getWeekHour());
        System.out.println("任务：" + this.getTasks());
    }
}
