import java.util.*;
import java.lang.*;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdIn;
public class Permutation {
    public static void main(String[] args){
        int k = Integer.parseInt(args[0]);
        RandomizedQueue<String> q = new RandomizedQueue<>();
        while(StdIn.hasNextLine() && !StdIn.isEmpty()){
            q.enqueue(StdIn.readString());
        }
        Iterator<String> iter = q.iterator();
        for (int i = 0; i<k; i++){
            StdOut.println(iter.next());
        }
    }
       
}