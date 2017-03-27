import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdIn;
import java.util.*;
public class MyStack<Item> implements Iterable<Item>
{
    private Node first = null;
    
    private class Node{
        Item item;
        Node next;
    }
    public boolean isEmpty() {
        return first == null;
    }
    public void push(Item item) {
        Node oldFirst = first;
        this.first  = new Node();
        this.first.item = item;
        this.first.next = oldFirst;
    }
    public Item pop() {
        Item item = this.first.item;
        this.first = this.first.next;
        return item;
    }
    
    // return a new objec of the private class that implements iterator 
    // interface.
    // the encapsulating class implements the iterable interface.
    public Iterator<Item> iterator(){ return new StackIterator();}
    
    // create a private class that implements the iterator interface.
    // hasnext methid, next method and remove if supported
    // you need to return an object of this class when the iterator method is
    // called on an object in your class.
    private class StackIterator implements Iterator<Item> {
        private Node current = first;
        
        public boolean hasNext() {
            return current != null;
        }
        public void remove() {
            throw new UnsupportedOperationException();
        }
        public Item next() {
            if (current == null) {
                throw  new NoSuchElementException();
            }
            Item item = current.item;
            current = current.next;
            return item;
        }
    }
    
    public static void main(String[] args){
        MyStack<Integer> st = new MyStack<>();
        st.push(1);
        st.push(6);
        for(Integer i: st){
            StdOut.println(i);
        }
    }
}