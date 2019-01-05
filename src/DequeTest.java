import java.util.ArrayList;

public class DequeTest {
    public static void plainTest() {

        Deque<String> deque = new Deque<>();
        assert (deque.isEmpty());
        String stringToAdd = "first";
        deque.addFirst(stringToAdd);
        assert (deque.size() == 1);
        String s = deque.removeLast();
        assert (s.equals(stringToAdd));
        assert (deque.isEmpty());

        deque.addLast(stringToAdd);
        assert (deque.size() == 1);
        s = deque.removeLast();
        assert (s.equals(stringToAdd));
        assert (deque.isEmpty());

        deque.addLast("First");
        deque.addFirst("Second");
        assert (deque.size() == 2);
        s = deque.removeFirst();
        assert (s.equals("Second"));
        s = deque.removeFirst();
        assert (s.equals("First"));
        assert (deque.isEmpty());

    }

    public static void complicatedTest() {

        Deque<String> deque = new Deque<>();
        ArrayList<String> items = new ArrayList<>();
        ArrayList<String> checkList = new ArrayList<>();

        checkList.add(String.valueOf(2));
        checkList.add(String.valueOf(0));
        checkList.add(String.valueOf(1));

        for (int i = 0; i < 3; i++) {
            String string = String.valueOf(i);
            if (i % 2 == 0) {

                deque.addFirst(string);
            } else {

                deque.addLast(string);
            }
        }

        for (String item : deque) {
            items.add(item);
        }

        assert (deque.size() == items.size());
        assert (items.equals(checkList));

        for (int i = 0; i < 3; i++) {
            String string = deque.removeFirst();
            assert(string == checkList.get(i));
        }


        assert (deque.isEmpty());

        try {
            deque.addFirst(null);
        } catch (java.lang.IllegalArgumentException e) {
            e.printStackTrace();
        }
        try {
            deque.addLast(null);
        } catch (java.lang.IllegalArgumentException e) {
            e.printStackTrace();
        }
        try {
            deque.removeFirst();
        } catch (java.util.NoSuchElementException e) {
            e.printStackTrace();
        }
    }
}
