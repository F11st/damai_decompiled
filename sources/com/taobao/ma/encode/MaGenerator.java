package com.taobao.ma.encode;

import android.graphics.Bitmap;
import android.util.Log;
import com.taobao.ma.common.config.MaConfig;
import com.taobao.ma.common.log.MaLogger;
import com.taobao.ma.encode.InputParameters.Gen0InputParameters;
import com.taobao.ma.encode.InputParameters.Gen3InputParameters;
import com.taobao.ma.encode.InputParameters.LogoBWInputParameters;
import com.taobao.ma.encode.InputParameters.MaEncodeInputParameters;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class MaGenerator {
    static {
        MaLogger.v("MaGenerator: loading so files");
        if (MaConfig.hasSoLoaded) {
            return;
        }
        try {
            System.loadLibrary("tbdecode");
            MaConfig.hasSoLoaded = true;
        } catch (UnsatisfiedLinkError e) {
            MaLogger.e("Failed to load libtbdecode.so", e);
        }
    }

    private static synchronized Bitmap __call_native_generateBWQRcode(Gen0InputParameters gen0InputParameters) {
        synchronized (MaGenerator.class) {
            try {
                byte[] generateBWQRCode = generateBWQRCode(gen0InputParameters.publicData, gen0InputParameters.hiddenData, gen0InputParameters.margin, gen0InputParameters.qrSize, gen0InputParameters.version, gen0InputParameters.rotation, gen0InputParameters.errorCorrectionLevel);
                int sqrt = (int) Math.sqrt(generateBWQRCode.length * 1.0d);
                return handleGrayResult(generateBWQRCode, sqrt, sqrt);
            } catch (Exception e) {
                MaLogger.v("Failed to load libtbdecode.so 2", e);
                return null;
            } catch (UnsatisfiedLinkError e2) {
                MaLogger.v("Failed to load libtbdecode.so", e2);
                return null;
            }
        }
    }

    private static synchronized Bitmap __call_native_generateGen3code(Gen3InputParameters gen3InputParameters) {
        synchronized (MaGenerator.class) {
            try {
                try {
                    byte[] generateGen3Code = generateGen3Code(gen3InputParameters.publicData, gen3InputParameters.bgImage_data, gen3InputParameters.bgImage_width, gen3InputParameters.bgImage_height, gen3InputParameters.bgImage_channel, gen3InputParameters.bgImage_step, gen3InputParameters.qrX, gen3InputParameters.qrY, gen3InputParameters.qrSize, gen3InputParameters.gen3format, gen3InputParameters.domainIndex, gen3InputParameters.errorCorrectionLevel, gen3InputParameters.visual_level, gen3InputParameters.version, gen3InputParameters.type);
                    int sqrt = (int) Math.sqrt((generateGen3Code.length / 3.0d) * 1.0d);
                    return handleResult(generateGen3Code, sqrt, sqrt, gen3InputParameters.bgImage_channel);
                } catch (UnsatisfiedLinkError e) {
                    MaLogger.v("Failed to load libtbdecode.so", e);
                    return null;
                }
            } catch (Exception e2) {
                MaLogger.v("Failed to load libtbdecode.so 2", e2);
                return null;
            }
        }
    }

    private static synchronized Bitmap __call_native_generateLogoBWcode(LogoBWInputParameters logoBWInputParameters) {
        synchronized (MaGenerator.class) {
            try {
                try {
                    byte[] generateLogoQRCode = generateLogoQRCode(logoBWInputParameters.publicData, logoBWInputParameters.margin, logoBWInputParameters.qrSize, logoBWInputParameters.version, logoBWInputParameters.logoData, logoBWInputParameters.logoWidth, logoBWInputParameters.logoHeight, logoBWInputParameters.logoChannel, logoBWInputParameters.logoSize, logoBWInputParameters.logoX, logoBWInputParameters.logoY);
                    int sqrt = (int) Math.sqrt((generateLogoQRCode.length / 3.0d) * 1.0d);
                    return handleResult(generateLogoQRCode, sqrt, sqrt, 3);
                } catch (UnsatisfiedLinkError e) {
                    MaLogger.v("Failed to load libtbdecode.so", e);
                    return null;
                }
            } catch (Exception e2) {
                MaLogger.v("Failed to load libtbdecode.so 2", e2);
                return null;
            }
        }
    }

    public static Bitmap facade(MaEncodeInputParameters maEncodeInputParameters) {
        int i;
        Log.v("masdk209", "facade");
        if (!maEncodeInputParameters.isLegal()) {
            Log.v("masdk209", maEncodeInputParameters.errorMsg);
            return null;
        }
        try {
            i = maEncodeInputParameters.type;
        } catch (Exception e) {
            Log.v("Masdk_exception_log", e.toString());
        }
        if (i == 0) {
            Log.v("masdk209", "encodeWhat = " + maEncodeInputParameters.type);
            return __call_native_generateBWQRcode((Gen0InputParameters) maEncodeInputParameters);
        } else if (i == 1) {
            return null;
        } else {
            if (i != 3) {
                if (i == 4) {
                    return __call_native_generateLogoBWcode((LogoBWInputParameters) maEncodeInputParameters);
                }
                return null;
            }
            Log.v("masdk209", "encodeWhat = " + maEncodeInputParameters.type);
            return __call_native_generateGen3code((Gen3InputParameters) maEncodeInputParameters);
        }
    }

    private static native byte[] generateBWQRCode(String str, String str2, int i, int i2, int i3, int i4, char c);

    private static native byte[] generateGen3Code(String str, byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, char c, char c2, int i9, int i10, int i11);

    private static native byte[] generateLogoQRCode(String str, int i, int i2, int i3, byte[] bArr, int i4, int i5, int i6, int i7, int i8, int i9);

    private static Bitmap handleGrayResult(byte[] bArr, int i, int i2) {
        if (bArr != null) {
            Bitmap createBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
            int[] iArr = new int[i * i2];
            int i3 = 0;
            int i4 = 0;
            while (i3 < bArr.length) {
                iArr[i4] = (((bArr[i3] & 255) << 16) - 16777216) + ((bArr[i3] & 255) << 8) + (bArr[i3] & 255);
                i3++;
                i4++;
            }
            createBitmap.setPixels(iArr, 0, i, 0, 0, i, i2);
            return createBitmap;
        }
        return null;
    }

    private static Bitmap handleResult(byte[] bArr, int i, int i2, int i3) {
        if (bArr != null) {
            MaLogger.v("handle result not null , channel = " + i3 + "w = " + i + "h = " + i2 + "length = " + bArr.length);
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
            MaLogger.v("before return result");
            return createBitmap;
        }
        return null;
    }
}
