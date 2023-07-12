package cn.damai.uikit.magicindicator;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class GradientIndicator extends LinePagerIndicatorEx {
    private static transient /* synthetic */ IpChange $ipChange;

    public GradientIndicator(Context context) {
        super(context);
    }

    @Override // cn.damai.uikit.magicindicator.LinePagerIndicatorEx, android.view.View
    protected void onDraw(Canvas canvas) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "632110769")) {
            ipChange.ipc$dispatch("632110769", new Object[]{this, canvas});
            return;
        }
        getPaint().setShader(new LinearGradient(getLineRect().left, getLineRect().top, getLineRect().right, getLineRect().bottom, new int[]{Color.parseColor("#FFA4A4"), Color.parseColor("#FF2373")}, (float[]) null, Shader.TileMode.CLAMP));
        canvas.drawRoundRect(getLineRect(), getRoundRadius(), getRoundRadius(), getPaint());
    }
}
