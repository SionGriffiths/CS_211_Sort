package sorting2014;

import java.util.Arrays;

/**
 * Created by sig2 on 27/02/14.
 */
public class JavaSort implements Sorter{
  @Override
  public void sort(Comparable[] items, int cutoff) {
    Arrays.sort(items);
  }
}
