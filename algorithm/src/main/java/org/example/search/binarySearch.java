package org.example.search;

public class binarySearch {

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        int i = left_bound(nums, 3);
        System.out.println(i);
    }

    public static int binarySearch(int[] nums, int target) {
        int left = 0;
        // 注意
        int right = nums.length - 1;

        while(left <= right) {
            //两个整数相除，结果将去除小数点。如：5/2=2
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                // mid为什么加1，因为mid已经比较过了，下次只用比较[mid+1,right]
                left = mid + 1;
            } else if (nums[mid] > target) {
                // mid为什么减1，因为mid已经比较过了，下次只用比较[left,mid-1]
                right = mid - 1;
            } else if(nums[mid] == target) {
                //直接返回
                return mid;
            }
        }
        return -1;
    }

    public static int left_bound(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] == target) {
                // 别返回，收紧右侧边界,锁定左侧边界
                right = mid - 1;
            }
        }
        // 最后要检查 left 越界的情况
        if (left >= nums.length || nums[left] != target) {
            return -1;
        }
        return left;
    }

    public static int right_bound(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] == target) {
                // 别返回，收紧左侧边界，锁定右侧边界
                left = mid + 1;
            }
        }
        // 最后要检查 right 越界的情况
        if (right < 0 || nums[right] != target) {
            return -1;
        }
        return right;
    }
}
