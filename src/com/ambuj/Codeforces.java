package com.ambuj;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


//https://codeforces.com/problemset/problem/300/A
public class Codeforces {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];

        for(int i = 0; i< n; i++)
            a[i] = sc.nextInt();

        List<List<Integer>> list;

        if(n>=3) {
            list = getSets(n, a);

            for (List<Integer> List : list) {
                System.out.print(List.size() + " ");
                for (int i : List)
                    System.out.print(i + " ");
                System.out.println();
            }
        }
    }

    private static List<List<Integer>> getSets(int n, int[] a) {
        List<Integer> neg = new ArrayList<>();
        List<Integer> pos = new ArrayList<>();
        List<Integer> zero = new ArrayList<>();
        for(int i : a)
            if(i<0)
                neg.add(i);
            else if(i>0)
                pos.add(i);
            else zero.add(i);

        if(neg.size() + pos.size() +zero.size() > 3) {
            if (neg.size() % 2 == 0 && pos.size() > 0) {
                zero.add(neg.get(neg.size() - 1));
                neg.remove(neg.size() - 1);
            }
            else if (neg.size() % 2 == 0) {
                pos.add(neg.get(neg.size() - 1));
                pos.add(neg.get(neg.size() - 2));
                zero.add(neg.get(neg.size() - 3));
                neg.remove(neg.size() - 1);
                neg.remove(neg.size() - 1);
                neg.remove(neg.size() - 1);
            } else {
                pos.add(neg.get(neg.size() - 1));
                pos.add(neg.get(neg.size() - 2));
                neg.remove(neg.size() - 1);
                neg.remove(neg.size() - 1);
            }
        }
        List<List<Integer>> list = new ArrayList<>();
            list.add(neg);
            list.add(pos);
            list.add(zero);

            return list;

    }
}
