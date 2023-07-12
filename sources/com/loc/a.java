package com.loc;

import android.annotation.SuppressLint;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import com.alibaba.security.biometrics.activity.BaseBioNavigatorActivity;
import com.amap.api.fence.GeoFence;
import com.amap.api.fence.GeoFenceListener;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.amap.api.location.DPoint;
import com.taobao.dp.http.ResCode;
import com.taobao.weex.common.Constants;
import com.youku.playerservice.axp.utils.Utils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import tb.g43;
import tb.tx0;

/* compiled from: Taobao */
@SuppressLint({"NewApi"})
/* loaded from: classes10.dex */
public final class a {
    private static boolean z;
    Context b;
    l1 a = null;
    PendingIntent c = null;
    String d = null;
    GeoFenceListener e = null;
    private Object f = new Object();
    volatile int g = 1;
    ArrayList<GeoFence> h = new ArrayList<>();
    d i = null;
    Object j = new Object();
    Object k = new Object();
    c l = null;
    b m = null;
    volatile boolean n = false;
    volatile boolean o = false;
    volatile boolean p = false;
    g43 q = null;
    l0 r = null;
    AMapLocationClient s = null;
    volatile AMapLocation t = null;
    long u = 0;
    AMapLocationClientOption v = null;
    int w = 0;
    AMapLocationListener x = new C0254a();
    volatile boolean y = false;

