package com.alibaba.gaiax.utils;

import com.alibaba.gaiax.GXTemplateEngine;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.b;
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
    public static final a Companion = new a(null);
    @NotNull
    private static final Lazy<GXGlobalCache> c;
    @NotNull
    private final Map<GXTemplateEngine.i, l81> a = new LinkedHashMap();
    @NotNull
    private final Map<GXTemplateEngine.i, l81> b = new LinkedHashMap();

    /* compiled from: Taobao */
    /* loaded from: classes6.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(k50 k50Var) {
            this();
        }

        @NotNull
        public final GXGlobalCache a() {
            return (GXGlobalCache) GXGlobalCache.c.getValue();
        }
    }

    static {
        Lazy<GXGlobalCache> b;
        b = b.b(new Function0<GXGlobalCache>() { // from class: com.alibaba.gaiax.utils.GXGlobalCache$Companion$instance$2
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
    public final l81 c(@NotNull GXTemplateEngine.i iVar) {
        b41.i(iVar, "key");
        return this.a.get(iVar);
    }

    @Nullable
    public final l81 d(@NotNull GXTemplateEngine.i iVar) {
        b41.i(iVar, "key");
        return this.b.get(iVar);
    }

    public final boolean e(@NotNull GXTemplateEngine.i iVar) {
        b41.i(iVar, "key");
        return this.a.containsKey(iVar);
    }

    public final boolean f(@NotNull GXTemplateEngine.i iVar) {
        b41.i(iVar, "key");
        return this.b.containsKey(iVar);
    }

    public final void g(@NotNull GXTemplateEngine.i iVar, @NotNull l81 l81Var) {
        b41.i(iVar, "key");
        b41.i(l81Var, "value");
        this.a.put(iVar, l81Var);
        kr0 kr0Var = kr0.INSTANCE;
        if (kr0Var.b()) {
            kr0Var.a("putLayoutForPrepareView key=" + iVar.hashCode() + " value=" + l81Var);
        }
    }

    public final void h(@NotNull GXTemplateEngine.i iVar, @NotNull l81 l81Var) {
        b41.i(iVar, "key");
        b41.i(l81Var, "value");
        this.b.put(iVar, l81Var);
    }
}
