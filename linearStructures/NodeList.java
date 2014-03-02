package linearStructures;

/**
 * @author Siôn Griffiths - sig2@aber.ac.uk
 *         Date: 27/02/14
 *         Time: 14:51
 *
 * NodeList is a simple linked list implememntation. Methods are implemented to
 * enable adding of nodes to the head of the list, returning the head of a list
 * and checking whether the list is empty
 */
public class NodeList {

  /**
   * The ListNode at the head of the list
   */
  ListNode head;

  /**
   * Constructs a NodeList, initialises head to null
   */
  public NodeList(){
    this.head = null;
  }

  /**
   * Adds a ListNode to the head of the list
   * @param item the node to be added
   */
  public void add(Comparable item){
    ListNode node = new ListNode(item);
    node.setNext(head);
    head = node;
  }

  /**
   * Checks for empty list
   * @return true for empty, false otherwise
   */
  public boolean isEmpty(){
    return head == null;
  }

  /**
   * Gets the node at the head of the list
   * @return the node at the head of the list
   */
  public ListNode getHead(){
    return head;
  }


}
