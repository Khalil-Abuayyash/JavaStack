public class PythagoreanTest {
	public static void main(String[] args) {
		try {
			int num1 = Integer.parseInt(args[0]);
			int num2 = Integer.parseInt(args[1]);
			double result = Pythagorean.calculateHypotenuse(num1, num2);
			System.out.println(result);
		} 
		catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("You should enter just two arguments not more or less");
			System.out.println("Example: Java PythagoreanTest 3 4");
		}
		catch (NumberFormatException e) {
			System.out.println("You should enter numbers only");
			System.out.println("Example: Java PythagoreanTest 3 4");
		}

		// int num1 = Integer.parseInt(args[0]);
		// int num2 = Integer.parseInt(args[1]);
		// double result = Pythagorean.calculateHypotenuse(num1, num2);
		// System.out.println(result);
	}
}

