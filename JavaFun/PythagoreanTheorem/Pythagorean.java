public class Pythagorean {
	public static double calculateHypotenuse(int legA, int legB) {
		double squaredHypotenuse = legA * legA + legB * legB;
		double hypotenuse = Math.sqrt(squaredHypotenuse);
		return hypotenuse;
	}
}

