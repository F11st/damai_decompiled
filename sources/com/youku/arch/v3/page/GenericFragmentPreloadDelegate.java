package com.youku.arch.v3.page;

import android.app.Activity;
import android.content.Context;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.adapter.ContentAdapter;
import com.youku.arch.v3.core.ActivityContext;
import com.youku.arch.v3.core.ConfigManager;
import com.youku.arch.v3.core.ModelValue;
import com.youku.arch.v3.core.PageContainer;
import com.youku.arch.v3.core.PageContext;
import com.youku.arch.v3.data.Constants;
import com.youku.arch.v3.event.FragmentEvent;
import com.youku.arch.v3.io.RequestBuilder;
import com.youku.arch.v3.loader.PageLoader;
import com.youku.kubus.Event;
import com.youku.kubus.EventBus;
import com.youku.kubus.Subscribe;
import io.flutter.wpkbridge.WPKFactory;
import java.util.HashMap;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0016\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001B\u000f\u0012\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\bO\u0010PJ\u0006\u0010\u0004\u001a\u00020\u0003J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\t\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0007J\u0006\u0010\n\u001a\u00020\u0003R\u0019\u0010\f\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR$\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R*\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u00178\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR$\u0010 \u001a\u0004\u0018\u00010\u001f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R$\u0010'\u001a\u0004\u0018\u00010&8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R$\u0010.\u001a\u0004\u0018\u00010-8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b.\u0010/\u001a\u0004\b0\u00101\"\u0004\b2\u00103R$\u00105\u001a\u0004\u0018\u0001048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b5\u00106\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R$\u0010<\u001a\u0004\u0018\u00010;8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b<\u0010=\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR$\u0010C\u001a\u0004\u0018\u00010B8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bC\u0010D\u001a\u0004\bE\u0010F\"\u0004\bG\u0010HR$\u0010I\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bI\u0010J\u001a\u0004\bK\u0010L\"\u0004\bM\u0010N¨\u0006Q"}, d2 = {"Lcom/youku/arch/v3/page/GenericFragmentPreloadDelegate;", "Lcom/youku/arch/v3/page/IDelegate;", "Lcom/youku/arch/v3/page/GenericFragment;", "Ltb/wt2;", "preload", "container", "setDelegatedContainer", "Lcom/youku/kubus/Event;", "event", "onFragmentDestroy", "release", "Landroid/content/Context;", WPKFactory.INIT_KEY_CONTEXT, "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "Lcom/youku/arch/v3/core/PageContext;", Constants.PAGE_CONTEXT, "Lcom/youku/arch/v3/core/PageContext;", "getPageContext", "()Lcom/youku/arch/v3/core/PageContext;", "setPageContext", "(Lcom/youku/arch/v3/core/PageContext;)V", "Lcom/youku/arch/v3/core/PageContainer;", "Lcom/youku/arch/v3/core/ModelValue;", "pageContainer", "Lcom/youku/arch/v3/core/PageContainer;", "getPageContainer", "()Lcom/youku/arch/v3/core/PageContainer;", "setPageContainer", "(Lcom/youku/arch/v3/core/PageContainer;)V", "", "pageName", "Ljava/lang/String;", "getPageName", "()Ljava/lang/String;", "setPageName", "(Ljava/lang/String;)V", "Lcom/youku/arch/v3/core/ActivityContext;", "activityContext", "Lcom/youku/arch/v3/core/ActivityContext;", "getActivityContext", "()Lcom/youku/arch/v3/core/ActivityContext;", "setActivityContext", "(Lcom/youku/arch/v3/core/ActivityContext;)V", "Lcom/youku/arch/v3/page/RecycleViewSettings;", "recyclerViewSettings", "Lcom/youku/arch/v3/page/RecycleViewSettings;", "getRecyclerViewSettings", "()Lcom/youku/arch/v3/page/RecycleViewSettings;", "setRecyclerViewSettings", "(Lcom/youku/arch/v3/page/RecycleViewSettings;)V", "Lcom/youku/arch/v3/core/ConfigManager;", "configManager", "Lcom/youku/arch/v3/core/ConfigManager;", "getConfigManager", "()Lcom/youku/arch/v3/core/ConfigManager;", "setConfigManager", "(Lcom/youku/arch/v3/core/ConfigManager;)V", "Lcom/youku/arch/v3/io/RequestBuilder;", "requestBuilder", "Lcom/youku/arch/v3/io/RequestBuilder;", "getRequestBuilder", "()Lcom/youku/arch/v3/io/RequestBuilder;", "setRequestBuilder", "(Lcom/youku/arch/v3/io/RequestBuilder;)V", "Lcom/youku/arch/v3/loader/PageLoader;", "pageLoader", "Lcom/youku/arch/v3/loader/PageLoader;", "getPageLoader", "()Lcom/youku/arch/v3/loader/PageLoader;", "setPageLoader", "(Lcom/youku/arch/v3/loader/PageLoader;)V", "genericFragment", "Lcom/youku/arch/v3/page/GenericFragment;", "getGenericFragment", "()Lcom/youku/arch/v3/page/GenericFragment;", "setGenericFragment", "(Lcom/youku/arch/v3/page/GenericFragment;)V", "<init>", "(Landroid/content/Context;)V", "konearch_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public class GenericFragmentPreloadDelegate implements IDelegate<GenericFragment> {
    private static transient /* synthetic */ IpChange $ipChange;
    @Nullable
    private ActivityContext activityContext;
    @Nullable
    private ConfigManager configManager;
    @NotNull
    private final Context context;
    @Nullable
    private GenericFragment genericFragment;
    @Nullable
    private PageContainer<ModelValue> pageContainer;
    @Nullable
    private PageContext pageContext;
    @Nullable
    private PageLoader pageLoader;
    @Nullable
    private String pageName;
    @Nullable
    private RecycleViewSettings recyclerViewSettings;
    @Nullable
    private RequestBuilder requestBuilder;

    public GenericFragmentPreloadDelegate(@NotNull Context context) {
        b41.i(context, WPKFactory.INIT_KEY_CONTEXT);
        this.context = context;
    }

    @Nullable
    public final ActivityContext getActivityContext() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1357194309") ? (ActivityContext) ipChange.ipc$dispatch("-1357194309", new Object[]{this}) : this.activityContext;
    }

    @Nullable
    public final ConfigManager getConfigManager() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-452269029") ? (ConfigManager) ipChange.ipc$dispatch("-452269029", new Object[]{this}) : this.configManager;
    }

    @NotNull
    public final Context getContext() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "987638486") ? (Context) ipChange.ipc$dispatch("987638486", new Object[]{this}) : this.context;
    }

    @Nullable
    public final GenericFragment getGenericFragment() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1835525397") ? (GenericFragment) ipChange.ipc$dispatch("-1835525397", new Object[]{this}) : this.genericFragment;
    }

    @Nullable
    public final PageContainer<ModelValue> getPageContainer() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1278709243") ? (PageContainer) ipChange.ipc$dispatch("1278709243", new Object[]{this}) : this.pageContainer;
    }

    @Nullable
    public final PageContext getPageContext() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1034969157") ? (PageContext) ipChange.ipc$dispatch("-1034969157", new Object[]{this}) : this.pageContext;
    }

    @Nullable
    public final PageLoader getPageLoader() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-507864517") ? (PageLoader) ipChange.ipc$dispatch("-507864517", new Object[]{this}) : this.pageLoader;
    }

    @Nullable
    public final String getPageName() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1277630723") ? (String) ipChange.ipc$dispatch("-1277630723", new Object[]{this}) : this.pageName;
    }

    @Nullable
    public final RecycleViewSettings getRecyclerViewSettings() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-177078905") ? (RecycleViewSettings) ipChange.ipc$dispatch("-177078905", new Object[]{this}) : this.recyclerViewSettings;
    }

    @Nullable
    public final RequestBuilder getRequestBuilder() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-2070599622") ? (RequestBuilder) ipChange.ipc$dispatch("-2070599622", new Object[]{this}) : this.requestBuilder;
    }

    @Subscribe(eventType = {FragmentEvent.ON_FRAGMENT_DESTROY})
    public final void onFragmentDestroy(@Nullable Event event) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-583638004")) {
            ipChange.ipc$dispatch("-583638004", new Object[]{this, event});
        } else {
            release();
        }
    }

    public final void preload() {
        PageContainer<ModelValue> pageContainer;
        ContentAdapter adapter;
        PageContainer<ModelValue> pageContainer2;
        PageContext pageContext;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-216995446")) {
            ipChange.ipc$dispatch("-216995446", new Object[]{this});
            return;
        }
        PageContext pageContext2 = this.pageContext;
        if (pageContext2 != null) {
            Context context = getContext();
            pageContext2.setActivity(context instanceof Activity ? (Activity) context : null);
            pageContext2.setPageContainer(getPageContainer());
            pageContext2.setPageName(getPageName());
            pageContext2.setBaseContext(getActivityContext() != null ? getActivityContext() : new ActivityContext());
        }
        ConfigManager configManager = this.configManager;
        if (configManager != null && (pageContext = getPageContext()) != null) {
            pageContext.setConfigManager(configManager);
        }
        RecycleViewSettings recycleViewSettings = this.recyclerViewSettings;
        if (recycleViewSettings != null && (adapter = recycleViewSettings.getAdapter()) != null && (pageContainer2 = getPageContainer()) != null) {
            pageContainer2.setContentAdapter(adapter);
        }
        RequestBuilder requestBuilder = this.requestBuilder;
        if (requestBuilder != null && (pageContainer = getPageContainer()) != null) {
            pageContainer.setRequestBuilder(requestBuilder);
        }
        PageLoader pageLoader = this.pageLoader;
        if (pageLoader == null) {
            return;
        }
        PageContainer<ModelValue> pageContainer3 = getPageContainer();
        if (pageContainer3 != null) {
            pageContainer3.setPageLoader(pageLoader);
        }
        pageLoader.load(new HashMap());
    }

    public final void release() {
        PageContext pageContext;
        EventBus eventBus;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1574893876")) {
            ipChange.ipc$dispatch("-1574893876", new Object[]{this});
            return;
        }
        GenericFragment genericFragment = this.genericFragment;
        if (genericFragment != null && (pageContext = genericFragment.getPageContext()) != null && (eventBus = pageContext.getEventBus()) != null && eventBus.isRegistered(this)) {
            eventBus.unregister(this);
        }
        this.pageContext = null;
        this.activityContext = null;
        this.pageContainer = null;
        this.configManager = null;
        this.pageLoader = null;
    }

    public final void setActivityContext(@Nullable ActivityContext activityContext) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1382066539")) {
            ipChange.ipc$dispatch("1382066539", new Object[]{this, activityContext});
        } else {
            this.activityContext = activityContext;
        }
    }

    public final void setConfigManager(@Nullable ConfigManager configManager) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-463449387")) {
            ipChange.ipc$dispatch("-463449387", new Object[]{this, configManager});
        } else {
            this.configManager = configManager;
        }
    }

    public final void setGenericFragment(@Nullable GenericFragment genericFragment) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "266419565")) {
            ipChange.ipc$dispatch("266419565", new Object[]{this, genericFragment});
        } else {
            this.genericFragment = genericFragment;
        }
    }

    public final void setPageContainer(@Nullable PageContainer<ModelValue> pageContainer) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-575824889")) {
            ipChange.ipc$dispatch("-575824889", new Object[]{this, pageContainer});
        } else {
            this.pageContainer = pageContainer;
        }
    }

    public final void setPageContext(@Nullable PageContext pageContext) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-36535317")) {
            ipChange.ipc$dispatch("-36535317", new Object[]{this, pageContext});
        } else {
            this.pageContext = pageContext;
        }
    }

    public final void setPageLoader(@Nullable PageLoader pageLoader) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1448359553")) {
            ipChange.ipc$dispatch("1448359553", new Object[]{this, pageLoader});
        } else {
            this.pageLoader = pageLoader;
        }
    }

    public final void setPageName(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-834174591")) {
            ipChange.ipc$dispatch("-834174591", new Object[]{this, str});
        } else {
            this.pageName = str;
        }
    }

    public final void setRecyclerViewSettings(@Nullable RecycleViewSettings recycleViewSettings) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1689623791")) {
            ipChange.ipc$dispatch("-1689623791", new Object[]{this, recycleViewSettings});
        } else {
            this.recyclerViewSettings = recycleViewSettings;
        }
    }

    public final void setRequestBuilder(@Nullable RequestBuilder requestBuilder) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1428927852")) {
            ipChange.ipc$dispatch("-1428927852", new Object[]{this, requestBuilder});
        } else {
            this.requestBuilder = requestBuilder;
        }
    }

    @Override // com.youku.arch.v3.page.IDelegate
    public void setDelegatedContainer(@Nullable GenericFragment genericFragment) {
        PageContext pageContext;
        EventBus eventBus;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-359612278")) {
            ipChange.ipc$dispatch("-359612278", new Object[]{this, genericFragment});
            return;
        }
        this.genericFragment = genericFragment;
        if (genericFragment == null || (pageContext = genericFragment.getPageContext()) == null || (eventBus = pageContext.getEventBus()) == null || eventBus.isRegistered(this)) {
            return;
        }
        eventBus.register(this);
    }
}
