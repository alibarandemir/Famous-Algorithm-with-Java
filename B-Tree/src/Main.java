public class Main {
    public static void main(String[] args) {
        BTree.Node root = new BTree.Node(3);
        BTree bTree = new BTree(3, root);
        bTree.add(10);

        bTree.add(20);

        bTree.add(5);

        bTree.add(1);

        bTree.add(30);

        bTree.add(15);

        bTree.add(25);

        bTree.add(26);

        bTree.add(27);

        bTree.add(28);

        bTree.add(29);

        bTree.add(24);

        bTree.add(31);

        bTree.add(40);

        bTree.add(41);

        bTree.add(42);

        bTree.add(43);

        bTree.add(44);

        bTree.add(45);

        bTree.add(46);
        bTree.display(root,1);
    }
}
