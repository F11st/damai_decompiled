package com.taobao.ma.analyze.api;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.YuvImage;
import android.hardware.Camera;
import com.taobao.ma.analyze.helper.MaAnalyzeHelper;
import com.taobao.ma.common.log.MaLogger;
import com.taobao.ma.common.result.MaResult;
import com.taobao.ma.common.result.MaType;
import com.taobao.ma.common.result.MaWapperResult;
import com.taobao.ma.common.usertrack.UTLogger;
import com.taobao.ma.decode.DecodeResult;
import com.taobao.ma.decode.MaDecode;
import com.taobao.ma.handler.MaHandler;
import com.taobao.ma.parser.MaParSer;
import com.taobao.ma.util.StringUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class MaAnalyzeAPI {
    private static MaHandler mHandler;
    private static List<MaParSer> mParsers = new ArrayList();
    private static List<MaResult> mResults = new ArrayList();
    private static String[] whiteList = {"http://s.tb.cn", "https://s.tb.cn", "HTTP://S.TB.CN", "HTTPS://S.TB.CN"};

    private static Rect buildDefaultDecodeRegion(int i, int i2) {
        int abs = Math.abs((i - i2) / 2);
        int min = (Math.min(i, i2) / 8) * 8;
        return new Rect(abs, 0, abs + min, min + 0);
    }

    public static MaResult decode(Bitmap bitmap, MaType... maTypeArr) {
        ArrayList arrayList = new ArrayList();
        int i = 0;
        for (int i2 = 0; i2 < maTypeArr.length; i2++) {
            if (!arrayList.contains(Integer.valueOf(maTypeArr[i2].getDiscernType()))) {
                arrayList.add(Integer.valueOf(maTypeArr[i2].getDiscernType()));
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            i |= ((Integer) it.next()).intValue();
        }
        DecodeResult codeDecodePictureWithQr = MaDecode.codeDecodePictureWithQr(bitmap, i);
        if (codeDecodePictureWithQr != null) {
            return new MaResult(MaType.QR, codeDecodePictureWithQr.strCode);
        }
        return null;
    }

    public static void registerHandler(MaHandler maHandler) {
        if (mHandler == null) {
            mHandler = maHandler;
        }
    }

    public static void registerResultParser(MaParSer maParSer) {
        mParsers.add(maParSer);
    }

    public static void removeAllResultParser() {
        mParsers.clear();
    }

    private static MaWapperResult wapperResult(DecodeResult decodeResult) {
        MaWapperResult maWapperResult = new MaWapperResult();
        maWapperResult.type = decodeResult.type;
        maWapperResult.subType = decodeResult.subType;
        maWapperResult.strCode = decodeResult.strCode;
        maWapperResult.decodeBytes = decodeResult.decodeBytes;
        maWapperResult.hiddenData = decodeResult.hiddenData;
        maWapperResult.x = decodeResult.x;
        maWapperResult.y = decodeResult.y;
        maWapperResult.width = decodeResult.width;
        maWapperResult.height = decodeResult.height;
        maWapperResult.xCorner = decodeResult.xCorner;
        maWapperResult.yCorner = decodeResult.yCorner;
        return maWapperResult;
    }

    public static void registerResultParser(List<MaParSer> list) {
        mParsers.addAll(list);
    }

    public static MaResult decode(YuvImage yuvImage, Rect rect) {
        MaType[] maTypeArr = new MaType[MaType.values().length];
        int i = 0;
        for (MaType maType : MaType.values()) {
            maTypeArr[i] = maType;
            i++;
        }
        return decode(yuvImage, rect, maTypeArr);
    }

    public static MaResult decode(YuvImage yuvImage, Rect rect, MaType... maTypeArr) {
        if (yuvImage == null) {
            return null;
        }
        if (rect == null) {
            rect = buildDefaultDecodeRegion(yuvImage.getWidth(), yuvImage.getHeight());
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < maTypeArr.length; i++) {
            if (!arrayList.contains(Integer.valueOf(maTypeArr[i].getDiscernType()))) {
                arrayList.add(Integer.valueOf(maTypeArr[i].getDiscernType()));
            }
        }
        Iterator it = arrayList.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            i2 |= ((Integer) it.next()).intValue();
        }
        DecodeResult yuvcodeDecode = MaDecode.yuvcodeDecode(yuvImage, rect, i2, "", whiteList);
        if (yuvcodeDecode == null || StringUtils.isEmpty(yuvcodeDecode.strCode)) {
            return null;
        }
        MaLogger.i(yuvcodeDecode.toString());
        MaWapperResult wapperResult = wapperResult(yuvcodeDecode);
        MaType maType = MaAnalyzeHelper.getMaType(wapperResult);
        wapperResult.maType = maType;
        if (Arrays.asList(maTypeArr).contains(maType)) {
            if (mParsers.size() == 0) {
                MaLogger.e("Do not add parser");
                return null;
            }
            if (mParsers.size() > 0) {
                mResults.clear();
                for (MaParSer maParSer : mParsers) {
                    mResults.add(maParSer.decode(wapperResult));
                }
            }
            mParsers.clear();
            mResults.removeAll(Collections.singleton(null));
            if (mResults.size() == 0) {
                return null;
            }
            MaResult maResult = mResults.get(0);
            UTLogger.userTrack(maResult);
            return maResult;
        }
        return null;
    }

    public static MaResult decode(byte[] bArr, Camera camera) {
        return mHandler.decode(bArr, camera);
    }

    public static MaResult decode(String str, int i) {
        MaResult maResult = null;
        if (StringUtils.isEmpty(str)) {
            return null;
        }
        DecodeResult codeDecodePictureWithQr = MaDecode.codeDecodePictureWithQr(str, i);
        if (codeDecodePictureWithQr != null && !StringUtils.isEmpty(codeDecodePictureWithQr.strCode)) {
            if (codeDecodePictureWithQr.type == 1) {
                if (codeDecodePictureWithQr.subType == 32768) {
                    return new MaResult(MaType.GEN3, codeDecodePictureWithQr.strCode);
                }
                maResult = new MaResult(MaType.QR, codeDecodePictureWithQr.strCode);
            }
            UTLogger.userTrack(maResult);
        }
        return maResult;
    }

    public static MaResult decode(String str) {
        return decode(str, 512);
    }
}
