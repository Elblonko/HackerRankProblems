import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by elblonko on 11/24/14.
 */

/*
Consider prefixes
Define c[i,j] = | LCS x[1-i] , y[1-j] |

theorem:
c[i,j] = c[i-1.j-1] if x[i]=y[j]
       = max{c[i,j-1], c[i-1,j]}
 */
public class LongestCommonSubSeq {


    //Find the length of the LCS
    public static int solveLCS(String x, String y)
    {
        int i, j;
        int[][] K = new int[x.length()+1][y.length()+1];

      /* ===============================================
         Initialize the base cases
	     ===============================================*/
      for (j = 0; j < y.length()+1; j++)
         K[1][j] = 0;        // x = "" ===> LCS = 0


      for (i = 1; i < x.length()+1; i++)
      {
         /* =====================================================
            Recycle phase: copy row K[1][...] to row K[0][...]
	        ===================================================== */
        for ( j = 0; j < y.length()+1; j++)
            K[0][j] = K[1][j];


        K[1][0] = 0;

        for (j = 1; j < y.length()+1; j++)
        {
            if ( x.charAt(i-1) == y.charAt(j-1) )
            {
                K[1][j] = K[0][j-1] + 1;
            }
            else
            {
                K[1][j] = Math.max(K[0][j], K[1][j - 1]);
            }
        }
    }
    // The value of LCS is in K[1][y.length()]
    return K[1][y.length()];
}

    public static String findLCS_String(String x, String y)
    {
        int mid, i, j;
        int m, n;
        String C = "";

        m = x.length();           // m = length of x
        n = y.length();           // n = length of y


      /* =====================================================
         Base case 1: ""
         ===================================================== */
        if ( m == 0 )
        {
            return "";             // LCS = ""
        }

      /* =====================================================
         Base case 2: x = "?"
         ===================================================== */
        if ( m == 1 )
        {
         /* =====================================
            The input x consists of 1 character
            Find the single common character in y
            ===================================== */
            for ( i = 0; i < n; i++ )
                if ( y.charAt(i) == x.charAt(0) )
                    return( x );                   // Found: LCS = x

            return "";                           // Not found: LCS = ""
        }

      /* =====================================================
         General case:  x has 2 or more characters
         ===================================================== */

        String x1="", x2="";          // x1 = first half of x, x2 = second half
        int    c1=0,  c2=0;           // c1 = length of first LCS, c2 = second

        int c = solveLCS( x, y ) ;    // This is the sum of the correct split

        x1 = x.substring( 0, m/2 );   // First half of x
        x2 = x.substring( m/2, m );   // Second half of x

      /* --------------------------------------------------
         Find a correct split of y
         -------------------------------------------------- */
        int k = 0;
        for ( k = 0; k < n; k++ )
        {
            c1 = solveLCS( x1, y.substring(0, k) ) ; // LCS of first half
            c2 = solveLCS( x2, y.substring(k, n) ) ; // LCS of second half

            if ( c1 + c2 == c )
                break;             // Found a correct split of y !!!
        }

      /* --------------------------------------------------
         Here: k = a correct split location of y ....

         Solve smaller problems
         -------------------------------------------------- */

        String y1 = y.substring( 0, k );
        String y2 = y.substring( k, n );

        String sol1 = findLCS_String( x1, y1 );
        String sol2 = findLCS_String( x2, y2 );

      /* ------------------------------------------------------------
         Use solution of smaller problems to solve original problem
         ------------------------------------------------------------ */
        return ( sol1 + sol2 );
    }

    public static ArrayList<Integer> LCSfinder(ArrayList<Integer> v, ArrayList<Integer> u) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        int lastchecked = 0;

        for(int iu = 0; iu < u.size(); iu++) {
            for(int iv = lastchecked; iv < v.size(); iv++) {
                if(iu >= u.size())
                    break;
                if(u.get(iu) == v.get(iv)) {
                    iu++;
                    res.add(v.get(iv));
                    lastchecked = iv+1;
                }
            }

        }

        return res;
    }




    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);

        //get length of Seq A
        int n = sc.nextInt();
        //get length of Seq B
        int m = sc.nextInt();

        //Create lists A and B
        ArrayList<Integer> a = new ArrayList<Integer>();
        ArrayList<Integer> b = new ArrayList<Integer>();

        //Fill lists
        for (int i = 0; i < n; i ++){
            a.add(sc.nextInt());
        }

        for (int i = 0; i < m; i++){
            b.add(sc.nextInt());
        }
        ArrayList<Integer> print = LCSfinder(a,b);
        for( int i : print){
            System.out.print(i + " ");
        }

        //Test if the arrays are correct
//        for(int i : a){
//            System.out.print(i + " ");
//        }
//        System.out.println();
//        for(int i : b){
//            System.out.print(i + " ");
//        }


        //TESTER
//        String x = "AGGTAB";
//        String y = "GXTXAYB";
//        char[] X = x.toCharArray();
//        char[] Y = y.toCharArray();
//
//        int m = x.length();
//        int n = y.length();
//
//        System.out.println("Length of LCS is " + solveLCS(x, y));
//
//        System.out.println("The LCS is " + findLCS_String(x, y));
    }

}
