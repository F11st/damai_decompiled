package cn.damai.commonbusiness.seatbiz.view.svgview.core.helper.parser.model;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class SVGPolygon extends Shape {
    private static transient /* synthetic */ IpChange $ipChange;
    public boolean isPloygon;
    public Path path;
    public ArrayList<Float> points;
    public RectF rect;

    @Override // cn.damai.commonbusiness.seatbiz.view.svgview.core.helper.parser.model.Shape
    protected void drawSelf(Canvas canvas) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-10252661")) {
            ipChange.ipc$dispatch("-10252661", new Object[]{this, canvas});
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
