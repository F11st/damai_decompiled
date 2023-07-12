package com.autonavi.amap.mapcore;

import android.content.Context;
import com.amap.api.mapcore.util.hn;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class MsgProcessor {
    private static hn mDelegate = new hn();

    public static native int nativeInit(Context context);

    public static void nativeInitInfo(Context context, boolean z, String str, String str2, String str3, String[] strArr) {
        mDelegate.a(context, z, str, str2, str3, strArr);
        nativeInit(context);
    }

    public static void nativeMsgProcessor(String str, String str2) {
        mDelegate.a(str, str2);
    }
}
