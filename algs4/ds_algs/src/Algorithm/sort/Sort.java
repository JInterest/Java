package Algorithm.sort;

/**
 * @Auther: AJun
 * @version:1.0
 * @Date: 2020/08/29  21:09
 * @Description: 对一个数组的各种排序
 */
public class Sort {

    public static void main(String[] args) {
        Sort sort = new Sort();
        //数组容量
        int capacity = 8000000;
        int[] array = new int[capacity];
        for (int i = 0; i < capacity; i++) {
            array[i] = (int) (Math.random() * 888888);
        }
        //Date begin = new Date();
        //SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");


        long begin = System.currentTimeMillis();
        // 8w 数据测试下
        //测试冒泡排序  ---13151/ms
        //int[] ints = sort.bubbleSort(array);

        //测试选择排序  ---3288/ms
        //int[] ints = sort.selectSort(array);

        //测试插入排序  ---833/ms
        //int[] ints = sort.insertSort(array);

        //测试希尔排序(交换式)  ---7462/ms
        //int[] ints = sort.shellSort1(array);

        //测试希尔排序(移位式)  ---时间稳定 23/ms  800w  2771/ms             y
        //int[] ints = sort.shellSort2(array);

        //测快速排序  ---时间不稳定 20-40/ms  800w  1269/ms                 y
        //int[] ints = sort.quickSort(array,0,array.length-1);

        //测归并排序 ---时间稳定 16/ms  800w 1375/ms                        y
        //sort.mergeSort(array,0,array.length-1,new int[array.length]);

        //测基数排序 ---时间稳定 35/ms  800w  514/ms
        //sort.radixSort(array);

        //测试堆排序  ---时间稳定 16/ms   800w  2584/ms                     y
        sort.heapSort(array);

        long end = System.currentTimeMillis();

        //System.out.println(Arrays.toString(array));

        System.out.println("排序容量为[" + capacity + "]的数组所花费的时间" + (end - begin) + "/ms");
    }

    /**
     * 冒泡排序
     */
    public int[] bubbleSort(int[] array) {

        int length = array.length;
        Boolean flag = false;
        int temp;

        for (int j = 0; j < length - 1; j++) {
            //排序一次得到一个最大的数，这个数下次不参与排序 ，排序数量减一
            for (int i = 0; i < length - 1 - j; i++) {
                //当前数与下一个做比较
                if (array[i] > array[i + 1]) {
                    flag = true;
                    temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                }
            }
            //如果flag=false  说明数组已经排好序，没有发生交换
            if (!flag) {
                break;
            } else {
                //重置标志信号flag
                flag = false;
            }
        }

        return array;
    }

    /**
     * 选择排序
     */
    public int[] selectSort(int[] array) {
        int length = array.length;

        for (int i = 0; i < length - 1; i++) {
            //假设第i个是最小值
            int index = i;
            int min = array[i];
            for (int j = i + 1; j < length; j++) {
                if (min > array[j]) {
                    index = j;
                    min = array[j];
                }
            }
            //发现了更小的再交换
            if (index != i) {
                array[index] = array[i];
                array[i] = min;
            }
        }
        return array;
    }

    /**
     * 插入排序
     */
    public int[] insertSort(int[] array) {
        int length = array.length;
        //默认第一个是正确的，从第二个开始
        for (int i = 1; i < length; i++) {
            int insertVal = array[i];//取出当前值保存
            int index = i - 1; //找到前一个数

            //循环一次指针减一 直到与前面的数比较完大小。
            while (index >= 0 && insertVal < array[index]) {
                //将比它大的数往后移
                array[index+1]=array[index];
                index--;
            }
            // 跳出循环的指针在需要插入的前一个位置 所以需要+1
            array[index+1]=insertVal;
        }

        return array;
    }

    /**
     * 希尔排序（交换式）
     */
    public int[] shellSort1(int[] array){
        int temp;
        int length = array.length;
        //依次对半分组，前面几次分组按步长将左右两个区域大小整体划分 ，
        //最后一次gap=1 就是正常的插入排序，此时只需一点点改变就可以了。
        for (int gap = length/2; gap >0 ; gap /= 2) {
            //步长决定走完全部数的次数
            for (int i = gap; i <length; i++) {
                //每一组的数进行插入排序
                for (int j = i-gap; j >= 0 ; j -= gap) {
                    if (array[j]>array[j+gap]){
                        temp=array[j];
                        array[j]=array[j+gap];
                        array[j+gap]=temp;
                    }
                }
            }
        }
        return array;
    }

