package com.alient.onearch.adapter.component.grid;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.alient.onearch.adapter.R;
import com.alient.onearch.adapter.component.grid.GenericGridContract;
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
import tb.ye2;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00012\u00020\u0006:\u0001(B\u000f\u0012\u0006\u0010%\u001a\u00020$¢\u0006\u0004\b&\u0010'J0\u0010\u000f\u001a\u00020\u000e2\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0014\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\t2\u0006\u0010\r\u001a\u00020\nH\u0002J(\u0010\u0014\u001a\u00020\u00132\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0014\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\tH\u0016J\u001a\u0010\u0017\u001a\u00020\u00132\u0010\u0010\u0016\u001a\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\u0015H\u0016R\u0019\u0010\u0019\u001a\u00020\u00188\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR$\u0010\u001e\u001a\u0004\u0018\u00010\u001d8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#¨\u0006)"}, d2 = {"Lcom/alient/onearch/adapter/component/grid/GenericGridView;", "Lcom/alient/onearch/adapter/view/AbsView;", "Lcom/youku/arch/v3/core/item/GenericItem;", "Lcom/youku/arch/v3/core/ItemValue;", "Lcom/alient/onearch/adapter/component/grid/GenericGridModel;", "Lcom/alient/onearch/adapter/component/grid/GenericGridPresenter;", "Lcom/alient/onearch/adapter/component/grid/GenericGridContract$View;", "Landroid/content/Context;", WPKFactory.INIT_KEY_CONTEXT, "", "", "", "data", "paramName", "", "getDimenId", "Landroidx/recyclerview/widget/RecyclerView$RecycledViewPool;", "recycledViewPool", "params", "Ltb/wt2;", "initRecyclerSettings", "Lcom/youku/arch/v3/adapter/VBaseAdapter;", "innerAdapter", "setAdapter", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "getRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "itemDecoration", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "getItemDecoration", "()Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "setItemDecoration", "(Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;)V", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "GridViewItemDecoration", "onearch-adapter_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes10.dex */
public class GenericGridView extends AbsView<GenericItem<ItemValue>, GenericGridModel, GenericGridPresenter> implements GenericGridContract.View {
    @Nullable
    private RecyclerView.ItemDecoration itemDecoration;
    @NotNull
    private final RecyclerView recyclerView;

    /* compiled from: Taobao */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0004\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\n\u001a\u00020\u0004\u0012\u0006\u0010\f\u001a\u00020\u0004\u0012\u0006\u0010\r\u001a\u00020\u0004¢\u0006\u0004\b\u000e\u0010\u000fJ \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016R\u0016\u0010\n\u001a\u00020\u00048\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0016\u0010\f\u001a\u00020\u00048\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\u000bR\u0016\u0010\r\u001a\u00020\u00048\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000b¨\u0006\u0010"}, d2 = {"Lcom/alient/onearch/adapter/component/grid/GenericGridView$GridViewItemDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "Landroid/graphics/Rect;", "outRect", "", "itemPosition", "Landroidx/recyclerview/widget/RecyclerView;", "parent", "Ltb/wt2;", "getItemOffsets", Constants.GAP, "I", Constants.Name.MARGIN_LEFT, Constants.Name.MARGIN_RIGHT, "<init>", "(Lcom/alient/onearch/adapter/component/grid/GenericGridView;III)V", "onearch-adapter_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes10.dex */
    public final class GridViewItemDecoration extends RecyclerView.ItemDecoration {
        private final int gap;
        private final int marginLeft;
        private final int marginRight;
        final /* synthetic */ GenericGridView this$0;

        public GridViewItemDecoration(GenericGridView genericGridView, int i, int i2, int i3) {
            b41.i(genericGridView, "this$0");
            this.this$0 = genericGridView;
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
            } else if (i == adapter.getItemCount() - 1) {
                int i3 = this.marginRight;
                if (i3 != 0) {
                    rect.right = i3;
                } else {
                    rect.right = this.gap;
                }
                rect.left = this.gap;
            } else {
                rect.left = this.gap;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GenericGridView(@NotNull View view) {
        super(view);
        b41.i(view, "view");
        View findViewById = view.findViewById(R.id.grid_container);
        b41.h(findViewById, "view.findViewById(R.id.grid_container)");
        this.recyclerView = (RecyclerView) findViewById;
    }

    private final int getDimenId(Context context, Map<String, ? extends Object> map, String str) {
        if (map.containsKey(str)) {
            return ViewUtil.getIdentifier(context, (String) map.get(str), com.youku.arch.v3.data.Constants.DIMEN);
        }
        return 0;
    }

    @Nullable
    public final RecyclerView.ItemDecoration getItemDecoration() {
        return this.itemDecoration;
    }

    @NotNull
    public final RecyclerView getRecyclerView() {
        return this.recyclerView;
    }

    @Override // com.alient.onearch.adapter.component.grid.GenericGridContract.View
    public void initRecyclerSettings(@Nullable RecyclerView.RecycledViewPool recycledViewPool, @Nullable Map<String, ? extends Object> map) {
        RecyclerView recyclerView = this.recyclerView;
        if (map == null) {
            return;
        }
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
        GridViewItemDecoration gridViewItemDecoration = new GridViewItemDecoration(this, dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize3);
        recyclerView.addItemDecoration(gridViewItemDecoration);
        wt2 wt2Var = wt2.INSTANCE;
        setItemDecoration(gridViewItemDecoration);
        Object obj = map.get(Constants.Name.COLUMN_COUNT);
        Integer num = obj instanceof Integer ? (Integer) obj : null;
        int intValue = num != null ? num.intValue() : 0;
        if (recycledViewPool != null) {
            recyclerView.setRecycledViewPool(recycledViewPool);
        }
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        Context context = recyclerView.getContext();
        ye2 ye2Var = ye2.INSTANCE;
        Context context2 = recyclerView.getContext();
        b41.h(context2, WPKFactory.INIT_KEY_CONTEXT);
        recyclerView.setLayoutManager(new GridLayoutManager(context, ye2Var.d(context2, intValue)));
    }

    @Override // com.alient.onearch.adapter.component.grid.GenericGridContract.View
    public void setAdapter(@Nullable VBaseAdapter<?, ?> vBaseAdapter) {
        this.recyclerView.swapAdapter(vBaseAdapter, false);
    }

    public final void setItemDecoration(@Nullable RecyclerView.ItemDecoration itemDecoration) {
        this.itemDecoration = itemDecoration;
    }
}
