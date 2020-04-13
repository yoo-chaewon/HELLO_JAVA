import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());
        Tree tree = new Tree();

        while (N-- > 0) {
            char[] data = bufferedReader.readLine().replace(" ", "").toCharArray();
            tree.Add(data[0], data[1], data[2]);
        }

        tree.PreOrder(tree.root);
        System.out.println();
        tree.InOrder(tree.root);
        System.out.println();
        tree.PostOrder(tree.root);
    }
}

class Node {
    char data;
    Node left;
    Node right;

    Node(char data) {
        this.data = data;
    }
}

class Tree {
    Node root;

    public void Add(char data, char left, char right) {
        if (root == null) {
            if (data != '.') root = new Node(data);
            if (left != '.') root.left = new Node(left);
            if (right != '.') root.right = new Node(right);
        } else {
            Search(root.left, data, left, right);
            Search(root.right, data, left, right);
        }
    }

    public void Search(Node node, char data, char left, char right) {
        if (node == null) return;
        if (node.data == data){
            if (left != '.') node.left = new Node(left);
            if (right != '.') node.right = new Node(right);
        }else {
            Search(node.left, data, left, right);
            Search(node.right, data, left, right);
        }
    }

    public void PreOrder(Node node){
        System.out.print(node.data);
        if (node.left != null) PreOrder(node.left);
        if (node.right != null) PreOrder(node.right);
    }

    public void InOrder(Node node){
        if (node.left != null) InOrder(node.left);
        System.out.print(node.data);
        if (node.right != null) InOrder(node.right);
    }

    public void PostOrder(Node node){
        if (node.left != null) PostOrder(node.left);
        if (node.right != null) PostOrder(node.right);
        System.out.print(node.data);
    }
}