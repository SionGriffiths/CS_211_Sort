package sorting2014;

/**
 * Created by sig2 on 26/02/14.
 */
public class Sig2Utils {

  public static String validate(Comparable[] items){

    String checkValue ="";
    if(isSorted(items)){
      checkValue = "Success, array sorted";
    }else{
      checkValue = "Fail, array unsorted";
    }
    return checkValue;
  }

  private static boolean isSorted(Comparable[] items) {
    return isSorted(items, 0, items.length - 1);
  }

  private static boolean isSorted(Comparable[] items, int low, int high) {
    for (int i = low + 1; i <= high; i++) {
      if (less(items[i], items[i - 1])) {
        return false;
      }
    }
    return true;
  }

  public static boolean less(Comparable item1, Comparable item2) {
    return (item1.compareTo(item2) < 0);
  }


  public static void swapElements(Comparable[] items, int indexFrom, int indexTo){
    Comparable temp = items[indexFrom];
    items[indexFrom] = items[indexTo];
    items[indexTo] = temp;
  }
}
