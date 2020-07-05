package com.runescape.renderable;

import com.runescape.cache.def.ActorDefinition;
import com.runescape.cache.def.Animation;
import com.runescape.cache.def.AnimationSequence;
import com.runescape.cache.def.SpotAnimation;
import com.runescape.graphic.Model;
import com.runescape.util.SignLink;

public class Npc extends Actor {

    private int anInt1697;
    private int anInt1698;
    private boolean aBoolean1699;
    public ActorDefinition definition;

    public Npc() {
        anInt1698 = 8;
        aBoolean1699 = true;
    }

    @Override
    public Model getRotatedModel(int i) {
        try {
            if (definition == null) {
                return null;
            }
            Model class44_sub3_sub4_sub4 = method540(false);
            if (i != -37770) {
                throw new NullPointerException();
            }
            if (class44_sub3_sub4_sub4 == null) {
                return null;
            }
            super.anInt1661 = class44_sub3_sub4_sub4.anInt1412;
            if (super.graphicId != -1 && super.currentAnimationId != -1) {
                SpotAnimation class32 = SpotAnimation.cache[super.graphicId];
                Model class44_sub3_sub4_sub4_1 = class32.method271();
                if (class44_sub3_sub4_sub4_1 != null) {
                    int j = class32.aClass26_563.anIntArray510[super.currentAnimationId];
                    Model class44_sub3_sub4_sub4_2 = new Model(class44_sub3_sub4_sub4_1, Animation.isNullFrame(j, 0),
                            false, anInt1697, true);
                    class44_sub3_sub4_sub4_2.method519(-super.graphicHeight, 0, (byte) 2, 0);
                    class44_sub3_sub4_sub4_2.createBones((byte) 3);
                    class44_sub3_sub4_sub4_2.applyTransformation(j, 188);
                    class44_sub3_sub4_sub4_2.triangleSkin = null;
                    class44_sub3_sub4_sub4_2.vertexSkin = null;
                    if (class32.anInt566 != 128 || class32.anInt567 != 128) {
                        class44_sub3_sub4_sub4_2.scaleT(class32.anInt566, class32.anInt566, class32.anInt567,
                                (byte) 31);
                    }
                    class44_sub3_sub4_sub4_2.applyLighting(64 + class32.anInt569, 850 + class32.anInt570, -30, -50, -30,
                            true);
                    Model[] aclass44_sub3_sub4_sub4 = {class44_sub3_sub4_sub4, class44_sub3_sub4_sub4_2};
                    class44_sub3_sub4_sub4 = new Model(true, 0, aclass44_sub3_sub4_sub4, 2);
                }
            }
            if (definition.boundaryDimension == 1) {
                class44_sub3_sub4_sub4.singleTile = true;
            }
            return class44_sub3_sub4_sub4;
        } catch (RuntimeException runtimeexception) {
            SignLink.error("15988, " + i + ", " + runtimeexception.toString());
        }
        throw new RuntimeException();
    }

    private Model method540(boolean flag) {
        try {
            if (flag) {
                aBoolean1699 = !aBoolean1699;
            }
            if (super.animation >= 0 && super.animationDelay == 0) {
                int i = AnimationSequence.cache[super.animation].anIntArray510[super.currentAnimationFrame];
                int k = -1;
                if (super.anInt1640 >= 0 && super.anInt1640 != super.anInt1620) {
                    k = AnimationSequence.cache[super.anInt1640].anIntArray510[super.anInt1641];
                }
                return definition.getChildModel(k, i, AnimationSequence.cache[super.animation].anIntArray514);
            }
            int j = -1;
            if (super.anInt1640 >= 0) {
                j = AnimationSequence.cache[super.anInt1640].anIntArray510[super.anInt1641];
            }
            return definition.getChildModel(-1, j, null);
        } catch (RuntimeException runtimeexception) {
            SignLink.error("99332, " + flag + ", " + runtimeexception.toString());
        }
        throw new RuntimeException();
    }

    @Override
    public boolean method535(boolean flag) {
        try {
            if (!flag) {
                anInt1698 = -80;
            }
            return definition != null;
        } catch (RuntimeException runtimeexception) {
            SignLink.error("4937, " + flag + ", " + runtimeexception.toString());
        }
        throw new RuntimeException();
    }
}
