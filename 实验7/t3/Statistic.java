package t3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Statistic {
    public static void main(String []args){
        File file = new File(args[0]);

        if(!file.exists()){
            System.out.println("The file \"" + args[0] + "\" does not exist");
            return;
        }

        Calculate(file);
    }
    public static void Calculate(File file){
        int totalChars = 0;
        int totalWords = 0;
        int totalLines = 0;
        int longestLinelen = 0;
        int [] fre = new int[5];
        try{
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;
            while((line = br.readLine())!=null){

                if(line.length() > longestLinelen){
                    longestLinelen = line.length();
                }
                totalLines++;

                totalChars += line.length();

                if(!line.trim().isEmpty()){
                    String[] words = line.trim().split("\\s+");
                    totalWords += words.length;
                }


                line = line.toLowerCase();
                for(int i = 0; i < line.length(); i++){
                    switch (line.charAt(i)){
                        case 'a':fre[0]++;break;
                        case 'e':fre[1]++;break;
                        case 'i':fre[2]++;break;
                        case 'o':fre[3]++;break;
                        case 'u':fre[4]++;break;
                    }
                }

            }

            System.out.println("字符总数：" + totalChars);
            System.out.println("单词总数：" + totalWords);
            System.out.println("行数：" + totalLines);
            System.out.println("最长行的长度：" + longestLinelen);
            System.out.println("a: " + fre[0] + " e: " + fre[1] + " i: " + fre[2] + " o: " + fre[3] + " u: " + fre[4]);
        }catch (IOException e){
            System.out.println("Fail to read");
        }
    }
}
