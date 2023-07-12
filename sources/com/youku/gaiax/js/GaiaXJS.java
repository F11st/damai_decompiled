package com.youku.gaiax.js;

import android.content.Context;
import android.content.res.AssetManager;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.security.realidentity.jsbridge.a;
import com.alipay.sdk.m.k.b;
import com.taobao.tao.log.TLogConstant;
import com.taobao.weex.common.Constants;
import com.uc.webview.export.extension.UCCore;
import com.youku.arch.v3.event.Subject;
import com.youku.gaiax.js.GaiaXJS;
import com.youku.gaiax.js.api.GaiaXBaseModule;
import com.youku.gaiax.js.core.GaiaXContext;
import com.youku.gaiax.js.core.GaiaXEngine;
import com.youku.gaiax.js.core.GaiaXRuntime;
import com.youku.gaiax.js.support.GaiaXModuleManager;
import com.youku.gaiax.js.support.IModuleManager;
import com.youku.gaiax.js.support.module.GaiaXNativeMessageEventModule;
import com.youku.gaiax.js.support.module.GaiaXNativeUtilModule;
import com.youku.gaiax.js.utils.Aop;
import com.youku.gaiax.js.utils.IdGenerator;
import com.youku.gaiax.js.utils.Log;
import com.youku.gaiax.js.utils.MonitorUtils;
import io.flutter.wpkbridge.WPKFactory;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.text.o;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.fm2;
import tb.hh1;
import tb.hi;
import tb.k50;
import tb.wt2;
import tb.xj;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 j2\u00020\u0001:\u0003jklB\u0007¢\u0006\u0004\bh\u0010iJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J!\u0010\u000b\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0005\u0018\u00010\n2\u0006\u0010\t\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u000b\u0010\fJ\b\u0010\r\u001a\u00020\u0002H\u0002J\u0010\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J \u0010\u0015\u001a\u00020\u00022\b\u0010\u0012\u001a\u0004\u0018\u00010\u00102\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00020\u0013H\u0002J\u001e\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00162\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00020\u0013H\u0002J\u0012\u0010\u0018\u001a\u00020\u00022\b\u0010\u0012\u001a\u0004\u0018\u00010\u0010H\u0002J\u0010\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0016H\u0002J\u0018\u0010\u001c\u001a\u00020\u00022\u000e\u0010\u001b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u001a0\u0019H\u0002J\u0010\u0010\u001e\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u0016H\u0002J\u000e\u0010!\u001a\u00020\u00002\u0006\u0010 \u001a\u00020\u001fJ\u000e\u0010$\u001a\u00020\u00002\u0006\u0010#\u001a\u00020\"J\u001e\u0010'\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u00162\u0006\u0010\u000f\u001a\u00020\u00052\u0006\u0010&\u001a\u00020%J\u0016\u0010(\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u00162\u0006\u0010&\u001a\u00020%J\u000e\u0010)\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u0016J\u000e\u0010*\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u0016J\u000e\u0010+\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u0016J\u000e\u0010,\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u0016J\u000e\u0010-\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u0016J\u0016\u0010.\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u00162\u0006\u0010&\u001a\u00020%J&\u00103\u001a\u00020\u00162\u0006\u0010/\u001a\u00020\u00052\u0006\u00100\u001a\u00020\u00052\u0006\u00101\u001a\u00020\u00052\u0006\u00102\u001a\u00020\u0005J\u000e\u00104\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u0016J\u0014\u0010\u0015\u001a\u00020\u00022\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00020\u0013J\u0006\u00105\u001a\u00020\u0002J\u0016\u00106\u001a\u00020\u00002\u000e\u0010\u001b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u001a0\u0019J\u000e\u00109\u001a\u00020\u00022\u0006\u00108\u001a\u000207J$\u0010<\u001a\u00020\u00022\u0006\u00108\u001a\u0002072\u0006\u0010:\u001a\u00020\u00162\f\u0010;\u001a\b\u0012\u0004\u0012\u00020\u00020\u0013J\u0014\u0010>\u001a\u00020\u00022\f\u0010=\u001a\b\u0012\u0004\u0012\u00020\u00020\u0013J$\u0010@\u001a\u00020\u00022\u0006\u00108\u001a\u0002072\u0006\u0010?\u001a\u00020\u00162\f\u0010=\u001a\b\u0012\u0004\u0012\u00020\u00020\u0013J\u000e\u0010A\u001a\u00020\u00022\u0006\u00108\u001a\u000207J\u0019\u0010 \u001a\u0004\u0018\u00010B2\u0006\u0010\u0017\u001a\u00020\u0016H\u0000¢\u0006\u0004\bC\u0010DJ)\u0010K\u001a\u0004\u0018\u00010\u00012\u0006\u0010E\u001a\u00020\u00162\u0006\u0010F\u001a\u00020\u00162\u0006\u0010H\u001a\u00020GH\u0000¢\u0006\u0004\bI\u0010JJ'\u0010N\u001a\u00020\u00022\u0006\u0010E\u001a\u00020\u00162\u0006\u0010F\u001a\u00020\u00162\u0006\u0010H\u001a\u00020GH\u0000¢\u0006\u0004\bL\u0010MJ'\u0010P\u001a\u00020\u00022\u0006\u0010E\u001a\u00020\u00162\u0006\u0010F\u001a\u00020\u00162\u0006\u0010H\u001a\u00020GH\u0000¢\u0006\u0004\bO\u0010MJ\u000f\u0010S\u001a\u00020\u0005H\u0000¢\u0006\u0004\bQ\u0010RJ\u000f\u0010U\u001a\u00020\u0005H\u0000¢\u0006\u0004\bT\u0010RR$\u0010#\u001a\u0004\u0018\u00010\"8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b#\u0010V\u001a\u0004\bW\u0010X\"\u0004\bY\u0010ZR\"\u0010 \u001a\u00020\u001f8\u0000@\u0000X\u0080.¢\u0006\u0012\n\u0004\b \u0010[\u001a\u0004\b\\\u0010]\"\u0004\b^\u0010_R\"\u0010a\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00100`8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\ba\u0010bR\u0016\u0010d\u001a\u00020c8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bd\u0010eR\u0018\u0010f\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bf\u0010g¨\u0006m"}, d2 = {"Lcom/youku/gaiax/js/GaiaXJS;", "", "Ltb/wt2;", "initModules", "registerAssetsModules", "", "file", "Ljava/io/InputStream;", "assetsOpen", a.V, "", "assetsModules", "(Ljava/lang/String;)[Ljava/lang/String;", "registerInnerModules", "Lcom/youku/gaiax/js/GaiaXJS$GaiaXJSType;", "type", "Lcom/youku/gaiax/js/core/GaiaXEngine;", "createEngine", "engine", "Lkotlin/Function0;", "complete", "startEngine", "", "engineId", "destroyEngine", "Ljava/lang/Class;", "Lcom/youku/gaiax/js/api/GaiaXBaseModule;", "moduleClazz", "unregisterModule", "id", "checkIdEngineExist", "Landroid/content/Context;", WPKFactory.INIT_KEY_CONTEXT, UCCore.LEGACY_EVENT_INIT, "Lcom/youku/gaiax/js/GaiaXJS$Listener;", "listener", "initListener", "Lcom/alibaba/fastjson/JSONObject;", "data", "onEventComponent", "onNativeEventComponent", "onReadyComponent", "onReuseComponent", "onShowComponent", "onHiddenComponent", "onDestroyComponent", "onLoadMoreComponent", hh1.DIMEN_BIZ, "templateId", "templateVersion", "script", "registerComponent", "unregisterComponent", "stopEngine", "registerModule", "", TLogConstant.PERSIST_TASK_ID, "remoteDelayTask", "delay", Subject.FUNCTION, "executeDelayTask", "func", "executeTask", Constants.Name.INTERVAL, "executeIntervalTask", "remoteIntervalTask", "Lcom/youku/gaiax/js/core/GaiaXContext;", "context$GaiaX_Android_JS", "(J)Lcom/youku/gaiax/js/core/GaiaXContext;", "moduleId", "methodId", "Lcom/alibaba/fastjson/JSONArray;", "args", "invokeSyncMethod$GaiaX_Android_JS", "(JJLcom/alibaba/fastjson/JSONArray;)Ljava/lang/Object;", "invokeSyncMethod", "invokeAsyncMethod$GaiaX_Android_JS", "(JJLcom/alibaba/fastjson/JSONArray;)V", "invokeAsyncMethod", "invokePromiseMethod$GaiaX_Android_JS", "invokePromiseMethod", "buildModulesScript$GaiaX_Android_JS", "()Ljava/lang/String;", "buildModulesScript", "buildBootstrapScript$GaiaX_Android_JS", "buildBootstrapScript", "Lcom/youku/gaiax/js/GaiaXJS$Listener;", "getListener$GaiaX_Android_JS", "()Lcom/youku/gaiax/js/GaiaXJS$Listener;", "setListener$GaiaX_Android_JS", "(Lcom/youku/gaiax/js/GaiaXJS$Listener;)V", "Landroid/content/Context;", "getContext$GaiaX_Android_JS", "()Landroid/content/Context;", "setContext$GaiaX_Android_JS", "(Landroid/content/Context;)V", "Ljava/util/concurrent/ConcurrentHashMap;", "engines", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/youku/gaiax/js/support/IModuleManager;", "moduleManager", "Lcom/youku/gaiax/js/support/IModuleManager;", "defaultEngine", "Lcom/youku/gaiax/js/core/GaiaXEngine;", "<init>", "()V", "Companion", "GaiaXJSType", "Listener", "GaiaX-Android-JS"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class GaiaXJS {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private static final String GAIAX_JS_MODULES = "gaiax_js_modules";
    @NotNull
    private static final String MODULE_PREFIX = "module_";
    @NotNull
    private static final String MODULE_SUFFIX = ".json";
    @NotNull
    private static final Lazy<GaiaXJS> instance$delegate;
    public Context context;
    @Nullable
    private GaiaXEngine defaultEngine;
    @Nullable
    private Listener listener;
    @NotNull
    private final ConcurrentHashMap<Long, GaiaXEngine> engines = new ConcurrentHashMap<>();
    @NotNull
    private final IModuleManager moduleManager = new GaiaXModuleManager();

    /* compiled from: Taobao */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\r\u0010\u000eR\u001d\u0010\u0007\u001a\u00020\u00028F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0016\u0010\t\u001a\u00020\b8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\u000b\u001a\u00020\b8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000b\u0010\nR\u0016\u0010\f\u001a\u00020\b8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\f\u0010\n¨\u0006\u000f"}, d2 = {"Lcom/youku/gaiax/js/GaiaXJS$Companion;", "", "Lcom/youku/gaiax/js/GaiaXJS;", "instance$delegate", "Lkotlin/Lazy;", "getInstance", "()Lcom/youku/gaiax/js/GaiaXJS;", "instance", "", "GAIAX_JS_MODULES", "Ljava/lang/String;", "MODULE_PREFIX", "MODULE_SUFFIX", "<init>", "()V", "GaiaX-Android-JS"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(k50 k50Var) {
            this();
        }

        @NotNull
        public final GaiaXJS getInstance() {
            return (GaiaXJS) GaiaXJS.instance$delegate.getValue();
        }
    }

    /* compiled from: Taobao */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/youku/gaiax/js/GaiaXJS$GaiaXJSType;", "", "<init>", "(Ljava/lang/String;I)V", "QuickJS", "GaiaX-Android-JS"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes2.dex */
    public enum GaiaXJSType {
        QuickJS
    }

    /* compiled from: Taobao */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J`\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\u00062\b\b\u0002\u0010\n\u001a\u00020\u00062\b\b\u0002\u0010\u000b\u001a\u00020\u00062\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\u00062\b\b\u0002\u0010\u000f\u001a\u00020\u00062\b\b\u0002\u0010\u0010\u001a\u00020\u0006H&¨\u0006\u0012"}, d2 = {"Lcom/youku/gaiax/js/GaiaXJS$Listener;", "", "Lcom/alibaba/fastjson/JSONObject;", "data", "Ltb/wt2;", "errorLog", "", "scene", b.l, "id", "type", "state", "", "value", "jsModuleName", "jsApiName", "jsApiType", "monitor", "GaiaX-Android-JS"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes2.dex */
    public interface Listener {

        /* compiled from: Taobao */
        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 5, 1})
        /* loaded from: classes2.dex */
        public static final class DefaultImpls {
            public static /* synthetic */ void monitor$default(Listener listener, String str, String str2, String str3, String str4, String str5, long j, String str6, String str7, String str8, int i, Object obj) {
                if (obj != null) {
                    throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: monitor");
                }
                listener.monitor(str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "" : str3, (i & 8) != 0 ? "" : str4, (i & 16) != 0 ? "" : str5, (i & 32) != 0 ? -1L : j, (i & 64) != 0 ? "" : str6, (i & 128) != 0 ? "" : str7, (i & 256) == 0 ? str8 : "");
            }
        }

        void errorLog(@NotNull JSONObject jSONObject);

        void monitor(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, long j, @NotNull String str6, @NotNull String str7, @NotNull String str8);
    }

    static {
        Lazy<GaiaXJS> b;
        b = kotlin.b.b(new Function0<GaiaXJS>() { // from class: com.youku.gaiax.js.GaiaXJS$Companion$instance$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final GaiaXJS invoke() {
                return new GaiaXJS();
            }
        });
        instance$delegate = b;
    }

    private final String[] assetsModules(String str) {
        String[] list;
        AssetManager assets = getContext$GaiaX_Android_JS().getAssets();
        b41.h(assets, "context.assets");
        synchronized (assets) {
            list = getContext$GaiaX_Android_JS().getAssets().list(str);
        }
        return list;
    }

    private final InputStream assetsOpen(String str) {
        InputStream open;
        AssetManager assets = getContext$GaiaX_Android_JS().getAssets();
        b41.h(assets, "context.assets");
        synchronized (assets) {
            open = getContext$GaiaX_Android_JS().getAssets().open(str);
        }
        b41.h(open, "synchronized(context.ass…ntext.assets.open(file) }");
        return open;
    }

    private final void checkIdEngineExist(long j) {
        if (this.engines.containsKey(Long.valueOf(j))) {
            throw new IllegalArgumentException("Id Engine Exist");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final GaiaXEngine createEngine(GaiaXJSType gaiaXJSType) {
        long genLongId = IdGenerator.INSTANCE.genLongId();
        checkIdEngineExist(genLongId);
        GaiaXEngine create = GaiaXEngine.Companion.create(genLongId, gaiaXJSType);
        this.engines.put(Long.valueOf(genLongId), create);
        create.initEngine$GaiaX_Android_JS();
        return create;
    }

    private final void destroyEngine(GaiaXEngine gaiaXEngine) {
        if (gaiaXEngine == null) {
            return;
        }
        destroyEngine(gaiaXEngine.getId$GaiaX_Android_JS());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void initModules() {
        try {
            registerInnerModules();
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            registerAssetsModules();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void registerAssetsModules() {
        boolean F;
        boolean p;
        JSONObject jSONObject = new JSONObject();
        String[] assetsModules = assetsModules(GAIAX_JS_MODULES);
        if (assetsModules != null) {
            for (String str : assetsModules) {
                Log log = Log.INSTANCE;
                if (log.isLog()) {
                    log.d(b41.r("registerAssetsModules() called with: file = ", str));
                }
                F = o.F(str, MODULE_PREFIX, false, 2, null);
                if (F) {
                    p = o.p(str, MODULE_SUFFIX, false, 2, null);
                    if (p) {
                        try {
                            InputStreamReader inputStreamReader = new InputStreamReader(assetsOpen(b41.r("gaiax_js_modules/", str)), hi.UTF_8);
                            BufferedReader bufferedReader = inputStreamReader instanceof BufferedReader ? (BufferedReader) inputStreamReader : new BufferedReader(inputStreamReader, 8192);
                            String c = fm2.c(bufferedReader);
                            xj.a(bufferedReader, null);
                            jSONObject.putAll(JSON.parseObject(c));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
        for (Map.Entry<String, Object> entry : jSONObject.entrySet()) {
            Class<?> cls = Class.forName(entry.getValue().toString());
            if (b41.d(cls.getSuperclass(), GaiaXBaseModule.class)) {
                registerModule(cls);
            } else {
                throw new IllegalArgumentException("Register Module " + cls + " Illegal");
            }
        }
    }

    private final void registerInnerModules() {
        registerModule(GaiaXNativeUtilModule.class);
        registerModule(GaiaXNativeMessageEventModule.class);
    }

    private final void unregisterModule(Class<? extends GaiaXBaseModule> cls) {
        this.moduleManager.unregisterModule(cls);
    }

    @NotNull
    public final String buildBootstrapScript$GaiaX_Android_JS() {
        InputStream open = getContext$GaiaX_Android_JS().getResources().getAssets().open(GaiaXContext.BOOTSTRAP_JS);
        b41.h(open, "context.resources.assets…aiaXContext.BOOTSTRAP_JS)");
        InputStreamReader inputStreamReader = new InputStreamReader(open, hi.UTF_8);
        BufferedReader bufferedReader = inputStreamReader instanceof BufferedReader ? (BufferedReader) inputStreamReader : new BufferedReader(inputStreamReader, 8192);
        try {
            String c = fm2.c(bufferedReader);
            xj.a(bufferedReader, null);
            return c;
        } finally {
        }
    }

    @NotNull
    public final String buildModulesScript$GaiaX_Android_JS() {
        return this.moduleManager.buildModulesScript();
    }

    @Nullable
    public final GaiaXContext context$GaiaX_Android_JS(long j) {
        GaiaXRuntime runtime$GaiaX_Android_JS;
        GaiaXEngine gaiaXEngine = this.engines.get(Long.valueOf(j));
        if (gaiaXEngine == null || (runtime$GaiaX_Android_JS = gaiaXEngine.runtime$GaiaX_Android_JS()) == null) {
            return null;
        }
        return runtime$GaiaX_Android_JS.context();
    }

    public final void executeDelayTask(int i, long j, @NotNull Function0<wt2> function0) {
        GaiaXRuntime runtime$GaiaX_Android_JS;
        GaiaXContext context;
        b41.i(function0, Subject.FUNCTION);
        GaiaXEngine gaiaXEngine = this.defaultEngine;
        if (gaiaXEngine == null || (runtime$GaiaX_Android_JS = gaiaXEngine.runtime$GaiaX_Android_JS()) == null || (context = runtime$GaiaX_Android_JS.context()) == null) {
            return;
        }
        context.executeDelayTask(i, j, function0);
    }

    public final void executeIntervalTask(int i, long j, @NotNull Function0<wt2> function0) {
        GaiaXRuntime runtime$GaiaX_Android_JS;
        GaiaXContext context;
        b41.i(function0, "func");
        GaiaXEngine gaiaXEngine = this.defaultEngine;
        if (gaiaXEngine == null || (runtime$GaiaX_Android_JS = gaiaXEngine.runtime$GaiaX_Android_JS()) == null || (context = runtime$GaiaX_Android_JS.context()) == null) {
            return;
        }
        context.executeIntervalTask(i, j, function0);
    }

    public final void executeTask(@NotNull Function0<wt2> function0) {
        GaiaXRuntime runtime$GaiaX_Android_JS;
        GaiaXContext context;
        b41.i(function0, "func");
        GaiaXEngine gaiaXEngine = this.defaultEngine;
        if (gaiaXEngine == null || (runtime$GaiaX_Android_JS = gaiaXEngine.runtime$GaiaX_Android_JS()) == null || (context = runtime$GaiaX_Android_JS.context()) == null) {
            return;
        }
        context.executeTask(function0);
    }

    @NotNull
    public final Context getContext$GaiaX_Android_JS() {
        Context context = this.context;
        if (context != null) {
            return context;
        }
        b41.A(WPKFactory.INIT_KEY_CONTEXT);
        return null;
    }

    @Nullable
    public final Listener getListener$GaiaX_Android_JS() {
        return this.listener;
    }

    @NotNull
    public final GaiaXJS init(@NotNull Context context) {
        b41.i(context, WPKFactory.INIT_KEY_CONTEXT);
        Context applicationContext = context.getApplicationContext();
        b41.h(applicationContext, "context.applicationContext");
        setContext$GaiaX_Android_JS(applicationContext);
        Aop.INSTANCE.aopTaskTime(new Function0<wt2>() { // from class: com.youku.gaiax.js.GaiaXJS$init$1
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
                GaiaXJS.this.initModules();
            }
        }, new Function1<Long, wt2>() { // from class: com.youku.gaiax.js.GaiaXJS$init$2
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ wt2 invoke(Long l) {
                invoke(l.longValue());
                return wt2.INSTANCE;
            }

            public final void invoke(long j) {
                MonitorUtils.INSTANCE.jsInitScene(MonitorUtils.TYPE_LOAD_MODULE, j);
            }
        });
        return this;
    }

    @NotNull
    public final GaiaXJS initListener(@NotNull Listener listener) {
        b41.i(listener, "listener");
        this.listener = listener;
        return this;
    }

    public final void invokeAsyncMethod$GaiaX_Android_JS(long j, long j2, @NotNull JSONArray jSONArray) {
        b41.i(jSONArray, "args");
        this.moduleManager.invokeMethodAsync(j, j2, jSONArray);
    }

    public final void invokePromiseMethod$GaiaX_Android_JS(long j, long j2, @NotNull JSONArray jSONArray) {
        b41.i(jSONArray, "args");
        this.moduleManager.invokePromiseMethod(j, j2, jSONArray);
    }

    @Nullable
    public final Object invokeSyncMethod$GaiaX_Android_JS(long j, long j2, @NotNull JSONArray jSONArray) {
        b41.i(jSONArray, "args");
        return this.moduleManager.invokeMethodSync(j, j2, jSONArray);
    }

    public final void onDestroyComponent(long j) {
        GaiaXRuntime runtime$GaiaX_Android_JS;
        GaiaXContext context;
        GaiaXEngine gaiaXEngine = this.defaultEngine;
        if (gaiaXEngine == null || (runtime$GaiaX_Android_JS = gaiaXEngine.runtime$GaiaX_Android_JS()) == null || (context = runtime$GaiaX_Android_JS.context()) == null) {
            return;
        }
        context.onDestroyComponent(j);
    }

    public final void onEventComponent(long j, @NotNull String str, @NotNull JSONObject jSONObject) {
        GaiaXRuntime runtime$GaiaX_Android_JS;
        GaiaXContext context;
        b41.i(str, "type");
        b41.i(jSONObject, "data");
        GaiaXEngine gaiaXEngine = this.defaultEngine;
        if (gaiaXEngine == null || (runtime$GaiaX_Android_JS = gaiaXEngine.runtime$GaiaX_Android_JS()) == null || (context = runtime$GaiaX_Android_JS.context()) == null) {
            return;
        }
        context.onEventComponent(j, str, jSONObject);
    }

    public final void onHiddenComponent(long j) {
        GaiaXRuntime runtime$GaiaX_Android_JS;
        GaiaXContext context;
        GaiaXEngine gaiaXEngine = this.defaultEngine;
        if (gaiaXEngine == null || (runtime$GaiaX_Android_JS = gaiaXEngine.runtime$GaiaX_Android_JS()) == null || (context = runtime$GaiaX_Android_JS.context()) == null) {
            return;
        }
        context.onHiddenComponent(j);
    }

    public final void onLoadMoreComponent(long j, @NotNull JSONObject jSONObject) {
        GaiaXRuntime runtime$GaiaX_Android_JS;
        GaiaXContext context;
        b41.i(jSONObject, "data");
        GaiaXEngine gaiaXEngine = this.defaultEngine;
        if (gaiaXEngine == null || (runtime$GaiaX_Android_JS = gaiaXEngine.runtime$GaiaX_Android_JS()) == null || (context = runtime$GaiaX_Android_JS.context()) == null) {
            return;
        }
        context.onLoadMoreComponent(j, jSONObject);
    }

    public final void onNativeEventComponent(long j, @NotNull JSONObject jSONObject) {
        GaiaXRuntime runtime$GaiaX_Android_JS;
        GaiaXContext context;
        b41.i(jSONObject, "data");
        GaiaXEngine gaiaXEngine = this.defaultEngine;
        if (gaiaXEngine == null || (runtime$GaiaX_Android_JS = gaiaXEngine.runtime$GaiaX_Android_JS()) == null || (context = runtime$GaiaX_Android_JS.context()) == null) {
            return;
        }
        context.onNativeEventComponent(j, jSONObject);
    }

    public final void onReadyComponent(long j) {
        GaiaXRuntime runtime$GaiaX_Android_JS;
        GaiaXContext context;
        GaiaXEngine gaiaXEngine = this.defaultEngine;
        if (gaiaXEngine == null || (runtime$GaiaX_Android_JS = gaiaXEngine.runtime$GaiaX_Android_JS()) == null || (context = runtime$GaiaX_Android_JS.context()) == null) {
            return;
        }
        context.onReadyComponent(j);
    }

    public final void onReuseComponent(long j) {
        GaiaXRuntime runtime$GaiaX_Android_JS;
        GaiaXContext context;
        GaiaXEngine gaiaXEngine = this.defaultEngine;
        if (gaiaXEngine == null || (runtime$GaiaX_Android_JS = gaiaXEngine.runtime$GaiaX_Android_JS()) == null || (context = runtime$GaiaX_Android_JS.context()) == null) {
            return;
        }
        context.onReuseComponent(j);
    }

    public final void onShowComponent(long j) {
        GaiaXRuntime runtime$GaiaX_Android_JS;
        GaiaXContext context;
        GaiaXEngine gaiaXEngine = this.defaultEngine;
        if (gaiaXEngine == null || (runtime$GaiaX_Android_JS = gaiaXEngine.runtime$GaiaX_Android_JS()) == null || (context = runtime$GaiaX_Android_JS.context()) == null) {
            return;
        }
        context.onShowComponent(j);
    }

    public final long registerComponent(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4) {
        GaiaXRuntime runtime$GaiaX_Android_JS;
        GaiaXContext context;
        b41.i(str, hh1.DIMEN_BIZ);
        b41.i(str2, "templateId");
        b41.i(str3, "templateVersion");
        b41.i(str4, "script");
        GaiaXEngine gaiaXEngine = this.defaultEngine;
        if (gaiaXEngine == null || (runtime$GaiaX_Android_JS = gaiaXEngine.runtime$GaiaX_Android_JS()) == null || (context = runtime$GaiaX_Android_JS.context()) == null) {
            return -1L;
        }
        return context.registerComponent(str, str2, str3, str4);
    }

    @NotNull
    public final GaiaXJS registerModule(@NotNull Class<? extends GaiaXBaseModule> cls) {
        b41.i(cls, "moduleClazz");
        Log log = Log.INSTANCE;
        if (log.isLog()) {
            log.d(b41.r("registerModule() called with: moduleClazz = ", cls));
        }
        this.moduleManager.registerModule(cls);
        return this;
    }

    public final void remoteDelayTask(int i) {
        GaiaXRuntime runtime$GaiaX_Android_JS;
        GaiaXContext context;
        GaiaXEngine gaiaXEngine = this.defaultEngine;
        if (gaiaXEngine == null || (runtime$GaiaX_Android_JS = gaiaXEngine.runtime$GaiaX_Android_JS()) == null || (context = runtime$GaiaX_Android_JS.context()) == null) {
            return;
        }
        context.remoteDelayTask(i);
    }

    public final void remoteIntervalTask(int i) {
        GaiaXRuntime runtime$GaiaX_Android_JS;
        GaiaXContext context;
        GaiaXEngine gaiaXEngine = this.defaultEngine;
        if (gaiaXEngine == null || (runtime$GaiaX_Android_JS = gaiaXEngine.runtime$GaiaX_Android_JS()) == null || (context = runtime$GaiaX_Android_JS.context()) == null) {
            return;
        }
        context.remoteIntervalTask(i);
    }

    public final void setContext$GaiaX_Android_JS(@NotNull Context context) {
        b41.i(context, "<set-?>");
        this.context = context;
    }

    public final void setListener$GaiaX_Android_JS(@Nullable Listener listener) {
        this.listener = listener;
    }

    public final void startEngine(@NotNull Function0<wt2> function0) {
        b41.i(function0, "complete");
        synchronized (GaiaXJS.class) {
            if (this.defaultEngine == null) {
                GaiaXEngine gaiaXEngine = (GaiaXEngine) Aop.INSTANCE.aopTaskTime(new Function0<GaiaXEngine>() { // from class: com.youku.gaiax.js.GaiaXJS$startEngine$1$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    @NotNull
                    public final GaiaXEngine invoke() {
                        GaiaXEngine createEngine;
                        createEngine = GaiaXJS.this.createEngine(GaiaXJS.GaiaXJSType.QuickJS);
                        return createEngine;
                    }
                }, new Function1<Long, wt2>() { // from class: com.youku.gaiax.js.GaiaXJS$startEngine$1$2
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ wt2 invoke(Long l) {
                        invoke(l.longValue());
                        return wt2.INSTANCE;
                    }

                    public final void invoke(long j) {
                        MonitorUtils.INSTANCE.jsInitScene(MonitorUtils.TYPE_JS_CONTEXT_INIT, j);
                    }
                });
                this.defaultEngine = gaiaXEngine;
                startEngine(gaiaXEngine, function0);
            }
            wt2 wt2Var = wt2.INSTANCE;
        }
    }

    public final void stopEngine() {
        synchronized (GaiaXJS.class) {
            GaiaXEngine gaiaXEngine = this.defaultEngine;
            if (gaiaXEngine != null) {
                destroyEngine(gaiaXEngine);
                this.defaultEngine = null;
            }
            wt2 wt2Var = wt2.INSTANCE;
        }
    }

    public final void unregisterComponent(long j) {
        GaiaXRuntime runtime$GaiaX_Android_JS;
        GaiaXContext context;
        GaiaXEngine gaiaXEngine = this.defaultEngine;
        if (gaiaXEngine == null || (runtime$GaiaX_Android_JS = gaiaXEngine.runtime$GaiaX_Android_JS()) == null || (context = runtime$GaiaX_Android_JS.context()) == null) {
            return;
        }
        context.unregisterComponent(j);
    }

    private final void destroyEngine(long j) {
        GaiaXEngine remove;
        if (!this.engines.containsKey(Long.valueOf(j)) || (remove = this.engines.remove(Long.valueOf(j))) == null) {
            return;
        }
        remove.destroyEngine$GaiaX_Android_JS();
    }

    private final void startEngine(GaiaXEngine gaiaXEngine, Function0<wt2> function0) {
        if (gaiaXEngine == null) {
            return;
        }
        startEngine(gaiaXEngine.getId$GaiaX_Android_JS(), function0);
    }

    private final void startEngine(long j, Function0<wt2> function0) {
        GaiaXEngine gaiaXEngine;
        if (!this.engines.containsKey(Long.valueOf(j)) || (gaiaXEngine = this.engines.get(Long.valueOf(j))) == null) {
            return;
        }
        gaiaXEngine.startEngine$GaiaX_Android_JS(function0);
    }
}
