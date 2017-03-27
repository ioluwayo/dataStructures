import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdIn;
import java.util.*;
import java.lang.*;
import edu.princeton.cs.algs4.StdRandom;

@SuppressWarnings("unchecked")
public class RandomizedQueue<Item> implements Iterable<Item> {
    private Item [] q;
    private int noElements;
    
    /**
     * constructs an empty randomizedQueue
     */
    public RandomizedQueue(){
        noElements = 0;
        q = (Item[]) new Object[1];
    }
    
    /**
     * returns true  if empty.
     */
    public boolean isEmpty(){
        return this.noElements == 0;
    }
    
    /**
     * returns the number of elements in array.
     */
    public int size(){
        return noElements;
    }
    
    /**
     * removes and returns a random element from the array.
     */
    public Item dequeue() {
        if(noElements == 0) throw new NoSuchElementException();
        int randomIndex = StdRandom.uniform(noElements);
        Item item = q[randomIndex];
        q[randomIndex] = q[noElements-1];
        q[noElements-1] = null;
        noElements--;
        if (noElements == q.length/4){
         resize(q.length/2);
        }
        return item;
    }
    /**
     * returns a random item from the que/array
     */
    public Item sample () {
        if(noElements == 0) throw new NoSuchElementException();
        int randomIndex = StdRandom.uniform(noElements);
        return q[randomIndex];
    }
    
    /**
     * adds an element to the array.
     */
    public void enqueue(Item item){
        if (item == null) throw new NullPointerException();
        q[noElements] = item;
        noElements++;
        if(noElements == q.length){
            resize(2*q.length);
            
        }
    }
    
    /**
     * changes the size of the array.
     */
    private void resize(int capacity){
        Item[] copy = (Item[]) new Object[capacity];
        for(int i = 0; i<noElements; i++){
            copy[i] = q[i];
        }
        q=copy;
    }
    /**
     * returns a random iterator over elements of the array. 
     */
    public Iterator<Item> iterator(){
        return new randomizedQueueIterator();
    }
    
    /**
     * private iterator class that implements the itarator interface with
     * next, hasNext and remove methods for this data type.
     */
    private class randomizedQueueIterator implements Iterator<Item> {
        private int count = 0;
        private int[] randoms =  new int[noElements];
        
        
        public randomizedQueueIterator() {
            for (int i =0; i<noElements; i++) {
                randoms[i] = i; 
            }
            StdRandom.shuffle(randoms);
        }
        
        public boolean hasNext() {
            return count<noElements;
        }
        public void remove() {
             throw new UnsupportedOperationException();
        }
        public Item next() {
            if (count == noElements){
                throw new NoSuchElementException();
            }
            return q[randoms[count++]];
        }
    }
}