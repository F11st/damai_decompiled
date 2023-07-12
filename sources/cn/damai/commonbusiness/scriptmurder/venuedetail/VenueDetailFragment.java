package cn.damai.commonbusiness.scriptmurder.venuedetail;

import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import cn.damai.common.AppConfig;
import cn.damai.common.net.mtop.Util;
import cn.damai.common.util.toastutil.a;
import cn.damai.commonbusiness.R$id;
import cn.damai.commonbusiness.R$layout;
import cn.damai.commonbusiness.scriptmurder.CommonNavbarActivity;
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
import com.youku.arch.v3.core.Constants;
import com.youku.arch.v3.core.ModelValue;
import com.youku.arch.v3.core.Node;
import com.youku.arch.v3.core.PageContainer;
import com.youku.arch.v3.core.PageContext;
import com.youku.arch.v3.data.Request;
import com.youku.arch.v3.io.IRequest;
import com.youku.arch.v3.io.IResponse;
import com.youku.arch.v3.io.RequestBuilder;
import com.youku.arch.v3.page.state.State;
import com.youku.arch.v3.util.ColorUtil;
import com.youku.arch.v3.util.IdGenerator;
import com.youku.kubus.Event;
import com.youku.kubus.Subscribe;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ListIterator;
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
public final class VenueDetailFragment extends BaseFragment implements StickyHeaderFeature {
    private static transient /* synthetic */ IpChange $ipChange = null;
    @NotNull
    public static final a Companion = new a(null);
    public static final boolean NEED_ENCODE = false;
    public static final boolean NEED_SESSION = false;
    @NotNull
    public static final String VENUE_ID = "venueId";
    @NotNull
    public static final String VERSION = "2.0";
    @Nullable
    private View stickyHeader;
    @Nullable
    private String venueId;
    @NotNull
    private final JSONObject dividerComponentData = new JSONObject();
    @NotNull
    private final String pageName = "VenueDetail";
    @NotNull
    private final String configPath = "://commonbusiness/raw/script_murder_venue_detail_component_config";

    /* compiled from: Taobao */
    /* loaded from: classes4.dex */
    public final class VenueDetailLoader extends GenericPagerLoader {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ VenueDetailFragment this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public VenueDetailLoader(@NotNull VenueDetailFragment venueDetailFragment, PageContainer<ModelValue> pageContainer) {
            super(pageContainer);
            b41.i(pageContainer, "pageContainer");
            this.this$0 = venueDetailFragment;
            venueDetailFragment.dividerComponentData.put((JSONObject) DividerModel.DIVIDER_COLOR, "#F5F6F7");
            addComponentDecorate(9996, new ComponentDecorateItem(9993, 9993, venueDetailFragment.dividerComponentData, ComponentDecorateItem.Indexer.Before));
            JSONObject jSONObject = venueDetailFragment.dividerComponentData;
            ComponentDecorateItem.Indexer indexer = ComponentDecorateItem.Indexer.After;
            addComponentDecorate(7502, new ComponentDecorateItem(9993, 9993, jSONObject, indexer));
            addComponentDecorate(7503, new ComponentDecorateItem(9993, 9993, venueDetailFragment.dividerComponentData, indexer));
        }

