package com.young;
import java.lang.Math;
import java.util.*;

public class TicTacToe {
    public static int[] winTable = { 0B000000111,
            0B000111000,
            0B111000000,
            0B001001001,
            0B010010010,
            0B100100100,
            0B100010001,
            0B001010100};

    public static void main(String[] args) {
        // write your code here
        Scanner scanner = new Scanner(System.in);
        // System.out.print("Enter cells: ");
        // String words = scanner.nextLine();
        String words = "_________";
        paint(words);

        boolean whoami = true;
        while (true) {
            while (true){
                System.out.print("Enter the coordinates:");
                int[] arr = Arrays.stream(scanner.nextLine().split(" ")).mapToInt( x -> Integer.parseInt(x)).toArray();
                if ( arr[0] > 3 || arr[0] < 1 || arr[1] > 3 || arr[1] < 1) {
                    System.out.println("Coordinates should be from 1 to 3!");
                } else if (words.charAt((3 - arr[1]) * 3 + arr[0] - 1) != '_') {
                    System.out.println("This cell is occupied! Choose another one!");
                } else {
                    whoami = !whoami;
                    StringBuilder state = new StringBuilder(words);
                    state.setCharAt((3 - arr[1]) * 3 + arr[0] - 1, whoami? 'O': 'X');
                    words = state.toString();
                    break;
                }
            }
            paint(words);
            // if (chkImpossible(words)) {
            //     System.out.println("Impossible");
            // } else if (chkRow(words, 'O') && chkRow(words, 'X')) {
            //     System.out.println("Impossible");
            if (chkRow(words, 'O')) {
                System.out.println("O wins");
                break;
            } else if (chkRow(words, 'X')) {
                System.out.println("X wins");
                break;
            } else if (chkFinish(words)) {
                continue;
                // System.out.println("Game not finished");
            } else {
                System.out.println("Draw");
                break;
            }
        }
    }

    public static void paint(String words){
        System.out.println("---------");
        for (int i=0; i < 3; i++) {
            System.out.print("| ");
            for(int j=0; j < 3; j++) {
                System.out.print(words.charAt(i * 3 + j) + " ");
            }
            System.out.println("|");
        }
        System.out.println("---------");
    }
    public static boolean chkFinish (String words) {
        for(int i = 0; i < words.length(); i++){
            if (words.charAt(i) == '_'){
                return true;
            }
        }
        return false;
    }
    public static boolean chkRow(String words, char sign) {
        for (int i=0; i < 3; i++){
            if (words.charAt(i*3) == words.charAt(i*3 +1)  && words.charAt(i*3) == words.charAt(i*3 +2)) {
                if (words.charAt(i*3) == sign) {
                    return true;
                }
            } else if (words.charAt(i) == words.charAt(i+3)  && words.charAt(i) == words.charAt(i+6)) {
                if (words.charAt(i) == sign) {
                    return true;
                }
            } else if (words.charAt(i) == words.charAt(4)  && words.charAt(i) == words.charAt(8-i)) {
                if (words.charAt(i) == sign) {
                    return true;
                }
            }
        }
        return false;
    }
    public static boolean chkImpossible(String words){
        int countO = 0;
        int countX = 0;
        for(int i = 0; i < words.length(); i++){
            if (words.charAt(i) == 'O') {
                countO++;
            } else if (words.charAt(i) == 'X') {
                countX++;
            }
        }
        if (Math.abs(countX - countO) >= 2){
            return true;
        } else {
            return false;
        }
    }
}