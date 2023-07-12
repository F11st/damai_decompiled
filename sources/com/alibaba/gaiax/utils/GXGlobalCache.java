package com.alibaba.gaiax.utils;

import com.alibaba.gaiax.GXTemplateEngine;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.C8177b;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.k50;
import tb.kr0;
import tb.l81;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public final class GXGlobalCache {
    @NotNull
    public static final C3417a Companion = new C3417a(null);
    @NotNull
    private static final Lazy<GXGlobalCache> c;
    @NotNull
    private final Map<GXTemplateEngine.C3347i, l81> a = new LinkedHashMap();
    @NotNull
    private final Map<GXTemplateEngine.C3347i, l81> b = new LinkedHashMap();

    /* compiled from: Taobao */
    /* renamed from: com.alibaba.gaiax.utils.GXGlobalCache$a */
    /* loaded from: classes6.dex */
    public static final class C3417a {
        private C3417a() {
        }

        public /* synthetic */ C3417a(k50 k50Var) {
            this();
        }

        @NotNull
        public final GXGlobalCache a() {
            return (GXGlobalCache) GXGlobalCache.c.getValue();
        }
    }

    static {
        Lazy<GXGlobalCache> b;
        b = C8177b.b(new Function0<GXGlobalCache>() { // from class: com.alibaba.gaiax.utils.GXGlobalCache$Companion$instance$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final GXGlobalCache invoke() {
                return new GXGlobalCache();
            }
        });
        c = b;
    }

    public final void b() {
        this.b.clear();
        this.a.clear();
    }

    @Nullable
    public final l81 c(@NotNull GXTemplateEngine.C3347i c3347i) {
        b41.i(c3347i, "key");
        return this.a.get(c3347i);
    }

    @Nullable
    public final l81 d(@NotNull GXTemplateEngine.C3347i c3347i) {
        b41.i(c3347i, "key");
        return this.b.get(c3347i);
    }

    public final boolean e(@NotNull GXTemplateEngine.C3347i c3347i) {
        b41.i(c3347i, "key");
        return this.a.containsKey(c3347i);
    }

    public final boolean f(@NotNull GXTemplateEngine.C3347i c3347i) {
        b41.i(c3347i, "key");
        return this.b.containsKey(c3347i);
    }

    public final void g(@NotNull GXTemplateEngine.C3347i c3347i, @NotNull l81 l81Var) {
        b41.i(c3347i, "key");
        b41.i(l81Var, "value");
        this.a.put(c3347i, l81Var);
        kr0 kr0Var = kr0.INSTANCE;
        if (kr0Var.b()) {
            kr0Var.a("putLayoutForPrepareView key=" + c3347i.hashCode() + " value=" + l81Var);
        }
    }

    public final void h(@NotNull GXTemplateEngine.C3347i c3347i, @NotNull l81 l81Var) {
        b41.i(c3347i, "key");
        b41.i(l81Var, "value");
        this.b.put(c3347i, l81Var);
    }
}
