package org.example.crawler;
import org.example.model.Teacher;
import org.example.exporter.ExcelExporter;

import java.util.List;

public class FacultyCrawler {
    private static final String LIST_URL = "https://faculty.csu.edu.cn/xyjslist.jsp?url" +
            "type=tsites.CollegeTeacherList&wbtreeid=1001&st=0&id=1022&lang=zh_CN";
    public static void main(String []args){
        System.out.println("开始爬取中南大学计算机学院教师信息……");
        ListPageParser listParser = new ListPageParser();
        DetailPageParser detailParser = new DetailPageParser();
        ExcelExporter exporter = new ExcelExporter();

        try{
            List<Teacher> teachers = listParser.parse(LIST_URL);
            System.out.println("从列表页获取到 " + teachers.size() + " 位教师");

            for(int i = 0; i < teachers.size(); i++){
                Teacher teacher = teachers.get(i);
                System.out.println("正在处理第 " + (i + 1) + "/" + teachers.size() + " 位：" + teacher.getName());
                detailParser.parse(teacher);
                Thread.sleep(1000);
            }
            exporter.export(teachers,"中南大学计算机学院教师信息.xlsx");
            System.out.println("爬取完成！");
        }catch (Exception e){
            System.out.println("爬取过程中发生错误：" + e.getMessage());
            e.printStackTrace();
        }
    }
}
