import jdk.nashorn.internal.runtime.Context;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ClassLoaderLab {

    void doReflect(int value) throws ClassNotFoundException, IllegalAccessException, InstantiationException, InvocationTargetException, NoSuchMethodException {

        System.out.println();
        System.out.println("----------------ClassLoader reflection---------------");



        MyClassLoader loader = new MyClassLoader();

        Class class1 = loader.findClass("MyClass");
        Object instanceOfClass1 = class1.newInstance();

        System.out.println("Loaded: " + class1.getName());

        Method method1 = class1.getMethod("SetA", int.class);
        method1.invoke(instanceOfClass1, value);

        Method method2 = class1.getMethod("PrintA");
        method2.invoke(instanceOfClass1);
    }

    void doInterface(String className) throws ClassNotFoundException, IllegalAccessException, InstantiationException, IOException {

        System.out.println();
        System.out.println("----------------ClassLoader reflection---------------");

        MyClassLoader loader = new MyClassLoader();


        Class class2 = loader.findClass("MyClass2");
        IMyClass2 instanceOfClass2 = (IMyClass2) class2.newInstance();


        System.out.println("Loaded: " + class2.getName());



        instanceOfClass2.Hello();
        instanceOfClass2.PrintStr("Job done");
    }




}
