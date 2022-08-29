package com.ambuj;

import java.util.HashMap;
import java.util.List;

public class StringChallenge2 {
    public static void main(String[] args) {
        String str = "wwwggop";
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i = 0; i< str.length();i++){
            char c = str.charAt(i);
            if(map.containsKey(c)){
                int a = map.get(c);
                a++;
                map.put(c,a);
            }
            else {
                map.put(c,1);
            }
        }
        int n = str.length()-1;
        int g =0;
        while(g<=n){
            char c = str.charAt(g);
            System.out.print(map.get(c)+""+c);
            g=g+map.get(c);
        }
    }
}
