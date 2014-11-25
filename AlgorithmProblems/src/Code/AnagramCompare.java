import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by elblonko on 11/9/14.
 */
public class AnagramCompare implements  Comparator<String>{

        public String sortChars(String s) {
            char[] content = s.toCharArray();
            Arrays.sort(content);
            return new String(content);
        }

        public int compare(String s1, String s2) {

            return sortChars(s1).compareTo(sortChars(s2));
        }


    public static void main(String args[]){

        String[] array = {"apple", "banana", "carrot", "ele", "duck", "papel", "tarroc", "cudk", "eel", "lee"};

        Arrays.sort(array, new AnagramCompare());

        for (int i =  0; i < array.length; i++ ){
            System.out.print(array[i] + " ");
        }

    }


}

