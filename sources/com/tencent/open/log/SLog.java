package com.tencent.open.log;

import android.os.Environment;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.connect.common.Constants;
import com.tencent.open.log.C7102d;
import com.tencent.open.utils.C7119g;
import java.io.File;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class SLog implements TraceLevel {
    public static final String TAG = "openSDK_LOG";
    private static boolean c;
    public static SLog instance;
    protected C7099a a;
    private Tracer b;

    private SLog() {
    }

    private void d() {
        this.a = new C7099a(new C7100b(a(), C7101c.m, C7101c.g, C7101c.h, C7101c.c, C7101c.i, 10, C7101c.e, C7101c.n));
    }

    public static final void e(String str, String str2) {
        getInstance().a(16, str, str2, null);
    }

    public static void flushLogs() {
        getInstance().c();
    }

    public static SLog getInstance() {
        if (instance == null) {
            synchronized (SLog.class) {
                if (instance == null) {
                    SLog sLog = new SLog();
                    instance = sLog;
                    sLog.d();
                    c = true;
                }
            }
        }
        return instance;
    }

    public static final void i(String str, String str2) {
        getInstance().a(4, str, str2, null);
    }

    public static void release() {
        synchronized (SLog.class) {
            getInstance().b();
            if (instance != null) {
                instance = null;
            }
        }
    }

    public static final void u(String str, String str2) {
        getInstance().a(32, str, str2, null);
    }

    public static final void v(String str, String str2) {
        getInstance().a(1, str, str2, null);
    }

    public static final void w(String str, String str2) {
        getInstance().a(8, str, str2, null);
    }

    protected void a(int i, String str, String str2, Throwable th) {
        if (c) {
            String b = C7119g.b();
            if (!TextUtils.isEmpty(b)) {
                String str3 = b + " SDK_VERSION:" + Constants.SDK_VERSION;
                if (this.a == null) {
                    return;
                }
                C7107e.a.a(32, Thread.currentThread(), System.currentTimeMillis(), TAG, str3, null);
                this.a.a(32, Thread.currentThread(), System.currentTimeMillis(), TAG, str3, null);
                c = false;
            }
        }
        C7107e.a.a(i, Thread.currentThread(), System.currentTimeMillis(), str, str2, th);
        if (C7102d.C7103a.a(C7101c.b, i)) {
            C7099a c7099a = this.a;
            if (c7099a == null) {
                return;
            }
            c7099a.a(i, Thread.currentThread(), System.currentTimeMillis(), str, str2, th);
        }
        Tracer tracer = this.b;
        if (tracer != null) {
            try {
                tracer.a(i, Thread.currentThread(), System.currentTimeMillis(), str, a(str2), th);
            } catch (Exception e) {
                Log.e(str, "Exception", e);
            }
        }
    }

    protected void b() {
        C7099a c7099a = this.a;
        if (c7099a != null) {
            c7099a.a();
            this.a.b();
            this.a = null;
        }
    }

    protected void c() {
        C7099a c7099a = this.a;
        if (c7099a != null) {
            c7099a.a();
        }
    }

    public void setCustomLogger(Tracer tracer) {
        this.b = tracer;
    }

    public static final void e(String str, String str2, Throwable th) {
        getInstance().a(16, str, str2, th);
    }

    public static final void i(String str, String str2, Throwable th) {
        getInstance().a(4, str, str2, th);
    }

    public static final void u(String str, String str2, Throwable th) {
        getInstance().a(32, str, str2, th);
    }

    public static final void v(String str, String str2, Throwable th) {
        getInstance().a(1, str, str2, th);
    }

    public static final void w(String str, String str2, Throwable th) {
        getInstance().a(8, str, str2, th);
    }

    public static final void d(String str, String str2) {
        getInstance().a(2, str, str2, null);
    }

    public static final void d(String str, String str2, Throwable th) {
        getInstance().a(2, str, str2, th);
    }

    private String a(String str) {
        return TextUtils.isEmpty(str) ? "" : C7102d.a(str) ? "xxxxxx" : str;
    }

    protected static File a() {
        String str = C7101c.d;
        try {
            C7102d.C7105c b = C7102d.C7104b.b();
            if (b != null && b.c() > C7101c.f) {
                return new File(Environment.getExternalStorageDirectory(), str);
            }
            return new File(C7119g.c(), str);
        } catch (Throwable th) {
            e(TAG, "getLogFilePath:", th);
            return null;
        }
    }
}
