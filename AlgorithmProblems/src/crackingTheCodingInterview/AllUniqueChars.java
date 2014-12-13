import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashSet;

/**
 * Created by elblonko on 11/24/14.
 */
public class AllUniqueChars {

    //Solve using a Hashtable
    public static boolean naiveAllUnique(String test){
        HashSet<Character> hash = new HashSet<Character>();

        for( Character c : test.toCharArray()){
            if( ! hash.contains(c) ){
                hash.add(c);
            }
            else{
                return false;
            }

        }
        return true;
    }

    public static boolean noStructAllUnique(String test){

        char[] arr = test.toCharArray();
        Arrays.sort(arr);

        for(int i = 1; i < arr.length; i++){
            if( arr[i] == arr[i-1]){
                return false;
            }
        }
        return true;

    }
    public static void main(String args[]){
        String test1 = "ABCDEF";
        String test2 = "ABCDEFA";
        System.out.println(naiveAllUnique(test1));
        System.out.println(naiveAllUnique(test2));
        System.out.println(noStructAllUnique(test1));
        System.out.println(noStructAllUnique(test2));

    }
}
