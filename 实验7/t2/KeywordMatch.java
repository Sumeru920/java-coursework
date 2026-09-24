package t2;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class KeywordMatch {
    public static void main(String []args){
        File newFile = new File(args[0]);
        String keyword = args[1].toLowerCase();

        if(!newFile.exists()){
            System.out.println("The file \"" + args[0]
                    + "\" does not exist");
            return;
        }
        searchAnalyze(newFile,keyword);
    }
    private static void searchAnalyze(File file, String keyword){
        int totalLines = 0;
        int totalWords = 0;
        int totalChars = 0;
        int keywordLines = 0;
        ArrayList<String> matchLines = new ArrayList<>();

        try{
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;
            while((line = br.readLine())!=null){
                totalLines++;

                totalChars += line.length();

                String []words = line.split("\\s+");
                totalWords += (line.trim().isEmpty()) ? 0:words.length;

                if(line.toLowerCase().contains(keyword)){
                    keywordLines++;
                    matchLines.add(totalLines + ":" + line);
                }
            }

            for(String matchLine:matchLines){
                System.out.println(matchLine);
            }

            System.out.println("-----统计结果-----");
            System.out.println("总行数: " + totalLines);
            System.out.println("总单词数: " + totalWords);
            System.out.println("总字符数(不含换行): " + totalChars);
            System.out.println("包含关键词的行数: " + keywordLines);

        }catch(IOException e){
            System.out.println("Fail to read");
        }


    }
}
