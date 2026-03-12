package in.ybuilds.interviews;

import java.util.Scanner;

public class BinarySearchTree {
    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    private Node insert(Node node, int data) {
        if (node == null)
            return new Node(data);

        if (data < node.data)
            node.left = insert(node.left, data);
        else if (data > node.data)
            node.right = insert(node.right, data);

        return node;
    }

    private Node findMinimum(Node node) {
        while(node != null)
            node = node.left;

        return node;
    }

    private Node delete(Node node, int key) {
        if (node == null)
            return null;

        if (key < node.data)
            node.left = delete(node.left, key);
        else if (key > node.data)
            node.right = delete(node.right, key);
        else {
            if (node.left == null) {
                return node.right;
            } else if (node.right == null) {
                return node.left;
            }
            Node min = findMinimum(node.right);
            node.data = min.data;
            node.right = delete(node.right, min.data);
        }

        return node;
    }

    private void inorder(Node node) {
        if (node != null) {
            inorder(node.left);
            System.out.print(node.data + " ");
            inorder(node.right);
        }
    }

    private void postorder(Node node) {
        if (node != null) {
            postorder(node.left);
            postorder(node.right);
            System.out.print(node.data + " ");
        }
    }

    private void preorder(Node node) {
        if (node != null) {
            System.out.print(node.data + " ");
            preorder(node.left);
            preorder(node.right);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BinarySearchTree object = new BinarySearchTree();

        Node tree = null;

        int n = scanner.nextInt();
        for(int i=0; i<n; i++)
            tree = object.insert(tree, scanner.nextInt());

        object.inorder(tree);
        System.out.println();

        object.preorder(tree);
        System.out.println();

        object.postorder(tree);
        System.out.println();
    }
}
