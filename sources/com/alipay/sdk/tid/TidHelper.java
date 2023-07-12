package com.alipay.sdk.tid;

import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import com.alipay.sdk.m.l.C4230a;
import com.alipay.sdk.m.m.C4248b;
import com.alipay.sdk.m.p.C4268b;
import com.alipay.sdk.m.q.C4280c;
import com.alipay.sdk.m.s.C4293a;
import com.alipay.sdk.m.s.C4295b;
import com.alipay.sdk.m.t.C4296a;
import com.alipay.sdk.m.u.C4300c;
import com.alipay.sdk.m.u.C4302e;
import org.json.JSONObject;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class TidHelper {
    public static void a(Context context) {
        if (context == null) {
            return;
        }
        C4295b.d().a(context);
    }

    public static Tid b(Context context) throws Exception {
        try {
            C4268b a = new C4280c().a(C4293a.h(), context);
            if (a != null) {
                JSONObject jSONObject = new JSONObject(a.a());
                C4296a a2 = C4296a.a(context);
                String optString = jSONObject.optString("tid");
                String string = jSONObject.getString(C4296a.j);
                if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(string)) {
                    a2.a(optString, string);
                }
                return a(context, a2);
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    public static void clearTID(Context context) {
        C4296a.a(context).a();
    }

    public static String getIMEI(Context context) {
        a(context);
        return C4300c.b(context).b();
    }

    public static String getIMSI(Context context) {
        a(context);
        return C4300c.b(context).c();
    }

    public static synchronized String getTIDValue(Context context) {
        String tid;
        synchronized (TidHelper.class) {
            Tid loadOrCreateTID = loadOrCreateTID(context);
            tid = Tid.isEmpty(loadOrCreateTID) ? "" : loadOrCreateTID.getTid();
        }
        return tid;
    }

    public static String getVirtualImei(Context context) {
        a(context);
        C4248b.b();
        return C4248b.f();
    }

    public static String getVirtualImsi(Context context) {
        a(context);
        C4248b.b();
        return C4248b.g();
    }

    public static Tid loadLocalTid(Context context) {
        C4296a a = C4296a.a(context);
        if (a.h()) {
            return null;
        }
        return new Tid(a.d(), a.c(), a.e().longValue());
    }

    public static synchronized Tid loadOrCreateTID(Context context) {
        synchronized (TidHelper.class) {
            C4302e.b(C4230a.z, "load_create_tid");
            a(context);
            Tid loadTID = loadTID(context);
            if (Tid.isEmpty(loadTID)) {
                if (Looper.myLooper() == Looper.getMainLooper()) {
                    return null;
                }
                try {
                    loadTID = b(context);
                } catch (Throwable unused) {
                }
            }
            return loadTID;
        }
    }

    public static Tid loadTID(Context context) {
        a(context);
        Tid a = a(context, C4296a.a(context));
        if (a == null) {
            C4302e.b(C4230a.z, "load_tid null");
        }
        return a;
    }

    public static boolean resetTID(Context context) throws Exception {
        C4302e.b(C4230a.z, "reset_tid");
        if (Looper.myLooper() != Looper.getMainLooper()) {
            a(context);
            clearTID(context);
            Tid tid = null;
            try {
                tid = b(context);
            } catch (Throwable unused) {
            }
            return !Tid.isEmpty(tid);
        }
        throw new Exception("Must be called on worker thread");
    }

    public static Tid a(Context context, C4296a c4296a) {
        if (c4296a == null || c4296a.i()) {
            return null;
        }
        return new Tid(c4296a.d(), c4296a.c(), c4296a.e().longValue());
    }
}
