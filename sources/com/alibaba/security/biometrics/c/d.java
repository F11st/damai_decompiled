package com.alibaba.security.biometrics.c;

import android.graphics.Color;
import android.text.TextUtils;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public final class d {
    public static int a(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return i;
        }
        try {
            return Color.parseColor(str);
        } catch (Exception unused) {
            return i;
        }
    }
}
