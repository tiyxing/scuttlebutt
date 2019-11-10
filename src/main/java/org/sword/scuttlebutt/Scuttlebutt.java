package org.sword.scuttlebutt;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author tiyxing
 * @date 2019-11-10
 * @since 1.0.0
 */
public abstract class Scuttlebutt<T> {

    protected String sourceId;

    protected Map<String,Long> source=new ConcurrentHashMap<>();

    public abstract Update<T>[] history(Map<String, Long> peerSource);

    public abstract void applyUpdates(Update<T> update);

    public abstract void localUpdate(Update<T> update);

    private Duplex creatStream(){
        return  new Duplex(this);
    }








}
