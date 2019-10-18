import org.apache.log4j.LogManager;

import java.util.logging.Logger;

public class Printer implements IPrinter{

    private StringBuilder str;
    private StringBuilder tree;

    /**
     * Class for accumulating  output string & tree
     */
    Printer() {
        str = new StringBuilder("");
        tree = new StringBuilder("");
    }
    @MyAnnotation()
    public String getStr() {
        return str.toString();
    }
    @MyAnnotation()
    public void print() {
        System.out.println(str);
        System.out.println("--------------------------------------");
        System.out.println(tree);
    }
    @MyAnnotation()
    public void clear() {
        str.setLength(0);
        tree.setLength(0);
    }
    @MyAnnotation()
    public void addToStrLn(String inputStr) {
        str.append(inputStr + "\n");
    }
    @MyAnnotation()
    public void addtoStr(String inputStr) {
        str.append(inputStr + "   ");
    }

    /**
     * add elem to the tree
     * @param inputStr
     * @param lvl
     */
    @MyAnnotation()
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
