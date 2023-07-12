package com.alipay.mobile.mascanengine;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Rect;
import android.hardware.Camera;
import android.os.SystemClock;
import android.text.TextUtils;
import com.alibaba.security.biometrics.service.constants.GlobalErrorCode;
import com.alipay.ma.EngineType;
import com.alipay.ma.MaBuryRecord;
import com.alipay.ma.MaLogger;
import com.alipay.ma.analyze.api.MaEngineAPI;
import com.alipay.ma.analyze.helper.MaResultTypeHelper;
import com.alipay.ma.decode.DecodeResult;
import com.alipay.ma.decode.MaDecode;
import com.alipay.ma.statistics.classification.BlurSVC;
import com.alipay.ma.statistics.classification.BlurSVM;
import com.alipay.mobile.binarize.RSMaEngineAPI;
import com.alipay.mobile.bqcscanservice.BQCCameraParam;
import com.alipay.mobile.bqcscanservice.BQCScanEngine;
import com.alipay.mobile.bqcscanservice.BQCScanResult;
import com.alipay.mobile.bqcscanservice.Constants;
import com.alipay.mobile.bqcscanservice.MPaasLogger;
import com.alipay.mobile.mascanengine.MultiMaScanResult;
import com.alipay.mobile.mascanengine.impl.MaPictureEngineServiceImpl;
import com.alipay.mobile.mascanengine.impl.MaScanResultUtils;
import com.autonavi.base.amap.mapcore.tools.GLMapStaticValue;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class MaEngineService extends BQCScanEngine {
    public static final String KEY_CALLBACK_PACE_SECOND = "callback_pace_second";
    public static final String KEY_ENGINE_PERF = "key_engine_perf";
    public static Map<Integer, Integer> SDK_STEP_NUMBER = null;
    public static final String TAG = "MaEngineService";
    private static long s = 200;
    public static boolean statisticsPerfData = false;
    private static long t = 200;
    protected static long u;
    protected long a;
    protected long b;
    private long c;
    protected float e;
    protected MaEngineAPI f;
    protected float g;
    protected float h;
    protected boolean i;
    protected boolean j;
    protected long l;
    protected boolean n;
    protected Map<String, String> q;
    private boolean r;
    protected MaScanCallback d = null;
    protected BlurSVM k = new BlurSVM();
    Map<String, Object> m = new HashMap();
    protected Point o = new Point();
    private int p = 0;

    static {
        HashMap hashMap = new HashMap();
        SDK_STEP_NUMBER = hashMap;
        hashMap.put(1000, 1);
        SDK_STEP_NUMBER.put(1002, 2);
        SDK_STEP_NUMBER.put(2001, 3);
        SDK_STEP_NUMBER.put(2002, 4);
        SDK_STEP_NUMBER.put(2020, 5);
        SDK_STEP_NUMBER.put(2030, 6);
        SDK_STEP_NUMBER.put(2040, 7);
        SDK_STEP_NUMBER.put(2050, 8);
        SDK_STEP_NUMBER.put(Integer.valueOf((int) GLMapStaticValue.MAP_PARAMETERNAME_POLYGON_FILL_CONTROL), 9);
        SDK_STEP_NUMBER.put(Integer.valueOf((int) GLMapStaticValue.AM_PARAMETERNAME_TEXT_GL_UNIT), 10);
        SDK_STEP_NUMBER.put(2060, 11);
        SDK_STEP_NUMBER.put(3001, 12);
        SDK_STEP_NUMBER.put(Integer.valueOf((int) GlobalErrorCode.ERROR_SERVER_CODE_3101), 13);
        SDK_STEP_NUMBER.put(Integer.valueOf((int) GlobalErrorCode.ERROR_SERVER_CODE_3102), 14);
        SDK_STEP_NUMBER.put(3200, 15);
        SDK_STEP_NUMBER.put(3404, 16);
    }

    private void c(MultiMaScanResult multiMaScanResult, MaEngineAPI maEngineAPI) {
        if (multiMaScanResult == null || maEngineAPI == null || !(maEngineAPI instanceof RSMaEngineAPI)) {
            return;
        }
        RSMaEngineAPI rSMaEngineAPI = (RSMaEngineAPI) maEngineAPI;
        multiMaScanResult.rsInitTime = rSMaEngineAPI.rsInitCost;
        multiMaScanResult.rsBinarized = rSMaEngineAPI.rsBinarized;
        multiMaScanResult.rsBinarizedCount = rSMaEngineAPI.rsBinarizedCount;
        int i = rSMaEngineAPI.classicFrameCount;
        multiMaScanResult.classicFrameCount = i;
        multiMaScanResult.frameCount = rSMaEngineAPI.rsFrameCount + i;
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:34:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int d(java.lang.String r8) {
        /*
            r7 = this;
            r0 = 0
            if (r8 != 0) goto L4
            return r0
        L4:
            org.json.JSONArray r1 = new org.json.JSONArray     // Catch: java.lang.Exception -> L2e
            r1.<init>(r8)     // Catch: java.lang.Exception -> L2e
            r2 = 0
            r3 = 0
        Lb:
            int r4 = r1.length()     // Catch: java.lang.Exception -> L2c
            if (r2 >= r4) goto L46
            org.json.JSONArray r4 = r1.getJSONArray(r2)     // Catch: java.lang.Exception -> L2c
            int r5 = r4.length()     // Catch: java.lang.Exception -> L2c
            r6 = 2
            if (r5 >= r6) goto L1d
            goto L29
        L1d:
            r5 = 1
            java.lang.String r4 = r4.getString(r5)     // Catch: java.lang.Exception -> L2c
            int r4 = java.lang.Integer.parseInt(r4)     // Catch: java.lang.Exception -> L2c
            if (r4 <= r3) goto L29
            r3 = r4
        L29:
            int r2 = r2 + 1
            goto Lb
        L2c:
            r1 = move-exception
            goto L30
        L2e:
            r1 = move-exception
            r3 = 0
        L30:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r4 = "getRecognizeStage: "
            r2.append(r4)
            r2.append(r8)
            java.lang.String r8 = r2.toString()
            java.lang.String r2 = "MaEngineService"
            com.alipay.ma.MaLogger.e(r2, r8, r1)
        L46:
            java.util.Map<java.lang.Integer, java.lang.Integer> r8 = com.alipay.mobile.mascanengine.MaEngineService.SDK_STEP_NUMBER
            java.lang.Integer r1 = java.lang.Integer.valueOf(r3)
            java.lang.Object r8 = r8.get(r1)
            java.lang.Integer r8 = (java.lang.Integer) r8
            if (r8 != 0) goto L55
            goto L59
        L55:
            int r0 = r8.intValue()
        L59:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.mobile.mascanengine.MaEngineService.d(java.lang.String):int");
    }

    protected MultiMaScanResult a(byte[] bArr, Rect rect, Point point, int i, int i2) {
        String str;
        int i3;
        float f;
        MaScanCallback maScanCallback;
        Map frameReadInfoJ;
        int i4;
        if (this.r) {
            MaLogger.d(TAG, "MaEngineService.doProcess(api2)");
            this.r = false;
        }
        this.i = false;
        this.j = false;
        if (this.c <= 0) {
            this.c = SystemClock.elapsedRealtime();
        }
        float floatValue = (this.m.containsKey(Constants.EXT_INFO_KEY_ZOOM) && (this.m.get(Constants.EXT_INFO_KEY_ZOOM) instanceof Float)) ? ((Float) this.m.get(Constants.EXT_INFO_KEY_ZOOM)).floatValue() : 1.0f;
        MaEngineAPI maEngineAPI = this.f;
        DecodeResult[] doProcess = maEngineAPI != null ? maEngineAPI.doProcess(bArr, rect, point, i, i2, false, -1, floatValue) : null;
        if (this.n && (maScanCallback = this.d) != null && (maScanCallback instanceof IOnMaSDKDecodeInfo) && (frameReadInfoJ = MaDecode.getFrameReadInfoJ()) != null) {
            Object obj = frameReadInfoJ.get(MaDecode.FRAME_READ_INFO_READ_STEPS);
            if (obj instanceof byte[]) {
                String str2 = new String((byte[]) obj);
                MPaasLogger.d(TAG, new Object[]{str2});
                i4 = d(str2);
            } else {
                i4 = 0;
            }
            MPaasLogger.d(TAG, new Object[]{"stage is ", Integer.valueOf(i4)});
            ((IOnMaSDKDecodeInfo) this.d).onGetRecognizeStage(i4);
        }
        long elapsedRealtime = SystemClock.elapsedRealtime();
        MaScanCallback maScanCallback2 = this.d;
        if (maScanCallback2 != null && doProcess == null && elapsedRealtime - this.c >= s) {
            if (maScanCallback2 != null && (maScanCallback2 instanceof IOnMaSDKDecodeInfo)) {
                if (elapsedRealtime - this.b > u) {
                    this.b = elapsedRealtime;
                    MaEngineAPI maEngineAPI2 = this.f;
                    float f2 = -1.0f;
                    if (maEngineAPI2 != null) {
                        f2 = maEngineAPI2.getMaProportion();
                        i3 = this.f.getMaProportionSource();
                        f = this.f.getMaLimitFactor();
                    } else {
                        i3 = -1;
                        f = -1.0f;
                    }
                    if (MaLogger.isDebuggable()) {
                        MaLogger.d(TAG, " qrAreaProportion=" + f2 + ", factor=" + f);
                    }
                    if (f > 1.0f) {
                        try {
                            ((IOnMaSDKDecodeInfo) this.d).onGetMaProportionAndSource(f, i3);
                        } catch (Throwable th) {
                            MaLogger.e(TAG, "onGetQRAreaProportion: " + th.getMessage());
                        }
                    }
                }
                long j = this.a;
                long j2 = t;
                if (elapsedRealtime - j > j2) {
                    if (j == 0) {
                        this.l = j2;
                    } else {
                        this.l = elapsedRealtime - j;
                    }
                    this.a = elapsedRealtime;
                    MaEngineAPI maEngineAPI3 = this.f;
                    int avgGray = maEngineAPI3 != null ? maEngineAPI3.getAvgGray() : -1;
                    if (MaLogger.isDebuggable()) {
                        str = TAG;
                        MaLogger.d(str, "avgGray: " + avgGray);
                    } else {
                        str = TAG;
                    }
                    if (avgGray >= 0) {
                        try {
                            ((IOnMaSDKDecodeInfo) this.d).onGetAvgGray(avgGray);
                        } catch (Throwable th2) {
                            MaLogger.e(str, "onGetAvgGray: " + th2.getMessage());
                        }
                    }
                    if (BlurSVC.getEnableBlur()) {
                        Map imageInfoJ = MaDecode.getImageInfoJ(new byte[0], 0, 0, 0, 0, 0, 0, 0);
                        if (imageInfoJ != null) {
                            try {
                                if (BlurSVM.getEnableBlur()) {
                                    Object obj2 = imageInfoJ.get("imageInfoLaplaceMean");
                                    Object obj3 = imageInfoJ.get("imageInfoLaplaceStd");
                                    Object obj4 = imageInfoJ.get("imageInfoLaplaceTime");
                                    Object obj5 = imageInfoJ.get("imageInfoMaxGrayRatio");
                                    if (obj2 != null && obj3 != null && obj4 != null) {
                                        float parseFloat = Float.parseFloat(new String((byte[]) obj2));
                                        float parseFloat2 = Float.parseFloat(new String((byte[]) obj3));
                                        float parseFloat3 = Float.parseFloat(new String((byte[]) obj4));
                                        float parseFloat4 = Float.parseFloat(new String((byte[]) obj5));
                                        if (parseFloat3 > 0.0f) {
                                            this.j = this.k.checkBlur(parseFloat, parseFloat2, parseFloat3, parseFloat4, this.l);
                                        }
                                    }
                                    if (this.d != null) {
                                        ((IOnMaSDKDecodeInfo) this.d).onGetWhetherFrameBlurSVM(this.j, getDurationOfBlur(), getDurationOfNonNeedCheckBlur());
                                    }
                                }
                            } catch (Exception e) {
                                MaLogger.e(str, "getImageInfoException: " + e.toString());
                            }
                        }
                        if (MaLogger.isDebuggable()) {
                            MaLogger.d(str, "BlurCheck: whetherBlur=" + this.i + ", localStd=" + this.g + ", globalStd=" + this.h);
                        }
                    }
                }
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append("maCallback is null ? ");
                sb.append(this.d == null);
                sb.append(", (curTimestamp - lastTimestamp) = ");
                sb.append(elapsedRealtime - this.a);
                MaLogger.d(TAG, sb.toString());
            }
        } else {
            MaLogger.d(TAG, "Not Reach The Threshold");
        }
        if (doProcess != null && this.q == null) {
            this.q = MaDecode.getDecodeInfoJ();
        }
        MultiMaScanResult fromMaResults = MaScanResultUtils.fromMaResults(doProcess, this.q);
        if (fromMaResults != null) {
            c(fromMaResults, this.f);
            fromMaResults.readerParams = MaDecode.getReaderParamsJ();
        }
        return fromMaResults;
    }

    protected MultiMaScanResult b(byte[] bArr, Camera camera, Rect rect, Camera.Size size, int i) {
        if (this.r) {
            MaLogger.d(TAG, "MaEngineService.doProcess(api1)");
            this.r = false;
        }
        if (camera == null) {
            MaLogger.d(TAG, "doProcess mCamera == null");
            MaBuryRecord.reportUnusualScanCase(2, "mCamera is null");
            return null;
        }
        if (size == null || i < 0) {
            size = camera.getParameters().getPreviewSize();
        }
        if (size == null) {
            return null;
        }
        Point point = this.o;
        int i2 = size.width;
        point.x = i2;
        point.y = size.height;
        return a(bArr, rect, point, i2, i);
    }

    @Override // com.alipay.mobile.bqcscanservice.BQCScanEngine
    public void destroy() {
        this.d = null;
        MaEngineAPI maEngineAPI = this.f;
        if (maEngineAPI != null) {
            maEngineAPI.destroy();
        }
    }

    protected List<String> e(BQCScanResult bQCScanResult) {
        MaScanResult[] maScanResultArr;
        ArrayList arrayList = null;
        if ((bQCScanResult instanceof MultiMaScanResult) && bQCScanResult != null && (maScanResultArr = ((MultiMaScanResult) bQCScanResult).maScanResults) != null && maScanResultArr.length > 0) {
            for (MaScanResult maScanResult : maScanResultArr) {
                String str = maScanResult.text;
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                if (!TextUtils.isEmpty(str)) {
                    arrayList.add(maScanResult.text);
                }
            }
        }
        return arrayList;
    }

    @Override // com.alipay.mobile.bqcscanservice.BQCScanEngine
    public float getCodeSize() {
        return this.e;
    }

    public Class<? extends BQCScanEngine> getEngineClazz() {
        return MaEngineService.class;
    }

    @Override // com.alipay.mobile.bqcscanservice.BQCScanEngine
    public boolean init(Context context, Map<String, Object> map) {
        if (this.f == null) {
            this.f = new RSMaEngineAPI();
        }
        MaEngineAPI maEngineAPI = this.f;
        if (maEngineAPI != null) {
            maEngineAPI.init(context, map);
        }
        this.r = true;
        return true;
    }

    @Override // com.alipay.mobile.bqcscanservice.BQCScanEngine
    public boolean isQrCodeEngine() {
        return true;
    }

    @Override // com.alipay.mobile.bqcscanservice.BQCScanEngine
    public boolean onProcessFinish(BQCScanResult bQCScanResult) {
        MaScanCallback maScanCallback;
        if (bQCScanResult != null && (maScanCallback = this.d) != null && maScanCallback.onMaCodeInterceptor(e(bQCScanResult))) {
            MaLogger.d(TAG, "scan ma code is intercepted,result=" + bQCScanResult);
            return false;
        } else if (bQCScanResult == null || this.d == null || !(bQCScanResult instanceof MultiMaScanResult)) {
            return false;
        } else {
            MaLogger.d(TAG, "The macallback is " + this.d);
            MaScanCallback maScanCallback2 = this.d;
            if (maScanCallback2 != null) {
                maScanCallback2.onResultMa((MultiMaScanResult) bQCScanResult);
                return true;
            }
            return true;
        }
    }

    @Override // com.alipay.mobile.bqcscanservice.BQCScanEngine
    public BQCScanResult process(Bitmap bitmap) {
        if (bitmap == null || bitmap.isRecycled()) {
            return null;
        }
        this.p++;
        MaDecode.enableFastBitmapDecodeJ();
        DecodeResult[] codeDecodePictureWithQr = MaDecode.codeDecodePictureWithQr(bitmap, MaPictureEngineServiceImpl.PICTURE_RECOG_TYPE, false);
        if (codeDecodePictureWithQr == null) {
            return null;
        }
        for (int i = 0; i < codeDecodePictureWithQr.length; i++) {
            codeDecodePictureWithQr[i].resultMaType = MaResultTypeHelper.getMaType(codeDecodePictureWithQr[i]);
        }
        MultiMaScanResult fromMaResults = MaScanResultUtils.fromMaResults(codeDecodePictureWithQr, null);
        fromMaResults.frameType = MultiMaScanResult.ScanFrameType.FRAME_TYPE_VIEW;
        fromMaResults.frameCount = this.p;
        return fromMaResults;
    }

    @Override // com.alipay.mobile.bqcscanservice.BQCScanEngine
    public void setEngineMemoryDownGrade() {
        MaDecode.needDownGradeSdkMemoryAllocateJ();
    }

    @Override // com.alipay.mobile.bqcscanservice.BQCScanEngine
    public void setExtInfo(String str, Object obj) {
        this.m.put(str, obj);
    }

    @Override // com.alipay.mobile.bqcscanservice.BQCScanEngine
    public void setResultCallback(BQCScanEngine.EngineCallback engineCallback) {
        if (engineCallback == null || !(engineCallback instanceof MaScanCallback)) {
            return;
        }
        MaLogger.d(TAG, "setResultCallback(): " + engineCallback);
        this.d = (MaScanCallback) engineCallback;
    }

    @Override // com.alipay.mobile.bqcscanservice.BQCScanEngine
    public void setSubScanType(BQCCameraParam.MaEngineType maEngineType) {
        setSubScanType(maEngineType, null);
    }

    @Override // com.alipay.mobile.bqcscanservice.BQCScanEngine
    public void start() {
        this.a = 0L;
        this.b = 0L;
        this.c = 0L;
        this.p = 0;
        this.m.clear();
    }

    @Override // com.alipay.mobile.bqcscanservice.BQCScanEngine
    public void setSubScanType(BQCCameraParam.MaEngineType maEngineType, String str) {
        MaEngineAPI maEngineAPI = this.f;
        if (maEngineAPI != null) {
            if (maEngineType != null) {
                maEngineAPI.setSubScanType(EngineType.getType(maEngineType.getType()), str);
            } else if (maEngineType == null && str != null) {
                maEngineAPI.setSubScanType(null, str);
            } else {
                maEngineAPI.setSubScanType(EngineType.getType(BQCCameraParam.MaEngineType.DEFAULT.getType()), null);
            }
        }
    }

    @Override // com.alipay.mobile.bqcscanservice.BQCScanEngine
    public BQCScanResult process(byte[] bArr, Camera camera, Rect rect, Camera.Size size, int i) {
        return b(bArr, camera, rect, size, i);
    }

    @Override // com.alipay.mobile.bqcscanservice.BQCScanEngine
    public BQCScanResult process(byte[] bArr, Rect rect, Point point, int i, int i2) {
        return a(bArr, rect, point, i, i2);
    }
}
