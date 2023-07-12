package com.ali.ha.fulltrace.dump;

import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import com.ali.ha.fulltrace.IReportEvent;
import com.ali.ha.fulltrace.IReportRawByteEvent;
import java.io.File;
import java.util.HashMap;
import tb.ih0;
import tb.jn1;
import tb.kx1;
import tb.lb1;

/* compiled from: Taobao */
/* loaded from: classes17.dex */
public class DumpManager {
    public static final String LOG_PATH = "log";
    public static final String TAG = "FULLTRACE";
    private static volatile byte b = -1;
    public static long c;
    private volatile boolean a;

    /* compiled from: Taobao */
    /* renamed from: com.ali.ha.fulltrace.dump.DumpManager$1  reason: invalid class name */
    /* loaded from: classes17.dex */
    class AnonymousClass1 implements Runnable {
        final /* synthetic */ IReportEvent val$event;

        AnonymousClass1(IReportEvent iReportEvent) {
            this.val$event = iReportEvent;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                IReportEvent iReportEvent = this.val$event;
                if (iReportEvent instanceof IReportRawByteEvent) {
                    byte[] body = ((IReportRawByteEvent) iReportEvent).getBody();
                    long time = this.val$event.getTime();
                    short type = this.val$event.getType();
                    lb1.a(DumpManager.TAG, "send rawBody type: 0x" + Integer.toHexString(type) + ", time:" + time + ", Body:" + body);
                    if (body != null) {
                        DumpManager.this.appendBytesBody(type, time, body);
                    }
                } else if (iReportEvent instanceof IReportEvent) {
                    lb1.a(DumpManager.TAG, "send nobody type: 0x" + Integer.toHexString(this.val$event.getType()));
                    DumpManager.this.appendNoBody(this.val$event.getType(), this.val$event.getTime());
                }
            } catch (Throwable th) {
                lb1.b("native method not found.\n" + th, new Object[0]);
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes17.dex */
    private static final class a {
        private static final DumpManager a = new DumpManager(null);
    }

    static {
        try {
            System.loadLibrary("fulltrace");
            b = (byte) 0;
        } catch (Throwable th) {
            th.printStackTrace();
            b = (byte) 1;
        }
    }

    /* synthetic */ DumpManager(AnonymousClass1 anonymousClass1) {
        this();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public native void appendBytesBody(short s, long j, byte[] bArr);

    /* JADX INFO: Access modifiers changed from: private */
    public native void appendNoBody(short s, long j);

    public static final DumpManager c() {
        return a.a;
    }

    public static String d(Context context) {
        String replace = ih0.p.replace(jn1.CONDITION_IF_MIDDLE, '.');
        if (TextUtils.isEmpty(replace)) {
            return "";
        }
        return com.ali.ha.fulltrace.a.c(context, LOG_PATH + File.separator + replace);
    }

    public static String e(Context context) {
        String replace = ih0.p.replace(jn1.CONDITION_IF_MIDDLE, '.');
        if (TextUtils.isEmpty(replace)) {
            return "";
        }
        return com.ali.ha.fulltrace.a.b(context, LOG_PATH + File.separator + replace);
    }

    private native boolean init(String str, String str2, HashMap<String, String> hashMap, HashMap<String, String> hashMap2, HashMap<String, String> hashMap3);

    private native void trim(String str, String str2);

    public void f(Application application, HashMap<String, String> hashMap, HashMap<String, String> hashMap2) {
        if (this.a) {
            return;
        }
        this.a = true;
        if (b != 0) {
            lb1.b(TAG, "initing, but so was loaded failed!");
            return;
        }
        HashMap<String, String> a2 = kx1.a();
        String e = e(application);
        String d = d(application);
        c = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        sb.append(d);
        String str = File.separator;
        sb.append(str);
        sb.append(c);
        String sb2 = sb.toString();
        if (init(sb2, e + str + c, hashMap, hashMap2, a2)) {
            return;
        }
        b = (byte) 2;
    }

    public void g(String str, String str2) {
        if (b != 0) {
            lb1.b(TAG, "Triming, but so was loaded failed!");
        } else if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
        } else {
            trim(str, str2);
        }
    }

    private DumpManager() {
        this.a = false;
    }
}