    /* compiled from: Taobao */
    /* renamed from: com.loc.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    final class C0254a implements AMapLocationListener {
        C0254a() {
        }

        @Override // com.amap.api.location.AMapLocationListener
        public final void onLocationChanged(AMapLocation aMapLocation) {
            boolean z;
            int i;
            try {
                if (!a.this.y && a.this.p) {
                    a.this.t = aMapLocation;
                    if (aMapLocation != null) {
                        i = aMapLocation.getErrorCode();
                        if (aMapLocation.getErrorCode() == 0) {
                            a.this.u = m1.B();
                            a.this.j(5, null, 0L);
                            z = true;
                        } else {
                            int errorCode = aMapLocation.getErrorCode();
                            String errorInfo = aMapLocation.getErrorInfo();
                            a.o("定位失败", errorCode, errorInfo, "locationDetail:" + aMapLocation.getLocationDetail());
                            z = false;
                        }
                    } else {
                        z = false;
                        i = 8;
                    }
                    if (z) {
                        a aVar = a.this;
                        aVar.w = 0;
                        aVar.j(6, null, 0L);
                        return;
                    }
                    Bundle bundle = new Bundle();
                    if (!a.this.n) {
                        a.this.C(7);
                        bundle.putLong(Constants.Name.INTERVAL, 2000L);
                        a.this.j(8, bundle, 2000L);
                    }
                    a aVar2 = a.this;
                    int i2 = aVar2.w + 1;
                    aVar2.w = i2;
                    if (i2 >= 3) {
                        bundle.putInt(GeoFence.BUNDLE_KEY_LOCERRORCODE, i);
                        a.this.i(1002, bundle);
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public static class b extends HandlerThread {
        public b(String str) {
            super(str);
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
    public class c extends Handler {
        public c(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            try {
                switch (message.what) {
                    case 0:
                        a.this.E(message.getData());
                        return;
                    case 1:
                        a.this.L(message.getData());
                        return;
                    case 2:
                        a.this.R(message.getData());
                        return;
                    case 3:
                        a.this.O(message.getData());
                        return;
                    case 4:
                        a.this.T(message.getData());
                        return;
                    case 5:
                        a.this.Q();
                        return;
                    case 6:
                        a aVar = a.this;
                        aVar.m(aVar.t);
                        return;
                    case 7:
                        a.this.N();
                        return;
                    case 8:
                        a.this.b0(message.getData());
                        return;
                    case 9:
                        a.this.k(message.getData());
                        return;
                    case 10:
                        a.this.J();
                        return;
                    case 11:
                        a.this.X(message.getData());
                        return;
                    case 12:
                        a.this.V(message.getData());
                        return;
                    case 13:
                        a.this.U();
                        return;
                    default:
                        return;
                }
            } catch (Throwable unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public class d extends Handler {
        public d() {
        }

        public d(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            try {
                Bundle data = message.getData();
                switch (message.what) {
                    case 1000:
                        a.this.Y(data);
                        return;
                    case 1001:
                        a.this.F((GeoFence) data.getParcelable("geoFence"));
                        return;
                    case 1002:
                        a.this.K(data.getInt(GeoFence.BUNDLE_KEY_LOCERRORCODE));
                        return;
                    default:
                        return;
                }
            } catch (Throwable unused) {
            }
        }
    }

    public a(Context context) {
        this.b = null;
        try {
            this.b = context.getApplicationContext();
            a0();
        } catch (Throwable th) {
            j1.h(th, "GeoFenceManger", "<init>");
        }
    }

    private static DPoint A(List<DPoint> list) {
        DPoint dPoint = new DPoint();
        if (list != null) {
            try {
                double d2 = 0.0d;
                double d3 = 0.0d;
                for (DPoint dPoint2 : list) {
                    d2 += dPoint2.getLatitude();
                    d3 += dPoint2.getLongitude();
                }
                return new DPoint(m1.z(d2 / list.size()), m1.z(d3 / list.size()));
            } catch (Throwable th) {
                j1.h(th, "GeoFenceUtil", "getPolygonCenter");
                return dPoint;
            }
        }
        return dPoint;
    }

    private void D(int i, Bundle bundle) {
        String str;
        int i2;
        String str2;
        int i3;
        String str3;
        String str4;
        String b2;
        Bundle bundle2 = new Bundle();
        try {
            ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
            if (bundle == null || bundle.isEmpty()) {
                str2 = "errorCode";
                i3 = 1;
            } else {
                List<GeoFence> arrayList2 = new ArrayList<>();
                String string = bundle.getString(GeoFence.BUNDLE_KEY_CUSTOMID);
                String string2 = bundle.getString("keyWords");
                String string3 = bundle.getString("city");
                String string4 = bundle.getString("poiType");
                DPoint dPoint = (DPoint) bundle.getParcelable("centerPoint");
                int i4 = bundle.getInt("searchSize", 10);
                float f = bundle.getFloat("aroundRadius", 3000.0f);
                if (u(i, string2, string4, dPoint)) {
                    Bundle bundle3 = new Bundle();
                    bundle3.putString(GeoFence.BUNDLE_KEY_CUSTOMID, string);
                    bundle3.putString("pendingIntentAction", this.d);
                    str3 = GeoFence.BUNDLE_KEY_CUSTOMID;
                    str4 = "errorCode";
                    try {
                        bundle3.putLong("expiration", -1L);
                        bundle3.putInt("activatesAction", this.g);
                        if (i == 1) {
                            bundle3.putFloat("fenceRadius", 1000.0f);
                            b2 = this.q.b(this.b, "http://restsdk.amap.com/v3/place/text?", string2, string4, string3, String.valueOf(i4));
                        } else if (i != 2) {
                            b2 = i != 3 ? null : this.q.a(this.b, "http://restsdk.amap.com/v3/config/district?", string2);
                        } else {
                            double z2 = m1.z(dPoint.getLatitude());
                            double z3 = m1.z(dPoint.getLongitude());
                            int intValue = Float.valueOf(f).intValue();
                            bundle3.putFloat("fenceRadius", 200.0f);
                            b2 = this.q.c(this.b, "http://restsdk.amap.com/v3/place/around?", string2, string4, String.valueOf(i4), String.valueOf(z2), String.valueOf(z3), String.valueOf(intValue));
                        }
                        if (b2 != null) {
                            int b3 = 1 == i ? l0.b(b2, arrayList2, bundle3) : 0;
                            if (2 == i) {
                                b3 = l0.e(b2, arrayList2, bundle3);
                            }
                            if (3 == i) {
                                b3 = this.r.f(b2, arrayList2, bundle3);
                            }
                            if (b3 != 10000) {
                                i2 = M(b3);
                            } else if (arrayList2.isEmpty()) {
                                i2 = 16;
                            } else {
                                i2 = c(arrayList2);
                                if (i2 == 0) {
                                    try {
                                        arrayList.addAll(arrayList2);
                                    } catch (Throwable th) {
                                        th = th;
                                        str = str4;
                                        try {
                                            j1.h(th, "GeoFenceManager", "doAddGeoFenceNearby");
                                            bundle2.putInt(str, 8);
                                            i(1000, bundle2);
                                            return;
                                        } catch (Throwable th2) {
                                            bundle2.putInt(str, i2);
                                            i(1000, bundle2);
                                            throw th2;
                                        }
                                    }
                                }
                            }
                        } else {
                            i2 = 4;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        str = str4;
                        i2 = 0;
                        j1.h(th, "GeoFenceManager", "doAddGeoFenceNearby");
                        bundle2.putInt(str, 8);
                        i(1000, bundle2);
                        return;
                    }
                } else {
                    str3 = GeoFence.BUNDLE_KEY_CUSTOMID;
                    str4 = "errorCode";
                    i2 = 1;
                }
                bundle2.putString(str3, string);
                bundle2.putParcelableArrayList("resultList", arrayList);
                i3 = i2;
                str2 = str4;
            }
            bundle2.putInt(str2, i3);
            i(1000, bundle2);
        } catch (Throwable th4) {
            th = th4;
            str = "errorCode";
        }
    }

    private static boolean G(AMapLocation aMapLocation, GeoFence geoFence) {
        boolean z2 = true;
        try {
            if (!x(aMapLocation, geoFence)) {
                if (geoFence.getStatus() != 2) {
                    try {
                        geoFence.setStatus(2);
                        geoFence.setEnterTime(-1L);
                    } catch (Throwable th) {
                        th = th;
                        j1.h(th, Utils.TAG, "isFenceStatusChanged");
                        return z2;
                    }
                }
                z2 = false;
            } else if (geoFence.getEnterTime() == -1) {
                if (geoFence.getStatus() != 1) {
                    geoFence.setEnterTime(m1.B());
                    geoFence.setStatus(1);
                }
                z2 = false;
            } else {
                if (geoFence.getStatus() != 3 && m1.B() - geoFence.getEnterTime() > 600000) {
                    geoFence.setStatus(3);
                }
                z2 = false;
            }
        } catch (Throwable th2) {
            th = th2;
            z2 = false;
        }
        return z2;
    }

    private static boolean H(AMapLocation aMapLocation, List<DPoint> list) {
        if (list.size() < 3) {
            return false;
        }
        return j1.l(new DPoint(aMapLocation.getLatitude(), aMapLocation.getLongitude()), list);
    }

    private int I(GeoFence geoFence) {
        try {
            if (this.h == null) {
                this.h = new ArrayList<>();
            }
            if (this.h.contains(geoFence)) {
                return 17;
            }
            this.h.add(geoFence);
            return 0;
        } catch (Throwable th) {
            j1.h(th, "GeoFenceManager", "addGeoFence2List");
            o("添加围栏失败", 8, th.getMessage(), new String[0]);
            return 8;
        }
    }

    private static int M(int i) {
        if (i != 1 && i != 7 && i != 4 && i != 5 && i != 16 && i != 17) {
            switch (i) {
                case 10000:
                    i = 0;
                    break;
                case 10001:
                case 10002:
                case ResCode.ENVIRONMENT_CHANGED /* 10007 */:
                case 10008:
                case 10009:
                case 10012:
                case 10013:
                    i = 7;
                    break;
                case 10003:
                case 10004:
                case 10005:
                case 10006:
                case 10010:
                case 10011:
                case 10014:
                case 10015:
                case 10016:
                case 10017:
                    i = 4;
                    break;
                default:
                    switch (i) {
                        case 20000:
                        case 20001:
                        case BaseBioNavigatorActivity.n /* 20002 */:
                            i = 1;
                            break;
                        case BaseBioNavigatorActivity.o /* 20003 */:
                        default:
                            i = 8;
                            break;
                    }
            }
        }
        if (i != 0) {
            o("添加围栏失败", i, "searchErrCode is ".concat(String.valueOf(i)), new String[0]);
        }
        return i;
    }

    private void P(GeoFence geoFence) {
        Bundle bundle = new Bundle();
        bundle.putParcelable("geoFence", geoFence);
        i(1001, bundle);
    }

    private static float a(AMapLocation aMapLocation, List<GeoFence> list) {
        float f = Float.MAX_VALUE;
        if (aMapLocation != null && aMapLocation.getErrorCode() == 0 && list != null && !list.isEmpty()) {
            DPoint dPoint = new DPoint(aMapLocation.getLatitude(), aMapLocation.getLongitude());
            for (GeoFence geoFence : list) {
                if (geoFence.isAble()) {
                    float d2 = m1.d(dPoint, geoFence.getCenter());
                    if (d2 > geoFence.getMinDis2Center() && d2 < geoFence.getMaxDis2Center()) {
                        return 0.0f;
                    }
                    if (d2 > geoFence.getMaxDis2Center()) {
                        f = Math.min(f, d2 - geoFence.getMaxDis2Center());
                    }
                    if (d2 < geoFence.getMinDis2Center()) {
                        f = Math.min(f, geoFence.getMinDis2Center() - d2);
                    }
                }
            }
        }
        return f;
    }

    private void a0() {
        if (!this.p) {
            this.p = true;
        }
        if (this.o) {
            return;
        }
        try {
            this.i = Looper.myLooper() == null ? new d(this.b.getMainLooper()) : new d();
        } catch (Throwable th) {
            j1.h(th, "GeoFenceManger", "init 1");
        }
        try {
            b bVar = new b("fenceActionThread");
            this.m = bVar;
            bVar.setPriority(5);
            this.m.start();
            this.l = new c(this.m.getLooper());
        } catch (Throwable th2) {
            j1.h(th2, "GeoFenceManger", "init 2");
        }
        try {
            this.q = new g43(this.b);
            this.r = new l0();
            this.v = new AMapLocationClientOption();
            this.s = new AMapLocationClient(this.b);
            this.v.setLocationCacheEnable(true);
            this.v.setNeedAddress(false);
            this.s.setLocationListener(this.x);
            if (this.a == null) {
                this.a = new l1();
            }
        } catch (Throwable th3) {
            j1.h(th3, "GeoFenceManger", "initBase");
        }
        this.o = true;
        try {
            String str = this.d;
            if (str != null && this.c == null) {
                d(str);
            }
        } catch (Throwable th4) {
            j1.h(th4, "GeoFenceManger", "init 4");
        }
        if (z) {
            return;
        }
        z = true;
        l1.n(this.b, "O020", null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static float b(DPoint dPoint, List<DPoint> list) {
        float f = Float.MAX_VALUE;
        if (dPoint != null && list != null && !list.isEmpty()) {
            for (DPoint dPoint2 : list) {
                f = Math.min(f, m1.d(dPoint, dPoint2));
            }
        }
        return f;
    }

    private int c(List<GeoFence> list) {
        try {
            if (this.h == null) {
                this.h = new ArrayList<>();
            }
            for (GeoFence geoFence : list) {
                I(geoFence);
            }
            return 0;
        } catch (Throwable th) {
            j1.h(th, "GeoFenceManager", "addGeoFenceList");
            o("添加围栏失败", 8, th.getMessage(), new String[0]);
            return 8;
        }
    }

    private boolean c0() {
        ArrayList<GeoFence> arrayList = this.h;
        if (arrayList == null || arrayList.isEmpty()) {
            return true;
        }
        Iterator<GeoFence> it = this.h.iterator();
        while (it.hasNext()) {
            if (it.next().isAble()) {
                return false;
            }
        }
        return true;
    }

    private void d0() {
        try {
            synchronized (this.k) {
                d dVar = this.i;
                if (dVar != null) {
                    dVar.removeCallbacksAndMessages(null);
                }
                this.i = null;
            }
        } catch (Throwable th) {
            j1.h(th, "GeoFenceManager", "destroyResultHandler");
        }
    }

    private static Bundle e(GeoFence geoFence, String str, String str2, int i, int i2) {
        Bundle bundle = new Bundle();
        if (str == null) {
            str = "";
        }
        bundle.putString(GeoFence.BUNDLE_KEY_FENCEID, str);
        bundle.putString(GeoFence.BUNDLE_KEY_CUSTOMID, str2);
        bundle.putInt("event", i);
        bundle.putInt(GeoFence.BUNDLE_KEY_LOCERRORCODE, i2);
        bundle.putParcelable(GeoFence.BUNDLE_KEY_FENCE, geoFence);
        return bundle;
    }

    private void e0() {
        try {
            synchronized (this.j) {
                c cVar = this.l;
                if (cVar != null) {
                    cVar.removeCallbacksAndMessages(null);
                }
                this.l = null;
            }
        } catch (Throwable th) {
            j1.h(th, "GeoFenceManager", "destroyActionHandler");
        }
    }

    private GeoFence f(Bundle bundle, boolean z2) {
        GeoFence geoFence = new GeoFence();
        ArrayList arrayList = new ArrayList();
        DPoint dPoint = new DPoint();
        if (z2) {
            geoFence.setType(1);
            arrayList = bundle.getParcelableArrayList("pointList");
            if (arrayList != null) {
                dPoint = A(arrayList);
            }
            geoFence.setMaxDis2Center(z(dPoint, arrayList));
            geoFence.setMinDis2Center(b(dPoint, arrayList));
        } else {
            geoFence.setType(0);
            dPoint = (DPoint) bundle.getParcelable("centerPoint");
            if (dPoint != null) {
                arrayList.add(dPoint);
            }
            float f = bundle.getFloat("fenceRadius", 1000.0f);
            float f2 = f > 0.0f ? f : 1000.0f;
            geoFence.setRadius(f2);
            geoFence.setMinDis2Center(f2);
            geoFence.setMaxDis2Center(f2);
        }
        geoFence.setActivatesAction(this.g);
        geoFence.setCustomId(bundle.getString(GeoFence.BUNDLE_KEY_CUSTOMID));
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(arrayList);
        geoFence.setPointList(arrayList2);
        geoFence.setCenter(dPoint);
        geoFence.setPendingIntentAction(this.d);
        geoFence.setExpiration(-1L);
        geoFence.setPendingIntent(this.c);
        StringBuilder sb = new StringBuilder();
        sb.append(l0.c());
        geoFence.setFenceId(sb.toString());
        l1 l1Var = this.a;
        if (l1Var != null) {
            l1Var.d(this.b, 2);
        }
        return geoFence;
    }

    private void f0() {
        if (this.y || this.l == null) {
            return;
        }
        if (h0()) {
            j(6, null, 0L);
            j(5, null, 0L);
            return;
        }
        C(7);
        j(7, null, 0L);
    }

    private void g0() {
        try {
            if (this.n) {
                C(8);
            }
            AMapLocationClient aMapLocationClient = this.s;
            if (aMapLocationClient != null) {
                aMapLocationClient.stopLocation();
            }
            this.n = false;
        } catch (Throwable unused) {
        }
    }

    private boolean h0() {
        return this.t != null && m1.q(this.t) && m1.B() - this.u < 10000;
    }

    static void o(String str, int i, String str2, String... strArr) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("===========================================\n");
        stringBuffer.append("              " + str + "                ");
        stringBuffer.append(StringUtils.LF);
        stringBuffer.append("-------------------------------------------\n");
        stringBuffer.append("errorCode:".concat(String.valueOf(i)));
        stringBuffer.append(StringUtils.LF);
        stringBuffer.append("错误信息:".concat(String.valueOf(str2)));
        stringBuffer.append(StringUtils.LF);
        if (strArr.length > 0) {
            for (String str3 : strArr) {
                stringBuffer.append(str3);
                stringBuffer.append(StringUtils.LF);
            }
        }
        stringBuffer.append("===========================================\n");
        Log.i("fenceErrLog", stringBuffer.toString());
    }

    private static boolean u(int i, String str, String str2, DPoint dPoint) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (i != 1) {
            if (i == 2) {
                if (dPoint == null) {
                    return false;
                }
                if (dPoint.getLatitude() > 90.0d || dPoint.getLatitude() < -90.0d || dPoint.getLongitude() > 180.0d || dPoint.getLongitude() < -180.0d) {
                    o("添加围栏失败", 0, "经纬度错误，传入的纬度：" + dPoint.getLatitude() + "传入的经度:" + dPoint.getLongitude(), new String[0]);
                    return false;
                }
            }
        } else if (TextUtils.isEmpty(str2)) {
            return false;
        }
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0025, code lost:
        if (r4.getStatus() == 3) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean w(com.amap.api.fence.GeoFence r4, int r5) {
        /*
            r0 = r5 & 1
            r1 = 1
            r2 = 0
            if (r0 != r1) goto L10
            int r0 = r4.getStatus()     // Catch: java.lang.Throwable -> Le
            if (r0 != r1) goto L10
            r2 = 1
            goto L10
        Le:
            r4 = move-exception
            goto L28
        L10:
            r0 = r5 & 2
            r3 = 2
            if (r0 != r3) goto L1c
            int r0 = r4.getStatus()     // Catch: java.lang.Throwable -> Le
            if (r0 != r3) goto L1c
            r2 = 1
        L1c:
            r0 = 4
            r5 = r5 & r0
            if (r5 != r0) goto L30
            int r4 = r4.getStatus()     // Catch: java.lang.Throwable -> Le
            r5 = 3
            if (r4 != r5) goto L30
            goto L31
        L28:
            java.lang.String r5 = "Utils"
            java.lang.String r0 = "remindStatus"
            com.loc.j1.h(r4, r5, r0)
            goto L32
        L30:
            r1 = r2
        L31:
            r2 = r1
        L32:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loc.a.w(com.amap.api.fence.GeoFence, int):boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x0056, code lost:
        if (y(r4, r5.getCenter(), r5.getRadius()) != false) goto L31;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean x(com.amap.api.location.AMapLocation r4, com.amap.api.fence.GeoFence r5) {
        /*
            r0 = 1
            r1 = 0
            boolean r2 = com.loc.m1.q(r4)     // Catch: java.lang.Throwable -> L5b
            if (r2 == 0) goto L59
            if (r5 == 0) goto L59
            java.util.List r2 = r5.getPointList()     // Catch: java.lang.Throwable -> L5b
            if (r2 == 0) goto L59
            java.util.List r2 = r5.getPointList()     // Catch: java.lang.Throwable -> L5b
            boolean r2 = r2.isEmpty()     // Catch: java.lang.Throwable -> L5b
            if (r2 != 0) goto L59
            int r2 = r5.getType()     // Catch: java.lang.Throwable -> L5b
            if (r2 == 0) goto L4a
            if (r2 == r0) goto L29
            r3 = 2
            if (r2 == r3) goto L4a
            r3 = 3
            if (r2 == r3) goto L29
            goto L59
        L29:
            java.util.List r5 = r5.getPointList()     // Catch: java.lang.Throwable -> L5b
            java.util.Iterator r5 = r5.iterator()     // Catch: java.lang.Throwable -> L5b
        L31:
            boolean r2 = r5.hasNext()     // Catch: java.lang.Throwable -> L47
            if (r2 == 0) goto L45
            java.lang.Object r2 = r5.next()     // Catch: java.lang.Throwable -> L47
            java.util.List r2 = (java.util.List) r2     // Catch: java.lang.Throwable -> L47
            boolean r2 = H(r4, r2)     // Catch: java.lang.Throwable -> L47
            if (r2 == 0) goto L31
            r1 = 1
            goto L31
        L45:
            r0 = r1
            goto L64
        L47:
            r4 = move-exception
            r0 = r1
            goto L5d
        L4a:
            com.amap.api.location.DPoint r2 = r5.getCenter()     // Catch: java.lang.Throwable -> L5b
            float r5 = r5.getRadius()     // Catch: java.lang.Throwable -> L5b
            boolean r4 = y(r4, r2, r5)     // Catch: java.lang.Throwable -> L5b
            if (r4 == 0) goto L59
            goto L64
        L59:
            r0 = 0
            goto L64
        L5b:
            r4 = move-exception
            r0 = 0
        L5d:
            java.lang.String r5 = "Utils"
            java.lang.String r1 = "isInGeoFence"
            com.loc.j1.h(r4, r5, r1)
        L64:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loc.a.x(com.amap.api.location.AMapLocation, com.amap.api.fence.GeoFence):boolean");
    }

    private static boolean y(AMapLocation aMapLocation, DPoint dPoint, float f) {
        return m1.e(new double[]{dPoint.getLatitude(), dPoint.getLongitude(), aMapLocation.getLatitude(), aMapLocation.getLongitude()}) <= f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static float z(DPoint dPoint, List<DPoint> list) {
        float f = Float.MIN_VALUE;
        if (dPoint != null && list != null && !list.isEmpty()) {
            for (DPoint dPoint2 : list) {
                f = Math.max(f, m1.d(dPoint, dPoint2));
            }
        }
        return f;
    }

    public final List<GeoFence> B() {
        try {
            if (this.h == null) {
                this.h = new ArrayList<>();
            }
            return (ArrayList) this.h.clone();
        } catch (Throwable unused) {
            return new ArrayList();
        }
    }

    final void C(int i) {
        try {
            synchronized (this.j) {
                c cVar = this.l;
                if (cVar != null) {
                    cVar.removeMessages(i);
                }
            }
        } catch (Throwable th) {
            j1.h(th, "GeoFenceManager", "removeActionHandlerMessage");
        }
    }

    final void E(Bundle bundle) {
        String str;
        try {
            ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
            String str2 = "";
            int i = 1;
            if (bundle != null && !bundle.isEmpty()) {
                DPoint dPoint = (DPoint) bundle.getParcelable("centerPoint");
                str = bundle.getString(GeoFence.BUNDLE_KEY_CUSTOMID);
                if (dPoint != null) {
                    if (dPoint.getLatitude() <= 90.0d && dPoint.getLatitude() >= -90.0d && dPoint.getLongitude() <= 180.0d && dPoint.getLongitude() >= -180.0d) {
                        GeoFence f = f(bundle, false);
                        i = I(f);
                        if (i == 0) {
                            arrayList.add(f);
                        }
                        Bundle bundle2 = new Bundle();
                        bundle2.putInt("errorCode", i);
                        bundle2.putParcelableArrayList("resultList", arrayList);
                        bundle2.putString(GeoFence.BUNDLE_KEY_CUSTOMID, str);
                        i(1000, bundle2);
                    }
                    o("添加围栏失败", 1, "经纬度错误，传入的纬度：" + dPoint.getLatitude() + "传入的经度:" + dPoint.getLongitude(), new String[0]);
                    Bundle bundle22 = new Bundle();
                    bundle22.putInt("errorCode", i);
                    bundle22.putParcelableArrayList("resultList", arrayList);
                    bundle22.putString(GeoFence.BUNDLE_KEY_CUSTOMID, str);
                    i(1000, bundle22);
                }
                str2 = str;
            }
            str = str2;
            Bundle bundle222 = new Bundle();
            bundle222.putInt("errorCode", i);
            bundle222.putParcelableArrayList("resultList", arrayList);
            bundle222.putString(GeoFence.BUNDLE_KEY_CUSTOMID, str);
            i(1000, bundle222);
        } catch (Throwable th) {
            j1.h(th, "GeoFenceManager", "doAddGeoFenceRound");
        }
    }

    final void F(GeoFence geoFence) {
        PendingIntent pendingIntent;
        Context context;
        try {
            synchronized (this.f) {
                if (this.b != null) {
                    if (this.c == null && geoFence.getPendingIntent() == null) {
                        return;
                    }
                    Intent intent = new Intent();
                    intent.putExtras(e(geoFence, geoFence.getFenceId(), geoFence.getCustomId(), geoFence.getStatus(), 0));
                    String str = this.d;
                    if (str != null) {
                        intent.setAction(str);
                    }
                    intent.setPackage(l.g(this.b));
                    if (geoFence.getPendingIntent() != null) {
                        pendingIntent = geoFence.getPendingIntent();
                        context = this.b;
                    } else {
                        pendingIntent = this.c;
                        context = this.b;
                    }
                    pendingIntent.send(context, 0, intent);
                }
            }
        } catch (Throwable th) {
            j1.h(th, "GeoFenceManager", "resultTriggerGeoFence");
        }
    }

    final void J() {
        if (this.o) {
            ArrayList<GeoFence> arrayList = this.h;
            if (arrayList != null) {
                arrayList.clear();
                this.h = null;
            }
            if (this.p) {
                return;
            }
            e0();
            AMapLocationClient aMapLocationClient = this.s;
            if (aMapLocationClient != null) {
                aMapLocationClient.stopLocation();
                this.s.onDestroy();
            }
            this.s = null;
            b bVar = this.m;
            if (bVar != null) {
                if (Build.VERSION.SDK_INT >= 18) {
                    bVar.quitSafely();
                } else {
                    bVar.quit();
                }
            }
            this.m = null;
            this.q = null;
            synchronized (this.f) {
                PendingIntent pendingIntent = this.c;
                if (pendingIntent != null) {
                    pendingIntent.cancel();
                }
                this.c = null;
            }
            d0();
            l1 l1Var = this.a;
            if (l1Var != null) {
                l1Var.u(this.b);
            }
            this.n = false;
            this.o = false;
        }
    }

    final void K(int i) {
        try {
            if (this.b != null) {
                synchronized (this.f) {
                    if (this.c == null) {
                        return;
                    }
                    Intent intent = new Intent();
                    intent.putExtras(e(null, null, null, 4, i));
                    this.c.send(this.b, 0, intent);
                }
            }
        } catch (Throwable th) {
            j1.h(th, "GeoFenceManager", "resultRemindLocationError");
        }
    }

    final void L(Bundle bundle) {
        GeoFence f;
        try {
            ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
            String str = "";
            int i = 1;
            if (bundle != null && !bundle.isEmpty()) {
                ArrayList parcelableArrayList = bundle.getParcelableArrayList("pointList");
                String string = bundle.getString(GeoFence.BUNDLE_KEY_CUSTOMID);
                if (parcelableArrayList != null && parcelableArrayList.size() > 2 && (i = I((f = f(bundle, true)))) == 0) {
                    arrayList.add(f);
                }
                str = string;
            }
            Bundle bundle2 = new Bundle();
            bundle2.putString(GeoFence.BUNDLE_KEY_CUSTOMID, str);
            bundle2.putInt("errorCode", i);
            bundle2.putParcelableArrayList("resultList", arrayList);
            i(1000, bundle2);
        } catch (Throwable th) {
            j1.h(th, "GeoFenceManager", "doAddGeoFencePolygon");
        }
    }

    final void N() {
        try {
            if (this.s != null) {
                g0();
                this.v.setOnceLocation(true);
                this.s.setLocationOption(this.v);
                this.s.startLocation();
            }
        } catch (Throwable th) {
            j1.h(th, "GeoFenceManager", "doStartOnceLocation");
        }
    }

    final void O(Bundle bundle) {
        D(2, bundle);
    }

    final void Q() {
        try {
            if (!this.y && m1.q(this.t)) {
                float a = a(this.t, this.h);
                if (a == Float.MAX_VALUE) {
                    return;
                }
                if (a < 1000.0f) {
                    C(7);
                    Bundle bundle = new Bundle();
                    bundle.putLong(Constants.Name.INTERVAL, 2000L);
                    j(8, bundle, 500L);
                } else if (a < 5000.0f) {
                    g0();
                    C(7);
                    j(7, null, 10000L);
                } else {
                    g0();
                    C(7);
                    j(7, null, ((a - 4000.0f) / 100.0f) * 1000.0f);
                }
            }
        } catch (Throwable th) {
            j1.h(th, "GeoFenceManager", "doCheckLocationPolicy");
        }
    }

    final void R(Bundle bundle) {
        D(1, bundle);
    }

    public final void S() {
        try {
            a0();
            this.y = true;
            j(13, null, 0L);
        } catch (Throwable th) {
            j1.h(th, "GeoFenceManager", "pauseGeoFence");
        }
    }

    final void T(Bundle bundle) {
        D(3, bundle);
    }

    final void U() {
        try {
            C(7);
            C(8);
            AMapLocationClient aMapLocationClient = this.s;
            if (aMapLocationClient != null) {
                aMapLocationClient.stopLocation();
            }
            this.n = false;
        } catch (Throwable th) {
            j1.h(th, "GeoFenceManager", "doPauseGeoFence");
        }
    }

    final void V(Bundle bundle) {
        if (bundle != null) {
            try {
                if (bundle.isEmpty()) {
                    return;
                }
                String string = bundle.getString("fid");
                if (TextUtils.isEmpty(string)) {
                    return;
                }
                boolean z2 = bundle.getBoolean(tx0.VALUE_MODEL_DEFAULT, true);
                ArrayList<GeoFence> arrayList = this.h;
                if (arrayList != null && !arrayList.isEmpty()) {
                    Iterator<GeoFence> it = this.h.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        GeoFence next = it.next();
                        if (next.getFenceId().equals(string)) {
                            next.setAble(z2);
                            break;
                        }
                    }
                }
                if (z2) {
                    f0();
                } else if (c0()) {
                    U();
                }
            } catch (Throwable th) {
                j1.h(th, "GeoFenceManager", "doSetGeoFenceAble");
            }
        }
    }

    public final void W() {
        try {
            a0();
            if (this.y) {
                this.y = false;
                f0();
            }
        } catch (Throwable th) {
            j1.h(th, "GeoFenceManager", "resumeGeoFence");
        }
    }

    final void X(Bundle bundle) {
        try {
            if (this.h != null) {
                GeoFence geoFence = (GeoFence) bundle.getParcelable("fc");
                if (this.h.contains(geoFence)) {
                    this.h.remove(geoFence);
                }
                if (this.h.size() <= 0) {
                    J();
                } else {
                    f0();
                }
            }
        } catch (Throwable unused) {
        }
    }

    final void Y(Bundle bundle) {
        if (bundle != null) {
            try {
                if (bundle.isEmpty()) {
                    return;
                }
                int i = bundle.getInt("errorCode");
                ArrayList parcelableArrayList = bundle.getParcelableArrayList("resultList");
                if (parcelableArrayList == null) {
                    parcelableArrayList = new ArrayList();
                }
                String string = bundle.getString(GeoFence.BUNDLE_KEY_CUSTOMID);
                if (string == null) {
                    string = "";
                }
                GeoFenceListener geoFenceListener = this.e;
                if (geoFenceListener != null) {
                    geoFenceListener.onGeoFenceCreateFinished((ArrayList) parcelableArrayList.clone(), i, string);
                }
                if (i == 0) {
                    f0();
                }
            } catch (Throwable th) {
                j1.h(th, "GeoFenceManager", "resultAddGeoFenceFinished");
            }
        }
    }

    public final boolean Z() {
        return this.y;
    }

    final void b0(Bundle bundle) {
        try {
            if (this.s != null) {
                long j = 2000;
                if (bundle != null && !bundle.isEmpty()) {
                    j = bundle.getLong(Constants.Name.INTERVAL, 2000L);
                }
                this.v.setOnceLocation(false);
                this.v.setInterval(j);
                this.s.setLocationOption(this.v);
                if (this.n) {
                    return;
                }
                this.s.stopLocation();
                this.s.startLocation();
                this.n = true;
            }
        } catch (Throwable th) {
            j1.h(th, "GeoFenceManager", "doStartContinueLocation");
        }
    }

    public final PendingIntent d(String str) {
        synchronized (this.f) {
            try {
                Intent intent = new Intent(str);
                intent.setPackage(l.g(this.b));
                this.c = (Build.VERSION.SDK_INT < 31 || this.b.getApplicationInfo().targetSdkVersion < 31) ? PendingIntent.getBroadcast(this.b, 0, intent, 0) : PendingIntent.getBroadcast(this.b, 0, intent, 33554432);
                this.d = str;
                ArrayList<GeoFence> arrayList = this.h;
                if (arrayList != null && !arrayList.isEmpty()) {
                    Iterator<GeoFence> it = this.h.iterator();
                    while (it.hasNext()) {
                        GeoFence next = it.next();
                        next.setPendingIntent(this.c);
                        next.setPendingIntentAction(this.d);
                    }
                }
            }
        }
        return this.c;
    }

    public final void g() {
        try {
            this.p = false;
            j(10, null, 0L);
        } catch (Throwable th) {
            j1.h(th, "GeoFenceManager", "removeGeoFence");
        }
    }

    public final void h(int i) {
        try {
            a0();
            i = (i > 7 || i <= 0) ? 1 : 1;
            Bundle bundle = new Bundle();
            bundle.putInt("activatesAction", i);
            j(9, bundle, 0L);
        } catch (Throwable th) {
            j1.h(th, "GeoFenceManager", "setActivateAction");
        }
    }

    final void i(int i, Bundle bundle) {
        try {
            synchronized (this.k) {
                d dVar = this.i;
                if (dVar != null) {
                    Message obtainMessage = dVar.obtainMessage();
                    obtainMessage.what = i;
                    obtainMessage.setData(bundle);
                    this.i.sendMessage(obtainMessage);
                }
            }
        } catch (Throwable th) {
            j1.h(th, "GeoFenceManager", "sendResultHandlerMessage");
        }
    }

    final void j(int i, Bundle bundle, long j) {
        try {
            synchronized (this.j) {
                c cVar = this.l;
                if (cVar != null) {
                    Message obtainMessage = cVar.obtainMessage();
                    obtainMessage.what = i;
                    obtainMessage.setData(bundle);
                    this.l.sendMessageDelayed(obtainMessage, j);
                }
            }
        } catch (Throwable th) {
            j1.h(th, "GeoFenceManager", "sendActionHandlerMessage");
        }
    }

    final void k(Bundle bundle) {
        int i = 1;
        if (bundle != null) {
            try {
                i = bundle.getInt("activatesAction", 1);
            } catch (Throwable th) {
                j1.h(th, "GeoFenceManager", "doSetActivatesAction");
                return;
            }
        }
        if (this.g != i) {
            ArrayList<GeoFence> arrayList = this.h;
            if (arrayList != null && !arrayList.isEmpty()) {
                Iterator<GeoFence> it = this.h.iterator();
                while (it.hasNext()) {
                    GeoFence next = it.next();
                    next.setStatus(0);
                    next.setEnterTime(-1L);
                }
            }
            f0();
        }
        this.g = i;
    }

    public final void l(GeoFenceListener geoFenceListener) {
        try {
            this.e = geoFenceListener;
        } catch (Throwable unused) {
        }
    }

    final void m(AMapLocation aMapLocation) {
        ArrayList<GeoFence> arrayList;
        try {
            if (this.y || (arrayList = this.h) == null || arrayList.isEmpty() || aMapLocation == null || aMapLocation.getErrorCode() != 0) {
                return;
            }
            Iterator<GeoFence> it = this.h.iterator();
            while (it.hasNext()) {
                GeoFence next = it.next();
                if (next.isAble() && G(aMapLocation, next) && w(next, this.g)) {
                    next.setCurrentLocation(aMapLocation);
                    P(next);
                }
            }
        } catch (Throwable th) {
            j1.h(th, "GeoFenceManager", "doCheckFence");
        }
    }

    public final void n(DPoint dPoint, float f, String str) {
        try {
            a0();
            Bundle bundle = new Bundle();
            bundle.putParcelable("centerPoint", dPoint);
            bundle.putFloat("fenceRadius", f);
            bundle.putString(GeoFence.BUNDLE_KEY_CUSTOMID, str);
            j(0, bundle, 0L);
        } catch (Throwable th) {
            j1.h(th, "GeoFenceManager", "addRoundGeoFence");
        }
    }

    public final void p(String str, String str2) {
        try {
            a0();
            Bundle bundle = new Bundle();
            bundle.putString("keyWords", str);
            bundle.putString(GeoFence.BUNDLE_KEY_CUSTOMID, str2);
            j(4, bundle, 0L);
        } catch (Throwable th) {
            j1.h(th, "GeoFenceManager", "addDistricetGeoFence");
        }
    }

    public final void q(String str, String str2, DPoint dPoint, float f, int i, String str3) {
        try {
            a0();
            f = (f <= 0.0f || f > 50000.0f) ? 3000.0f : 3000.0f;
            if (i <= 0) {
                i = 10;
            }
            if (i > 25) {
                i = 25;
            }
            Bundle bundle = new Bundle();
            bundle.putString("keyWords", str);
            bundle.putString("poiType", str2);
            bundle.putParcelable("centerPoint", dPoint);
            bundle.putFloat("aroundRadius", f);
            bundle.putInt("searchSize", i);
            bundle.putString(GeoFence.BUNDLE_KEY_CUSTOMID, str3);
            j(3, bundle, 0L);
        } catch (Throwable th) {
            j1.h(th, "GeoFenceManager", "addNearbyGeoFence");
        }
    }

    public final void r(String str, String str2, String str3, int i, String str4) {
        try {
            a0();
            if (i <= 0) {
                i = 10;
            }
            if (i > 25) {
                i = 25;
            }
            Bundle bundle = new Bundle();
            bundle.putString("keyWords", str);
            bundle.putString("poiType", str2);
            bundle.putString("city", str3);
            bundle.putInt("searchSize", i);
            bundle.putString(GeoFence.BUNDLE_KEY_CUSTOMID, str4);
            j(2, bundle, 0L);
        } catch (Throwable th) {
            j1.h(th, "GeoFenceManager", "addKeywordGeoFence");
        }
    }

    public final void s(String str, boolean z2) {
        try {
            a0();
            Bundle bundle = new Bundle();
            bundle.putString("fid", str);
            bundle.putBoolean(tx0.VALUE_MODEL_DEFAULT, z2);
            j(12, bundle, 0L);
        } catch (Throwable th) {
            j1.h(th, "GeoFenceManager", "setGeoFenceAble");
        }
    }

    public final void t(List<DPoint> list, String str) {
        try {
            a0();
            Bundle bundle = new Bundle();
            bundle.putParcelableArrayList("pointList", new ArrayList<>(list));
            bundle.putString(GeoFence.BUNDLE_KEY_CUSTOMID, str);
            j(1, bundle, 0L);
        } catch (Throwable th) {
            j1.h(th, "GeoFenceManager", "addPolygonGeoFence");
        }
    }

    public final boolean v(GeoFence geoFence) {
        try {
            ArrayList<GeoFence> arrayList = this.h;
            if (arrayList != null && !arrayList.isEmpty()) {
                if (this.h.contains(geoFence)) {
                    if (this.h.size() == 1) {
                        this.p = false;
                    }
                    Bundle bundle = new Bundle();
                    bundle.putParcelable("fc", geoFence);
                    j(11, bundle, 0L);
                    return true;
                }
                return false;
            }
            this.p = false;
            j(10, null, 0L);
            return true;
        } catch (Throwable th) {
            j1.h(th, "GeoFenceManager", "removeGeoFence(GeoFence)");
            return false;
        }
    }
}
