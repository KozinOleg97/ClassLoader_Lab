import java.awt.*;
import java.lang.reflect.MalformedParameterizedTypeException;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.SortedSet;

public class MainClass implements Itest, iTest2{


    public static void main(String[] args){

        ////////////////////////////Const MAP////////////////////////////////////////////
        final Map<String, String> map = new HashMap<String, String>(){{
            put("Key_1", "Value_1");
            put("Key_2", "Value_2");
            put("Key_3", "Value_1");
        }};

        map.put("d","d");

        final Map constMap = Collections.unmodifiableMap(map);

        constMap.put("d", "d");
        /////////////////////////////////////////////////////////////////////////////////

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
