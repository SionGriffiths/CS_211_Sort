package sorting2014;

/**
 * Created by sig2 on 26/02/14.
 */
public class InsertionSort implements Sorter {

  @Override
  public void sort(Comparable[] items, int cutoff) {
    insertionSort(items);
  }

  private void insertionSort(Comparable[] items) {
    int i, j;
    Comparable newValue;
    for (i = 1; i < items.length; i++) {
      newValue = items[i];
      j = i;
      while (j > 0 && (items[j - 1].compareTo(newValue)>0)) {
        items[j] = items[j - 1];
        j--;
      }
      items[j] = newValue;
    }
  }
}
