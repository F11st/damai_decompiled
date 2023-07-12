package cn.damai.commonbusiness.dynamicx.customwidget.dashview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.t60;

/* compiled from: Taobao */
/* loaded from: classes14.dex */
public class DMDXDashView extends View {
    private static transient /* synthetic */ IpChange $ipChange;
    private int dashColor;
    private int dashGap;
    private int dashWidth;

    public DMDXDashView(Context context) {
        super(context);
        this.dashColor = Color.parseColor("#EEEEEE");
        this.dashWidth = t60.a(getContext(), 3.0f);
        this.dashGap = t60.a(getContext(), 2.0f);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1858605804")) {
            ipChange.ipc$dispatch("1858605804", new Object[]{this, canvas});
            return;
        }
        Paint paint = new Paint(1);
        paint.setColor(this.dashColor);
        paint.setStrokeWidth(getHeight());
        paint.setPathEffect(new DashPathEffect(new float[]{this.dashWidth, this.dashGap}, 0.0f));
        float height = getHeight() / 2;
        canvas.drawLine(0.0f, height, getWidth(), height, paint);
    }

    public void setParams(int i, int i2, int i3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "934676509")) {
            ipChange.ipc$dispatch("934676509", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
            return;
        }
        this.dashColor = i;
        this.dashWidth = i2;
        this.dashGap = i3;
        invalidate();
    }

    public DMDXDashView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dashColor = Color.parseColor("#EEEEEE");
        this.dashWidth = t60.a(getContext(), 3.0f);
        this.dashGap = t60.a(getContext(), 2.0f);
    }
}
