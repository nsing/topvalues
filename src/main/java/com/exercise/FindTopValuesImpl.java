package com.exercise;

/**
 * This class uses partial sorting algorithm based on Quicksort
 * Expected time is O(s + n log n) where s is the size of array
 * and n is the no. top elements.
 */
public class FindTopValuesImpl implements FindTopValues {

	/**
	 * This method returns the single highest integer in the array.
	 */
	public int findMaxValue(int[] anyOldOrderValues) {
		return findTopNValues(anyOldOrderValues, 1)[0];
	}

	/**
	 * This method returns an array of the highest ’n’ values in the source array,
	 * ordered naturally, with the highest value at the start of the array.
	 */
	public int[] findTopNValues(int[] anyOldOrderValues, int n) {
		int[] topValues = new int[n];
		quickfindFirstK(anyOldOrderValues, 0, anyOldOrderValues.length-1, n);
		for(int i=0; i< n; i++) {
			topValues[i] = anyOldOrderValues[i];
		}
	    return topValues;
	}

	/**
	 * This function is Quicksort variation.
	 * If the pivot falls in position k or later, recurse only on the left partition
	 *
	 * @param array
	 * @param left
	 * @param right
	 * @param n
	 */
	private void quickfindFirstK(int[] array, int left, int right, int n) {
		if (right > left) {
			int pivotIndex = left + (right-left)/2;
			int pivotNewIndex = partition(array, left, right, pivotIndex);
			quickfindFirstK(array, left, pivotNewIndex-1, n);
			if (pivotNewIndex < (left + n)) {
				quickfindFirstK(array, pivotNewIndex+1, right, n);
			}
		}
	}

	/**
	 * This partitions the portion of the array between indexes left and right, inclusively,
	 * by moving all elements equal or greater than array[pivotIndex] before the pivot,
	 * and the smaller elements after it.
	 *
	 * @param anyOldOrderValues
	 * @param left
	 * @param right
	 * @param pivotIndex
	 * @return
	 */
	private int partition(int[] anyOldOrderValues, int left, int right, int pivotIndex) {
		int pivotValue = anyOldOrderValues[pivotIndex];
		swap(anyOldOrderValues, pivotIndex, right);
		int storeIndex = left;
	    for (int i=left; i < right; i++) {
	        if (anyOldOrderValues[i] > pivotValue) {
	        	swap(anyOldOrderValues, i, storeIndex);
	            storeIndex++;
	        }
	    }
	    swap(anyOldOrderValues, storeIndex, right);
	    return storeIndex;
	}

	/**
	 * Swap given indices values in an array
	 *
	 * @param anyOldOrderValues
	 * @param index1
	 * @param index2
	 */
    private void swap(int[] anyOldOrderValues, int index1, int index2) {
        int tmp = anyOldOrderValues[index1];
        anyOldOrderValues[index1] = anyOldOrderValues[index2];
        anyOldOrderValues[index2] = tmp;
    }

	/**
	 * Main method
	 *
	 * @param args
	 */
	public static void main(String[] args) {
		FindTopValues findTopValues = new FindTopValuesImpl();
		int[] arr = { 1,  2,  3,  4,  5,  6,  7,  8,  9, 10,
				     11, 12, 13, 14, 15, 16, 17, 18, 19, 20,
				     21, 22, 23, 24, 25, 26, 27, 28, 29, 30,
				     31, 32, 33, 34, 35, 36, 37, 38, 39, 40,
				     41, 42, 43, 44, 45, 46, 47, 48, 49, 50};
		System.out.println("Array is:: ");
		for(int i=0; i<arr.length; i++){
			System.out.print(arr[i]+" ");
		}
		int[] topValues = findTopValues.findTopNValues(arr, 10);
		System.out.println("\nTop 10 values are: ");
		for(int i=0; i<topValues.length; i++){
			System.out.print(topValues[i]+" ");
		}

		System.out.println("\nTop values is: ");
		System.out.println(findTopValues.findMaxValue(arr));
	}

}
