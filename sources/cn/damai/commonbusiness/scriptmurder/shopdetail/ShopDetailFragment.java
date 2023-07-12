package cn.damai.commonbusiness.scriptmurder.shopdetail;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import cn.damai.common.AppConfig;
import cn.damai.common.net.mtop.Util;
import cn.damai.common.util.toastutil.C0537a;
import cn.damai.commonbusiness.R$id;
import cn.damai.commonbusiness.R$layout;
import cn.damai.commonbusiness.scriptmurder.CommonNavbarActivity;
import cn.damai.commonbusiness.scriptmurder.shopdetail.ShopDetailFragment;
import cn.damai.live.LiveActivity;
import cn.damai.uikit.refresh.footer.SimpleHeader;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.pictures.bricks.component.scriptmurder.GenericBannerPresenterExt;
import com.alient.onearch.adapter.BaseFragment;
import com.alient.onearch.adapter.GenericPageContainer;
import com.alient.onearch.adapter.component.divider.DividerModel;
import com.alient.onearch.adapter.component.footer.v2.GenericFooterPresent;
import com.alient.onearch.adapter.component.header.sticky.StickyHeaderFeature;
import com.alient.onearch.adapter.decorate.ComponentDecorateItem;
import com.alient.onearch.adapter.loader.v2.GenericPagerLoader;
import com.alient.onearch.adapter.state.StateViewManager;
import com.alient.onearch.adapter.style.StyleConstant;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.scwang.smartrefresh.layout.api.RefreshInternal;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.taobao.weex.common.Constants;
import com.ut.device.UTDevice;
import com.youku.arch.v3.core.ModelValue;
import com.youku.arch.v3.core.Node;
import com.youku.arch.v3.core.PageContainer;
import com.youku.arch.v3.core.PageContext;
import com.youku.arch.v3.data.Constants;
import com.youku.arch.v3.data.Request;
import com.youku.arch.v3.io.IRequest;
import com.youku.arch.v3.io.IResponse;
import com.youku.arch.v3.io.RequestBuilder;
import com.youku.arch.v3.page.state.State;
import com.youku.arch.v3.util.ColorUtil;
import com.youku.arch.v3.util.IdGenerator;
import com.youku.kubus.Event;
import com.youku.kubus.Subscribe;
import com.youku.live.livesdk.model.mtop.LiveFullInfo;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.ir1;
import tb.k50;
import tb.mr1;
import tb.wt2;
import tb.z20;

/* compiled from: Taobao */
/* loaded from: classes4.dex */
public final class ShopDetailFragment extends BaseFragment implements StickyHeaderFeature {
    private static transient /* synthetic */ IpChange $ipChange = null;
    @NotNull
    public static final C0802a Companion = new C0802a(null);
    public static final boolean NEED_ENCODE = false;
    public static final boolean NEED_SESSION = false;
    @NotNull
    public static final String VERSION = "2.0";
    @Nullable
    private View stickyHeader;
    @Nullable
    private String storeId;
    @NotNull
    private final String pageName = "ShopDetail";
    @NotNull
    private final String configPath = "://commonbusiness/raw/script_murder_shop_detail_component_config";
    @NotNull
    private final Handler refreshHeaderHandler = new Handler();

    /* compiled from: Taobao */
    /* loaded from: classes4.dex */
    public final class ShopDetailLoader extends GenericPagerLoader {
        private static transient /* synthetic */ IpChange $ipChange;
        @NotNull
        private final JSONObject dividerComponentData;
        final /* synthetic */ ShopDetailFragment this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ShopDetailLoader(@NotNull ShopDetailFragment shopDetailFragment, PageContainer<ModelValue> pageContainer) {
            super(pageContainer);
            b41.i(pageContainer, "pageContainer");
            this.this$0 = shopDetailFragment;
            JSONObject jSONObject = new JSONObject();
            this.dividerComponentData = jSONObject;
            jSONObject.put((JSONObject) DividerModel.DIVIDER_COLOR, "#F5F6F7");
            ComponentDecorateItem.Indexer indexer = ComponentDecorateItem.Indexer.After;
            addComponentDecorate(7506, new ComponentDecorateItem(9993, 9993, jSONObject, indexer));
            addComponentDecorate(7516, new ComponentDecorateItem(9993, 9993, jSONObject, indexer));
            addComponentDecorate(7520, new ComponentDecorateItem(9993, 9993, jSONObject, indexer));
            addComponentDecorate(7526, new ComponentDecorateItem(9993, 9993, jSONObject, indexer));
            addComponentDecorate(7503, new ComponentDecorateItem(9993, 9993, jSONObject, indexer));
        }

