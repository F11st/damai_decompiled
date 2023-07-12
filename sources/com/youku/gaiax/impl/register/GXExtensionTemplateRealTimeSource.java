package com.youku.gaiax.impl.register;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.gaiax.GXRegisterCenter;
import com.alibaba.gaiax.GXTemplateEngine;
import com.taobao.downloader.adpater.Monitor;
import com.taobao.tao.log.TLogConstant;
import com.youku.live.livesdk.wkit.component.Constants;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.b;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.k50;
import tb.ns0;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\u0006\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0007¢\u0006\u0004\b\u0011\u0010\u0012J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001e\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tJ\u0006\u0010\r\u001a\u00020\u000bR\"\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00040\u000e8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010¨\u0006\u0014"}, d2 = {"Lcom/youku/gaiax/impl/register/GXExtensionTemplateRealTimeSource;", "Lcom/alibaba/gaiax/GXRegisterCenter$GXIExtensionTemplateSource;", "Lcom/alibaba/gaiax/GXTemplateEngine$i;", "gxTemplateItem", "Ltb/ns0;", "getTemplate", "", "templateBiz", "templateId", "Lcom/alibaba/fastjson/JSONObject;", "data", "Ltb/wt2;", Monitor.POINT_ADD, Constants.TAG_CLEAR_STRING, "", "cache", "Ljava/util/Map;", "<init>", "()V", "Companion", "GaiaX-Android"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class GXExtensionTemplateRealTimeSource implements GXRegisterCenter.GXIExtensionTemplateSource {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private static final Lazy<GXExtensionTemplateRealTimeSource> instance$delegate;
    @NotNull
    private final Map<String, ns0> cache = new LinkedHashMap();

    /* compiled from: Taobao */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tR\u001d\u0010\u0007\u001a\u00020\u00028F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/youku/gaiax/impl/register/GXExtensionTemplateRealTimeSource$Companion;", "", "Lcom/youku/gaiax/impl/register/GXExtensionTemplateRealTimeSource;", "instance$delegate", "Lkotlin/Lazy;", "getInstance", "()Lcom/youku/gaiax/impl/register/GXExtensionTemplateRealTimeSource;", "instance", "<init>", "()V", "GaiaX-Android"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(k50 k50Var) {
            this();
        }

        @NotNull
        public final GXExtensionTemplateRealTimeSource getInstance() {
            return (GXExtensionTemplateRealTimeSource) GXExtensionTemplateRealTimeSource.instance$delegate.getValue();
        }
    }

    static {
        Lazy<GXExtensionTemplateRealTimeSource> b;
        b = b.b(new Function0<GXExtensionTemplateRealTimeSource>() { // from class: com.youku.gaiax.impl.register.GXExtensionTemplateRealTimeSource$Companion$instance$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final GXExtensionTemplateRealTimeSource invoke() {
                return new GXExtensionTemplateRealTimeSource();
            }
        });
        instance$delegate = b;
    }

    public final void add(@NotNull String str, @NotNull String str2, @NotNull JSONObject jSONObject) {
        b41.i(str, "templateBiz");
        b41.i(str2, "templateId");
        b41.i(jSONObject, "data");
        GXTemplateEngine.Companion.a().d();
        GXExtensionTemplateInfoSource.Companion.getInstance().clear();
        String string = jSONObject.getString("index.json");
        String str3 = string == null ? "" : string;
        String string2 = jSONObject.getString("index.css");
        String str4 = string2 == null ? "" : string2;
        String string3 = jSONObject.getString("index.databinding");
        String str5 = string3 == null ? "" : string3;
        String string4 = jSONObject.getString("index.js");
        String str6 = string4 == null ? "" : string4;
        jSONObject.getString("index.mock");
        ns0 ns0Var = new ns0(str2, str, -1, str3, str4, str5, str6);
        ns0Var.i(TLogConstant.CHANNEL_MODLE);
        this.cache.put(str2, ns0Var);
    }

    public final void clear() {
        this.cache.clear();
    }

    @Override // com.alibaba.gaiax.GXRegisterCenter.GXIExtensionTemplateSource
    @Nullable
    public ns0 getTemplate(@NotNull GXTemplateEngine.i iVar) {
        b41.i(iVar, "gxTemplateItem");
        return this.cache.get(iVar.d());
    }
}
