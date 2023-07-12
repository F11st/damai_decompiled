package cn.damai.onearch.component.banner;

import android.view.View;
import cn.damai.commonbusiness.R$id;
import cn.damai.onearch.component.banner.LoopBannerContract;
import cn.damai.onearch.component.banner.widget.Banner;
import cn.damai.onearch.component.banner.widget.IndicatorView;
import com.alient.onearch.adapter.view.AbsView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.adapter.VBaseAdapter;
import com.youku.arch.v3.core.ItemValue;
import com.youku.arch.v3.core.item.GenericItem;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public final class LoopBannerView extends AbsView<GenericItem<ItemValue>, LoopBannerModel, LoopBannerPresenter> implements LoopBannerContract.View {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    private final Banner banner;
    @NotNull
    private final IndicatorView indicator;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LoopBannerView(@NotNull View view) {
        super(view);
        b41.i(view, "view");
        View findViewById = view.findViewById(R$id.banner);
        b41.h(findViewById, "view.findViewById(R.id.banner)");
        this.banner = (Banner) findViewById;
        View findViewById2 = view.findViewById(R$id.indicator);
        b41.h(findViewById2, "view.findViewById(R.id.indicator)");
        this.indicator = (IndicatorView) findViewById2;
    }

    @NotNull
    public final Banner getBanner() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1536811064") ? (Banner) ipChange.ipc$dispatch("1536811064", new Object[]{this}) : this.banner;
    }

    @NotNull
    public final IndicatorView getIndicator() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "609794917") ? (IndicatorView) ipChange.ipc$dispatch("609794917", new Object[]{this}) : this.indicator;
    }

    @Override // cn.damai.onearch.component.banner.LoopBannerContract.View
    public void setAdapter(@Nullable VBaseAdapter<?, ?> vBaseAdapter) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1743907834")) {
            ipChange.ipc$dispatch("1743907834", new Object[]{this, vBaseAdapter});
            return;
        }
        this.indicator.setIndicatorStyle(0);
        this.indicator.setIndicatorColor(-1711276033);
        this.indicator.setIndicatorSelectorColor(-1);
        this.banner.setIndicator(this.indicator, false);
        this.banner.setAdapter(vBaseAdapter);
    }
}
