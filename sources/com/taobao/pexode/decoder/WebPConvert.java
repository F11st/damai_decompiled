package com.taobao.pexode.decoder;

import androidx.annotation.Keep;
import com.taobao.pexode.Pexode;
import tb.hh0;

/* compiled from: Taobao */
@Keep
/* loaded from: classes11.dex */
public class WebPConvert {
    public static boolean sIsSoInstalled;

    static {
        try {
            System.loadLibrary("dwebp");
            sIsSoInstalled = true;
            hh0.f(Pexode.TAG, "system load lib%s.so result=%b", "WebPConvert", true);
        } catch (UnsatisfiedLinkError e) {
            hh0.c(Pexode.TAG, "system load lib%s.so error=%s", "WebPConvert", e);
        }
    }

    public static native int nativeProcess(byte[] bArr, String str);

    public static native void nativeUseBugFix(boolean z);
}
