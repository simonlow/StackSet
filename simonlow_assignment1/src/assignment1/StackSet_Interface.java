/**
 * COMP 410
 *
 * Make your class and its methods public!
 * Don't modify this file!
 *
 * Your StackSet implementation will implement this interface.
 *
*/


package assignment1;

public interface StackSet_Interface {
    public boolean push(double elt);
    public boolean pop();
    public double peek();
    public boolean contains(double elt);
    public int size();
    public int limit();
    public boolean isEmpty();
    public boolean isFull();
}

