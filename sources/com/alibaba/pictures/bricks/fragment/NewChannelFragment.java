package com.alibaba.pictures.bricks.fragment;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.pictures.R$layout;
import com.alibaba.pictures.bricks.channel.component.ProjectFilterComponentCreator;
import com.alibaba.pictures.bricks.channel.component.ProjectListComponentCreator;
import com.alibaba.pictures.bricks.channel.params.PageArgument;
import com.alient.onearch.adapter.BaseFragment;
import com.alient.onearch.adapter.GenericPageContainer;
import com.alient.onearch.adapter.loader.v2.GenericPagerLoader;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.youku.arch.v3.core.ConfigManager;
import com.youku.arch.v3.core.Constants;
import com.youku.arch.v3.core.ModelValue;
import com.youku.arch.v3.core.PageContainer;
import com.youku.arch.v3.core.PageContext;
import com.youku.arch.v3.data.Constants;
import com.youku.arch.v3.data.Request;
import com.youku.arch.v3.io.IRequest;
import com.youku.arch.v3.io.IResponse;
import com.youku.arch.v3.io.RequestBuilder;
import com.youku.arch.v3.loader.LoadingViewAdapter;
import com.youku.arch.v3.page.state.IStateView;
import com.youku.arch.v3.page.state.State;
import com.youku.arch.v3.page.state.StateView;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.gm;
import tb.qp1;
import tb.wt2;
import tb.xh;
import tb.yo2;
import tb.ys2;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class NewChannelFragment extends BaseFragment {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    private final String configPath = "://bricks/raw/new_channel_component_config";
    @NotNull
    private final String pageName = "channel";
    @Nullable
    private String utPageName = "channel_default";

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public final class ChannelPageLoader extends GenericPagerLoader {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ NewChannelFragment this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ChannelPageLoader(@NotNull NewChannelFragment newChannelFragment, PageContainer<ModelValue> pageContainer) {
            super(pageContainer);
            b41.i(pageContainer, "pageContainer");
            this.this$0 = newChannelFragment;
        }

        @Override // com.youku.arch.v3.loader.PageLoader, com.youku.arch.v3.loader.AbsLoader, com.youku.arch.v3.loader.PagingLoader
        public void handleLoadFailure(@NotNull final IResponse iResponse) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1124788765")) {
                ipChange.ipc$dispatch("-1124788765", new Object[]{this, iResponse});
                return;
            }
            b41.i(iResponse, "response");
            if (b41.d(iResponse.getSource(), "remote")) {
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                linkedHashMap.put("reduce", Boolean.TRUE);
                this.this$0.m1253getPageLoader().load(linkedHashMap);
                return;
            }
            super.handleLoadFailure(iResponse);
            PageContext pageContext = this.this$0.getPageContext();
            final NewChannelFragment newChannelFragment = this.this$0;
            pageContext.runOnUIThread(new Function0<FragmentActivity>() { // from class: com.alibaba.pictures.bricks.fragment.NewChannelFragment$ChannelPageLoader$handleLoadFailure$1
                private static transient /* synthetic */ IpChange $ipChange;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @Nullable
                public final FragmentActivity invoke() {
                    IStateView stateView;
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-1368878458")) {
                        return (FragmentActivity) ipChange2.ipc$dispatch("-1368878458", new Object[]{this});
                    }
                    FragmentActivity activity = NewChannelFragment.this.getActivity();
                    if (activity != null) {
                        NewChannelFragment newChannelFragment2 = NewChannelFragment.this;
                        IResponse iResponse2 = iResponse;
                        newChannelFragment2.hideLoadingDialog(activity);
                        if (newChannelFragment2.getPageLoader().getRealItemCount() > 0) {
                            yo2.INSTANCE.i(activity, "小二很忙，系统很累，稍后再试吧");
                            return activity;
                        }
                        newChannelFragment2.getPageStateManager().setState(State.FAILED);
                        StateView stateView2 = newChannelFragment2.getPageStateManager().stateView;
                        if (stateView2 == null || (stateView = stateView2.getStateView(stateView2.getCurrentState())) == null) {
                            return activity;
                        }
                        stateView.update(iResponse2.getRetCode(), iResponse2.getRetMessage());
                        return activity;
                    }
                    return null;
                }
            });
        }

        @Override // com.alient.onearch.adapter.loader.v2.GenericPagerLoader, com.youku.arch.v3.loader.PageLoader, com.youku.arch.v3.loader.AbsLoader, com.youku.arch.v3.loader.PagingLoader
        public void handleLoadSuccess(@NotNull IResponse iResponse, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1567940743")) {
                ipChange.ipc$dispatch("-1567940743", new Object[]{this, iResponse, Integer.valueOf(i)});
                return;
            }
            b41.i(iResponse, "response");
            super.handleLoadSuccess(iResponse, i);
            PageContext pageContext = this.this$0.getPageContext();
            final NewChannelFragment newChannelFragment = this.this$0;
            pageContext.runOnUIThread(new Function0<wt2>() { // from class: com.alibaba.pictures.bricks.fragment.NewChannelFragment$ChannelPageLoader$handleLoadSuccess$1
                private static transient /* synthetic */ IpChange $ipChange;

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
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "1950664658")) {
                        ipChange2.ipc$dispatch("1950664658", new Object[]{this});
                        return;
                    }
                    NewChannelFragment newChannelFragment2 = NewChannelFragment.this;
                    newChannelFragment2.hideLoadingDialog(newChannelFragment2.getActivity());
                }
            });
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public final class ChannelPageRequestBuilder implements RequestBuilder {
        private static transient /* synthetic */ IpChange $ipChange;

        public ChannelPageRequestBuilder() {
        }

        @Override // com.youku.arch.v3.io.RequestBuilder
        @NotNull
        public IRequest build(@NotNull Map<String, ? extends Object> map) {
            Request a;
            JSONObject parseArg2Json;
            Map<String, Object> innerMap;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-2123761603")) {
                return (IRequest) ipChange.ipc$dispatch("-2123761603", new Object[]{this, map});
            }
            b41.i(map, Constants.CONFIG);
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            LinkedHashMap linkedHashMap2 = new LinkedHashMap();
            PageArgument b = qp1.INSTANCE.b(NewChannelFragment.this.getPageContext().getBundle());
            String str = b != null ? b.patternName : null;
            if (str == null) {
                str = "";
            }
            String str2 = b != null ? b.patternVersion : null;
            String str3 = str2 != null ? str2 : "";
            linkedHashMap.put("patternName", str);
            linkedHashMap.put("patternVersion", str3);
            if (b != null && (parseArg2Json = b.parseArg2Json()) != null && (innerMap = parseArg2Json.getInnerMap()) != null) {
                innerMap.remove("patternName");
                innerMap.remove("patternVersion");
                linkedHashMap2.putAll(innerMap);
            }
            long j = 2;
            Bundle bundle = new Bundle();
            Object obj = map.get("reduce");
            Boolean bool = obj instanceof Boolean ? (Boolean) obj : null;
            if (bool != null && bool.booleanValue()) {
                j = Constants.RequestStrategy.REMOTE_FILE;
                bundle.putParcelable("uri", Uri.parse("https://oss.taopiaopiao.com/dm_calendar_node_" + str3 + "_bak_" + gm.INSTANCE.a().getCityId() + "_1.json?v=" + System.currentTimeMillis()));
            }
            linkedHashMap2.put("currentCityId", gm.INSTANCE.a().getCityId());
            a = xh.INSTANCE.a(j, linkedHashMap2, linkedHashMap, (r16 & 8) != 0 ? null : null, (r16 & 16) != 0 ? null : null);
            a.setBundle(bundle);
            return a;
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public final class PageLoadingListener extends LoadingViewAdapter {
        private static transient /* synthetic */ IpChange $ipChange;

        public PageLoadingListener() {
        }

        @Override // com.youku.arch.v3.loader.LoadingViewAdapter, com.youku.arch.v3.loader.ILoadingViewListener
        public void onAllPageLoaded() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "516710636")) {
                ipChange.ipc$dispatch("516710636", new Object[]{this});
                return;
            }
            PageContext pageContext = NewChannelFragment.this.getPageContext();
            final NewChannelFragment newChannelFragment = NewChannelFragment.this;
            pageContext.runOnUIThread(new Function0<RefreshLayout>() { // from class: com.alibaba.pictures.bricks.fragment.NewChannelFragment$PageLoadingListener$onAllPageLoaded$1
                private static transient /* synthetic */ IpChange $ipChange;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @Nullable
                public final RefreshLayout invoke() {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "2092783708")) {
                        return (RefreshLayout) ipChange2.ipc$dispatch("2092783708", new Object[]{this});
                    }
                    RefreshLayout refreshLayout = NewChannelFragment.this.getRefreshLayout();
                    if (refreshLayout != null) {
                        return refreshLayout.setEnableLoadMore(false);
                    }
                    return null;
                }
            });
        }
    }

    @Override // com.alient.onearch.adapter.BaseFragment
    @NotNull
    public GenericPagerLoader createPageLoader(@NotNull GenericPageContainer genericPageContainer) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-402042170")) {
            return (GenericPagerLoader) ipChange.ipc$dispatch("-402042170", new Object[]{this, genericPageContainer});
        }
        b41.i(genericPageContainer, "container");
        ChannelPageLoader channelPageLoader = new ChannelPageLoader(this, genericPageContainer);
        channelPageLoader.getLoadingViewManager().addLoadingStateListener(new PageLoadingListener());
        return channelPageLoader;
    }

    @Override // com.alient.onearch.adapter.BaseFragment
    public /* bridge */ /* synthetic */ RequestBuilder createRequestBuilder(Map map) {
        return createRequestBuilder((Map<String, ? extends Object>) map);
    }

    @Override // com.alient.onearch.adapter.BaseFragment
    public boolean enableUTReport() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "932651545")) {
            return ((Boolean) ipChange.ipc$dispatch("932651545", new Object[]{this})).booleanValue();
        }
        return true;
    }

    @Override // com.youku.arch.v3.page.GenericFragment
    @NotNull
    protected String getConfigPath() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1495659170") ? (String) ipChange.ipc$dispatch("-1495659170", new Object[]{this}) : this.configPath;
    }

    @Override // com.alient.onearch.adapter.BaseFragment, com.youku.arch.v3.page.GenericFragment
    protected int getLayoutResId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-570738813") ? ((Integer) ipChange.ipc$dispatch("-570738813", new Object[]{this})).intValue() : R$layout.bricks_fragment_new_channel;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.youku.arch.v3.page.GenericFragment
    @NotNull
    public String getPageName() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-919588847") ? (String) ipChange.ipc$dispatch("-919588847", new Object[]{this}) : this.pageName;
    }

    @Override // com.alient.onearch.adapter.BaseFragment
    @Nullable
    public String getUtPageName() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1391463248") ? (String) ipChange.ipc$dispatch("1391463248", new Object[]{this}) : this.utPageName;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.alient.onearch.adapter.BaseFragment, com.youku.arch.v3.page.GenericFragment
    public void initConfigManager() {
        ConfigManager.CreatorConfig creatorConfig;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-52709020")) {
            ipChange.ipc$dispatch("-52709020", new Object[]{this});
            return;
        }
        super.initConfigManager();
        ConfigManager configManager = getPageContext().getConfigManager();
        if (configManager == null || (creatorConfig = configManager.getCreatorConfig(2)) == null) {
            return;
        }
        creatorConfig.addCreator(7587, new ProjectFilterComponentCreator());
        creatorConfig.addCreator(7588, new ProjectListComponentCreator());
    }

    @Override // com.alient.onearch.adapter.BaseFragment, com.youku.arch.v3.page.GenericFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "377809636")) {
            ipChange.ipc$dispatch("377809636", new Object[]{this, bundle});
            return;
        }
        Bundle bundle2 = getPageContext().getBundle();
        if (bundle2 == null) {
            bundle2 = new Bundle();
        }
        getPageContext().setBundle(bundle2);
        bundle2.putAll(qp1.INSTANCE.a(getArguments()));
        ys2.INSTANCE.i("", "");
        super.onCreate(bundle);
    }

    @Override // com.alient.onearch.adapter.BaseFragment, com.youku.arch.v3.page.GenericFragment, androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1064823293")) {
            ipChange.ipc$dispatch("1064823293", new Object[]{this, view, bundle});
            return;
        }
        b41.i(view, "view");
        super.onViewCreated(view, bundle);
        RefreshLayout refreshLayout = getRefreshLayout();
        if (refreshLayout != null) {
            refreshLayout.setEnableRefresh(false);
        }
        RefreshLayout refreshLayout2 = getRefreshLayout();
        if (refreshLayout2 != null) {
            refreshLayout2.setEnableLoadMore(true);
        }
        doRequest();
    }

    @Override // com.alient.onearch.adapter.BaseFragment
    public void setUtPageName(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1924195698")) {
            ipChange.ipc$dispatch("-1924195698", new Object[]{this, str});
        } else {
            this.utPageName = str;
        }
    }

    @Override // com.alient.onearch.adapter.BaseFragment
    @NotNull
    protected ChannelPageRequestBuilder createRequestBuilder(@Nullable Map<String, ? extends Object> map) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-978791093") ? (ChannelPageRequestBuilder) ipChange.ipc$dispatch("-978791093", new Object[]{this, map}) : new ChannelPageRequestBuilder();
    }
}
