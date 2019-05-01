package entry;

public class Entry {
    private String key;
    private int value;
    private Entry next;

    public Entry(String key, int value, Entry next) {
        this.key = key;
        this.value = value;
        this.next = next;
    }
}
