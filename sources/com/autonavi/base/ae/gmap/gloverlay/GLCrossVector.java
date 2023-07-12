package com.autonavi.base.ae.gmap.gloverlay;

import android.graphics.Rect;
import com.autonavi.ae.gmap.gloverlay.AVectorCrossAttr;
import com.autonavi.base.ae.gmap.gloverlay.GLOverlay;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class GLCrossVector extends GLOverlay {
    public GLCrossVector(int i, IAMapDelegate iAMapDelegate, int i2) {
        super(i, iAMapDelegate, i2);
        if (iAMapDelegate == null || iAMapDelegate.getGLMapEngine() == null) {
            return;
        }
        this.mNativeInstance = iAMapDelegate.getGLMapEngine().createOverlay(i, GLOverlay.EAMapOverlayTpye.AMAPOVERLAY_VECTOR.ordinal());
    }

    private static native void nativeAddVectorCar(long j, int i, int i2, int i3);

    private static native int nativeAddVectorData(long j, int[] iArr, byte[] bArr);

    private static native int nativeGetFBOTextureId(long j);

    private static native void nativeInitFBOTexture(long j, int i, int i2);

    private static native void nativeSetArrowResId(long j, boolean z, int i);

    private static native void nativeSetBackgroundResId(long j, int i);

    private static native void nativeSetCarResId(long j, int i);

    public void addVectorCar(int i, int i2, int i3) {
        nativeAddVectorCar(this.mNativeInstance, i, i2, i3);
    }

    public int addVectorItem(AVectorCrossAttr aVectorCrossAttr, byte[] bArr, int i) {
        if (aVectorCrossAttr == null || bArr == null || i == 0) {
            return -1;
        }
        Rect rect = aVectorCrossAttr.stAreaRect;
        return nativeAddVectorData(this.mNativeInstance, new int[]{rect.left, rect.top, rect.right, rect.bottom, aVectorCrossAttr.stAreaColor, aVectorCrossAttr.fArrowBorderWidth, aVectorCrossAttr.stArrowBorderColor, aVectorCrossAttr.fArrowLineWidth, aVectorCrossAttr.stArrowLineColor, aVectorCrossAttr.dayMode ? 1 : 0}, bArr);
    }

    public void addVectorRemainDis(int i) {
    }

    public int getFBOTextureId() {
        return nativeGetFBOTextureId(this.mNativeInstance);
    }

    public void initFBOTexture(int i, int i2) {
        nativeInitFBOTexture(this.mNativeInstance, i, i2);
    }

    public void setArrowResId(boolean z, int i) {
        nativeSetArrowResId(this.mNativeInstance, z, i);
    }

    public void setBackgroundResId(int i) {
        nativeSetBackgroundResId(this.mNativeInstance, i);
    }

    public void setCarResId(int i) {
        nativeSetCarResId(this.mNativeInstance, i);
    }

    public void setRoadResId(boolean z, int i) {
    }

    public void setSkyResId(boolean z, int i) {
    }
}
