import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ClassChecker {

    //private  Class curClass;
    //private Class[] curInterfaces;

    public void check(Class curClass, Printer printer){
        checkParentClasses(curClass, printer);
        checkParentInterfaces(curClass, printer, 0);
    }

    private void checkParentClasses (Class curClass, Printer printer){

        printer.addtoStr(curClass.getName());



        for (Field f: curClass.getDeclaredFields() ) {
            printer.addtoStr(" (f)" + f.getName());
        }

        for (Method m: curClass.getDeclaredMethods()) {
            printer.addtoStr(" (m)" + m.getName());
        }


        printer.addtoStrLn("");

        curClass = curClass.getSuperclass();

        if (curClass!= null){
            checkParentClasses(curClass, printer);
        }
    }

    private void checkParentInterfaces(Class originClass, Printer printer, int lvl ){

        Class [] curInterfaces = originClass.getInterfaces();

        printer.addToTree(originClass.getName(), lvl);
        if (curInterfaces.length!=0){
            for (Class curInt : curInterfaces) {
             checkParentInterfaces(curInt, printer,lvl+1);
            }
        }


    }

}
