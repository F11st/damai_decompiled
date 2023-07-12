package cn.damai.tetris.component.home.widget.banner.transformer;

import android.view.View;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class Alpha2Transformer extends cn.damai.uikit.banner.transformer.BasePageTransformer {
    private static transient /* synthetic */ IpChange $ipChange;
    private float a = 1.0f;

    @Override // cn.damai.uikit.banner.transformer.BasePageTransformer
    public void a(View view, float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "622714431")) {
            ipChange.ipc$dispatch("622714431", new Object[]{this, view, Float.valueOf(f)});
        }
    }

    @Override // cn.damai.uikit.banner.transformer.BasePageTransformer
    public void b(View view, float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-686377027")) {
            ipChange.ipc$dispatch("-686377027", new Object[]{this, view, Float.valueOf(f)});
            return;
        }
        view.setPivotX(view.getMeasuredWidth() * 0.5f);
        view.setPivotY(view.getMeasuredHeight() * 0.5f);
        float abs = Math.abs(f);
        float f2 = this.a;
        if (abs < f2) {
            view.setAlpha(1.0f - Math.abs(f));
        } else {
            view.setAlpha(f2);
        }
    }

    @Override // cn.damai.uikit.banner.transformer.BasePageTransformer
    public void c(View view, float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1522421542")) {
            ipChange.ipc$dispatch("1522421542", new Object[]{this, view, Float.valueOf(f)});
            return;
        }
        view.setPivotX(view.getMeasuredWidth() * 0.5f);
        view.setPivotY(view.getMeasuredHeight() * 0.5f);
        view.setAlpha(1.0f - f);
    }
}
