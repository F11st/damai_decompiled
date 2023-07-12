package com.taobao.ma.encode.api;

import android.graphics.Bitmap;
import com.taobao.ma.common.log.MaLogger;
import com.taobao.ma.decode.MaDecode;
import com.taobao.ma.encode.InputParameters.MaEncodeInputParameters;
import com.taobao.ma.encode.MaGenerator;
import com.youku.upsplayer.util.YKUpsConvert;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class MaEncodeAPI {
    @Deprecated
    public static Bitmap encodeMa(String str, Bitmap bitmap, int i) {
        return MaDecode.encode(str, bitmap, i, YKUpsConvert.CHAR_ZERO);
    }

    public static Bitmap encodeMa2(MaEncodeInputParameters maEncodeInputParameters) {
        MaLogger.v("encodeMa2");
        return MaGenerator.facade(maEncodeInputParameters);
    }
}
