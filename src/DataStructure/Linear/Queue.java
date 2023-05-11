package DataStructure.Linear;

import java.util.ArrayDeque;

/**
 * @author 孟广辉
 * @version 54188
 * 使用数组模拟队列
 */
public class Queue {
    public static void main(String[] args) {
        ArrayQueue queue = new ArrayQueue(3);

        queue.addData(10);
        queue.addData(20);
        queue.addData(30);

        queue.getData();
        queue.getData();
        queue.getData();

//        queue.addData(40);

        queue.showAllData();
        queue.showHead();
        queue.showTail();
    }
}

//自定义一个队列类
class ArrayQueue{
    /**
     * 说明：队列的头指针指向队列头的前一个索引
     *      队列的尾指针指向队列尾的索引
     * 存在的问题：
     *      该数组模拟的队列只能使用一次。
     * 解决方法：
     *      将其改进为环形队列
     * 解决实现：
     *      CircularQueue
     */
    //1、定义队列的字段
    private int maxSize;
    private int[] arr;
    private int rear ;
    private int front;
    //2、创建构造器，完成字段的赋值与创建
    ArrayQueue(int maxSize){
        this.maxSize = maxSize;
        arr = new int[maxSize];
        rear = -1;
        front = -1;

    }
    //3、定义一系列方法
    //判断队列是否满，尾指针等于队列最大容量（maxSize-1）
    public boolean isFull(){
        if (rear == this.maxSize-1){
            return true;
        }
        return false;
    }
    //判断队列是否为空，尾指针等于头指针
    public boolean isEmpty(){
        if (rear == front){
            return true;
        }
        return false;
    }
    //添加数据到队列中，先判断队列是否已满，队列满时，不能再添加数据。添加时，尾指针后移并且数组赋值
    public void addData(int num){
        if (isFull()){
            System.out.println("队列已满，无法添加数据");
        }
        rear++;//相当于队列添加元素
        arr[rear] = num;
    }
    //获取队列中的数据，先判断队列是否为空，队列为空时，不能取数据。取出时，头指针后移并返回数组头指针对应的值
    //遵循先进先出原则
    public int getData(){
        if(isEmpty()){
            System.out.println("队列为空，无法取出数据");
        }
        front++;//相当于队列删除了元素
        return arr[front];
    }
    //显示队列中的所有数据（不需要移动指针）
    public void showAllData(){
        if (isEmpty()){
            System.out.println("队列为空，无法查看队列数据");
            return;
        }
        //遍历数组，并控制台显示输出
        for (int i = front+1; i <= rear; i++) {
            System.out.printf("%d\t",arr[i]);
        }
        System.out.println();
    }
    //显示队列头数据
    public void showHead(){

        if (isEmpty()) {
            System.out.println("队列已为空，无头数据");
            return;
        }
        System.out.printf("%d\n", arr[front + 1]);
    }
    //显示队列尾数据
    public void showTail(){

        if (isEmpty()){
            System.out.println("队列为空，无尾数据");
            return ;
        }
        System.out.printf("%d\n",arr[rear]);
    }

}