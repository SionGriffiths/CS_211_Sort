package sorting2014;

/**
 * Created by sig2 on 26/02/14.
 */
public class InsertionSort implements Sorter {

  @Override
  public void sort(Comparable[] items, int cutoff) {
    insertionSort(items, 0, items.length-1);
  }


  public static void insertionSort(Comparable[] items, int low, int high) {
    for( int p = low + 1; p <= high; p++ ) {
      Comparable temp = items[ p ];
      int j;

      for( j = p; j > low && temp.compareTo( items[ j - 1 ] ) < 0; j-- )
        items[ j ] = items[ j - 1 ];
      items[ j ] = temp;
    }
  }
}
