package cn.damai.uikit.banner.loader;

import android.content.Context;
import android.widget.ImageView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public abstract class ImageLoader implements ImageLoaderInterface<ImageView> {
    private static transient /* synthetic */ IpChange $ipChange;

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // cn.damai.uikit.banner.loader.ImageLoaderInterface
    public ImageView createImageView(Context context) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "529788236") ? (ImageView) ipChange.ipc$dispatch("529788236", new Object[]{this, context}) : new ImageView(context);
    }
}
