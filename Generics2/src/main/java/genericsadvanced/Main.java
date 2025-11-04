package genericsadvanced;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Part 1: Pair<K,V> ===");
        Pair<String, Integer> p1 = new Pair<>("age", 36);
        System.out.println(p1);
        p1.setValue(37);
        System.out.println("Updated: " + p1);

        System.out.println("\n=== Part 1: Stack<T> ===");
        Stack<String> stack = new Stack<>();
        stack.push("A"); stack.push("B"); stack.push("C");
        System.out.println("Stack: " + stack);
        System.out.println("peek: " + stack.peek());
        System.out.println("pop: " + stack.pop());
        System.out.println("after pop: " + stack);

        // Edge: underflow (demonstrate exception handling in demo)
        try {
            Stack<Integer> empty = new Stack<>();
            empty.pop(); // should throw
        } catch (NoSuchElementException ex) {
            System.out.println("Caught expected underflow: " + ex.getMessage());
        }

        System.out.println("\n=== Part 2: Sort Utility ===");
        ArrayList<Integer> ints = new ArrayList<>(List.of(5, 2, 9, 1));
        ArrayList<String> strs = new ArrayList<>(List.of("delta", "Alpha", "charlie", "bravo"));
        ArrayList<Student> students = new ArrayList<>(List.of(
            new Student("Alice", "Brown", 3),
            new Student("Bob", "Anderson", 2),
            new Student("Cara", "Anderson", 5)
        ));

        CollectionsUtil.sort(ints);
        CollectionsUtil.sort(strs);
        CollectionsUtil.sort(students);
        System.out.println("Sorted ints: " + ints);
        System.out.println("Sorted strings: " + strs);
        System.out.println("Sorted students: " + students);

        System.out.println("\n=== Part 2: Wildcards ===");
        System.out.println("printCollection(students):");
        CollectionsUtil.printCollection(students);

        List<Number> nums = List.of(1, 2.5, 3L, 4.75f);
        double sum = CollectionsUtil.sumOfNumberList(nums);
        System.out.println("sumOfNumberList: " + sum);

        System.out.println("\n=== Part 3: Cache<T> ===");
        // Cache of Students, keyed by "lastName:firstName#id"
        Cache<Student> studentCache = new Cache<>(s -> s.lastName() + ":" + s.firstName() + "#" + s.id());
        studentCache.add(new Student("Dana", "Clark", 10));
        studentCache.add(new Student("Evan", "Brown", 11));
        System.out.println("studentCache: " + studentCache);

        // second cache, then addAll into first
        Cache<Student> otherCache = new Cache<>(s -> s.lastName() + ":" + s.firstName() + "#" + s.id());
        otherCache.add(new Student("Fiona", "Anderson", 12));
        otherCache.add(new Student("Gina", "Brown", 13));

        studentCache.addAll(otherCache);
        System.out.println("after addAll: " + studentCache);

        String key = "Brown:Evan#11";
        System.out.println("containsKey(" + key + "): " + studentCache.containsKey(key));
        System.out.println("get(" + key + "): " + studentCache.get(key).orElse(null));

        // Edge: clear cache
        studentCache.clear();
        System.out.println("after clear, size=" + studentCache.size());
    }
}
