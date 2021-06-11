import java.util.Arrays;


public class BaseJavaTest {
	public static void main(String[] args) {
		// #1
		BaseJava.print1To255();
		// #2
		BaseJava.odd1To255();
		// #3
		BaseJava.sum0To255();
		// #4
		String[] arr = {"game","now","Hello"};
		Integer[] arr1 = {1,2,3,4};
		BaseJava.traverseArray(arr);
		BaseJava.traverseArray(arr1);
		// #5
		double[] arr5;
		arr5 = new double[5];
		arr5[0] = -1; 
		arr5[1] = 2; 
		arr5[2] = -5; 
		arr5[3] = 4; 
		arr5[4] = 0; 
		BaseJava.findMax(arr5);
		// #6
		double[] arr6 = {1.2, 5.5, 8, 12, 8.6}; 
		BaseJava.average(arr6);
		// #7
		BaseJava.oddArray();
		// #8
		double[] arr8 = {6,4,7,3,2,10};
		int counter = BaseJava.greaterThan(arr8, 4);
		System.out.println(counter);
		// #9
		double[] arr9 = {1,2,3,4,5,6,7,8,9,10};
		System.out.println(Arrays.toString(BaseJava.squared(arr9)));
		// #10
		int[] toZero = {1,5,0,-1,4,-8,0,-7};
		System.out.println(Arrays.toString(BaseJava.eliminateNegatives(toZero)));
		// #11
		double[] arr11 = {-1,5,4,8,6,12,7,2};
		System.out.println(Arrays.toString(BaseJava.maxMinAvg(arr11)));
		// #12
		double[] arr12 = {-1,5,4,8,6,12,7,2};
		System.out.println(Arrays.toString(BaseJava.shift(arr11)));
	}
}
