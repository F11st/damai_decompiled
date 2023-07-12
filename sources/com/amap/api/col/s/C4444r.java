package com.amap.api.col.s;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.amap.api.col.s.C4373ae;
import com.amap.api.col.s.bl;
import com.youku.live.dago.widgetlib.interactive.gift.bean.GiftNumBean;
import org.json.JSONObject;

/* compiled from: Taobao */
/* renamed from: com.amap.api.col.s.r */
/* loaded from: classes10.dex */
public final class C4444r {
    public static bv a;
    private static C4444r b;
    private static Context c;
    private HandlerC4445a d;
    private HandlerThread e = new HandlerThread("manifestThread") { // from class: com.amap.api.col.s.r.1
        @Override // android.os.HandlerThread, java.lang.Thread, java.lang.Runnable
        public final void run() {
            Thread.currentThread().setName("ManifestConfigThread");
            bv a2 = C4434h.a(false);
            C4444r.c(C4444r.c);
            bl.a(C4444r.c, a2, "11K;001;184;185", new bl.InterfaceC4381a() { // from class: com.amap.api.col.s.r.1.1
                @Override // com.amap.api.col.s.bl.InterfaceC4381a
                public final void a(bl.C4382b c4382b) {
                    HandlerC4445a handlerC4445a;
                    JSONObject jSONObject;
                    JSONObject optJSONObject;
                    JSONObject jSONObject2;
                    JSONObject optJSONObject2;
                    Message message = new Message();
                    if (c4382b != null) {
                        try {
                            bl.C4382b.C4383a c4383a = c4382b.g;
                            if (c4383a != null) {
                                message.obj = new C4446s(c4383a.b, c4383a.a);
                            }
                        } catch (Throwable th) {
                            try {
                                C4435i.a(th, "ManifestConfig", "run");
                                if (handlerC4445a == null) {
                                    return;
                                }
                            } finally {
                                message.what = 3;
                                if (C4444r.this.d != null) {
                                    C4444r.this.d.sendMessage(message);
                                }
                            }
                        }
                    }
                    if (c4382b != null && (jSONObject2 = c4382b.f) != null && (optJSONObject2 = jSONObject2.optJSONObject("184")) != null) {
                        C4444r.d(optJSONObject2);
                        am.a(C4444r.c, "amap_search", "cache_control", optJSONObject2.toString());
                    }
                    if (c4382b != null && (jSONObject = c4382b.f) != null && (optJSONObject = jSONObject.optJSONObject("185")) != null) {
                        C4444r.c(optJSONObject);
                        am.a(C4444r.c, "amap_search", "parm_control", optJSONObject.toString());
                    }
                    message.what = 3;
                    if (C4444r.this.d == null) {
                    }
                }
            });
            try {
                Thread.sleep(10000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    };

    /* compiled from: Taobao */
    /* renamed from: com.amap.api.col.s.r$a */
    /* loaded from: classes10.dex */
    class HandlerC4445a extends Handler {
        String a;

        public HandlerC4445a(Looper looper) {
            super(looper);
            this.a = "handleMessage";
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            if (message != null && message.what == 3) {
                try {
                    C4446s c4446s = (C4446s) message.obj;
                    if (c4446s == null) {
                        c4446s = new C4446s(false, false);
                    }
                    cl.a(C4444r.c, C4434h.a(c4446s.a()));
                    C4444r.a = C4434h.a(c4446s.a());
                } catch (Throwable th) {
                    C4435i.a(th, "ManifestConfig", this.a);
                }
            }
        }
    }

    private C4444r(Context context) {
        c = context;
        a = C4434h.a(false);
        try {
            b();
            this.d = new HandlerC4445a(Looper.getMainLooper());
            this.e.start();
        } catch (Throwable th) {
            C4435i.a(th, "ManifestConfig", "ManifestConfig");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void c(Context context) {
        try {
            String str = (String) am.b(context, "amap_search", "cache_control", "");
            if (!TextUtils.isEmpty(str)) {
                d(new JSONObject(str));
            }
            String str2 = (String) am.b(context, "amap_search", "parm_control", "");
            if (TextUtils.isEmpty(str2)) {
                return;
            }
            c(new JSONObject(str2));
        } catch (Throwable th) {
            C4435i.a(th, "ManifestConfig", "ManifestConfig-readAuthFromCache");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void d(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                if (jSONObject.has("able")) {
                    C4373ae.C4374a a2 = a(jSONObject, true, (C4373ae.C4374a) null);
                    C4373ae.a().a(a2);
                    if (a2.a()) {
                        a("regeo", jSONObject, a2);
                        a("geo", jSONObject, a2);
                        a("placeText", jSONObject, a2);
                        a("placeAround", jSONObject, a2);
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    private static void b() {
        C4372ad.a();
    }

    public static C4444r a(Context context) {
        if (b == null) {
            b = new C4444r(context);
        }
        return b;
    }

    private static void a(String str, JSONObject jSONObject, C4373ae.C4374a c4374a) {
        if (jSONObject != null && jSONObject.has(str)) {
            C4373ae.a().a(str, a(jSONObject.optJSONObject(str), false, c4374a));
        }
    }

    private static C4373ae.C4374a a(JSONObject jSONObject, boolean z, C4373ae.C4374a c4374a) {
        C4373ae.C4374a c4374a2;
        boolean optBoolean;
        C4373ae.C4374a c4374a3 = null;
        if (jSONObject != null) {
            try {
                c4374a2 = new C4373ae.C4374a();
                boolean z2 = false;
            } catch (Throwable th) {
                th = th;
            }
            try {
                if (z) {
                    optBoolean = bl.a(jSONObject.optString("able"), (c4374a == null || c4374a.a()) ? true : true);
                } else {
                    optBoolean = jSONObject.optBoolean("able", (c4374a == null || c4374a.a()) ? true : true);
                }
                int optInt = jSONObject.optInt("timeoffset", c4374a != null ? (int) c4374a.b() : 86400);
                int optInt2 = jSONObject.optInt(GiftNumBean.KEY_NUM, c4374a != null ? c4374a.c() : 10);
                double optDouble = jSONObject.optDouble("limitDistance", c4374a != null ? c4374a.d() : 0.0d);
                c4374a2.a(optBoolean);
                c4374a2.a(optInt);
                c4374a2.a(optInt2);
                c4374a2.a(optDouble);
                return c4374a2;
            } catch (Throwable th2) {
                th = th2;
                c4374a3 = c4374a2;
                th.printStackTrace();
                return c4374a3;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void c(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                boolean a2 = bl.a(jSONObject.optString("passAreaAble"), true);
                boolean a3 = bl.a(jSONObject.optString("truckAble"), true);
                boolean a4 = bl.a(jSONObject.optString("poiPageAble"), true);
                boolean a5 = bl.a(jSONObject.optString("rideAble"), true);
                boolean a6 = bl.a(jSONObject.optString("walkAble"), true);
                boolean a7 = bl.a(jSONObject.optString("passPointAble"), true);
                boolean a8 = bl.a(jSONObject.optString("keyWordLenAble"), true);
                int optInt = jSONObject.optInt("poiPageMaxSize", 25);
                int optInt2 = jSONObject.optInt("passAreaMaxCount", 100);
                int optInt3 = jSONObject.optInt("walkMaxLength", 100);
                int optInt4 = jSONObject.optInt("passPointMaxCount", 6);
                int optInt5 = jSONObject.optInt("poiPageMaxNum", 100);
                int optInt6 = jSONObject.optInt("truckMaxLength", 5000);
                int optInt7 = jSONObject.optInt("rideMaxLength", 1200);
                int optInt8 = jSONObject.optInt("passAreaMaxArea", 100000000);
                int optInt9 = jSONObject.optInt("passAreaPointCount", 16);
                int optInt10 = jSONObject.optInt("keyWordLenMaxNum", 100);
                ah.a().a(a2);
                ah.a().c(optInt2);
                ah.a().i(optInt8);
                ah.a().j(optInt9);
                ah.a().b(a3);
                ah.a().g(optInt6);
                ah.a().c(a4);
                ah.a().f(optInt5);
                ah.a().a(optInt);
                ah.a().b(optInt10);
                ah.a().g(a8);
                ah.a().d(a5);
                ah.a().h(optInt7);
                ah.a().e(a6);
                ah.a().d(optInt3);
                ah.a().f(a7);
                ah.a().e(optInt4);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }
}
