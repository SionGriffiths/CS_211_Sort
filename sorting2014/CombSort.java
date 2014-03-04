package sorting2014;

import projectUtils.SortUtils;

/**
 * @author Siôn Griffiths - sig2@aber.ac.uk
 *         Date: 27/02/14
 *         Time: 19:42
 *CombSort implements a sorting algorithm that is based on the simple bubble sort.
 *Comb sort improves on bubble sort primarily by comparing distant elements in
 * an array as opposed to adjacent ones. The distance between elements to be compared
 * decreces with each iteration. Using such a technique results in fewer comparisons
 * being required which results in better performance over the original bubble sort.
 *
 * This CombSort implementation is taken from http://en.wikipedia.org/wiki/Comb_sort
 */
public class CombSort implements Sorter {

  @Override
  public void sort(Comparable[] items, int cutoff) {
    cSort(items);
  }

  /**
   * Performs comb sort on a given array to sort elements in ascending order.
   * @param items the array to be sorted.
   */
  private void cSort(Comparable[] items) {

    int gap = items.length; //Distance between elements to be compared
    boolean swapped = true;

    while (gap > 1 || swapped) {
      if (gap > 1) {
        gap = (int) (gap / 1.3); //Decrease the 'gap'
      }
      swapped = false;
      for (int i = 0; i + gap < items.length; i++) {
        if (items[i].compareTo(items[i + gap]) > 0) {
          SortUtils.swapElements(items, i, i+gap);
          swapped = true;
        }
      }
    }
  }
}
