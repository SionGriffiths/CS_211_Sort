package sorting2014;

/**
 * Created by sig2 on 27/02/14.
 */
public class HashSort implements Sorter {

  private Comparable[] help;
  private Comparable[] help2;
  @Override
  public void sort(Comparable[] items, int cutoff) {

    help = new Comparable[9000000];
    help2 = new Comparable[items.length-1];
    hashSort(items, items.length-1);
  }

  private void hashSort(Comparable[] items, int length){

    int insertIndex = 0;
    for(int i = 0; i < items.length; i++){



      insertIndex = hashFunction(items[i]);
      help[insertIndex] = items[i];
    }

    int j = 0;
    for(int i =0; i < help.length; i++){
      if(help[i] != null){
        help2[j] = help[i];
        j++;
      }
    }

  }

  /*
  private int collision(Comparable[] help, int index){


    if(help[index] == null){
      return index;
    }else if(help[index+1] == null){
      return index+1;
    }else if(help[index+3] == null){
      return index+3;
    }else if(help[index+5] == null){
      return index+5;
    }else if(help[index+7] == null){
      return index+7;
    }else{
      System.err.print("List is b0rk mate");
    }


  }*/



  private int hashFunction(Comparable element){

    int hash;
    int value = Integer.parseInt(element.toString());
    hash = value - 1000000;
    return hash;
  }
}
