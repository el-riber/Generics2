package genericsadvanced;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class Stack<T> {
    private final List<T> data = new ArrayList<>();

    public void push(T item) {
        data.add(item);
    }

    public T pop() {
        if (isEmpty()) {
            throw new NoSuchElementException("Stack underflow: cannot pop from empty stack");
        }
        return data.remove(data.size() - 1);
    }

    public T peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("Stack is empty: cannot peek");
        }
        return data.get(data.size() - 1);
    }

    public boolean isEmpty() {
        return data.isEmpty();
    }

    public int size() { return data.size(); }

    @Override
    public String toString() {
        return data.toString();
    }
}
