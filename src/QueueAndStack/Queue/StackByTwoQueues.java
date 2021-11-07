package Queue;

import java.util.ArrayDeque;
import java.util.Queue;

public class StackByTwoQueues {
    private Queue<Integer> q1;
    private Queue<Integer> q2;

    public StackByTwoQueues() {
        q1 = new ArrayDeque<>();
        q1 = new ArrayDeque<>();
    }

    public void push(int value) {
        q1.offer(value);
    }

    public Integer pop() {
        Integer prev = q1.poll();
        Integer cur = q1.poll();
        while (cur != null) {
            q2.offer(prev);
            prev = cur;
            cur = q1.poll();
        }
        Queue<Integer> tmp = q1;
        q1 = q2;
        q2 = tmp;
        return prev;
    }

    public Integer top() {
        Integer ret = pop(); // perform as pollLast() get what the stack will return next
        if (ret != null) {
            q1.offer(ret);
        }
        return ret;
    }

    public boolean isEmpty() {
        return q1.size() == 0;
    }
}
