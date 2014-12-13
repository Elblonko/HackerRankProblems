import java.util.HashSet;
import java.util.Iterator;

/**
 * Created by elblonko on 11/24/14.
 */
public class RemoveDup {

    public static class Node{
        public String data;
        public Node next;
        public Node previous;

        public Node(String newData, Node newNext, Node newPrevious){
            data = newData;
            next = newNext;
            previous = newPrevious;

        }

        public void remove(){
            if (this.next !=null) {
                Node tempNext = this.next;
                this.previous.next = tempNext;
                tempNext.previous = this.previous;
            }
            else{
                this.previous.next = null;
                this.previous = null;
            }

        }
    }

    public static class LinkedList {
        public Node head;
        public Node tail;

        public LinkedList(String newList) {
            head = new Node(newList, null, null);
        }

        public void add(String newItem) {

            Node n = new Node(newItem, null, this.tail);
            if (head.next == null) {
                head.next = n;
            } else {
                tail.next = n;
            }
            tail = n;
        }

        public void tailUpdate(){
            Node curr = head;

            while(curr.next != null){
                curr = curr.next;
            }
            tail = curr;
        }


    }



    public static void removeDup(LinkedList list){
        Node curr = list.head;
        HashSet<String> checker = new HashSet<String>();

        while(curr != null){
            if(! checker.contains(curr.data)){
                checker.add(curr.data);
            }
            else{
                curr.remove();
            }
            curr = curr.next;
        }

    }




    public static void main(String args[]){
        LinkedList test = new LinkedList("a");
        test.add("b");
        test.add("c");
        test.add("d");

        test.head.next.next.next.remove();
        test.tailUpdate();
        Node iterator = test.head;
        while(iterator != null){
            System.out.println(iterator.data);
            iterator = iterator.next;
        }

        test.add("d");
        test.add("a");
        System.out.println("Added d and a");
        iterator = test.head;
        while(iterator != null){
            System.out.println(iterator.data);
            iterator = iterator.next;
        }
        System.out.println("Removing duplicates");
        removeDup(test);
        iterator = test.head;
        while(iterator != null){
            System.out.println(iterator.data);
            iterator = iterator.next;
        }



    }
}
