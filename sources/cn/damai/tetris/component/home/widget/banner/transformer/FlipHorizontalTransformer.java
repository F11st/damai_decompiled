package cn.damai.tetris.component.home.widget.banner.transformer;

import android.view.View;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class FlipHorizontalTransformer extends cn.damai.uikit.banner.transformer.ABaseTransformer {
    private static transient /* synthetic */ IpChange $ipChange;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.damai.uikit.banner.transformer.ABaseTransformer
    public void d(View view, float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1835053313")) {
            ipChange.ipc$dispatch("-1835053313", new Object[]{this, view, Float.valueOf(f)});
            return;
        }
        super.d(view, f);
        if (f > -0.5f && f < 0.5f) {
            view.setVisibility(0);
        } else {
            view.setVisibility(4);
        }
    }

    @Override // cn.damai.uikit.banner.transformer.ABaseTransformer
    protected void f(View view, float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-579471809")) {
            ipChange.ipc$dispatch("-579471809", new Object[]{this, view, Float.valueOf(f)});
            return;
        }
        float f2 = f * 180.0f;
        view.setAlpha((f2 > 90.0f || f2 < -90.0f) ? 0.0f : 1.0f);
        view.setPivotX(view.getWidth() * 0.5f);
        view.setPivotY(view.getHeight() * 0.5f);
        view.setRotationY(f2);
    }
}
