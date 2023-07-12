package com.alient.onearch.adapter.component.tab.generic.vertical;

import android.util.Pair;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.fastjson.JSONObject;
import com.alient.onearch.adapter.component.tab.base.BaseTabView;
import com.alient.onearch.adapter.component.tab.generic.vertical.VerticalTabContract;
import com.alient.onearch.adapter.component.tab.generic.vertical.VerticalTabView;
import com.alient.onearch.adapter.widget.OneTabLayout;
import com.alient.oneservice.ut.TrackInfo;
import com.alient.oneservice.ut.UserTrackProviderProxy;
import com.google.android.material.tabs.TabLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.youku.arch.v3.IComponent;
import com.youku.arch.v3.IContainer;
import com.youku.arch.v3.IItem;
import com.youku.arch.v3.IModule;
import com.youku.arch.v3.adapter.ContentAdapter;
import com.youku.arch.v3.adapter.VBaseAdapter;
import com.youku.arch.v3.adapter.VBaseHolder;
import com.youku.arch.v3.core.ComponentValue;
import com.youku.arch.v3.core.Config;
import com.youku.arch.v3.core.ItemValue;
import com.youku.arch.v3.core.ModelValue;
import com.youku.arch.v3.core.ModuleValue;
import com.youku.arch.v3.core.Node;
import com.youku.arch.v3.core.item.GenericItem;
import com.youku.arch.v3.page.GenericFragment;
import com.youku.arch.v3.util.LogUtil;
import com.youku.arch.v3.view.render.GenericRenderConfig;
import com.youku.middlewareservice.provider.info.AppInfoProviderProxy;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.k50;
import tb.wt2;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000¢\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u0000 A2\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00012\u00020\u0006:\u0001AB\u000f\u0012\u0006\u0010-\u001a\u00020,¢\u0006\u0004\b?\u0010@J\u0016\u0010\u000b\u001a\u00020\n2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0002J\b\u0010\f\u001a\u00020\nH\u0016J\u001c\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\r2\n\u0010\u0010\u001a\u0006\u0012\u0002\b\u00030\u000fH\u0016J\u0010\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u0013H\u0016J\u0010\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u0013H\u0016J\u0010\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u0013H\u0016J \u0010\u001d\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u001bH\u0016J \u0010\"\u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\u00112\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\u001bH\u0016J@\u0010*\u001a\u00020\n2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00030#2\f\u0010&\u001a\b\u0012\u0004\u0012\u00020%0\u00072\f\u0010(\u001a\b\u0012\u0004\u0012\u00020'0\u00072\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0016J\u0018\u0010+\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\u00112\u0006\u0010\f\u001a\u00020\u001bH\u0016R\u0019\u0010-\u001a\u00020,8\u0006@\u0006¢\u0006\f\n\u0004\b-\u0010.\u001a\u0004\b/\u00100R\"\u00104\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020302018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b4\u00105R\"\u00109\u001a\u000e\u0012\u0004\u0012\u000207\u0012\u0004\u0012\u000208068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b9\u0010:R\"\u0010;\u001a\u000e\u0012\u0004\u0012\u000207\u0012\u0004\u0012\u000208068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b;\u0010:R\u0018\u0010=\u001a\u0004\u0018\u00010<8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b=\u0010>¨\u0006B"}, d2 = {"Lcom/alient/onearch/adapter/component/tab/generic/vertical/VerticalTabView;", "Lcom/alient/onearch/adapter/component/tab/base/BaseTabView;", "Lcom/youku/arch/v3/core/item/GenericItem;", "Lcom/youku/arch/v3/core/ItemValue;", "Lcom/alient/onearch/adapter/component/tab/generic/vertical/VerticalTabModel;", "Lcom/alient/onearch/adapter/component/tab/generic/vertical/VerticalTabPresenter;", "Lcom/alient/onearch/adapter/component/tab/generic/vertical/VerticalTabContract$View;", "", "Lcom/youku/arch/v3/core/Node;", "componentNodes", "Ltb/wt2;", "createChildComponents", "scrollToTop", "Lcom/alibaba/android/vlayout/DelegateAdapter;", "delegateAdapter", "Lcom/alibaba/android/vlayout/DelegateAdapter$Adapter;", "innerAdapter", "", "getRealPositionForAdapter", "Lcom/google/android/material/tabs/TabLayout$Tab;", "tab", "onTabSelected", "onTabReselected", "onTabUnselected", "position", "", "positionOffset", "", "updateSelectedText", "setScrollPosition", "selectedPosition", "Lcom/alient/onearch/adapter/widget/OneTabLayout;", "tabLayout", "isScroll", "updateTabTextSize", "Lcom/youku/arch/v3/IItem;", "containerItem", "Lcom/alient/onearch/adapter/widget/RichTitle;", "childComponentTitles", "Lcom/alibaba/fastjson/JSONArray;", "childComponentBtns", "childComponentNodes", "setChildComponentData", "showCurrentComponent", "Landroid/view/View;", "view", "Landroid/view/View;", "getView", "()Landroid/view/View;", "", "Lcom/youku/arch/v3/IComponent;", "Lcom/youku/arch/v3/core/ComponentValue;", "childComponents", "Ljava/util/List;", "", "", "Lcom/alient/oneservice/ut/TrackInfo;", "tabTrackInfos", "Ljava/util/Map;", "componentTrackInfos", "Landroidx/recyclerview/widget/LinearLayoutManager;", "layoutManager", "Landroidx/recyclerview/widget/LinearLayoutManager;", "<init>", "(Landroid/view/View;)V", "Companion", "onearch-adapter_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes10.dex */
public class VerticalTabView extends BaseTabView<GenericItem<ItemValue>, VerticalTabModel, VerticalTabPresenter> implements VerticalTabContract.View {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    public static final String TAG = "OneArch.VerticalTabView";
    @NotNull
    private final List<IComponent<ComponentValue>> childComponents;
    @NotNull
    private Map<String, TrackInfo> componentTrackInfos;
    @Nullable
    private LinearLayoutManager layoutManager;
    @NotNull
    private Map<String, TrackInfo> tabTrackInfos;
    @NotNull
    private final View view;

    /* compiled from: Taobao */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/alient/onearch/adapter/component/tab/generic/vertical/VerticalTabView$Companion;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "onearch-adapter_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes12.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(k50 k50Var) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VerticalTabView(@NotNull View view) {
        super(view);
        b41.i(view, "view");
        this.view = view;
        this.childComponents = new ArrayList();
        this.tabTrackInfos = new LinkedHashMap();
        this.componentTrackInfos = new LinkedHashMap();
    }

    private final void createChildComponents(final List<? extends Node> list) {
        getContainerItem().getPageContext().runOnLoaderThreadLocked(new Function0<wt2>() { // from class: com.alient.onearch.adapter.component.tab.generic.vertical.VerticalTabView$createChildComponents$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
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
                List list2;
                int size = list.size() - 1;
                if (size < 0) {
                    return;
                }
                int i = 0;
                while (true) {
                    int i2 = i + 1;
                    Node node = list.get(i);
                    Config<Node> config = new Config<>(this.getContainerItem().getPageContext(), node.getType(), node, 0, false, 24, null);
                    try {
                        IModule<ModuleValue> module = this.getContainerItem().getComponent().getModule();
                        VerticalTabView verticalTabView = this;
                        IComponent<ComponentValue> createComponent = module.createComponent(config);
                        if (createComponent != null) {
                            list2 = verticalTabView.childComponents;
                            list2.add(createComponent);
                        }
                    } catch (Exception e) {
                        LogUtil.e(VerticalTabView.TAG, b41.r("createComponent exception ", e.getMessage()));
                        if (AppInfoProviderProxy.isDebuggable()) {
                            throw new RuntimeException(e);
                        }
                    }
                    if (i2 > size) {
                        return;
                    }
                    i = i2;
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: scrollToTop$lambda-3$lambda-2$lambda-1  reason: not valid java name */
    public static final void m205scrollToTop$lambda3$lambda2$lambda1(RecyclerView recyclerView, int i) {
        b41.i(recyclerView, "$this_apply");
        RecyclerView.ViewHolder findViewHolderForAdapterPosition = recyclerView.findViewHolderForAdapterPosition(i + 1);
        if (findViewHolderForAdapterPosition == null) {
            return;
        }
        recyclerView.scrollBy(0, findViewHolderForAdapterPosition.itemView.getTop());
    }

    public int getRealPositionForAdapter(@NotNull DelegateAdapter delegateAdapter, @NotNull DelegateAdapter.Adapter<?> adapter) {
        b41.i(delegateAdapter, "delegateAdapter");
        b41.i(adapter, "innerAdapter");
        int itemCount = delegateAdapter.getItemCount();
        if (itemCount > 0) {
            int i = 0;
            while (true) {
                int i2 = i + 1;
                Pair<DelegateAdapter.AdapterDataObserver, DelegateAdapter.Adapter> findAdapterByPosition = delegateAdapter.findAdapterByPosition(i);
                if (findAdapterByPosition != null && findAdapterByPosition.second == adapter) {
                    return i;
                }
                if (i2 >= itemCount) {
                    break;
                }
                i = i2;
            }
        }
        return -1;
    }

    @NotNull
    public final View getView() {
        return this.view;
    }

    @Override // com.alient.onearch.adapter.component.tab.base.BaseTabView, com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
    public void onTabReselected(@NotNull TabLayout.Tab tab) {
        b41.i(tab, "tab");
        super.onTabReselected(tab);
        onTabSelected(tab);
    }

    @Override // com.alient.onearch.adapter.component.tab.base.BaseTabView, com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
    public void onTabSelected(@NotNull TabLayout.Tab tab) {
        b41.i(tab, "tab");
        super.onTabSelected(tab);
        setCurrentSelectedTabPosition(tab.getPosition());
        ((VerticalTabPresenter) getPresenter()).tabSelected(tab.getPosition());
        showCurrentComponent(tab.getPosition(), true);
    }

    @Override // com.alient.onearch.adapter.component.tab.base.BaseTabView, com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
    public void onTabUnselected(@NotNull TabLayout.Tab tab) {
        b41.i(tab, "tab");
        super.onTabUnselected(tab);
        ((VerticalTabPresenter) getPresenter()).onTabUnselected(tab);
    }

    public void scrollToTop() {
        final int realPositionForAdapter;
        GenericFragment fragment;
        final RecyclerView recyclerView;
        IContainer<ModelValue> pageContainer = getContainerItem().getPageContext().getPageContainer();
        ContentAdapter contentAdapter = pageContainer == null ? null : pageContainer.getContentAdapter();
        VBaseAdapter<IItem<ItemValue>, VBaseHolder<IItem<ItemValue>, GenericRenderConfig>> adapter = getContainerItem().getComponent().getAdapter();
        if (adapter == null || contentAdapter == null || (realPositionForAdapter = getRealPositionForAdapter(contentAdapter, adapter)) <= 0 || (fragment = getContainerItem().getPageContext().getFragment()) == null || (recyclerView = fragment.getRecyclerView()) == null) {
            return;
        }
        recyclerView.scrollToPosition(realPositionForAdapter + 1);
        recyclerView.post(new Runnable() { // from class: tb.nx2
            @Override // java.lang.Runnable
            public final void run() {
                VerticalTabView.m205scrollToTop$lambda3$lambda2$lambda1(RecyclerView.this, realPositionForAdapter);
            }
        });
    }

    /* JADX WARN: Removed duplicated region for block: B:67:0x012a A[Catch: Exception -> 0x0177, TryCatch #0 {Exception -> 0x0177, blocks: (B:59:0x00eb, B:76:0x0151, B:79:0x015c, B:82:0x0163, B:85:0x016a, B:88:0x0171, B:62:0x0107, B:65:0x010e, B:67:0x012a, B:69:0x013b, B:72:0x0145, B:75:0x014c, B:68:0x0137), top: B:130:0x00eb }] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0137 A[Catch: Exception -> 0x0177, TryCatch #0 {Exception -> 0x0177, blocks: (B:59:0x00eb, B:76:0x0151, B:79:0x015c, B:82:0x0163, B:85:0x016a, B:88:0x0171, B:62:0x0107, B:65:0x010e, B:67:0x012a, B:69:0x013b, B:72:0x0145, B:75:0x014c, B:68:0x0137), top: B:130:0x00eb }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void setChildComponentData(@org.jetbrains.annotations.NotNull final com.youku.arch.v3.IItem<com.youku.arch.v3.core.ItemValue> r21, @org.jetbrains.annotations.NotNull java.util.List<com.alient.onearch.adapter.widget.RichTitle> r22, @org.jetbrains.annotations.NotNull java.util.List<? extends com.alibaba.fastjson.JSONArray> r23, @org.jetbrains.annotations.NotNull java.util.List<? extends com.youku.arch.v3.core.Node> r24) {
        /*
            Method dump skipped, instructions count: 542
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alient.onearch.adapter.component.tab.generic.vertical.VerticalTabView.setChildComponentData(com.youku.arch.v3.IItem, java.util.List, java.util.List, java.util.List):void");
    }

    @Override // com.alient.onearch.adapter.component.tab.generic.vertical.VerticalTabContract.View
    public void setScrollPosition(int i, float f, boolean z) {
        setCurrentSelectedTabPosition(i);
        getTabLayout().setScrollPosition(i, f, z);
        updateTabTextSize(i, getTabLayout(), true);
    }

    public void showCurrentComponent(int i, boolean z) {
        RefreshLayout refreshLayout;
        String string;
        TrackInfo trackInfo;
        if (i < this.childComponents.size()) {
            IComponent<ComponentValue> iComponent = this.childComponents.get(i);
            JSONObject data = iComponent.getProperty().getData();
            if (data != null && (string = data.getString("nodeId")) != null && (trackInfo = this.tabTrackInfos.get(string)) != null) {
                UserTrackProviderProxy.click(trackInfo, false);
            }
            GenericFragment fragment = getContainerItem().getPageContext().getFragment();
            if (fragment != null && (refreshLayout = fragment.getRefreshLayout()) != null) {
                refreshLayout.setEnableLoadMore(iComponent.hasNext());
                refreshLayout.setNoMoreData(false);
            }
            IModule<ModuleValue> module = getContainerItem().getComponent().getModule();
            module.getChildState().setChanged();
            module.replaceComponent(module.getComponents().size() - 1, iComponent);
        }
        if (z) {
            getContainerItem().getPageContext().runOnUIThreadLocked(new Function0<wt2>() { // from class: com.alient.onearch.adapter.component.tab.generic.vertical.VerticalTabView$showCurrentComponent$4
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
                    VerticalTabView.this.scrollToTop();
                }
            });
        }
    }

    @Override // com.alient.onearch.adapter.component.tab.generic.vertical.VerticalTabContract.View
    public void updateTabTextSize(int i, @NotNull OneTabLayout oneTabLayout, boolean z) {
        b41.i(oneTabLayout, "tabLayout");
        updateSelectedTab(i, oneTabLayout, z);
    }
}
