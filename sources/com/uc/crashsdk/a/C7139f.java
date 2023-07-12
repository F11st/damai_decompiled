package com.uc.crashsdk.a;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import java.util.HashMap;

/* compiled from: Taobao */
/* renamed from: com.uc.crashsdk.a.f */
/* loaded from: classes11.dex */
public class C7139f {
    static final /* synthetic */ boolean a = true;
    private static volatile HandlerThread b;
    private static volatile HandlerThread c;
    private static volatile HandlerThread d;
    private static Handler e;
    private static Handler f;
    private static Handler g;
    private static Handler h;
    private static final HashMap<Object, Object[]> i = new HashMap<>();

    public static Handler a(int i2) {
        if (i2 == 0) {
            if (b == null) {
                a();
            }
            return e;
        } else if (i2 == 1) {
            if (c == null) {
                b();
            }
            return f;
        } else if (i2 == 2) {
            if (g == null) {
                g = new Handler(Looper.getMainLooper());
            }
            return g;
        } else if (i2 == 3) {
            if (h == null) {
                c();
            }
            return h;
        } else {
            throw new RuntimeException("unknown thread type: " + i2);
        }
    }

    public static boolean b(Runnable runnable) {
        Object[] objArr;
        if (runnable == null) {
            return false;
        }
        HashMap<Object, Object[]> hashMap = i;
        synchronized (hashMap) {
            objArr = hashMap.get(runnable);
        }
        return objArr != null;
    }

    private static synchronized void c() {
        synchronized (C7139f.class) {
            if (d == null) {
                HandlerThread handlerThread = new HandlerThread("CrashSDKAnrHandler", 0);
                d = handlerThread;
                handlerThread.start();
                h = new Handler(d.getLooper());
            }
        }
    }

    private static synchronized void b() {
        synchronized (C7139f.class) {
            if (c == null) {
                HandlerThread handlerThread = new HandlerThread("CrashSDKNormalHandler", 0);
                c = handlerThread;
                handlerThread.start();
                f = new Handler(c.getLooper());
            }
        }
    }

    public static boolean a(int i2, Runnable runnable, long j) {
        Handler a2;
        if (runnable == null || (a2 = a(i2)) == null) {
            return false;
        }
        RunnableC7138e runnableC7138e = new RunnableC7138e(10, new Object[]{runnable});
        HashMap<Object, Object[]> hashMap = i;
        synchronized (hashMap) {
            hashMap.put(runnable, new Object[]{runnableC7138e, Integer.valueOf(i2)});
        }
        return a2.postDelayed(runnableC7138e, j);
    }

    public static void a(int i2, Object[] objArr) {
        if (i2 != 10) {
            if (!a) {
                throw new AssertionError();
            }
        } else if (!a && objArr == null) {
            throw new AssertionError();
        } else {
            Runnable runnable = (Runnable) objArr[0];
            HashMap<Object, Object[]> hashMap = i;
            synchronized (hashMap) {
                if (hashMap.get(runnable) != null) {
                    hashMap.remove(runnable);
                }
            }
            runnable.run();
        }
    }

    public static boolean a(int i2, Runnable runnable) {
        return a(i2, runnable, 0L);
    }

    public static void a(Runnable runnable) {
        Object[] objArr;
        if (runnable == null) {
            return;
        }
        HashMap<Object, Object[]> hashMap = i;
        synchronized (hashMap) {
            objArr = hashMap.get(runnable);
        }
        if (objArr == null) {
            return;
        }
        int intValue = ((Integer) objArr[1]).intValue();
        Handler handler = null;
        if (intValue == 0) {
            handler = e;
        } else if (intValue == 1) {
            handler = f;
        } else if (intValue == 2) {
            handler = g;
        }
        if (handler != null) {
            handler.removeCallbacks((Runnable) objArr[0]);
        }
        synchronized (hashMap) {
            if (hashMap.get(runnable) != null) {
                hashMap.remove(runnable);
            }
        }
    }

    private static synchronized void a() {
        synchronized (C7139f.class) {
            if (b == null) {
                HandlerThread handlerThread = new HandlerThread("CrashSDKBkgdHandler", 10);
                b = handlerThread;
                handlerThread.start();
                e = new Handler(b.getLooper());
            }
        }
    }
}
