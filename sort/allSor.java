1.冒泡排序
思想：两两比较，大的后沉，最大结点在最后一位
重复这个过程，依次找到第二大……直至整个数组有序

public void bubble(int[] nums){
    int len = getLength(nums);
    for(int i = len-1; i > 0; i--){
        for(int j = 0; j < i; j++){
            if(nums[j] > nums[j+1]){
                int t = nums[j];
                nums[j] = nums[j+1];
                nums[j+1] = t;
            }
        }
    }
}

2.简单选择排序
思想：每次选出最小的与前面的交换

public void select(int[] nums){
    int len = getLength(nums);
    for(int i = 0; i < len; i++){
        int min = i;
        for(int j = len-1; j > i; j--){
            if(nums[j] < nums[min]){
                min = j;
            }
        }
        int t = s[i];
        s[i] = s[min];
        s[min] = t;
    }
}


3.直接插入排序
往有序表中插入数使之仍有序

public void insert(int[] nums){
    int len = getLength(nums);
    for(int i = 1; i < len; i++){
        //逐个向前比较，直到找到插入的地方
        if(nums[i] < nums[i-1]){
            int k = nums[i];
            for(int j = i-1; j >= 0 && nums[j] >= k; j--){
                nums[j+1] = nums[j];
            }
            nums[j+1] = k;//插入
        }
    }
}

4.希尔排序
分组的插入排序

public void shell(int[] nums){
    int len = getLength(nums);
    for(int gap = len/2; gap > 0; gap /= 2){
        for(int i = gap; i < len; i++){
            if(nums[i] < nums[i-gap]){
                int k = nums[i];
                for(int j = i-gap; j >= 0 && nums[j] >= k; j -= gap){
                    nums[j+gap] = nums[j];
                }
                nums[j+gap] = k;
            }
        }
    }
}

5.快速排序
挖坑填数
取一个数做基准，设置两个指针，高指针从后往前找比基准小的跟低指针指向的数交换。然后低指针从前往后找比
基准大的跟高指针指向的数交换，直至两指针相遇，把基准放入相遇的位置，第一轮结束，重复这个过程，直至整个序列
有序

public int findPas(int[] nums, int low, int high){
    int key = nums[low];
    while(low < high){
        while(low < high && nums[high] >= key){
            high--;
        }
        nums[low] = nums[high];
        while(low < high && nums[low] <= key){
            low++;
        }
        nums[high] = nums[low];
    }
    nums[low] = key;
    return low;
}

public void quick(int[] nums, int low, int high){
    if(low < high){
        int pas = findPas(nums, low, high);
        quick(nums, low, pas-1);
        quick(nums, pas+1，high);
    }
}

6.合并排序
将两个或两个以上的有序表合并成一个，使之仍有序

public void merge(int[] nums, int[] b, int start, int mid, int end){
    int i = start;
    int j = mid+1;
    int k = 0;
    if(start < end){
        while(i <= mid && j <= end){
            if(nums[i] <= nums[j]){
                b[k++] = nums[i++];
            }else{
                b[k++] = nums[j++];
            }
        }

        while(i <= mid){
            b[k++] = nums[i++];
        }
        while(j <= end){
            b[k++] = nums[j++];
        }

        for(int i = 0; i < k; i++){
            nums[i+start] = b[i];
        }
    }
}

public void Merge_Sort(int[] nums, int start, int end){
    if(start < end){
        int[] b = new int[nums.length];
        int mid = (start+end)/2;
        Merge_Sort(nums, start, mid);
        Merge_Sort(nums, mid+1, end);
        merge(nums, b, start, mid, end);
    }
}

7.堆排序
先建堆，每次取最后的元素跟堆顶元素交换，调整堆

public void adjust(int[] nums, int i, int n){
    int t = nums[i];
    int j = 2*i+1;//左孩子

    while(j < n){
        while(j+1 < n && nums[j+1] > t){
            j++;//右孩子
        }

        if(nums[j] < t){
            break;
        }

        nums[i] = nums[j];
        i = j;
        j = 2*i+1;
    }
    nums[i] = t;
}

public void heap(int[] nums, int n){
    //建堆,从第一个非叶子节点开始调整
    for(int i = (n-1)/2; i > 0; i--){
        adjust(nums, i, n);
    }

    for(int i = n-1; i > 0; i--){
        int t = nums[0];
        nums[0] = nums[i];
        nums[i] = t;

        adjust(nums, 0, i);
    }
}
