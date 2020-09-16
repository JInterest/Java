package DataStructure.tree;

/**
 * @Auther: AJun
 * @version:1.0
 * @Date: 2020/08/31  20:51
 * @Description: 红黑树
 */
public class RBTree<T extends Comparable<T>> {

    private RBTreeNode<T> mRoot;    // 根结点

    private static final boolean RED = false;
    private static final boolean BLACK = true;


    public class RBTreeNode<T extends Comparable<T>> {
        private final boolean RED = false;
        private final boolean BLACK = true;
        private int key;
        private boolean color;
        private RBTreeNode<T> left;
        private RBTreeNode<T> right;
        private RBTreeNode<T> parent;

        public RBTreeNode(int key) {
            this.key = key;
            this.color = RED;
        }

        public int getKey() {
            return key;
        }

        public void setKey(int key) {
            this.key = key;
        }

        public boolean isColor() {
            return color;
        }

        public void setColor(boolean color) {
            this.color = color;
        }

        public RBTreeNode<T> getLeft() {
            return left;
        }

        public void setLeft(RBTreeNode<T> left) {
            this.left = left;
        }

        public RBTreeNode<T> getRight() {
            return right;
        }

        public void setRight(RBTreeNode<T> right) {
            this.right = right;
        }

        public RBTreeNode<T> getParent() {
            return parent;
        }

        public void setParent(RBTreeNode<T> parent) {
            this.parent = parent;
        }

        @Override
        public String toString() {
            return "RBTreeNode{" +
                    ",key=" + key +
                    ", color=" + color +
                    '}';
        }
    }


}