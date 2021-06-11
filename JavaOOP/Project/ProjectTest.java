public class ProjectTest {
	public static void main(String[] args) {
		Project one = new Project();
		one.setName("Farm");
		System.out.println(one.getName());
		Project two = new Project("Wood Shop");
		two.setDesc("We make cuboards");
		System.out.println(two.getDesc());
		Project three = new Project("Vegetable store", "To sell vegetables!");
		System.out.println(three.elevatorPitch());

	}
}
