package PrivateConstructor;

public class TestClass {

    private TestClass(){
        throw new AssertionError();
    }
    public static void printHi(){
        System.out.println("hi");
    }

    public static void callConstructor(){
        System.out.println("실수로 클래스 안에서 생성자를 호출하는 경우가 생길 때");
        TestClass xxx = new TestClass();
    }
    //TODO 필드 클래스 뭔지 몰라용
}
