package TreeNHeep;
import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {
    static class Node {
        int key;
        Node left, right;

        // constructor
        Node(int key)
        {
            this.key = key;
            left = null;
            right = null;
        }
    }
    static Node root;
    static Node temp = root;

    /* Inorder traversal of a binary tree*/
    public static void inorder(Node node) {
        if (node == null)
            return;
        inorder(node.left);
        System.out.print(node.key + " ");
        inorder(node.right);
    }

    public void printPreorder(Node node) {
        if (node == null)
            return;
        System.out.print(node.key + " ");
        printPreorder(node.left);
        printPreorder(node.right);
    }

    public void printPostorder(Node node) {
        if (node == null)
            return;
        printPostorder(node.left);
        printPostorder(node.right);
        System.out.print(node.key + " ");
    }

    static void insert(Node temp, int key) {
        if (temp == null) {
            root = new Node(key);
            return;
        }
        Queue<Node> q = new LinkedList<Node>();
        q.add(temp);

        // 进行层序遍历，直到我们找到一个空的地方。
        while (!q.isEmpty()) {
            temp = q.peek();
            q.remove();
            if (temp.left == null) {
                temp.left = new Node(key);
                break;
            }
            else
                q.add(temp.left);
            if (temp.right == null) {
                temp.right = new Node(key);
                break;
            }
            else
                q.add(temp.right);
        }
    }

    private Node addRecursive(Node current, int key) {
        if (current == null) {
            return new Node(key);
        }
        if (key < current.key) {
            current.left = addRecursive(current.left, key);
        } else if (key > current.key) {
            current.right = addRecursive(current.right, key);
        } else {
            return current;
        }
        return current;
    }

    public void add(int key) {
        root = addRecursive(root, key);
    }

    private Node deleteRecursive(Node current, int key) {
        if (current == null) {
            return null;
        }

        if (key == current.key) {
            // Node to delete found
            // ... code to delete the node will go here
        }
        if (key < current.key) {
            current.left = deleteRecursive(current.left, key);
            return current;
        }

        current.right = deleteRecursive(current.right, key);
        return current;
    }

    public void delete(int value) {
        root = deleteRecursive(root, value);
    }

    private boolean containsNodeRecursive(Node current, int key) {
        if (current == null) {
            return false;
        }
        if (key == current.key) {
            return true;
        }
         if(key < current.key)
             return containsNodeRecursive(current.left, key);
         else
             return containsNodeRecursive(current.right, key);
    }

    public boolean containsNode(int key) {
        return containsNodeRecursive(root, key);
    }

    // Driver code
    public static void main(String args[]) {
        root = new Node(10);
        root.left = new Node(11);
        root.left.left = new Node(7);
        root.right = new Node(9);
        root.right.left = new Node(15);
        root.right.right = new Node(8);

        System.out.println("Inorder traversal before insertion:");
        inorder(root);

        int key = 12;
        insert(root, key);

        System.out.println("Inorder traversal after insertion:");
        inorder(root);
    }
}