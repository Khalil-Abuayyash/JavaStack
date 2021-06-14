public class HumanTest {
	public static void main(String[] args) {
		Human Maen = new Human();
		Human Khalil = new Human();
		Samurai Adam = new Samurai();
		Khalil.attack(Maen);
		System.out.println(Maen.health);
		System.out.println(Samurai.howMany());
	}
}
