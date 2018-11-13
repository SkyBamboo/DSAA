import java.util.*;
import java.io.*;

public class C{
    static FastReader cin = new FastReader();
    static PrintWriter out;

    public static void main(String[] args) {
        out = new PrintWriter(System.out);
        int T = cin.nextInt();
        for (int testCase = 0; testCase < T; testCase++) {
            int N = cin.nextInt();
            String text = cin.nextLine();
            int M = cin.nextInt();
            String patten = cin.nextLine();
                int count = operate(text, N, patten, M);
            out.println(count);
        }
        out.close();
    }

    public static int operate(String text, int N, String patten, int M) {//出现次数
        int count;
        myKMPC kmp = new myKMPC(patten);
        count = kmp.search(text);
        return count;
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new
                    InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}

class myKMPC {
    String patten;
    int[] next;
    myKMPC(String patten){
        this.patten = patten;
        int M = patten.length();
        next = new int[M];
    }

    public int[] calcNext(String patten){
        int m = patten.length();
        int[] next = new int[m];
        int x = 0;
        int i = 1;
        next[0] = 0;
        while (i < m){
            if (patten.charAt(i) == patten.charAt(x)){
                x++;
                next[i] = x;
                i++;
            }
            else {
                if (x!= 0){
                    x = next[x -1];
                }
                else {//x = 0
                    next[i] = x;
                    i++;
                }
            }
        }
        return next;
    }

    public int search(String text){
        int count = 0;
        String patten = this.patten;
        int M = patten.length();
        int j = 0;
        int N = text.length();
        next = calcNext(patten);
        int i = 0;
        while (i < N){
            if (patten.charAt(j) == text.charAt(i)){
                j++;
                i++;
            }
            if (j == M){
                count++;
                j = next[j-1];
            }
            else if (i < N && patten.charAt(j) != text.charAt(i)){
                if (j != 0){
                    j = next[j - 1];
                }else
                    i = i + 1;
            }
        }
        return count;
    }

}




