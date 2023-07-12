package com.alibaba.wireless.security.aopsdk.h.c;

import android.content.Context;
import android.util.Log;
import com.alibaba.wireless.security.aopsdk.config.ConfigManager;
import com.youku.live.livesdk.wkit.component.Constants;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.util.Map;
import java.util.UUID;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;

/* compiled from: UserTrackMethodBridge.java */
/* loaded from: classes.dex */
public class a {
    private static final String A = "msg";
    private static final String B = "rsv1";
    private static final String C = "rsv2";
    private static final String D = "rsv3";
    private static final String E = "rsv4";
    private static Context a = null;
    private static String b = null;
    private static int c = 0;
    private static int d = 0;
    private static int e = 0;
    private static volatile int f = 0;
    private static Class g = null;
    private static Class h = null;
    private static Class i = null;
    private static Constructor j = null;
    private static Method k = null;
    private static Method l = null;
    private static Method m = null;
    private static Method n = null;
    private static Method o = null;
    private static final String q = "UTMethodJniBridge";
    private static final String r = "Page_SecAOP";
    private static final int s = 19999;
    private static final String t = "plugin";
    private static final String u = "pid";
    private static final String v = "ui";
    private static final String w = "sid";
    private static final String x = "uuid";
    private static final String y = "tid";
    private static final String z = "time";
    private static final boolean p = ConfigManager.DEBUG;
    private static final char[] F = "0123456789abcdef".toCharArray();

    public static void a(Context context) {
        if (context != null) {
            a = context;
        }
    }

    private static String b() {
        try {
            String uuid = UUID.randomUUID().toString();
            return a(MessageDigest.getInstance(MessageDigestAlgorithms.SHA_1).digest((uuid + String.valueOf(System.nanoTime())).getBytes("UTF-8")));
        } catch (Exception e2) {
            return "";
        }
    }

    public static int c() {
        if (f == 0) {
            synchronized (a.class) {
                if (f == 0) {
                    try {
                        g = Class.forName("com.ut.mini.internal.UTOriginalCustomHitBuilder");
                        h = Class.forName("com.ut.mini.UTAnalytics");
                        i = Class.forName("com.ut.mini.UTTracker");
                        try {
                            j = g.getConstructor(String.class, Integer.TYPE, String.class, String.class, String.class, Map.class);
                            k = g.getMethod("build", new Class[0]);
                            l = h.getMethod("getInstance", new Class[0]);
                            m = h.getMethod("getTracker", String.class);
                            o = g.getMethod("setProperties", Map.class);
                            n = i.getMethod("send", Map.class);
                            if (p) {
                                Log.i(q, "UserTrack is Aviable");
                            }
                            e = 1;
                        } catch (NoSuchMethodException e2) {
                            if (p) {
                                Log.e(q, e2.toString(), e2);
                            }
                        }
                    } catch (ClassNotFoundException e3) {
                        if (p) {
                            Log.e(q, e3.toString(), e3);
                        }
                    }
                    f = 1;
                }
            }
        }
        return e;
    }

    public static int a(String str, String str2, Map<String, String> map) {
        if (c() == 0) {
            if (p) {
                Log.i(q, "UserTracke is not avaiable.");
            }
        } else if (str != null && str.length() != 0) {
            if (str2 == null) {
                str2 = "";
            }
            try {
                Object newInstance = j.newInstance(r, 19999, str, str2, "", map);
                if (newInstance == null) {
                    if (p) {
                        Log.i(q, "Fail to create builder obj.");
                    }
                } else {
                    Map map2 = (Map) k.invoke(newInstance, new Object[0]);
                    if (map2 != null && map2.size() != 0) {
                        Object invoke = l.invoke(h, new Object[0]);
                        if (invoke == null) {
                            if (p) {
                                Log.i(q, "Fail to create call getInstance.");
                            }
                        } else {
                            Object invoke2 = m.invoke(invoke, "SecAOP");
                            if (invoke2 == null) {
                                if (p) {
                                    Log.i(q, "Fail to create call getDefaultTracker.");
                                }
                            } else {
                                n.invoke(invoke2, map2);
                            }
                        }
                    } else if (p) {
                        Log.i(q, "Fail to create call build method.");
                    }
                }
            } catch (Exception e2) {
                if (p) {
                    Log.e(q, e2.toString(), e2);
                }
            }
        } else if (p) {
            Log.i(q, "Invalid method name.");
        }
        return 0;
    }

    public static String a(int i2, int i3) {
        int i4 = 0;
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        if (stackTrace == null || stackTrace.length <= 0 || i2 <= 0 || i3 <= 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int i5 = 0;
        while (true) {
            int i6 = i4;
            if (i5 >= stackTrace.length || i6 >= i3 || sb.length() >= i2) {
                break;
            }
            if (i5 <= 1) {
                i4 = i6;
            } else {
                i4 = i6 + 1;
                StackTraceElement stackTraceElement = stackTrace[i5];
                sb.append(stackTraceElement.getClassName() + "." + stackTraceElement.getMethodName());
                if (i5 < stackTrace.length - 1) {
                    sb.append(Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX);
                }
            }
            i5++;
        }
        return sb.toString();
    }

    private static String a(String str) {
        if (str == null || str.length() == 0) {
            return "";
        }
        try {
            return URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
            return "";
        }
    }

    private static synchronized String a() {
        String substring;
        synchronized (a.class) {
            String str = b;
            if (str == null || str.length() == 0) {
                b = b();
            }
            String str2 = b;
            substring = str2.substring(0, str2.length() / 8);
        }
        return substring;
    }

    public static String a(byte[] bArr) {
        char[] cArr = new char[bArr.length * 2];
        for (int i2 = 0; i2 < bArr.length; i2++) {
            int i3 = bArr[i2] & 255;
            int i4 = i2 * 2;
            char[] cArr2 = F;
            cArr[i4] = cArr2[i3 >>> 4];
            cArr[i4 + 1] = cArr2[i3 & 15];
        }
        return new String(cArr);
    }
}
