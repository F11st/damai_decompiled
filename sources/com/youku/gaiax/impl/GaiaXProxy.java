package com.youku.gaiax.impl;

import com.alibaba.fastjson.JSONObject;
import com.vivo.push.PushClientConstants;
import com.youku.arch.v3.core.Constants;
import com.youku.gaiax.EnvConfig;
import com.youku.gaiax.IEnvConfig;
import com.youku.gaiax.api.proxy.IProxyApp;
import com.youku.gaiax.api.proxy.IProxyDesignToken;
import com.youku.gaiax.api.proxy.IProxyFeatures;
import com.youku.gaiax.api.proxy.IProxyMonitor;
import com.youku.gaiax.api.proxy.IProxyNet;
import com.youku.gaiax.api.proxy.IProxyPrefs;
import com.youku.gaiax.api.proxy.IProxySource;
import com.youku.gaiax.api.proxy.IProxyTask;
import com.youku.gaiax.api.proxy.IProxyViews;
import com.youku.gaiax.common.utils.Log;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.k50;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 V2\u00020\u0001:\u0001VB\u0007¢\u0006\u0004\bT\u0010UJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J!\u0010\u000e\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0006\u0010\u0014\u001a\u00020\u0002R$\u0010\u0016\u001a\u0004\u0018\u00010\u00158\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR$\u0010\u001d\u001a\u0004\u0018\u00010\u001c8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R$\u0010$\u001a\u0004\u0018\u00010#8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R$\u0010+\u001a\u0004\u0018\u00010*8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R$\u00102\u001a\u0004\u0018\u0001018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b2\u00103\u001a\u0004\b4\u00105\"\u0004\b6\u00107R$\u00109\u001a\u0004\u0018\u0001088\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b9\u0010:\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R$\u0010@\u001a\u0004\u0018\u00010?8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b@\u0010A\u001a\u0004\bB\u0010C\"\u0004\bD\u0010ER$\u0010G\u001a\u0004\u0018\u00010F8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bG\u0010H\u001a\u0004\bI\u0010J\"\u0004\bK\u0010LR$\u0010N\u001a\u0004\u0018\u00010M8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bN\u0010O\u001a\u0004\bP\u0010Q\"\u0004\bR\u0010S¨\u0006W"}, d2 = {"Lcom/youku/gaiax/impl/GaiaXProxy;", "", "Ltb/wt2;", "initConfig", "Lcom/alibaba/fastjson/JSONObject;", Constants.CONFIG, "initViewsModule", "initAppModule", "initTaskModule", "initPrefsModule", "initSourceModule", "T", "", PushClientConstants.TAG_CLASS_NAME, "tryToCreateClazz", "(Ljava/lang/String;)Ljava/lang/Object;", "initDesignTokenModule", "initNetModule", "initFeaturesModule", "initMonitorModule", "initModules", "Lcom/youku/gaiax/api/proxy/IProxyApp;", "app", "Lcom/youku/gaiax/api/proxy/IProxyApp;", "getApp", "()Lcom/youku/gaiax/api/proxy/IProxyApp;", "setApp", "(Lcom/youku/gaiax/api/proxy/IProxyApp;)V", "Lcom/youku/gaiax/api/proxy/IProxyTask;", "task", "Lcom/youku/gaiax/api/proxy/IProxyTask;", "getTask", "()Lcom/youku/gaiax/api/proxy/IProxyTask;", "setTask", "(Lcom/youku/gaiax/api/proxy/IProxyTask;)V", "Lcom/youku/gaiax/api/proxy/IProxyPrefs;", "prefs", "Lcom/youku/gaiax/api/proxy/IProxyPrefs;", "getPrefs", "()Lcom/youku/gaiax/api/proxy/IProxyPrefs;", "setPrefs", "(Lcom/youku/gaiax/api/proxy/IProxyPrefs;)V", "Lcom/youku/gaiax/api/proxy/IProxySource;", "source", "Lcom/youku/gaiax/api/proxy/IProxySource;", "getSource", "()Lcom/youku/gaiax/api/proxy/IProxySource;", "setSource", "(Lcom/youku/gaiax/api/proxy/IProxySource;)V", "Lcom/youku/gaiax/api/proxy/IProxyViews;", "views", "Lcom/youku/gaiax/api/proxy/IProxyViews;", "getViews", "()Lcom/youku/gaiax/api/proxy/IProxyViews;", "setViews", "(Lcom/youku/gaiax/api/proxy/IProxyViews;)V", "Lcom/youku/gaiax/api/proxy/IProxyDesignToken;", "designToken", "Lcom/youku/gaiax/api/proxy/IProxyDesignToken;", "getDesignToken", "()Lcom/youku/gaiax/api/proxy/IProxyDesignToken;", "setDesignToken", "(Lcom/youku/gaiax/api/proxy/IProxyDesignToken;)V", "Lcom/youku/gaiax/api/proxy/IProxyFeatures;", "features", "Lcom/youku/gaiax/api/proxy/IProxyFeatures;", "getFeatures", "()Lcom/youku/gaiax/api/proxy/IProxyFeatures;", "setFeatures", "(Lcom/youku/gaiax/api/proxy/IProxyFeatures;)V", "Lcom/youku/gaiax/api/proxy/IProxyMonitor;", "monitor", "Lcom/youku/gaiax/api/proxy/IProxyMonitor;", "getMonitor", "()Lcom/youku/gaiax/api/proxy/IProxyMonitor;", "setMonitor", "(Lcom/youku/gaiax/api/proxy/IProxyMonitor;)V", "Lcom/youku/gaiax/api/proxy/IProxyNet;", "net", "Lcom/youku/gaiax/api/proxy/IProxyNet;", "getNet", "()Lcom/youku/gaiax/api/proxy/IProxyNet;", "setNet", "(Lcom/youku/gaiax/api/proxy/IProxyNet;)V", "<init>", "()V", "Companion", "GaiaX-Android"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class GaiaXProxy {
    @NotNull
    private static final String TAG = "[GaiaX]";
    @Nullable

    /* renamed from: app  reason: collision with root package name */
    private IProxyApp f1033app;
    @Nullable
    private IProxyDesignToken designToken;
    @Nullable
    private IProxyFeatures features;
    @Nullable
    private IProxyMonitor monitor;
    @Nullable

    /* renamed from: net  reason: collision with root package name */
    private IProxyNet f1034net;
    @Nullable
    private IProxyPrefs prefs;
    @Nullable
    private IProxySource source;
    @Nullable
    private IProxyTask task;
    @Nullable
    private IProxyViews views;
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private static final GaiaXProxy instance = new GaiaXProxy();

    /* compiled from: Taobao */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bR\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0016\u0010\b\u001a\u00020\u00078\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/youku/gaiax/impl/GaiaXProxy$Companion;", "", "Lcom/youku/gaiax/impl/GaiaXProxy;", "instance", "Lcom/youku/gaiax/impl/GaiaXProxy;", "getInstance", "()Lcom/youku/gaiax/impl/GaiaXProxy;", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "GaiaX-Android"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(k50 k50Var) {
            this();
        }

        @NotNull
        public final GaiaXProxy getInstance() {
            return GaiaXProxy.instance;
        }
    }

    public GaiaXProxy() {
        initConfig();
    }

    private final void initAppModule(JSONObject jSONObject) {
        Object obj = jSONObject.get(EnvConfig.CONFIG_MODULE_APP_KEY);
        String str = obj instanceof String ? (String) obj : null;
        if (str != null) {
            setApp((IProxyApp) tryToCreateClazz(str));
        }
        if (this.f1033app == null) {
            throw new IllegalArgumentException("必须实现App的提供者(Provider)");
        }
    }

    private final void initConfig() {
        IEnvConfig iEnvConfig = (IEnvConfig) tryToCreateClazz(EnvConfig.CONFIG_CLASS);
        if (iEnvConfig == null) {
            return;
        }
        JSONObject configs = iEnvConfig.getConfigs();
        initAppModule(configs);
        initViewsModule(configs);
        initTaskModule(configs);
        initPrefsModule(configs);
        initSourceModule(configs);
        initDesignTokenModule(configs);
        initNetModule(configs);
        initFeaturesModule(configs);
        initMonitorModule(configs);
    }

    private final void initDesignTokenModule(JSONObject jSONObject) {
        Object obj = jSONObject.get(EnvConfig.CONFIG_MODULE_DESIGN_TOKEN_KEY);
        String str = obj instanceof String ? (String) obj : null;
        if (str != null) {
            setDesignToken((IProxyDesignToken) tryToCreateClazz(str));
        }
        if (this.designToken == null) {
            Log.INSTANCE.e("[GaiaX]", "IProxyDesignToken 没有实现类");
        }
    }

    private final void initFeaturesModule(JSONObject jSONObject) {
        Object obj = jSONObject.get(EnvConfig.CONFIG_MODULE_FEATURES_KEY);
        String str = obj instanceof String ? (String) obj : null;
        if (str != null) {
            setFeatures((IProxyFeatures) tryToCreateClazz(str));
        }
        if (this.features == null) {
            Log.INSTANCE.e("[GaiaX]", "IProxyFeatures 没有实现类");
        }
    }

    private final void initMonitorModule(JSONObject jSONObject) {
        Object obj = jSONObject.get(EnvConfig.CONFIG_MODULE_MONITOR_KEY);
        String str = obj instanceof String ? (String) obj : null;
        if (str != null) {
            setMonitor((IProxyMonitor) tryToCreateClazz(str));
        }
        if (this.monitor == null) {
            Log.INSTANCE.e("[GaiaX]", "IProxyMonitor 没有实现类");
        }
    }

    private final void initNetModule(JSONObject jSONObject) {
        Object obj = jSONObject.get(EnvConfig.CONFIG_MODULE_NET_KEY);
        String str = obj instanceof String ? (String) obj : null;
        if (str != null) {
            setNet((IProxyNet) tryToCreateClazz(str));
        }
        if (this.f1034net == null) {
            Log.INSTANCE.e("[GaiaX]", "IProxyNet 没有实现类");
        }
    }

    private final void initPrefsModule(JSONObject jSONObject) {
        Object obj = jSONObject.get(EnvConfig.CONFIG_MODULE_PREFS_KEY);
        String str = obj instanceof String ? (String) obj : null;
        if (str != null) {
            setPrefs((IProxyPrefs) tryToCreateClazz(str));
        }
        if (this.prefs == null) {
            Log.INSTANCE.e("[GaiaX]", "IProxyPrefs 没有实现类");
        }
    }

    private final void initSourceModule(JSONObject jSONObject) {
        Object obj = jSONObject.get(EnvConfig.CONFIG_MODULE_SOURCE_CLASS_KEY);
        String str = obj instanceof String ? (String) obj : null;
        if (str != null) {
            setSource((IProxySource) tryToCreateClazz(str));
        }
        if (this.source == null) {
            Log.INSTANCE.e("[GaiaX]", "IProxySource 没有实现类");
        }
    }

    private final void initTaskModule(JSONObject jSONObject) {
        Object obj = jSONObject.get(EnvConfig.CONFIG_MODULE_TASK_KEY);
        String str = obj instanceof String ? (String) obj : null;
        if (str != null) {
            setTask((IProxyTask) tryToCreateClazz(str));
        }
        if (this.task == null) {
            Log.INSTANCE.e("[GaiaX]", "IProxyTask 没有实现类");
        }
    }

    private final void initViewsModule(JSONObject jSONObject) {
        Object obj = jSONObject.get(EnvConfig.CONFIG_MODULE_VIEWS_KEY);
        String str = obj instanceof String ? (String) obj : null;
        if (str != null) {
            setViews((IProxyViews) tryToCreateClazz(str));
        }
        if (this.views == null) {
            throw new IllegalArgumentException("必须实现Views的提供者(Provider)");
        }
    }

    private final <T> T tryToCreateClazz(String str) {
        Log log = Log.INSTANCE;
        if (log.isLaunchLog()) {
            log.d("[GaiaX]", b41.r("GaiaX初始化逻辑 - 配置 = ", str));
        }
        if (str != null) {
            try {
                return (T) Class.forName(str, true, GaiaXProxy.class.getClassLoader()).newInstance();
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
        return null;
    }

    @Nullable
    public final IProxyApp getApp() {
        return this.f1033app;
    }

    @Nullable
    public final IProxyDesignToken getDesignToken() {
        return this.designToken;
    }

    @Nullable
    public final IProxyFeatures getFeatures() {
        return this.features;
    }

    @Nullable
    public final IProxyMonitor getMonitor() {
        return this.monitor;
    }

    @Nullable
    public final IProxyNet getNet() {
        return this.f1034net;
    }

    @Nullable
    public final IProxyPrefs getPrefs() {
        return this.prefs;
    }

    @Nullable
    public final IProxySource getSource() {
        return this.source;
    }

    @Nullable
    public final IProxyTask getTask() {
        return this.task;
    }

    @Nullable
    public final IProxyViews getViews() {
        return this.views;
    }

    public final void initModules() {
        IProxyApp iProxyApp = this.f1033app;
        if (iProxyApp != null) {
            iProxyApp.appInit();
        }
        IProxyPrefs iProxyPrefs = this.prefs;
        if (iProxyPrefs != null) {
            iProxyPrefs.prefsInit();
        }
        IProxySource iProxySource = this.source;
        if (iProxySource != null) {
            iProxySource.sourceInit();
        }
        IProxyDesignToken iProxyDesignToken = this.designToken;
        if (iProxyDesignToken != null) {
            iProxyDesignToken.designTokenInit();
        }
        IProxyFeatures iProxyFeatures = this.features;
        if (iProxyFeatures != null) {
            iProxyFeatures.featuresInit();
        }
        IProxyMonitor iProxyMonitor = this.monitor;
        if (iProxyMonitor == null) {
            return;
        }
        iProxyMonitor.monitorInit();
    }

    public final void setApp(@Nullable IProxyApp iProxyApp) {
        this.f1033app = iProxyApp;
    }

    public final void setDesignToken(@Nullable IProxyDesignToken iProxyDesignToken) {
        this.designToken = iProxyDesignToken;
    }

    public final void setFeatures(@Nullable IProxyFeatures iProxyFeatures) {
        this.features = iProxyFeatures;
    }

    public final void setMonitor(@Nullable IProxyMonitor iProxyMonitor) {
        this.monitor = iProxyMonitor;
    }

    public final void setNet(@Nullable IProxyNet iProxyNet) {
        this.f1034net = iProxyNet;
    }

    public final void setPrefs(@Nullable IProxyPrefs iProxyPrefs) {
        this.prefs = iProxyPrefs;
    }

    public final void setSource(@Nullable IProxySource iProxySource) {
        this.source = iProxySource;
    }

    public final void setTask(@Nullable IProxyTask iProxyTask) {
        this.task = iProxyTask;
    }

    public final void setViews(@Nullable IProxyViews iProxyViews) {
        this.views = iProxyViews;
    }
}
