import java.util.ArrayList;

/**
 * Created by elblonko on 1/8/15.
 */
public class PermutationsOfStrings {

    public static ArrayList<String> getPermutationsStrings(String orig) {

        ArrayList<String> perms = new ArrayList<String>();

        if (orig == null) {
            return null;
        } else if (orig.length() == 0) {
            perms.add("");
            return perms;
        }


        char first = orig.charAt(0);
        String remainder = orig.substring(1);
        ArrayList<String> words = getPermutationsStrings(remainder);

        for (String word : words) {
            for (int j = 0; j <= word.length(); j++) {
                perms.add(insertCharAt(word, first, j));
            }
        }

        return perms;
    }
    public static String insertCharAt(String word, char c, int i) {
        String start = word.substring(0, i);
        String end = word.substring(i);
        return start + c + end;
    }


    public static void main(String[] args) {
        ArrayList<String> list = getPermutationsStrings("abcde");
        System.out.println("There are " + list.size() + " permutations.");
        for (String s : list) {
            System.out.println(s);
        }
    }
}
