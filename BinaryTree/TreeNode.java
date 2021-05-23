import java.util.Stack;

public class TreeNode {
    public TreeNode left;
    public TreeNode right;
    public Integer value;
    public TreeNode(Integer n) {
        this.value = n;
    }
    public TreeNode getLeft() {
        return left;
    }
    public void setLeft(TreeNode left) {
        this.left = left;
    }
    public TreeNode getRight() {
        return right;
    }
    public void setRight(TreeNode right) {
        this.right = right;
    }
    public Integer getValue() {
        return value;
    }
    public void setValue(Integer value) {
        this.value = value;
    }
    public boolean isLeaf() {
        return (this.right==null && this.left==null);
    }
    @Override public String toString() {
        return ""+value;
    }
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree(5,1,6,5,8,9);
        bst.inorder(bst.getRoot());
        System.out.println();
        bst.remove(6);
        bst.inorderIt();
    }
}
class BinarySearchTree {
    private TreeNode root;
    private int size;
    public BinarySearchTree(Integer...elements) {
        for (Integer i : elements) {
            this.add(i);
        }
    }
    public TreeNode find(Integer n) {
        TreeNode current = root;
        while (!current.isLeaf()) {
            if (n > current.getValue()) {
                current = current.getRight();
            }
            if (n < current.getValue()) {
                current = current.getLeft();
            }
            if (n==current.getValue()) {
                return current;
            }
        }
        return null;
    }
    public boolean isEmpty() {
        return size==0;
    }
    public void add(Integer n) {
        TreeNode newNode = new TreeNode(n);
        TreeNode current = root;
        TreeNode previous;
        if (this.root == null) {
            root = newNode;
            return;
        }
        while (true) {
            previous = current;
            if (n < current.getValue()) {
                current = current.left;
                if (current == null) {
                    previous.left = newNode;
                    size++;
                    return;
                }
            }
            else if (current.getValue()==n) {
                return;
            }
            else {
                current = current.right;
                if (current == null) {
                    previous.right = newNode;
                    size++;
                    return;
                }
            }
        }
    }
    public TreeNode findParent(TreeNode root, Integer n) {
        if (root == null) {
            return null;
        }
        if (root.getValue() == n) {
            return null;
        }
        TreeNode top = root;
        while (top != null) {
            if (top.getLeft() == null) {
                return null;
            }
            if (top.getRight() == null) {
                return null;
            }
            if (top.getRight().getValue()==n) {
                return top;
            }
            if (top.getLeft().getValue()==n) {
                return top;
            }
            if (top.getValue().compareTo(n) > 0) {
                top = top.getLeft();
                findParent(top, n);
            }
            else {
                top = top.getRight();
                findParent(top, n);
            }
        }
        return null;
    }
    public void remove(Integer n) {
        TreeNode parent = findParent(root, n);
        TreeNode toRemove = find(n);
        TreeNode node;
        if (toRemove == null)
            return;
        if (toRemove == root) {
            if (toRemove.getRight() != null) {
                node = toRemove.getRight();
                while (node.getLeft() != null)
                    node = node.getLeft();
            }
            else {
                node = toRemove.getLeft();
                while (node.getRight() != null)
                    node = node.getRight();
            }
            Integer val = node.getValue();
            remove(val);
            root.setValue(val);
            --size;
            return;
        }
        //Case 1: Node removing is a leaf
        if (toRemove.isLeaf()) {
            if (parent.getRight() == toRemove) {
                parent.setRight(null);
                --size;
                return;
            }
            else {
                parent.setLeft(null);
                --size;
                return;
            }
        }
        //Case 2: Node removing is not a leaf
        if (!toRemove.isLeaf()) {
            if (parent.getRight() == toRemove) {
                TreeNode temp = toRemove.getLeft();
                while (temp.getLeft() != null) {
                    temp = temp.getLeft();
                }
                Integer nextData = temp.getValue();
                remove(temp.getValue());
                toRemove.setValue(nextData);
                --size;
                return;
            }
            else {
                TreeNode temp = toRemove.getRight();
                while (temp.getRight() != null)
                    temp = temp.getRight();
                Integer nextData = temp.getValue();
                remove(temp.getValue());
                toRemove.setValue(nextData);
                --size;
                return;
            }
        }
        if (toRemove.getRight() == null) {
            if (parent.getRight() == toRemove) {
                parent.setRight(toRemove.getLeft());
                --size;
                return;
            }
            else {
                parent.setLeft(toRemove.getLeft());
                --size;
                return;
            }
        }
        if (toRemove.getLeft() == null) {
            if (parent.getRight() == toRemove) {
                parent.setRight(toRemove.getRight());
                --size;
                return;
            }
            else {
                parent.setLeft(toRemove.getRight());
                --size;
                return;
            }
        }
    }

    public TreeNode getRoot() {
        return root;
    }
    public void clear() {
        root = null;
    }
    public void preorder (TreeNode node) {
        if (node==null)
            return;
        System.out.print(node.value + " ");
        preorder(node.getLeft());
        preorder(node.getRight());
    }
    public void preorderIt() {
        Stack<TreeNode> st = new Stack<TreeNode>();
        if (root == null) {
            return;
        }
        TreeNode current = root;
        st.push(root);
        while (!st.empty()) {
            TreeNode node = st.peek();
            System.out.print(node.value + " ");
            st.pop();
            if (node.right != null) {
                st.push(node.right);
            }
            if (node.left != null) {
                st.push(node.left);
            }
        }
    }
    public void inorder (TreeNode node) {
        if (node==null)
            return;
        inorder(node.getLeft());
        System.out.print(node.value + " ");
        inorder(node.getRight());
    }
    public void inorderIt () {
        Stack<TreeNode> st = new Stack<TreeNode>();
        if (root == null) {
            return;
        }
        TreeNode current = root;
        while (!st.isEmpty() || current != null) {
            if (current != null) {
                st.push(current);
                current = current.left;
            }
            else {
                TreeNode node = st.pop();
                System.out.print(node.value+" ");
                current = node.right;
            }
        }

    }
    public void postorder (TreeNode node) {
        if (node==null)
            return;
        postorder(node.getLeft());
        postorder(node.getRight());
        System.out.print(node.value+" ");
    }
    public void postorderIt() {
        Stack<TreeNode> st1 = new Stack<TreeNode>();
        Stack<TreeNode> st2 = new Stack<TreeNode>();
        if (root == null)
            return;
        st1.push(root);
        while (!st1.isEmpty()) {
            TreeNode current = st1.pop();
            st2.push(current);
            if (current.left != null)
                st1.push(current.left);
            if (current.right != null)
                st1.push(current.right);
        }
        while (!st2.isEmpty()) {
            System.out.print(st2.pop().value+" ");
        }
    }
}
