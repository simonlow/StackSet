/**
 * COMP 410
 * See inline comment descriptions for methods we need that are
 * not described in the interface.
 *
*/
package assignment1;

public class StackSet implements StackSet_Interface {
  private Node head;  //this will be the entry point to your linked list 
                      //( it points to the first data cell, the top for a stack )
  private final int limit;  //defines the maximum size the stackset may contain
  private int size;   //current count of elements in the stackset 
  
  public StackSet( int maxNumElts ){ //this constructor is needed for testing purposes. 
    head = null;                 //Please don't modify what you see here!
    limit = maxNumElts;          //you may add fields if you need to
    size = 0;
  }
  
  //implement all methods of the interface, and 
  //also include the getRoot method below that we made for testing purposes. 
  //Feel free to implement private helper methods!
  //you may add any fields you need to add to make it all work... 
  
  public Node getRoot(){ //leave this method as is, used by the grader to grab 
    return head;         //your data list easily.
  }
  public boolean push(double elt) {
	  if(contains(elt)){
		  if (head.getValue() == elt) 
			  return true;
		  Node current = getRoot().getNext();
		  Node previous = getRoot();
		  while (current != null) {
			  if (current.getValue() == elt) {
				  Node temp = getRoot();
				  this.head = current;
				  previous.setNext(current.getNext());
				  current.setNext(temp);
				  return true;
			  }
			  else {
				  previous = current;
				  current = current.getNext();
			  }
		  }  
		  return false;
	  }
	  else if (size() == limit()) {
		  return false;
	  }
	  else {
		  Node newValue = new NodeImpl(elt);
		  newValue.setNext(getRoot());
		  changeHead(newValue);
		  this.size++;
		  return true;
	  }
  }
  public boolean pop() {
	  if (isEmpty()) {
		  return false; 
	  }
	  else {
		  Node newHead = getRoot().getNext();
		  changeHead(newHead);
		  size--;
		  return true;
	  }  
  }
  public double peek() {
	  if (isEmpty()) {
		  return Double.NaN;
	  } else {
		  return getRoot().getValue();
	  }
  }
  public boolean contains(double elt) {
	  if (getRoot() == null) {
		  return false;
	  }
	  Node current = getRoot();
	  while (current != null) {
		  if (current.getValue() == elt) {
			  return true;
		  }
		  else if (current.getNext() == null) {
			  return false;
		  }
		  current = current.getNext();
	  }
	  return false;
  }
  public int size() {
	  return this.size;
  }
  public int limit() {
	  return this.limit;
  }
  public boolean isEmpty() {
	  if (size() == 0)
		  return true;
	  return false;
  }
  public boolean isFull() {
	  if (size() == limit()) 
		  return true;
	  return false;
  }
  private void changeHead(Node newHead) {
	  this.head = newHead;
  }
}
