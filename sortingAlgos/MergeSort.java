import java.util.*;
public class MergeSort{
 
    public static void sort(Comparable[] array){
    /**This is the public method that requires just the array as input **/
        int n = array.length;
        Comparable[] auxArray = new Comparable[n];
        sort(array,auxArray,0,n-1);
    }
    private static void sort(Comparable[] array, Comparable[] auxArray, int leftLimit, int rightLimit){
        if(leftLimit >= rightLimit) return; //there is nothing to be done, single item array is sorted.
        int mid = leftLimit + (rightLimit - leftLimit)/2;
        /**sort the left half, sort the right half, then merge both halves**/
        sort(array, auxArray, leftLimit, mid);
        sort(array, auxArray, mid+1, rightLimit);
        merge(array,auxArray, leftLimit, rightLimit);
    }
    private static void merge(Comparable[] array, Comparable[] auxArray,int l, int r){
        /**copy the entire array over to the auxilary array and then put them back in the proper order**/
        for(int i = 0; i<=r; i++){
            auxArray[i] = array[i];
        }
        int mid = l+(r-l)/2;
        int lpointer = l;
        int rpointer = mid+1;
        for(int i = l; i<=r; i++){
            if(lpointer>mid) array[i] = auxArray[rpointer++]; //if left half is exhausted
            else if(rpointer>r) array[i] = auxArray[lpointer++];
            else if(auxArray[lpointer].compareTo(auxArray[rpointer])!=1) array[i] = auxArray[lpointer++];
            else array[i] = auxArray[rpointer++];
        }
    }
}
