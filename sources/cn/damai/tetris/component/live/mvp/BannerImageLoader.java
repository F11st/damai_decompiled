package cn.damai.tetris.component.live.mvp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import cn.damai.commonbusiness.R$drawable;
import cn.damai.commonbusiness.R$id;
import cn.damai.commonbusiness.R$layout;
import cn.damai.uikit.banner.loader.ViewLoader;
import cn.damai.uikit.image.a;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class BannerImageLoader extends ViewLoader {
    private static transient /* synthetic */ IpChange $ipChange;

    @Override // cn.damai.uikit.banner.loader.ViewLoader, cn.damai.uikit.banner.loader.ImageLoaderInterface
    public View createImageView(Context context) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-116857987") ? (View) ipChange.ipc$dispatch("-116857987", new Object[]{this, context}) : LayoutInflater.from(context).inflate(R$layout.live_header_banner_item, (ViewGroup) null);
    }

    @Override // cn.damai.uikit.banner.loader.ImageLoaderInterface
    public void displayImage(Context context, Object obj, View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "262200526")) {
            ipChange.ipc$dispatch("262200526", new Object[]{this, context, obj, view});
            return;
        }
        int i = R$drawable.uikit_default_image_bg_gradient;
        a.a().loadinto((String) obj, (ImageView) view.findViewById(R$id.image_view), i, i);
    }
}
