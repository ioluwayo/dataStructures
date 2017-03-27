import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdIn;
public class ArrayStackOfStrings {
    private String[] s;
    private int N = 0;
    public ArrayStackOfStrings() {
        s = new String[1];
    }
    //double size of array when array is full;
    public void push(String item) {
        if(N==s.length)
            resize(s.length * 2);
        s[N++] = item;
    }
    // half size of array when array is a quarter full;
    public String pop() {
        String item = s[--N];
        s[N]= null; // all garbage collection.
        if(N> 0 && N == s.length/4){
            resize(s.length/2); //resize to half.
        }
        return item;
    }
    // creat a new arry of specified size and copy over elements.
    public void resize(int size){
        String [] copy = new String [size];
        for (int i=0; i<N; i++){
            copy[i] = s[i];
        }
        s = copy;
    }
    public boolean isEmpty(){
        return N==0;
    }
    public static void main(String[] args){
        ArrayStackOfStrings st = new ArrayStackOfStrings();
        st.push("to do or");
        st.push("not");
        st.push("to");
        st.push("do");
        st.push("yeah");
        while(!st.isEmpty()){
            StdOut.println(st.pop());
        }
  
    }
        
}