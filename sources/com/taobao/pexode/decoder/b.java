package com.taobao.pexode.decoder;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import com.taobao.pexode.Pexode;
import com.taobao.pexode.PexodeOptions;
import com.taobao.pexode.common.DegradeEventListener;
import com.taobao.pexode.common.NdkCore;
import com.taobao.pexode.entity.RewindableStream;
import com.taobao.pexode.exception.PexodeException;
import java.io.IOException;
import java.lang.reflect.Field;
import tb.hh0;
import tb.n8;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public abstract class b implements Decoder {
    protected static Field sBitmapBufferField;

    /* JADX INFO: Access modifiers changed from: protected */
    public static long getPixelAddressFromBitmap(@NonNull Bitmap bitmap) {
        long[] jArr = {0};
        try {
            NdkCore.nativePinBitmapWithAddr(bitmap, jArr);
        } catch (Throwable th) {
            hh0.c(Pexode.TAG, "get Bitmap pixels address error=%s", th);
        }
        return jArr[0];
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static boolean invalidBitmap(Bitmap bitmap, PexodeOptions pexodeOptions, String str) {
        if (bitmap == null) {
            hh0.c(Pexode.TAG, "%s bitmap is null", str);
            return true;
        } else if (bitmap.getWidth() * bitmap.getHeight() < pexodeOptions.outWidth * pexodeOptions.outHeight) {
            hh0.c(Pexode.TAG, "%s bitmap space not large enough", str);
            return true;
        } else {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static Bitmap newBitmap(PexodeOptions pexodeOptions, boolean z) {
        if (z) {
            return n8.a().newBitmap(pexodeOptions.outWidth, pexodeOptions.outHeight, PexodeOptions.CONFIG);
        }
        return Bitmap.createBitmap(pexodeOptions.outWidth, pexodeOptions.outHeight, PexodeOptions.CONFIG);
    }

    protected abstract Bitmap decodeAshmem(RewindableStream rewindableStream, PexodeOptions pexodeOptions, DegradeEventListener degradeEventListener) throws PexodeException, IOException;

    protected abstract Bitmap decodeInBitmap(RewindableStream rewindableStream, PexodeOptions pexodeOptions, DegradeEventListener degradeEventListener) throws PexodeException, IOException;

    protected abstract Bitmap decodeNormal(RewindableStream rewindableStream, PexodeOptions pexodeOptions) throws PexodeException;

    protected synchronized boolean ensureBitmapBufferField() {
        if (sBitmapBufferField == null) {
            try {
                Field declaredField = Bitmap.class.getDeclaredField("mBuffer");
                sBitmapBufferField = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException e) {
                hh0.c(Pexode.TAG, "ensure Bitmap buffer field error=%s", e);
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public byte[] getPixelBufferFromBitmap(Bitmap bitmap) {
        try {
            if (ensureBitmapBufferField()) {
                return (byte[]) sBitmapBufferField.get(bitmap);
            }
            return null;
        } catch (Exception e) {
            hh0.c(Pexode.TAG, "get Bitmap buffer field error=%s", e);
            return null;
        }
    }
}
