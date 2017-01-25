import java.util.Arrays;
/**
 * Created by ZY on 23.01.17.
 */
public class Minimum<T> {
    private T[] arr;
    public Minimum(T[] arr){
        this.arr = arr;
    }
    public T getMinimum() {
        try{
            Arrays.sort(arr);
            return arr[0];
        } catch(ClassCastException e){ System.out.println("ClassCastException: getMinimum = null, Minimum im Array ist nicht bestimmbar."); return null;}

    }
}