        @Override // com.alient.onearch.adapter.loader.v2.GenericPagerLoader
        public void handleFooterItemProperty(@NotNull Node node, @NotNull Node node2) {
            JSONObject data;
            Object obj;
            JSONObject data2;
            JSONObject data3;
            JSONObject data4;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-379511963")) {
                ipChange.ipc$dispatch("-379511963", new Object[]{this, node, node2});
                return;
            }
            b41.i(node, "componentNode");
            b41.i(node2, "itemNode");
            if (node.getType() == 7507) {
                List<Node> children = node.getChildren();
                if (children == null || (data4 = node2.getData()) == null) {
                    return;
                }
                data4.put((JSONObject) GenericFooterPresent.KEY_EXPEND_CONTENT, "展开全部" + children.size() + "个商品");
                data4.put((JSONObject) GenericFooterPresent.KEY_COLLAPSE_CONTENT, "收起");
                data4.put((JSONObject) StyleConstant.FOOTER_TEXT_COLOR, "#30AEFF");
            } else if (node.getType() == 7520) {
                List<Node> children2 = node.getChildren();
                if (children2 == null || (data3 = node2.getData()) == null) {
                    return;
                }
                data3.put((JSONObject) GenericFooterPresent.KEY_EXPEND_CONTENT, "展开全部" + children2.size() + "个商品");
                data3.put((JSONObject) GenericFooterPresent.KEY_COLLAPSE_CONTENT, "收起");
                data3.put((JSONObject) StyleConstant.FOOTER_TEXT_COLOR, "#30AEFF");
            } else if (node.getType() != 7516 || (data = node.getData()) == null || (obj = data.get(Constants.TOTAL_NUM)) == null || (data2 = node2.getData()) == null) {
            } else {
                data2.put((JSONObject) GenericFooterPresent.KEY_EXPEND_CONTENT, "查看全部" + obj + "个剧本");
                data2.put((JSONObject) GenericFooterPresent.KEY_COLLAPSE_CONTENT, "收起");
                data2.put((JSONObject) StyleConstant.FOOTER_TEXT_COLOR, "#30AEFF");
            }
        }

