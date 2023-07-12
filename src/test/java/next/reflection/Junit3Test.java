package next.reflection;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Junit3Test {

    private static final Logger logger = LoggerFactory.getLogger(Junit3Test.class);
    public void test1()  {
        logger.debug("Running Test1");
    }

    public void test2(){
        logger.debug("Running Test2");
    }

    public void three() {
        logger.debug("Running Test3");
    }
}
