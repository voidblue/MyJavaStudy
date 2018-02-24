package EnumSingletone;

import org.omg.PortableInterceptor.INACTIVE;

public enum TestEnum{
    INSTANCE;

    public void printOK(){
        System.out.println("OK");
    }
}