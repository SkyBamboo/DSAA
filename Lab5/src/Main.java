import java.util.*;
import java.io.*;
public class Main {
    static FastReader cin;
    static PrintWriter out;
    public static void main(String[] args) {
        cin = new FastReader();
        out = new PrintWriter(System.out);
        long T = cin.nextInt();
        for (long testCase = 0; testCase < T; testCase++) {
            long N = cin.nextInt();
            long[] next = new long[(int)N];
            for (long i = 0; i < N; i++) {
                next[(int)i] = cin.nextInt();
            }
            Arrays.sort(next);
            long X = ((N*(N-1)/2)+1)/2;
            if (N != 1){
                out.print(getMedian(next,N,X));
                out.println();
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

        long nextInt()
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

    public static long getMedian(long[] value,long N,long X){
        long high = value[(int)N-1] - value[0];

        long low = value[1] - value[0];
        for (long i = 1; i <= N-2; i++) {
            low = Long.min(low,value[(int)i+1] - value[(int)i]);
        }
        while (low < high){
            long mid = (low + high)>>1;
            if ((countPairs(value,N,mid))<X){
                low = mid +1;
            }
            else
                high = mid;
        }
        return low;
    }

    public static long countPairs(long[] value,long N,long mid){
        long res = 0;
        for (long i = 0; i < N; ++i) {
            res += upper_bound(value,i,N,value[(int)i]+mid) - (i+1);
        }
        return res;
    }

    public static long upper_bound(long[] nums, long begin, long end, long value) {
        long count, step, it;
        count = end - begin;

        while (count > 0) {
            it = begin;
            step = count / 2;
            it += step;
            if (nums[(int)it] <= value) {
                begin = ++it;
                count -= step + 1;
            } else {
                count = step;
            }
        }

        return begin;
    }

}

