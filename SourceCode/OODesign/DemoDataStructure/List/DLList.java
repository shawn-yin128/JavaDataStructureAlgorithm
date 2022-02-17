package OODesign.DemoDataStructure.List;

public class DLList {
    static class IntNode {
        public int value;
        public IntNode prev;
        public IntNode next;

        public IntNode(int value, IntNode prev, IntNode next) {
            this.value = value;
            this.prev = prev;
            this.next = next;
        }
    }

    public IntNode head;
    public IntNode tail;
    private int size;

    public DLList() {} // init with nothing

    public DLList(int x) { // init with value
        head = new IntNode(x, null, null);
        tail = head;
        size = 1;
    }

    // empty?
    public boolean isEmpty() {
        return size == 0;
    }

    // get size
    public int size() {
        return size;
    }

    // clean list
    public void clean() {
        head = null;
        tail = null;
        size = 0;
    }

    // add at head
    public void addHead(int x) {
        head = new IntNode(x, null, head);
        if (size == 0) {
            tail = head;
        } else {
            head.next.prev = head;
        }
        size++;
    }

    // add at tail
    public void addLast(int x) {
        tail = new IntNode(x, tail, null);
        if (size == 0) {
            head = tail;
        } else {
            tail.prev.next = tail;
        }
        size++;
    }

    // add at index
    public void add(int i, int x) throws IndexOutOfBoundsException {
        if (i >= size || i < 0) {
            throw new IndexOutOfBoundsException();
        } else if (i == 0) {
            addHead(x);
        } else if (i == size - 1) {
            addLast(x);
        } else {
            IntNode next = head;
            while (i > 0) {
                next = next.next;
                i--;
            }
            IntNode prev = next.prev;
            prev.next = new IntNode(x, prev, next);
            next.prev = prev.next;
        }
    }

    // delete at head
    public void dropHead() {
        if (isEmpty()) {
            return;
        } else if (size == 1) {
            head = null;
            tail = null;
            size--;
        } else {
            IntNode next = head.next;
            next.prev = null;
            head = next;
            size--;
        }
    }

    // delete at tail
    public void dropLast() {
        if (isEmpty()) {
            return;
        } else if (size == 1) {
            head= null;
            tail = null;
            size--;
        } else {
            IntNode prev = tail.prev;
            prev.next = null;
            tail = prev;
            size--;
        }
    }

    // delete at index
    public void drop(int i) throws IndexOutOfBoundsException {
        if (i >= size || i < 0) {
            throw new IndexOutOfBoundsException();
        } else if (i == 0) {
            dropHead();
        } else if (i == size - 1) {
            dropLast();
        } else {
            IntNode cur = head;
            while (i > 0) {
                cur = cur.next;
                i--;
            }
            cur.prev.next = cur.next;
        }
    }

    // get at head
    public int getHead() {
        return head.value;
    }

    // get at tail
    public int getLast() {
        return tail.value;
    }

    // get at index
    public int get(int i) throws IndexOutOfBoundsException {
        if (i >= size || i < 0) {
            throw new IndexOutOfBoundsException();
        } else {
            IntNode l = head;
            while (i > 0) {
                l = l.next;
                i--;
            }
            return l.value;
        }
    }

    // update head
    public void updateHead(int x) {
        head.value = x;
    }

    // update tail
    public void updateLast(int x) {
        tail.value = x;
    }

    // update at index
    public void update(int i, int x) throws IndexOutOfBoundsException {
        if (i >= size || i < 0) {
            throw new IndexOutOfBoundsException();
        } else {
            IntNode l = head;
            while (i > 0) {
                l = l.next;
                i--;
            }
            l.value = x;
        }
    }

    // print list
    public void print() {
        IntNode i = head;
        if (size == 0) {
            System.out.println("this list is null");
            return;
        }
        while (i != null) {
            System.out.print(i.value + ", ");
            i = i.next;
        }
        System.out.println();
    }

    // test
    public static void main(String[] args) {
        DLList head = new DLList();

        // empty list check
        System.out.println("is this list empty? " + head.isEmpty());
        System.out.println("size of this list? " + head.size());
        head.print();

        head.addHead(1);
        System.out.println("the head is " + head.head.value + " the tail is " + head.tail.value + " the size is " + head.size());
        head.dropLast();
        System.out.println(head.isEmpty() + " " + head.size());
        head.addLast(5);
        System.out.println("the head is " + head.head.value + " the tail is " + head.tail.value + " the size is " + head.size());
        head.dropHead();
        System.out.println(head.isEmpty() + " " + head.size());

        head.addHead(5);
        head.addHead(2);
        head.addLast(3);
        head.addLast(4);
        head.print();
        System.out.println(head.size());

        head.dropLast();
        head.print();
        System.out.println(head.size());

        head.dropHead();
        head.print();
        System.out.println(head.size());

        head.updateHead(10000);
        head.updateLast(255);
        head.print();

        head.clean();
        System.out.println("is this list empty? " + head.isEmpty());
        System.out.println("size of this list? " + head.size());
        head.print();

        head.addHead(10);
        head.addHead(9);
        head.addHead(8);
        head.addHead(7);
        head.addHead(6);
        head.addHead(5);
        head.addHead(4);
        head.addHead(3);
        head.addHead(2);
        head.addHead(1);
        head.print();

        System.out.println(head.get(0));
        System.out.println(head.get(head.size() - 1));
        System.out.println(head.get(5));

        head.update(0, 100);
        head.update(head.size() - 1, 101);
        head.update(5, 102);
        head.print();

        head.add(0, 0);
        head.add(head.size() - 1, 100000);
        head.add(5, 999);
        head.print();

        head.drop(0);
        head.drop(head.size() - 1);
        head.drop(5);
        head.print();
    }
}
