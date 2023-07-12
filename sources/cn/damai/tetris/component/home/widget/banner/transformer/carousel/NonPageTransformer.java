package cn.damai.tetris.component.home.widget.banner.transformer.carousel;

import android.view.View;
import androidx.viewpager.widget.ViewPager;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class NonPageTransformer implements ViewPager.PageTransformer {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final ViewPager.PageTransformer INSTANCE = new cn.damai.uikit.banner.transformer.carousel.NonPageTransformer();

    @Override // androidx.viewpager.widget.ViewPager.PageTransformer
    public void transformPage(View view, float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1641242829")) {
            ipChange.ipc$dispatch("1641242829", new Object[]{this, view, Float.valueOf(f)});
        } else {
            view.setScaleX(0.999f);
        }
    }
}
