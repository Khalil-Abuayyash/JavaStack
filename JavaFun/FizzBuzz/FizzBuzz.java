public class FizzBuzz  {
	public static String fizzBuzz(int number) {
		String str = String.format("%o", number);
		// if a number is divisible by 3 and 5 then it is divisible by 15.
		if (number % 15 == 0) {
			str = "FizzBuzz";
		}
		else if (number % 5 == 0) {
			str = "Buzz";
		}
		else if (number % 3 == 0) {
			str = "Fizz";
		}

		return str;
	}
}
