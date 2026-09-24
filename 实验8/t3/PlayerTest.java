package t3;

public class PlayerTest {
    public static void main(String []args){
        Playable[] players = new Playable[4];

        players[0] = new MusicPlayer("《Faded》");
        players[1] = new MusicPlayer("《左手指月》");

        players[2] = new VideoPlayer("Avengers4",300);
        players[3] = new VideoPlayer("Inerstellar",169);

        Object[] objects = new Object[6];
        objects[0] = new MusicPlayer("《Faded》");
        objects[1] = new MusicPlayer("《左手指月》");

        objects[2] = new VideoPlayer("Avengers4",300);
        objects[3] = new VideoPlayer("Inerstellar",169);

        objects[4] = "It is a string";
        objects[5] = 2.25;

        System.out.println("---遍历数组1---");
        for(Playable playable:players){
            if(playable instanceof Playable)playable.play();
        }
        System.out.println("---遍历数组2---");
        for(Object object:objects){
            if(object instanceof Playable){
                Playable player = (Playable)object;
                player.play();
            }else{
                System.out.println(object + " 不可播放");
            }
        }
    }
}
