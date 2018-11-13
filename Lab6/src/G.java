import java.util.*;
import java.io.*;
public class G {
    static FastReader cin;
    static PrintWriter out;
    public static void main(String[] args) {
        cin = new FastReader();
        int T = cin.nextInt();
        for (int testCase = 0; testCase < T; testCase ++) {
            int N = cin.nextInt();
            for (int i = 0; i < N-1; i++) {

            }

        }

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
