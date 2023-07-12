package com.alipay.mobile.mascanengine;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public interface IOnMaSDKDecodeInfo {
    void onGetAvgGray(int i);

    void onGetMaProportion(float f);

    void onGetMaProportionAndSource(float f, int i);

    void onGetRecognizeStage(int i);

    void onGetWhetherFrameBlur(float f, float f2, boolean z);

    void onGetWhetherFrameBlurSVM(boolean z, long j, long j2);
}
