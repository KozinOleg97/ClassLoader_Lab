import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ClassChecker {

    //private  Class curClass;
    //private Class[] curInterfaces;

    public void check(Class curClass, IPrinter printer){
        checkParentClasses(curClass, printer);
        checkParentInterfaces(curClass, printer, 0);
    }

    private void checkParentClasses (Class curClass, IPrinter printer){

        printer.addToStrLn(curClass.getName());



        for (Field f: curClass.getDeclaredFields() ) {
            printer.addToStrLn(" (f)" + f.getType() + " " + f.getName());
        }

        for (Method m: curClass.getDeclaredMethods()) {
            printer.addToStrLn(" (m)" +  m.getName());
        }


        printer.addToStrLn("");

        curClass = curClass.getSuperclass();

        if (curClass!= null){
            checkParentClasses(curClass, printer);
        }
    }

    private void checkParentInterfaces(Class originClass, IPrinter printer, int lvl ){

        Class [] curInterfaces = originClass.getInterfaces();

        printer.addToTree(originClass.getName(), lvl);
        if (curInterfaces.length!=0){
            for (Class curInt : curInterfaces) {
             checkParentInterfaces(curInt, printer,lvl+1);
            }
        }


    }

}
