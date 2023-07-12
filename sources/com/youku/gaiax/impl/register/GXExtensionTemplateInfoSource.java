package com.youku.gaiax.impl.register;

import android.content.Context;
import android.os.SystemClock;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.gaiax.GXRegisterCenter;
import com.alibaba.gaiax.GXTemplateEngine;
import com.alibaba.gaiax.template.GXIExpression;
import com.alibaba.gaiax.template.GXTemplateInfo;
import com.youku.arch.v3.data.Constants;
import com.youku.gaiax.api.proxy.IProxyApp;
import com.youku.gaiax.impl.GaiaXExpression;
import com.youku.gaiax.impl.GaiaXMonitor;
import com.youku.gaiax.impl.GaiaXProxy;
import com.youku.gaiax.impl.js.GaiaXJSDelegate;
import com.youku.gaiax.impl.utils.ExceptionUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.C8177b;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.k50;
import tb.ns0;
import tb.rq0;
import tb.wt2;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\t\u0018\u0000 !2\u00020\u0001:\u0001!B\u0007¢\u0006\u0004\b\u001f\u0010 J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0004H\u0002J$\u0010\r\u001a\u00020\u00072\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00040\t2\u0006\u0010\f\u001a\u00020\u0004H\u0002J\u0016\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\nJ\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0016\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\nJ\u0018\u0010\u0017\u001a\u0014\u0012\u0004\u0012\u00020\n\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u00160\u0015J\u0006\u0010\u0018\u001a\u00020\u0007R\"\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00190\t8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR1\u0010\u001c\u001a\u001a\u0012\u0004\u0012\u00020\n\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00040\t0\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u001b\u001a\u0004\b\u001d\u0010\u001e¨\u0006\""}, d2 = {"Lcom/youku/gaiax/impl/register/GXExtensionTemplateInfoSource;", "Lcom/alibaba/gaiax/GXRegisterCenter$GXIExtensionTemplateInfoSource;", "Lcom/alibaba/gaiax/GXTemplateEngine$i;", "gxTemplateItem", "Lcom/alibaba/gaiax/template/GXTemplateInfo;", "getData", Constants.TEMPLATE, "Ltb/wt2;", "specialForTemplatePhoneDemand", "Ljava/util/concurrent/ConcurrentHashMap;", "", "bizList", "info", "collectionNestTemplate", "templateBiz", "templateId", "", "exist", "getTemplateInfo", "Lcom/alibaba/fastjson/JSONObject;", "getTemplate", "", "", "getAllTemplate", com.youku.live.livesdk.wkit.component.Constants.TAG_CLEAR_STRING, "", "dataLock", "Ljava/util/concurrent/ConcurrentHashMap;", "dataCache", "getDataCache", "()Ljava/util/concurrent/ConcurrentHashMap;", "<init>", "()V", "Companion", "GaiaX-Android"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class GXExtensionTemplateInfoSource implements GXRegisterCenter.GXIExtensionTemplateInfoSource {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private static final Lazy<GXExtensionTemplateInfoSource> instance$delegate;
    @NotNull
    private final ConcurrentHashMap<String, Object> dataLock = new ConcurrentHashMap<>();
    @NotNull
    private final ConcurrentHashMap<String, ConcurrentHashMap<String, GXTemplateInfo>> dataCache = new ConcurrentHashMap<>();

    /* compiled from: Taobao */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tR\u001d\u0010\u0007\u001a\u00020\u00028F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/youku/gaiax/impl/register/GXExtensionTemplateInfoSource$Companion;", "", "Lcom/youku/gaiax/impl/register/GXExtensionTemplateInfoSource;", "instance$delegate", "Lkotlin/Lazy;", "getInstance", "()Lcom/youku/gaiax/impl/register/GXExtensionTemplateInfoSource;", "instance", "<init>", "()V", "GaiaX-Android"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(k50 k50Var) {
            this();
        }

        @NotNull
        public final GXExtensionTemplateInfoSource getInstance() {
            return (GXExtensionTemplateInfoSource) GXExtensionTemplateInfoSource.instance$delegate.getValue();
        }
    }

    static {
        Lazy<GXExtensionTemplateInfoSource> b;
        b = C8177b.b(new Function0<GXExtensionTemplateInfoSource>() { // from class: com.youku.gaiax.impl.register.GXExtensionTemplateInfoSource$Companion$instance$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final GXExtensionTemplateInfoSource invoke() {
                return new GXExtensionTemplateInfoSource();
            }
        });
        instance$delegate = b;
    }

    private final void collectionNestTemplate(ConcurrentHashMap<String, GXTemplateInfo> concurrentHashMap, GXTemplateInfo gXTemplateInfo) {
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
                collectionNestTemplate(concurrentHashMap, gXTemplateInfo2);
            }
        }
    }

    private final GXTemplateInfo getData(GXTemplateEngine.C3347i c3347i) {
        GXTemplateInfo g;
        if (exist(c3347i.a(), c3347i.d())) {
            ConcurrentHashMap<String, GXTemplateInfo> concurrentHashMap = this.dataCache.get(c3347i.a());
            GXTemplateInfo gXTemplateInfo = concurrentHashMap == null ? null : concurrentHashMap.get(c3347i.d());
            if (gXTemplateInfo != null) {
                return gXTemplateInfo;
            }
            throw new IllegalArgumentException("Template exist but reference is null");
        }
        String r = b41.r(c3347i.a(), c3347i.d());
        Object obj = this.dataLock.get(r);
        if (obj == null) {
            obj = new Object();
            this.dataLock.put(r, obj);
        }
        synchronized (obj) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            g = GXTemplateInfo.Companion.g(c3347i);
            GaiaXMonitor.INSTANCE.onCreateC(c3347i, elapsedRealtime);
            wt2 wt2Var = wt2.INSTANCE;
        }
        specialForTemplatePhoneDemand(g);
        ConcurrentHashMap<String, GXTemplateInfo> concurrentHashMap2 = getDataCache().get(c3347i.a());
        if (concurrentHashMap2 == null) {
            concurrentHashMap2 = new ConcurrentHashMap<>();
            getDataCache().put(c3347i.a(), concurrentHashMap2);
        }
        concurrentHashMap2.put(c3347i.d(), g);
        collectionNestTemplate(concurrentHashMap2, g);
        return g;
    }

    private final void specialForTemplatePhoneDemand(GXTemplateInfo gXTemplateInfo) {
        rq0 rq0Var;
        if (!b41.d(gXTemplateInfo.s().d(), "phone-demand") || gXTemplateInfo.s().h() == -1) {
            return;
        }
        if (gXTemplateInfo.n() == null || !b41.d(gXTemplateInfo.n(), "V2")) {
            ExceptionUtils exceptionUtils = ExceptionUtils.INSTANCE;
            exceptionUtils.throwExceptionOrAlarm(new IllegalArgumentException("phone-demand V2 but expVersion error version= " + gXTemplateInfo.s().h() + " expVersion=" + ((Object) gXTemplateInfo.n())), "5001");
        }
        Map<String, rq0> m = gXTemplateInfo.m();
        GXIExpression gXIExpression = null;
        if (m != null && (rq0Var = m.get("title")) != null) {
            gXIExpression = rq0Var.c();
        }
        if (gXIExpression instanceof GaiaXExpression) {
            ExceptionUtils exceptionUtils2 = ExceptionUtils.INSTANCE;
            exceptionUtils2.throwExceptionOrAlarm(new IllegalArgumentException("phone-demand V2 but title value error value = " + gXIExpression + " expression= " + ((GaiaXExpression) gXIExpression).expression() + " version= " + gXTemplateInfo.s().h() + " expVersion=" + ((Object) gXTemplateInfo.n())), "5001");
        }
    }

    public final void clear() {
        this.dataCache.clear();
        this.dataLock.clear();
    }

    public final boolean exist(@NotNull String str, @NotNull String str2) {
        b41.i(str, "templateBiz");
        b41.i(str2, "templateId");
        ConcurrentHashMap<String, GXTemplateInfo> concurrentHashMap = this.dataCache.get(str);
        return (concurrentHashMap == null ? null : concurrentHashMap.get(str2)) != null;
    }

    @NotNull
    public final Map<String, List<JSONObject>> getAllTemplate() {
        HashMap hashMap = new HashMap();
        for (Map.Entry<String, ConcurrentHashMap<String, GXTemplateInfo>> entry : this.dataCache.entrySet()) {
            String key = entry.getKey();
            ArrayList arrayList = new ArrayList();
            for (Map.Entry<String, GXTemplateInfo> entry2 : entry.getValue().entrySet()) {
                ns0 s = entry2.getValue().s();
                JSONObject jSONObject = new JSONObject();
                JSONObject jSONObject2 = new JSONObject();
                GXTemplateInfo.Companion companion = GXTemplateInfo.Companion;
                jSONObject2.put((JSONObject) "index.json", (String) companion.n(s.f()));
                jSONObject2.put((JSONObject) "index.css", (String) companion.l(s.b()));
                jSONObject2.put((JSONObject) "index.databinding", (String) companion.m(s.c()));
                jSONObject2.put((JSONObject) "index.js", s.e());
                jSONObject.put((JSONObject) Constants.TEMPLATE, (String) jSONObject2);
                jSONObject.put((JSONObject) "templateId", s.d());
                jSONObject.put((JSONObject) "templateBiz", s.a());
                jSONObject.put((JSONObject) "templateVersion", (String) Integer.valueOf(s.h()));
                jSONObject.put((JSONObject) "templateType", "memory");
                arrayList.add(jSONObject);
            }
            hashMap.put(key, arrayList);
        }
        return hashMap;
    }

    @NotNull
    public final ConcurrentHashMap<String, ConcurrentHashMap<String, GXTemplateInfo>> getDataCache() {
        return this.dataCache;
    }

    @NotNull
    public final JSONObject getTemplate(@NotNull String str, @NotNull String str2) {
        GXTemplateInfo gXTemplateInfo;
        ns0 s;
        b41.i(str, "templateBiz");
        b41.i(str2, "templateId");
        ConcurrentHashMap<String, GXTemplateInfo> concurrentHashMap = this.dataCache.get(str);
        if (concurrentHashMap == null || (gXTemplateInfo = concurrentHashMap.get(str2)) == null || (s = gXTemplateInfo.s()) == null) {
            return new JSONObject();
        }
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        GXTemplateInfo.Companion companion = GXTemplateInfo.Companion;
        jSONObject2.put((JSONObject) "index.json", (String) companion.n(s.f()));
        jSONObject2.put((JSONObject) "index.css", (String) companion.l(s.b()));
        jSONObject2.put((JSONObject) "index.databinding", (String) companion.m(s.c()));
        jSONObject2.put((JSONObject) "index.js", s.e());
        jSONObject.put((JSONObject) Constants.TEMPLATE, (String) jSONObject2);
        jSONObject.put((JSONObject) "templateId", s.d());
        jSONObject.put((JSONObject) "templateBiz", s.a());
        jSONObject.put((JSONObject) "templateVersion", (String) Integer.valueOf(s.h()));
        jSONObject.put((JSONObject) "templateType", "memory");
        return jSONObject;
    }

    @Override // com.alibaba.gaiax.GXRegisterCenter.GXIExtensionTemplateInfoSource
    @Nullable
    public GXTemplateInfo getTemplateInfo(@NotNull GXTemplateEngine.C3347i c3347i) {
        IProxyApp app2;
        Context applicationContext;
        b41.i(c3347i, "gxTemplateItem");
        GXTemplateInfo data = getData(c3347i);
        boolean z = false;
        if (data != null && data.t()) {
            z = true;
        }
        if (z && (app2 = GaiaXProxy.Companion.getInstance().getApp()) != null && (applicationContext = app2.applicationContext()) != null) {
            GaiaXJSDelegate.INSTANCE.startEngine(applicationContext, new Function0<wt2>() { // from class: com.youku.gaiax.impl.register.GXExtensionTemplateInfoSource$getTemplateInfo$1$1
                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ wt2 invoke() {
                    invoke2();
                    return wt2.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }
            });
        }
        return data;
    }
}
