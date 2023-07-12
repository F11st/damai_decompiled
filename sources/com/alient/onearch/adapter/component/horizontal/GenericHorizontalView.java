package com.alient.onearch.adapter.component.horizontal;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.alient.onearch.adapter.R;
import com.alient.onearch.adapter.component.horizontal.GenericHorizontalContract;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00012\u00020\u0006:\u0001&B\u000f\u0012\u0006\u0010#\u001a\u00020\"¢\u0006\u0004\b$\u0010%J0\u0010\u000f\u001a\u00020\u000e2\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0014\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\t2\u0006\u0010\r\u001a\u00020\nH\u0002J$\u0010\u0015\u001a\u00020\u00142\u0010\u0010\u0011\u001a\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016J(\u0010\u0019\u001a\u00020\u00142\b\u0010\u0017\u001a\u0004\u0018\u00010\u00162\u0014\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\tH\u0016R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u001c\u0010\u001e\u001a\u00020\u001d8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!¨\u0006'"}, d2 = {"Lcom/alient/onearch/adapter/component/horizontal/GenericHorizontalView;", "Lcom/alient/onearch/adapter/view/AbsView;", "Lcom/youku/arch/v3/core/item/GenericItem;", "Lcom/youku/arch/v3/core/ItemValue;", "Lcom/alient/onearch/adapter/component/horizontal/GenericHorizontalModel;", "Lcom/alient/onearch/adapter/component/horizontal/GenericHorizontalPresenter;", "Lcom/alient/onearch/adapter/component/horizontal/GenericHorizontalContract$View;", "Landroid/content/Context;", WPKFactory.INIT_KEY_CONTEXT, "", "", "", "data", "paramName", "", "getDimenId", "Lcom/youku/arch/v3/adapter/VBaseAdapter;", "innerAdapter", "Landroid/app/Activity;", "activity", "Ltb/wt2;", "setAdapter", "Landroidx/recyclerview/widget/RecyclerView$RecycledViewPool;", "recycledViewPool", "params", "initRecyclerSettings", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "itemDecoration", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "getRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "HorizontalViewItemDecoration", "onearch-adapter_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes10.dex */
public class GenericHorizontalView extends AbsView<GenericItem<ItemValue>, GenericHorizontalModel, GenericHorizontalPresenter> implements GenericHorizontalContract.View {
    @Nullable
    private RecyclerView.ItemDecoration itemDecoration;
    @NotNull
    private final RecyclerView recyclerView;

    /* compiled from: Taobao */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0004\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\n\u001a\u00020\u0004\u0012\u0006\u0010\f\u001a\u00020\u0004\u0012\u0006\u0010\r\u001a\u00020\u0004¢\u0006\u0004\b\u000e\u0010\u000fJ \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016R\u0016\u0010\n\u001a\u00020\u00048\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0016\u0010\f\u001a\u00020\u00048\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\u000bR\u0016\u0010\r\u001a\u00020\u00048\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000b¨\u0006\u0010"}, d2 = {"Lcom/alient/onearch/adapter/component/horizontal/GenericHorizontalView$HorizontalViewItemDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "Landroid/graphics/Rect;", "outRect", "", "itemPosition", "Landroidx/recyclerview/widget/RecyclerView;", "parent", "Ltb/wt2;", "getItemOffsets", Constants.GAP, "I", Constants.Name.MARGIN_LEFT, Constants.Name.MARGIN_RIGHT, "<init>", "(Lcom/alient/onearch/adapter/component/horizontal/GenericHorizontalView;III)V", "onearch-adapter_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes10.dex */
    public final class HorizontalViewItemDecoration extends RecyclerView.ItemDecoration {
        private final int gap;
        private final int marginLeft;
        private final int marginRight;
        final /* synthetic */ GenericHorizontalView this$0;

        public HorizontalViewItemDecoration(GenericHorizontalView genericHorizontalView, int i, int i2, int i3) {
            b41.i(genericHorizontalView, "this$0");
            this.this$0 = genericHorizontalView;
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

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GenericHorizontalView(@NotNull View view) {
        super(view);
        b41.i(view, "view");
        View findViewById = view.findViewById(R.id.horizontal_container);
        b41.h(findViewById, "view.findViewById(R.id.horizontal_container)");
        this.recyclerView = (RecyclerView) findViewById;
    }

    private final int getDimenId(Context context, Map<String, ? extends Object> map, String str) {
        if (map.containsKey(str)) {
            return ViewUtil.getIdentifier(context, (String) map.get(str), com.youku.arch.v3.data.Constants.DIMEN);
        }
        return 0;
    }

    @Override // com.alient.onearch.adapter.component.horizontal.GenericHorizontalContract.View
    @NotNull
    public RecyclerView getRecyclerView() {
        return this.recyclerView;
    }

    public void initRecyclerSettings(@Nullable RecyclerView.RecycledViewPool recycledViewPool, @Nullable Map<String, ? extends Object> map) {
        RecyclerView recyclerView = getRecyclerView();
        if (map != null) {
            int dimenId = getDimenId(recyclerView.getContext(), map, com.youku.arch.v3.data.Constants.GAP);
            int dimensionPixelSize = dimenId != 0 ? recyclerView.getContext().getResources().getDimensionPixelSize(dimenId) : 0;
            int dimenId2 = getDimenId(recyclerView.getContext(), map, "listMarginLeft");
            int dimensionPixelSize2 = dimenId2 != 0 ? recyclerView.getContext().getResources().getDimensionPixelSize(dimenId2) : 0;
            int dimenId3 = getDimenId(recyclerView.getContext(), map, "listMarginRight");
            int dimensionPixelSize3 = dimenId3 != 0 ? recyclerView.getContext().getResources().getDimensionPixelSize(dimenId3) : 0;
            RecyclerView.ItemDecoration itemDecoration = this.itemDecoration;
            if (itemDecoration != null) {
                recyclerView.removeItemDecoration(itemDecoration);
            }
            HorizontalViewItemDecoration horizontalViewItemDecoration = new HorizontalViewItemDecoration(this, dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize3);
            recyclerView.addItemDecoration(horizontalViewItemDecoration);
            wt2 wt2Var = wt2.INSTANCE;
            this.itemDecoration = horizontalViewItemDecoration;
        }
        if (recycledViewPool != null) {
            recyclerView.setRecycledViewPool(recycledViewPool);
        }
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(recyclerView.getContext(), 0, false);
        linearLayoutManager.setItemPrefetchEnabled(false);
        wt2 wt2Var2 = wt2.INSTANCE;
        recyclerView.setLayoutManager(linearLayoutManager);
    }

    @Override // com.alient.onearch.adapter.component.horizontal.GenericHorizontalContract.View
    public void setAdapter(@Nullable VBaseAdapter<?, ?> vBaseAdapter, @Nullable Activity activity) {
        getRecyclerView().swapAdapter(vBaseAdapter, false);
    }
}
