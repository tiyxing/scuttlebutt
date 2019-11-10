package org.sword.scuttlebutt;

import lombok.extern.slf4j.Slf4j;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author tiyxing
 * @date 2019-11-10
 * @since 1.0.0
 */
@Slf4j
public class Model<T> extends Scuttlebutt<T> {
    private Map<String, Update<T>> store = new ConcurrentHashMap<>();

    @Override
    public Update<T>[] history(Map<String, Long> peerSource) {
        Update[] updates = store.values().stream().filter(tUpdate -> {
            if (peerSource.containsKey(tUpdate.getSourceId()) && peerSource.get(tUpdate.getSourceId()) > tUpdate.getTimestamp()) {
                return false;
            }
            return true;
        }).toArray(Update[]::new);
        return updates;
    }

    @Override
    public void applyUpdates(Update update) {
        String key = update.getBizData().getKey();
        if (store.get(key) != null && store.get(key).getTimestamp() > update.getTimestamp()) {
            log.info("{} apply update from:{} but update timestamp old", sourceId, update.getSourceId());
            return;
        }
        store.putIfAbsent(key, update);
    }

    @Override
    public void localUpdate(Update update) {
        source.putIfAbsent(sourceId, update.getTimestamp());
        applyUpdates(update);
    }


    public void set(String key, T value) {
        localUpdate(new Update<>(sourceId, System.currentTimeMillis(), new BizData<>(key, value)));
    }

    public T get(String key) {
        return store.get(key).getBizData().getValue();
    }
}
