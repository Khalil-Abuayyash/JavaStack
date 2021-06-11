import java.util.ArrayList;

public class ListOfExceptions {
    public static void main(String[] args) {
        ArrayList<Object> myList = new ArrayList<Object>();
        myList.add("13");
        myList.add("hello world");
        myList.add(48);
        myList.add("Goodbye World");

        for(int i = 0; i < myList.size(); i++) {
            try {
                Integer castedValue = (Integer) myList.get(i);
                System.out.println("An Integer");
                System.out.println( myList.get(i) + " : " + castedValue);
            }
            catch (ClassCastException e) {
                try {
                    Integer castedValue =Integer.valueOf((String) myList.get(i));
                    System.out.println("A number stored as a string");
                    System.out.println( myList.get(i) + " : " + castedValue);
                }
                catch (NumberFormatException er){
                    System.out.println("A string");
                    System.out.println( myList.get(i));
                }  
            }  
        }
    }
}