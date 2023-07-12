package cn.damai.commonbusiness.seatbiz.view.svgview.core.helper.parser.model;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class SVGOval extends Shape {
    private static transient /* synthetic */ IpChange $ipChange;
    public float centerX;
    public float centerY;
    public float radiusX;
    public float radiusY;
    public RectF rect;

    @Override // cn.damai.commonbusiness.seatbiz.view.svgview.core.helper.parser.model.Shape
    protected void drawSelf(Canvas canvas) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1123186719")) {
            ipChange.ipc$dispatch("-1123186719", new Object[]{this, canvas});
            return;
        }
        Paint paint = this.fillPaint;
        if (paint != null) {
            canvas.drawOval(this.rect, paint);
        }
        Paint paint2 = this.strokePaint;
        if (paint2 != null) {
            canvas.drawOval(this.rect, paint2);
        }
    }
}
