package t3;

public class MusicPlayer implements Playable{
    public String musicName;

    public MusicPlayer(){}
    public MusicPlayer(String name){
        this.musicName = name;
    }
    public void play(){
        System.out.println("正在播放音乐：" + musicName);
    }
}
