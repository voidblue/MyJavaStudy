package Interface;

public enum MyHardware {
    INSTANCE;


    private OnClickListener onClickListener;
    public void setOnClinckListener(OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }

    public void onClick(){
        onClickListener.click("스트링~~~");
    }
}