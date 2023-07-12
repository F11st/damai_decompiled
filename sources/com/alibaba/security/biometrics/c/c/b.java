package com.alibaba.security.biometrics.c.c;

import android.content.Context;
import com.youku.arch.v3.data.Constants;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public final class b {
    public static int a(Context context) {
        int identifier = context.getResources().getIdentifier("status_bar_height", Constants.DIMEN, "android");
        if (identifier > 0) {
            return context.getResources().getDimensionPixelSize(identifier);
        }
        return 0;
    }
}
