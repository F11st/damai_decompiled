package com.alient.onearch.adapter.component.pager;

import android.view.View;
import com.alient.onearch.adapter.R;
import com.alient.onearch.adapter.component.pager.PagerGridContract;
import com.alient.onearch.adapter.view.AbsView;
import com.alient.onearch.adapter.widget.indicator.PagerIndicator;
import com.taobao.weex.common.Constants;
import com.taobao.weex.ui.component.WXBasicComponentType;
import com.youku.arch.v3.IItem;
import com.youku.arch.v3.adapter.VBaseAdapter;
import com.youku.arch.v3.adapter.VBaseHolder;
import com.youku.arch.v3.core.ItemValue;
import com.youku.arch.v3.core.item.GenericItem;
import com.youku.arch.v3.data.Constants;
import com.youku.arch.v3.view.render.GenericRenderConfig;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.m;
import org.jetbrains.annotations.NotNull;
import tb.b41;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00012\u00020\u0006B\u000f\u0012\u0006\u0010 \u001a\u00020\u001f¢\u0006\u0004\b!\u0010\"Jb\u0010\u0014\u001a\u00020\u00132\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u000720\u0010\u0012\u001a,\u0012(\u0012&\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u000f\u0012\u0016\u0012\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u000f\u0012\u0004\u0012\u00020\u00110\u00100\u000e0\rH\u0016R\u0019\u0010\u0016\u001a\u00020\u00158\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0019\u0010\u001b\u001a\u00020\u001a8\u0006@\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e¨\u0006#"}, d2 = {"Lcom/alient/onearch/adapter/component/pager/PagerGridView;", "Lcom/alient/onearch/adapter/view/AbsView;", "Lcom/youku/arch/v3/core/item/GenericItem;", "Lcom/youku/arch/v3/core/ItemValue;", "Lcom/alient/onearch/adapter/component/pager/PagerGridModel;", "Lcom/alient/onearch/adapter/component/pager/PagerGridPresenter;", "Lcom/alient/onearch/adapter/component/pager/PagerGridContract$View;", "", Constants.GAP, Constants.Name.MARGIN_LEFT, Constants.Name.MARGIN_RIGHT, "rowHeight", Constants.Name.COLUMN_COUNT, "", "Lcom/youku/arch/v3/adapter/VBaseAdapter;", "Lcom/youku/arch/v3/IItem;", "Lcom/youku/arch/v3/adapter/VBaseHolder;", "Lcom/youku/arch/v3/view/render/GenericRenderConfig;", "childAdapters", "Ltb/wt2;", "renderPagerInView", "Lcom/alient/onearch/adapter/component/pager/GridViewPager;", "gridViewPager", "Lcom/alient/onearch/adapter/component/pager/GridViewPager;", "getGridViewPager", "()Lcom/alient/onearch/adapter/component/pager/GridViewPager;", "Lcom/alient/onearch/adapter/widget/indicator/PagerIndicator;", WXBasicComponentType.INDICATOR, "Lcom/alient/onearch/adapter/widget/indicator/PagerIndicator;", "getIndicator", "()Lcom/alient/onearch/adapter/widget/indicator/PagerIndicator;", "Landroid/view/View;", "contentView", "<init>", "(Landroid/view/View;)V", "onearch-adapter_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes10.dex */
public class PagerGridView extends AbsView<GenericItem<ItemValue>, PagerGridModel, PagerGridPresenter> implements PagerGridContract.View {
    @NotNull
    private final GridViewPager gridViewPager;
    @NotNull
    private final PagerIndicator indicator;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PagerGridView(@NotNull View view) {
        super(view);
        b41.i(view, "contentView");
        View findViewById = view.findViewById(R.id.view_pager);
        b41.h(findViewById, "contentView.findViewById(R.id.view_pager)");
        this.gridViewPager = (GridViewPager) findViewById;
        View findViewById2 = view.findViewById(R.id.indicator);
        b41.h(findViewById2, "contentView.findViewById(R.id.indicator)");
        this.indicator = (PagerIndicator) findViewById2;
    }

    @NotNull
    public final GridViewPager getGridViewPager() {
        return this.gridViewPager;
    }

    @NotNull
    public final PagerIndicator getIndicator() {
        return this.indicator;
    }

    public void renderPagerInView(int i, int i2, int i3, int i4, int i5, @NotNull List<? extends VBaseAdapter<IItem<ItemValue>, VBaseHolder<IItem<ItemValue>, GenericRenderConfig>>> list) {
        b41.i(list, "childAdapters");
        this.gridViewPager.setData(i, i2, i3, i5, list);
        int i6 = 0;
        if (list.size() <= 1) {
            this.indicator.setVisibility(8);
            this.indicator.setViewPager(null);
        } else {
            this.indicator.setVisibility(0);
            this.indicator.setViewPager(this.gridViewPager);
        }
        for (Object obj : list) {
            int i7 = i6 + 1;
            if (i6 < 0) {
                m.p();
            }
            getGridViewPager().setPagerHeights(((int) Math.ceil(((VBaseAdapter) obj).dataCount / i5)) * i4, i6);
            i6 = i7;
        }
        this.gridViewPager.notifyDataSetChanged();
    }
}
