
# Java Generics 2 — Advanced Assignment

## 🎯 Objective
Enhance your understanding of **Java Generics** by implementing and utilizing more complex generic structures, including multi-type generics, collections, wildcards, and practical caching.

---

## 🧩 Project Overview
This project demonstrates:
- Multi-type generic classes (`Pair<K, V>`)
- Generic data structures (`Stack<T>`)
- Generic methods and wildcards (`sort`, `printCollection`, `sumOfNumberList`)
- Complex generic implementations (`Cache<T>` with bounded wildcards)
- Custom class implementing `Comparable<T>` (`Student`)

---

## 🗂️ Project Structure
```

Generic2/
├─ src/
│  └─ main/
│     └─ java/
│        └─ genericsadvanced/
│           ├─ Pair.java
│           ├─ Stack.java
│           ├─ CollectionsUtil.java
│           ├─ Cache.java
│           ├─ Student.java
│           └─ Main.java
└─ README.md

````

Each file uses the package declaration:
```java
package genericsadvanced;
````

---

## ⚙️ How to Compile and Run

### ✅ Step 1: Compile

Open your terminal (PowerShell or CMD) in the project root:

```bash
javac -d out src\main\java\genericsadvanced\*.java
```

### ✅ Step 2: Run

```bash
java -cp out genericsadvanced.Main
```

If using **VS Code**, you can press **Run ▶️** on `Main.java`.

---

## 🧱 Part 1: Implementing Complex Data Structures

### 🔹 `Pair<K, V>`

* Stores a key-value pair of any types.
* Methods: `getKey()`, `getValue()`, `setKey()`, `setValue()`.
* Example:

  ```java
  Pair<String, Integer> personAge = new Pair<>("Age", 30);
  System.out.println(personAge); // Pair{Age = 30}
  ```

### 🔹 `Stack<T>`

* A generic stack that allows pushing and popping any type.
* Methods: `push()`, `pop()`, `peek()`, `isEmpty()`.
* Throws `NoSuchElementException` if `pop()` or `peek()` is called on an empty stack.
* Example:

  ```java
  Stack<String> stack = new Stack<>();
  stack.push("A");
  stack.push("B");
  System.out.println(stack.pop()); // B
  ```

---

## 🧮 Part 2: Using Generics in Collections

### 🔹 `CollectionsUtil.sort()`

* Static generic method that sorts an `ArrayList<T>` where `T extends Comparable<T>`.
* Example:

  ```java
  ArrayList<Integer> list = new ArrayList<>(List.of(5, 3, 9, 1));
  CollectionsUtil.sort(list);
  System.out.println(list); // [1, 3, 5, 9]
  ```

### 🔹 `CollectionsUtil.printCollection()`

* Accepts `Collection<?>` and prints each item (demonstrates wildcard use).
* Example:

  ```java
  List<String> names = List.of("Alice", "Bob", "Carol");
  CollectionsUtil.printCollection(names);
  ```

### 🔹 `CollectionsUtil.sumOfNumberList()`

* Accepts `List<? extends Number>` and returns the sum as a `double`.
* Example:

  ```java
  List<Number> nums = List.of(1, 2.5, 3L);
  double sum = CollectionsUtil.sumOfNumberList(nums); // 6.5
  ```

---

## 🧠 Part 3: Complex Generic Scenarios

### 🔹 `Cache<T>`

* Stores instances of type `T` with retrieval by key.
* Uses a key extractor (`Function<T, String>`) passed into the constructor.
* Methods:

  * `add(T item)`
  * `get(String key)`
  * `clear()`
  * `addAll(Cache<? extends T> other)` — adds compatible cache entries using bounded wildcards.
* Example:

  ```java
  Cache<Student> cache = new Cache<>(s -> s.lastName() + ":" + s.id());
  cache.add(new Student("Alice", "Brown", 1));
  System.out.println(cache.get("Brown:1"));
  ```

### 🔹 `Student` (Custom Comparable)

Implements `Comparable<Student>` for sorting by last name, first name, and ID.

---

## 🧪 Test Cases for Demonstration Video

### ✅ Normal Test Cases

| # | Feature             | Expected Result                                       |
| - | ------------------- | ----------------------------------------------------- |
| 1 | `Pair<K, V>`        | Prints key-value and allows updating value            |
| 2 | `Stack<T>` push/pop | Returns items in correct order                        |
| 3 | `sort()` utility    | Correctly sorts integers, strings, and custom objects |

### ⚠️ Edge Test Cases

| # | Feature                              | Expected Result                                 |
| - | ------------------------------------ | ----------------------------------------------- |
| 1 | Pop empty stack                      | Throws and catches `NoSuchElementException`     |
| 2 | `sumOfNumberList()` with mixed types | Correctly sums integers, floats, doubles, longs |
| 3 | `Cache<T>.clear()`                   | Removes all items; `size()` returns 0           |

---

## 🧩 Example Output

```
=== Part 1: Pair<K,V> ===
Pair{age = 36}
Updated: Pair{age = 37}

=== Part 1: Stack<T> ===
Stack: [A, B, C]
peek: C
pop: C
after pop: [A, B]
Caught expected underflow: Stack underflow: cannot pop from empty stack

=== Part 2: Sort Utility ===
Sorted ints: [1, 2, 5, 9]
Sorted strings: [Alpha, bravo, charlie, delta]
Sorted students: [Student{Anderson, Bob #2}, Student{Anderson, Cara #5}, Student{Brown, Alice #3}]

=== Part 2: Wildcards ===
printCollection(students):
Student{Anderson, Bob #2}
Student{Anderson, Cara #5}
Student{Brown, Alice #3}
sumOfNumberList: 11.25

=== Part 3: Cache<T> ===
studentCache: [Student{Clark, Dana #10}, Student{Brown, Evan #11}]
after addAll: [Student{Clark, Dana #10}, Student{Brown, Evan #11}, Student{Anderson, Fiona #12}, Student{Brown, Gina #13}]
containsKey(Brown:Evan#11): true
get(Brown:Evan#11): Student{Brown, Evan #11}
after clear, size=0
```

---

## 🏅 Extra Credit Opportunities (+5%)

You can earn up to **5% extra credit** by:

* Implementing a **text-based CLI menu** to interact with Stack and Cache.
* Building a **simple GUI (Swing/JavaFX)** to manage the cache visually.
* Writing a **unit test suite (JUnit)** covering all classes.

Include a short PDF describing your enhancements and how they improve the assignment.

---

## 🧑‍💻 Author

**Elida Ribeiro**
North Seattle College — Application Development BAS
📅 *Due Date:* November 3, 2025

