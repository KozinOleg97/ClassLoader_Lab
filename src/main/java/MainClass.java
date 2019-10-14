import javassist.CannotCompileException;
import javassist.NotFoundException;

import java.io.IOException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class MainClass {


    public static void main(String[] args) throws CannotCompileException, InstantiationException, NotFoundException, IllegalAccessException, NoSuchMethodException, IOException {

        ////////////////////////////Const MAP////////////////////////////////////////////
        final Map<String, String> map = new HashMap<String, String>(){{
            put("Key_1", "Value_1");
            put("Key_2", "Value_2");
            put("Key_3", "Value_1");
        }};

        map.put("d","d");

        final Map constMap = Collections.unmodifiableMap(map);

        try {
            constMap.put("d", "d");
        } catch (Exception e) {
            //e.printStackTrace();
        }

        //////////////////////proxy with printer////////////////////////////////////////////////////////////////
        Printer myPrinter = new Printer();
        IPrinter printerProxy = (IPrinter) Proxy.newProxyInstance
                        (Printer.class.getClassLoader(),
                        Printer.class.getInterfaces(),
                        new MyProxyHandler(myPrinter));

        IPrinter printer = printerProxy;


        //////////////////ClassLoaders/////////////////////////////////////
        MainClass mainClass = new MainClass();

        ClassChecker classChecker = new ClassChecker();



        classChecker.check(HashMap.class, printer);
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

            //////////////////////////////////////////////////////////////////////
            //interface + generic
            Class class3 = loader.findClass("MyClassGeneric");
            IMyGenericClass instanceOfClass3 = (IMyGenericClass) class3.newInstance();

            instanceOfClass3.setA("sssss");
            System.out.println( instanceOfClass3.getA());
            instanceOfClass3.setA(26);
            System.out.println( instanceOfClass3.getA());

            //interface + reflection ( inner class? )


            /*MyClassLoader loader2 = new MyClassLoader();//new instance loader

            Class class4 = loader2.findClass("MyGenericMethosClass");
            Object instanceOfClass4 = class4.newInstance();


            Method [] methods = class4.getDeclaredMethods();
            methods[0].setAccessible(true);
            //Method method_1 = class4.getMethod("getA");
            Type returnType = methods[0].getGenericReturnType();


            ParameterizedType t = (ParameterizedType) class4.getGenericSuperclass(); // OtherClass<String>
            Class<?> clazz = (Class<?>) t.getActualTypeArguments()[0]; // Class<String>



            //List<> qqw = new List<clazz>();
            //genObj = methods[0].invoke(instanceOfClass4);*/

            System.out.println();


        } catch (Exception e) {
            e.printStackTrace();
        }



        JavaAssistProxyTest assistProxyTest = new JavaAssistProxyTest();




    }


}
