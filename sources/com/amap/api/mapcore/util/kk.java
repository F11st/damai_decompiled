package com.amap.api.mapcore.util;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.autonavi.amap.mapcore.Inner_3dMap_location;
import com.autonavi.amap.mapcore.Inner_3dMap_locationOption;
import com.taobao.weex.common.Constants;
import com.uc.webview.export.extension.UCCore;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public final class kk {
    private static int m = 200;
    private static boolean n = true;
    Context a;
    Handler f;
    Inner_3dMap_locationOption i;
    kd b = null;
    kl c = null;
    b d = null;
    Handler e = null;
    boolean g = false;
    boolean h = false;
    final int j = 500;
    final int k = 30;
    private JSONArray o = null;
    Object l = new Object();

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            if (message.what != 1) {
                return;
            }
            kk.this.b();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public static class b extends HandlerThread {
        public b(String str) {
            super(str);
        }

        @Override // android.os.HandlerThread
        protected final void onLooperPrepared() {
            super.onLooperPrepared();
        }

        @Override // android.os.HandlerThread, java.lang.Thread, java.lang.Runnable
        public final void run() {
            try {
                super.run();
            } catch (Throwable unused) {
            }
        }
    }

    public kk(Context context, Handler handler) {
        this.a = null;
        this.f = null;
        this.i = null;
        try {
            if (context == null) {
                throw new IllegalArgumentException("Context参数不能为null");
            }
            this.a = context.getApplicationContext();
            this.f = handler;
            this.i = new Inner_3dMap_locationOption();
            f();
            e();
        } catch (Throwable th) {
            jy.a(th, "LocationService", "<init>");
        }
    }

    private void a(Inner_3dMap_location inner_3dMap_location) {
        try {
            if (n && inner_3dMap_location != null && inner_3dMap_location.getErrorCode() == 0 && inner_3dMap_location.getLocationType() == 1) {
                if (this.o == null) {
                    this.o = new JSONArray();
                }
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("lon", inner_3dMap_location.getLongitude());
                jSONObject.put("lat", inner_3dMap_location.getLatitude());
                jSONObject.put("type", 0);
                jSONObject.put("timestamp", kc.a());
                JSONArray put = this.o.put(jSONObject);
                this.o = put;
                if (put.length() >= m) {
                    h();
                }
            }
        } catch (Throwable th) {
            jy.a(th, "LocationService", "recordOfflineLocLog");
        }
    }

    private void e() {
        b bVar = new b("locServiceAction");
        this.d = bVar;
        bVar.setPriority(5);
        this.d.start();
        this.e = new a(this.d.getLooper());
    }

    private void f() {
        try {
            if (this.i == null) {
                this.i = new Inner_3dMap_locationOption();
            }
            if (this.h) {
                return;
            }
            this.b = new kd(this.a);
            kl klVar = new kl(this.a);
            this.c = klVar;
            klVar.a(this.i);
            g();
            this.h = true;
        } catch (Throwable th) {
            jy.a(th, "LocationService", UCCore.LEGACY_EVENT_INIT);
        }
    }

    private void g() {
        try {
            n = kb.b(this.a, "maploc", "ue");
            int a2 = kb.a(this.a, "maploc", "opn");
            m = a2;
            if (a2 > 500) {
                m = 500;
            }
            if (m < 30) {
                m = 30;
            }
        } catch (Throwable th) {
            jy.a(th, "LocationService", "getSPConfig");
        }
    }

    private synchronized void h() {
        try {
            JSONArray jSONArray = this.o;
            if (jSONArray != null && jSONArray.length() > 0) {
                ir.a(new iq(this.a, jy.c(), this.o.toString()), this.a);
                this.o = null;
            }
        } catch (Throwable th) {
            jy.a(th, "LocationService", "writeOfflineLog");
        }
    }

    private void i() {
        synchronized (this.l) {
            Handler handler = this.e;
            if (handler != null) {
                handler.removeCallbacksAndMessages(null);
            }
            this.e = null;
        }
    }

    private void j() {
        synchronized (this.l) {
            Handler handler = this.e;
            if (handler != null) {
                handler.removeMessages(1);
            }
        }
    }

    public final void a() {
        try {
            f();
            if (!this.i.getLocationMode().equals(Inner_3dMap_locationOption.Inner_3dMap_Enum_LocationMode.Battery_Saving) && !this.g) {
                this.g = true;
                this.b.a();
            }
            Handler handler = this.e;
            if (handler != null) {
                handler.sendEmptyMessage(1);
            }
        } catch (Throwable th) {
            jy.a(th, "LocationService", "getLocation");
        }
    }

    public final void a(Inner_3dMap_locationOption inner_3dMap_locationOption) {
        this.i = inner_3dMap_locationOption;
        if (inner_3dMap_locationOption == null) {
            this.i = new Inner_3dMap_locationOption();
        }
        kl klVar = this.c;
        if (klVar != null) {
            klVar.a(inner_3dMap_locationOption);
        }
    }

    final void b() {
        Inner_3dMap_location inner_3dMap_location = null;
        try {
            if (this.i.getLocationMode().equals(Inner_3dMap_locationOption.Inner_3dMap_Enum_LocationMode.Battery_Saving) && this.g) {
                this.b.b();
                this.g = false;
            }
            if (this.b.c()) {
                inner_3dMap_location = this.b.d();
            } else if (!this.i.getLocationMode().equals(Inner_3dMap_locationOption.Inner_3dMap_Enum_LocationMode.Device_Sensors)) {
                inner_3dMap_location = this.c.a();
            }
            if (this.f != null && inner_3dMap_location != null) {
                Message obtain = Message.obtain();
                obtain.obj = inner_3dMap_location;
                obtain.what = 1;
                this.f.sendMessage(obtain);
            }
            a(inner_3dMap_location);
        } catch (Throwable th) {
            jy.a(th, "LocationService", "doGetLocation");
        }
    }

    public final void c() {
        this.g = false;
        try {
            j();
            kd kdVar = this.b;
            if (kdVar != null) {
                kdVar.b();
            }
        } catch (Throwable th) {
            jy.a(th, "LocationService", "stopLocation");
        }
    }

    public final void d() {
        try {
            c();
            i();
            b bVar = this.d;
            if (bVar != null) {
                if (Build.VERSION.SDK_INT >= 18) {
                    ka.a(bVar, HandlerThread.class, "quitSafely", new Object[0]);
                } else {
                    bVar.quit();
                }
            }
            this.d = null;
            this.c.b();
            this.g = false;
            this.h = false;
            h();
        } catch (Throwable th) {
            jy.a(th, "LocationService", Constants.Event.SLOT_LIFECYCLE.DESTORY);
        }
    }
}
