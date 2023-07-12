package com.alient.onearch.adapter.component.header.sticky;

import android.view.View;
import com.alient.onearch.adapter.R;
import com.alient.onearch.adapter.component.header.sticky.StickyHeaderContract;
import com.alient.onearch.adapter.pom.StickyHeaderTabValue;
import com.alient.onearch.adapter.view.AbsView;
import com.alient.onearch.adapter.widget.OneTabLayout;
import com.google.android.material.tabs.TabLayout;
import com.youku.arch.v3.core.ItemValue;
import com.youku.arch.v3.core.item.GenericItem;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import tb.b41;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\b\u0016\u0018\u00002\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00012\u00020\u00062\u00020\u0007B\u000f\u0012\u0006\u0010!\u001a\u00020 ¢\u0006\u0004\b(\u0010)J\u0016\u0010\f\u001a\u00020\u000b2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0016J \u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J \u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0011H\u0016J\b\u0010\u001a\u001a\u00020\u0019H\u0016J\u0010\u0010\u001d\u001a\u00020\u000b2\u0006\u0010\u001c\u001a\u00020\u001bH\u0016J\u0010\u0010\u001e\u001a\u00020\u000b2\u0006\u0010\u001c\u001a\u00020\u001bH\u0016J\u0010\u0010\u001f\u001a\u00020\u000b2\u0006\u0010\u001c\u001a\u00020\u001bH\u0016R\u0019\u0010!\u001a\u00020 8\u0006@\u0006¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R\u001e\u0010\u0016\u001a\n %*\u0004\u0018\u00010\u00150\u00158\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010&R\u001c\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\n\u0010'¨\u0006*"}, d2 = {"Lcom/alient/onearch/adapter/component/header/sticky/StickyHeaderView;", "Lcom/alient/onearch/adapter/view/AbsView;", "Lcom/youku/arch/v3/core/item/GenericItem;", "Lcom/youku/arch/v3/core/ItemValue;", "Lcom/alient/onearch/adapter/component/header/sticky/StickyHeaderModel;", "Lcom/alient/onearch/adapter/component/header/sticky/StickyHeaderPresent;", "Lcom/alient/onearch/adapter/component/header/sticky/StickyHeaderContract$View;", "Lcom/google/android/material/tabs/TabLayout$OnTabSelectedListener;", "", "Lcom/alient/onearch/adapter/pom/StickyHeaderTabValue;", "tabs", "Ltb/wt2;", "renderTab", "", "position", "", "positionOffset", "", "updateSelectedText", "setScrollPosition", "selectedPosition", "Lcom/alient/onearch/adapter/widget/OneTabLayout;", "tabLayout", "isScroll", "updateTabTextSize", "Lcom/google/android/material/tabs/TabLayout;", "headerView", "Lcom/google/android/material/tabs/TabLayout$Tab;", "tab", "onTabSelected", "onTabUnselected", "onTabReselected", "Landroid/view/View;", "view", "Landroid/view/View;", "getView", "()Landroid/view/View;", "kotlin.jvm.PlatformType", "Lcom/alient/onearch/adapter/widget/OneTabLayout;", "Ljava/util/List;", "<init>", "(Landroid/view/View;)V", "onearch-adapter_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes10.dex */
public class StickyHeaderView extends AbsView<GenericItem<ItemValue>, StickyHeaderModel, StickyHeaderPresent> implements StickyHeaderContract.View, TabLayout.OnTabSelectedListener {
    private final OneTabLayout tabLayout;
    @NotNull
    private List<StickyHeaderTabValue> tabs;
    @NotNull
    private final View view;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StickyHeaderView(@NotNull View view) {
        super(view);
        b41.i(view, "view");
        this.view = view;
        this.tabLayout = (OneTabLayout) view.findViewById(R.id.component_sticky_tab_layout);
        this.tabs = new ArrayList();
    }

    @NotNull
    public final View getView() {
        return this.view;
    }

    @Override // com.alient.onearch.adapter.component.header.sticky.StickyHeaderContract.View
    @NotNull
    public TabLayout headerView() {
        OneTabLayout oneTabLayout = this.tabLayout;
        b41.h(oneTabLayout, "tabLayout");
        return oneTabLayout;
    }

    @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
    public void onTabReselected(@NotNull TabLayout.Tab tab) {
        b41.i(tab, "tab");
        ((StickyHeaderPresent) getPresenter()).tabSelected(tab.getPosition(), this.tabs.get(tab.getPosition()));
    }

    @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
    public void onTabSelected(@NotNull TabLayout.Tab tab) {
        b41.i(tab, "tab");
        ((StickyHeaderPresent) getPresenter()).tabSelected(tab.getPosition(), this.tabs.get(tab.getPosition()));
        this.tabLayout.setSelectedTab(tab, false);
    }

    @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
    public void onTabUnselected(@NotNull TabLayout.Tab tab) {
        b41.i(tab, "tab");
        ((StickyHeaderPresent) getPresenter()).tabUnSelected(tab.getPosition());
        this.tabLayout.setUnSelectedTab(tab, false);
    }

    @Override // com.alient.onearch.adapter.component.header.sticky.StickyHeaderContract.View
    public void renderTab(@NotNull List<StickyHeaderTabValue> list) {
        b41.i(list, "tabs");
        this.tabs = list;
        this.tabLayout.removeAllTabs();
        this.tabLayout.removeOnTabSelectedListener((TabLayout.OnTabSelectedListener) this);
        this.tabLayout.setTitles(((StickyHeaderPresent) getPresenter()).createTitles(list), 0);
        OneTabLayout oneTabLayout = this.tabLayout;
        b41.h(oneTabLayout, "tabLayout");
        updateTabTextSize(0, oneTabLayout, false);
        this.tabLayout.addOnTabSelectedListener((TabLayout.OnTabSelectedListener) this);
    }

    @Override // com.alient.onearch.adapter.component.header.sticky.StickyHeaderContract.View
    public void setScrollPosition(int i, float f, boolean z) {
        this.tabLayout.setScrollPosition(i, f, z);
        OneTabLayout oneTabLayout = this.tabLayout;
        b41.h(oneTabLayout, "tabLayout");
        updateTabTextSize(i, oneTabLayout, true);
    }

    @Override // com.alient.onearch.adapter.component.header.sticky.StickyHeaderContract.View
    public void updateTabTextSize(int i, @NotNull OneTabLayout oneTabLayout, boolean z) {
        b41.i(oneTabLayout, "tabLayout");
        int tabCount = oneTabLayout.getTabCount();
        if (tabCount <= 0) {
            return;
        }
        int i2 = 0;
        while (true) {
            int i3 = i2 + 1;
            TabLayout.Tab tabAt = oneTabLayout.getTabAt(i2);
            if (i2 == i) {
                if (tabAt != null) {
                    oneTabLayout.setSelectedTab(tabAt, z);
                }
            } else if (tabAt != null) {
                oneTabLayout.setUnSelectedTab(tabAt, z);
            }
            if (i3 >= tabCount) {
                return;
            }
            i2 = i3;
        }
    }
}
