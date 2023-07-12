package com.alipay.mobile.mascanengine.impl;

import android.graphics.Rect;
import com.alipay.ma.MaLogger;
import com.alipay.ma.common.result.ResultMaType;
import com.alipay.ma.decode.DecodeResult;
import com.alipay.mobile.mascanengine.MaScanResult;
import com.alipay.mobile.mascanengine.MaScanType;
import com.alipay.mobile.mascanengine.MultiMaScanResult;
import java.util.ArrayList;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class MaScanResultUtils {
    public static final String TAG = "MaScanResultUtils";

    public static MaScanResult fromMaResult(DecodeResult decodeResult) {
        if (decodeResult == null) {
            return null;
        }
        MaScanResult maScanResult = new MaScanResult();
        maScanResult.rawData = decodeResult.bytes;
        maScanResult.text = decodeResult.strCode;
        ResultMaType resultMaType = decodeResult.resultMaType;
        if (resultMaType == null) {
            return null;
        }
        maScanResult.type = MaScanType.getType(resultMaType);
        maScanResult.ecLevel = decodeResult.ecLevel;
        maScanResult.bitErrors = decodeResult.bitErrors;
        maScanResult.version = decodeResult.version;
        maScanResult.strategy = decodeResult.strategy;
        maScanResult.charset = decodeResult.encodeCharset;
        maScanResult.errPercent = decodeResult.errPercent;
        maScanResult.codeProportion = decodeResult.codeProportion;
        maScanResult.qrSize = decodeResult.qrSize;
        MaLogger.d(TAG, "fromMaResult(" + decodeResult + "),type=" + maScanResult.type);
        MaScanType maScanType = maScanResult.type;
        if (maScanType == MaScanType.QR || maScanType == MaScanType.PRODUCT || maScanType == MaScanType.EXPRESS || maScanType == MaScanType.DM || maScanType == MaScanType.PDF417 || maScanType == MaScanType.HMCODE) {
            int i = decodeResult.x;
            int i2 = decodeResult.y;
            maScanResult.rect = new Rect(i, i2, decodeResult.width + i, decodeResult.height + i2);
        }
        if (maScanResult.type == MaScanType.HMCODE) {
            maScanResult.typeName = decodeResult.typeName;
        }
        return maScanResult;
    }

    public static MultiMaScanResult fromMaResults(DecodeResult[] decodeResultArr, Map map) {
        if (decodeResultArr == null) {
            return null;
        }
        MultiMaScanResult multiMaScanResult = new MultiMaScanResult();
        if (map != null) {
            try {
                Object obj = map.get("wholeRealTimeCost");
                if (obj != null) {
                    multiMaScanResult.totalEngineTime = new String((byte[]) obj);
                }
                Object obj2 = map.get("lastHasCodeDuration");
                if (obj2 != null) {
                    multiMaScanResult.totalScanTime = new String((byte[]) obj2);
                }
                Object obj3 = map.get("wholeThreadTime");
                if (obj3 != null) {
                    multiMaScanResult.totalEngineCpuTime = new String((byte[]) obj3);
                }
            } catch (Exception unused) {
                MaLogger.e(TAG, "composeResultFail");
            }
        }
        ArrayList arrayList = new ArrayList();
        for (DecodeResult decodeResult : decodeResultArr) {
            MaScanResult fromMaResult = fromMaResult(decodeResult);
            fromMaResult.totalEngineTime = multiMaScanResult.totalEngineTime;
            fromMaResult.totalScanTime = multiMaScanResult.totalScanTime;
            fromMaResult.totalEngineCpuTime = multiMaScanResult.totalEngineCpuTime;
            if (fromMaResult.rect != null) {
                arrayList.add(fromMaResult);
            }
        }
        if (arrayList.isEmpty()) {
            arrayList.add(fromMaResult(decodeResultArr[0]));
        }
        try {
            multiMaScanResult.maScanResults = (MaScanResult[]) arrayList.toArray(new MaScanResult[arrayList.size()]);
            return multiMaScanResult;
        } catch (ClassCastException e) {
            MaLogger.e(TAG, e.getMessage());
            return null;
        }
    }
}