        @Override // com.alient.onearch.adapter.loader.v2.GenericPagerLoader
        public void handleHeaderItemProperty(@NotNull Node node, @NotNull Node node2) {
            JSONObject data;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-790106445")) {
                ipChange.ipc$dispatch("-790106445", new Object[]{this, node, node2});
                return;
            }
            b41.i(node, "componentNode");
            b41.i(node2, "itemNode");
            if (node.getType() != 7503 || (data = node2.getData()) == null) {
                return;
            }
            data.put((JSONObject) StyleConstant.HEADER_RIGHT_TEXT_COLOR, "#999999");
        }

        @Override // com.youku.arch.v3.loader.PageLoader, com.youku.arch.v3.loader.AbsLoader, com.youku.arch.v3.loader.PagingLoader
        public void handleLoadFailure(@NotNull final IResponse iResponse) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1055620289")) {
                ipChange.ipc$dispatch("-1055620289", new Object[]{this, iResponse});
                return;
            }
            b41.i(iResponse, "response");
            super.handleLoadFailure(iResponse);
            final FragmentActivity activity = this.this$0.getActivity();
            if (activity != null) {
                final ShopDetailFragment shopDetailFragment = this.this$0;
                shopDetailFragment.getPageContext().runOnUIThread(new Function0<wt2>() { // from class: cn.damai.commonbusiness.scriptmurder.shopdetail.ShopDetailFragment$ShopDetailLoader$handleLoadFailure$1$1
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
                        if (AndroidInstantRuntime.support(ipChange2, "-708150966")) {
                            ipChange2.ipc$dispatch("-708150966", new Object[]{this});
                            return;
                        }
                        ShopDetailFragment.this.hideLoadingDialog(activity);
                        String errorMsg = Util.getErrorMsg(iResponse.getRetCode(), iResponse.getRetMessage());
                        if (ShopDetailFragment.this.getPageLoader().getRealItemCount() > 0) {
                            C0537a.i(activity, errorMsg);
                        } else {
                            ShopDetailFragment.this.getPageStateManager().setState(State.FAILED);
                        }
                    }
                });
            }
        }

        @Override // com.alient.onearch.adapter.loader.v2.GenericPagerLoader, com.youku.arch.v3.loader.PageLoader, com.youku.arch.v3.loader.AbsLoader, com.youku.arch.v3.loader.PagingLoader
        public void handleLoadSuccess(@NotNull IResponse iResponse, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "576282013")) {
                ipChange.ipc$dispatch("576282013", new Object[]{this, iResponse, Integer.valueOf(i)});
                return;
            }
            b41.i(iResponse, "response");
            PageContext pageContext = this.this$0.getPageContext();
            final ShopDetailFragment shopDetailFragment = this.this$0;
            pageContext.runOnUIThread(new Function0<wt2>() { // from class: cn.damai.commonbusiness.scriptmurder.shopdetail.ShopDetailFragment$ShopDetailLoader$handleLoadSuccess$1
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
                    if (AndroidInstantRuntime.support(ipChange2, "1885745654")) {
                        ipChange2.ipc$dispatch("1885745654", new Object[]{this});
                        return;
                    }
                    ShopDetailFragment shopDetailFragment2 = ShopDetailFragment.this;
                    shopDetailFragment2.hideLoadingDialog(shopDetailFragment2.getActivity());
                }
            });
            FragmentActivity activity = this.this$0.getActivity();
            ShopDetailActivity shopDetailActivity = activity instanceof ShopDetailActivity ? (ShopDetailActivity) activity : null;
            if (shopDetailActivity != null) {
                shopDetailActivity.onRefresh();
            }
            super.handleLoadSuccess(iResponse, i);
        }

        @Override // com.youku.arch.v3.loader.AbsLoader, com.youku.arch.v3.loader.PagingLoader
        public void load(@NotNull Map<String, ? extends Object> map) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1082508325")) {
                ipChange.ipc$dispatch("-1082508325", new Object[]{this, map});
                return;
            }
            b41.i(map, com.youku.arch.v3.core.Constants.CONFIG);
            super.load(map);
            Object obj = map.get("reload");
            if (b41.d(obj instanceof Boolean ? (Boolean) obj : null, Boolean.TRUE)) {
                return;
            }
            ShopDetailFragment shopDetailFragment = this.this$0;
            StateViewManager.IStateFeature.DefaultImpls.showLoadingDialog$default(shopDetailFragment, shopDetailFragment.getActivity(), null, false, 6, null);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes4.dex */
    public final class ShopDetailRequestBuilder implements RequestBuilder {
        private static transient /* synthetic */ IpChange $ipChange;
        @NotNull
        private Map<String, Object> params = new LinkedHashMap();
        private long strategy = 2;

        public ShopDetailRequestBuilder() {
        }

        @Override // com.youku.arch.v3.io.RequestBuilder
        @NotNull
        public IRequest build(@NotNull Map<String, ? extends Object> map) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1078341023")) {
                return (IRequest) ipChange.ipc$dispatch("-1078341023", new Object[]{this, map});
            }
            b41.i(map, com.youku.arch.v3.core.Constants.CONFIG);
            this.params.put("patternName", "dm_app_script_store");
            this.params.put("patternVersion", LiveFullInfo.VER);
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            String utdid = UTDevice.getUtdid(ShopDetailFragment.this.getContext());
            b41.h(utdid, "getUtdid(context)");
            linkedHashMap.put("utdid", utdid);
            String c = z20.c();
            b41.h(c, "getCityId()");
            linkedHashMap.put("comboDamaiCityId", c);
            if (ir1.i(mr1.LOCATION)) {
                linkedHashMap.put("latitude", Double.valueOf(z20.n()));
                linkedHashMap.put("longitude", Double.valueOf(z20.o()));
            }
            String p = AppConfig.p();
            b41.h(p, "getTtid()");
            linkedHashMap.put(LiveActivity.OPTION_TTID, p);
            linkedHashMap.put("comboChannel", "1");
            linkedHashMap.put("pageIndex", "1");
            linkedHashMap.put(Constants.Name.PAGE_SIZE, 15);
            String storeId = ShopDetailFragment.this.getStoreId();
            if (storeId != null) {
                linkedHashMap.put("storeId", storeId);
            }
            Map<String, Object> map2 = this.params;
            String jSONString = JSON.toJSONString(linkedHashMap);
            b41.h(jSONString, "toJSONString(args)");
            map2.put("args", jSONString);
            return new Request.Builder().setApiName("mtop.damai.mec.aristotle.get").setVersion("2.0").setNeedECode(false).setNeedSession(false).setTimeout(10000).setStrategy(this.strategy).setRequestId(IdGenerator.getId()).setDataParams(new HashMap(this.params)).build();
        }

        @NotNull
        public final Map<String, Object> getParams() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "504809242") ? (Map) ipChange.ipc$dispatch("504809242", new Object[]{this}) : this.params;
        }

        public final long getStrategy() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "91088652") ? ((Long) ipChange.ipc$dispatch("91088652", new Object[]{this})).longValue() : this.strategy;
        }

        public final void setParams(@NotNull Map<String, Object> map) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1280347212")) {
                ipChange.ipc$dispatch("1280347212", new Object[]{this, map});
                return;
            }
            b41.i(map, "<set-?>");
            this.params = map;
        }

        public final void setStrategy(long j) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-560435784")) {
                ipChange.ipc$dispatch("-560435784", new Object[]{this, Long.valueOf(j)});
            } else {
                this.strategy = j;
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.commonbusiness.scriptmurder.shopdetail.ShopDetailFragment$a */
    /* loaded from: classes4.dex */
    public static final class C0802a {
        private C0802a() {
        }

        public /* synthetic */ C0802a(k50 k50Var) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onMessageGet$lambda-3$lambda-2  reason: not valid java name */
    public static final void m21onMessageGet$lambda3$lambda2(ShopDetailFragment shopDetailFragment, Event event) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2027449155")) {
            ipChange.ipc$dispatch("-2027449155", new Object[]{shopDetailFragment, event});
            return;
        }
        b41.i(shopDetailFragment, "this$0");
        b41.i(event, "$event");
        Object obj = event.data;
        shopDetailFragment.fireComponentEvent(GenericBannerPresenterExt.MSG_BANNER_BG_UPDATE, obj instanceof Map ? (Map) obj : null);
    }

    private final void updateRefreshHeaderBgColor(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1045337630")) {
            ipChange.ipc$dispatch("-1045337630", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        RefreshInternal refreshHeader = getRefreshHeader();
        SimpleHeader simpleHeader = refreshHeader instanceof SimpleHeader ? (SimpleHeader) refreshHeader : null;
        if (simpleHeader != null) {
            simpleHeader.setBackgroundColor(i);
        }
    }

    @Override // com.alient.onearch.adapter.BaseFragment
    @NotNull
    public GenericPagerLoader createPageLoader(@NotNull GenericPageContainer genericPageContainer) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1876390001")) {
            return (GenericPagerLoader) ipChange.ipc$dispatch("1876390001", new Object[]{this, genericPageContainer});
        }
        b41.i(genericPageContainer, "container");
        ShopDetailLoader shopDetailLoader = new ShopDetailLoader(this, genericPageContainer);
        shopDetailLoader.addComponentDisplayLimit(7507, 5);
        return shopDetailLoader;
    }

    @Override // com.alient.onearch.adapter.BaseFragment
    @NotNull
    protected RequestBuilder createRequestBuilder(@Nullable Map<String, ? extends Object> map) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-721040010") ? (RequestBuilder) ipChange.ipc$dispatch("-721040010", new Object[]{this, map}) : new ShopDetailRequestBuilder();
    }

    @Override // com.youku.arch.v3.page.GenericFragment
    @NotNull
    protected String getConfigPath() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1598094995") ? (String) ipChange.ipc$dispatch("1598094995", new Object[]{this}) : this.configPath;
    }

    @Override // com.alient.onearch.adapter.BaseFragment, com.youku.arch.v3.page.GenericFragment
    protected int getLayoutResId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1735576904") ? ((Integer) ipChange.ipc$dispatch("-1735576904", new Object[]{this})).intValue() : R$layout.fragment_script_murder_shop_detail;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.youku.arch.v3.page.GenericFragment
    @NotNull
    public String getPageName() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-308548986") ? (String) ipChange.ipc$dispatch("-308548986", new Object[]{this}) : this.pageName;
    }

    @NotNull
    public final Handler getRefreshHeaderHandler() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1515013844") ? (Handler) ipChange.ipc$dispatch("1515013844", new Object[]{this}) : this.refreshHeaderHandler;
    }

    @Override // com.alient.onearch.adapter.component.header.sticky.StickyHeaderFeature
    @Nullable
    public View getStickyView() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "440947048") ? (View) ipChange.ipc$dispatch("440947048", new Object[]{this}) : this.stickyHeader;
    }

    @Nullable
    public final String getStoreId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1431489926") ? (String) ipChange.ipc$dispatch("1431489926", new Object[]{this}) : this.storeId;
    }

    @Override // com.alient.onearch.adapter.BaseFragment, com.youku.arch.v3.page.GenericFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        Bundle bundle2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "120425935")) {
            ipChange.ipc$dispatch("120425935", new Object[]{this, bundle});
            return;
        }
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        String string = arguments != null ? arguments.getString("storeId") : null;
        this.storeId = string;
        if (string == null || (bundle2 = getPageContext().getBundle()) == null) {
            return;
        }
        bundle2.putString("storeId", string);
    }

    @Subscribe(eventType = {GenericBannerPresenterExt.MSG_BANNER_DETACHED, GenericBannerPresenterExt.MSG_BANNER_ATTACHED, GenericBannerPresenterExt.MSG_BANNER_BG_UPDATE, "EventBus://business/notification/scriptMurder/get_header_info"})
    public final void onMessageGet(@NotNull final Event event) {
        Object obj;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1914030274")) {
            ipChange.ipc$dispatch("1914030274", new Object[]{this, event});
            return;
        }
        b41.i(event, "event");
        String str = event.type;
        if (str != null) {
            switch (str.hashCode()) {
                case -1469126409:
                    if (str.equals(GenericBannerPresenterExt.MSG_BANNER_BG_UPDATE)) {
                        Object obj2 = event.data;
                        Map map = obj2 instanceof Map ? (Map) obj2 : null;
                        if (map == null || (obj = map.get("color")) == null) {
                            return;
                        }
                        FragmentActivity activity = getActivity();
                        CommonNavbarActivity commonNavbarActivity = activity instanceof CommonNavbarActivity ? (CommonNavbarActivity) activity : null;
                        if (commonNavbarActivity != null) {
                            commonNavbarActivity.setNavBarColor(((Integer) obj).intValue());
                        }
                        updateRefreshHeaderBgColor(((Integer) obj).intValue());
                        this.refreshHeaderHandler.postDelayed(new Runnable() { // from class: tb.dc2
                            @Override // java.lang.Runnable
                            public final void run() {
                                ShopDetailFragment.m21onMessageGet$lambda3$lambda2(ShopDetailFragment.this, event);
                            }
                        }, 30L);
                        return;
                    }
                    return;
                case -938649949:
                    if (str.equals("EventBus://business/notification/scriptMurder/get_header_info")) {
                        Object obj3 = event.data;
                        HashMap hashMap = obj3 instanceof HashMap ? (HashMap) obj3 : null;
                        if (hashMap != null) {
                            FragmentActivity activity2 = getActivity();
                            CommonNavbarActivity commonNavbarActivity2 = activity2 instanceof CommonNavbarActivity ? (CommonNavbarActivity) activity2 : null;
                            if (commonNavbarActivity2 != null) {
                                commonNavbarActivity2.onHeaderInfoUpdate(hashMap);
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    return;
                case 1462675504:
                    if (str.equals(GenericBannerPresenterExt.MSG_BANNER_ATTACHED)) {
                        FragmentActivity activity3 = getActivity();
                        ShopDetailActivity shopDetailActivity = activity3 instanceof ShopDetailActivity ? (ShopDetailActivity) activity3 : null;
                        if (shopDetailActivity != null) {
                            shopDetailActivity.stopWithCheck();
                            return;
                        }
                        return;
                    }
                    return;
                case 1968485886:
                    if (str.equals(GenericBannerPresenterExt.MSG_BANNER_DETACHED)) {
                        FragmentActivity activity4 = getActivity();
                        ShopDetailActivity shopDetailActivity2 = activity4 instanceof ShopDetailActivity ? (ShopDetailActivity) activity4 : null;
                        if (shopDetailActivity2 != null) {
                            shopDetailActivity2.startWithCheck();
                            return;
                        }
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    @Override // com.alient.onearch.adapter.BaseFragment, com.youku.arch.v3.page.GenericFragment, androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1590608920")) {
            ipChange.ipc$dispatch("-1590608920", new Object[]{this, view, bundle});
            return;
        }
        b41.i(view, "view");
        super.onViewCreated(view, bundle);
        RefreshLayout refreshLayout = getRefreshLayout();
        if (refreshLayout != null) {
            refreshLayout.setEnableLoadMore(false);
        }
        View realView = getRealView();
        this.stickyHeader = realView != null ? realView.findViewById(R$id.sticky_header) : null;
        RefreshInternal refreshHeader = getRefreshHeader();
        SimpleHeader simpleHeader = refreshHeader instanceof SimpleHeader ? (SimpleHeader) refreshHeader : null;
        if (simpleHeader != null) {
            simpleHeader.setBackgroundColor(ColorUtil.parseColorSafely("#825542"));
        }
        load(new LinkedHashMap());
    }

    public final void setStoreId(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-189738832")) {
            ipChange.ipc$dispatch("-189738832", new Object[]{this, str});
        } else {
            this.storeId = str;
        }
    }
}
