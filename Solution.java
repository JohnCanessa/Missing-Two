import java.util.Random;

/*
 * 
 */
public class Solution {

	// **** to add variety to the test ****
	static Random rand = new Random();

	/*
	 * Instantiate and populate the array. Array start with number 1.
	 */
	static int[] populateArray(int size, int count, boolean consecutive) {

		// **** ****
		int[] arr = new int[size];

		// **** determine first missing number ****
		int f = 1 + rand.nextInt(size - 2);
		int s = Integer.MAX_VALUE;

		// **** determine the second missing number (if needed) ****
		if (count == 2) {
			if (consecutive)
				s = f + 1;
			else {
				s = (f + 1) + rand.nextInt(size - f - 1);
			}
		}

		// ???? ????
		System.out.print("populateArray <<< f: " + f);
		if (count == 2)
			System.out.print(" s: " + s);
		System.out.println();

		// **** populate the array ****
		int val = 1;
		for (int i = 0; i < arr.length; i++, val++) {

			// **** ****
			if (val == f) {
				val++;
				if (val == s)
					val++;
				arr[i] = val;
				continue;
			}

			// **** ****
			if (val == s) {
				val++;
				arr[i] = val;
				continue;
			}

			// **** ****
			arr[i] = val;
		}

		// **** return array with missing numbers(s) ****
		return arr;
	}

	/*
	 * Find one or two missing number(s) in the specified array.
	 */
	static int[] missingNumbers(int[] arr) {

		// **** array holding one or two missing number(s) ****
		int[] missing = { -1, -1 };

		int f = -1;
		int s = -1;

		// **** traverse array (only once) ****
		for (int i = 0; i < arr.length; i++) {

			// **** check for first missing number (if needed) ****
			if (f == -1) {
				if ((i + 1) != arr[i]) {
					f = i + 1;
				}
			}

			// **** check for second missing number (if needed) ****
			if ((f != -1) && (s == -1)) {
				if ((i + 2) != arr[i]) {
					s = i + 2;
					break;
				}
			}
		}

		// **** populate the missing number(s) ****
		missing[0] = f;
		missing[1] = s;

		// **** ****
		return missing;
	}

	/*
	 * Test scaffolding.
	 */
	public static void main(String[] args) {

		// **** ****
		final int MAX_ARRAY_LENGTH = 23;
		final int MIN_ARRAY_LENGTH = 5;

		// **** determine the array size ****
		int size = MIN_ARRAY_LENGTH + rand.nextInt(MAX_ARRAY_LENGTH - MIN_ARRAY_LENGTH);

		// ???? ????
		System.out.println("main <<< size: " + size);

		// ***** determine number of missing values ****
		int count = 1 + rand.nextInt(2);

		// ???? ????
		System.out.println("main <<< count: " + count);

		// **** determine if missing value(s) are consecutive ****
		boolean consecutive = rand.nextBoolean();

		// ???? ????
		if (count == 2)
			System.out.println("main <<< consecutive: " + consecutive);

		// **** populate the array ****
		int[] arr = populateArray(size, count, consecutive);

		// ???? ????
		System.out.print("main <<< arr: [");
		for (int i = 0; i < arr.length; i++) {
			if (i + 1 < arr.length)
				System.out.print(arr[i] + ", ");
			else
				System.out.print(arr[i]);
		}
		System.out.println("] length: " + arr.length);

		// **** find missing values ****
		int[] missing = missingNumbers(arr);

		// **** display missing number(s) ****
		System.out.print("main <<< missing: " + missing[0]);
		if (missing[1] >= 1)
			System.out.println(", " + missing[1]);
		System.out.println();
	}

}
