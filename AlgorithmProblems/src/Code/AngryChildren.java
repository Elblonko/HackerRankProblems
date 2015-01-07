import java.util.*;

/**
 * Created by elblonko on 1/5/15.
 *
 * Problem Statement

 Bill Gates is on one of his philanthropic journeys to a village in Utopia. He has N packets of candies and would like to distribute one packet to each of the K children in the village (each packet may contain different number of candies). To avoid any fighting among the children, he would like to pick K out of N packets, such that unfairness is minimized.

 Suppose the K packets have (x1, x2, x3,....xk) candies in them, where xi denotes the number of candies in the ith packet, then we define unfairness as

 max(x1,x2,...xk) - min(x1,x2,...xk)

 where max denotes the highest value amongst the elements, and min denotes the least value amongst the elements. Can you figure out the minimum unfairness and print it?

 Input Format
 The first line contains an integer N.
 The second line contains an integer K. N lines follow. Each line contains an integer that denotes the candy in the nth (1≤n≤N) packet.

 Output Format
 An integer that denotes the minimum possible value of unfairness.

 Constraints
 1<=N<=105
 1<=K<=N
 0<= number of candies in any packet <=109
 */
public class AngryChildren {

    /*
        Need to find the max and min element of a set of K with the min distance. From here fill in the elements between them.
        Subproblem:
            find a max and a min with K-2 bags between them

        Equation:
        Max(K@i) - Min(K@j) = Min Fairness
     */

/*
    public static void main(String args[]) {
        boolean DEBUG = true;
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();

        //get array of bags of candies
        int[] bags = new int[N];
        for (int i = 0; i < N; i++) {
            bags[i] = sc.nextInt();
        }

        if(DEBUG){
            System.out.println("Printing input array bags");
            for(int bag : bags){
                System.out.print(bag + " ");
            }
            System.out.println();
        }

        int bestFairness = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            if( i + K > N ){
                break;
            }
            ArrayList<Integer> temp = new ArrayList<Integer>();
            temp.add(bags[i]);

            for (int j = i + 1; j < N; j++) {
                //Fill the ArrayList to size of K
                if (temp.size() < K) {
                    temp.add(bags[j]);
                }
                //Now minimize the distance between item 1 and the rest of the list
                else {
                    for (int k = 1; k < K; k++) {
                        //if the current element has less of a distance from the first than any other replace
                        if(DEBUG){
                            System.out.println("Comparing: " + temp.get(0) + " - " + bags[j] + " < " + temp.get(0) + " - " + temp.get(k));
                        }
                        if ( Math.abs(temp.get(0) - bags[j]) <  Math.abs(temp.get(0) - temp.get(k)) ) {
                            if(DEBUG)
                                System.out.println("COMPARISON TRUE");
                            temp.remove(k);
                            temp.add(bags[j]);
                            //must break so you don't add the same element more than once
                            break;
                        }
                    }
                }
            }

            if(DEBUG){
                System.out.println("Printing the current contents of the temp array");
                for( Integer item : temp){
                    System.out.print(item + " ");
                }
                System.out.println();
            }

            //Now compare the min array at element i with the current minArray for fairness
            int currFairness = Collections.max(temp) - Collections.min(temp);
            if (currFairness < bestFairness) {
                bestFairness = currFairness;
            }
        }
        System.out.println(bestFairness);
    }
    */

    public static void main (String args[]){
        boolean DEBUG = true;
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();

        //get array of bags of candies
        int[] bags = new int[N];
        for (int i = 0; i < N; i++) {
            bags[i] = sc.nextInt();
        }

        //sort the array such that we are dealing with finding min and max points to solve Fairness
        Arrays.sort(bags);

        if(DEBUG){
            System.out.println("Printing input array bags");
            for(int bag : bags){
                System.out.print(bag + " ");
            }
            System.out.println();
        }



        //Fairness is equal to max - min over some K distance
        int fairness = Integer.MAX_VALUE;
        for (int i = 0; i < N ; i++){
            if((i + K) >= bags.length)
                break;
            else {
                int min = bags[i];
                int max = bags[i + (K-1)];
                int tempFairness = max - min;

                if (DEBUG) {
                    System.out.println("Min: " + min + "Max: " + max + "Fairness: " + fairness + "tempFairness: " + tempFairness);
                }

                if (tempFairness < fairness) {
                    fairness = tempFairness;
                }
            }
        }
        System.out.println(fairness);
    }
}
