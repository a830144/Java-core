package leetcode;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ThreeSum {

	public static void main(String[] args) {

		ThreeSum t = new ThreeSum();
		int[] nums = new int[] { 0,0,0,0 };
		List<List<Integer>> list = t.threeSum(nums);
		Iterator<List<Integer>> iter = list.iterator();
		while (iter.hasNext()) {
			List<?> sub = iter.next();
			Iterator<?> iterSub = sub.iterator();
			while (iterSub.hasNext()) {
				System.out.print("," + iterSub.next());
			}
			System.out.println();
		}

	}

	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> main = new LinkedList<List<Integer>>();
		Arrays.sort(nums);
		HashSet<Integer> set1 = new HashSet<Integer>();

		for (int i = 0; i < nums.length; i++) {
			if (!set1.contains(nums[i])) {
				HashSet<Integer> set2 = new HashSet<Integer>();
				for (int j = i + 1; j < nums.length; j++) {
					if (!set2.contains(nums[j])) {
						int temp = 0 - (nums[i] + nums[j]);
						int k = Arrays.binarySearch(nums, j + 1, nums.length, temp);
						if (k >= 0) {

							List<Integer> sub = new LinkedList<Integer>();
							sub.add(nums[i]);
							sub.add(nums[j]);
							sub.add(nums[k]);

							main.add(sub);
							int temp_i = nums[i];
							set1.add(temp_i);
							int temp_j = nums[j];
							set2.add(temp_j);
						}
					}
				}

			}

		}
		return main;

	}

}
