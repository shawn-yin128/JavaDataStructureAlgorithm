package Stack;

import java.util.LinkedList;

public class SortWithTwoStacks {
    public void sort(LinkedList<Integer> s1) {
        LinkedList<Integer> s2 = new LinkedList<>();
        if (s1 == null || s1.size() <= 1) {
            return;
        }
        sort(s1, s2);
    }
    public void sort(LinkedList<Integer> input, LinkedList<Integer> buffer) {
        while (!input.isEmpty()) {
            int curMin = Integer.MAX_VALUE;
            int count = 0;
            while (!input.isEmpty()) {
                int cur = input.pollFirst();
                if (cur < curMin) {
                    curMin = cur;
                    count = 1;
                } else if (cur == curMin) {
                    count++;
                }
                buffer.offerFirst(cur);
            }
            while (!buffer.isEmpty() && buffer.peekFirst() >= curMin) {
                int temp = buffer.pollFirst();
                if (temp != curMin) {
                    input.offerFirst(temp);
                }
            }
            while (count > 0) {
                buffer.offerFirst(curMin);
                count--;
            }
        }
        while (!buffer.isEmpty()) {
            input.offerFirst(buffer.pollFirst());
        }
    }
}

/**
 * time complexity: O(n^2)
 * space complexity: O(n)
 */