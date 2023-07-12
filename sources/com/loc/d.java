package com.loc;

import android.app.Application;
import android.app.Notification;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.WebView;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.amap.api.location.AMapLocationQualityReport;
import com.amap.api.location.APSService;
import com.amap.api.location.UmidtokenInfo;
import com.amap.api.services.geocoder.GeocodeSearch;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
import tb.f83;
import tb.h83;
import tb.r73;
import tb.z73;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public final class d {
    private static boolean H = true;
    public static volatile boolean I;
    private static boolean J;
    private static AtomicBoolean K = new AtomicBoolean(false);
    eo a;
    private Context b;
    public e d;
    private f83 f;
    n1 l;
    Intent o;
    private boolean p;
    AMapLocationClientOption c = new AMapLocationClientOption();
    h83 e = null;
    private boolean g = false;
    private volatile boolean h = false;
    ArrayList<AMapLocationListener> i = new ArrayList<>();
    public boolean j = true;
    public boolean k = true;
    Messenger m = null;
    Messenger n = null;
    b q = null;
    boolean r = false;
    AMapLocationClientOption.AMapLocationMode s = AMapLocationClientOption.AMapLocationMode.Hight_Accuracy;
    Object t = new Object();
    l1 u = null;
    boolean v = false;
    com.loc.e w = null;
    private AMapLocationClientOption x = new AMapLocationClientOption();
    private i y = null;
    String z = null;
    private ServiceConnection A = new a();
    AMapLocationQualityReport B = null;
    boolean C = false;
    private volatile boolean D = false;
    HandlerC0255d E = null;
    String F = null;
    boolean G = false;

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    final class a implements ServiceConnection {
        a() {
        }

        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                d.this.m = new Messenger(iBinder);
                d.this.g = true;
                d.this.v = true;
            } catch (Throwable th) {
                j1.h(th, "ALManager", "onServiceConnected");
            }
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName componentName) {
            d dVar = d.this;
            dVar.m = null;
            dVar.g = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public static class b extends HandlerThread {
        d a;

        public b(String str, d dVar) {
            super(str);
            this.a = null;
            this.a = dVar;
        }

        @Override // android.os.HandlerThread
        protected final void onLooperPrepared() {
            try {
                this.a.l.b();
                z73.a(this.a.b);
                this.a.v0();
                d dVar = this.a;
                if (dVar != null && dVar.b != null) {
                    i1.j(this.a.b);
                    i1.a(this.a.b);
                }
                super.onLooperPrepared();
            } catch (Throwable unused) {
            }
        }

        @Override // android.os.HandlerThread, java.lang.Thread, java.lang.Runnable
        public final void run() {
            try {
                super.run();
            } catch (Throwable unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public static /* synthetic */ class c {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[AMapLocationClientOption.AMapLocationMode.values().length];
            a = iArr;
            try {
                iArr[AMapLocationClientOption.AMapLocationMode.Battery_Saving.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[AMapLocationClientOption.AMapLocationMode.Device_Sensors.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[AMapLocationClientOption.AMapLocationMode.Hight_Accuracy.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.loc.d$d  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public class HandlerC0255d extends Handler {
        public HandlerC0255d(Looper looper) {
            super(looper);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v0 */
        /* JADX WARN: Type inference failed for: r0v1 */
        /* JADX WARN: Type inference failed for: r0v2, types: [java.lang.String] */
        /* JADX WARN: Type inference failed for: r0v3, types: [java.lang.String] */
        /* JADX WARN: Type inference failed for: r0v7 */
        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            ?? r0 = 0;
            try {
                super.handleMessage(message);
                int i = message.what;
                if (i == 11) {
                    d.this.k(message.getData());
                } else if (i == 12) {
                    d.this.I(message);
                } else if (i == 1011) {
                    d.this.f(14, null);
                    d.this.i0();
                } else {
                    try {
                        switch (i) {
                            case 1002:
                                d.this.U((AMapLocationListener) message.obj);
                                return;
                            case 1003:
                                d.this.o0();
                                d.this.f(13, null);
                                return;
                            case 1004:
                                d.this.r0();
                                d.this.f(14, null);
                                return;
                            case 1005:
                                d.this.Z((AMapLocationListener) message.obj);
                                return;
                            default:
                                switch (i) {
                                    case 1014:
                                        d.this.l(message);
                                        return;
                                    case 1015:
                                        d dVar = d.this;
                                        dVar.e.k(dVar.c);
                                        d.this.g(1025, null, 300000L);
                                        return;
                                    case 1016:
                                        if (m1.f0(d.this.b)) {
                                            d.this.x0();
                                            return;
                                        } else if (d.this.e.v()) {
                                            d.this.g(1016, null, 1000L);
                                            return;
                                        } else {
                                            d.this.t0();
                                            return;
                                        }
                                    case 1017:
                                        d.this.e.c();
                                        d.this.d(1025);
                                        return;
                                    case 1018:
                                        d dVar2 = d.this;
                                        AMapLocationClientOption aMapLocationClientOption = (AMapLocationClientOption) message.obj;
                                        dVar2.c = aMapLocationClientOption;
                                        if (aMapLocationClientOption != null) {
                                            dVar2.y0();
                                            return;
                                        }
                                        return;
                                    default:
                                        switch (i) {
                                            case 1023:
                                                d.this.S(message);
                                                return;
                                            case 1024:
                                                d.this.X(message);
                                                return;
                                            case 1025:
                                                if (d.this.e.F()) {
                                                    d.this.e.c();
                                                    d dVar3 = d.this;
                                                    dVar3.e.k(dVar3.c);
                                                }
                                                d.this.g(1025, null, 300000L);
                                                return;
                                            case 1026:
                                                d.this.f.i(d.this.c);
                                                return;
                                            case 1027:
                                                d.this.f.b();
                                                return;
                                            case 1028:
                                                d.this.g0((AMapLocation) message.obj);
                                                return;
                                            default:
                                                return;
                                        }
                                }
                        }
                    } catch (Throwable th) {
                        r0 = message;
                        th = th;
                        if (r0 == 0) {
                            r0 = "handleMessage";
                        }
                        j1.h(th, "AMapLocationManage$MHandlerr", r0);
                    }
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public class e extends Handler {
        public e() {
        }

        public e(Looper looper) {
            super(looper);
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            e eVar;
            e eVar2;
            try {
                super.handleMessage(message);
                d dVar = d.this;
                if (dVar.r) {
                    return;
                }
                int i = message.what;
                if (i == 1) {
                    Message obtainMessage = dVar.E.obtainMessage();
                    obtainMessage.what = 11;
                    obtainMessage.setData(message.getData());
                    d.this.E.sendMessage(obtainMessage);
                    return;
                }
                if (i != 2) {
                    if (i == 13) {
                        eo eoVar = dVar.a;
                        if (eoVar != null) {
                            dVar.n(eoVar);
                            return;
                        }
                        AMapLocation aMapLocation = new AMapLocation("LBS");
                        aMapLocation.setErrorCode(33);
                        d.this.n(aMapLocation);
                        return;
                    }
                    switch (i) {
                        case 5:
                            Bundle data = message.getData();
                            data.putBundle("optBundle", j1.a(d.this.c));
                            d.this.f(10, data);
                            return;
                        case 6:
                            Bundle data2 = message.getData();
                            h83 h83Var = d.this.e;
                            if (h83Var != null) {
                                h83Var.h(data2);
                                return;
                            }
                            return;
                        case 7:
                            d.this.p = message.getData().getBoolean("ngpsAble");
                            return;
                        case 8:
                            l1.p(null, 2141);
                            break;
                        case 9:
                            boolean unused = d.J = message.getData().getBoolean("installMockApp");
                            return;
                        case 10:
                            dVar.n((AMapLocation) message.obj);
                            return;
                        default:
                            switch (i) {
                                case 100:
                                    l1.p(null, 2155);
                                    break;
                                case 101:
                                    break;
                                case 102:
                                    Bundle data3 = message.getData();
                                    data3.putBundle("optBundle", j1.a(d.this.c));
                                    d.this.f(15, data3);
                                    return;
                                case 103:
                                    Bundle data4 = message.getData();
                                    if (d.this.f != null) {
                                        d.this.f.f(data4);
                                        return;
                                    }
                                    return;
                                default:
                                    return;
                            }
                            Message obtain = Message.obtain();
                            obtain.what = 1028;
                            obtain.obj = message.obj;
                            d.this.E.sendMessage(obtain);
                            if (d.this.x == null || !d.this.x.getCacheCallBack() || (eVar2 = d.this.d) == null) {
                                return;
                            }
                            eVar2.removeMessages(13);
                            return;
                    }
                }
                Message obtain2 = Message.obtain();
                obtain2.what = 12;
                obtain2.obj = message.obj;
                d.this.E.sendMessage(obtain2);
                if (d.this.x == null || !d.this.x.getCacheCallBack() || (eVar = d.this.d) == null) {
                    return;
                }
                eVar.removeMessages(13);
            } catch (Throwable th) {
                j1.h(th, "AmapLocationManager$MainHandler", 0 == 0 ? "handleMessage" : null);
            }
        }
    }

    public d(Context context, Intent intent, Looper looper) {
        this.o = null;
        this.b = context;
        this.o = intent;
        H(looper);
    }

    private static void A(ej ejVar, eo eoVar) {
        if (eoVar != null) {
            try {
                if (eoVar.getErrorCode() == 0) {
                    ejVar.t(eoVar);
                }
            } catch (Throwable th) {
                j1.h(th, "ALManager", "apsLocation:doFirstAddCache");
            }
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(15:1|(11:2|3|4|(1:6)|7|(1:9)|10|11|12|(3:14|(2:16|(2:86|(2:88|(1:92)))(1:18))|93)(1:94)|19)|(4:(18:(1:22)(1:84)|23|24|(2:26|(1:28))|30|(3:73|74|75)(1:32)|33|(1:37)|38|39|(1:43)|45|(1:47)|48|(1:50)|(1:55)|68|69)(1:85)|68|69|(2:(0)|(1:70)))|80|(0)(0)|33|(2:35|37)|38|39|(2:41|43)|45|(0)|48|(0)|(2:53|55)) */
    /* JADX WARN: Removed duplicated region for block: B:106:0x00c2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0106 A[Catch: all -> 0x0122, TryCatch #6 {all -> 0x00ce, blocks: (B:56:0x00c2, B:85:0x012c, B:87:0x0130, B:74:0x00ff, B:76:0x0106, B:77:0x0119, B:79:0x011e, B:61:0x00d1, B:63:0x00d9, B:65:0x00dd), top: B:106:0x00c2 }] */
    /* JADX WARN: Removed duplicated region for block: B:79:0x011e A[Catch: all -> 0x0122, TRY_LEAVE, TryCatch #6 {all -> 0x00ce, blocks: (B:56:0x00c2, B:85:0x012c, B:87:0x0130, B:74:0x00ff, B:76:0x0106, B:77:0x0119, B:79:0x011e, B:61:0x00d1, B:63:0x00d9, B:65:0x00dd), top: B:106:0x00c2 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.loc.eo E(com.loc.ej r14) {
        /*
            Method dump skipped, instructions count: 328
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loc.d.E(com.loc.ej):com.loc.eo");
    }

    private void H(Looper looper) {
        try {
            if (looper == null) {
                this.d = Looper.myLooper() == null ? new e(this.b.getMainLooper()) : new e();
            } else {
                this.d = new e(looper);
            }
        } catch (Throwable th) {
            j1.h(th, "ALManager", "init 1");
        }
        try {
            this.l = new n1(this.b);
            b bVar = new b("amapLocManagerThread", this);
            this.q = bVar;
            bVar.setPriority(5);
            this.q.start();
            this.E = b(this.q.getLooper());
            try {
                this.e = new h83(this.b, this.d);
                this.f = new f83(this.b, this.d);
            } catch (Throwable th2) {
                j1.h(th2, "ALManager", "init 3");
            }
            if (this.u == null) {
                this.u = new l1();
            }
            h(this.b);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I(Message message) {
        try {
            AMapLocation aMapLocation = (AMapLocation) message.obj;
            if (this.j && this.m != null) {
                Bundle bundle = new Bundle();
                bundle.putBundle("optBundle", j1.a(this.c));
                f(0, bundle);
                if (this.h) {
                    f(13, null);
                }
                this.j = false;
            }
            o(aMapLocation, null);
            d(1025);
            g(1025, null, 300000L);
        } catch (Throwable th) {
            j1.h(th, "ALManager", "resultGpsLocationSuccess");
        }
    }

    private void J(AMapLocation aMapLocation) {
        if (aMapLocation != null) {
            try {
                String locationDetail = aMapLocation.getLocationDetail();
                StringBuilder sb = TextUtils.isEmpty(locationDetail) ? new StringBuilder() : new StringBuilder(locationDetail);
                boolean N = m1.N(this.b, "EYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19XSUZJX1NUQVRF");
                boolean N2 = m1.N(this.b, "WYW5kcm9pZC5wZXJtaXNzaW9uLkNIQU5HRV9XSUZJX1NUQVRF");
                boolean N3 = m1.N(this.b, "WYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19MT0NBVElPTl9FWFRSQV9DT01NQU5EUw==");
                boolean N4 = m1.N(this.b, "EYW5kcm9pZC5wZXJtaXNzaW9uLlJFQURfUEhPTkVfU1RBVEU=");
                boolean N5 = m1.N(this.b, "EYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19GSU5FX0xPQ0FUSU9O");
                boolean N6 = m1.N(this.b, "EYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19DT0FSU0VfTE9DQVRJT04=");
                sb.append(N ? "#pm1" : "#pm0");
                String str = "1";
                sb.append(N2 ? "1" : "0");
                sb.append(N3 ? "1" : "0");
                sb.append(N4 ? "1" : "0");
                sb.append(N5 ? "1" : "0");
                if (!N6) {
                    str = "0";
                }
                sb.append(str);
                aMapLocation.setLocationDetail(sb.toString());
            } catch (Throwable unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void S(Message message) {
        if (message == null) {
            return;
        }
        try {
            Bundle data = message.getData();
            if (data == null) {
                return;
            }
            int i = data.getInt("i", 0);
            Intent w0 = w0();
            w0.putExtra("i", i);
            w0.putExtra("h", (Notification) data.getParcelable("h"));
            w0.putExtra("g", 1);
            j(w0, true);
        } catch (Throwable th) {
            j1.h(th, "ALManager", "doEnableBackgroundLocation");
        }
    }

    private void T(AMapLocation aMapLocation) {
        Message obtainMessage = this.d.obtainMessage();
        obtainMessage.what = 10;
        obtainMessage.obj = aMapLocation;
        this.d.sendMessage(obtainMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void U(AMapLocationListener aMapLocationListener) {
        if (aMapLocationListener == null) {
            throw new IllegalArgumentException("listener参数不能为null");
        }
        if (this.i == null) {
            this.i = new ArrayList<>();
        }
        if (this.i.contains(aMapLocationListener)) {
            return;
        }
        this.i.add(aMapLocationListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void X(Message message) {
        if (message == null) {
            return;
        }
        try {
            Bundle data = message.getData();
            if (data == null) {
                return;
            }
            boolean z = data.getBoolean("j", true);
            Intent w0 = w0();
            w0.putExtra("j", z);
            w0.putExtra("g", 2);
            j(w0, false);
        } catch (Throwable th) {
            j1.h(th, "ALManager", "doDisableBackgroundLocation");
        }
    }

    private synchronized void Y(AMapLocation aMapLocation) {
        if (aMapLocation == null) {
            try {
                aMapLocation = new AMapLocation("");
                aMapLocation.setErrorCode(8);
                aMapLocation.setLocationDetail("coarse amapLocation is null#2005");
            } catch (Throwable th) {
                j1.h(th, "ALManager", "handlerCoarseLocation part2");
                return;
            }
        }
        if (this.B == null) {
            this.B = new AMapLocationQualityReport();
        }
        this.B.setLocationMode(this.c.getLocationMode());
        if (this.f != null) {
            this.B.setGPSSatellites(aMapLocation.getSatellites());
            this.B.setGpsStatus(this.f.n());
        }
        this.B.setWifiAble(m1.Y(this.b));
        this.B.setNetworkType(m1.Z(this.b));
        this.B.setNetUseTime(0L);
        this.B.setInstallHighDangerMockApp(J);
        aMapLocation.setLocationQualityReport(this.B);
        if (this.h) {
            l1.h(this.b, aMapLocation);
            T(aMapLocation.m216clone());
            z73.a(this.b).c(aMapLocation);
            z73.a(this.b).d();
        }
        if (this.r) {
            return;
        }
        if (this.f != null) {
            r0();
        }
        f(14, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Z(AMapLocationListener aMapLocationListener) {
        if (!this.i.isEmpty() && this.i.contains(aMapLocationListener)) {
            this.i.remove(aMapLocationListener);
        }
        if (this.i.isEmpty()) {
            r0();
        }
    }

    private HandlerC0255d b(Looper looper) {
        HandlerC0255d handlerC0255d;
        synchronized (this.t) {
            handlerC0255d = new HandlerC0255d(looper);
            this.E = handlerC0255d;
        }
        return handlerC0255d;
    }

    private eo c(ej ejVar, boolean z) {
        if (this.c.isLocationCacheEnable()) {
            try {
                return ejVar.f(z);
            } catch (Throwable th) {
                j1.h(th, "ALManager", "doFirstCacheLoc");
                return null;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(int i) {
        synchronized (this.t) {
            HandlerC0255d handlerC0255d = this.E;
            if (handlerC0255d != null) {
                handlerC0255d.removeMessages(i);
            }
        }
    }

    private void d0(AMapLocation aMapLocation) {
        if (aMapLocation == null) {
            return;
        }
        AMapLocation aMapLocation2 = null;
        try {
            r73 r73Var = n1.g;
            if (r73Var == null) {
                n1 n1Var = this.l;
                if (n1Var != null) {
                    aMapLocation2 = n1Var.d();
                }
            } else {
                aMapLocation2 = r73Var.a();
            }
            l1.o(aMapLocation2, aMapLocation);
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(int i, Bundle bundle) {
        if (bundle == null) {
            try {
                bundle = new Bundle();
            } catch (Throwable th) {
                boolean z = (th instanceof IllegalStateException) && th.getMessage().contains("sending message to a Handler on a dead thread");
                if ((th instanceof RemoteException) || z) {
                    this.m = null;
                    this.g = false;
                }
                j1.h(th, "ALManager", "sendLocMessage");
                return;
            }
        }
        if (TextUtils.isEmpty(this.z)) {
            this.z = j1.o(this.b);
        }
        bundle.putString(com.huawei.hms.opendevice.c.a, this.z);
        Message obtain = Message.obtain();
        obtain.what = i;
        obtain.setData(bundle);
        obtain.replyTo = this.n;
        Messenger messenger = this.m;
        if (messenger != null) {
            messenger.send(obtain);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(int i, Object obj, long j) {
        synchronized (this.t) {
            if (this.E != null) {
                Message obtain = Message.obtain();
                obtain.what = i;
                if (obj instanceof Bundle) {
                    obtain.setData((Bundle) obj);
                } else {
                    obtain.obj = obj;
                }
                this.E.sendMessageDelayed(obtain, j);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g0(AMapLocation aMapLocation) {
        try {
            if (this.k && this.m != null) {
                Bundle bundle = new Bundle();
                bundle.putBundle("optBundle", j1.a(this.c));
                f(0, bundle);
                if (this.h) {
                    f(13, null);
                }
                this.k = false;
            }
            Y(aMapLocation);
        } catch (Throwable th) {
            j1.h(th, "ALManager", "resultGpsLocationSuccess");
        }
    }

    private static void h(final Context context) {
        if (K.compareAndSet(false, true)) {
            o0.f().d(new ck() { // from class: com.loc.d.1
                @Override // com.loc.ck
                public final void a() {
                    o.M();
                    o.w(context);
                    o.R(context);
                }
            });
        }
    }

    private void i(Intent intent) {
        try {
            this.b.bindService(intent, this.A, 1);
        } catch (Throwable th) {
            j1.h(th, "ALManager", "startServiceImpl");
        }
    }

    private void j(Intent intent, boolean z) {
        Context context = this.b;
        if (context != null) {
            if (Build.VERSION.SDK_INT < 26 || !z) {
                context.startService(intent);
            } else if (!z0()) {
                Log.e("amapapi", "-------------调用后台定位服务，缺少权限：android.permission.FOREGROUND_SERVICE--------------");
                return;
            } else {
                try {
                    this.b.getClass().getMethod("startForegroundService", Intent.class).invoke(this.b, intent);
                } catch (Throwable unused) {
                    this.b.startService(intent);
                }
            }
            this.G = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(Bundle bundle) {
        ei eiVar;
        AMapLocation aMapLocation;
        h83 h83Var;
        AMapLocation aMapLocation2 = null;
        if (bundle != null) {
            try {
                bundle.setClassLoader(AMapLocation.class.getClassLoader());
                aMapLocation = (AMapLocation) bundle.getParcelable("loc");
                this.F = bundle.getString("nb");
                eiVar = (ei) bundle.getParcelable("statics");
                if (aMapLocation != null) {
                    try {
                        if (aMapLocation.getErrorCode() == 0 && (h83Var = this.e) != null) {
                            h83Var.x();
                            if (!TextUtils.isEmpty(aMapLocation.getAdCode())) {
                                h83.J = aMapLocation;
                            }
                        }
                    } catch (Throwable th) {
                        th = th;
                        j1.h(th, "AmapLocationManager", "resultLbsLocationSuccess");
                        o(aMapLocation2, eiVar);
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                eiVar = null;
                j1.h(th, "AmapLocationManager", "resultLbsLocationSuccess");
                o(aMapLocation2, eiVar);
            }
        } else {
            eiVar = null;
            aMapLocation = null;
        }
        h83 h83Var2 = this.e;
        aMapLocation2 = h83Var2 != null ? h83Var2.b(aMapLocation, this.F) : aMapLocation;
        o(aMapLocation2, eiVar);
    }

    private void k0() {
        synchronized (this.t) {
            HandlerC0255d handlerC0255d = this.E;
            if (handlerC0255d != null) {
                handlerC0255d.removeCallbacksAndMessages(null);
            }
            this.E = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(Message message) {
        try {
            Bundle data = message.getData();
            AMapLocation aMapLocation = (AMapLocation) data.getParcelable("loc");
            String string = data.getString("lastLocNb");
            d0(aMapLocation);
            if (this.l.c(aMapLocation, string)) {
                this.l.f();
            }
        } catch (Throwable th) {
            j1.h(th, "ALManager", "doSaveLastLocation");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(AMapLocation aMapLocation) {
        try {
            if (aMapLocation.getErrorCode() != 0) {
                aMapLocation.setLocationType(0);
            }
            if (aMapLocation.getErrorCode() == 0) {
                double latitude = aMapLocation.getLatitude();
                double longitude = aMapLocation.getLongitude();
                if ((latitude == 0.0d && longitude == 0.0d) || latitude < -90.0d || latitude > 90.0d || longitude < -180.0d || longitude > 180.0d) {
                    l1.q("errorLatLng", aMapLocation.toStr());
                    aMapLocation.setLocationType(0);
                    aMapLocation.setErrorCode(8);
                    aMapLocation.setLocationDetail("LatLng is error#0802");
                }
            }
            if (GeocodeSearch.GPS.equalsIgnoreCase(aMapLocation.getProvider()) || !this.e.v()) {
                aMapLocation.setAltitude(m1.I(aMapLocation.getAltitude()));
                aMapLocation.setBearing(m1.b(aMapLocation.getBearing()));
                aMapLocation.setSpeed(m1.b(aMapLocation.getSpeed()));
                J(aMapLocation);
                Iterator<AMapLocationListener> it = this.i.iterator();
                while (it.hasNext()) {
                    try {
                        it.next().onLocationChanged(aMapLocation);
                    } catch (Throwable unused) {
                    }
                }
            }
        } catch (Throwable unused2) {
        }
    }

    private boolean n0() {
        boolean z = false;
        int i = 0;
        do {
            try {
                if (this.m != null) {
                    break;
                }
                Thread.sleep(100L);
                i++;
            } catch (Throwable th) {
                j1.h(th, "ALManager", "checkAPSManager");
            }
        } while (i < 50);
        if (this.m == null) {
            Message obtain = Message.obtain();
            Bundle bundle = new Bundle();
            AMapLocation aMapLocation = new AMapLocation("");
            aMapLocation.setErrorCode(10);
            aMapLocation.setLocationDetail(!m1.d0(this.b.getApplicationContext()) ? "请检查配置文件是否配置服务，并且manifest中service标签是否配置在application标签内#1003" : "启动ApsServcie失败#1001");
            bundle.putParcelable("loc", aMapLocation);
            obtain.setData(bundle);
            obtain.what = 1;
            this.d.sendMessage(obtain);
        } else {
            z = true;
        }
        if (!z) {
            l1.p(null, !m1.d0(this.b.getApplicationContext()) ? 2103 : 2101);
        }
        return z;
    }

    private synchronized void o(AMapLocation aMapLocation, ei eiVar) {
        if (aMapLocation == null) {
            try {
                aMapLocation = new AMapLocation("");
                aMapLocation.setErrorCode(8);
                aMapLocation.setLocationDetail("amapLocation is null#0801");
            } catch (Throwable th) {
                j1.h(th, "ALManager", "handlerLocation part3");
                return;
            }
        }
        if (!GeocodeSearch.GPS.equalsIgnoreCase(aMapLocation.getProvider())) {
            aMapLocation.setProvider("lbs");
        }
        if (this.B == null) {
            this.B = new AMapLocationQualityReport();
        }
        this.B.setLocationMode(this.c.getLocationMode());
        h83 h83Var = this.e;
        if (h83Var != null) {
            this.B.setGPSSatellites(h83Var.C());
            this.B.setGpsStatus(this.e.A());
        }
        this.B.setWifiAble(m1.Y(this.b));
        this.B.setNetworkType(m1.Z(this.b));
        if (aMapLocation.getLocationType() == 1 || GeocodeSearch.GPS.equalsIgnoreCase(aMapLocation.getProvider())) {
            this.B.setNetUseTime(0L);
        }
        if (eiVar != null) {
            this.B.setNetUseTime(eiVar.a());
        }
        this.B.setInstallHighDangerMockApp(J);
        aMapLocation.setLocationQualityReport(this.B);
        if (this.h) {
            p(aMapLocation, this.F);
            if (eiVar != null) {
                eiVar.d(m1.B());
            }
            l1.i(this.b, aMapLocation, eiVar);
            l1.h(this.b, aMapLocation);
            T(aMapLocation.m216clone());
            z73.a(this.b).c(aMapLocation);
            z73.a(this.b).d();
        }
        if (this.r) {
            return;
        }
        if (this.c.isOnceLocation()) {
            r0();
            f(14, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void o0() {
        int i = Build.VERSION.SDK_INT;
        if ((i < 29 && i >= 23 && !m1.N(this.b, "EYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19DT0FSU0VfTE9DQVRJT04=") && !m1.N(this.b, "EYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19GSU5FX0xPQ0FUSU9O")) || ((i < 31 && i >= 29 && !m1.N(this.b, "EYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19GSU5FX0xPQ0FUSU9O")) || (i >= 31 && !m1.N(this.b, "EYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19DT0FSU0VfTE9DQVRJT04=") && !m1.N(this.b, "EYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19GSU5FX0xPQ0FUSU9O")))) {
            q0();
            return;
        }
        if (this.c == null) {
            this.c = new AMapLocationClientOption();
        }
        if (this.h) {
            return;
        }
        this.h = true;
        int i2 = c.a[this.c.getLocationMode().ordinal()];
        long j = 0;
        if (i2 == 1) {
            g(1027, null, 0L);
            g(1017, null, 0L);
            g(1016, null, 0L);
        } else if (i2 == 2) {
            if (m1.f0(this.b)) {
                d(1016);
                g(1017, null, 0L);
                g(1026, null, 0L);
                return;
            }
            d(1016);
            g(1027, null, 0L);
            g(1015, null, 0L);
        } else {
            if (i2 == 3) {
                if (m1.f0(this.b)) {
                    d(1016);
                    g(1017, null, 0L);
                    g(1026, null, 0L);
                    return;
                }
                g(1027, null, 0L);
                g(1015, null, 0L);
                if (this.c.isGpsFirst() && this.c.isOnceLocation()) {
                    j = this.c.getGpsFirstTimeout();
                }
                g(1016, null, j);
            }
        }
    }

    private void p(AMapLocation aMapLocation, String str) {
        Bundle bundle = new Bundle();
        bundle.putParcelable("loc", aMapLocation);
        bundle.putString("lastLocNb", str);
        g(1014, bundle, 0L);
    }

    private void q0() {
        AMapLocation aMapLocation = new AMapLocation("");
        aMapLocation.setErrorCode(12);
        aMapLocation.setLocationDetail("定位权限被禁用,请授予应用定位权限 #1201");
        if (this.B == null) {
            this.B = new AMapLocationQualityReport();
        }
        AMapLocationQualityReport aMapLocationQualityReport = new AMapLocationQualityReport();
        this.B = aMapLocationQualityReport;
        aMapLocationQualityReport.setGpsStatus(4);
        this.B.setGPSSatellites(0);
        this.B.setLocationMode(this.c.getLocationMode());
        this.B.setWifiAble(m1.Y(this.b));
        this.B.setNetworkType(m1.Z(this.b));
        this.B.setNetUseTime(0L);
        aMapLocation.setLocationQualityReport(this.B);
        l1.p(null, 2121);
        T(aMapLocation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r0() {
        try {
            d(1025);
            h83 h83Var = this.e;
            if (h83Var != null) {
                h83Var.c();
            }
            f83 f83Var = this.f;
            if (f83Var != null) {
                f83Var.b();
            }
            d(1016);
            this.h = false;
        } catch (Throwable th) {
            j1.h(th, "ALManager", "stopLocation");
        }
    }

    private void s0() {
        eo E = E(new ej(true));
        if (n0()) {
            Bundle bundle = new Bundle();
            String str = (E == null || !(E.getLocationType() == 2 || E.getLocationType() == 4)) ? "0" : "1";
            bundle.putBundle("optBundle", j1.a(this.c));
            bundle.putString("isCacheLoc", str);
            f(0, bundle);
            if (this.h) {
                f(13, null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t0() {
        try {
            if (H || !(this.v || this.D)) {
                H = false;
                this.D = true;
                s0();
            } else {
                if (this.v && !C() && !this.C) {
                    this.C = true;
                    v0();
                }
                if (n0()) {
                    this.C = false;
                    Bundle bundle = new Bundle();
                    bundle.putBundle("optBundle", j1.a(this.c));
                    bundle.putString("d", UmidtokenInfo.getUmidtoken());
                    if (!this.e.v()) {
                        f(1, bundle);
                    }
                }
            }
        } catch (Throwable th) {
            try {
                j1.h(th, "ALManager", "doLBSLocation");
                try {
                    if (this.c.isOnceLocation()) {
                        return;
                    }
                    u0();
                } catch (Throwable unused) {
                }
            } finally {
                try {
                    if (!this.c.isOnceLocation()) {
                        u0();
                    }
                } catch (Throwable unused2) {
                }
            }
        }
    }

    private void u0() {
        if (this.c.getLocationMode() != AMapLocationClientOption.AMapLocationMode.Device_Sensors) {
            g(1016, null, this.c.getInterval() >= 1000 ? this.c.getInterval() : 1000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v0() {
        try {
            if (this.n == null) {
                this.n = new Messenger(this.d);
            }
            i(w0());
        } catch (Throwable unused) {
        }
    }

    private Intent w0() {
        String str;
        if (this.o == null) {
            this.o = new Intent(this.b, APSService.class);
        }
        try {
            str = !TextUtils.isEmpty(AMapLocationClientOption.getAPIKEY()) ? AMapLocationClientOption.getAPIKEY() : l.j(this.b);
        } catch (Throwable th) {
            j1.h(th, "ALManager", "startServiceImpl p2");
            str = "";
        }
        this.o.putExtra("a", str);
        this.o.putExtra("b", l.g(this.b));
        this.o.putExtra("d", UmidtokenInfo.getUmidtoken());
        return this.o;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x0() {
        try {
            StringBuilder sb = new StringBuilder();
            new ei().f("#2001");
            sb.append("模糊权限下不支持低功耗定位#2001");
            l1.p(null, 2153);
            eo eoVar = new eo("");
            eoVar.setErrorCode(20);
            eoVar.setLocationDetail(sb.toString());
            g0(eoVar);
        } catch (Throwable th) {
            j1.h(th, "ALManager", "apsLocation:callback");
        }
    }

    private static void y(ej ejVar) {
        try {
            ejVar.x();
            ejVar.m(new AMapLocationClientOption().setNeedAddress(false));
            ejVar.g(true, new ei());
        } catch (Throwable th) {
            j1.h(th, "ALManager", "apsLocation:doFirstNetLocate 2");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y0() {
        l1 l1Var;
        Context context;
        int i;
        this.e.u(this.c);
        this.f.q(this.c);
        if (this.h && !this.c.getLocationMode().equals(this.s)) {
            r0();
            o0();
        }
        this.s = this.c.getLocationMode();
        if (this.u != null) {
            if (this.c.isOnceLocation()) {
                l1Var = this.u;
                context = this.b;
                i = 0;
            } else {
                l1Var = this.u;
                context = this.b;
                i = 1;
            }
            l1Var.d(context, i);
            this.u.j(this.b, this.c);
        }
    }

    private void z(ej ejVar, ei eiVar) {
        try {
            ejVar.j(this.b);
            ejVar.m(this.c);
            ejVar.s(eiVar);
        } catch (Throwable th) {
            j1.h(th, "ALManager", "initApsBase");
        }
    }

    private boolean z0() {
        if (m1.c0(this.b)) {
            int i = -1;
            try {
                i = k1.f(((Application) this.b.getApplicationContext()).getBaseContext(), "checkSelfPermission", "android.permission.FOREGROUND_SERVICE");
            } catch (Throwable unused) {
            }
            if (i != 0) {
                return false;
            }
        }
        return true;
    }

    public final void B(boolean z) {
        try {
            Bundle bundle = new Bundle();
            bundle.putBoolean("j", z);
            g(1024, bundle, 0L);
        } catch (Throwable th) {
            j1.h(th, "ALManager", "disableBackgroundLocation");
        }
    }

    public final boolean C() {
        return this.g;
    }

    public final void G() {
        e eVar;
        try {
            if (this.x.getCacheCallBack() && (eVar = this.d) != null) {
                eVar.sendEmptyMessageDelayed(13, this.x.getCacheCallBackTime());
            }
        } catch (Throwable unused) {
        }
        try {
            g(1003, null, 0L);
        } catch (Throwable th) {
            j1.h(th, "ALManager", "startLocation");
        }
    }

    public final void K(AMapLocationListener aMapLocationListener) {
        try {
            g(1005, aMapLocationListener, 0L);
        } catch (Throwable th) {
            j1.h(th, "ALManager", "unRegisterLocationListener");
        }
    }

    public final void R() {
        try {
            g(1004, null, 0L);
        } catch (Throwable th) {
            j1.h(th, "ALManager", "stopLocation");
        }
    }

    public final void W() {
        try {
            i iVar = this.y;
            if (iVar != null) {
                iVar.h();
                this.y = null;
            }
            g(1011, null, 0L);
            this.r = true;
        } catch (Throwable th) {
            j1.h(th, "ALManager", "onDestroy");
        }
    }

    public final AMapLocation c0() {
        AMapLocation aMapLocation = null;
        try {
            n1 n1Var = this.l;
            if (n1Var != null && (aMapLocation = n1Var.d()) != null) {
                aMapLocation.setTrustedLevel(3);
            }
        } catch (Throwable th) {
            j1.h(th, "ALManager", "getLastKnownLocation");
        }
        return aMapLocation;
    }

    public final void e(int i, Notification notification) {
        if (i == 0 || notification == null) {
            return;
        }
        try {
            Bundle bundle = new Bundle();
            bundle.putInt("i", i);
            bundle.putParcelable("h", notification);
            g(1023, bundle, 0L);
        } catch (Throwable th) {
            j1.h(th, "ALManager", "disableBackgroundLocation");
        }
    }

    public final void f0() {
        try {
            i iVar = this.y;
            if (iVar != null) {
                iVar.h();
                this.y = null;
            }
        } catch (Throwable th) {
            j1.h(th, "ALManager", "stopAssistantLocation");
        }
    }

    final void i0() {
        f(12, null);
        this.j = true;
        this.k = true;
        this.g = false;
        this.v = false;
        r0();
        l1 l1Var = this.u;
        if (l1Var != null) {
            l1Var.u(this.b);
        }
        z73.a(this.b).b();
        l1.c(this.b);
        com.loc.e eVar = this.w;
        if (eVar != null) {
            eVar.s().sendEmptyMessage(11);
        } else {
            ServiceConnection serviceConnection = this.A;
            if (serviceConnection != null) {
                this.b.unbindService(serviceConnection);
            }
        }
        try {
            if (this.G) {
                this.b.stopService(w0());
            }
        } catch (Throwable unused) {
        }
        this.G = false;
        ArrayList<AMapLocationListener> arrayList = this.i;
        if (arrayList != null) {
            arrayList.clear();
            this.i = null;
        }
        this.A = null;
        k0();
        b bVar = this.q;
        if (bVar != null) {
            if (Build.VERSION.SDK_INT >= 18) {
                try {
                    k1.b(bVar, HandlerThread.class, "quitSafely", new Object[0]);
                } catch (Throwable unused2) {
                    this.q.quit();
                }
            } else {
                bVar.quit();
            }
        }
        this.q = null;
        e eVar2 = this.d;
        if (eVar2 != null) {
            eVar2.removeCallbacksAndMessages(null);
        }
        n1 n1Var = this.l;
        if (n1Var != null) {
            n1Var.e();
            this.l = null;
        }
    }

    public final void m(WebView webView) {
        if (this.y == null) {
            this.y = new i(this.b, webView);
        }
        this.y.c();
    }

    public final void q(AMapLocationClientOption aMapLocationClientOption) {
        try {
            this.x = aMapLocationClientOption.m217clone();
            g(1018, aMapLocationClientOption.m217clone(), 0L);
        } catch (Throwable th) {
            j1.h(th, "ALManager", "setLocationOption");
        }
    }

    public final void r(AMapLocationListener aMapLocationListener) {
        try {
            g(1002, aMapLocationListener, 0L);
        } catch (Throwable th) {
            j1.h(th, "ALManager", "setLocationListener");
        }
    }
}
