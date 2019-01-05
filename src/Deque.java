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

        return first == null && last == null;
    }

    public int size() {
        return size;
    }

    public void addFirst(Item item) throws java.lang.IllegalArgumentException {

        if (item == null) {
            throw new java.lang.IllegalArgumentException();
        } else {
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
    }

    public void addLast(Item item) throws java.lang.IllegalArgumentException {
        if (item == null) {
            throw new java.lang.IllegalArgumentException();
        } else {
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
    }

    public Item removeFirst() throws java.util.NoSuchElementException {
        if (first == null) {
            throw new java.util.NoSuchElementException();
        } else {
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
    }

    public Item removeLast() throws java.util.NoSuchElementException {
        if (first == null) {
            throw new java.util.NoSuchElementException();
        } else {
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
    }

    public Iterator<Item> iterator() {
        return new DequeIterator();
    }

    private class DequeIterator implements Iterator<Item> {
        private Node current = first;

        public boolean hasNext() {

            return current != null;
        }

        public void remove() throws java.lang.UnsupportedOperationException {
            throw new java.lang.UnsupportedOperationException();
        }

        public Item next() throws java.util.NoSuchElementException {
            if (current == null) {
                throw new java.util.NoSuchElementException();
            } else {
                Item item = current.item;
                current = current.next;
                return item;
            }
        }
    }

    public static void main(String[] args) {

        DequeTest.plainTest();
        DequeTest.complicatedTest();

    }
}