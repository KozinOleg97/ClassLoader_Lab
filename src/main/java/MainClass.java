import java.lang.reflect.MalformedParameterizedTypeException;

public class MainClass implements Itest{


    public static void main(String[] args){

        Printer printer = new Printer();

        MainClass mainClass = new MainClass();

        ClassChecker classChecker = new ClassChecker();

        classChecker.check(MainClass.class, printer);
        printer.clear();
        classChecker.check(MalformedParameterizedTypeException.class, printer);

        //printer.addtoStr(mainClass.getClass().toString());


        printer.print();
    }


}
