package t2;

import java.util.ArrayList;
import java.util.Arrays;

public class test {
    public static void main(String []args)throws CloneNotSupportedException{
        ArrayList<String> a = new ArrayList<>(Arrays.asList("复习","实验","预习"));
        CoursePlan c = new CoursePlan("Java程序设计","李明",24,a);
        System.out.println("创建一个CoursePlan对象：");
        c.showCourse();
        System.out.println("\n克隆并修改副本任课教师为李华，\n" +
                "课程学时改为48，课程任务移除“实验”，\n" +
                "增加“网课”、“测试”\n");
        CoursePlan c_1 = c.clone();

        c_1.setTeacher("李华");
        c_1.setWeekHour(48);
        c_1.removeTask("实验");
        c_1.addTask("网课");
        c_1.addTask("测试");
        System.out.println("---副本---");
        c_1.showCourse();
        System.out.println("---原对象---");
        c.showCourse();

    }
}
