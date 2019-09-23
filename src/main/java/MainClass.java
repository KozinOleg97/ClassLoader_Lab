import java.awt.*;
import java.lang.reflect.MalformedParameterizedTypeException;
import java.util.SortedSet;

public class MainClass implements Itest, iTest2{


    public static void main(String[] args){

        Printer printer = new Printer();

        MainClass mainClass = new MainClass();

        ClassChecker classChecker = new ClassChecker();



        classChecker.check(Printer.class, printer);
        printer.print();
        printer.clear();




    }


}
