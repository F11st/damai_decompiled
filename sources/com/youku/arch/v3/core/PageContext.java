package com.youku.arch.v3.core;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.os.Looper;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.IContainer;
import com.youku.arch.v3.adapter.ViewTypeSupport;
import com.youku.arch.v3.creator.ComponentCreatorManager;
import com.youku.arch.v3.event.ArchExceptionEvent;
import com.youku.arch.v3.event.Subject;
import com.youku.arch.v3.page.GenericFragment;
import com.youku.arch.v3.style.StyleManager;
import com.youku.arch.v3.util.LogUtil;
import com.youku.kubus.EventBus;
import com.youku.kubus.EventBusBuilder;
import com.youku.middlewareservice.provider.info.AppInfoProviderProxy;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.e;
import kotlinx.coroutines.g;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.bj2;
import tb.d61;
import tb.da0;
import tb.k50;
import tb.ro;
import tb.wt2;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000¤\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u007f2\u00020\u00012\u00020\u0002:\u0001\u007fB\t\b\u0016¢\u0006\u0004\b}\u0010~B\u0013\b\u0016\u0012\b\u0010)\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b}\u0010.J\u001c\u0010\u0007\u001a\u00020\u0006\"\u0004\b\u0000\u0010\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016J\u001c\u0010\b\u001a\u00020\u0006\"\u0004\b\u0000\u0010\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016J\u001c\u0010\t\u001a\u00020\u0006\"\u0004\b\u0000\u0010\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016J\u001c\u0010\n\u001a\u00020\u0006\"\u0004\b\u0000\u0010\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016J\b\u0010\u000b\u001a\u00020\u0006H\u0016R$\u0010\r\u001a\u0004\u0018\u00010\f8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R$\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R$\u0010\u001b\u001a\u0004\u0018\u00010\u001a8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R*\u0010#\u001a\n\u0012\u0004\u0012\u00020\"\u0018\u00010!8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R$\u0010)\u001a\u0004\u0018\u00010\u00028\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R$\u00100\u001a\u0004\u0018\u00010/8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b0\u00101\u001a\u0004\b2\u00103\"\u0004\b4\u00105R$\u00107\u001a\u0004\u0018\u0001068\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b7\u00108\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R$\u0010>\u001a\u0004\u0018\u00010=8V@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b>\u0010?\u001a\u0004\b@\u0010A\"\u0004\bB\u0010CR$\u0010E\u001a\u0004\u0018\u00010D8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\bE\u0010F\u001a\u0004\bG\u0010H\"\u0004\bI\u0010JR$\u0010L\u001a\u0004\u0018\u00010K8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\bL\u0010M\u001a\u0004\bN\u0010O\"\u0004\bP\u0010QR2\u0010T\u001a\u0012\u0012\u0004\u0012\u00020D\u0012\u0006\u0012\u0004\u0018\u00010S\u0018\u00010R8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\bT\u0010U\u001a\u0004\bV\u0010W\"\u0004\bX\u0010YR$\u0010[\u001a\u0004\u0018\u00010Z8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b[\u0010\\\u001a\u0004\b]\u0010^\"\u0004\b_\u0010`R$\u0010b\u001a\u0004\u0018\u00010a8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\bb\u0010c\u001a\u0004\bd\u0010e\"\u0004\bf\u0010gR$\u0010i\u001a\u0004\u0018\u00010h8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\bi\u0010j\u001a\u0004\bk\u0010l\"\u0004\bm\u0010nR$\u0010p\u001a\u0004\u0018\u00010o8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\bp\u0010q\u001a\u0004\br\u0010s\"\u0004\bt\u0010uR\u0016\u0010w\u001a\u00020v8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bw\u0010xR\u0016\u0010z\u001a\u00020y8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bz\u0010{R\u0016\u0010|\u001a\u00020y8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b|\u0010{¨\u0006\u0080\u0001"}, d2 = {"Lcom/youku/arch/v3/core/PageContext;", "Lcom/youku/arch/v3/core/ContextWrapper;", "Lcom/youku/arch/v3/core/IContext;", "T", "Lkotlin/Function0;", "action", "Ltb/wt2;", "runOnUIThreadLocked", "runOnUIThread", "runOnLoaderThreadLocked", "runOnLoaderThread", "release", "Landroid/app/Application;", "application", "Landroid/app/Application;", "getApplication", "()Landroid/app/Application;", "setApplication", "(Landroid/app/Application;)V", "Landroid/app/Activity;", "activity", "Landroid/app/Activity;", "getActivity", "()Landroid/app/Activity;", "setActivity", "(Landroid/app/Activity;)V", "Lcom/youku/arch/v3/page/GenericFragment;", Subject.FRAGMENT, "Lcom/youku/arch/v3/page/GenericFragment;", "getFragment", "()Lcom/youku/arch/v3/page/GenericFragment;", "setFragment", "(Lcom/youku/arch/v3/page/GenericFragment;)V", "Lcom/youku/arch/v3/IContainer;", "Lcom/youku/arch/v3/core/ModelValue;", "pageContainer", "Lcom/youku/arch/v3/IContainer;", "getPageContainer", "()Lcom/youku/arch/v3/IContainer;", "setPageContainer", "(Lcom/youku/arch/v3/IContainer;)V", "baseContext", "Lcom/youku/arch/v3/core/IContext;", "getBaseContext", "()Lcom/youku/arch/v3/core/IContext;", "setBaseContext", "(Lcom/youku/arch/v3/core/IContext;)V", "Lcom/youku/arch/v3/core/ConfigManager;", "configManager", "Lcom/youku/arch/v3/core/ConfigManager;", "getConfigManager", "()Lcom/youku/arch/v3/core/ConfigManager;", "setConfigManager", "(Lcom/youku/arch/v3/core/ConfigManager;)V", "Lcom/youku/arch/v3/creator/ComponentCreatorManager;", "componentCreatorManager", "Lcom/youku/arch/v3/creator/ComponentCreatorManager;", "getComponentCreatorManager", "()Lcom/youku/arch/v3/creator/ComponentCreatorManager;", "setComponentCreatorManager", "(Lcom/youku/arch/v3/creator/ComponentCreatorManager;)V", "Lcom/youku/arch/v3/adapter/ViewTypeSupport;", "viewTypeSupport", "Lcom/youku/arch/v3/adapter/ViewTypeSupport;", "getViewTypeSupport", "()Lcom/youku/arch/v3/adapter/ViewTypeSupport;", "setViewTypeSupport", "(Lcom/youku/arch/v3/adapter/ViewTypeSupport;)V", "", "pageName", "Ljava/lang/String;", "getPageName", "()Ljava/lang/String;", "setPageName", "(Ljava/lang/String;)V", "Landroid/os/Bundle;", "bundle", "Landroid/os/Bundle;", "getBundle", "()Landroid/os/Bundle;", "setBundle", "(Landroid/os/Bundle;)V", "Ljava/util/concurrent/ConcurrentMap;", "", "concurrentMap", "Ljava/util/concurrent/ConcurrentMap;", "getConcurrentMap", "()Ljava/util/concurrent/ConcurrentMap;", "setConcurrentMap", "(Ljava/util/concurrent/ConcurrentMap;)V", "Lcom/youku/kubus/EventBus;", "eventBus", "Lcom/youku/kubus/EventBus;", "getEventBus", "()Lcom/youku/kubus/EventBus;", "setEventBus", "(Lcom/youku/kubus/EventBus;)V", "Lcom/youku/arch/v3/core/EventDispatcher;", "eventDispatcher", "Lcom/youku/arch/v3/core/EventDispatcher;", "getEventDispatcher", "()Lcom/youku/arch/v3/core/EventDispatcher;", "setEventDispatcher", "(Lcom/youku/arch/v3/core/EventDispatcher;)V", "Lcom/youku/arch/v3/core/ActivityValue;", "activityValue", "Lcom/youku/arch/v3/core/ActivityValue;", "getActivityValue", "()Lcom/youku/arch/v3/core/ActivityValue;", "setActivityValue", "(Lcom/youku/arch/v3/core/ActivityValue;)V", "Lcom/youku/arch/v3/style/StyleManager;", "styleManager", "Lcom/youku/arch/v3/style/StyleManager;", "getStyleManager", "()Lcom/youku/arch/v3/style/StyleManager;", "setStyleManager", "(Lcom/youku/arch/v3/style/StyleManager;)V", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "coroutineExceptionHandler", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "Lkotlinx/coroutines/CoroutineScope;", "loaderCoroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "renderCoroutineScope", "<init>", "()V", "Companion", "konearch_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class PageContext extends ContextWrapper {
    private static transient /* synthetic */ IpChange $ipChange = null;
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private static final String TAG = "OneArch.PageContext";
    @Nullable
    private Activity activity;
    @Nullable
    private ActivityValue activityValue;
    @Nullable
    private Application application;
    @Nullable
    private IContext baseContext;
    @Nullable
    private Bundle bundle;
    @Nullable
    private ComponentCreatorManager componentCreatorManager;
    @Nullable
    private ConcurrentMap<String, Object> concurrentMap;
    @Nullable
    private ConfigManager configManager;
    @NotNull
    private final CoroutineExceptionHandler coroutineExceptionHandler;
    @Nullable
    private EventBus eventBus;
    @Nullable
    private EventDispatcher eventDispatcher;
    @Nullable
    private GenericFragment fragment;
    @NotNull
    private final CoroutineScope loaderCoroutineScope;
    @Nullable
    private IContainer<ModelValue> pageContainer;
    @Nullable
    private String pageName;
    @NotNull
    private final CoroutineScope renderCoroutineScope;
    @Nullable
    private StyleManager styleManager;
    @Nullable
    private ViewTypeSupport viewTypeSupport;

    /* compiled from: Taobao */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/youku/arch/v3/core/PageContext$Companion;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "konearch_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(k50 k50Var) {
            this();
        }
    }

    public PageContext() {
        this(null);
    }

    @Override // com.youku.arch.v3.core.ContextWrapper, com.youku.arch.v3.core.IContext
    @Nullable
    public Activity getActivity() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1117284555") ? (Activity) ipChange.ipc$dispatch("-1117284555", new Object[]{this}) : this.activity;
    }

    @Override // com.youku.arch.v3.core.ContextWrapper, com.youku.arch.v3.core.IContext
    @Nullable
    public ActivityValue getActivityValue() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1550738560") ? (ActivityValue) ipChange.ipc$dispatch("1550738560", new Object[]{this}) : this.activityValue;
    }

    @Override // com.youku.arch.v3.core.ContextWrapper, com.youku.arch.v3.core.IContext
    @Nullable
    public Application getApplication() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1763067271") ? (Application) ipChange.ipc$dispatch("1763067271", new Object[]{this}) : this.application;
    }

    @Override // com.youku.arch.v3.core.ContextWrapper, com.youku.arch.v3.core.IContext
    @Nullable
    public IContext getBaseContext() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1160520398") ? (IContext) ipChange.ipc$dispatch("-1160520398", new Object[]{this}) : this.baseContext;
    }

    @Override // com.youku.arch.v3.core.ContextWrapper, com.youku.arch.v3.core.IContext
    @Nullable
    public Bundle getBundle() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1850963196") ? (Bundle) ipChange.ipc$dispatch("-1850963196", new Object[]{this}) : this.bundle;
    }

    @Override // com.youku.arch.v3.core.ContextWrapper, com.youku.arch.v3.core.IContext
    @Nullable
    public ComponentCreatorManager getComponentCreatorManager() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "898338765") ? (ComponentCreatorManager) ipChange.ipc$dispatch("898338765", new Object[]{this}) : this.componentCreatorManager;
    }

    @Override // com.youku.arch.v3.core.ContextWrapper, com.youku.arch.v3.core.IContext
    @Nullable
    public ConcurrentMap<String, Object> getConcurrentMap() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1062003371") ? (ConcurrentMap) ipChange.ipc$dispatch("-1062003371", new Object[]{this}) : this.concurrentMap;
    }

    @Override // com.youku.arch.v3.core.ContextWrapper, com.youku.arch.v3.core.IContext
    @Nullable
    public ConfigManager getConfigManager() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "64279712") ? (ConfigManager) ipChange.ipc$dispatch("64279712", new Object[]{this}) : this.configManager;
    }

    @Override // com.youku.arch.v3.core.ContextWrapper, com.youku.arch.v3.core.IContext
    @Nullable
    public EventBus getEventBus() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1396757462") ? (EventBus) ipChange.ipc$dispatch("1396757462", new Object[]{this}) : this.eventBus;
    }

    @Override // com.youku.arch.v3.core.ContextWrapper, com.youku.arch.v3.core.IContext
    @Nullable
    public EventDispatcher getEventDispatcher() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1102020448") ? (EventDispatcher) ipChange.ipc$dispatch("-1102020448", new Object[]{this}) : this.eventDispatcher;
    }

    @Override // com.youku.arch.v3.core.ContextWrapper, com.youku.arch.v3.core.IContext
    @Nullable
    public GenericFragment getFragment() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-787058113") ? (GenericFragment) ipChange.ipc$dispatch("-787058113", new Object[]{this}) : this.fragment;
    }

    @Override // com.youku.arch.v3.core.ContextWrapper, com.youku.arch.v3.core.IContext
    @Nullable
    public IContainer<ModelValue> getPageContainer() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1267122646") ? (IContainer) ipChange.ipc$dispatch("-1267122646", new Object[]{this}) : this.pageContainer;
    }

    @Override // com.youku.arch.v3.core.ContextWrapper, com.youku.arch.v3.core.IContext
    @Nullable
    public String getPageName() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1024752344") ? (String) ipChange.ipc$dispatch("1024752344", new Object[]{this}) : this.pageName;
    }

    @Override // com.youku.arch.v3.core.ContextWrapper, com.youku.arch.v3.core.IContext
    @Nullable
    public StyleManager getStyleManager() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1385862520") ? (StyleManager) ipChange.ipc$dispatch("1385862520", new Object[]{this}) : this.styleManager;
    }

    @Override // com.youku.arch.v3.core.ContextWrapper, com.youku.arch.v3.core.IContext
    @Nullable
    public ViewTypeSupport getViewTypeSupport() {
        ConfigManager configManager;
        String pathConfig;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2145033370")) {
            return (ViewTypeSupport) ipChange.ipc$dispatch("-2145033370", new Object[]{this});
        }
        if (this.viewTypeSupport == null && (configManager = getConfigManager()) != null && (pathConfig = configManager.getPathConfig(ConfigManager.COMPONENT_CONFIG_FILE)) != null) {
            this.viewTypeSupport = ViewTypeSupport.Companion.getInstance(pathConfig);
        }
        return this.viewTypeSupport;
    }

    @Override // com.youku.arch.v3.core.ContextWrapper, com.youku.arch.v3.core.IContext
    public void release() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-982360047")) {
            ipChange.ipc$dispatch("-982360047", new Object[]{this});
            return;
        }
        ro.c(this.loaderCoroutineScope, null, 1, null);
        ro.c(this.renderCoroutineScope, null, 1, null);
        if (AppInfoProviderProxy.isDebuggable()) {
            Object[] objArr = new Object[1];
            StringBuilder sb = new StringBuilder();
            sb.append("page context [");
            EventBus eventBus = getEventBus();
            sb.append((Object) (eventBus != null ? eventBus.getChannelId() : null));
            sb.append("] released");
            objArr[0] = sb.toString();
            LogUtil.v(TAG, objArr);
        }
    }

    @Override // com.youku.arch.v3.core.ContextWrapper, com.youku.arch.v3.core.IContext
    public <T> void runOnLoaderThread(@NotNull Function0<? extends T> function0) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-746113320")) {
            ipChange.ipc$dispatch("-746113320", new Object[]{this, function0});
            return;
        }
        b41.i(function0, "action");
        g.b(this.loaderCoroutineScope, null, null, new PageContext$runOnLoaderThread$1(function0, null), 3, null);
    }

    @Override // com.youku.arch.v3.core.ContextWrapper, com.youku.arch.v3.core.IContext
    public <T> void runOnLoaderThreadLocked(@NotNull Function0<? extends T> function0) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1322415506")) {
            ipChange.ipc$dispatch("-1322415506", new Object[]{this, function0});
            return;
        }
        b41.i(function0, "action");
        if (b41.d(Looper.myLooper(), Looper.getMainLooper())) {
            runOnLoaderThread(function0);
        } else {
            function0.invoke();
        }
    }

    @Override // com.youku.arch.v3.core.ContextWrapper, com.youku.arch.v3.core.IContext
    public <T> void runOnUIThread(@NotNull Function0<? extends T> function0) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-745230825")) {
            ipChange.ipc$dispatch("-745230825", new Object[]{this, function0});
            return;
        }
        b41.i(function0, "action");
        if (d61.i(this.renderCoroutineScope.getCoroutineContext())) {
            g.b(this.renderCoroutineScope, null, null, new PageContext$runOnUIThread$1(function0, null), 3, null);
            return;
        }
        EventDispatcher eventDispatcher = getEventDispatcher();
        if (eventDispatcher == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("errorMsg", "coroutineContext not active");
        wt2 wt2Var = wt2.INSTANCE;
        eventDispatcher.dispatchEvent(ArchExceptionEvent.COROUTINE_RUN_FAILED, hashMap);
    }

    @Override // com.youku.arch.v3.core.ContextWrapper, com.youku.arch.v3.core.IContext
    public <T> void runOnUIThreadLocked(@NotNull Function0<? extends T> function0) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1112648083")) {
            ipChange.ipc$dispatch("-1112648083", new Object[]{this, function0});
            return;
        }
        b41.i(function0, "action");
        if (b41.d(Looper.myLooper(), Looper.getMainLooper())) {
            function0.invoke();
        } else if (d61.i(this.renderCoroutineScope.getCoroutineContext())) {
            e.c(this.renderCoroutineScope.getCoroutineContext(), new PageContext$runOnUIThreadLocked$1(function0, null));
        } else {
            EventDispatcher eventDispatcher = getEventDispatcher();
            if (eventDispatcher == null) {
                return;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("errorMsg", "coroutineContext not active");
            wt2 wt2Var = wt2.INSTANCE;
            eventDispatcher.dispatchEvent(ArchExceptionEvent.COROUTINE_RUN_FAILED, hashMap);
        }
    }

    @Override // com.youku.arch.v3.core.ContextWrapper, com.youku.arch.v3.core.IContext
    public void setActivity(@Nullable Activity activity) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1578561753")) {
            ipChange.ipc$dispatch("1578561753", new Object[]{this, activity});
        } else {
            this.activity = activity;
        }
    }

    @Override // com.youku.arch.v3.core.ContextWrapper, com.youku.arch.v3.core.IContext
    public void setActivityValue(@Nullable ActivityValue activityValue) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "871375426")) {
            ipChange.ipc$dispatch("871375426", new Object[]{this, activityValue});
        } else {
            this.activityValue = activityValue;
        }
    }

    @Override // com.youku.arch.v3.core.ContextWrapper, com.youku.arch.v3.core.IContext
    public void setApplication(@Nullable Application application) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1561938331")) {
            ipChange.ipc$dispatch("1561938331", new Object[]{this, application});
        } else {
            this.application = application;
        }
    }

    @Override // com.youku.arch.v3.core.ContextWrapper, com.youku.arch.v3.core.IContext
    public void setBaseContext(@Nullable IContext iContext) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "83995746")) {
            ipChange.ipc$dispatch("83995746", new Object[]{this, iContext});
        } else {
            this.baseContext = iContext;
        }
    }

    @Override // com.youku.arch.v3.core.ContextWrapper, com.youku.arch.v3.core.IContext
    public void setBundle(@Nullable Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2023202400")) {
            ipChange.ipc$dispatch("-2023202400", new Object[]{this, bundle});
        } else {
            this.bundle = bundle;
        }
    }

    @Override // com.youku.arch.v3.core.ContextWrapper, com.youku.arch.v3.core.IContext
    public void setComponentCreatorManager(@Nullable ComponentCreatorManager componentCreatorManager) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-43977283")) {
            ipChange.ipc$dispatch("-43977283", new Object[]{this, componentCreatorManager});
        } else {
            this.componentCreatorManager = componentCreatorManager;
        }
    }

    @Override // com.youku.arch.v3.core.ContextWrapper, com.youku.arch.v3.core.IContext
    public void setConcurrentMap(@Nullable ConcurrentMap<String, Object> concurrentMap) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "284730289")) {
            ipChange.ipc$dispatch("284730289", new Object[]{this, concurrentMap});
        } else {
            this.concurrentMap = concurrentMap;
        }
    }

    @Override // com.youku.arch.v3.core.ContextWrapper, com.youku.arch.v3.core.IContext
    public void setConfigManager(@Nullable ConfigManager configManager) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1630307600")) {
            ipChange.ipc$dispatch("-1630307600", new Object[]{this, configManager});
        } else {
            this.configManager = configManager;
        }
    }

    @Override // com.youku.arch.v3.core.ContextWrapper, com.youku.arch.v3.core.IContext
    public void setEventBus(@Nullable EventBus eventBus) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "706712172")) {
            ipChange.ipc$dispatch("706712172", new Object[]{this, eventBus});
        } else {
            this.eventBus = eventBus;
        }
    }

    @Override // com.youku.arch.v3.core.ContextWrapper, com.youku.arch.v3.core.IContext
    public void setEventDispatcher(@Nullable EventDispatcher eventDispatcher) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-367087804")) {
            ipChange.ipc$dispatch("-367087804", new Object[]{this, eventDispatcher});
        } else {
            this.eventDispatcher = eventDispatcher;
        }
    }

    @Override // com.youku.arch.v3.core.ContextWrapper, com.youku.arch.v3.core.IContext
    public void setFragment(@Nullable GenericFragment genericFragment) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "485767681")) {
            ipChange.ipc$dispatch("485767681", new Object[]{this, genericFragment});
        } else {
            this.fragment = genericFragment;
        }
    }

    @Override // com.youku.arch.v3.core.ContextWrapper, com.youku.arch.v3.core.IContext
    public void setPageContainer(@Nullable IContainer<ModelValue> iContainer) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-446075316")) {
            ipChange.ipc$dispatch("-446075316", new Object[]{this, iContainer});
        } else {
            this.pageContainer = iContainer;
        }
    }

    @Override // com.youku.arch.v3.core.ContextWrapper, com.youku.arch.v3.core.IContext
    public void setPageName(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1820223750")) {
            ipChange.ipc$dispatch("1820223750", new Object[]{this, str});
        } else {
            this.pageName = str;
        }
    }

    @Override // com.youku.arch.v3.core.ContextWrapper, com.youku.arch.v3.core.IContext
    public void setStyleManager(@Nullable StyleManager styleManager) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1385736418")) {
            ipChange.ipc$dispatch("1385736418", new Object[]{this, styleManager});
        } else {
            this.styleManager = styleManager;
        }
    }

    @Override // com.youku.arch.v3.core.ContextWrapper, com.youku.arch.v3.core.IContext
    public void setViewTypeSupport(@Nullable ViewTypeSupport viewTypeSupport) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-719244038")) {
            ipChange.ipc$dispatch("-719244038", new Object[]{this, viewTypeSupport});
        } else {
            this.viewTypeSupport = viewTypeSupport;
        }
    }

    public PageContext(@Nullable IContext iContext) {
        super(iContext);
        PageContext$special$$inlined$CoroutineExceptionHandler$1 pageContext$special$$inlined$CoroutineExceptionHandler$1 = new PageContext$special$$inlined$CoroutineExceptionHandler$1(CoroutineExceptionHandler.Key);
        this.coroutineExceptionHandler = pageContext$special$$inlined$CoroutineExceptionHandler$1;
        this.loaderCoroutineScope = ro.a(da0.a().plus(bj2.b(null, 1, null)).plus(pageContext$special$$inlined$CoroutineExceptionHandler$1));
        this.renderCoroutineScope = ro.a(da0.c().plus(bj2.b(null, 1, null)).plus(pageContext$special$$inlined$CoroutineExceptionHandler$1));
        setEventBus(new EventBusBuilder().logNoSubscriberMessages(false).sendNoSubscriberEvent(false).loggable(false).name("page").build());
        setBundle(new Bundle());
        setConcurrentMap(new ConcurrentHashMap());
        setEventDispatcher(new EventDispatcher(this));
        setComponentCreatorManager(new ComponentCreatorManager());
        if (AppInfoProviderProxy.isDebuggable()) {
            Object[] objArr = new Object[1];
            StringBuilder sb = new StringBuilder();
            sb.append("page context [");
            EventBus eventBus = getEventBus();
            sb.append((Object) (eventBus != null ? eventBus.getChannelId() : null));
            sb.append("] created");
            objArr[0] = sb.toString();
            LogUtil.v(TAG, objArr);
        }
    }
}
