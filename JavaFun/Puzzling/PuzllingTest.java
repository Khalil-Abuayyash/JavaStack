import java.util.Arrays;
import java.util.ArrayList;

public class PuzllingTest {
    public static void main(String[] args) {
        // #1
        double[] arr = {3,5,1,2,7,9,8,13,25,32};
        System.out.println(Puzlling.sumAndGreater(arr));
        //#2
        ArrayList<String> names = new ArrayList<String>();
        names.add("Nancy");
        names.add("Jinichi");
        names.add("Fujibayashi");
        names.add("Momochi");
        names.add("Ishikawa");
        System.out.println(Puzlling.shuffleNames(names));
        // #3
        Puzlling.alphabet();
        // #4 and #5
        // System.out.println(Arrays.toString(Puzlling.tenRandoms()));
        System.out.println(Puzlling.tenRandoms());
        // # 6
        Puzlling.fiveStr();
        // #7
        System.out.println(Arrays.toString(Puzlling.tenWords()));
    }
}