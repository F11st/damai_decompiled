package cn.damai.homepage.v2.feed.container;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.homepage.v2.feed.container.FeedTabContainer;
import com.alibaba.fastjson.JSONArray;
import com.alient.onearch.adapter.component.tab.generic.vertical.VerticalTabView;
import com.alient.onearch.adapter.widget.RichTitle;
import com.alient.resource.util.DisplayUtil;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.IContainer;
import com.youku.arch.v3.IItem;
import com.youku.arch.v3.adapter.ContentAdapter;
import com.youku.arch.v3.adapter.VBaseAdapter;
import com.youku.arch.v3.adapter.VBaseHolder;
import com.youku.arch.v3.core.ItemValue;
import com.youku.arch.v3.core.ModelValue;
import com.youku.arch.v3.core.Node;
import com.youku.arch.v3.page.GenericFragment;
import com.youku.arch.v3.view.render.GenericRenderConfig;
import com.youku.kubus.Event;
import com.youku.kubus.EventBus;
import java.lang.ref.WeakReference;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.k50;
import tb.ux0;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public final class FeedTabContainer extends VerticalTabView {
    private static transient /* synthetic */ IpChange $ipChange = null;
    @NotNull
    public static final C1271a Companion = new C1271a(null);
    @NotNull
    public static final String STICKY_SCROLL_TOP = "STICKY_SCROLL_TOP";
    @Nullable
    private static WeakReference<View> weakTabView;

    /* compiled from: Taobao */
    /* renamed from: cn.damai.homepage.v2.feed.container.FeedTabContainer$a */
    /* loaded from: classes14.dex */
    public static final class C1271a {
        private static transient /* synthetic */ IpChange $ipChange;

        private C1271a() {
        }

        public /* synthetic */ C1271a(k50 k50Var) {
            this();
        }

        public final boolean a(int i) {
            View view;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-732237854")) {
                return ((Boolean) ipChange.ipc$dispatch("-732237854", new Object[]{this, Integer.valueOf(i)})).booleanValue();
            }
            WeakReference weakReference = FeedTabContainer.weakTabView;
            return weakReference != null && (view = (View) weakReference.get()) != null && view.isAttachedToWindow() && view.getTop() <= i;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FeedTabContainer(@NotNull View view) {
        super(view);
        b41.i(view, "itemView");
        weakTabView = new WeakReference<>(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: scrollToTop$lambda-3$lambda-2$lambda-1  reason: not valid java name */
    public static final void m59scrollToTop$lambda3$lambda2$lambda1(RecyclerView recyclerView, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-243430886")) {
            ipChange.ipc$dispatch("-243430886", new Object[]{recyclerView, Integer.valueOf(i)});
            return;
        }
        b41.i(recyclerView, "$this_apply");
        RecyclerView.ViewHolder findViewHolderForAdapterPosition = recyclerView.findViewHolderForAdapterPosition(i + 1);
        if (findViewHolderForAdapterPosition != null) {
            recyclerView.scrollBy(0, findViewHolderForAdapterPosition.itemView.getTop() - DisplayUtil.dip2px(recyclerView.getContext(), 42.0f));
        }
    }

    @Override // com.alient.onearch.adapter.component.tab.generic.vertical.VerticalTabView
    public void scrollToTop() {
        final int realPositionForAdapter;
        final RecyclerView recyclerView;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1308603060")) {
            ipChange.ipc$dispatch("-1308603060", new Object[]{this});
            return;
        }
        IContainer<ModelValue> pageContainer = getContainerItem().getPageContext().getPageContainer();
        ContentAdapter contentAdapter = pageContainer != null ? pageContainer.getContentAdapter() : null;
        VBaseAdapter<IItem<ItemValue>, VBaseHolder<IItem<ItemValue>, GenericRenderConfig>> adapter = getContainerItem().getComponent().getAdapter();
        if (adapter == null || contentAdapter == null || (realPositionForAdapter = getRealPositionForAdapter(contentAdapter, adapter)) <= 0) {
            return;
        }
        GenericFragment fragment = getContainerItem().getPageContext().getFragment();
        if (fragment != null && (recyclerView = fragment.getRecyclerView()) != null) {
            recyclerView.scrollToPosition(realPositionForAdapter + 1);
            recyclerView.post(new Runnable() { // from class: tb.ei0
                @Override // java.lang.Runnable
                public final void run() {
                    FeedTabContainer.m59scrollToTop$lambda3$lambda2$lambda1(RecyclerView.this, realPositionForAdapter);
                }
            });
        }
        EventBus eventBus = getContainerItem().getPageContext().getEventBus();
        if (eventBus != null) {
            eventBus.post(new Event(STICKY_SCROLL_TOP));
        }
    }

    @Override // com.alient.onearch.adapter.component.tab.generic.vertical.VerticalTabView, com.alient.onearch.adapter.component.tab.generic.vertical.VerticalTabContract.View
    public void setChildComponentData(@NotNull IItem<ItemValue> iItem, @NotNull List<RichTitle> list, @NotNull List<? extends JSONArray> list2, @NotNull List<? extends Node> list3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1022460345")) {
            ipChange.ipc$dispatch("1022460345", new Object[]{this, iItem, list, list2, list3});
            return;
        }
        b41.i(iItem, "containerItem");
        b41.i(list, "childComponentTitles");
        b41.i(list2, "childComponentBtns");
        b41.i(list3, "childComponentNodes");
        ux0.i().p(list);
        super.setChildComponentData(iItem, list, list2, list3);
    }

    @Override // com.alient.onearch.adapter.component.tab.generic.vertical.VerticalTabView, com.alient.onearch.adapter.component.tab.generic.vertical.VerticalTabContract.View
    public void showCurrentComponent(int i, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1873131745")) {
            ipChange.ipc$dispatch("1873131745", new Object[]{this, Integer.valueOf(i), Boolean.valueOf(z)});
            return;
        }
        ux0.i().o(i);
        super.showCurrentComponent(i, z);
    }
}
