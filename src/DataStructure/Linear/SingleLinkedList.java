package DataStructure.Linear;

import com.sun.xml.internal.ws.api.message.Header;

import java.util.LinkedList;

/**
 * @author 孟广辉
 * @version 54188
 *
 * demo01:完成创建节点，向链表中添加节点（从链表尾部添加），输出显示链表的功能。
 * demo02:在链表添加节点方法中进行改进，做到顺序添加节点。
 */
public class SingleLinkedList {
    public static void main(String[] args) {
        LinkedList01 linkedList01 = new LinkedList01();
        HeroNode heroNode01 = new HeroNode(1, "林冲", "豹子头");
        HeroNode heroNode02 = new HeroNode(2, "吴用", "智多星");
        HeroNode heroNode03 = new HeroNode(3, "李逵", "黑旋风");
        HeroNode heroNode04 = new HeroNode(3, "wzm", "老王吧");
        HeroNode heroNode05 = new HeroNode(2, "lsy", "sb");


//        linkedList01.add(heroNode01);
//        linkedList01.add(heroNode02);
//        linkedList01.add(heroNode03);

        linkedList01.addByOrder(heroNode01);
        linkedList01.addByOrder(heroNode03);
        linkedList01.addByOrder(heroNode02);
        //测试1：新节点序号与链表中某个节点序号相同
//        linkedList01.addByOrder(heroNode04);
//        linkedList01.addByOrder(heroNode05);
//        linkedList01.addByOrder(new HeroNode(0,"cjc","cnm"));

        //测试2：
//        linkedList01.update(new HeroNode(1,"mgh","mgh"));
//        linkedList01.update(new HeroNode(2,"mgh","mgh"));
//        linkedList01.update(new HeroNode(3,"mgh","mgh"));
//        linkedList01.update(new HeroNode(4,"mgh","mgh"));

        //测试3：
//        linkedList01.delete(1);
        linkedList01.show();

        //测试4：
//        linkedList01.select(1);
//        linkedList01.select(2);
//        linkedList01.select(3);

        //测试5：
//        System.out.printf("当前链表长度为：%d\n",getLenth(linkedList01.head));

        //测试6：
        int lastIndex = 1;
        System.out.printf("倒数第%d个节点为：%s",lastIndex,getLastIndexNode(linkedList01.head,lastIndex));

    }

    //获取单链表的倒数第k个节点，关键：遍历length-k次
    public static HeroNode getLastIndexNode(HeroNode head, int index){
        if (head.next == null){
            System.out.println("当前链表为空，获取失败！");
            return null;
        }
        //第一次遍历，获取单链表长度
        int lenth = getLenth(head);
        HeroNode curNode = head.next;
        //过滤无效index值，将index控制在（0，lenth）范围内
        if (index<=0 || index>lenth){
            System.out.println("索引错误！");
            return null;
        }
        //第二次遍历，获取指定节点信息
        for (int i = 0; i < lenth-index; i++) {
            curNode = curNode.next;
        }
        return curNode;
    }

    //获取单链表的有效节点个数（不统计头节点）
    /**
     *
     * @param head      传入某链表的头节点
     */
    public static int getLenth(HeroNode head){
        if (head.next == null){
            System.out.println("当前链表为空，无长度！");
            return 0;
        }
        HeroNode curNode = head.next;
        int length = 0;
        //遍历
        while(curNode!=null){
            length++;
            curNode = curNode.next;
        }
        return length;
    }
}
class LinkedList01{

    //创建头节点
    public HeroNode head= new HeroNode(0,"","");

    //定义add方法，向链表添加节点
    public void add(HeroNode heroNode){
        //将头节点保存到临时变量中，用于遍历
        HeroNode temp = head;
        //判断某节点的下一个节点是否为空，为空说明该节点为最后一个节点，将最后一个节点的next置为新添加的节点
        //每次判断完不为空之后，需要移动next
        while (true){
            if (temp.next==null){
                temp.next = heroNode;
                System.out.println("添加新节点成功！添加的节点为："+heroNode);
                return ;
            }
            //next不为空，next指针后移
            temp = temp.next;
        }
    }

