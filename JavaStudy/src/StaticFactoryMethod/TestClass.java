package StaticFactoryMethod;

import javax.sound.midi.SysexMessage;

public class TestClass {
    //생성자를 감추고 다른 함수로서 반환한다
    //getInstance가 싱글턴에서만 사용되는 인스턴스 얻는 방식이라고 하는데 사람마다 말하는 부분이 다른듯
    public static TestClass getInstance (){
        return new TestClass();
    }

    private TestClass(){
        System.out.println("생성자가 호출됨");
    }

    public void show(){
        System.out.println("쇼우~");
    }

}
