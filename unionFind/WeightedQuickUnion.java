public class WeightedQuickUnion {
 protected int[] id;
 protected int[] size;
 public WeightedQuickUnion(int n) {
  id = new int[n];
  size = new int[n];
  for (int i = 0; i<id.length; i++) {
   size[i] = 1;
   id[i] = i;
  }
 }
 public int root(int i) {
  while(i !=id[i]){
   id[i] = id[id[i]]; //path compression;
   i = id[i];
  }
  return i;
 }
 public boolean connected(int p, int q) {
  return root(p) == root(q);
 }
 public void union (int p, int q) {
  int proot = root(p);
  int qroot  = root(q);
  if(proot == qroot) {
   return;
  }
  if (size[proot] < size[qroot]) {
   id[proot] = qroot;
   size[qroot] += size[proot];
  }
  else {
   id[qroot] = proot;
   size[proot] += size[qroot];
  }
 }
 public static void main(String[] args){
     WeightedQuickUnion qf = new WeightedQuickUnion(10);
     qf.union(1,2);
     qf.union(2,6);
     qf.union(1,9);
     System.out.println(qf.connected(2,9));
 }
 
}
