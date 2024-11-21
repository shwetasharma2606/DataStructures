// { Driver Code Starts
import java.io.*;
import java.util.*;

import javax.naming.NameAlreadyBoundException;

class CloneGraph {
    public static void main(String[] args){
      Node node1 = new Node(1);
      Node node2 = new Node(2);
      Node node3 = new Node(3);
      Node node4 = new Node(4);
      node1.neighbors.add(node2);
      node1.neighbors.add(node4);

      node2.neighbors.add(node3);
      node2.neighbors.add(node1);

      node3.neighbors.add(node2);
      node3.neighbors.add(node4);

      node4.neighbors.add(node1);
      node4.neighbors.add(node3);

      System.out.println(cloneGraph(node1));
    }
    public static class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }
    public static Node cloneGraph(Node node) {
        if(node==null) return null;
        Node newRoot = new Node(node.val);
        HashMap<Integer,Node> visited = new HashMap<Integer,Node>();
        visited.put(newRoot.val, newRoot);
        dfs(node, newRoot, visited);
        return newRoot;
    }
    /*
    //Surya
    public void dfs1(Node curr, Node node, Map<Integer, Node> visited) {
        visited.put(node.val, node);
        for (Node ele : curr.neighbors) {
            if (!visited.containsKey(ele.val)) {
                Node newnode = new Node(ele.val);
                node.neighbors.add(newnode);
                dfs(ele, newnode, visited);
            } else {
                node.neighbors.add(visited.get(ele.val));
            }
        }
    }*/
    
    public static void dfs(Node node, Node newNode, HashMap<Integer,Node>  visited){
        if(node==null) return;
        ArrayList<Node> neighbours = (ArrayList)node.neighbors;
        visited.put(newNode.val, newNode);
        if(neighbours!=null){
            for (Node node2 : neighbours) {
                if(visited.get(node2.val)!=null){
                    Node child = visited.get(node2.val);
                    //System.out.println("CASE 1 :  PARENT : "  +newNode.val +" > CHILD > "+child.val);
                    newNode.neighbors.add(child);
                    //child.neighbors.add(newNode);
                }
                else{
                    Node child = new Node(node2.val);
                    //System.out.println("CASE 2 :  PARENT : "  +newNode.val +" > CHILD > "+child.val);
                    newNode.neighbors.add(child);
                    //child.neighbors.add(newNode);
                    dfs(node2, child,visited );
                }
            }
        }
    }

    
}
