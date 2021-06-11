public class GreeterTest {
    public static void main(String[] args){
        Greeter grerter = new Greeter();
        String greeting = grerter.greet();
        String greetingWithName = grerter.greet("Eduardo");
        if (greeting.equals("Hello World") || greetingWithName.equals("Hello Eduardo")){
            System.out.println("Test successful");
        } else{
            System.out.println("Test Fail");
        }
    }
}