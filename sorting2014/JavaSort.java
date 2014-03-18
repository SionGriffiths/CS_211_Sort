package sorting2014;

import java.util.Arrays;

/**
 * @author Siôn Griffiths - sig2@aber.ac.uk
 *         Date: 27/02/14
 *         Time: 09:22
 *
 * JavaSort calls the java library default array sort.
 *
 * It is included in this project for comparison purposes.
 */
public class JavaSort implements Sorter{
  @Override
  public void sort(Comparable[] items, int cutoff) {
    Arrays.sort(items);
  }
}
