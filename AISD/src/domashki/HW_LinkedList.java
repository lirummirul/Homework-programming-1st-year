package domashki;

public class HW_LinkedList<T> {
    class Node {
        Node next;
        T value;

        public Node(T value) {
            this.value = value;
            this.next = null;
        }
    }

    Node first;
    Node last;
    int size = 0;

    public void add(T element) {
        if (first == null) {
            first = new Node(element);
            last = first;
        } else {
            last.next = new Node(element);
            last = last.next;
        }
        size++;
    }

    public T get(int index) {
        Node cur = first;
        for (int i = 0; i < index; i++) cur = cur.next;
        return cur.value;
    }

    public void remove(int index) {
        if (index == 0) {
            first = first.next;
        } else {
            Node cur = first;
            for (int i = 0; i < index - 1; i++) cur = cur.next;
            cur.next = cur.next.next;
            if (index == size - 1) last = cur;
        }
        size--;
    }

    public int size() {
        return size;
    }
}