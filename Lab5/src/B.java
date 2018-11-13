import java.io.PrintWriter;
import java.util.Scanner;
public class B {
    static Scanner cin = new Scanner(System.in);
    static PrintWriter out;
    public static void main(String[] args) {
        out = new PrintWriter(System.out);
        int T = cin.nextInt();
        cin.nextLine();
        for (int testCase = 0; testCase < T; testCase++) {
            boolean state;
            int M = cin.nextInt();
            int N = cin.nextInt();
            cin.nextLine();
            String patten = cin.nextLine();
            String text = cin.nextLine();
            state = operate(patten,M,text,N);
            if (state){
                out.println("YES");
            }else out.println("NO");
        }
        out.close();
    }

    public static int findStar(String patten){
        int index = -1;
        for (int i = 0; i < patten.length(); i++) {
            if (patten.charAt(i) == '*'){
                index = i;
                break;
            }
        }
        return index;
    }

    public static boolean operate(String patten,int M,String text,int N){
        boolean isMatch = false;
        int indexOfStar = findStar(patten);
        final int last = M-1;
        if (M == 1 && patten.charAt(0) == '*'){
            isMatch = true;
            return isMatch;
        }
        if (M == 2){
            if (indexOfStar == -1);{
                myKMP kmp = new myKMP(patten);
                if (kmp.search(text) != -1){
                    isMatch = true;
                }
            }
            if (indexOfStar == 0){
                for (int i = 0; i < N; i++) {
                    if (text.charAt(i) == patten.charAt(1)){
                        isMatch =true;
                        break;
                    }
                }
            }
            if (indexOfStar == 1){
                for (int i = 0; i < N; i++) {
                    if (text.charAt(i) == patten.charAt(0)){
                        isMatch =true;
                        break;
                    }
                }
            }
            return isMatch;
        }
        if (M >= 3) {
            if (indexOfStar == -1) {
                myKMP kmp = new myKMP(patten);
                int index = kmp.search(text);
                if (index != -1) {
                    isMatch = true;
                    return isMatch;
                }
            }
            if (indexOfStar == 0) {
                patten = patten.substring(1);
                myKMP kmp = new myKMP(patten);
                int index = kmp.search(text);
                if (index != -1) {
                    isMatch = true;
                    return isMatch;
                }
            }
            if (indexOfStar == last) {
                patten = patten.substring(0, M - 2);
                myKMP kmp = new myKMP(patten);
                int index = kmp.search(text);
                if (index != -1) {
                    isMatch = true;
                    return isMatch;
                }
            }
            if (indexOfStar != -1 && indexOfStar != 0 && indexOfStar != last) {
                String sub1 = patten.substring(0, indexOfStar);
                String sub2 = patten.substring(indexOfStar + 1);
                myKMP kmp = new myKMP(sub1);
                int index = kmp.search(text);
                if (index != -1) {
                    String subText = text.substring(index + sub1.length());
                    if (subText.length() != 0) {
                        myKMP kmp2 = new myKMP(sub2);
                        int index2 = kmp2.search(subText);
                        if (index2 != -1) {
                            isMatch = true;
                            return isMatch;
                        }
                    }
                }
            }
        }
        return isMatch;
    }


}




