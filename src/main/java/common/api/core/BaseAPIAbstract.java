
package common.api.core;

public abstract class BaseAPIAbstract<T extends BaseAPI<T, V>, V> implements BaseAPI<T, V> {

    public BaseAPIAbstract() {
        INSTANCES.add(this);
    }
}
