package com.alibaba.pictures.bricks.component.imgcard;

import android.view.View;
import android.widget.ImageView;
import com.alibaba.pictures.R$drawable;
import com.alibaba.pictures.R$id;
import com.alibaba.pictures.bricks.component.imgcard.BannerContract;
import com.alient.onearch.adapter.view.AbsView;
import com.alient.oneservice.image.ImageLoaderProvider;
import com.alient.oneservice.image.ImageLoaderProviderProxy;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.core.ItemValue;
import com.youku.arch.v3.core.item.GenericItem;
import com.youku.arch.v3.util.DisplayUtils;
import org.jetbrains.annotations.NotNull;
import tb.b41;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class ImageCardView extends AbsView<GenericItem<ItemValue>, BannerModel, BannerPresent> implements BannerContract.View {
    private static transient /* synthetic */ IpChange $ipChange;
    private final ImageView image;
    @NotNull
    private final View view;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ImageCardView(@NotNull View view) {
        super(view);
        b41.i(view, "view");
        this.view = view;
        this.image = (ImageView) view.findViewById(R$id.common_banner_view_bg);
    }

    @NotNull
    public final View getView() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "943878902") ? (View) ipChange.ipc$dispatch("943878902", new Object[]{this}) : this.view;
    }

    @Override // com.alibaba.pictures.bricks.component.imgcard.BannerContract.View
    public void renderImage(@NotNull BannerBean bannerBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1640666933")) {
            ipChange.ipc$dispatch("-1640666933", new Object[]{this, bannerBean});
            return;
        }
        b41.i(bannerBean, "content");
        this.view.getLayoutParams().width = DisplayUtils.getWidthPixels() - DisplayUtils.dp2px(24);
        ImageLoaderProvider proxy = ImageLoaderProviderProxy.getProxy();
        String str = bannerBean.url;
        ImageView imageView = this.image;
        int i = R$drawable.default_color_f0f0f0;
        proxy.loadinto(str, imageView, i, i);
        if (bannerBean.isVideo) {
            ((ImageView) this.view.findViewById(R$id.common_banner_view_play)).setVisibility(0);
        } else {
            ((ImageView) this.view.findViewById(R$id.common_banner_view_play)).setVisibility(8);
        }
    }
}
