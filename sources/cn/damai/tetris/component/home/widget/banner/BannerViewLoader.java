package cn.damai.tetris.component.home.widget.banner;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import cn.damai.common.image.DMImageCreator;
import cn.damai.commonbusiness.R$drawable;
import cn.damai.commonbusiness.R$id;
import cn.damai.commonbusiness.R$layout;
import cn.damai.tetris.component.home.widget.banner.loader.ImageLoaderInterface;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class BannerViewLoader implements ImageLoaderInterface {
    private static transient /* synthetic */ IpChange $ipChange;

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public class a implements DMImageCreator.DMImageSuccListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ ImageView a;

        a(BannerViewLoader bannerViewLoader, ImageView imageView) {
            this.a = imageView;
        }

        @Override // cn.damai.common.image.DMImageCreator.DMImageSuccListener
        public void onSuccess(DMImageCreator.e eVar) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "821450944")) {
                ipChange.ipc$dispatch("821450944", new Object[]{this, eVar});
            } else {
                this.a.setImageDrawable(eVar.a);
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public class b implements DMImageCreator.DMImageFailListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ ImageView a;

        b(BannerViewLoader bannerViewLoader, ImageView imageView) {
            this.a = imageView;
        }

        @Override // cn.damai.common.image.DMImageCreator.DMImageFailListener
        public void onFail(DMImageCreator.d dVar) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "549004397")) {
                ipChange.ipc$dispatch("549004397", new Object[]{this, dVar});
            } else {
                this.a.setImageResource(R$drawable.uikit_default_image_bg_grey);
            }
        }
    }

    @Override // cn.damai.tetris.component.home.widget.banner.loader.ImageLoaderInterface
    public View createImageView(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "97803776")) {
            return (View) ipChange.ipc$dispatch("97803776", new Object[]{this, context});
        }
        View inflate = LayoutInflater.from(context).inflate(R$layout.homepage_banner_item, (ViewGroup) null, false);
        BannerImageView bannerImageView = (BannerImageView) inflate.findViewById(R$id.image_banner);
        bannerImageView.setBorderRadius(12);
        bannerImageView.setBorder(0.5f, Color.parseColor("#1A000000"));
        bannerImageView.setImageResource(R$drawable.uikit_default_image_bg_grey);
        return inflate;
    }

    @Override // cn.damai.tetris.component.home.widget.banner.loader.ImageLoaderInterface
    public void displayImage(Context context, int i, Object obj, View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-182627368")) {
            ipChange.ipc$dispatch("-182627368", new Object[]{this, context, Integer.valueOf(i), obj, view});
        } else if (view instanceof FrameLayout) {
            FrameLayout frameLayout = (FrameLayout) view;
            if (frameLayout.getChildCount() > 1) {
                ImageView imageView = (ImageView) frameLayout.getChildAt(0);
                String str = (String) obj;
                if ("default_banner0".equals(str)) {
                    imageView.setImageResource(R$drawable.default_banner0);
                } else if ("default_banner1".equals(str)) {
                    imageView.setImageResource(R$drawable.default_banner1);
                } else if ("default_banner2".equals(str)) {
                    imageView.setImageResource(R$drawable.default_banner2);
                } else {
                    cn.damai.common.image.a.b().c(str).e(new b(this, imageView)).n(new a(this, imageView)).f();
                }
            }
        }
    }
}
