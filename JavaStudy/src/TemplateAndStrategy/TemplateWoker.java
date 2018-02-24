package TemplateAndStrategy;

public abstract class TemplateWoker {
    protected abstract void work();
    public final void showday(){
        System.out.println("출근");
        work();
        System.out.println("퇴근");
    }

}

class Developer extends TemplateWoker {

    @Override
    protected void work() {
        System.out.println("개발중");
    }
}

class Deginer extends TemplateWoker{

    @Override
    protected void work() {
        System.out.println("디자인중");
    }
}


class Main{
    public static void main(String args[]){
        Developer developer = new Developer();
        developer.showday();

        Deginer deginer = new Deginer();
        deginer.showday();
    }
}