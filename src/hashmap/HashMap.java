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
        int index = getHashIdx(key);
        System.out.println("Index for new " + key + " : " + index);

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

        LinkedList<Entry> list = elements[index];

        elementsCounter++;

        Entry newEntry = new Entry(key, value);
        list.add(newEntry);
    }

    @Override
    public Integer getValue(String key) {
        int hash = getHash(key);
        int idx = getHashIdx(key);
        Integer value = null;

        LinkedList<Entry> list = elements[idx];

        ListIterator iter = list.listIterator();
        while(iter.hasNext()) {
            Entry entry = (Entry) iter.next();
            if(getHash(entry.getKey()) == hash && key.equals(entry.getKey())) {
                value = entry.getValue();
                System.out.println("Value found: " + value);
            } else {
                System.out.println("There is no such key");
                return null;
            }
        }
        return value;
    }

    @Override
    public void remove(String key) {
        int hash = getHash(key);
        int idx = getHashIdx(key);

        LinkedList<Entry> list = elements[idx];
        ListIterator iter = list.listIterator();
        while(iter.hasNext()) {
            Entry entry = (Entry) iter.next();
            if(getHash(entry.getKey()) == hash && key.equals(entry.getKey())) {
                iter.remove();
                elementsCounter--;
            }
        }
    }

    @Override
    public void clearAll() {

    }

    private int getHashIdx(String key) {
        return getHash(key) % buckets;
    }

    private int getHash(String key) {
        return key.hashCode();
    }

    private void resizeIfNeeded() {
        if(elementsCounter > buckets * 2) {
            buckets = buckets *2;
        } else if (elementsCounter < buckets / 2) {
            buckets = buckets / 2;
            System.out.println("Resizing elements.");
        }
    }

    public void printEntries() {
        for (int i = 0; i < elements.length; i++) {
            if(elements[i] != null) {
                System.out.println("========= Bucket: " + i + " =========");
                for (Entry entry : elements[i]
                ) {
                    System.out.println("Entry's key: " + entry.getKey() + "; Entry's value: " + entry.getValue());
                    System.out.println("===============================================");
                }
            }
        }

        System.out.println("Sum of elements in map: " + elementsCounter);
    }
}
