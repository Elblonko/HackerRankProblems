import java.util.ArrayList;
import java.util.List;

/**
 * Created by elblonko on 11/10/14.
 */

/*
Following are the steps to find all prime factors.
1) While n is divisible by 2, print 2 and divide n by 2.
2) After step 1, n must be odd. Now start a loop from i = 3 to square root of n. While i divides n, print i and divide n by i, increment i by 2 and continue.
3) If n is a prime number and is greater than 2, then n will not become 1 by above two steps. So print n if it is greater than 2.
 */
public class PrimeFactorization {

    public static List<Integer> findPrimeFactors(int num) {


        int curr = num;
        //List to return Primes
        ArrayList<Integer> ret = new ArrayList<Integer>();

        for (int i = 2; i <= curr / i; i++) {

            while (curr % i == 0) {
                ret.add(i);
                curr = curr / i;
            }

        }
        if (curr > 1) {
            ret.add(curr);
        }

        return ret;
    }




    public static void main(String args[]){
        System.out.println("Primefactors of 44");
        for (Integer integer : findPrimeFactors(44)) {
            System.out.println(integer);
        }
        System.out.println("Primefactors of 3");
        for (Integer integer : findPrimeFactors(3)) {
            System.out.println(integer);
        }
        System.out.println("Primefactors of 32");
        for (Integer integer : findPrimeFactors(32)) {
            System.out.println(integer);
        }


    }
}
