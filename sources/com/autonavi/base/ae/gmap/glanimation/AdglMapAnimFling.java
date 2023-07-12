package com.autonavi.base.ae.gmap.glanimation;

import android.os.SystemClock;
import com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.base.ae.gmap.GLMapState;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class AdglMapAnimFling extends AbstractAdglAnimation {
    private IPoint fromCenter;
    private boolean hasCheckParams;
    private int lastMoveX;
    private int lastMoveY;
    private AbstractAdglAnimationParam2V moveParam = null;
    private boolean needMove;
    private int screenCenterX;
    private int screenCenterY;
    private float velocityX;
    private float velocityY;

    public AdglMapAnimFling(int i, int i2, int i3) {
        this.screenCenterX = i2;
        this.screenCenterY = i3;
        this.lastMoveX = i2;
        this.lastMoveY = i3;
        reset();
        this.duration = i;
    }

    public void commitAnimation(Object obj) {
        GLMapState gLMapState = (GLMapState) obj;
        if (gLMapState == null) {
            return;
        }
        this.hasCheckParams = false;
        this.isOver = true;
        float f = this.velocityX;
        int i = this.duration;
        int i2 = (int) ((f * i) / 2000.0f);
        int i3 = (int) ((this.velocityY * i) / 2000.0f);
        if (Math.abs(i2) != 0 && Math.abs(i3) != 0) {
            if (this.fromCenter == null) {
                this.fromCenter = IPoint.obtain();
            }
            gLMapState.getMapGeoCenter(this.fromCenter);
            this.isOver = false;
            this.moveParam.setFromValue(this.screenCenterX, this.screenCenterY);
            this.moveParam.setToValue(this.screenCenterX - i2, this.screenCenterY - i3);
            this.needMove = this.moveParam.needToCaculate();
        }
        this.hasCheckParams = true;
        this.startTime = SystemClock.uptimeMillis();
    }

    public void commitAnimationold(Object obj) {
        GLMapState gLMapState = (GLMapState) obj;
        if (gLMapState == null) {
            return;
        }
        this.hasCheckParams = false;
        this.isOver = true;
        float f = this.velocityX;
        float f2 = this.velocityY;
        float sqrt = ((float) Math.sqrt((f * f) + (f2 * f2))) / 1000.0f;
        if (sqrt >= 0.1f) {
            float f3 = sqrt * 0.02f;
            if (this.fromCenter == null) {
                this.fromCenter = IPoint.obtain();
            }
            gLMapState.getMapGeoCenter(this.fromCenter);
            this.isOver = false;
            this.moveParam.setFromValue(this.screenCenterX, this.screenCenterY);
            this.moveParam.setToValue(this.screenCenterX - (this.velocityX * f3), this.screenCenterY - (this.velocityY * f3));
            this.needMove = this.moveParam.needToCaculate();
        }
        this.hasCheckParams = true;
        this.startTime = SystemClock.uptimeMillis();
    }

    @Override // com.autonavi.base.ae.gmap.glanimation.AbstractAdglAnimation
    public void doAnimation(Object obj) {
        GLMapState gLMapState = (GLMapState) obj;
        if (gLMapState == null) {
            return;
        }
        if (!this.hasCheckParams) {
            commitAnimation(obj);
        }
        if (this.isOver) {
            return;
        }
        long uptimeMillis = SystemClock.uptimeMillis() - this.startTime;
        this.offsetTime = uptimeMillis;
        float f = ((float) uptimeMillis) / this.duration;
        if (f > 1.0f) {
            this.isOver = true;
            f = 1.0f;
        }
        if (f < 0.0f || f > 1.0f || !this.needMove) {
            return;
        }
        this.moveParam.setNormalizedTime(f);
        int curXValue = (int) this.moveParam.getCurXValue();
        int curYValue = (int) this.moveParam.getCurYValue();
        IPoint obtain = IPoint.obtain();
        gLMapState.screenToP20Point((this.screenCenterX + curXValue) - this.lastMoveX, (this.screenCenterY + curYValue) - this.lastMoveY, obtain);
        gLMapState.setMapGeoCenter(Point.getx(obtain), Point.gety(obtain));
        this.lastMoveX = curXValue;
        this.lastMoveY = curYValue;
        obtain.recycle();
    }

    public void reset() {
        AbstractAdglAnimationParam2V abstractAdglAnimationParam2V = this.moveParam;
        if (abstractAdglAnimationParam2V != null) {
            abstractAdglAnimationParam2V.reset();
        }
        this.velocityX = 0.0f;
        this.velocityY = 0.0f;
        this.needMove = false;
        this.hasCheckParams = false;
    }

    public void setPositionAndVelocity(float f, float f2) {
        this.moveParam = null;
        this.velocityX = f;
        this.velocityY = f2;
        AbstractAdglAnimationParam2V abstractAdglAnimationParam2V = new AbstractAdglAnimationParam2V();
        this.moveParam = abstractAdglAnimationParam2V;
        abstractAdglAnimationParam2V.setInterpolatorType(2, 1.2f);
        this.needMove = false;
        this.hasCheckParams = false;
    }
}
