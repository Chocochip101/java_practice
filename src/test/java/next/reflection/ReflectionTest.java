package next.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import next.optional.Student;
import next.optional.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class ReflectionTest {
    private static final Logger logger = LoggerFactory.getLogger(ReflectionTest.class);

    @Test
    @DisplayName("테스트1: 리플렉션을 이용해서 클래스와 메소드의 정보를 정확하게 출력해야 한다.")
    public void showClass() throws Exception {
        Class<Question> clazz = Question.class;
        System.out.println(System.identityHashCode(clazz));
        logger.debug("Classs Name {}", clazz.getClass());

        Question question = new Question("Chocochip", "Reflection class", "Let's study");
        Class<? extends Question> questionClass = question.getClass();

        Field[] fields = questionClass.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            logger.debug("Field = {}", field.get(question));
        }

        Constructor<? extends Question> fullConstructor =
                questionClass.getConstructor(String.class, String.class, String.class);
        Question question2 = fullConstructor.newInstance("Constructor", "Reflection class", "Let's study");
        logger.debug("Constructor = {}", question2);

        Method[] methods = questionClass.getMethods();
        for (Method method : methods) {
            method.setAccessible(true);
            logger.debug("Method = {}", method.getName());
        }
    }

    @Test
    public void constructor() throws Exception {
        Class<Question> clazz = Question.class;
        Constructor[] constructors = clazz.getConstructors();
        for (Constructor constructor : constructors) {
            Class[] parameterTypes = constructor.getParameterTypes();
            logger.debug("paramer length : {}", parameterTypes.length);
            for (Class paramType : parameterTypes) {
                logger.debug("param type : {}", paramType);
            }
        }
    }

    @Test
    @DisplayName("테스트4: 리플랙션을 통해 private field에 값 할당 검증한다.")
    public void privateFieldAccess() throws Exception {
        Class<Student> clazz = Student.class;
        Student student = new Student();

        Field changeField = clazz.getDeclaredField("name");
        changeField.setAccessible(true);
        changeField.set(student, "재성");

        Field[] fields = clazz.getDeclaredFields();

        for (Field field : fields) {
            field.setAccessible(true);
            logger.debug("Field = {}", field.get(student));
        }
    }

    @Test
    @DisplayName("테스트5: 리플랙션을 통해 인자를 가진 생성자의 인스턴스 생성한다.")
    public void constructorInstance() throws Exception {
        Class<User> clazz = User.class;
        Constructor<?>[] constructors = clazz.getDeclaredConstructors();

        for (Constructor constructor : constructors) {
            constructor.newInstance("Softeer2", 21);
            logger.debug("Constructor = {}", constructor);
        }
    }
}
