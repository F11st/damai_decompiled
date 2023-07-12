package com.autonavi.base.ae.gmap.glanimation;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class AbstractAdglAnimationParam2V extends AbstractAdglAnimationParam {
    public double fromXValue;
    public double fromYValue;
    public double toXValue;
    public double toYValue;

    public AbstractAdglAnimationParam2V() {
        reset();
    }

    @Override // com.autonavi.base.ae.gmap.glanimation.AbstractAdglAnimationParam
    public void checkParam() {
        this.needToCaculate = false;
        if (this.hasFromValue && this.hasToValue) {
            double d = this.toXValue - this.fromXValue;
            double d2 = this.toYValue - this.fromYValue;
            if (Math.abs(d) > 1.0E-4d || Math.abs(d2) > 1.0E-4d) {
                this.needToCaculate = true;
            }
        }
        this.hasCheckedParam = true;
    }

    public double getCurXValue() {
        double d = this.fromXValue;
        return d + ((this.toXValue - d) * this.mult);
    }

    public double getCurYValue() {
        double d = this.fromYValue;
        return d + ((this.toYValue - d) * this.mult);
    }

    public double getFromXValue() {
        return this.fromXValue;
    }

    public double getFromYValue() {
        return this.fromYValue;
    }

    public double getToXValue() {
        return this.toXValue;
    }

    public double getToYValue() {
        return this.toYValue;
    }

    @Override // com.autonavi.base.ae.gmap.glanimation.AbstractAdglAnimationParam
    public void reset() {
        super.reset();
        this.fromXValue = 0.0d;
        this.toXValue = 0.0d;
        this.fromYValue = 0.0d;
        this.toYValue = 0.0d;
    }

    public void setFromValue(double d, double d2) {
        this.fromXValue = d;
        this.fromYValue = d2;
        this.hasFromValue = true;
        this.hasCheckedParam = false;
    }

    public void setToValue(double d, double d2) {
        this.toXValue = d;
        this.toYValue = d2;
        this.hasToValue = true;
        this.hasCheckedParam = false;
    }
}
