package common.api.core;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Future;

public interface BaseAPI<T extends BaseAPI<T, V>, V> {

    @SuppressWarnings("rawtypes")
    List<BaseAPI> INSTANCES = Collections.synchronizedList(new ArrayList<>());

    @SuppressWarnings("unchecked")
    default List<T> getInstances() {
        return (List<T>) INSTANCES;
    }

    Future<V> invoke();
}
