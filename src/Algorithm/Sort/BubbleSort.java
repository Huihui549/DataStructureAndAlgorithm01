package Algorithm.Sort;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author 孟广辉
 * @version 54188
 *
 * 冒泡排序算法的实现与优化，及测速，10s左右
 *
 * Date date1 = new Date();
 * SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
 * String date1Str = format1.format(date1);
 * System.out.println("排序前时间："+date1Str);
 *
 * Date date2 = new Date();
 * SimpleDateFormat format2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
 * String date2Str = format2.format(date2);
 * System.out.println("排序前时间："+date2Str);
 */
public class BubbleSort {
    public static void main(String[] args) {
        //创建并初始化一个数组
//        int[] nums = {3,9,-1,10,-2,20,25};
//
//hot-fix
//master
//hot-fix02

        //创建一个80000个随机数的数组
        int[] nums = new int[80000];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = (int) (Math.random() * 8000000);
        }

        //排序前
//        for (int i = 0; i < nums.length; i++) {
//            System.out.printf("%d\t",nums[i]);
//        }
//        System.out.println();

        Date date1 = new Date();
        SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1Str = format1.format(date1);
        System.out.println("排序前时间："+date1Str);

        //进行冒泡排序
        Bubble(nums);

        Date date2 = new Date();
        SimpleDateFormat format2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date2Str = format2.format(date2);
        System.out.println("排序前时间："+date2Str);

        //排序后
//         for (int i = 0; i < nums.length; i++) {
//             System.out.printf("%d\t",nums[i]);
//         }
//         System.out.println();
    }
    public static int[] Bubble(int[] nums){
        //优化
        //如果每一趟最后flag为false说明这一趟中没有发生过交换
        boolean flag = false;
        int temp;
        //第一层循环：排序的趟数，即length-1
        //第二层循环，每一趟中比较大小的次数，即length-i-1
        for (int i = 0; i < nums.length-1; i++) {
            for (int j = 0; j < nums.length-i-1; j++) {
                if (nums[j] > nums[j + 1]) {
                    //前一个数大于后一个数，交换
                    temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                    //说明交换过，
                    flag = true;

                }
            }
//            System.out.printf("第%d趟交换成功！\n",i+1);
            if (!flag){
                //说明这一趟没有发生交换，就直接退出循环
//                System.out.printf("当前第%d趟没有发生交换，直接排序完成\n",i+1);
                break;
            }else{
                flag = false;//重新置位
            }
        }
        return nums;
    }
}
