package next.reflection;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class BonusRunner {
    private static final Logger logger = LoggerFactory.getLogger(BonusRunner.class);
    @Test
    @DisplayName("Elapsed Annotation있는 메서드들만 가져와서 수행시간 측정")
    public void runner() throws Exception {
        Class clazz = BonusTest.class;
        Method[] methods = clazz.getDeclaredMethods();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYYY-MM-DD HH:mm:ss.SSS");

        for(Method method : methods) {
            if(method.isAnnotationPresent(ElapsedTime.class)) {
                long startTime = System.currentTimeMillis();
                logger.debug("= Start Time : {}", simpleDateFormat.format(startTime));
                method.invoke(clazz.newInstance());
                long endTime = System.currentTimeMillis();
                logger.debug("= End Time : {}", simpleDateFormat.format(endTime));
                logger.debug("= Elapsed Time : {} ms", endTime - startTime);
                logger.debug("=========================");

            }
        }
    }
}
