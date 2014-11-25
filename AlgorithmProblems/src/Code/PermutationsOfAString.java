/**
 * Created by elblonko on 11/7/14.
 */
public class PermutationsOfAString {


    public static void printAllPermutations(String s){
        char[] arrS = s.toCharArray();


        recPrintAllPerms(arrS, 0, "");
    }

    public static void recPrintAllPerms(char[] arrS, int start,String curr){

        if( start < arrS.length) {
            for (int i = start; i < arrS.length; i++) {

                //swap the current i to a new position
                char[] temp = new char[arrS.length];
                for (int j = 0; j < arrS.length; j++){
                    char charTemp = arrS[j];
                    temp[j] = charTemp;
                }
                temp[start] = temp[i];
                temp[i] = arrS[start];

                String newCurr = (curr + temp[start]);
                //System.out.println("Start: " +start+" To String " + curr);
                recPrintAllPerms(temp, (start + 1), newCurr);

            }
        }
        else{
            System.out.println(curr.toString());
        }
    }





    public static void main (String args[]){

        printAllPermutations("abc");
    }
}
