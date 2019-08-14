
package common.api.core;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

public final class TestAPIImpl extends BaseAPIAbstract<TestAPI, Void> implements TestAPI {

    private final String num;
    private final CompletableFuture<String> completableFuture;

    public TestAPIImpl(final String num) {
        this.num = num;
        this.completableFuture = new CompletableFuture<>();
    }

    @Override
    public Future<Void> invoke() {
        this.completableFuture.complete(this.num);
        return CompletableFuture.completedFuture(null);
    }

    @Override
    public Future<String> test() {
        return this.completableFuture;
    }

}
