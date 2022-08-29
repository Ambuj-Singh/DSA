package com.ambuj;
//Find an element in an infinite sorted array
public class InfiniteBinarySearch {
    public static void main(String[] args) {

        int a[] = {3,5,7,9,10,90,100,130,140,160,170};
        int target = 7;
        System.out.println(ans(a,target));

    }

    static int ans(int[] a, int target){
        //first find the range
        //start with a box size of 2

        int start = 0, end = 1;

        while(a[end]< target){
            int temp = end + 1;
            //box_size =  (end - start + 1)
            //end = end +  (end - start + 1) * 2;
            end = end +  (end - start + 1) * 2;
            start = temp;
        }

        return binarySearchInfinite(a,target,start,end);
    }

    private static int binarySearchInfinite(int[] a, int target, int start, int end) {

        while(start <= end){
            int mid = start + (end - start)/2;

            if(a[mid] > target){
                end = mid - 1;
            }
            else if(a[mid] < target)
                start = mid + 1;
            else
                return mid;
        }

        return -1;
    }
}
