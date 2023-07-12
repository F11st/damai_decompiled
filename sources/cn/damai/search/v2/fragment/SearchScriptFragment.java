package cn.damai.search.v2.fragment;

import android.os.Bundle;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import cn.damai.onearch.errpage.bean.ErrControlViewInfo;
import cn.damai.search.bean.SearchResultTabEnum;
import cn.damai.search.component.script.ScriptComponentCreator;
import cn.damai.search.component.script.ScriptMoreComponentCreator;
import cn.damai.search.v2.bean.InputInfo;
import cn.damai.search.v2.fragment.SearchBaseFragment;
import cn.damai.search.v2.fragment.SearchScriptFragment;
import com.alibaba.fastjson.JSONObject;
import com.alient.onearch.adapter.component.divider.DividerModel;
import com.alient.onearch.adapter.decorate.ComponentDecorateItem;
import com.alient.onearch.adapter.decorate.ComponentDecorator;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.IContainer;
import com.youku.arch.v3.IModule;
import com.youku.arch.v3.core.ModelValue;
import com.youku.arch.v3.core.ModuleValue;
import com.youku.arch.v3.core.Node;
import com.youku.arch.v3.io.IResponse;
import com.youku.arch.v3.util.IdGenerator;
import com.youku.kubus.Event;
import com.youku.kubus.Subscribe;
import java.util.ArrayList;
import java.util.Map;
import kotlin.jvm.functions.Function0;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class SearchScriptFragment extends SearchBaseFragment {
    private static transient /* synthetic */ IpChange $ipChange;

    /* compiled from: Taobao */
    /* loaded from: classes6.dex */
    public final class SearchScriptPageLoader extends SearchBaseFragment.SearchPageLoader {
        private static transient /* synthetic */ IpChange $ipChange;

        public SearchScriptPageLoader(IContainer<ModelValue> iContainer) {
            super(iContainer);
            getComponentItemDisplayLimiter().addComponentLimitSize(1008, 5);
            getComponentItemDisplayLimiter().addComponentLimitSize(1009, 5);
            getComponentItemDisplayLimiter().addComponentLimitSize(1010, 5);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(DividerModel.DIVIDER_COLOR, (Object) "#F5F6F7");
            ComponentDecorator componentDecorator = getComponentDecorator();
            ComponentDecorateItem.Indexer indexer = ComponentDecorateItem.Indexer.Before;
            componentDecorator.addComponentDecorate(1008, new ComponentDecorateItem(2, 2, jSONObject, indexer));
            getComponentDecorator().addComponentDecorate(1009, new ComponentDecorateItem(2, 2, jSONObject, indexer));
            getComponentDecorator().addComponentDecorate(1010, new ComponentDecorateItem(2, 2, jSONObject, indexer));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ Object lambda$setLoadingViewState$0() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-381842312")) {
                return ipChange.ipc$dispatch("-381842312", new Object[]{this});
            }
            if (SearchScriptFragment.this.getRefreshLayout() != null) {
                SearchScriptFragment.this.getRefreshLayout().setEnableLoadMore(false);
                return null;
            }
            return null;
        }

        @Override // com.alient.onearch.adapter.loader.BasePageLoader
        public void createFooterSection(@NonNull Node node, @Nullable JSONObject jSONObject) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "905547253")) {
                ipChange.ipc$dispatch("905547253", new Object[]{this, node, jSONObject});
                return;
            }
            Node node2 = new Node();
            node2.setLevel(2);
            node2.setType(1011);
            node2.setData(jSONObject);
            node2.setId(IdGenerator.getId());
            node2.setParent(node);
            node2.setChildren(new ArrayList());
            Node node3 = new Node();
            node3.setLevel(3);
            node3.setType(1011);
            node3.setData(jSONObject);
            node3.setId(IdGenerator.getId());
            node3.setParent(node2);
            if (node2.getChildren() != null) {
                node2.getChildren().add(node3);
            }
            if (node.getChildren() == null || node.getChildren().isEmpty()) {
                return;
            }
            node.getChildren().add(node2);
        }

        @Override // cn.damai.search.v2.fragment.SearchBaseFragment.SearchPageLoader, com.alient.onearch.adapter.loader.BasePageLoader
        public Node createNoMoreSectionNode(Node node, boolean z) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1027101726")) {
                return (Node) ipChange.ipc$dispatch("1027101726", new Object[]{this, node, Boolean.valueOf(z)});
            }
            return null;
        }

        @Override // cn.damai.search.v2.fragment.SearchBaseFragment.SearchPageLoader, com.alient.onearch.adapter.loader.BasePageLoader, com.youku.arch.v3.loader.PageLoader
        @NonNull
        public Node parseNode(@NonNull JSONObject jSONObject) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1903112866")) {
                return (Node) ipChange.ipc$dispatch("1903112866", new Object[]{this, jSONObject});
            }
            Node parseNode = super.parseNode(jSONObject);
            if (parseNode.getChildren() != null && !parseNode.getChildren().isEmpty()) {
                Node node = parseNode.getChildren().get(0);
                if (node.getChildren() != null && !node.getChildren().isEmpty()) {
                    Node node2 = node.getChildren().get(0);
                    if (node2.getType() == 2) {
                        node.getChildren().remove(node2);
                    }
                }
                Node node3 = parseNode.getChildren().get(parseNode.getChildren().size() - 1);
                if (node3.getChildren() != null && !node3.getChildren().isEmpty() && node3.getChildren().get(node3.getChildren().size() - 1).getType() != 1011) {
                    super.createNoMoreSectionNode(parseNode, true);
                }
            }
            return parseNode;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // cn.damai.search.v2.fragment.SearchBaseFragment.SearchPageLoader
        public void setLoadingViewState(IResponse iResponse) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1351514302")) {
                ipChange.ipc$dispatch("1351514302", new Object[]{this, iResponse});
                return;
            }
            super.setLoadingViewState(iResponse);
            SearchScriptFragment.this.pageContainer.getPageContext().runOnUIThread(new Function0() { // from class: tb.z72
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Object lambda$setLoadingViewState$0;
                    lambda$setLoadingViewState$0 = SearchScriptFragment.SearchScriptPageLoader.this.lambda$setLoadingViewState$0();
                    return lambda$setLoadingViewState$0;
                }
            });
        }
    }

    @Override // cn.damai.search.v2.fragment.SearchBaseFragment, cn.damai.search.v2.listener.SearchInputObserver
    public void dispatchInputWord(InputInfo inputInfo) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "210648545")) {
            ipChange.ipc$dispatch("210648545", new Object[]{this, inputInfo});
        } else if (inputInfo == null) {
        } else {
            this.noMoreNodeData.put("content", (Object) ("\"" + inputInfo.inputText + "\"相关剧本杀只有这么多啦"));
            super.dispatchInputWord(inputInfo);
        }
    }

    @Override // cn.damai.search.v2.fragment.SearchBaseFragment
    protected String getEmptyPageDesSuffix() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1508545283") ? (String) ipChange.ipc$dispatch("1508545283", new Object[]{this}) : ErrControlViewInfo.TYPE_SCRIPT;
    }

    @Override // cn.damai.search.v2.fragment.SearchBaseFragment
    protected int getRequestPageSize() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-322164358")) {
            return ((Integer) ipChange.ipc$dispatch("-322164358", new Object[]{this})).intValue();
        }
        return 5;
    }

    @Override // cn.damai.search.v2.fragment.SearchBaseFragment
    protected String getRequestPatternName() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1688537400") ? (String) ipChange.ipc$dispatch("-1688537400", new Object[]{this}) : "searchScriptKill";
    }

    @Override // cn.damai.search.v2.fragment.SearchBaseFragment
    protected String getRequestPatternVersion() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-545384591") ? (String) ipChange.ipc$dispatch("-545384591", new Object[]{this}) : "1.0";
    }

    @Override // com.alibaba.pictures.bricks.component.ipbrand.ITab
    public String getTabTitle() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1431443937") ? (String) ipChange.ipc$dispatch("-1431443937", new Object[]{this}) : SearchResultTabEnum.SCRIPT.content;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.alient.onearch.adapter.BaseFragment, com.youku.arch.v3.page.GenericFragment
    public void initConfigManager() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-766313473")) {
            ipChange.ipc$dispatch("-766313473", new Object[]{this});
            return;
        }
        super.initConfigManager();
        if (getPageContext().getConfigManager() != null) {
            getPageContext().getConfigManager().getCreatorConfig(2).addCreator(1008, new ScriptComponentCreator());
            getPageContext().getConfigManager().getCreatorConfig(2).addCreator(1009, new ScriptComponentCreator());
            getPageContext().getConfigManager().getCreatorConfig(2).addCreator(1010, new ScriptComponentCreator());
            getPageContext().getConfigManager().getCreatorConfig(2).addCreator(1011, new ScriptMoreComponentCreator());
        }
    }

    @Override // cn.damai.search.v2.fragment.SearchBaseFragment, com.alient.onearch.adapter.BaseFragment, com.youku.arch.v3.page.GenericFragment
    protected void initPageLoader() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-771988898")) {
            ipChange.ipc$dispatch("-771988898", new Object[]{this});
            return;
        }
        SearchScriptPageLoader searchScriptPageLoader = new SearchScriptPageLoader(this.pageContainer);
        this.pageLoader = searchScriptPageLoader;
        searchScriptPageLoader.setCallback(this);
        this.pageContainer.setPageLoader(this.pageLoader);
    }

    @Subscribe(eventType = {"script_load_more", "script_all_loaded"})
    public void onComponentMessage(Event event) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1963940461")) {
            ipChange.ipc$dispatch("1963940461", new Object[]{this, event});
            return;
        }
        for (int i = 0; i < this.pageContainer.getModules().size(); i++) {
            IModule<ModuleValue> iModule = this.pageContainer.getModules().get(i);
            for (int i2 = 0; i2 < iModule.getComponents().size(); i2++) {
                iModule.getComponents().get(i2).onMessage(event.type, (Map) event.data);
            }
        }
    }

    @Override // cn.damai.search.v2.fragment.SearchBaseFragment, com.alient.onearch.adapter.BaseFragment, com.youku.arch.v3.page.GenericFragment, androidx.fragment.app.Fragment
    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "500876760")) {
            ipChange.ipc$dispatch("500876760", new Object[]{this, view, bundle});
            return;
        }
        super.onViewCreated(view, bundle);
        getRefreshLayout().setEnableLoadMore(false);
    }
}
