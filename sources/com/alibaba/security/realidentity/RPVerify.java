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
import com.alibaba.security.common.c.C3800a;
import com.alibaba.security.common.d.C3811h;
import com.alibaba.security.common.track.RPTrack;
import com.alibaba.security.common.track.a.C3829a;
import com.alibaba.security.realidentity.RPConfig;
import com.alibaba.security.realidentity.a.C3847g;
import com.alibaba.security.realidentity.a.C3849h;
import com.alibaba.security.realidentity.a.C3850i;
import com.alibaba.security.realidentity.bean.ClientInfo;
import com.alibaba.security.realidentity.d.C3890b;
import com.alibaba.security.realidentity.http.RpcInvoker;
import com.alibaba.security.realidentity.jsbridge.AbstractC3893a;
import com.alibaba.security.realidentity.jsbridge.RP;
import com.alibaba.security.realidentity.track.C3915a;
import com.alibaba.security.realidentity.utils.C3925c;
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
        C3847g.C3848a.a.g = rPConfig;
        runnable.run();
    }

    public static String getDeviceInfo() {
        JSONObject jSONObject = new JSONObject();
        ClientInfo clientInfo = new ClientInfo();
        clientInfo.setVersionTag("");
        jSONObject.put(AbstractC3893a.I, (Object) C3811h.a(clientInfo));
        jSONObject.put("wua", (Object) C3847g.C3848a.a.i.f());
        jSONObject.put("miniWua", (Object) C3847g.C3848a.a.i.g());
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
                C3847g c3847g = C3847g.C3848a.a;
                Activity activity2 = activity;
                String str2 = str;
                RPEventListener rPEventListener2 = rPEventListener;
                if (!C3925c.a()) {
                    if (rPEventListener2 != null) {
                        RPResult rPResult = RPResult.AUDIT_FAIL;
                        rPEventListener2.onFinish(rPResult, new RPDetail(C3847g.a(rPResult, "-10415"), "-10415", "CTID SDK NOT EXIST", null));
                        return;
                    }
                    return;
                }
                c3847g.a(str2, c3847g.a(), "ctid");
                c3847g.h = c3847g.a(rPEventListener2);
                if (c3847g.b(str2)) {
                    c3847g.m = "ctid";
                    c3847g.d = str2;
                    c3847g.l = System.currentTimeMillis();
                    C3800a.a("RPVerifyManager", "startVerifyByNative token is: ".concat(String.valueOf(str2)));
                    c3847g.h.onStart();
                    GetCacheDataManager.getInstance().setUmidToken(c3847g.i.h());
                    C3847g.a(activity2, str2, rPEventListener2, new C3847g.AnonymousClass4(rPEventListener2, activity2, str2), c3847g.i);
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
        C3847g unused = C3847g.C3848a.a;
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
        C3847g.C3848a.a.f = str2;
        C3847g c3847g = C3847g.C3848a.a;
        RPEnv rPEnv2 = c3847g.e;
        c3847g.c = context.getApplicationContext();
        c3847g.e = rPEnv2;
        C3850i c3850i = C3850i.C3851a.a;
        c3850i.a = new C3849h();
        c3850i.b();
        c3847g.i.a(c3847g.c);
        C3829a.C3830a.a.a(c3847g.c, (RPTrack.TrackStrategy) null);
        C3829a.C3830a.a.d = new C3915a(c3847g.c);
        c3847g.j.init(context);
        WVPluginManager.registerPlugin("RP", (Class<? extends WVApiPlugin>) RP.class);
        C3847g c3847g2 = C3847g.C3848a.a;
        c3847g2.e = rPEnv;
        C3890b c3890b = c3847g2.i;
        c3890b.a = rPEnv;
        c3890b.d = null;
        c3890b.e = null;
        RpcInvoker.setMtopInstanceId(str);
        isInit = true;
    }

    public static void start(final Context context, final String str, RPConfig rPConfig, final RPEventListener rPEventListener) {
        a(context, str, rPConfig, rPEventListener, new Runnable() { // from class: com.alibaba.security.realidentity.RPVerify.1
            @Override // java.lang.Runnable
            public final void run() {
                C3847g.C3848a.a.a(context, str, "h5", rPEventListener);
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
        C3847g.C3848a.a.g = rPConfig;
        C3847g c3847g = C3847g.C3848a.a;
        String a = C3847g.a(str);
        c3847g.a(a, c3847g.a(), "url");
        c3847g.h = c3847g.a(rPEventListener);
        if (c3847g.b(a)) {
            c3847g.m = "url";
            c3847g.d = a;
            c3847g.l = System.currentTimeMillis();
            GetCacheDataManager.getInstance().setUmidToken(c3847g.i.h());
            C3847g.a(context, a, c3847g.h, new C3847g.AnonymousClass2(context, C3847g.a(str, "fromSource", "rpsdk"), a), c3847g.i);
        }
    }

    public static void start(final Context context, final String str, RPConfig rPConfig, final String str2, final RPEventListener rPEventListener) {
        a(context, str, rPConfig, rPEventListener, new Runnable() { // from class: com.alibaba.security.realidentity.RPVerify.2
            @Override // java.lang.Runnable
            public final void run() {
                C3847g.C3848a.a.a(context, str, str2, rPEventListener);
            }
        });
    }

    public static void startByNative(final Context context, final String str, RPConfig rPConfig, final RPEventListener rPEventListener) {
        a(context, str, rPConfig, rPEventListener, new Runnable() { // from class: com.alibaba.security.realidentity.RPVerify.3
            @Override // java.lang.Runnable
            public final void run() {
                C3847g c3847g = C3847g.C3848a.a;
                Context context2 = context;
                String str2 = str;
                RPEventListener rPEventListener2 = rPEventListener;
                c3847g.a(str2, c3847g.a(), "native");
                c3847g.h = c3847g.a(rPEventListener2);
                if (c3847g.b(str2)) {
                    c3847g.m = "native";
                    c3847g.d = str2;
                    c3847g.l = System.currentTimeMillis();
                    C3800a.a("RPVerifyManager", "startVerifyByNative token is: ".concat(String.valueOf(str2)));
                    c3847g.h.onStart();
                    GetCacheDataManager.getInstance().setUmidToken(c3847g.i.h());
                    C3847g.a(context2, str2, c3847g.h, new C3847g.AnonymousClass3(context2, str2), c3847g.i);
                }
            }
        });
    }
}
