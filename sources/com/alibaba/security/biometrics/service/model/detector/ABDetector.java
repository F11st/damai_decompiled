package com.alibaba.security.biometrics.service.model.detector;

import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import com.alibaba.security.biometrics.service.model.params.ALBiometricsParams;
import com.alibaba.security.biometrics.service.state.ABDetectListener;
import java.util.ArrayList;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public abstract class ABDetector {
    public static final int ALGORITHM_ALI = 3;
    public static final int ALGORITHM_HISIGN = 1;
    public static final int ALGORITHM_MEGVII = 2;
    protected ABDetectListener mDetectEventListener;

    public abstract void changeDetectType(ABDetectType aBDetectType, boolean z);

    public abstract boolean doDetect(byte[] bArr, int i, int i2, int i3);

    public abstract Bundle doDetectContinue(byte[] bArr, int i, int i2, int i3);

    public abstract ABDetectType getCurrentDetectType();

    public abstract byte[] getGlobalImage();

    public abstract Rect getImageFaceSize();

    public abstract byte[] getLocalImage();

    public abstract String getLog();

    public abstract byte[] getOriginImage();

    public abstract float[] getOriginImageLandmarks();

    public abstract byte[] getQualityImage();

    public abstract float[] getQualityImageLandmarks();

    public abstract ArrayList<ABFaceFrame> getValidFrames();

    public abstract String getVersion();

    public abstract boolean init(Context context, ALBiometricsParams aLBiometricsParams);

    public abstract boolean isEnable();

    public abstract void release();

    public abstract void reset(boolean z);

    public void setDetectEventListener(ABDetectListener aBDetectListener) {
        this.mDetectEventListener = aBDetectListener;
    }

    public abstract void startReflectDetect(int i);
}
