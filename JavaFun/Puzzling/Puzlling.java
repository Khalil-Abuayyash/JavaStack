import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Puzlling {
    // #1
    public static ArrayList<Double> sumAndGreater(double[] numbers) {
        double sum = 0;
        ArrayList<Double> greaterThanTen = new ArrayList<Double>();
        for (int i = 0; i < numbers.length; i++) {
            sum += numbers[i];
            if (numbers[i] > 10) {
                greaterThanTen.add(numbers[i]);
            }
        }
        System.out.println(sum);
        return greaterThanTen;
    }

    // #2
    public static ArrayList<String> shuffleNames(ArrayList<String> names) {
        ArrayList<String> longNames = new ArrayList<String>();
        Collections.shuffle(names);
        for (String name : names) {
            System.out.println(name);
            if (name.length() > 5){
                longNames.add(name);
            }
        }
        return longNames;
    }

    // #3
    public static ArrayList<Character> alphabet() {
        ArrayList<Character> letters = new ArrayList<Character>();
        char letter = 'a';
        letters.add(letter);
        int number = letter;
        for (int i = 0; i < 25; i++) {
            number += 1;
            letter = (char) number;
            letters.add(letter);
        }
        Collections.shuffle(letters);
        System.out.println(letters.get(25));
        System.out.println(letters.get(0));
        if (letters.get(0) == 'a' || letters.get(0) == 'u' || letters.get(0) == 'e' || letters.get(0) == 'i' || letters.get(0) == 'o' ) {
            System.out.println("A vowel");
        }
        return letters;
    }

    // #4 and #5
    // public static int[] tenRandoms() {
    public static ArrayList<Integer> tenRandoms() {
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        // int[] numbers;
        // numbers = new int[10];
        Random r = new Random();
        for (int i = 0; i < 10; i++) {
            // numbers[i] = r.nextInt(45) + 55;
            numbers.add(r.nextInt(45) + 55);
        }
        Collections.sort(numbers);
        System.out.println(String.format("The Minimum is: %d",numbers.get(0)));
        System.out.println(String.format("The Maximum is: %d",numbers.get(9)));
        return numbers;
    }

    // #6
    public static String fiveStr() {
        // ArrayList<String> str = new ArrayList<String>();
        String str = "";
        Random r = new Random();
        ArrayList<Character> letters = alphabet();
        for (int i = 0; i < 5; i++) {
            str = str + letters.get(r.nextInt(25));
        }
        System.out.println(str);
        return str;
    }

    //#7
    public static String[] tenWords() {
        String[] words;
        words = new String[10];
        for (int i = 0; i < 10; i++) {
            words[i] = fiveStr();
        }
        return words;
    }
}