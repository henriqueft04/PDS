import java.lang.Integer;
import java.util.Iterator;
import java.util.ListIterator;

public class Main {
    public static void main(String[] args) {
        VectorGeneric<Integer> vector = new VectorGeneric<Integer>();

        for (int i = 0; i < 10; i++) {
            vector.addElem(i);
        }

        ListIterator<Integer> vecIterator = vector.ListIterator(1);

        while (vecIterator.hasNext()) {
            int value = vecIterator.next();

            if (value == 7) {
                vecIterator.set(10);
            }

            if (value % 2 == 0) {
                vecIterator.remove();
            }

            if (value % 3 == 0) {
                vecIterator.add(value + 10);
            }

            System.out.println(value);

        }

    }
}
