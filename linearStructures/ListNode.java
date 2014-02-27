package linearStructures;

/**
 * Created by sig2 on 27/02/14.
 */
public class ListNode {

  private Comparable dataObject;
  private ListNode next;


  public ListNode(Comparable dataObject){
    this.dataObject = dataObject;
  }


  public Comparable getDataObject() {
    return dataObject;
  }

  public void setDataObject(Comparable dataObject) {
    this.dataObject = dataObject;
  }

  public ListNode getNext() {
    return next;
  }

  public void setNext(ListNode next) {
    this.next = next;
  }



}
