package com.youku.gaiax.js.impl.qjs;

import com.youku.gaiax.js.core.GaiaXEngine;
import com.youku.gaiax.js.core.api.IEngine;
import com.youku.gaiax.quickjs.QuickJS;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.k50;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\b\u0000\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0011\b\u0002\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\u0013\u0010\u0014J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\u0006\u0010\u0005\u001a\u00020\u0002J\b\u0010\u0006\u001a\u00020\u0002H\u0016R\u0019\u0010\b\u001a\u00020\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR$\u0010\r\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u0016"}, d2 = {"Lcom/youku/gaiax/js/impl/qjs/QuickJSEngine;", "Lcom/youku/gaiax/js/core/api/IEngine;", "Ltb/wt2;", "destroyQuickJS", "initEngine", "checkQuickJS", "destroyEngine", "Lcom/youku/gaiax/js/core/GaiaXEngine;", "engine", "Lcom/youku/gaiax/js/core/GaiaXEngine;", "getEngine", "()Lcom/youku/gaiax/js/core/GaiaXEngine;", "Lcom/youku/gaiax/quickjs/QuickJS;", "quickJS", "Lcom/youku/gaiax/quickjs/QuickJS;", "getQuickJS", "()Lcom/youku/gaiax/quickjs/QuickJS;", "setQuickJS", "(Lcom/youku/gaiax/quickjs/QuickJS;)V", "<init>", "(Lcom/youku/gaiax/js/core/GaiaXEngine;)V", "Companion", "GaiaX-Android-JS"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class QuickJSEngine implements IEngine {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final GaiaXEngine engine;
    @Nullable
    private QuickJS quickJS;

    /* compiled from: Taobao */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\b"}, d2 = {"Lcom/youku/gaiax/js/impl/qjs/QuickJSEngine$Companion;", "", "Lcom/youku/gaiax/js/core/GaiaXEngine;", "engine", "Lcom/youku/gaiax/js/impl/qjs/QuickJSEngine;", "create", "<init>", "()V", "GaiaX-Android-JS"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(k50 k50Var) {
            this();
        }

        @NotNull
        public final QuickJSEngine create(@NotNull GaiaXEngine gaiaXEngine) {
            b41.i(gaiaXEngine, "engine");
            return new QuickJSEngine(gaiaXEngine, null);
        }
    }

    private QuickJSEngine(GaiaXEngine gaiaXEngine) {
        this.engine = gaiaXEngine;
    }

    public /* synthetic */ QuickJSEngine(GaiaXEngine gaiaXEngine, k50 k50Var) {
        this(gaiaXEngine);
    }

    private final void destroyQuickJS() {
        this.quickJS = null;
    }

    public final void checkQuickJS() {
        if (this.quickJS == null) {
            throw new IllegalArgumentException("QuickJS Instance Null");
        }
    }

    @Override // com.youku.gaiax.js.core.api.IEngine
    public void destroyEngine() {
        destroyQuickJS();
    }

    @NotNull
    public final GaiaXEngine getEngine() {
        return this.engine;
    }

    @Nullable
    public final QuickJS getQuickJS() {
        return this.quickJS;
    }

    @Override // com.youku.gaiax.js.core.api.IEngine
    public void initEngine() {
        if (this.quickJS == null) {
            this.quickJS = new QuickJS.Builder().build();
        }
    }

    public final void setQuickJS(@Nullable QuickJS quickJS) {
        this.quickJS = quickJS;
    }
}
