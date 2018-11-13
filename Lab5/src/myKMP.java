public class myKMP {
    String patten;
    int[] next;
    myKMP(String patten){
        this.patten = patten;
        int M = patten.length();
        next = new int[M];
    }

    public static int[] calcNext(String patten){
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
            if (j == M){//匹配上的时候
                return i-j;
            }
            else if (i < N && patten.charAt(j) != text.charAt(i)){
                if (j != 0){
                    j = next[j - 1];
                }else
                    i = i + 1;
            }
        }
        return -1;
    }

}
