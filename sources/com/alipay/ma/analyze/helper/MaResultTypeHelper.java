package com.alipay.ma.analyze.helper;

import android.net.Uri;
import android.text.TextUtils;
import com.alipay.ma.common.result.ResultMaType;
import com.alipay.ma.decode.DecodeResult;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class MaResultTypeHelper {
    private static boolean a(String str) {
        return !TextUtils.isEmpty(str) && ((str.startsWith("8") && str.length() == 20) || ((str.startsWith("10") || str.startsWith("11")) && str.length() == 16));
    }

    private static boolean b(String str) {
        Uri parse;
        return (TextUtils.isEmpty(str) || (parse = Uri.parse(str)) == null || TextUtils.isEmpty(parse.getHost()) || !TextUtils.equals("s.tb.cn", parse.getHost().toLowerCase())) ? false : true;
    }

    public static ResultMaType getMaType(DecodeResult decodeResult) {
        int i = decodeResult.type;
        if (i != 0) {
            if (i == 1) {
                if (b(decodeResult.strCode)) {
                    return ResultMaType.TB_ANTI_FAKE;
                }
                return ResultMaType.QR;
            } else if (i == 2) {
                if (a(decodeResult.strCode)) {
                    return ResultMaType.MEDICINE;
                }
                return ResultMaType.EXPRESS;
            } else if (i != 1024) {
                if (i != 2048) {
                    if (i == 65536) {
                        if (isARCode(i, decodeResult.subType)) {
                            return ResultMaType.ARCODE;
                        }
                        return null;
                    } else if (i != 131072) {
                        if (i != 262144) {
                            return null;
                        }
                        return ResultMaType.HMCODE;
                    } else {
                        return ResultMaType.NARROW;
                    }
                }
                return ResultMaType.PDF417;
            } else {
                return ResultMaType.DM;
            }
        }
        return ResultMaType.PRODUCT;
    }

    public static boolean isARCode(int i, int i2) {
        ResultMaType resultMaType = ResultMaType.ARCODE;
        return i == resultMaType.getType() && i2 == resultMaType.getDiscernType();
    }
}
