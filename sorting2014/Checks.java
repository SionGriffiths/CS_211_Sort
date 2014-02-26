package sorting2014;

/**
 * Created by sig2 on 26/02/14.
 */
public class Checks {

  public static boolean isSorted(Comparable[] items) {
    return isSorted(items, 0, items.length - 1);
  }

  private static boolean isSorted(Comparable[] items, int low, int high) {
    for (int i = low + 1; i <= high; i++)
      if (less(items[i], items[i-1])) return false;
    return true;
  }

  private static boolean less(Comparable v, Comparable w) {
    return (v.compareTo(w) < 0);
  }
}
