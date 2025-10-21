public class PlayList {
    String name;
    int duration;
    PlayList next; 


    public PlayList(String name, int duration) {
        this.name = name;
        this.duration = duration;
        this.next = null;
    }

}

