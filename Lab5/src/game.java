public class game {
    public static void main(String[] args) {
        int[] a = {1,2,3,4,5};
        a = change(a);
        for (int i:
             a) {
            System.out.println(i);
        }
    }
    public static int[] change(int[] a){
        int[] b = {1,2,3,4};
        a = b;
        return a;
    }
}
