package com.youku.live.dago.widgetlib.interactive.gift.view.floatingview.transition;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public abstract class BaseFloatingPathTransition implements FloatingPathTransition {
    private static transient /* synthetic */ IpChange $ipChange;
    private PathPosition mPathPosition;
    private float[] mPathPositionGetter;

    public float getEndPathPosition() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1331966106")) {
            return ((Float) ipChange.ipc$dispatch("1331966106", new Object[]{this})).floatValue();
        }
        if (getFloatingPath() != null) {
            return getFloatingPath().getPathMeasure().getLength();
        }
        return 0.0f;
    }

    public PathPosition getFloatingPosition(float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1479709176")) {
            return (PathPosition) ipChange.ipc$dispatch("-1479709176", new Object[]{this, Float.valueOf(f)});
        }
        if (this.mPathPosition == null) {
            this.mPathPosition = new PathPosition();
        }
        if (this.mPathPositionGetter == null) {
            this.mPathPositionGetter = new float[2];
        }
        if (getFloatingPath() != null) {
            getFloatingPath().getPathMeasure().getPosTan(f, this.mPathPositionGetter, null);
            PathPosition pathPosition = this.mPathPosition;
            float[] fArr = this.mPathPositionGetter;
            pathPosition.x = fArr[0];
            pathPosition.y = fArr[1];
        }
        return this.mPathPosition;
    }

    public float getStartPathPosition() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-42737997")) {
            return ((Float) ipChange.ipc$dispatch("-42737997", new Object[]{this})).floatValue();
        }
        return 0.0f;
    }
}
