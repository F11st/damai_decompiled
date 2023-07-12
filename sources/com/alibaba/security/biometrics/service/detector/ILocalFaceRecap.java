package com.alibaba.security.biometrics.service.detector;

import android.content.Context;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public interface ILocalFaceRecap<T> {
    float[] calcSimilarScore(T t, T t2);

    float getRecapResult();

    void inference(byte[] bArr, int i, int i2, int i3);

    void prepare(Context context, OnLocalRecapPreparedListener onLocalRecapPreparedListener);

    void release();
}
