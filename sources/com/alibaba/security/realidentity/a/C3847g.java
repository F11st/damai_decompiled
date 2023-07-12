package com.alibaba.security.realidentity.a;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.taobao.windvane.jsbridge.WVApiPlugin;
import android.taobao.windvane.jsbridge.WVPluginManager;
import android.text.TextUtils;
import android.util.Pair;
import com.alibaba.security.biometrics.jni.VersionKey;
import com.alibaba.security.biometrics.service.common.GetCacheDataManager;
import com.alibaba.security.biometrics.service.constants.GlobalErrorCode;
import com.alibaba.security.biometrics.service.sensor.SensorGetter;
import com.alibaba.security.biometrics.skin.RPSkinManager;
import com.alibaba.security.biometrics.theme.ALBiometricsConfig;
import com.alibaba.security.common.c.C3800a;
import com.alibaba.security.common.d.C3805b;
import com.alibaba.security.common.d.C3812i;
import com.alibaba.security.common.track.RPTrack;
import com.alibaba.security.common.track.a.C3829a;
import com.alibaba.security.common.track.model.TrackLog;
import com.alibaba.security.realidentity.AbstractC3853b;
import com.alibaba.security.realidentity.RPConfig;
import com.alibaba.security.realidentity.RPDetail;
import com.alibaba.security.realidentity.RPEnv;
import com.alibaba.security.realidentity.RPEventListener;
import com.alibaba.security.realidentity.RPResult;
import com.alibaba.security.realidentity.a.C3850i;
import com.alibaba.security.realidentity.activity.RPWebViewActivity;
import com.alibaba.security.realidentity.business.C3857a;
import com.alibaba.security.realidentity.business.base.chain.BusinessHeadParams;
import com.alibaba.security.realidentity.business.dynamic.AsyncTaskC3875b;
import com.alibaba.security.realidentity.business.dynamic.model.CtidConfig;
import com.alibaba.security.realidentity.business.dynamic.model.ScConfig;
import com.alibaba.security.realidentity.d.C3890b;
import com.alibaba.security.realidentity.e.InterfaceC3891a;
import com.alibaba.security.realidentity.jsbridge.RP;
import com.alibaba.security.realidentity.track.C3915a;
import com.alibaba.security.realidentity.utils.C3925c;
import java.util.HashMap;
import tb.dz2;
import tb.ez2;

/* compiled from: Taobao */
/* renamed from: com.alibaba.security.realidentity.a.g */
/* loaded from: classes8.dex */
public final class C3847g implements InterfaceC3891a {
    private static final String q = "RPVerifyManager";
    final RPSkinManager a;
    final Handler b;
    public Context c;
    public String d;
    public RPEnv e;
    public String f;
    public RPConfig g;
    public AbstractC3853b h;
    public C3890b i;
    public final SensorGetter j;
    volatile boolean k;
    public long l;
    public String m;
    public ScConfig n;
    public boolean o;
    public CtidConfig p;

    /* compiled from: Taobao */
    /* renamed from: com.alibaba.security.realidentity.a.g$2 */
    /* loaded from: classes8.dex */
    public class AnonymousClass2 implements Runnable {
        final /* synthetic */ Context a;
        final /* synthetic */ String b;
        final /* synthetic */ String c;

