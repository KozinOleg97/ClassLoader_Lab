import java.util.ArrayList;

public class Printer {

    private StringBuilder str;
    private ArrayList<String> tree;

    Printer (){
        str = new StringBuilder("");
        tree = new ArrayList<String>();
    }

    public String getStr(){
        return str.toString();
    }

    public void print(){
        System.out.println(str);
    }

    public void clear(){
        str.setLength(0);
    }

    public void addtoStrLn(String inputStr){
        str.append(inputStr+"\n");
    }

    public void addtoStr(String inputStr){
        str.append(inputStr+"   ");
    }

    public void addToTree(String inputStr, int lvl){
        if (lvl+1 > tree.size()){
            int a = lvl-tree.size()+1;
            for (int i = 0; i < a; i++){
                tree.add("");
            }
        }
        tree.set(lvl, tree.get(lvl) + "  " + inputStr);


    }

    public void addToTree(int lvl){
        tree.set(lvl, tree.get(lvl) + "     " );
    }

}
