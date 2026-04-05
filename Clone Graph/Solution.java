class Solution {
    Map<Node , Node > hm = new HashMap<>();
    public Node cloneGraph(Node node) {
        if (node == null) return null;
        if (hm.containsKey(node)) return hm.get(node);

        Node clone = new Node(node.val);
        hm.put(node,clone);
        for (Node neighbor : node.neighbors){
            clone.neighbors.add(cloneGraph(neighbor));
        }

        return clone;
    }
}