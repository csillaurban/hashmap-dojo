import hashmap.HashMap;

public class Main {
    public static void main(String[] args) {
        HashMap map = new HashMap();

        map.add("Entry1", 1);
        map.add("Entry2", 2);
        map.add("Entry2", 2);
        map.add("Entry3", 3);
        map.add("Entry4", 4);
        map.add("Entry5", 5);
        map.add("Entry6", 6);
        map.add("Entry7", 7);
        map.add("Entry8", 8);
        map.printEntries();
        map.getValue("Entry3");
        map.remove("Entry1");
        map.printEntries();
    }
}
