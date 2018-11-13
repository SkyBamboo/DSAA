import java.util.*;
import java.io.*;
public class C {
    static FastReader cin;
    static PrintWriter out;
    public static void main(String[] args) {
        out = new PrintWriter(System.out);
        cin = new FastReader();
        int T = cin.nextInt();
        for (int testCase = 0; testCase < T; testCase ++) {
            int N = cin.nextInt();
            PriorityQueue<Integer> heap = new PriorityQueue<>();
            for (int i = 0; i < N; i++) {
                heap.add(cin.nextInt());
            }
            int Q = cin.nextInt();
            for (int i = 0; i < Q; i++) {
                int operation = cin.nextInt();
                switch (operation){
                    case 1:
                        int number = cin.nextInt();
                        heap.add(number);
                        break;

                    case 2:
                        heap.poll();
                        break;

                    case 3:
                        int peek = heap.peek();
                        out.println(peek);
                        break;
                }
            }

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
