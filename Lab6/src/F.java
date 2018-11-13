import java.util.*;
import java.io.*;

public class F {
    static FastReader cin;
    static PrintWriter out;

    public static void main(String[] args) {
        cin = new FastReader();
        out = new PrintWriter(System.out);
        int T = cin.nextInt();
        for (int testCase = 0; testCase < T; testCase++) {
            boolean isWin = false;
            int N = cin.nextInt();
            int[] color = new int[N + 1];
            int[] nodeDepth = new int[N + 1];
            int[] blackNumber;
            int maxDepth = 1;
            for (int i = 1; i < N + 1; i++) {
                color[i] = cin.nextInt();
            }
            nodeDepth[1] = 1;
            for (int i = 1; i < N; i++) {
                int left = cin.nextInt();
                int right = cin.nextInt();
                int father;
                int child;
                int LD = nodeDepth[left];
                int RD = nodeDepth[right];
                if (LD > RD){
                    father = left;
                    child = right;
                }else {
                    father = right;
                    child = left;
                }
                nodeDepth[child] = nodeDepth[father] + 1;
                if (nodeDepth[child] > maxDepth) {
                    maxDepth = nodeDepth[child];
                }
            }
            blackNumber = new int[maxDepth+1];
            for (int i = 1; i < N+1; i++) {
                if (color[i] == 1) {
                    int depth = nodeDepth[i];
                    blackNumber[depth]++;
                }
            }

            for (int i = 1; i < maxDepth+1; i++) {
                if (blackNumber[i] % 2 != 0) {
                    isWin = true;
                    break;
                }
            }
            if (isWin) {
                out.println("YES");
            } else out.println("NO");

        }
        out.close();

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
