package cn.damai.commonbusiness.seatbiz.view.svgview.core.helper.parser.model;

import android.graphics.Canvas;
import android.graphics.Paint;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class SVGLine extends Shape {
    private static transient /* synthetic */ IpChange $ipChange;
    public float endX;
    public float endY;
    public float startX;
    public float startY;

    @Override // cn.damai.commonbusiness.seatbiz.view.svgview.core.helper.parser.model.Shape
    protected void drawSelf(Canvas canvas) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1870012927")) {
            ipChange.ipc$dispatch("1870012927", new Object[]{this, canvas});
            return;
        }
        Paint paint = this.strokePaint;
        if (paint != null) {
            paint.setColor(this.strokeColor);
            canvas.drawLine(this.startX, this.startY, this.endX, this.endY, this.strokePaint);
        }
    }
}
