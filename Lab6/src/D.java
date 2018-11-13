import java.util.*;
import java.io.*;
public class D {
    static FastReader jin;
    static PrintWriter out;
    public static void main(String[] args) {
        out = new PrintWriter(System.out);
        jin = new FastReader();
        int T = jin.nextInt();
        for (int testCase = 0; testCase < T; testCase ++) {
            int N = jin.nextInt();
            Graph graph = new Graph(N+1);
            for (int i = 1; i < N+1; i++) {
                int v = jin.nextInt();
                int w = jin.nextInt();
                graph.addEdge(v,w);
            }
            int node = graph.getNode();
            int distant = graph.getDistance(node);
            out.println(distant);
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
