package cn.damai.ticklet.view;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.ImageView;
import cn.damai.uikit.banner.loader.ImageLoader;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class TickletImageLoader extends ImageLoader {
    private static transient /* synthetic */ IpChange $ipChange;

    @Override // cn.damai.uikit.banner.loader.ImageLoader, cn.damai.uikit.banner.loader.ImageLoaderInterface
    public ImageView createImageView(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1798397973")) {
            return (ImageView) ipChange.ipc$dispatch("-1798397973", new Object[]{this, context});
        }
        ImageView imageView = new ImageView(context);
        imageView.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        return imageView;
    }

    @Override // cn.damai.uikit.banner.loader.ImageLoaderInterface
    public void displayImage(Context context, Object obj, ImageView imageView) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1829567540")) {
            ipChange.ipc$dispatch("1829567540", new Object[]{this, context, obj, imageView});
        } else {
            imageView.setImageResource(((Integer) obj).intValue());
        }
    }
}
