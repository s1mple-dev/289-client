package com.runescape.util;

import java.applet.Applet;
import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.URL;

public class SignLink implements Runnable {

    public static int clientversion = 289;
    public static int uid;
    public static int storeId = 32;
    public static RandomAccessFile cache_dat = null;
    public static final RandomAccessFile[] cache_idx = new RandomAccessFile[5];
    public static boolean sunjava;
    public static final Applet mainapp = null;
    private static boolean active;
    private static int threadliveid;
    private static InetAddress socketip;
    private static int socketreq;
    private static Socket socket = null;
    private static int threadreqpri = 1;
    private static Runnable threadreq = null;
    private static String dnsreq = null;
    public static String dns = null;
    private static String urlreq = null;
    private static DataInputStream urlstream = null;
    private static int savelen;
    private static String savereq = null;
    private static byte[] savebuf = null;
    private static boolean midiplay;
    private static int midipos;
    public static String midi = null;
    public static int midivol;
    public static int midifade;
    private static boolean waveplay;
    private static int wavepos;
    private static String wave = null;
    public static int wavevol;
    public static boolean reporterror = true;
    public static String errorname = "";

    private SignLink() {
    }

    public static void initiate(InetAddress inetaddress) {
        SignLink.threadliveid = (int) (Math.random() * 99999999D);
        if (SignLink.active) {
            try {
                Thread.sleep(500L);
            } catch (Exception _ex) {
            }
            SignLink.active = false;
        }
        SignLink.socketreq = 0;
        SignLink.threadreq = null;
        SignLink.dnsreq = null;
        SignLink.savereq = null;
        SignLink.urlreq = null;
        SignLink.socketip = inetaddress;
        Thread thread = new Thread(new SignLink());
        thread.setDaemon(true);
        thread.start();
        while (!SignLink.active) {
            try {
                Thread.sleep(50L);
            } catch (Exception _ex) {
            }
        }
    }

    private static String findcachedir() {
        String[] var0 = new String[]{"c:/windows/", "c:/winnt/", "d:/windows/", "d:/winnt/", "e:/windows/", "e:/winnt/", "f:/windows/", "f:/winnt/", "c:/", "~/", "/tmp/", ""};
        String var1 = ".file_store_32";

        for (int var2 = 0; var2 < var0.length; ++var2) {
            try {
                String var3 = var0[var2];
                File var4;
                if (var3.length() > 0) {
                    var4 = new File(var3);
                    if (!var4.exists()) {
                        continue;
                    }
                }

                var4 = new File(var3 + var1);
                if (var4.exists() || var4.mkdir()) {
                    return var3 + var1 + "/";
                }
            } catch (Exception var5) {
            }
        }

        return null;
    }

    private static int getuid(String s) {
        try {
            File file = new File(s + "uid.dat");
            if (!file.exists() || file.length() < 4L) {
                DataOutputStream dataoutputstream = new DataOutputStream(new FileOutputStream(s + "uid.dat"));
                dataoutputstream.writeInt((int) (Math.random() * 99999999D));
                dataoutputstream.close();
            }
        } catch (Exception _ex) {
        }
        try {
            DataInputStream datainputstream = new DataInputStream(new FileInputStream(s + "uid.dat"));
            int i = datainputstream.readInt();
            datainputstream.close();
            return i + 1;
        } catch (Exception _ex) {
            return 0;
        }
    }

    public static synchronized Socket opensocket(int i) throws IOException {
        for (SignLink.socketreq = i; SignLink.socketreq != 0; ) {
            try {
                Thread.sleep(50L);
            } catch (Exception _ex) {
            }
        }
        if (SignLink.socket == null) {
            throw new IOException("could not open socket");
        } else {
            return SignLink.socket;
        }
    }

    public static synchronized DataInputStream openurl(String s) throws IOException {
        for (SignLink.urlreq = s; SignLink.urlreq != null; ) {
            try {
                Thread.sleep(50L);
            } catch (Exception _ex) {
            }
        }
        if (SignLink.urlstream == null) {
            throw new IOException("could not open: " + s);
        } else {
            return SignLink.urlstream;
        }
    }

    public static synchronized void dnslookup(String s) {
        SignLink.dns = s;
        SignLink.dnsreq = s;
    }

    public static synchronized void startthread(Runnable runnable, int i) {
        SignLink.threadreqpri = i;
        SignLink.threadreq = runnable;
    }

