import javassist.CannotCompileException;
import javassist.NotFoundException;
import sun.awt.SunHints;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class MainClass {


    public static void main(String[] args) throws CannotCompileException, InstantiationException, NotFoundException, IllegalAccessException, NoSuchMethodException, IOException {

        ClassChecker checker = new ClassChecker();

        ClassLoaderLab classLoaderLab = new ClassLoaderLab();
        try {
            System.out.println(checker.check(classLoaderLab.doReflect(228)));
            System.out.println("\n");
            System.out.println(checker.check(classLoaderLab.doInterface()));
            System.out.println("\n");


        } catch (Exception e) {
            e.printStackTrace();
        }


        JavaAssistProxyTest javaAssistLab = new JavaAssistProxyTest();
        System.out.println(checker.check(javaAssistLab.doLab("ClassForTest", 100500)));


        ClassLoaderGenericLab genericLab = new ClassLoaderGenericLab();
        try {
            System.out.println(checker.check(genericLab.doLabInterface("This is string", 8800)));

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }




    Class2 class2 = new Class2();
        Integer[] mas = {1,2,3,4,5,6};
        Integer var = 5;
        ArrayList<Integer> list = new ArrayList<>();
        Integer res = class2.qwe(mas, list, var);

        String[] mas2 = {"1", "2", "www"};
        String var2 = "str";
        ArrayList<String> list2 = new ArrayList<>();
        class2.qwe(mas2, list2, var2);
        String res2 = class2.qwe(mas2, list2, var2);


        //interface + reflection


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

      /*      System.out.println();


        } catch (Exception e) {
            e.printStackTrace();
        }
*/


    }


}
