package com.ambuj;
//https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
public class LeetCodeStartEnd {
    public static void main(String[] args) {
        int[] a = {1,2,3,3,3,5,5,6,7,7,7,8};

        int target = 7;
        int[] b =searchFirstLast(a,target);

        System.out.println("["+b[0]+","+b[1]+"]");
    }

    public static int[] searchFirstLast(int[] nums, int target ) {
        int start = 0, end = nums.length - 1;
        int[] a = new int[2];
        if(end >= 0){
            while (start <= end) {
                int mid = start + (end - start) / 2;

                if (nums[mid] == target) {
                    a[0] = mid;
                    end = mid - 1;
                } else if (target < nums[mid])
                    end = mid - 1;
                else
                    start = mid + 1;
            }
            start = 0;
            end = nums.length - 1;
            while (start <= end) {
                int mid = start + (end - start) / 2;

                if (nums[mid] == target) {
                    a[1] = mid;
                    start = mid + 1;
                } else if (target < nums[mid])
                    end = mid - 1;
                else
                    start = mid + 1;
            }
        }

        else{
            a[0] = -1;
            a[1] = -1;
            return a;
        }
        if (!((nums[a[0]] == target) && (nums[a[1]] == target))) {
            a[0] = -1;
            a[1] = -1;
        }
        else return a;

        return a;

    }
}
