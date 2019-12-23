import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Type;

public class ClassChecker {

    //private  Class curClass;
    //private Class[] curInterfaces;

    private static final String DEPTH_CHARACTER = "     ";
    private static final String DEPTH_DIRECTORY = "|--";


    public String check(Class curClass) {
        return this.getAll(curClass, new StringBuilder()).toString();
    }


    private StringBuilder getAll(Class name, StringBuilder depth) {
        StringBuilder sb = new StringBuilder();
        StringBuilder dp = new StringBuilder();
        dp.append(depth);
        dp.append(DEPTH_CHARACTER);
        sb.append(this.getLoader(name, dp));
        sb.append(this.getField(name, dp));
        sb.append(this.getMethods(name, dp));
        sb.append(this.getInterfaces(name, dp));
        sb.append(this.getParentClass(name, dp));

        return sb;
    }

    private StringBuilder getParentClass(Class name, StringBuilder depth) {
        StringBuilder sb = new StringBuilder();
        sb.append(depth + " ------------------------------------------------------------- \n");
        StringBuilder dp = new StringBuilder();
        dp.append(depth);
        sb.append(dp);
        dp.append(DEPTH_CHARACTER);
        sb.append(getAnnotations(name.getAnnotations(), depth));
        sb.append("<C| Class name:  ");
        sb.append(name.getName());
        sb.append(" Parent class: ");
        if (name.getSuperclass() != null) {
            sb.append(name.getSuperclass().getName()).append("\n");
        } else {
            sb.append("none").append("\n");
        }
        if (name.getSuperclass() != null) {
            sb.append(this.getAll(name.getSuperclass(), dp));
        }
        return sb;
    }

    private StringBuilder getInterfaces(Class name, StringBuilder depth) {
        Class[] allInterfaces = name.getInterfaces();
        StringBuilder sb = new StringBuilder();
        sb.append(depth + " ------------------------------------------------------------- \n");
        StringBuilder dp = new StringBuilder();
        dp.append(depth);
        StringBuilder lineBegin = new StringBuilder();
        lineBegin.append(dp);
        sb.append(lineBegin);
        lineBegin.append(DEPTH_DIRECTORY);
        dp.append(DEPTH_CHARACTER);
        sb.append(getAnnotations(name.getAnnotations(), depth));
        sb.append("<I| Class name:  ").append(name.getName());
        sb.append(" Interfaces: ").append(allInterfaces.length).append("\n");
        for (Class aInterface : allInterfaces) {
            sb.append(getAnnotations(aInterface.getAnnotations(), depth));
            sb.append(lineBegin);
            sb.append(aInterface.getName());
            Type tempType = aInterface.getGenericSuperclass();
            if (tempType != null) {
                sb.append("         Generic type:   ").append(tempType);
            }

            sb.append("\n");
            sb.append(this.getAll(aInterface, dp));
        }
        return sb;
    }

    private StringBuilder getField(Class name, StringBuilder depth) {
        Field[] allFields = name.getDeclaredFields();
        StringBuilder sb = new StringBuilder();
        sb.append(depth + " ------------------------------------------------------------- \n");
        StringBuilder lineBegin = new StringBuilder();
        lineBegin.append(depth);
        sb.append(lineBegin);
        lineBegin.append(DEPTH_DIRECTORY);
        sb.append(getAnnotations(name.getAnnotations(), depth));
        sb.append("<F| Class name:  ").append(name.getName());
        sb.append(" Fields: ").append(allFields.length).append("\n");
        for (Field field : allFields) {

            String str = field.toString().replaceAll(name.getName().toString() + ".", "");
            sb.append(lineBegin);
            sb.append(str);

            sb.append(getGeneric(field, depth));
        }
        return sb;
    }

    private StringBuilder getLoader(Class name, StringBuilder depth) {
        StringBuilder sb = new StringBuilder();
        sb.append(depth + " ------------------------------------------------------------- \n");
        sb.append(depth);
        ClassLoader loader = name.getClassLoader();
        sb.append(getAnnotations(name.getAnnotations(), depth));
        sb.append("<L| Class name:  ").append(name.getName());
        sb.append("     Class loader name:  ");
        if (loader != null) {
            sb.append(getAnnotations(loader.getClass().getAnnotations(), depth));
            sb.append(loader.getClass().getName());
        } else {
            sb.append("The default system class was used.");
        }
        sb.append("\n");
        return sb;
    }

    private StringBuilder getMethods(Class name, StringBuilder depth) {
        Method[] allMethods = name.getDeclaredMethods();
        StringBuilder sb = new StringBuilder();
        sb.append(depth + " ------------------------------------------------------------- \n");
        StringBuilder lineBegin = new StringBuilder();
        lineBegin.append(depth);
        sb.append(lineBegin);
        lineBegin.append(DEPTH_DIRECTORY);
        sb.append(getAnnotations(name.getAnnotations(), depth));
        sb.append("<M| Class name:  ").append(name.getName());
        sb.append(" Methods:    ").append(allMethods.length).append("\n");
        for (Method method : allMethods) {
            sb.append(getAnnotations(method.getAnnotations(), depth));
            sb.append(lineBegin);
            sb.append(method.toString()
                    .replaceAll(name.getName().toString() + ".", ""));
            sb.append(getGeneric(method, depth));

        }
        return sb;
    }

    private StringBuilder getGeneric(Method method, StringBuilder depth) {
        StringBuilder sb = new StringBuilder();
        Type[] tempType = method.getGenericParameterTypes();
        if (tempType.length > 0) {
            sb.append("         Generic type:   ");
        }
        for (Type type : tempType) {
            sb.append(type.toString().replaceAll("java.lang.", "")).append(";" + DEPTH_CHARACTER);
        }
        sb.append("\n");

        return sb;
    }

    private StringBuilder getGeneric(Field field, StringBuilder depth) {
        StringBuilder sb = new StringBuilder();
        Type tempType = field.getGenericType();

        if (tempType != null) {
            sb.append("         Generic type:   ").append(tempType.toString()
                    .replaceAll("java.lang.", "")
                    + ";");
        }
        sb.append("\n");

        return sb;
    }

    private StringBuilder getAnnotations(Annotation[] allAnnotations, StringBuilder depth) {
        StringBuilder sb = new StringBuilder();
        for (Annotation annotation : allAnnotations) {
            sb.append(depth).append(DEPTH_CHARACTER);
            sb.append(annotation.toString()).append("\n");
        }
        return sb;
    }


}
