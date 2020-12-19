package net.torrypubrepo.Algorithms.Search.BinarySearchTree;

/*
 Created by Toriola

 This is the representation of each node(i.e. root/subTreeRoot/child/Leaf) in the Tree
 ==>> Each node can be a root of a subtree
 */
public class TreeNode
{
    // Data to be stored in each Node
    private int data;
    // Each Node has reference to the left and right node
    private TreeNode leftChild;
    private TreeNode rightChild;

    public TreeNode(int data)
    {
        this.data = data;
    }

    public void insert(int val)
    {
        // Ignore Duplicate value
        if (val == data)
            return;
        if (val < data)
        {
            // Check if Left is null
            if (leftChild == null)
                leftChild = new TreeNode(val);
            else
                leftChild.insert(val);

        }
        else
        {
            if (rightChild == null)
                rightChild = new TreeNode(val);
            else
                rightChild.insert(val);
        }

    }

    public TreeNode get(int val)
    {
        if (val == data)
            return this;
         if (val < data)
        {
            // Check leftChild of this node
            if (leftChild != null)
                return leftChild.get(val);
        }
         if (val > data)
         {
             if (rightChild != null)
                 return rightChild.get(val);
         }

         return null;
    }

    // Returns the minimum value in the tree. Minimum value will be in the left child
    public int min()
    {
        if (leftChild == null)
            return data;
        else
            return leftChild.min();
    }

    // Returns the maximum value in the tree. Maximum value will be in the right child
    public int max()
    {
        if (rightChild == null)
            return data;
        else
            return rightChild.max();
    }

    // In_order traverse starts from the leftChild --> root --> rightChild
    // Note ==> root refers to both the root of the tree and the child because childNode can be root to leaf(s)
    public void traversalInorder()
    {
        // InOrder Traverse, we start from left -> root -> right
        if (leftChild != null)
            leftChild.traversalInorder();
        System.out.print(data + " ");// This is the root/subRoot/SubTree Node
        if (rightChild != null)
            rightChild.traversalInorder();
    }

    public void traversalPreOrder()
    {
        // PreOrder Traverse we start from the root -> left -> right
        System.out.print(data + " ");// This is the root/subRoot/SubTree Node
        if (leftChild != null)
            leftChild.traversalPreOrder();
        if (rightChild != null)
            rightChild.traversalPreOrder();
    }

    public void traversalPostOrder()
    {
        // Post Order Traverse we start root is visited last i.e. left/right -> right/left -> root
        if (leftChild != null)
            leftChild.traversalPostOrder();
        if (rightChild != null)
            rightChild.traversalPostOrder();
        System.out.print(data + " ");// This is the root/subRoot/SubTree Node
    }

    public void setData(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public TreeNode getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(TreeNode leftChild) {
        this.leftChild = leftChild;
    }

    public TreeNode getRightChild() {
        return rightChild;
    }

    public void setRightChild(TreeNode rightChild) {
        this.rightChild = rightChild;
    }
}//End TreeNode
