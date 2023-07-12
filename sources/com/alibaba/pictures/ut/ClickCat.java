package com.alibaba.pictures.ut;

import android.view.View;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.ut.mini.UTAnalytics;
import com.ut.mini.UTHitBuilders;
import java.util.HashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.b;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.ff2;
import tb.qv2;
import tb.ys2;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public final class ClickCat {
    private static transient /* synthetic */ IpChange $ipChange;
    private String a;
    private String b;
    private String c;
    private boolean d;
    private boolean e;
    private View.AccessibilityDelegate f;
    private final Lazy g;
    private final View h;

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public static final class a extends View.AccessibilityDelegate {
        private static transient /* synthetic */ IpChange $ipChange;
        @NotNull
        private ClickCat a;

        public a(@NotNull ClickCat clickCat) {
            b41.i(clickCat, "clickCat");
            this.a = clickCat;
        }

        public final void a() {
            UTHitBuilders.UTControlHitBuilder uTControlHitBuilder;
            Map<String, String> o;
            DogCat dogCat;
            ff2 s;
            IpChange ipChange = $ipChange;
            boolean z = false;
            if (AndroidInstantRuntime.support(ipChange, "326109968")) {
                ipChange.ipc$dispatch("326109968", new Object[]{this});
                return;
            }
            String str = this.a.a;
            if (str == null || str.length() == 0) {
                ClickCat clickCat = this.a;
                clickCat.a = DogCat.INSTANCE.k(clickCat.c);
            }
            String str2 = this.a.b;
            if (str2 == null || str2.length() == 0) {
                uTControlHitBuilder = new UTHitBuilders.UTControlHitBuilder(this.a.a);
            } else {
                uTControlHitBuilder = new UTHitBuilders.UTControlHitBuilder(DogCat.INSTANCE.j(str2), this.a.a);
            }
            IClkParamsHandler g = ys2.INSTANCE.g();
            if (g != null) {
                g.onHandle(this.a.l(), this.a.d);
            }
            uTControlHitBuilder.setProperties(this.a.l());
            String str3 = this.a.c;
            String r = !(str3 == null || str3.length() == 0) ? this.a.c : DogCat.INSTANCE.r(this.a.h);
            if (r == null || r.length() == 0) {
                r = DogCat.b(DogCat.INSTANCE, this.a.a, null, 2, null);
            }
            if ((r == null || r.length() == 0) && (s = (dogCat = DogCat.INSTANCE).s()) != null && !s.c()) {
                ff2 s2 = dogCat.s();
                String a = s2 != null ? s2.a() : null;
                ff2 s3 = dogCat.s();
                if (s3 != null) {
                    s3.d(true);
                }
                r = a;
            }
            if ((r == null || r.length() == 0) ? true : true) {
                qv2.c("click-emit-cancel: spm is null");
                return;
            }
            DogCat dogCat2 = DogCat.INSTANCE;
            if (!dogCat2.c(r)) {
                qv2.d("click-emit: spm is unLegal : ctrlName=" + this.a.a + ", spm=" + r);
            }
            uTControlHitBuilder.setProperty("spm", r);
            if (this.a.d) {
                HashMap hashMap = new HashMap();
                hashMap.put("spm-url", r);
                hashMap.put("spm", r);
                hashMap.putAll(this.a.l());
                UTAnalytics uTAnalytics = UTAnalytics.getInstance();
                b41.h(uTAnalytics, "UTAnalytics.getInstance()");
                uTAnalytics.getDefaultTracker().updateNextPageProperties(hashMap);
            }
            if (this.a.e && (o = dogCat2.o()) != null) {
                uTControlHitBuilder.setProperties(o);
            }
            qv2.a("click-emit: " + this.a.a);
            UTAnalytics uTAnalytics2 = UTAnalytics.getInstance();
            b41.h(uTAnalytics2, "UTAnalytics.getInstance()");
            uTAnalytics2.getDefaultTracker().send(uTControlHitBuilder.build());
        }

        @Override // android.view.View.AccessibilityDelegate
        public void sendAccessibilityEvent(@NotNull View view, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-481948896")) {
                ipChange.ipc$dispatch("-481948896", new Object[]{this, view, Integer.valueOf(i)});
                return;
            }
            b41.i(view, "host");
            super.sendAccessibilityEvent(view, i);
            View.AccessibilityDelegate accessibilityDelegate = this.a.f;
            if (accessibilityDelegate != null) {
                accessibilityDelegate.sendAccessibilityEvent(view, i);
            }
            if (i == 1 || i == 2) {
                a();
            }
        }
    }

    public ClickCat(@Nullable View view) {
        Lazy b;
        this.h = view;
        b = b.b(new Function0<HashMap<String, String>>() { // from class: com.alibaba.pictures.ut.ClickCat$params$2
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final HashMap<String, String> invoke() {
                IpChange ipChange = $ipChange;
                return AndroidInstantRuntime.support(ipChange, "-129683141") ? (HashMap) ipChange.ipc$dispatch("-129683141", new Object[]{this}) : new HashMap<>();
            }
        });
        this.g = b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Map<String, String> l() {
        IpChange ipChange = $ipChange;
        return (Map) (AndroidInstantRuntime.support(ipChange, "1311907817") ? ipChange.ipc$dispatch("1311907817", new Object[]{this}) : this.g.getValue());
    }

    public final void j() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1247353219")) {
            ipChange.ipc$dispatch("1247353219", new Object[]{this});
            return;
        }
        a aVar = new a(this);
        View view = this.h;
        if (view == null) {
            aVar.a();
            return;
        }
        if (!view.isClickable()) {
            this.h.setClickable(true);
        }
        this.h.setAccessibilityDelegate(aVar);
    }

    @NotNull
    public final ClickCat k(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1876761198")) {
            return (ClickCat) ipChange.ipc$dispatch("-1876761198", new Object[]{this, str});
        }
        this.a = str;
        return this;
    }

    @NotNull
    public final ClickCat m(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1154692147")) {
            return (ClickCat) ipChange.ipc$dispatch("-1154692147", new Object[]{this, Boolean.valueOf(z)});
        }
        this.d = z;
        return this;
    }

    @NotNull
    public final ClickCat n(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1989062474")) {
            return (ClickCat) ipChange.ipc$dispatch("-1989062474", new Object[]{this, str});
        }
        this.b = str;
        return this;
    }

    @NotNull
    public final ClickCat o(@Nullable Map<String, String> map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1806168591")) {
            return (ClickCat) ipChange.ipc$dispatch("1806168591", new Object[]{this, map});
        }
        if (map != null) {
            l().putAll(map);
        }
        return this;
    }

    @NotNull
    public final ClickCat p(@NotNull String... strArr) {
        int i;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1165367733")) {
            return (ClickCat) ipChange.ipc$dispatch("1165367733", new Object[]{this, strArr});
        }
        b41.i(strArr, "args");
        for (int i2 = 0; i2 < strArr.length && (i = i2 + 1) < strArr.length; i2 += 2) {
            l().put(strArr[i2], strArr[i]);
        }
        return this;
    }

    @NotNull
    public final ClickCat q(@Nullable String str, @Nullable String str2, @Nullable String str3) {
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "788857691")) {
            return (ClickCat) ipChange.ipc$dispatch("788857691", new Object[]{this, str, str2, str3});
        }
        if (str != null && str.length() != 0) {
            z = false;
        }
        if (z) {
            return r(str2, str3);
        }
        DogCat dogCat = DogCat.INSTANCE;
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append('.');
        if (str2 == null) {
            str2 = "default";
        }
        sb.append(str2);
        sb.append('.');
        if (str3 == null) {
            str3 = "0";
        }
        sb.append(str3);
        this.c = DogCat.b(dogCat, sb.toString(), null, 2, null);
        return this;
    }

    @NotNull
    public final ClickCat r(@Nullable String str, @Nullable String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "104672877")) {
            return (ClickCat) ipChange.ipc$dispatch("104672877", new Object[]{this, str, str2});
        }
        DogCat dogCat = DogCat.INSTANCE;
        StringBuilder sb = new StringBuilder();
        if (str == null) {
            str = "default";
        }
        sb.append(str);
        sb.append('.');
        if (str2 == null) {
            str2 = "0";
        }
        sb.append(str2);
        this.c = DogCat.b(dogCat, sb.toString(), null, 2, null);
        return this;
    }
}
