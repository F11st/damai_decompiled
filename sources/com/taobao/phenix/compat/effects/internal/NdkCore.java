package com.taobao.phenix.compat.effects.internal;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import tb.hh0;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class NdkCore {
    private static boolean a;

    static {
        try {
            System.loadLibrary("EffectsCore");
            a = true;
            hh0.f("Effects4Phenix", "system load lib%s.so success", "EffectsCore");
        } catch (UnsatisfiedLinkError e) {
            hh0.c("Effects4Phenix", "system load lib%s.so error=%s", "EffectsCore", e);
        }
    }

    public static Bitmap a(@NonNull Bitmap bitmap, int i) {
        if (a && bitmap.getConfig() == Bitmap.Config.ARGB_8888) {
            try {
                if (nativeBlurBitmap(bitmap, bitmap.getWidth(), bitmap.getHeight(), i) == 0) {
                    return bitmap;
                }
            } catch (UnsatisfiedLinkError e) {
                hh0.f("Effects4Phenix", "native blur bitmap error=%s", e);
            }
        }
        return null;
    }

    private static native int nativeBlurBitmap(Bitmap bitmap, int i, int i2, int i3);
}
