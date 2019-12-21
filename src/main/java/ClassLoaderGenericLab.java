public class ClassLoaderGenericLab {

    Class doLabInterface(String strValue, Integer intValue) throws ClassNotFoundException, IllegalAccessException, InstantiationException {


        System.out.println("-------------- GenericLoader -------------");

        MyClassLoader loader = new MyClassLoader();

        Class myClassGeneric = loader.findClass("MyClassGeneric");
        IMyGenericClass instance = (IMyGenericClass) myClassGeneric.newInstance();

        instance.setA(strValue);
        System.out.println(instance.getA());
        instance.setA(intValue);
        System.out.println(instance.getA());

        return myClassGeneric;
    }
}
