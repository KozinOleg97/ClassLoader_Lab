public class ClassChecker {

    //private  Class curClass;
    private Class[] curInterfaces;

    public void check (Class curClass, Printer printer){

        printer.addtoStrLn(curClass.getName());

        curInterfaces = curClass.getInterfaces();
        curClass = curClass.getSuperclass();

        if (curClass!= null){
            check(curClass, printer);
        }



    }

}
