package com.loc;

import android.content.Context;
import android.text.TextUtils;
import com.amap.api.location.AMapLocation;
import com.taobao.weex.common.Constants;
import java.util.List;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;
import org.json.JSONObject;
import tb.r73;
import tb.s73;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public final class n1 {
    static r73 g;
    static j h;
    static long i;
    private Context a;
    String b = null;
    r73 c = null;
    r73 d = null;
    long e = 0;
    boolean f = false;

    public n1(Context context) {
        this.a = context.getApplicationContext();
    }

    private void g() {
        if (g == null || m1.B() - i > 180000) {
            r73 h2 = h();
            i = m1.B();
            if (h2 == null || !m1.q(h2.a())) {
                return;
            }
            g = h2;
        }
    }

    private r73 h() {
        Throwable th;
        r73 r73Var;
        j jVar;
        byte[] h2;
        byte[] h3;
        String str = null;
        if (this.a == null) {
            return null;
        }
        b();
        try {
            jVar = h;
        } catch (Throwable th2) {
            th = th2;
            r73Var = null;
        }
        if (jVar == null) {
            return null;
        }
        List f = jVar.f("_id=1", r73.class);
        if (f == null || f.size() <= 0) {
            r73Var = null;
        } else {
            r73Var = (r73) f.get(0);
            try {
                byte[] g2 = p1.g(r73Var.g());
                String str2 = (g2 == null || g2.length <= 0 || (h3 = e1.h(g2, this.b)) == null || h3.length <= 0) ? null : new String(h3, "UTF-8");
                byte[] g3 = p1.g(r73Var.e());
                if (g3 != null && g3.length > 0 && (h2 = e1.h(g3, this.b)) != null && h2.length > 0) {
                    str = new String(h2, "UTF-8");
                }
                r73Var.d(str);
                str = str2;
            } catch (Throwable th3) {
                th = th3;
                j1.h(th, "LastLocationManager", "readLastFix");
                return r73Var;
            }
        }
        if (!TextUtils.isEmpty(str)) {
            AMapLocation aMapLocation = new AMapLocation("");
            j1.f(aMapLocation, new JSONObject(str));
            if (m1.G(aMapLocation)) {
                r73Var.c(aMapLocation);
            }
        }
        return r73Var;
    }

    public final AMapLocation a(AMapLocation aMapLocation, String str, long j) {
        if (aMapLocation == null || aMapLocation.getErrorCode() == 0 || aMapLocation.getLocationType() == 1 || aMapLocation.getErrorCode() == 7) {
            return aMapLocation;
        }
        try {
            g();
            r73 r73Var = g;
            if (r73Var != null && r73Var.a() != null) {
                boolean z = false;
                if (TextUtils.isEmpty(str)) {
                    long B = m1.B() - g.h();
                    if (B >= 0 && B <= j) {
                        z = true;
                    }
                    aMapLocation.setTrustedLevel(3);
                } else {
                    z = m1.t(g.e(), str);
                    aMapLocation.setTrustedLevel(2);
                }
                if (z) {
                    AMapLocation a = g.a();
                    try {
                        a.setLocationType(9);
                        a.setFixLastLocation(true);
                        a.setLocationDetail(aMapLocation.getLocationDetail());
                        return a;
                    } catch (Throwable th) {
                        th = th;
                        aMapLocation = a;
                        j1.h(th, "LastLocationManager", "fixLastLocation");
                        return aMapLocation;
                    }
                }
                return aMapLocation;
            }
            return aMapLocation;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public final void b() {
        if (this.f) {
            return;
        }
        try {
            if (this.b == null) {
                this.b = e1.b(MessageDigestAlgorithms.MD5, o.h0(this.a));
            }
            if (h == null) {
                h = new j(this.a, j.c(s73.class));
            }
        } catch (Throwable th) {
            j1.h(th, "LastLocationManager", "<init>:DBOperation");
        }
        this.f = true;
    }

    public final boolean c(AMapLocation aMapLocation, String str) {
        if (this.a != null && aMapLocation != null && m1.q(aMapLocation) && aMapLocation.getLocationType() != 2 && !aMapLocation.isMock() && !aMapLocation.isFixLastLocation()) {
            r73 r73Var = new r73();
            r73Var.c(aMapLocation);
            if (aMapLocation.getLocationType() == 1) {
                r73Var.d(null);
            } else {
                r73Var.d(str);
            }
            try {
                g = r73Var;
                i = m1.B();
                this.c = r73Var;
                r73 r73Var2 = this.d;
                if (r73Var2 != null && m1.c(r73Var2.a(), r73Var.a()) <= 500.0f) {
                    return false;
                }
                if (m1.B() - this.e > 30000) {
                    return true;
                }
            } catch (Throwable th) {
                j1.h(th, "LastLocationManager", "setLastFix");
            }
        }
        return false;
    }

    public final AMapLocation d() {
        g();
        r73 r73Var = g;
        if (r73Var != null && m1.q(r73Var.a())) {
            return g.a();
        }
        return null;
    }

    public final void e() {
        try {
            f();
            this.e = 0L;
            this.f = false;
            this.c = null;
            this.d = null;
        } catch (Throwable th) {
            j1.h(th, "LastLocationManager", Constants.Event.SLOT_LIFECYCLE.DESTORY);
        }
    }

    public final void f() {
        r73 r73Var;
        String str;
        try {
            b();
            r73 r73Var2 = this.c;
            if (r73Var2 != null && m1.q(r73Var2.a()) && h != null && (r73Var = this.c) != this.d && r73Var.h() == 0) {
                String str2 = this.c.a().toStr();
                String e = this.c.e();
                this.d = this.c;
                if (TextUtils.isEmpty(str2)) {
                    str = null;
                } else {
                    String f = p1.f(e1.e(str2.getBytes("UTF-8"), this.b));
                    str = TextUtils.isEmpty(e) ? null : p1.f(e1.e(e.getBytes("UTF-8"), this.b));
                    r4 = f;
                }
                if (TextUtils.isEmpty(r4)) {
                    return;
                }
                r73 r73Var3 = new r73();
                r73Var3.f(r4);
                r73Var3.b(m1.B());
                r73Var3.d(str);
                h.i(r73Var3, "_id=1");
                this.e = m1.B();
                r73 r73Var4 = g;
                if (r73Var4 != null) {
                    r73Var4.b(m1.B());
                }
            }
        } catch (Throwable th) {
            j1.h(th, "LastLocationManager", "saveLastFix");
        }
    }
}
