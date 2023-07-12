package com.taobao.pexode.decoder;

import android.content.Context;
import android.graphics.Bitmap;
import com.taobao.pexode.Pexode;
import com.taobao.pexode.PexodeOptions;
import com.taobao.pexode.common.DegradeEventListener;
import com.taobao.pexode.entity.RewindableStream;
import com.taobao.pexode.exception.NotSupportedException;
import com.taobao.pexode.exception.PexodeException;
import com.taobao.pexode.mimetype.MimeType;
import java.io.IOException;
import tb.hh0;
import tb.n8;
import tb.or1;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class c implements Decoder {
    private static boolean a;

    static {
        String a2 = a();
        try {
            System.loadLibrary(a2);
            boolean z = GifImage.nativeLoadedVersionTest() == 2;
            a = z;
            hh0.f(Pexode.TAG, "system load lib%s.so result=%b", a2, Boolean.valueOf(z));
        } catch (UnsatisfiedLinkError e) {
            hh0.c(Pexode.TAG, "system load lib%s.so error=%s", a2, e);
        }
    }

    private static String a() {
        return "pexgif";
    }

    @Override // com.taobao.pexode.decoder.Decoder
    public boolean acceptInputType(int i, MimeType mimeType, boolean z) {
        return i != 3;
    }

    @Override // com.taobao.pexode.decoder.Decoder
    public boolean canDecodeIncrementally(MimeType mimeType) {
        return false;
    }

    @Override // com.taobao.pexode.decoder.Decoder
    public or1 decode(RewindableStream rewindableStream, PexodeOptions pexodeOptions, DegradeEventListener degradeEventListener) throws PexodeException, IOException {
        GifImage create;
        boolean z = true;
        if (pexodeOptions.justDecodeBounds) {
            pexodeOptions.outHeight = 1;
            pexodeOptions.outWidth = 1;
            return null;
        }
        int inputType = rewindableStream.getInputType();
        if (inputType == 1) {
            create = GifImage.create(rewindableStream.getBuffer(), rewindableStream.getBufferOffset(), rewindableStream.getBufferLength());
        } else if (inputType == 2) {
            create = GifImage.create(rewindableStream.getFD());
        } else {
            throw new NotSupportedException("Not support input type(" + rewindableStream.getInputType() + ") when GifImage creating!");
        }
        if (pexodeOptions.forceStaticIfAnimation && create != null) {
            GifFrame frame = create.getFrame(0);
            if (frame == null) {
                create.dispose();
                return null;
            }
            int width = frame.getWidth();
            int height = frame.getHeight();
            z = (!pexodeOptions.enableAshmem || com.taobao.pexode.a.f().b) ? false : false;
            Bitmap newBitmapWithPin = z ? n8.a().newBitmapWithPin(width, height, Bitmap.Config.ARGB_8888) : null;
            if (!z || (newBitmapWithPin == null && pexodeOptions.allowDegrade2NoAshmem)) {
                newBitmapWithPin = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
            }
            if (newBitmapWithPin != null) {
                frame.renderFrame(width, height, newBitmapWithPin);
            }
            frame.dispose();
            create.dispose();
            return or1.a(newBitmapWithPin);
        }
        return or1.b(create);
    }

    @Override // com.taobao.pexode.decoder.Decoder
    public MimeType detectMimeType(byte[] bArr) {
        if (a) {
            MimeType mimeType = com.taobao.pexode.mimetype.a.GIF;
            if (mimeType.f(bArr)) {
                return mimeType;
            }
            return null;
        }
        return null;
    }

    @Override // com.taobao.pexode.decoder.Decoder
    public boolean isSupported(MimeType mimeType) {
        return a && mimeType != null && mimeType.g(com.taobao.pexode.mimetype.a.GIF);
    }

    @Override // com.taobao.pexode.decoder.Decoder
    public void prepare(Context context) {
        if (a) {
            return;
        }
        String a2 = a();
        boolean z = com.taobao.pexode.common.a.b(a2, 2) && GifImage.nativeLoadedVersionTest() == 2;
        a = z;
        hh0.f(Pexode.TAG, "retry load lib%s.so result=%b", a2, Boolean.valueOf(z));
    }

    public String toString() {
        return "GifDecoder@" + Integer.toHexString(hashCode());
    }
}
