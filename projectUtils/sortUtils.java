package projectUtils;

/**
 * Created by sig2 on 26/02/14.
 */
public class SortUtils {



  public static String validate(Comparable[] items){

    String checkValue ="";
    if(isSorted(items, 0, items.length-1)){
      checkValue = "Success, array sorted";
    }else{
      checkValue = "Fail, array unsorted";
    }
    return checkValue;
  }


  private static boolean isSorted(Comparable[] items, int low, int high) {

    for (int i = low + 1; i <= high; i++) {
      if (less(items[i], items[i - 1])) {
        System.out.println(items[i].toString() + " is after " + items[i-1].toString());
        return false;
      }
    }
    return true;
  }



  public static boolean less(Comparable item1, Comparable item2) {
    return (item1.compareTo(item2) < 0);
  }


  public static int numRepeatValues(Comparable[] items){

    int repeats = 0;

    for(int i = 0; i < items.length-1; i++){
      if(items[i].compareTo(items[i+1]) == 0){
        repeats++;
      }
    }

    return repeats;
  }


  public static void swapElements(Comparable[] items, int indexFrom, int indexTo){
    Comparable temp = items[indexFrom];
    items[indexFrom] = items[indexTo];
    items[indexTo] = temp;
  }

  public static int[] getMinMax(Comparable[] items){
    Comparable min = null;
    Comparable max = null;

    for(Comparable i : items){
      if(min == null || i.compareTo(min) < 0){
        min = i;
      }
      if(max == null || i.compareTo(max) > 0){
        max = i;
      }
    }
    int[] minmax = new int[2];

    minmax[0] = Integer.parseInt(min.toString());
    minmax[1] =  Integer.parseInt(max.toString());
    return minmax;
  }



}
