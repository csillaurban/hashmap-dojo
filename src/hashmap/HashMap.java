package hashmap;

public class HashMap implements HashMapInterface{
    private int buckets = 16;

    @Override
    public void add(String key, int value) {

    }

    @Override
    public int getValue(String key) {
        return 0;
    }

    @Override
    public void remove(String key) {

    }

    @Override
    public void clearAll() {

    }

    private Integer getHash(String key) {
        Integer hash = key.hashCode();
        return hash % buckets;
    }

    private void resizeIfNeeded() {

    }
}
