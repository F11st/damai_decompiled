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
/* loaded from: classes10.dex */
public class b implements f {
    private ThreadPoolExecutor j;
    private long d = 60;
    private int e = 10;
    private boolean i = false;
    private final SimpleDateFormat a = new SimpleDateFormat("MM-dd HH:mm:ss");
    private final List<a> b = Collections.synchronizedList(new ArrayList());
    private final Handler c = new Handler(Looper.getMainLooper());
    private String g = Environment.getExternalStorageDirectory().getAbsolutePath() + "/Android/data/pushSdk/defaultLog";
    private final e f = new e();
    private final String h = String.valueOf(Process.myPid());

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public class a {
        final String a;
        final String b;
        final String c;

        public a(String str, String str2, String str3) {
            this.a = b.this.a.format(new Date()) + " " + b.this.h + "-" + Thread.currentThread().getId() + " " + str + "/";
            this.b = str2;
            this.c = str3;
        }
    }

    public b() {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 1, 30L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new j().a("log-pool-%d").a());
        this.j = threadPoolExecutor;
        threadPoolExecutor.allowCoreThreadTimeOut(true);
    }

    private void a(a aVar) {
        try {
            this.b.add(aVar);
        } catch (Exception e) {
            Log.e("Logger", "add logInfo error " + e.getMessage());
        }
    }

    private void b() {
        if (this.b.size() == 0) {
            this.c.postDelayed(new Runnable() { // from class: com.meizu.cloud.pushsdk.b.b.1
                @Override // java.lang.Runnable
                public void run() {
                    b.this.a(true);
                }
            }, this.d * 1000);
        }
    }

    private void c() {
        if (this.b.size() == this.e) {
            a(true);
        }
    }

    @Override // com.meizu.cloud.pushsdk.b.f
    public void a(String str) {
        this.g = str;
    }

    @Override // com.meizu.cloud.pushsdk.b.f
    public void a(String str, String str2) {
        if (this.i) {
            Log.d(str, str2);
        }
        synchronized (this.b) {
            b();
            a(new a("D", str, str2));
            c();
        }
    }

    @Override // com.meizu.cloud.pushsdk.b.f
    public void a(String str, String str2, Throwable th) {
        if (this.i) {
            Log.e(str, str2, th);
        }
        synchronized (this.b) {
            b();
            a(new a(ExifInterface.LONGITUDE_EAST, str, str2 + StringUtils.LF + Log.getStackTraceString(th)));
            c();
        }
    }

    @Override // com.meizu.cloud.pushsdk.b.f
    public void a(boolean z) {
        ThreadPoolExecutor threadPoolExecutor;
        Runnable runnable = new Runnable() { // from class: com.meizu.cloud.pushsdk.b.b.2
            @Override // java.lang.Runnable
            public void run() {
                ArrayList<a> arrayList;
                b bVar;
                synchronized (b.this.b) {
                    b.this.c.removeCallbacksAndMessages(null);
                    arrayList = new ArrayList(b.this.b);
                    b.this.b.clear();
                }
                try {
                    try {
                        b.this.f.a(b.this.g);
                        for (a aVar : arrayList) {
                            b.this.f.a(aVar.a, aVar.b, aVar.c);
                        }
                        bVar = b.this;
                    } catch (Exception unused) {
                        bVar = b.this;
                    } catch (Throwable th) {
                        try {
                            b.this.f.a();
                        } catch (Exception unused2) {
                        }
                        throw th;
                    }
                    bVar.f.a();
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

    @Override // com.meizu.cloud.pushsdk.b.f
    public boolean a() {
        return this.i;
    }

    @Override // com.meizu.cloud.pushsdk.b.f
    public void b(String str, String str2) {
        if (this.i) {
            Log.i(str, str2);
        }
        synchronized (this.b) {
            b();
            a(new a("I", str, str2));
            c();
        }
    }

    @Override // com.meizu.cloud.pushsdk.b.f
    public void b(boolean z) {
        this.i = z;
    }

    @Override // com.meizu.cloud.pushsdk.b.f
    public void c(String str, String str2) {
        if (this.i) {
            Log.w(str, str2);
        }
        synchronized (this.b) {
            b();
            a(new a(ExifInterface.LONGITUDE_WEST, str, str2));
            c();
        }
    }

    @Override // com.meizu.cloud.pushsdk.b.f
    public void d(String str, String str2) {
        if (this.i) {
            Log.e(str, str2);
        }
        synchronized (this.b) {
            b();
            a(new a(ExifInterface.LONGITUDE_EAST, str, str2));
            c();
        }
    }
}
