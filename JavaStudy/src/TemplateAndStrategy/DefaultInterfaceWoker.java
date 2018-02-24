package TemplateAndStrategy;

public interface DefaultInterfaceWoker {
    void work();


    default void showday(){
        System.out.println("출근");
        work();
        System.out.println("퇴근");
    }
}


class Developer2 implements DefaultInterfaceWoker {

    @Override
    public void work() {
        System.out.println("개발중");
    }
}

class Deginer2 implements DefaultInterfaceWoker {

    @Override
    public void work() {
        System.out.println("디자인중");
    }
}


class strategyMain{
    public static void main(String args[]){
        Developer2 developer2 = new Developer2();
        developer2.showday();

        Deginer2 deginer2 = new Deginer2();
        deginer2.showday();
    }
}