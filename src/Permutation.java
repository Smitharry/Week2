import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Permutation {

    public static void main(String[] args) {
        RandomizedQueue<String> queue = readQueue(args);
        printRandomItems(queue);
    }

    private static void printRandomItems(RandomizedQueue<String> randomizedQueue) {
        for (String item : randomizedQueue) {
            StdOut.println(item);
        }
    }

    private static RandomizedQueue<String> readQueue(String[] args) {
        RandomizedQueue<String> randomizedQueue = new RandomizedQueue<>();

        int numberOfInputStrings = Integer.parseInt(args[0]);

        for (int i = 0; i < numberOfInputStrings; i++) {
            randomizedQueue.enqueue(StdIn.readString());
        }

        return randomizedQueue;
    }

}
