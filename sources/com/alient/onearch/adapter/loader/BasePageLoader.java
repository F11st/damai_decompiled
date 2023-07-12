package com.alient.onearch.adapter.loader;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.android.ultron.trade.event.OpenSimplePopupSubscriber;
import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alient.onearch.adapter.decorate.ComponentDecorateItem;
import com.alient.onearch.adapter.decorate.ComponentDecorator;
import com.alient.onearch.adapter.pom.OneArchConstants;
import com.youku.arch.v3.IComponent;
import com.youku.arch.v3.IContainer;
import com.youku.arch.v3.IItem;
import com.youku.arch.v3.IModule;
import com.youku.arch.v3.adapter.VBaseAdapter;
import com.youku.arch.v3.adapter.VBaseHolder;
import com.youku.arch.v3.adapter.ViewTypeConfig;
import com.youku.arch.v3.adapter.ViewTypeSupport;
import com.youku.arch.v3.core.ActivityValue;
import com.youku.arch.v3.core.ComponentValue;
import com.youku.arch.v3.core.Config;
import com.youku.arch.v3.core.Constants;
import com.youku.arch.v3.core.IContext;
import com.youku.arch.v3.core.ItemValue;
import com.youku.arch.v3.core.ModelValue;
import com.youku.arch.v3.core.ModuleValue;
import com.youku.arch.v3.core.Node;
import com.youku.arch.v3.io.IResponse;
import com.youku.arch.v3.loader.PageLoader;
import com.youku.arch.v3.page.GenericFragment;
import com.youku.arch.v3.page.state.State;
import com.youku.arch.v3.util.IdGenerator;
import com.youku.arch.v3.view.render.GenericRenderConfig;
import com.youku.kubus.Event;
import com.youku.kubus.EventBus;
import com.youku.middlewareservice.provider.info.AppInfoProviderProxy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentMap;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.text.C8604o;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.wt2;
import tb.xl2;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010?\u001a\b\u0012\u0004\u0012\u00020>0=¢\u0006\u0004\b@\u0010AJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u001c\u0010\r\u001a\u00020\u00062\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\tH\u0016J\u0010\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\u0018\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J\u0018\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0011H\u0016J\u0018\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u000eH\u0016J\"\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u00022\b\u0010\u001a\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u001b\u001a\u00020\u0004H\u0016J\u0018\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u000eH\u0016J\u0018\u0010\u001f\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u000eH\u0016J\u001a\u0010 \u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u00022\b\u0010\u0017\u001a\u0004\u0018\u00010\u000eH\u0016J\u0018\u0010#\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00022\u0006\u0010\"\u001a\u00020!H\u0016J\u0010\u0010%\u001a\u00020\u00042\u0006\u0010$\u001a\u00020\nH&J\u001c\u0010'\u001a\u00020&2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00022\b\u0010\u0017\u001a\u0004\u0018\u00010\u000eH\u0016J\u001c\u0010)\u001a\u0004\u0018\u00010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010(\u001a\u00020&H\u0016J\u0018\u0010+\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020*2\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010-\u001a\u00020\u000e2\u0006\u0010,\u001a\u00020\u000eH\u0014R\u001c\u0010/\u001a\u00020.8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b/\u00100\u001a\u0004\b1\u00102R\u001c\u00104\u001a\u0002038\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b4\u00105\u001a\u0004\b6\u00107R\u001c\u00109\u001a\u0002088\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b9\u0010:\u001a\u0004\b;\u0010<¨\u0006B"}, d2 = {"Lcom/alient/onearch/adapter/loader/BasePageLoader;", "Lcom/youku/arch/v3/loader/PageLoader;", "Lcom/youku/arch/v3/core/Node;", "pageNode", "", "index", "Ltb/wt2;", "handleFirstLoad", "handleLoadMore", "", "", "", Constants.CONFIG, "load", "Lcom/alibaba/fastjson/JSONObject;", "response", "parseNode", "Lcom/alibaba/fastjson/JSONArray;", "layers", "parseLayers", "layerNode", "sections", "parseSections", "section", "parseSection", "sectionNode", "items", "limit", "parseItems", "item", "parseItem", "createHeaderSection", "createFooterSection", "Lcom/alient/onearch/adapter/decorate/ComponentDecorateItem;", "componentDecorateItemNode", "createDecorateSection", OpenSimplePopupSubscriber.KEY_COMPONENT_TYPE, "parseComponentType", "", "isInterceptCreateSection", "force", "createNoMoreSectionNode", "Lcom/youku/arch/v3/io/IResponse;", "handleLoadSuccess", "jsonObject", "findRootDataNode", "Lcom/alient/onearch/adapter/loader/ComponentTitleFilter;", "componentTitleFilter", "Lcom/alient/onearch/adapter/loader/ComponentTitleFilter;", "getComponentTitleFilter", "()Lcom/alient/onearch/adapter/loader/ComponentTitleFilter;", "Lcom/alient/onearch/adapter/loader/ComponentItemDisplayLimiter;", "componentItemDisplayLimiter", "Lcom/alient/onearch/adapter/loader/ComponentItemDisplayLimiter;", "getComponentItemDisplayLimiter", "()Lcom/alient/onearch/adapter/loader/ComponentItemDisplayLimiter;", "Lcom/alient/onearch/adapter/decorate/ComponentDecorator;", "componentDecorator", "Lcom/alient/onearch/adapter/decorate/ComponentDecorator;", "getComponentDecorator", "()Lcom/alient/onearch/adapter/decorate/ComponentDecorator;", "Lcom/youku/arch/v3/IContainer;", "Lcom/youku/arch/v3/core/ModelValue;", "pageContainer", "<init>", "(Lcom/youku/arch/v3/IContainer;)V", "onearch-adapter_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes10.dex */
public abstract class BasePageLoader extends PageLoader {
    @NotNull
    private final ComponentDecorator componentDecorator;
    @NotNull
    private final ComponentItemDisplayLimiter componentItemDisplayLimiter;
    @NotNull
    private final ComponentTitleFilter componentTitleFilter;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BasePageLoader(@NotNull IContainer<ModelValue> iContainer) {
        super(iContainer);
        b41.i(iContainer, "pageContainer");
        this.componentTitleFilter = new ComponentTitleFilter();
        this.componentItemDisplayLimiter = new ComponentItemDisplayLimiter();
        this.componentDecorator = new ComponentDecorator();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleFirstLoad(Node node, int i) {
        createNoMoreSectionNode(node, false);
        List<Node> children = node.getChildren();
        checkDuplicateModule(node, i);
        if (i == 1) {
            Bundle bundle = getHost().getPageContext().getBundle();
            if (bundle != null) {
                bundle.putSerializable("pageData", node);
            }
            ConcurrentMap<String, Object> concurrentMap = getHost().getPageContext().getConcurrentMap();
            if (concurrentMap != null) {
                concurrentMap.put("pageData", node);
            }
            EventBus eventBus = getHost().getPageContext().getEventBus();
            if (eventBus != null) {
                eventBus.post(new Event("CHANNEL_FIRST_PAGE_LOADED"));
            }
        }
        if (children != null && (!children.isEmpty())) {
            tryCreateModules(node, i);
            final IContext pageContext = getHost().getPageContext();
            pageContext.runOnUIThreadLocked(new Function0<wt2>() { // from class: com.alient.onearch.adapter.loader.BasePageLoader$handleFirstLoad$2$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                @Nullable
                public final wt2 invoke() {
                    RecyclerView recyclerView;
                    RecyclerView.Adapter adapter;
                    GenericFragment fragment;
                    RecyclerView recyclerView2;
                    GenericFragment fragment2 = IContext.this.getFragment();
                    if (fragment2 == null || (recyclerView = fragment2.getRecyclerView()) == null || (adapter = recyclerView.getAdapter()) == null) {
                        return null;
                    }
                    IContext iContext = IContext.this;
                    if (adapter.getItemCount() > 0 && (fragment = iContext.getFragment()) != null && (recyclerView2 = fragment.getRecyclerView()) != null) {
                        recyclerView2.scrollToPosition(0);
                    }
                    return wt2.INSTANCE;
                }
            });
            return;
        }
        getHost().clearModules();
        getHost().getPageContext().runOnUIThreadLocked(new Function0<wt2>() { // from class: com.alient.onearch.adapter.loader.BasePageLoader$handleFirstLoad$3
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
                IContainer host;
                host = BasePageLoader.this.getHost();
                host.updateContentAdapter();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleLoadMore(final Node node, int i) {
        if (node.getChildren() != null) {
            List<Node> children = node.getChildren();
            b41.f(children);
            if (!children.isEmpty()) {
                List<Node> children2 = node.getChildren();
                b41.f(children2);
                List<Node> children3 = node.getChildren();
                b41.f(children3);
                Node node2 = children2.get(children3.size() - 1);
                List<Node> children4 = node2.getChildren();
                b41.f(children4);
                List<Node> children5 = node2.getChildren();
                b41.f(children5);
                Node node3 = children4.get(children5.size() - 1);
                final IModule<ModuleValue> iModule = getHost().getModules().get(getHost().getModules().size() - 1);
                final IComponent<ComponentValue> iComponent = iModule.getComponents().get(iModule.getComponents().size() - 1);
                iComponent.getProperty().setMore(node3.getMore());
                final int childCount = iComponent.getChildCount();
                List<Node> children6 = node3.getChildren();
                b41.f(children6);
                iComponent.createItems(children6);
                final IContext pageContext = getHost().getPageContext();
                pageContext.runOnLoaderThreadLocked(new Function0<wt2>() { // from class: com.alient.onearch.adapter.loader.BasePageLoader$handleLoadMore$1$1$1
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
                        IContext iContext = IContext.this;
                        final IComponent<ComponentValue> iComponent2 = iComponent;
                        final int i2 = childCount;
                        iContext.runOnUIThreadLocked(new Function0<wt2>() { // from class: com.alient.onearch.adapter.loader.BasePageLoader$handleLoadMore$1$1$1.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            @Nullable
                            public final wt2 invoke() {
                                try {
                                    if (iComponent2.getInnerAdapter() != null) {
                                        VBaseAdapter<IItem<ItemValue>, VBaseHolder<IItem<ItemValue>, GenericRenderConfig>> innerAdapter = iComponent2.getInnerAdapter();
                                        if (innerAdapter != null) {
                                            innerAdapter.dataCount = iComponent2.getChildCount();
                                        }
                                        VBaseAdapter<IItem<ItemValue>, VBaseHolder<IItem<ItemValue>, GenericRenderConfig>> innerAdapter2 = iComponent2.getInnerAdapter();
                                        if (innerAdapter2 == null) {
                                            return null;
                                        }
                                        innerAdapter2.notifyItemRangeInserted(i2, iComponent2.getChildCount() - i2);
                                        return wt2.INSTANCE;
                                    }
                                    VBaseAdapter<IItem<ItemValue>, VBaseHolder<IItem<ItemValue>, GenericRenderConfig>> adapter = iComponent2.getAdapter();
                                    if (adapter != null) {
                                        adapter.dataCount = iComponent2.getChildCount();
                                    }
                                    VBaseAdapter<IItem<ItemValue>, VBaseHolder<IItem<ItemValue>, GenericRenderConfig>> adapter2 = iComponent2.getAdapter();
                                    if (adapter2 == null) {
                                        return null;
                                    }
                                    adapter2.notifyItemRangeInserted(i2, iComponent2.getChildCount() - i2);
                                    return wt2.INSTANCE;
                                } catch (Exception e) {
                                    e.printStackTrace();
                                    return wt2.INSTANCE;
                                }
                            }
                        });
                    }
                });
                getHost().getPageContext().runOnLoaderThread(new Function0<Node>() { // from class: com.alient.onearch.adapter.loader.BasePageLoader$handleLoadMore$2
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    @Nullable
                    public final Node invoke() {
                        IContainer host;
                        Node createNoMoreSectionNode = BasePageLoader.this.createNoMoreSectionNode(node, false);
                        if (createNoMoreSectionNode == null) {
                            return null;
                        }
                        IModule<ModuleValue> iModule2 = iModule;
                        try {
                            host = BasePageLoader.this.getHost();
                            IComponent<ComponentValue> createComponent = iModule2.createComponent(new Config<>(host.getPageContext(), createNoMoreSectionNode.getType(), createNoMoreSectionNode, 0, false, 24, null));
                            if (createComponent == null) {
                                return createNoMoreSectionNode;
                            }
                            iModule2.addComponent(iModule2.getComponents().size(), createComponent, true);
                            return createNoMoreSectionNode;
                        } catch (Exception e) {
                            if (AppInfoProviderProxy.isDebuggable()) {
                                throw new RuntimeException(e);
                            }
                            return createNoMoreSectionNode;
                        }
                    }
                });
                return;
            }
        }
        List<Node> children7 = node.getChildren();
        if (children7 != null) {
            Node node4 = new Node();
            node4.setChildren(new ArrayList());
            node4.setLevel(1);
            node4.setData(new JSONObject());
            node4.setId(UUID.randomUUID().hashCode());
            wt2 wt2Var = wt2.INSTANCE;
            children7.add(node4);
        }
        createNoMoreSectionNode(node, true);
        tryCreateModules(node, i);
    }

    @NotNull
    public Node createDecorateSection(@NotNull Node node, @NotNull ComponentDecorateItem componentDecorateItem) {
        b41.i(node, "layerNode");
        b41.i(componentDecorateItem, "componentDecorateItemNode");
        Node node2 = new Node();
        node2.setLevel(2);
        node2.setType(componentDecorateItem.getComponentType());
        node2.setId(IdGenerator.getId());
        node2.setParent(node);
        node2.setChildren(new ArrayList());
        List<Node> children = node2.getChildren();
        b41.f(children);
        Node node3 = new Node();
        node3.setLevel(3);
        node3.setData(componentDecorateItem.getData());
        node3.setParent(node2);
        node3.setType(componentDecorateItem.getComponentType());
        node3.setId(IdGenerator.getId());
        wt2 wt2Var = wt2.INSTANCE;
        children.add(node3);
        List<Node> children2 = node.getChildren();
        if (children2 != null) {
            children2.add(node2);
        }
        return node2;
    }

    public void createFooterSection(@NotNull Node node, @Nullable JSONObject jSONObject) {
        b41.i(node, "layerNode");
        List<Node> children = node.getChildren();
        if (children == null) {
            return;
        }
        Node node2 = new Node();
        node2.setLevel(2);
        node2.setType(parseComponentType(OneArchConstants.SectionFooterType.NORMAL));
        node2.setId(IdGenerator.getId());
        node2.setParent(node);
        node2.setChildren(new ArrayList());
        List<Node> children2 = node2.getChildren();
        b41.f(children2);
        Node node3 = new Node();
        node3.setLevel(3);
        node3.setData(jSONObject);
        node3.setParent(node2);
        node3.setType(parseComponentType(OneArchConstants.SectionFooterType.NORMAL));
        node3.setId(IdGenerator.getId());
        wt2 wt2Var = wt2.INSTANCE;
        children2.add(node3);
        children.add(node2);
    }

    public void createHeaderSection(@NotNull Node node, @NotNull JSONObject jSONObject) {
        b41.i(node, "layerNode");
        b41.i(jSONObject, "section");
        List<Node> children = node.getChildren();
        if (children == null) {
            return;
        }
        Node node2 = new Node();
        node2.setLevel(2);
        node2.setType(parseComponentType(OneArchConstants.SectionHeaderType.NORMAL));
        node2.setId(IdGenerator.getId());
        node2.setParent(node);
        node2.setChildren(new ArrayList());
        List<Node> children2 = node2.getChildren();
        b41.f(children2);
        Node node3 = new Node();
        node3.setLevel(3);
        node3.setData(new JSONObject());
        JSONObject data = node3.getData();
        b41.f(data);
        data.put((JSONObject) "title", jSONObject.getJSONObject("style").getString("title"));
        node3.setParent(node2);
        node3.setType(parseComponentType(OneArchConstants.SectionHeaderType.NORMAL));
        node3.setId(IdGenerator.getId());
        wt2 wt2Var = wt2.INSTANCE;
        children2.add(node3);
        ComponentDecorateItem componentDecorate = getComponentDecorator().getComponentDecorate(node2.getType(), ComponentDecorateItem.Indexer.Before);
        if (componentDecorate != null) {
            createDecorateSection(node, componentDecorate);
        }
        children.add(node2);
    }

    @Nullable
    public Node createNoMoreSectionNode(@Nullable Node node, boolean z) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.youku.arch.v3.loader.PageLoader
    @NotNull
    public JSONObject findRootDataNode(@NotNull JSONObject jSONObject) {
        b41.i(jSONObject, "jsonObject");
        if (jSONObject.containsKey("data")) {
            jSONObject = jSONObject.getJSONObject("data");
            b41.h(jSONObject, "jsonObject.getJSONObject(\"data\")");
        }
        return super.findRootDataNode(jSONObject);
    }

    @NotNull
    public ComponentDecorator getComponentDecorator() {
        return this.componentDecorator;
    }

    @NotNull
    public ComponentItemDisplayLimiter getComponentItemDisplayLimiter() {
        return this.componentItemDisplayLimiter;
    }

    @NotNull
    public ComponentTitleFilter getComponentTitleFilter() {
        return this.componentTitleFilter;
    }

    @Override // com.youku.arch.v3.loader.PageLoader, com.youku.arch.v3.loader.AbsLoader, com.youku.arch.v3.loader.PagingLoader
    public void handleLoadSuccess(@NotNull final IResponse iResponse, final int i) {
        b41.i(iResponse, "response");
        final IContext pageContext = getHost().getPageContext();
        pageContext.runOnLoaderThreadLocked(new Function0<Object>() { // from class: com.alient.onearch.adapter.loader.BasePageLoader$handleLoadSuccess$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final Object invoke() {
                ActivityValue parseActivityValue;
                try {
                    JSONObject jsonObject = IResponse.this.getJsonObject();
                    if (jsonObject == null) {
                        return null;
                    }
                    BasePageLoader basePageLoader = this;
                    IContext iContext = pageContext;
                    int i2 = i;
                    IResponse iResponse2 = IResponse.this;
                    Node parseNode = basePageLoader.parseNode(basePageLoader.findRootDataNode(jsonObject));
                    parseActivityValue = basePageLoader.parseActivityValue(parseNode.getData());
                    iContext.setActivityValue(parseActivityValue);
                    if (i2 > 1) {
                        basePageLoader.handleLoadMore(parseNode, i2);
                    } else {
                        basePageLoader.handleFirstLoad(parseNode, i2);
                    }
                    basePageLoader.setLoadingPage(0);
                    basePageLoader.handleLoadFinish(iResponse2, true, i2);
                    return jsonObject;
                } catch (Exception unused) {
                    this.handleLoadFinish(IResponse.this, false, i);
                    return wt2.INSTANCE;
                }
            }
        });
    }

    public boolean isInterceptCreateSection(@Nullable Node node, @Nullable JSONObject jSONObject) {
        return false;
    }

    @Override // com.youku.arch.v3.loader.AbsLoader, com.youku.arch.v3.loader.PagingLoader
    public void load(@NotNull Map<String, ? extends Object> map) {
        GenericFragment fragment;
        b41.i(map, Constants.CONFIG);
        Integer num = (Integer) map.get("index");
        if (num != null && num.intValue() <= 1 && (fragment = getHost().getPageContext().getFragment()) != null) {
            RecyclerView recyclerView = fragment.getRecyclerView();
            RecyclerView.Adapter adapter = recyclerView == null ? null : recyclerView.getAdapter();
            if (adapter instanceof DelegateAdapter) {
                ((DelegateAdapter) adapter).clear();
                adapter.notifyDataSetChanged();
            }
            fragment.getPageStateManager().setState(State.LOADING);
        }
        super.load(map);
    }

    public abstract int parseComponentType(@NotNull String str);

    public void parseItem(@NotNull Node node, @NotNull JSONObject jSONObject) {
        ViewTypeConfig viewTypeConfig;
        HashMap<String, Object> params;
        Object obj;
        b41.i(node, "sectionNode");
        b41.i(jSONObject, "item");
        Node node2 = new Node();
        node2.setLevel(3);
        node2.setData(new JSONObject());
        node2.setChildren(new ArrayList());
        node2.setType(node.getType());
        node2.setId(node.getId());
        if (node2.getConfig() == null) {
            node2.setConfig(new JSONObject());
        }
        ViewTypeSupport viewTypeSupport = getHost().getPageContext().getViewTypeSupport();
        if (viewTypeSupport != null && (viewTypeConfig = viewTypeSupport.getViewTypeConfig(node2.getType())) != null && (params = viewTypeConfig.getParams()) != null && (obj = params.get("bean")) != null) {
            JSONObject config = node2.getConfig();
            b41.f(config);
            config.put((JSONObject) "bean", (String) obj);
        }
        for (String str : jSONObject.keySet()) {
            JSONObject data = node2.getData();
            b41.f(data);
            data.put((JSONObject) str, (String) jSONObject.get(str));
        }
        node2.setParent(node);
        List<Node> children = node.getChildren();
        if (children == null) {
            return;
        }
        children.add(node2);
    }

    public void parseItems(@NotNull Node node, @Nullable JSONArray jSONArray, int i) {
        b41.i(node, "sectionNode");
        if (jSONArray == null) {
            return;
        }
        int i2 = 0;
        if (i <= 0) {
            return;
        }
        while (true) {
            int i3 = i2 + 1;
            JSONObject jSONObject = jSONArray.getJSONObject(i2);
            b41.h(jSONObject, "getJSONObject(index)");
            parseItem(node, jSONObject);
            if (i3 >= i) {
                return;
            }
            i2 = i3;
        }
    }

    public void parseLayers(@NotNull Node node, @NotNull JSONArray jSONArray) {
        List<Node> children;
        boolean q;
        b41.i(node, "pageNode");
        b41.i(jSONArray, "layers");
        int size = jSONArray.size() - 1;
        if (size < 0) {
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i + 1;
            JSONObject jSONObject = jSONArray.getJSONObject(i);
            if (jSONObject.getJSONArray("sections") != null) {
                Node node2 = new Node();
                node2.setLevel(1);
                node2.setData(new JSONObject());
                node2.setId(jSONObject.getString("layerId").hashCode());
                node2.setChildren(new ArrayList());
                for (String str : jSONObject.keySet()) {
                    q = C8604o.q(str, "sections", true);
                    if (q) {
                        JSONArray jSONArray2 = jSONObject.getJSONArray("sections");
                        b41.h(jSONArray2, "getJSONArray(\"sections\")");
                        parseSections(node2, jSONArray2);
                    } else {
                        JSONObject data = node2.getData();
                        b41.f(data);
                        data.put((JSONObject) str, (String) jSONObject.get(str));
                    }
                }
                b41.f(node2.getChildren());
                if (!children.isEmpty()) {
                    node2.setParent(node);
                    List<Node> children2 = node.getChildren();
                    if (children2 != null) {
                        children2.add(node2);
                    }
                }
            }
            if (i2 > size) {
                return;
            }
            i = i2;
        }
    }

    @Override // com.youku.arch.v3.loader.PageLoader
    @NotNull
    public Node parseNode(@NotNull JSONObject jSONObject) {
        boolean q;
        b41.i(jSONObject, "response");
        Node node = new Node();
        node.setLevel(0);
        node.setData(new JSONObject());
        node.setChildren(new ArrayList());
        for (String str : jSONObject.keySet()) {
            q = C8604o.q(str, "layers", true);
            if (q) {
                JSONArray jSONArray = jSONObject.getJSONArray("layers");
                b41.h(jSONArray, "response.getJSONArray(\"layers\")");
                parseLayers(node, jSONArray);
            } else {
                JSONObject data = node.getData();
                b41.f(data);
                data.put((JSONObject) str, (String) jSONObject.get(str));
            }
        }
        return node;
    }

    public void parseSection(@NotNull Node node, @NotNull JSONObject jSONObject) {
        ComponentDecorateItem componentDecorate;
        boolean q;
        boolean q2;
        boolean q3;
        b41.i(node, "layerNode");
        b41.i(jSONObject, "section");
        if (isInterceptCreateSection(node, jSONObject)) {
            return;
        }
        String string = jSONObject.getString("componentId");
        boolean z = false;
        if (string == null || string.length() == 0) {
            return;
        }
        String string2 = jSONObject.getString("sectionId");
        if (string2 == null || string2.length() == 0) {
            return;
        }
        Node node2 = new Node();
        node2.setLevel(2);
        node2.setData(new JSONObject());
        String string3 = jSONObject.getString("componentId");
        b41.h(string3, "section.getString(\"componentId\")");
        node2.setType(parseComponentType(string3));
        node2.setId(jSONObject.getString("sectionId").hashCode());
        node2.setChildren(new ArrayList());
        if (!jSONObject.containsKey("item") || jSONObject.getJSONObject("item") == null) {
            return;
        }
        for (String str : jSONObject.keySet()) {
            q = C8604o.q(str, "item", true);
            if (q) {
                JSONObject jSONObject2 = jSONObject.getJSONObject("item");
                for (String str2 : jSONObject2.keySet()) {
                    if (!jSONObject2.containsKey("list") && !jSONObject2.containsKey("result")) {
                        return;
                    }
                    q2 = C8604o.q(str2, "list", true);
                    if (!q2) {
                        q3 = C8604o.q(str2, "result", true);
                        if (!q3) {
                            JSONObject data = node2.getData();
                            if (data != null) {
                                data.put((JSONObject) str2, (String) jSONObject2.get(str2));
                            }
                        }
                    }
                    JSONArray jSONArray = jSONObject2.getJSONArray("list") == null ? jSONObject2.getJSONArray("result") : jSONObject2.getJSONArray("list");
                    if (jSONArray == null || jSONArray.isEmpty()) {
                        return;
                    }
                    if (getComponentItemDisplayLimiter().hasComponentLimitSize(node2.getType())) {
                        Integer geComponentLimitSize = getComponentItemDisplayLimiter().geComponentLimitSize(node2.getType());
                        if (geComponentLimitSize != null) {
                            int intValue = geComponentLimitSize.intValue();
                            if (intValue <= 0) {
                                parseItems(node2, jSONArray, jSONArray.size());
                                if (jSONObject2.containsKey(xl2.HAS_NEXT) && jSONObject2.getBooleanValue(xl2.HAS_NEXT)) {
                                    node2.setMore(true);
                                    z = true;
                                }
                            } else {
                                parseItems(node2, jSONArray, Math.min(intValue, jSONArray.size()));
                                if (intValue < jSONArray.size()) {
                                    node2.setMore(true);
                                    z = true;
                                }
                                if (jSONObject2.containsKey(xl2.HAS_NEXT) && jSONObject2.getBooleanValue(xl2.HAS_NEXT)) {
                                    node2.setMore(true);
                                    z = true;
                                }
                            }
                        }
                    } else {
                        parseItems(node2, jSONArray, jSONArray.size());
                        if (jSONObject2.containsKey(xl2.HAS_NEXT)) {
                            Boolean bool = jSONObject2.getBoolean(xl2.HAS_NEXT);
                            b41.h(bool, "sectionItemsData.getBool…                        )");
                            if (bool.booleanValue()) {
                                node2.setMore(true);
                            }
                        }
                    }
                }
                continue;
            } else {
                JSONObject data2 = node2.getData();
                if (data2 != null) {
                    data2.put((JSONObject) str, (String) jSONObject.get(str));
                }
            }
        }
        ComponentDecorateItem componentDecorate2 = getComponentDecorator().getComponentDecorate(node2.getType(), ComponentDecorateItem.Indexer.Before);
        if (componentDecorate2 != null) {
            createDecorateSection(node, componentDecorate2);
        }
        if (jSONObject.containsKey("style") && !TextUtils.isEmpty(jSONObject.getJSONObject("style").getString("title")) && !getComponentTitleFilter().isFilterTitle(node2.getType())) {
            createHeaderSection(node, jSONObject);
        }
        node2.setParent(node);
        List<Node> children = node.getChildren();
        if (children != null) {
            children.add(node2);
        }
        if (z) {
            createFooterSection(node, jSONObject);
        }
        if (node2.getMore() || (componentDecorate = getComponentDecorator().getComponentDecorate(node2.getType(), ComponentDecorateItem.Indexer.After)) == null) {
            return;
        }
        createDecorateSection(node, componentDecorate);
    }

    public void parseSections(@NotNull Node node, @NotNull JSONArray jSONArray) {
        b41.i(node, "layerNode");
        b41.i(jSONArray, "sections");
        int size = jSONArray.size() - 1;
        if (size < 0) {
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i + 1;
            JSONObject jSONObject = jSONArray.getJSONObject(i);
            b41.h(jSONObject, "sections.getJSONObject(index)");
            parseSection(node, jSONObject);
            if (i2 > size) {
                return;
            }
            i = i2;
        }
    }
}
