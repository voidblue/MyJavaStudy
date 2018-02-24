package BuliderAndFinal;

public class MainClass {
    public static void main(String args[]){
        //setter 방식으로 이루어진 bean패턴으로 가능하기도 하지만 이 경우 객체 일관성이 깨질수도 있다.
        //객체 일관성 : 객체가 생성되고 나서 변할 여지
        //이펙티브자바를 읽다보면 대부분의 경우 객체를 변경하는 것 보다 새로 만드는 게 나음 따라서 객체 변경 가능성은 줄이는 게 좋음 -->> 세터방식 말고 빌더방식 사용
        TestClass testInstanace = new TestClass.Builder("940412-비밀~", "김재윤").age(24).IQ(999).nickname("voidblue").weight(0).length(170).build();
        testInstanace.printAll();
        //빌더가 스태틱이긴 하지만 객체 만든 이후 변수 값이 다 0으로 초기화된다.
        testInstanace = new TestClass.Builder("아까랑 똑같", "김재윤2").build();
        testInstanace.printAll();
    }
}