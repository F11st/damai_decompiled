package cn.damai.category.category.utils;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import cn.damai.common.image.DMImageCreator;
import cn.damai.homepage.R$drawable;
import cn.damai.homepage.R$layout;
import cn.damai.uikit.R$id;
import cn.damai.uikit.banner.loader.ViewLoader;
import cn.damai.uikit.view.RoundImageView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class BannerImageLoader extends ViewLoader {
    private static transient /* synthetic */ IpChange $ipChange;

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public class a implements DMImageCreator.DMImageSuccListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ RoundImageView a;

        a(BannerImageLoader bannerImageLoader, RoundImageView roundImageView) {
            this.a = roundImageView;
        }

        @Override // cn.damai.common.image.DMImageCreator.DMImageSuccListener
        public void onSuccess(DMImageCreator.e eVar) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "556946178")) {
                ipChange.ipc$dispatch("556946178", new Object[]{this, eVar});
            } else {
                this.a.setImageDrawable(eVar.a);
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public class b implements DMImageCreator.DMImageFailListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ RoundImageView a;

        b(BannerImageLoader bannerImageLoader, RoundImageView roundImageView) {
            this.a = roundImageView;
        }

        @Override // cn.damai.common.image.DMImageCreator.DMImageFailListener
        public void onFail(DMImageCreator.d dVar) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "50755631")) {
                ipChange.ipc$dispatch("50755631", new Object[]{this, dVar});
            } else {
                this.a.setImageResource(R$drawable.uikit_default_image_bg_grey);
            }
        }
    }

    @Override // cn.damai.uikit.banner.loader.ViewLoader, cn.damai.uikit.banner.loader.ImageLoaderInterface
    public View createImageView(Context context) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1977890494") ? (View) ipChange.ipc$dispatch("-1977890494", new Object[]{this, context}) : LayoutInflater.from(context).inflate(R$layout.category_video_item, (ViewGroup) null);
    }

    @Override // cn.damai.uikit.banner.loader.ImageLoaderInterface
    public void displayImage(Context context, Object obj, View view) {
        boolean z;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1124178067")) {
            ipChange.ipc$dispatch("1124178067", new Object[]{this, context, obj, view});
            return;
        }
        try {
            z = ((Boolean) view.getTag(R$id.bannervideo)).booleanValue();
        } catch (Exception unused) {
            z = false;
        }
        RoundImageView roundImageView = (RoundImageView) view.findViewById(cn.damai.homepage.R$id.image_video);
        ImageView imageView = (ImageView) view.findViewById(cn.damai.homepage.R$id.icon_video);
        cn.damai.common.image.a.b().e((String) obj).i(R$drawable.uikit_default_image_bg_grey).e(new b(this, roundImageView)).n(new a(this, roundImageView)).f();
        if (z) {
            imageView.setVisibility(0);
        } else {
            imageView.setVisibility(8);
        }
    }
}
