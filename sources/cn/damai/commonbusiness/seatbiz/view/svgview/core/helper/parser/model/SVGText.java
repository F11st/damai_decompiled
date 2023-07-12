package cn.damai.commonbusiness.seatbiz.view.svgview.core.helper.parser.model;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextUtils;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class SVGText extends Shape {
    private static transient /* synthetic */ IpChange $ipChange;
    public String content = "";
    public float textSize;
    public float x;
    public float y;

    @Override // cn.damai.commonbusiness.seatbiz.view.svgview.core.helper.parser.model.Shape
    protected void drawSelf(Canvas canvas) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "351243942")) {
            ipChange.ipc$dispatch("351243942", new Object[]{this, canvas});
        } else if (TextUtils.isEmpty(this.content)) {
        } else {
            Paint paint = this.fillPaint;
            if (paint != null) {
                paint.setColor(this.fillColor);
                if (this.strokePaint != null) {
                    this.fillPaint.setStyle(Paint.Style.FILL_AND_STROKE);
                }
                this.fillPaint.setTextSize(this.textSize);
                canvas.drawText(this.content, this.x, this.y, this.fillPaint);
                return;
            }
            Paint paint2 = this.strokePaint;
            if (paint2 != null) {
                paint2.setColor(this.strokeColor);
                this.strokePaint.setTextSize(this.textSize);
                canvas.drawText(this.content, this.x, this.y, this.strokePaint);
            }
        }
    }
}
