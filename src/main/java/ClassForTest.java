public class ClassForTest implements ITest{


    int value;


    @MyAnnotation
    public int get(){
        return value;
    }

    @MyAnnotation
    public void set (int value){
        this.value = value;
    }
}
