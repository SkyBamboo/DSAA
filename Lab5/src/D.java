import java.util.*;
import java.io.*;

public class D {
    static FastReader cin = new FastReader();
    static PrintWriter out;
    public static void main(String[] args) {
        out = new PrintWriter(System.out);
        int T = cin.nextInt();
        for (int testCase = 0; testCase < T; testCase++) {
            int N = cin.nextInt();
            String S = cin.nextLine();
            out.println(lengthOfPubchline(S,N));
        }
        out.close();
    }

    public static int lengthOfPubchline(String S,int N){
        int len = 0;
        if (S.length()<3){
            return 0;
        }
        String longestSub = findLongestpre(S,N);
        int L = longestSub.length();
        String sub = S.substring(L,N-L);
        if (sub.contains(longestSub)){
            len = L;
        } else {
            while (L >1){
                int[] next = myKMP.calcNext(longestSub);
                longestSub = longestSub.substring(0,next[next.length-1]);
                L = longestSub.length();
                sub = S.substring(L,N-L);
                if (sub.contains(longestSub)){
                    len = L;
                    break;
                }
            }
        }

        return len;
    }

    public static String findLongestpre(String S,int L){
        String s1 = S.substring(0,L/3);
        String s2 = S.substring(L- L/3);
        int N = s1.length();
        int M = s2.length();
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

        }
        return common;
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