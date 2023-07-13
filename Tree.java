import java.security.Principal;
//implementing Tree, with preOrderTraversal method!
//NIMA BAHRAMI
class Node {

    String data;
    Node leftNode;
    Node rightNode; 

public Node (String item){

    data = item; 
    leftNode = null; 
    rightNode = null;
    }
}

class binaryTree {

Node root;

void preOrder(Node node){
    if (node != null){
        System.out.println(node.data);
        preOrder(node.leftNode);
        preOrder(node.rightNode);
    }
}
public static void main(String[] args) {

        binaryTree tree = new binaryTree();
        tree.root = new Node("A"); 
        tree.root.leftNode = new Node("B");
        tree.root.rightNode = new Node ("C");
        tree.root.leftNode.leftNode = new Node ("D");
        tree.root.leftNode.rightNode = new Node ("E");
        tree.root.rightNode.rightNode = new Node ("F");

        tree.preOrder(tree.root);
    }
}

