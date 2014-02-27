package sorting2014;

import linearStructures.ListNode;
import linearStructures.NodeList;

/**
 * Created by sig2 on 27/02/14.
 */
public class HashSort implements Sorter {

  private NodeList[] help;

  @Override
  public void sort(Comparable[] items, int cutoff) {

   // int range = valueRange(items);
    help = new NodeList[9000000];

    hashSort(items, items.length-1);
  }

  private void hashSort(Comparable[] items, int length){

    int insertIndex = 0;
    for(int i = 0; i < items.length; i++){


      insertIndex = hashFunction(items[i]);

      NodeList list = new NodeList();
      if(help[insertIndex] == null){
        help[insertIndex] = list;
        list.add(items[i]);
      }else{
        help[insertIndex].add(items[i]);
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


  private int hashFunction(Comparable element){
    int value = Integer.parseInt(element.toString());
    return value - 1000000;
  }



}
