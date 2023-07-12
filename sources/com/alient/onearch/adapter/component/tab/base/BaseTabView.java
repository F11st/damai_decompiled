package com.alient.onearch.adapter.component.tab.base;

import android.view.View;
import android.widget.TextView;
import com.alibaba.fastjson.JSONArray;
import com.alient.onearch.adapter.R;
import com.alient.onearch.adapter.view.AbsView;
import com.alient.onearch.adapter.widget.OneTabLayout;
import com.alient.onearch.adapter.widget.RichTitle;
import com.alient.oneservice.nav.Action;
import com.alient.oneservice.nav.NavProviderProxy;
import com.alient.oneservice.ut.UserTrackProviderProxy;
import com.google.android.material.tabs.TabLayout;
import com.youku.arch.v3.IItem;
import com.youku.arch.v3.core.ItemValue;
import com.youku.arch.v3.core.Node;
import com.youku.arch.v3.core.item.GenericItem;
import com.youku.arch.v3.view.IContract;
import com.youku.arch.v3.view.IContract.Model;
import com.youku.arch.v3.view.IContract.Presenter;
import com.youku.middlewareservice.provider.info.AppInfoProviderProxy;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\b&\u0018\u0000*\u000e\b\u0000\u0010\u0003*\b\u0012\u0004\u0012\u00020\u00020\u0001*\u000e\b\u0001\u0010\u0005*\b\u0012\u0004\u0012\u00028\u00000\u0004*\u0014\b\u0002\u0010\u0007*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00062\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\b2\u00020\tB\u000f\u0012\u0006\u0010\u001e\u001a\u00020(¢\u0006\u0004\bK\u0010LJ\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0010\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0010\u0010\u000f\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u001e\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0014J\u0010\u0010\u0017\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\u0019\u001a\u00020\u0018H\u0016J\u0010\u0010\u001c\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\u001aH\u0016J\u0018\u0010!\u001a\u00020\f2\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010 \u001a\u00020\u001fH\u0016R\u001b\u0010\"\u001a\u0004\u0018\u00010\u001d8\u0006@\u0006¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%R\u001b\u0010&\u001a\u0004\u0018\u00010\u001d8\u0006@\u0006¢\u0006\f\n\u0004\b&\u0010#\u001a\u0004\b'\u0010%R\u001b\u0010)\u001a\u0004\u0018\u00010(8\u0006@\u0006¢\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,R\u0019\u0010\u0013\u001a\u00020\u00128\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010-\u001a\u0004\b.\u0010/R*\u00102\u001a\n\u0012\u0004\u0012\u000201\u0018\u0001008\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b2\u00103\u001a\u0004\b4\u00105\"\u0004\b6\u00107R*\u00108\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u0001008\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b8\u00103\u001a\u0004\b9\u00105\"\u0004\b:\u00107R*\u0010<\u001a\n\u0012\u0004\u0012\u00020;\u0018\u0001008\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b<\u00103\u001a\u0004\b=\u00105\"\u0004\b>\u00107R\"\u0010?\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b?\u0010\u0003\u001a\u0004\b@\u0010A\"\u0004\bB\u0010CR(\u0010E\u001a\b\u0012\u0004\u0012\u00020\u00020D8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\bE\u0010F\u001a\u0004\bG\u0010H\"\u0004\bI\u0010J¨\u0006M"}, d2 = {"Lcom/alient/onearch/adapter/component/tab/base/BaseTabView;", "Lcom/youku/arch/v3/core/item/GenericItem;", "Lcom/youku/arch/v3/core/ItemValue;", "I", "Lcom/youku/arch/v3/view/IContract$Model;", "M", "Lcom/youku/arch/v3/view/IContract$Presenter;", "P", "Lcom/alient/onearch/adapter/view/AbsView;", "Lcom/google/android/material/tabs/TabLayout$OnTabSelectedListener;", "Lcom/google/android/material/tabs/TabLayout$Tab;", "tab", "Ltb/wt2;", "onTabSelected", "onTabUnselected", "onTabReselected", "", "selectedPosition", "Lcom/alient/onearch/adapter/widget/OneTabLayout;", "tabLayout", "", "isScroll", "updateSelectedTab", "resetComponentRightBtns", "", "selectedTabTextSize", "Lcom/alibaba/fastjson/JSONArray;", "btns", "setComponentBtns", "Landroid/widget/TextView;", "view", "Lcom/alient/oneservice/nav/Action;", "action", "rightBtnClick", "btnOne", "Landroid/widget/TextView;", "getBtnOne", "()Landroid/widget/TextView;", "btnTwo", "getBtnTwo", "Landroid/view/View;", "rightArrow", "Landroid/view/View;", "getRightArrow", "()Landroid/view/View;", "Lcom/alient/onearch/adapter/widget/OneTabLayout;", "getTabLayout", "()Lcom/alient/onearch/adapter/widget/OneTabLayout;", "", "Lcom/alient/onearch/adapter/widget/RichTitle;", "childComponentTitles", "Ljava/util/List;", "getChildComponentTitles", "()Ljava/util/List;", "setChildComponentTitles", "(Ljava/util/List;)V", "childComponentBtns", "getChildComponentBtns", "setChildComponentBtns", "Lcom/youku/arch/v3/core/Node;", "childComponentNodes", "getChildComponentNodes", "setChildComponentNodes", "currentSelectedTabPosition", "getCurrentSelectedTabPosition", "()I", "setCurrentSelectedTabPosition", "(I)V", "Lcom/youku/arch/v3/IItem;", "containerItem", "Lcom/youku/arch/v3/IItem;", "getContainerItem", "()Lcom/youku/arch/v3/IItem;", "setContainerItem", "(Lcom/youku/arch/v3/IItem;)V", "<init>", "(Landroid/view/View;)V", "onearch-adapter_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes10.dex */
public abstract class BaseTabView<I extends GenericItem<ItemValue>, M extends IContract.Model<I>, P extends IContract.Presenter<I, M>> extends AbsView<I, M, P> implements TabLayout.OnTabSelectedListener {
    @Nullable
    private final TextView btnOne;
    @Nullable
    private final TextView btnTwo;
    @Nullable
    private List<? extends JSONArray> childComponentBtns;
    @Nullable
    private List<? extends Node> childComponentNodes;
    @Nullable
    private List<RichTitle> childComponentTitles;
    public IItem<ItemValue> containerItem;
    private int currentSelectedTabPosition;
    @Nullable
    private final View rightArrow;
    @NotNull
    private final OneTabLayout tabLayout;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseTabView(@NotNull View view) {
        super(view);
        b41.i(view, "view");
        this.btnOne = (TextView) view.findViewById(R.id.action_one);
        this.btnTwo = (TextView) view.findViewById(R.id.action_two);
        this.rightArrow = view.findViewById(R.id.right_arrow);
        View findViewById = view.findViewById(R.id.component_tab_layout);
        b41.h(findViewById, "view.findViewById(R.id.component_tab_layout)");
        this.tabLayout = (OneTabLayout) findViewById;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: setComponentBtns$lambda-11$lambda-10  reason: not valid java name */
    public static final void m202setComponentBtns$lambda11$lambda10(BaseTabView baseTabView, Action action, View view) {
        b41.i(baseTabView, "this$0");
        b41.i(action, "$this_apply");
        baseTabView.rightBtnClick(baseTabView.getBtnTwo(), action);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: setComponentBtns$lambda-7$lambda-6  reason: not valid java name */
    public static final void m203setComponentBtns$lambda7$lambda6(BaseTabView baseTabView, Action action, View view) {
        b41.i(baseTabView, "this$0");
        b41.i(action, "$this_apply");
        baseTabView.rightBtnClick(baseTabView.getBtnOne(), action);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: setComponentBtns$lambda-9$lambda-8  reason: not valid java name */
    public static final void m204setComponentBtns$lambda9$lambda8(BaseTabView baseTabView, Action action, View view) {
        b41.i(baseTabView, "this$0");
        b41.i(action, "$this_apply");
        baseTabView.rightBtnClick(baseTabView.getBtnOne(), action);
    }

    @Nullable
    public final TextView getBtnOne() {
        return this.btnOne;
    }

    @Nullable
    public final TextView getBtnTwo() {
        return this.btnTwo;
    }

    @Nullable
    public final List<JSONArray> getChildComponentBtns() {
        return this.childComponentBtns;
    }

    @Nullable
    public final List<Node> getChildComponentNodes() {
        return this.childComponentNodes;
    }

    @Nullable
    public final List<RichTitle> getChildComponentTitles() {
        return this.childComponentTitles;
    }

    @NotNull
    public final IItem<ItemValue> getContainerItem() {
        IItem<ItemValue> iItem = this.containerItem;
        if (iItem != null) {
            return iItem;
        }
        b41.A("containerItem");
        return null;
    }

    public final int getCurrentSelectedTabPosition() {
        return this.currentSelectedTabPosition;
    }

    @Nullable
    public final View getRightArrow() {
        return this.rightArrow;
    }

    @NotNull
    public final OneTabLayout getTabLayout() {
        return this.tabLayout;
    }

    @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
    public void onTabReselected(@NotNull TabLayout.Tab tab) {
        b41.i(tab, "tab");
    }

    @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
    public void onTabSelected(@NotNull TabLayout.Tab tab) {
        b41.i(tab, "tab");
        this.currentSelectedTabPosition = tab.getPosition();
        OneTabLayout oneTabLayout = this.tabLayout;
        int tabCount = oneTabLayout.getTabCount();
        if (tabCount <= 0) {
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i + 1;
            if (i == getCurrentSelectedTabPosition()) {
                TabLayout.Tab tabAt = oneTabLayout.getTabAt(i);
                if (tabAt != null) {
                    oneTabLayout.setSelectedTab(tabAt, false);
                }
            } else {
                TabLayout.Tab tabAt2 = oneTabLayout.getTabAt(i);
                if (tabAt2 != null) {
                    oneTabLayout.setUnSelectedTab(tabAt2, false);
                }
            }
            if (i2 >= tabCount) {
                return;
            }
            i = i2;
        }
    }

    @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
    public void onTabUnselected(@NotNull TabLayout.Tab tab) {
        b41.i(tab, "tab");
        this.tabLayout.setUnSelectedTab(tab, false);
    }

    public void resetComponentRightBtns(@NotNull TabLayout.Tab tab) {
        b41.i(tab, "tab");
        List<? extends JSONArray> list = this.childComponentBtns;
        if (list != null && tab.getPosition() < list.size()) {
            try {
                setComponentBtns(list.get(tab.getPosition()));
            } catch (Exception e) {
                if (AppInfoProviderProxy.isDebuggable()) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public void rightBtnClick(@NotNull TextView textView, @NotNull Action action) {
        b41.i(textView, "view");
        b41.i(action, "action");
        NavProviderProxy.toUri(textView.getContext(), action);
        UserTrackProviderProxy.click(textView, action.getTrackInfo(), true);
    }

    public float selectedTabTextSize() {
        return 18.0f;
    }

    public final void setChildComponentBtns(@Nullable List<? extends JSONArray> list) {
        this.childComponentBtns = list;
    }

    public final void setChildComponentNodes(@Nullable List<? extends Node> list) {
        this.childComponentNodes = list;
    }

    public final void setChildComponentTitles(@Nullable List<RichTitle> list) {
        this.childComponentTitles = list;
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0089  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void setComponentBtns(@org.jetbrains.annotations.NotNull com.alibaba.fastjson.JSONArray r10) {
        /*
            Method dump skipped, instructions count: 475
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alient.onearch.adapter.component.tab.base.BaseTabView.setComponentBtns(com.alibaba.fastjson.JSONArray):void");
    }

    public final void setContainerItem(@NotNull IItem<ItemValue> iItem) {
        b41.i(iItem, "<set-?>");
        this.containerItem = iItem;
    }

    public final void setCurrentSelectedTabPosition(int i) {
        this.currentSelectedTabPosition = i;
    }

    public final void updateSelectedTab(int i, @NotNull OneTabLayout oneTabLayout, boolean z) {
        b41.i(oneTabLayout, "tabLayout");
        this.currentSelectedTabPosition = i;
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
