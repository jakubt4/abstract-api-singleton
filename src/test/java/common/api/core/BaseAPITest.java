
package common.api.core;

import static org.junit.Assert.assertEquals;
import java.util.List;
import java.util.concurrent.Future;
import org.junit.Before;
import org.junit.Test;

public class BaseAPITest {

    private TestAPI testAPIImpl1;
    private TestAPI testAPIImpl2;
    private TestAPI testAPIImpl3;

    @Before
    public void init() {
        this.testAPIImpl1 = new TestAPIImpl("1");
        this.testAPIImpl2 = new TestAPIImpl("2");
        this.testAPIImpl3 = new TestAPIImpl("3");
    }

    @Test
    public void instancesTest() throws Exception {
        final TestAPI testAPIImpl = new TestAPIImpl("local");
        final List<TestAPI> instances = testAPIImpl.getInstances();
        synchronized (instances) {
            for (final TestAPI testAPI : instances) {
                testAPI.invoke();
            }
        }
        testFutures(testAPIImpl, "local");
        testFutures(this.testAPIImpl1, "1");
        testFutures(this.testAPIImpl2, "2");
        testFutures(this.testAPIImpl3, "3");
    }

    private void testFutures(final TestAPI testAPI, final String expected) throws Exception {
        final Future<String> testLocal = testAPI.test();
        assertEquals(expected, testLocal.get());
    }
}
