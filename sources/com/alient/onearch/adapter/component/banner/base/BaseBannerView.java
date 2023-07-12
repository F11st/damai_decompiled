package com.alient.onearch.adapter.component.banner.base;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.gaiax.GXTemplateEngine;
import com.alient.onearch.adapter.component.banner.base.BaseBannerContract;
import com.alient.onearch.adapter.component.banner.base.BaseBannerView;
import com.alient.onearch.adapter.view.AbsView;
import com.taobao.weex.common.Constants;
import com.youku.arch.v3.adapter.VBaseAdapter;
import com.youku.arch.v3.core.ItemValue;
import com.youku.arch.v3.core.item.GenericItem;
import com.youku.arch.v3.data.Constants;
import com.youku.arch.v3.util.ViewUtil;
import io.flutter.wpkbridge.WPKFactory;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.wt2;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\b&\u0018\u00002\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00012\u00020\u0006:\u000201B\u000f\u0012\u0006\u0010-\u001a\u00020,¢\u0006\u0004\b.\u0010/J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0002J0\u0010\u0012\u001a\u00020\u00072\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0014\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\r2\u0006\u0010\u0011\u001a\u00020\u000eH\u0002J(\u0010\u0016\u001a\u00020\t2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0014\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f\u0018\u00010\rH\u0016J\u001a\u0010\u0019\u001a\u00020\t2\u0010\u0010\u0018\u001a\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\u0017H\u0016J\b\u0010\u001a\u001a\u00020\tH\u0016R$\u0010\u001c\u001a\u0004\u0018\u00010\u001b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\"\u0010#\u001a\u00020\"8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u0016\u0010)\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010+\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b+\u0010*¨\u00062"}, d2 = {"Lcom/alient/onearch/adapter/component/banner/base/BaseBannerView;", "Lcom/alient/onearch/adapter/view/AbsView;", "Lcom/youku/arch/v3/core/item/GenericItem;", "Lcom/youku/arch/v3/core/ItemValue;", "Lcom/alient/onearch/adapter/component/banner/base/BaseBannerModel;", "Lcom/alient/onearch/adapter/component/banner/base/BaseBannerPresenter;", "Lcom/alient/onearch/adapter/component/banner/base/BaseBannerContract$View;", "", "position", "Ltb/wt2;", "pageChanged", "Landroid/content/Context;", WPKFactory.INIT_KEY_CONTEXT, "", "", "", "data", "paramName", "getDimenId", "Landroidx/recyclerview/widget/RecyclerView$RecycledViewPool;", "recycledViewPool", "params", "initRecyclerSettings", "Lcom/youku/arch/v3/adapter/VBaseAdapter;", "innerAdapter", "setAdapter", "resetViewHolder", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "itemDecoration", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "getItemDecoration", "()Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "setItemDecoration", "(Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;)V", "Landroidx/recyclerview/widget/PagerSnapHelper;", "pagerSnapHelper", "Landroidx/recyclerview/widget/PagerSnapHelper;", "getPagerSnapHelper", "()Landroidx/recyclerview/widget/PagerSnapHelper;", "setPagerSnapHelper", "(Landroidx/recyclerview/widget/PagerSnapHelper;)V", "selectedItemPosition", "I", "intermediateSelectedItemPosition", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "BannerViewItemDecoration", "InternalRecyclerScrollListener", "onearch-adapter_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes10.dex */
public abstract class BaseBannerView extends AbsView<GenericItem<ItemValue>, BaseBannerModel, BaseBannerPresenter> implements BaseBannerContract.View {
    private int intermediateSelectedItemPosition;
    @Nullable
    private RecyclerView.ItemDecoration itemDecoration;
    @NotNull
    private PagerSnapHelper pagerSnapHelper;
    private int selectedItemPosition;

    /* compiled from: Taobao */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0004\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\n\u001a\u00020\u0004\u0012\u0006\u0010\f\u001a\u00020\u0004\u0012\u0006\u0010\r\u001a\u00020\u0004¢\u0006\u0004\b\u000e\u0010\u000fJ \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016R\u0016\u0010\n\u001a\u00020\u00048\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0016\u0010\f\u001a\u00020\u00048\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\u000bR\u0016\u0010\r\u001a\u00020\u00048\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000b¨\u0006\u0010"}, d2 = {"Lcom/alient/onearch/adapter/component/banner/base/BaseBannerView$BannerViewItemDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "Landroid/graphics/Rect;", "outRect", "", "itemPosition", "Landroidx/recyclerview/widget/RecyclerView;", "parent", "Ltb/wt2;", "getItemOffsets", Constants.GAP, "I", Constants.Name.MARGIN_LEFT, Constants.Name.MARGIN_RIGHT, "<init>", "(Lcom/alient/onearch/adapter/component/banner/base/BaseBannerView;III)V", "onearch-adapter_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes10.dex */
    public final class BannerViewItemDecoration extends RecyclerView.ItemDecoration {
        private final int gap;
        private final int marginLeft;
        private final int marginRight;
        final /* synthetic */ BaseBannerView this$0;

        public BannerViewItemDecoration(BaseBannerView baseBannerView, int i, int i2, int i3) {
            b41.i(baseBannerView, "this$0");
            this.this$0 = baseBannerView;
            this.gap = i;
            this.marginLeft = i2;
            this.marginRight = i3;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(@NotNull Rect rect, int i, @NotNull RecyclerView recyclerView) {
            b41.i(rect, "outRect");
            b41.i(recyclerView, "parent");
            RecyclerView.Adapter adapter = recyclerView.getAdapter();
            if (adapter == null) {
                return;
            }
            if (i == 0) {
                int i2 = this.marginLeft;
                if (i2 != 0) {
                    rect.left = i2;
                } else {
                    rect.left = this.gap;
                }
            }
            if (i == adapter.getItemCount() - 1) {
                int i3 = this.marginRight;
                if (i3 != 0) {
                    rect.right = i3;
                    return;
                } else {
                    rect.right = this.gap;
                    return;
                }
            }
            rect.right = this.gap / 2;
        }
    }

    /* compiled from: Taobao */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0080\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0010\u0010\u0011J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002H\u0002J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0002H\u0002J\u0018\u0010\u000f\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0016¨\u0006\u0012"}, d2 = {"Lcom/alient/onearch/adapter/component/banner/base/BaseBannerView$InternalRecyclerScrollListener;", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "Landroid/view/View;", "getMostVisibleChild", "containerView", "child", "", "calculatePercentVisible", "mostVisibleChild", "Ltb/wt2;", "setSelectedItemPosition", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "newState", GXTemplateEngine.C3344g.TYPE_ON_SCROLL_STATE_CHANGED, "<init>", "(Lcom/alient/onearch/adapter/component/banner/base/BaseBannerView;)V", "onearch-adapter_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes10.dex */
    public final class InternalRecyclerScrollListener extends RecyclerView.OnScrollListener {
        final /* synthetic */ BaseBannerView this$0;

        public InternalRecyclerScrollListener(BaseBannerView baseBannerView) {
            b41.i(baseBannerView, "this$0");
            this.this$0 = baseBannerView;
        }

        private final float calculatePercentVisible(View view, View view2) {
            float width;
            int left = view2.getLeft();
            int right = view2.getRight();
            int width2 = view2.getWidth();
            if (left < 0) {
                width = right;
            } else if (right <= view.getWidth()) {
                return 1.0f;
            } else {
                width = view.getWidth() - left;
            }
            return width / width2;
        }

        private final View getMostVisibleChild() {
            View renderView;
            RecyclerView.LayoutManager layoutManager = this.this$0.getRecyclerView().getLayoutManager();
            b41.f(layoutManager);
            int childCount = layoutManager.getChildCount() - 1;
            View view = null;
            if (childCount >= 0) {
                float f = 0.0f;
                while (true) {
                    int i = childCount - 1;
                    RecyclerView.LayoutManager layoutManager2 = this.this$0.getRecyclerView().getLayoutManager();
                    b41.f(layoutManager2);
                    View childAt = layoutManager2.getChildAt(childCount);
                    if (childAt != null && (renderView = this.this$0.getRenderView()) != null) {
                        float calculatePercentVisible = calculatePercentVisible(renderView, childAt);
                        if (calculatePercentVisible >= f) {
                            view = childAt;
                            f = calculatePercentVisible;
                        }
                    }
                    if (i < 0) {
                        break;
                    }
                    childCount = i;
                }
            }
            return view;
        }

        private final void setSelectedItemPosition(View view) {
            RecyclerView.ViewHolder findContainingViewHolder = this.this$0.getRecyclerView().findContainingViewHolder(view);
            if (findContainingViewHolder == null) {
                return;
            }
            Integer valueOf = Integer.valueOf(findContainingViewHolder.getAdapterPosition());
            this.this$0.intermediateSelectedItemPosition = valueOf.intValue();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(@NotNull RecyclerView recyclerView, int i) {
            View mostVisibleChild;
            b41.i(recyclerView, "recyclerView");
            super.onScrollStateChanged(recyclerView, i);
            if (i != 0 || (mostVisibleChild = getMostVisibleChild()) == null) {
                return;
            }
            BaseBannerView baseBannerView = this.this$0;
            setSelectedItemPosition(mostVisibleChild);
            baseBannerView.selectedItemPosition = baseBannerView.intermediateSelectedItemPosition;
            baseBannerView.pageChanged(baseBannerView.selectedItemPosition);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseBannerView(@NotNull View view) {
        super(view);
        b41.i(view, "view");
        this.pagerSnapHelper = new PagerSnapHelper();
    }

    private final int getDimenId(Context context, Map<String, ? extends Object> map, String str) {
        if (map.containsKey(str)) {
            return ViewUtil.getIdentifier(context, (String) map.get(str), com.youku.arch.v3.data.Constants.DIMEN);
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void pageChanged(int i) {
        ((BaseBannerPresenter) getPresenter()).onPageChanged(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: resetViewHolder$lambda-6  reason: not valid java name */
    public static final void m196resetViewHolder$lambda6(BaseBannerView baseBannerView) {
        b41.i(baseBannerView, "this$0");
        baseBannerView.getRecyclerView().scrollToPosition(0);
    }

    @Nullable
    public final RecyclerView.ItemDecoration getItemDecoration() {
        return this.itemDecoration;
    }

    @NotNull
    public final PagerSnapHelper getPagerSnapHelper() {
        return this.pagerSnapHelper;
    }

    public void initRecyclerSettings(@Nullable RecyclerView.RecycledViewPool recycledViewPool, @Nullable Map<String, ? extends Object> map) {
        RecyclerView recyclerView = getRecyclerView();
        if (map != null) {
            int dimenId = getDimenId(recyclerView.getContext(), map, com.youku.arch.v3.data.Constants.GAP);
            int dimensionPixelSize = dimenId != 0 ? recyclerView.getContext().getResources().getDimensionPixelSize(dimenId) : 0;
            int dimenId2 = getDimenId(recyclerView.getContext(), map, Constants.Name.MARGIN_LEFT);
            int dimensionPixelSize2 = dimenId2 != 0 ? recyclerView.getContext().getResources().getDimensionPixelSize(dimenId2) : 0;
            int dimenId3 = getDimenId(recyclerView.getContext(), map, Constants.Name.MARGIN_RIGHT);
            int dimensionPixelSize3 = dimenId3 != 0 ? recyclerView.getContext().getResources().getDimensionPixelSize(dimenId3) : 0;
            RecyclerView.ItemDecoration itemDecoration = getItemDecoration();
            if (itemDecoration != null) {
                recyclerView.removeItemDecoration(itemDecoration);
            }
            BannerViewItemDecoration bannerViewItemDecoration = new BannerViewItemDecoration(this, dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize3);
            recyclerView.addItemDecoration(bannerViewItemDecoration);
            wt2 wt2Var = wt2.INSTANCE;
            setItemDecoration(bannerViewItemDecoration);
        }
        if (recycledViewPool != null) {
            recyclerView.setRecycledViewPool(recycledViewPool);
        }
        getPagerSnapHelper().attachToRecyclerView(recyclerView);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext(), 0, false));
        recyclerView.addOnScrollListener(new InternalRecyclerScrollListener(this));
    }

    @Override // com.alient.onearch.adapter.component.banner.base.BaseBannerContract.View
    public void resetViewHolder() {
        getRecyclerView().post(new Runnable() { // from class: tb.ia
            @Override // java.lang.Runnable
            public final void run() {
                BaseBannerView.m196resetViewHolder$lambda6(BaseBannerView.this);
            }
        });
    }

    @Override // com.alient.onearch.adapter.component.banner.base.BaseBannerContract.View
    public void setAdapter(@Nullable VBaseAdapter<?, ?> vBaseAdapter) {
        getRecyclerView().swapAdapter(vBaseAdapter, false);
        RecyclerView.LayoutManager layoutManager = getRecyclerView().getLayoutManager();
        LinearLayoutManager linearLayoutManager = layoutManager instanceof LinearLayoutManager ? (LinearLayoutManager) layoutManager : null;
        if (linearLayoutManager == null) {
            return;
        }
        linearLayoutManager.scrollToPosition(this.selectedItemPosition);
    }

    public final void setItemDecoration(@Nullable RecyclerView.ItemDecoration itemDecoration) {
        this.itemDecoration = itemDecoration;
    }

    public final void setPagerSnapHelper(@NotNull PagerSnapHelper pagerSnapHelper) {
        b41.i(pagerSnapHelper, "<set-?>");
        this.pagerSnapHelper = pagerSnapHelper;
    }
}
