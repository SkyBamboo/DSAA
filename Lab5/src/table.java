import java.util.*;
import java.io.*;
public class table {
    public static void main(String[] args) {
        boolean a = true;
        boolean b = true;
        boolean c = false;
        boolean d;
        d = Boolean.logicalXor(Boolean.logicalXor(a,b),c);
        System.out.println(d);
    }
}
