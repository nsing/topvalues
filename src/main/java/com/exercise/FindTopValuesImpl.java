package com.exercise;

/**
 * Implements interface {@link FindTopValues}
 */
public class FindTopValuesImpl implements FindTopValues {

	/**
	 * Returns the single highest integer
	 *
	 * @param input array
	 * @return max value
	 */
	public int findMaxValue(int[] anyOldOrderValues) {
		return findTopNValues(anyOldOrderValues, 1)[0];
	}

	/**
	 * Returns an array of the highest 'n' values in the source array, ordered
	 * naturally, with the highest value at the start of the array
	 * <p>
	 * This uses partial sorting algorithm based on Quicksort. Expected
	 * time is O(s + n log n) where s is the size of array and n is the no.
	 * of top elements.
	 *
	 * @param input array
	 * @param no. of highest values
	 * @return array of top values
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
	 * This works in such a way that if the pivot falls in position n or later
	 * recurse only on the left partition otherwise recurse on both partitions
	 *
	 * @param array
	 * @param left
	 * @param right
	 * @param no. of highest values
	 */
	private void quickfindFirstK(int[] array, int left, int right, int n) {
		if (right > left) {
			int pivotIndex = left + (right-left)/2;
			int pivotNewIndex = partition(array, left, right, pivotIndex);
			//Recurse on left partition
			quickfindFirstK(array, left, pivotNewIndex-1, n);
			if (pivotNewIndex < (left + n)) {
				/*Pivot doesn't fall in position n or later so recurse
				on right partition too*/
				quickfindFirstK(array, pivotNewIndex+1, right, n);
			}
		}
	}

	/**
	 * This partitions the portion of the array between indexes left and right, inclusively,
	 * by moving all elements equal or greater than array[pivotIndex] before the pivot,
	 * and the smaller elements after it.
	 *
	 * @param array
	 * @param left
	 * @param right
	 * @param pivotIndex
	 * @return
	 */
	private int partition(int[] array, int left, int right, int pivotIndex) {
		int pivotValue = array[pivotIndex];
		swap(array, pivotIndex, right);
		int storeIndex = left;
		for (int i=left; i < right; i++) {
			if (array[i] > pivotValue) {
				swap(array, i, storeIndex);
			    	storeIndex++;
			}
		}
		swap(array, storeIndex, right);
		return storeIndex;
	}

	/**
	 * Swap given indices values in an array
	 *
	 * @param array
	 * @param index 1
	 * @param index 2
	 */
	private void swap(int[] array, int i1, int i2) {
        int tmp = array[i1];
        array[i1] = array[i2];
        array[i2] = tmp;
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

		System.out.println("\nTop value is: ");
		System.out.println(findTopValues.findMaxValue(arr));
	}

}
