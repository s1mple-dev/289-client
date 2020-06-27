package com.runescape.collection;

public class CacheableNode extends Node {

    public CacheableNode next;
    public CacheableNode previous;

    public void removeCacheable() {
        if (previous == null) {
            return;
        }

        previous.next = next;
        next.previous = previous;
        next = null;
        previous = null;
    }
}
