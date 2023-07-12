package com.alipay.sdk.m.p0;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.util.Log;
import tb.gn1;

/* compiled from: Taobao */
/* renamed from: com.alipay.sdk.m.p0.c */
/* loaded from: classes12.dex */
public class C4274c {
    public static String A = null;
    public static volatile C4274c B = null;
    public static volatile C4273b C = null;
    public static final String a = "VMS_IDLG_SDK_Client";
    public static final String b = "content://com.vivo.vms.IdProvider/IdentifierId";
    public static final String c = "persist.sys.identifierid.supported";
    public static final String d = "appid";
    public static final String e = "type";
    public static final String f = "OAID";
    public static final String g = "VAID";
    public static final String h = "AAID";
    public static final int i = 0;
    public static final int j = 1;
    public static final int k = 2;
    public static final int l = 4;
    public static final int m = 11;
    public static final int n = 2000;
    public static Context o;
    public static boolean p;
    public static C4276d q;
    public static C4276d r;
    public static C4276d s;
    public static Object t = new Object();
    public static HandlerThread u;
    public static Handler v;
    public static String w;
    public static String x;
    public static String y;
    public static String z;

    /* compiled from: Taobao */
    /* renamed from: com.alipay.sdk.m.p0.c$a */
    /* loaded from: classes12.dex */
    public static class HandlerC4275a extends Handler {
        public HandlerC4275a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 11) {
                String unused = C4274c.w = C4274c.C.a(message.getData().getInt("type"), message.getData().getString("appid"));
                synchronized (C4274c.t) {
                    C4274c.t.notify();
                }
                return;
            }
            Log.e(C4274c.a, "message type valid");
        }
    }

    public static C4274c a(Context context) {
        if (B == null) {
            synchronized (C4274c.class) {
                o = context.getApplicationContext();
                B = new C4274c();
            }
        }
        if (C == null) {
            synchronized (C4274c.class) {
                o = context.getApplicationContext();
                g();
                C = new C4273b(o);
                f();
            }
        }
        return B;
    }

    public static void f() {
        p = "1".equals(a(c, "0"));
    }

    public static void g() {
        HandlerThread handlerThread = new HandlerThread("SqlWorkThread");
        u = handlerThread;
        handlerThread.start();
        v = new HandlerC4275a(u.getLooper());
    }

    public String b(String str) {
        if (c()) {
            String str2 = y;
            if (str2 != null) {
                return str2;
            }
            a(1, str);
            if (r == null && y != null) {
                a(o, 1, str);
            }
            return y;
        }
        return null;
    }

    public boolean c() {
        return p;
    }

    private void c(int i2, String str) {
        Message obtainMessage = v.obtainMessage();
        obtainMessage.what = 11;
        Bundle bundle = new Bundle();
        bundle.putInt("type", i2);
        if (i2 == 1 || i2 == 2) {
            bundle.putString("appid", str);
        }
        obtainMessage.setData(bundle);
        v.sendMessage(obtainMessage);
    }

    public String b() {
        if (c()) {
            a(4, (String) null);
            return A;
        }
        return null;
    }

    public String a() {
        if (c()) {
            String str = x;
            if (str != null) {
                return str;
            }
            a(0, (String) null);
            if (q == null) {
                a(o, 0, null);
            }
            return x;
        }
        return null;
    }

    public String a(String str) {
        if (c()) {
            String str2 = z;
            if (str2 != null) {
                return str2;
            }
            a(2, str);
            if (s == null && z != null) {
                a(o, 2, str);
            }
            return z;
        }
        return null;
    }

    public void a(int i2, String str) {
        synchronized (t) {
            c(i2, str);
            long uptimeMillis = SystemClock.uptimeMillis();
            try {
                t.wait(2000L);
            } catch (InterruptedException e2) {
                e2.printStackTrace();
            }
            if (SystemClock.uptimeMillis() - uptimeMillis >= 2000) {
                Log.d(a, "query timeout");
            } else if (i2 == 0) {
                x = w;
                w = null;
            } else if (i2 != 1) {
                if (i2 == 2) {
                    String str2 = w;
                    if (str2 != null) {
                        z = str2;
                        w = null;
                    } else {
                        Log.e(a, "get aaid failed");
                    }
                } else if (i2 != 4) {
                }
                A = w;
                w = null;
            } else {
                String str3 = w;
                if (str3 != null) {
                    y = str3;
                    w = null;
                } else {
                    Log.e(a, "get vaid failed");
                }
            }
        }
    }

    public static String a(String str, String str2) {
        try {
            try {
                Class<?> cls = Class.forName("android.os.SystemProperties");
                return (String) cls.getMethod(gn1.TYPE_OPEN_URL_METHOD_GET, String.class, String.class).invoke(cls, str, "unknown");
            } catch (Exception e2) {
                e2.printStackTrace();
                return str2;
            }
        } catch (Throwable unused) {
            return str2;
        }
    }

    public static void a(Context context, int i2, String str) {
        if (i2 == 0) {
            q = new C4276d(B, 0, null);
            context.getContentResolver().registerContentObserver(Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/OAID"), true, q);
        } else if (i2 == 1) {
            r = new C4276d(B, 1, str);
            ContentResolver contentResolver = context.getContentResolver();
            contentResolver.registerContentObserver(Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/VAID_" + str), false, r);
        } else if (i2 != 2) {
        } else {
            s = new C4276d(B, 2, str);
            ContentResolver contentResolver2 = context.getContentResolver();
            contentResolver2.registerContentObserver(Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/AAID_" + str), false, s);
        }
    }
}