        public AnonymousClass2(Context context, String str, String str2) {
            C3847g.this = r1;
            this.a = context;
            this.b = str;
            this.c = str2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            C3847g.this.a(this.a, this.b, this.c);
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.alibaba.security.realidentity.a.g$3 */
    /* loaded from: classes8.dex */
    public class AnonymousClass3 implements Runnable {
        final /* synthetic */ Context a;
        final /* synthetic */ String b;

        public AnonymousClass3(Context context, String str) {
            C3847g.this = r1;
            this.a = context;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public final void run() {
            C3847g c3847g = C3847g.this;
            C3857a c3857a = new C3857a(this.a, this.b, c3847g.h);
            BusinessHeadParams businessHeadParams = new BusinessHeadParams();
            businessHeadParams.setScConfig(c3847g.n);
            c3857a.a(businessHeadParams);
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.alibaba.security.realidentity.a.g$4 */
    /* loaded from: classes8.dex */
    public class AnonymousClass4 implements Runnable {
        final /* synthetic */ RPEventListener a;
        final /* synthetic */ Activity b;
        final /* synthetic */ String c;

        public AnonymousClass4(RPEventListener rPEventListener, Activity activity, String str) {
            C3847g.this = r1;
            this.a = rPEventListener;
            this.b = activity;
            this.c = str;
        }

        @Override // java.lang.Runnable
        public final void run() {
            C3847g c3847g = C3847g.this;
            if (c3847g.p == null) {
                c3847g.k = false;
                RPResult rPResult = RPResult.AUDIT_FAIL;
                this.a.onFinish(rPResult, new RPDetail(C3847g.a(rPResult, "-10415"), "-10415", "CTID auth failed", null));
                return;
            }
            final C3925c c3925c = new C3925c();
            CtidConfig ctidConfig = C3847g.this.p;
            Activity activity = this.b;
            String str = this.c;
            Runnable runnable = new Runnable() { // from class: com.alibaba.security.realidentity.a.g.4.1
                {
                    AnonymousClass4.this = this;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    if (c3925c.a == -1) {
                        C3847g.this.k = false;
                        AnonymousClass4.this.a.onFinish(RPResult.AUDIT_NOT, new RPDetail(C3847g.a(RPResult.AUDIT_FAIL, "-10415"), "-10415", "CTID auth failed by user exit", null));
                        return;
                    }
                    AnonymousClass4 anonymousClass4 = AnonymousClass4.this;
                    C3857a c3857a = new C3857a(anonymousClass4.b, anonymousClass4.c, C3847g.this.h);
                    BusinessHeadParams businessHeadParams = new BusinessHeadParams();
                    businessHeadParams.setCtidParams(c3925c.b);
                    businessHeadParams.setCtidCode(c3925c.a);
                    businessHeadParams.setCtidCalled(true);
                    c3857a.a(businessHeadParams);
                }
            };
            ez2 ez2Var = new ez2(ctidConfig.getOrgId(), ctidConfig.getAndroidAppId(), str, ctidConfig.getType());
            C3925c.a(ctidConfig, str);
            new dz2(activity, ez2Var).getAuthResult(new C3925c.AnonymousClass1(str, runnable));
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.alibaba.security.realidentity.a.g$a */
    /* loaded from: classes8.dex */
    public static final class C3848a {
        private static final C3847g a = new C3847g((byte) 0);

        private C3848a() {
        }

        public static /* synthetic */ C3847g a() {
            return a;
        }
    }

    /* synthetic */ C3847g(byte b) {
        this();
    }

    private static boolean A() {
        return false;
    }

    private static boolean B() {
        return false;
    }

    private static String C() {
        return null;
    }

    private static String D() {
        return VersionKey.RP_SDK_VERSION;
    }

    private RPEnv E() {
        return this.e;
    }

    private ScConfig F() {
        return this.n;
    }

    private static /* synthetic */ boolean c(C3847g c3847g) {
        c3847g.k = false;
        return false;
    }

    private static Pair<Boolean, String> h() {
        return new Pair<>(Boolean.TRUE, "");
    }

    private Pair<Boolean, String> i() {
        C3890b c3890b = this.i;
        if (c3890b == null) {
            return null;
        }
        return c3890b.a();
    }

    private Context j() {
        return this.c;
    }

    @Deprecated
    private static void k() {
    }

    @Deprecated
    private String l() {
        return this.d;
    }

    private RPEnv m() {
        return this.e;
    }

    private String n() {
        return this.f;
    }

    private RPEventListener o() {
        return this.h;
    }

    private void p() {
        this.h = null;
    }

    private boolean q() {
        return this.k;
    }

    private static void r() {
        C3829a.C3830a.a.a(false);
    }

    private String s() {
        return this.i.c();
    }

    private String t() {
        return this.i.d();
    }

    private String u() {
        return this.i.e();
    }

    private String v() {
        return this.i.f();
    }

    private String w() {
        return this.i.g();
    }

    private String x() {
        return this.i.h();
    }

    private static boolean y() {
        return false;
    }

    private static boolean z() {
        return false;
    }

    private C3847g() {
        this.c = null;
        this.d = "";
        this.e = RPEnv.ONLINE;
        this.f = "https://market.m.taobao.com/app/msd/m-rpverify-internal/start.html";
        this.g = null;
        this.h = null;
        this.o = true;
        this.i = new C3890b(this);
        this.k = false;
        this.b = new Handler(Looper.getMainLooper());
        this.a = RPSkinManager.getInstance();
        this.j = SensorGetter.getDefault();
    }

    private void c(Context context, String str, RPEventListener rPEventListener) {
        C3857a c3857a = new C3857a(context, str, rPEventListener);
        BusinessHeadParams businessHeadParams = new BusinessHeadParams();
        businessHeadParams.setScConfig(this.n);
        c3857a.a(businessHeadParams);
    }

    private void d(String str) {
        this.f = str;
    }

    private static C3847g e() {
        return C3848a.a;
    }

    private static boolean f() {
        WVPluginManager.registerPlugin("RP", (Class<? extends WVApiPlugin>) RP.class);
        return true;
    }

    private Pair<Boolean, String> g() {
        return this.i.a();
    }

    private boolean a(Context context) {
        RPEnv rPEnv = this.e;
        this.c = context.getApplicationContext();
        this.e = rPEnv;
        C3850i c3850i = C3850i.C3851a.a;
        c3850i.a = new C3849h();
        c3850i.b();
        this.i.a(this.c);
        C3829a.C3830a.a.a(this.c, (RPTrack.TrackStrategy) null);
        C3829a.C3830a.a.d = new C3915a(this.c);
        this.j.init(context);
        WVPluginManager.registerPlugin("RP", (Class<? extends WVApiPlugin>) RP.class);
        return true;
    }

    private void b(Context context, String str, RPEventListener rPEventListener) {
        a(str, a(), "native");
        this.h = a(rPEventListener);
        if (b(str)) {
            this.m = "native";
            this.d = str;
            this.l = System.currentTimeMillis();
            C3800a.a(q, "startVerifyByNative token is: ".concat(String.valueOf(str)));
            this.h.onStart();
            GetCacheDataManager.getInstance().setUmidToken(this.i.h());
            a(context, str, this.h, new AnonymousClass3(context, str), this.i);
        }
    }

    private String e(String str) {
        return this.i.a(str);
    }

    private String f(String str) {
        return this.i.b(str);
    }

    public final boolean d() {
        return this.o && C3805b.a();
    }

    private void c(String str) {
        this.d = str;
    }

    public final Pair<Boolean, String> c() {
        C3829a.C3830a.a.a = null;
        Pair<Boolean, String> i = i();
        GetCacheDataManager.getInstance().setUmidToken(this.i.h());
        return i;
    }

    public final boolean b(String str) {
        Pair<Boolean, String> h = h();
        if (!((Boolean) h.first).booleanValue()) {
            this.h.b(RPResult.AUDIT_NOT, "-10403", (String) h.second, str);
            return false;
        }
        Pair<Boolean, String> c = c();
        if (!((Boolean) c.first).booleanValue()) {
            this.h.b(RPResult.AUDIT_NOT, "-10403", (String) c.second, str);
            return false;
        } else if (this.k) {
            this.h.a(RPResult.AUDIT_NOT, "-10404", "重复认证，上一次认证还未结束", str);
            return false;
        } else {
            this.k = true;
            return true;
        }
    }

    private boolean a(Context context, RPEnv rPEnv) {
        this.c = context.getApplicationContext();
        this.e = rPEnv;
        C3850i c3850i = C3850i.C3851a.a;
        c3850i.a = new C3849h();
        c3850i.b();
        this.i.a(this.c);
        C3829a.C3830a.a.a(this.c, (RPTrack.TrackStrategy) null);
        C3829a.C3830a.a.d = new C3915a(this.c);
        this.j.init(context);
        WVPluginManager.registerPlugin("RP", (Class<? extends WVApiPlugin>) RP.class);
        return true;
    }

    public final RPConfig b() {
        if (this.g == null) {
            this.g = new RPConfig.Builder().build();
        }
        return this.g;
    }

    private static void b(RPDetail rPDetail) {
        if (rPDetail != null && "1".equals(rPDetail.getCode())) {
            rPDetail.setSubCode("1");
        }
    }

    @Override // com.alibaba.security.realidentity.e.InterfaceC3891a
    @Deprecated
    public final void b(TrackLog trackLog) {
        a(trackLog);
    }

    public final void a(final Context context, final String str, String str2, RPEventListener rPEventListener) {
        this.m = str2;
        a(str, a(), str2);
        this.h = a(rPEventListener);
        if (b(str)) {
            this.d = str;
            this.l = System.currentTimeMillis();
            C3800a.a(q, "startVerify token is: ".concat(String.valueOf(str)));
            GetCacheDataManager.getInstance().setUmidToken(this.i.h());
            a(context, str, this.h, new Runnable() { // from class: com.alibaba.security.realidentity.a.g.1
                {
                    C3847g.this = this;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    C3847g c3847g = C3847g.this;
                    Context context2 = context;
                    String str3 = str;
                    c3847g.a(context2, C3847g.a(C3847g.a(c3847g.f, "token", str3), "fromSource", "rpsdk"), str3);
                }
            }, this.i);
        }
    }

    private void a(Context context, String str) {
        a(context, a(a(this.f, "token", str), "fromSource", "rpsdk"), str);
    }

    public static String a(String str, String str2, String str3) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(str.lastIndexOf("?") >= 0 ? "&" : "?");
        sb.append(str2);
        sb.append("=");
        sb.append(str3);
        String sb2 = sb.toString();
        C3800a.a(q, "originalUrl:" + str + "\nnewUrl:" + sb2);
        return sb2;
    }

    public final boolean a() {
        ALBiometricsConfig biometricsConfig = b().getBiometricsConfig();
        if (biometricsConfig == null) {
            return false;
        }
        boolean isSkinInAssets = biometricsConfig.isSkinInAssets();
        String skinPath = biometricsConfig.getSkinPath();
        if (isSkinInAssets || !TextUtils.isEmpty(skinPath)) {
            this.a.init(this.c, skinPath, isSkinInAssets);
            return true;
        }
        return false;
    }

    private void a(Context context, String str, RPEventListener rPEventListener) {
        String a = a(str);
        a(a, a(), "url");
        this.h = a(rPEventListener);
        if (b(a)) {
            this.m = "url";
            this.d = a;
            this.l = System.currentTimeMillis();
            GetCacheDataManager.getInstance().setUmidToken(this.i.h());
            a(context, a, this.h, new AnonymousClass2(context, a(str, "fromSource", "rpsdk"), a), this.i);
        }
    }

    public static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            HashMap hashMap = new HashMap();
            String[] split = str.substring(str.indexOf("?") + 1).split("&");
            if (split != null && split.length > 0) {
                for (String str2 : split) {
                    String[] split2 = str2.split("=");
                    if (split2.length == 2) {
                        hashMap.put(split2[0], split2[1]);
                    }
                }
            }
            return (String) hashMap.get("token");
        } catch (Exception unused) {
            C3800a.b();
            return "";
        }
    }

    private void a(Activity activity, String str, RPEventListener rPEventListener) {
        if (!C3925c.a()) {
            if (rPEventListener != null) {
                RPResult rPResult = RPResult.AUDIT_FAIL;
                rPEventListener.onFinish(rPResult, new RPDetail(a(rPResult, "-10415"), "-10415", "CTID SDK NOT EXIST", null));
                return;
            }
            return;
        }
        a(str, a(), "ctid");
        this.h = a(rPEventListener);
        if (b(str)) {
            this.m = "ctid";
            this.d = str;
            this.l = System.currentTimeMillis();
            C3800a.a(q, "startVerifyByNative token is: ".concat(String.valueOf(str)));
            this.h.onStart();
            GetCacheDataManager.getInstance().setUmidToken(this.i.h());
            a(activity, str, rPEventListener, new AnonymousClass4(rPEventListener, activity, str), this.i);
        }
    }

    private void a(CtidConfig ctidConfig) {
        this.p = ctidConfig;
    }

    public final void a(Context context, String str, String str2) {
        this.l = System.currentTimeMillis();
        Intent intent = new Intent();
        if (C3800a.a()) {
            C3800a.a(q, "processStartVerifyWithUrl: ".concat(String.valueOf(str)));
        }
        intent.putExtra("url", str);
        intent.putExtra("token", str2);
        intent.setFlags(268435456);
        intent.setClass(context, RPWebViewActivity.class);
        context.startActivity(intent);
    }

    private void a(RPEnv rPEnv) {
        this.e = rPEnv;
        C3890b c3890b = this.i;
        c3890b.a = rPEnv;
        c3890b.d = null;
        c3890b.e = null;
    }

    private void a(RPConfig rPConfig) {
        this.g = rPConfig;
    }

    public final AbstractC3853b a(final RPEventListener rPEventListener) {
        return new AbstractC3853b() { // from class: com.alibaba.security.realidentity.a.g.5
            {
                C3847g.this = this;
            }

            private void a(final RPResult rPResult, final RPDetail rPDetail, String str) {
                C3847g.this.a(rPResult, rPDetail.getCode(), rPDetail.getMsg(), str, rPDetail.getSubCode());
                C3847g.this.i.b();
                RPTrack.a();
                C3847g.this.a.release();
                C3812i.a();
                C3847g.this.b.post(new Runnable() { // from class: com.alibaba.security.realidentity.a.g.5.5
                    {
                        AnonymousClass5.this = this;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        C3847g.this.k = false;
                        rPEventListener.onFinish(rPResult, rPDetail);
                        C3848a.a.h = null;
                    }
                });
            }

            @Override // com.alibaba.security.realidentity.AbstractC3853b
            public final void b(RPResult rPResult, String str, String str2, String str3) {
                a(rPResult, new RPDetail(C3847g.a(rPResult, str), str, str2, null), str3);
            }

            @Override // com.alibaba.security.realidentity.RPEventListener
            public final void onBiometricsFinish(final int i) {
                C3847g.this.b.post(new Runnable() { // from class: com.alibaba.security.realidentity.a.g.5.3
                    {
                        AnonymousClass5.this = this;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        C3847g.this.k = false;
                        rPEventListener.onBiometricsFinish(i);
                        C3829a.C3830a.a.a(false);
                    }
                });
            }

            @Override // com.alibaba.security.realidentity.RPEventListener
            public final void onBiometricsStart() {
                C3847g.this.b.post(new Runnable() { // from class: com.alibaba.security.realidentity.a.g.5.2
                    {
                        AnonymousClass5.this = this;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        rPEventListener.onBiometricsStart();
                    }
                });
            }

            @Override // com.alibaba.security.realidentity.RPEventListener
            public final void onFinish(RPResult rPResult, RPDetail rPDetail) {
                rPDetail.setCode(C3847g.a(rPResult, rPDetail.getSubCode()));
                C3847g.a(rPDetail);
                a(rPResult, rPDetail, C3847g.this.d);
            }

            @Override // com.alibaba.security.realidentity.RPEventListener
            public final void onStart() {
                super.onStart();
                C3847g.this.b.post(new Runnable() { // from class: com.alibaba.security.realidentity.a.g.5.1
                    {
                        AnonymousClass5.this = this;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        rPEventListener.onStart();
                    }
                });
            }

            @Override // com.alibaba.security.realidentity.RPEventListener
            public final void onFinish(RPResult rPResult, String str, String str2) {
                RPDetail rPDetail = new RPDetail(C3847g.a(rPResult, str), str, str2, null);
                C3847g.a(rPDetail);
                a(rPResult, rPDetail, C3847g.this.d);
            }

            @Override // com.alibaba.security.realidentity.AbstractC3853b
            public final void a(final RPResult rPResult, final String str, final String str2, String str3) {
                final String a = C3847g.a(rPResult, str);
                C3847g.this.a(rPResult, a, str2, str3, str);
                C3847g.this.b.post(new Runnable() { // from class: com.alibaba.security.realidentity.a.g.5.4
                    {
                        AnonymousClass5.this = this;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        rPEventListener.onFinish(rPResult, new RPDetail(a, str, str2, null));
                    }
                });
            }
        };
    }

    public static String a(RPResult rPResult, String str) {
        try {
            return rPResult == RPResult.AUDIT_PASS ? "1" : GlobalErrorCode.mappingResultCode(Integer.decode(str).intValue());
        } catch (Exception unused) {
            return "-10000";
        }
    }

    public static void a(String str, TrackLog trackLog) {
        trackLog.setVerifyToken(str);
        trackLog.addTag9(VersionKey.RP_SDK_VERSION + "/3.3.0");
        trackLog.addTag10("Android");
        C3829a.C3830a.a.a(trackLog);
    }

    public final void a(String str, boolean z, String str2) {
        a(str, TrackLog.createStartBeginLog(str2, b().getFromSource(), z));
    }

    public final void a(RPResult rPResult, String str, String str2, String str3, String str4) {
        a(str3, TrackLog.createStartEndLog(this.m, str2, this.l, String.valueOf(rPResult.code), str, str4));
        C3829a.C3830a.a.a(false);
    }

    private void a(C3890b c3890b) {
        this.i = c3890b;
    }

    private void a(ScConfig scConfig) {
        this.n = scConfig;
    }

    private void a(boolean z) {
        this.o = z;
    }

    public static void a(Context context, String str, RPEventListener rPEventListener, Runnable runnable, C3890b c3890b) {
        new AsyncTaskC3875b(context, str, rPEventListener, runnable, c3890b).execute(AsyncTaskC3875b.g);
    }

    private void a(String str, Runnable runnable) {
        a(this.c, str, this.h, runnable, this.i);
    }

    public final byte[] a(byte[] bArr, String str) {
        return this.i.a(bArr, str);
    }

    private void a(long j) {
        this.l = j;
    }

    @Deprecated
    public final void a(TrackLog trackLog) {
        a(this.d, trackLog);
    }

    static /* synthetic */ void a(RPDetail rPDetail) {
        if (rPDetail != null && "1".equals(rPDetail.getCode())) {
            rPDetail.setSubCode("1");
        }
    }
}
