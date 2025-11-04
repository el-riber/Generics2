package genericsadvanced;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public final class CollectionsUtil {
    private CollectionsUtil() {}

    // Generic Sort Utility: sorts ArrayList<T> where T extends Comparable<? super T>
    public static <T extends Comparable<? super T>> void sort(ArrayList<T> list) {
        list.sort(null); // natural order
    }

    // Wildcard: print any collection
    public static void printCollection(Collection<?> coll) {
        for (Object o : coll) {
            System.out.println(o);
        }
    }

    // Wildcard upper bound: sum numbers
    public static double sumOfNumberList(List<? extends Number> list) {
        double sum = 0.0;
        for (Number n : list) {
            if (n != null) sum += n.doubleValue();
        }
        return sum;
    }
}
