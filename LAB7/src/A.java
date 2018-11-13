import java.util.*;
import java.io.*;
public class A {
    static FastReader jin;
    static PrintWriter out;
    public static void main(String[] args) {
        jin = new FastReader();
        out = new PrintWriter(System.out);
        int T = jin.nextInt();
        for (int testCase = 0; testCase < T; testCase++) {
            int N = jin.nextInt();
            int[] input = new int[2*N+1];
            for (int i = 1; i < N + 1; i++) {
                input[i] = jin.nextInt();
                input[N+i] = jin.nextInt();
            }
            int root = findRoot(N,input);
            int[] tree = buildTree(N,root,input);
            if (isCBT(N,tree)){
                out.println("YES");
            }else out.println("NO");

        }
        
        
        out.close();
    }
    public static int findRoot(int N,int[]input){
        int rootNode = 0;
        boolean[] root = new boolean[N+1];
        for (int i = 1; i < N+1; i++) {
            if (input[i] != 0){
                root[input[i]] = true;
            }
            if (input[N + i] != 0){
                root[input[i]] = true;
            }
        }
        for (int i = 1; i < N+1; i++) {
            if (root[i] == false){
                rootNode = i;
                break;
            }
        }
        return rootNode;
    }

    public static int[] buildTree(int N,int root,int[] input){
        int[] tree = new int[2*(N+1)];
        tree[1] = root;
        for (int i = 1; i < N+1; i++) {
            int childIndexInInput = tree[i];
            int leftChild = input[childIndexInInput];
            int rightChild = input[childIndexInInput + N];
            tree[2*i] = leftChild;
            tree[2*i+1] = rightChild;
        }
        return tree;
    }

    public static boolean isCBT(int N,int[] tree){
        boolean state = true;
        for (int i = 1; i < N+1; i++) {
            if (tree[i] == 0){
                return false;
            }
        }

        return state;
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

