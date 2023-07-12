package com.alibaba.security.biometrics.service.model.detector;

import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Bundle;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public abstract class ABFaceFrame {
    protected DetectInfo detectInfo;
    protected Bundle exts;

    public static PointF get2DPoint(float f, float f2, float f3, float f4, float f5, float f6) {
        PointF pointF = new PointF();
        pointF.x = ((f6 < 0.0f ? f6 / f3 : (-f6) / f4) * 0.5f) + 0.5f;
        pointF.y = ((f5 < 0.0f ? (-f5) / f : f5 / f2) * 0.5f) + 0.5f;
        return pointF;
    }

    public static boolean isValid2DPoint(PointF pointF) {
        float f = pointF.x;
        if (f < 0.0f || f > 1.0f) {
            return false;
        }
        float f2 = pointF.y;
        return f2 >= 0.0f && f2 <= 1.0f;
    }

    public abstract int facesDetected();

    public DetectInfo getDetectInfo() {
        return this.detectInfo;
    }

    public Bundle getExts() {
        return this.exts;
    }

    public abstract RectF getFacePos();

    public abstract float getFaceQuality();

    public Rect getFaceSize() {
        return getDetectInfo().getFaceSize();
    }

    public abstract int getImageAngle();

    public abstract byte[] getImageData();

    public abstract int getImageHeight();

    public abstract int getImageWidth();

    public abstract float getIso();

    public boolean hasFace() {
        return facesDetected() > 0 && getDetectInfo() != null;
    }

    public void setDetectInfo(DetectInfo detectInfo) {
        this.detectInfo = detectInfo;
    }

    public void setExts(Bundle bundle) {
        this.exts = bundle;
    }

    public PointF get2DPoint(float f, float f2, float f3, float f4) {
        if (facesDetected() <= 0) {
            return null;
        }
        return get2DPoint(f, f2, f3, f4, this.detectInfo.getSmoothPitch(), this.detectInfo.getSmoothYaw());
    }

    public PointF get2DPoint() {
        return get2DPoint(-0.17f, 0.17f, -0.22f, 0.22f);
    }
}
