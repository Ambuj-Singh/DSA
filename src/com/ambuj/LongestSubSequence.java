package com.ambuj;

import java.io.IOException;
import java.util.*;

public class LongestSubSequence {
    public static void main(String[] args) {


            int[] a = {0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
            System.out.println(longestConsecutive(new int[]{0}));

    }
   /* public static int longestConsecutive(int[] nums) {
        Arrays.sort(nums);
        List<Integer> list = new ArrayList<>();
        int count = 0;
        for(int i = 1; i< nums.length; i++){
            if((nums[i]-nums[i-1])==1)
                count+=1;
            else {
                list.add(count+1);
                count = 0;
            }
            if(i==nums.length-1){
                list.add(count+1);
                count = 0;
            }
        }

        return Collections.max(list);
    }*/
   public static int longestConsecutive(int[] nums) {
       if(nums.length>1){
           Arrays.sort(nums);
           List<Integer> list = new ArrayList<>();
           int count = 0;
           for(int i = 1; i< nums.length; i++){
               if((nums[i]-nums[i-1])==1)
                   count+=1;
               else{
                   list.add(count+1);
                   count = 0;
               }
               if(i==nums.length-1){
                   list.add(count+1);
                   count = 0;
               }
           }
           Collections.sort(list);

           return list.get(list.size()-1);
       }
       else if(nums.length == 1)
           return 1;
       else
           return 0;
   }
}
