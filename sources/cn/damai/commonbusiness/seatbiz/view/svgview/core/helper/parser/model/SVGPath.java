package cn.damai.commonbusiness.seatbiz.view.svgview.core.helper.parser.model;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class SVGPath extends Shape {
    private static transient /* synthetic */ IpChange $ipChange;
    public Path path;
    public RectF rect;

    @Override // cn.damai.commonbusiness.seatbiz.view.svgview.core.helper.parser.model.Shape
    protected void drawSelf(Canvas canvas) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "443353262")) {
            ipChange.ipc$dispatch("443353262", new Object[]{this, canvas});
            return;
        }
        Paint paint = this.fillPaint;
        if (paint != null) {
            canvas.drawPath(this.path, paint);
        }
        Paint paint2 = this.strokePaint;
        if (paint2 != null) {
            canvas.drawPath(this.path, paint2);
        }
    }
}
