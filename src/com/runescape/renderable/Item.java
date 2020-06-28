package com.runescape.renderable;

import com.runescape.cache.def.ItemDefinition;
import com.runescape.graphic.Model;
import com.runescape.util.SignLink;

public class Item extends Renderable {

    private boolean aBoolean1494;
    public int anInt1495;
    public int anInt1496;

    public Item() {
        aBoolean1494 = true;
    }

    @Override
    public Model getRotatedModel(int i) {
        try {
            ItemDefinition class14 = ItemDefinition.method220(anInt1495);
            if (i != -37770) {
                aBoolean1494 = !aBoolean1494;
            }
            return class14.method224(anInt1496);
        } catch (RuntimeException runtimeexception) {
            SignLink.error("51746, " + i + ", " + runtimeexception.toString());
        }
        throw new RuntimeException();
    }
}
