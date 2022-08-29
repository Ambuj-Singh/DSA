package com.ambuj;
//https://leetcode.com/problems/top-k-frequent-elements/
//https://neetcode.io/
import java.util.*;

public class TopKElements {
    public static void main(String[] args) {
        int nums[] = {1,1,1,1,-1,-2,-2,-3,3,3,3,3,3};
        int k = 2;
        topKFrequent(nums, k);
    }
    public static void topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i : nums)
        {
            map.put(i, map.getOrDefault(i,0) + 1);
        }

        PriorityQueue<Node> pq = new PriorityQueue<Node>(new NodeComparator());

        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            Node node = new Node(entry.getKey(), entry.getValue());
            pq.add(node);
        }

        List<Integer> list = new ArrayList<>();

        for(int i = 0; i < k; i++) {
            list.add(pq.poll().getNum());
        }

        System.out.println(list);
    }

}


class Node {
    int num;
    int freq;

    public Node(int num,int freq){
        this.num = num;
        this.freq = freq;
    }

    public int getFreq(){
        return freq;
    }
    public int getNum(){
        return this.num;
    }
}

class NodeComparator implements Comparator<Node> {
    public int compare(Node cur, Node next) {
        return next.freq - cur.freq;
    }
}