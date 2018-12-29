import java.util.Iterator;

public class Deque<Item> implements Iterable<Item> {

    class Node {
        Item item;
        Node next, previous;
    }

    private Node first;
    private Node last;
    private int size;

    public Deque() {
        size = 0;
        first = null;
        last = null;
    }
    public boolean isEmpty() {
        return first == null;
    }
    public int size() {
        return size;
    }
    public void addFirst(Item item) {

        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
        if (oldFirst != null) {
            oldFirst.previous = first;
        }
        size++;

    }
    public void addLast(Item item) {
        Node oldLast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        oldLast.next = last;
        last.previous = oldLast;
        size++;
    }

    public Item removeFirst() {
        Item removedItem = first.item;
        first = first.next;
        first.previous = null;
        size--;
        return removedItem;
    }

    public Item removeLast() {
        Item removedItem = last.item;
        if (last.previous != null) {
            last = last.previous;
            last.next = null;
        }
        else {
            last = null;
        }

        size--;
        return removedItem;

    }

    public Iterator<Item> iterator() {
        return new DequeIterator();
    }

    private class DequeIterator implements Iterator<Item>
    {
        private Node current = first;
        public boolean hasNext() {
            return current != null;
        }
        public void remove() { /* not supported */ }
        public Item next()
        {
            Item item = current.item;
            current = current.next;
            return item;
        }
    }

    public static void main(String[] args) {
        Deque<String> deque = new Deque<>();
        assert (deque.isEmpty());
        String stringToAdd = "first";
        deque.addFirst(stringToAdd);
        assert (deque.size == 1);
        String s = deque.removeLast();
        assert (s.equals(stringToAdd));
        assert (deque.isEmpty());

    }   // unit testing (optional)
}