import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyProxyHandler implements InvocationHandler {

    private Object obj;


    MyProxyHandler(Object obj){
        this.obj=obj;

    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //log
        //System.out.println("PROXY");
        return method.invoke(obj, args);
    }
}
