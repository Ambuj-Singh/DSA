package com.ambuj;
//https://leetcode.com/problems/peak-index-in-a-mountain-array/
public class MountainPeak {
    public static void main(String[] args) {
         int a[] = {3,4,5,6,7,2};
         int n = a.length;

        System.out.println(peak(a,n));
    }

    static int peak(int a[], int n){
        int start = 0, end = n-1;

        while(start < end){
            int mid = start + (end - start)/2;

            if(a[mid] < a[mid + 1]){
                start = mid + 1;
            }
            else
                end = mid;

        }

        return a[start];
    }
}
