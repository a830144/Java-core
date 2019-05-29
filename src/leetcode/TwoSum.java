package leetcode;

public class TwoSum {

	static int[] arr = { 35, 33, 42, 26, 27, 49, 10, 14, 44, 31 };

	public static void main(String[] args) {
		
		TwoSum twoSum= new TwoSum();
		Sort(arr, 0, arr.length - 1);
		System.out.println(twoSum.binarySearch(arr, 0, arr.length-1, 49));
		
		/**
		Sort(arr, 0, arr.length - 1);
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
		**/

	}

	public int[] twoSum(int[] nums, int target) {
		Sort(arr, 0, arr.length - 1);
		
		int number =binarySearchLower(arr, 0, arr.length-1, target);
		int compliment = target - number;
		int position = binarySearch(arr, 0, arr.length-1, compliment);
		return null;

	}
	public static void Sort(int[] array, int left, int right)
    {
        if (right <= left)
            return;
 
        // random pivot
        //int pivotIndex = left + random.nextInt(right - left + 1);
 
        // middle pivot
        int pivotIndex = (left + right) / 2;
        int pivot = array[pivotIndex];
        Swap(array, pivotIndex, right);
        int swapIndex = left;
        for (int i = left; i < right; ++i)
        {
            if (array[i] <= pivot)
            {
                Swap(array, i, swapIndex);
                ++swapIndex;
            }
        }
        Swap(array, swapIndex, right);
 
        Sort(array, left, swapIndex - 1);
        Sort(array, swapIndex + 1, right);
    }
 
    private static void Swap(int[] array, int indexA, int indexB)
    {
        int tmp = array[indexA];
        array[indexA] = array[indexB];
        array[indexB] = tmp;
    }

	public int binarySearch(int[] sortArray,int start , int end,int num)
	{
		if(start == end&& sortArray[start]!=num){
			return -1;
		}
		int middle = sortArray[(start+end)/2];		
		if(middle == num){
			return (start+end)/2;
		}else if(num < middle){
			return binarySearch(sortArray,start,(start+end)/2-1,num);
		}else{
			return binarySearch(sortArray,(start+end)/2+1,end,num);
		}
	}
	
	public int binarySearchLower(int[] sortArray,int start , int end,int num)
	{
		if(start == end&& sortArray[start]>=num){
			return -1;
		}
		int middle = sortArray[(start+end)/2];		
		if(middle <= num){
			return middle;
		}else {
			return binarySearch(sortArray,start,(start+end)/2-1,num);
		}
	}

}