    //按节点的名次顺序添加节点，要找到待插入节点位置上的上一个节点
    public void addByOrder(HeroNode heroNode){
        //头节点存临时变量
        //定义标志位flag，判断节点序号是否在链表中已经存在
        HeroNode temp = head;
        boolean flag = false;

        while (true) {
            //1、判断temp的下一个节点为空时，1：链表无节点，2：temp节点就是链表的最后一个节点。退出循环，并添加新节点
            if (temp.next == null){
                temp.next = heroNode;
                //当前新节点添加成功
                System.out.println("添加新节点成功！新节点为："+heroNode);
                return;
            }
            //链表中存在节点，且temp不是链表最后一个节点，就寻找插入的位置
            //2、判断temp的下一个节点的序号大于新节点的序号时（升序），说明新节点一个插入在temp和temp下一个节点之间
            if (temp.next.no > heroNode.no){
                heroNode.next = temp.next;
                temp.next = heroNode;
                System.out.println("添加新节点成功！新节点为："+heroNode);
                return ;
            }
            //新节点的下一个节点 = temp的下一个节点
            //temp的下一个节点 = 新的节点
            //3、判断temp的下一个节点序号等于新节点序号，说明新节点的序号在原链表中已经存在，flag置为true，标记为新序号已经存在
            //说明：无需判断新节点的序号是否与temp节点的序号相同。因为是从头节点开始遍历的，即从链表的第一个节点开始与新节点序号比较。
            else if (temp.next.no == heroNode.no){
                flag = true;
                System.out.println("新节点序号已经存在于链表中，无法添加！");
                return;
            }
            //移动temp的next指针
            temp = temp.next;
        }

    }

    //删除节点，要找到待删除节点的上一个节点
    public void delete(int no){
        //说明：不能将头节点的下一个节点存入临时变量
        HeroNode temp = head;

        while (true){
            //判断是否遍历到链表末尾
            if (temp.next == null){
                System.out.println("原链表中不存在需要删除节点的序号，删除失败！");
                return;
            }
            //找到需要删除节点的上一个节点
            if (temp.next.no == no){
                //执行删除该节点的操作
                temp.next = temp.next.next;
                System.out.println("删除节点成功!");
                return ;
            }
            temp = temp.next;
        }
    }

    //修改节点信息，根据序号查找链表中的节点
    public void update(HeroNode newHeroNode){
        if (head.next == null){
            System.out.println("当前链表为空，无法修改！");
            return;
        }
        //链表中存在节点
        //头节点的下一个节点保存在临时变量temp中
        HeroNode temp = head.next;
        //遍历判断
        while (true) {
            //判断temp节点的序号是否等于新节点的序号，等于，则说明在链表中查找到了该新节点对应的序号。
            if (temp.no == newHeroNode.no){
                temp.name = newHeroNode.name;
                temp.nickName = newHeroNode.nickName;
                System.out.println("修改节点成功！");
                return;
            }
            if (temp.next == null){
                //说明已经遍历到链表的末尾，输出不存在该新节点对应的序号
                System.out.println("当前链表中不存在该新节点对应的序号");
                return;
            }
            //反之链表中不存在该新节点对应的序号,退出循环时，根据flag输出错误
            //temp指针后移
            temp = temp.next;
        }

    }

    //查找指定节点的信息
    public void select(int no){
        HeroNode temp = head;
        if (temp.next == null){
            System.out.println("链表为空，无法查找");
            return ;
        }

        while (true){
            //判断是否遍历到链表末尾
            if (temp.next == null){
                System.out.println("当前链表中不存在要查找的指定节点，查找失败！");
                return;
            }
            //判断是否存在和no相同的节点序号
            if(temp.next.no == no){
                System.out.printf("查找成功，当前查找的序号为%d的节点为：%s\n",no,temp.next);
                return;
            }
            temp = temp.next;
        }
    }
    //定义show方法，显示链表的内容
    public void show(){
        //仍需要创建一个临时变量，保存头节点的下一个节点，用于遍历.因为此时头节点的下一个节点一定存在，不存在则输出错误
        HeroNode temp = head.next;
        //判断temp是否为空，为空，说明链表内无节点，或者以及遍历到最后一个节点，则终止循环遍历。
        //不为空，则输出显示该节点，并一定next指针
        if (temp == null){
            //此时链表中无节点
            System.out.println("该链表中不存在节点，请添加节点！");
            return;
        }
        while (true){
            if (temp==null){
                //此时已经遍历到最后一个节点，退出循环遍历
                break;
            }
            //此时链表中有节点
            System.out.println(temp);
            temp = temp.next;
        }
    }


}


class HeroNode{
    public int no;
    public String name;
    public String nickName;
    public HeroNode next;

    HeroNode(int no , String name, String nickName){
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}