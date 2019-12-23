import java.util.ArrayList;

public class Class2 {

    public  <T> T qwe(T[] a, ArrayList<T> c, T b) {
        for (T elem : a) {
            c.add( elem );
        }
        return b;
    }
}
