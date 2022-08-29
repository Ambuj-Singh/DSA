package com.ambuj;

import java.util.*;

public class SudokuValidation {
    public static void main(String[] args) {

        char[][] board =
        /*{{'5','3','.','.','7','.','.','.','.'},{'6','.','.','1','9','5','.','.','.'},{'.','9','8','.','.','.','.','6','.'},{'8','.','.','.','6','.','.','.','3'},{'4','.','.','8','.','3','.','.','1'},{'7','.','.','.','2','.','.','.','6'},{'.','6','.','.','.','.','2','8','.'},{'.','.','.','4','1','9','.','.','5'},{'.','.','.','.','8','.','.','7','9'}};
        System.out.println(isValidSudoku(board));*/
               /*{{'.','.','.','.','5','.','.','1','.'},
                {'.','4','.','3','.','.','.','.','.'},
                {'.','.','.','.','.','3','.','.','1'},
                {'8','.','.','.','.','.','.','2','.'},
                {'.','.','2','.','7','.','.','.','.'},
                {'.','1','5','.','.','.','.','.','.'},
                {'.','.','.','.','.','2','.','.','.'},
                {'.','2','.','9','.','.','.','.','.'},
                {'.','.','4','.','.','.','.','.','.'}};*/
        
                {{'.','.','.','.','8','.','.','.','.'}
                ,{'.','.','.','.','.','.','5','.','.'}
                ,{'.','.','.','.','4','.','.','2','.'}
                ,{'.','.','.','3','.','9','.','.','.'}
                ,{'.','.','1','8','.','.','9','.','.'}
                ,{'.','.','.','.','.','5','1','.','.'}
                ,{'.','.','3','.','.','8','.','.','.'}
                ,{'.','1','2','.','3','.','.','.','.'}
                ,{'.','.','.','.','.','7','.','.','1'}};
        char[][] board1 =
               {{'8','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}};

        System.out.println(isValidSudoku(board));
    }

    public static boolean isValidSudoku(char[][] board) {

        List<List<Character>> boxes = getBoxes(board);
        System.out.println(boxes);

        for(List<Character> list : boxes) {

            if (duplicates(list)) {
                return false;
            }
        }

        for(char[] c : board) {
            List<Character> list = convertToSimple(c);

            if (duplicates(list)) {
                return false;
            }
        }

       for(int j = 0; j < 9; j++) {
           List<Character> list = new ArrayList<>();

           for (int i = 0; i < 9; i++) {
               if(board[i][j] != '.')
                   list.add(board[i][j]);
           }
           if (duplicates(list)){
               return false;
           }
           System.out.println();
       }

       return true;

    }

    private static List<List<Character>> getBoxes(char[][] board) {
        List<List<Character>> boxes = new ArrayList<>();

        List<List<Character>> boxesSorted = new ArrayList<>();

        for(char[] c : board) {
            List<Character> box = new ArrayList<>();
            for (int i = 0; i < 9 ; i++) {
                if(c[i] != '.')
                 box.add(c[i]);
                if (((i + 1 )% 3) == 0) {
                    boxes.add(box);
                    box = new ArrayList<>();
                }

            }
        }

        for (int i = 0; i < 21; i++){
            List<Character> trueBox = new ArrayList<>();
            trueBox.addAll(boxes.get(i));
            trueBox.addAll(boxes.get(i+3));
            trueBox.addAll(boxes.get(i+6));
            boxesSorted.add(trueBox);
            if((i == 2) || (i == 11)){
                i = i + 6;
            }
        }
        return boxesSorted;
    }

    private static List<Character> convertToSimple(char[] c) {
        List<Character> list = new ArrayList<>();

        for (char i : c)
            if(i != '.')
                list.add(i);
        return list;
    }

    public static boolean duplicates(List<Character> list){
        for (char i : list)
         if(Collections.frequency(list, i) > 1)
            return true;
        return false;
    }
    public static boolean duplicates(char[] arr){
        List<Character> list = new ArrayList<>();
        for(char i : arr)
            list.add(i);
        for (char i : list)
            if(Collections.frequency(list, i) > 1)
                return true;
        return false;
    }
}

