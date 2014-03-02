package linearStructures;

/**
 * @author Siôn Griffiths - sig2@aber.ac.uk
 *         Date: 27/02/14
 *         Time: 14:46
 *
 * ListNode is a simple class representing a node for use in a linked list.
 * It holds a reference to a Comparable type data object and a reference to the
 * next node in the list.
 */
public class ListNode {

  /**
   * The Comparable data object to be held in the node
   */
  private Comparable dataObject;

  /**
   * A reference to the next node in the list
   */
  private ListNode next;


  public ListNode(){}

  /**
   * Constructs a ListNode. Initiates the node with a data object
   * @param dataObject the Comparable data object to be held in the node
   */
  public ListNode(Comparable dataObject){
    this.dataObject = dataObject;
  }

  /**
   * Returns the data object
   * @return the data object
   */
  public Comparable getDataObject() {
    return dataObject;
  }

  /**
   * Sets the data object held in this node
   * @param dataObject the new data object for this node
   */
  public void setDataObject(Comparable dataObject) {
    this.dataObject = dataObject;
  }

  /**
   * Gets the next node in the list
   * @return the next node in the list
   */
  public ListNode getNext() {
    return next;
  }

  /**
   * Sets the next node in the list
   * @param next the next node
   */
  public void setNext(ListNode next) {
    this.next = next;
  }



}
