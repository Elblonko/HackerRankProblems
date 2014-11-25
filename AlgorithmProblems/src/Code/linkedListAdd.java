/**
 * Created by elblonko on 11/10/14.
 */
public class linkedListAdd {

    public static class  myNode{
        public myNode next = null;
        public int num = 0;

        myNode(int num){
            this.num = num;
        }

        public int addLists (myNode a,myNode b){
            int numA = 0;
            int numB = 0;

            if(b == null)
                return -1;

            myNode currA = a;
            myNode currB = b;

            //extract the numbers
            while(currA != null && currB != null){

                numA += currA.num;
                if(currB.next != null) {
                    numA = numA * 10;
                 }
                currA = currA.next;

                numB += currB.num;
                if(currB.next != null){
                    numB = numB *10;
                }
                currB = currB.next;
            }

            System.out.println("numberA: " +numA+ " numberB: " +numB);

            return (numA + numB);
        }
    }




    public static void main(String args[]){

        //Crate two node lists
        myNode hA = new myNode(3);
        hA.next = new myNode(1);
        hA.next.next = new myNode(5);

        myNode hB = new myNode(5);
        hB.next = new myNode(9);
        hB.next.next = new myNode(2);



        System.out.println(hA.num +" " + hA.next.num + " " +hA.next.next.num);
        System.out.println(hA.addLists(hA,hB));

    }
}
