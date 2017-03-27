
public class QuickUnion {
	private int[] id;
	public QuickUnion(int n) {
		id = new int[n];
		for (int i=0; i<n; i++){
			id[i] = i; 
		}
	}
	private int root(int n) {
		while (n != id[n]) n = id[n];
		return n;
	}
	/**
	 * depth of p and q array accesses
	 * only one id changes however.
	 * @param p
	 * @param q
	 */
	public void union (int p, int q) {
		int qroot = root(q);
		id[p] = qroot;
	}
	/**
	 * depth of p and q array accesses
	 * This can get expensive with a skinny long tree
	 * @param p
	 * @param q
	 * @return
	 */
	public boolean connected (int p, int q) {
		return root(p) == root(q);
	}
}
