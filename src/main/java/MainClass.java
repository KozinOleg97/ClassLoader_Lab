import java.awt.*;
import java.lang.reflect.MalformedParameterizedTypeException;
import java.lang.reflect.Method;
import java.util.SortedSet;

public class MainClass implements Itest, iTest2{


    public static void main(String[] args){

        Printer printer = new Printer();

        MainClass mainClass = new MainClass();

        ClassChecker classChecker = new ClassChecker();



        classChecker.check(Printer.class, printer);
        printer.print();
        printer.clear();



        MyClassLoader loader = new MyClassLoader();

        try {

            //reflection
            Class class1 = loader.findClass("MyClass");
            Object instanceOfClass1 = class1.newInstance();


            Method method1 = class1.getMethod("SetA", int.class);
            method1.invoke(instanceOfClass1, 1991);

            Method method2 = class1.getMethod("PrintA");
            method2.invoke(instanceOfClass1);

            //interface
            Class class2 = loader.findClass("MyClass2");
            IMyClass2 instanceOfClass2 = (IMyClass2) class2.newInstance();

            instanceOfClass2.Hello();
            instanceOfClass2.PrintStr("Job done");


        } catch (Exception e) {
            e.printStackTrace();
        }



    }


}
