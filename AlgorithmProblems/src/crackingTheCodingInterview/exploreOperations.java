import java.util.*;

/**
 * Created by elblonko on 11/28/14.
 */
public class exploreOperations {
    public enum State {
        Unvisited, Visited, Visiting;
    }

    class Node {
        private Node adjacent[];
        public int adjacentCount;
        private String vertex;
        public State state;
        public Node(String vertex, int adjacentLength) {
            this.vertex = vertex;
            adjacentCount = 0;
            adjacent = new Node[adjacentLength];
        }

        public void addAdjacent(Node x) {
            if (adjacentCount < 30) {
                this.adjacent[adjacentCount] = x;
                adjacentCount++;
            } else {
                System.out.print("No more adjacent can be added");
            }
        }
        public Node[] getAdjacent() {
            return adjacent;
        }
        public String getVertex() {
            return vertex;
        }
    }


    public class Graph {
        private Node vertices[];
        public int count;
        public Graph() {
            vertices = new Node[6];
            count = 0;
        }

        public void addNode(Node x) {
            if (count < 30) {
                vertices[count] = x;
                count++;
            } else {
                System.out.print("Graph full");
            }
        }

        public Node[] getNodes() {
            return vertices;
        }
    }

    public static HashSet<String> explore(Graph g, Node a, Node b){

        HashSet<String> reachable = new HashSet<String>();

        for( Node curr : g.getNodes()){
            curr.state = State.Unvisited;
        }

        Stack<Node> toExplore = new Stack<Node>();

        toExplore.add(a);
        Node temp = null;

        while(! toExplore.empty()){
            temp = toExplore.pop();
            temp.state = State.Visited;
            reachable.add(temp.getVertex());

            for( Node curr: temp.getAdjacent()){
                if(curr.state != State.Visited){
                   toExplore.add(curr);
                }
            }
        }

        return reachable;

    }

    public static boolean isReachable(HashSet<Node> set, String name){
        return set.contains(name);
    }

    public static void main(String args[]){

    }
}

//checking if changes are detected
