import java.util.ArrayList;
import java.util.Iterator;

public class RandomizedQueueTest {
    public static void randomizedQueueTest () {
        RandomizedQueue<Integer> rq = new RandomizedQueue<Integer>();
        ArrayList<Integer> checkList = new ArrayList<>();


        assert(rq.isEmpty());
        assert(rq.size() == 0);

        for(int i = 0; i < 3; i++) {
            rq.enqueue(i);
            checkList.add(i);
        }

        assert(rq.size() == checkList.size());

        int item = rq.sample();
        boolean isPresent = false;

        for(int number : rq) {
            if (number == item) {
                isPresent = true;
            }
        }

        assert(isPresent);

        int deletedItem = rq.sample();
        boolean isAbsent = true;

        for(int number : rq) {
            if (number == deletedItem) {
                isAbsent = false;
            }
        }
        assert(isAbsent);

        int counter = 0;
        if (deletedItem == 1) {
            counter++;
        }
        for(int i = 1; i < 3; i++) {
            deletedItem = rq.dequeue();
            if (checkList.get(i) == deletedItem) {
                counter++;
            }
        }
        assert(counter != 3);
        assert(rq.isEmpty());
        assert(rq.size() == 0);
    }

    public static void iteratorTest () {
        RandomizedQueue<Integer> rq = new RandomizedQueue<Integer>();
        int counter = 0;

        for(int i = 0; i < 3; i++) {
            rq.enqueue(i);
        }

        Iterator<Integer> firstIterator = rq.iterator();
        Iterator<Integer> secondIterator = rq.iterator();

        while (firstIterator.hasNext() && secondIterator.hasNext())
        {
            int firstItem = firstIterator.next();
            int secondItem = secondIterator.next();
            if (firstItem == secondItem) {
                counter++;
            }
        }
        assert(!firstIterator.hasNext());
        assert(!secondIterator.hasNext());
        assert(counter != 3);

    }
}
