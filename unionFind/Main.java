import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		System.out.println("====== QUICK FIND ======");
		QuickFind quikfind = new QuickFind(10);
		System.out.println(quikfind.connected(1, 3));
		quikfind.union(0, 1);
		System.out.println(quikfind.connected(0, 1));
		
		System.out.println("====== QUICK UNION ======");
		QuickUnion quickunion = new QuickUnion(20);
		System.out.println(quickunion.connected(12, 11));
		System.out.println(quickunion.connected(10, 1));
		quickunion.union(12, 11);
		System.out.println(quickunion.connected(12, 11));
		
		System.out.println("===== WEIGHTED QUICK UNION WITH PATH COMPRESSION =====");
		WeightedQuickUnion weightedquickunion = new WeightedQuickUnion(20);
		System.out.println(weightedquickunion.connected(10, 12));
		System.out.println(weightedquickunion.connected(1, 4));
		weightedquickunion.union(10, 12);
		System.out.println(weightedquickunion.connected(10, 12));
		
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = null;
		try {
			temp = bfr.readLine().split(" ");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        int N = Integer.parseInt(temp[0]);
        int I = Integer.parseInt(temp[1]);
        wqu qu = new wqu(N);
        for(int i = 0; i < I; i++){
            try {
				temp = bfr.readLine().split(" ");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            int a = Integer.parseInt(temp[0]);
            int b = Integer.parseInt(temp[1]);
            qu.union(a,b);
          // Store a and b in an appropriate data structure of your choice
        }
       int[] size = qu.getSize();
       long combinations = 0;
       HashSet<Integer> roots = new HashSet<>();
       for (int i:qu.getId()){
    	   roots.add(i);
       }
       long previousSum = qu.getSize()[0];
       for(int i = 1; i<qu.getSize().length; i++){
           combinations += previousSum * qu.getSize()[i];
           previousSum += qu.getSize()[i];
       }

        // Compute the final answer - the number of combinations
       
        System.out.println(combinations);
        }
	}
