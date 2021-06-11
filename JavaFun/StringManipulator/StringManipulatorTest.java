public class StringManipulatorTest {
	public static void main(String[] args) {
		StringManipulator manipulator = new StringManipulator();
		System.out.println(manipulator.trimAndConcat("Hello","World"));
		System.out.println(manipulator.getIndexOrNull("Hello", 'l'));
		System.out.println(manipulator.getIndexOrNull("Hello", 'a'));
		System.out.println(manipulator.getIndexOrNull("Hello", "llo"));
		System.out.println(manipulator.getIndexOrNull("Hello", "lw"));
		System.out.println(manipulator.concatSubstring("Hello", 1, 2, "World"));
	}
}
