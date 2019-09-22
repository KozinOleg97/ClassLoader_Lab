import java.awt.*;
import java.lang.reflect.MalformedParameterizedTypeException;

public class MainClass implements Itest, iTest2{


    public static void main(String[] args){

        Printer printer = new Printer();

        MainClass mainClass = new MainClass();

        ClassChecker classChecker = new ClassChecker();



        classChecker.checkParentClasses(MainClass.class, printer);
        printer.print();
        printer.clear();
        classChecker.checkParentInterfaces(MainClass.class, printer,0);
        printer.print();
        printer.clear();




    }


}
