
public class MinimumMain {

    public static void main(String[] args){
        Object[] objArr = {(Integer)4,(Integer)22,"7",(Integer)2,(Integer)9};

        Minimum m = new Minimum<Object>(objArr);
        System.out.println(m.getMinimum());

    }
}
