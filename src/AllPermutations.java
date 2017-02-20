
public class AllPermutations {
	/*
	 * numbers are unique
	 */
	public static void main(String[] args) {
		int[] array = new int[] { 1, 2, 3, 4 };
		boolean isThereSameNumbers = false;
		for (int i = 0; i < array.length; i++) {
			for (int j = i + 1; j < array.length; j++) {
				if (array[i] == array[j]) {
					isThereSameNumbers = true;
					break;
				}
			}
			if (isThereSameNumbers) {
				break;
			}
		}
		if (isThereSameNumbers) {
			System.out.println("Please enter only unique numbers.");
		} else {
			perpermutations(array);
		}
	}

	public static void perpermutations(int[] arr) {
		permutationHelper(arr, 0);
	}

	private static void permutationHelper(int[] arr, int index) {
		// If we are at the last element - nothing left to permute
		if (index >= arr.length - 1) { 
			// Print the array
			System.out.print("[");
			for (int i = 0; i < arr.length - 1; i++) {
				System.out.print(arr[i] + ", ");
			}
			if (arr.length > 0)
				System.out.print(arr[arr.length - 1]);
			System.out.println("]");
			return;
		}
		// For each index in the sub array arr[index...end]
		for (int i = index; i < arr.length; i++) { 
			// Swap the elements at indices index and i
			swap(arr, index, i);
			// Recurse on the sub array arr[index+1...end]
			permutationHelper(arr, index + 1);

			// Swap the elements back
			swap(arr, index, i);

		}
	}

	private static void swap(int[] array, int firstIndex, int secondIndex) {
		int temp = array[firstIndex];
		array[firstIndex] = array[secondIndex];
		array[secondIndex] = temp;
	}
}
