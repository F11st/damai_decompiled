package com.youku.live.dago.widgetlib.ailproom.adapter.likeview;

import android.animation.TypeEvaluator;
import android.graphics.PointF;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class PointFTypeEvaluator implements TypeEvaluator<PointF> {
    private static transient /* synthetic */ IpChange $ipChange;
    PointF control;
    PointF mPointF = new PointF();

    public PointFTypeEvaluator(PointF pointF) {
        this.control = pointF;
    }

    private PointF getBezierPoint(PointF pointF, PointF pointF2, PointF pointF3, float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1327859549")) {
            return (PointF) ipChange.ipc$dispatch("1327859549", new Object[]{this, pointF, pointF2, pointF3, Float.valueOf(f)});
        }
        PointF pointF4 = this.mPointF;
        float f2 = 1.0f - f;
        float f3 = f2 * f2;
        float f4 = 2.0f * f * f2;
        float f5 = f * f;
        pointF4.x = (pointF.x * f3) + (pointF3.x * f4) + (pointF2.x * f5);
        pointF4.y = (f3 * pointF.y) + (f4 * pointF3.y) + (f5 * pointF2.y);
        return pointF4;
    }

    @Override // android.animation.TypeEvaluator
    public PointF evaluate(float f, PointF pointF, PointF pointF2) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1127331480") ? (PointF) ipChange.ipc$dispatch("-1127331480", new Object[]{this, Float.valueOf(f), pointF, pointF2}) : getBezierPoint(pointF, pointF2, this.control, f);
    }
}
