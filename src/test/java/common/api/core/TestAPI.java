
package common.api.core;

import java.util.concurrent.Future;

public interface TestAPI extends BaseAPI<TestAPI, Void> {

    Future<String> test();
}
