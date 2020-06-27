package com.runescape.collection;

public class Node {

    public long nodeId;
    public Node nextNode;
    public Node previousNode;

    public void remove() {
        if (previousNode != null) {
            previousNode.nextNode = nextNode;
            nextNode.previousNode = previousNode;
            nextNode = null;
            previousNode = null;
        }
    }
}
