package lang.java.collections;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Set doesn't provide an operation to <b>get</b> an element that equals another element,
 * the designers of the collection framework were not very forward looking. They didn't
 * anticipate your very legitimate use case, naively tried to "model the mathematical
 * set abstraction" (from the javadoc) and simply forgot to add the useful get() method.
 */
public class JavaSet {
  private static void hashSet() {
    // Create a set
    Set<String> s1 = new HashSet<>();

    // Add a few elements
    s1.add("John");
    s1.add("Donna");
    s1.add("Ken");
    s1.add("Ken"); // Duplicate!!! No effect

    // Create another set by copying s1
    Set<String> s2 = new HashSet<>(s1);

    // Add a few more elements
    s2.add("Ellen");
    s2.add("Sara");
    s2.add(null); // one null is fine
    s2.add(null); // Duplicate!!! No effect

    // Print the sets
    System.out.println("s1: " + s1);
    System.out.println("s1.size(): " + s1.size());

    System.out.println("s2: " + s2);
    System.out.println("s2.size(): " + s2.size());
  }

  /**
   * The LinkedHashSet implementation guarantees that the iterator of a Set will
   * return the elements in the same order the elements were inserted (insertion order).
   */
  private static void linkedHashSet() {
    Set<String> s1 = new LinkedHashSet<>();
    s1.add("John");
    s1.add("Adam");
    s1.add("Eve");
    s1.add("Donna");
    s1.add("Don");
    System.out.println("LinkedHashSet: " + s1);

    // Add the same elements to this set
    Set<String> s2 = new HashSet<>();
    s2.add("John");
    s2.add("Adam");
    s2.add("Eve");
    s2.add("Donna");
    s2.add("Don");
    System.out.println("HashSet: " + s2);

    System.out.println("s1.equals(s2): " + s1.equals(s2));
  }

  public static void main(String[] args) {
    hashSet();
    linkedHashSet();
  }
}


class SetOperations {
  public static void main(String[] args) {
    // Create a set
    Set<String> s1 = new HashSet<>();
    s1.add("John");
    s1.add("Donna");
    s1.add("Ken");

    // Create another set
    Set<String> s2 = new HashSet<>();
    s2.add("Ellen");
    s2.add("Sara");
    s2.add("Donna");

    //Print the elements of both sets
    System.out.println("s1: " + s1);
    System.out.println("s2: " + s2);

    // Perform set operations
    performUnion(s1, s2);
    performIntersection(s1, s2);
    performDifference(s1, s2);
    testForSubset(s1, s2);
  }

  private static void performUnion(Set<String> s1, Set<String> s2) {
    Set<String> s1Unions2 = new HashSet<>(s1);
    s1Unions2.addAll(s2);
    System.out.println("s1 union s2: " + s1Unions2);
  }

  private static void performIntersection(Set<String> s1, Set<String> s2) {
    Set<String> s1Intersections2 = new HashSet<>(s1);
    s1Intersections2.retainAll(s2);
    System.out.println("s1 intersection s2: " + s1Intersections2);
  }

  private static void performDifference(Set<String> s1, Set<String> s2) {
    Set<String> s1Differences2 = new HashSet<>(s1);
    s1Differences2.removeAll(s2);
    Set<String> s2Differences1 = new HashSet<>(s2);
    s2Differences1.removeAll(s1);

    System.out.println("s1 difference s2: " + s1Differences2);
    System.out.println("s2 difference s1: " + s2Differences1);
  }

  private static void testForSubset(Set<String> s1, Set<String> s2) {
    System.out.println("s2 is subset s1: " + s1.containsAll(s2));
    System.out.println("s1 is subset s2: " + s2.containsAll(s1));
  }
}
