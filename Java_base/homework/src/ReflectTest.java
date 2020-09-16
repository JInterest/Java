import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectTest {

    public static void refMethod(String c,String name,String pw) {

        try {

            Class cClass=Class.forName(c);
            Object o=cClass.newInstance();
            Method refMethod =cClass.getMethod("set", String.class, String.class);
            refMethod.invoke(o,name,pw);
            System.out.println(o);

        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
