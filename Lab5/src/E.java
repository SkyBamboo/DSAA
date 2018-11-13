import java.util.*;
import java.io.*;

public class E {
    static FastReader cin = new FastReader();
    static PrintWriter out;
    public static void main(String[] args) {
        out = new PrintWriter(System.out);
        int T = cin.nextInt();
        for (int testCase = 0; testCase < T; testCase++) {
            int N = cin.nextInt();
            int M = cin.nextInt();
            String s1 = cin.nextLine();
            String s2 = cin.nextLine();
            int count;
            String combine = s1.concat(s2);
            myKMP kmp = new myKMP(combine);
            int [] next = kmp.calcNext(combine);
            count = next[M+N -1];
            String common = "";
            if (count != 0){
                int min = Integer.min(M,N);
                if (count > min){
                    if (s1.length() == min){
                        common = s1;
                        count = min;
                    }else if (s2.length() == min){
                        common = s2;
                        count = min;
                    }
                }else {
                    common = combine.substring(M + N - count);
                }
                out.println(count + " " + common);
            }
            else out.println(0);

        }


        out.close();
    }
    static class FastReader
    {
        BufferedReader br;
        StringTokenizer st;

        public FastReader()
        {
            br = new BufferedReader(new
                    InputStreamReader(System.in));
        }

        String next()
        {
            while (st == null || !st.hasMoreElements())
            {
                try
                {
                    st = new StringTokenizer(br.readLine());
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt()
        {
            return Integer.parseInt(next());
        }

        long nextLong()
        {
            return Long.parseLong(next());
        }

        double nextDouble()
        {
            return Double.parseDouble(next());
        }

        String nextLine()
        {
            String str = "";
            try
            {
                str = br.readLine();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
            return str;
        }
    }


}