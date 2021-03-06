package com.zyh.code.binarysearch;

/**
 * @author zhangyinghui  Date: 2020/9/9 Time: 2:57 PM
 */
public class Search {


    public int search2(int[] nums, int start, int end, int target) {
        //临界条件
        if (start==end) {
            if (nums[start] == target) {
                return start;
            } else {
                return -1;
            }
        }
        //递归
        int middle = (end-start)/2 + start;
        if (target>nums[middle]) {
            return search2(nums, middle+1, end, target);
        } else if (target==nums[middle]) {
            return middle;
        } else {
            return search2(nums, start, middle-1, target);
        }

    }
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int startIndex = 0;
        int endIndex = nums.length - 1;

        while (startIndex <= endIndex) {
            int middleIndex = (endIndex - startIndex) / 2 + startIndex;
            if (target > nums[middleIndex]) {
                startIndex = middleIndex + 1;
            } else if (target == nums[middleIndex]) {
                return middleIndex;
            } else {
                endIndex = middleIndex - 1;
            }
        }
        return -1;
    }

    //类似二分查找,题目是插入这个元素,找到插入的位置,如果相等则在其前面插入
    public static int search1(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int startIndex = 0;
        int endIndex = nums.length - 1;

        while (startIndex < endIndex) {
            int middleIndex = (endIndex - startIndex) / 2 + startIndex;
            if (target > nums[middleIndex]) {
                startIndex = middleIndex + 1;
            } else if (target == nums[middleIndex]) {
                return middleIndex;
            } else {
                endIndex = middleIndex - 1;
            }
        }
        if (nums[startIndex] >= target) {
            return startIndex;
        } else {
            return startIndex + 1;
        }
    }

    public static void main(String[] args) {
        System.out.println(search1(new int[]{1,3}, 2));
    }
}
