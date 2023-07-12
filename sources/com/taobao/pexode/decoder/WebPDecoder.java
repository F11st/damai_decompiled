package com.taobao.pexode.decoder;

import android.content.Context;
import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import com.taobao.pexode.C6827a;
import com.taobao.pexode.Pexode;
import com.taobao.pexode.PexodeOptions;
import com.taobao.pexode.common.C6829a;
import com.taobao.pexode.common.DegradeEventListener;
import com.taobao.pexode.entity.IncrementalStaging;
import com.taobao.pexode.entity.RewindableStream;
import com.taobao.pexode.exception.IncrementalDecodeException;
import com.taobao.pexode.exception.PexodeException;
import com.taobao.pexode.mimetype.C6838a;
import com.taobao.pexode.mimetype.MimeType;
import java.io.FileDescriptor;
import java.io.IOException;
import tb.hh0;
import tb.or1;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class WebPDecoder extends AbstractC6832b {
    private static final int LIBRARY_JNI_VERSION = 2;
    private static final int NATIVE_RET_DECODE_OK = 0;
    private static final int NATIVE_RET_NULL_STRAIGHT = 2;
    private static final int NATIVE_RET_TRY_DEGRADING = 1;
    private static final int VP8_STATUS_OK = 0;
    private static final int VP8_STATUS_REQUEST_CANCELLED = -6;
    private static final int VP8_STATUS_SUSPENDED = 5;
    private static boolean sIsSoInstalled;
    private final IncrementalStaging.NativeDestructor CONFIG_OUT_DESTRUCTOR = new C6830a(this);

    /* compiled from: Taobao */
    /* renamed from: com.taobao.pexode.decoder.WebPDecoder$a */
    /* loaded from: classes11.dex */
    class C6830a implements IncrementalStaging.NativeDestructor {
        C6830a(WebPDecoder webPDecoder) {
        }

        @Override // com.taobao.pexode.entity.IncrementalStaging.NativeDestructor
        public void destruct(long j) {
            WebPDecoder.nativeDestructConfigOut(j);
        }
    }

    static {
        String libraryName = getLibraryName();
        try {
            System.loadLibrary(libraryName);
            boolean z = nativeLoadedVersionTest() == 2;
            sIsSoInstalled = z;
            hh0.f(Pexode.TAG, "system load lib%s.so result=%b", libraryName, Boolean.valueOf(z));
        } catch (UnsatisfiedLinkError e) {
            hh0.c(Pexode.TAG, "system load lib%s.so error=%s", libraryName, e);
        }
    }

    private int decodeFirstIncrementally(RewindableStream rewindableStream, PexodeOptions pexodeOptions, Bitmap bitmap, boolean z) throws PexodeException {
        byte[] pixelBufferFromBitmap;
        long j;
        int nativeDecodeBytesWithOutBufferIncrementally;
        if (AbstractC6832b.invalidBitmap(bitmap, pexodeOptions, "decodeFirstIncrementally")) {
            return 1;
        }
        if (z) {
            j = AbstractC6832b.getPixelAddressFromBitmap(bitmap);
            pixelBufferFromBitmap = null;
        } else {
            pixelBufferFromBitmap = getPixelBufferFromBitmap(bitmap);
            j = 0;
        }
        if (pixelBufferFromBitmap == null && j == 0) {
            return 1;
        }
        long[] jArr = new long[1];
        int inputType = rewindableStream.getInputType();
        if (inputType != 1) {
            if (inputType != 2) {
                byte[] g = C6827a.f().g(2048);
                if (z) {
                    nativeDecodeBytesWithOutBufferIncrementally = nativeDecodeStreamWithOutAddressIncrementally(rewindableStream, g, pexodeOptions, j, jArr);
                } else {
                    nativeDecodeBytesWithOutBufferIncrementally = nativeDecodeStreamWithOutBufferIncrementally(rewindableStream, g, pexodeOptions, pixelBufferFromBitmap, jArr);
                }
                C6827a.f().h(g);
            } else if (z) {
                nativeDecodeBytesWithOutBufferIncrementally = nativeDecodeFdWithOutAddressIncrementally(rewindableStream.getFD(), pexodeOptions, j, jArr);
            } else {
                nativeDecodeBytesWithOutBufferIncrementally = nativeDecodeFdWithOutBufferIncrementally(rewindableStream.getFD(), pexodeOptions, pixelBufferFromBitmap, jArr);
            }
        } else if (z) {
            nativeDecodeBytesWithOutBufferIncrementally = nativeDecodeBytesWithOutAddressIncrementally(rewindableStream.getBuffer(), rewindableStream.getBufferOffset(), rewindableStream.getBufferLength(), pexodeOptions, j, jArr);
        } else {
            nativeDecodeBytesWithOutBufferIncrementally = nativeDecodeBytesWithOutBufferIncrementally(rewindableStream.getBuffer(), rewindableStream.getBufferOffset(), rewindableStream.getBufferLength(), pexodeOptions, pixelBufferFromBitmap, jArr);
        }
        IncrementalStaging incrementalStaging = new IncrementalStaging(bitmap, jArr[0], this.CONFIG_OUT_DESTRUCTOR);
        if (nativeDecodeBytesWithOutBufferIncrementally != 5 || C6827a.b(pexodeOptions)) {
            incrementalStaging.c();
        }
        if (nativeDecodeBytesWithOutBufferIncrementally == -6) {
            return 2;
        }
        if (nativeDecodeBytesWithOutBufferIncrementally == 0 || nativeDecodeBytesWithOutBufferIncrementally == 5) {
            C6827a.l(pexodeOptions, incrementalStaging);
            return nativeDecodeBytesWithOutBufferIncrementally == 5 ? 2 : 0;
        }
        return 1;
    }

    private static int decodeInBitmapAddress(RewindableStream rewindableStream, PexodeOptions pexodeOptions, Bitmap bitmap) {
        boolean z;
        if (AbstractC6832b.invalidBitmap(bitmap, pexodeOptions, "decodeInBitmapAddress")) {
            return 1;
        }
        long pixelAddressFromBitmap = AbstractC6832b.getPixelAddressFromBitmap(bitmap);
        if (pixelAddressFromBitmap == 0) {
            return 1;
        }
        int inputType = rewindableStream.getInputType();
        if (inputType == 1) {
            z = nativeDecodeBytesWithOutAddress(rewindableStream.getBuffer(), rewindableStream.getBufferOffset(), rewindableStream.getBufferLength(), pexodeOptions, pixelAddressFromBitmap);
        } else if (inputType != 2) {
            byte[] g = C6827a.f().g(2048);
            boolean nativeDecodeStreamWithOutAddress = nativeDecodeStreamWithOutAddress(rewindableStream, g, pexodeOptions, pixelAddressFromBitmap);
            C6827a.f().h(g);
            z = nativeDecodeStreamWithOutAddress;
        } else {
            z = nativeDecodeFdWithOutAddress(rewindableStream.getFD(), pexodeOptions, pixelAddressFromBitmap);
        }
        return !z;
    }

    private int decodeInBitmapBuffer(RewindableStream rewindableStream, PexodeOptions pexodeOptions, Bitmap bitmap) {
        byte[] pixelBufferFromBitmap;
        boolean z;
        if (AbstractC6832b.invalidBitmap(bitmap, pexodeOptions, "decodeInBitmapBuffer") || (pixelBufferFromBitmap = getPixelBufferFromBitmap(bitmap)) == null) {
            return 1;
        }
        int inputType = rewindableStream.getInputType();
        if (inputType == 1) {
            z = nativeDecodeBytesWithOutBuffer(rewindableStream.getBuffer(), rewindableStream.getBufferOffset(), rewindableStream.getBufferLength(), pexodeOptions, pixelBufferFromBitmap);
        } else if (inputType != 2) {
            byte[] g = C6827a.f().g(2048);
            boolean nativeDecodeStreamWithOutBuffer = nativeDecodeStreamWithOutBuffer(rewindableStream, g, pexodeOptions, pixelBufferFromBitmap);
            C6827a.f().h(g);
            z = nativeDecodeStreamWithOutBuffer;
        } else {
            z = nativeDecodeFdWithOutBuffer(rewindableStream.getFD(), pexodeOptions, pixelBufferFromBitmap);
        }
        return !z;
    }

    private int decodeLaterIncrementally(RewindableStream rewindableStream, PexodeOptions pexodeOptions, @NonNull IncrementalStaging incrementalStaging) throws PexodeException {
        int nativeDecodeBytesIncrementally;
        int inputType = rewindableStream.getInputType();
        if (inputType == 1) {
            nativeDecodeBytesIncrementally = nativeDecodeBytesIncrementally(rewindableStream.getBuffer(), rewindableStream.getBufferOffset(), rewindableStream.getBufferLength(), pexodeOptions, incrementalStaging.b());
        } else if (inputType != 2) {
            byte[] g = C6827a.f().g(2048);
            nativeDecodeBytesIncrementally = nativeDecodeStreamIncrementally(rewindableStream, g, pexodeOptions, incrementalStaging.b());
            C6827a.f().h(g);
        } else {
            nativeDecodeBytesIncrementally = nativeDecodeFdIncrementally(rewindableStream.getFD(), pexodeOptions, incrementalStaging.b());
        }
        if (nativeDecodeBytesIncrementally != 5 || C6827a.b(pexodeOptions)) {
            incrementalStaging.c();
        }
        if (nativeDecodeBytesIncrementally == 5 || nativeDecodeBytesIncrementally == -6) {
            return 2;
        }
        if (nativeDecodeBytesIncrementally == 0) {
            return 0;
        }
        throw new IncrementalDecodeException("native decode bytes with buffer incrementally error, status=" + nativeDecodeBytesIncrementally);
    }

    private int decodeReturnInBuffer(RewindableStream rewindableStream, PexodeOptions pexodeOptions, Bitmap bitmap, IncrementalStaging incrementalStaging, boolean z, boolean z2) throws PexodeException {
        if (z) {
            if (z2) {
                return decodeFirstIncrementally(rewindableStream, pexodeOptions, bitmap, false);
            }
            return decodeLaterIncrementally(rewindableStream, pexodeOptions, incrementalStaging);
        }
        return decodeInBitmapBuffer(rewindableStream, pexodeOptions, bitmap);
    }

    private static String getLibraryName() {
        return "pexwebp";
    }

    private static native int nativeDecodeBytesIncrementally(byte[] bArr, int i, int i2, PexodeOptions pexodeOptions, long j);

    private static native boolean nativeDecodeBytesWithOutAddress(byte[] bArr, int i, int i2, PexodeOptions pexodeOptions, long j);

    private static native int nativeDecodeBytesWithOutAddressIncrementally(byte[] bArr, int i, int i2, PexodeOptions pexodeOptions, long j, long[] jArr);

    private static native boolean nativeDecodeBytesWithOutBuffer(byte[] bArr, int i, int i2, PexodeOptions pexodeOptions, byte[] bArr2);

    private static native int nativeDecodeBytesWithOutBufferIncrementally(byte[] bArr, int i, int i2, PexodeOptions pexodeOptions, byte[] bArr2, long[] jArr);

    private static native int nativeDecodeFdIncrementally(FileDescriptor fileDescriptor, PexodeOptions pexodeOptions, long j);

    private static native boolean nativeDecodeFdWithOutAddress(FileDescriptor fileDescriptor, PexodeOptions pexodeOptions, long j);

    private static native int nativeDecodeFdWithOutAddressIncrementally(FileDescriptor fileDescriptor, PexodeOptions pexodeOptions, long j, long[] jArr);

    private static native boolean nativeDecodeFdWithOutBuffer(FileDescriptor fileDescriptor, PexodeOptions pexodeOptions, byte[] bArr);

    private static native int nativeDecodeFdWithOutBufferIncrementally(FileDescriptor fileDescriptor, PexodeOptions pexodeOptions, byte[] bArr, long[] jArr);

    private static native int nativeDecodeStreamIncrementally(RewindableStream rewindableStream, byte[] bArr, PexodeOptions pexodeOptions, long j);

    private static native boolean nativeDecodeStreamWithOutAddress(RewindableStream rewindableStream, byte[] bArr, PexodeOptions pexodeOptions, long j);

    private static native int nativeDecodeStreamWithOutAddressIncrementally(RewindableStream rewindableStream, byte[] bArr, PexodeOptions pexodeOptions, long j, long[] jArr);

    private static native boolean nativeDecodeStreamWithOutBuffer(RewindableStream rewindableStream, byte[] bArr, PexodeOptions pexodeOptions, byte[] bArr2);

    private static native int nativeDecodeStreamWithOutBufferIncrementally(RewindableStream rewindableStream, byte[] bArr, PexodeOptions pexodeOptions, byte[] bArr2, long[] jArr);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nativeDestructConfigOut(long j);

    private static native int nativeLoadedVersionTest();

    @Override // com.taobao.pexode.decoder.Decoder
    public boolean acceptInputType(int i, MimeType mimeType, boolean z) {
        return true;
    }

    @Override // com.taobao.pexode.decoder.Decoder
    public boolean canDecodeIncrementally(MimeType mimeType) {
        return isSupported(mimeType);
    }

    @Override // com.taobao.pexode.decoder.Decoder
    public or1 decode(RewindableStream rewindableStream, PexodeOptions pexodeOptions, DegradeEventListener degradeEventListener) throws PexodeException, IOException {
        Bitmap decodeNormal;
        if (!pexodeOptions.isSizeAvailable()) {
            int inputType = rewindableStream.getInputType();
            if (inputType == 1) {
                nativeDecodeBytesWithOutBuffer(rewindableStream.getBuffer(), rewindableStream.getBufferOffset(), rewindableStream.getBufferLength(), pexodeOptions, null);
            } else if (inputType != 2) {
                byte[] g = C6827a.f().g(64);
                nativeDecodeStreamWithOutBuffer(rewindableStream, g, pexodeOptions, null);
                C6827a.f().h(g);
            } else {
                nativeDecodeFdWithOutBuffer(rewindableStream.getFD(), pexodeOptions, null);
            }
        } else if (pexodeOptions.sampleSize != C6827a.e(pexodeOptions)) {
            int i = pexodeOptions.outWidth;
            int i2 = i / pexodeOptions.sampleSize;
            pexodeOptions.outWidth = i2;
            pexodeOptions.outHeight = (pexodeOptions.outHeight * i2) / i;
        }
        C6827a.m(pexodeOptions, pexodeOptions.sampleSize);
        if (pexodeOptions.justDecodeBounds || C6827a.b(pexodeOptions)) {
            return null;
        }
        if (!pexodeOptions.isSizeAvailable()) {
            hh0.c(Pexode.TAG, "WebPDecoder size unavailable before bitmap decoding", new Object[0]);
            return null;
        }
        if (pexodeOptions.enableAshmem && !C6827a.f().b) {
            decodeNormal = decodeAshmem(rewindableStream, pexodeOptions, degradeEventListener);
        } else if (pexodeOptions.inBitmap != null && !C6827a.f().a) {
            decodeNormal = decodeInBitmap(rewindableStream, pexodeOptions, degradeEventListener);
        } else {
            decodeNormal = decodeNormal(rewindableStream, pexodeOptions);
        }
        return or1.a(decodeNormal);
    }

    @Override // com.taobao.pexode.decoder.AbstractC6832b
    protected Bitmap decodeAshmem(RewindableStream rewindableStream, PexodeOptions pexodeOptions, DegradeEventListener degradeEventListener) throws PexodeException, IOException {
        int decodeInBitmapAddress;
        boolean z = pexodeOptions.incrementalDecode;
        IncrementalStaging d = C6827a.d(pexodeOptions);
        boolean z2 = false;
        boolean z3 = d == null;
        Bitmap bitmap = null;
        Bitmap newBitmap = (!z || z3) ? AbstractC6832b.newBitmap(pexodeOptions, true) : null;
        if (!z) {
            decodeInBitmapAddress = decodeInBitmapAddress(rewindableStream, pexodeOptions, newBitmap);
        } else if (z3) {
            decodeInBitmapAddress = decodeFirstIncrementally(rewindableStream, pexodeOptions, newBitmap, true);
        } else {
            decodeInBitmapAddress = decodeLaterIncrementally(rewindableStream, pexodeOptions, d);
        }
        if (decodeInBitmapAddress == 0) {
            return z ? C6827a.d(pexodeOptions).a() : newBitmap;
        } else if (2 == decodeInBitmapAddress) {
            return null;
        } else {
            if (!C6827a.b(pexodeOptions) && pexodeOptions.allowDegrade2NoAshmem) {
                rewindableStream.rewind();
                bitmap = decodeNormal(rewindableStream, pexodeOptions);
                if (!C6827a.b(pexodeOptions)) {
                    degradeEventListener.onDegraded2NoAshmem((bitmap != null || z) ? true : true);
                }
            }
            return bitmap;
        }
    }

    @Override // com.taobao.pexode.decoder.AbstractC6832b
    protected Bitmap decodeInBitmap(RewindableStream rewindableStream, PexodeOptions pexodeOptions, DegradeEventListener degradeEventListener) throws PexodeException, IOException {
        boolean z = pexodeOptions.incrementalDecode;
        IncrementalStaging d = C6827a.d(pexodeOptions);
        boolean z2 = true;
        int decodeReturnInBuffer = decodeReturnInBuffer(rewindableStream, pexodeOptions, pexodeOptions.inBitmap, d, z, d == null);
        if (decodeReturnInBuffer == 0) {
            if (z) {
                return C6827a.d(pexodeOptions).a();
            }
            return pexodeOptions.inBitmap;
        }
        Bitmap bitmap = null;
        if (2 == decodeReturnInBuffer) {
            return null;
        }
        if (!C6827a.b(pexodeOptions) && pexodeOptions.allowDegrade2NoInBitmap) {
            rewindableStream.rewind();
            bitmap = decodeNormal(rewindableStream, pexodeOptions);
            if (!C6827a.b(pexodeOptions)) {
                if (bitmap == null && !z) {
                    z2 = false;
                }
                degradeEventListener.onDegraded2NoInBitmap(z2);
            }
        }
        return bitmap;
    }

    @Override // com.taobao.pexode.decoder.AbstractC6832b
    protected Bitmap decodeNormal(RewindableStream rewindableStream, PexodeOptions pexodeOptions) throws PexodeException {
        boolean z = pexodeOptions.incrementalDecode;
        IncrementalStaging d = C6827a.d(pexodeOptions);
        boolean z2 = d == null;
        Bitmap newBitmap = (!z || z2) ? AbstractC6832b.newBitmap(pexodeOptions, false) : null;
        int decodeReturnInBuffer = decodeReturnInBuffer(rewindableStream, pexodeOptions, newBitmap, d, z, z2);
        if (decodeReturnInBuffer == 0) {
            return z ? C6827a.d(pexodeOptions).a() : newBitmap;
        } else if (1 == decodeReturnInBuffer && z) {
            throw new IncrementalDecodeException("incremental decoding error at the first and cannot degrade now");
        } else {
            return null;
        }
    }

    @Override // com.taobao.pexode.decoder.Decoder
    public MimeType detectMimeType(byte[] bArr) {
        if (sIsSoInstalled) {
            MimeType mimeType = C6838a.WEBP;
            if (mimeType.f(bArr)) {
                return mimeType;
            }
            MimeType mimeType2 = C6838a.WEBP_A;
            if (mimeType2.f(bArr)) {
                return mimeType2;
            }
            return null;
        }
        return null;
    }

    @Override // com.taobao.pexode.decoder.Decoder
    public boolean isSupported(MimeType mimeType) {
        return sIsSoInstalled && mimeType != null && C6838a.WEBP.a().equals(mimeType.a());
    }

    @Override // com.taobao.pexode.decoder.Decoder
    public void prepare(Context context) {
        if (sIsSoInstalled) {
            return;
        }
        String libraryName = getLibraryName();
        boolean z = C6829a.b(libraryName, 2) && nativeLoadedVersionTest() == 2;
        sIsSoInstalled = z;
        hh0.f(Pexode.TAG, "retry load lib%s.so result=%b", libraryName, Boolean.valueOf(z));
    }

    public String toString() {
        return "WebPDecoder@" + Integer.toHexString(hashCode());
    }
}
