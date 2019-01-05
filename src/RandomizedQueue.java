import java.util.Iterator;

public class RandomizedQueue<Item> implements Iterable<Item> {

    Item[] randomizedQueue;
    private int size;
    private int headOfQueue;
    private int tailOfQueue;
    /*    public class FixedCapacityStackOfStrings
    {
        private String[] s;
        private int N = 0;

        public FixedCapacityStackOfStrings(int capacity)
        { s = new String[capacity]; }

        public boolean isEmpty()
        { return N == 0; }

        public void push(String item)
        { s[N++] = item; }

        public String pop()
        { return s[--N]; }
    } */
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

    public void enqueue(Item item) {
        if (tailOfQueue > randomizedQueue.length) {
            resizeQueue(2 * randomizedQueue.length);
        }
        randomizedQueue[tailOfQueue++] = item;
        size++;
    }
    public Item dequeue() {

    }

    public Item sample()  {
        int itemPosition = StdRandom.uniform(size);

        return randomizedQueue[itemPosition + headOfQueue];
    }
    public Iterator<Item> iterator() {
        return Iterator<Item>;
    }

    private void resizeQueue (int capacity)
    {
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
