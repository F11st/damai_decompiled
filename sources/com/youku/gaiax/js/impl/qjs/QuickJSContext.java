package com.youku.gaiax.js.impl.qjs;

import com.youku.gaiax.js.GaiaXJS;
import com.youku.gaiax.js.core.GaiaXContext;
import com.youku.gaiax.js.core.api.IContext;
import com.youku.gaiax.js.core.api.IEngine;
import com.youku.gaiax.js.core.api.IRuntime;
import com.youku.gaiax.js.impl.qjs.module.QuickJSBridgeModule;
import com.youku.gaiax.js.impl.qjs.module.QuickJSTimer;
import com.youku.gaiax.js.support.GaiaXScriptBuilder;
import com.youku.gaiax.js.utils.IdGenerator;
import com.youku.gaiax.js.utils.Log;
import com.youku.gaiax.quickjs.BridgeModuleListener;
import com.youku.gaiax.quickjs.JSContext;
import com.youku.gaiax.quickjs.JSRuntime;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.k50;
import tb.wt2;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\b\u0000\u0018\u0000 ,2\u00020\u0001:\u0001,B\u001f\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\u0006\u0010\u0016\u001a\u00020\u0015\u0012\u0006\u0010\u001b\u001a\u00020\u001a¢\u0006\u0004\b*\u0010+J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\u0002H\u0016J\b\u0010\n\u001a\u00020\u0002H\u0016J\b\u0010\u000b\u001a\u00020\u0002H\u0016J\b\u0010\f\u001a\u00020\u0002H\u0016J\u0010\u0010\u000e\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u0006H\u0016J\b\u0010\u000f\u001a\u00020\u0002H\u0016R\u0019\u0010\u0011\u001a\u00020\u00108\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0019\u0010\u0016\u001a\u00020\u00158\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0019\u0010\u001b\u001a\u00020\u001a8\u0006@\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u0018\u0010 \u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b \u0010!R\u0018\u0010\"\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\"\u0010#R\u0018\u0010%\u001a\u0004\u0018\u00010$8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010(\u001a\u00020'8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b(\u0010)¨\u0006-"}, d2 = {"Lcom/youku/gaiax/js/impl/qjs/QuickJSContext;", "Lcom/youku/gaiax/js/core/api/IContext;", "Ltb/wt2;", "initModuleTimer", "checkContext", "initContext", "", "module", "initModule", "initBootstrap", "initPendingJob", "destroyPendingJob", "startBootstrap", "script", "evaluateJS", "destroyContext", "Lcom/youku/gaiax/js/core/GaiaXContext;", "host", "Lcom/youku/gaiax/js/core/GaiaXContext;", "getHost", "()Lcom/youku/gaiax/js/core/GaiaXContext;", "Lcom/youku/gaiax/js/impl/qjs/QuickJSEngine;", "engine", "Lcom/youku/gaiax/js/impl/qjs/QuickJSEngine;", "getEngine", "()Lcom/youku/gaiax/js/impl/qjs/QuickJSEngine;", "Lcom/youku/gaiax/js/impl/qjs/QuickJSRuntime;", "runtime", "Lcom/youku/gaiax/js/impl/qjs/QuickJSRuntime;", "getRuntime", "()Lcom/youku/gaiax/js/impl/qjs/QuickJSRuntime;", "Lcom/youku/gaiax/quickjs/BridgeModuleListener;", "bridgeModule", "Lcom/youku/gaiax/quickjs/BridgeModuleListener;", "bootstrap", "Ljava/lang/String;", "Lcom/youku/gaiax/quickjs/JSContext;", "jsContext", "Lcom/youku/gaiax/quickjs/JSContext;", "", "pendingTaskId", "I", "<init>", "(Lcom/youku/gaiax/js/core/GaiaXContext;Lcom/youku/gaiax/js/impl/qjs/QuickJSEngine;Lcom/youku/gaiax/js/impl/qjs/QuickJSRuntime;)V", "Companion", "GaiaX-Android-JS"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class QuickJSContext implements IContext {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @Nullable
    private String bootstrap;
    @Nullable
    private BridgeModuleListener bridgeModule;
    @NotNull
    private final QuickJSEngine engine;
    @NotNull
    private final GaiaXContext host;
    @Nullable
    private JSContext jsContext;
    private final int pendingTaskId;
    @NotNull
    private final QuickJSRuntime runtime;

    /* compiled from: Taobao */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u001e\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006¨\u0006\f"}, d2 = {"Lcom/youku/gaiax/js/impl/qjs/QuickJSContext$Companion;", "", "Lcom/youku/gaiax/js/core/GaiaXContext;", "host", "Lcom/youku/gaiax/js/core/api/IEngine;", "engine", "Lcom/youku/gaiax/js/core/api/IRuntime;", "runtime", "Lcom/youku/gaiax/js/impl/qjs/QuickJSContext;", "create", "<init>", "()V", "GaiaX-Android-JS"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(k50 k50Var) {
            this();
        }

        @NotNull
        public final QuickJSContext create(@NotNull GaiaXContext gaiaXContext, @NotNull IEngine iEngine, @NotNull IRuntime iRuntime) {
            b41.i(gaiaXContext, "host");
            b41.i(iEngine, "engine");
            b41.i(iRuntime, "runtime");
            return new QuickJSContext(gaiaXContext, (QuickJSEngine) iEngine, (QuickJSRuntime) iRuntime);
        }
    }

    public QuickJSContext(@NotNull GaiaXContext gaiaXContext, @NotNull QuickJSEngine quickJSEngine, @NotNull QuickJSRuntime quickJSRuntime) {
        b41.i(gaiaXContext, "host");
        b41.i(quickJSEngine, "engine");
        b41.i(quickJSRuntime, "runtime");
        this.host = gaiaXContext;
        this.engine = quickJSEngine;
        this.runtime = quickJSRuntime;
        this.pendingTaskId = IdGenerator.INSTANCE.genIntId();
    }

    private final void checkContext() {
        if (this.jsContext == null) {
            throw new IllegalArgumentException("JSContext Instance Null");
        }
    }

    private final void initModuleTimer() {
        JSContext jSContext = this.jsContext;
        if (jSContext == null) {
            return;
        }
        jSContext.getGlobalObject().setProperty("setTimeout", jSContext.createJSFunction(QuickJSTimer.createSetTimeoutFunc()));
        jSContext.getGlobalObject().setProperty("clearTimeout", jSContext.createJSFunction(QuickJSTimer.createClearTimeoutFunc()));
        jSContext.getGlobalObject().setProperty("setInterval", jSContext.createJSFunction(QuickJSTimer.createSetIntervalFunc()));
        jSContext.getGlobalObject().setProperty("clearInterval", jSContext.createJSFunction(QuickJSTimer.createClearIntervalFunc()));
    }

    @Override // com.youku.gaiax.js.core.api.IContext
    public void destroyContext() {
        JSContext jSContext = this.jsContext;
        if (jSContext != null) {
            jSContext.close();
        }
        this.jsContext = null;
    }

    @Override // com.youku.gaiax.js.core.api.IContext
    public void destroyPendingJob() {
        this.host.remoteIntervalTask(this.pendingTaskId);
    }

    @Override // com.youku.gaiax.js.core.api.IContext
    public void evaluateJS(@NotNull String str) {
        b41.i(str, "script");
        Log log = Log.INSTANCE;
        if (log.isLog()) {
            log.e(b41.r("evaluateJS() called with: script = ", str));
        }
        JSContext jSContext = this.jsContext;
        if (jSContext == null) {
            return;
        }
        jSContext.evaluate(str, "", 1, 0);
    }

    @NotNull
    public final QuickJSEngine getEngine() {
        return this.engine;
    }

    @NotNull
    public final GaiaXContext getHost() {
        return this.host;
    }

    @NotNull
    public final QuickJSRuntime getRuntime() {
        return this.runtime;
    }

    @Override // com.youku.gaiax.js.core.api.IContext
    public void initBootstrap() {
        if (this.bootstrap == null) {
            StringBuilder sb = new StringBuilder();
            GaiaXScriptBuilder gaiaXScriptBuilder = GaiaXScriptBuilder.INSTANCE;
            sb.append(gaiaXScriptBuilder.buildImportScript());
            sb.append(gaiaXScriptBuilder.buildGlobalContext(this.host.getHost().getHost().getEngineId(), 0));
            sb.append(gaiaXScriptBuilder.buildExtendAndAssignScript());
            GaiaXJS.Companion companion = GaiaXJS.Companion;
            sb.append(companion.getInstance().buildBootstrapScript$GaiaX_Android_JS());
            sb.append(companion.getInstance().buildModulesScript$GaiaX_Android_JS());
            sb.append(gaiaXScriptBuilder.buildStyle());
            this.bootstrap = sb.toString();
        }
    }

    @Override // com.youku.gaiax.js.core.api.IContext
    public void initContext() {
        this.engine.checkQuickJS();
        this.runtime.checkRuntime();
        JSRuntime jsRuntime = this.runtime.getJsRuntime();
        this.jsContext = jsRuntime == null ? null : jsRuntime.createJSContext();
    }

    @Override // com.youku.gaiax.js.core.api.IContext
    public void initModule(@NotNull String str) {
        JSContext jSContext;
        JSContext jSContext2;
        JSContext jSContext3;
        b41.i(str, "module");
        this.engine.checkQuickJS();
        this.runtime.checkRuntime();
        checkContext();
        int hashCode = str.hashCode();
        if (hashCode == 3556) {
            if (str.equals("os") && (jSContext = this.jsContext) != null) {
                jSContext.initModuleOs();
            }
        } else if (hashCode == 114211) {
            if (str.equals(GaiaXContext.MODULE_STD) && (jSContext2 = this.jsContext) != null) {
                jSContext2.initModuleStd();
            }
        } else if (hashCode == 110364485) {
            if (str.equals("timer")) {
                initModuleTimer();
            }
        } else if (hashCode == 1319209784 && str.equals(GaiaXContext.MODULE_GAIAX_BRIDGE)) {
            if (this.bridgeModule == null && (jSContext3 = this.jsContext) != null) {
                GaiaXContext gaiaXContext = this.host;
                b41.f(jSContext3);
                this.bridgeModule = new QuickJSBridgeModule(gaiaXContext, jSContext3);
            }
            JSContext jSContext4 = this.jsContext;
            if (jSContext4 != null) {
                jSContext4.registerBridgeModuleListener(this.bridgeModule);
            }
            JSContext jSContext5 = this.jsContext;
            if (jSContext5 == null) {
                return;
            }
            jSContext5.initModuleBridge(str);
        }
    }

    @Override // com.youku.gaiax.js.core.api.IContext
    public void initPendingJob() {
        this.host.executeIntervalTask(this.pendingTaskId, 10L, new Function0<wt2>() { // from class: com.youku.gaiax.js.impl.qjs.QuickJSContext$initPendingJob$1
            /* JADX INFO: Access modifiers changed from: package-private */
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
                JSContext jSContext;
                jSContext = QuickJSContext.this.jsContext;
                if (jSContext == null) {
                    return;
                }
                jSContext.executePendingJob();
            }
        });
    }

    @Override // com.youku.gaiax.js.core.api.IContext
    public void startBootstrap() {
        String str = this.bootstrap;
        if (str == null) {
            return;
        }
        evaluateJS(str);
    }
}