    /**
     * 希尔排序(移位式)
     */
    public int[] shellSort2(int[] array){
        int length = array.length;

        for (int gap = length/2; gap >0 ; gap /= 2) {
            for (int i = gap; i <length; i++) {
                int index = i;
                int value = array[index];
                //取出指针位置的值与前面的值比较 ， 如果小于 则将前面那个数后移
                while (index-gap >= 0 && value < array[index-gap] ){
                    array[index]=array[index-gap];
                    index -= gap;
                }
                //结束循环 找到合适位置
                array[index]=value;
            }
        }
        return array;
    }

    /**
     * 快速排序
     */
    public int[] quickSort(int[] array,int begin,int end){
        if (begin<end){
            int temp = array[begin];//取出区间第一个做基准数
            int i = begin;//左指针
            int j = end;//右指针
            while (i<j){
                while (i<j && array[j]>temp){
                    j--; //右指针对应值 大于基准值 左移
                }
                //小于则填入左边对应的位置 array[i]
                array[i]=array[j];

                while (i<j && array[i]<=temp){
                    i++; //左指针对应值 小于基准值 右移
                }
                //小于则填入右边对应的位置 array[i]
                array[j]=array[i];
            }

            //将基准数放到左右指针重叠的位置  此位置左边的数小于右边的数
            array[i]=temp;//i=j

            //递归左右两边的数
            //对基准元素的左边子区间进行相似的快速排序

            quickSort(array,begin,i-1);

            //对基准元素的右边子区间进行相似的快速排序

            quickSort(array,i+1,end);
        }

        return array;
    }

    /**
     * 归并排序（分+治）
     */
    public int [] mergeSort(int[] array,int left, int right, int[] temp){
        if (left<right){
            int mid = (left+right)/2;
            //左右分到最小
            mergeSort(array,left,mid,temp);
            mergeSort(array,mid+1,right,temp);
            //分完开始进行排序，然后合并
            merge(array,left,mid,right,temp);
        }

        return array;
    }

    /**
     * 归并排序（合）
     */
    public void merge(int[] array,int left, int mid,  int right,int[] temp){
        //定义左右指针
        int i = left;
        int j = mid+1;
        int t = 0; //temp 的指针

        //(一)
        //先把左右两边(有序)的数据按照规则填充到temp数组
        //直到左右两边的有序序列，有一边处理完毕为止
        while (i <= mid && j <= right) {//继续
            //如果左边的有序序列的当前元素，小于等于右边有序序列的当前元素
            //即将左边的当前元素，填充到 temp数组
            //然后 t++, i++
            if(array[i] <= array[j]) {
                temp[t] = array[i];
                t += 1;
                i += 1;
            } else { //反之,将右边有序序列的当前元素，填充到temp数组
                temp[t] = array[j];
                t += 1;
                j += 1;
            }
        }

        //(二)
        //把有剩余数据的一边的数据依次全部填充到temp
        while( i <= mid) { //左边的有序序列还有剩余的元素，就全部填充到temp
            temp[t] = array[i];
            t += 1;
            i += 1;
        }

        while( j <= right) { //右边的有序序列还有剩余的元素，就全部填充到temp
            temp[t] = array[j];
            t += 1;
            j += 1;
        }

        //(三)
        //将temp数组的元素拷贝到arr
        //注意，并不是每次都拷贝所有
        t = 0;
        int tempLeft = left; //
        //第一次合并 tempLeft = 0 , right = 1 //  tempLeft = 2  right = 3 // tL=0 ri=3
        //最后一次 tempLeft = 0  right = 7
        while(tempLeft <= right) {
            array[tempLeft] = temp[t];
            t += 1;
            tempLeft += 1;
        }
    }

