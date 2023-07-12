package com.alibaba.security.biometrics.c.c;

import android.content.Context;
import com.youku.arch.v3.data.Constants;

/* compiled from: Taobao */
/* renamed from: com.alibaba.security.biometrics.c.c.b */
/* loaded from: classes8.dex */
public final class C3755b {
    public static int a(Context context) {
        int identifier = context.getResources().getIdentifier("status_bar_height", Constants.DIMEN, "android");
        if (identifier > 0) {
            return context.getResources().getDimensionPixelSize(identifier);
        }
        return 0;
    }
}
