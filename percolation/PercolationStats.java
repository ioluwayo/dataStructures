import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;
import edu.princeton.cs.algs4.Stopwatch;

public class PercolationStats {
     private Percolation grid;
     private int numberOfOpenedSites = 0;
     private int trials;
     private double [] ratios;
    /**
     * Computes "trials" number of percolation experiments on an n by n grid
     */
    public PercolationStats(int n, int trials){
        if(n<=0 || trials<=0){
            throw new IllegalArgumentException();
        }
        ratios = new double[trials];
        this.trials = trials;
        for (int i = 0; i<trials; i++){
            //create a new percolation object everytime.
            grid = new Percolation(n);
            while(!grid.percolates()) {
                int row = StdRandom.uniform(1,n+1); // a random number [1..n+1]
                int col = StdRandom.uniform(1, n+1);
                grid.open(row, col); // opens a site.
            }
            numberOfOpenedSites = grid.numberOfOpenSites();
            ratios[i] = (double) numberOfOpenedSites/(n*n);
        }
    }
    public double mean(){
        return StdStats.mean(ratios);
    }
    public double stddev(){
        return StdStats.stddev(ratios);
    }
    public double confidenceLo(){
        return this.mean() - (1.96 * this.stddev())/Math.sqrt(this.trials);
    }
    public double confidenceHi(){
        return mean() + (1.96 * this.stddev())/Math.sqrt(this.trials);
    }
    public static void main(String[] args){
        Stopwatch watch = new Stopwatch();
        int n = Integer.parseInt(args[0]); //size
        int t = Integer.parseInt(args[1]);
        PercolationStats pstats = new PercolationStats(n,t);
        StdOut.println("mean                    = " + pstats.mean());
        StdOut.println("stddev                  = " + pstats.stddev());
        StdOut.println("95% confidence interval = [ " 
                           + pstats.confidenceLo() + ", " + 
                       pstats.confidenceHi()+" ]");
        StdOut.println(watch.elapsedTime());
        
        
    }
}