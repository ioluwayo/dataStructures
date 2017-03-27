import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdIn;
import java.util.*;
public class Deque<Item> implements Iterable<Item> {
    private Node first;
    private Node last;
    private int size = 0;
    
    private class Node {
        Item item;
        Node next;
        Node prev;
    }
    /**
     * Constructs a deque a objec using a linkedlist behind the scene
     */
    public Deque () {
        
    }
    /**
     * True is deque is empty.
     * i.e first  == null;
     */
    public boolean isEmpty () {
      return this.first == null;  
    }
    /**
     * Returns the number of elements in the deque
     */
    public int size () {
        return this.size;
    }
    /**
     * Adds an item to the front of the deque
     */
    public void addFirst (Item item) {
        if (item == null) throw new NullPointerException();
        
        Node oldFirst = this.first;
        this.first = new Node();
        this.first.item = item;
        // special case if deque was previously empty
        if(this.size==0) {
            this.last = this.first;
            first.next = null;
        }
        else{
            oldFirst.prev = this.first;
            this.first.next = oldFirst;

        }
        this.first.prev = null;
        size++; //increment size counter whenever we successfully add an element
    }
    /**
     * Adds an item to the back of the deque
     */
    public void addLast (Item item) {
        if (item == null) throw new NullPointerException();
        
        Node oldLast = this.last;
        this.last = new Node ();
        this.last.item = item;
        this.last.next = null;
        // special case if deque  was previously empty
        if (this.size == 0){
            this.first = this.last;
            this.last.prev = null;
        }
        else {
            this.last.prev = oldLast;
            oldLast.next = this.last;
        }
        last.next = null;
        size++;
    }
    /**
     * Removes and returns the item in front of the deque
     */
    public Item removeFirst () {
        if (size == 0) throw new NoSuchElementException();
        
        Item item = first.item;
        if(size>1){
            first =  first.next;
            first.prev = null;
        }
        else{
            first = null;
        }
        size--;
        return item;
    }
    /**
     * Removes and returns the item at the back of the deque
     */
    public Item removeLast () {
        if (size == 0) throw new NoSuchElementException();
        Item item = last.item;
        if (size>1) {
        last = last.prev;
        last.next = null;
        }
        else{
            last = null;
        }
        size--;
        return item;
    }
    /**
     * implementation of iterator abstract method of Iterable interface
     */
    public Iterator<Item> iterator () {
        return new DequeIterator();
    }
    //iterator class defination
    private class DequeIterator implements Iterator<Item> {
        private Node current = first; // reference to the front of the deque 
        
        public boolean hasNext() {
            return current != null; // true while there are items in list
        }
        
        public void remove () {
            throw new UnsupportedOperationException();
        }
        
        public Item next () {
            if (current == null) throw new NoSuchElementException();
            
            Item item = current.item;
            current = current.next;
            return item;

        }
    }

}