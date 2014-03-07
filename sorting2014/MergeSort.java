package sorting2014;

/**
 * @author Siôn Griffiths - sig2@aber.ac.uk
 *         Date: 25/02/14
 *         Time: 19:01
 *
 * MergeSort implements a standard merge sort algorithm to sort an array in ascending order.
 */
public class MergeSort implements Sorter {


  @Override
  public void sort(Comparable[] items, int cutoff) {
    Comparable[] temp = new Comparable[items.length];
    mergeSort(items, temp, 0, items.length - 1, cutoff);
  }

  /**
   * Perform merge sort on a given array - recursively call this method on each half of the passed in array then merge both halves
   * into a single array again. Subarrays remain in place, delimited by parameter indices.
   * @param items the original array to be sorted
   * @param temp a temporary array used to hold values during the merge
   * @param left lower index of the array
   * @param right upper index of the array
   * @param cutoff controls when mergeSort will drop into insertion sort
   */
  private void mergeSort(Comparable[] items, Comparable[] temp, int left, int right, int cutoff){
    if(right <= left + cutoff){
      InsertionSort.insertionSort(items, left, right);

    }else{
      int centre = (left+right)/2;
      mergeSort(items, temp, left, centre, cutoff); //left subarray
      mergeSort(items, temp, centre+1, right, cutoff); //right subarray
      merge(items, temp, left, centre, right);
    }
  }


  /**
   * Merges subarrays back together based on passed in index range
   * @param items the orignial array to be sorted
   * @param temp a temporary array used to hold values during the merge
   * @param left lower index of array to merge
   * @param centre center index of array to merge
   * @param right upper index of array to merge
   */
  private void merge(Comparable[] items, Comparable[] temp, int left, int centre, int right){

    //copy the given range of items into temp
    for(int i = left; i <= right; i++){
      temp[i] = items[i];
    }

    int leftPtr = left;
    int rightPtr = centre+1;

    //repopulate items from temp in ascending order
    for(int i = left; i <= right; i++){
      if(leftPtr > centre){ //leftPtr at end of sub-array - fill from right sub array
        items[i] = temp[rightPtr];
        rightPtr++;
      }else if(rightPtr > right){//rightPtr at end of sub-array - fill from left
        items[i] = temp[leftPtr];
        leftPtr++;
      }else if(temp[leftPtr].compareTo(temp[rightPtr]) < 0){
        items[i] = temp[leftPtr];
        leftPtr++;
      }else{
        items[i] = temp[rightPtr];
        rightPtr++;
      }
    }


  }

}
