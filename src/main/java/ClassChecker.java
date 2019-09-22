public class ClassChecker {

    //private  Class curClass;
    //private Class[] curInterfaces;

    public void checkParentClasses (Class curClass, Printer printer){

        printer.addtoStrLn(curClass.getName());
        curClass = curClass.getSuperclass();

        if (curClass!= null){
            checkParentClasses(curClass, printer);
        }
    }

    public void checkParentInterfaces(Class originClass, Printer printer, int lvl ){

        Class [] curInterfaces = originClass.getInterfaces();

        if (curInterfaces.length!=0){
            for (Class curInt : curInterfaces) {
             checkParentInterfaces(curInt, printer,lvl+1);
            }
            printer.addToTree(lvl);
        }
        printer.addToTree(originClass.getName(), lvl);

    }

}
