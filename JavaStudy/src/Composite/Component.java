package Composite;

import java.util.ArrayList;
import java.util.List;

public abstract class Component {
    String componentName;
    protected List<Component> children;
    protected Component(String componentName){
        this.componentName = componentName;
        children = new ArrayList<Component>();
    }

    protected abstract void add(Component component);

    public List<Component> getChildren(){
        return children;
    }
    public String getDerectoryStructure(){
        return getDerectoryStructure(0);

    }

    private String getDerectoryStructure(int depth){
        StringBuilder strBuilder = new StringBuilder();
        for (int i  = 0 ; i < depth ; i++){
            strBuilder.append(" ");
        }
        depth++;
        if (this instanceof Composit) {
            strBuilder.append("+" + componentName);
        }else{
            strBuilder.append("-" + componentName);
        }
        strBuilder.append("\n");
        for (Component component : children){
            strBuilder.append(component.getDerectoryStructure(depth));
        }

        return strBuilder.toString();
    }
}

class Composit extends Component{

    public Composit(String componentName) {
        super(componentName);
    }

    @Override
    public void add(Component component) {
        children.add(component);
    }
}

class Leaf extends Component{

    public Leaf(String componentName) {
        super(componentName);
    }

    @Override
    public void add(Component component) {
        System.out.println("Leaf는 하위노드를  넣을 수 없습니다,");
        throw new UnsupportedOperationException();
    }
}

class FileManager{
    public static void main(String args[]){
        Composit C = new Composit("C");
        Composit programFiles = new Composit("programfiles");
        Composit windows = new Composit("window32");
        Leaf window = new Leaf("window.exe");
        Composit DNF = new Composit("DNF");
        Leaf Dnfexe = new Leaf("DNF.exe");
        Leaf Dnfpng = new Leaf("DNF.png");

        C.add(programFiles);
        C.add(windows);
        windows.add(window);
        programFiles.add(DNF);
        DNF.add(Dnfexe);
        DNF.add(Dnfpng);
        System.out.println(C.getDerectoryStructure());

    }
}