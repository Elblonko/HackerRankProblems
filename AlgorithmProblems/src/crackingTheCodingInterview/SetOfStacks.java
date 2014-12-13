import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by elblonko on 11/25/14.
 */
public class SetOfStacks {

    private ArrayList<Stack<Integer>> stackList;
    private int maxStackLength;
    private int currStack;

    public SetOfStacks(){
        stackList = new ArrayList<Stack<Integer>>();
        //Create a new empty stack
        Stack stack1 = new Stack<Integer>();
        stackList.add(stack1);
        //default maxStackLength
        maxStackLength = 2;
        //current stack pointer
        currStack = 0;
    }

    public void push(int num){

        //check if max length is exceeded
        if( stackList.get(currStack).size() -1 >= maxStackLength   ){
            this.incrStack();
        }

        //add item to the stack
        stackList.get(currStack).push(num);
    }

    public int pop(){

        //check to see if curr stack is empty
        if( stackList.get(currStack).empty()){
            this.decStack();
        }

        //return the next element
        return stackList.get(currStack).pop();
    }

    public int popAt(int index){
        int ret;
        if(currStack < index){
            return -1;
        }
        else{
            ret = stackList.get(index).pop();
        }
        //now refill the stacks as appropriate
        if(index == currStack){
            return ret;
        }
        else{
            Stack<Integer> tempStack = new Stack<Integer>();
            //pop stack until equal to index
            while(currStack > index){
                tempStack.push(stackList.get(currStack).pop());
            }
            while(! tempStack.empty()){
                stackList.get(currStack).push(tempStack.pop());
            }
        }


        return ret;
    }

    public boolean isEmpty(){
        if(stackList.get(currStack).empty() && currStack == 0){
            return true;
        }
        else{
            return false;
        }
    }

    private void incrStack(){
        Stack<Integer> newStack = new Stack<Integer>();
        stackList.add(newStack);
        currStack++;
    }

    private void decStack(){
        stackList.remove(currStack);
        currStack--;
    }


    public static void main(String args[]){
        SetOfStacks test = new SetOfStacks();
        test.push(1);
        test.push(2);
        test.push(3);
        test.push(4);
        test.push(5);

        while(!test.isEmpty()){
            System.out.println(test.pop());
        }

        test.push(1);
        test.push(2);
        test.push(3);
        test.push(4);
        test.push(5);

        test.popAt(1);
        while(!test.isEmpty()){
            System.out.println(test.pop());
        }



    }




}
