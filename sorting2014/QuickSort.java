package sorting2014;

import projectUtils.SortUtils;

/**
 * Created by sig2 on 26/02/14.
 *
 * taken from lecture slides
 */
public class QuickSort implements Sorter {

  @Override
  public void sort(Comparable[] items, int cutoff) {
    if(items.length < 10000){
      cutoff = 0;
    }
    quickSort(items, 0, items.length-1, cutoff);

  }

  private void quickSort(Comparable[] items, int low, int high, int cutoff){
    int pivot;

    if(high <= low + cutoff){
      InsertionSort.insertionSort(items, low, high);

    }else{

      pivot = partition( items, low, high );
      quickSort(items, low, pivot-1, cutoff);
      quickSort(items, pivot+1, high, cutoff);
    /*
    if ( high > low ){
      pivot = partition( items, low, high );
      quickSort(items, low, pivot-1);
      quickSort(items, pivot+1, high);*/
    }
  }



  private int partition(Comparable[] items, int low, int high){

    int diff = (high-low)/2;
    int pivotPos = low+diff;

    SortUtils.swapElements(items, pivotPos, low);

    int swapPos = low+1;

    for(int i = swapPos; i <= high; i++){
      if(items[i].compareTo(items[low]) < 0){

        SortUtils.swapElements(items, swapPos, i);
        swapPos++;
      }
    }

    SortUtils.swapElements(items, low, swapPos - 1);


    return swapPos-1;
  }

  /*
  pivotPos = middle of array a;
swap a[pivotPos] with a[first]; // Move the pivot out of the way
swapPos = first + 1;
for each element in the array from swapPos to last do:
// If the current element is smaller than pivot we
// move it towards start of array
if (a[currentElement] < a[first]):
swap a[swapPos] with a[currentElement];
increment swapPos by 1;
// Now move the pivot back to its rightful place
swap a[first] with a[swapPos-1];
return swapPos-1; // Pivot position
   */
}
