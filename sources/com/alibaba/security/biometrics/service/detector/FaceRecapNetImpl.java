package com.alibaba.security.biometrics.service.detector;

import android.content.Context;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class FaceRecapNetImpl implements ILocalFaceRecap<Object> {
    private static final String TAG = "AliNNRecapNet";

    @Override // com.alibaba.security.biometrics.service.detector.ILocalFaceRecap
    public float[] calcSimilarScore(Object obj, Object obj2) {
        return new float[0];
    }

    @Override // com.alibaba.security.biometrics.service.detector.ILocalFaceRecap
    public float getRecapResult() {
        return 0.0f;
    }

    @Override // com.alibaba.security.biometrics.service.detector.ILocalFaceRecap
    public void inference(byte[] bArr, int i, int i2, int i3) {
    }

    @Override // com.alibaba.security.biometrics.service.detector.ILocalFaceRecap
    public void prepare(Context context, OnLocalRecapPreparedListener onLocalRecapPreparedListener) {
        if (onLocalRecapPreparedListener != null) {
            onLocalRecapPreparedListener.onFailed(-1, new Throwable("do not need impl"));
        }
    }

    @Override // com.alibaba.security.biometrics.service.detector.ILocalFaceRecap
    public void release() {
    }
}
