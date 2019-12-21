import jdk.nashorn.internal.runtime.Context;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ClassLoaderLab {

    Class doReflect(int value) throws ClassNotFoundException, IllegalAccessException, InstantiationException, InvocationTargetException, NoSuchMethodException {

        System.out.println();
        System.out.println("----------------ClassLoader reflection---------------");


        MyClassLoader loader = new MyClassLoader();

        Class myClass = loader.findClass("MyClass");
        Object instanceOfClass1 = myClass.newInstance();

        System.out.println("Loaded: " + myClass.getName());

        Method method1 = myClass.getMethod("SetA", int.class);
        method1.invoke(instanceOfClass1, value);

        Method method2 = myClass.getMethod("PrintA");
        method2.invoke(instanceOfClass1);

        return myClass;
    }

    Class doInterface() throws ClassNotFoundException, IllegalAccessException, InstantiationException, IOException {

        System.out.println();
        System.out.println("----------------ClassLoader reflection---------------");

        MyClassLoader loader = new MyClassLoader();


        Class myClass = loader.findClass("MyClass2");
        IMyClass2 instanceOfClass2 = (IMyClass2) myClass.newInstance();


        System.out.println("Loaded: " + myClass.getName());


        instanceOfClass2.Hello();
        instanceOfClass2.PrintStr("Job done");

        return myClass;
    }


}
