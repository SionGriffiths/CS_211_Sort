/*
 * Created on Nov 28, 2003
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package sorting2014;
import java.io.*;
import java.util.*;
/**
 * @author rcs
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
@SuppressWarnings("unchecked")
public class SortDemo {

  public Comparable[] readData(String fileName)  {

    Comparable[] items;
    File file = new File(fileName);
    BufferedReader reader=null;

    try{
      reader = new BufferedReader(
        new FileReader(file));
    } catch (FileNotFoundException e)    {
      System.out.println("File not found "+fileName);
      System.exit(0);
    }

    boolean eof = false;
    String inLine=null;
    int numLines=0;
    while (! eof){
      try{
        inLine=reader.readLine();
        if (inLine==null){
          eof=true;
        } else {
          numLines++;
        }
      } catch (IOException e){}
    }

    try{
      reader.close();
    } catch (IOException e){}

    items = new Comparable[numLines];

    try{
      reader = new BufferedReader(
        new FileReader(file));
    } catch (FileNotFoundException e){
      System.out.println("File not found "+fileName);
      System.exit(0);
    }

    eof = false;
    inLine=null;
    numLines=0;

    while (! eof){
      try{
        inLine=reader.readLine();
        if (inLine==null){
          eof=true;
        } else {
          items[numLines]=inLine;
          numLines++;
        }
      } catch (IOException e){}
    }

    try{
      reader.close();
    } catch (IOException e){}

    return items;
  }



  public long testOne(String type, Comparable[] items){
    long start;
    long finish;
    long timeTaken = 0;
    Sorter s = SortFactory.getSorter(type);

    if (s != null){
      //Changed timing to nanoseconds for improved granularity
      start = System.nanoTime();
      s.sort(items,15);
      finish = System.nanoTime();
      timeTaken=finish-start;
    } else {
      System.out.println("Failed loading the sorter, no sorting will happen.");
    }
    //Check that the returned list is sorted
    System.out.println(Sig2Utils.validate(items) + " using " + type + " on " + items.length + " items");
    // System.out.print(" with " + Sig2Utils.numRepeatValues(items) + " repeated elements" + "\n");
    return timeTaken/1000000; //nanoseconds -> milliseconds
  }

  public void printSortedArray(Comparable[] items){

    for (int i=0; i<items.length; i++){
      System.out.println(items[i]);
    }
  }


  public static void main(String[] args) {
    SortDemo sd = new SortDemo();
  //  Comparable[] items=sd.readData("SortingData/test3e.dat");
  //  System.out.println(sd.testOne("sorting2014.SelectionSort",items));
    //    sd.printSortedArray(items);


    //System.out.println(Sig2Utils.validate(items));
    //  System.out.println(Sig2Utils.numRepeatValues(items) +" items repeating");

//		System.err.println(Runtime.getRuntime().maxMemory());
//		System.out.println(sd.testAll("test6.dat"));
      System.out.println(sd.testEverything());
//		System.out.println(sd.testOne("sorting.OptimisedQuickSort",items));
//		sd.printSortedArray(items);
  }




  public String testEverything()
  {
    String filenames [] ={
      "SortingData/test3.dat",
      "SortingData/test3a.dat",
      "SortingData/test3b.dat",
      "SortingData/test3c.dat",
      "SortingData/test3d.dat",
      "SortingData/test3e.dat",
      "SortingData/test4.dat",
      "SortingData/test4a.dat",
      "SortingData/test4b.dat",
      "SortingData/test4c.dat",
      "SortingData/test4d.dat",
      "SortingData/test4e.dat",
      "SortingData/test5.dat",
      "SortingData/test5a.dat",
      "SortingData/test5b.dat",
      "SortingData/test5c.dat",
      "SortingData/test5d.dat",
      "SortingData/test5e.dat",
      "SortingData/test6.dat",
      "SortingData/test6a.dat",
      "SortingData/test6b.dat",
      "SortingData/test6c.dat",
      "SortingData/test6d.dat",
      "SortingData/test6e.dat",
    };

    String sortTypes[] = {
      "Quick3Way",
      "QuickSort",
      "MergeSort",//2
      "JavaSort",
      "HashSort",
      "CombSort",
      "RadixSort",//6
      "InsertionSort",
      "SelectionSort", //8
      "BubbleSort"
    };

    long timeTaken = 0l;
    StringBuffer retLine=new StringBuffer();

    for (int i= 0; i<sortTypes.length;i++){
      retLine.append(sortTypes[i]);
      for (int j=0; j<filenames.length;j++){

        Comparable[] items=this.readData(filenames[j]);
       // if (items.length>8000000 && i>5) break;
        if (items.length>100000 && i>6) break;
        if (items.length>10000 && i>8) break;

        timeTaken = this.testOne("sorting2014."+sortTypes[i],items);

        retLine.append(","+timeTaken);
      }
      retLine.append("\n");
    }
    return retLine.toString();

  }

  public String testAll(String filename){
    String sortTypes[] = {
      "Quick3Way",
      "QuickSort",
      "MergeSort",//2
      "JavaSort",
      "HashSort",
      "CombSort",
      "RadixSort",//6
      "InsertionSort",
      "SelectionSort", //8
      "BubbleSort"
    };

    long timeTaken[] = new long[sortTypes.length];
    StringBuffer retLine=new StringBuffer();

    for (int i= 0; i<sortTypes.length;i++){
      Comparable[] items=this.readData(filename);
      if (items.length>700000 && i>5) break;
      if (items.length>100000 && i>6) break;
      if (items.length>10000 && i>8) break;

      timeTaken[i]=
        this.testOne("sorting."+sortTypes[i],items);
      retLine.append(sortTypes[i]+"\t"+timeTaken[i]+"\n");
    }
    return retLine.toString();
  }




}
