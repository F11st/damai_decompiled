package com.alibaba.security.realidentity;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public abstract class RPEventListener {
    public void onBiometricsFinish(int i) {
    }

    public void onBiometricsStart() {
    }

    public void onFinish(RPResult rPResult, RPDetail rPDetail) {
        onFinish(rPResult, rPDetail.getCode(), rPDetail.getMsg());
    }

    @Deprecated
    public void onFinish(RPResult rPResult, String str, String str2) {
    }

    public void onStart() {
    }
}
