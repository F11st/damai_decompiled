package com.taobao.alivfsadapter;

import android.app.Application;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.taobao.alivfsadapter.database.alidb.C6251a;
import com.taobao.android.alivfsdb.AliDBLogger;
import tb.AbstractC9293j0;
import tb.C9064e0;
import tb.C9121f0;
import tb.C9328k0;
import tb.C9393l0;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class AVFSAdapterManager {
    private static volatile AVFSAdapterManager f;
    private AVFSSDKAppMonitor b;
    private Application d;
    private boolean a = false;
    private final Handler c = new Handler(Looper.getMainLooper());
    private final Runnable e = new Runnable() { // from class: com.taobao.alivfsadapter.AVFSAdapterManager.1
        @Override // java.lang.Runnable
        public void run() {
            synchronized (AVFSAdapterManager.this.e) {
                AVFSAdapterManager.this.d(C9121f0.a(), null, null);
                AVFSAdapterManager.this.e.notify();
            }
        }
    };

    public static synchronized AVFSAdapterManager g() {
        AVFSAdapterManager aVFSAdapterManager;
        synchronized (AVFSAdapterManager.class) {
            if (f == null && f == null) {
                f = new AVFSAdapterManager();
            }
            aVFSAdapterManager = f;
        }
        return aVFSAdapterManager;
    }

    private void h(Application application, AVFSSDKAppMonitor aVFSSDKAppMonitor, AbstractC9293j0 abstractC9293j0) {
        this.d = application;
        if (aVFSSDKAppMonitor == null) {
            try {
                this.b = new C9393l0();
            } catch (ClassNotFoundException unused) {
            }
        } else {
            this.b = aVFSSDKAppMonitor;
        }
        if (abstractC9293j0 == null) {
            try {
                Class.forName("com.taobao.android.alivfsdb.AliDB");
                new C9064e0();
                AliDBLogger.logger = new C6251a();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
                new C9328k0();
            }
        }
        this.a = this.d != null;
        Log.d("AVFSAdapterManager", "- AVFSAdapterManager initialize: mInitialized=" + this.a);
    }

    public void b() {
        if (i()) {
            return;
        }
        if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
            this.c.post(this.e);
            synchronized (this.e) {
                try {
                    try {
                        try {
                            this.e.wait();
                        } catch (IllegalStateException unused) {
                            this.a = false;
                            return;
                        }
                    } catch (InterruptedException unused2) {
                        this.a = false;
                        return;
                    }
                } finally {
                }
            }
            return;
        }
        d(C9121f0.a(), null, null);
    }

    public void c(Application application) {
        d(application, null, null);
    }

    public synchronized void d(Application application, AVFSSDKAppMonitor aVFSSDKAppMonitor, AbstractC9293j0 abstractC9293j0) {
        h(application, aVFSSDKAppMonitor, abstractC9293j0);
    }

    public Application e() {
        b();
        Application application = this.d;
        if (application != null) {
            return application;
        }
        throw new RuntimeException("AVFSAdapterManager not initialized!");
    }

    public AVFSSDKAppMonitor f() {
        b();
        return this.b;
    }

    public boolean i() {
        return this.a;
    }
}
