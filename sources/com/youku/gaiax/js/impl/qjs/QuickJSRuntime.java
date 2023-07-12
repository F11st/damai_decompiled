package com.youku.gaiax.js.impl.qjs;

import com.alibaba.fastjson.JSONObject;
import com.youku.gaiax.js.GaiaXJS;
import com.youku.gaiax.js.core.GaiaXRuntime;
import com.youku.gaiax.js.core.api.IEngine;
import com.youku.gaiax.js.core.api.IRuntime;
import com.youku.gaiax.js.utils.Log;
import com.youku.gaiax.quickjs.JSRuntime;
import com.youku.gaiax.quickjs.QuickJS;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.hh1;
import tb.k50;
import tb.wt2;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\b\u0000\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u0019\b\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\u0017\u0010\u0018J\u0006\u0010\u0003\u001a\u00020\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0002H\u0016R\u0019\u0010\u0007\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR\u0019\u0010\f\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR$\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006\u001a"}, d2 = {"Lcom/youku/gaiax/js/impl/qjs/QuickJSRuntime;", "Lcom/youku/gaiax/js/core/api/IRuntime;", "Ltb/wt2;", "checkRuntime", "initRuntime", "destroyRuntime", "Lcom/youku/gaiax/js/core/GaiaXRuntime;", "runtime", "Lcom/youku/gaiax/js/core/GaiaXRuntime;", "getRuntime", "()Lcom/youku/gaiax/js/core/GaiaXRuntime;", "Lcom/youku/gaiax/js/impl/qjs/QuickJSEngine;", "engine", "Lcom/youku/gaiax/js/impl/qjs/QuickJSEngine;", "getEngine", "()Lcom/youku/gaiax/js/impl/qjs/QuickJSEngine;", "Lcom/youku/gaiax/quickjs/JSRuntime;", "jsRuntime", "Lcom/youku/gaiax/quickjs/JSRuntime;", "getJsRuntime", "()Lcom/youku/gaiax/quickjs/JSRuntime;", "setJsRuntime", "(Lcom/youku/gaiax/quickjs/JSRuntime;)V", "<init>", "(Lcom/youku/gaiax/js/core/GaiaXRuntime;Lcom/youku/gaiax/js/impl/qjs/QuickJSEngine;)V", "Companion", "GaiaX-Android-JS"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class QuickJSRuntime implements IRuntime {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final QuickJSEngine engine;
    @Nullable
    private JSRuntime jsRuntime;
    @NotNull
    private final GaiaXRuntime runtime;

    /* compiled from: Taobao */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tJ\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004¨\u0006\n"}, d2 = {"Lcom/youku/gaiax/js/impl/qjs/QuickJSRuntime$Companion;", "", "Lcom/youku/gaiax/js/core/GaiaXRuntime;", "runtime", "Lcom/youku/gaiax/js/core/api/IEngine;", "engine", "Lcom/youku/gaiax/js/impl/qjs/QuickJSRuntime;", "create", "<init>", "()V", "GaiaX-Android-JS"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(k50 k50Var) {
            this();
        }

        @NotNull
        public final QuickJSRuntime create(@NotNull GaiaXRuntime gaiaXRuntime, @NotNull IEngine iEngine) {
            b41.i(gaiaXRuntime, "runtime");
            b41.i(iEngine, "engine");
            return new QuickJSRuntime(gaiaXRuntime, (QuickJSEngine) iEngine, null);
        }
    }

    private QuickJSRuntime(GaiaXRuntime gaiaXRuntime, QuickJSEngine quickJSEngine) {
        this.runtime = gaiaXRuntime;
        this.engine = quickJSEngine;
    }

    public /* synthetic */ QuickJSRuntime(GaiaXRuntime gaiaXRuntime, QuickJSEngine quickJSEngine, k50 k50Var) {
        this(gaiaXRuntime, quickJSEngine);
    }

    public final void checkRuntime() {
        if (this.jsRuntime == null) {
            throw new IllegalArgumentException("JSRuntime Instance Null");
        }
    }

    @Override // com.youku.gaiax.js.core.api.IRuntime
    public void destroyRuntime() {
        JSRuntime jSRuntime = this.jsRuntime;
        if (jSRuntime != null) {
            jSRuntime.close();
        }
        this.jsRuntime = null;
    }

    @NotNull
    public final QuickJSEngine getEngine() {
        return this.engine;
    }

    @Nullable
    public final JSRuntime getJsRuntime() {
        return this.jsRuntime;
    }

    @NotNull
    public final GaiaXRuntime getRuntime() {
        return this.runtime;
    }

    @Override // com.youku.gaiax.js.core.api.IRuntime
    public void initRuntime() {
        this.engine.checkQuickJS();
        QuickJS quickJS = this.engine.getQuickJS();
        JSRuntime createJSRuntime = quickJS == null ? null : quickJS.createJSRuntime();
        this.jsRuntime = createJSRuntime;
        if (createJSRuntime != null) {
            createJSRuntime.setRuntimeMaxStackSize(0);
        }
        JSRuntime jSRuntime = this.jsRuntime;
        if (jSRuntime != null) {
            jSRuntime.setPromiseRejectionHandler(new JSRuntime.PromiseRejectionHandler() { // from class: com.youku.gaiax.js.impl.qjs.QuickJSRuntime$initRuntime$1
                @Override // com.youku.gaiax.quickjs.JSRuntime.PromiseRejectionHandler
                public final void onError(String str) {
                    Log log = Log.INSTANCE;
                    if (log.isLog()) {
                        log.e(b41.r("setPromiseRejectionHandler() called with: message = ", str));
                    }
                    GaiaXJS.Listener listener$GaiaX_Android_JS = GaiaXJS.Companion.getInstance().getListener$GaiaX_Android_JS();
                    if (listener$GaiaX_Android_JS == null) {
                        return;
                    }
                    JSONObject jSONObject = new JSONObject();
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put((JSONObject) "message", str);
                    jSONObject2.put((JSONObject) "templateId", "");
                    jSONObject2.put((JSONObject) "templateVersion", "");
                    jSONObject2.put((JSONObject) hh1.DIMEN_BIZ, "");
                    jSONObject.put((JSONObject) "data", (String) jSONObject2);
                    wt2 wt2Var = wt2.INSTANCE;
                    listener$GaiaX_Android_JS.errorLog(jSONObject);
                }
            });
        }
        JSRuntime jSRuntime2 = this.jsRuntime;
        if (jSRuntime2 == null) {
            return;
        }
        jSRuntime2.setInterruptHandler(new JSRuntime.InterruptHandler() { // from class: com.youku.gaiax.js.impl.qjs.QuickJSRuntime$initRuntime$2
            @Override // com.youku.gaiax.quickjs.JSRuntime.InterruptHandler
            public final boolean onInterrupt() {
                Log log = Log.INSTANCE;
                if (log.isLog()) {
                    log.e("setInterruptHandler() called with:");
                    return false;
                }
                return false;
            }
        });
    }

    public final void setJsRuntime(@Nullable JSRuntime jSRuntime) {
        this.jsRuntime = jSRuntime;
    }
}
