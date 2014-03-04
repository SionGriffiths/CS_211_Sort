package sorting2014;

import projectUtils.SortUtils;

import java.util.Arrays;

/**
 * @author Siôn Griffiths - sig2@aber.ac.uk
 *         Date: 02/03/14
 *         Time: 13:42
 *
 * CountingSort implements a sorting algorithm that is specific to integer sorting.
 *
 * Using the numeric value of a list element, an index value can be generated.
 * Using this index value to insert the element into a list results in the
 * list being sorted in ascending order without the need for comparison between
 * list elements. Duplicated values are counted and this count is used to repeatedly
 * insert the duplicated value into the sorted array.
 * With no comparisons the algorithm can sort a list in near linear time.
 *
 */
public class CountingSort implements Sorter {

  @Override
  public void sort(Comparable[] items, int cutoff) {
    int[] minmax = SortUtils.getMinMax(items);
    countingSort(items, minmax[0], minmax[1]);
  }

  /**
   * Performs counting sort on a list, sorting its elements in ascending order.
   * @param items the list to be sorted
   * @param min the minimum value found in the list
   * @param max the maximum value found in a list
   */
  public void countingSort(Comparable[] items, int min, int max){
    int[] counts = new int[max - min + 1]; // this will hold all possible values, from min to max

    for(Comparable comp : items){
      counts[Integer.parseInt(comp.toString()) - min]++; // - min so the lowest possible value is always 0
    }
    int current = 0;
    for (int i = 0; i < counts.length; i++){
      Arrays.fill(items, current, current + counts[i], i + min); // fills counts[i] elements of value i + min in current
      current += counts[i]; // leap forward by counts[i] steps
    }
  }
}
