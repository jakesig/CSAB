public class TreeNode {
    public TreeNode left;
    public TreeNode right;
    public Object value;
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
    public Object getValue() {
        return value;
    }
    public void setValue(Object value) {
        this.value = value;
    }
    public static Object m(Object a, Object b) {
        if ( ( (Comparable) a).compareTo(b) >= 0) {
            return a;
        }
        else {
            return b;
        }
    }
    public static Object f(TreeNode t) {
        if (t.getLeft() == null && t.getRight() == null) {
            return t.getValue();
        }
        else if (t.getLeft() == null) {
            return m(t.getValue(), f(t.getRight()));
        }
        else if (t.getRight() == null) {
            return m(t.getValue(), f(t.getLeft()));
        }
        else {
            return m(m(t.getValue(), f(t.getLeft())), f(t.getRight()));
        }
    }
}
class BinaryTree {
    private TreeNode root;
    private int height;

}