    public static synchronized boolean wavesave(byte[] abyte0, int i) {
        if (i > 0x1e8480) {
            return false;
        }
        if (SignLink.savereq != null) {
            return false;
        } else {
            SignLink.wavepos = (SignLink.wavepos + 1) % 5;
            SignLink.savelen = i;
            SignLink.savebuf = abyte0;
            SignLink.waveplay = true;
            SignLink.savereq = "sound" + SignLink.wavepos + ".wav";
            return true;
        }
    }

    public static synchronized boolean wavereplay() {
        if (SignLink.savereq != null) {
            return false;
        } else {
            SignLink.savebuf = null;
            SignLink.waveplay = true;
            SignLink.savereq = "sound" + SignLink.wavepos + ".wav";
            return true;
        }
    }

    public static synchronized void midisave(byte[] abyte0, int i) {
        if (i > 0x1e8480) {
            return;
        }
        if (SignLink.savereq != null) {
        } else {
            SignLink.midipos = (SignLink.midipos + 1) % 5;
            SignLink.savelen = i;
            SignLink.savebuf = abyte0;
            SignLink.midiplay = true;
            SignLink.savereq = "jingle" + SignLink.midipos + ".mid";
        }
    }

    public static void reporterror(String s) {
        if (!SignLink.reporterror) {
            return;
        }
        if (!SignLink.active) {
            return;
        }
        System.out.println("Error: " + s);
        try {
            s = s.replace(':', '_');
            s = s.replace('@', '_');
            s = s.replace('&', '_');
            s = s.replace('#', '_');
            DataInputStream datainputstream = SignLink.openurl("reporterror" + 289 + ".cgi?error=" + SignLink.errorname
                    + " " + s);
            datainputstream.readUTF();
            datainputstream.close();
        } catch (IOException _ex) {
        }
    }

    @Override
    public void run() {
        SignLink.active = true;
        String s = SignLink.findcachedir();
        SignLink.uid = SignLink.getuid(s);
        try {
            File file = new File(s + "main_file_cache.dat");
            if (file.exists() && file.length() > 0x3200000L) {
                file.delete();
            }
            SignLink.cache_dat = new RandomAccessFile(s + "main_file_cache.dat", "rw");
            for (int j = 0; j < 5; j++) {
                SignLink.cache_idx[j] = new RandomAccessFile(s + "main_file_cache.idx" + j, "rw");
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        for (int i = SignLink.threadliveid; SignLink.threadliveid == i; ) {
            if (SignLink.socketreq != 0) {
                try {
                    SignLink.socket = new Socket(SignLink.socketip, SignLink.socketreq);
                } catch (Exception _ex) {
                    SignLink.socket = null;
                }
                SignLink.socketreq = 0;
            } else if (SignLink.threadreq != null) {
                Thread thread = new Thread(SignLink.threadreq);
                thread.setDaemon(true);
                thread.start();
                thread.setPriority(SignLink.threadreqpri);
                SignLink.threadreq = null;
            } else if (SignLink.dnsreq != null) {
                try {
                    SignLink.dns = InetAddress.getByName(SignLink.dnsreq).getHostName();
                } catch (Exception _ex) {
                    SignLink.dns = "unknown";
                }
                SignLink.dnsreq = null;
            } else if (SignLink.savereq != null) {
                if (SignLink.savebuf != null) {
                    try {
                        FileOutputStream fileoutputstream = new FileOutputStream(s + SignLink.savereq);
                        fileoutputstream.write(SignLink.savebuf, 0, SignLink.savelen);
                        fileoutputstream.close();
                    } catch (Exception _ex) {
                    }
                }
                if (SignLink.waveplay) {
                    SignLink.wave = s + SignLink.savereq;
                    SignLink.waveplay = false;
                }
                if (SignLink.midiplay) {
                    SignLink.midi = s + SignLink.savereq;
                    SignLink.midiplay = false;
                }
                SignLink.savereq = null;
            } else if (SignLink.urlreq != null) {
                try {
                    SignLink.urlstream = new DataInputStream(
                            (new URL(SignLink.mainapp.getCodeBase(), SignLink.urlreq)).openStream());
                } catch (Exception _ex) {
                    SignLink.urlstream = null;
                }
                SignLink.urlreq = null;
            }
            try {
                Thread.sleep(50L);
            } catch (Exception _ex) {
            }
        }
    }

}
