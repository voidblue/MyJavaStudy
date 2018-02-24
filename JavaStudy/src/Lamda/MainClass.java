package Lamda;

public class MainClass {

    public static void main(String args[]) {
        //보통 코드,,,, 함수실행을 위해서 객체를 파라미터로 줘야한다(내 추측)
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello World.");
            }
        }).start();

        //람다 코드,,, 람다식을 이용해 함수를 파라미터로 전달 (추측)
        new Thread(() -> {
            System.out.println("Hello World.");
        }).start();

        FakeThread thread = new FakeThread(() -> {System.out.println("가짜 스레드 실행");});
        thread.start();

    }
}
