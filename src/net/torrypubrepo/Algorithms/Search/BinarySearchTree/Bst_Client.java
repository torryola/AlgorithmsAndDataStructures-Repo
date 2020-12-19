package net.torrypubrepo.Algorithms.Search.BinarySearchTree;

/*
 Created by Toriola Dec
 */
public class Bst_Client
{
    public static void main(String[] args)
    {
        // Populate the Tree
        Tree_Impl tree = new Tree_Impl();
        tree.insert(25);
        tree.insert(20);
        tree.insert(15);
        tree.insert(27);
        tree.insert(30);
        tree.insert(29);
        tree.insert(26);
        tree.insert(22);
        tree.insert(85);
        tree.insert(32);

        tree.traversalInorder();

        System.out.println();
       // System.out.println(" Find Value : "+tree.get(27).getData());
       // System.out.println(" Find Value : "+tree.get(89));

       // System.out.println(" Min Value in this Tree : "+tree.min());
       // System.out.println(" Max Value in this Tree : "+tree.max());

       // tree.delete(15);

        tree.traversalPreOrder();

        System.out.println();

        tree.traversalPostOrder();

        System.out.println();


    }
}
