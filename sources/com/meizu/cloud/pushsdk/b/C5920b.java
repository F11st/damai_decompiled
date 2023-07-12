package com.meizu.cloud.pushsdk.b;

import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import android.util.Log;
import androidx.exifinterface.media.ExifInterface;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.apache.commons.lang3.StringUtils;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* renamed from: com.meizu.cloud.pushsdk.b.b */
/* loaded from: classes10.dex */
public class C5920b implements InterfaceC5938f {
    private ThreadPoolExecutor j;
    private long d = 60;
    private int e = 10;
    private boolean i = false;
    private final SimpleDateFormat a = new SimpleDateFormat("MM-dd HH:mm:ss");
    private final List<C5921a> b = Collections.synchronizedList(new ArrayList());
    private final Handler c = new Handler(Looper.getMainLooper());
    private String g = Environment.getExternalStorageDirectory().getAbsolutePath() + "/Android/data/pushSdk/defaultLog";
    private final C5936e f = new C5936e();
    private final String h = String.valueOf(Process.myPid());

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.meizu.cloud.pushsdk.b.b$a */
    /* loaded from: classes10.dex */
    public class C5921a {
        final String a;
        final String b;
        final String c;

        public C5921a(String str, String str2, String str3) {
            this.a = C5920b.this.a.format(new Date()) + " " + C5920b.this.h + "-" + Thread.currentThread().getId() + " " + str + "/";
            this.b = str2;
            this.c = str3;
        }
    }

    public C5920b() {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 1, 30L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new C5942j().a("log-pool-%d").a());
        this.j = threadPoolExecutor;
        threadPoolExecutor.allowCoreThreadTimeOut(true);
    }

    private void a(C5921a c5921a) {
        try {
            this.b.add(c5921a);
        } catch (Exception e) {
            Log.e("Logger", "add logInfo error " + e.getMessage());
        }
    }

    private void b() {
        if (this.b.size() == 0) {
            this.c.postDelayed(new Runnable() { // from class: com.meizu.cloud.pushsdk.b.b.1
                @Override // java.lang.Runnable
                public void run() {
                    C5920b.this.a(true);
                }
            }, this.d * 1000);
        }
    }

    private void c() {
        if (this.b.size() == this.e) {
            a(true);
        }
    }

    @Override // com.meizu.cloud.pushsdk.b.InterfaceC5938f
    public void a(String str) {
        this.g = str;
    }

    @Override // com.meizu.cloud.pushsdk.b.InterfaceC5938f
    public void a(String str, String str2) {
        if (this.i) {
            Log.d(str, str2);
        }
        synchronized (this.b) {
            b();
            a(new C5921a("D", str, str2));
            c();
        }
    }

    @Override // com.meizu.cloud.pushsdk.b.InterfaceC5938f
    public void a(String str, String str2, Throwable th) {
        if (this.i) {
            Log.e(str, str2, th);
        }
        synchronized (this.b) {
            b();
            a(new C5921a(ExifInterface.LONGITUDE_EAST, str, str2 + StringUtils.LF + Log.getStackTraceString(th)));
            c();
        }
    }

    @Override // com.meizu.cloud.pushsdk.b.InterfaceC5938f
    public void a(boolean z) {
        ThreadPoolExecutor threadPoolExecutor;
        Runnable runnable = new Runnable() { // from class: com.meizu.cloud.pushsdk.b.b.2
            @Override // java.lang.Runnable
            public void run() {
                ArrayList<C5921a> arrayList;
                C5920b c5920b;
                synchronized (C5920b.this.b) {
                    C5920b.this.c.removeCallbacksAndMessages(null);
                    arrayList = new ArrayList(C5920b.this.b);
                    C5920b.this.b.clear();
                }
                try {
                    try {
                        C5920b.this.f.a(C5920b.this.g);
                        for (C5921a c5921a : arrayList) {
                            C5920b.this.f.a(c5921a.a, c5921a.b, c5921a.c);
                        }
                        c5920b = C5920b.this;
                    } catch (Exception unused) {
                        c5920b = C5920b.this;
                    } catch (Throwable th) {
                        try {
                            C5920b.this.f.a();
                        } catch (Exception unused2) {
                        }
                        throw th;
                    }
                    c5920b.f.a();
                } catch (Exception unused3) {
                }
            }
        };
        if (!z || (threadPoolExecutor = this.j) == null) {
            runnable.run();
        } else {
            threadPoolExecutor.execute(runnable);
        }
    }

    @Override // com.meizu.cloud.pushsdk.b.InterfaceC5938f
    public boolean a() {
        return this.i;
    }

    @Override // com.meizu.cloud.pushsdk.b.InterfaceC5938f
    public void b(String str, String str2) {
        if (this.i) {
            Log.i(str, str2);
        }
        synchronized (this.b) {
            b();
            a(new C5921a("I", str, str2));
            c();
        }
    }

    @Override // com.meizu.cloud.pushsdk.b.InterfaceC5938f
    public void b(boolean z) {
        this.i = z;
    }

    @Override // com.meizu.cloud.pushsdk.b.InterfaceC5938f
    public void c(String str, String str2) {
        if (this.i) {
            Log.w(str, str2);
        }
        synchronized (this.b) {
            b();
            a(new C5921a(ExifInterface.LONGITUDE_WEST, str, str2));
            c();
        }
    }

    @Override // com.meizu.cloud.pushsdk.b.InterfaceC5938f
    public void d(String str, String str2) {
        if (this.i) {
            Log.e(str, str2);
        }
        synchronized (this.b) {
            b();
            a(new C5921a(ExifInterface.LONGITUDE_EAST, str, str2));
            c();
        }
    }
}
