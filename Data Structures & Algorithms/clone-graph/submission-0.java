/*
Definition for a Node.
class Node {
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
*/

class Solution {
    public Node cloneGraph(Node node) {
        HashMap<Node, Node> map = new HashMap<>(); // old -> new
        return dfs(map, node);
    }
    private Node dfs(HashMap<Node, Node> map, Node node) {
        if (node == null) { //basic base case
            return null;
        }
        if (map.containsKey(node)) { //avoid loops
            return map.get(node);
        }
        Node c = new Node(node.val);
        map.put(node, c);
        for (Node n : node.neighbors) {
            c.neighbors.add(dfs(map, n));
        }
        return c;
    }
}