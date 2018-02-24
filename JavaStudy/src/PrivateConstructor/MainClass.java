package PrivateConstructor;

public class MainClass {
    //TestClass 는 정적 메소드와 필드 클래스만 있고
    //인스턴스가 만들어져선 안된다!
    public static void main(String args[]) {
        TestClass.printHi();
//        TestClass xxx = new TestClass();//당연히 오류나죠
        TestClass.callConstructor();
    }
}
