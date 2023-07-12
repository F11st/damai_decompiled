package com.amap.api.col.s;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.amap.api.col.s.ae;
import com.amap.api.col.s.bl;
import com.youku.live.dago.widgetlib.interactive.gift.bean.GiftNumBean;
import org.json.JSONObject;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public final class r {
    public static bv a;
    private static r b;
    private static Context c;
    private a d;
    private HandlerThread e = new HandlerThread("manifestThread") { // from class: com.amap.api.col.s.r.1
        @Override // android.os.HandlerThread, java.lang.Thread, java.lang.Runnable
        public final void run() {
            Thread.currentThread().setName("ManifestConfigThread");
            bv a2 = h.a(false);
            r.c(r.c);
            bl.a(r.c, a2, "11K;001;184;185", new bl.a() { // from class: com.amap.api.col.s.r.1.1
                @Override // com.amap.api.col.s.bl.a
                public final void a(bl.b bVar) {
                    a aVar;
                    JSONObject jSONObject;
                    JSONObject optJSONObject;
                    JSONObject jSONObject2;
                    JSONObject optJSONObject2;
                    Message message = new Message();
                    if (bVar != null) {
                        try {
                            bl.b.a aVar2 = bVar.g;
                            if (aVar2 != null) {
                                message.obj = new s(aVar2.b, aVar2.a);
                            }
                        } catch (Throwable th) {
                            try {
                                i.a(th, "ManifestConfig", "run");
                                if (aVar == null) {
                                    return;
                                }
                            } finally {
                                message.what = 3;
                                if (r.this.d != null) {
                                    r.this.d.sendMessage(message);
                                }
                            }
                        }
                    }
                    if (bVar != null && (jSONObject2 = bVar.f) != null && (optJSONObject2 = jSONObject2.optJSONObject("184")) != null) {
                        r.d(optJSONObject2);
                        am.a(r.c, "amap_search", "cache_control", optJSONObject2.toString());
                    }
                    if (bVar != null && (jSONObject = bVar.f) != null && (optJSONObject = jSONObject.optJSONObject("185")) != null) {
                        r.c(optJSONObject);
                        am.a(r.c, "amap_search", "parm_control", optJSONObject.toString());
                    }
                    message.what = 3;
                    if (r.this.d == null) {
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
    /* loaded from: classes10.dex */
    class a extends Handler {
        String a;

        public a(Looper looper) {
            super(looper);
            this.a = "handleMessage";
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            if (message != null && message.what == 3) {
                try {
                    s sVar = (s) message.obj;
                    if (sVar == null) {
                        sVar = new s(false, false);
                    }
                    cl.a(r.c, h.a(sVar.a()));
                    r.a = h.a(sVar.a());
                } catch (Throwable th) {
                    i.a(th, "ManifestConfig", this.a);
                }
            }
        }
    }

    private r(Context context) {
        c = context;
        a = h.a(false);
        try {
            b();
            this.d = new a(Looper.getMainLooper());
            this.e.start();
        } catch (Throwable th) {
            i.a(th, "ManifestConfig", "ManifestConfig");
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
            i.a(th, "ManifestConfig", "ManifestConfig-readAuthFromCache");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void d(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                if (jSONObject.has("able")) {
                    ae.a a2 = a(jSONObject, true, (ae.a) null);
                    ae.a().a(a2);
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
        ad.a();
    }

    public static r a(Context context) {
        if (b == null) {
            b = new r(context);
        }
        return b;
    }

    private static void a(String str, JSONObject jSONObject, ae.a aVar) {
        if (jSONObject != null && jSONObject.has(str)) {
            ae.a().a(str, a(jSONObject.optJSONObject(str), false, aVar));
        }
    }

    private static ae.a a(JSONObject jSONObject, boolean z, ae.a aVar) {
        ae.a aVar2;
        boolean optBoolean;
        ae.a aVar3 = null;
        if (jSONObject != null) {
            try {
                aVar2 = new ae.a();
                boolean z2 = false;
            } catch (Throwable th) {
                th = th;
            }
            try {
                if (z) {
                    optBoolean = bl.a(jSONObject.optString("able"), (aVar == null || aVar.a()) ? true : true);
                } else {
                    optBoolean = jSONObject.optBoolean("able", (aVar == null || aVar.a()) ? true : true);
                }
                int optInt = jSONObject.optInt("timeoffset", aVar != null ? (int) aVar.b() : 86400);
                int optInt2 = jSONObject.optInt(GiftNumBean.KEY_NUM, aVar != null ? aVar.c() : 10);
                double optDouble = jSONObject.optDouble("limitDistance", aVar != null ? aVar.d() : 0.0d);
                aVar2.a(optBoolean);
                aVar2.a(optInt);
                aVar2.a(optInt2);
                aVar2.a(optDouble);
                return aVar2;
            } catch (Throwable th2) {
                th = th2;
                aVar3 = aVar2;
                th.printStackTrace();
                return aVar3;
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
