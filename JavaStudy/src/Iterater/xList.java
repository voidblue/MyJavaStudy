package Iterater;

import java.util.ArrayList;
import java.util.Iterator;

public class xList implements Iterator {
    private ArrayList list;

    public xList(){
        list = new ArrayList();
    }

    public void add(String name){
        list.add(name);
    }

    public Iterator<String> iterator() {
        return  new Iterator<String>(){
            int seq = 0;
            public boolean hasNext() {
                return  seq < list.size();
            }
            public String next() {
                return (String)list.get(seq++);
            }
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public Object next() {
        return null;
    }

    public static void main(String args[]){
        xList xlist = new xList();
        xlist.add("aa");
        xlist.add("bb");
        xlist.add("cc");
//        iterator의 장점
//        해당 객체의 내부가 어떻게 동작하는지에 대해 알 수 없습니다.
//        2.다형성
//        어떤 컬렉션이든 다형성을 활용하여 한개의 순환문으로 처리할 수 있습니다.  <--어떤 collection이 오든
//        또한 인터페이스만(Iterator) 알고 있으면 됩니다.
        Iterator xxx = xlist.iterator();
        while(xxx.hasNext()){
            System.out.println(xxx.next());
        }
    }
}
