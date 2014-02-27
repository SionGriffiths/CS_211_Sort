package sorting2014;

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

  private void q3sort(Comparable[] a, int lo, int hi, int cutoff) {

   /* if((hi-lo) <= cutoff){
      InsertionSort.insertionSort(a, lo, hi);
      return;
    }*/

    if (hi <= lo) return;

    int lt = lo, gt = hi;
    Comparable v = a[lo];
    int i = lo;

    while (i <= gt) {

      int cmp = a[i].compareTo(v);

      if      (cmp < 0){
        Sig2Utils.swapElements(a, lt++, i++);
      }
      else if (cmp > 0){
        Sig2Utils.swapElements(a, i, gt--);
      }
      else{
        i++;
      }
    }

    // a[lo..lt-1] < v = a[lt..gt] < a[gt+1..hi].
    q3sort(a, lo, lt - 1, cutoff);
    q3sort(a, gt + 1, hi, cutoff);

  }

}
