package com.runescape.util;

import com.runescape.net.Buffer;

public class ChatEncoder {

    public static int anInt806 = 991;
    public static int anInt807;
    public static int anInt808;
    public static char aCharArray809[] = new char[100];
    public static Buffer aClass44_Sub3_Sub2_810 = new Buffer(new byte[100], 15787);
    public static char aCharArray811[] = {' ', 'e', 't', 'a', 'o', 'i', 'h', 'n', 's', 'r', 'd', 'l', 'u', 'm', 'w',
            'c', 'y', 'f', 'g', 'p', 'b', 'v', 'k', 'x', 'j', 'q', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8',
            '9', ' ', '!', '?', '.', ',', ':', ';', '(', ')', '-', '&', '*', '\\', '\'', '@', '#', '+', '=', '\243',
            '$', '%', '"', '[', ']'};

    public static String method556(byte byte0, Buffer class44_sub3_sub2, int i) {
        try {
            int j = 0;
            int k = -1;
            for (int l = 0; l < i; l++) {
                int i1 = class44_sub3_sub2.readUnsignedByte();
                int j1 = i1 >> 4 & 0xf;
                if (k == -1) {
                    if (j1 < 13) {
                        ChatEncoder.aCharArray809[j++] = ChatEncoder.aCharArray811[j1];
                    } else {
                        k = j1;
                    }
                } else {
                    ChatEncoder.aCharArray809[j++] = ChatEncoder.aCharArray811[((k << 4) + j1) - 195];
                    k = -1;
                }
                j1 = i1 & 0xf;
                if (k == -1) {
                    if (j1 < 13) {
                        ChatEncoder.aCharArray809[j++] = ChatEncoder.aCharArray811[j1];
                    } else {
                        k = j1;
                    }
                } else {
                    ChatEncoder.aCharArray809[j++] = ChatEncoder.aCharArray811[((k << 4) + j1) - 195];
                    k = -1;
                }
            }
            boolean flag = true;
            if (byte0 != -94) {
                ChatEncoder.anInt808 = -316;
            }
            for (int k1 = 0; k1 < j; k1++) {
                char c = ChatEncoder.aCharArray809[k1];
                if (flag && c >= 'a' && c <= 'z') {
                    ChatEncoder.aCharArray809[k1] += '\uFFE0';
                    flag = false;
                }
                if (c == '.' || c == '!' || c == '?') {
                    flag = true;
                }
            }
            return new String(ChatEncoder.aCharArray809, 0, j);
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("44303, " + byte0 + ", " + class44_sub3_sub2 + ", " + i + ", "
                    + runtimeexception.toString());
        }
        throw new RuntimeException();
    }

    public static void method557(String s, Buffer class44_sub3_sub2, int i) {
        try {
            if (i <= 0) {
                return;
            }
            if (s.length() > 80) {
                s = s.substring(0, 80);
            }
            s = s.toLowerCase();
            int j = -1;
            for (int k = 0; k < s.length(); k++) {
                char c = s.charAt(k);
                int l = 0;
                for (int i1 = 0; i1 < ChatEncoder.aCharArray811.length; i1++) {
                    if (c != ChatEncoder.aCharArray811[i1]) {
                        continue;
                    }
                    l = i1;
                    break;
                }
                if (l > 12) {
                    l += 195;
                }
                if (j == -1) {
                    if (l < 13) {
                        j = l;
                    } else {
                        class44_sub3_sub2.writeByte(l);
                    }
                } else if (l < 13) {
                    class44_sub3_sub2.writeByte((j << 4) + l);
                    j = -1;
                } else {
                    class44_sub3_sub2.writeByte((j << 4) + (l >> 4));
                    j = l & 0xf;
                }
            }
            if (j != -1) {
                class44_sub3_sub2.writeByte(j << 4);
                return;
            }
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("17960, " + s + ", " + class44_sub3_sub2 + ", " + i + ", "
                    + runtimeexception.toString());
            throw new RuntimeException();
        }
    }

    public static String method558(String s, int i) {
        try {
            ChatEncoder.aClass44_Sub3_Sub2_810.offset = 0;
            ChatEncoder.method557(s, ChatEncoder.aClass44_Sub3_Sub2_810, 991);
            int j = ChatEncoder.aClass44_Sub3_Sub2_810.offset;
            if (i != 0) {
                ChatEncoder.anInt807 = -64;
            }
            ChatEncoder.aClass44_Sub3_Sub2_810.offset = 0;
            String s1 = ChatEncoder.method556((byte) -94, ChatEncoder.aClass44_Sub3_Sub2_810, j);
            return s1;
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("99118, " + s + ", " + i + ", " + runtimeexception.toString());
        }
        throw new RuntimeException();
    }

}
