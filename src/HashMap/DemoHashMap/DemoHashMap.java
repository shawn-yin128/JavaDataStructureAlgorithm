package DemoHashMap;

import java.util.Arrays;

public class DemoHashMap<K, V> {
    public static class Entry<K, V> {
        public K key;
        public V value;
        Entry<K, V> next;
        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
        public K getKey() {
            return key;
        }
        public V getValue() {
            return value;
        }
        public void setValue(V value) {
            this.value = value;
        }
    }

    // field
    private static final int DEFAULT_CAPACITY = 16;
    private static final float DEFAULT_LOAD_FACTOR = 0.75f;
    private Entry<K, V>[] array;
    private int size;
    private float loadFactor;

    // constructor
    public DemoHashMap() {
        this(DEFAULT_CAPACITY, DEFAULT_LOAD_FACTOR);
    }
    public DemoHashMap(int cap, float loadFactor) {
        if (cap <= 0) {
            throw new IllegalArgumentException("capacity cannot be non-positive.");
        }
        this.array = (Entry<K, V>[]) (new Entry[cap]); // generic type cannot directly generate array
        this.size = 0;
        this.loadFactor = loadFactor;
    }

    // key private method
    private int hash(K key) {
        if (key == null) {
            return 0;
        }
        int hashNumber = key.hashCode();
        return hashNumber & 0x7FFFFFF; //make sure hashnumber is positive
    }
    private int getIndex(K key) {
        return hash(key) % array.length;
    }
    private boolean equalsValue(V v1, V v2) {
        return v1 == v2 || (v1 != null && v1.equals(v2)); // primitive type use first one, or if the reference is same. other object use second one
    }
    private boolean equalsKey(K k1, K k2) {
        return k1 == k2 || (k1 != null && k1.equals(k2)); // primitive type use first one, or if the reference is same. other object use second one
    }
    private boolean needRehasing() {
        float ratio = (size + 0.0f) / array.length;
        return ratio >= loadFactor;
    }
    private void rehasing() {
        Entry<K, V>[] oldArray = array;
        array = (Entry<K, V>[]) (new Entry[array.length * 2]);
        for (Entry<K, V> entry : oldArray) {
            while (entry != null) {
                Entry<K, V> next = entry.next;
                int index = getIndex(entry.getKey());
                entry.next = array[index]; // to link with other node if there is already node at index --> has collision
                array[index] = entry; // let entry as new head
                entry = next;
            }
        }
    }

    // key API
    public V put(K key, V value) {
        int index = getIndex(key);
        Entry<K, V> entry = array[index];
        Entry<K, V> cur = entry;
        while (cur != null) {
            if (equalsKey(cur.getKey(), key)) {
                V result = cur.getValue();
                entry.setValue(value);
                return result;
            }
            cur = cur.next;
        }
        Entry<K, V> newHead = new Entry<K, V>(key, value);
        newHead.next = entry;
        array[index] = newHead;
        size++;
        if (needRehasing()) {
            rehasing();
        }
        return null;
    }
    public V remove(K key) {
        int index = getIndex(key);
        Entry<K, V> entry = array[index];
        Entry<K, V> prev = null;
        while (entry != null) {
            if (equalsKey(entry.getKey(), key)) {
                if (prev != null) {
                    prev.next = entry.next;
                } else {
                    array[index] = entry.next;
                }
                size--;
                return entry.value;
            }
            prev = entry;
            entry = entry.next;
        }
        return null;
    }
    public V get(K key) {
        int index = getIndex(key);
        Entry<K, V> entry = array[index];
        while (entry != null) {
            if (equalsKey(entry.getKey(), key)) {
                return entry.getValue();
            }
            entry = entry.next;
        }
        return null;
    }
    public int size() {
        return size;
    }
    public boolean isEmpty() {
        return size == 0;
    }
    public void clear() {
        Arrays.fill(this.array, null);
        size = 0;
    }
    public boolean containsValue(V value) {
        if (isEmpty()) {
            return false;
        }
        for (Entry<K, V> entry: array) {
            while (entry != null) {
                if (equalsValue(entry.getValue(), value)) {
                    return true;
                }
                entry = entry.next;
            }
        }
        return false;
    }
    public boolean containsKey(K key) {
        if (isEmpty()) {
            return false;
        }
        int index = getIndex(key);
        Entry<K, V> entry = array[index];
        while (entry != null) {
            if (equalsKey(entry.getKey(), key)) {
                return true;
            }
            entry = entry.next;
        }
        return false;
    }
}