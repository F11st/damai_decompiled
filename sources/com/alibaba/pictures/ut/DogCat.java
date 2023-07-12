package com.alibaba.pictures.ut;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.Rect;
import android.view.View;
import com.alibaba.pictures.ut.ExposureDog;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.weex.annotation.JSMethod;
import com.ut.mini.UTAnalytics;
import com.ut.mini.UTPageHitHelper;
import com.ut.mini.exposure.ExposureConfigMgr;
import com.ut.mini.internal.UTTeamWork;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;
import java.util.regex.Pattern;
import kotlin.Lazy;
import kotlin.b;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.text.Regex;
import kotlin.text.o;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.ff2;
import tb.qv2;
import tb.ss2;
import tb.ys2;
import tb.zg0;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public final class DogCat {
    private static transient /* synthetic */ IpChange $ipChange;
    @Nullable
    private static ff2 a;
    private static final Lazy c;
    private static final Lazy d;
    private static Object e;
    @Nullable
    private static String f;
    private static final List<ExposureDog.ExposureObserver> g;
    @NotNull
    public static final DogCat INSTANCE = new DogCat();
    private static final Rect b = new Rect();

    static {
        Lazy b2;
        Lazy b3;
        b2 = b.b(new Function0<HashMap<Integer, ClickCat>>() { // from class: com.alibaba.pictures.ut.DogCat$catMap$2
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final HashMap<Integer, ClickCat> invoke() {
                IpChange ipChange = $ipChange;
                return AndroidInstantRuntime.support(ipChange, "-302938289") ? (HashMap) ipChange.ipc$dispatch("-302938289", new Object[]{this}) : new HashMap<>();
            }
        });
        c = b2;
        b3 = b.b(new Function0<HashMap<Integer, ExposureDog>>() { // from class: com.alibaba.pictures.ut.DogCat$dogMap$2
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final HashMap<Integer, ExposureDog> invoke() {
                IpChange ipChange = $ipChange;
                return AndroidInstantRuntime.support(ipChange, "2067519529") ? (HashMap) ipChange.ipc$dispatch("2067519529", new Object[]{this}) : new HashMap<>();
            }
        });
        d = b3;
        g = new ArrayList();
        ys2.INSTANCE.a();
    }

    private DogCat() {
    }

    private final String A(Object obj, String str) {
        boolean F;
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "1268499157")) {
            return (String) ipChange.ipc$dispatch("1268499157", new Object[]{this, obj, str});
        }
        qv2.a("tryGetAndUpdatePageName,tPageName=" + str);
        if ((str == null || str.length() == 0) && (obj instanceof IUTPageOperation)) {
            IUTPageOperation iUTPageOperation = (IUTPageOperation) obj;
            f = iUTPageOperation.getPageSPM();
            str = iUTPageOperation.getUTPageName();
        }
        if (!(str == null || str.length() == 0)) {
            String str2 = f;
            if (str2 == null || str2.length() == 0) {
                f = ys2.INSTANCE.h(str);
            }
        }
        if (str == null || str.length() == 0) {
            return str;
        }
        ys2 ys2Var = ys2.INSTANCE;
        String e2 = ys2Var.e();
        if (e2 != null && e2.length() != 0) {
            z = false;
        }
        if (z) {
            return str;
        }
        String e3 = ys2Var.e();
        b41.f(e3);
        F = o.F(str, e3, false, 2, null);
        if (F) {
            return str;
        }
        return ys2Var.e() + str;
    }

    private final double E(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-462858656")) {
            return ((Double) ipChange.ipc$dispatch("-462858656", new Object[]{this, view})).doubleValue();
        }
        int width = view.getWidth();
        int height = view.getHeight();
        Rect rect = b;
        int i = width * height;
        if (!view.getGlobalVisibleRect(rect) || i <= 0) {
            return 0.0d;
        }
        return ((com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.width(rect) * com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.height(rect)) * 1.0d) / i;
    }

    public static /* synthetic */ String b(DogCat dogCat, String str, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = null;
        }
        return dogCat.a(str, str2);
    }

    @JvmStatic
    @Nullable
    public static final <T extends Activity> T n(@NotNull View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1328279637")) {
            return (T) ipChange.ipc$dispatch("1328279637", new Object[]{view});
        }
        b41.i(view, "view");
        for (Context context = view.getContext(); context instanceof ContextWrapper; context = ((ContextWrapper) context).getBaseContext()) {
            if (context instanceof Activity) {
                return (T) context;
            }
        }
        return null;
    }

    private final Map<Integer, ExposureDog> p() {
        IpChange ipChange = $ipChange;
        return (Map) (AndroidInstantRuntime.support(ipChange, "1694955811") ? ipChange.ipc$dispatch("1694955811", new Object[]{this}) : d.getValue());
    }

    @Nullable
    public final String B(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-129822273")) {
            return (String) ipChange.ipc$dispatch("-129822273", new Object[]{this, str});
        }
        if (str == null || str.length() == 0) {
            return null;
        }
        try {
            List<String> split = new Regex("\\.").split(str, 0);
            if (split.size() >= 4) {
                return split.get(3);
            }
            return split.size() >= 2 ? split.get(split.size() - 1) : "0";
        } catch (Exception e2) {
            qv2.c("tryGetSpmD-error:" + e2.getMessage());
            return null;
        }
    }

    public final void C(@Nullable Object obj, @Nullable Properties properties) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "914096019")) {
            ipChange.ipc$dispatch("914096019", new Object[]{this, obj, properties});
        } else if (obj != null && properties != null && properties.size() > 0) {
            HashMap hashMap = new HashMap();
            for (Map.Entry entry : properties.entrySet()) {
                Object key = entry.getKey();
                Object value = entry.getValue();
                hashMap.put(key.toString(), value.toString());
                qv2.a("updatePageProperties:" + key + ',' + value);
            }
            qv2.a("updatePageProperties:" + obj);
            UTAnalytics uTAnalytics = UTAnalytics.getInstance();
            b41.h(uTAnalytics, "UTAnalytics.getInstance()");
            uTAnalytics.getDefaultTracker().updatePageProperties(obj, hashMap);
        }
    }

    public final void D(@NotNull String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1915926485")) {
            ipChange.ipc$dispatch("-1915926485", new Object[]{this, str});
            return;
        }
        b41.i(str, "spm");
        HashMap hashMap = new HashMap(1);
        hashMap.put("spm", str);
        UTAnalytics uTAnalytics = UTAnalytics.getInstance();
        b41.h(uTAnalytics, "UTAnalytics.getInstance()");
        uTAnalytics.getDefaultTracker().updateNextPageProperties(hashMap);
    }

    /* JADX WARN: Code restructure failed: missing block: B:91:?, code lost:
        return f() + '.' + r8;
     */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.String a(@org.jetbrains.annotations.Nullable java.lang.String r8, @org.jetbrains.annotations.Nullable java.lang.String r9) {
        /*
            Method dump skipped, instructions count: 261
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.pictures.ut.DogCat.a(java.lang.String, java.lang.String):java.lang.String");
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x002e A[Catch: Exception -> 0x0029, TRY_LEAVE, TryCatch #0 {Exception -> 0x0029, blocks: (B:33:0x0020, B:41:0x002e), top: B:49:0x0020 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean c(@org.jetbrains.annotations.Nullable java.lang.String r6) {
        /*
            r5 = this;
            com.android.alibaba.ip.runtime.IpChange r0 = com.alibaba.pictures.ut.DogCat.$ipChange
            java.lang.String r1 = "-1196338313"
            boolean r2 = com.android.alibaba.ip.runtime.AndroidInstantRuntime.support(r0, r1)
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L1e
            r2 = 2
            java.lang.Object[] r2 = new java.lang.Object[r2]
            r2[r4] = r5
            r2[r3] = r6
            java.lang.Object r6 = r0.ipc$dispatch(r1, r2)
            java.lang.Boolean r6 = (java.lang.Boolean) r6
            boolean r6 = r6.booleanValue()
            return r6
        L1e:
            if (r6 == 0) goto L2b
            int r0 = r6.length()     // Catch: java.lang.Exception -> L29
            if (r0 != 0) goto L27
            goto L2b
        L27:
            r0 = 0
            goto L2c
        L29:
            r6 = move-exception
            goto L41
        L2b:
            r0 = 1
        L2c:
            if (r0 != 0) goto L5a
            java.lang.String r0 = "\\."
            kotlin.text.Regex r1 = new kotlin.text.Regex     // Catch: java.lang.Exception -> L29
            r1.<init>(r0)     // Catch: java.lang.Exception -> L29
            java.util.List r6 = r1.split(r6, r4)     // Catch: java.lang.Exception -> L29
            int r6 = r6.size()     // Catch: java.lang.Exception -> L29
            r0 = 4
            if (r6 != r0) goto L5a
            goto L5b
        L41:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "checkElementSpmLegal-error:"
            r0.append(r1)
            java.lang.String r6 = r6.getMessage()
            r0.append(r6)
            java.lang.String r6 = r0.toString()
            tb.qv2.c(r6)
            return r4
        L5a:
            r3 = 0
        L5b:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.pictures.ut.DogCat.c(java.lang.String):boolean");
    }

    @NotNull
    public final ClickCat d() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1475618820") ? (ClickCat) ipChange.ipc$dispatch("1475618820", new Object[]{this}) : new ClickCat(null);
    }

    @Nullable
    public final String e() {
        IpChange ipChange = $ipChange;
        boolean z = false;
        if (AndroidInstantRuntime.support(ipChange, "1601830543")) {
            return (String) ipChange.ipc$dispatch("1601830543", new Object[]{this});
        }
        UTPageHitHelper uTPageHitHelper = UTPageHitHelper.getInstance();
        b41.h(uTPageHitHelper, "UTPageHitHelper.getInstance()");
        String currentPageName = uTPageHitHelper.getCurrentPageName();
        if ((currentPageName == null || currentPageName.length() == 0) ? true : true) {
            Object obj = e;
            if (obj instanceof IUTPageOperation) {
                Objects.requireNonNull(obj, "null cannot be cast to non-null type com.alibaba.pictures.ut.IUTPageOperation");
                return ((IUTPageOperation) obj).getUTPageName();
            }
            return currentPageName;
        }
        return currentPageName;
    }

    @Nullable
    public final String f() {
        IpChange ipChange = $ipChange;
        boolean z = false;
        if (AndroidInstantRuntime.support(ipChange, "-1905928542")) {
            return (String) ipChange.ipc$dispatch("-1905928542", new Object[]{this});
        }
        String e2 = e();
        ys2 ys2Var = ys2.INSTANCE;
        String h = ys2Var.h(e2);
        if (h == null || h.length() == 0) {
            h = f;
        }
        if (!(h == null || h.length() == 0)) {
            e2 = h;
        }
        if ((e2 == null || e2.length() == 0) ? true : true) {
            return ys2Var.c();
        }
        return ys2Var.f() + '.' + e2;
    }

    @NotNull
    public final zg0 g() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "769245380") ? (zg0) ipChange.ipc$dispatch("769245380", new Object[]{this}) : new zg0();
    }

    @NotNull
    public final ExposureDog h() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "2096553074") ? (ExposureDog) ipChange.ipc$dispatch("2096553074", new Object[]{this}) : new ExposureDog(null);
    }

    @NotNull
    public final ExposureDog i(@NotNull View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1361682202")) {
            return (ExposureDog) ipChange.ipc$dispatch("-1361682202", new Object[]{this, view});
        }
        b41.i(view, "view");
        ExposureDog exposureDog = p().get(Integer.valueOf(view.hashCode()));
        if (exposureDog == null) {
            ExposureDog exposureDog2 = new ExposureDog(view);
            p().put(Integer.valueOf(view.hashCode()), exposureDog2);
            return exposureDog2;
        }
        exposureDog.j(null);
        exposureDog.q(null);
        return exposureDog;
    }

    @Nullable
    public final String j(@Nullable String str) {
        boolean F;
        boolean F2;
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "733190009")) {
            return (String) ipChange.ipc$dispatch("733190009", new Object[]{this, str});
        }
        if (str != null && str.length() != 0) {
            z = false;
        }
        if (!z) {
            F = o.F(str, "Page_", false, 2, null);
            if (!F) {
                F2 = o.F(str, "page_", false, 2, null);
                if (!F2) {
                    return b41.r(ys2.INSTANCE.e(), str);
                }
            }
        }
        return e();
    }

    /* JADX WARN: Removed duplicated region for block: B:98:0x00d3 A[Catch: Exception -> 0x0112, TryCatch #0 {Exception -> 0x0112, blocks: (B:64:0x0021, B:67:0x003b, B:79:0x0086, B:86:0x0099, B:88:0x00ab, B:90:0x00b1, B:92:0x00c7, B:98:0x00d3, B:100:0x00e5, B:102:0x00eb, B:103:0x00ff, B:68:0x0049, B:70:0x004f, B:71:0x005d, B:73:0x0063, B:74:0x0071, B:76:0x0077), top: B:108:0x0021 }] */
    @org.jetbrains.annotations.NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.String k(@org.jetbrains.annotations.Nullable java.lang.String r20) {
        /*
            Method dump skipped, instructions count: 283
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.pictures.ut.DogCat.k(java.lang.String):java.lang.String");
    }

    @NotNull
    public final String l(@Nullable String str, @Nullable String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1687697508")) {
            return (String) ipChange.ipc$dispatch("1687697508", new Object[]{this, str, str2});
        }
        String j = j(str);
        if (j == null) {
            j = "";
        }
        return j + JSMethod.NOT_SET + k(str2);
    }

    /* JADX WARN: Removed duplicated region for block: B:64:0x0073 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:71:? A[RETURN, SYNTHETIC] */
    @org.jetbrains.annotations.NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.String m(@org.jetbrains.annotations.Nullable android.view.View r5) {
        /*
            r4 = this;
            com.android.alibaba.ip.runtime.IpChange r0 = com.alibaba.pictures.ut.DogCat.$ipChange
            java.lang.String r1 = "1823907999"
            boolean r2 = com.android.alibaba.ip.runtime.AndroidInstantRuntime.support(r0, r1)
            if (r2 == 0) goto L1a
            r2 = 2
            java.lang.Object[] r2 = new java.lang.Object[r2]
            r3 = 0
            r2[r3] = r4
            r3 = 1
            r2[r3] = r5
            java.lang.Object r5 = r0.ipc$dispatch(r1, r2)
            java.lang.String r5 = (java.lang.String) r5
            return r5
        L1a:
            r0 = 0
            if (r5 == 0) goto L68
            int r1 = r5.getId()
            r2 = -1
            if (r1 != r2) goto L25
            goto L68
        L25:
            android.content.res.Resources r1 = r5.getResources()     // Catch: java.lang.Throwable -> L40 java.lang.Exception -> L42
            int r2 = r5.getId()     // Catch: java.lang.Throwable -> L40 java.lang.Exception -> L42
            java.lang.String r0 = r1.getResourceEntryName(r2)     // Catch: java.lang.Throwable -> L40 java.lang.Exception -> L42
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            if (r1 == 0) goto L70
            int r5 = r5.getId()
            java.lang.String r0 = java.lang.String.valueOf(r5)
            goto L70
        L40:
            r1 = move-exception
            goto L5a
        L42:
            int r1 = r5.getId()     // Catch: java.lang.Throwable -> L40
            java.lang.String r0 = java.lang.String.valueOf(r1)     // Catch: java.lang.Throwable -> L40
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            if (r1 == 0) goto L70
            int r5 = r5.getId()
            java.lang.String r5 = java.lang.String.valueOf(r5)
            r0 = r5
            goto L70
        L5a:
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L67
            int r5 = r5.getId()
            java.lang.String.valueOf(r5)
        L67:
            throw r1
        L68:
            int r5 = android.view.View.generateViewId()
            java.lang.String r0 = java.lang.String.valueOf(r5)
        L70:
            if (r0 == 0) goto L73
            goto L75
        L73:
            java.lang.String r0 = "general"
        L75:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.pictures.ut.DogCat.m(android.view.View):java.lang.String");
    }

    @Nullable
    public final Map<String, String> o() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-184391818") ? (Map) ipChange.ipc$dispatch("-184391818", new Object[]{this}) : UTPageHitHelper.getInstance().getPageProperties(e);
    }

    @Nullable
    public final String q(@Nullable String str) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1078604805") ? (String) ipChange.ipc$dispatch("-1078604805", new Object[]{this, str}) : ys2.INSTANCE.h(str);
    }

    @Nullable
    public final String r(@Nullable View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-260162711")) {
            return (String) ipChange.ipc$dispatch("-260162711", new Object[]{this, view});
        }
        if (view == null) {
            return null;
        }
        Object tag = view.getTag(ss2.a());
        if (tag instanceof String) {
            return (String) tag;
        }
        return null;
    }

    @Nullable
    public final ff2 s() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "402634912") ? (ff2) ipChange.ipc$dispatch("402634912", new Object[]{this}) : a;
    }

    public final boolean t(@NotNull String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1200713009")) {
            return ((Boolean) ipChange.ipc$dispatch("-1200713009", new Object[]{this, str})).booleanValue();
        }
        b41.i(str, "str");
        try {
            return Pattern.compile("[0-9]*").matcher(str).matches();
        } catch (Exception unused) {
            return false;
        }
    }

    public final boolean u(@NotNull View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1428745888")) {
            return ((Boolean) ipChange.ipc$dispatch("-1428745888", new Object[]{this, view})).booleanValue();
        }
        b41.i(view, "view");
        return E(view) >= ExposureConfigMgr.dimThreshold;
    }

    public final void v(@Nullable Object obj, @Nullable String str) {
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "-756605368")) {
            ipChange.ipc$dispatch("-756605368", new Object[]{this, obj, str});
        } else if (obj == null) {
        } else {
            String A = A(obj, str);
            qv2.a("pageAppear:" + obj + ",name=" + A);
            if (A != null && A.length() != 0) {
                z = false;
            }
            if (z) {
                return;
            }
            UTAnalytics uTAnalytics = UTAnalytics.getInstance();
            b41.h(uTAnalytics, "UTAnalytics.getInstance()");
            uTAnalytics.getDefaultTracker().pageAppear(obj, A);
            while (true) {
                List<ExposureDog.ExposureObserver> list = g;
                if (list.size() > 0) {
                    ExposureDog.ExposureObserver remove = list.remove(0);
                    if (remove != null) {
                        remove.run();
                    }
                } else {
                    e = obj;
                    return;
                }
            }
        }
    }

    public final void w(@Nullable Object obj, @Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1372063289")) {
            ipChange.ipc$dispatch("-1372063289", new Object[]{this, obj, str});
        } else if (obj == null) {
        } else {
            String A = A(obj, str);
            UTAnalytics uTAnalytics = UTAnalytics.getInstance();
            b41.h(uTAnalytics, "UTAnalytics.getInstance()");
            uTAnalytics.getDefaultTracker().pageAppearDonotSkip(obj, A);
            while (true) {
                List<ExposureDog.ExposureObserver> list = g;
                if (list.size() > 0) {
                    ExposureDog.ExposureObserver remove = list.remove(0);
                    if (remove != null) {
                        remove.run();
                    }
                } else {
                    e = obj;
                    return;
                }
            }
        }
    }

    public final void x(@Nullable Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "578019980")) {
            ipChange.ipc$dispatch("578019980", new Object[]{this, obj});
        } else if (obj == null) {
        } else {
            qv2.a("pageDisAppear:" + obj);
            UTAnalytics uTAnalytics = UTAnalytics.getInstance();
            b41.h(uTAnalytics, "UTAnalytics.getInstance()");
            uTAnalytics.getDefaultTracker().pageDisAppear(obj);
            f = null;
            while (true) {
                List<ExposureDog.ExposureObserver> list = g;
                if (list.size() <= 0) {
                    return;
                }
                ExposureDog.ExposureObserver remove = list.remove(0);
                if (remove != null) {
                    remove.run();
                }
            }
        }
    }

    public final void y(@Nullable Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "565755604")) {
            ipChange.ipc$dispatch("565755604", new Object[]{this, obj});
            return;
        }
        UTAnalytics uTAnalytics = UTAnalytics.getInstance();
        b41.h(uTAnalytics, "UTAnalytics.getInstance()");
        uTAnalytics.getDefaultTracker().skipPage(obj);
    }

    public final void z(@Nullable Activity activity) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2078132769")) {
            ipChange.ipc$dispatch("2078132769", new Object[]{this, activity});
        } else if (activity != null) {
            UTTeamWork.getInstance().startExpoTrack(activity);
        }
    }
}
