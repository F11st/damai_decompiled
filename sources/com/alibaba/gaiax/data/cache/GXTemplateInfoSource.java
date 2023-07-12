package com.alibaba.gaiax.data.cache;

import com.alibaba.gaiax.GXRegisterCenter;
import com.alibaba.gaiax.GXTemplateEngine;
import com.alibaba.gaiax.template.GXTemplateInfo;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.C8177b;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.k50;
import tb.wt2;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public final class GXTemplateInfoSource implements GXRegisterCenter.GXIExtensionTemplateInfoSource {
    @NotNull
    public static final C3359a Companion = new C3359a(null);
    @NotNull
    private static final Lazy<GXTemplateInfoSource> c;
    @NotNull
    private final ConcurrentHashMap<String, Object> a = new ConcurrentHashMap<>();
    @NotNull
    private final ConcurrentHashMap<String, ConcurrentHashMap<String, GXTemplateInfo>> b = new ConcurrentHashMap<>();

    /* compiled from: Taobao */
    /* renamed from: com.alibaba.gaiax.data.cache.GXTemplateInfoSource$a */
    /* loaded from: classes6.dex */
    public static final class C3359a {
        private C3359a() {
        }

        public /* synthetic */ C3359a(k50 k50Var) {
            this();
        }

        @NotNull
        public final GXTemplateInfoSource a() {
            return (GXTemplateInfoSource) GXTemplateInfoSource.c.getValue();
        }
    }

    static {
        Lazy<GXTemplateInfoSource> b;
        b = C8177b.b(new Function0<GXTemplateInfoSource>() { // from class: com.alibaba.gaiax.data.cache.GXTemplateInfoSource$Companion$instance$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final GXTemplateInfoSource invoke() {
                return new GXTemplateInfoSource();
            }
        });
        c = b;
    }

    private final void c(ConcurrentHashMap<String, GXTemplateInfo> concurrentHashMap, GXTemplateInfo gXTemplateInfo) {
        List<GXTemplateInfo> k = gXTemplateInfo.k();
        if (k == null) {
            return;
        }
        for (GXTemplateInfo gXTemplateInfo2 : k) {
            concurrentHashMap.put(gXTemplateInfo2.p().d(), gXTemplateInfo2);
            List<GXTemplateInfo> k2 = gXTemplateInfo2.k();
            boolean z = false;
            if (k2 != null && (!k2.isEmpty())) {
                z = true;
            }
            if (z) {
                c(concurrentHashMap, gXTemplateInfo2);
            }
        }
    }

    private final boolean d(String str, String str2) {
        ConcurrentHashMap<String, GXTemplateInfo> concurrentHashMap = this.b.get(str);
        return (concurrentHashMap == null ? null : concurrentHashMap.get(str2)) != null;
    }

    public final void b() {
        this.b.clear();
        this.a.clear();
    }

    @Override // com.alibaba.gaiax.GXRegisterCenter.GXIExtensionTemplateInfoSource
    @Nullable
    public GXTemplateInfo getTemplateInfo(@NotNull GXTemplateEngine.C3347i c3347i) {
        GXTemplateInfo g;
        b41.i(c3347i, "gxTemplateItem");
        if (d(c3347i.a(), c3347i.d())) {
            ConcurrentHashMap<String, GXTemplateInfo> concurrentHashMap = this.b.get(c3347i.a());
            GXTemplateInfo gXTemplateInfo = concurrentHashMap == null ? null : concurrentHashMap.get(c3347i.d());
            if (gXTemplateInfo != null) {
                return gXTemplateInfo;
            }
            throw new IllegalArgumentException("Template exist but reference is null");
        }
        String r = b41.r(c3347i.a(), c3347i.d());
        Object obj = this.a.get(r);
        if (obj == null) {
            obj = new Object();
            this.a.put(r, obj);
        }
        synchronized (obj) {
            g = GXTemplateInfo.Companion.g(c3347i);
            wt2 wt2Var = wt2.INSTANCE;
        }
        ConcurrentHashMap<String, GXTemplateInfo> concurrentHashMap2 = this.b.get(c3347i.a());
        if (concurrentHashMap2 == null) {
            concurrentHashMap2 = new ConcurrentHashMap<>();
            this.b.put(c3347i.a(), concurrentHashMap2);
        }
        concurrentHashMap2.put(c3347i.d(), g);
        c(concurrentHashMap2, g);
        return g;
    }
}
