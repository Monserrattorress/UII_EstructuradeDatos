public class App {
    public static void main(String[] args) throws Exception {
        Node playlist = new Node();

        playlist.Song("Yesterdar", 150);
        playlist.Song("Imagine", 180);
        playlist.Song("imagination",200);
        playlist.list();

        playlist.remove("imagination");
        playlist.list();
    }
}
