package StaticFactoryMethod;

import javax.sound.midi.SysexMessage;

public class TestClass {
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
