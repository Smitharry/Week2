import java.util.Iterator;

public class RandomizedQueue<Item> implements Iterable<Item> {

    Item[] randomizedQueue;
    private int size;
    private int headOfQueue;
    private int tailOfQueue;

    public RandomizedQueue() {
        Item[] randomizedQueue = (Item[]) new Object[1];
        size = 0;
        headOfQueue = 0;
        tailOfQueue = 0;
    }

    public boolean isEmpty() {
        return (size == 0);
    }

    public int size() {

        return size;
    }

    public void enqueue(Item item) throws java.lang.IllegalArgumentException {
        if (item == null) {
            throw new java.lang.IllegalArgumentException();
        }
        if (tailOfQueue > randomizedQueue.length) {
            resizeQueue(2 * randomizedQueue.length);
        }
        int itemPosition = StdRandom.uniform(size);

        if (itemPosition == size) {
            randomizedQueue[tailOfQueue++] = item;
        } else {
            Item itemToSwap = randomizedQueue[itemPosition + headOfQueue];
            randomizedQueue[itemPosition + headOfQueue] = item;
            randomizedQueue[tailOfQueue++] = itemToSwap;
        }
        size++;
    }

    public Item dequeue() throws java.util.NoSuchElementException{
        if (isEmpty()) {
            throw new java.util.NoSuchElementException();
        }
        if (size < randomizedQueue.length / 4) {
            resizeQueue(randomizedQueue.length / 2);
        }
        Item itemToReturn = randomizedQueue[headOfQueue];
        randomizedQueue[headOfQueue] = null;
        headOfQueue++;
        size--;
        return itemToReturn;
    }

    public Item sample() throws java.util.NoSuchElementException {
        if (isEmpty()) {
            throw new java.util.NoSuchElementException();
        }
        int itemPosition = StdRandom.uniform(size);

        return randomizedQueue[itemPosition + headOfQueue];
    }

    public Iterator<Item> iterator() {

        return new ArrayIterator();
    }

    private class ArrayIterator implements Iterator<Item> {
        private int currentPosition;
        private Item[] iteratorArray = (Item[]) new Object[size];

        ArrayIterator() {

            int counter = 0;
            currentPosition = 0;

            for (int i = headOfQueue; i < tailOfQueue; i++) {
                int itemPosition = StdRandom.uniform(counter);
                if (itemPosition == counter) {
                    iteratorArray[counter++] = randomizedQueue[i];
                } else {
                    Item itemToSwap = iteratorArray[itemPosition];
                    iteratorArray[itemPosition] = randomizedQueue[i];
                    iteratorArray[counter++] = itemToSwap;
                }
            }
        }

        public boolean hasNext() {
            return currentPosition < iteratorArray.length;
        }

        public void remove() throws java.lang.UnsupportedOperationException {
            throw new java.lang.UnsupportedOperationException();
        }

        public Item next() throws java.util.NoSuchElementException {
            if (!hasNext()) {
                throw new java.util.NoSuchElementException();
            }
            return iteratorArray[currentPosition++];
        }
    }

    private void resizeQueue(int capacity) {
        Item[] copy = (Item[]) new Object[capacity];
        int itemPosition = 0;
        for (int i = headOfQueue; i < tailOfQueue; i++)
            copy[itemPosition++] = randomizedQueue[i];
        randomizedQueue = copy;
        headOfQueue = 0;
        tailOfQueue = itemPosition - 1;
    }

    public static void main(String[] args) {
        RandomizedQueueTest.randomizedQueueTest();
        RandomizedQueueTest.iteratorTest();
    }// unit testing (optional)
}
