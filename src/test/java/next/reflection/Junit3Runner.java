package next.reflection;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Junit3Runner {
    @Test
    @DisplayName("테스트라는 이름을 가진 메서드들만 실행")
    public void runner() throws Exception {
        Class clazz = Junit3Test.class;
        Method[] methods = clazz.getDeclaredMethods();
        final String EXPECTED_NAME = "test";

        for(Method method : methods) {
            if(method.getName().startsWith(EXPECTED_NAME)) {
                try {
                    method.invoke(clazz.newInstance());
                } catch (InvocationTargetException | IllegalAccessException | InstantiationException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

}
