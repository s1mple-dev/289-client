package com.runescape.renderable;

import com.runescape.Client;
import com.runescape.cache.def.AnimationSequence;
import com.runescape.cache.def.GameObjectDefinition;
import com.runescape.cache.def.VarBit;
import com.runescape.graphic.Model;
import com.runescape.util.SignLink;

public class GameObject extends Renderable {

    public static Client aClient1481;
    public int anInt1482;
    public int anInt1483;
    public int anInt1484;
    public int anInt1485;
    public int anInt1486;
    public int anInt1487;
    public int anInt1488;
    public AnimationSequence aClass26_1489;
    public int anInt1490;
    public int anInt1491;
    public int anInt1492;
    public int anIntArray1493[];

    public GameObject(int i, int j, int k, int l, int i1, boolean flag, int j1, int k1, boolean flag1, int l1) {
        try {
            anInt1482 = j;
            anInt1483 = k;
            anInt1484 = i;
            anInt1485 = j1;
            anInt1486 = l1;
            anInt1487 = i1;
            anInt1488 = l;
            if (flag) {
                throw new NullPointerException();
            }
            if (k1 != -1) {
                aClass26_1489 = AnimationSequence.cache[k1];
                anInt1490 = 0;
                anInt1491 = Client.anInt1240;
                if (flag1 && aClass26_1489.anInt513 != -1) {
                    anInt1490 = (int) (Math.random() * aClass26_1489.anInt509);
                    anInt1491 -= (int) (Math.random() * aClass26_1489.method254(anInt1490, 24425));
                }
            }
            GameObjectDefinition class8 = GameObjectDefinition.method199(anInt1482);
            anInt1492 = class8.anInt249;
            anIntArray1493 = class8.anIntArray250;
            return;
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("78557, " + i + ", " + j + ", " + k + ", " + l + ", " + i1 + ", " + flag + ", " + j1
                    + ", " + k1 + ", " + flag1 + ", " + l1 + ", " + runtimeexception.toString());
        }
        throw new RuntimeException();
    }

    @Override
    public Model getRotatedModel(int i) {
        try {
            if (i != -37770) {
                for (int j = 1; j > 0; j++) {
                }
            }
            int k = -1;
            if (aClass26_1489 != null) {
                int l = Client.anInt1240 - anInt1491;
                if (l > 100 && aClass26_1489.anInt513 > 0) {
                    l = 100;
                }
                while (l > aClass26_1489.method254(anInt1490, 24425)) {
                    l -= aClass26_1489.method254(anInt1490, 24425);
                    anInt1490++;
                    if (anInt1490 < aClass26_1489.anInt509) {
                        continue;
                    }
                    anInt1490 -= aClass26_1489.anInt513;
                    if (anInt1490 >= 0 && anInt1490 < aClass26_1489.anInt509) {
                        continue;
                    }
                    aClass26_1489 = null;
                    break;
                }
                anInt1491 = Client.anInt1240 - l;
                k = aClass26_1489.anIntArray510[anInt1490];
            }
            GameObjectDefinition class8;
            if (anIntArray1493 != null) {
                VarBit class35 = VarBit.aClass35Array590[anInt1492];
                int i1 = class35.anInt592;
                int j1 = class35.anInt593;
                int k1 = class35.anInt594;
                int l1 = Client.anIntArray1088[k1 - j1];
                int i2 = GameObject.aClient1481.anIntArray1214[i1] >> j1 & l1;
                if (i2 < 0 || i2 >= anIntArray1493.length || anIntArray1493[i2] == -1) {
                    return null;
                }
                class8 = GameObjectDefinition.method199(anIntArray1493[i2]);
            } else {
                class8 = GameObjectDefinition.method199(anInt1482);
            }
            Model class44_sub3_sub4_sub4 = class8.method205(anInt1483, anInt1484, anInt1485, anInt1486, anInt1487,
                    anInt1488, k);
            return class44_sub3_sub4_sub4;
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("27197, " + i + ", " + runtimeexception.toString());
        }
        throw new RuntimeException();
    }
}
