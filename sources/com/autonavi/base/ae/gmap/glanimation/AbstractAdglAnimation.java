package com.autonavi.base.ae.gmap.glanimation;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public abstract class AbstractAdglAnimation {
    public static final int DEFAULT_DURATION = 250;
    public static final int INTERPOLATOR_ACCELERATE = 1;
    public static final int INTERPOLATOR_ACCELERATE_DECELERATE = 3;
    public static final int INTERPOLATOR_BOUNCE = 4;
    public static final int INTERPOLATOR_DECELERATE = 2;
    public static final int INTERPOLATOR_DOUBLE_RAISE = 6;
    public static final int INTERPOLATOR_LINEAR = 0;
    public static final int INTERPOLATOR_OVERSHOOT = 5;
    public static final int INVALIDE_VALUE = -9999;
    protected int duration = 300;
    protected boolean isOver = false;
    protected long startTime = -1;
    protected long offsetTime = 0;

    public abstract void doAnimation(Object obj);

    public boolean isOver() {
        return this.isOver;
    }

    public boolean isValid() {
        return true;
    }
}
