package net.torrypubrepo.Algorithms.Search.BinarySearchTree;

/*
 Created by Toriola

 The Binary Tree Implementation with single root node
 */
public class Tree_Impl
{
    private TreeNode root;

    public void insert(int val)
    {
        // Check if root node exists or this is a 1st root
        if (root == null)
            root = new TreeNode(val);
        // Insert the value into the root child. The insert will take care of the comparison and the insertion
        else root.insert(val);
    }

    public TreeNode get(int val)
    {
        if (root != null)
            return root.get(val);
        return null;
    }

    public void delete(int val)
    {
        root = delete(root, val);
    }

    // Helper method that return the replacement node
    private TreeNode delete(TreeNode subTreeNode, int val)
    {
        if (subTreeNode == null)
            return null;

            if (val < subTreeNode.getData()) //Search SubTree LeftChild for the Value and return the replacement node
                subTreeNode.setLeftChild(delete(subTreeNode.getLeftChild(), val));
            else if (val > subTreeNode.getData())
                subTreeNode.setRightChild(delete(subTreeNode.getRightChild(), val));
            else {
                // handle the case, where node to delete has 0 - 1 child
                if (subTreeNode.getLeftChild() == null)
                    return subTreeNode.getRightChild();
                else if (subTreeNode.getRightChild() == null)
                    return subTreeNode.getLeftChild();
                // If Node to delete has 2 children
                // Replace the value in the subTreeNode with the smallest value from the right subtree
                subTreeNode.setData(subTreeNode.getRightChild().getData());

                // Delete the node that has the smallest value in the right subTreeNode
                subTreeNode.setRightChild(delete(subTreeNode.getRightChild(), subTreeNode.getData()));
            }
        return subTreeNode;
    }

    public int min()
    {
        if (root == null)
            return Integer.MIN_VALUE; // Nothing in this tree just return Minimum value that can be stored
        else
            return root.min();
    }

    public int max()
    {
        if (root == null)
            return Integer.MAX_VALUE;
        else
            return root.max();
    }

    public void traversalInorder()
    {
        if (root != null)
            root.traversalInorder();
    }

    public void traversalPreOrder()
    {
        if (root != null)
            root.traversalPreOrder();
    }

    public void traversalPostOrder()
    {
        if (root != null)
            root.traversalPostOrder();
    }
}
