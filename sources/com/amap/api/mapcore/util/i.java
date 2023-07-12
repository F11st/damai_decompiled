package com.amap.api.mapcore.util;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.amap.api.mapcore.util.j;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;
import com.autonavi.base.amap.mapcore.MapConfig;
import java.lang.ref.WeakReference;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class i extends Thread {
    private static int c = 0;
    private static int d = 3;
    private static long e = 30000;
    private static boolean g;
    private WeakReference<Context> a;
    private IAMapDelegate b;
    private a f = null;
    private Handler h = new Handler(Looper.getMainLooper()) { // from class: com.amap.api.mapcore.util.i.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (i.g) {
                return;
            }
            if (i.this.f == null) {
                i iVar = i.this;
                iVar.f = new a(iVar.b, i.this.a == null ? null : (Context) i.this.a.get());
            }
            ep.a().a(i.this.f);
        }
    };

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    static class a implements Runnable {
        private WeakReference<IAMapDelegate> a;
        private WeakReference<Context> b;
        private j c;

        public a(IAMapDelegate iAMapDelegate, Context context) {
            this.a = null;
            this.b = null;
            this.a = new WeakReference<>(iAMapDelegate);
            if (context != null) {
                this.b = new WeakReference<>(context);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            j.a e;
            WeakReference<Context> weakReference;
            try {
                if (i.g) {
                    return;
                }
                if (this.c == null && (weakReference = this.b) != null && weakReference.get() != null) {
                    this.c = new j(this.b.get(), "");
                }
                i.c();
                if (i.c > i.d) {
                    boolean unused = i.g = true;
                    a();
                    return;
                }
                j jVar = this.c;
                if (jVar == null || (e = jVar.e()) == null) {
                    return;
                }
                if (!e.d) {
                    a();
                }
                boolean unused2 = i.g = true;
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
                        ds.a(a.this.b == null ? null : (Context) a.this.b.get(), "鉴权失败，当前key没有自定义纹理的使用权限，自定义纹理相关内容，将不会呈现！");
                    }
                }
            });
        }
    }

    public i(Context context, IAMapDelegate iAMapDelegate) {
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
