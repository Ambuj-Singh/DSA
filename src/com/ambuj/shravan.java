package com.ambuj;

import java.util.List;

public class shravan {
    public static void main(String[] args) {
        int n = 55;
        int count = 0, one = 0;
        while(n!=0){
            if(n%2==1) {
             count++;
                one++;
            }
            else{
                count++;
            }
            n = n/2;
        }
        int mod = count % one;
        int offset = mod % 26;

        char c = (char)(64 + offset);
        String s ="";

        while(one!=0){
            one--;
            s = s+"1"+c;
            c++;
        }
        System.out.println(s);
    }
}
