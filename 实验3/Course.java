import java.util.Scanner;
public class Course {
    private String courseName;
    private Teacher teacher;
    public Course(){}//无参构造方法
    public Course(String courseName,Teacher teacher){
        this.courseName = courseName;
        this.teacher = teacher;
    }
    public void setTeacher(Teacher teacher){
        this.teacher = teacher;//更换教师
    }

    public Teacher getTeacher(){
        return this.teacher;//获取教师
    }
    public void showInfo(){//获取课程信息
        String name = this.teacher.getName();
        String title = this.teacher.getTitle();
        System.out.println("Course:" + this.courseName);
        System.out.println("Teacher:" + name + "\nTitle:"+ title);
    }
    public void menu(){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter 1 to check information\n2 to set teacher\n3 to check current teacher\n4 to exit");
        int n = input.nextInt();
        input.nextLine();
            switch(n){
                case 1:this.showInfo();break;
                case 2:
                    System.out.println("Set new teacher for the course.\nEnter name and title:");
                    String s2 = input.nextLine();
                    String title2 = input.nextLine();
                    Teacher t2 = new Teacher(s2,title2);
                    this.setTeacher(t2);
                    break;
                case 3:
                    String name = this.teacher.getName();
                    String title = this.teacher.getTitle();
                    System.out.println("Current teacher:" + name +"\nTitle:" + title);
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Invalid input.Enter again.");
            }
    }
    public static void main(String []args){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the course name,teacher name and title:");
        String course = input.nextLine();
        String teachername = input.nextLine();
        String title = input.nextLine();
        Teacher t = new Teacher(teachername,title);
        Course c = new Course(course,t);
        c.menu();
    }
}
