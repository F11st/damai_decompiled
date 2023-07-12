package com.youku.live.dago.widgetlib.ailproom.favor;

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
        if (AndroidInstantRuntime.support(ipChange, "-1033462981")) {
            return (PointF) ipChange.ipc$dispatch("-1033462981", new Object[]{this, Float.valueOf(f), pointF, pointF2});
        }
        float f2 = 1.0f - f;
        PointF pointF3 = new PointF();
        float f3 = f2 * f2 * f2;
        float f4 = 6.0f * f2;
        PointF pointF4 = this.pointF1;
        float f5 = (pointF.x * f3) + (f4 * f2 * f * pointF4.x);
        PointF pointF5 = this.pointF2;
        float f6 = f5 + (f4 * f * f * pointF5.x);
        float f7 = f * f * f;
        pointF3.x = f6 + (pointF2.x * f7);
        float f8 = f3 * pointF.y;
        float f9 = 3.0f * f2;
        pointF3.y = f8 + (f2 * f9 * f * pointF4.y) + (f9 * f * f * pointF5.y) + (f7 * pointF2.y);
        return pointF3;
    }

    public BezierEvaluator(PointF pointF) {
        this.point1 = pointF;
    }
}
