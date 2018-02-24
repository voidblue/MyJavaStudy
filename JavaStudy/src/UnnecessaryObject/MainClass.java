package UnnecessaryObject;

public class MainClass {
    public static void main(String args[]){
        String xx = new String("xx"); //이거는 여러번 실행되어도 객체를 그때마다 만든다. <<-- 비용이 크다
        String xxx = "xxx";  //이거는 여러번 실행 되어도 같은 객체에서 값만 바뀐다
                                //+같은 가상 머신에 실행되는 모든 코드가 같은 객체를 사용한다.

        TestClass xxxx = TestClass.getInstance();
        boolean temp = xxxx.isBabyBoomer();
        System.out.println(temp);

        Test2Class xxxx2 = Test2Class.getInstance();
        System.out.println(temp);
    }
}
