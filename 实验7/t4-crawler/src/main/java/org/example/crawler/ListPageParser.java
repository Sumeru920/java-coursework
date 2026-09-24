package org.example.crawler;

import org.example.model.Teacher;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ListPageParser {
    private static final String USER_AGENT = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36";
    public List<Teacher> parse(String listUrl) throws IOException{
        List<Teacher> teachers = new ArrayList<>();
        Document doc = Jsoup.connect(listUrl)
                .userAgent(USER_AGENT)
                .timeout(10000)
                .get();

        Elements links = doc.select(".teacher_list a, .college_teacher_list a, a[href*='/zh_CN/']");
        for(Element link: links){
            String name = link.text().trim();
            String href = link.attr("href");

            if(isValidTeaherLink(name,href)){
                Teacher teacher = new Teacher();
                teacher.setName(name);
                teacher.setProfileUrl(buildAbsoluteUrl(href));
                teachers.add(teacher);
            }
        }
        return teachers;
    }
    private boolean isValidTeaherLink(String name, String href){
        return name != null&&!name.isEmpty()&&href != null && href.contains("/zh_CN")
                && !href.equals("#") && name.length()>=2&& !name.equals("更多");
    }

    private String buildAbsoluteUrl(String href){
        if(href.startsWith("http")){
            return href;
        }
        return "https://faculty.csu.edu.cn" + (href.startsWith("/") ? "" : "/") + href;
    }
}
