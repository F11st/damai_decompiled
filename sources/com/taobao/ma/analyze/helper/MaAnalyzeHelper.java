package com.taobao.ma.analyze.helper;

import android.graphics.YuvImage;
import android.hardware.Camera;
import android.net.Uri;
import android.text.TextUtils;
import com.taobao.ma.common.result.MaType;
import com.taobao.ma.common.result.MaWapperResult;
import com.taobao.ma.util.StringUtils;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class MaAnalyzeHelper {
    private static final String ANTI_FAKE_URI_HOST = "s.tb.cn";

    public static YuvImage buildYuvImage(byte[] bArr, Camera camera) {
        Camera.Parameters parameters;
        Camera.Size previewSize;
        if (bArr == null || bArr.length == 0 || camera == null || (parameters = camera.getParameters()) == null || (previewSize = parameters.getPreviewSize()) == null || camera.getParameters().getPreviewFormat() <= 0 || previewSize.width <= 0 || previewSize.height <= 0) {
            return null;
        }
        return new YuvImage(bArr, camera.getParameters().getPreviewFormat(), previewSize.width, previewSize.height, null);
    }

    public static MaType getMaType(MaWapperResult maWapperResult) {
        int i = maWapperResult.type;
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    if (i == 127 && maWapperResult.subType == 128) {
                        return MaType.PRODUCT;
                    }
                    return null;
                } else if (isMedicineCode(maWapperResult.strCode)) {
                    return MaType.MEDICINE;
                } else {
                    return MaType.EXPRESS;
                }
            } else if (isTBAntiFakeCode(maWapperResult.strCode)) {
                return MaType.TB_ANTI_FAKE;
            } else {
                if (isGen3(maWapperResult.subType)) {
                    return MaType.GEN3;
                }
                if (is4GCode(maWapperResult.subType)) {
                    return MaType.TB_4G;
                }
                if (isDMCode(maWapperResult.subType)) {
                    return MaType.DM;
                }
                return MaType.QR;
            }
        }
        return MaType.PRODUCT;
    }

    public static boolean is4GCode(int i) {
        return i == 2050;
    }

    public static boolean is4GCode(int i, MaType maType, int i2) {
        return i == 1 && maType == MaType.TB_4G && i2 == 2050;
    }

    public static boolean isBarCode(int i, int i2) {
        return i == 0 || i == 2 || (i == 127 && i2 == 128);
    }

    public static boolean isDMCode(int i) {
        return i == 1024;
    }

    public static boolean isDMCode(int i, MaType maType, int i2) {
        return i == 1 && maType == MaType.DM && i2 == 1024;
    }

    public static boolean isGen3(int i) {
        return i == 32768;
    }

    public static boolean isGen3Code(int i, MaType maType, int i2) {
        return i == 1 && maType == MaType.GEN3 && i2 == 32768;
    }

    public static boolean isMedicineCode(String str) {
        if (StringUtils.isEmpty(str)) {
            return false;
        }
        if (str.startsWith("8") && str.length() == 20) {
            return true;
        }
        return (str.startsWith("10") || str.startsWith("11")) && str.length() == 16;
    }

    public static boolean isQrCode(int i, MaType maType, int i2) {
        return i == 1 && maType == MaType.QR && i2 == 512;
    }

    public static boolean isTBAntiFakeCode(String str) {
        Uri parse;
        if (StringUtils.isEmpty(str) || (parse = Uri.parse(str)) == null || parse.getHost() == null) {
            return false;
        }
        return TextUtils.equals(ANTI_FAKE_URI_HOST, parse.getHost().toLowerCase());
    }

    public static boolean isTBAntiFakeCode(int i, MaType maType) {
        return i == 1 && maType == MaType.TB_ANTI_FAKE;
    }
}
