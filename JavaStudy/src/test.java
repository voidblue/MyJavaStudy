import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

//옵저버 패턴이랑 이런저런 아이디로 안드로이드 OnClick이랑 비슷하게 만들어보기
class user {
    public static void main(String args[]) {
        AppButton xxx = new AppButton();

        ScreenManager sm = ScreenManager.getInstance();
        sm.check(1);  //유저 액션?
    }

}
//개발자가 만든 앱 버튼이라 가정
class AppButton{
    public AppButton(){
        Button button = new Button();
        button.setOnClickListener(()->{
            System.out.println("앱 버튼이 눌림");
        });
    }
}

//통보받는 역할
class Button implements Observer{
    int startx, starty, width, height;
    OnClickLestener onClickLestener;

    //position도 안드로이드라면 findViewById로 가져와서 넣었겠지만 테스트만 할거니까 대충 생성자로 넣기
    public Button(){
        ScreenManager.getInstance().addButton(this);
        startx = 50;
        starty = 50;
        width = 100;
        height = 100;
    }

    public void setOnClickListener(OnClickLestener onClickListener){
        this.onClickLestener = onClickListener;
    }

    @Override
    public void update(Observable observable, Object o) {
        onClickLestener.onClick();
    }

    //    //충돌했나 확인, 테스트가 목적이라 대충
    public boolean isCollide(int posx, int posy){
        return true;
    }
}


@FunctionalInterface
interface OnClickLestener{
    void onClick();
}

//통보하는 역할
class ScreenManager extends Observable{
    static ScreenManager INSTANCE = new ScreenManager();
    private ArrayList<Button> buttonList = new ArrayList();
    private int posx = 100; //마우스 포인터라 가정
    private int posy = 100;
    private final int CLICKCODE = 1;

    public static ScreenManager getInstance(){
        return INSTANCE;
    }

    public void addButton(Button button){
        buttonList.add(button);
    }

    public void check(int ACTIONCODE){
        if (ACTIONCODE == CLICKCODE){
            for (Button b : buttonList){
                if(b.isCollide(posx, posy)){
                    addObserver(b);
                    setChanged();
                    notifyObservers();
                    deleteObserver(b);
                }
            }
        }
    }

}

