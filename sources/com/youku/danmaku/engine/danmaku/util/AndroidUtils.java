package com.youku.danmaku.engine.danmaku.util;

import android.app.ActivityManager;
import android.content.Context;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class AndroidUtils {
    public static int getMemoryClass(Context context) {
        return ((ActivityManager) context.getSystemService("activity")).getMemoryClass();
    }
}
