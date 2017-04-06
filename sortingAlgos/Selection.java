import java.util.*;
import java.lang.*;
/**
 * Static Selection sort that can be used on objects that implememt comparable
 * Best case and worst case is Quadratic run time.
 */
public class Selection
{
    public static void sort (Comparable[] a)
    {
        int N = a.length;
        for (int i = 0; i < N; i++)
        {
            int min = i;
            for (int j = i+1; j<N; j++)
            {
                if(less(a[j],a[min]))
                    min = j;
            }
            exch(a,i,min);
        }
    }
    /**
     * implement the less method
     *  it returns true/false
     */
    private static boolean less(Comparable a, Comparable b)
    {
        return a.compareTo(b) < 0;
    }
    /**
     * implement the exhange method.
     * swaps element sin an array
     */
    private static void exch(Comparable[] a, int i, int j)
    {
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
        return;
    }
}