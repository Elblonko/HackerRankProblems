/**
 * Created by elblonko on 10/25/14.
 */
public class PracticeMicrosoft {


    public static int isSubstring(String s, String sub){
        int front = 0; int back = s.length() -1;
        boolean flag = true;


        for (; front < s.length(); front ++ ,back--){


            for(int i = front, tempSub = 0; tempSub < sub.length(); tempSub++, i++ ){
                if(s.charAt(i) != sub.charAt(tempSub) ){
                    flag = false;
                    break;
                }
            }
            if(flag){
                System.out.println("front is" + front);
                return front;
            }
            flag = true;

            for(int tempBack = back, subTemp = sub.length() -1 ; subTemp >= 0 && tempBack >= 0; subTemp--, tempBack--){
                if(s.charAt(tempBack) != sub.charAt(subTemp)){
                    flag = false;
                    break;
                 }
                if(flag) {
                    return (back - sub.length());
                }
                flag = true;
            }
        }
        return -1;
    }

    public static int[][] replace1With(int[][] input){

        //get the lengths, and find which is longer
        int rowLength = input.length;
        int colLength = input[0].length;
        boolean[] dominate;

        if(colLength > rowLength){
            dominate = new boolean[colLength];
        }
        else {
            dominate = new boolean[rowLength];
        }

        for(int r = 0; r < rowLength; r++){
            //skip if row already has a one in it
            if(dominate[r] == true){
                continue;
            }


            for(int c= 0; c < colLength; c++){
                //skip if column already has a 1 in it
                if(dominate[c] == true){
                    break;
                }
                if( input[r][c] == 1){
                    dominate[c] = true;
                    dominate[r] = true;
                }
            }

        }

        //Now fill the matrix
        for(int r = 0; r < rowLength; r++){

            for(int c = 0; c < colLength; c++){
                if(dominate[r] || dominate[c]){
                    input[r][c] = 1;
                }
            }
        }

    return input;


    }

    public static void main (String args[]) {

        System.out.println("Print is substrings");
        System.out.println(isSubstring("rawrcookies", "ooki"));
        System.out.println(isSubstring("bobisshitty", "fuck"));

        int[][] multi = new int[][]{
                { 1, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }
        };

        multi = replace1With(multi);

        for(int r = 0; r < multi.length; r++){

            System.out.println();

            for(int c = 0; c < multi[0].length; c++){
                System.out.print(multi[r][c] + " ");
            }
        }

    }
}
