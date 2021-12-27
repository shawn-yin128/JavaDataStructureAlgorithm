package DataStructure.Array.KArray;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KSortedArrayMerge {
    static class Entry {
        int x;
        int y;
        int value;
        public Entry(int x, int y, int value) {
            this.x = x;
            this.y = y;
            this.value = value;
        }
    }

    public int[] merge(int[][] arrays) {
        PriorityQueue<Entry> heap = new PriorityQueue<>(new Comparator<Entry>() {
            @Override
            public int compare(Entry o1, Entry o2) {
                if (o1.value == o2.value) {
                    return 0;
                }
                return o1.value < o2.value ? -1 : 1;
            }
        });
        int length = 0;
        for (int i = 0; i < arrays.length; i++) {
            int[] array = arrays[i];
            length += array.length;
            if (array.length != 0) {
                heap.offer(new Entry(i, 0, array[0]));
            }
        }
        int[] result = new int[length];
        int curIdx = 0;
        while (!heap.isEmpty()) {
            Entry tmp = heap.poll();
            result[curIdx++] = tmp.value;
            if (tmp.y + 1 < arrays[tmp.x].length) {
                tmp.y++;
                tmp.value = arrays[tmp.x][tmp.y];
                heap.offer(tmp);
            }
        }
        return result;
    }
}

/**
 * time complexity: O(knlogk)
 * space complexity: O(k)
 */