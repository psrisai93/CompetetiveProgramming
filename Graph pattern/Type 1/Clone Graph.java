/*
// Definition for a Node.
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
        //if node is null return null
        if(node==null) return null;
        //create visited<Node> - hAShset
        HashMap<Integer,Node> visited = new HashMap<Integer,Node>();
        //create newNode
        Node newNode = new Node(node.val);
        //visited.add()
        visited.put(node.val, newNode);
        if(node.neighbors!=null && node.neighbors.size()>0){
            //loop neighbors
            for(Node neighbor : node.neighbors)
                    //DFS(neighbor,visited,newNode)
                    DFS(neighbor,visited,newNode);
        }
        return newNode;
    }
    public void DFS(Node node, HashMap<Integer,Node> visited, Node rootNode){
        //if node is found in visited
        if(visited.containsKey(node.val)){
            rootNode.neighbors.add(visited.get(node.val));
            //return
            return;
        }
        //create newNode with node.val
        Node newNode = new Node(node.val);
        //rootNode.neighbors.add(newNode)
        rootNode.neighbors.add(newNode);
        //visited.add(node)
        visited.put(node.val, newNode);
        //List<Node> neighbors = node.neighbors;
        List<Node> neighbors = node.neighbors;
        //if(neighbors!=null)
        if(neighbors!=null && neighbors.size()>0){
            //loop all niehgogrs
            for(Node neighbor : neighbors){
                //DFS(neighbor, visited, newNode)
                DFS(neighbor, visited, newNode);
            }
        }
    }
}
