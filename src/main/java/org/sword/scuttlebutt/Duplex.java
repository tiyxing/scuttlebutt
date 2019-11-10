package org.sword.scuttlebutt;

import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * @author tiyxing
 * @date 2019-11-10
 * @since 1.0.0
 */
public class Duplex {

    private Scuttlebutt sb;

    public Map<String,Long> peerClock;

    private ArrayBlockingQueue arrayBlockingQueue;

    private boolean syncSent;

    private boolean syncRecv;

    public Duplex(Scuttlebutt scuttlebutt){
        this.sb=scuttlebutt;
    }

    public void source(){


    }

    public void sink(){

    }

    public void sync(){

    }


}
