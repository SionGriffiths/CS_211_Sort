package sorting2014;

/**
 * @author Siôn Griffiths - sig2@aber.ac.uk
 *         Date: 25/02/14
 *         Time: 15:49
 */
public class SelectionSort implements Sorter {


  @Override
  public void sort(Comparable[] items, int cutoff) {

    System.out.println("Sorting " + items.length + " elements");
    int last = items.length-1;
    int maxIndex = 0;
    Comparable max;
    Comparable temp;

    for(int i = 0; i < items.length; i++){
      max = null;
      for(int j = 0; j <= last; j++){
        if((max == null) || (items[j].compareTo(max) > 0)){
          max = items[j];
          maxIndex = j;
        }
      }
      temp = items[last];
      items[last] = max;
      items[maxIndex] = temp;
      last--;
    }

  }
}
