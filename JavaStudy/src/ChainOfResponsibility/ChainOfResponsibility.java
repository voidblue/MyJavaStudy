package ChainOfResponsibility;


import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

abstract class Operator {
    List expression;
    Operator nextOp;

    abstract List solve(List expression);

    public void setExpression(List expression){
        this.expression = expression;
    }


    boolean isSolved(){
        if (expression.size() == 1){
            return true;
        }else{
            return false;
        }
    }
    public Operator setNext(Operator operator) {
        nextOp = operator;
        nextOp.setExpression(expression);
        return operator;
    }

    public Operator toNext() {
        if (isSolved()) {
            return this;
        }else{
            expression = solve(expression);
            return nextOp;
        }
    }

    public void printResult(){
        System.out.println(expression.get(0));

    }
}

//다 하나 클래스 가지고 op만 주고 다르게 만들 수 있지만 어거지로....
class Adder extends Operator{

    @Override
    List solve(List expression) {
        for(int i = 0 ; i < expression.size() ; i++) {
            if (expression.get(i).equals("+")){
                float num1 = Float.parseFloat((String) expression.remove(i+1));
                expression.remove(i);
                float num2 = Float.parseFloat((String)expression.remove(i-1));
                expression.add(i-1, Float.toString(num1 + num2));
                i-=2;
            }
        }

        return expression;
    }
}

class Divider extends Operator{


    @Override
    List solve(List expression) {
        for(int i = 0 ; i < expression.size() ; i++) {
            if (expression.get(i).equals("/")){
                float num1 = Float.parseFloat((String) expression.remove(i+1));
                expression.remove(i);
                float num2 = Float.parseFloat((String)expression.remove(i-1));
                expression.add(i-1,  Float.toString(num1 / num2));
                i-=2;
            }
        }

        return expression;
    }
}

class Subtractor extends Operator{


    @Override
    List solve(List expression) {
        for(int i = 0 ; i < expression.size() ; i++) {
            if (expression.get(i).equals("-")){
                float num1 = Float.parseFloat((String) expression.remove(i+1));
                expression.remove(i);
                float num2 = Float.parseFloat((String)expression.remove(i-1));
                expression.add(i-1,  Float.toString(num1 - num2));
                i-=2;

            }
        }

        return expression;
    }
}
;
class Multiplier extends Operator{

    @Override
    List solve(List expression) {
        for(int i = 0 ; i < expression.size() ; i++) {
            if (expression.get(i).equals("*")){
                float num1 = Float.parseFloat((String) expression.remove(i+1));
                expression.remove(i);
                float num2 = Float.parseFloat((String)expression.remove(i-1));
                expression.add(i-1,  Float.toString(num1 * num2));
                i-=2;
            }
        }

        return expression;
    }
}





public class ChainOfResponsibility {
    public static void main(String args[]){
        String strExpresstion = "1 + 2 + 3 + 4 * 2 * 3 * 5 * 1 / 2 / 3 / 1 / 2 + 5 + 1 + 2 - 3 - 1 - 2 - 3 + 5 + 1 - 2 - 3";
        String[] arrayExpresstion = strExpresstion.split(" ");
        List listExpresstion = new ArrayList();
        for( String e : arrayExpresstion){
            listExpresstion.add(e);
        }
        Adder adder = new Adder();
        Subtractor subtractor = new Subtractor();
        Divider divider = new Divider();
        Multiplier multiplier = new Multiplier();


        multiplier.setExpression(listExpresstion);
        multiplier.setNext(divider).setNext(adder).setNext(subtractor);

        multiplier.toNext().toNext().toNext().toNext();  //뭔가 이상하게 짜였긴 하지만 패턴은 잘 따라져서 수정은 보류..
        multiplier.printResult();



    }


}
