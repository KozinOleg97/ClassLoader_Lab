import com.sun.xml.internal.bind.v2.TODO;
import javassist.*;

import java.io.IOException;

public class JavaAssistProxyTest {


    public JavaAssistProxyTest() throws NotFoundException, CannotCompileException, IllegalAccessException, InstantiationException, NoSuchMethodException, IOException {

        System.out.println("-------------- JavaAssistProxyTest -------------");

        ClassPool pool = ClassPool.getDefault();
        CtClass classToMod = pool.get("Printer");
        classToMod.setName("ProxyPrinter");

        CtMethod[] allMethods = classToMod.getDeclaredMethods();
        modifyMethods(allMethods, classToMod);


        Class loadedClass = classToMod.toClass();
        IPrinter loadedClassInst = (IPrinter) loadedClass.newInstance();


        loadedClassInst.addToStrLn("TestProxy");
        loadedClassInst.print();


        classToMod.writeFile();
    }

    void modifyMethods(CtMethod[] allmethods, CtClass ctClass) {

        try {
            for (CtMethod method : allmethods) {
                if (method.hasAnnotation(MyAnnotation.class)) {

                    //TODO params substitution ($)

                    method.insertBefore("{" +
                            "loger.info(\" $1 \");" +
                            " loger.info(\" $$ \");}");
                    method.insertAfter("{" +
                            "loger.info(\" $_, $r \");" +
                            "System.out.println(\"$1\");" +
                            "}");

                }
            }


        } catch (Exception ex) {
            System.out.println("Err 1");
        }
    }
}
