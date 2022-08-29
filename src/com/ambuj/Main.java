package com.ambuj;

import java.text.SimpleDateFormat;
import java.util.*;

public class Main {
    int t = 20;
    static int b = 30;
    public static void main(String[] args) {

      /*  long timestamp = System.currentTimeMillis();
        SimpleDateFormat sdf = new SimpleDateFormat("yyMMddhhmmss");
        System.out.println(sdf.format(new Date(timestamp)));*/

      /*  HashMap<String, Integer> map = new HashMap<>();
        LinkedHashMap<String, Integer> sortedMap = new LinkedHashMap<>();
        ArrayList<Integer> list = new ArrayList<>();
        map.put("0", 5);
        map.put("1", 7);
        map.put("2", 3);
        map.put("3", 1);
        map.put("4", 1);
        map.put("5", 4);
        map.put("6", 4);
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            list.add(entry.getValue());
        }
        Collections.sort(list);
        for (int num : list) {
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                if (entry.getValue().equals(num)) {
                    sortedMap.put(entry.getKey(), num);
                }
            }
        }
        System.out.println(sortedMap);*/

        String s = "357110a73eb2a37213da436de6f7ce3ef4ab21bfc01aff9b016637b8adfa2296";
        String s1 = "357110a73eb2a37213da436de6f7ce3ef4ab21bfc01aff9b016637b8adfa2296";
        System.out.println(s.equals(s1));

}

    private static char ceilingLeetCode(char[] a, int n, char find) {
        int start = 0,end = n-1;

        while(start <= end){
            int mid = start + (end - start)/2;

            if(a[mid] > find){
                end = mid - 1;
            }
            else
                start = mid + 1;
        }

        return a[start % n];
    }

    public static int ceiling(int[] a,int n,int find){
        int start = 0,end = n;

        if(a[end - 1] < find){
            System.out.println("No Ceiling of the number for " + find );
            return find;
        }
        while(start <= end){
            int mid = start + (end - start)/2;

            if(a[mid]==find){
                return find;
            }
            else if(a[mid] > find){
                end = mid - 1;
            }
            else
                start = mid + 1;
        }

        return a[start];
    }

    public static int floor(int[] a,int n,int find){
        int start = 0,end = n;

        if(a[start] > find){
            System.out.println("No Floor of the number for " + find );
            return find;
        }
        while(start <= end){
            int mid = start + (end - start)/2;

            if(a[mid]==find){
                return find;
            }
            else if(a[mid] > find){
                end = mid - 1;
            }
            else {

                start = mid + 1;
            }
        }

        return a[end];
    }
}
