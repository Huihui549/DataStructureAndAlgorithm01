package DataStructure.NonLinear.HuffmanTree;

import java.util.*;

/**
 * @author 孟广辉
 * @version 54188
 */
public class CreateHuffmanTree {
    public static void main(String[] args) {
        int[] arr = {13,7,8,3,29,6,1};
        //构建赫夫曼树
        Node huffmanTree = createHuffmanTree(arr);
        //前序遍历显示赫夫曼树
        preOrderTree(huffmanTree);

    }
    public static void preOrderTree(Node root){
        if (root!=null){
            root.preOrder();
        }else {
            System.out.println("当前树为空！");
        }
    }

    //构建赫夫曼树
    public static Node createHuffmanTree(int[] arr){
        //1、将arr数组放入集合ArrayList中
        List<Node> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            list.add(new Node(arr[i]));
        }
        //最终的结果：构成一个只有一个根节点的树
        while(list.size() >1) {
            //2、对List集合进行升序排序
            Collections.sort(list);
            //3、循环构建赫夫曼树
            //<1>从集合中取出前两个节点
            Node leftNode = list.get(0);
            Node rightNode = list.get(1);

            //<2>将这两个节点重新构建成一个根节点
            Node newRoot = new Node(leftNode.value + rightNode.value);

            //<3>将这两个节点与新构建的根节点建立关系
            newRoot.left = leftNode;
            newRoot.right = rightNode;

            //<4>将原集合中取出的这两个节点移除，将新建的根节点加入
            list.remove(leftNode);
            list.remove(rightNode);
            list.add(newRoot);
            //<5>将修改后的集合进行排序
        }
        //返回根节点
        return list.get(0);
    }


}

//Node实现
class Node implements Comparable<Node>{
    int value;//节点的权值
    Node left;//左子节点
    Node right;//右子节点
    Node(int value){
        this.value = value;
    }

    //前序遍历方法
    public void preOrder(){
        System.out.println(this.value);
        if (this.left!=null){
            this.left.preOrder();
        }
        if (this.right!=null){
            this.right.preOrder();
        }
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }


    @Override
    public int compareTo(Node o) {
        //按照升序排序
        return this.value - o.value;
    }
}
