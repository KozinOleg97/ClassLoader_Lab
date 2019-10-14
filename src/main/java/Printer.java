import java.util.ArrayList;

public class Printer implements IPrinter{

    private StringBuilder str;
    private StringBuilder tree;

    Printer() {
        str = new StringBuilder("");
        tree = new StringBuilder("");
    }

    public String getStr() {
        return str.toString();
    }

    public void print() {
        System.out.println(str);
        System.out.println("--------------------------------------");
        System.out.println(tree);
    }

    public void clear() {
        str.setLength(0);
        tree.setLength(0);
    }
    @MyAnnotation()
    public void addToStrLn(String inputStr) {
        str.append(inputStr + "\n");
    }

    public void addtoStr(String inputStr) {
        str.append(inputStr + "   ");
    }

    public void addToTree(String inputStr, int lvl) {

        if (lvl != 0) {
            for (int i = 0; i < lvl - 1; i++) {
                tree.append("   ");
            }
            tree.append("|--");
        }


        tree.append(inputStr + "\n");


    }


}
