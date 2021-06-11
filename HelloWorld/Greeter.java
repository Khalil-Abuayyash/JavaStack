public class Greeter {

    private String createGreeting(String toBeGreeted){
        return "Hello " + toBeGreeted;
    }

    public String greet(){
    return createGreeting("World");
    }
    
    public String greet(String firstName, String lastName){
        return createGreeting(firstName + " " + lastName)
    }

    public String greet(String name){
        return "Hello " + name;
    }
}