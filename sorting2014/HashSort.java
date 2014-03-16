package sorting2014;

import linearStructures.ListNode;
import linearStructures.NodeList;
import projectUtils.SortUtils;

/**
 * @author Siôn Griffiths - sig2@aber.ac.uk
 *         Date: 27/02/14
 *         Time: 15:12
 *
 * HashSort implementes a sorting algorithms that is specific to integer sorting.
 *
 * Using the numeric value of a list element, an index value can be generated.
 * Using this index value to insert the element into a list results in the
 * list being sorted in ascending order without the need for comparison between
 * list elements.
 *
 * Each element in the list being inserted to is represented by a simple linked list
 * (See NodeList class), any duplicated values are inserted into the linked list for that value.
 */
public class HashSort implements Sorter {

  private NodeList[] help;
  private int min;
  private int max;


  @Override
  public void sort(Comparable[] items, int cutoff) {

    setMinMax(items);
    int range = max-min;
    help = new NodeList[range+1];

    hashSort(items, items.length-1);
  }

  /**
   * Performs HashSort on an array, sorting it in ascending order.
   * @param items the array to be sorted
   * @param length the number of elements in the array
   */
  private void hashSort(Comparable[] items, int length){

    int insertIndex = 0;
    for(int i = 0; i < items.length; i++){
      insertIndex = hashFunction(items[i]);

      NodeList list = new NodeList();
      if(help[insertIndex] == null){ //check if index already occupied
        help[insertIndex] = list;
        list.add(items[i]);
      }else{
        help[insertIndex].add(items[i]); //add element to linked list if already occupied
      }
    }

    int j =0;
    for(int i = 0; i < help.length; i++){
      if(help[i] != null){
        items[j] = help[i].getHead().getDataObject();
        j++;
        if(help[i].getHead().getNext() != null){
          for(ListNode itar = help[i].getHead().getNext(); itar != null; itar = itar.getNext() ){
            items[j] = itar.getDataObject();
            j++;
          }
        }
      }
    }


  }


  /**
   * A method to generate index values for elements to be inserted into the array.
   * This naive method simple subtracts the minimum value found in the dataset
   * from each element to be inserted such that the lowest value will always have an index of 0.
   * @param element the element to generate an index value for
   * @return the index value generated for the element.
   */
  private int hashFunction(Comparable element){
    int value = Integer.parseInt(element.toString());
    return value - min;
  }

  /**
   * Method to set the minimum and maximum values found in the array
   * @param items the array
   */
  private void setMinMax(Comparable[] items){
    int[] minmax = SortUtils.getMinMax(items);
    this.min = minmax[0];
    this.max = minmax[1];
  }

}
