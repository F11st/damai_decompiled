package com.youku.gaiax.js.core;

import com.youku.gaiax.js.GaiaXJS;
import com.youku.gaiax.js.core.GaiaXRuntime;
import com.youku.gaiax.js.core.api.IEngine;
import com.youku.gaiax.js.impl.qjs.QuickJSEngine;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.k50;
import tb.wt2;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 '2\u00020\u0001:\u0002'(B\u0019\b\u0002\u0012\u0006\u0010\u0017\u001a\u00020\u0013\u0012\u0006\u0010\u001b\u001a\u00020\u001a¢\u0006\u0004\b%\u0010&J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u000f\u0010\u0007\u001a\u00020\u0004H\u0000¢\u0006\u0004\b\u0005\u0010\u0006J\u001d\u0010\f\u001a\u00020\u00042\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\bH\u0000¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\u000e\u001a\u00020\u0004H\u0000¢\u0006\u0004\b\r\u0010\u0006J\u0011\u0010\u0012\u001a\u0004\u0018\u00010\u000fH\u0000¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0016\u001a\u00020\u0013H\u0000¢\u0006\u0004\b\u0014\u0010\u0015R\u0019\u0010\u0017\u001a\u00020\u00138\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u0015R\u0019\u0010\u001b\u001a\u00020\u001a8\u0006@\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u0016\u0010 \u001a\u00020\u001f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b \u0010!R\u0018\u0010\"\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\"\u0010#R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010$¨\u0006)"}, d2 = {"Lcom/youku/gaiax/js/core/GaiaXEngine;", "", "Lcom/youku/gaiax/js/core/api/IEngine;", "createEngine", "Ltb/wt2;", "initEngine$GaiaX_Android_JS", "()V", "initEngine", "Lkotlin/Function0;", "complete", "startEngine$GaiaX_Android_JS", "(Lkotlin/jvm/functions/Function0;)V", "startEngine", "destroyEngine$GaiaX_Android_JS", "destroyEngine", "Lcom/youku/gaiax/js/core/GaiaXRuntime;", "runtime$GaiaX_Android_JS", "()Lcom/youku/gaiax/js/core/GaiaXRuntime;", "runtime", "", "getId$GaiaX_Android_JS", "()J", "getId", "engineId", "J", "getEngineId", "Lcom/youku/gaiax/js/GaiaXJS$GaiaXJSType;", "type", "Lcom/youku/gaiax/js/GaiaXJS$GaiaXJSType;", "getType", "()Lcom/youku/gaiax/js/GaiaXJS$GaiaXJSType;", "Lcom/youku/gaiax/js/core/GaiaXEngine$State;", "state", "Lcom/youku/gaiax/js/core/GaiaXEngine$State;", "engine", "Lcom/youku/gaiax/js/core/api/IEngine;", "Lcom/youku/gaiax/js/core/GaiaXRuntime;", "<init>", "(JLcom/youku/gaiax/js/GaiaXJS$GaiaXJSType;)V", "Companion", "State", "GaiaX-Android-JS"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class GaiaXEngine {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @Nullable
    private IEngine engine;
    private final long engineId;
    @Nullable
    private GaiaXRuntime runtime;
    @NotNull
    private volatile State state;
    @NotNull
    private final GaiaXJS.GaiaXJSType type;

    /* compiled from: Taobao */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tJ\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004¨\u0006\n"}, d2 = {"Lcom/youku/gaiax/js/core/GaiaXEngine$Companion;", "", "", "engineId", "Lcom/youku/gaiax/js/GaiaXJS$GaiaXJSType;", "type", "Lcom/youku/gaiax/js/core/GaiaXEngine;", "create", "<init>", "()V", "GaiaX-Android-JS"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(k50 k50Var) {
            this();
        }

        @NotNull
        public final GaiaXEngine create(long j, @NotNull GaiaXJS.GaiaXJSType gaiaXJSType) {
            b41.i(gaiaXJSType, "type");
            return new GaiaXEngine(j, gaiaXJSType, null);
        }
    }

    /* compiled from: Taobao */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/youku/gaiax/js/core/GaiaXEngine$State;", "", "<init>", "(Ljava/lang/String;I)V", "NONE", "INIT_START", "INIT_END", "RUNNING_START", "RUNNING_END", "DESTROY_START", "DESTROY_END", "GaiaX-Android-JS"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes2.dex */
    public enum State {
        NONE,
        INIT_START,
        INIT_END,
        RUNNING_START,
        RUNNING_END,
        DESTROY_START,
        DESTROY_END
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

    private GaiaXEngine(long j, GaiaXJS.GaiaXJSType gaiaXJSType) {
        this.engineId = j;
        this.type = gaiaXJSType;
        this.state = State.NONE;
    }

    public /* synthetic */ GaiaXEngine(long j, GaiaXJS.GaiaXJSType gaiaXJSType, k50 k50Var) {
        this(j, gaiaXJSType);
    }

    private final IEngine createEngine() {
        if (WhenMappings.$EnumSwitchMapping$0[this.type.ordinal()] == 1) {
            return QuickJSEngine.Companion.create(this);
        }
        throw new NoWhenBranchMatchedException();
    }

    public final void destroyEngine$GaiaX_Android_JS() {
        if (this.state == State.RUNNING_END || this.state == State.INIT_START) {
            this.state = State.DESTROY_START;
            GaiaXRuntime gaiaXRuntime = this.runtime;
            if (gaiaXRuntime != null) {
                gaiaXRuntime.destroyRuntime();
            }
            this.runtime = null;
            IEngine iEngine = this.engine;
            if (iEngine != null) {
                iEngine.destroyEngine();
            }
            this.engine = null;
            this.state = State.DESTROY_END;
        }
    }

    public final long getEngineId() {
        return this.engineId;
    }

    public final long getId$GaiaX_Android_JS() {
        return this.engineId;
    }

    @NotNull
    public final GaiaXJS.GaiaXJSType getType() {
        return this.type;
    }

    public final void initEngine$GaiaX_Android_JS() {
        if (this.state == State.NONE || this.state == State.DESTROY_END) {
            this.state = State.INIT_START;
            if (this.engine == null) {
                this.engine = createEngine();
            }
            IEngine iEngine = this.engine;
            if (iEngine != null) {
                iEngine.initEngine();
            }
            if (this.runtime == null) {
                GaiaXRuntime.Companion companion = GaiaXRuntime.Companion;
                IEngine iEngine2 = this.engine;
                b41.f(iEngine2);
                this.runtime = companion.create(this, iEngine2, this.type);
            }
            GaiaXRuntime gaiaXRuntime = this.runtime;
            if (gaiaXRuntime != null) {
                gaiaXRuntime.initRuntime();
            }
            this.state = State.INIT_END;
        }
    }

    @Nullable
    public final GaiaXRuntime runtime$GaiaX_Android_JS() {
        return this.runtime;
    }

    public final void startEngine$GaiaX_Android_JS(@NotNull Function0<wt2> function0) {
        b41.i(function0, "complete");
        if (this.state == State.INIT_END) {
            this.state = State.RUNNING_START;
            GaiaXRuntime gaiaXRuntime = this.runtime;
            if (gaiaXRuntime != null) {
                gaiaXRuntime.startRuntime(function0);
            }
            this.state = State.RUNNING_END;
        }
    }
}
