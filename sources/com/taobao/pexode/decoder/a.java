package com.taobao.pexode.decoder;

import android.content.Context;
import com.taobao.pexode.Pexode;
import com.taobao.pexode.PexodeOptions;
import com.taobao.pexode.common.DegradeEventListener;
import com.taobao.pexode.entity.RewindableStream;
import com.taobao.pexode.exception.PexodeException;
import com.taobao.pexode.mimetype.MimeType;
import java.io.IOException;
import java.util.List;
import tb.d0;
import tb.hh0;
import tb.or1;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class a implements Decoder {
    private static boolean a;

    static {
        com.taobao.pexode.mimetype.a.ALL_EXTENSION_TYPES.add(d0.APNG);
        String a2 = a();
        try {
            System.loadLibrary(a2);
            boolean z = APngImage.nativeLoadedVersionTest() == 1;
            a = z;
            hh0.f(Pexode.TAG, "system load lib%s.so result=%b", a2, Boolean.valueOf(z));
        } catch (UnsatisfiedLinkError e) {
            hh0.c(Pexode.TAG, "system load lib%s.so error=%s", a2, e);
        }
    }

    private static String a() {
        return "pexapng";
    }

    @Override // com.taobao.pexode.decoder.Decoder
    public boolean acceptInputType(int i, MimeType mimeType, boolean z) {
        return true;
    }

    @Override // com.taobao.pexode.decoder.Decoder
    public boolean canDecodeIncrementally(MimeType mimeType) {
        return false;
    }

    @Override // com.taobao.pexode.decoder.Decoder
    public or1 decode(RewindableStream rewindableStream, PexodeOptions pexodeOptions, DegradeEventListener degradeEventListener) throws PexodeException, IOException {
        Decoder decoder;
        if (pexodeOptions.justDecodeBounds) {
            pexodeOptions.outHeight = 1;
            pexodeOptions.outWidth = 1;
            return null;
        } else if (pexodeOptions.forceStaticIfAnimation) {
            List<Decoder> g = Pexode.g(com.taobao.pexode.mimetype.a.PNG);
            if (g == null || g.size() <= 0 || (decoder = g.get(0)) == null) {
                return null;
            }
            return decoder.decode(rewindableStream, pexodeOptions, degradeEventListener);
        } else {
            int inputType = rewindableStream.getInputType();
            if (inputType != 1) {
                if (inputType != 2) {
                    byte[] g2 = com.taobao.pexode.a.f().g(2048);
                    or1 b = or1.b(APngImage.nativeCreateFromRewindableStream(rewindableStream, g2));
                    com.taobao.pexode.a.f().h(g2);
                    return b;
                }
                return or1.b(APngImage.nativeCreateFromFd(rewindableStream.getFD()));
            }
            return or1.b(APngImage.nativeCreateFromBytes(rewindableStream.getBuffer(), rewindableStream.getBufferOffset(), rewindableStream.getBufferLength()));
        }
    }

    @Override // com.taobao.pexode.decoder.Decoder
    public MimeType detectMimeType(byte[] bArr) {
        if (a) {
            MimeType mimeType = d0.APNG;
            if (mimeType.f(bArr)) {
                return mimeType;
            }
            return null;
        }
        return null;
    }

    @Override // com.taobao.pexode.decoder.Decoder
    public boolean isSupported(MimeType mimeType) {
        return a && d0.APNG.g(mimeType);
    }

    @Override // com.taobao.pexode.decoder.Decoder
    public void prepare(Context context) {
        if (a) {
            return;
        }
        String a2 = a();
        boolean z = com.taobao.pexode.common.a.b(a2, 1) && APngImage.nativeLoadedVersionTest() == 1;
        a = z;
        hh0.f(Pexode.TAG, "retry load lib%s.so result=%b", a2, Boolean.valueOf(z));
    }

    public String toString() {
        return "APngDecoder@" + Integer.toHexString(hashCode());
    }
}
