package next.reflection;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.lang.reflect.Method;

public class Junit4Runner {
    @Test
    @DisplayName("MyTest annotation이 달린 메서드들만 실행")
    public void run() throws Exception {
        Class clazz = Junit4Test.class;

        Method[] methods = clazz.getDeclaredMethods();
        for(Method method : methods) {
            if(method.isAnnotationPresent(MyTest.class)) {
                method.invoke(clazz.newInstance());
            }
        }
    }
}


