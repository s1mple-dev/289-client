package com.runescape.cache.request;

import com.runescape.collection.CacheableNode;

public class OnDemandNode extends CacheableNode {

    public int dataType;
    public int index;
    public byte[] buffer;
    public int loopCycle;
    public boolean incomplete;

    public OnDemandNode() {
        incomplete = true;
    }
}
