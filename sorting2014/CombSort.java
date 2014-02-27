package sorting2014;

/**
 * @author Siôn Griffiths - sig2@aber.ac.uk
 *         Date: 27/02/14
 *         Time: 19:42
 *
 *        This CombSort implementation is taken from http://en.wikipedia.org/wiki/Comb_sort
 */
public class CombSort implements Sorter {
  @Override
  public void sort(Comparable[] items, int cutoff) {
    cSort(items);
  }

  private void cSort(Comparable[] input) {
    int gap = input.length;
    boolean swapped = true;
    while (gap > 1 || swapped) {
      if (gap > 1) {
        gap = (int) (gap / 1.3);
      }
      swapped = false;
      for (int i = 0; i + gap < input.length; i++) {
        if (input[i].compareTo(input[i + gap]) > 0) {
          Comparable t = input[i];
          input[i] = input[i + gap];
          input[i + gap] = t;
          swapped = true;
        }
      }
    }
  }
}
