package cn.damai.onearch.component.banner.zoom;

import android.view.View;
import cn.damai.common.image.a;
import cn.damai.commonbusiness.R$id;
import cn.damai.onearch.component.banner.zoom.ZoomBannerContract;
import cn.damai.tetris.component.home.widget.banner.sub.RoundRadiusImageView;
import com.alient.onearch.adapter.view.AbsView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.core.ItemValue;
import com.youku.arch.v3.core.item.GenericItem;
import org.jetbrains.annotations.NotNull;
import tb.b41;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public final class ZoomBannerView extends AbsView<GenericItem<ItemValue>, ZoomBannerModel, ZoomBannerPresent> implements ZoomBannerContract.View {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    private final RoundRadiusImageView bg;
    @NotNull
    private final View view;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZoomBannerView(@NotNull View view) {
        super(view);
        b41.i(view, "view");
        this.view = view;
        View findViewById = view.findViewById(R$id.image);
        b41.h(findViewById, "view.findViewById(R.id.image)");
        this.bg = (RoundRadiusImageView) findViewById;
    }

    @NotNull
    public final View getView() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1042374249") ? (View) ipChange.ipc$dispatch("-1042374249", new Object[]{this}) : this.view;
    }

    @Override // cn.damai.onearch.component.banner.zoom.ZoomBannerContract.View
    public void renderBanner(@NotNull String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-576681374")) {
            ipChange.ipc$dispatch("-576681374", new Object[]{this, str});
            return;
        }
        b41.i(str, "picUrl");
        a.b().c(str).g(this.bg);
    }
}
