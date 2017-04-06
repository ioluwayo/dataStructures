
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Percolation {
    private int topIndex = 0; // the extra cell at the top.
    private int bottomIndex; // the extra cell at the bottom.
    private boolean[][] isOpenSite; // size by size matrix.[0][0] = row 1,col 1
    private WeightedQuickUnion qf; // union-find object of size*size + 2
    private int size;
    private int count =0;
    
    /**
     * constructs a percolation object of n by n cells.
     */
    public Percolation(int size){
        if(size<=0){
            throw new IllegalArgumentException();
        }
        else{     
            this.size = size;
            this.bottomIndex = size*size + 1; // last index in qf object
            this.isOpenSite = new boolean[size][size];
            qf = new WeightedQuickUnion(size*size+2); //+2 for extra top and bottom 
        }
    }
    
    /**
     * opens a cell. sets the index[row][col] to true
     */
    public void open(int row, int col) {
        if (row<1 || col<1 || row>size || col>size){
            throw new IndexOutOfBoundsException();// maybe
        }
        else if(!isOpen(row,col)) {
            this.isOpenSite[row-1][col-1] = true;
            count++;
            //Now check if neighbours are open. if they are, union them.
            //since the top and bottom rows are always open
            if (row==1){
                qf.union(topIndex,this.getLocation(row,col));
            }
            if(row == size){
                qf.union(bottomIndex, this.getLocation(row, col));
            }
            if(isOpen(row-1,col)){
                qf.union(getLocation(row-1,col), getLocation(row,col));
            }
            if(isOpen(row+1,col)){
                qf.union(getLocation(row+1,col), getLocation(row,col));   
            }
            if(isOpen(row,col-1)){
                qf.union(getLocation(row,col-1), getLocation(row,col));   
            }
            if(isOpen(row,col+1)){
                qf.union(getLocation(row,col+1), getLocation(row,col));   
            }
        }
    }
    
    /**
     * True if a cell is open
     * false if closed or out of bounds
     */
    public boolean isOpen(int row, int col) {
        if(row>0 && col >0 && row<=size && col <= size){
            return isOpenSite[row-1][col-1];   
        }
        else return false;
    }
    
    /**
     * True if the top cell is connected to cell (row, col)
     */
    public boolean isFull(int row, int col) {
        if(row>0 && col >0 && row<=size && col <= size){
            return qf.connected(topIndex, getLocation(row, col));
        }
        else{
            throw new IndexOutOfBoundsException();
        }
    }
    
    /**
     * True if the system percolates.
     * Which means that theres a patch from top row to bottom row.
     */
    public boolean percolates(){ //does the system percolate.
        return qf.connected(topIndex, bottomIndex);
    }
    
    /**
     * The total number of open sites.
     */
    public int numberOfOpenSites(){
        return count;
    }
    
    /**
     * The numeric location of a pair (row,col)
     */
    private int getLocation(int row, int col){

        if (row>size || col>size){
            throw new IndexOutOfBoundsException();
        }
        if (row<=0 || col<=0){
            throw new IndexOutOfBoundsException();
        }
        else{
            int id = size * (row-1) + col;
            return id;
        }
    }
    private void show(){
        for(int i =0; i<size; i++){
            for (int j = 0; j<size; j++ ){
                if(isOpenSite[i][j]){StdOut.print("*"+" ");}
                else{
                    StdOut.print("#"+" ");
                }
            }
            StdOut.println();
        }
        StdOut.println("number of Open Sites: "+ count);
        return;
    }
    /**
     * For testing
     */
    public static void main(String[] args) {
        
        Percolation grid;
        grid = new Percolation(1);
        StdOut.println(grid.percolates());
        grid.open(1,1);
        StdOut.println(grid.percolates());
        grid.show();
        StdOut.println(grid.percolates());
        
    }
}