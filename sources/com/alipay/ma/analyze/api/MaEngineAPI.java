package com.alipay.ma.analyze.api;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.hardware.Camera;
import com.alipay.ma.EngineType;
import com.alipay.ma.MaBuryRecord;
import com.alipay.ma.MaLogger;
import com.alipay.ma.decode.DecodeResult;
import com.alipay.ma.decode.DecodeType;
import com.alipay.ma.decode.MaDecode;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class MaEngineAPI {
    public static final String TAG = "MaEngineAPI";
    public static boolean sEngineSoLoaded;
    protected EngineType a;
    protected String b;
    protected int c;
    private DecodeType d;

    /* JADX INFO: Access modifiers changed from: protected */
    public int a() {
        return MaDecode.getLastFrameAverageGray();
    }

    public void destroy() {
        this.d = null;
        MaDecode.decodeUnInit();
    }

    public DecodeResult[] doProcess(byte[] bArr, Camera camera, Rect rect, Camera.Size size, int i, boolean z, int i2, float f) {
        if (bArr == null) {
            MaLogger.d(TAG, "doProcess mData == null");
            MaBuryRecord.reportUnusualScanCase(1, "mData is null");
            return null;
        } else if (camera == null) {
            MaLogger.d(TAG, "doProcess mCamera == null");
            MaBuryRecord.reportUnusualScanCase(2, "mCamera is null");
            return null;
        } else {
            Camera.Size previewSize = (size == null || i < 0) ? camera.getParameters().getPreviewSize() : size;
            if (previewSize == null) {
                return null;
            }
            return doProcess(bArr, rect, new Point(previewSize.width, previewSize.height), i, z, i2, f);
        }
    }

    public int getAvgGray() {
        return this.c;
    }

    public float getMaLimitFactor() {
        return MaDecode.getLimitZoomFactorJ();
    }

    public float getMaProportion() {
        return MaDecode.getMaProportionJ();
    }

    public int getMaProportionSource() {
        return MaDecode.getMaProportionSourceJ();
    }

    public boolean init(Context context, Map<String, Object> map) {
        MaDecode.decodeInit();
        if (map != null) {
            for (String str : map.keySet()) {
                Object obj = map.get(str);
                if (obj != null) {
                    MaDecode.setReaderParamsJ(str, obj.toString().toUpperCase());
                }
            }
        }
        this.d = null;
        return true;
    }

    public void resetRecognizeResults() {
    }

    public void setSubScanType(EngineType engineType) {
        this.a = engineType;
        this.b = null;
    }

    public boolean useRsBinary() {
        return false;
    }

    public void setSubScanType(EngineType engineType, String str) {
        this.a = engineType;
        this.b = str;
    }

    public DecodeResult[] doProcess(byte[] bArr, Rect rect, Point point, int i, boolean z, int i2, float f) {
        if (point == null) {
            return null;
        }
        return doProcess(bArr, rect, point, com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(point), i, z, i2, f);
    }

    public DecodeResult[] doProcess(byte[] bArr, Rect rect, Point point, int i, int i2, boolean z, int i3, float f) {
        Rect rect2;
        DecodeType decodeType;
        DecodeResult[] decodeScanMode;
        DecodeResult[] decodeResultArr = null;
        if (bArr == null) {
            MaLogger.d(TAG, "doProcess mData == null");
            MaBuryRecord.reportUnusualScanCase(1, "mData is null");
            return null;
        }
        if (rect != null) {
            if (rect.left < 0) {
                rect.left = 0;
            }
            if (rect.top < 0) {
                rect.top = 0;
            }
            int i4 = rect.right;
            int xVar = com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(point);
            if (i4 > xVar) {
                rect.right = xVar;
            }
            int i5 = rect.bottom;
            int yVar = com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(point);
            if (i5 > yVar) {
                rect.bottom = yVar;
            }
            rect2 = rect;
        } else {
            rect2 = null;
        }
        if (rect2 == null) {
            MaBuryRecord.reportUnusualScanCase(3, "scanRect is null");
            MaLogger.d(TAG, "doProcess maResults = null");
        } else {
            EngineType engineType = this.a;
            if (engineType == EngineType.DEFAULT) {
                decodeType = DecodeType.DEFAULTCODE;
            } else if (engineType == EngineType.ALL) {
                decodeType = DecodeType.ALLCODE;
            } else if (engineType == EngineType.QRCODE) {
                decodeType = DecodeType.ALLQRCODE;
            } else if (engineType == EngineType.BAR) {
                decodeType = DecodeType.ALLBARCODE;
            } else if (engineType == EngineType.LOTTERY) {
                decodeType = DecodeType.ALLLOTTERYCODE;
            } else {
                decodeType = this.b == null ? DecodeType.DEFAULTCODE : null;
            }
            if (z) {
                decodeScanMode = MaAnalyzeAPI.decodeBinarizedData(bArr, com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(point), com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(point), rect2, i3, DecodeType.getCodeTypes(decodeType, this.b));
            } else {
                if (this.d == null) {
                    this.d = decodeType;
                    MaLogger.d(TAG, "doProcess: recognizeType=" + this.a + ", typeSet=" + this.b);
                }
                decodeScanMode = MaAnalyzeAPI.decodeScanMode(bArr, com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(point), com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(point), i, rect2, DecodeType.getCode(decodeType, this.b), f);
            }
            if (decodeScanMode != null) {
                if (decodeScanMode.length == 0) {
                    MaBuryRecord.reportUnusualScanCase(4, "maResults.length is 0");
                    MaLogger.d(TAG, "doProcess maResults.length == 0");
                } else {
                    MaLogger.d(TAG, "total get " + decodeScanMode.length + " codes");
                    for (DecodeResult decodeResult : decodeScanMode) {
                        MaLogger.d(TAG, decodeResult.toString());
                    }
                }
            }
            decodeResultArr = decodeScanMode;
        }
        if (decodeResultArr == null) {
            this.c = a();
        } else {
            this.c = -1;
        }
        return decodeResultArr;
    }
}
