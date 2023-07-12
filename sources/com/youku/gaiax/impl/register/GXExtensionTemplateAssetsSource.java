package com.youku.gaiax.impl.register;

import android.content.Context;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.gaiax.GXTemplateEngine;
import com.alibaba.gaiax.template.GXTemplateInfo;
import com.youku.arch.v3.data.Constants;
import com.youku.gaiax.api.proxy.IProxyApp;
import com.youku.gaiax.api.proxy.IProxySource;
import com.youku.gaiax.impl.GaiaXProxy;
import io.flutter.wpkbridge.WPKFactory;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.C8177b;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
import tb.b41;
import tb.cq0;
import tb.k50;
import tb.ns0;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0016\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u000f\u0012\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u0011\u0010\u0012J\u0016\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002J\u0016\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002J\u001a\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\n0\tH\u0016R\u001c\u0010\r\u001a\u00020\f8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0014"}, d2 = {"Lcom/youku/gaiax/impl/register/GXExtensionTemplateAssetsSource;", "Ltb/cq0;", "", "templateBiz", "templateId", "", "exist", "Lcom/alibaba/fastjson/JSONObject;", "getTemplate", "", "", "getAllTemplate", "Landroid/content/Context;", WPKFactory.INIT_KEY_CONTEXT, "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "Companion", "GaiaX-Android"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public class GXExtensionTemplateAssetsSource extends cq0 {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private static final Lazy<GXExtensionTemplateAssetsSource> instance$delegate;
    @NotNull
    private final Context context;

    /* compiled from: Taobao */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nJ\u0006\u0010\u0003\u001a\u00020\u0002R\u001d\u0010\b\u001a\u00020\u00028F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000b"}, d2 = {"Lcom/youku/gaiax/impl/register/GXExtensionTemplateAssetsSource$Companion;", "", "Lcom/youku/gaiax/impl/register/GXExtensionTemplateAssetsSource;", "assetsInstance", "instance$delegate", "Lkotlin/Lazy;", "getInstance", "()Lcom/youku/gaiax/impl/register/GXExtensionTemplateAssetsSource;", "instance", "<init>", "()V", "GaiaX-Android"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(k50 k50Var) {
            this();
        }

        @NotNull
        public final GXExtensionTemplateAssetsSource assetsInstance() {
            IProxySource source = GaiaXProxy.Companion.getInstance().getSource();
            GXExtensionTemplateAssetsSource assetsTemplateSource = source == null ? null : source.getAssetsTemplateSource();
            return assetsTemplateSource == null ? getInstance() : assetsTemplateSource;
        }

        @NotNull
        public final GXExtensionTemplateAssetsSource getInstance() {
            return (GXExtensionTemplateAssetsSource) GXExtensionTemplateAssetsSource.instance$delegate.getValue();
        }
    }

    static {
        Lazy<GXExtensionTemplateAssetsSource> b;
        b = C8177b.b(new Function0<GXExtensionTemplateAssetsSource>() { // from class: com.youku.gaiax.impl.register.GXExtensionTemplateAssetsSource$Companion$instance$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final GXExtensionTemplateAssetsSource invoke() {
                IProxyApp app2 = GaiaXProxy.Companion.getInstance().getApp();
                Context applicationContext = app2 == null ? null : app2.applicationContext();
                if (applicationContext != null) {
                    return new GXExtensionTemplateAssetsSource(applicationContext);
                }
                throw new IllegalArgumentException("GXExtensionTemplateAssetsSource context not exist");
            }
        });
        instance$delegate = b;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GXExtensionTemplateAssetsSource(@NotNull Context context) {
        super(context);
        b41.i(context, WPKFactory.INIT_KEY_CONTEXT);
        this.context = context;
    }

    public final boolean exist(@NotNull String str, @NotNull String str2) {
        b41.i(str, "templateBiz");
        b41.i(str2, "templateId");
        return getTemplate(new GXTemplateEngine.C3347i(getContext(), str, str2)) != null;
    }

    @NotNull
    public Map<String, List<JSONObject>> getAllTemplate() {
        return new HashMap();
    }

    @Override // tb.cq0
    @NotNull
    public Context getContext() {
        return this.context;
    }

    @NotNull
    public final JSONObject getTemplate(@NotNull String str, @NotNull String str2) {
        b41.i(str, "templateBiz");
        b41.i(str2, "templateId");
        JSONObject jSONObject = new JSONObject();
        ns0 template = getTemplate(new GXTemplateEngine.C3347i(getContext(), str, str2));
        if (template != null) {
            JSONObject jSONObject2 = new JSONObject();
            GXTemplateInfo.Companion companion = GXTemplateInfo.Companion;
            jSONObject2.put((JSONObject) "index.json", (String) companion.n(template.f()));
            jSONObject2.put((JSONObject) "index.css", (String) companion.l(template.b()));
            jSONObject2.put((JSONObject) "index.databinding", (String) companion.m(template.c()));
            jSONObject2.put((JSONObject) "index.js", template.e());
            jSONObject.put((JSONObject) Constants.TEMPLATE, (String) jSONObject2);
            jSONObject.put((JSONObject) "templateId", template.d());
            jSONObject.put((JSONObject) "templateBiz", template.a());
            jSONObject.put((JSONObject) "templateVersion", (String) Integer.valueOf(template.h()));
            jSONObject.put((JSONObject) "templateType", "assets");
        }
        return jSONObject;
    }
}
