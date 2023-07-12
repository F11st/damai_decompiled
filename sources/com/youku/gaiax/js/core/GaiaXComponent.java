package com.youku.gaiax.js.core;

import com.alibaba.fastjson.JSONObject;
import com.youku.gaiax.js.core.api.IComponent;
import com.youku.gaiax.js.support.GaiaXScriptBuilder;
import com.youku.gaiax.js.utils.Aop;
import com.youku.gaiax.js.utils.IdGenerator;
import com.youku.gaiax.js.utils.MonitorUtils;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.b;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import tb.b41;
import tb.hh1;
import tb.k50;
import tb.wt2;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\t\n\u0002\b\u000b\b\u0000\u0018\u0000 *2\u00020\u0001:\u0001*B1\b\u0002\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u0012\u0006\u0010\u0016\u001a\u00020\n\u0012\u0006\u0010\u001a\u001a\u00020\n\u0012\u0006\u0010\u001c\u001a\u00020\n\u0012\u0006\u0010\u001e\u001a\u00020\n¢\u0006\u0004\b(\u0010)J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0002H\u0016J\b\u0010\b\u001a\u00020\u0002H\u0016J\b\u0010\t\u001a\u00020\u0002H\u0016J\u0018\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0016J\u0010\u0010\u000f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\fH\u0016J\u0010\u0010\u0010\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\fH\u0016R\u0019\u0010\u0012\u001a\u00020\u00118\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0019\u0010\u0016\u001a\u00020\n8\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0019\u0010\u001a\u001a\u00020\n8\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u0017\u001a\u0004\b\u001b\u0010\u0019R\u0019\u0010\u001c\u001a\u00020\n8\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u0017\u001a\u0004\b\u001d\u0010\u0019R\u0019\u0010\u001e\u001a\u00020\n8\u0006@\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u0017\u001a\u0004\b\u001f\u0010\u0019R\u001d\u0010%\u001a\u00020 8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R\u0013\u0010'\u001a\u00020 8F@\u0006¢\u0006\u0006\u001a\u0004\b&\u0010$¨\u0006+"}, d2 = {"Lcom/youku/gaiax/js/core/GaiaXComponent;", "Lcom/youku/gaiax/js/core/api/IComponent;", "Ltb/wt2;", "initComponent", "onReady", "onReuse", "onShow", "onHide", "onDestroy", "destroyComponent", "", "type", "Lcom/alibaba/fastjson/JSONObject;", "data", "onEvent", "onNativeEvent", "onLoadMore", "Lcom/youku/gaiax/js/core/GaiaXContext;", "jsContext", "Lcom/youku/gaiax/js/core/GaiaXContext;", "getJsContext", "()Lcom/youku/gaiax/js/core/GaiaXContext;", hh1.DIMEN_BIZ, "Ljava/lang/String;", "getBizId", "()Ljava/lang/String;", "templateId", "getTemplateId", "templateVersion", "getTemplateVersion", "script", "getScript", "", "_id$delegate", "Lkotlin/Lazy;", "get_id", "()J", "_id", "getId", "id", "<init>", "(Lcom/youku/gaiax/js/core/GaiaXContext;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Companion", "GaiaX-Android-JS"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class GaiaXComponent implements IComponent {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final Lazy _id$delegate;
    @NotNull
    private final String bizId;
    @NotNull
    private final GaiaXContext jsContext;
    @NotNull
    private final String script;
    @NotNull
    private final String templateId;
    @NotNull
    private final String templateVersion;

    /* compiled from: Taobao */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ.\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0004¨\u0006\r"}, d2 = {"Lcom/youku/gaiax/js/core/GaiaXComponent$Companion;", "", "Lcom/youku/gaiax/js/core/GaiaXContext;", "jsContext", "", hh1.DIMEN_BIZ, "templateId", "templateVersion", "script", "Lcom/youku/gaiax/js/core/GaiaXComponent;", "create", "<init>", "()V", "GaiaX-Android-JS"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(k50 k50Var) {
            this();
        }

        @NotNull
        public final GaiaXComponent create(@NotNull GaiaXContext gaiaXContext, @NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4) {
            b41.i(gaiaXContext, "jsContext");
            b41.i(str, hh1.DIMEN_BIZ);
            b41.i(str2, "templateId");
            b41.i(str3, "templateVersion");
            b41.i(str4, "script");
            return new GaiaXComponent(gaiaXContext, str, str2, str3, str4, null);
        }
    }

    private GaiaXComponent(GaiaXContext gaiaXContext, String str, String str2, String str3, String str4) {
        Lazy b;
        this.jsContext = gaiaXContext;
        this.bizId = str;
        this.templateId = str2;
        this.templateVersion = str3;
        this.script = str4;
        b = b.b(new Function0<Long>() { // from class: com.youku.gaiax.js.core.GaiaXComponent$_id$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Long invoke() {
                return Long.valueOf(IdGenerator.INSTANCE.genLongId());
            }
        });
        this._id$delegate = b;
    }

    public /* synthetic */ GaiaXComponent(GaiaXContext gaiaXContext, String str, String str2, String str3, String str4, k50 k50Var) {
        this(gaiaXContext, str, str2, str3, str4);
    }

    private final long get_id() {
        return ((Number) this._id$delegate.getValue()).longValue();
    }

    @Override // com.youku.gaiax.js.core.api.IComponent
    public void destroyComponent() {
        getJsContext().evaluateJS(GaiaXScriptBuilder.INSTANCE.buildDestroyComponentScript(getId()));
    }

    @NotNull
    public final String getBizId() {
        return this.bizId;
    }

    public final long getId() {
        return get_id();
    }

    @NotNull
    public final GaiaXContext getJsContext() {
        return this.jsContext;
    }

    @NotNull
    public final String getScript() {
        return this.script;
    }

    @NotNull
    public final String getTemplateId() {
        return this.templateId;
    }

    @NotNull
    public final String getTemplateVersion() {
        return this.templateVersion;
    }

    @Override // com.youku.gaiax.js.core.api.IComponent
    public void initComponent() {
        final String buildInitComponentScript = GaiaXScriptBuilder.INSTANCE.buildInitComponentScript(getId(), this.bizId, this.templateId, this.templateVersion, this.script);
        getJsContext().executeTask(new Function0<wt2>() { // from class: com.youku.gaiax.js.core.GaiaXComponent$initComponent$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ wt2 invoke() {
                invoke2();
                return wt2.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2() {
                Aop aop = Aop.INSTANCE;
                final GaiaXComponent gaiaXComponent = GaiaXComponent.this;
                final String str = buildInitComponentScript;
                Function0<wt2> function0 = new Function0<wt2>() { // from class: com.youku.gaiax.js.core.GaiaXComponent$initComponent$1$1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ wt2 invoke() {
                        invoke2();
                        return wt2.INSTANCE;
                    }

                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        GaiaXComponent.this.getJsContext().evaluateJSWithoutTask(str);
                    }
                };
                final GaiaXComponent gaiaXComponent2 = GaiaXComponent.this;
                aop.aopTaskTime(function0, new Function1<Long, wt2>() { // from class: com.youku.gaiax.js.core.GaiaXComponent$initComponent$1$1.2
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ wt2 invoke(Long l) {
                        invoke(l.longValue());
                        return wt2.INSTANCE;
                    }

                    public final void invoke(long j) {
                        MonitorUtils.INSTANCE.jsTemplate(MonitorUtils.TYPE_LOAD_INDEX_JS, j, GaiaXComponent.this.getTemplateId(), GaiaXComponent.this.getBizId());
                    }
                });
            }
        });
    }

    @Override // com.youku.gaiax.js.core.api.IComponent
    public void onDestroy() {
        getJsContext().evaluateJS(GaiaXScriptBuilder.INSTANCE.buildComponentDestroyScript(getId()));
    }

    @Override // com.youku.gaiax.js.core.api.IComponent
    public void onEvent(@NotNull String str, @NotNull JSONObject jSONObject) {
        b41.i(str, "type");
        b41.i(jSONObject, "data");
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.putAll(jSONObject);
        jSONObject2.put((JSONObject) hh1.DIMEN_BIZ, getBizId());
        jSONObject2.put((JSONObject) "templateId", getTemplateId());
        jSONObject2.put((JSONObject) "templateVersion", getTemplateVersion());
        jSONObject2.put((JSONObject) "instanceId", (String) Long.valueOf(getId()));
        jSONObject2.put((JSONObject) "type", str);
        GaiaXScriptBuilder gaiaXScriptBuilder = GaiaXScriptBuilder.INSTANCE;
        String jSONString = jSONObject2.toJSONString();
        b41.h(jSONString, "targetData.toJSONString()");
        getJsContext().evaluateJS(gaiaXScriptBuilder.buildPostMessage(jSONString));
    }

    @Override // com.youku.gaiax.js.core.api.IComponent
    public void onHide() {
        getJsContext().evaluateJS(GaiaXScriptBuilder.INSTANCE.buildComponentHideScript(getId()));
    }

    @Override // com.youku.gaiax.js.core.api.IComponent
    public void onLoadMore(@NotNull JSONObject jSONObject) {
        b41.i(jSONObject, "data");
        GaiaXScriptBuilder gaiaXScriptBuilder = GaiaXScriptBuilder.INSTANCE;
        long id = getId();
        String jSONString = jSONObject.toJSONString();
        b41.h(jSONString, "data.toJSONString()");
        getJsContext().evaluateJS(gaiaXScriptBuilder.buildComponentLoadMoreScript(id, jSONString));
    }

    @Override // com.youku.gaiax.js.core.api.IComponent
    public void onNativeEvent(@NotNull JSONObject jSONObject) {
        b41.i(jSONObject, "data");
        GaiaXScriptBuilder gaiaXScriptBuilder = GaiaXScriptBuilder.INSTANCE;
        String jSONString = jSONObject.toJSONString();
        b41.h(jSONString, "data.toJSONString()");
        getJsContext().evaluateJS(gaiaXScriptBuilder.buildPostNativeMessage(jSONString));
    }

    @Override // com.youku.gaiax.js.core.api.IComponent
    public void onReady() {
        getJsContext().evaluateJS(GaiaXScriptBuilder.INSTANCE.buildComponentReadyScript(getId()));
    }

    @Override // com.youku.gaiax.js.core.api.IComponent
    public void onReuse() {
        getJsContext().evaluateJS(GaiaXScriptBuilder.INSTANCE.buildComponentReuseScript(getId()));
    }

    @Override // com.youku.gaiax.js.core.api.IComponent
    public void onShow() {
        getJsContext().evaluateJS(GaiaXScriptBuilder.INSTANCE.buildComponentShowScript(getId()));
    }
}
