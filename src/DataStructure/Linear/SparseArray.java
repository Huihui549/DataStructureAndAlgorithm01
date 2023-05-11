package DataStructure.Linear;

/**
 * @author 孟广辉
 * @version 54188
 */
public class SparseArray {

    public static void main(String[] args) {
        final int arrayRow = 11;
        final int arrayColumn = 11;

        //1、定义一个需要压缩的二维数组
        int[][] array01 = new int[arrayRow][arrayColumn];
        //初始化
        array01[1][2] = 1;
        array01[2][3] = 2;
        array01[3][4] = 2;
        array01[6][10] = 15;
        System.out.println("原数组如下：");
        for (int[] arr:
             array01) {
            for (int num01 :
                    arr) {
                System.out.printf("%d\t",num01);
            }
            System.out.println();
        }
//        System.out.println(array01);

        //2、压缩为稀疏数组
        //获取原数组中有效数据个数，存入遍历sum中，sparse[sum+1][3]
        int sum =0;
        for (int[] arr :
                array01) {
            for (int num02:
                 arr) {
                if (num02!=0){
                   sum++;
                }
            }
        }
        System.out.println();
        //定义稀疏数组
        int[][]  sparse = new int[sum+1][3];
        //稀疏数组第一行记录原数组总行列数,以及原数组的有效值个数
        sparse[0][0] = arrayRow;
        sparse[0][1] = arrayColumn;
        sparse[0][2] = sum;
        System.out.println("稀疏数组第一行数据如下：");
        for (int num03 :
                sparse[0]) {
            System.out.printf("%d\t",num03);
        }
        System.out.println();
        System.out.println();
        //遍历原数组，将原数组有效值的行列信息及有效值大小存入稀疏数组中
        int count =0;
        for (int i = 0; i < arrayRow; i++) {
            for (int j = 0; j < arrayColumn; j++) {
                if (array01[i][j]!=0){
                    count++;
                    sparse[count][0] = i;
                    sparse[count][1] = j;
                    sparse[count][2] = array01[i][j];

                }
            }
        }
        //输出显示初始化完成的稀疏数组
        System.out.println("稀疏数组如下：");
        for (int[] num04 :
                sparse) {
            for (int num05 :
                    num04) {
                System.out.printf("%d\t",num05);
            }
            System.out.println();
        }
        //3、解析为原数组
        //读取稀疏数组第一行信息，初始化二维数组
        int[][] array02 = new int[sparse[0][0]][sparse[0][1]];
        //解析出原数组的有效值
        //遍历稀疏数组，从第一行开始获取有效值信息，并初始化还原的二维数组
        for (int i = 1; i <= sparse[0][2]; i++) {
                array02[sparse[i][0]][sparse[i][1]] = sparse[i][2];
        }
        //输出显示还原的二维数组
        System.out.println("还原后的数组如下：");
        for (int i = 0; i < arrayRow; i++) {
            for (int j = 0; j < arrayColumn; j++) {
                System.out.printf("%d\t",array02[i][j]);
            }
            System.out.println();
        }
    }

}
