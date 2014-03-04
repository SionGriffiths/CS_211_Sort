package sorting2014;

import projectUtils.SortUtils;

/**
 * @author Siôn Griffiths - sig2@aber.ac.uk
 *         Date: 26/02/14
 *         Time: 15:25
 */
public class Quick3Way implements Sorter{

  @Override
  public void sort(Comparable[] items, int cutoff) {
    q3sort(items, 0, items.length-1, cutoff);
  }

  private  void q3sort( Comparable [ ] items, int low, int high, int cutoff ) {
    if( high <= low + cutoff){
      InsertionSort.insertionSort( items, low, high );
      return;
    }
    else {
      // Sort low, middle, high
      int middle = ( low + high ) / 2;
      if( items[ middle ].compareTo( items[ low ] ) < 0 )
        SortUtils.swapElements( items, low, middle );
      if( items[ high ].compareTo( items[ low ] ) < 0 )
        SortUtils.swapElements( items, low, high );
      if( items[ high ].compareTo( items[ middle ] ) < 0 )
        SortUtils.swapElements( items, middle, high );

      // Place pivot at position high - 1
      SortUtils.swapElements( items, middle, high - 1 );
      Comparable pivot = items[ high - 1 ];



      // Begin partitioning
      int i, j;
      for( i = low, j = high - 1; ; ) {
        while( items[ ++i ].compareTo( pivot ) < 0 )
          ;
        while( pivot.compareTo( items[ --j ] ) < 0 )
          ;
        if( i >= j )
          break;
        SortUtils.swapElements( items, i, j );
      }

      // Restore pivot
      SortUtils.swapElements( items, i, high - 1 );

      q3sort( items, low, i - 1, cutoff );    // Sort small elements
      q3sort( items, i + 1, high, cutoff );   // Sort large elements
    }
  }

}
