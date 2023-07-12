package com.taobao.ma.decode;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.YuvImage;
import com.taobao.ma.ar.ARInputParam;
import com.taobao.ma.ar.ARResult;
import com.taobao.ma.common.config.MaConfig;
import com.taobao.ma.common.log.MaLogger;
import com.taobao.ma.util.ImageTool;
import com.taobao.ma.util.StringEncodeUtils;
import com.taobao.ma.util.StringUtils;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class MaDecode {
    private static boolean isInDecoding;

    static {
        MaLogger.v("Madecode: loading so files");
        if (!MaConfig.hasSoLoaded) {
            try {
                System.loadLibrary("tbdecode");
                MaConfig.hasSoLoaded = true;
            } catch (UnsatisfiedLinkError e) {
                MaLogger.e("Failed to load libtbdecode.so", e);
            }
        }
        isInDecoding = false;
    }

    private static synchronized DecodeResult codeDecode(byte[] bArr, int i, int i2, int i3, Rect rect, int i4, String str, String[] strArr) {
        synchronized (MaDecode.class) {
            DecodeResult decodeResult = null;
            if (isInDecoding) {
                return null;
            }
            isInDecoding = true;
            if (bArr == null) {
                MaLogger.w("codeDecode data is null");
                return null;
            }
            try {
                decodeResult = yuvcodeDecode(bArr, i, i2, i3, rect, i4, str, strArr);
            } catch (Exception e) {
                MaLogger.e(e);
            } catch (UnsatisfiedLinkError e2) {
                MaLogger.e("Failed to load libtbdecode.so", e2);
            }
            DecodeResult handleDecodeResult = handleDecodeResult(decodeResult);
            isInDecoding = false;
            return handleDecodeResult;
        }
    }

    public static synchronized DecodeResult codeDecodePictureWithQr(String str) {
        DecodeResult codeDecodePictureWithQr;
        synchronized (MaDecode.class) {
            codeDecodePictureWithQr = codeDecodePictureWithQr(str, 512);
        }
        return codeDecodePictureWithQr;
    }

    private static native DecodeResult codeDecodeWithQr(byte[] bArr, int i, int i2, int i3, int i4);

    public static synchronized ARResult detectGen3Markers(ARInputParam aRInputParam) {
        ARResult convertId;
        synchronized (MaDecode.class) {
            ARResult aRResult = new ARResult();
            detectMarkers(aRInputParam.imageData, aRInputParam.imageWidth, aRInputParam.imageHeight, aRInputParam.preXCoords, aRInputParam.preYCoords, aRInputParam.preDim, aRInputParam.preInCount, -1, aRInputParam.interestP1_X, aRInputParam.interestP1_Y, aRInputParam.interestP2_X, aRInputParam.interestP2_Y, aRResult);
            convertId = aRResult.pointNum == 0 ? null : aRResult.convertId();
        }
        return convertId;
    }

    private static native void detectMarkers(byte[] bArr, int i, int i2, int[] iArr, int[] iArr2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, ARResult aRResult);

    public static synchronized Bitmap encode(String str, Bitmap bitmap, int i, char c) {
        Bitmap handleResult;
        synchronized (MaDecode.class) {
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            int i2 = bitmap.hasAlpha() ? 4 : 3;
            handleResult = handleResult(encode(str, getPixelData(bitmap, width, height, i2), width, height, i2, i, c), width, height, i2);
        }
        return handleResult;
    }

    private static native byte[] encode(String str, byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, char c, char c2, int i9, int i10, int i11);

    private static byte[] getPixelData(Bitmap bitmap, int i, int i2, int i3) {
        int i4 = i * i2;
        byte[] bArr = new byte[i3 * i4];
        int[] iArr = new int[i4];
        bitmap.getPixels(iArr, 0, i, 0, 0, i, i2);
        int i5 = 0;
        int i6 = 0;
        while (i5 < i4) {
            int i7 = iArr[i5];
            byte b = (byte) ((i7 >> 24) & 255);
            bArr[i6] = (byte) ((i7 >> 16) & 255);
            bArr[i6 + 1] = (byte) ((i7 >> 8) & 255);
            bArr[i6 + 2] = (byte) (i7 & 255);
            if (i3 == 4) {
                bArr[i6 + 3] = b;
            }
            i5++;
            i6 += i3;
        }
        return bArr;
    }

    private static DecodeResult handleDecodeResult(DecodeResult decodeResult) {
        byte[] bArr;
        if (decodeResult == null || (bArr = decodeResult.bytes) == null || bArr.length <= 0) {
            return null;
        }
        try {
            String stringEncode = StringEncodeUtils.getStringEncode(bArr);
            if (StringUtils.isEmpty(stringEncode)) {
                decodeResult.strCode = new String(decodeResult.bytes, "utf-8");
            } else {
                decodeResult.strCode = new String(decodeResult.bytes, stringEncode);
            }
            decodeResult.bytes = null;
            if (StringUtils.isEmpty(decodeResult.strCode)) {
                decodeResult = null;
            }
            return decodeResult;
        } catch (UnsupportedEncodingException | Exception unused) {
            return null;
        }
    }

    private static Bitmap handleResult(byte[] bArr, int i, int i2, int i3) {
        if (bArr != null) {
            Bitmap createBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
            int[] iArr = new int[i * i2];
            int i4 = 0;
            int i5 = 0;
            while (i4 < bArr.length) {
                iArr[i5] = (i3 == 4 ? (bArr[i4 + 3] & 255) << 24 : -16777216) + ((bArr[i4] & 255) << 16) + ((bArr[i4 + 1] & 255) << 8) + (bArr[i4 + 2] & 255);
                i4 += i3;
                i5++;
            }
            createBitmap.setPixels(iArr, 0, i, 0, 0, i, i2);
            return createBitmap;
        }
        return null;
    }

    private static native void releaseMemory();

    public static void releaseStaticMemory() {
        releaseMemory();
    }

    public static DecodeResult yuvcodeDecode(YuvImage yuvImage, Rect rect, int i, String str, String[] strArr) {
        return codeDecode(yuvImage.getYuvData(), yuvImage.getWidth(), yuvImage.getHeight(), yuvImage.getStrides()[0], rect, i, str, strArr);
    }

    private static native DecodeResult yuvcodeDecode(byte[] bArr, int i, int i2, int i3, Rect rect, int i4, String str, String[] strArr);

    public static synchronized DecodeResult codeDecodePictureWithQr(String str, int i) {
        synchronized (MaDecode.class) {
            try {
                if (StringUtils.isEmpty(str)) {
                    return null;
                }
                File file = new File(str);
                if (file.exists()) {
                    return codeDecodePictureWithQr(ImageTool.createThumbnail(file, 1024, 1024), i);
                }
                return null;
            } catch (Exception unused) {
                return null;
            }
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(13:3|(1:5)(1:31)|6|7|8|(7:(1:11)(0)|12|(1:14)(1:26)|15|16|17|18)|28|12|(0)(0)|15|16|17|18) */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x002c, code lost:
        if (r20 == r21) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0052, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0053, code lost:
        com.taobao.ma.common.log.MaLogger.e(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0057, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0058, code lost:
        com.taobao.ma.common.log.MaLogger.e("Failed to load libtbdecode.so", r0);
     */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0035  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static synchronized byte[] encode(java.lang.String r18, byte[] r19, int r20, int r21, int r22, int r23, char r24) {
        /*
            r0 = r20
            r4 = r21
            r15 = r23
            java.lang.Class<com.taobao.ma.decode.MaDecode> r16 = com.taobao.ma.decode.MaDecode.class
            monitor-enter(r16)
            r1 = 3
            if (r15 != r1) goto Lf
            r11 = r24
            goto L13
        Lf:
            r2 = 48
            r11 = 48
        L13:
            r2 = 4
            char[] r3 = new char[r2]     // Catch: java.lang.Throwable -> L5f
            r5 = 81
            r6 = 0
            r3[r6] = r5     // Catch: java.lang.Throwable -> L5f
            r7 = 1
            r3[r7] = r5     // Catch: java.lang.Throwable -> L5f
            r5 = 2
            r7 = 76
            r3[r5] = r7     // Catch: java.lang.Throwable -> L5f
            r3[r1] = r7     // Catch: java.lang.Throwable -> L5f
            if (r0 <= r4) goto L28
            goto L2e
        L28:
            if (r0 >= r4) goto L2c
            r6 = r4
            goto L2f
        L2c:
            if (r0 != r4) goto L2f
        L2e:
            r6 = r0
        L2f:
            r5 = 350(0x15e, float:4.9E-43)
            if (r6 < r5) goto L35
            r14 = 4
            goto L36
        L35:
            r14 = 3
        L36:
            r13 = 2
            r17 = 0
            int r6 = r22 * r0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            char r12 = r3[r15]     // Catch: java.lang.Exception -> L52 java.lang.UnsatisfiedLinkError -> L57 java.lang.Throwable -> L5f
            r1 = r18
            r2 = r19
            r3 = r20
            r4 = r21
            r5 = r22
            r15 = r23
            byte[] r17 = encode(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15)     // Catch: java.lang.Exception -> L52 java.lang.UnsatisfiedLinkError -> L57 java.lang.Throwable -> L5f
            goto L5d
        L52:
            r0 = move-exception
            com.taobao.ma.common.log.MaLogger.e(r0)     // Catch: java.lang.Throwable -> L5f
            goto L5d
        L57:
            r0 = move-exception
            java.lang.String r1 = "Failed to load libtbdecode.so"
            com.taobao.ma.common.log.MaLogger.e(r1, r0)     // Catch: java.lang.Throwable -> L5f
        L5d:
            monitor-exit(r16)
            return r17
        L5f:
            r0 = move-exception
            monitor-exit(r16)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.taobao.ma.decode.MaDecode.encode(java.lang.String, byte[], int, int, int, int, char):byte[]");
    }

    public static synchronized DecodeResult codeDecodePictureWithQr(Bitmap bitmap, int i) {
        DecodeResult decodeResult;
        synchronized (MaDecode.class) {
            DecodeResult decodeResult2 = null;
            try {
                Bitmap.Config config = bitmap.getConfig();
                Bitmap.Config config2 = Bitmap.Config.ARGB_8888;
                if (config != config2) {
                    Bitmap copy = bitmap.copy(config2, true);
                    bitmap.recycle();
                    bitmap = copy;
                }
                ByteBuffer allocate = ByteBuffer.allocate(bitmap.getHeight() * bitmap.getRowBytes());
                allocate.order(ByteOrder.BIG_ENDIAN);
                bitmap.copyPixelsToBuffer(allocate);
                try {
                    decodeResult2 = codeDecodeWithQr(allocate.array(), bitmap.getWidth(), bitmap.getHeight(), bitmap.getRowBytes(), i);
                } catch (Exception e) {
                    MaLogger.e(e);
                } catch (UnsatisfiedLinkError e2) {
                    MaLogger.e("Failed to load libtbdecode.so", e2);
                }
                decodeResult = handleDecodeResult(decodeResult2);
            } catch (OutOfMemoryError unused) {
                decodeResult = decodeResult2;
            }
        }
        return decodeResult;
    }
}
