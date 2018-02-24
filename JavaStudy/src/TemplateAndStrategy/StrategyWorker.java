package TemplateAndStrategy;

public interface StrategyWorker {
    void work();

}


class Developer3 implements StrategyWorker{

    @Override
    public void work() {
        System.out.println("개발중");
    }
}

class Deginer3 implements StrategyWorker{

    @Override
    public void work() {
        System.out.println();
    }
}


class CallWorker{
    public void showday(StrategyWorker strategyWorker){
        System.out.println("출근");
        strategyWorker.work();
        System.out.println("퇴근");
    }

    public void main(){
        CallWorker worker = new CallWorker();
        worker.showday(new Developer3());
        worker.showday(new Deginer3());
    }
}