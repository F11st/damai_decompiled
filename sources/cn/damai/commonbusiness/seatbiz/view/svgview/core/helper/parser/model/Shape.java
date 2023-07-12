package cn.damai.commonbusiness.seatbiz.view.svgview.core.helper.parser.model;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import cn.damai.commonbusiness.seatbiz.view.svgview.core.model.PointLocation;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class Shape {
    private static transient /* synthetic */ IpChange $ipChange;
    public int fillColor;
    public Paint fillPaint;
    public String floorId;
    public List<PointLocation> locationList;
    public String rowId;
    public int strokeColor;
    public Paint strokePaint;
    public Path transformBound;
    public Matrix transformMatrix;

    private void setColor(Paint paint, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "472673168")) {
            ipChange.ipc$dispatch("472673168", new Object[]{this, paint, Integer.valueOf(i)});
        } else if (paint != null) {
            paint.setColor(i);
        }
    }

    public void draw(Canvas canvas, int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1155302122")) {
            ipChange.ipc$dispatch("1155302122", new Object[]{this, canvas, Integer.valueOf(i), Integer.valueOf(i2)});
        } else if (canvas == null) {
        } else {
            try {
                if (this.transformMatrix != null) {
                    canvas.save();
                    canvas.concat(this.transformMatrix);
                }
                setColor(this.fillPaint, i);
                setColor(this.strokePaint, i2);
                drawSelf(canvas);
                if (this.transformMatrix != null) {
                    canvas.restore();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    protected void drawSelf(Canvas canvas) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1337910922")) {
            ipChange.ipc$dispatch("-1337910922", new Object[]{this, canvas});
        }
    }
}
