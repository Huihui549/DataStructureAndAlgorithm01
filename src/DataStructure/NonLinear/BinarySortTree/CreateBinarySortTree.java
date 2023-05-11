package DataStructure.NonLinear.BinarySortTree;

/**
 * @author 孟广辉
 * @version 54188
 *
 * 二叉排序树与中序遍历结合使用，输出升序序列
 */
public class CreateBinarySortTree {
    public static void main(String[] args) {
        int[] arr = {10,9,7,5,22,30,55};
        BinarySortTree binarySortTree = new BinarySortTree();
        //向二叉排序树中添加节点
        for (int i = 0; i < arr.length; i++) {
            binarySortTree.add(new Node(arr[i]));
        }
        System.out.println("向二叉排序树中添加节点完成");

        //中序遍历二叉排序树
        binarySortTree.infixOrder();

    }


}

class BinarySortTree{
    private Node root;
    //向二叉排序树中添加一个新节点
    public void add(Node node){
        if ( root == null){
            root = node;
        }else {
            root.add(node);
        }
    }
    //中序输出二叉排序树
    public void infixOrder(){
        if (root == null){
            System.out.println("当前二叉排序树为空，无法遍历");
        }else {
            root.infixOrder();
        }
    }
}

class Node{
    int value;
    Node left;
    Node right;

    Node(int value){
        this.value = value;
    }

    //添加节点
    public void add(Node node){
        if (node == null){
            return;
        }
        //判断要添加的节点与当前子树根节点值的关系
        //小于当前子树根节点的值，需要添加的节点就添加在左边
        if(node.value < this.value){
            if (this.left == null){
                this.left = node;
            }else{
                this.left.add(node);
            }
        }
        //大于当前子树根节点的值，添加的节点就添加在右边
        else{
            if (this.right == null){
                this.right = node;
            }else{
                this.right.add(node);
            }
        }
    }

    public void infixOrder(){
        if (this.left != null){
            this.left.infixOrder();
        }
        System.out.println(this.value);
        if (this.right!= null){
            this.right.infixOrder();
        }
    }
}
