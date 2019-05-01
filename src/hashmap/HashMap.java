package hashmap;

public class HashMap implements HashMapInterface{
    private int buckets = 16;
    private int elementsCounter = 0;

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

    private int getHash(String key) {
        return key.hashCode() % buckets;
    }

    private void resizeIfNeeded() {
        if(elementsCounter > buckets * 2) {
            buckets = buckets *2;
        } else if (elementsCounter < buckets / 2) {
            buckets = buckets / 2;
        }
    }
}
