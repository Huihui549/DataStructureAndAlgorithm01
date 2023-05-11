package Algorithm.Sort;

import com.sun.org.apache.bcel.internal.generic.Select;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * @author 孟广辉
 * @version 54188
 *
 * 选择排序实现与测速：2s左右
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
public class SelectSort {
    public static void main(String[] args) {
//        int[] arr = {8,3,2,1,7,4,6,5};

//        int[] arr = new int[80000];
//        for (int i = 0; i < 80000; i++) {
//            arr[i] = (int)(Math.random()*8000000);
//        }

        int[] arr = new int[15];
        for (int i = 0; i < 15; i++) {
            arr[i] = (int)(Math.random()*800);
        }

//        Date date1 = new Date();
//        SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        String date1Str = format1.format(date1);
//        System.out.println("排序前时间："+date1Str);

        Select(arr);

//         Date date2 = new Date();
//         SimpleDateFormat format2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//         String date2Str = format2.format(date2);
//         System.out.println("排序后时间："+date2Str);
    }

    public static void Select(int[] arr){
//
        //[8,3,2,1,7,4,6,5],长度为8
        for (int i = 0; i < arr.length-1; i++) {
            int minIndex = i;
            int min = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                if (min > arr[j]) {
                    minIndex = j;
                    min = arr[j];
                }
            }
            //遍历完之后，min就是数组中最小的值
            //将最小的min与预定义的最小值交换
            arr[minIndex] = arr[i];
            arr[i] = min;
//            System.out.println(Arrays.toString(arr));
        }
        System.out.println(Arrays.toString(arr));
    }
}
