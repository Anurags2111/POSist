import java.io.*;
import java.util.*;

public class Posist {
    class Node
    {
        float data;
        Node left, right;

        public Node(float data)
        {
            this.data = data;
            left = right = null;
        }

    }

    Node root;

    Posist() {
        root = null;
    }

    void insert(float key) {
        root = insertRec(root, key);
    }

    Node insertRec(Node root, float key) {

        if (root == null) {
            root = new Node(key);
            return root;
        }

        if (key < root.key)
            root.left = insertRec(root.left, key);
        else if (key > root.key)
            root.right = insertRec(root.right, key);
        return root;
    }

    static float Encrypt(Node node, float n1)
    {
        if (node == null)
            return 0.0f;

        if (node.data > n1)
            return 1+ Encrypt(node.left, n1);

        if (node.data < n1)
            return 1+Encrypt(node.right, n1);

        return 0.0f;
    }

    public static void main(String[] args)
    {
        boolean user = true;
        float data;
        int choice;
        Scanner in  = new Scanner(System.in);
        Posist tree = new Posist();


        while(user) {
            System.out.println("Choose one of the options:");
            System.out.println("1. Insert");
            System.out.println("2. Exit");
            choice = in.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter data");
                    data = in.nextFloat();
                    tree.insert(data);
                    break;

                default:
                    user = false;
                    System.out.println("Execution stopped.");
                    break;
            }
        }

        System.out.println("Enter the data to be encrypted.");
        float x = in.nextFloat();
        float enc = Encrypt(tree.root, x);
        System.out.println("Encrypted: " + enc);
    }
}
