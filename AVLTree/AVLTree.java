class AVLNode {
    private int value; 
    private int height;
    private AVLNode left;
    private AVLNode right;
    public int getValue() {
        return value;
    }
    public void setValue(int value) {
        this.value = value;
    }
    public AVLNode(int value) {
        this.value = value;
        height = 1;
    }
    public int getHeight() {
        return height;
    }
    public void setHeight(int height) {
        this.height = height;
    }
    public void setLeft(AVLNode left) {
        this.left = left;
    }
    public void setRight(AVLNode right) {
        this.right = right;
    }
    public AVLNode getLeft() {
        return left;
    }
    public AVLNode getRight() {
        return right;
    }
    @Override public String toString() {
        return ("Value: "+value+"\nRight: "+right+"\tLeft: "+left);
    }
}
class AVLTree {
    AVLNode root;
    public AVLTree(int...nodes) {
        for (int i = 0; i < nodes.length; i++) {
            root=this.insertAVLNode(this.root, nodes[i]);
        }
    }
    public int height(AVLNode N) {
        if (N == null)
            return 0;
        return N.getHeight();
    }
    public int max(int a, int b) {
        return Math.max(a, b);
    }
    public int getBalanceFactor(AVLNode N) {
        if (N == null)
            return 0;
        return height(N.getLeft()) - height(N.getRight());
    }
    public AVLNode insertAVLNode(AVLNode node, int value) {
        if (node == null)
            return (new AVLNode(value));
        if (value < node.getValue())
            node.setLeft(insertAVLNode(node.getLeft(), value));
        else if (value > node.getValue())
            node.setRight(insertAVLNode(node.getRight(), value));
        else
            return node;
        node.setHeight(1 + max(height(node.getLeft()), height(node.getRight())));
        int balanceFactor = getBalanceFactor(node);
        if (balanceFactor > 1) {
            if (value < node.getLeft().getValue()) {
                return rR(node);
            } else if (value > node.getLeft().getValue()) {
                node.setLeft(lL(node.getLeft()));
                return rR(node);
            }
        }
        if (balanceFactor < -1) {
            if (value > node.getRight().getValue()) {
                return lL(node);
            } else if (value < node.getRight().getValue()) {
                node.setLeft(rR(node.getLeft()));
                return lL(node);
            }
        }
        return node;
    }
    AVLNode AVLNodeWithMinimumValue(AVLNode AVLNode) {
        AVLNode current = AVLNode;
        while (current.getLeft() != null)
            current = current.getLeft();
        return current;
    }
    AVLNode deleteAVLNode(AVLNode root, int item) {
        if (root == null)
            return root;
        if (item < root.getValue())
            root.setLeft(deleteAVLNode(root.getLeft(), item));
        else if (item > root.getValue())
            root.setRight(deleteAVLNode(root.getRight(), item));
        else {
            if ((root.getLeft() == null) || (root.getRight() == null)) {
                AVLNode temp = null;
                if (temp == root.getLeft())
                    temp = root.getRight();
                else
                    temp = root.getLeft();
                if (temp == null) {
                    temp = root;
                    root = null;
                } else
                    root = temp;
            } else {
                AVLNode temp = AVLNodeWithMinimumValue(root.getRight());
                root.setValue(temp.getValue());
                root.setRight(deleteAVLNode(root.getRight(), temp.getValue()));
            }
        }
        if (root == null)
            return root;
        root.setHeight(max(height(root.getLeft()), height(root.getRight())) + 1);
        int balanceFactor = getBalanceFactor(root);
        if (balanceFactor > 1) {
            if (getBalanceFactor(root.getLeft()) >= 0) {
                return rR(root);
            } else {
                root.setLeft(lL(root.getLeft()));
                return rR(root);
            }
        }
        if (balanceFactor < -1) {
            if (getBalanceFactor(root.getRight()) <= 0) {
                return lL(root);
            } else {
                root.setRight(rR(root.getRight()));
                return lL(root);
            }
        }
        return root;
    }
    public void preorder (AVLNode node) {
        if (node==null)
            return;
        System.out.print(node.getValue() + " ");
        preorder(node.getLeft());
        preorder(node.getRight());
    }
    public AVLNode rR(AVLNode node) {
        AVLNode node1 = node.getLeft();
        AVLNode node2 = node1.getRight();
        node1.setRight(node);
        node.setLeft(node2);
        node.setHeight(max(height(node.getLeft()), height(node.getRight()))+1);
        node1.setHeight(max(height(node1.getLeft()), height(node1.getRight()))+1);
        return node1;
    }
    public AVLNode lL(AVLNode node) {
        AVLNode node1 = node.getRight();
        AVLNode node2 = node1.getLeft();
        node1.setLeft(node);
        node.setRight(node2);
        node.setHeight(Math.max(height(node.getLeft()), height(node.getRight()))+1);
        node1.setHeight(Math.max(height(node1.getLeft()), height(node1.getRight()))+1);
        return node1;
    }
    public AVLNode rL(AVLNode node) {
        node.setRight(lL(node.getRight()));
        return rR(node);
    }
    public AVLNode lR(AVLNode node) {
        node.setLeft(rR(node.getLeft()));
        return lL(node);
    }
    public static void main(String[] args) {
        AVLTree tree = new AVLTree(33,13,53,9,21,61,8,11);
        AVLNode root = tree.root;
        AVLTree lltree = new AVLTree(33,13,53,9,21,61,8,11);
        AVLTree rrtree = new AVLTree(33,13,53,9,21,61,8,11);
        AVLTree rltree = new AVLTree(33,13,53,9,21,61,8,11);
        AVLTree lrtree = new AVLTree(33,13,53,9,21,61,8,11);
        System.out.println("Original");
        tree.preorder(root);
        System.out.println("\nLL");
        root = lltree.lL(lltree.root);
        lltree.preorder(root);
        System.out.println("\nRR");
        root = rrtree.rR(rrtree.root);
        rrtree.preorder(root);
        System.out.println("\nRL");
        root = rltree.rL(rltree.root);
        rltree.preorder(root);
        System.out.println("\nLR");
        root = lrtree.lR(lrtree.root);
        lrtree.preorder(root);
    }
}