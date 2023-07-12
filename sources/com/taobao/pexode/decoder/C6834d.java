package com.taobao.pexode.decoder;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.os.Build;
import com.taobao.pexode.C6827a;
import com.taobao.pexode.Pexode;
import com.taobao.pexode.PexodeOptions;
import com.taobao.pexode.entity.RewindableStream;
import com.taobao.pexode.exception.PexodeException;
import com.taobao.pexode.mimetype.C6838a;
import com.taobao.pexode.mimetype.MimeType;
import java.util.Random;
import tb.hh0;

/* compiled from: Taobao */
/* renamed from: com.taobao.pexode.decoder.d */
/* loaded from: classes11.dex */
public class C6834d implements Decoder {
    private static final boolean b;
    private static final boolean c;
    private Context a;

    static {
        int i = Build.VERSION.SDK_INT;
        b = i >= 14;
        c = i > 17;
    }

    private static void a(RewindableStream rewindableStream, PexodeOptions pexodeOptions) throws PexodeException {
        if (rewindableStream.getInputType() == 2 && Build.VERSION.SDK_INT == 19) {
            if (!pexodeOptions.justDecodeBounds) {
                hh0.f(Pexode.TAG, "maybe leak when system decoding with fd, back to input stream type!", new Object[0]);
            }
            rewindableStream.back2StreamType();
        }
        if (rewindableStream.getInputType() == 3) {
            if (pexodeOptions.enableAshmem) {
                hh0.i(Pexode.TAG, "cannot use ashmem when system decoding with input stream(justBounds=%b), disabled already!", Boolean.valueOf(pexodeOptions.justDecodeBounds));
                pexodeOptions.enableAshmem = false;
            }
            if (!C6838a.WEBP.g(pexodeOptions.outMimeType) || c) {
                return;
            }
            hh0.c(Pexode.TAG, "maybe error black image when system decoding webp with input stream(justBounds=%b)!", Boolean.valueOf(pexodeOptions.justDecodeBounds));
        }
    }

    public static String b(int i) {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < i; i2++) {
            sb.append("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".charAt(random.nextInt(52)));
        }
        return sb.toString();
    }

    private static BitmapFactory.Options c(PexodeOptions pexodeOptions) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = pexodeOptions.justDecodeBounds;
        if (!C6827a.f().a) {
            options.inBitmap = pexodeOptions.inBitmap;
        }
        if (pexodeOptions.isSizeAvailable()) {
            options.outWidth = pexodeOptions.outWidth;
            options.outHeight = pexodeOptions.outHeight;
        }
        MimeType mimeType = pexodeOptions.outMimeType;
        if (mimeType != null) {
            options.outMimeType = mimeType.toString();
        }
        options.inSampleSize = pexodeOptions.sampleSize;
        boolean z = true;
        options.inDither = true;
        options.inPreferredConfig = PexodeOptions.CONFIG;
        d(options, (C6827a.f().b || !pexodeOptions.enableAshmem) ? false : false);
        C6827a.n(pexodeOptions, options);
        return options;
    }

    public static void d(BitmapFactory.Options options, boolean z) {
        options.inMutable = true;
        if (options.inJustDecodeBounds) {
            return;
        }
        options.inPurgeable = z;
        options.inInputShareable = z;
    }

    private static void e(PexodeOptions pexodeOptions, BitmapFactory.Options options) {
        pexodeOptions.outWidth = options.outWidth;
        pexodeOptions.outHeight = options.outHeight;
        C6827a.n(pexodeOptions, null);
    }

    @Override // com.taobao.pexode.decoder.Decoder
    public boolean acceptInputType(int i, MimeType mimeType, boolean z) {
        if (Pexode.g && Build.VERSION.SDK_INT == 28 && (C6838a.WEBP_A.g(mimeType) || C6838a.WEBP.g(mimeType))) {
            return i == 1;
        } else if (i == 2 && Build.VERSION.SDK_INT == 19) {
            return false;
        } else {
            if (i == 3) {
                if (z) {
                    return false;
                }
                if (C6838a.WEBP.g(mimeType) && !c) {
                    return false;
                }
            }
            return true;
        }
    }

    @Override // com.taobao.pexode.decoder.Decoder
    public boolean canDecodeIncrementally(MimeType mimeType) {
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:55:0x00f4 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x012c A[Catch: Exception -> 0x0141, TryCatch #4 {Exception -> 0x0141, blocks: (B:58:0x00fa, B:61:0x0102, B:63:0x0106, B:65:0x010a, B:67:0x0110, B:72:0x013d, B:68:0x0119, B:69:0x0120, B:71:0x012c), top: B:105:0x00fa }] */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0157 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0172  */
    @Override // com.taobao.pexode.decoder.Decoder
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public tb.or1 decode(com.taobao.pexode.entity.RewindableStream r13, com.taobao.pexode.PexodeOptions r14, com.taobao.pexode.common.DegradeEventListener r15) throws com.taobao.pexode.exception.PexodeException, java.io.IOException {
        /*
            Method dump skipped, instructions count: 428
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.taobao.pexode.decoder.C6834d.decode(com.taobao.pexode.entity.RewindableStream, com.taobao.pexode.PexodeOptions, com.taobao.pexode.common.DegradeEventListener):tb.or1");
    }

    @Override // com.taobao.pexode.decoder.Decoder
    public MimeType detectMimeType(byte[] bArr) {
        if (b) {
            MimeType mimeType = C6838a.WEBP;
            if (mimeType.f(bArr)) {
                return mimeType;
            }
        }
        MimeType mimeType2 = C6838a.JPEG;
        if (mimeType2.f(bArr)) {
            return mimeType2;
        }
        MimeType mimeType3 = C6838a.PNG;
        if (mimeType3.f(bArr)) {
            return mimeType3;
        }
        MimeType mimeType4 = C6838a.PNG_A;
        if (mimeType4.f(bArr)) {
            return mimeType4;
        }
        if (c) {
            MimeType mimeType5 = C6838a.WEBP_A;
            if (mimeType5.f(bArr)) {
                return mimeType5;
            }
        }
        MimeType mimeType6 = C6838a.BMP;
        if (mimeType6.f(bArr)) {
            return mimeType6;
        }
        if (Pexode.f && Build.VERSION.SDK_INT == 28) {
            MimeType mimeType7 = C6838a.HEIF;
            if (mimeType7.f(bArr)) {
                return mimeType7;
            }
            return null;
        }
        return null;
    }

    @Override // com.taobao.pexode.decoder.Decoder
    public boolean isSupported(MimeType mimeType) {
        return mimeType != null && ((b && mimeType.g(C6838a.WEBP)) || mimeType.g(C6838a.JPEG) || mimeType.g(C6838a.PNG) || mimeType.g(C6838a.PNG_A) || ((c && mimeType.g(C6838a.WEBP_A)) || mimeType.g(C6838a.BMP) || (Pexode.f && Build.VERSION.SDK_INT == 28 && mimeType.g(C6838a.HEIF))));
    }

    @Override // com.taobao.pexode.decoder.Decoder
    public void prepare(Context context) {
        this.a = context;
    }

    public String toString() {
        return "SystemDecoder@" + Integer.toHexString(hashCode());
    }
}
