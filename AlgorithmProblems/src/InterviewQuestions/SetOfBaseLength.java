package AlgorithmProblems.src.InterviewQuestions;

import java.io.StringReader;
import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by elblonko on 1/8/15.
 */
/*
This question was given to me by Microsoft,
Question:
Given a Base and a Length store the set of all possible numbers
Example:
Base 3, Length 2: Max = 22 min 00
Base 10, Length 4: Max 9999 min 0000
 */
public class SetOfBaseLength {

    public static ArrayList<String> generatePossibleSet(int base, int length){
        ArrayList<String> ret = new ArrayList<String>();

        for(int l = 1; l <= length; l++){
            ArrayList<StringBuilder> curr = new ArrayList<StringBuilder>();

            for(int b = 0; b < base; b++ ){
                curr.set(b, new StringBuilder());

                for(int ofLength = l; ofLength > 0; ofLength--){
                    for(int num = 0; num < base; num++);
                    //curr.get(b).append();
                }

            }
        }
        return ret;

    }


    public static void main( String args[]){
        ArrayList<String> test;
        test = generatePossibleSet(2,2);
        for (String item: test){
            System.out.println(item);
        }

    }
}
