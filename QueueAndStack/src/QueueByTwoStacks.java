import java.util.LinkedList;

public class QueueByTwoStacks {
    private LinkedList<Integer> in;
    private LinkedList<Integer> out;

    public QueueByTwoStacks() {
        in = new LinkedList<Integer>();
        out = new LinkedList<Integer>();
    }

    public Integer poll() {
        move();
        return out.pollFirst();
    }

    public void offer(int value) {
        in.offerFirst(value);
    }

    public Integer peek() {
        move();
        return out.peekFirst();
    }

    private void move() { // when no elements in out stack, move from in stack to out stack
        if (out.isEmpty()) { // check move or not
            while (!in.isEmpty()) {
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
