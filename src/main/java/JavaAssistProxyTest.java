


import javassist.*;

import java.io.IOException;

public class JavaAssistProxyTest {



    public  Class doLab(String className, Integer value) throws NotFoundException, CannotCompileException, IllegalAccessException, InstantiationException, NoSuchMethodException, IOException {

        System.out.println("-------------- JavaAssistProxyTest -------------");

        ClassPool pool = ClassPool.getDefault();
        pool.importPackage("org.apache.log4j"); // don't work with get() methods
        //pool.importPackage( "java.lang.reflect.*");

        CtClass classToMod = pool.get(className);
        classToMod.setName("Proxy");


        CtMethod[] allMethods = classToMod.getDeclaredMethods();
        modifyMethods(allMethods, classToMod);


        Class loadedClass = classToMod.toClass();
        ITest loadedClassInst = (ITest) loadedClass.newInstance();


        loadedClassInst.set(value);
        System.out.printf(String.valueOf(loadedClassInst.get()));
        System.out.println("\n");


        classToMod.writeFile();

        return loadedClass;
    }

    /**
     * @param allmethods
     * @param ctClass
     */
    void modifyMethods(CtMethod[] allmethods, CtClass ctClass) {

        try {

            for (CtMethod method : allmethods) {
                if (method.hasAnnotation(MyAnnotation.class)) {


                    method.insertBefore("{"
                            + "org.apache.log4j.Logger logger =  org.apache.log4j.LogManager.getLogger(\"\"); "
                            + "String param = \"Method '" + method.getName() + "' params: \";"
                            + "for (int i = 0; i < $args.length; i++ )"
                            + " param += $args[i] + \" \";"
                            + "logger.info(param);"
                            + "}");

                    method.insertAfter("{"
                            + "org.apache.log4j.Logger logger =  org.apache.log4j.LogManager.getLogger(\"\");"
                            + "logger.info( \"Method '" + method.getName() + "' returns: \" + $_);"
                            + "}");


                }
            }


        } catch (Exception ex) {
            System.out.println("Err 1");
        }
    }
}
