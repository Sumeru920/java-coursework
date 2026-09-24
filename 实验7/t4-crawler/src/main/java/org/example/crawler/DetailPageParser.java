package org.example.crawler;
import org.apache.poi.ss.formula.functions.T;
import org.example.model.Teacher;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DetailPageParser {
    private static final String USER_AGENT = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36";
    public void parse(Teacher teacher){
        if(teacher.getProfileUrl() == null || teacher.getProfileUrl().isEmpty()){
            setDefaultValues(teacher);
            return;
        }
        try{
            Document doc = Jsoup.connect(teacher.getProfileUrl())
                    .userAgent(USER_AGENT)
                    .timeout(10000)
                    .get();
            teacher.setBio(extractBio(doc));
            teacher.setEmail(extractEmail(doc));
            teacher.setResearch(extractResearch(doc));

            cleanText(teacher);
        }catch(IOException e){
            System.err.println("获取详细失败：" + teacher.getProfileUrl() + " - " + e.getMessage());
            setErrorValues(teacher);
        }
    }

    private String extractBio(Document doc){
        Element bioElement = doc.selectFirst("div.intro, div.profile, div.teacher-intro, div.description, p.intro");
        return bioElement != null?bioElement.text().trim():"无";
    }

    private String extractEmail(Document doc){
        Element mailLink = doc.selectFirst("a[href^=mailto:]");
        if(mailLink != null){
            return mailLink.attr("href").replace("mailto:","").trim();
        }
        String text = doc.body().text();
        Pattern pattern = Pattern.compile("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\\\.[a-zA-Z]{2,}");
        Matcher matcher = pattern.matcher(text);
        return matcher.find()?matcher.group():"无";
    }
    private String extractResearch(Document doc){
        Elements researchLinks = doc.select("a[href*='/yjfx/']");
        if(!researchLinks.isEmpty()){
            List<String> researchItems = new ArrayList<>();
            for(Element link: researchLinks){
                String text = link.text().trim();
                if(!text.isEmpty()&&!researchItems.contains(text)){
                    researchItems.add(text);
                }
            }
            if(!researchItems.isEmpty()){
                return String.join(";", researchItems);
            }
        }
        return "无";
    }
    private void cleanText(Teacher teacher){
        if(!"无".equals((teacher.getBio()))&&!"获取失败".equals(teacher.getBio())){
            teacher.setBio(teacher.getBio().replaceAll("\\s+"," "));
        }
        if(!"无".equals((teacher.getResearch()))&&!"获取失败".equals(teacher.getResearch())){
            teacher.setResearch(teacher.getResearch().replaceAll("\\s+"," "));
        }
    }
    private void setDefaultValues(Teacher teacher){
        teacher.setBio("无");
        teacher.setEmail("无");
        teacher.setResearch("无");
    }
    private void setErrorValues(Teacher teacher){
        teacher.setBio("获取失败");
        teacher.setEmail("获取失败");
        teacher.setResearch("获取失败");
    }
}
