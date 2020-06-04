package com.runescape.cache.def;

import com.runescape.cache.Archive;
import com.runescape.net.Buffer;
import com.runescape.util.SignLink;

public class Varp {

    public static boolean aBoolean671 = true;
    public static int anInt672 = 810;
    public static int anInt673;
    public static Varp cache[];
    public static int anInt675;
    public static int anIntArray676[];
    public int anInt670;
    public String aString677;
    public int anInt678;
    public int anInt679;
    public boolean aBoolean680;
    public boolean aBoolean681;
    public int anInt682;
    public boolean aBoolean683;
    public int anInt684;
    public int anInt685;
    public boolean aBoolean686;
    public int anInt687;

    public Varp() {
        anInt670 = -550;
        aBoolean680 = false;
        aBoolean681 = true;
        aBoolean683 = false;
        aBoolean686 = false;
        anInt687 = -1;
    }

    public static void method337(boolean flag, Archive class47) {
        try {
            if (!flag) {
                Varp.aBoolean671 = !Varp.aBoolean671;
            }
            Buffer class44_sub3_sub2 = new Buffer(class47.method549("varp.dat", null), 15787);
            Varp.anInt675 = 0;
            Varp.anInt673 = class44_sub3_sub2.readUnsignedShort();
            if (Varp.cache == null) {
                Varp.cache = new Varp[Varp.anInt673];
            }
            if (Varp.anIntArray676 == null) {
                Varp.anIntArray676 = new int[Varp.anInt673];
            }
            for (int i = 0; i < Varp.anInt673; i++) {
                if (Varp.cache[i] == null) {
                    Varp.cache[i] = new Varp();
                }
                Varp.cache[i].method338(Varp.anInt672, i, class44_sub3_sub2);
            }
            if (class44_sub3_sub2.offset != class44_sub3_sub2.payload.length) {
                System.out.println("varptype load mismatch");
                return;
            }
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("51793, " + flag + ", " + class47 + ", " + runtimeexception.toString());
            throw new RuntimeException();
        }
    }

    public void method338(int i, int j, Buffer class44_sub3_sub2) {
        try {
            if (i <= 0) {
                anInt670 = 68;
            }
            do {
                int k = class44_sub3_sub2.readUnsignedByte();
                if (k == 0) {
                    return;
                }
                if (k == 1) {
                    anInt678 = class44_sub3_sub2.readUnsignedByte();
                } else if (k == 2) {
                    anInt679 = class44_sub3_sub2.readUnsignedByte();
                } else if (k == 3) {
                    aBoolean680 = true;
                    Varp.anIntArray676[Varp.anInt675++] = j;
                } else if (k == 4) {
                    aBoolean681 = false;
                } else if (k == 5) {
                    anInt682 = class44_sub3_sub2.readUnsignedShort();
                } else if (k == 6) {
                    aBoolean683 = true;
                } else if (k == 7) {
                    anInt684 = class44_sub3_sub2.method487();
                } else if (k == 8) {
                    anInt685 = 1;
                    aBoolean686 = true;
                } else if (k == 10) {
                    aString677 = class44_sub3_sub2.method489();
                } else if (k == 11) {
                    aBoolean686 = true;
                } else if (k == 12) {
                    anInt687 = class44_sub3_sub2.method487();
                } else if (k == 13) {
                    anInt685 = 2;
                } else {
                    System.out.println("Error unrecognised config code: " + k);
                }
            } while (true);
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("69668, " + i + ", " + j + ", " + class44_sub3_sub2 + ", "
                    + runtimeexception.toString());
        }
        throw new RuntimeException();
    }

}
