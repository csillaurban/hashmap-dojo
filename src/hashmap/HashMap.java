package hashmap;

import entry.Entry;
import exception.ExistingKeyException;

import java.util.LinkedList;
import java.util.ListIterator;

public class HashMap implements HashMapInterface{
    private int buckets = 16;
    private int elementsCounter = 0;
    private LinkedList<Entry>[] elements = new LinkedList[buckets];

    @Override
    public void add(String key, int value) {
        int index = getHash(key);
        System.out.println("Index for new Entry: " + index);

        if(elements[index] != null) {
            ListIterator iter = elements[index].listIterator();
            while(iter.hasNext()) {
                Entry entry = (Entry) iter.next();
                if (entry.getKey().equals(key)) {
                    try {
                        throw new ExistingKeyException("Key is already existing.");
                    } catch (ExistingKeyException e) {
                        e.getMessage();
                        return;
                    }
                }
            }
        } else {
            elements[index] = new LinkedList<Entry>();
        }

        LinkedList list = elements[index];

        elementsCounter++;
        resizeIfNeeded();

        Entry newEntry = new Entry(key, value);
        list.add(newEntry);
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

    public void printEntries() {
        for (int i = 0; i < elements.length; i++) {
            System.out.println("========= Bucket: " + i + " =========");
            if(elements[i] != null) {
                for (Entry entry : elements[i]
                ) {
                    System.out.println("Entry's key: " + entry.getKey() + "; Entry's value: " + entry.getValue());
                    System.out.println("===============================================");
                }
            }
        }
    }
}
