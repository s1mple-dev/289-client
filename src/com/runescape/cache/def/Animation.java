package com.runescape.cache.def;

import com.runescape.graphic.Skins;
import com.runescape.net.Buffer;
import com.runescape.util.SignLink;

public class Animation {

    private static int anInt262;
    private static int anInt263 = 2;
    private static Animation[] aClass11Array264;
    private static boolean[] aBooleanArray272;
    public int anInt265;
    public Skins aClass9_266;
    public int anInt267;
    public int[] anIntArray268;
    public int[] anIntArray269;
    public int[] anIntArray270;
    public int[] anIntArray271;

    private Animation() {
    }

    public static void method207(int i) {
        Animation.aClass11Array264 = new Animation[i + 1];
        Animation.aBooleanArray272 = new boolean[i + 1];
        for (int j = 0; j < i + 1; j++) {
            Animation.aBooleanArray272[j] = true;
        }
    }

    public static void method208(int i, byte[] abyte0) {
        try {
            Buffer class44_sub3_sub2 = new Buffer(abyte0);
            class44_sub3_sub2.offset = abyte0.length - 8;
            int j = class44_sub3_sub2.readUnsignedShort();
            int k = class44_sub3_sub2.readUnsignedShort();
            int l = class44_sub3_sub2.readUnsignedShort();
            int i1 = class44_sub3_sub2.readUnsignedShort();
            int j1 = 0;
            Buffer class44_sub3_sub2_1 = new Buffer(abyte0);
            class44_sub3_sub2_1.offset = j1;
            j1 += j + 2;
            Buffer class44_sub3_sub2_2 = new Buffer(abyte0);
            class44_sub3_sub2_2.offset = j1;
            j1 += k;
            Buffer class44_sub3_sub2_3 = new Buffer(abyte0);
            class44_sub3_sub2_3.offset = j1;
            j1 += l;
            Buffer class44_sub3_sub2_4 = new Buffer(abyte0);
            class44_sub3_sub2_4.offset = j1;
            j1 += i1;
            Buffer class44_sub3_sub2_5 = new Buffer(abyte0);
            class44_sub3_sub2_5.offset = j1;
            Skins class9 = new Skins(class44_sub3_sub2_5, Animation.anInt262);
            int k1 = class44_sub3_sub2_1.readUnsignedShort();
            if (i != 2) {
                return;
            }
            int[] ai = new int[500];
            int[] ai1 = new int[500];
            int[] ai2 = new int[500];
            int[] ai3 = new int[500];
            for (int l1 = 0; l1 < k1; l1++) {
                int i2 = class44_sub3_sub2_1.readUnsignedShort();
                Animation class11 = Animation.aClass11Array264[i2] = new Animation();
                class11.anInt265 = class44_sub3_sub2_4.readUnsignedByte();
                class11.aClass9_266 = class9;
                int j2 = class44_sub3_sub2_1.readUnsignedByte();
                int k2 = -1;
                int l2 = 0;
                for (int i3 = 0; i3 < j2; i3++) {
                    int j3 = class44_sub3_sub2_2.readUnsignedByte();
                    if (j3 > 0) {
                        if (class9.anIntArray254[i3] != 0) {
                            for (int l3 = i3 - 1; l3 > k2; l3--) {
                                if (class9.anIntArray254[l3] != 0) {
                                    continue;
                                }
                                ai[l2] = l3;
                                ai1[l2] = 0;
                                ai2[l2] = 0;
                                ai3[l2] = 0;
                                l2++;
                                break;
                            }
                        }
                        ai[l2] = i3;
                        char c = '\0';
                        if (class9.anIntArray254[i3] == 3) {
                            c = '\200';
                        }
                        if ((j3 & 1) != 0) {
                            ai1[l2] = class44_sub3_sub2_3.readUnsignedSmartA();
                        } else {
                            ai1[l2] = c;
                        }
                        if ((j3 & 2) != 0) {
                            ai2[l2] = class44_sub3_sub2_3.readUnsignedSmartA();
                        } else {
                            ai2[l2] = c;
                        }
                        if ((j3 & 4) != 0) {
                            ai3[l2] = class44_sub3_sub2_3.readUnsignedSmartA();
                        } else {
                            ai3[l2] = c;
                        }
                        k2 = i3;
                        l2++;
                        if (class9.anIntArray254[i3] == 5) {
                            Animation.aBooleanArray272[i2] = false;
                        }
                    }
                }
                class11.anInt267 = l2;
                class11.anIntArray268 = new int[l2];
                class11.anIntArray269 = new int[l2];
                class11.anIntArray270 = new int[l2];
                class11.anIntArray271 = new int[l2];
                for (int k3 = 0; k3 < l2; k3++) {
                    class11.anIntArray268[k3] = ai[k3];
                    class11.anIntArray269[k3] = ai1[k3];
                    class11.anIntArray270[k3] = ai2[k3];
                    class11.anIntArray271[k3] = ai3[k3];
                }
            }
            return;
        } catch (RuntimeException runtimeexception) {
            SignLink.error("77261, " + i + ", " + abyte0 + ", " + runtimeexception.toString());
        }
        throw new RuntimeException();
    }

    public static void method209(byte byte0) {
        try {
            if (byte0 != 42) {
                Animation.anInt262 = 423;
            }
            Animation.aClass11Array264 = null;
            return;
        } catch (RuntimeException runtimeexception) {
            SignLink.error("94238, " + byte0 + ", " + runtimeexception.toString());
        }
        throw new RuntimeException();
    }

    public static Animation method210(int i, byte byte0) {
        try {
            if (byte0 == 4) {
                byte0 = 0;
            } else {
                Animation.anInt263 = -60;
            }
            if (Animation.aClass11Array264 == null) {
                return null;
            } else {
                return Animation.aClass11Array264[i];
            }
        } catch (RuntimeException runtimeexception) {
            SignLink.error("52733, " + i + ", " + byte0 + ", " + runtimeexception.toString());
        }
        throw new RuntimeException();
    }

    public static boolean method211(int i, int j) {
        try {
            if (j != 0) {
                Animation.anInt263 = 271;
            }
            return i == -1;
        } catch (RuntimeException runtimeexception) {
            SignLink.error("34856, " + i + ", " + j + ", " + runtimeexception.toString());
        }
        throw new RuntimeException();
    }

}
