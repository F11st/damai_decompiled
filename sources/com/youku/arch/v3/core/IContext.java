package com.youku.arch.v3.core;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import com.youku.arch.v3.IContainer;
import com.youku.arch.v3.adapter.ViewTypeSupport;
import com.youku.arch.v3.creator.ComponentCreatorManager;
import com.youku.arch.v3.event.Subject;
import com.youku.arch.v3.page.GenericFragment;
import com.youku.arch.v3.style.StyleManager;
import com.youku.kubus.EventBus;
import java.io.Serializable;
import java.util.concurrent.ConcurrentMap;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u001c\u0010\u0006\u001a\u00020\u0005\"\u0004\b\u0000\u0010\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H&J\u001c\u0010\u0007\u001a\u00020\u0005\"\u0004\b\u0000\u0010\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H&J\u001c\u0010\b\u001a\u00020\u0005\"\u0004\b\u0000\u0010\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H&J\u001c\u0010\t\u001a\u00020\u0005\"\u0004\b\u0000\u0010\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H&J\b\u0010\n\u001a\u00020\u0005H&R\u001e\u0010\u0010\u001a\u0004\u0018\u00010\u000b8&@&X¦\u000e¢\u0006\f\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0016\u001a\u0004\u0018\u00010\u00118&@&X¦\u000e¢\u0006\f\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001e\u0010\u001c\u001a\u0004\u0018\u00010\u00178&@&X¦\u000e¢\u0006\f\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR$\u0010#\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u001d8&@&X¦\u000e¢\u0006\f\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001e\u0010(\u001a\u0004\u0018\u00010\u00008&@&X¦\u000e¢\u0006\f\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001e\u0010.\u001a\u0004\u0018\u00010)8&@&X¦\u000e¢\u0006\f\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u001e\u00104\u001a\u0004\u0018\u00010/8&@&X¦\u000e¢\u0006\f\u001a\u0004\b0\u00101\"\u0004\b2\u00103R,\u0010;\u001a\u0012\u0012\u0004\u0012\u00020)\u0012\u0006\u0012\u0004\u0018\u000106\u0018\u0001058&@&X¦\u000e¢\u0006\f\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R\u001e\u0010A\u001a\u0004\u0018\u00010<8&@&X¦\u000e¢\u0006\f\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R\u001e\u0010G\u001a\u0004\u0018\u00010B8&@&X¦\u000e¢\u0006\f\u001a\u0004\bC\u0010D\"\u0004\bE\u0010FR\u001e\u0010M\u001a\u0004\u0018\u00010H8&@&X¦\u000e¢\u0006\f\u001a\u0004\bI\u0010J\"\u0004\bK\u0010LR\u001e\u0010S\u001a\u0004\u0018\u00010N8&@&X¦\u000e¢\u0006\f\u001a\u0004\bO\u0010P\"\u0004\bQ\u0010RR\u001e\u0010Y\u001a\u0004\u0018\u00010T8&@&X¦\u000e¢\u0006\f\u001a\u0004\bU\u0010V\"\u0004\bW\u0010XR\u001e\u0010_\u001a\u0004\u0018\u00010Z8&@&X¦\u000e¢\u0006\f\u001a\u0004\b[\u0010\\\"\u0004\b]\u0010^R\u001e\u0010e\u001a\u0004\u0018\u00010`8&@&X¦\u000e¢\u0006\f\u001a\u0004\ba\u0010b\"\u0004\bc\u0010d¨\u0006f"}, d2 = {"Lcom/youku/arch/v3/core/IContext;", "Ljava/io/Serializable;", "T", "Lkotlin/Function0;", "action", "Ltb/wt2;", "runOnLoaderThreadLocked", "runOnLoaderThread", "runOnUIThreadLocked", "runOnUIThread", "release", "Landroid/app/Application;", "getApplication", "()Landroid/app/Application;", "setApplication", "(Landroid/app/Application;)V", "application", "Landroid/app/Activity;", "getActivity", "()Landroid/app/Activity;", "setActivity", "(Landroid/app/Activity;)V", "activity", "Lcom/youku/arch/v3/page/GenericFragment;", "getFragment", "()Lcom/youku/arch/v3/page/GenericFragment;", "setFragment", "(Lcom/youku/arch/v3/page/GenericFragment;)V", Subject.FRAGMENT, "Lcom/youku/arch/v3/IContainer;", "Lcom/youku/arch/v3/core/ModelValue;", "getPageContainer", "()Lcom/youku/arch/v3/IContainer;", "setPageContainer", "(Lcom/youku/arch/v3/IContainer;)V", "pageContainer", "getBaseContext", "()Lcom/youku/arch/v3/core/IContext;", "setBaseContext", "(Lcom/youku/arch/v3/core/IContext;)V", "baseContext", "", "getPageName", "()Ljava/lang/String;", "setPageName", "(Ljava/lang/String;)V", "pageName", "Landroid/os/Bundle;", "getBundle", "()Landroid/os/Bundle;", "setBundle", "(Landroid/os/Bundle;)V", "bundle", "Ljava/util/concurrent/ConcurrentMap;", "", "getConcurrentMap", "()Ljava/util/concurrent/ConcurrentMap;", "setConcurrentMap", "(Ljava/util/concurrent/ConcurrentMap;)V", "concurrentMap", "Lcom/youku/arch/v3/core/ConfigManager;", "getConfigManager", "()Lcom/youku/arch/v3/core/ConfigManager;", "setConfigManager", "(Lcom/youku/arch/v3/core/ConfigManager;)V", "configManager", "Lcom/youku/arch/v3/creator/ComponentCreatorManager;", "getComponentCreatorManager", "()Lcom/youku/arch/v3/creator/ComponentCreatorManager;", "setComponentCreatorManager", "(Lcom/youku/arch/v3/creator/ComponentCreatorManager;)V", "componentCreatorManager", "Lcom/youku/arch/v3/adapter/ViewTypeSupport;", "getViewTypeSupport", "()Lcom/youku/arch/v3/adapter/ViewTypeSupport;", "setViewTypeSupport", "(Lcom/youku/arch/v3/adapter/ViewTypeSupport;)V", "viewTypeSupport", "Lcom/youku/kubus/EventBus;", "getEventBus", "()Lcom/youku/kubus/EventBus;", "setEventBus", "(Lcom/youku/kubus/EventBus;)V", "eventBus", "Lcom/youku/arch/v3/core/EventDispatcher;", "getEventDispatcher", "()Lcom/youku/arch/v3/core/EventDispatcher;", "setEventDispatcher", "(Lcom/youku/arch/v3/core/EventDispatcher;)V", "eventDispatcher", "Lcom/youku/arch/v3/core/ActivityValue;", "getActivityValue", "()Lcom/youku/arch/v3/core/ActivityValue;", "setActivityValue", "(Lcom/youku/arch/v3/core/ActivityValue;)V", "activityValue", "Lcom/youku/arch/v3/style/StyleManager;", "getStyleManager", "()Lcom/youku/arch/v3/style/StyleManager;", "setStyleManager", "(Lcom/youku/arch/v3/style/StyleManager;)V", "styleManager", "konearch_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public interface IContext extends Serializable {
    @Nullable
    Activity getActivity();

    @Nullable
    ActivityValue getActivityValue();

    @Nullable
    Application getApplication();

    @Nullable
    IContext getBaseContext();

    @Nullable
    Bundle getBundle();

    @Nullable
    ComponentCreatorManager getComponentCreatorManager();

    @Nullable
    ConcurrentMap<String, Object> getConcurrentMap();

    @Nullable
    ConfigManager getConfigManager();

    @Nullable
    EventBus getEventBus();

    @Nullable
    EventDispatcher getEventDispatcher();

    @Nullable
    GenericFragment getFragment();

    @Nullable
    IContainer<ModelValue> getPageContainer();

    @Nullable
    String getPageName();

    @Nullable
    StyleManager getStyleManager();

    @Nullable
    ViewTypeSupport getViewTypeSupport();

    void release();

    <T> void runOnLoaderThread(@NotNull Function0<? extends T> function0);

    <T> void runOnLoaderThreadLocked(@NotNull Function0<? extends T> function0);

    <T> void runOnUIThread(@NotNull Function0<? extends T> function0);

    <T> void runOnUIThreadLocked(@NotNull Function0<? extends T> function0);

    void setActivity(@Nullable Activity activity);

    void setActivityValue(@Nullable ActivityValue activityValue);

    void setApplication(@Nullable Application application);

    void setBaseContext(@Nullable IContext iContext);

    void setBundle(@Nullable Bundle bundle);

    void setComponentCreatorManager(@Nullable ComponentCreatorManager componentCreatorManager);

    void setConcurrentMap(@Nullable ConcurrentMap<String, Object> concurrentMap);

    void setConfigManager(@Nullable ConfigManager configManager);

    void setEventBus(@Nullable EventBus eventBus);

    void setEventDispatcher(@Nullable EventDispatcher eventDispatcher);

    void setFragment(@Nullable GenericFragment genericFragment);

    void setPageContainer(@Nullable IContainer<ModelValue> iContainer);

    void setPageName(@Nullable String str);

    void setStyleManager(@Nullable StyleManager styleManager);

    void setViewTypeSupport(@Nullable ViewTypeSupport viewTypeSupport);
}
