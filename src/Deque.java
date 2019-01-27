import java.util.Iterator;

public class Deque<Item> implements Iterable<Item> {

    private Node first;
    private Node last;
    private int size;

    public Deque() {
        size = 0;
        first = null;
        last = null;
    }

    public boolean isEmpty() {
        return first == null && last == null;
    }

    public int size() {
        return size;
    }

    public void addFirst(Item item) {
        validateIfNull(item);

        Node oldFirst = first;

        first = new Node();
        first.item = item;
        first.next = oldFirst;

        if (oldFirst != null) {
            oldFirst.previous = first;
        } else {
            last = first;
        }

        size++;
    }

    public void addLast(Item item) {
        validateIfNull(item);

        Node oldLast = last;

        last = new Node();
        last.item = item;

        if (oldLast != null) {
            oldLast.next = last;
            last.previous = oldLast;
        } else {
            first = last;
        }

        size++;
    }

    public Item removeFirst() {
        validateIfNull(first);

        Item removedItem = first.item;
        if (first.next != null) {
            first = first.next;
            first.previous = null;
        } else {
            first = null;
            last = null;
        }

        size--;
        return removedItem;
    }

    public Item removeLast() {
        validateIfNull(first);

        Item removedItem = last.item;
        if (last.previous != null) {
            last = last.previous;
            last.next = null;
        } else {
            last = null;
            first = null;
        }

        size--;
        return removedItem;
    }

    public Iterator<Item> iterator() {
        return new DequeIterator();
    }


    private void validateIfNull(Object item) {
        if (item == null) {
            throw new IllegalArgumentException();
        }
    }


    private class Node {
        Item item;
        Node next;
        Node previous;
    }

    private class DequeIterator implements Iterator<Item> {

        private Node current = first;

        public boolean hasNext() {
            return current != null;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        public Item next() {
            validateIfNull(current);

            Item item = current.item;
            current = current.next;

            return item;
        }
    }

}