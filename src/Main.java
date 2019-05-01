import hashmap.HashMap;

public class Main {
    public static void main(String[] args) {
        HashMap map = new HashMap();

        map.add("Entry1", 1);
        map.add("Entry2", 2);
        map.add("Entry3", 3);
        map.printEntries();
    }
}
