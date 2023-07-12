package com.alient.onearch.adapter.component.tab.generic.vertical;

import android.view.View;
import com.alibaba.android.vlayout.a;
import com.alibaba.android.vlayout.layout.StickyLayoutHelper;
import com.alibaba.fastjson.JSONArray;
import com.alient.onearch.adapter.component.header.sticky.StickyHeaderFeature;
import com.alient.onearch.adapter.component.tab.base.BaseTabPresenter;
import com.alient.onearch.adapter.component.tab.generic.vertical.VerticalTabContract;
import com.alient.onearch.adapter.widget.OneTabLayout;
import com.alient.onearch.adapter.widget.RichTitle;
import com.google.android.material.tabs.TabLayout;
import com.uc.webview.export.extension.UCCore;
import com.youku.arch.v3.IItem;
import com.youku.arch.v3.adapter.VBaseAdapter;
import com.youku.arch.v3.adapter.VBaseHolder;
import com.youku.arch.v3.core.Constants;
import com.youku.arch.v3.core.ItemValue;
import com.youku.arch.v3.core.Node;
import com.youku.arch.v3.core.item.GenericItem;
import com.youku.arch.v3.event.EventHandler;
import com.youku.arch.v3.page.GenericFragment;
import com.youku.arch.v3.view.render.GenericRenderConfig;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00012\u00020\u00062\u00020\u00072\u00020\bB3\u0012\u0006\u0010,\u001a\u00020+\u0012\u0006\u0010-\u001a\u00020+\u0012\b\u0010.\u001a\u0004\u0018\u00010\u001f\u0012\u0006\u00100\u001a\u00020/\u0012\b\u00101\u001a\u0004\u0018\u00010+¢\u0006\u0004\b2\u00103J\u0016\u0010\u000b\u001a\u00020\n2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016J2\u0010\u0013\u001a\u00020\n2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\f2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\fH\u0016J\u0010\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J\u0010\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\u0014H\u0016J\u0010\u0010\u001b\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\u0019H\u0016J\u0010\u0010\u001c\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\u0019H\u0016J\u0010\u0010\u001d\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\u0019H\u0016J\u001a\u0010!\u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\u00142\b\u0010 \u001a\u0004\u0018\u00010\u001fH\u0016J\u001a\u0010\"\u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\u00142\b\u0010 \u001a\u0004\u0018\u00010\u001fH\u0016R\u0016\u0010#\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b#\u0010$R$\u0010%\u001a\u0004\u0018\u00010\u001f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*¨\u00064"}, d2 = {"Lcom/alient/onearch/adapter/component/tab/generic/vertical/VerticalTabPresenter;", "Lcom/alient/onearch/adapter/component/tab/base/BaseTabPresenter;", "Lcom/youku/arch/v3/core/item/GenericItem;", "Lcom/youku/arch/v3/core/ItemValue;", "Lcom/alient/onearch/adapter/component/tab/generic/vertical/VerticalTabModel;", "Lcom/alient/onearch/adapter/component/tab/generic/vertical/VerticalTabView;", "Lcom/alient/onearch/adapter/component/tab/generic/vertical/VerticalTabContract$Presenter;", "Lcom/google/android/material/tabs/TabLayout$OnTabSelectedListener;", "Lcom/alibaba/android/vlayout/layout/StickyLayoutHelper$StickyListener;", "item", "Ltb/wt2;", UCCore.LEGACY_EVENT_INIT, "", "Lcom/alient/onearch/adapter/widget/RichTitle;", "childComponentTitles", "Lcom/alibaba/fastjson/JSONArray;", "childComponentBtns", "Lcom/youku/arch/v3/core/Node;", "childComponentNodes", "renderTabInView", "", "selectedPosition", "tabSelected", "unSelectedPosition", "tabUnSelected", "Lcom/google/android/material/tabs/TabLayout$Tab;", "tab", "onTabSelected", "onTabUnselected", "onTabReselected", "pos", "Landroid/view/View;", "view", "onSticky", "onUnSticky", "currentSelectedTabPosition", "I", "stickyView", "Landroid/view/View;", "getStickyView", "()Landroid/view/View;", "setStickyView", "(Landroid/view/View;)V", "", "mClassName", "vClassName", "renderView", "Lcom/youku/arch/v3/event/EventHandler;", "eventHandler", Constants.CONFIG, "<init>", "(Ljava/lang/String;Ljava/lang/String;Landroid/view/View;Lcom/youku/arch/v3/event/EventHandler;Ljava/lang/String;)V", "onearch-adapter_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes10.dex */
public class VerticalTabPresenter extends BaseTabPresenter<GenericItem<ItemValue>, VerticalTabModel, VerticalTabView> implements VerticalTabContract.Presenter, TabLayout.OnTabSelectedListener, StickyLayoutHelper.StickyListener {
    private int currentSelectedTabPosition;
    @Nullable
    private View stickyView;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VerticalTabPresenter(@NotNull String str, @NotNull String str2, @Nullable View view, @NotNull EventHandler eventHandler, @Nullable String str3) {
        super(str, str2, view, eventHandler, str3);
        b41.i(str, "mClassName");
        b41.i(str2, "vClassName");
        b41.i(eventHandler, "eventHandler");
    }

    @Nullable
    public final View getStickyView() {
        return this.stickyView;
    }

    @Override // com.alibaba.android.vlayout.layout.StickyLayoutHelper.StickyListener
    public void onSticky(int i, @Nullable View view) {
        View view2 = this.stickyView;
        if (view2 == null) {
            return;
        }
        view2.setVisibility(0);
    }

    @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
    public void onTabReselected(@NotNull TabLayout.Tab tab) {
        b41.i(tab, "tab");
        onTabSelected(tab);
    }

    @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
    public void onTabSelected(@NotNull TabLayout.Tab tab) {
        b41.i(tab, "tab");
        tabSelected(tab.getPosition());
        ((VerticalTabView) getView()).setScrollPosition(tab.getPosition(), 0.0f, true);
        ((VerticalTabView) getView()).showCurrentComponent(tab.getPosition(), true);
    }

    @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
    public void onTabUnselected(@NotNull TabLayout.Tab tab) {
        b41.i(tab, "tab");
        tabUnSelected(tab.getPosition());
    }

    @Override // com.alibaba.android.vlayout.layout.StickyLayoutHelper.StickyListener
    public void onUnSticky(int i, @Nullable View view) {
        View view2 = this.stickyView;
        if (view2 == null) {
            return;
        }
        view2.setVisibility(8);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [com.youku.arch.v3.IItem] */
    @Override // com.alient.onearch.adapter.component.tab.base.BaseTabPresenter
    public void renderTabInView(@NotNull List<RichTitle> list, @NotNull List<? extends JSONArray> list2, @NotNull List<? extends Node> list3) {
        b41.i(list, "childComponentTitles");
        b41.i(list2, "childComponentBtns");
        b41.i(list3, "childComponentNodes");
        ((VerticalTabView) getView()).setChildComponentData(getItem(), list, list2, list3);
        VBaseAdapter<IItem<ItemValue>, VBaseHolder<IItem<ItemValue>, GenericRenderConfig>> adapter = ((GenericItem) getItem()).getComponent().getAdapter();
        a layoutHelper = adapter == null ? null : adapter.getLayoutHelper();
        StickyLayoutHelper stickyLayoutHelper = layoutHelper instanceof StickyLayoutHelper ? (StickyLayoutHelper) layoutHelper : null;
        if (stickyLayoutHelper != null) {
            stickyLayoutHelper.i(this);
        }
        View view = this.stickyView;
        OneTabLayout oneTabLayout = view instanceof OneTabLayout ? (OneTabLayout) view : null;
        if (oneTabLayout == null) {
            return;
        }
        oneTabLayout.removeAllTabs();
        oneTabLayout.clearOnTabSelectedListeners();
        oneTabLayout.setTitles(list, this.currentSelectedTabPosition);
        oneTabLayout.addOnTabSelectedListener((TabLayout.OnTabSelectedListener) this);
        ((VerticalTabView) getView()).updateTabTextSize(this.currentSelectedTabPosition, oneTabLayout, false);
        oneTabLayout.setScrollPosition(this.currentSelectedTabPosition, 0.0f, true);
    }

    public final void setStickyView(@Nullable View view) {
        this.stickyView = view;
    }

    @Override // com.alient.onearch.adapter.component.tab.generic.vertical.VerticalTabContract.Presenter
    public void tabSelected(int i) {
        int tabCount;
        this.currentSelectedTabPosition = i;
        View view = this.stickyView;
        OneTabLayout oneTabLayout = view instanceof OneTabLayout ? (OneTabLayout) view : null;
        if (oneTabLayout == null || (tabCount = oneTabLayout.getTabCount()) <= 0) {
            return;
        }
        int i2 = 0;
        while (true) {
            int i3 = i2 + 1;
            if (i2 == i) {
                TabLayout.Tab tabAt = oneTabLayout.getTabAt(i2);
                if (tabAt != null) {
                    oneTabLayout.setSelectedTab(tabAt, false);
                }
            } else {
                TabLayout.Tab tabAt2 = oneTabLayout.getTabAt(i2);
                if (tabAt2 != null) {
                    oneTabLayout.setUnSelectedTab(tabAt2, false);
                }
            }
            if (i3 >= tabCount) {
                return;
            }
            i2 = i3;
        }
    }

    @Override // com.alient.onearch.adapter.component.tab.generic.vertical.VerticalTabContract.Presenter
    public void tabUnSelected(int i) {
    }

    @Override // com.alient.onearch.adapter.component.tab.base.BaseTabPresenter, com.alient.onearch.adapter.view.AbsPresenter, com.youku.arch.v3.view.AbsPresenter, com.youku.arch.v3.view.IContract.Presenter
    public void init(@NotNull GenericItem<ItemValue> genericItem) {
        View stickyView;
        b41.i(genericItem, "item");
        GenericFragment fragment = genericItem.getPageContext().getFragment();
        StickyHeaderFeature stickyHeaderFeature = fragment instanceof StickyHeaderFeature ? (StickyHeaderFeature) fragment : null;
        if (stickyHeaderFeature != null && (stickyView = stickyHeaderFeature.getStickyView()) != null) {
            setStickyView(stickyView);
        }
        super.init((VerticalTabPresenter) genericItem);
    }
}
