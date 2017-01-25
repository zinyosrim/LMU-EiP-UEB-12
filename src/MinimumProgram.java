
public class MinimumProgram {

    public static void main(String[] args){
        Object[] objArr = {(Integer)4,(Integer)22,7,"XX",(Integer)2,(Integer)9};

        Minimum m = new Minimum<Object>(objArr);
        //m.getMinimum();
        System.out.println(m.getMinimum());

    }
}
