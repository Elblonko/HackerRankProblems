/**
 * Created by elblonko on 11/7/14.
 */
public class MergeAToB {


    public static void sortAB(int[] a, int[] b, int la, int lb){
        int totL = la + lb +1;

        while (la != 0 && lb != 0){

            if(a[la] > b[lb]){
                System.out.println("current position " + la);
                a[totL] = a[la];
                la = la -1;
                totL = totL -1;
            }
            else {
                a[totL] = b[lb];
                lb = lb -1;
                totL = totL -1;
            }
        }

        //Fill in rest of a
        while ( lb >=0){
            a[totL] = b[lb];
            totL = totL -1;
            lb = lb -1;
        }

        if(a[0] > a[1]){
            int temp = a[0];
            a[0] = a[1];
            a[1] = temp;
        }

    }


    public static void main(String args[]){


        int[] a = {2,4,6,9,10,0,0,0,0,0,0};
        int[] b = {1,3,5,7,8,11};
        sortAB(a,b,4,5);
        for(int i = 0; i < a.length; i++)
        System.out.println(a[i]);

        //call to functin

    }


}
