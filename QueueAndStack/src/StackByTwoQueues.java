import java.util.Deque;
import java.util.LinkedList;

public class StackByTwoQueues {
    private Deque<Integer> q1;
    private Deque<Integer> q2;

    public StackByTwoQueues() {
        q1 = new LinkedList<Integer>();
        q1 = new LinkedList<Integer>();
    }

    public void push(int value) {
        q1.offerLast(value);
    }

    public Integer pop() {
        Integer prev = q1.pollFirst();
        Integer cur = q1.pollFirst();
        while (cur != null) {
            q2.offerLast(prev);
            prev = cur;
            cur = q1.pollFirst();
        }
        Deque<Integer> tmp = q1;
        q1 = q2;
        q2 = tmp;
        return prev;
    }

    public Integer top() {
        Integer ret = pop(); // perform as pollLast() get what the stack will return next
        if (ret != null) {
            q1.offerLast(ret);
        }
        return ret;
    }

    public boolean isEmpty() {
        return q1.size() == 0;
    }
}
