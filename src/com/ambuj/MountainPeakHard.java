package com.ambuj;
//https://leetcode.com/problems/find-in-mountain-array/
public class MountainPeakHard {
    public static void main(String[] args) {

        int[] a = {1,2,3,4,5,3,1};
        int n = a.length;
        int peak_index = peak(a,n);
        int target = 2;
        int start_1 = binarySearchMountain(a,0,peak_index,target);

        int start_2 =  binarySearchMountain(a,peak_index+1,n-1,target);


        System.out.println(start_1 +  ";" + start_2);
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

        return start;
    }

    static int binarySearchMountain(int[] a, int start, int end, int target){
            int index = -1;
        if(start != 0){
            while(start<=end){
                int mid = start + (end - start)/2;

            if(a[mid] == target){
                index = mid;
                    end = mid - 1;

            }
            else if(a[mid] > target)
                start = mid + 1;
            else
                end = mid - 1;
        }
        }
        else{
            while(start<=end){
                int mid = start + (end - start)/2;

                if(a[mid] == target){
                    index = mid;
                        end = mid - 1;
                }
                else if(a[mid] < target)
                    start = mid + 1;
                else
                    end = mid - 1;
            }
            return index;
        }
        return index;
    }
}
