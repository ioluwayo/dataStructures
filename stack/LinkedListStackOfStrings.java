public class LinkedListStackOfStrings {

    private Node first = null;
    
    /**
     * Inner class defining a node for a string linked list
     * access modifiers do not matter
     */
    private class Node {
        String item;
        Node next;
    }
    public boolean isEmpty() {
        return first == null;
    }
    public void push(String item){
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
    }
    public String pop () {
        String item = first.item;
        first = first.next;
        return item;
    }
    public static void main(String args[]){
        LinkedListStackOfStrings st = new LinkedListStackOfStrings();
        st.push("1hey");
        st.push("2hey");
        while (!st.isEmpty()){
        System.out.println(st.pop());
        }
    }
}