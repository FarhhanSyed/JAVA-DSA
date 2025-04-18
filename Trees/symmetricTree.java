public class symmetricTree {
    static class Node {

        int data;
        Node right;
        Node left;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    public static boolean isSymmetric(Node root)
    {
        return root==null || isSymmetricHelper(root.left,root.right);
    }
    public static boolean isSymmetricHelper(Node left,Node right)
    {
        if(left==null || right==null)
        {
            return left==right;
        }
        if(left.data!=right.data)
        {
            return false;
        }
        return isSymmetricHelper(left.left, right.right) && isSymmetricHelper(left.right, right.left);
    }
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(2);
        root.left.right = new Node(3);
        root.right.right = new Node(3);
        System.err.println(isSymmetric(root));
    }
}
