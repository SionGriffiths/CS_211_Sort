package sorting2014;

import projectUtils.SortUtils;

/**
 * Created by sig2 on 26/02/14.
 */
public class InsertionSort implements Sorter {

  @Override
  public void sort(Comparable[] items, int cutoff) {
    insertionSort(items, 0, items.length-1);
  }


  public static void insertionSort(Comparable[] items, int low, int high) {
    for(int i = low + 1; i <= high; i++ ) {

      Comparable temp = items[i];
      int j;

      for(j = i; j > low && temp.compareTo(items[j-1]) < 0; j--){

        items[j] = items[j-1];
      }
      items[j] = temp;
    }
  }

/*
  public static void insertionSort(Comparable[] items, int low, int high){
    for (int i = 0; i <= high; i++) {
      for (int j = i; j > low; j--) {
        if (items[j-1].compareTo(items[j]) > 0) {

          SortUtils.swapElements(items, j, j-1);
        }
      }
    }
  }*/

}
