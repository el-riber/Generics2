package genericsadvanced;

import java.util.Objects;

public class Student implements Comparable<Student> {
    private final String firstName;
    private final String lastName;
    private final int id;

    public Student(String firstName, String lastName, int id) {
        this.firstName = firstName; this.lastName = lastName; this.id = id;
    }

    public String firstName() { return firstName; }
    public String lastName()  { return lastName; }
    public int id()           { return id; }

    @Override
    public int compareTo(Student other) {
        int byLast = this.lastName.compareToIgnoreCase(other.lastName);
        if (byLast != 0) return byLast;
        int byFirst = this.firstName.compareToIgnoreCase(other.firstName);
        if (byFirst != 0) return byFirst;
        return Integer.compare(this.id, other.id);
    }

    @Override
    public String toString() {
        return "Student{" + lastName + ", " + firstName + " #" + id + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Student s)) return false;
        return id == s.id && Objects.equals(firstName, s.firstName) && Objects.equals(lastName, s.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, id);
    }
}
