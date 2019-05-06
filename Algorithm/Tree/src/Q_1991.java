import java.io.BufferedReader;
import java.io.InputStreamReader;

class Q_1991 {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int input = Integer.parseInt(bufferedReader.readLine());
        Tree tree = new Tree();

        for (int i = 0; i < input; i++) {
            char[] data = bufferedReader.readLine().replaceAll(" ", "").toCharArray();
            tree.add(data[0], data[1], data[2]);
        }
        tree.preOrder(tree.root);
        System.out.println();
        tree.inOrder(tree.root);
        System.out.println();
        tree.postOrder(tree.root);
    }
}

class Node {
    char data;
    Node left, right;

    Node(char data) {
        this.data = data;
    }
}

class Tree {
    Node root;

    public void add(char data, char leftdata, char rightdata) {
        if (root == null) {
            if (data != '.') root = new Node(data);
            if (leftdata != '.') root.left = new Node(leftdata);
            if (rightdata != '.') root.right = new Node(rightdata);
        } else {
            search(root.left, data, leftdata, rightdata);
            search(root.right, data, leftdata, rightdata);
        }
    }

    public void search(Node node, char data, char leftdata, char rightdata) {
        if (node == null) return;
        if (node.data == data){
            if (leftdata != '.') node.left = new Node(leftdata);
            if (rightdata != '.') node.right = new Node(rightdata);
        }else {
            search(node.left, data, leftdata, rightdata);
            search(node.right, data, leftdata, rightdata);
        }
    }

    public void preOrder(Node node) {//root->left->right
        System.out.print(node.data);
        if (node.left != null) preOrder(node.left);
        if (node.right != null) preOrder(node.right);
    }

    public void inOrder(Node node) {//left->root->right
        if (node.left != null) inOrder(node.left);
        System.out.print(node.data);
        if (node.right != null) inOrder(node.right);
    }

    public void postOrder(Node node) {//left->right->root
        if (node.left != null) postOrder(node.left);
        if (node.right != null) postOrder(node.right);
        System.out.print(node.data);
    }
}