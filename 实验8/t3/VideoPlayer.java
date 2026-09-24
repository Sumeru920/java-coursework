package t3;

public class VideoPlayer implements Playable{
    public String videoName;
    public int duration;
    public VideoPlayer(){}
    public VideoPlayer(String name,int duration){
        this.videoName = name;
        this.duration = duration;
    }

    public void play(){
        System.out.println("正在播放视频：<" + this.videoName + ">，时长 " + duration + " 分钟");
    }
}
