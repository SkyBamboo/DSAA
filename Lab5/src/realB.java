import java.util.Scanner;

public class realB{
    static Scanner cin = new Scanner(System.in);
    public static void main(String[] args) {
        int T = cin.nextInt();
        cin.nextLine();
        for (int testCase = 0; testCase < T; testCase++) {
            boolean state = true;
            int n = cin.nextInt();
            int m = cin.nextInt();
            cin.nextLine();
            String patten = cin.nextLine();
            String text = cin.nextLine();
            int indexOfStar = findStar(patten);
            String sub1;
            String sub2;
            if (indexOfStar == 0){
                sub1 = "";
            }else sub1 = patten.substring(0,indexOfStar-1);
            if (indexOfStar == patten.length()-1){
                sub2 = "";
            }else sub2 = patten.substring(indexOfStar +1);
        }

    }


    public static int findStar(String patten){
        int index = 0;
        for (int i = 0; i < patten.length(); i++) {
            if (patten.charAt(i) == '*'){
                index = i;
                break;
            }
        }
        return index;
    }


}
