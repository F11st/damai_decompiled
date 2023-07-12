package cn.damai.search.v2.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import cn.damai.common.AppConfig;
import cn.damai.common.net.mtop.Util;
import cn.damai.common.user.C0529c;
import cn.damai.common.util.ToastUtil;
import cn.damai.live.LiveActivity;
import cn.damai.onearch.errpage.ErrClickListener;
import cn.damai.onearch.errpage.bean.ErrControlViewInfo;
import cn.damai.search.bean.SearchResultTabEnum;
import cn.damai.search.bean.youku.SearchResultBeanYouKu;
import cn.damai.search.v2.ISearchTabSwitch;
import cn.damai.search.v2.SearchActivity;
import cn.damai.search.v2.bean.InputInfo;
import cn.damai.search.v2.fragment.SearchBaseFragment;
import cn.damai.search.v2.listener.SearchInputObserver;
import cn.damai.tetris.component.drama.bean.ProjectShowBean;
import cn.damai.tetris.core.mtop.GlobalConfig;
import cn.damai.tetris.core.ut.TrackProxy;
import cn.damai.tetris.core.ut.TrackType;
import cn.damai.wantsee.StartConfig;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.pictures.bricks.component.ipbrand.ITab;
import com.alient.onearch.adapter.BaseFragment;
import com.alient.onearch.adapter.ComponentTypeMapper;
import com.alient.onearch.adapter.component.divider.DividerModel;
import com.alient.onearch.adapter.decorate.ComponentDecorateItem;
import com.alient.onearch.adapter.decorate.ComponentDecorator;
import com.alient.onearch.adapter.loader.BasePageLoader;
import com.alient.oneservice.ut.TrackInfo;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.weex.annotation.JSMethod;
import com.taobao.weex.common.Constants;
import com.ut.device.UTDevice;
import com.youku.arch.v3.IContainer;
import com.youku.arch.v3.adapter.ContentAdapter;
import com.youku.arch.v3.core.ModelValue;
import com.youku.arch.v3.core.Node;
import com.youku.arch.v3.data.Constants;
import com.youku.arch.v3.data.Request;
import com.youku.arch.v3.io.IRequest;
import com.youku.arch.v3.io.IResponse;
import com.youku.arch.v3.io.RequestBuilder;
import com.youku.arch.v3.page.state.StateView;
import com.youku.arch.v3.util.IdGenerator;
import com.youku.middlewareservice.provider.info.AppInfoProviderProxy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
import tb.b82;
import tb.cb1;
import tb.ir1;
import tb.mr1;
import tb.n6;
import tb.t60;
import tb.w20;
import tb.xl2;
import tb.z20;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public abstract class SearchBaseFragment extends BaseFragment implements ISearchTabSwitch, SearchInputObserver, ITab {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String CDN_DOWN_GRADE_KEY = "reduce";
    public static final String CURRENT_AB = "ABTrackInfo";
    protected InputInfo currentSearchInputInfo;
    protected InputInfo historySearchInputInfo;
    private SearchActivity host;
    public JSONObject noMoreNodeData = new JSONObject();
    protected final JSONObject emptyComponentData = new JSONObject();
    protected final JSONObject dividerComponentData = new JSONObject();
    protected boolean isCurrentPageTriggerSearch = false;
    private volatile boolean isFirstLoad = true;

    /* compiled from: Taobao */
    /* loaded from: classes6.dex */
    public class SearchPageLoader extends BasePageLoader {
        private static transient /* synthetic */ IpChange $ipChange;

        /* compiled from: Taobao */
        /* renamed from: cn.damai.search.v2.fragment.SearchBaseFragment$SearchPageLoader$a */
        /* loaded from: classes6.dex */
        public class C1644a implements ErrClickListener {
            private static transient /* synthetic */ IpChange $ipChange;

            C1644a() {
            }

            @Override // cn.damai.onearch.errpage.ErrClickListener
            public void callBack(int i) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1680860399")) {
                    ipChange.ipc$dispatch("-1680860399", new Object[]{this, Integer.valueOf(i)});
                } else {
                    SearchPageLoader.this.refreshLoad();
                }
            }
        }

        /* compiled from: Taobao */
        /* renamed from: cn.damai.search.v2.fragment.SearchBaseFragment$SearchPageLoader$b */
        /* loaded from: classes6.dex */
        public class C1645b implements ErrClickListener {
            private static transient /* synthetic */ IpChange $ipChange;

            C1645b() {
            }

            @Override // cn.damai.onearch.errpage.ErrClickListener
            public void callBack(int i) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "2103572720")) {
                    ipChange.ipc$dispatch("2103572720", new Object[]{this, Integer.valueOf(i)});
                } else {
                    SearchPageLoader.this.refreshLoad();
                }
            }
        }

        public SearchPageLoader(IContainer<ModelValue> iContainer) {
            super(iContainer);
        }

        private void countDownTime(JSONObject jSONObject, Node node) {
            long longValue;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1112037426")) {
                ipChange.ipc$dispatch("-1112037426", new Object[]{this, jSONObject, node});
            } else if (jSONObject.containsKey("currentTime")) {
                try {
                    if (jSONObject.get("currentTime") instanceof String) {
                        longValue = Long.parseLong((String) jSONObject.get("currentTime"));
                    } else {
                        longValue = jSONObject.get("currentTime") instanceof Long ? ((Long) jSONObject.get("currentTime")).longValue() : 0L;
                    }
                    if (longValue > 0) {
                        long elapsedRealtime = SystemClock.elapsedRealtime();
                        if (node.getData() != null) {
                            node.getData().put("nativeDiffTime", (Object) Long.valueOf(longValue - elapsedRealtime));
                            node.getData().put(ProjectShowBean.SERVER_TIME, (Object) Long.valueOf(longValue));
                        }
                    }
                } catch (Exception unused) {
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ Object lambda$handleLoadFinish$1(IResponse iResponse, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1549555355")) {
                return ipChange.ipc$dispatch("-1549555355", new Object[]{this, iResponse, Integer.valueOf(i)});
            }
            if (iResponse != null && iResponse.isSuccess()) {
                setLoadingPage(i);
            }
            setLoadingViewState(iResponse);
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ Object lambda$handleLoadSuccess$0() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1874345580")) {
                return ipChange.ipc$dispatch("1874345580", new Object[]{this});
            }
            SearchBaseFragment.this.host.showErrView(ErrControlViewInfo.errSensitiveWord("contain_sensitive_words", "报歉，没有搜索到“" + SearchBaseFragment.this.currentSearchInputInfo.inputText + "”的相关结果\n由于相关法律法规和政策，部分结果未予显示"));
            setLoadingState(2);
            return null;
        }

        @Override // com.alient.onearch.adapter.loader.BasePageLoader
        public Node createNoMoreSectionNode(Node node, boolean z) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1167772433")) {
                return (Node) ipChange.ipc$dispatch("-1167772433", new Object[]{this, node, Boolean.valueOf(z)});
            }
            List<Node> children = node.getChildren();
            if (children == null || children.isEmpty()) {
                return null;
            }
            Node node2 = children.get(children.size() - 1);
            if (z) {
                SearchBaseFragment.this.getRefreshLayout().setEnableLoadMore(false);
                return createDecorateSection(node2, new ComponentDecorateItem(3, 3, SearchBaseFragment.this.noMoreNodeData, ComponentDecorateItem.Indexer.After));
            }
            List<Node> children2 = node2.getChildren();
            if (children2 == null || children2.isEmpty() || children2.get(children2.size() - 1).getMore()) {
                return null;
            }
            SearchBaseFragment.this.getRefreshLayout().setEnableLoadMore(false);
            return createDecorateSection(node2, new ComponentDecorateItem(3, 3, SearchBaseFragment.this.noMoreNodeData, ComponentDecorateItem.Indexer.After));
        }

        @Override // com.youku.arch.v3.loader.PageLoader, com.youku.arch.v3.loader.AbsLoader, com.youku.arch.v3.loader.PagingLoader
        public void handleLoadFailure(IResponse iResponse) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1226558235")) {
                ipChange.ipc$dispatch("-1226558235", new Object[]{this, iResponse});
            } else if (StartConfig.isOpenSearchCdnDowngrade() && SearchBaseFragment.this.pageLoader != null && "remote".equals(iResponse.getSource()) && SearchBaseFragment.this.pageLoader.getLoadingPage() == 1) {
                HashMap hashMap = new HashMap();
                hashMap.put("reduce", Boolean.TRUE);
                SearchBaseFragment.this.pageLoader.load(hashMap);
                try {
                    InputInfo inputInfo = SearchBaseFragment.this.currentSearchInputInfo;
                    b82.f(iResponse.getRetCode(), iResponse.getRetMessage(), inputInfo == null ? "none" : inputInfo.inputText);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                super.handleLoadFailure(iResponse);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.youku.arch.v3.loader.PageLoader
        public void handleLoadFinish(@Nullable final IResponse iResponse, boolean z, final int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1883100889")) {
                ipChange.ipc$dispatch("1883100889", new Object[]{this, iResponse, Boolean.valueOf(z), Integer.valueOf(i)});
                return;
            }
            SearchBaseFragment.this.getPageContext().runOnUIThread(new Function0() { // from class: tb.v72
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Object lambda$handleLoadFinish$1;
                    lambda$handleLoadFinish$1 = SearchBaseFragment.SearchPageLoader.this.lambda$handleLoadFinish$1(iResponse, i);
                    return lambda$handleLoadFinish$1;
                }
            });
            try {
                if (getCallback() != null) {
                    getCallback().onResponse(iResponse);
                }
            } catch (Exception e) {
                if (AppInfoProviderProxy.isDebuggable()) {
                    e.printStackTrace();
                }
            }
        }

        @Override // com.alient.onearch.adapter.loader.BasePageLoader, com.youku.arch.v3.loader.PageLoader, com.youku.arch.v3.loader.AbsLoader, com.youku.arch.v3.loader.PagingLoader
        public void handleLoadSuccess(IResponse iResponse, int i) {
            JSONObject jSONObject;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-427827017")) {
                ipChange.ipc$dispatch("-427827017", new Object[]{this, iResponse, Integer.valueOf(i)});
                return;
            }
            if (iResponse.getRawData().contains("contain_sensitive_words")) {
                SearchBaseFragment.this.getPageContext().runOnUIThreadLocked(new Function0() { // from class: tb.u72
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Object lambda$handleLoadSuccess$0;
                        lambda$handleLoadSuccess$0 = SearchBaseFragment.SearchPageLoader.this.lambda$handleLoadSuccess$0();
                        return lambda$handleLoadSuccess$0;
                    }
                });
            } else {
                super.handleLoadSuccess(iResponse, i);
            }
            if (iResponse.getJsonObject() == null || iResponse.getJsonObject().getJSONObject("data") == null || (jSONObject = iResponse.getJsonObject().getJSONObject("data").getJSONObject("globalConfig")) == null) {
                return;
            }
            try {
                SearchBaseFragment.this.updateAB((GlobalConfig) jSONObject.toJavaObject(GlobalConfig.class));
            } catch (Exception e) {
                if (AppInfoProviderProxy.isDebuggable()) {
                    throw new RuntimeException(e);
                }
            }
        }

        @Override // com.alient.onearch.adapter.loader.BasePageLoader
        public boolean isInterceptCreateSection(Node node, JSONObject jSONObject) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1245369103")) {
                return ((Boolean) ipChange.ipc$dispatch("-1245369103", new Object[]{this, node, jSONObject})).booleanValue();
            }
            if (parseComponentType(jSONObject.getString("componentId")) == 1000) {
                JSONObject jSONObject2 = jSONObject.getJSONObject("item");
                if (jSONObject2 == null) {
                    return true;
                }
                JSONObject jSONObject3 = jSONObject2.getJSONObject("tourInfo");
                if (jSONObject3 != null && jSONObject3.containsKey("topItem") && jSONObject3.containsKey("items")) {
                    Node node2 = new Node();
                    node2.setLevel(2);
                    node2.setData(new JSONObject());
                    node2.setType(1006);
                    node2.setId(1006L);
                    node2.setChildren(new ArrayList());
                    if (jSONObject.getJSONObject("trackInfo") != null) {
                        node2.getData().put("trackInfo", (Object) jSONObject.getJSONObject("trackInfo"));
                    }
                    node2.getData().put("abBucket", (Object) jSONObject.getString("abBucket"));
                    countDownTime(jSONObject2, node2);
                    JSONArray jSONArray = new JSONArray();
                    jSONArray.add(jSONObject3);
                    parseItems(node2, jSONArray, jSONArray.size());
                    node2.setParent(node);
                    ComponentDecorator componentDecorator = getComponentDecorator();
                    int type = node2.getType();
                    ComponentDecorateItem.Indexer indexer = ComponentDecorateItem.Indexer.Before;
                    if (componentDecorator.getComponentDecorate(type, indexer) != null) {
                        createDecorateSection(node, getComponentDecorator().getComponentDecorate(node2.getType(), indexer));
                    }
                    node.getChildren().add(node2);
                    ComponentDecorator componentDecorator2 = getComponentDecorator();
                    int type2 = node2.getType();
                    ComponentDecorateItem.Indexer indexer2 = ComponentDecorateItem.Indexer.After;
                    if (componentDecorator2.getComponentDecorate(type2, indexer2) != null) {
                        createDecorateSection(node, getComponentDecorator().getComponentDecorate(node2.getType(), indexer2));
                    }
                    if (SearchBaseFragment.this.getTabTitle().equals(SearchResultTabEnum.ALL.content)) {
                        getComponentItemDisplayLimiter().addComponentLimitSize(1007, 5);
                    }
                } else if (SearchBaseFragment.this.getTabTitle().equals(SearchResultTabEnum.ALL.content)) {
                    getComponentItemDisplayLimiter().addComponentLimitSize(1007, 10);
                }
                JSONArray jSONArray2 = jSONObject2.getJSONArray(SearchResultBeanYouKu.FlAG_PROJECT);
                if (jSONArray2 != null && !jSONArray2.isEmpty()) {
                    Node node3 = new Node();
                    node3.setLevel(2);
                    node3.setData(new JSONObject());
                    node3.setType(1007);
                    node3.setId(1007L);
                    node3.setChildren(new ArrayList());
                    if (jSONObject.getJSONObject("trackInfo") != null) {
                        node3.getData().put("trackInfo", (Object) jSONObject.getJSONObject("trackInfo"));
                    }
                    node3.getData().put("abBucket", (Object) jSONObject.getString("abBucket"));
                    node3.getData().put("componentId", (Object) jSONObject.getString("componentId"));
                    countDownTime(jSONObject2, node3);
                    ComponentDecorator componentDecorator3 = getComponentDecorator();
                    int type3 = node3.getType();
                    ComponentDecorateItem.Indexer indexer3 = ComponentDecorateItem.Indexer.Before;
                    if (componentDecorator3.getComponentDecorate(type3, indexer3) != null) {
                        createDecorateSection(node, getComponentDecorator().getComponentDecorate(node3.getType(), indexer3));
                    }
                    if (getComponentItemDisplayLimiter().hasComponentLimitSize(node3.getType())) {
                        parseItems(node3, jSONArray2, Math.min(getComponentItemDisplayLimiter().geComponentLimitSize(node3.getType()).intValue(), jSONArray2.size()));
                        r4 = getComponentItemDisplayLimiter().geComponentLimitSize(node3.getType()).intValue() < jSONArray2.size();
                        node3.setMore(true);
                    } else {
                        parseItems(node3, jSONArray2, jSONArray2.size());
                        node3.setMore(jSONObject2.containsKey(xl2.HAS_NEXT) && "true".equals(jSONObject2.getString(xl2.HAS_NEXT)));
                    }
                    node3.setParent(node);
                    node.getChildren().add(node3);
                    if (r4) {
                        createFooterSection(node, jSONObject);
                    }
                    ComponentDecorator componentDecorator4 = getComponentDecorator();
                    int type4 = node3.getType();
                    ComponentDecorateItem.Indexer indexer4 = ComponentDecorateItem.Indexer.After;
                    if (componentDecorator4.getComponentDecorate(type4, indexer4) != null) {
                        createDecorateSection(node, getComponentDecorator().getComponentDecorate(node3.getType(), indexer4));
                    }
                }
                return true;
            }
            return false;
        }

        @Override // com.alient.onearch.adapter.loader.BasePageLoader, com.youku.arch.v3.loader.AbsLoader, com.youku.arch.v3.loader.PagingLoader
        public void load(Map<String, ?> map) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1610730495")) {
                ipChange.ipc$dispatch("-1610730495", new Object[]{this, map});
                return;
            }
            Integer num = (Integer) map.get("index");
            if (num != null && num.intValue() <= 1) {
                SearchBaseFragment.this.getRefreshLayout().setEnableLoadMore(true);
                if (SearchBaseFragment.this.getPageContext().getFragment().getRecyclerView() != null && (SearchBaseFragment.this.getPageContext().getFragment().getRecyclerView().getAdapter() instanceof ContentAdapter)) {
                    ((ContentAdapter) SearchBaseFragment.this.getPageContext().getFragment().getRecyclerView().getAdapter()).clear();
                    SearchBaseFragment.this.getPageContext().getFragment().getRecyclerView().getAdapter().notifyDataSetChanged();
                }
            }
            super.load(map);
        }

        @Override // com.alient.onearch.adapter.loader.BasePageLoader
        public int parseComponentType(String str) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "163390659") ? ((Integer) ipChange.ipc$dispatch("163390659", new Object[]{this, str})).intValue() : ComponentTypeMapper.INSTANCE.convertComponentTypeToInt(str);
        }

        @Override // com.alient.onearch.adapter.loader.BasePageLoader, com.youku.arch.v3.loader.PageLoader
        @NonNull
        public Node parseNode(@NonNull JSONObject jSONObject) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1872319887")) {
                return (Node) ipChange.ipc$dispatch("-1872319887", new Object[]{this, jSONObject});
            }
            Node parseNode = super.parseNode(jSONObject);
            if (parseNode.getChildren() != null && parseNode.getChildren().size() == 1) {
                Node node = parseNode.getChildren().get(0);
                if (node.getChildren() != null && node.getChildren().size() == 1) {
                    Node node2 = node.getChildren().get(0);
                    if (node2.getType() == 1005) {
                        node.getChildren().remove(0);
                        SearchBaseFragment.this.emptyComponentData.put("content", (Object) ("报歉，没有搜索到“" + SearchBaseFragment.this.currentSearchInputInfo.inputText + "”的相关结果"));
                        JSONObject jSONObject2 = SearchBaseFragment.this.emptyComponentData;
                        ComponentDecorateItem.Indexer indexer = ComponentDecorateItem.Indexer.Before;
                        createDecorateSection(node, new ComponentDecorateItem(1, 1, jSONObject2, indexer));
                        SearchBaseFragment.this.dividerComponentData.put(DividerModel.DIVIDER_COLOR, (Object) "#F5F6F7");
                        createDecorateSection(node, new ComponentDecorateItem(2, 2, SearchBaseFragment.this.dividerComponentData, indexer));
                        node.getChildren().add(node2);
                    }
                }
            }
            return parseNode;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public void setLoadingViewState(IResponse iResponse) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "94694735")) {
                ipChange.ipc$dispatch("94694735", new Object[]{this, iResponse});
            } else if (SearchBaseFragment.this.host == null || SearchBaseFragment.this.host.isFinishing()) {
            } else {
                SearchBaseFragment.this.host.hideErrView();
                boolean z = getRealItemCount() > 0;
                boolean z2 = iResponse != null && iResponse.isSuccess();
                HashMap hashMap = new HashMap();
                if (z2) {
                    hashMap.put("success", "ture");
                }
                if (z) {
                    hashMap.put("hasItem", "ture");
                }
                C0529c.e().A(hashMap, "LoadingViewState", "search");
                if (getLoadingPage() <= 1) {
                    if (z) {
                        if (z2) {
                            getLoadingViewManager().onSuccess();
                            if (hasNextPage()) {
                                setLoadingPage(getLoadingPage() + 1);
                            } else {
                                getLoadingViewManager().onAllPageLoaded();
                            }
                        } else if (iResponse != null) {
                            SearchBaseFragment.this.host.showErrView(ErrControlViewInfo.errNetInfo(iResponse.getRetCode(), Util.getErrorMsg(iResponse.getRetCode(), iResponse.getRetMessage()), "", new C1645b()));
                        }
                    } else if (z2) {
                        getLoadingViewManager().onNoData();
                        StateView stateView = SearchBaseFragment.this.getPageStateManager().stateView;
                        if (stateView != null && stateView.getStateView(stateView.getCurrentState()) != null) {
                            stateView.getStateView(stateView.getCurrentState()).update(iResponse.getRetCode(), "抱歉，没有搜索到\"" + SearchBaseFragment.this.currentSearchInputInfo.inputText + "\"的相关" + SearchBaseFragment.this.getEmptyPageDesSuffix());
                        }
                    } else {
                        getLoadingViewManager().onFailure("response fails or is null");
                        if (iResponse != null) {
                            SearchBaseFragment.this.host.showErrView(ErrControlViewInfo.errNetInfo(iResponse.getRetCode(), Util.getErrorMsg(iResponse.getRetCode(), iResponse.getRetMessage()), "", new C1644a()));
                        }
                    }
                } else if (z2) {
                    if (hasNextPage()) {
                        getLoadingViewManager().onLoadNextSuccess();
                        setLoadingPage(getLoadingPage() + 1);
                    } else {
                        getLoadingViewManager().onAllPageLoaded();
                    }
                } else {
                    getLoadingViewManager().onLoadNextFailure("response fails or is null");
                    if (iResponse != null) {
                        ToastUtil.a().e(SearchBaseFragment.this.host, Util.getErrorMsg(iResponse.getRetCode(), iResponse.getRetMessage()));
                    }
                }
                if (!z2) {
                    setLoadingState(2);
                } else if (z && hasNextPage()) {
                    setLoadingState(0);
                } else {
                    setLoadingState(3);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.youku.arch.v3.loader.PageLoader
        public void setLoadingViewState(@NotNull IResponse iResponse, boolean z) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1359384731")) {
                ipChange.ipc$dispatch("-1359384731", new Object[]{this, iResponse, Boolean.valueOf(z)});
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.youku.arch.v3.loader.PageLoader
        public void tryCreateModules(@NonNull Node node, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1382718623")) {
                ipChange.ipc$dispatch("-1382718623", new Object[]{this, node, Integer.valueOf(i)});
                return;
            }
            super.tryCreateModules(node, i);
            if (getLoadingPage() > 1 || !SearchBaseFragment.this.isCurrentPageTriggerSearch) {
                return;
            }
            C0529c.e().u();
            SearchBaseFragment.this.isCurrentPageTriggerSearch = false;
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes6.dex */
    public class SearchRequestBuilder implements RequestBuilder {
        private static transient /* synthetic */ IpChange $ipChange = null;
        private static final String API_NAME = "mtop.damai.mec.aristotle.get";
        private static final boolean NEED_ENCODE = false;
        private static final boolean NEED_SESSION = false;
        private static final String VERSION = "1.0";

        public SearchRequestBuilder() {
        }

        @Override // com.youku.arch.v3.io.RequestBuilder
        public IRequest build(Map<String, ?> map) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1410716556")) {
                return (IRequest) ipChange.ipc$dispatch("1410716556", new Object[]{this, map});
            }
            long j = 2;
            HashMap hashMap = new HashMap();
            hashMap.put("patternName", SearchBaseFragment.this.getRequestPatternName());
            hashMap.put("patternVersion", SearchBaseFragment.this.getRequestPatternVersion());
            HashMap hashMap2 = new HashMap();
            hashMap2.put("utdid", UTDevice.getUtdid(SearchBaseFragment.this.getContext()));
            hashMap2.put("comboDamaiCityId", z20.c());
            if (ir1.i(mr1.LOCATION)) {
                hashMap2.put("latitude", Double.valueOf(z20.n()));
                hashMap2.put("longitude", Double.valueOf(z20.o()));
            }
            hashMap2.put(Constants.Name.PAGE_SIZE, Integer.valueOf(SearchBaseFragment.this.getRequestPageSize()));
            hashMap2.put(LiveActivity.OPTION_TTID, AppConfig.p());
            Object obj = map.get("index");
            if (obj != null) {
                hashMap2.put("pageNo", obj);
                if (((Integer) obj).intValue() > 1) {
                    setLoadMoreRequestParams(hashMap, hashMap2);
                }
            }
            InputInfo inputInfo = SearchBaseFragment.this.currentSearchInputInfo;
            if (inputInfo != null) {
                hashMap2.put("keyword", inputInfo.inputText);
            }
            String jSONString = JSON.toJSONString(hashMap2);
            hashMap.put("args", jSONString);
            Map<String, String> c = w20.b().c(API_NAME, hashMap);
            Map<String, String> e = n6.e();
            if (z20.t()) {
                e.put("EagleEye-UserData", "scm_project=" + z20.s());
            }
            HashMap hashMap3 = new HashMap();
            hashMap3.put("requestArgs", jSONString);
            C0529c.e().A(hashMap3, "RequestBuilder", "search");
            Object obj2 = map.get("reduce");
            Bundle bundle = null;
            if ((obj2 instanceof Boolean) && ((Boolean) obj2).booleanValue()) {
                j = Constants.RequestStrategy.REMOTE_FILE;
                bundle = new Bundle();
                String requestPatternName = SearchBaseFragment.this.getRequestPatternName();
                String requestPatternVersion = SearchBaseFragment.this.getRequestPatternVersion();
                InputInfo inputInfo2 = SearchBaseFragment.this.currentSearchInputInfo;
                String str = "https://oss.taopiaopiao.com/" + requestPatternName + JSMethod.NOT_SET + requestPatternVersion + "_bak_" + (inputInfo2 != null ? inputInfo2.inputText : "") + ".json";
                cb1.c("CDNDownGrade", "cdn url: " + str);
                bundle.putParcelable("uri", Uri.parse(str));
            }
            return new Request.Builder().setApiName(API_NAME).setVersion("1.0").setNeedECode(false).setNeedSession(false).setStrategy(j).setHeaders(e).setRequestId(IdGenerator.getId()).setDataParams(new HashMap(c)).setBundle(bundle).build();
        }

        protected void setLoadMoreRequestParams(Map<String, String> map, Map<String, Object> map2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-435816452")) {
                ipChange.ipc$dispatch("-435816452", new Object[]{this, map, map2});
            }
        }
    }

    private void doSearch(InputInfo inputInfo) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1787002690")) {
            ipChange.ipc$dispatch("-1787002690", new Object[]{this, inputInfo});
            return;
        }
        if (this.pageContainer.getPageContext().getConcurrentMap() != null && inputInfo != null) {
            this.pageContainer.getPageContext().getConcurrentMap().put("keyword", inputInfo.inputText);
        }
        this.isFirstLoad = false;
        this.historySearchInputInfo = this.currentSearchInputInfo;
        refreshTrackInfo(inputInfo);
        doRequest();
    }

    private void refreshTrackInfo(@Nullable InputInfo inputInfo) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "797359977")) {
            ipChange.ipc$dispatch("797359977", new Object[]{this, inputInfo});
            return;
        }
        TrackInfo trackInfo = getTrackInfo();
        if (trackInfo.getArgs() == null) {
            trackInfo.setArgs(new HashMap<>());
        }
        trackInfo.getArgs().put("contentlabel", getTabTitle());
        if (inputInfo != null) {
            trackInfo.getArgs().put("keyword", inputInfo.inputText);
            trackInfo.getArgs().put("type", inputInfo.getType4Ut());
        }
    }

    @Override // com.alient.onearch.adapter.BaseFragment
    @Nullable
    protected RequestBuilder createRequestBuilder(@Nullable Map<String, ?> map) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1763281376") ? (RequestBuilder) ipChange.ipc$dispatch("-1763281376", new Object[]{this, map}) : new SearchRequestBuilder();
    }

    public void dispatchInputWord(InputInfo inputInfo) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2019728743")) {
            ipChange.ipc$dispatch("2019728743", new Object[]{this, inputInfo});
        } else if (inputInfo == null) {
        } else {
            this.currentSearchInputInfo = inputInfo;
            if (!getUserVisibleHint() || this.currentSearchInputInfo.equals(this.historySearchInputInfo)) {
                return;
            }
            this.isCurrentPageTriggerSearch = true;
            doSearch(inputInfo);
        }
    }

    @Override // com.youku.arch.v3.page.GenericFragment
    public void doRequest() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1434262544")) {
            ipChange.ipc$dispatch("-1434262544", new Object[]{this});
        } else if (this.currentSearchInputInfo == null) {
        } else {
            super.doRequest();
        }
    }

    @Override // com.youku.arch.v3.page.GenericFragment
    public String getConfigPath() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1559750313") ? (String) ipChange.ipc$dispatch("1559750313", new Object[]{this}) : "://trade/raw/search_component_config";
    }

    protected abstract String getEmptyPageDesSuffix();

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.youku.arch.v3.page.GenericFragment
    public String getPageName() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-889593828") ? (String) ipChange.ipc$dispatch("-889593828", new Object[]{this}) : "search";
    }

    protected abstract int getRequestPageSize();

    protected abstract String getRequestPatternName();

    protected abstract String getRequestPatternVersion();

    @Override // com.alient.onearch.adapter.BaseFragment, com.youku.arch.v3.page.GenericFragment
    protected void initPageLoader() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1452930660")) {
            ipChange.ipc$dispatch("1452930660", new Object[]{this});
            return;
        }
        SearchPageLoader searchPageLoader = new SearchPageLoader(this.pageContainer);
        this.pageLoader = searchPageLoader;
        searchPageLoader.setCallback(this);
        this.pageContainer.setPageLoader(this.pageLoader);
    }

    @Override // com.youku.arch.v3.page.GenericFragment, androidx.fragment.app.Fragment
    public void onAttach(@NonNull Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-973284746")) {
            ipChange.ipc$dispatch("-973284746", new Object[]{this, context});
            return;
        }
        super.onAttach(context);
        this.host = (SearchActivity) context;
    }

    @Override // com.youku.arch.v3.page.GenericFragment, androidx.fragment.app.Fragment
    public void onDetach() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1818289540")) {
            ipChange.ipc$dispatch("1818289540", new Object[]{this});
            return;
        }
        this.host = null;
        super.onDetach();
    }

    @Override // cn.damai.search.v2.ISearchTabSwitch
    public void onPageEnter() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1474676854")) {
            ipChange.ipc$dispatch("-1474676854", new Object[]{this});
            return;
        }
        C0529c.e().u();
        if (this.currentSearchInputInfo == null && getActivity() != null) {
            this.currentSearchInputInfo = ((SearchActivity) getActivity()).getSearchInputManager().getCurrentInputInfo();
        }
        InputInfo inputInfo = this.historySearchInputInfo;
        InputInfo inputInfo2 = this.currentSearchInputInfo;
        if (inputInfo != inputInfo2) {
            doSearch(inputInfo2);
        }
        TrackProxy.a().userTrack(TrackType.click, null, getPageName(), "top", "tab_" + SearchResultTabEnum.valueOfContent(getTabTitle()).index, getTrackInfo().getArgs(), false);
    }

    @Override // cn.damai.search.v2.ISearchTabSwitch
    public void onPageExit() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "90391050")) {
            ipChange.ipc$dispatch("90391050", new Object[]{this});
        }
    }

    @Override // com.alient.onearch.adapter.BaseFragment, com.youku.arch.v3.page.GenericFragment, androidx.fragment.app.Fragment
    public void onResume() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1977956010")) {
            ipChange.ipc$dispatch("1977956010", new Object[]{this});
            return;
        }
        super.onResume();
        if (getUserVisibleHint() && this.isFirstLoad) {
            if (this.currentSearchInputInfo == null && getActivity() != null) {
                this.currentSearchInputInfo = ((SearchActivity) getActivity()).getSearchInputManager().getCurrentInputInfo();
            }
            InputInfo inputInfo = this.historySearchInputInfo;
            InputInfo inputInfo2 = this.currentSearchInputInfo;
            if (inputInfo != inputInfo2) {
                doSearch(inputInfo2);
            }
            doSearch(this.currentSearchInputInfo);
        }
    }

    @Override // com.alient.onearch.adapter.BaseFragment, com.youku.arch.v3.page.GenericFragment, androidx.fragment.app.Fragment
    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "836328850")) {
            ipChange.ipc$dispatch("836328850", new Object[]{this, view, bundle});
            return;
        }
        super.onViewCreated(view, bundle);
        getRefreshLayout().setEnableRefresh(false);
        getRecyclerView().setPadding(0, t60.a(getActivity(), 9.0f), 0, 0);
    }

    public void updateAB(GlobalConfig globalConfig) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1186461220")) {
            ipChange.ipc$dispatch("1186461220", new Object[]{this, globalConfig});
        } else if (getActivity() != null) {
            HashMap hashMap = new HashMap();
            if (globalConfig != null && !TextUtils.isEmpty(globalConfig.pabBucket)) {
                hashMap.put("ABTrackInfo", globalConfig.pabBucket);
            }
            if (getUserVisibleHint()) {
                C0529c.e().O(getActivity(), hashMap);
            }
        }
    }
}
