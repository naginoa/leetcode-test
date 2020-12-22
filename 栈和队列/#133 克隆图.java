class Solution {
    HashMap<Node, Node> hashMap = new LinkedHashMap<>();
    public Node cloneGraph(Node node) {
        if (node==null) return null;
        if (hashMap.containsKey(node))return hashMap.get(node);

        Node tmp = new Node(node.val);
        tmp.neighbors = new ArrayList<>();
        hashMap.put(node, tmp);

        for (Node neighbor : node.neighbors) {
            tmp.neighbors.add(cloneGraph(neighbor));
        }

        return hashMap.get(node);
    }
}