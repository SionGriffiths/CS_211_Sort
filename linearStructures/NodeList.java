package linearStructures;

/**
 * @author Siôn Griffiths - sig2@aber.ac.uk
 *         Date: 27/02/14
 *         Time: 14:51
 */
public class NodeList {

  ListNode head;


  public NodeList(){
    this.head = null;
  }

  public void add(Comparable item){
    ListNode node = new ListNode(item);
    node.setNext(head);
    head = node;
  }

  public boolean isEmpty(){
    return head == null;
  }

  public ListNode getHead(){
    return head;
  }


}
