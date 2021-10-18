import java.util.Deque;
import java.util.LinkedList;

public class QueueByTwoStacks {
    private Deque<Integer> in;
    private Deque<Integer> out;

    public QueueByTwoStacks() {
        in = new LinkedList<Integer>();
        out = new LinkedList<Integer>();
    }

    public Integer poll() {
        move();
        return out.isEmpty() ? null : out.pollFirst(); // need to make sure can poll
    }

    public void offer(int value) {
        in.offerFirst(value);
    }

    public Integer peek() {
        move();
        return out.isEmpty() ? null : out.peekFirst(); // need to make sure there is value to peek
    }

    private void move() { // when no elements in out stack, move from in stack to out stack
        if (out.isEmpty()) { // check move or not
            while (!in.isEmpty()) { // 注意while
                out.offerFirst(in.pollFirst());
            }
        }
    }

    public int size() {
        return in.size() + out.size();
    }

    public boolean isEmpty() {
        return in.size() == 0 && out.size() == 0;
    }
}
