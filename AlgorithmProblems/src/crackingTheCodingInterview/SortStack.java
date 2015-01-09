import java.util.Stack;

/**
 * Created by elblonko on 1/7/15.
 */
public class SortStack {

    public static void sort(Stack<Integer> unsorted){
        Stack<Integer> temp = new Stack<Integer>();

        while(!unsorted.empty()){

            int curr = unsorted.pop();
            if(temp.empty() ){
                temp.push(curr);
            }
            else if ( temp.peek() >= curr){
                temp.push(curr);
            }
            else {
                while (temp.peek() < curr) {
                    unsorted.push(temp.pop());

                    if (temp.isEmpty()) {
                        temp.push(curr);
                        break;
                    }
                }
            }
        }
        while ( ! temp.empty()){
            unsorted.push(temp.pop());
        }
    }

    public static void main(String args[]){

        Stack<Integer> tester = new Stack<Integer>();
        tester.push(3);
        tester.push(100);
        tester.push(1);
        tester.push(57);
        tester.push(7);

        sort(tester);

        while ( ! tester.empty()){
            System.out.println(tester.pop());
        }

    }
}
