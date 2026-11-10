import java.io.PrintWriter;
import java.util.ArrayList;

public class Recursion {

    //PRE: the function accepts a value that is an integer
    //POST: the function should determine that the value passed is positive
    // if so, return an integer that is the factorial of the value passed
    // Recursively, 𝑛! = 𝑛 × (𝑛 − 1)! And 0! = 1
    public static long factorialR(long value){
        if (value < 0) {
            throw new IllegalArgumentException(value + "must be a non-negative integer");
        }
        else if(value == 0 || value == 1){
            return 1;
        }
        //Used Copilot to help with recursion logic for factorial and handle overflow
        else{
            return Math.multiplyExact(value, factorialR(value - 1));
        }
    }
    //PRE: Accepts a string and a starting (0) and ending (length – 1) position in the string
    //POST: Returns true if the string is the same forwards and backwards, false otherwise
    public static boolean palindromeR(String str, int start, int end){
        if (str == null || str.isEmpty()) {
            return false;
        }
        if (start >= end) {
            return true;
        }
        if (str.length() == 1) {
            return true;
        }
        if (str.charAt(start) != str.charAt(end)) {
            return false;
        }
        //Used copilot to help with recursion logic for palindromeR
        return palindromeR(str, start + 1, end - 1);
    }
    //Used lecture 12 notes to assist with recursion logic for reverseStringR
    public static void reverseStringR(PrintWriter outputWriter, String str){
        if (str.length() < 1) {
            return;
        } else if (str.length() >= 1) {
            outputWriter.print(str.charAt(str.length() - 1));
            reverseStringR(outputWriter, str.substring(0, str.length() - 1));
        }

    }
    //PRE: accepts a value to evaluate (ex: 27)
    // and the next divisor to check (beginning at 2)
    //POST: if the value can be evenly divided by the divisor, return false
    // else, check isPrimeR with the next divisor
    public static boolean isPrimeR(int value, int n) {
        if (value != (int) value){
            throw new IllegalArgumentException(value + "must be an integer");
        }
        if (value % n == 0){
            return false;
        }
        if (value % n ==1){
            return true;
        }

        return isPrimeR(value, n +1);
    }
    //PRE: Accepts an ArrayList of values entered by the user
    //and a starting position value (0)
    //POST: returns the total sum of the values in the ArrayList
    public static int sumR(PrintWriter outputWriter, ArrayList<Integer> nums, int pos) {
        if (pos >= nums.size()){
            return 0;
        }
        return nums.get(pos) + sumR(outputWriter, nums, pos + 1);
    }
 

}

   