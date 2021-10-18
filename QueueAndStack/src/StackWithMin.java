import java.util.Deque;
import java.util.LinkedList;

public class StackWithMin {
    private Deque<Integer> stack;
    private Deque<Integer> minStack;

    public StackWithMin() {
        stack = new LinkedList<Integer>();
        minStack = new LinkedList<Integer>();
    }

    public int min() {
        if (minStack.isEmpty()) {
            return -1;
        }
        return minStack.peekFirst();
    }

    public void push(int value) {
        stack.offerFirst(value);
        if (minStack.isEmpty() || value <= minStack.peekFirst()) { // = make sure duplicate can be offered
            minStack.offerFirst(value);
        }
    }

    public int pop() {
        if (stack.isEmpty()) {
            return -1;
        }
        Integer result = stack.pollFirst();
        if (minStack.peekFirst().equals(result)) {
            minStack.pollFirst();
        }
        return result;
    }

    public int top() {
        if (stack.isEmpty()) {
            return -1;
        }
        return stack.peekFirst();
    }
}