        @Override // com.alient.onearch.adapter.loader.v2.GenericPagerLoader
        public void handleComponentNode(@NotNull ListIterator<Node> listIterator, @NotNull Node node) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "925542487")) {
                ipChange.ipc$dispatch("925542487", new Object[]{this, listIterator, node});
                return;
            }
            b41.i(listIterator, "componentIterator");
            b41.i(node, "componentNode");
            if (node.getType() == 9996) {
                node.setData(new JSONObject());
            }
            super.handleComponentNode(listIterator, node);
        }

        @Override // com.alient.onearch.adapter.loader.v2.GenericPagerLoader
        public void handleFooterItemProperty(@NotNull Node node, @NotNull Node node2) {
            List<Node> children;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "381043014")) {
                ipChange.ipc$dispatch("381043014", new Object[]{this, node, node2});
                return;
            }
            b41.i(node, "componentNode");
            b41.i(node2, "itemNode");
            if (node.getType() != 7502 || (children = node.getChildren()) == null) {
                return;
            }
            JSONObject data = node2.getData();
            if (data != null) {
                data.put((JSONObject) GenericFooterPresent.KEY_EXPEND_CONTENT, "展开全部" + children.size() + "场演出");
            }
            JSONObject data2 = node2.getData();
            if (data2 != null) {
                data2.put((JSONObject) GenericFooterPresent.KEY_COLLAPSE_CONTENT, "收起");
            }
        }

        @Override // com.alient.onearch.adapter.loader.v2.GenericPagerLoader
        public void handleHeaderItemProperty(@NotNull Node node, @NotNull Node node2) {
            JSONObject data;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-29551468")) {
                ipChange.ipc$dispatch("-29551468", new Object[]{this, node, node2});
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
            if (AndroidInstantRuntime.support(ipChange, "2083674430")) {
                ipChange.ipc$dispatch("2083674430", new Object[]{this, iResponse});
                return;
            }
            b41.i(iResponse, "response");
            super.handleLoadFailure(iResponse);
            final FragmentActivity activity = this.this$0.getActivity();
            if (activity != null) {
                final VenueDetailFragment venueDetailFragment = this.this$0;
                venueDetailFragment.getPageContext().runOnUIThread(new Function0<wt2>() { // from class: cn.damai.commonbusiness.scriptmurder.venuedetail.VenueDetailFragment$VenueDetailLoader$handleLoadFailure$1$1
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
                        if (AndroidInstantRuntime.support(ipChange2, "-225705493")) {
                            ipChange2.ipc$dispatch("-225705493", new Object[]{this});
                            return;
                        }
                        VenueDetailFragment.this.hideLoadingDialog(activity);
                        String errorMsg = Util.getErrorMsg(iResponse.getRetCode(), iResponse.getRetMessage());
                        if (VenueDetailFragment.this.getPageLoader().getRealItemCount() > 0) {
                            a.i(activity, errorMsg);
                        } else {
                            VenueDetailFragment.this.getPageStateManager().setState(State.FAILED);
                        }
                    }
                });
            }
        }

        @Override // com.alient.onearch.adapter.loader.v2.GenericPagerLoader, com.youku.arch.v3.loader.PageLoader, com.youku.arch.v3.loader.AbsLoader, com.youku.arch.v3.loader.PagingLoader
        public void handleLoadSuccess(@NotNull IResponse iResponse, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-889829506")) {
                ipChange.ipc$dispatch("-889829506", new Object[]{this, iResponse, Integer.valueOf(i)});
                return;
            }
            b41.i(iResponse, "response");
            PageContext pageContext = this.this$0.getPageContext();
            final VenueDetailFragment venueDetailFragment = this.this$0;
            pageContext.runOnUIThread(new Function0<wt2>() { // from class: cn.damai.commonbusiness.scriptmurder.venuedetail.VenueDetailFragment$VenueDetailLoader$handleLoadSuccess$1
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
                    if (AndroidInstantRuntime.support(ipChange2, "-545034537")) {
                        ipChange2.ipc$dispatch("-545034537", new Object[]{this});
                        return;
                    }
                    VenueDetailFragment venueDetailFragment2 = VenueDetailFragment.this;
                    venueDetailFragment2.hideLoadingDialog(venueDetailFragment2.getActivity());
                }
            });
            super.handleLoadSuccess(iResponse, i);
        }

        @Override // com.youku.arch.v3.loader.AbsLoader, com.youku.arch.v3.loader.PagingLoader
        public void load(@NotNull Map<String, ? extends Object> map) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "706431514")) {
                ipChange.ipc$dispatch("706431514", new Object[]{this, map});
                return;
            }
            b41.i(map, Constants.CONFIG);
            super.load(map);
            Object obj = map.get("reload");
            if (b41.d(obj instanceof Boolean ? (Boolean) obj : null, Boolean.TRUE)) {
                return;
            }
            VenueDetailFragment venueDetailFragment = this.this$0;
            StateViewManager.IStateFeature.DefaultImpls.showLoadingDialog$default(venueDetailFragment, venueDetailFragment.getActivity(), null, false, 6, null);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes4.dex */
    public final class VenueDetailRequestBuilder implements RequestBuilder {
        private static transient /* synthetic */ IpChange $ipChange;
        @NotNull
        private Map<String, Object> params = new LinkedHashMap();
        private long strategy = 2;

        public VenueDetailRequestBuilder() {
        }

        @Override // com.youku.arch.v3.io.RequestBuilder
        @NotNull
        public IRequest build(@NotNull Map<String, ? extends Object> map) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1518122174")) {
                return (IRequest) ipChange.ipc$dispatch("-1518122174", new Object[]{this, map});
            }
            b41.i(map, Constants.CONFIG);
            this.params.put("patternName", "venue");
            this.params.put("patternVersion", "1.0");
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            String utdid = UTDevice.getUtdid(VenueDetailFragment.this.getContext());
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
            Object obj = map.get("index");
            if (obj != null) {
                linkedHashMap.put("pageNo", obj);
            }
            linkedHashMap.put(Constants.Name.PAGE_SIZE, 15);
            String str = VenueDetailFragment.this.venueId;
            if (str != null) {
                linkedHashMap.put(VenueDetailFragment.VENUE_ID, str);
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
            return AndroidInstantRuntime.support(ipChange, "2077322969") ? (Map) ipChange.ipc$dispatch("2077322969", new Object[]{this}) : this.params;
        }

        public final long getStrategy() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "1880028491") ? ((Long) ipChange.ipc$dispatch("1880028491", new Object[]{this})).longValue() : this.strategy;
        }

        public final void setParams(@NotNull Map<String, Object> map) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1511334803")) {
                ipChange.ipc$dispatch("-1511334803", new Object[]{this, map});
                return;
            }
            b41.i(map, "<set-?>");
            this.params = map;
        }

        public final void setStrategy(long j) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-937875623")) {
                ipChange.ipc$dispatch("-937875623", new Object[]{this, Long.valueOf(j)});
            } else {
                this.strategy = j;
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes4.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(k50 k50Var) {
            this();
        }
    }

    @Override // com.alient.onearch.adapter.BaseFragment
    @NotNull
    public GenericPagerLoader createPageLoader(@NotNull GenericPageContainer genericPageContainer) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1844872207")) {
            return (GenericPagerLoader) ipChange.ipc$dispatch("1844872207", new Object[]{this, genericPageContainer});
        }
        b41.i(genericPageContainer, "container");
        VenueDetailLoader venueDetailLoader = new VenueDetailLoader(this, genericPageContainer);
        venueDetailLoader.addComponentDisplayLimit(7502, 5);
        return venueDetailLoader;
    }

    @Override // com.alient.onearch.adapter.BaseFragment
    @NotNull
    protected RequestBuilder createRequestBuilder(@Nullable Map<String, ? extends Object> map) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-386194284") ? (RequestBuilder) ipChange.ipc$dispatch("-386194284", new Object[]{this, map}) : new VenueDetailRequestBuilder();
    }

    @Override // com.youku.arch.v3.page.GenericFragment
    @NotNull
    protected String getConfigPath() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "2083689909") ? (String) ipChange.ipc$dispatch("2083689909", new Object[]{this}) : this.configPath;
    }

    @Override // com.alient.onearch.adapter.BaseFragment, com.youku.arch.v3.page.GenericFragment
    protected int getLayoutResId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "75845082") ? ((Integer) ipChange.ipc$dispatch("75845082", new Object[]{this})).intValue() : R$layout.fragment_script_murder_venue_detail;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.youku.arch.v3.page.GenericFragment
    @NotNull
    public String getPageName() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "451732008") ? (String) ipChange.ipc$dispatch("451732008", new Object[]{this}) : this.pageName;
    }

    @Override // com.alient.onearch.adapter.component.header.sticky.StickyHeaderFeature
    @Nullable
    public View getStickyView() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1685479802") ? (View) ipChange.ipc$dispatch("-1685479802", new Object[]{this}) : this.stickyHeader;
    }

    @Override // com.alient.onearch.adapter.BaseFragment, com.youku.arch.v3.page.GenericFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "837687789")) {
            ipChange.ipc$dispatch("837687789", new Object[]{this, bundle});
            return;
        }
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        this.venueId = arguments != null ? arguments.getString(VENUE_ID) : null;
    }

    @Subscribe(eventType = {GenericBannerPresenterExt.MSG_BANNER_BG_UPDATE, "EventBus://business/notification/scriptMurder/get_header_info"})
    public final void onMessageGet(@NotNull Event event) {
        CommonNavbarActivity commonNavbarActivity;
        Object obj;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1450223904")) {
            ipChange.ipc$dispatch("-1450223904", new Object[]{this, event});
            return;
        }
        b41.i(event, "event");
        String str = event.type;
        if (b41.d(str, GenericBannerPresenterExt.MSG_BANNER_BG_UPDATE)) {
            Object obj2 = event.data;
            HashMap hashMap = obj2 instanceof HashMap ? (HashMap) obj2 : null;
            if (hashMap == null || (obj = hashMap.get("color")) == null) {
                return;
            }
            FragmentActivity activity = getActivity();
            commonNavbarActivity = activity instanceof CommonNavbarActivity ? (CommonNavbarActivity) activity : null;
            if (commonNavbarActivity != null) {
                commonNavbarActivity.setNavBarColor(((Integer) obj).intValue());
            }
            updateRefreshHeaderBgColor(((Integer) obj).intValue());
        } else if (b41.d(str, "EventBus://business/notification/scriptMurder/get_header_info")) {
            Object obj3 = event.data;
            HashMap hashMap2 = obj3 instanceof HashMap ? (HashMap) obj3 : null;
            if (hashMap2 != null) {
                FragmentActivity activity2 = getActivity();
                commonNavbarActivity = activity2 instanceof CommonNavbarActivity ? (CommonNavbarActivity) activity2 : null;
                if (commonNavbarActivity != null) {
                    commonNavbarActivity.onHeaderInfoUpdate(hashMap2);
                }
            }
        }
    }

    @Override // com.alient.onearch.adapter.BaseFragment, com.youku.arch.v3.page.GenericFragment, androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1941360134")) {
            ipChange.ipc$dispatch("1941360134", new Object[]{this, view, bundle});
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

    public final void updateRefreshHeaderBgColor(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-328075776")) {
            ipChange.ipc$dispatch("-328075776", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        RefreshInternal refreshHeader = getRefreshHeader();
        SimpleHeader simpleHeader = refreshHeader instanceof SimpleHeader ? (SimpleHeader) refreshHeader : null;
        if (simpleHeader != null) {
            simpleHeader.setBackgroundColor(i);
        }
    }
}
