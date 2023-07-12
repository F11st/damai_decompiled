package com.alipay.mobile.binarize;

import android.os.Build;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class BinarizeUtils {
    public static final String KEY_ENABLE_RS_BINARIZE = "enableRsBinarize";

    public static boolean supportRsBinarize() {
        return Build.VERSION.SDK_INT >= 24;
    }
}
