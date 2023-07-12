package com.alipay.ma.analyze.api;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.graphics.YuvImage;
import android.text.TextUtils;
import com.alipay.ma.analyze.helper.MaResultTypeHelper;
import com.alipay.ma.decode.DecodeResult;
import com.alipay.ma.decode.DecodeType;
import com.alipay.ma.decode.MaDecode;
import com.alipay.ma.strategies.MaInterceptOperation;
import com.alipay.ma.util.ImageTool;
import java.util.ArrayList;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class MaAnalyzeAPI {
    private static Rect a(int i, int i2) {
        int min = Math.min(i, i2) & (-8);
        return new Rect(Math.abs((i - i2) / 2) & (-4), 0, min, min);
    }

    public static DecodeResult[] decode(YuvImage yuvImage, Rect rect, DecodeType... decodeTypeArr) {
        if (yuvImage == null) {
            return null;
        }
        return decode(yuvImage.getYuvData(), yuvImage.getWidth(), yuvImage.getHeight(), rect, decodeTypeArr);
    }

    public static DecodeResult[] decodeBinarizedData(byte[] bArr, int i, int i2, Rect rect, int i3, DecodeType... decodeTypeArr) {
        int i4 = 0;
        for (DecodeType decodeType : decodeTypeArr) {
            i4 |= decodeType.getCodeType();
        }
        DecodeResult[] codeDecodeBinarizedData = MaDecode.codeDecodeBinarizedData(bArr, i, i2, i, rect, i4, i3, "", null);
        if (codeDecodeBinarizedData == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (DecodeResult decodeResult : codeDecodeBinarizedData) {
            if (decodeResult != null && !TextUtils.isEmpty(decodeResult.strCode) && (decodeResult.type | i4) > 0) {
                decodeResult.resultMaType = MaResultTypeHelper.getMaType(decodeResult);
                arrayList.add(decodeResult);
            }
        }
        return (DecodeResult[]) arrayList.toArray(new DecodeResult[arrayList.size()]);
    }

    public static DecodeResult[] decodeScanMode(byte[] bArr, int i, int i2, Rect rect, int i3) {
        return decodeScanMode(bArr, i, i2, rect, i3, 1.0f);
    }

    public static DecodeResult[] decode(byte[] bArr, int i, int i2, Rect rect, DecodeType... decodeTypeArr) {
        return decode(bArr, i, i2, i, rect, decodeTypeArr);
    }

    public static DecodeResult[] decodeScanMode(byte[] bArr, int i, int i2, int i3, Rect rect, int i4) {
        return decodeScanMode(bArr, i, i2, i3, rect, i4, 1.0f);
    }

    public static DecodeResult[] decode(byte[] bArr, int i, int i2, int i3, Rect rect, DecodeType... decodeTypeArr) {
        int i4 = 0;
        for (DecodeType decodeType : decodeTypeArr) {
            i4 |= decodeType.getCodeType();
        }
        return decodeScanMode(bArr, i, i2, i3, rect, i4);
    }

    public static DecodeResult[] decodeScanMode(byte[] bArr, int i, int i2, Rect rect, int i3, float f) {
        return decodeScanMode(bArr, i, i2, i, rect, i3, f);
    }

    public static DecodeResult[] decodeScanMode(byte[] bArr, int i, int i2, int i3, Rect rect, int i4, float f) {
        if (rect == null) {
            rect = a(i, i2);
        }
        DecodeResult[] codeDecode = MaDecode.codeDecode(bArr, i, i2, i3, rect, i4, "", null, f);
        if (codeDecode == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (DecodeResult decodeResult : codeDecode) {
            if (decodeResult != null && !TextUtils.isEmpty(decodeResult.strCode) && (decodeResult.type | i4) > 0) {
                decodeResult.resultMaType = MaResultTypeHelper.getMaType(decodeResult);
                arrayList.add(decodeResult);
            }
        }
        return (DecodeResult[]) arrayList.toArray(new DecodeResult[arrayList.size()]);
    }

    public static DecodeResult[] decode(String str, int i) {
        return decode(str, i, false);
    }

    public static DecodeResult[] decode(String str, int i, boolean z) {
        return decode(str, i, 4, z);
    }

    public static DecodeResult[] decode(String str, int i, int i2, boolean z) {
        return decode(str, i, i2, z, (MaInterceptOperation) null);
    }

    public static DecodeResult[] decode(String str, int i, int i2, boolean z, MaInterceptOperation maInterceptOperation) {
        DecodeResult[] codeDecodePictureWithQr;
        if (!TextUtils.isEmpty(str) && (codeDecodePictureWithQr = MaDecode.codeDecodePictureWithQr(str, i, i2, z, maInterceptOperation)) != null && codeDecodePictureWithQr.length != 0) {
            ArrayList arrayList = new ArrayList();
            for (DecodeResult decodeResult : codeDecodePictureWithQr) {
                if (decodeResult == null || TextUtils.isEmpty(decodeResult.strCode)) {
                    return null;
                }
                decodeResult.resultMaType = MaResultTypeHelper.getMaType(decodeResult);
                arrayList.add(decodeResult);
            }
            if (arrayList.size() > 0) {
                return (DecodeResult[]) arrayList.toArray(new DecodeResult[arrayList.size()]);
            }
        }
        return null;
    }

    public static DecodeResult[] decode(String str, Context context, int i) {
        return decode(str, context, i, false);
    }

    public static DecodeResult[] decode(String str, Context context, int i, boolean z) {
        return decode(str, context, i, 4, z);
    }

    public static DecodeResult[] decode(String str, Context context, int i, int i2, boolean z) {
        return decode(str, context, i, i2, z, (MaInterceptOperation) null);
    }

    public static DecodeResult[] decode(String str, Context context, int i, int i2, boolean z, MaInterceptOperation maInterceptOperation) {
        DecodeResult[] codeDecodePictureWithQr;
        if (!TextUtils.isEmpty(str) && context != null && (codeDecodePictureWithQr = MaDecode.codeDecodePictureWithQr(str, context, i, i2, z, maInterceptOperation)) != null && codeDecodePictureWithQr.length != 0) {
            ArrayList arrayList = new ArrayList();
            for (DecodeResult decodeResult : codeDecodePictureWithQr) {
                if (decodeResult == null || TextUtils.isEmpty(decodeResult.strCode)) {
                    return null;
                }
                decodeResult.resultMaType = MaResultTypeHelper.getMaType(decodeResult);
                arrayList.add(decodeResult);
            }
            if (arrayList.size() > 0) {
                return (DecodeResult[]) arrayList.toArray(new DecodeResult[arrayList.size()]);
            }
        }
        return null;
    }

    public static DecodeResult[] decode(Bitmap bitmap, int i) {
        return decode(bitmap, i, false);
    }

    public static DecodeResult[] decode(Bitmap bitmap, int i, boolean z) {
        return decode(bitmap, i, 4, z);
    }

    public static DecodeResult[] decode(Bitmap bitmap, int i, int i2, boolean z) {
        DecodeResult[] codeDecodePictureWithQr;
        if (bitmap == null) {
            return null;
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.outWidth = bitmap.getWidth();
        options.outHeight = bitmap.getHeight();
        int computeSampleSize = ImageTool.computeSampleSize(options, 1500, 2250000);
        if (computeSampleSize > 1) {
            Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmap, bitmap.getWidth() / computeSampleSize, bitmap.getHeight() / computeSampleSize, false);
            codeDecodePictureWithQr = MaDecode.codeDecodePictureWithQr(createScaledBitmap, i, i2, z);
            createScaledBitmap.recycle();
        } else {
            codeDecodePictureWithQr = MaDecode.codeDecodePictureWithQr(bitmap, i, i2, z);
        }
        if (codeDecodePictureWithQr != null && codeDecodePictureWithQr.length != 0) {
            ArrayList arrayList = new ArrayList();
            for (DecodeResult decodeResult : codeDecodePictureWithQr) {
                if (decodeResult == null || TextUtils.isEmpty(decodeResult.strCode)) {
                    return null;
                }
                decodeResult.resultMaType = MaResultTypeHelper.getMaType(decodeResult);
                arrayList.add(decodeResult);
            }
            if (arrayList.size() > 0) {
                return (DecodeResult[]) arrayList.toArray(new DecodeResult[arrayList.size()]);
            }
        }
        return null;
    }
}
