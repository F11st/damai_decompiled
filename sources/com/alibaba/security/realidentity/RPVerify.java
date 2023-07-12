package com.alibaba.security.realidentity;

import android.app.Activity;
import android.content.Context;
import android.taobao.windvane.jsbridge.WVApiPlugin;
import android.taobao.windvane.jsbridge.WVPluginManager;
import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.security.biometrics.jni.VersionKey;
import com.alibaba.security.biometrics.service.common.GetCacheDataManager;
import com.alibaba.security.biometrics.service.constants.GlobalErrorCode;
import com.alibaba.security.common.d.h;
import com.alibaba.security.common.track.RPTrack;
import com.alibaba.security.common.track.a.a;
import com.alibaba.security.realidentity.RPConfig;
import com.alibaba.security.realidentity.a.g;
import com.alibaba.security.realidentity.a.i;
import com.alibaba.security.realidentity.bean.ClientInfo;
import com.alibaba.security.realidentity.http.RpcInvoker;
import com.alibaba.security.realidentity.jsbridge.RP;
import com.alibaba.security.realidentity.utils.c;
import java.util.Objects;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class RPVerify {
    private static final String dailyUrl = "https://market.waptest.taobao.com/app/msd/m-rpverify-internal/start.html";
    private static boolean isInit = false;
    private static final String onlineUrl = "https://market.m.taobao.com/app/msd/m-rpverify-internal/start.html";
    private static final String preUrl = "https://market.wapa.taobao.com/app/msd/m-rpverify-internal/start.html";

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.alibaba.security.realidentity.RPVerify$5  reason: invalid class name */
    /* loaded from: classes8.dex */
    public static /* synthetic */ class AnonymousClass5 {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[RPEnv.values().length];
            a = iArr;
            try {
                iArr[RPEnv.DAILY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[RPEnv.PRE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    private static void a(Context context, String str, RPConfig rPConfig, RPEventListener rPEventListener, Runnable runnable) {
        Objects.requireNonNull(rPEventListener, "RPVerify#start rpEventListener is null");
        if (TextUtils.isEmpty(str)) {
            rPEventListener.onFinish(RPResult.AUDIT_NOT, new RPDetail(GlobalErrorCode.mappingResultCode(GlobalErrorCode.ERROR_TOKEN_EMPTY), "-10401", "verifyToken is null", null));
            return;
        }
        if (!isInit) {
            init(context, RPEnv.ONLINE);
        }
        if (!isInit) {
            rPEventListener.onFinish(RPResult.AUDIT_NOT, new RPDetail(GlobalErrorCode.mappingResultCode(GlobalErrorCode.ERROR_INIT), "-10400", "sdk init fail", null));
            return;
        }
        g.a.a.g = rPConfig;
        runnable.run();
    }

    public static String getDeviceInfo() {
        JSONObject jSONObject = new JSONObject();
        ClientInfo clientInfo = new ClientInfo();
        clientInfo.setVersionTag("");
        jSONObject.put(com.alibaba.security.realidentity.jsbridge.a.I, (Object) h.a(clientInfo));
        jSONObject.put("wua", (Object) g.a.a.i.f());
        jSONObject.put("miniWua", (Object) g.a.a.i.g());
        return JSON.toJSONString(jSONObject);
    }

    public static void init(Context context, RPEnv rPEnv) {
        init(context, rPEnv, null);
    }

    public static void start(Context context, String str, RPEventListener rPEventListener) {
        start(context, str, null, rPEventListener);
    }

    public static void startByCtidWithVerifyToken(final Activity activity, final String str, RPConfig rPConfig, final RPEventListener rPEventListener) {
        RPConfig build;
        if (rPConfig != null) {
            build = new RPConfig.Builder(rPConfig).setNeedFailResultPage(true).build();
        } else {
            build = new RPConfig.Builder().setNeedFailResultPage(true).build();
        }
        a(activity, str, build, rPEventListener, new Runnable() { // from class: com.alibaba.security.realidentity.RPVerify.4
            @Override // java.lang.Runnable
            public final void run() {
                g gVar = g.a.a;
                Activity activity2 = activity;
                String str2 = str;
                RPEventListener rPEventListener2 = rPEventListener;
                if (!c.a()) {
                    if (rPEventListener2 != null) {
                        RPResult rPResult = RPResult.AUDIT_FAIL;
                        rPEventListener2.onFinish(rPResult, new RPDetail(g.a(rPResult, "-10415"), "-10415", "CTID SDK NOT EXIST", null));
                        return;
                    }
                    return;
                }
                gVar.a(str2, gVar.a(), "ctid");
                gVar.h = gVar.a(rPEventListener2);
                if (gVar.b(str2)) {
                    gVar.m = "ctid";
                    gVar.d = str2;
                    gVar.l = System.currentTimeMillis();
                    com.alibaba.security.common.c.a.a("RPVerifyManager", "startVerifyByNative token is: ".concat(String.valueOf(str2)));
                    gVar.h.onStart();
                    GetCacheDataManager.getInstance().setUmidToken(gVar.i.h());
                    g.a(activity2, str2, rPEventListener2, new g.AnonymousClass4(rPEventListener2, activity2, str2), gVar.i);
                }
            }
        });
    }

    public static void startByNative(Context context, String str, RPEventListener rPEventListener) {
        RPConfig.Builder builder = new RPConfig.Builder();
        builder.setNeedWaitingForFinish(true);
        startByNative(context, str, builder.build(), rPEventListener);
    }

    @Deprecated
    public static void startWithUrl(Context context, String str, RPEventListener rPEventListener) {
        startWithUrl(context, str, null, rPEventListener);
    }

    public static String version() {
        g unused = g.a.a;
        return VersionKey.RP_SDK_VERSION;
    }

    public static void init(Context context, RPEnv rPEnv, String str) {
        String str2 = onlineUrl;
        if (rPEnv != null) {
            int i = AnonymousClass5.a[rPEnv.ordinal()];
            if (i == 1) {
                str2 = dailyUrl;
            } else if (i == 2) {
                str2 = preUrl;
            }
        }
        g.a.a.f = str2;
        g gVar = g.a.a;
        RPEnv rPEnv2 = gVar.e;
        gVar.c = context.getApplicationContext();
        gVar.e = rPEnv2;
        i iVar = i.a.a;
        iVar.a = new com.alibaba.security.realidentity.a.h();
        iVar.b();
        gVar.i.a(gVar.c);
        a.C0165a.a.a(gVar.c, (RPTrack.TrackStrategy) null);
        a.C0165a.a.d = new com.alibaba.security.realidentity.track.a(gVar.c);
        gVar.j.init(context);
        WVPluginManager.registerPlugin("RP", (Class<? extends WVApiPlugin>) RP.class);
        g gVar2 = g.a.a;
        gVar2.e = rPEnv;
        com.alibaba.security.realidentity.d.b bVar = gVar2.i;
        bVar.a = rPEnv;
        bVar.d = null;
        bVar.e = null;
        RpcInvoker.setMtopInstanceId(str);
        isInit = true;
    }

    public static void start(final Context context, final String str, RPConfig rPConfig, final RPEventListener rPEventListener) {
        a(context, str, rPConfig, rPEventListener, new Runnable() { // from class: com.alibaba.security.realidentity.RPVerify.1
            @Override // java.lang.Runnable
            public final void run() {
                g.a.a.a(context, str, "h5", rPEventListener);
            }
        });
    }

    @Deprecated
    public static void startWithUrl(Context context, String str, RPConfig rPConfig, RPEventListener rPEventListener) {
        if (rPEventListener == null) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            rPEventListener.onFinish(RPResult.AUDIT_NOT, new RPDetail(GlobalErrorCode.mappingResultCode(GlobalErrorCode.ERROR_URL_EMPTY), "-10402", "url is empty", null));
            return;
        }
        if (!isInit) {
            init(context, RPEnv.ONLINE);
        }
        if (!isInit) {
            rPEventListener.onFinish(RPResult.AUDIT_NOT, new RPDetail(GlobalErrorCode.mappingResultCode(GlobalErrorCode.ERROR_INIT), "-10400", "sdk init fail", null));
            return;
        }
        g.a.a.g = rPConfig;
        g gVar = g.a.a;
        String a = g.a(str);
        gVar.a(a, gVar.a(), "url");
        gVar.h = gVar.a(rPEventListener);
        if (gVar.b(a)) {
            gVar.m = "url";
            gVar.d = a;
            gVar.l = System.currentTimeMillis();
            GetCacheDataManager.getInstance().setUmidToken(gVar.i.h());
            g.a(context, a, gVar.h, new g.AnonymousClass2(context, g.a(str, "fromSource", "rpsdk"), a), gVar.i);
        }
    }

    public static void start(final Context context, final String str, RPConfig rPConfig, final String str2, final RPEventListener rPEventListener) {
        a(context, str, rPConfig, rPEventListener, new Runnable() { // from class: com.alibaba.security.realidentity.RPVerify.2
            @Override // java.lang.Runnable
            public final void run() {
                g.a.a.a(context, str, str2, rPEventListener);
            }
        });
    }

    public static void startByNative(final Context context, final String str, RPConfig rPConfig, final RPEventListener rPEventListener) {
        a(context, str, rPConfig, rPEventListener, new Runnable() { // from class: com.alibaba.security.realidentity.RPVerify.3
            @Override // java.lang.Runnable
            public final void run() {
                g gVar = g.a.a;
                Context context2 = context;
                String str2 = str;
                RPEventListener rPEventListener2 = rPEventListener;
                gVar.a(str2, gVar.a(), "native");
                gVar.h = gVar.a(rPEventListener2);
                if (gVar.b(str2)) {
                    gVar.m = "native";
                    gVar.d = str2;
                    gVar.l = System.currentTimeMillis();
                    com.alibaba.security.common.c.a.a("RPVerifyManager", "startVerifyByNative token is: ".concat(String.valueOf(str2)));
                    gVar.h.onStart();
                    GetCacheDataManager.getInstance().setUmidToken(gVar.i.h());
                    g.a(context2, str2, gVar.h, new g.AnonymousClass3(context2, str2), gVar.i);
                }
            }
        });
    }
}
