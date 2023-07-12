package cn.damai.tetris.component.home.widget.banner.transformer;

import android.view.View;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class ZoomOutTranformer extends cn.damai.uikit.banner.transformer.ABaseTransformer {
    private static transient /* synthetic */ IpChange $ipChange;

    @Override // cn.damai.uikit.banner.transformer.ABaseTransformer
    protected void f(View view, float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "215340112")) {
            ipChange.ipc$dispatch("215340112", new Object[]{this, view, Float.valueOf(f)});
            return;
        }
        float abs = Math.abs(f) + 1.0f;
        view.setScaleX(abs);
        view.setScaleY(abs);
        view.setPivotX(view.getWidth() * 0.5f);
        view.setPivotY(view.getHeight() * 0.5f);
        view.setAlpha((f < -1.0f || f > 1.0f) ? 0.0f : 1.0f - (abs - 1.0f));
        if (f == -1.0f) {
            view.setTranslationX(view.getWidth() * (-1));
        }
    }
}
