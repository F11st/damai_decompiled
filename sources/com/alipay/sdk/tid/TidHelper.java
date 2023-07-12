package com.alipay.sdk.tid;

import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import com.alipay.sdk.m.q.c;
import com.alipay.sdk.m.s.a;
import com.alipay.sdk.m.s.b;
import com.alipay.sdk.m.u.e;
import org.json.JSONObject;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class TidHelper {
    public static void a(Context context) {
        if (context == null) {
            return;
        }
        b.d().a(context);
    }

    public static Tid b(Context context) throws Exception {
        try {
            com.alipay.sdk.m.p.b a = new c().a(a.h(), context);
            if (a != null) {
                JSONObject jSONObject = new JSONObject(a.a());
                com.alipay.sdk.m.t.a a2 = com.alipay.sdk.m.t.a.a(context);
                String optString = jSONObject.optString("tid");
                String string = jSONObject.getString(com.alipay.sdk.m.t.a.j);
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
        com.alipay.sdk.m.t.a.a(context).a();
    }

    public static String getIMEI(Context context) {
        a(context);
        return com.alipay.sdk.m.u.c.b(context).b();
    }

    public static String getIMSI(Context context) {
        a(context);
        return com.alipay.sdk.m.u.c.b(context).c();
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
        com.alipay.sdk.m.m.b.b();
        return com.alipay.sdk.m.m.b.f();
    }

    public static String getVirtualImsi(Context context) {
        a(context);
        com.alipay.sdk.m.m.b.b();
        return com.alipay.sdk.m.m.b.g();
    }

    public static Tid loadLocalTid(Context context) {
        com.alipay.sdk.m.t.a a = com.alipay.sdk.m.t.a.a(context);
        if (a.h()) {
            return null;
        }
        return new Tid(a.d(), a.c(), a.e().longValue());
    }

    public static synchronized Tid loadOrCreateTID(Context context) {
        synchronized (TidHelper.class) {
            e.b(com.alipay.sdk.m.l.a.z, "load_create_tid");
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
        Tid a = a(context, com.alipay.sdk.m.t.a.a(context));
        if (a == null) {
            e.b(com.alipay.sdk.m.l.a.z, "load_tid null");
        }
        return a;
    }

    public static boolean resetTID(Context context) throws Exception {
        e.b(com.alipay.sdk.m.l.a.z, "reset_tid");
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

    public static Tid a(Context context, com.alipay.sdk.m.t.a aVar) {
        if (aVar == null || aVar.i()) {
            return null;
        }
        return new Tid(aVar.d(), aVar.c(), aVar.e().longValue());
    }
}
