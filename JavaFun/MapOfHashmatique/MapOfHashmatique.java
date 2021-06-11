import java.util.HashMap;
import java.util.Set;

public class MapOfHashmatique {
    public static void main(String[] args) {
        HashMap<String, String> hashmatique = new HashMap<String, String>();
        hashmatique.put("Holm", "law kont nghamed");
        hashmatique.put("Ma lqeet", "ma kqeet haja wahda itfaser manna illi sayer");
        hashmatique.put("Asela berasi", "fee asela berasi 3ank 3an elhara");
        hashmatique.put("In An", "wa eshabee ketar bel jalama");
        hashmatique.get("Asela berasi");
        Set<String> keys = hashmatique.keySet();
        for (String key : keys) {
            System.out.println(key+ " : " + hashmatique.get(key));
        }
    }
}