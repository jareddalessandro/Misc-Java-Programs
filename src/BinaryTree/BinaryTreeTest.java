package BinaryTree;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class BinaryTreeTest {

    public static void main(String[] args) {
        final BinaryTree tree = new BinaryTree();

        // final Random random = new Random();
        // for (int i = 0; i < 30; i++) {
        // tree.insert(random.nextInt(30));
        // }
        // tree.printTree();
        // System.out.println("-----------------------------");
        // tree.traverse();

        tree.insert(5);
        tree.insert(10);
        tree.insert(9);
        tree.insert(12);
        tree.insert(120);
        tree.insert(4);
        tree.insert(3);
        tree.insert(1);
        tree.insert(2);
        tree.printTree();
        System.out.println(tree.isBST());
    }


    @Test
    public void testInsert() throws Exception {
        final BinaryTree tree = new BinaryTree();
        tree.insert(3);
        tree.insert(4);
        tree.insert(2);
        assertEquals(3, tree.size());
    }

    @Test
    public void testSize() throws Exception {
        final BinaryTree tree = new BinaryTree();
        tree.insert(5);
        tree.insert(3);
        assertTrue(tree.size() > 1);
        assertTrue(tree.size() < 3);
    }

    @Test
    public void testLookup() throws Exception {
        final BinaryTree tree = new BinaryTree();
        tree.insert(5);
        tree.insert(2);
        assertTrue(tree.lookup(2));
        assertFalse(tree.lookup(10));

    }

    @Test
    public void testDelete() throws Exception {
        final BinaryTree tree = new BinaryTree();
        tree.insert(5);
        tree.insert(4);
        tree.insert(3);
        tree.insert(10);
        tree.insert(9);
        tree.insert(1);
        tree.insert(12);
        tree.insert(2);
        tree.insert(120);

        final BinaryTree tree2 = new BinaryTree();
        tree2.insert(5);
        tree2.insert(4);
        tree2.insert(3);
        tree2.insert(10);
        tree2.insert(9);
        tree2.insert(1);
        tree2.insert(12);
        tree2.insert(2);
        tree2.insert(120);

        tree2.delete(9);
        assertNotEquals(tree.size(), tree2.size());
        assertFalse(tree2.lookup(9));

    }

    @Test
    public void testConvert() throws Exception {
        final BinaryTree tree = new BinaryTree();
        tree.insert(5);
        tree.insert(4);
        tree.insert(3);
        tree.insert(10);

        assertFalse(tree.lookup(7));
        tree.convert(5, 7);
        assertTrue(tree.lookup(7));
        tree.convert(7,3);
        assertTrue(tree.lookup(3));
    }

    @Test
    public void testDepth() throws Exception {
        final BinaryTree tree = new BinaryTree();
        tree.insert(5);
        tree.insert(4);
        tree.insert(3);
        tree.insert(2);
        tree.insert(1);
        assertEquals(5, tree.maxDepth());
    }

    @Test
    public void testIsBST() throws Exception {
        final BinaryTree tree = new BinaryTree();
        tree.insert(5);
        tree.insert(4);
        tree.insert(6);
        tree.insert(7);
        tree.insert(3);
        tree.insert(2);
        tree.insert(1);
        assertTrue(tree.isBST());
    }

    // Doesn't actually test anything, just increases coverage by calling
    // printTree and traverse methods
    @Test
    public void testPrintTraverse() throws Exception {
        final BinaryTree tree = new BinaryTree();
        tree.insert(5);
        tree.insert(6);
        tree.insert(12);
        tree.insert(13);
        tree.insert(14);
        tree.insert(3);
        System.out.println("Print and Traverse Results: \n");
        tree.printTree();
        tree.traverse();

    }

}
