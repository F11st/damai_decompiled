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
import com.youku.kubus.EventBus;
import java.util.concurrent.ConcurrentMap;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0016\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\bl\u0010\u0011J\u0010\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001J\u001c\u0010\b\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u00052\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0016J\u001c\u0010\t\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u00052\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0016J\u001c\u0010\n\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u00052\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0016J\u001c\u0010\u000b\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u00052\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0016J\b\u0010\f\u001a\u00020\u0003H\u0016R$\u0010\u0002\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0002\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R(\u0010\u0018\u001a\u0004\u0018\u00010\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00128V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R(\u0010\u001e\u001a\u0004\u0018\u00010\u00192\b\u0010\u0013\u001a\u0004\u0018\u00010\u00198V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR(\u0010$\u001a\u0004\u0018\u00010\u001f2\b\u0010\u0013\u001a\u0004\u0018\u00010\u001f8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R4\u0010+\u001a\n\u0012\u0004\u0012\u00020&\u0018\u00010%2\u000e\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020&\u0018\u00010%8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R(\u0010.\u001a\u0004\u0018\u00010\u00012\b\u0010\u0013\u001a\u0004\u0018\u00010\u00018V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b,\u0010\u000f\"\u0004\b-\u0010\u0011R(\u00104\u001a\u0004\u0018\u00010/2\b\u0010\u0013\u001a\u0004\u0018\u00010/8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b0\u00101\"\u0004\b2\u00103R(\u0010:\u001a\u0004\u0018\u0001052\b\u0010\u0013\u001a\u0004\u0018\u0001058V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b6\u00107\"\u0004\b8\u00109R(\u0010@\u001a\u0004\u0018\u00010;2\b\u0010\u0013\u001a\u0004\u0018\u00010;8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R(\u0010F\u001a\u0004\u0018\u00010A2\b\u0010\u0013\u001a\u0004\u0018\u00010A8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\bB\u0010C\"\u0004\bD\u0010ER(\u0010L\u001a\u0004\u0018\u00010G2\b\u0010\u0013\u001a\u0004\u0018\u00010G8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\bH\u0010I\"\u0004\bJ\u0010KRD\u0010S\u001a\u0012\u0012\u0004\u0012\u00020A\u0012\u0006\u0012\u0004\u0018\u00010N\u0018\u00010M2\u0016\u0010\u0013\u001a\u0012\u0012\u0004\u0012\u00020A\u0012\u0006\u0012\u0004\u0018\u00010N\u0018\u00010M8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\bO\u0010P\"\u0004\bQ\u0010RR(\u0010Y\u001a\u0004\u0018\u00010T2\b\u0010\u0013\u001a\u0004\u0018\u00010T8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\bU\u0010V\"\u0004\bW\u0010XR(\u0010_\u001a\u0004\u0018\u00010Z2\b\u0010\u0013\u001a\u0004\u0018\u00010Z8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b[\u0010\\\"\u0004\b]\u0010^R(\u0010e\u001a\u0004\u0018\u00010`2\b\u0010\u0013\u001a\u0004\u0018\u00010`8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\ba\u0010b\"\u0004\bc\u0010dR(\u0010k\u001a\u0004\u0018\u00010f2\b\u0010\u0013\u001a\u0004\u0018\u00010f8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\bg\u0010h\"\u0004\bi\u0010j¨\u0006m"}, d2 = {"Lcom/youku/arch/v3/core/ContextWrapper;", "Lcom/youku/arch/v3/core/IContext;", "base", "Ltb/wt2;", "attachBaseContext", "T", "Lkotlin/Function0;", "action", "runOnUIThreadLocked", "runOnUIThread", "runOnLoaderThreadLocked", "runOnLoaderThread", "release", "Lcom/youku/arch/v3/core/IContext;", "getBase", "()Lcom/youku/arch/v3/core/IContext;", "setBase", "(Lcom/youku/arch/v3/core/IContext;)V", "Landroid/app/Application;", "value", "getApplication", "()Landroid/app/Application;", "setApplication", "(Landroid/app/Application;)V", "application", "Landroid/app/Activity;", "getActivity", "()Landroid/app/Activity;", "setActivity", "(Landroid/app/Activity;)V", "activity", "Lcom/youku/arch/v3/page/GenericFragment;", "getFragment", "()Lcom/youku/arch/v3/page/GenericFragment;", "setFragment", "(Lcom/youku/arch/v3/page/GenericFragment;)V", Subject.FRAGMENT, "Lcom/youku/arch/v3/IContainer;", "Lcom/youku/arch/v3/core/ModelValue;", "getPageContainer", "()Lcom/youku/arch/v3/IContainer;", "setPageContainer", "(Lcom/youku/arch/v3/IContainer;)V", "pageContainer", "getBaseContext", "setBaseContext", "baseContext", "Lcom/youku/arch/v3/core/ConfigManager;", "getConfigManager", "()Lcom/youku/arch/v3/core/ConfigManager;", "setConfigManager", "(Lcom/youku/arch/v3/core/ConfigManager;)V", "configManager", "Lcom/youku/arch/v3/creator/ComponentCreatorManager;", "getComponentCreatorManager", "()Lcom/youku/arch/v3/creator/ComponentCreatorManager;", "setComponentCreatorManager", "(Lcom/youku/arch/v3/creator/ComponentCreatorManager;)V", "componentCreatorManager", "Lcom/youku/arch/v3/adapter/ViewTypeSupport;", "getViewTypeSupport", "()Lcom/youku/arch/v3/adapter/ViewTypeSupport;", "setViewTypeSupport", "(Lcom/youku/arch/v3/adapter/ViewTypeSupport;)V", "viewTypeSupport", "", "getPageName", "()Ljava/lang/String;", "setPageName", "(Ljava/lang/String;)V", "pageName", "Landroid/os/Bundle;", "getBundle", "()Landroid/os/Bundle;", "setBundle", "(Landroid/os/Bundle;)V", "bundle", "Ljava/util/concurrent/ConcurrentMap;", "", "getConcurrentMap", "()Ljava/util/concurrent/ConcurrentMap;", "setConcurrentMap", "(Ljava/util/concurrent/ConcurrentMap;)V", "concurrentMap", "Lcom/youku/kubus/EventBus;", "getEventBus", "()Lcom/youku/kubus/EventBus;", "setEventBus", "(Lcom/youku/kubus/EventBus;)V", "eventBus", "Lcom/youku/arch/v3/core/EventDispatcher;", "getEventDispatcher", "()Lcom/youku/arch/v3/core/EventDispatcher;", "setEventDispatcher", "(Lcom/youku/arch/v3/core/EventDispatcher;)V", "eventDispatcher", "Lcom/youku/arch/v3/core/ActivityValue;", "getActivityValue", "()Lcom/youku/arch/v3/core/ActivityValue;", "setActivityValue", "(Lcom/youku/arch/v3/core/ActivityValue;)V", "activityValue", "Lcom/youku/arch/v3/style/StyleManager;", "getStyleManager", "()Lcom/youku/arch/v3/style/StyleManager;", "setStyleManager", "(Lcom/youku/arch/v3/style/StyleManager;)V", "styleManager", "<init>", "konearch_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public class ContextWrapper implements IContext {
    private static transient /* synthetic */ IpChange $ipChange;
    @Nullable
    private IContext base;

    public ContextWrapper(@Nullable IContext iContext) {
        this.base = iContext;
    }

    public final void attachBaseContext(@Nullable IContext iContext) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1972104971")) {
            ipChange.ipc$dispatch("1972104971", new Object[]{this, iContext});
            return;
        }
        if (this.base == null) {
            this.base = iContext;
            return;
        }
        throw new IllegalStateException("Base context already set".toString());
    }

    @Override // com.youku.arch.v3.core.IContext
    @Nullable
    public Activity getActivity() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "366662535")) {
            return (Activity) ipChange.ipc$dispatch("366662535", new Object[]{this});
        }
        IContext iContext = this.base;
        if (iContext == null) {
            return null;
        }
        return iContext.getActivity();
    }

    @Override // com.youku.arch.v3.core.IContext
    @Nullable
    public ActivityValue getActivityValue() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1215197038")) {
            return (ActivityValue) ipChange.ipc$dispatch("1215197038", new Object[]{this});
        }
        IContext iContext = this.base;
        if (iContext == null) {
            return null;
        }
        return iContext.getActivityValue();
    }

    @Override // com.youku.arch.v3.core.IContext
    @Nullable
    public Application getApplication() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1189837913")) {
            return (Application) ipChange.ipc$dispatch("1189837913", new Object[]{this});
        }
        IContext iContext = this.base;
        if (iContext == null) {
            return null;
        }
        return iContext.getApplication();
    }

    @Nullable
    public final IContext getBase() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "639957703") ? (IContext) ipChange.ipc$dispatch("639957703", new Object[]{this}) : this.base;
    }

    @Override // com.youku.arch.v3.core.IContext
    @Nullable
    public IContext getBaseContext() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "53879300") ? (IContext) ipChange.ipc$dispatch("53879300", new Object[]{this}) : this.base;
    }

    @Override // com.youku.arch.v3.core.IContext
    @Nullable
    public Bundle getBundle() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1330289806")) {
            return (Bundle) ipChange.ipc$dispatch("-1330289806", new Object[]{this});
        }
        IContext iContext = this.base;
        if (iContext == null) {
            return null;
        }
        return iContext.getBundle();
    }

    @Override // com.youku.arch.v3.core.IContext
    @Nullable
    public ComponentCreatorManager getComponentCreatorManager() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "580065567")) {
            return (ComponentCreatorManager) ipChange.ipc$dispatch("580065567", new Object[]{this});
        }
        IContext iContext = this.base;
        if (iContext == null) {
            return null;
        }
        return iContext.getComponentCreatorManager();
    }

    @Override // com.youku.arch.v3.core.IContext
    @Nullable
    public ConcurrentMap<String, Object> getConcurrentMap() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-713749565")) {
            return (ConcurrentMap) ipChange.ipc$dispatch("-713749565", new Object[]{this});
        }
        IContext iContext = this.base;
        if (iContext == null) {
            return null;
        }
        return iContext.getConcurrentMap();
    }

    @Override // com.youku.arch.v3.core.IContext
    @Nullable
    public ConfigManager getConfigManager() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-271261810")) {
            return (ConfigManager) ipChange.ipc$dispatch("-271261810", new Object[]{this});
        }
        IContext iContext = this.base;
        if (iContext == null) {
            return null;
        }
        return iContext.getConfigManager();
    }

    @Override // com.youku.arch.v3.core.IContext
    @Nullable
    public EventBus getEventBus() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1942382808")) {
            return (EventBus) ipChange.ipc$dispatch("-1942382808", new Object[]{this});
        }
        IContext iContext = this.base;
        if (iContext == null) {
            return null;
        }
        return iContext.getEventBus();
    }

    @Override // com.youku.arch.v3.core.IContext
    @Nullable
    public EventDispatcher getEventDispatcher() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1146446990")) {
            return (EventDispatcher) ipChange.ipc$dispatch("1146446990", new Object[]{this});
        }
        IContext iContext = this.base;
        if (iContext == null) {
            return null;
        }
        return iContext.getEventDispatcher();
    }

    @Override // com.youku.arch.v3.core.IContext
    @Nullable
    public GenericFragment getFragment() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-498729455")) {
            return (GenericFragment) ipChange.ipc$dispatch("-498729455", new Object[]{this});
        }
        IContext iContext = this.base;
        if (iContext == null) {
            return null;
        }
        return iContext.getFragment();
    }

    @Override // com.youku.arch.v3.core.IContext
    @Nullable
    public IContainer<ModelValue> getPageContainer() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1127356184")) {
            return (IContainer) ipChange.ipc$dispatch("1127356184", new Object[]{this});
        }
        IContext iContext = this.base;
        if (iContext == null) {
            return null;
        }
        return iContext.getPageContainer();
    }

    @Override // com.youku.arch.v3.core.IContext
    @Nullable
    public String getPageName() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-14241750")) {
            return (String) ipChange.ipc$dispatch("-14241750", new Object[]{this});
        }
        IContext iContext = this.base;
        if (iContext == null) {
            return null;
        }
        return iContext.getPageName();
    }

    @Override // com.youku.arch.v3.core.IContext
    @Nullable
    public StyleManager getStyleManager() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-703171382")) {
            return (StyleManager) ipChange.ipc$dispatch("-703171382", new Object[]{this});
        }
        IContext iContext = this.base;
        if (iContext == null) {
            return null;
        }
        return iContext.getStyleManager();
    }

    @Override // com.youku.arch.v3.core.IContext
    @Nullable
    public ViewTypeSupport getViewTypeSupport() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1933430968")) {
            return (ViewTypeSupport) ipChange.ipc$dispatch("1933430968", new Object[]{this});
        }
        IContext iContext = this.base;
        if (iContext == null) {
            return null;
        }
        return iContext.getViewTypeSupport();
    }

    @Override // com.youku.arch.v3.core.IContext
    public void release() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1447216257")) {
            ipChange.ipc$dispatch("-1447216257", new Object[]{this});
            return;
        }
        IContext iContext = this.base;
        if (iContext == null) {
            return;
        }
        iContext.release();
    }

    @Override // com.youku.arch.v3.core.IContext
    public <T> void runOnLoaderThread(@NotNull Function0<? extends T> function0) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "925755590")) {
            ipChange.ipc$dispatch("925755590", new Object[]{this, function0});
            return;
        }
        b41.i(function0, "action");
        IContext iContext = this.base;
        if (iContext == null) {
            return;
        }
        iContext.runOnLoaderThread(function0);
    }

    @Override // com.youku.arch.v3.core.IContext
    public <T> void runOnLoaderThreadLocked(@NotNull Function0<? extends T> function0) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1655270948")) {
            ipChange.ipc$dispatch("-1655270948", new Object[]{this, function0});
            return;
        }
        b41.i(function0, "action");
        IContext iContext = this.base;
        if (iContext == null) {
            return;
        }
        iContext.runOnLoaderThreadLocked(function0);
    }

    @Override // com.youku.arch.v3.core.IContext
    public <T> void runOnUIThread(@NotNull Function0<? extends T> function0) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1649248005")) {
            ipChange.ipc$dispatch("1649248005", new Object[]{this, function0});
            return;
        }
        b41.i(function0, "action");
        IContext iContext = this.base;
        if (iContext == null) {
            return;
        }
        iContext.runOnUIThread(function0);
    }

    @Override // com.youku.arch.v3.core.IContext
    public <T> void runOnUIThreadLocked(@NotNull Function0<? extends T> function0) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-764394277")) {
            ipChange.ipc$dispatch("-764394277", new Object[]{this, function0});
            return;
        }
        b41.i(function0, "action");
        IContext iContext = this.base;
        if (iContext == null) {
            return;
        }
        iContext.runOnUIThreadLocked(function0);
    }

    @Override // com.youku.arch.v3.core.IContext
    public void setActivity(@Nullable Activity activity) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "336281287")) {
            ipChange.ipc$dispatch("336281287", new Object[]{this, activity});
            return;
        }
        IContext iContext = this.base;
        if (iContext == null) {
            return;
        }
        iContext.setActivity(activity);
    }

    @Override // com.youku.arch.v3.core.IContext
    public void setActivityValue(@Nullable ActivityValue activityValue) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-940477164")) {
            ipChange.ipc$dispatch("-940477164", new Object[]{this, activityValue});
            return;
        }
        IContext iContext = this.base;
        if (iContext == null) {
            return;
        }
        iContext.setActivityValue(activityValue);
    }

    @Override // com.youku.arch.v3.core.IContext
    public void setApplication(@Nullable Application application) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "971697417")) {
            ipChange.ipc$dispatch("971697417", new Object[]{this, application});
            return;
        }
        IContext iContext = this.base;
        if (iContext == null) {
            return;
        }
        iContext.setApplication(application);
    }

    public final void setBase(@Nullable IContext iContext) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1861331205")) {
            ipChange.ipc$dispatch("1861331205", new Object[]{this, iContext});
        } else {
            this.base = iContext;
        }
    }

    @Override // com.youku.arch.v3.core.IContext
    public void setBaseContext(@Nullable IContext iContext) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-924319280")) {
            ipChange.ipc$dispatch("-924319280", new Object[]{this, iContext});
        } else {
            this.base = iContext;
        }
    }

    @Override // com.youku.arch.v3.core.IContext
    public void setBundle(@Nullable Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1232770802")) {
            ipChange.ipc$dispatch("1232770802", new Object[]{this, bundle});
            return;
        }
        IContext iContext = this.base;
        if (iContext == null) {
            return;
        }
        iContext.setBundle(bundle);
    }

    @Override // com.youku.arch.v3.core.IContext
    public void setComponentCreatorManager(@Nullable ComponentCreatorManager componentCreatorManager) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1320511829")) {
            ipChange.ipc$dispatch("-1320511829", new Object[]{this, componentCreatorManager});
            return;
        }
        IContext iContext = this.base;
        if (iContext == null) {
            return;
        }
        iContext.setComponentCreatorManager(componentCreatorManager);
    }

    @Override // com.youku.arch.v3.core.IContext
    public void setConcurrentMap(@Nullable ConcurrentMap<String, Object> concurrentMap) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1804303613")) {
            ipChange.ipc$dispatch("-1804303613", new Object[]{this, concurrentMap});
            return;
        }
        IContext iContext = this.base;
        if (iContext == null) {
            return;
        }
        iContext.setConcurrentMap(concurrentMap);
    }

    @Override // com.youku.arch.v3.core.IContext
    public void setConfigManager(@Nullable ConfigManager configManager) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "852807106")) {
            ipChange.ipc$dispatch("852807106", new Object[]{this, configManager});
            return;
        }
        IContext iContext = this.base;
        if (iContext == null) {
            return;
        }
        iContext.setConfigManager(configManager);
    }

    @Override // com.youku.arch.v3.core.IContext
    public void setEventBus(@Nullable EventBus eventBus) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "272578906")) {
            ipChange.ipc$dispatch("272578906", new Object[]{this, eventBus});
            return;
        }
        IContext iContext = this.base;
        if (iContext == null) {
            return;
        }
        iContext.setEventBus(eventBus);
    }

    @Override // com.youku.arch.v3.core.IContext
    public void setEventDispatcher(@Nullable EventDispatcher eventDispatcher) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "615926038")) {
            ipChange.ipc$dispatch("615926038", new Object[]{this, eventDispatcher});
            return;
        }
        IContext iContext = this.base;
        if (iContext == null) {
            return;
        }
        iContext.setEventDispatcher(eventDispatcher);
    }

    @Override // com.youku.arch.v3.core.IContext
    public void setFragment(@Nullable GenericFragment genericFragment) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "834021487")) {
            ipChange.ipc$dispatch("834021487", new Object[]{this, genericFragment});
            return;
        }
        IContext iContext = this.base;
        if (iContext == null) {
            return;
        }
        iContext.setFragment(genericFragment);
    }

    @Override // com.youku.arch.v3.core.IContext
    public void setPageContainer(@Nullable IContainer<ModelValue> iContainer) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "768324382")) {
            ipChange.ipc$dispatch("768324382", new Object[]{this, iContainer});
            return;
        }
        IContext iContext = this.base;
        if (iContext == null) {
            return;
        }
        iContext.setPageContainer(iContainer);
    }

    @Override // com.youku.arch.v3.core.IContext
    public void setPageName(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-323822092")) {
            ipChange.ipc$dispatch("-323822092", new Object[]{this, str});
            return;
        }
        IContext iContext = this.base;
        if (iContext == null) {
            return;
        }
        iContext.setPageName(str);
    }

    @Override // com.youku.arch.v3.core.IContext
    public void setStyleManager(@Nullable StyleManager styleManager) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1050194896")) {
            ipChange.ipc$dispatch("1050194896", new Object[]{this, styleManager});
            return;
        }
        IContext iContext = this.base;
        if (iContext == null) {
            return;
        }
        iContext.setStyleManager(styleManager);
    }

    @Override // com.youku.arch.v3.core.IContext
    public void setViewTypeSupport(@Nullable ViewTypeSupport viewTypeSupport) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1159098856")) {
            ipChange.ipc$dispatch("1159098856", new Object[]{this, viewTypeSupport});
            return;
        }
        IContext iContext = this.base;
        if (iContext == null) {
            return;
        }
        iContext.setViewTypeSupport(viewTypeSupport);
    }
}
