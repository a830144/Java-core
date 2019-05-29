package leetcode;
public class TotalHammingDistance {

	private int sum=0;
	

	public int totalHammingDistance(int[] nums) {
		/*int r = 2;
		int n = nums.length;
		combination(nums, n, r);
		return sum;*/
		
		
		int result = 0;
		int[] zeroOne = new int[2];
		while (true) {
			int numsZero = 0;
			zeroOne[0] = 0;
			zeroOne[1] = 0;
			for (int i = 0; i < nums.length; i++) {
				if (nums[i] == 0) {
					numsZero++;
				}
				zeroOne[nums[i] % 2]++;
				nums[i] >>>= 1;
			}
			result += zeroOne[0] * zeroOne[1];
			if (numsZero == nums.length) {
				return result;
			}
		}
	}

	
	void combinationUtil(int arr[], int n, int r, int index, int data[], int i) {
		if (index == r) {			
			sum+=bitCount(data[0] ^ data[1]);
			return;
		}
		if (i >= n) {
			return;
		}
		data[index] = arr[i];
		combinationUtil(arr, n, r, index + 1, data, i + 1);
		combinationUtil(arr, n, r, index, data, i + 1);
	}

	void combination(int arr[], int n, int r) {
		int data[] = new int[r];
		combinationUtil(arr, n, r, 0, data, 0);
	}

	public static int bitCount(int i) {
		// HD, Figure 5-2
		i = i - ((i >>> 1) & 0x55555555);
		i = (i & 0x33333333) + ((i >>> 2) & 0x33333333);
		i = (i + (i >>> 4)) & 0x0f0f0f0f;
		i = i + (i >>> 8);
		i = i + (i >>> 16);
		return i & 0x3f;
	}

	public static void main(String[] args) {
		
		TotalHammingDistance t= new TotalHammingDistance();
		int nums[] = { 4, 14, 4 };
		System.out.println(t.totalHammingDistance(nums));
	}
}
