package com.alibaba.pictures.bricks.artist;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.graphics.ColorUtils;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.user.star.StarIndexFragment;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.pictures.R$color;
import com.alibaba.pictures.R$id;
import com.alibaba.pictures.R$layout;
import com.alibaba.pictures.bricks.artist.ArtistFragment;
import com.alibaba.pictures.bricks.bean.ArtistTopBean;
import com.alibaba.pictures.bricks.component.artist.wishcity.cityrequest.ActionRelation;
import com.alibaba.pictures.bricks.component.home.FollowStateBean;
import com.alibaba.pictures.bricks.util.toast.BricksToastUtil;
import com.alibaba.pictures.bricks.view.FixedScrollOffsetLayoutManager;
import com.alibaba.pictures.bricks.view.FollowView;
import com.alient.onearch.adapter.BaseFragment;
import com.alient.onearch.adapter.GenericPageContainer;
import com.alient.onearch.adapter.PageInfoBean;
import com.alient.onearch.adapter.component.footer.v2.GenericFooterPresent;
import com.alient.onearch.adapter.delegate.AutoLoadMoreDelegate;
import com.alient.onearch.adapter.loader.v2.GenericPagerLoader;
import com.alient.onearch.adapter.state.StateViewManager;
import com.alient.onearch.adapter.style.StyleConstant;
import com.alient.oneservice.appinfo.AppInfoProviderProxy;
import com.alient.oneservice.nav.Action;
import com.alient.oneservice.ut.TrackInfo;
import com.alient.oneservice.ut.UserTrackProviderProxy;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.huawei.hms.support.api.entity.core.CommonCode;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.youku.arch.v3.core.ConfigManager;
import com.youku.arch.v3.core.Constants;
import com.youku.arch.v3.core.ModelValue;
import com.youku.arch.v3.core.Node;
import com.youku.arch.v3.core.PageContainer;
import com.youku.arch.v3.core.PageContext;
import com.youku.arch.v3.data.Constants;
import com.youku.arch.v3.data.Request;
import com.youku.arch.v3.io.IRequest;
import com.youku.arch.v3.io.IResponse;
import com.youku.arch.v3.io.RequestBuilder;
import com.youku.arch.v3.loader.LoadingViewAdapter;
import com.youku.arch.v3.page.GenericFragment;
import com.youku.arch.v3.page.IDelegate;
import com.youku.arch.v3.page.state.IStateView;
import com.youku.arch.v3.page.state.State;
import com.youku.arch.v3.page.state.StateView;
import com.youku.arch.v3.style.Style;
import com.youku.arch.v3.util.ColorUtil;
import com.youku.arch.v3.util.DisplayUtil;
import io.flutter.wpkbridge.WPKFactory;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Properties;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.bi0;
import tb.h8;
import tb.jg2;
import tb.k50;
import tb.l8;
import tb.oj1;
import tb.vb1;
import tb.wt2;
import tb.x2;
import tb.yo2;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class ArtistFragment extends BaseFragment {
    private static transient /* synthetic */ IpChange $ipChange = null;
    @NotNull
    public static final String ACTION_BAR_FOLLOW_BTN = "barfollowBtn";
    @NotNull
    public static final C3443a Companion = new C3443a(null);
    @Nullable
    private String artistId;
    @Nullable
    private View backBg;
    @Nullable
    private TextView backIcon;
    @Nullable
    private RelativeLayout backLayout;
    @Nullable
    private FollowView follow;
    @Nullable
    private LinearLayout navbar;
    @Nullable
    private View shareBg;
    @Nullable
    private TextView shareIcon;
    @Nullable
    private RelativeLayout shareLayout;
    @Nullable
    private View statusBarGap;
    @Nullable
    private TextView title;
    @NotNull
    private final String configPath = "://bricks/raw/artist_component_config";
    @NotNull
    private final String pageName = StarIndexFragment.Default_PAGE;
    @Nullable
    private String utPageName = StarIndexFragment.Default_PAGE;
    @NotNull
    private final BroadcastReceiver loginLogoutReceiver = new BroadcastReceiver() { // from class: com.alibaba.pictures.bricks.artist.ArtistFragment$loginLogoutReceiver$1
        private static transient /* synthetic */ IpChange $ipChange;

        @Override // android.content.BroadcastReceiver
        public void onReceive(@Nullable Context context, @NotNull Intent intent) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1068621698")) {
                ipChange.ipc$dispatch("1068621698", new Object[]{this, context, intent});
                return;
            }
            b41.i(intent, CommonCode.Resolution.HAS_RESOLUTION_FROM_APK);
            if (b41.d(vb1.BROADCAST_LOGIN_SUCCESS, intent.getAction()) || b41.d(vb1.BROADCAST_LOGOUT_SUCCESS, intent.getAction())) {
                ArtistFragment.this.getPageLoader().reload();
            }
        }
    };

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public final class ArtistPageLoader extends GenericPagerLoader {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ ArtistFragment this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ArtistPageLoader(@NotNull ArtistFragment artistFragment, PageContainer<ModelValue> pageContainer) {
            super(pageContainer);
            b41.i(pageContainer, "pageContainer");
            this.this$0 = artistFragment;
        }

        @Override // com.alient.onearch.adapter.loader.v2.GenericPagerLoader
        public int handleCreateHeaderComponentNodeType(@NotNull Node node) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1089687604")) {
                return ((Integer) ipChange.ipc$dispatch("1089687604", new Object[]{this, node})).intValue();
            }
            b41.i(node, "componentNode");
            if (node.getType() == 7541) {
                return 7615;
            }
            return super.handleCreateHeaderComponentNodeType(node);
        }

        @Override // com.alient.onearch.adapter.loader.v2.GenericPagerLoader
        public int handleCreateHeaderItemNodeType(@NotNull Node node) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1179715368")) {
                return ((Integer) ipChange.ipc$dispatch("1179715368", new Object[]{this, node})).intValue();
            }
            b41.i(node, "componentNode");
            if (node.getType() == 7541) {
                return 7616;
            }
            return super.handleCreateHeaderItemNodeType(node);
        }

        @Override // com.alient.onearch.adapter.loader.v2.GenericPagerLoader
        public void handleFooterItemProperty(@NotNull Node node, @NotNull Node node2) {
            List<Node> children;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1582848956")) {
                ipChange.ipc$dispatch("1582848956", new Object[]{this, node, node2});
                return;
            }
            b41.i(node, "componentNode");
            b41.i(node2, "itemNode");
            if (node.getType() != 7611 || (children = node.getChildren()) == null) {
                return;
            }
            node.setMore(true);
            JSONObject data = node2.getData();
            if (data != null) {
                data.put((JSONObject) GenericFooterPresent.KEY_EXPEND_CONTENT, "展开全部" + children.size() + "场演出");
                data.put((JSONObject) GenericFooterPresent.KEY_COLLAPSE_CONTENT, "收起");
                data.put((JSONObject) StyleConstant.FOOTER_TEXT_COLOR, "#959aa5");
            }
        }

        @Override // com.alient.onearch.adapter.loader.v2.GenericPagerLoader
        public void handleHeaderItemProperty(@NotNull Node node, @NotNull Node node2) {
            Map<String, Object> map;
            Map<String, Object> map2;
            Map<String, Object> map3;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1172254474")) {
                ipChange.ipc$dispatch("1172254474", new Object[]{this, node, node2});
                return;
            }
            b41.i(node, "componentNode");
            b41.i(node2, "itemNode");
            Style style = node2.getStyle();
            if (style != null && (map3 = style.cssMap) != null) {
                map3.put(StyleConstant.HEADER_HEIGHT, "35");
            }
            if (node.getType() == 7541) {
                Style style2 = node2.getStyle();
                if (style2 == null || (map2 = style2.cssMap) == null) {
                    return;
                }
                map2.put(StyleConstant.HEADER_BG_COLOR, "#00000000");
                return;
            }
            Style style3 = node2.getStyle();
            if (style3 == null || (map = style3.cssMap) == null) {
                return;
            }
            map.put(StyleConstant.HEADER_BG_COLOR, "#00000000");
            map.put(StyleConstant.HEADER_HEIGHT, "45");
        }

        @Override // com.alient.onearch.adapter.loader.v2.GenericPagerLoader
        public void handleItemNode(@NotNull ListIterator<Node> listIterator, @NotNull Node node) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1163087183")) {
                ipChange.ipc$dispatch("1163087183", new Object[]{this, listIterator, node});
                return;
            }
            b41.i(listIterator, "itemIterator");
            b41.i(node, "itemNode");
            bi0.INSTANCE.a(node);
            super.handleItemNode(listIterator, node);
        }

        @Override // com.youku.arch.v3.loader.PageLoader, com.youku.arch.v3.loader.AbsLoader, com.youku.arch.v3.loader.PagingLoader
        public void handleLoadFailure(@NotNull final IResponse iResponse) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-500842488")) {
                ipChange.ipc$dispatch("-500842488", new Object[]{this, iResponse});
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
            final ArtistFragment artistFragment = this.this$0;
            pageContext.runOnUIThread(new Function0<FragmentActivity>() { // from class: com.alibaba.pictures.bricks.artist.ArtistFragment$ArtistPageLoader$handleLoadFailure$1
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
                    if (AndroidInstantRuntime.support(ipChange2, "-376286549")) {
                        return (FragmentActivity) ipChange2.ipc$dispatch("-376286549", new Object[]{this});
                    }
                    FragmentActivity activity = ArtistFragment.this.getActivity();
                    if (activity != null) {
                        ArtistFragment artistFragment2 = ArtistFragment.this;
                        IResponse iResponse2 = iResponse;
                        artistFragment2.hideLoadingDialog(activity);
                        if (artistFragment2.getPageLoader().getRealItemCount() > 0) {
                            yo2.INSTANCE.i(activity, "小二很忙，系统很累，稍后再试吧");
                            return activity;
                        }
                        artistFragment2.getPageStateManager().setState(State.FAILED);
                        StateView stateView2 = artistFragment2.getPageStateManager().stateView;
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

        @Override // com.alient.onearch.adapter.loader.v2.GenericPagerLoader
        public void handlePageBaseInfo(@Nullable String str, @Nullable JSONObject jSONObject, @Nullable JSONObject jSONObject2) {
            ArtistTopBean artistTopBean;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1956210661")) {
                ipChange.ipc$dispatch("-1956210661", new Object[]{this, str, jSONObject, jSONObject2});
                return;
            }
            super.handlePageBaseInfo(str, jSONObject, jSONObject2);
            if (jSONObject != null) {
                try {
                    artistTopBean = (ArtistTopBean) jSONObject.toJavaObject(ArtistTopBean.class);
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
            } else {
                artistTopBean = null;
            }
            if (artistTopBean != null) {
                this.this$0.refreshNavbar(artistTopBean);
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public final class ArtistPageLoadingListener extends LoadingViewAdapter {
        private static transient /* synthetic */ IpChange $ipChange;

        public ArtistPageLoadingListener() {
        }

        @Override // com.youku.arch.v3.loader.LoadingViewAdapter, com.youku.arch.v3.loader.ILoadingViewListener
        public void onAllPageLoaded() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "509349510")) {
                ipChange.ipc$dispatch("509349510", new Object[]{this});
                return;
            }
            PageContext pageContext = ArtistFragment.this.getPageContext();
            final ArtistFragment artistFragment = ArtistFragment.this;
            pageContext.runOnUIThread(new Function0<RefreshLayout>() { // from class: com.alibaba.pictures.bricks.artist.ArtistFragment$ArtistPageLoadingListener$onAllPageLoaded$1
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
                    if (AndroidInstantRuntime.support(ipChange2, "71823734")) {
                        return (RefreshLayout) ipChange2.ipc$dispatch("71823734", new Object[]{this});
                    }
                    RefreshLayout refreshLayout = ArtistFragment.this.getRefreshLayout();
                    if (refreshLayout != null) {
                        return refreshLayout.setEnableLoadMore(false);
                    }
                    return null;
                }
            });
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public final class ArtistRequestBuilder implements RequestBuilder {
        private static transient /* synthetic */ IpChange $ipChange;

        public ArtistRequestBuilder() {
        }

        @Override // com.youku.arch.v3.io.RequestBuilder
        @NotNull
        public IRequest build(@NotNull Map<String, ? extends Object> map) {
            Request a;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1993131593")) {
                return (IRequest) ipChange.ipc$dispatch("1993131593", new Object[]{this, map});
            }
            b41.i(map, Constants.CONFIG);
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("patternName", l8.PATTERN_NAME);
            linkedHashMap.put("patternVersion", "1.0");
            LinkedHashMap linkedHashMap2 = new LinkedHashMap();
            String str = ArtistFragment.this.artistId;
            if (str != null) {
                linkedHashMap2.put(l8.KEY_ARTIST_ID, str);
            }
            long j = 2;
            Bundle bundle = new Bundle();
            Object obj = map.get("reduce");
            Boolean bool = obj instanceof Boolean ? (Boolean) obj : null;
            if (bool != null) {
                ArtistFragment artistFragment = ArtistFragment.this;
                if (bool.booleanValue()) {
                    j = Constants.RequestStrategy.REMOTE_FILE;
                    bundle.putParcelable("uri", Uri.parse("https://oss.taopiaopiao.com/artist_home_1.0_bak_" + AppInfoProviderProxy.getComboChannel() + '_' + artistFragment.artistId + ".json?v=" + System.currentTimeMillis()));
                }
            }
            a = l8.INSTANCE.a(j, linkedHashMap2, linkedHashMap, (r16 & 8) != 0 ? null : null, (r16 & 16) != 0 ? null : null);
            a.setBundle(bundle);
            return a;
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.alibaba.pictures.bricks.artist.ArtistFragment$a */
    /* loaded from: classes7.dex */
    public static final class C3443a {
        private C3443a() {
        }

        public /* synthetic */ C3443a(k50 k50Var) {
            this();
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.alibaba.pictures.bricks.artist.ArtistFragment$b */
    /* loaded from: classes7.dex */
    public static final class C3444b implements ActionRelation<FollowStateBean> {
        private static transient /* synthetic */ IpChange $ipChange;

        C3444b() {
        }

        @Override // com.alibaba.pictures.bricks.component.artist.wishcity.cityrequest.ActionRelation
        public void action(@NotNull x2<FollowStateBean> x2Var) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1405654166")) {
                ipChange.ipc$dispatch("1405654166", new Object[]{this, x2Var});
                return;
            }
            b41.i(x2Var, "result");
            if (!x2Var.b()) {
                BricksToastUtil.INSTANCE.b(oj1.MAIPIAO_SERVICE_ERROR_FRIENDLY);
            } else if (x2Var.a() != null) {
                if (x2Var.a().isFollowed()) {
                    BricksToastUtil.INSTANCE.b("关注成功");
                } else {
                    BricksToastUtil.INSTANCE.b("取消关注成功");
                }
            }
        }

        @Override // com.alibaba.pictures.bricks.component.artist.wishcity.cityrequest.ActionRelation
        public void end() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1209532535")) {
                ipChange.ipc$dispatch("-1209532535", new Object[]{this});
                return;
            }
            ArtistFragment artistFragment = ArtistFragment.this;
            artistFragment.hideLoadingDialog(artistFragment.getActivity());
        }

        @Override // com.alibaba.pictures.bricks.component.artist.wishcity.cityrequest.ActionRelation
        public void start() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1219611362")) {
                ipChange.ipc$dispatch("1219611362", new Object[]{this});
                return;
            }
            ArtistFragment artistFragment = ArtistFragment.this;
            StateViewManager.IStateFeature.DefaultImpls.showLoadingDialog$default(artistFragment, artistFragment.getActivity(), null, false, 6, null);
        }
    }

    private final void initNavbar() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1809652104")) {
            ipChange.ipc$dispatch("-1809652104", new Object[]{this});
            return;
        }
        if (Build.VERSION.SDK_INT >= 23) {
            View view = this.statusBarGap;
            ViewGroup.LayoutParams layoutParams = view != null ? view.getLayoutParams() : null;
            if (layoutParams != null) {
                layoutParams.height = jg2.a(getActivity());
            }
            View view2 = this.statusBarGap;
            if (view2 != null) {
                view2.setVisibility(0);
            }
            jg2.f(requireActivity(), true, R$color.black);
        } else {
            jg2.f(requireActivity(), false, R$color.black);
            View view3 = this.statusBarGap;
            if (view3 != null) {
                view3.setVisibility(8);
            }
        }
        RelativeLayout relativeLayout = this.backLayout;
        if (relativeLayout != null) {
            relativeLayout.setOnClickListener(new View.OnClickListener() { // from class: tb.i8
                @Override // android.view.View.OnClickListener
                public final void onClick(View view4) {
                    ArtistFragment.m109initNavbar$lambda4(ArtistFragment.this, view4);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: initNavbar$lambda-4  reason: not valid java name */
    public static final void m109initNavbar$lambda4(ArtistFragment artistFragment, View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "212888812")) {
            ipChange.ipc$dispatch("212888812", new Object[]{artistFragment, view});
            return;
        }
        b41.i(artistFragment, "this$0");
        FragmentActivity activity = artistFragment.getActivity();
        if (activity != null) {
            activity.onBackPressed();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void refreshNavbar(ArtistTopBean artistTopBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1513219315")) {
            ipChange.ipc$dispatch("1513219315", new Object[]{this, artistTopBean});
        } else {
            getPageContext().runOnUIThread(new ArtistFragment$refreshNavbar$1(this, artistTopBean));
        }
    }

    @Override // com.alient.onearch.adapter.BaseFragment
    @Nullable
    public VirtualLayoutManager createLayoutManager(@NotNull Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1404037984")) {
            return (VirtualLayoutManager) ipChange.ipc$dispatch("1404037984", new Object[]{this, context});
        }
        b41.i(context, WPKFactory.INIT_KEY_CONTEXT);
        FixedScrollOffsetLayoutManager fixedScrollOffsetLayoutManager = new FixedScrollOffsetLayoutManager(context);
        fixedScrollOffsetLayoutManager.setItemPrefetchEnabled(true);
        fixedScrollOffsetLayoutManager.setInitialPrefetchItemCount(5);
        return fixedScrollOffsetLayoutManager;
    }

    @Override // com.alient.onearch.adapter.BaseFragment
    @NotNull
    public GenericPagerLoader createPageLoader(@NotNull GenericPageContainer genericPageContainer) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-435901575")) {
            return (GenericPagerLoader) ipChange.ipc$dispatch("-435901575", new Object[]{this, genericPageContainer});
        }
        b41.i(genericPageContainer, "container");
        ArtistPageLoader artistPageLoader = new ArtistPageLoader(this, genericPageContainer);
        artistPageLoader.getLoadingViewManager().addLoadingStateListener(new ArtistPageLoadingListener());
        return artistPageLoader;
    }

    @Override // com.alient.onearch.adapter.BaseFragment
    public /* bridge */ /* synthetic */ RequestBuilder createRequestBuilder(Map map) {
        return createRequestBuilder((Map<String, ? extends Object>) map);
    }

    @Override // com.alient.onearch.adapter.BaseFragment
    public boolean enableUTReport() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1474565958")) {
            return ((Boolean) ipChange.ipc$dispatch("1474565958", new Object[]{this})).booleanValue();
        }
        return true;
    }

    @Override // com.youku.arch.v3.page.GenericFragment
    @NotNull
    protected String getConfigPath() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1853425803") ? (String) ipChange.ipc$dispatch("1853425803", new Object[]{this}) : this.configPath;
    }

    @Override // com.alient.onearch.adapter.BaseFragment, com.youku.arch.v3.page.GenericFragment
    protected int getLayoutResId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-28824400") ? ((Integer) ipChange.ipc$dispatch("-28824400", new Object[]{this})).intValue() : R$layout.bricks_fragment_artist;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.youku.arch.v3.page.GenericFragment
    @NotNull
    public String getPageName() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1019089534") ? (String) ipChange.ipc$dispatch("1019089534", new Object[]{this}) : this.pageName;
    }

    @Override // com.alient.onearch.adapter.BaseFragment
    @NotNull
    public Properties getUTPageData() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-179612626")) {
            return (Properties) ipChange.ipc$dispatch("-179612626", new Object[]{this});
        }
        Properties properties = new Properties();
        properties.put("biz_id", this.artistId);
        return properties;
    }

    @Override // com.alient.onearch.adapter.BaseFragment
    @Nullable
    public String getUtPageName() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "445580925") ? (String) ipChange.ipc$dispatch("445580925", new Object[]{this}) : this.utPageName;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.alient.onearch.adapter.BaseFragment, com.youku.arch.v3.page.GenericFragment
    public void initConfigManager() {
        ConfigManager.CreatorConfig creatorConfig;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-662497001")) {
            ipChange.ipc$dispatch("-662497001", new Object[]{this});
            return;
        }
        super.initConfigManager();
        ConfigManager configManager = getPageContext().getConfigManager();
        if (configManager == null || (creatorConfig = configManager.getCreatorConfig(2)) == null) {
            return;
        }
        creatorConfig.addCreator(7541, new FeedComponentCreator());
    }

    @Override // com.alient.onearch.adapter.BaseFragment, com.youku.arch.v3.page.GenericFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        Bundle bundle2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-945125673")) {
            ipChange.ipc$dispatch("-945125673", new Object[]{this, bundle});
            return;
        }
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        String string = arguments != null ? arguments.getString("userId") : null;
        this.artistId = string;
        if (string != null && (bundle2 = getPageContext().getBundle()) != null) {
            bundle2.putString(l8.KEY_ARTIST_ID, string);
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(vb1.BROADCAST_LOGIN_SUCCESS);
        intentFilter.addAction(vb1.BROADCAST_LOGOUT_SUCCESS);
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.registerReceiver(this.loginLogoutReceiver, intentFilter);
        }
    }

    @Override // com.alient.onearch.adapter.BaseFragment, com.youku.arch.v3.page.GenericFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-590325801")) {
            ipChange.ipc$dispatch("-590325801", new Object[]{this});
            return;
        }
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.unregisterReceiver(this.loginLogoutReceiver);
        }
        h8.Companion.a().d(this, this.artistId);
        super.onDestroy();
    }

    @Override // com.alient.onearch.adapter.BaseFragment, com.youku.arch.v3.page.GenericFragment, androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-904553232")) {
            ipChange.ipc$dispatch("-904553232", new Object[]{this, view, bundle});
            return;
        }
        b41.i(view, "view");
        super.onViewCreated(view, bundle);
        View realView = getRealView();
        this.navbar = realView != null ? (LinearLayout) realView.findViewById(R$id.nav_bar) : null;
        View realView2 = getRealView();
        this.statusBarGap = realView2 != null ? realView2.findViewById(R$id.status_bar_gap) : null;
        View realView3 = getRealView();
        this.backLayout = realView3 != null ? (RelativeLayout) realView3.findViewById(R$id.navbar_back_layout) : null;
        View realView4 = getRealView();
        this.backBg = realView4 != null ? realView4.findViewById(R$id.navbar_back_bg) : null;
        View realView5 = getRealView();
        this.backIcon = realView5 != null ? (TextView) realView5.findViewById(R$id.navbar_back_icon) : null;
        View realView6 = getRealView();
        this.shareLayout = realView6 != null ? (RelativeLayout) realView6.findViewById(R$id.navbar_share_layout) : null;
        View realView7 = getRealView();
        this.shareBg = realView7 != null ? realView7.findViewById(R$id.navbar_share_bg) : null;
        View realView8 = getRealView();
        this.shareIcon = realView8 != null ? (TextView) realView8.findViewById(R$id.navbar_share_icon) : null;
        View realView9 = getRealView();
        this.follow = realView9 != null ? (FollowView) realView9.findViewById(R$id.navbar_follow) : null;
        View realView10 = getRealView();
        this.title = realView10 != null ? (TextView) realView10.findViewById(R$id.navbar_title) : null;
        RefreshLayout refreshLayout = getRefreshLayout();
        if (refreshLayout != null) {
            refreshLayout.setEnableRefresh(true);
        }
        RefreshLayout refreshLayout2 = getRefreshLayout();
        if (refreshLayout2 != null) {
            refreshLayout2.setEnableLoadMore(true);
        }
        RefreshLayout refreshLayout3 = getRefreshLayout();
        if (refreshLayout3 != null) {
            refreshLayout3.setEnableOverScrollBounce(false);
        }
        FollowView followView = this.follow;
        if (followView != null) {
            h8.Companion.a().f(this, this.artistId, followView, new Function1<Boolean, wt2>() { // from class: com.alibaba.pictures.bricks.artist.ArtistFragment$onViewCreated$1$1
                private static transient /* synthetic */ IpChange $ipChange;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ wt2 invoke(Boolean bool) {
                    invoke(bool.booleanValue());
                    return wt2.INSTANCE;
                }

                public final void invoke(boolean z) {
                    Map<String, Action> map;
                    Action action;
                    TrackInfo trackInfo;
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "912235450")) {
                        ipChange2.ipc$dispatch("912235450", new Object[]{this, Boolean.valueOf(z)});
                        return;
                    }
                    PageInfoBean topBasePageInfo = ArtistFragment.this.getTopBasePageInfo();
                    if (topBasePageInfo == null || (map = topBasePageInfo.action) == null || (action = map.get(ArtistFragment.ACTION_BAR_FOLLOW_BTN)) == null || (trackInfo = action.getTrackInfo()) == null) {
                        return;
                    }
                    HashMap<String, String> args = trackInfo.getArgs();
                    if (args != null) {
                        args.put("status", z ? "1" : "0");
                    }
                    UserTrackProviderProxy.click(trackInfo);
                }
            });
        }
        h8.Companion.a().h(this, this.artistId, new C3444b());
        RecyclerView recyclerView = getRecyclerView();
        if (recyclerView != null) {
            recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.alibaba.pictures.bricks.artist.ArtistFragment$onViewCreated$3
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
                public void onScrolled(@NotNull RecyclerView recyclerView2, int i, int i2) {
                    LinearLayout linearLayout;
                    TextView textView;
                    View view2;
                    TextView textView2;
                    View view3;
                    TextView textView3;
                    FollowView followView2;
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-622089253")) {
                        ipChange2.ipc$dispatch("-622089253", new Object[]{this, recyclerView2, Integer.valueOf(i), Integer.valueOf(i2)});
                        return;
                    }
                    b41.i(recyclerView2, "recyclerView");
                    super.onScrolled(recyclerView2, i, i2);
                    int computeVerticalScrollOffset = recyclerView2.computeVerticalScrollOffset();
                    float abs = (Math.abs(computeVerticalScrollOffset >= 0 ? computeVerticalScrollOffset : 0) * 1.0f) / DisplayUtil.dip2px(recyclerView2.getContext(), 120.0f);
                    if (abs > 1.0f) {
                        abs = 1.0f;
                    }
                    if (abs >= 1.0f) {
                        jg2.d(true, ArtistFragment.this.getActivity());
                    } else {
                        jg2.e(ArtistFragment.this.getActivity());
                    }
                    linearLayout = ArtistFragment.this.navbar;
                    if (linearLayout != null) {
                        linearLayout.setBackgroundColor(ColorUtils.setAlphaComponent(-1, (int) (255 * abs)));
                    }
                    textView = ArtistFragment.this.title;
                    if (textView != null) {
                        textView.setTextColor(ColorUtils.setAlphaComponent(ColorUtil.parseColorSafely("#2e333e"), (int) (255 * abs)));
                    }
                    float f = 1 - abs;
                    view2 = ArtistFragment.this.backBg;
                    if (view2 != null) {
                        view2.setAlpha(f);
                    }
                    textView2 = ArtistFragment.this.backIcon;
                    if (textView2 != null) {
                        textView2.setAlpha(f);
                    }
                    view3 = ArtistFragment.this.shareBg;
                    if (view3 != null) {
                        view3.setAlpha(f);
                    }
                    textView3 = ArtistFragment.this.shareIcon;
                    if (textView3 != null) {
                        textView3.setAlpha(f);
                    }
                    followView2 = ArtistFragment.this.follow;
                    if (followView2 == null) {
                        return;
                    }
                    followView2.setAlpha(abs);
                }
            });
        }
        initNavbar();
        doRequest();
    }

    @Override // com.alient.onearch.adapter.BaseFragment
    public void setUtPageName(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1181776639")) {
            ipChange.ipc$dispatch("-1181776639", new Object[]{this, str});
        } else {
            this.utPageName = str;
        }
    }

    @Override // com.alient.onearch.adapter.BaseFragment, com.youku.arch.v3.page.GenericFragment
    @Nullable
    public List<IDelegate<GenericFragment>> wrapperDelegates(@Nullable List<IDelegate<GenericFragment>> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-568837575")) {
            return (List) ipChange.ipc$dispatch("-568837575", new Object[]{this, list});
        }
        List<IDelegate<GenericFragment>> wrapperDelegates = super.wrapperDelegates(list);
        if (wrapperDelegates == null) {
            wrapperDelegates = new ArrayList<>();
        }
        wrapperDelegates.add(new AutoLoadMoreDelegate());
        return wrapperDelegates;
    }

    @Override // com.alient.onearch.adapter.BaseFragment
    @NotNull
    protected ArtistRequestBuilder createRequestBuilder(@Nullable Map<String, ? extends Object> map) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1213802260") ? (ArtistRequestBuilder) ipChange.ipc$dispatch("1213802260", new Object[]{this, map}) : new ArtistRequestBuilder();
    }
}
