package DataStructure.Linear;

/**
 * @author 孟广辉
 * @version 54188
 *
 * 存在数组下标越界的错误，未解决
 */

public class CircularQueue {
    public static void main(String[] args) {
        circularArrayQueue queue = new circularArrayQueue(3);

        queue.addData(10);
        queue.addData(20);
        queue.addData(30);

        queue.getData();
        queue.getData();
//        queue.getData();

        queue.addData(40);
        queue.addData(50);

        queue.showAllData();
//        queue.showHead();
//        queue.showTail();
    }
}


//自定义一个队列类
class circularArrayQueue{
    /**
     * 说明：队列的头指针指向队列头的前一个索引
     *      队列的尾指针指向队列尾的索引
     *      的基础上，头指针和尾指针均向后偏移一位
     *
     */
    //1、定义队列的字段
    private int maxSize;
    private int[] arr;
    private int rear ;
    private int front;
    //2、创建构造器，完成字段的赋值与创建
    circularArrayQueue(int maxSize){
        this.maxSize = maxSize;
        arr = new int[maxSize];
        rear = 0;
        front = 0;

    }
    //3、定义一系列方法
    //判断队列是否满，尾指针等于队列最大容量（maxSize-1）
    //上述判断需要修改为（rear+1）%maxSize == front
    public boolean isFull(){
            return (rear+1)%this.maxSize == front;
    }
    //判断队列是否为空，尾指针等于头指针
    public boolean isEmpty(){
        return rear == front;
    }

    //所做的修改：添加数据时，先数组赋值，再移动rear指针
    public void addData(int num){
        if (isFull()){
            System.out.println("队列已满，无法继续添加数据...");
            return;
        }

        arr[rear] = num;
        rear = (rear+1)%maxSize;//取模时为了防止数组越界

    }
    //所做的修改，取出数据时，先将front对应的值保存到一个临时变量，然后后移front（考虑取模），最后返回临时变量
    //遵循先进先出原则
    public int getData(){
        if(isEmpty()){
//            System.out.println("队列为空，无法取出数据");
//            return 0;
            throw new RuntimeException("队列为空，无法取出数据");
        }
        int value = arr[front];
        front = (front + 1)%maxSize;
        return value;
    }
    //显示队列中的所有数据（不需要移动指针）
    //所做的修改，修改遍历范围
    public void showAllData(){
        if (isEmpty()){
            System.out.println("队列为空，无法查看队列数据");
            return;
        }
        //遍历数组，并控制台显示输出
        //从队列第一个元素索引到第一个元素索引+队列有效值个数
        for (int i = front; i <= front + size(); i++) {
            System.out.printf("arr[%d]=%d\t",i%maxSize,arr[i%maxSize]);//防止数组越界
        }
        System.out.println();
    }
    //显示队列头数据
    public void showHead(){

        if (isEmpty()) {
            System.out.println("队列已为空，无头数据");
            return;
        }
        System.out.printf("%d\n", arr[front]);
    }
    //显示队列尾数据
    public void showTail(){

        if (isEmpty()){
            System.out.println("队列为空，无尾数据");
            return ;
        }
        System.out.printf("%d\n",arr[rear-1]);
    }

    //返回当前队列的有效值个数
    public int size(){
        return (rear+maxSize -front)%maxSize;
    }
}