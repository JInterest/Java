package practise.p9;

import java.lang.reflect.Array;

/**
 * @Auther: AJun
 * @version:1.0
 * @Date: 2020/08/22  16:34
 * @Description: 稀疏数组
 */
public class SparseArray {
    /**
     * 创造一个空的二维数组
     */
    public int[][] create(int x, int y) {
        if (x<0||y<0)return null;
        int[][] array = new int[x][y];
        return array;
    }

    /**
     * 遍历二维数组
     *
     * @param ints
     */
    public void showArray(int[][] ints) {
        if (ints==null){
            System.out.println("数组为空");
            return ;
        }
        for (int[] a : ints
        ) {
            for (int b : a
            ) {
                System.out.print(b + "\t");
            }
            System.out.println();
        }
    }

    /**
     * 将二维数组转变成稀疏数组
     */
    public int[][] toSparseArray(int[][] array) {
        int rowNum=array.length;
        int colNum=0;
        if (rowNum>0) colNum=array[0].length;

        int valNum=0;
        int count=0;
        //求二维数组中不为0的个数：
        for (int[] a:array) {
            for (int b:a) {
                if (b!=0) valNum++;
            }
        }
        //转变稀疏数组
        int[][] res = new int[valNum+1][3];
        //第一行对应原数组的行 列 和不为0的数
        res[0][0]=rowNum;
        res[0][1]=colNum;
        res[0][2]=valNum;

        //再把每一个值原来的位置记录
        for (int i = 0; i < rowNum; i++) {
            for (int j = 0; j <colNum ; j++) {
                if (array[i][j]!=0){
                    count++;
                    res[count][0]=i;
                    res[count][1]=j;
                    res[count][2]=array[i][j];
                }
            }
        }
        return res;
    }

    /**
     * 将稀疏数组转变成二维数组
     */
    public int[][] recoverArray(int[][] array){
        if (array==null) return null;
        int[][] res=new int[array[0][0]][array[0][1]];
        for (int i = 1; i < array.length; i++) {
            res[array[i][0]][array[i][1]]=array[i][2];
        }
        return res;
    }

    public static void main(String[] args) {
       SparseArray sparseArray = new SparseArray();
        int[][] ints = sparseArray.create(6, 6);
        ints[0][1] = 5;
        ints[1][2] = 8;
        ints[2][3] = 6;
        ints[3][0] = 9;
        sparseArray.showArray(ints);
        System.out.println("-----------转成稀疏数组-----------");
        int[][] sp = sparseArray.toSparseArray(ints);
        sparseArray.showArray(sp);
        System.out.println("------------恢复数组----------");
        int[][] recoverArray = sparseArray.recoverArray(sp);
        sparseArray.showArray(recoverArray);


    }
}

