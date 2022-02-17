package OODesign.DemoDataStructure.List;

public class SLList {
    static class IntNode {
        public int value;
        public IntNode next;

        public IntNode(int value, IntNode next) {
            this.value = value;
            this.next = next;
        }
    }

    public IntNode head;
    public IntNode tail;
    private int size;

    public SLList() {} // init with nothing

    public SLList(int x) { // init with value
        head = new IntNode(x, null);
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
        head = new IntNode(x, head);
        if (isEmpty()) {
            tail = head;
        }
        size++;
    }

    // add at tail
    public void addLast(int x) {
        if (isEmpty()) {
            addHead(x);
        } else {
            tail.next = new IntNode(x, null);
            tail = tail.next;
            size++;
        }
    }

    // add at index
    public void add(int i, int x) throws IndexOutOfBoundsException {
        if (i >= size || i < 0) {
            throw new IndexOutOfBoundsException();
        } else {
            if (i == 0) {
                addHead(x);
            } else if (i == size - 1) {
                addLast(x);
            } else {
                IntNode l = head;
                while (i > 1) {
                    l = l.next;
                    i--;
                }
                IntNode next = l.next;
                l.next = new IntNode(x, next);
                size++;
            }
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
            head = head.next;
            size--;
        }
    }

    // delete at tail
    public void dropLast() {
        if (isEmpty()) {
            return;
        } else if (size == 1) {
            head = null;
            tail = null;
            size--;
        } else {
            IntNode i = head;
            while (i.next.next != null) {
                i = i.next;
            }
            tail = i;
            tail.next = null;
            size--;
        }
    }

    // delete at index
    public void drop(int i) throws IndexOutOfBoundsException {
        if (i >= size || i < 0) {
            throw new IndexOutOfBoundsException();
        } else {
            if (i == 0) {
                dropHead();
            } else if (i == size - 1) {
                dropLast();
            } else {
                IntNode l = head;
                while (i > 1) {
                    l = l.next;
                    i--;
                }
                l.next = l.next.next;
                size--;
            }
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
        if (i == null) {
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
        SLList head = new SLList();

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
        head.addLast(10);
        head.addHead(1);
        head.addHead(2);
        head.addHead(3);
        head.addHead(4);
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

        head.update(9, 100);
        head.print();

        head.drop(0);
        head.print();
        System.out.println(head.size());
        head.drop(head.size() - 1);
        head.print();
        System.out.println(head.size());
        head.drop(2);
        head.print();
        System.out.println(head.size());

        head.add(0, 100);
        head.print();
        head.add(head.size() - 1, 101);
        head.print();
        head.add(1, 200);
        head.print();
        head.add(5, 100);
        head.print();
        System.out.println(head.size());
    }
}
