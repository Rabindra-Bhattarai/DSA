public class AVLTree {
    public static class Node {
        Node left;
        Node right;
        int data;
        int height;

        Node(int data) {
            this.data = data;
            this.height = 1;
            this.left = this.right = null;
        }
    }

    Node createBST(Node root, int data) {
        if (root == null) {
            return new Node(data);
        }

        if (data < root.data) {
            // Update root.left with the result of recursion
            root.left = createBST(root.left, data);
        } else if (data > root.data) {
            // Update root.right with the result of recursion
            root.right = createBST(root.right, data);
        } else {
            return root; // Duplicates are not allowed
        }

        // Update height of current node
        root.height = 1 + Math.max(getHeight(root.left), getHeight(root.right));

        // Calculate balance factor
        int balanceFactor = getBalanceFactor(root);

        // Perform rotations if the node becomes unbalanced
        if (balanceFactor > 1 && data < root.left.data) {
            // Left Left (LL)
            return rightRotation(root);
        } else if (balanceFactor > 1 && data > root.left.data) {
            // Left Right (LR)
            root.left = leftRotation(root.left);
            return rightRotation(root);
        } else if (balanceFactor < -1 && data > root.right.data) {
            // Right Right (RR)
            return leftRotation(root);
        } else if (balanceFactor < -1 && data < root.right.data) {
            // Right Left (RL)
            root.right = rightRotation(root.right);
            return leftRotation(root);
        }

        return root;
    }

    Node rightRotation(Node y) {
        Node x = y.left;
        Node temp = x.right;

        x.right = y;
        y.left = temp;

        // Update heights
        y.height = 1 + Math.max(getHeight(y.left), getHeight(y.right));
        x.height = 1 + Math.max(getHeight(x.left), getHeight(x.right));

        return x;
    }

    Node leftRotation(Node x) {
        Node y = x.right;
        Node temp = y.left;

        y.left = x;
        x.right = temp;

        // Update heights
        x.height = 1 + Math.max(getHeight(x.left), getHeight(x.right));
        y.height = 1 + Math.max(getHeight(y.left), getHeight(y.right));

        return y;
    }

    int getHeight(Node root) {
        if (root == null) {
            return 0;
        }
        return root.height;
    }

    int getBalanceFactor(Node root) {
        if (root == null) {
            return 0;
        }
        return getHeight(root.left) - getHeight(root.right);
    }
}
