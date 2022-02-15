package OODesign.DemoDataStructure.List;

public class IntList {
    private int value;
    private IntList rest;

    public IntList(int value, IntList rest) {
        this.value = value;
        this.rest = rest;
    }

    // getter
    public int getValue() {
        return value;
    }

    // setter
    public void setValue(int value) {
        this.value = value;
    }

    public void setRest(IntList rest) {
        this.rest = rest;
    }

    // recursive size
    public int recursiveSize() {
        if (rest == null) {
            return 1;
        }
        return 1 + rest.recursiveSize();
    }

    // iterative size
    public int iterativeSize() {
        IntList head = this;
        int size = 0;
        while (head != null) {
            size++;
            head = head.rest;
        }
        return size;
    }

    // get according index
    public int recursiveGet(int i) {
        if (i == 0) {
            return value;
        }
        return rest.recursiveGet(i - 1);
    }

    // get with iteration
    public int iterativeGet(int i) {
        IntList head = this;
        while (i > 0) {
            head = head.rest;
            i--;
        }
        return head.value;
    }

    // increment list without inplace
    public static IntList increList(IntList l, int x) {
        IntList fakeHead = new IntList(0, l);
        IntList i = fakeHead;
        while (l != null) {
            IntList newNode = new IntList(l.value + x, l.rest);
            i.rest = newNode;
            i = i.rest;
            l = l.rest;
        }
        return fakeHead.rest;
    }

    // increment list with inplace
    public static IntList dincreList(IntList l, int x) {
        IntList fakeHead = new IntList(0, l);
        while (l != null) {
            l.value += x;
            l = l.rest;
        }
        return fakeHead.rest;
    }

    // print the list
    public void print() {
        IntList i = this;
        while (i != null) {
            System.out.print(i.value + ", ");
            i = i.rest;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // init list
        IntList l1 = new IntList(10, null);
        IntList l2 = new IntList(7, null);
        IntList l3 = new IntList(5, null);
        IntList l4 = new IntList(3, null);
        IntList l5 = new IntList(1, null);

        l1.setRest(l2);
        l2.setRest(l3);
        l3.setRest(l4);
        l4.setRest(l5);

        IntList head = l1;
        // print all
        head.print();

        // test size
        System.out.print(head.recursiveSize() + ", ");
        System.out.print(head.iterativeSize() + "\n");

        // test get
        System.out.print(head.iterativeGet(1) + ", ");
        System.out.print(head.recursiveGet(1) + "\n");

        // test increment
        System.out.println("test increment");
        IntList incre1 = increList(l1, 1);
        head = incre1;
        head.print();

        IntList incre2 = dincreList(l1, 2);
        head = incre2;
        head.print();

        System.out.println("address of first ele in l1 is " + System.identityHashCode(l1));
        System.out.println("address of first ele in incre1 is " + System.identityHashCode(incre1));
        System.out.println("address of first ele in incre2 is " + System.identityHashCode(incre2));
    }
}
