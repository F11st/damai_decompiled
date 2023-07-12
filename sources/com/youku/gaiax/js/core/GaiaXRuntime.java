package com.youku.gaiax.js.core;

import com.youku.gaiax.js.GaiaXJS;
import com.youku.gaiax.js.core.GaiaXContext;
import com.youku.gaiax.js.core.api.IEngine;
import com.youku.gaiax.js.core.api.IRuntime;
import com.youku.gaiax.js.impl.qjs.QuickJSRuntime;
import io.flutter.wpkbridge.WPKFactory;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.k50;
import tb.wt2;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0000\u0018\u0000  2\u00020\u0001:\u0001 B\u001f\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u0012\u0006\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0006\u0010\u0005\u001a\u00020\u0004J\u0014\u0010\b\u001a\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006J\u0006\u0010\t\u001a\u00020\u0004J\b\u0010\u000b\u001a\u0004\u0018\u00010\nR\u0019\u0010\r\u001a\u00020\f8\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0019\u0010\u0012\u001a\u00020\u00118\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0019\u0010\u0017\u001a\u00020\u00168\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0018\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\u001d¨\u0006!"}, d2 = {"Lcom/youku/gaiax/js/core/GaiaXRuntime;", "", "Lcom/youku/gaiax/js/core/api/IRuntime;", "createRuntime", "Ltb/wt2;", "initRuntime", "Lkotlin/Function0;", "complete", "startRuntime", "destroyRuntime", "Lcom/youku/gaiax/js/core/GaiaXContext;", WPKFactory.INIT_KEY_CONTEXT, "Lcom/youku/gaiax/js/core/GaiaXEngine;", "host", "Lcom/youku/gaiax/js/core/GaiaXEngine;", "getHost", "()Lcom/youku/gaiax/js/core/GaiaXEngine;", "Lcom/youku/gaiax/js/core/api/IEngine;", "engine", "Lcom/youku/gaiax/js/core/api/IEngine;", "getEngine", "()Lcom/youku/gaiax/js/core/api/IEngine;", "Lcom/youku/gaiax/js/GaiaXJS$GaiaXJSType;", "type", "Lcom/youku/gaiax/js/GaiaXJS$GaiaXJSType;", "getType", "()Lcom/youku/gaiax/js/GaiaXJS$GaiaXJSType;", "runtime", "Lcom/youku/gaiax/js/core/api/IRuntime;", "Lcom/youku/gaiax/js/core/GaiaXContext;", "<init>", "(Lcom/youku/gaiax/js/core/GaiaXEngine;Lcom/youku/gaiax/js/core/api/IEngine;Lcom/youku/gaiax/js/GaiaXJS$GaiaXJSType;)V", "Companion", "GaiaX-Android-JS"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class GaiaXRuntime {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @Nullable
    private GaiaXContext context;
    @NotNull
    private final IEngine engine;
    @NotNull
    private final GaiaXEngine host;
    @Nullable
    private IRuntime runtime;
    @NotNull
    private final GaiaXJS.GaiaXJSType type;

    /* compiled from: Taobao */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u001e\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006¨\u0006\f"}, d2 = {"Lcom/youku/gaiax/js/core/GaiaXRuntime$Companion;", "", "Lcom/youku/gaiax/js/core/GaiaXEngine;", "host", "Lcom/youku/gaiax/js/core/api/IEngine;", "engine", "Lcom/youku/gaiax/js/GaiaXJS$GaiaXJSType;", "type", "Lcom/youku/gaiax/js/core/GaiaXRuntime;", "create", "<init>", "()V", "GaiaX-Android-JS"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(k50 k50Var) {
            this();
        }

        @NotNull
        public final GaiaXRuntime create(@NotNull GaiaXEngine gaiaXEngine, @NotNull IEngine iEngine, @NotNull GaiaXJS.GaiaXJSType gaiaXJSType) {
            b41.i(gaiaXEngine, "host");
            b41.i(iEngine, "engine");
            b41.i(gaiaXJSType, "type");
            return new GaiaXRuntime(gaiaXEngine, iEngine, gaiaXJSType);
        }
    }

    /* compiled from: Taobao */
    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 5, 1})
    /* loaded from: classes2.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[GaiaXJS.GaiaXJSType.values().length];
            iArr[GaiaXJS.GaiaXJSType.QuickJS.ordinal()] = 1;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public GaiaXRuntime(@NotNull GaiaXEngine gaiaXEngine, @NotNull IEngine iEngine, @NotNull GaiaXJS.GaiaXJSType gaiaXJSType) {
        b41.i(gaiaXEngine, "host");
        b41.i(iEngine, "engine");
        b41.i(gaiaXJSType, "type");
        this.host = gaiaXEngine;
        this.engine = iEngine;
        this.type = gaiaXJSType;
    }

    private final IRuntime createRuntime() {
        if (WhenMappings.$EnumSwitchMapping$0[this.type.ordinal()] == 1) {
            return QuickJSRuntime.Companion.create(this, this.engine);
        }
        throw new NoWhenBranchMatchedException();
    }

    @Nullable
    public final GaiaXContext context() {
        return this.context;
    }

    public final void destroyRuntime() {
        GaiaXContext gaiaXContext = this.context;
        if (gaiaXContext != null) {
            gaiaXContext.destroyContext();
        }
        this.context = null;
        IRuntime iRuntime = this.runtime;
        if (iRuntime != null) {
            iRuntime.destroyRuntime();
        }
        this.runtime = null;
    }

    @NotNull
    public final IEngine getEngine() {
        return this.engine;
    }

    @NotNull
    public final GaiaXEngine getHost() {
        return this.host;
    }

    @NotNull
    public final GaiaXJS.GaiaXJSType getType() {
        return this.type;
    }

    public final void initRuntime() {
        if (this.runtime == null) {
            this.runtime = createRuntime();
        }
        IRuntime iRuntime = this.runtime;
        if (iRuntime != null) {
            iRuntime.initRuntime();
        }
        if (this.context == null) {
            GaiaXContext.Companion companion = GaiaXContext.Companion;
            IRuntime iRuntime2 = this.runtime;
            b41.f(iRuntime2);
            this.context = companion.create(this, iRuntime2, this.type);
        }
        GaiaXContext gaiaXContext = this.context;
        if (gaiaXContext == null) {
            return;
        }
        gaiaXContext.initContext();
    }

    public final void startRuntime(@NotNull Function0<wt2> function0) {
        b41.i(function0, "complete");
        GaiaXContext gaiaXContext = this.context;
        if (gaiaXContext == null) {
            return;
        }
        gaiaXContext.startContext(function0);
    }
}
