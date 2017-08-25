public class TreeNode<T> {

    T data;
    TreeNode<T> left;
    TreeNode<T> right;

    TreeNode(T x) {
        data = x;
    }

    TreeNode(T x, TreeNode<T> l, TreeNode<T> r) {
        this(x);
        this.left = l;
        this.right = r;
    }
}