package Lamda;

public class FakeThread {

    FakeRunnable fakeRunnable;

    //러너블 정의부분
    public FakeThread(FakeRunnable fakeRunnable){
        this.fakeRunnable = fakeRunnable;
    }

    //러너블 시작부분인데,, 쓰레드는 여기를 어떻게 구현했을까...
    public void start(){
        fakeRunnable.run();
    }
}
