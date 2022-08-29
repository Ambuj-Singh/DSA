package com.ambuj;
//https://leetcode.com/problems/search-in-rotated-sorted-array
public class SortedRotatedArray {
    public static void main(String[] args) {
        int[] nums = {3,4,5,6,1,2};
        int n = nums.length;
        int target = 2;

        int peak = getPivot(nums,n);

        if(nums[peak] == nums[n-1])
            System.out.println(binarySearchRotated(nums,0,n-1,target));
        else
        {
            int firstHalf = binarySearchRotated(nums,0,peak,target);
            int secondHalf = binarySearchRotated(nums,peak+1,n-1,target);

            if(firstHalf>=0)
                System.out.println(firstHalf);
            else if(secondHalf>=0)
                System.out.println(secondHalf);
            else
                System.out.println(-1);;
        }
    }
//will not work for the duplicate elements
    public static int getPivot(int[] a, int n){
        int start = 0;
        int end = a.length - 1;

        while(start <= end){
            int mid = start + (end - start)/2;

            //4 cases
            if(mid<end && a[mid] > a[mid + 1])
                return mid;
            if(mid > start && a[mid] < a[mid-1])
                return mid-1;
            if(a[mid] <= a[start])
                end = mid - 1;
            else
                start = mid + 1;
        }
        return -1;
    }

    public static int getPivotDuplicates(int[] a, int n){
        int start = 0;
        int end = a.length - 1;

        while(start <= end){
            int mid = start + (end - start)/2;

            //4 cases
            if(mid<end && a[mid] > a[mid + 1])
                return mid;
            if(mid > start && a[mid] < a[mid-1])
                return mid-1;
            if(a[mid] == a[start] && a[mid] == a[end]) {
                //check if the start and end are pivot or not
                //else skip the duplicates
                if (a[start] > a[start + 1])
                    return start;
                start++;
                if(a[end] < a[end-1])
                    return end-1;
                end--;
            }
            //left side is sorted, so pivot should be in right
            else if(a[start] < a[mid] || a[mid] ==  a[start] && a[mid]> a[end]){
                start = mid + 1;
            }
            else
                end = mid - 1;
        }
        return -1;
    }

    public static int binarySearchRotated(int[] a,int start, int end, int target){

        while(start<=end){
            int mid = start + (end - start)/2;

            if(a[mid] == target)
                return mid;
            else if(a[mid] < target)
                start = mid + 1;
            else
                end = mid - 1;
        }

        return -1;
    }
}