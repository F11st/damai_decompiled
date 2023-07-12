package cn.damai.search.v2.fragment;

import androidx.annotation.Nullable;
import cn.damai.onearch.errpage.bean.ErrControlViewInfo;
import cn.damai.search.bean.SearchResultTabEnum;
import cn.damai.search.v2.SearchActivity;
import cn.damai.search.v2.bean.InputInfo;
import cn.damai.search.v2.fragment.SearchBaseFragment;
import cn.damai.tetris.request.DrObj;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alient.onearch.adapter.component.divider.DividerModel;
import com.alient.onearch.adapter.decorate.ComponentDecorateItem;
import com.alient.onearch.adapter.decorate.ComponentDecorator;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.IContainer;
import com.youku.arch.v3.core.ModelValue;
import com.youku.arch.v3.core.Node;
import com.youku.arch.v3.io.RequestBuilder;
import com.youku.kubus.Event;
import com.youku.kubus.Subscribe;
import com.youku.live.livesdk.model.mtop.LiveFullInfo;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import tb.jn1;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public final class SearchAllResultFragment extends SearchBaseFragment {
    private static transient /* synthetic */ IpChange $ipChange;

    /* compiled from: Taobao */
    /* loaded from: classes6.dex */
    public final class SearchAllPageLoader extends SearchBaseFragment.SearchPageLoader {
        private static transient /* synthetic */ IpChange $ipChange;
        JSONObject greyDivider;

        public SearchAllPageLoader(IContainer<ModelValue> iContainer) {
            super(iContainer);
            this.greyDivider = new JSONObject();
            getComponentItemDisplayLimiter().addComponentLimitSize(1001, 1);
            getComponentItemDisplayLimiter().addComponentLimitSize(1002, 1);
            getComponentItemDisplayLimiter().addComponentLimitSize(1003, 1);
            getComponentItemDisplayLimiter().addComponentLimitSize(1007, 10);
            getComponentItemDisplayLimiter().addComponentLimitSize(1008, 3);
            getComponentItemDisplayLimiter().addComponentLimitSize(1009, 3);
            getComponentItemDisplayLimiter().addComponentLimitSize(1010, 3);
            this.greyDivider.put(DividerModel.DIVIDER_COLOR, (Object) "#F5F6F7");
            ComponentDecorator componentDecorator = getComponentDecorator();
            JSONObject jSONObject = this.greyDivider;
            ComponentDecorateItem.Indexer indexer = ComponentDecorateItem.Indexer.Before;
            componentDecorator.addComponentDecorate(1008, new ComponentDecorateItem(2, 2, jSONObject, indexer));
            getComponentDecorator().addComponentDecorate(1009, new ComponentDecorateItem(2, 2, this.greyDivider, indexer));
            getComponentDecorator().addComponentDecorate(1010, new ComponentDecorateItem(2, 2, this.greyDivider, indexer));
            getComponentDecorator().addComponentDecorate(1001, new ComponentDecorateItem(2, 2, this.greyDivider, indexer));
            getComponentDecorator().addComponentDecorate(1002, new ComponentDecorateItem(2, 2, this.greyDivider, indexer));
            getComponentDecorator().addComponentDecorate(1003, new ComponentDecorateItem(2, 2, this.greyDivider, indexer));
            getComponentDecorator().addComponentDecorate(1004, new ComponentDecorateItem(2, 2, this.greyDivider, indexer));
            getComponentDecorator().addComponentDecorate(1006, new ComponentDecorateItem(2, 2, this.greyDivider, indexer));
            getComponentDecorator().addComponentDecorate(1007, new ComponentDecorateItem(2, 2, this.greyDivider, indexer));
            getComponentDecorator().addComponentDecorate(101, new ComponentDecorateItem(2, 2, this.greyDivider, indexer));
        }

        private List<Node> getValidSectionNodes(Node node) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1483021381")) {
                return (List) ipChange.ipc$dispatch("-1483021381", new Object[]{this, node});
            }
            ArrayList arrayList = new ArrayList();
            if (node.getChildren() != null) {
                for (int i = 0; i < node.getChildren().size(); i++) {
                    if (node.getChildren().get(i) != null && node.getChildren().get(i).getData() != null && !node.getChildren().get(i).getData().isEmpty()) {
                        arrayList.add(node.getChildren().get(i));
                    }
                }
            }
            return arrayList;
        }

        @Override // cn.damai.search.v2.fragment.SearchBaseFragment.SearchPageLoader, com.alient.onearch.adapter.loader.BasePageLoader, com.youku.arch.v3.loader.PageLoader
        @NotNull
        public Node parseNode(@NotNull JSONObject jSONObject) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-144910327")) {
                return (Node) ipChange.ipc$dispatch("-144910327", new Object[]{this, jSONObject});
            }
            Node parseNode = super.parseNode(jSONObject);
            if (getLoadingPage() == 1 && parseNode.getChildren() != null && !parseNode.getChildren().isEmpty()) {
                Node node = parseNode.getChildren().get(0);
                if (node.getChildren() != null && !node.getChildren().isEmpty()) {
                    Node node2 = node.getChildren().get(0);
                    if (node2.getType() == 2) {
                        node.getChildren().remove(node2);
                    }
                }
            }
            if (parseNode.getChildren() != null && parseNode.getChildren().size() == 1) {
                Node node3 = parseNode.getChildren().get(0);
                if (node3.getChildren() != null && getValidSectionNodes(node3).size() == 1) {
                    Node node4 = node3.getChildren().get(node3.getChildren().size() - 1);
                    if (node4.getType() == 1005) {
                        node3.getChildren().remove(node4);
                        ArrayList arrayList = new ArrayList(node3.getChildren());
                        node3.getChildren().clear();
                        SearchAllResultFragment.this.emptyComponentData.put("content", (Object) ("报歉，没有搜索到“" + SearchAllResultFragment.this.currentSearchInputInfo.inputText + "”的相关结果"));
                        JSONObject jSONObject2 = SearchAllResultFragment.this.emptyComponentData;
                        ComponentDecorateItem.Indexer indexer = ComponentDecorateItem.Indexer.Before;
                        createDecorateSection(node3, new ComponentDecorateItem(1, 1, jSONObject2, indexer));
                        createDecorateSection(node3, new ComponentDecorateItem(2, 2, SearchAllResultFragment.this.dividerComponentData, indexer));
                        node3.getChildren().addAll(arrayList);
                        node3.getChildren().add(node4);
                    }
                }
            }
            SearchAllResultFragment.this.getPageContext().getBundle().putString("tabtitle", "全部");
            return parseNode;
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes6.dex */
    public final class SearchAllRequestBuilder extends SearchBaseFragment.SearchRequestBuilder {
        private static transient /* synthetic */ IpChange $ipChange;

        private SearchAllRequestBuilder() {
            super();
        }

        @Override // cn.damai.search.v2.fragment.SearchBaseFragment.SearchRequestBuilder
        protected void setLoadMoreRequestParams(Map<String, String> map, Map<String, Object> map2) {
            int i;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-413021804")) {
                ipChange.ipc$dispatch("-413021804", new Object[]{this, map, map2});
                return;
            }
            int childCount = SearchAllResultFragment.this.getPageContainer().getChildCount();
            if (childCount <= 0 || SearchAllResultFragment.this.getPageContainer().getModules().size() <= (i = childCount - 1)) {
                return;
            }
            try {
                DrObj drObj = new DrObj(SearchAllResultFragment.this.getPageContainer().getModules().get(i).getProperty().getData().getString("layerId"), null, JSON.toJSONString(map2));
                map.put("dr", jn1.ARRAY_START_STR + JSON.toJSONString(drObj) + jn1.ARRAY_END_STR);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // cn.damai.search.v2.fragment.SearchBaseFragment, com.alient.onearch.adapter.BaseFragment
    @Nullable
    protected RequestBuilder createRequestBuilder(@Nullable Map<String, ?> map) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "853687563") ? (RequestBuilder) ipChange.ipc$dispatch("853687563", new Object[]{this, map}) : new SearchAllRequestBuilder();
    }

    @Override // cn.damai.search.v2.fragment.SearchBaseFragment, cn.damai.search.v2.listener.SearchInputObserver
    public void dispatchInputWord(InputInfo inputInfo) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-228474788")) {
            ipChange.ipc$dispatch("-228474788", new Object[]{this, inputInfo});
        } else if (inputInfo == null) {
        } else {
            this.noMoreNodeData.put("content", (Object) ("\"" + inputInfo.inputText + "\"相关搜索结果只有这么多啦"));
            super.dispatchInputWord(inputInfo);
        }
    }

    @Override // cn.damai.search.v2.fragment.SearchBaseFragment
    protected String getEmptyPageDesSuffix() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1924937918") ? (String) ipChange.ipc$dispatch("1924937918", new Object[]{this}) : ErrControlViewInfo.TYPE_ALL;
    }

    @Override // cn.damai.search.v2.fragment.SearchBaseFragment
    protected int getRequestPageSize() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1697662283")) {
            return ((Integer) ipChange.ipc$dispatch("-1697662283", new Object[]{this})).intValue();
        }
        return 15;
    }

    @Override // cn.damai.search.v2.fragment.SearchBaseFragment
    protected String getRequestPatternName() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1272144765") ? (String) ipChange.ipc$dispatch("-1272144765", new Object[]{this}) : "searchHome";
    }

    @Override // cn.damai.search.v2.fragment.SearchBaseFragment
    protected String getRequestPatternVersion() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "342053846") ? (String) ipChange.ipc$dispatch("342053846", new Object[]{this}) : LiveFullInfo.VER;
    }

    @Override // com.alibaba.pictures.bricks.component.ipbrand.ITab
    public String getTabTitle() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-890934886") ? (String) ipChange.ipc$dispatch("-890934886", new Object[]{this}) : SearchResultTabEnum.ALL.content;
    }

    @Override // cn.damai.search.v2.fragment.SearchBaseFragment, com.alient.onearch.adapter.BaseFragment, com.youku.arch.v3.page.GenericFragment
    protected void initPageLoader() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1037551897")) {
            ipChange.ipc$dispatch("1037551897", new Object[]{this});
            return;
        }
        SearchAllPageLoader searchAllPageLoader = new SearchAllPageLoader(this.pageContainer);
        this.pageLoader = searchAllPageLoader;
        searchAllPageLoader.setCallback(this);
        this.pageContainer.setPageLoader(this.pageLoader);
    }

    @Subscribe(eventType = {"switch_search_result_tab"})
    public void switchSearchResultTab(Event event) {
        Object obj;
        Integer num;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-754653487")) {
            ipChange.ipc$dispatch("-754653487", new Object[]{this, event});
        } else if (getActivity() == null || !(getActivity() instanceof SearchActivity) || event == null || (obj = event.data) == null || (num = (Integer) ((Map) obj).get("tabIndex")) == null) {
        } else {
            ((SearchActivity) getActivity()).switchSearchResultTab(num.intValue());
        }
    }
}
