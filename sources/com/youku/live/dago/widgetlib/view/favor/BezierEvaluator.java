package com.youku.live.dago.widgetlib.view.favor;

import android.animation.TypeEvaluator;
import android.graphics.PointF;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class BezierEvaluator implements TypeEvaluator<PointF> {
    private static transient /* synthetic */ IpChange $ipChange;
    private PointF point1;
    private PointF pointF1;
    private PointF pointF2;

    public BezierEvaluator(PointF pointF, PointF pointF2) {
        this.pointF1 = pointF;
        this.pointF2 = pointF2;
    }

    @Override // android.animation.TypeEvaluator
    public PointF evaluate(float f, PointF pointF, PointF pointF2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "299716829")) {
            return (PointF) ipChange.ipc$dispatch("299716829", new Object[]{this, Float.valueOf(f), pointF, pointF2});
        }
        float f2 = 1.0f - f;
        PointF pointF3 = new PointF();
        float f3 = f2 * f2 * f2;
        float f4 = 3.0f * f2;
        float f5 = f2 * f4 * f;
        PointF pointF4 = this.pointF1;
        float f6 = (pointF.x * f3) + (pointF4.x * f5);
        float f7 = f4 * f * f;
        PointF pointF5 = this.pointF2;
        float f8 = f * f * f;
        pointF3.x = f6 + (pointF5.x * f7) + (pointF2.x * f8);
        pointF3.y = (f3 * pointF.y) + (f5 * pointF4.y) + (f7 * pointF5.y) + (f8 * pointF2.y);
        return pointF3;
    }

    public BezierEvaluator(PointF pointF) {
        this.point1 = pointF;
    }
}
