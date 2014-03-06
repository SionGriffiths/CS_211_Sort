package projectUtils;

/**
 * Created by sig2 on 26/02/14.
 *
 * SortUtils defines methods that are used to aid the project. Methods are implemented to
 * validate a sort result, compare two comparable objects, swap elements by index in an array
 * and get the minimum and maximum values that appear in a given dataset.
 */
public class SortUtils {


  /**
   * Validates that elements in an array are sorted in ascending order.
   * @param items the array to be validated
   * @return a message whether the array is sorted or not.
   */
  public static String validate(Comparable[] items){

    String checkValue ="";
    if(isSorted(items, 0, items.length-1)){
      checkValue = "Success, array sorted";
    }else{
      checkValue = "Fail, array unsorted";
    }
    return checkValue;
  }


  /**
   * Iterates through an array between given indexes, compares each element with
   * the one in the prior index. If an element has a lesser value than te one in the prior index
   * the array is unsorted and the method will return false.
   * @param items the array to be validated
   * @param low start index
   * @param high end index
   * @return true if the array is sorted, false otherwise.
   */
  private static boolean isSorted(Comparable[] items, int low, int high) {

    for (int i = low + 1; i <= high; i++) {
      if (less(items[i], items[i - 1])) {
        return false;
      }
    }
    return true;
  }


  /**
   * Checks that a comparable object has lesser value than an other Comparable object.
   * @param item1 first comparable
   * @param item2 second comparable
   * @return true if item1 has lesser value than item 2, false otherwise
   */
  public static boolean less(Comparable item1, Comparable item2) {
    return (item1.compareTo(item2) < 0);
  }


  /**
   * Counts the number of repeated values in a given array
   * @param items the array
   * @return the number of repeated values
   */
  public static int numRepeatValues(Comparable[] items){

    int repeats = 0;

    for(int i = 0; i < items.length-1; i++){
      if(items[i].compareTo(items[i+1]) == 0){
        repeats++;
      }
    }

    return repeats;
  }

  /**
   * Swaps the position of two elements in an array based on their index
   * @param items the array
   * @param indexFrom first element index
   * @param indexTo second element index
   */
  public static void swapElements(Comparable[] items, int indexFrom, int indexTo){
    Comparable temp = items[indexFrom];
    items[indexFrom] = items[indexTo];
    items[indexTo] = temp;
  }

  /**
   * Finds the lowest and highest values in a given array
   * @param items the array
   * @return an array containing the lowest and highest values.
   */
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
