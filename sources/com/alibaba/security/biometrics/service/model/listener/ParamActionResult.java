package com.alibaba.security.biometrics.service.model.listener;

import com.alibaba.security.biometrics.service.model.detector.ABDetectType;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class ParamActionResult {
    public int actionIndex;
    public int actionTotal;
    public ABDetectType detectType;

    public ParamActionResult(ABDetectType aBDetectType, int i, int i2) {
        this.detectType = aBDetectType;
        this.actionIndex = i;
        this.actionTotal = i2;
    }
}
