package com.ambuj;

import java.util.*;

public class StringChallenge {
    public static void main(String[] args) {
        String s = "fun&!! time";
            s=s.replaceAll("\\p{Punct}", "");
        String[] a = s.split(" ");
        List<Integer> li = new ArrayList<>();

        HashMap<Integer, List<String>> map = new HashMap<>();
        for (String i : a){
            int len = i.length();
            li.add(len);
            List<String> list = new ArrayList<>();
            if(map.containsKey(len)){
                list = map.get(len);
                list.add(i);
                map.put(len,list);
            }
            else {
                list.add(i);
            }
            map.put(len,list);
        }

   String sen = "";
        Collections.sort(li);
        sen = map.get(li.get(li.size()-1)).get(0);

    /*   for (int i : li){
           if(map.get(i).size()>=2){
               sen = map.get(i).get(0);
               break;
           }
       }*/
        sen = sen.substring(0,sen.length()-1)+"_8xg_0sk_j5f_";
        System.out.println(sen);
    }
}
