/**
 * Created by elblonko on 9/30/14.
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class UtopiaTree {

    private ArrayList<Integer> treeHeights;
    private ArrayList<Integer> cycleNumbers;
    private int numTrails;

    public UtopiaTree(ArrayList<Integer> cycleNumbers, int numTrails){
        this.cycleNumbers = cycleNumbers;
        this.numTrails = numTrails;
        treeHeights = new ArrayList<Integer>(60);
    }

    public int findMax(){
        int max = 0;
        for(int curr: this.cycleNumbers){
            if ( curr > max){
                max = curr;
            }
        }
        return max;
    }

    public int Monsoon(int height){
        return height *2;
    }

    public int Summer(int height){
        return height + 1;
    }

    public void CalcHeights(int maxCycle){
        //currrents height
        int currHeight = 1;
        //take care of initial case
        treeHeights.add(0,currHeight);

        for (int i = 1; i <= maxCycle; i++){

            //if odd cycle equals Monsoon
            if( i % 2 == 0){
                currHeight = Summer(currHeight);
                treeHeights.add(i, currHeight);
            }
            else{
                currHeight = Monsoon(currHeight);
                treeHeights.add(i,currHeight);
            }
        }
    }

    public int getHeight(int cycleNum){
        if( cycleNum > this.treeHeights.size()){
            System.out.print("Error cycle Number larger than calculated heights");
            return -1;
        }

        return treeHeights.get(cycleNum );
    }

    public ArrayList<Integer> getCycleNumbers(){
        return this.cycleNumbers;
    }


    public static void main(String[] args){
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));

        ArrayList<Integer> input = new ArrayList<Integer>();


        try {
            //get the T
            input.add(Integer.parseInt(br.readLine()));

            for(int i = 1; i < input.get(1); i++){
                input.add(Integer.parseInt(br.readLine()));
                if(i >= 10){
                    System.out.println("Error to many cycles");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        int maxNum = input.get(0);

        UtopiaTree tree = new UtopiaTree(input,maxNum);

        tree.CalcHeights(maxNum);

        for(int i = 1; i < input.size() -1; i++){
            System.out.println(tree.getHeight(input.get(i)));
        }


    }
}
