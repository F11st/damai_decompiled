package com.alient.onearch.adapter.component.banner.generic;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.alient.onearch.adapter.R;
import com.alient.onearch.adapter.component.banner.base.BaseBannerView;
import com.alient.onearch.adapter.component.banner.generic.GenericBannerContract;
import com.alient.onearch.adapter.widget.indicator.PagerIndicator2;
import com.taobao.weex.ui.component.WXBasicComponentType;
import com.youku.arch.v3.adapter.VBaseAdapter;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0006\u001a\u00020\u00052\u0010\u0010\u0004\u001a\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\u0003H\u0016R\u001c\u0010\b\u001a\u00020\u00078\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\r\u001a\u00020\f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u0013"}, d2 = {"Lcom/alient/onearch/adapter/component/banner/generic/GenericBannerView;", "Lcom/alient/onearch/adapter/component/banner/base/BaseBannerView;", "Lcom/alient/onearch/adapter/component/banner/generic/GenericBannerContract$View;", "Lcom/youku/arch/v3/adapter/VBaseAdapter;", "innerAdapter", "Ltb/wt2;", "setAdapter", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "getRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "Lcom/alient/onearch/adapter/widget/indicator/PagerIndicator2;", WXBasicComponentType.INDICATOR, "Lcom/alient/onearch/adapter/widget/indicator/PagerIndicator2;", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "onearch-adapter_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes10.dex */
public final class GenericBannerView extends BaseBannerView implements GenericBannerContract.View {
    @NotNull
    private final PagerIndicator2 indicator;
    @NotNull
    private final RecyclerView recyclerView;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GenericBannerView(@NotNull View view) {
        super(view);
        b41.i(view, "view");
        View findViewById = view.findViewById(R.id.banner_container);
        b41.h(findViewById, "view.findViewById(R.id.banner_container)");
        this.recyclerView = (RecyclerView) findViewById;
        View findViewById2 = view.findViewById(R.id.indicator);
        b41.h(findViewById2, "view.findViewById(R.id.indicator)");
        this.indicator = (PagerIndicator2) findViewById2;
    }

    @Override // com.alient.onearch.adapter.component.banner.base.BaseBannerContract.View
    @NotNull
    public RecyclerView getRecyclerView() {
        return this.recyclerView;
    }

    @Override // com.alient.onearch.adapter.component.banner.base.BaseBannerView, com.alient.onearch.adapter.component.banner.base.BaseBannerContract.View
    public void setAdapter(@Nullable VBaseAdapter<?, ?> vBaseAdapter) {
        super.setAdapter(vBaseAdapter);
        this.indicator.attachToRecyclerView(getRecyclerView(), getPagerSnapHelper());
    }
}
