package com.ambuj;

import java.util.Collections;
import java.util.Vector;

public class Marginalizing {
    public static void main(String[] args) {
        int[] a = {1,3,4,4,4,5};
        int k = 3;
        Vector<Integer> v = new Vector<>();

        for(int i = 1;i<a.length-1;i++){
            v.add((a[i-1] - a[i]));
        }
        Collections.sort(v);

        int result = a[a.length-1] - a[0];

        for(int i=0;i<k-1;i++)
            result +=v.get(i);

        System.out.println(result);
    }
}
