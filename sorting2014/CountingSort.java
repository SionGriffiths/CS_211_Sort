package sorting2014;

import projectUtils.SortUtils;

import java.util.Arrays;

/**
 * @author Siôn Griffiths - sig2@aber.ac.uk
 *         Date: 02/03/14
 *         Time: 13:42
 */
public class CountingSort implements Sorter {
  @Override
  public void sort(Comparable[] items, int cutoff) {
    int[] minmax = SortUtils.getMinMax(items);
    countingSort(items, minmax[0], minmax[1]);
  }

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
