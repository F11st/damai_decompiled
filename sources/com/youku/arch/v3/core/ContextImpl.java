package com.youku.arch.v3.core;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.IContainer;
import com.youku.arch.v3.adapter.ViewTypeSupport;
import com.youku.arch.v3.creator.ComponentCreatorManager;
import com.youku.arch.v3.event.Subject;
import com.youku.arch.v3.page.GenericFragment;
import com.youku.arch.v3.style.StyleManager;
import com.youku.arch.v3.util.LogUtil;
import com.youku.kubus.EventBus;
import com.youku.kubus.EventBusBuilder;
import com.youku.middlewareservice.provider.info.AppInfoProviderProxy;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.k50;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u0000 s2\u00020\u0001:\u0001sB\u0007¢\u0006\u0004\bq\u0010rJ\u001c\u0010\u0006\u001a\u00020\u0005\"\u0004\b\u0000\u0010\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0016J\u001c\u0010\u0007\u001a\u00020\u0005\"\u0004\b\u0000\u0010\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0016J\u001c\u0010\b\u001a\u00020\u0005\"\u0004\b\u0000\u0010\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0016J\u001c\u0010\t\u001a\u00020\u0005\"\u0004\b\u0000\u0010\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0016J\b\u0010\n\u001a\u00020\u0005H\u0016R$\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R$\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R$\u0010\u001a\u001a\u0004\u0018\u00010\u00198\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR$\u0010!\u001a\u0004\u0018\u00010 8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R$\u0010(\u001a\u0004\u0018\u00010'8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R$\u0010/\u001a\u0004\u0018\u00010.8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b/\u00100\u001a\u0004\b1\u00102\"\u0004\b3\u00104R$\u00106\u001a\u0004\u0018\u0001058\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b6\u00107\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R$\u0010=\u001a\u0004\u0018\u00010<8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b=\u0010>\u001a\u0004\b?\u0010@\"\u0004\bA\u0010BR$\u0010D\u001a\u0004\u0018\u00010C8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\bD\u0010E\u001a\u0004\bF\u0010G\"\u0004\bH\u0010IR2\u0010L\u001a\u0012\u0012\u0004\u0012\u00020.\u0012\u0006\u0012\u0004\u0018\u00010K\u0018\u00010J8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\bL\u0010M\u001a\u0004\bN\u0010O\"\u0004\bP\u0010QR(\u0010X\u001a\u0004\u0018\u00010R2\b\u0010S\u001a\u0004\u0018\u00010R8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\bT\u0010U\"\u0004\bV\u0010WR4\u0010_\u001a\n\u0012\u0004\u0012\u00020Z\u0018\u00010Y2\u000e\u0010S\u001a\n\u0012\u0004\u0012\u00020Z\u0018\u00010Y8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b[\u0010\\\"\u0004\b]\u0010^R(\u0010d\u001a\u0004\u0018\u00010\u00012\b\u0010S\u001a\u0004\u0018\u00010\u00018V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b`\u0010a\"\u0004\bb\u0010cR(\u0010j\u001a\u0004\u0018\u00010e2\b\u0010S\u001a\u0004\u0018\u00010e8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\bf\u0010g\"\u0004\bh\u0010iR(\u0010p\u001a\u0004\u0018\u00010k2\b\u0010S\u001a\u0004\u0018\u00010k8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\bl\u0010m\"\u0004\bn\u0010o¨\u0006t"}, d2 = {"Lcom/youku/arch/v3/core/ContextImpl;", "Lcom/youku/arch/v3/core/IContext;", "T", "Lkotlin/Function0;", "action", "Ltb/wt2;", "runOnUIThreadLocked", "runOnUIThread", "runOnLoaderThreadLocked", "runOnLoaderThread", "release", "Landroid/app/Application;", "application", "Landroid/app/Application;", "getApplication", "()Landroid/app/Application;", "setApplication", "(Landroid/app/Application;)V", "Landroid/app/Activity;", "activity", "Landroid/app/Activity;", "getActivity", "()Landroid/app/Activity;", "setActivity", "(Landroid/app/Activity;)V", "Lcom/youku/kubus/EventBus;", "eventBus", "Lcom/youku/kubus/EventBus;", "getEventBus", "()Lcom/youku/kubus/EventBus;", "setEventBus", "(Lcom/youku/kubus/EventBus;)V", "Lcom/youku/arch/v3/core/ConfigManager;", "configManager", "Lcom/youku/arch/v3/core/ConfigManager;", "getConfigManager", "()Lcom/youku/arch/v3/core/ConfigManager;", "setConfigManager", "(Lcom/youku/arch/v3/core/ConfigManager;)V", "Lcom/youku/arch/v3/creator/ComponentCreatorManager;", "componentCreatorManager", "Lcom/youku/arch/v3/creator/ComponentCreatorManager;", "getComponentCreatorManager", "()Lcom/youku/arch/v3/creator/ComponentCreatorManager;", "setComponentCreatorManager", "(Lcom/youku/arch/v3/creator/ComponentCreatorManager;)V", "", "pageName", "Ljava/lang/String;", "getPageName", "()Ljava/lang/String;", "setPageName", "(Ljava/lang/String;)V", "Lcom/youku/arch/v3/core/ActivityValue;", "activityValue", "Lcom/youku/arch/v3/core/ActivityValue;", "getActivityValue", "()Lcom/youku/arch/v3/core/ActivityValue;", "setActivityValue", "(Lcom/youku/arch/v3/core/ActivityValue;)V", "Lcom/youku/arch/v3/style/StyleManager;", "styleManager", "Lcom/youku/arch/v3/style/StyleManager;", "getStyleManager", "()Lcom/youku/arch/v3/style/StyleManager;", "setStyleManager", "(Lcom/youku/arch/v3/style/StyleManager;)V", "Landroid/os/Bundle;", "bundle", "Landroid/os/Bundle;", "getBundle", "()Landroid/os/Bundle;", "setBundle", "(Landroid/os/Bundle;)V", "Ljava/util/concurrent/ConcurrentMap;", "", "concurrentMap", "Ljava/util/concurrent/ConcurrentMap;", "getConcurrentMap", "()Ljava/util/concurrent/ConcurrentMap;", "setConcurrentMap", "(Ljava/util/concurrent/ConcurrentMap;)V", "Lcom/youku/arch/v3/page/GenericFragment;", "value", "getFragment", "()Lcom/youku/arch/v3/page/GenericFragment;", "setFragment", "(Lcom/youku/arch/v3/page/GenericFragment;)V", Subject.FRAGMENT, "Lcom/youku/arch/v3/IContainer;", "Lcom/youku/arch/v3/core/ModelValue;", "getPageContainer", "()Lcom/youku/arch/v3/IContainer;", "setPageContainer", "(Lcom/youku/arch/v3/IContainer;)V", "pageContainer", "getBaseContext", "()Lcom/youku/arch/v3/core/IContext;", "setBaseContext", "(Lcom/youku/arch/v3/core/IContext;)V", "baseContext", "Lcom/youku/arch/v3/adapter/ViewTypeSupport;", "getViewTypeSupport", "()Lcom/youku/arch/v3/adapter/ViewTypeSupport;", "setViewTypeSupport", "(Lcom/youku/arch/v3/adapter/ViewTypeSupport;)V", "viewTypeSupport", "Lcom/youku/arch/v3/core/EventDispatcher;", "getEventDispatcher", "()Lcom/youku/arch/v3/core/EventDispatcher;", "setEventDispatcher", "(Lcom/youku/arch/v3/core/EventDispatcher;)V", "eventDispatcher", "<init>", "()V", "Companion", "konearch_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class ContextImpl implements IContext {
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
    private Bundle bundle;
    @Nullable
    private ComponentCreatorManager componentCreatorManager;
    @Nullable
    private ConcurrentMap<String, Object> concurrentMap;
    @Nullable
    private ConfigManager configManager;
    @Nullable
    private EventBus eventBus;
    @Nullable
    private String pageName;
    @Nullable
    private StyleManager styleManager;

    public ContextImpl() {
        setApplication(AppInfoProviderProxy.getApplication());
        setBundle(new Bundle());
        setConcurrentMap(new ConcurrentHashMap());
    }

    @Override // com.youku.arch.v3.core.IContext
    @Nullable
    public Activity getActivity() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-367770556") ? (Activity) ipChange.ipc$dispatch("-367770556", new Object[]{this}) : this.activity;
    }

    @Override // com.youku.arch.v3.core.IContext
    @Nullable
    public ActivityValue getActivityValue() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1412810449") ? (ActivityValue) ipChange.ipc$dispatch("1412810449", new Object[]{this}) : this.activityValue;
    }

    @Override // com.youku.arch.v3.core.IContext
    @Nullable
    public Application getApplication() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "340437846") ? (Application) ipChange.ipc$dispatch("340437846", new Object[]{this}) : this.application;
    }

    @Override // com.youku.arch.v3.core.IContext
    @Nullable
    public IContext getBaseContext() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-718732287")) {
            return (IContext) ipChange.ipc$dispatch("-718732287", new Object[]{this});
        }
        throw new UnsupportedOperationException();
    }

    @Override // com.youku.arch.v3.core.IContext
    @Nullable
    public Bundle getBundle() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-966938475") ? (Bundle) ipChange.ipc$dispatch("-966938475", new Object[]{this}) : this.bundle;
    }

    @Override // com.youku.arch.v3.core.IContext
    @Nullable
    public ComponentCreatorManager getComponentCreatorManager() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1022090660") ? (ComponentCreatorManager) ipChange.ipc$dispatch("-1022090660", new Object[]{this}) : this.componentCreatorManager;
    }

    @Override // com.youku.arch.v3.core.IContext
    @Nullable
    public ConcurrentMap<String, Object> getConcurrentMap() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "216063974") ? (ConcurrentMap) ipChange.ipc$dispatch("216063974", new Object[]{this}) : this.concurrentMap;
    }

    @Override // com.youku.arch.v3.core.IContext
    @Nullable
    public ConfigManager getConfigManager() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-73648399") ? (ConfigManager) ipChange.ipc$dispatch("-73648399", new Object[]{this}) : this.configManager;
    }

    @Override // com.youku.arch.v3.core.IContext
    @Nullable
    public EventBus getEventBus() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-794664603") ? (EventBus) ipChange.ipc$dispatch("-794664603", new Object[]{this}) : this.eventBus;
    }

    @Override // com.youku.arch.v3.core.IContext
    @Nullable
    public EventDispatcher getEventDispatcher() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-468954511")) {
            return (EventDispatcher) ipChange.ipc$dispatch("-468954511", new Object[]{this});
        }
        throw new UnsupportedOperationException();
    }

    @Override // com.youku.arch.v3.core.IContext
    @Nullable
    public GenericFragment getFragment() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-607282802")) {
            return (GenericFragment) ipChange.ipc$dispatch("-607282802", new Object[]{this});
        }
        throw new UnsupportedOperationException();
    }

    @Override // com.youku.arch.v3.core.IContext
    @Nullable
    public IContainer<ModelValue> getPageContainer() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1668513413")) {
            return (IContainer) ipChange.ipc$dispatch("-1668513413", new Object[]{this});
        }
        throw new UnsupportedOperationException();
    }

    @Override // com.youku.arch.v3.core.IContext
    @Nullable
    public String getPageName() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1635252377") ? (String) ipChange.ipc$dispatch("-1635252377", new Object[]{this}) : this.pageName;
    }

    @Override // com.youku.arch.v3.core.IContext
    @Nullable
    public StyleManager getStyleManager() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1943722745") ? (StyleManager) ipChange.ipc$dispatch("-1943722745", new Object[]{this}) : this.styleManager;
    }

    @Override // com.youku.arch.v3.core.IContext
    @Nullable
    public ViewTypeSupport getViewTypeSupport() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1679100939")) {
            return (ViewTypeSupport) ipChange.ipc$dispatch("-1679100939", new Object[]{this});
        }
        throw new UnsupportedOperationException();
    }

    @Override // com.youku.arch.v3.core.IContext
    public void release() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1361627102")) {
            ipChange.ipc$dispatch("-1361627102", new Object[]{this});
        } else if (AppInfoProviderProxy.isDebuggable()) {
            Object[] objArr = new Object[1];
            StringBuilder sb = new StringBuilder();
            sb.append("page context [");
            EventBus eventBus = getEventBus();
            sb.append((Object) (eventBus == null ? null : eventBus.getChannelId()));
            sb.append("] released");
            objArr[0] = sb.toString();
            LogUtil.v(TAG, objArr);
        }
    }

    @Override // com.youku.arch.v3.core.IContext
    public <T> void runOnLoaderThread(@NotNull Function0<? extends T> function0) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "783706537")) {
            ipChange.ipc$dispatch("783706537", new Object[]{this, function0});
        } else {
            b41.i(function0, "action");
            throw new UnsupportedOperationException();
        }
    }

    @Override // com.youku.arch.v3.core.IContext
    public <T> void runOnLoaderThreadLocked(@NotNull Function0<? extends T> function0) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-727344001")) {
            ipChange.ipc$dispatch("-727344001", new Object[]{this, function0});
        } else {
            b41.i(function0, "action");
            throw new UnsupportedOperationException();
        }
    }

    @Override // com.youku.arch.v3.core.IContext
    public <T> void runOnUIThread(@NotNull Function0<? extends T> function0) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1146621592")) {
            ipChange.ipc$dispatch("-1146621592", new Object[]{this, function0});
        } else {
            b41.i(function0, "action");
            throw new UnsupportedOperationException();
        }
    }

    @Override // com.youku.arch.v3.core.IContext
    public <T> void runOnUIThreadLocked(@NotNull Function0<? extends T> function0) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "165419262")) {
            ipChange.ipc$dispatch("165419262", new Object[]{this, function0});
        } else {
            b41.i(function0, "action");
            throw new UnsupportedOperationException();
        }
    }

    @Override // com.youku.arch.v3.core.IContext
    public void setActivity(@Nullable Activity activity) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-956308054")) {
            ipChange.ipc$dispatch("-956308054", new Object[]{this, activity});
        } else {
            this.activity = activity;
        }
    }

    @Override // com.youku.arch.v3.core.IContext
    public void setActivityValue(@Nullable ActivityValue activityValue) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "890571281")) {
            ipChange.ipc$dispatch("890571281", new Object[]{this, activityValue});
        } else {
            this.activityValue = activityValue;
        }
    }

    @Override // com.youku.arch.v3.core.IContext
    public void setApplication(@Nullable Application application) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "410099116")) {
            ipChange.ipc$dispatch("410099116", new Object[]{this, application});
        } else {
            this.application = application;
        }
    }

    @Override // com.youku.arch.v3.core.IContext
    public void setBaseContext(@Nullable IContext iContext) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "894525299")) {
            throw new UnsupportedOperationException();
        }
        ipChange.ipc$dispatch("894525299", new Object[]{this, iContext});
    }

    @Override // com.youku.arch.v3.core.IContext
    public void setBundle(@Nullable Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-388239825")) {
            ipChange.ipc$dispatch("-388239825", new Object[]{this, bundle});
        } else {
            this.bundle = bundle;
        }
    }

    @Override // com.youku.arch.v3.core.IContext
    public void setComponentCreatorManager(@Nullable ComponentCreatorManager componentCreatorManager) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "552252686")) {
            ipChange.ipc$dispatch("552252686", new Object[]{this, componentCreatorManager});
        } else {
            this.componentCreatorManager = componentCreatorManager;
        }
    }

    @Override // com.youku.arch.v3.core.IContext
    public void setConcurrentMap(@Nullable ConcurrentMap<String, Object> concurrentMap) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1250112320")) {
            ipChange.ipc$dispatch("1250112320", new Object[]{this, concurrentMap});
        } else {
            this.concurrentMap = concurrentMap;
        }
    }

    @Override // com.youku.arch.v3.core.IContext
    public void setConfigManager(@Nullable ConfigManager configManager) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1611111745")) {
            ipChange.ipc$dispatch("-1611111745", new Object[]{this, configManager});
        } else {
            this.configManager = configManager;
        }
    }

    @Override // com.youku.arch.v3.core.IContext
    public void setEventBus(@Nullable EventBus eventBus) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1492104893")) {
            ipChange.ipc$dispatch("1492104893", new Object[]{this, eventBus});
        } else {
            this.eventBus = eventBus;
        }
    }

    @Override // com.youku.arch.v3.core.IContext
    public void setEventDispatcher(@Nullable EventDispatcher eventDispatcher) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "2078087059")) {
            throw new UnsupportedOperationException();
        }
        ipChange.ipc$dispatch("2078087059", new Object[]{this, eventDispatcher});
    }

    @Override // com.youku.arch.v3.core.IContext
    public void setFragment(@Nullable GenericFragment genericFragment) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1763835026")) {
            throw new UnsupportedOperationException();
        }
        ipChange.ipc$dispatch("1763835026", new Object[]{this, genericFragment});
    }

    @Override // com.youku.arch.v3.core.IContext
    public void setPageContainer(@Nullable IContainer<ModelValue> iContainer) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-4287205")) {
            throw new UnsupportedOperationException();
        }
        ipChange.ipc$dispatch("-4287205", new Object[]{this, iContainer});
    }

    @Override // com.youku.arch.v3.core.IContext
    public void setPageName(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "964456023")) {
            ipChange.ipc$dispatch("964456023", new Object[]{this, str});
        } else {
            this.pageName = str;
        }
    }

    @Override // com.youku.arch.v3.core.IContext
    public void setStyleManager(@Nullable StyleManager styleManager) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1247808307")) {
            ipChange.ipc$dispatch("1247808307", new Object[]{this, styleManager});
        } else {
            this.styleManager = styleManager;
        }
    }

    @Override // com.youku.arch.v3.core.IContext
    public void setViewTypeSupport(@Nullable ViewTypeSupport viewTypeSupport) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "839759435")) {
            throw new UnsupportedOperationException();
        }
        ipChange.ipc$dispatch("839759435", new Object[]{this, viewTypeSupport});
    }

    /* compiled from: Taobao */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0005\u001a\u00020\u0004R\u0016\u0010\u0007\u001a\u00020\u00068\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/youku/arch/v3/core/ContextImpl$Companion;", "", "Lcom/youku/kubus/EventBus;", "eventBus", "Lcom/youku/arch/v3/core/IContext;", "createContainerContext", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "konearch_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes2.dex */
    public static final class Companion {
        private static transient /* synthetic */ IpChange $ipChange;

        private Companion() {
        }

        public /* synthetic */ Companion(k50 k50Var) {
            this();
        }

        @NotNull
        public final IContext createContainerContext(@NotNull EventBus eventBus) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-900828637")) {
                return (IContext) ipChange.ipc$dispatch("-900828637", new Object[]{this, eventBus});
            }
            b41.i(eventBus, "eventBus");
            ContextImpl contextImpl = new ContextImpl();
            contextImpl.setEventBus(eventBus);
            if (AppInfoProviderProxy.isDebuggable()) {
                LogUtil.v(ContextImpl.TAG, "page context [" + ((Object) eventBus.getChannelId()) + "] created");
            }
            return contextImpl;
        }

        @NotNull
        public final IContext createContainerContext() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1567999129")) {
                return (IContext) ipChange.ipc$dispatch("-1567999129", new Object[]{this});
            }
            EventBus build = new EventBusBuilder().loggable(true).name("container").build();
            b41.h(build, "eventBus");
            return createContainerContext(build);
        }
    }
}
