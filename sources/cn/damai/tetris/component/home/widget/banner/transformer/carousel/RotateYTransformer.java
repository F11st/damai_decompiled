package cn.damai.tetris.component.home.widget.banner.transformer.carousel;

import android.annotation.TargetApi;
import android.view.View;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class RotateYTransformer extends cn.damai.uikit.banner.transformer.carousel.BasePageTransformer {
    private static transient /* synthetic */ IpChange $ipChange;
    private float b = 35.0f;

    @Override // cn.damai.uikit.banner.transformer.carousel.BasePageTransformer
    @TargetApi(11)
    public void a(View view, float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "102596589")) {
            ipChange.ipc$dispatch("102596589", new Object[]{this, view, Float.valueOf(f)});
            return;
        }
        view.setPivotY(view.getHeight() / 2);
        if (f < -1.0f) {
            view.setRotationY(this.b * (-1.0f));
            view.setPivotX(view.getWidth());
        } else if (f <= 1.0f) {
            view.setRotationY(this.b * f);
            if (f < 0.0f) {
                view.setPivotX(view.getWidth() * (((-f) * 0.5f) + 0.5f));
                view.setPivotX(view.getWidth());
                return;
            }
            view.setPivotX(view.getWidth() * 0.5f * (1.0f - f));
            view.setPivotX(0.0f);
        } else {
            view.setRotationY(this.b * 1.0f);
            view.setPivotX(0.0f);
        }
    }
}
