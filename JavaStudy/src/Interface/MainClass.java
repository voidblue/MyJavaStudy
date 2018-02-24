package Interface;

public class MainClass {

    public static void main(String args[]){

        //이 아래부분을 메인 함수의 일부라 생각하지 말고 다른 파트라 생각하자
        MyHardware device;
        device = MyHardware.INSTANCE;

        device.setOnClinckListener(new OnClickListener() {
            @Override
            public void click(String string) {
                System.out.println(string + "\n이 출력했고 선언부에서 보내준 문자열!"
                                            +"\n문자열이 아니고 객체면 다르게 정의할 수 있을듯!");
            }
        });

        ///여기는 다른 장치라 생각해서ㅎ
        device.onClick();

    }
}