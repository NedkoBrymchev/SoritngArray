import java.util.Random;

public class KthBiggest {
	public static int K;

	public static void main(String[] args) {
		int[] array = {43, 56, 12, 760, 58, 8, 50, 85, 53, 87, 4,56};
		// it is a random because of testing
		K = new Random().nextInt(array.length + 1) + 0;
		/*
		 * check if K is negative or bigger than the number of the elements in
		 * the array and if not call the method
		 */
		if (K > array.length) {
			System.out.println("K is bigger than the number of elements in the array");
		} else if (K <= 0) {
			System.out.println("K must be positive");
		} else {
			System.out.println("The " + K + " biggest number is " + biggestKthElement(array, 0, array.length - 1, K));
		}
	}

	public static int biggestKthElement(int[] array, int lowestIndex, int highestIndex, int k) {
		// if there is only one element and we want the biggest return the only
		// element of the array
		if (array.length == 1 && k == 1) {
			return array[0];
		}
		// if we want the biggest element iterates the array only one time and
		// return the biggest element
		else if (k == 1 && array.length > 1) {
			int max = array[0];
			for (int i = 1; i < array.length; i++) {
				if (max < array[i]) {
					max = array[i];
				}
			}
			return max;
		}
		// if the biggest K we want is equal to the number of elements in the
		// array it means we want the smallest element
		else if (k == array.length) {
			int min = array[0];
			for (int i = 1; i < array.length; i++) {
				if (min > array[i]) {
					min = array[i];
				}
			}
			return min;
		} else {
			/*
			 * using the way of quick sort,we separate the array on two
			 * parts,and find where our K should be,in the left part,where are
			 * the smaller than the pivot numbers or in the right part where are
			 * the bigger than pivot numbers. Also we choose our pivot on
			 * random. And after the first separation,there are different cases.
			 */
			Random rand = new Random();
			int pivotIndex = lowestIndex + rand.nextInt(highestIndex - lowestIndex);
			//find the right place for our pivot
			int newPivotIndex = partition(array, lowestIndex, highestIndex, pivotIndex);

			/*
			 * if k is smaller than array.length - newPivotIndex(that gave us that K must be bigger 
			 * by value than the element on the newPivotIndex position) so K is in the right part
			 */
			if (array.length - newPivotIndex > k) {
				//call our method with new indexes
				return biggestKthElement(array, newPivotIndex+1,highestIndex , k);
			} else if (array.length - newPivotIndex == k) {

				return array[newPivotIndex];
			} else {
				/*
				 * if k is bigger than array.length - newPivotIndex(that gave us that K must be smaller 
				 * by value than the element on the newPivotIndex position) so K is in the left part
				 */
				
				//call our method with new indexes
				return biggestKthElement(array, lowestIndex, newPivotIndex, k);
			}

		}

	}
	/*
	 * method that separate the array
	 */
	public static int partition(int[] array, int lowestIndex, int highestIndex, int pivotIndex) {
		int pivotValue = array[pivotIndex];
		int index = lowestIndex;
		swap(array, pivotIndex, highestIndex);
		for (int i = lowestIndex; i < highestIndex; i++) {
			if (array[i] <= pivotValue) {
				swap(array, i, index);
				index++;
			}
		}
		swap(array, highestIndex, index);
		return index;

	}
	/*
	 * method that swap two elements of the array
	 */
	private static void swap(int[] array, int firstIndex, int secondIndex) {
		int temp = array[firstIndex];
		array[firstIndex] = array[secondIndex];
		array[secondIndex] = temp;
	}
}
