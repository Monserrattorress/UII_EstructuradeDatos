
public class Node{
    PlayList head;

    public void Song(String name, int duration) {
        PlayList newMusic = new PlayList(name, duration);
        if (head == null) {
            head = newMusic;
        } else {
            PlayList temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newMusic;
        }
    }

    public void remove(String name) {
        if (head == null) return;

        if (head.name.equals(name)) {
            head = head.next;
            return;
        }

        PlayList temp = head;
        while (temp.next != null && !temp.next.name.equals(name)) {
            temp = temp.next;
        }

        if (temp.next != null) {
            temp.next = temp.next.next;
        }
    }

    public void list() {
        System.out.println("Lista:");
        PlayList temp = head;
        int i = 1;
        while (temp != null) {
            System.out.println(i + ". " + temp.name + " (" + temp.duration + " s)");
            temp = temp.next;
            i++;
        }
        System.out.println("Duración total: " + getDurationTotal() + " s");
    }

    public int getDurationTotal() {
        int total = 0;
        PlayList temp = head;
        while (temp != null) {
            total += temp.duration;
            temp = temp.next;
        }
        return total;
    }   
}

