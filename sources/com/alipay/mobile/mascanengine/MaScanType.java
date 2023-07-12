package com.alipay.mobile.mascanengine;

import com.alipay.ma.common.result.ResultMaType;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public enum MaScanType {
    PRODUCT,
    MEDICINE,
    EXPRESS,
    QR,
    TB_ANTI_FAKE,
    ARCODE,
    DM,
    PDF417,
    NARROW,
    HMCODE;

    public static MaScanType getType(ResultMaType resultMaType) {
        return valueOf(resultMaType.toString());
    }
}
