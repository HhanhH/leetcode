package com.company.two;

import com.company.graph.Node;

import java.util.*;

public class LeetCode133 {
    Map<Node, Node> map = new HashMap<>();

    public Node cloneGraph(Node node) {
        if (node == null) return null;
        if (node.neighbors.size() == 0) return new Node(1);
        dfs(node);
        for (Node tmp : map.keySet()) {
            Node v = map.get(tmp);
            for (Node it : tmp.neighbors) {
                Node n = map.get(it);
                v.neighbors.add(n);
            }

        }
        return map.get(node);
    }

    public void dfs(Node node) {
        for (Node t : node.neighbors) {
            if (!map.containsKey(t)) {
                Node newt = new Node(t.val, new ArrayList<>());
                map.put(t, newt);
                dfs(t);
            }
        }
    }

    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        n1.neighbors = Arrays.asList(n2, n4);
        n2.neighbors = Arrays.asList(n1, n3);
        n3.neighbors = Arrays.asList(n2, n4);
        n4.neighbors = Arrays.asList(n1, n3);
        new LeetCode133().cloneGraph(n1);
//        Node res = cloneGraph(n1);
//        System.out.println(res.val);

    }
}
