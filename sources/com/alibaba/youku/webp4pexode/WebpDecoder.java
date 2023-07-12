package com.alibaba.youku.webp4pexode;

import android.content.Context;
import android.graphics.Bitmap;
import com.taobao.pexode.C6827a;
import com.taobao.pexode.Pexode;
import com.taobao.pexode.PexodeOptions;
import com.taobao.pexode.common.DegradeEventListener;
import com.taobao.pexode.decoder.Decoder;
import com.taobao.pexode.entity.C6835a;
import com.taobao.pexode.entity.RewindableStream;
import com.taobao.pexode.exception.PexodeException;
import com.taobao.pexode.mimetype.C6838a;
import com.taobao.pexode.mimetype.MimeType;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;
import tb.hh0;
import tb.n8;
import tb.or1;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class WebpDecoder implements Decoder {
    private static final int LIBRARY_JNI_VERSION = 1;
    public static final String LIBRARY_NAME = "pwebp-v7a";
    private static boolean sIsSoInstalled = true;

    static {
        C6838a.ALL_EXTENSION_TYPES.add(WebpMimeType.WEBPD);
        String libraryName = getLibraryName();
        try {
            System.loadLibrary(libraryName);
            hh0.f(Pexode.TAG, "system load lib%s.so result = %b", libraryName, Boolean.valueOf(sIsSoInstalled));
        } catch (UnsatisfiedLinkError e) {
            hh0.c(Pexode.TAG, "system load lib%s.so error = %s", libraryName, e);
        }
    }

    private byte[] IS2Bytes(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[4096];
        while (true) {
            int read = inputStream.read(bArr);
            if (-1 != read) {
                byteArrayOutputStream.write(bArr, 0, read);
            } else {
                return byteArrayOutputStream.toByteArray();
            }
        }
    }

    private static String getLibraryName() {
        return LIBRARY_NAME;
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
        WebpImage nativeCreateFromDirectByteBuffer;
        Decoder decoder;
        boolean z = true;
        if (pexodeOptions.justDecodeBounds) {
            pexodeOptions.outHeight = 1;
            pexodeOptions.outWidth = 1;
            return null;
        } else if (pexodeOptions.forceStaticIfAnimation) {
            List<Decoder> g = Pexode.g(C6838a.WEBP);
            if (g == null || g.size() <= 0 || (decoder = g.get(0)) == null) {
                return null;
            }
            return decoder.decode(rewindableStream, pexodeOptions, degradeEventListener);
        } else {
            if (rewindableStream.getInputType() != 1) {
                byte[] IS2Bytes = IS2Bytes(rewindableStream);
                C6835a c6835a = new C6835a(IS2Bytes, 0, IS2Bytes.length);
                ByteBuffer allocateDirect = ByteBuffer.allocateDirect(c6835a.getBuffer().length);
                allocateDirect.put(c6835a.getBuffer());
                allocateDirect.rewind();
                nativeCreateFromDirectByteBuffer = WebpImage.nativeCreateFromDirectByteBuffer(allocateDirect);
            } else {
                ByteBuffer allocateDirect2 = ByteBuffer.allocateDirect(rewindableStream.getBuffer().length);
                allocateDirect2.put(rewindableStream.getBuffer());
                allocateDirect2.rewind();
                nativeCreateFromDirectByteBuffer = WebpImage.nativeCreateFromDirectByteBuffer(allocateDirect2);
            }
            if (pexodeOptions.forceStaticIfAnimation && nativeCreateFromDirectByteBuffer != null) {
                WebpFrame frame = nativeCreateFromDirectByteBuffer.getFrame(0);
                if (frame == null) {
                    frame.dispose();
                    return null;
                }
                int width = frame.getWidth();
                int height = frame.getHeight();
                z = (!pexodeOptions.enableAshmem || C6827a.f().b) ? false : false;
                Bitmap newBitmapWithPin = z ? n8.a().newBitmapWithPin(width, height, Bitmap.Config.ARGB_8888) : null;
                if (!z || (newBitmapWithPin == null && pexodeOptions.allowDegrade2NoAshmem)) {
                    newBitmapWithPin = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
                }
                if (newBitmapWithPin != null) {
                    frame.renderFrame(width, height, newBitmapWithPin);
                }
                frame.dispose();
                nativeCreateFromDirectByteBuffer.dispose();
                return or1.a(newBitmapWithPin);
            }
            return or1.b(nativeCreateFromDirectByteBuffer);
        }
    }

    @Override // com.taobao.pexode.decoder.Decoder
    public MimeType detectMimeType(byte[] bArr) {
        if (sIsSoInstalled) {
            MimeType mimeType = WebpMimeType.WEBPD;
            if (mimeType.f(bArr)) {
                return mimeType;
            }
            return null;
        }
        return null;
    }

    @Override // com.taobao.pexode.decoder.Decoder
    public boolean isSupported(MimeType mimeType) {
        return WebpMimeType.WEBPD.g(mimeType);
    }

    @Override // com.taobao.pexode.decoder.Decoder
    public void prepare(Context context) {
        if (sIsSoInstalled) {
            return;
        }
        hh0.f(Pexode.TAG, "retry load lib%s.so result=%b", getLibraryName(), Boolean.valueOf(sIsSoInstalled));
    }
}