    /**
     *  基数排序  空间换时间
     */
    public int[] radixSort(int[] arr) {

        //1. 得到数组中最大的数的位数
        int max = arr[0]; //假设第一数就是最大数
        for(int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        //得到最大数是几位数
        int maxLength = (max + "").length();

        //定义一个二维数组，表示10个桶, 每个桶就是一个一维数组
        //说明
        //1. 二维数组包含10个一维数组
        //2. 为了防止在放入数的时候，数据溢出，则每个一维数组(桶)，大小定为arr.length
        //3. 名明确，基数排序是使用空间换时间的经典算法
        int[][] bucket = new int[10][arr.length];

        //为了记录每个桶中，实际存放了多少个数据,我们定义一个一维数组来记录各个桶的每次放入的数据个数
        //可以这里理解
        //比如：bucketElementCounts[0] , 记录的就是  bucket[0] 桶的放入数据个数
        int[] bucketElementCounts = new int[10];

        //这里我们使用循环将代码处理
        for(int i = 0 , n = 1; i < maxLength; i++, n *= 10) {
            //(针对每个元素的对应位进行排序处理)， 第一次是个位，第二次是十位，第三次是百位..
            for(int j = 0; j < arr.length; j++) {
                //取出每个元素的对应位的值
                int digitOfElement = arr[j] / n % 10;
                //放入到对应的桶中
                bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[j];
                bucketElementCounts[digitOfElement]++;
            }
            //按照这个桶的顺序(一维数组的下标依次取出数据，放入原来数组)
            int index = 0;
            //遍历每一桶，并将桶中是数据，放入到原数组
            for(int k = 0; k < bucketElementCounts.length; k++) {
                //如果桶中，有数据，我们才放入到原数组
                if(bucketElementCounts[k] != 0) {
                    //循环该桶即第k个桶(即第k个一维数组), 放入
                    for(int l = 0; l < bucketElementCounts[k]; l++) {
                        //取出元素放入到arr
                        arr[index++] = bucket[k][l];
                    }
                }
                //第i+1轮处理后，需要将每个 bucketElementCounts[k] = 0 ！！！！
                bucketElementCounts[k] = 0;
            }
        }
        return arr;
    }

    /**
     * 堆排序(一种选择排序)
     */
    public  void heapSort(int arr[]) {
        int temp = 0;
        System.out.println("堆排序!!");

        //1）将无序序列构建成一个堆，根据升序降序需求选择大顶堆或小顶堆
        //求出非叶子节点个数
        for(int i = arr.length / 2 -1; i >=0; i--) {
            adjustHeap(arr, i, arr.length);
        }

		/*
		  2).将堆顶元素与末尾元素交换，将最大元素"沉"到数组末端;
　　		  3).重新调整结构，使其满足堆定义，然后继续交换堆顶元素与当前末尾元素，反复执行调整+交换步骤，直到整个序列有序。
		 */
        for(int j = arr.length-1;j >0; j--) {
            //交换
            temp = arr[j];
            arr[j] = arr[0];
            arr[0] = temp;
            adjustHeap(arr, 0, j);
        }

    }


    /**
     * 功能： 完成 将 以 i 对应的非叶子结点的树调整成大顶堆
     * 举例  int arr[] = {4, 6, 8, 5, 9}; => i = 1 => adjustHeap => 得到 {4, 9, 8, 5, 6}
     * 如果我们再次调用  adjustHeap 传入的是 i = 0 => 得到 {4, 9, 8, 5, 6} => {9,6,8,5, 4}
     * @param arr 待调整的数组
     * @param i 表示非叶子结点在数组中索引
     * @param length 表示对多少个元素继续调整， length 是在逐渐的减少
     */
    public  void adjustHeap(int arr[], int i, int length) {

        int temp = arr[i];//先取出当前元素的值，保存在临时变量
        //开始调整
        //1. k = i * 2 + 1 k 是 i结点的左子结点
        for(int k = i * 2 + 1; k < length; k = k * 2 + 1) {
            if(k+1 < length && arr[k] < arr[k+1]) { //说明左子结点的值小于右子结点的值
                k++; // k 指向右子结点
            }
            if(arr[k] > temp) { //如果子结点大于父结点
                arr[i] = arr[k]; //把较大的值赋给当前结点
                i = k; //!!! i 指向 k,继续循环比较
            } else {
                break;//!
            }
        }
        //当for 循环结束后，我们已经将以i 为父结点的树的最大值，放在了 最顶(局部)
        arr[i] = temp;//将temp值放到调整后的位置
    }
}
