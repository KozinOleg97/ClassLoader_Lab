public class MyClassGeneric<T> implements IMyGenericClass<T> {

    T a;
    @Override
    public T getA() {
        return a;
    }

    @Override
    public void setA(T a) {
        this.a = a;
    }
}
