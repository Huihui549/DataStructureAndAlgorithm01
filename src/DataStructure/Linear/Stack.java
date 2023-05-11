package DataStructure.Linear;

/**
 * @author 孟广辉
 * @version 54188
 *
 * 使用数组模拟栈
 */
public class Stack {
    public static void main(String[] args) {
        ArrayStack arrayStack = new ArrayStack(3);

//        arrayStack.pop();
        arrayStack.push(1);
        arrayStack.push(2);
        arrayStack.push(3);

        arrayStack.show();

    }
}


class ArrayStack{
    public int maxSize;
    public int[] stack;
    public int top;

    ArrayStack(int maxSize){
        this.maxSize = maxSize;
        stack= new int[maxSize];
        top = -1;
    }

    //判断栈满
    public boolean isFull(){
        return top == maxSize-1;
    }
    //判断栈空
    public boolean isEmpty(){
        return top == -1;
    }
    //入栈
    public void push(int num){
        //判断栈是否满
        if (isFull()){
            System.out.println("当前栈已满，入栈失败！");
            return;
        }
        top ++;
        stack[top] = num;
        System.out.printf("入栈成功！添加数据%d\n",stack[top]);
    }
    //出栈
    public int pop(){
        //判断栈是否为空
        if (isEmpty()){
            throw new RuntimeException("当前栈为空，出栈失败！");
        }
        int value = stack[top];
        top --;
        return value;
    }
    //显示栈中数据
    public void show(){
        //判断栈是否为空
        if (isEmpty()){
            System.out.println("当前栈为空，显示失败！");
            return;
        }
        for (int i = top; i >= 0 ; i--) {
            System.out.printf("输出下标为%d的数据%d\n",i,stack[i]);
        }
    }
}