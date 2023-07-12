package com.amap.api.mapcore.util;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.amap.api.mapcore.util.C4596j;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;
import com.autonavi.base.amap.mapcore.MapConfig;
import java.lang.ref.WeakReference;

/* compiled from: Taobao */
/* renamed from: com.amap.api.mapcore.util.i */
/* loaded from: classes10.dex */
public class C4584i extends Thread {
    private static int c = 0;
    private static int d = 3;
    private static long e = 30000;
    private static boolean g;
    private WeakReference<Context> a;
    private IAMapDelegate b;
    private RunnableC4585a f = null;
    private Handler h = new Handler(Looper.getMainLooper()) { // from class: com.amap.api.mapcore.util.i.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (C4584i.g) {
                return;
            }
            if (C4584i.this.f == null) {
                C4584i c4584i = C4584i.this;
                c4584i.f = new RunnableC4585a(c4584i.b, C4584i.this.a == null ? null : (Context) C4584i.this.a.get());
            }
            ep.a().a(C4584i.this.f);
        }
    };

    /* compiled from: Taobao */
    /* renamed from: com.amap.api.mapcore.util.i$a */
    /* loaded from: classes10.dex */
    static class RunnableC4585a implements Runnable {
        private WeakReference<IAMapDelegate> a;
        private WeakReference<Context> b;
        private C4596j c;

        public RunnableC4585a(IAMapDelegate iAMapDelegate, Context context) {
            this.a = null;
            this.b = null;
            this.a = new WeakReference<>(iAMapDelegate);
            if (context != null) {
                this.b = new WeakReference<>(context);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            C4596j.C4597a e;
            WeakReference<Context> weakReference;
            try {
                if (C4584i.g) {
                    return;
                }
                if (this.c == null && (weakReference = this.b) != null && weakReference.get() != null) {
                    this.c = new C4596j(this.b.get(), "");
                }
                C4584i.c();
                if (C4584i.c > C4584i.d) {
                    boolean unused = C4584i.g = true;
                    a();
                    return;
                }
                C4596j c4596j = this.c;
                if (c4596j == null || (e = c4596j.e()) == null) {
                    return;
                }
                if (!e.d) {
                    a();
                }
                boolean unused2 = C4584i.g = true;
            } catch (Throwable th) {
                hd.c(th, "authForPro", "loadConfigData_uploadException");
            }
        }

        private void a() {
            final IAMapDelegate iAMapDelegate;
            WeakReference<IAMapDelegate> weakReference = this.a;
            if (weakReference == null || weakReference.get() == null || (iAMapDelegate = this.a.get()) == null || iAMapDelegate.getMapConfig() == null) {
                return;
            }
            iAMapDelegate.queueEvent(new Runnable() { // from class: com.amap.api.mapcore.util.i.a.1
                @Override // java.lang.Runnable
                public void run() {
                    IAMapDelegate iAMapDelegate2 = iAMapDelegate;
                    if (iAMapDelegate2 == null || iAMapDelegate2.getMapConfig() == null) {
                        return;
                    }
                    MapConfig mapConfig = iAMapDelegate.getMapConfig();
                    mapConfig.setProFunctionAuthEnable(false);
                    if (mapConfig.isUseProFunction()) {
                        iAMapDelegate.setMapCustomEnable(mapConfig.isCustomStyleEnable(), true);
                        iAMapDelegate.reloadMapCustomStyle();
                        ds.a(RunnableC4585a.this.b == null ? null : (Context) RunnableC4585a.this.b.get(), "鉴权失败，当前key没有自定义纹理的使用权限，自定义纹理相关内容，将不会呈现！");
                    }
                }
            });
        }
    }

    public C4584i(Context context, IAMapDelegate iAMapDelegate) {
        this.a = null;
        if (context != null) {
            this.a = new WeakReference<>(context);
        }
        this.b = iAMapDelegate;
        a();
    }

    static /* synthetic */ int c() {
        int i = c;
        c = i + 1;
        return i;
    }

    private void f() {
        if (g) {
            return;
        }
        int i = 0;
        while (i <= d) {
            i++;
            this.h.sendEmptyMessageDelayed(0, i * e);
        }
    }

    @Override // java.lang.Thread
    public void interrupt() {
        this.b = null;
        this.a = null;
        Handler handler = this.h;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        this.h = null;
        this.f = null;
        a();
        super.interrupt();
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        try {
            f();
        } catch (Throwable th) {
            hd.c(th, "AMapDelegateImpGLSurfaceView", "mVerfy");
            th.printStackTrace();
        }
    }

    public static void a() {
        c = 0;
        g = false;
    }
}
