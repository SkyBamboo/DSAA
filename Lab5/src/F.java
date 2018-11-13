import java.util.*;
import java.io.*;

public class F {
    static FastReader cin = new FastReader();
    static PrintWriter out;
    public static void main(String[] args) {
        out = new PrintWriter(System.out);
        int T = cin.nextInt();
        for (int testCase = 0; testCase < T; testCase++) {
            int N = cin.nextInt();
            String[] strings = new String[N];
            for (int stringIndex = 0; stringIndex < N; stringIndex++) {
                strings[stringIndex] = cin.nextLine();
            }
            String  longestSub = findlongestSub(strings);
            out.println(longestSub);
        }



        out.close();
    }


    public static String findlongestSub(String arr[]) {
        int N = arr.length;
        int minLength = arr[0].length();
        int index = 0;
        for (int i = 0; i < N; i++) {
            if (arr[i].length() < minLength){
                minLength = arr[i].length();
                index = i;
            }
        }
        String s = arr[index];
        int len = minLength;

        String longestSub = "";

        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j <= len; j++) {
                String psub = s.substring(i, j);
                int a;
                for (a = 1; a < N; a++)
                    if (!arr[a].contains(psub)) {
                    break;
                    }
                if (a == N && longestSub.length() == psub.length()){
                    longestSub = compareLexicographicallyOrder(psub,longestSub,psub.length());
                }
                if (a == N && longestSub.length() < psub.length()){
                    longestSub = psub;
                }

            }
        }
        if (longestSub.length() == 0){
            longestSub = "Hong";
        }
        return longestSub;
    }

    public static String compareLexicographicallyOrder(String s1,String s2,int N){
        String min = s1;
        for (int i = 0; i < N; i++) {
            if (s1.charAt(i) != s2.charAt(i)){
                int minInt = Integer.min(s1.charAt(i),s2.charAt(i));
                if (minInt == s1.charAt(i)){
                    min = s1;
                    break;
                }else {
                    min = s2;
                    break;
                }
            }
        }
        return min;
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

