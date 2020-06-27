package com.runescape.cache.def;

import com.runescape.cache.Archive;
import com.runescape.net.Buffer;
import com.runescape.util.SignLink;

public class AnimationSequence {

    private static boolean aBoolean506 = true;
    private static int anInt507;
    public static AnimationSequence[] cache;
    public static int anInt524;
    private final byte aByte505;
    public int anInt509;
    public int[] anIntArray510;
    public int[] anIntArray511;
    private int[] anIntArray512;
    public int anInt513;
    public int[] anIntArray514;
    public boolean aBoolean515;
    public int anInt516;
    public int anInt517;
    public int anInt518;
    public int anInt519;
    public int anInt520;
    public int anInt521;
    public int anInt522;

    private AnimationSequence() {
        boolean aBoolean504 = false;
        aByte505 = 4;
        anInt513 = -1;
        aBoolean515 = false;
        anInt516 = 5;
        anInt517 = -1;
        anInt518 = -1;
        anInt519 = 99;
        anInt520 = -1;
        anInt521 = -1;
    }

    public static void method253(boolean flag, Archive class47) {
        try {
            Buffer class44_sub3_sub2 = new Buffer(class47.method549("seq.dat", null));
            AnimationSequence.anInt507 = class44_sub3_sub2.readUnsignedShort();
            if (AnimationSequence.cache == null) {
                AnimationSequence.cache = new AnimationSequence[AnimationSequence.anInt507];
            }
            for (int i = 0; i < AnimationSequence.anInt507; i++) {
                if (AnimationSequence.cache[i] == null) {
                    AnimationSequence.cache[i] = new AnimationSequence();
                }
                AnimationSequence.cache[i].method255(false, class44_sub3_sub2);
            }
            if (!flag) {
                AnimationSequence.aBoolean506 = !AnimationSequence.aBoolean506;
            }
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("90750, " + flag + ", " + class47 + ", " + runtimeexception.toString());
            throw new RuntimeException();
        }
    }

    public int method254(int i, int j) {
        try {
            if (j != 24425) {
                for (int k = 1; k > 0; k++) {
                }
            }
            int l = anIntArray512[i];
            if (l == 0) {
                Animation class11 = Animation.method210(anIntArray510[i], aByte505);
                if (class11 != null) {
                    l = anIntArray512[i] = class11.anInt265;
                }
            }
            if (l == 0) {
                l = 1;
            }
            return l;
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("17518, " + i + ", " + j + ", " + runtimeexception.toString());
        }
        throw new RuntimeException();
    }

    private void method255(boolean flag, Buffer class44_sub3_sub2) {
        try {
            if (flag) {
                throw new NullPointerException();
            }
            do {
                int i = class44_sub3_sub2.readUnsignedByte();
                if (i == 0) {
                    break;
                }
                if (i == 1) {
                    anInt509 = class44_sub3_sub2.readUnsignedByte();
                    anIntArray510 = new int[anInt509];
                    anIntArray511 = new int[anInt509];
                    anIntArray512 = new int[anInt509];
                    for (int j = 0; j < anInt509; j++) {
                        anIntArray510[j] = class44_sub3_sub2.readUnsignedShort();
                        anIntArray511[j] = class44_sub3_sub2.readUnsignedShort();
                        if (anIntArray511[j] == 65535) {
                            anIntArray511[j] = -1;
                        }
                        anIntArray512[j] = class44_sub3_sub2.readUnsignedShort();
                    }
                } else if (i == 2) {
                    anInt513 = class44_sub3_sub2.readUnsignedShort();
                } else if (i == 3) {
                    int k = class44_sub3_sub2.readUnsignedByte();
                    anIntArray514 = new int[k + 1];
                    for (int l = 0; l < k; l++) {
                        anIntArray514[l] = class44_sub3_sub2.readUnsignedByte();
                    }
                    anIntArray514[k] = 0x98967f;
                } else if (i == 4) {
                    aBoolean515 = true;
                } else if (i == 5) {
                    anInt516 = class44_sub3_sub2.readUnsignedByte();
                } else if (i == 6) {
                    anInt517 = class44_sub3_sub2.readUnsignedShort();
                } else if (i == 7) {
                    anInt518 = class44_sub3_sub2.readUnsignedShort();
                } else if (i == 8) {
                    anInt519 = class44_sub3_sub2.readUnsignedByte();
                } else if (i == 9) {
                    anInt520 = class44_sub3_sub2.readUnsignedByte();
                } else if (i == 10) {
                    anInt521 = class44_sub3_sub2.readUnsignedByte();
                } else if (i == 11) {
                    anInt522 = class44_sub3_sub2.readUnsignedByte();
                } else if (i == 12) {
                    int anInt523 = class44_sub3_sub2.readUnsignedInt();
                } else {
                    System.out.println("Error unrecognised seq config code: " + i);
                }
            } while (true);
            if (anInt509 == 0) {
                anInt509 = 1;
                anIntArray510 = new int[1];
                anIntArray510[0] = -1;
                anIntArray511 = new int[1];
                anIntArray511[0] = -1;
                anIntArray512 = new int[1];
                anIntArray512[0] = -1;
            }
            if (anInt520 == -1) {
                if (anIntArray514 != null) {
                    anInt520 = 2;
                } else {
                    anInt520 = 0;
                }
            }
            if (anInt521 == -1) {
                if (anIntArray514 != null) {
                    anInt521 = 2;
                } else {
                    anInt521 = 0;
                }
            }
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("13368, " + flag + ", " + class44_sub3_sub2 + ", " + runtimeexception.toString());
            throw new RuntimeException();
        }
    }

}
