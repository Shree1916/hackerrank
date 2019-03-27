import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the isValid function below.
    static String isValid(String s) {

        int[] alphabets = new int[26];

        for(int i=0;i<s.length();i++){
            alphabets[s.charAt(i) - 'a']++;
        }

        Arrays.sort(alphabets);
        int i = 0;
        while(alphabets[i] == 0){
            i++;
        }

        int maxFreq = alphabets[25];
        int minFreq = alphabets[i];

        if(minFreq == maxFreq){
            return "YES";
        }else if(((maxFreq-minFreq==1) && (alphabets[24]==maxFreq-1)) || 
                            ((minFreq==1) && (alphabets[i+1] == maxFreq))){
            return "YES";
        }

        return "NO";
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        String result = isValid(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
