package com.taobao.pexode.common;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import android.text.TextUtils;
import com.taobao.pexode.Pexode;
import java.io.FileDescriptor;
import tb.hh0;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class NdkCore {
    private static boolean a;
    private static String[] b;

    static {
        try {
            System.loadLibrary("pexcore");
            a = nativeLoadedVersionTest() == 2;
            hh0.f(Pexode.TAG, "system load lib%s.so success", "pexcore");
        } catch (UnsatisfiedLinkError e) {
            hh0.c(Pexode.TAG, "system load lib%s.so error=%s", "pexcore", e);
        }
    }

    public static boolean a(String str) {
        if (b == null) {
            try {
                if (Build.VERSION.SDK_INT >= 21) {
                    String nativeGetCpuAbiList = nativeGetCpuAbiList();
                    if (!TextUtils.isEmpty(nativeGetCpuAbiList)) {
                        b = nativeGetCpuAbiList.split(",");
                    }
                } else {
                    b = new String[]{nativeGetCpuAbi(com.alibaba.wireless.security.aopsdk.replace.android.os.Build.getCPU_ABI())};
                }
            } catch (UnsatisfiedLinkError e) {
                hh0.c(Pexode.TAG, "NdkCore.isCpuAbiSupported error=%s", e);
            }
            if (b == null) {
                if (Build.VERSION.SDK_INT >= 21) {
                    b = Build.SUPPORTED_ABIS;
                } else {
                    b = new String[]{com.alibaba.wireless.security.aopsdk.replace.android.os.Build.getCPU_ABI()};
                }
            }
        }
        for (String str2 : b) {
            if (str2.equals(str)) {
                return true;
            }
        }
        return false;
    }

    public static boolean b() {
        return a;
    }

    public static void c(Context context) {
        if (a) {
            return;
        }
        boolean z = C6829a.b("pexcore", 2) && nativeLoadedVersionTest() == 2;
        a = z;
        hh0.f(Pexode.TAG, "retry load lib%s.so result=%b", "pexcore", Boolean.valueOf(z));
    }

    private static native boolean nativeCpuSupportNEON();

    private static native String nativeGetCpuAbi(String str);

    private static native String nativeGetCpuAbiList();

    private static native boolean nativeIsSeekable(FileDescriptor fileDescriptor);

    private static native int nativeLoadedVersionTest();

    public static native void nativePinBitmap(Bitmap bitmap) throws RuntimeException;

    public static native void nativePinBitmapWithAddr(Bitmap bitmap, long[] jArr) throws Exception;

    public static native void nativeUnpinBitmap(Bitmap bitmap) throws RuntimeException;
}
