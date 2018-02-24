package StaticFactoryMethod;

public class Mainclass {
    public static void main(String args[]){
        boolean ttt = valueOF(true);
        System.out.println(ttt);
        TestClass xxx =  TestClass.getInstance();
        xxx.show();
        xxx = TestClass.getInstance();
        xxx.show();
    }


    public static boolean valueOF(boolean b) {
        return b? Boolean.TRUE : Boolean.FALSE;
    }
}


