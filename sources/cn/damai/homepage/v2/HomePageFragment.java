package cn.damai.homepage.v2;

import android.app.Application;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.common.AppConfig;
import cn.damai.common.net.mtop.Util;
import cn.damai.common.user.C0525a;
import cn.damai.common.util.PriorityTask;
import cn.damai.common.util.ToastUtil;
import cn.damai.common.util.toastutil.C0537a;
import cn.damai.commonbusiness.pageut.PageUtExecutor;
import cn.damai.commonbusiness.tab.DamaiTabViewHelper;
import cn.damai.commonbusiness.tab.DamaiTabbarManager;
import cn.damai.homepage.MainActivity;
import cn.damai.homepage.R$id;
import cn.damai.homepage.R$layout;
import cn.damai.homepage.bean.HomePageGuideBarSearchKeywords;
import cn.damai.homepage.bean.KeyWord;
import cn.damai.homepage.request.HomeConfigRequest;
import cn.damai.homepage.ui.fragment.FragmentAgent;
import cn.damai.homepage.ui.fragment.HomeTabFragment;
import cn.damai.homepage.ui.view.HomePageGuideBar;
import cn.damai.homepage.util.HomeHeadUiBinder;
import cn.damai.homepage.util.LottieMockHelper;
import cn.damai.homepage.v2.HomePageFragment;
import cn.damai.homepage.v2.feed.FeedComponentCreator;
import cn.damai.homepage.v2.feed.container.FeedTabContainer;
import cn.damai.uikit.refresh.footer.SimpleHeader;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.pictures.abtest.provider.ABTestProvider;
import com.alibaba.pictures.bricks.component.home.StateAtmo;
import com.alibaba.pictures.bricks.view.NestedRecyclerView;
import com.alient.onearch.adapter.BaseFragment;
import com.alient.onearch.adapter.GenericPageContainer;
import com.alient.onearch.adapter.PageInfoBean;
import com.alient.onearch.adapter.component.divider.DividerModel;
import com.alient.onearch.adapter.component.header.sticky.StickyHeaderFeature;
import com.alient.onearch.adapter.decorate.ComponentDecorateItem;
import com.alient.onearch.adapter.delegate.AutoLoadMoreDelegate;
import com.alient.onearch.adapter.loader.v2.GenericPagerLoader;
import com.alient.onearch.adapter.state.StateViewManager;
import com.alient.onearch.adapter.style.StyleConstant;
import com.alient.resource.util.DisplayUtil;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.scwang.smartrefresh.layout.api.RefreshInternal;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.youku.arch.v3.IComponent;
import com.youku.arch.v3.IItem;
import com.youku.arch.v3.IModule;
import com.youku.arch.v3.adapter.ContentAdapter;
import com.youku.arch.v3.adapter.VBaseAdapter;
import com.youku.arch.v3.adapter.VBaseHolder;
import com.youku.arch.v3.core.ConfigManager;
import com.youku.arch.v3.core.ItemValue;
import com.youku.arch.v3.core.ModelValue;
import com.youku.arch.v3.core.Node;
import com.youku.arch.v3.core.PageContainer;
import com.youku.arch.v3.core.PageContext;
import com.youku.arch.v3.data.Constants;
import com.youku.arch.v3.data.Request;
import com.youku.arch.v3.data.local.LocalDataSource;
import com.youku.arch.v3.event.RefreshEvent;
import com.youku.arch.v3.io.IRequest;
import com.youku.arch.v3.io.IResponse;
import com.youku.arch.v3.io.RequestBuilder;
import com.youku.arch.v3.loader.LoadingViewAdapter;
import com.youku.arch.v3.page.GenericFragment;
import com.youku.arch.v3.page.IDelegate;
import com.youku.arch.v3.style.Style;
import com.youku.arch.v3.view.render.GenericRenderConfig;
import com.youku.kubus.Event;
import com.youku.kubus.Subscribe;
import io.flutter.stat.StatsUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Ref$ObjectRef;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.ci0;
import tb.k50;
import tb.mu0;
import tb.nu1;
import tb.qy0;
import tb.r8;
import tb.r92;
import tb.tx0;
import tb.wt2;
import tb.wy0;
import tb.yi;
import tb.z20;
import tb.zr;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public final class HomePageFragment extends BaseFragment implements FragmentAgent, StickyHeaderFeature {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    public static final C1254a Companion = new C1254a(null);
    @Nullable
    private HomePageGuideBar guideBar;
    @Nullable
    private HomeHeadUiBinder mHomeHeadUiBinder;
    @Nullable
    private View stickyHeaderView;
    @NotNull
    private final String pageName = "home";
    @Nullable
    private String utPageName = "page_home";
    @NotNull
    private final String configPath = "://homepage/raw/homepage_component_config";

    /* compiled from: Taobao */
    /* loaded from: classes5.dex */
    public final class HomePageLoader extends GenericPagerLoader {
        private static transient /* synthetic */ IpChange $ipChange;
        @NotNull
        private final JSONObject dividerComponentData;
        final /* synthetic */ HomePageFragment this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public HomePageLoader(@NotNull HomePageFragment homePageFragment, PageContainer<ModelValue> pageContainer) {
            super(pageContainer);
            b41.i(pageContainer, "pageContainer");
            this.this$0 = homePageFragment;
            JSONObject jSONObject = new JSONObject();
            this.dividerComponentData = jSONObject;
            jSONObject.put((JSONObject) DividerModel.DIVIDER_COLOR, "#00000000");
            addComponentDecorate(StatsUtil.MSG_SAVE_STATS_HEARTBEAT, new ComponentDecorateItem(9993, 9993, jSONObject, ComponentDecorateItem.Indexer.Before));
        }

        private final void cacheRequestData(final IResponse iResponse) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "2055129881")) {
                ipChange.ipc$dispatch("2055129881", new Object[]{this, iResponse});
            } else {
                this.this$0.getPageContext().runOnLoaderThread(new Function0<wt2>() { // from class: cn.damai.homepage.v2.HomePageFragment$HomePageLoader$cacheRequestData$1
                    private static transient /* synthetic */ IpChange $ipChange;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                        JSONObject jSONObject;
                        IpChange ipChange2 = $ipChange;
                        if (AndroidInstantRuntime.support(ipChange2, "-307781933")) {
                            ipChange2.ipc$dispatch("-307781933", new Object[]{this});
                            return;
                        }
                        HomePageFragment.HomePageLoader homePageLoader = HomePageFragment.HomePageLoader.this;
                        JSONObject jsonObject = iResponse.getJsonObject();
                        homePageLoader.filterNeedCacheData((jsonObject == null || (jSONObject = jsonObject.getJSONObject("data")) == null) ? null : jSONObject.getJSONArray("nodes"));
                        IResponse iResponse2 = iResponse;
                        JSONObject jsonObject2 = iResponse2.getJsonObject();
                        iResponse2.setRawData(jsonObject2 != null ? jsonObject2.toJSONString() : null);
                        LocalDataSource.put$default(LocalDataSource.Companion.getInstance(), iResponse, 0L, 2, null);
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Code restructure failed: missing block: B:37:0x007a, code lost:
            if (r2.intValue() != 7545) goto L35;
         */
        /* JADX WARN: Removed duplicated region for block: B:48:0x008f  */
        /* JADX WARN: Removed duplicated region for block: B:77:0x009e A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:79:0x004e A[SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final tb.wt2 filterNeedCacheData(com.alibaba.fastjson.JSONArray r8) {
            /*
                r7 = this;
                com.android.alibaba.ip.runtime.IpChange r0 = cn.damai.homepage.v2.HomePageFragment.HomePageLoader.$ipChange
                java.lang.String r1 = "56465508"
                boolean r2 = com.android.alibaba.ip.runtime.AndroidInstantRuntime.support(r0, r1)
                r3 = 0
                r4 = 1
                if (r2 == 0) goto L1a
                r2 = 2
                java.lang.Object[] r2 = new java.lang.Object[r2]
                r2[r3] = r7
                r2[r4] = r8
                java.lang.Object r8 = r0.ipc$dispatch(r1, r2)
                tb.wt2 r8 = (tb.wt2) r8
                return r8
            L1a:
                r0 = 0
                if (r8 == 0) goto Lb3
                java.util.Iterator r8 = r8.iterator()
            L21:
                boolean r1 = r8.hasNext()
                if (r1 == 0) goto Lb1
                java.lang.Object r1 = r8.next()
                boolean r2 = r1 instanceof com.alibaba.fastjson.JSONObject     // Catch: java.lang.Exception -> La2
                if (r2 == 0) goto L32
                com.alibaba.fastjson.JSONObject r1 = (com.alibaba.fastjson.JSONObject) r1     // Catch: java.lang.Exception -> La2
                goto L33
            L32:
                r1 = r0
            L33:
                if (r1 == 0) goto L42
                java.lang.String r2 = "nodes"
                com.alibaba.fastjson.JSONArray r1 = r1.getJSONArray(r2)     // Catch: java.lang.Exception -> La2
                if (r1 == 0) goto L42
                java.util.Iterator r1 = r1.iterator()     // Catch: java.lang.Exception -> La2
                goto L43
            L42:
                r1 = r0
            L43:
                boolean r2 = tb.tq2.l(r1)     // Catch: java.lang.Exception -> La2
                if (r2 == 0) goto L4a
                goto L4b
            L4a:
                r1 = r0
            L4b:
                if (r1 != 0) goto L4e
                goto L21
            L4e:
                boolean r2 = r1.hasNext()     // Catch: java.lang.Exception -> La2
                if (r2 == 0) goto L21
                java.lang.Object r2 = r1.next()     // Catch: java.lang.Exception -> La2
                com.alibaba.fastjson.JSONObject r2 = (com.alibaba.fastjson.JSONObject) r2     // Catch: java.lang.Exception -> La2
                java.lang.String r5 = "type"
                java.lang.String r2 = r2.getString(r5)     // Catch: java.lang.Exception -> La2
                if (r2 == 0) goto L70
                java.lang.String r5 = "getString(\"type\")"
                tb.b41.h(r2, r5)     // Catch: java.lang.Exception -> La2
                int r2 = java.lang.Integer.parseInt(r2)     // Catch: java.lang.Exception -> La2
                java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch: java.lang.Exception -> La2
                goto L71
            L70:
                r2 = r0
            L71:
                r5 = 7545(0x1d79, float:1.0573E-41)
                if (r2 != 0) goto L76
                goto L7e
            L76:
                int r6 = r2.intValue()     // Catch: java.lang.Exception -> La2
                if (r6 != r5) goto L7e
            L7c:
                r5 = 1
                goto L8b
            L7e:
                r5 = 7546(0x1d7a, float:1.0574E-41)
                if (r2 != 0) goto L83
                goto L8a
            L83:
                int r6 = r2.intValue()     // Catch: java.lang.Exception -> La2
                if (r6 != r5) goto L8a
                goto L7c
            L8a:
                r5 = 0
            L8b:
                if (r5 == 0) goto L8f
            L8d:
                r2 = 1
                goto L9c
            L8f:
                r5 = 9990(0x2706, float:1.3999E-41)
                if (r2 != 0) goto L94
                goto L9b
            L94:
                int r2 = r2.intValue()     // Catch: java.lang.Exception -> La2
                if (r2 != r5) goto L9b
                goto L8d
            L9b:
                r2 = 0
            L9c:
                if (r2 == 0) goto L4e
                r1.remove()     // Catch: java.lang.Exception -> La2
                goto L4e
            La2:
                r1 = move-exception
                boolean r2 = com.youku.middlewareservice.provider.info.AppInfoProviderProxy.isDebuggable()
                if (r2 != 0) goto Lab
                goto L21
            Lab:
                java.lang.RuntimeException r8 = new java.lang.RuntimeException
                r8.<init>(r1)
                throw r8
            Lb1:
                tb.wt2 r0 = tb.wt2.INSTANCE
            Lb3:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: cn.damai.homepage.v2.HomePageFragment.HomePageLoader.filterNeedCacheData(com.alibaba.fastjson.JSONArray):tb.wt2");
        }

        @Override // com.alient.onearch.adapter.loader.v2.GenericPagerLoader
        public void handleComponentNode(@NotNull ListIterator<Node> listIterator, @NotNull Node node) {
            IpChange ipChange = $ipChange;
            boolean z = false;
            if (AndroidInstantRuntime.support(ipChange, "-116474219")) {
                ipChange.ipc$dispatch("-116474219", new Object[]{this, listIterator, node});
                return;
            }
            b41.i(listIterator, "componentIterator");
            b41.i(node, "componentNode");
            super.handleComponentNode(listIterator, node);
            if (node.getType() == 9990) {
                List<Node> children = node.getChildren();
                if (children != null) {
                    int size = children.size();
                    int i = 0;
                    while (true) {
                        if (i >= size) {
                            break;
                        }
                        List<Node> children2 = children.get(i).getChildren();
                        if (!(children2 == null || children2.isEmpty())) {
                            listIterator.add(children.get(i));
                            node.setMore(true);
                            z = true;
                            break;
                        }
                        i++;
                    }
                }
                if (z) {
                    return;
                }
                PageContext pageContext = this.this$0.getPageContext();
                final HomePageFragment homePageFragment = this.this$0;
                pageContext.runOnUIThread(new Function0<RefreshLayout>() { // from class: cn.damai.homepage.v2.HomePageFragment$HomePageLoader$handleComponentNode$2
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
                        if (AndroidInstantRuntime.support(ipChange2, "-420269997")) {
                            return (RefreshLayout) ipChange2.ipc$dispatch("-420269997", new Object[]{this});
                        }
                        RefreshLayout refreshLayout = HomePageFragment.this.getRefreshLayout();
                        if (refreshLayout != null) {
                            return refreshLayout.setEnableLoadMore(false);
                        }
                        return null;
                    }
                });
            }
        }

        @Override // com.alient.onearch.adapter.loader.v2.GenericPagerLoader
        public void handleHeaderItemProperty(@NotNull Node node, @NotNull Node node2) {
            Map<String, Object> map;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1776350546")) {
                ipChange.ipc$dispatch("1776350546", new Object[]{this, node, node2});
                return;
            }
            b41.i(node, "componentNode");
            b41.i(node2, "itemNode");
            node.getType();
            if (node2.getStyle() == null) {
                node2.setStyle(new Style());
            }
            Style style = node2.getStyle();
            b41.f(style);
            if (style.cssMap == null) {
                Style style2 = node2.getStyle();
                b41.f(style2);
                style2.cssMap = new LinkedHashMap();
            }
            Style style3 = node2.getStyle();
            if (style3 == null || (map = style3.cssMap) == null) {
                return;
            }
            map.put(StyleConstant.HEADER_CORNER, "9");
        }

        @Override // com.alient.onearch.adapter.loader.v2.GenericPagerLoader
        public void handleItemNode(@NotNull ListIterator<Node> listIterator, @NotNull Node node) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-392773625")) {
                ipChange.ipc$dispatch("-392773625", new Object[]{this, listIterator, node});
                return;
            }
            b41.i(listIterator, "itemIterator");
            b41.i(node, "itemNode");
            ci0.INSTANCE.a(node);
            super.handleItemNode(listIterator, node);
        }

        @Override // com.youku.arch.v3.loader.PageLoader, com.youku.arch.v3.loader.AbsLoader, com.youku.arch.v3.loader.PagingLoader
        public void handleLoadFailure(@NotNull final IResponse iResponse) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1663110976")) {
                ipChange.ipc$dispatch("-1663110976", new Object[]{this, iResponse});
                return;
            }
            b41.i(iResponse, "response");
            if (b41.d(iResponse.getSource(), "remote")) {
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                linkedHashMap.put("reduce", Boolean.TRUE);
                this.this$0.m1253getPageLoader().load(linkedHashMap);
            } else if (b41.d(iResponse.getSource(), Constants.ResponseSource.REMOTE_FILE) && this.this$0.getPageContainer().getChildCount() <= 0) {
                LinkedHashMap linkedHashMap2 = new LinkedHashMap();
                linkedHashMap2.put(Constants.ResponseSource.LOCAL_FILE, Boolean.TRUE);
                this.this$0.m1253getPageLoader().load(linkedHashMap2);
            } else {
                super.handleLoadFailure(iResponse);
                PageContext pageContext = this.this$0.getPageContext();
                final HomePageFragment homePageFragment = this.this$0;
                pageContext.runOnUIThread(new Function0<wt2>() { // from class: cn.damai.homepage.v2.HomePageFragment$HomePageLoader$handleLoadFailure$1
                    private static transient /* synthetic */ IpChange $ipChange;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                        if (AndroidInstantRuntime.support(ipChange2, "-1605838116")) {
                            ipChange2.ipc$dispatch("-1605838116", new Object[]{this});
                            return;
                        }
                        HomePageFragment homePageFragment2 = HomePageFragment.this;
                        homePageFragment2.hideLoadingDialog(homePageFragment2.getActivity());
                        String errorMsg = Util.getErrorMsg(iResponse.getRetCode(), iResponse.getRetMessage());
                        if (HomePageFragment.this.getPageLoader().getRealItemCount() <= 0 || !b41.d(iResponse.getSource(), "remote")) {
                            HomeHeadUiBinder homeHeadUiBinder = HomePageFragment.this.mHomeHeadUiBinder;
                            if (homeHeadUiBinder != null) {
                                homeHeadUiBinder.d();
                            }
                            zr.INSTANCE.a().a("mtop.damai.mec.aristotle.get").h(wy0.patternName).i(wy0.patternVersion).c(iResponse.getRetCode()).d(iResponse.getRetMessage()).g("大麦oneArch新首页").f(false).b();
                            return;
                        }
                        C0537a.i(HomePageFragment.this.requireContext(), errorMsg);
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.youku.arch.v3.loader.PageLoader
        public void handleLoadFinish(@NotNull IResponse iResponse, boolean z, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1234867806")) {
                ipChange.ipc$dispatch("1234867806", new Object[]{this, iResponse, Boolean.valueOf(z), Integer.valueOf(i)});
                return;
            }
            b41.i(iResponse, "response");
            super.handleLoadFinish(iResponse, z, i);
            if (b41.d(iResponse.getSource(), "remote")) {
                cacheRequestData(iResponse);
            }
        }

        @Override // com.alient.onearch.adapter.loader.v2.GenericPagerLoader, com.youku.arch.v3.loader.PageLoader, com.youku.arch.v3.loader.AbsLoader, com.youku.arch.v3.loader.PagingLoader
        public void handleLoadSuccess(@NotNull IResponse iResponse, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1076060100")) {
                ipChange.ipc$dispatch("-1076060100", new Object[]{this, iResponse, Integer.valueOf(i)});
                return;
            }
            b41.i(iResponse, "response");
            PageContext pageContext = this.this$0.getPageContext();
            final HomePageFragment homePageFragment = this.this$0;
            pageContext.runOnUIThread(new Function0<wt2>() { // from class: cn.damai.homepage.v2.HomePageFragment$HomePageLoader$handleLoadSuccess$1
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
                    if (AndroidInstantRuntime.support(ipChange2, "1652990357")) {
                        ipChange2.ipc$dispatch("1652990357", new Object[]{this});
                        return;
                    }
                    HomePageFragment homePageFragment2 = HomePageFragment.this;
                    homePageFragment2.hideLoadingDialog(homePageFragment2.getActivity());
                }
            });
            super.handleLoadSuccess(iResponse, i);
        }

        @Override // com.alient.onearch.adapter.loader.v2.GenericPagerLoader
        public void handlePageBaseInfo(@Nullable String str, @Nullable JSONObject jSONObject, @Nullable JSONObject jSONObject2) {
            List<KeyWord> keywords;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "2110679651")) {
                ipChange.ipc$dispatch("2110679651", new Object[]{this, str, jSONObject, jSONObject2});
                return;
            }
            HomePageGuideBarSearchKeywords homePageGuideBarSearchKeywords = jSONObject != null ? (HomePageGuideBarSearchKeywords) jSONObject.toJavaObject(HomePageGuideBarSearchKeywords.class) : null;
            final ArrayList arrayList = new ArrayList();
            final ArrayList arrayList2 = new ArrayList();
            if (homePageGuideBarSearchKeywords != null && (keywords = homePageGuideBarSearchKeywords.getKeywords()) != null) {
                for (KeyWord keyWord : keywords) {
                    arrayList.add(keyWord.getKeyword());
                    arrayList2.add(keyWord);
                }
            }
            PageContext pageContext = this.this$0.getPageContext();
            final HomePageFragment homePageFragment = this.this$0;
            pageContext.runOnUIThread(new Function0<wt2>() { // from class: cn.damai.homepage.v2.HomePageFragment$HomePageLoader$handlePageBaseInfo$2
                private static transient /* synthetic */ IpChange $ipChange;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                @Nullable
                public final wt2 invoke() {
                    HomePageGuideBar homePageGuideBar;
                    HomePageGuideBar homePageGuideBar2;
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "844327346")) {
                        return (wt2) ipChange2.ipc$dispatch("844327346", new Object[]{this});
                    }
                    homePageGuideBar = HomePageFragment.this.guideBar;
                    if (homePageGuideBar != null) {
                        homePageGuideBar.setSearchText(arrayList, arrayList2);
                    }
                    homePageGuideBar2 = HomePageFragment.this.guideBar;
                    if (homePageGuideBar2 != null) {
                        PageInfoBean topBasePageInfo = HomePageFragment.this.getTopBasePageInfo();
                        homePageGuideBar2.setTrackInfo(topBasePageInfo != null ? topBasePageInfo.action : null, HomePageFragment.this.getUtPageName());
                        return wt2.INSTANCE;
                    }
                    return null;
                }
            });
            super.handlePageBaseInfo(str, jSONObject, jSONObject2);
        }

        @Override // com.youku.arch.v3.loader.PageLoader, com.youku.arch.v3.loader.AbsLoader, com.youku.arch.v3.loader.PagingLoader
        public boolean hasNextPage() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-637400733")) {
                return ((Boolean) ipChange.ipc$dispatch("-637400733", new Object[]{this})).booleanValue();
            }
            return false;
        }

        @Override // com.youku.arch.v3.loader.AbsLoader, com.youku.arch.v3.loader.PagingLoader
        public void load(@NotNull Map<String, ? extends Object> map) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-2060676836")) {
                ipChange.ipc$dispatch("-2060676836", new Object[]{this, map});
                return;
            }
            b41.i(map, com.youku.arch.v3.core.Constants.CONFIG);
            if (this.this$0.getPageContainer().getChildCount() == 0 || map.containsKey("dialogLoading")) {
                HomePageFragment homePageFragment = this.this$0;
                StateViewManager.IStateFeature.DefaultImpls.showLoadingDialog$default(homePageFragment, homePageFragment.getActivity(), null, false, 6, null);
            }
            HashMap hashMap = new HashMap(map);
            if (z20.v()) {
                hashMap.put("reduce", Boolean.TRUE);
            }
            super.load(hashMap);
        }

        @Override // com.alient.onearch.adapter.loader.v2.GenericPagerLoader, com.youku.arch.v3.loader.PageLoader
        @Nullable
        public Node parseNode(@NotNull JSONObject jSONObject) {
            HomeHeadUiBinder homeHeadUiBinder;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-832211594")) {
                return (Node) ipChange.ipc$dispatch("-832211594", new Object[]{this, jSONObject});
            }
            b41.i(jSONObject, "response");
            if (AppConfig.v()) {
                LottieMockHelper.c(jSONObject);
            }
            Node node = null;
            try {
                node = super.parseNode(jSONObject);
            } catch (Exception e) {
                e.printStackTrace();
            }
            boolean d = r8.INSTANCE.d(this.this$0.getPageContext(), node);
            HomePageFragment homePageFragment = this.this$0;
            if (!d && (homeHeadUiBinder = homePageFragment.mHomeHeadUiBinder) != null) {
                homeHeadUiBinder.d();
            }
            Bundle bundle = this.this$0.getPageContext().getBundle();
            if (bundle != null) {
                bundle.putString("initElapsedRealtime", String.valueOf(SystemClock.elapsedRealtime()));
            }
            return node;
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes5.dex */
    public final class HomePageRequestBuilder implements RequestBuilder {
        private static transient /* synthetic */ IpChange $ipChange;
        private long strategy = 3;

        public HomePageRequestBuilder() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: build$lambda-3$lambda-2  reason: not valid java name */
        public static final void m58build$lambda3$lambda2(String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1120748479")) {
                ipChange.ipc$dispatch("1120748479", new Object[]{str});
                return;
            }
            b41.i(str, "$uri");
            ToastUtil a = ToastUtil.a();
            Application a2 = mu0.a();
            a.j(a2, "cdn降级:" + str);
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [android.os.Bundle, T] */
        /* JADX WARN: Type inference failed for: r3v8, types: [android.os.Bundle, T] */
        @Override // com.youku.arch.v3.io.RequestBuilder
        @NotNull
        public IRequest build(@NotNull Map<String, ? extends Object> map) {
            Request a;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-446953984")) {
                return (IRequest) ipChange.ipc$dispatch("-446953984", new Object[]{this, map});
            }
            b41.i(map, com.youku.arch.v3.core.Constants.CONFIG);
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            LinkedHashMap linkedHashMap2 = new LinkedHashMap();
            Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
            ref$ObjectRef.element = new Bundle();
            this.strategy = 2L;
            Object obj = map.get("reload");
            Boolean bool = obj instanceof Boolean ? (Boolean) obj : null;
            if (bool != null && bool.booleanValue()) {
                this.strategy = 2L;
            }
            Object obj2 = map.get("reduce");
            Boolean bool2 = obj2 instanceof Boolean ? (Boolean) obj2 : null;
            if (bool2 != null && bool2.booleanValue()) {
                this.strategy = Constants.RequestStrategy.REMOTE_FILE;
                final String str = "https://oss.taopiaopiao.com/combo/app_home_3.2_bak_" + z20.c() + ".json?v=" + System.currentTimeMillis();
                ?? bundle = new Bundle();
                bundle.putParcelable("uri", Uri.parse(str));
                ref$ObjectRef.element = bundle;
                if (AppConfig.v()) {
                    new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: tb.zx0
                        @Override // java.lang.Runnable
                        public final void run() {
                            HomePageFragment.HomePageRequestBuilder.m58build$lambda3$lambda2(str);
                        }
                    });
                }
            }
            Object obj3 = map.get(Constants.ResponseSource.LOCAL_FILE);
            Boolean bool3 = obj3 instanceof Boolean ? (Boolean) obj3 : null;
            if (bool3 != null) {
                HomePageFragment homePageFragment = HomePageFragment.this;
                if (bool3.booleanValue()) {
                    this.strategy = Constants.RequestStrategy.LOCAL_FILE;
                    Bundle bundle2 = (Bundle) ref$ObjectRef.element;
                    StringBuilder sb = new StringBuilder();
                    sb.append("android.resource://");
                    Context context = homePageFragment.getContext();
                    sb.append(context != null ? context.getPackageName() : null);
                    sb.append("/raw/home_cms_local_data");
                    bundle2.putParcelable("uri", Uri.parse(sb.toString()));
                }
            }
            if (!z20.K()) {
                linkedHashMap2.put("filterComponents", "7541,7542,7543");
            }
            a = wy0.INSTANCE.a(this.strategy, linkedHashMap2, linkedHashMap, (r16 & 8) != 0 ? null : null, (r16 & 16) != 0 ? null : null);
            a.setBundle((Bundle) ref$ObjectRef.element);
            return a;
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes5.dex */
    public final class PageLoadingListener extends LoadingViewAdapter {
        private static transient /* synthetic */ IpChange $ipChange;

        public PageLoadingListener() {
        }

        @Override // com.youku.arch.v3.loader.LoadingViewAdapter, com.youku.arch.v3.loader.ILoadingViewListener
        public void onAllPageLoaded() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1764439217")) {
                ipChange.ipc$dispatch("-1764439217", new Object[]{this});
                return;
            }
            PageContext pageContext = HomePageFragment.this.getPageContext();
            final HomePageFragment homePageFragment = HomePageFragment.this;
            pageContext.runOnUIThread(new Function0<RefreshLayout>() { // from class: cn.damai.homepage.v2.HomePageFragment$PageLoadingListener$onAllPageLoaded$1
                private static transient /* synthetic */ IpChange $ipChange;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @Nullable
                public final RefreshLayout invoke() {
                    RefreshLayout refreshLayout;
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "400257279")) {
                        return (RefreshLayout) ipChange2.ipc$dispatch("400257279", new Object[]{this});
                    }
                    GenericFragment fragment = HomePageFragment.this.getPageContext().getFragment();
                    if (fragment == null || (refreshLayout = fragment.getRefreshLayout()) == null) {
                        return null;
                    }
                    return refreshLayout.setEnableLoadMore(false);
                }
            });
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.homepage.v2.HomePageFragment$a */
    /* loaded from: classes14.dex */
    public static final class C1254a {
        private static transient /* synthetic */ IpChange $ipChange;

        private C1254a() {
        }

        public /* synthetic */ C1254a(k50 k50Var) {
            this();
        }

        @NotNull
        public final HomePageFragment a() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "1230876939") ? (HomePageFragment) ipChange.ipc$dispatch("1230876939", new Object[]{this}) : new HomePageFragment();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void dispatchTabIconUpdate() {
        DamaiTabViewHelper h;
        DamaiTabViewHelper h2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1679989275")) {
            ipChange.ipc$dispatch("-1679989275", new Object[]{this});
            return;
        }
        FragmentActivity activity = getActivity();
        if (activity == null || !(activity instanceof MainActivity)) {
            return;
        }
        if (FeedTabContainer.Companion.a(getGuideBarHeight())) {
            DamaiTabbarManager tabbarManager = ((MainActivity) activity).getTabbarManager();
            if (tabbarManager == null || (h2 = tabbarManager.h()) == null) {
                return;
            }
            h2.i();
            return;
        }
        DamaiTabbarManager tabbarManager2 = ((MainActivity) activity).getTabbarManager();
        if (tabbarManager2 == null || (h = tabbarManager2.h()) == null) {
            return;
        }
        h.h();
    }

    private final void ensureSetUpPageSpmb() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-336818686")) {
            ipChange.ipc$dispatch("-336818686", new Object[]{this});
        } else {
            new PageUtExecutor(getActivity(), new PageUtExecutor.UTKeyBuilderProvider() { // from class: tb.vx0
                @Override // cn.damai.commonbusiness.pageut.PageUtExecutor.UTKeyBuilderProvider
                public final C0525a.C0527b get(int i) {
                    C0525a.C0527b m54ensureSetUpPageSpmb$lambda6;
                    m54ensureSetUpPageSpmb$lambda6 = HomePageFragment.m54ensureSetUpPageSpmb$lambda6(i);
                    return m54ensureSetUpPageSpmb$lambda6;
                }
            }).a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ensureSetUpPageSpmb$lambda-6  reason: not valid java name */
    public static final C0525a.C0527b m54ensureSetUpPageSpmb$lambda6(int i) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "672135750") ? (C0525a.C0527b) ipChange.ipc$dispatch("672135750", new Object[]{Integer.valueOf(i)}) : new C0525a.C0527b().i("home").a(z20.d());
    }

    private final int getGuideBarHeight() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1208343999")) {
            return ((Integer) ipChange.ipc$dispatch("-1208343999", new Object[]{this})).intValue();
        }
        HomePageGuideBar homePageGuideBar = this.guideBar;
        if (homePageGuideBar == null) {
            return 0;
        }
        b41.f(homePageGuideBar);
        return homePageGuideBar.getGuideLayoutHeight();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-5  reason: not valid java name */
    public static final void m55onViewCreated$lambda5() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1928175047")) {
            ipChange.ipc$dispatch("-1928175047", new Object[0]);
            return;
        }
        HomeTabFragment.requestCalendarData();
        nu1.a(new PriorityTask() { // from class: cn.damai.homepage.v2.HomePageFragment$onViewCreated$6$1
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.util.PriorityTask
            public void doTask() {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "171789047")) {
                    ipChange2.ipc$dispatch("171789047", new Object[]{this});
                } else {
                    yi.a(mu0.a());
                }
            }
        });
        HomeConfigRequest.requestAppGlobalConfig();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: scrollToRecommend$lambda-16$lambda-15$lambda-14$lambda-13$lambda-12  reason: not valid java name */
    public static final void m56scrollToRecommend$lambda16$lambda15$lambda14$lambda13$lambda12(RecyclerView recyclerView, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "294734337")) {
            ipChange.ipc$dispatch("294734337", new Object[]{recyclerView, Integer.valueOf(i)});
            return;
        }
        b41.i(recyclerView, "$this_apply");
        RecyclerView.ViewHolder findViewHolderForAdapterPosition = recyclerView.findViewHolderForAdapterPosition(i + 1);
        if (findViewHolderForAdapterPosition != null) {
            recyclerView.scrollBy(0, findViewHolderForAdapterPosition.itemView.getTop() - DisplayUtil.dip2px(recyclerView.getContext(), 42.0f));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: stickyTabScrollTop$lambda-20  reason: not valid java name */
    public static final void m57stickyTabScrollTop$lambda20(HomePageFragment homePageFragment) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-162197654")) {
            ipChange.ipc$dispatch("-162197654", new Object[]{homePageFragment});
            return;
        }
        b41.i(homePageFragment, "this$0");
        homePageFragment.dispatchTabIconUpdate();
    }

    @Override // com.alient.onearch.adapter.BaseFragment
    @NotNull
    public GenericPagerLoader createPageLoader(@NotNull GenericPageContainer genericPageContainer) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1787696919")) {
            return (GenericPagerLoader) ipChange.ipc$dispatch("-1787696919", new Object[]{this, genericPageContainer});
        }
        b41.i(genericPageContainer, "container");
        HomePageLoader homePageLoader = new HomePageLoader(this, genericPageContainer);
        homePageLoader.getLoadingViewManager().addLoadingStateListener(new PageLoadingListener());
        return homePageLoader;
    }

    @Override // com.alient.onearch.adapter.BaseFragment
    @Nullable
    protected RequestBuilder createRequestBuilder(@Nullable Map<String, ? extends Object> map) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1086860306") ? (RequestBuilder) ipChange.ipc$dispatch("-1086860306", new Object[]{this, map}) : new HomePageRequestBuilder();
    }

    @Subscribe(eventType = {r8.KEY_EVENT_ATMOSPHERE_STATE})
    public final void dispatchAtmosphereEvent(@NotNull Event event) {
        HomeHeadUiBinder homeHeadUiBinder;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1600740784")) {
            ipChange.ipc$dispatch("1600740784", new Object[]{this, event});
            return;
        }
        b41.i(event, "event");
        Object obj = event.data;
        StateAtmo stateAtmo = obj instanceof StateAtmo ? (StateAtmo) obj : null;
        if (stateAtmo == null || (homeHeadUiBinder = this.mHomeHeadUiBinder) == null) {
            return;
        }
        homeHeadUiBinder.f(stateAtmo);
    }

    @Subscribe(eventType = {RefreshEvent.ON_REFRESH_STATE_CHANGED, RefreshEvent.ON_HEADER_MOVING})
    public final void dispatchEvent(@NotNull Event event) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1025825394")) {
            ipChange.ipc$dispatch("1025825394", new Object[]{this, event});
            return;
        }
        b41.i(event, "event");
        HomeHeadUiBinder homeHeadUiBinder = this.mHomeHeadUiBinder;
        if (homeHeadUiBinder != null) {
            homeHeadUiBinder.c(event);
        }
    }

    @Subscribe(eventType = {"EventBus://fragment/notification/home/item/follow-request"})
    public final void dispatchFollowEvent(@NotNull Event event) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1976652225")) {
            ipChange.ipc$dispatch("1976652225", new Object[]{this, event});
            return;
        }
        b41.i(event, "event");
        FragmentActivity activity = getActivity();
        b41.g(activity, "null cannot be cast to non-null type cn.damai.homepage.MainActivity");
        Object obj = event.data;
        b41.g(obj, "null cannot be cast to non-null type kotlin.collections.Map<*, *>");
        ((MainActivity) activity).showWantSee((String) ((Map) obj).get("id"));
    }

    @Override // com.alient.onearch.adapter.BaseFragment
    public boolean enableUTReport() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-72769578")) {
            return ((Boolean) ipChange.ipc$dispatch("-72769578", new Object[]{this})).booleanValue();
        }
        return true;
    }

    @Override // com.youku.arch.v3.page.GenericFragment
    @NotNull
    protected String getConfigPath() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-2051313381") ? (String) ipChange.ipc$dispatch("-2051313381", new Object[]{this}) : this.configPath;
    }

    @Override // com.alient.onearch.adapter.BaseFragment, com.youku.arch.v3.page.GenericFragment
    protected int getLayoutResId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1576159936") ? ((Integer) ipChange.ipc$dispatch("-1576159936", new Object[]{this})).intValue() : R$layout.homepage_fragment_v2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.youku.arch.v3.page.GenericFragment
    @NotNull
    public String getPageName() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "2141282062") ? (String) ipChange.ipc$dispatch("2141282062", new Object[]{this}) : this.pageName;
    }

    @Override // com.alient.onearch.adapter.component.header.sticky.StickyHeaderFeature
    @Nullable
    public View getStickyView() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1021562912") ? (View) ipChange.ipc$dispatch("-1021562912", new Object[]{this}) : this.stickyHeaderView;
    }

    @Override // com.alient.onearch.adapter.BaseFragment
    @Nullable
    public String getUtPageName() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "835809037") ? (String) ipChange.ipc$dispatch("835809037", new Object[]{this}) : this.utPageName;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.alient.onearch.adapter.BaseFragment, com.youku.arch.v3.page.GenericFragment
    public void initConfigManager() {
        ConfigManager.CreatorConfig creatorConfig;
        ConfigManager.CreatorConfig creatorConfig2;
        ConfigManager.CreatorConfig creatorConfig3;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "548537991")) {
            ipChange.ipc$dispatch("548537991", new Object[]{this});
            return;
        }
        super.initConfigManager();
        ConfigManager configManager = getPageContext().getConfigManager();
        if (configManager != null && (creatorConfig3 = configManager.getCreatorConfig(2)) != null) {
            creatorConfig3.addCreator(7541, new FeedComponentCreator());
        }
        ConfigManager configManager2 = getPageContext().getConfigManager();
        if (configManager2 != null && (creatorConfig2 = configManager2.getCreatorConfig(2)) != null) {
            creatorConfig2.addCreator(7542, new FeedComponentCreator());
        }
        ConfigManager configManager3 = getPageContext().getConfigManager();
        if (configManager3 == null || (creatorConfig = configManager3.getCreatorConfig(2)) == null) {
            return;
        }
        creatorConfig.addCreator(7543, new FeedComponentCreator());
    }

    @Override // cn.damai.homepage.ui.fragment.FragmentAgent
    public void logoutRefreshUI() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1581152227")) {
            ipChange.ipc$dispatch("-1581152227", new Object[]{this});
            return;
        }
        HomePageGuideBar homePageGuideBar = this.guideBar;
        if (homePageGuideBar != null) {
            homePageGuideBar.logoutUpdateUI();
        }
    }

    @Override // com.alient.onearch.adapter.BaseFragment, com.youku.arch.v3.page.GenericFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "199452743")) {
            ipChange.ipc$dispatch("199452743", new Object[]{this, bundle});
            return;
        }
        HomeFragmentPreloadDelegate homeFragmentPreloadDelegate = qy0.a;
        if (homeFragmentPreloadDelegate != null) {
            if (homeFragmentPreloadDelegate.isInited()) {
                setFragmentPreloadDelegate(homeFragmentPreloadDelegate);
            } else {
                homeFragmentPreloadDelegate.release();
            }
        }
        super.onCreate(bundle);
        getPageContainer().setRequestBuilder(createRequestBuilder(new HashMap()));
        ABTestProvider aBTestProvider = ABTestProvider.INSTANCE;
        tx0 tx0Var = tx0.INSTANCE;
        aBTestProvider.n(tx0Var.d(), Long.valueOf(tx0Var.c()));
        ABTestProvider.k(aBTestProvider, tx0Var.d(), Long.valueOf(tx0Var.c()), tx0.a, null, 8, null);
    }

    @Override // com.alient.onearch.adapter.BaseFragment, com.youku.arch.v3.page.GenericFragment, androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        RecyclerView.Adapter adapter;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "790441568")) {
            ipChange.ipc$dispatch("790441568", new Object[]{this, view, bundle});
            return;
        }
        b41.i(view, "view");
        super.onViewCreated(view, bundle);
        View realView = getRealView();
        this.stickyHeaderView = realView != null ? realView.findViewById(R$id.feed_tab) : null;
        View realView2 = getRealView();
        HomePageGuideBar homePageGuideBar = realView2 != null ? (HomePageGuideBar) realView2.findViewById(R$id.home_page_guide) : null;
        this.guideBar = homePageGuideBar;
        if (homePageGuideBar != null) {
            homePageGuideBar.initDefault(getActivity(), false);
        }
        RefreshLayout refreshLayout = getRefreshLayout();
        if (refreshLayout != null) {
            refreshLayout.setEnableLoadMore(false);
        }
        RefreshLayout refreshLayout2 = getRefreshLayout();
        if (refreshLayout2 != null) {
            refreshLayout2.setEnableRefresh(true);
        }
        RefreshLayout refreshLayout3 = getRefreshLayout();
        if (refreshLayout3 != null) {
            refreshLayout3.setEnableOverScrollBounce(false);
        }
        RefreshInternal refreshHeader = getRefreshHeader();
        SimpleHeader simpleHeader = refreshHeader instanceof SimpleHeader ? (SimpleHeader) refreshHeader : null;
        if (simpleHeader != null) {
            simpleHeader.setVisibility(4);
            simpleHeader.setId(R$id.one_arch_header);
            simpleHeader.getView().setPadding(0, com.youku.arch.v3.util.DisplayUtil.dip2px(getActivity(), 12.0f), 0, com.youku.arch.v3.util.DisplayUtil.dip2px(getActivity(), 18.0f));
        }
        RecyclerView recyclerView = getRecyclerView();
        if (recyclerView != null) {
            recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: cn.damai.homepage.v2.HomePageFragment$onViewCreated$2
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
                public void onScrollStateChanged(@NotNull RecyclerView recyclerView2, int i) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "1702048019")) {
                        ipChange2.ipc$dispatch("1702048019", new Object[]{this, recyclerView2, Integer.valueOf(i)});
                        return;
                    }
                    b41.i(recyclerView2, "recyclerView");
                    if (i == 0) {
                        HomePageFragment.this.dispatchTabIconUpdate();
                    }
                }
            });
        }
        this.mHomeHeadUiBinder = new HomeHeadUiBinder(getRealView(), this.guideBar, getRecyclerView());
        ensureSetUpPageSpmb();
        ContentAdapter contentAdapter = getPageContainer().getContentAdapter();
        if ((contentAdapter.getAdaptersCount() > 0 ? contentAdapter : null) != null) {
            getPageLoader().getLoadingViewManager().onSuccess();
            getPageContainer().updateContentAdapter();
            RecyclerView recyclerView2 = getRecyclerView();
            if (recyclerView2 != null && (adapter = recyclerView2.getAdapter()) != null) {
                adapter.notifyDataSetChanged();
            }
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("index", 1);
            linkedHashMap.put("reload", Boolean.TRUE);
            load(linkedHashMap);
        } else {
            load(new LinkedHashMap());
        }
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: tb.yx0
            @Override // java.lang.Runnable
            public final void run() {
                HomePageFragment.m55onViewCreated$lambda5();
            }
        }, 1000L);
    }

    @Override // cn.damai.homepage.ui.fragment.FragmentAgent
    public void refreshAllFragment() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "176041042")) {
            ipChange.ipc$dispatch("176041042", new Object[]{this});
        } else {
            refreshHomeFragment(true);
        }
    }

    @Override // cn.damai.homepage.ui.fragment.FragmentAgent
    public void refreshHomeFragment(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "438717660")) {
            ipChange.ipc$dispatch("438717660", new Object[]{this, Boolean.valueOf(z)});
        } else if (!isFragmentVisible() || getRecyclerView() == null) {
        } else {
            RecyclerView recyclerView = getRecyclerView();
            if (recyclerView != null && recyclerView.canScrollVertically(-1)) {
                recyclerView.scrollToPosition(0);
            }
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            if (z) {
                linkedHashMap.put("dialogLoading", Boolean.TRUE);
            }
            linkedHashMap.put("reload", Boolean.TRUE);
            load(linkedHashMap);
        }
    }

    @Override // cn.damai.homepage.ui.fragment.FragmentAgent
    public void scrollToRecommend() {
        final int realPositionForAdapter;
        final RecyclerView recyclerView;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2136489138")) {
            ipChange.ipc$dispatch("-2136489138", new Object[]{this});
        } else if (r92.c()) {
        } else {
            RecyclerView recyclerView2 = getRecyclerView();
            if (recyclerView2 != null && (recyclerView2 instanceof NestedRecyclerView)) {
                ((NestedRecyclerView) recyclerView2).stopDispatchScrollUtilIdle();
            }
            if (getActivity() == null || getRecyclerView() == null) {
                return;
            }
            Iterator<T> it = getPageContainer().getModules().iterator();
            while (it.hasNext()) {
                IModule iModule = (IModule) it.next();
                if (iModule != null) {
                    Iterator<T> it2 = iModule.getComponents().iterator();
                    while (true) {
                        if (it2.hasNext()) {
                            IComponent iComponent = (IComponent) it2.next();
                            if (iComponent.getType() == 9990) {
                                VBaseAdapter<IItem<ItemValue>, VBaseHolder<IItem<ItemValue>, GenericRenderConfig>> adapter = iComponent.getAdapter();
                                if (adapter != null && (realPositionForAdapter = getRealPositionForAdapter(getPageContainer().getContentAdapter(), adapter)) > 0 && (recyclerView = getRecyclerView()) != null) {
                                    recyclerView.scrollToPosition(realPositionForAdapter + 1);
                                    recyclerView.post(new Runnable() { // from class: tb.wx0
                                        @Override // java.lang.Runnable
                                        public final void run() {
                                            HomePageFragment.m56scrollToRecommend$lambda16$lambda15$lambda14$lambda13$lambda12(RecyclerView.this, realPositionForAdapter);
                                        }
                                    });
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    @Override // cn.damai.homepage.ui.fragment.FragmentAgent
    public void scrollToTop() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-927984683")) {
            ipChange.ipc$dispatch("-927984683", new Object[]{this});
            return;
        }
        RecyclerView recyclerView = getRecyclerView();
        if (recyclerView == null || recyclerView.getAdapter() == null || recyclerView.getLayoutManager() == null || recyclerView.getChildAt(0) == null) {
            return;
        }
        if ((recyclerView instanceof NestedRecyclerView) && recyclerView.canScrollVertically(-1)) {
            ((NestedRecyclerView) recyclerView).stopDispatchScrollUtilIdle();
        }
        recyclerView.smoothScrollToPosition(0);
    }

    @Override // com.alient.onearch.adapter.BaseFragment
    public void setUtPageName(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1969607055")) {
            ipChange.ipc$dispatch("-1969607055", new Object[]{this, str});
        } else {
            this.utPageName = str;
        }
    }

    @Subscribe(eventType = {FeedTabContainer.STICKY_SCROLL_TOP})
    public final void stickyTabScrollTop(@NotNull Event event) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "161605288")) {
            ipChange.ipc$dispatch("161605288", new Object[]{this, event});
            return;
        }
        b41.i(event, "event");
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: tb.xx0
            @Override // java.lang.Runnable
            public final void run() {
                HomePageFragment.m57stickyTabScrollTop$lambda20(HomePageFragment.this);
            }
        }, 50L);
    }

    @Override // com.alient.onearch.adapter.BaseFragment, com.youku.arch.v3.page.GenericFragment
    @Nullable
    public List<IDelegate<GenericFragment>> wrapperDelegates(@Nullable List<IDelegate<GenericFragment>> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-922614871")) {
            return (List) ipChange.ipc$dispatch("-922614871", new Object[]{this, list});
        }
        List<IDelegate<GenericFragment>> wrapperDelegates = super.wrapperDelegates(list);
        if (wrapperDelegates == null) {
            wrapperDelegates = new ArrayList<>();
        }
        wrapperDelegates.add(new AutoLoadMoreDelegate());
        return wrapperDelegates;
    }
}
