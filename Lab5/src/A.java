import java.io.PrintWriter;
import java.util.Scanner;

public class A {
    static Scanner cin = new Scanner(System.in);
    static PrintWriter out;
    public static void main(String[] args) {
        out = new PrintWriter(System.out);
        int T = cin.nextInt();
        for (int testCase = 0; testCase < T; testCase++) {
            int N = cin.nextInt();
            cin.nextLine();
            int max = 1;
            int curMax = 1;
            String s = cin.nextLine();
            int curChar = s.charAt(s.length()-1);
            for (int sentence = 1; sentence < N; sentence++) {
                String cs = cin.nextLine();
                if (curChar == cs.charAt(cs.length()-1)){
                    curMax++;
                }else {
                    curMax = 1;
                    curChar = cs.charAt(cs.length()-1);
                }
                if (curMax > max){
                    max = curMax;
                }
            }
            out.println(max);
        }
        out.close();
    }

}