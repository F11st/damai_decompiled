package com.alient.onearch.adapter.component.tab.generic;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.alibaba.fastjson.JSONObject;
import com.alient.onearch.adapter.R;
import com.alient.onearch.adapter.component.tab.GenericTabViewContainer;
import com.alient.onearch.adapter.component.tab.ITabSelectedListener;
import com.alient.onearch.adapter.component.tab.base.BaseTabView;
import com.alient.onearch.adapter.component.tab.generic.GenericTabContract;
import com.alient.onearch.adapter.view.BaseViewHolder;
import com.alient.onearch.adapter.widget.OneTabLayout;
import com.alient.oneservice.ut.TrackInfo;
import com.alient.oneservice.ut.UserTrackProviderProxy;
import com.google.android.material.tabs.TabLayout;
import com.youku.arch.v3.IItem;
import com.youku.arch.v3.adapter.VBaseHolder;
import com.youku.arch.v3.adapter.ViewTypeConfig;
import com.youku.arch.v3.adapter.ViewTypeSupport;
import com.youku.arch.v3.core.ConfigManager;
import com.youku.arch.v3.core.ItemValue;
import com.youku.arch.v3.core.Node;
import com.youku.arch.v3.core.item.GenericItem;
import com.youku.arch.v3.event.ViewHolderEvent;
import com.youku.arch.v3.view.render.AbsRenderPlugin;
import com.youku.arch.v3.view.render.GenericRenderConfig;
import com.youku.arch.v3.view.render.GenericRenderPlugin;
import com.youku.arch.v3.view.render.RenderPluginConfigCenter;
import com.youku.arch.v3.view.render.RenderPluginFactory;
import com.youku.middlewareservice.provider.info.AppInfoProviderProxy;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.m;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0094\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u00002\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00012\u00020\u0006B\u000f\u0012\u0006\u0010&\u001a\u00020%¢\u0006\u0004\b7\u00108J\u0018\u0010\f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0002J\u0018\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0007H\u0002J\b\u0010\u0011\u001a\u00020\u000bH\u0016J\b\u0010\u0012\u001a\u00020\u000bH\u0016J@\u0010\u001b\u001a\u00020\u000b2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00030\u00132\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u00152\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\u00152\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\r0\u0015H\u0016J&\u0010!\u001a\u00020\t2\u0006\u0010\u001d\u001a\u00020\u001c2\u0014\u0010 \u001a\u0010\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u001eH\u0016J\u0010\u0010$\u001a\u00020\u000b2\u0006\u0010#\u001a\u00020\"H\u0016R\u0019\u0010&\u001a\u00020%8\u0006@\u0006¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)R\u0016\u0010+\u001a\u00020*8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b+\u0010,R.\u00100\u001a\u001a\u0012\u0016\u0012\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0013\u0012\u0004\u0012\u00020/0.0-8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b0\u00101R\"\u00104\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u000203028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b4\u00105R\"\u00106\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u000203028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b6\u00105¨\u00069"}, d2 = {"Lcom/alient/onearch/adapter/component/tab/generic/GenericTabView;", "Lcom/alient/onearch/adapter/component/tab/base/BaseTabView;", "Lcom/youku/arch/v3/core/item/GenericItem;", "Lcom/youku/arch/v3/core/ItemValue;", "Lcom/alient/onearch/adapter/component/tab/generic/GenericTabModel;", "Lcom/alient/onearch/adapter/component/tab/generic/GenericTabPresenter;", "Lcom/alient/onearch/adapter/component/tab/generic/GenericTabContract$View;", "", "position", "", "clickTab", "Ltb/wt2;", "showCurrentComponent", "Lcom/youku/arch/v3/core/Node;", "componentNode", "index", "createChildComponent", "showTabIndicator", "hideTabIndicator", "Lcom/youku/arch/v3/IItem;", "containerItem", "", "Lcom/alient/onearch/adapter/widget/RichTitle;", "childComponentTitles", "Lcom/alibaba/fastjson/JSONArray;", "childComponentBtns", "childComponentNodes", "setChildComponentData", "", "type", "", "", "map", "dispatchViewHolderMessage", "Lcom/google/android/material/tabs/TabLayout$Tab;", "tab", "onTabSelected", "Landroid/view/View;", "view", "Landroid/view/View;", "getView", "()Landroid/view/View;", "Lcom/alient/onearch/adapter/component/tab/GenericTabViewContainer;", "contentContainer", "Lcom/alient/onearch/adapter/component/tab/GenericTabViewContainer;", "", "Lcom/youku/arch/v3/adapter/VBaseHolder;", "Lcom/youku/arch/v3/view/render/GenericRenderConfig;", "componentViewHolders", "Ljava/util/List;", "", "Lcom/alient/oneservice/ut/TrackInfo;", "tabTrackInfos", "Ljava/util/Map;", "componentTrackInfos", "<init>", "(Landroid/view/View;)V", "onearch-adapter_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes10.dex */
public class GenericTabView extends BaseTabView<GenericItem<ItemValue>, GenericTabModel, GenericTabPresenter> implements GenericTabContract.View {
    @NotNull
    private Map<String, TrackInfo> componentTrackInfos;
    @NotNull
    private final List<VBaseHolder<IItem<ItemValue>, GenericRenderConfig>> componentViewHolders;
    @NotNull
    private final GenericTabViewContainer contentContainer;
    @NotNull
    private Map<String, TrackInfo> tabTrackInfos;
    @NotNull
    private final View view;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GenericTabView(@NotNull View view) {
        super(view);
        b41.i(view, "view");
        this.view = view;
        View findViewById = view.findViewById(R.id.content_container);
        b41.h(findViewById, "view.findViewById(R.id.content_container)");
        this.contentContainer = (GenericTabViewContainer) findViewById;
        this.componentViewHolders = new ArrayList();
        this.tabTrackInfos = new LinkedHashMap();
        this.componentTrackInfos = new LinkedHashMap();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v11, types: [com.youku.arch.v3.core.ItemValue, com.youku.arch.v3.core.Node] */
    /* JADX WARN: Type inference failed for: r1v22, types: [com.youku.arch.v3.core.ItemValue, com.youku.arch.v3.core.Node] */
    private final void createChildComponent(Node node, int i) {
        ViewTypeConfig viewTypeConfig;
        Integer layoutResId;
        ViewTypeSupport viewTypeSupport = getContainerItem().getPageContext().getViewTypeSupport();
        if (viewTypeSupport == null || (viewTypeConfig = viewTypeSupport.getViewTypeConfig(node.getType() << 16)) == null || (layoutResId = viewTypeConfig.getLayoutResId()) == null) {
            return;
        }
        View inflate = LayoutInflater.from(getView().getContext()).inflate(layoutResId.intValue(), (ViewGroup) null, false);
        if (inflate == null) {
            return;
        }
        Class<?> viewHolderClass = viewTypeConfig.getViewHolderClass();
        Constructor<?> constructor = viewHolderClass == null ? null : viewHolderClass.getConstructor(View.class);
        VBaseHolder vBaseHolder = constructor == null ? null : (VBaseHolder) constructor.newInstance(inflate);
        ConfigManager configManager = getContainerItem().getPageContext().getConfigManager();
        String pathConfig = configManager == null ? null : configManager.getPathConfig(ConfigManager.COMPONENT_CONFIG_FILE);
        RenderPluginConfigCenter.Companion companion = RenderPluginConfigCenter.Companion;
        if (!companion.getInstance().isSupportRenderPlugin(getContainerItem().getPageContext(), pathConfig, String.valueOf(viewTypeConfig.getViewType()))) {
            if (vBaseHolder == null) {
                return;
            }
            try {
                vBaseHolder.setPageContext(getContainerItem().getPageContext());
                Context context = this.contentContainer.getContext();
                b41.h(context, "contentContainer.context");
                vBaseHolder.setContext(context);
                vBaseHolder.onCreate();
                GenericItem genericItem = new GenericItem(getContainerItem().getPageContext());
                genericItem.setProperty(new ItemValue(node));
                genericItem.setType(node.getType());
                genericItem.setComponent(getContainerItem().getComponent());
                genericItem.getProperty().setData(node.getData());
                genericItem.getExtra().putInt("index", i);
                vBaseHolder.setData(genericItem);
                if (i < this.componentViewHolders.size()) {
                    this.componentViewHolders.set(i, vBaseHolder);
                } else {
                    this.componentViewHolders.add(vBaseHolder);
                }
                return;
            } catch (Exception e) {
                if (AppInfoProviderProxy.isDebuggable()) {
                    throw e;
                }
                return;
            }
        }
        GenericRenderConfig genericRenderConfig = new GenericRenderConfig();
        genericRenderConfig.setType(String.valueOf(viewTypeConfig.getViewType()));
        genericRenderConfig.setMClassName(viewTypeConfig.getModel());
        genericRenderConfig.setMClassNameOpt(viewTypeConfig.getModelOpt());
        genericRenderConfig.setVClassName(viewTypeConfig.getView());
        genericRenderConfig.setVClassNameOpt(viewTypeConfig.getViewOpt());
        genericRenderConfig.setPClassName(viewTypeConfig.getPresenter());
        genericRenderConfig.setPClassNameOpt(viewTypeConfig.getPresenterOpt());
        genericRenderConfig.setLayoutId(viewTypeConfig.getLayoutResId());
        genericRenderConfig.setLayoutIdOpt(viewTypeConfig.getLayoutResIdOpt());
        genericRenderConfig.setLayoutStr(viewTypeConfig.getLayoutResString());
        genericRenderConfig.setLayoutStrOpt(viewTypeConfig.getLayoutResStringOpt());
        genericRenderConfig.setExtra(viewTypeConfig.wrapParams(genericRenderConfig.getExtra()));
        RenderPluginFactory renderPluginFactory = companion.getInstance().getRenderPluginFactory(pathConfig, String.valueOf(viewTypeConfig.getViewType()));
        AbsRenderPlugin<?, ?> create = renderPluginFactory == null ? null : renderPluginFactory.create();
        if (!(create instanceof AbsRenderPlugin)) {
            create = null;
        }
        if (create != null) {
            create.attachContext(getContainerItem().getPageContext());
        }
        GenericRenderPlugin genericRenderPlugin = create instanceof GenericRenderPlugin ? create : null;
        if (genericRenderPlugin != null) {
            genericRenderPlugin.setRenderView(inflate);
        }
        if (create != null) {
            try {
                create.setConfig(genericRenderConfig);
            } catch (Exception e2) {
                if (AppInfoProviderProxy.isDebuggable()) {
                    throw e2;
                }
                return;
            }
        }
        if (vBaseHolder == null) {
            return;
        }
        vBaseHolder.setPageContext(getContainerItem().getPageContext());
        Context context2 = this.contentContainer.getContext();
        b41.h(context2, "contentContainer.context");
        vBaseHolder.setContext(context2);
        vBaseHolder.setRenderPlugin(create);
        GenericItem genericItem2 = new GenericItem(getContainerItem().getPageContext());
        genericItem2.setProperty(new ItemValue(node));
        genericItem2.setType(node.getType());
        genericItem2.setComponent(getContainerItem().getComponent());
        genericItem2.getProperty().setData(node.getData());
        genericItem2.getExtra().putInt("index", i);
        vBaseHolder.setData(genericItem2);
        if (i < this.componentViewHolders.size()) {
            this.componentViewHolders.set(i, vBaseHolder);
        } else {
            this.componentViewHolders.add(vBaseHolder);
        }
    }

    private final void showCurrentComponent(int i, boolean z) {
        TabLayout.Tab tabAt;
        BaseViewHolder baseViewHolder;
        ItemValue property;
        JSONObject data;
        String string;
        TrackInfo trackInfo;
        this.contentContainer.removeAllViews();
        int i2 = 0;
        for (Object obj : this.componentViewHolders) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                m.p();
            }
            VBaseHolder vBaseHolder = (VBaseHolder) obj;
            ITabSelectedListener iTabSelectedListener = vBaseHolder instanceof ITabSelectedListener ? (ITabSelectedListener) vBaseHolder : null;
            if (iTabSelectedListener != null) {
                iTabSelectedListener.onTabSelected(i);
            }
            if (i2 == i) {
                baseViewHolder = vBaseHolder instanceof BaseViewHolder ? (BaseViewHolder) vBaseHolder : null;
                if (baseViewHolder != null) {
                    baseViewHolder.setSelected(true);
                }
                IItem data2 = vBaseHolder.getData();
                if (data2 != null && (property = data2.getProperty()) != null && (data = property.getData()) != null && (string = data.getString("nodeId")) != null) {
                    TrackInfo trackInfo2 = this.componentTrackInfos.get(string);
                    if (trackInfo2 != null) {
                        View view = vBaseHolder.itemView;
                        StringBuilder sb = new StringBuilder();
                        sb.append(vBaseHolder.itemView.getId());
                        sb.append((Object) trackInfo2.getSpmc());
                        sb.append((Object) trackInfo2.getSpmd());
                        UserTrackProviderProxy.expose(view, sb.toString(), trackInfo2);
                    }
                    if (z && (trackInfo = this.tabTrackInfos.get(string)) != null) {
                        UserTrackProviderProxy.click(trackInfo, false);
                    }
                }
                this.contentContainer.addView(vBaseHolder.itemView, new ViewGroup.LayoutParams(-1, -2));
            } else {
                baseViewHolder = vBaseHolder instanceof BaseViewHolder ? (BaseViewHolder) vBaseHolder : null;
                if (baseViewHolder != null) {
                    baseViewHolder.setSelected(false);
                }
            }
            i2 = i3;
        }
        OneTabLayout tabLayout = getTabLayout();
        if (tabLayout.getTabCount() > i && (tabAt = tabLayout.getTabAt(i)) != null) {
            resetComponentRightBtns(tabAt);
        }
        int i4 = 0;
        for (Object obj2 : this.componentViewHolders) {
            int i5 = i4 + 1;
            if (i4 < 0) {
                m.p();
            }
            VBaseHolder vBaseHolder2 = (VBaseHolder) obj2;
            HashMap hashMap = new HashMap(1);
            hashMap.put("selected", Boolean.valueOf(i4 == i));
            vBaseHolder2.onMessage(ViewHolderEvent.ON_VIEW_SELECTED, hashMap);
            i4 = i5;
        }
    }

    @Override // com.alient.onearch.adapter.component.tab.generic.GenericTabContract.View
    public boolean dispatchViewHolderMessage(@NotNull String str, @Nullable Map<String, ? extends Object> map) {
        b41.i(str, "type");
        if (this.componentViewHolders.isEmpty()) {
            return false;
        }
        for (VBaseHolder<IItem<ItemValue>, GenericRenderConfig> vBaseHolder : this.componentViewHolders) {
            vBaseHolder.onMessage(str, map);
        }
        return true;
    }

    @NotNull
    public final View getView() {
        return this.view;
    }

    @Override // com.alient.onearch.adapter.component.tab.generic.GenericTabContract.View
    public void hideTabIndicator() {
        getTabLayout().hideIndicator();
    }

    @Override // com.alient.onearch.adapter.component.tab.base.BaseTabView, com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
    public void onTabSelected(@NotNull TabLayout.Tab tab) {
        b41.i(tab, "tab");
        super.onTabSelected(tab);
        showCurrentComponent(getCurrentSelectedTabPosition(), true);
    }

    /* JADX WARN: Removed duplicated region for block: B:201:0x0147 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0146  */
    @Override // com.alient.onearch.adapter.component.tab.generic.GenericTabContract.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void setChildComponentData(@org.jetbrains.annotations.NotNull com.youku.arch.v3.IItem<com.youku.arch.v3.core.ItemValue> r21, @org.jetbrains.annotations.NotNull java.util.List<com.alient.onearch.adapter.widget.RichTitle> r22, @org.jetbrains.annotations.NotNull java.util.List<? extends com.alibaba.fastjson.JSONArray> r23, @org.jetbrains.annotations.NotNull java.util.List<? extends com.youku.arch.v3.core.Node> r24) {
        /*
            Method dump skipped, instructions count: 824
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alient.onearch.adapter.component.tab.generic.GenericTabView.setChildComponentData(com.youku.arch.v3.IItem, java.util.List, java.util.List, java.util.List):void");
    }

    @Override // com.alient.onearch.adapter.component.tab.generic.GenericTabContract.View
    public void showTabIndicator() {
        getTabLayout().showIndicator();
    }
}
