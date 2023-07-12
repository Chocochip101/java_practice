package next.reflection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BonusTest {
    private static final Logger logger = LoggerFactory.getLogger(BonusTest.class);

    @ElapsedTime
    public void test1()  {
        logger.debug("Running Test1");
    }

    @ElapsedTime
    public void test2(){
        try {
            Thread.sleep(2000);
        } catch(InterruptedException e) {
            logger.error(e.getMessage());
        }
        logger.debug("Running Test2");
    }

    public void three() {
        logger.debug("Running Test3");
    }
}
