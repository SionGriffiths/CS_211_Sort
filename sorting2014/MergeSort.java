package sorting2014;

/**
 * @author Siôn Griffiths - sig2@aber.ac.uk
 *         Date: 25/02/14
 *         Time: 19:01
 *         from slides
 */
public class MergeSort implements Sorter {


  @Override
  public void sort(Comparable[] items, int cutoff) {
    Comparable[] temp = new Comparable[items.length];
    mergeSort(items, temp, 0, items.length - 1);
  }

  private void mergeSort(Comparable[] items, Comparable[] temp, int left, int right){
    if(left < right){
      int centre = (left+right)/2;
      mergeSort(items, temp, left, centre);
      mergeSort(items, temp, centre+1, right);
      merge(items, temp, left, centre, right);
    }
  }

  private void merge(Comparable[] items, Comparable[] temp, int left, int centre, int right){

    for(int i = left; i <= right; i++){
      temp[i] = items[i];
    }

    int leftPtr = left;
    int rightPtr = centre+1;

    for(int i = left; i <= right; i++){
      if(leftPtr > centre){ //leftPtr at end of sub-array
        items[i] = temp[rightPtr];
        rightPtr++;
      }else if(rightPtr > right){//rightPtr at end of sub-array
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
