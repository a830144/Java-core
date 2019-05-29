package leetcode;
public class MaxAreaOfIsland {

	private boolean hasIsland = false;

	public int maxAreaOfIsland(int[][] grid) {

		WeightedQuickUnionUF wquf = new WeightedQuickUnionUF(grid.length * grid[0].length);
		

		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if (grid[i][j] == 1) {
					//System.out.println(i + ";" + j);
					if (i != 0) {
						if (grid[i - 1][j] == 1) {
							wquf.union(i * grid[i].length + j, (i - 1) * grid[i].length + j);
							//System.out.println(
									//"union---" + (i * grid[i].length + j) + "----" + ((i - 1) * grid[i].length + j));
						}
					}
					if (i != grid.length - 1 && grid.length > 1) {
						if (grid[i + 1][j] == 1) {
							wquf.union(i * grid[i].length + j, (i + 1) * grid[i].length + j);
							//System.out.println(
									//"union---" + (i * grid[i].length + j) + "----" + ((i + 1) * grid[i].length + j));
						}
					}
					if (j != 0) {
						if (grid[i][j - 1] == 1) {
							wquf.union(i * grid[i].length + j, i * grid[i].length + j - 1);
							//System.out.println(
									//"union---" + (i * grid[i].length + j) + "----" + (i * grid[i].length + j - 1));
						}
					}
					if (j != grid[i].length - 1) {
						if (grid[i][j + 1] == 1) {
							wquf.union(i * grid[i].length + j, i * grid[i].length + j + 1);
							//System.out.println(
									//"union---" + (i * grid[i].length + j) + "----" + (i * grid[i].length + j + 1));

						}
					}
					hasIsland = true;
				}
			}
		}

		int biggest = 1;
		for (int i = 0; i < wquf.size.length; i++) {
			if (wquf.size[i] != 1) {
				//System.out.println(wquf.size[i]);
				if (wquf.size[i] > biggest) {
					biggest = wquf.size[i];
				}
			}
		}
		//System.out.println("xxxxx~~~" + hasIsland);
		if (hasIsland) {
			return biggest;
		} else {
			return 0;
		}

	}

	private class WeightedQuickUnionUF {
		private int[] parent; // parent[i] = parent of i
		private int[] size; // size[i] = number of sites in subtree rooted at i
		private int count; // number of components

		/**
		 * Initializes an empty union�ind data structure with {@code n} sites
		 * {@code 0} through {@code n-1}. Each site is initially in its own
		 * component.
		 *
		 * @param n
		 *            the number of sites
		 * @throws IllegalArgumentException
		 *             if {@code n < 0}
		 */
		public WeightedQuickUnionUF(int n) {
			count = n;
			parent = new int[n];
			size = new int[n];
			for (int i = 0; i < n; i++) {
				parent[i] = i;
				size[i] = 1;
			}
		}

		/**
		 * Returns the number of components.
		 *
		 * @return the number of components (between {@code 1} and {@code n})
		 */
		public int count() {
			return count;
		}

		/**
		 * Returns the component identifier for the component containing site
		 * {@code p}.
		 *
		 * @param p
		 *            the integer representing one object
		 * @return the component identifier for the component containing site
		 *         {@code p}
		 * @throws IllegalArgumentException
		 *             unless {@code 0 <= p < n}
		 */
		public int find(int p) {
			validate(p);
			while (p != parent[p])
				p = parent[p];
			return p;
		}

		// validate that p is a valid index
		private void validate(int p) {
			int n = parent.length;
			if (p < 0 || p >= n) {
				throw new IllegalArgumentException("index " + p + " is not between 0 and " + (n - 1));
			}
		}

		/**
		 * Returns true if the the two sites are in the same component.
		 *
		 * @param p
		 *            the integer representing one site
		 * @param q
		 *            the integer representing the other site
		 * @return {@code true} if the two sites {@code p} and {@code q} are in
		 *         the same component; {@code false} otherwise
		 * @throws IllegalArgumentException
		 *             unless both {@code 0 <= p < n} and {@code 0 <= q < n}
		 */
		public boolean connected(int p, int q) {
			return find(p) == find(q);
		}

		/**
		 * Merges the component containing site {@code p} with the the component
		 * containing site {@code q}.
		 *
		 * @param p
		 *            the integer representing one site
		 * @param q
		 *            the integer representing the other site
		 * @throws IllegalArgumentException
		 *             unless both {@code 0 <= p < n} and {@code 0 <= q < n}
		 */
		public void union(int p, int q) {
			int rootP = find(p);
			int rootQ = find(q);
			if (rootP == rootQ)
				return;

			// make smaller root point to larger one
			if (size[rootP] < size[rootQ]) {
				parent[rootP] = rootQ;
				size[rootQ] += size[rootP];
			} else {
				parent[rootQ] = rootP;
				size[rootP] += size[rootQ];
			}
			count--;
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MaxAreaOfIsland m = new MaxAreaOfIsland();
		/*
		 * int[][] grid = new int[8][13]; for(int i=0;i<8;i++){ for(int
		 * j=0;j<13;j++){ if(i==0){ if(j==2||j==7){ grid[i][j]=1; } } if(i==1){
		 * if(j==7||j==8||j==9){ grid[i][j]=1; } } if(i==2){
		 * if(j==1||j==2||j==4){ grid[i][j]=1; } } if(i==3){
		 * if(j==1||j==4||j==5||j==8||j==10){ grid[i][j]=1; } } if(i==4){
		 * if(j==1||j==4||j==5||j==8||j==9||j==10){ grid[i][j]=1; } } if(i==5){
		 * if(j==10){ grid[i][j]=1; } } if(i==6){ if(j==7||j==8||j==9){
		 * grid[i][j]=1; } } if(i==6){ if(j==7||j==8){ grid[i][j]=1; } }
		 * 
		 * } }
		 */
		int[][] grid = { { 1, 1, 0, 0, 0 }, { 1, 1, 0, 0, 0 }, { 0, 0, 0, 1, 1 }, { 0, 0, 0, 1, 1 } };
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				System.out.print(grid[i][j] + " ");
			}
			System.out.println();
		}
		System.out.print(m.maxAreaOfIsland(grid));
	}

}
