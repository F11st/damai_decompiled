package com.alipay.ma.decode;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.YuvImage;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import com.alibaba.analytics.core.sync.UploadQueueMgr;
import com.alibaba.security.realidentity.jsbridge.AbstractC3893a;
import com.alipay.ma.MaBuryRecord;
import com.alipay.ma.MaLogger;
import com.alipay.ma.analyze.api.MaEngineAPI;
import com.alipay.ma.analyze.helper.MaResultTypeHelper;
import com.alipay.ma.common.result.ResultMaType;
import com.alipay.ma.strategies.MaInterceptOperation;
import com.alipay.ma.util.ImageTool;
import com.alipay.ma.util.StringEncodeUtils;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
import tb.C9796v;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class MaDecode {
    public static final String CAMERA2_UPLOAD_IMAGE = "camera2_upload_image";
    public static final String DIAGNOSE_SCAN_FOCUS = "diagnose_scan_focus";
    public static final String FRAME_READ_INFO_BINARIZE_ID = "BINARIZE_ID";
    public static final String FRAME_READ_INFO_FRAME_ID = "FRAME_ID";
    public static final String FRAME_READ_INFO_READ_STEPS = "READ_STEPS";
    public static final String IMAGE_INFO_BLOCK_MAX_STDDEV = "imageInfoBlockMaxStdDev";
    public static final String IMAGE_INFO_ENTROPY = "imageInfoEntropy";
    public static final String IMAGE_INFO_GLOBAL_STDDEV = "imageInfoGlobalStdDev";
    public static final String KEY_SCANNOTHINGDURATION = "scanNothingDuration";
    public static final int QR_PARTITION_SOURCE_TRADITION = 0;
    public static final int QR_PARTITION_SOURCE_XNN = 1;
    public static final String SCAN_STATISTICS_PERF = "scan_statistics_perf";
    public static final String SCAN_UPLOAD_IMAGE = "scan_upload_image";
    public static final String SO_NAME = "decode100198";
    public static final String TAG = "MaDecode";
    private static MaInterceptOperation a = null;
    private static boolean b = false;
    public static int decodeThreadTID = 0;
    public static boolean dynamicCodeDev = false;
    public static long firstFrameIn = -1;
    public static long frameEngineIn = -1;
    public static long sEngineSoLoadedTimestamp = 0;
    public static String sInitedReaderParams = null;
    public static String scanSourceId = "null";
    public static String scanUIType = "oldUI";

    static {
        init();
        b = false;
    }

    public static native int AISetup(String str, String str2, String str3, String str4, String str5);

    public static int AISetupJ(String str, String str2, String str3, String str4, String str5) {
        try {
            return AISetup(str, str2, str3, str4, str5);
        } catch (Throwable th) {
            MaLogger.e(TAG, "AISetupJ: ", th);
            return 0;
        }
    }

    public static native int AIUninstall();

    public static int AIUninstallJ() {
        try {
            return AIUninstall();
        } catch (Throwable th) {
            MaLogger.e(TAG, "AIUninstallJ: ", th);
            return 0;
        }
    }

    public static native long RegistDSLReader(String str, boolean z);

    public static synchronized long RegistDSLReaderJ(String str, boolean z) {
        long RegistDSLReader;
        synchronized (MaDecode.class) {
            try {
                RegistDSLReader = RegistDSLReader(str, z);
            } catch (Throwable th) {
                MaLogger.e(TAG, "RegistDSLReaderJ", th);
                return 0L;
            }
        }
        return RegistDSLReader;
    }

    public static native long UnRegistDSLReader(boolean z);

    public static synchronized long UnRegistDSLReaderJ(boolean z) {
        long UnRegistDSLReader;
        synchronized (MaDecode.class) {
            try {
                UnRegistDSLReader = UnRegistDSLReader(z);
            } catch (Throwable th) {
                MaLogger.e(TAG, "UnRegistDSLReaderJ", th);
                return 0L;
            }
        }
        return UnRegistDSLReader;
    }

    private static void a(String str) {
        try {
            StringBuilder sb = new StringBuilder(128);
            String name = Thread.currentThread().getName();
            sb.append("id=");
            sb.append(Process.myTid());
            sb.append("^name=");
            sb.append(name);
            sb.append("^");
            sb.append(str);
            if (MaLogger.isDebuggable()) {
                MaBuryRecord.reportNativeInterfaceResult(sb.toString());
            }
        } catch (Exception e) {
            MaLogger.e(TAG, "buryInformation: " + e.getMessage());
        }
    }

    private static DecodeResult b(DecodeResult decodeResult) {
        byte[] bArr;
        if (decodeResult == null || (bArr = decodeResult.bytes) == null || bArr.length <= 0) {
            return null;
        }
        try {
            long j = decodeResult.strLen;
            if (j > 0) {
                byte[] bArr2 = new byte[(int) j];
                System.arraycopy(bArr, 0, bArr2, 0, (int) j);
                String stringEncode = StringEncodeUtils.getStringEncode(bArr2, false);
                if (TextUtils.isEmpty(stringEncode)) {
                    decodeResult.strCode = new String(bArr2, "utf-8");
                    decodeResult.encodeCharset = "utf-8";
                } else {
                    decodeResult.strCode = new String(bArr2, stringEncode);
                    decodeResult.encodeCharset = stringEncode;
                    if (TextUtils.equals(stringEncode, StringEncodeUtils.UTF8) && decodeResult.strCode.charAt(0) == 65279) {
                        decodeResult.strCode = decodeResult.strCode.substring(1);
                    }
                }
                if (TextUtils.isEmpty(decodeResult.strCode)) {
                    decodeResult = null;
                }
            } else if (j == 0) {
                if (MaResultTypeHelper.getMaType(decodeResult) == ResultMaType.QR) {
                    decodeResult.strCode = "null";
                    decodeResult.encodeCharset = null;
                }
                MaBuryRecord.recodeDecodeFailedMaInfo(MaResultTypeHelper.getMaType(decodeResult) != null ? MaResultTypeHelper.getMaType(decodeResult).name() : null);
            }
            return decodeResult;
        } catch (UnsupportedEncodingException | Exception unused) {
            return null;
        }
    }

    private static native DecodeResult[] bitmapDecode(Bitmap bitmap, int i, int i2, boolean z);

    public static synchronized DecodeResult[] bitmapDecodeJ(Bitmap bitmap, int i, int i2, boolean z, MaInterceptOperation maInterceptOperation) {
        DecodeResult[] bitmapDecode;
        synchronized (MaDecode.class) {
            MaLogger.d(TAG, "bitmap_scan_opt()");
            Log.i(TAG, "bitmap_scan_opt bitmapDecodeJ start");
            a = maInterceptOperation;
            bitmapDecode = bitmapDecode(bitmap, i, i2, z);
            a = null;
            Log.i(TAG, "bitmap_scan_opt bitmapDecodeJ end");
        }
        return bitmapDecode;
    }

    private static boolean c() {
        try {
            return ((Boolean) Class.forName("com.alipay.mobile.mascanengine.AlipayMaEngineUtils").getMethod("isNeedBitmapInterfaceOpt", null).invoke(null, new Object[0])).booleanValue();
        } catch (Throwable unused) {
            return false;
        }
    }

    public static native int cameraDecodeInit();

    public static int cameraDecodeInitJ() {
        try {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            int cameraDecodeInit = cameraDecodeInit();
            long elapsedRealtime2 = SystemClock.elapsedRealtime() - elapsedRealtime;
            a("function=cameraDecodeInitJ^duration=" + elapsedRealtime2);
            return cameraDecodeInit;
        } catch (UnsatisfiedLinkError e) {
            MaLogger.e(TAG, "cameraDecodeInitJ: " + e.getMessage());
            return 0;
        } catch (Error e2) {
            MaLogger.e(TAG, "cameraDecodeInitJ: " + e2.getMessage());
            return 0;
        }
    }

    public static native int cameraDecodeUnInit();

    public static int cameraDecodeUnInitJ() {
        try {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            int cameraDecodeUnInit = cameraDecodeUnInit();
            long elapsedRealtime2 = SystemClock.elapsedRealtime() - elapsedRealtime;
            a("function=cameraDecodeUnInitJ^duration=" + elapsedRealtime2);
            return cameraDecodeUnInit;
        } catch (UnsatisfiedLinkError e) {
            MaLogger.e(TAG, "cameraDecodeUnInitJ: " + e);
            return 0;
        } catch (Error e2) {
            MaLogger.e(TAG, "cameraDecodeUnInitJ: " + e2);
            return 0;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x004c A[Catch: all -> 0x00f1, TryCatch #4 {, blocks: (B:4:0x0003, B:10:0x000b, B:12:0x000f, B:15:0x0018, B:22:0x0047, B:24:0x004c, B:26:0x0059, B:28:0x0061, B:36:0x00c1, B:39:0x00c5, B:41:0x00c8, B:18:0x001e, B:20:0x0029, B:29:0x008d), top: B:52:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00c1 A[Catch: all -> 0x00f1, TRY_ENTER, TryCatch #4 {, blocks: (B:4:0x0003, B:10:0x000b, B:12:0x000f, B:15:0x0018, B:22:0x0047, B:24:0x004c, B:26:0x0059, B:28:0x0061, B:36:0x00c1, B:39:0x00c5, B:41:0x00c8, B:18:0x001e, B:20:0x0029, B:29:0x008d), top: B:52:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00c8 A[Catch: all -> 0x00f1, TRY_LEAVE, TryCatch #4 {, blocks: (B:4:0x0003, B:10:0x000b, B:12:0x000f, B:15:0x0018, B:22:0x0047, B:24:0x004c, B:26:0x0059, B:28:0x0061, B:36:0x00c1, B:39:0x00c5, B:41:0x00c8, B:18:0x001e, B:20:0x0029, B:29:0x008d), top: B:52:0x0003 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static synchronized com.alipay.ma.decode.DecodeResult[] codeDecode(byte[] r3, int r4, int r5, int r6, android.graphics.Rect r7, int r8, java.lang.String r9, java.lang.String[] r10, float r11) {
        /*
            Method dump skipped, instructions count: 244
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.ma.decode.MaDecode.codeDecode(byte[], int, int, int, android.graphics.Rect, int, java.lang.String, java.lang.String[], float):com.alipay.ma.decode.DecodeResult[]");
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0066 A[Catch: all -> 0x007c, TryCatch #2 {, blocks: (B:4:0x0003, B:10:0x000b, B:12:0x000f, B:15:0x0018, B:22:0x0047, B:26:0x005a, B:28:0x0066, B:31:0x006a, B:33:0x006d, B:18:0x001e, B:20:0x0029), top: B:42:0x0003, inners: #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x006d A[Catch: all -> 0x007c, TRY_LEAVE, TryCatch #2 {, blocks: (B:4:0x0003, B:10:0x000b, B:12:0x000f, B:15:0x0018, B:22:0x0047, B:26:0x005a, B:28:0x0066, B:31:0x006a, B:33:0x006d, B:18:0x001e, B:20:0x0029), top: B:42:0x0003, inners: #3 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static synchronized com.alipay.ma.decode.DecodeResult[] codeDecodeBinarizedData(byte[] r3, int r4, int r5, int r6, android.graphics.Rect r7, int r8, int r9, java.lang.String r10, java.lang.String[] r11) {
        /*
            java.lang.Class<com.alipay.ma.decode.MaDecode> r0 = com.alipay.ma.decode.MaDecode.class
            monitor-enter(r0)
            boolean r1 = com.alipay.ma.decode.MaDecode.b     // Catch: java.lang.Throwable -> L7c
            r2 = 0
            if (r1 == 0) goto La
            monitor-exit(r0)
            return r2
        La:
            r1 = 1
            com.alipay.ma.decode.MaDecode.b = r1     // Catch: java.lang.Throwable -> L7c
            if (r3 != 0) goto L18
            java.lang.String r3 = "MaDecode"
            java.lang.String r4 = "codeDecode data is null"
            com.alipay.ma.MaLogger.w(r3, r4)     // Catch: java.lang.Throwable -> L7c
            monitor-exit(r0)
            return r2
        L18:
            com.alipay.ma.decode.DecodeResult[] r3 = codeDecodeWithBinary(r3, r4, r5, r6, r7, r8, r9, r10, r11)     // Catch: java.lang.Exception -> L1d java.lang.UnsatisfiedLinkError -> L28 java.lang.Throwable -> L7c
            goto L47
        L1d:
            r3 = move-exception
            java.lang.String r4 = "MaDecode"
            java.lang.String r3 = r3.getMessage()     // Catch: java.lang.Throwable -> L7c
            com.alipay.ma.MaLogger.e(r4, r3)     // Catch: java.lang.Throwable -> L7c
            goto L46
        L28:
            r3 = move-exception
            java.lang.String r4 = "MaDecode"
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L7c
            r5.<init>()     // Catch: java.lang.Throwable -> L7c
            java.lang.String r6 = "Failed to load decode100198, "
            r5.append(r6)     // Catch: java.lang.Throwable -> L7c
            java.lang.String r3 = r3.getMessage()     // Catch: java.lang.Throwable -> L7c
            r5.append(r3)     // Catch: java.lang.Throwable -> L7c
            java.lang.String r3 = r5.toString()     // Catch: java.lang.Throwable -> L7c
            com.alipay.ma.MaLogger.e(r4, r3)     // Catch: java.lang.Throwable -> L7c
            init()     // Catch: java.lang.Throwable -> L7c
        L46:
            r3 = r2
        L47:
            r4 = 0
            com.alipay.ma.decode.MaDecode.b = r4     // Catch: java.lang.Throwable -> L7c
            java.lang.String r5 = "MaDecode"
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L7c
            r6.<init>()     // Catch: java.lang.Throwable -> L7c
            java.lang.String r7 = "result is null:"
            r6.append(r7)     // Catch: java.lang.Throwable -> L7c
            if (r3 != 0) goto L59
            goto L5a
        L59:
            r1 = 0
        L5a:
            r6.append(r1)     // Catch: java.lang.Throwable -> L7c
            java.lang.String r6 = r6.toString()     // Catch: java.lang.Throwable -> L7c
            com.alipay.ma.MaLogger.d(r5, r6)     // Catch: java.lang.Throwable -> L7c
            if (r3 == 0) goto L7a
            int r5 = r3.length     // Catch: java.lang.Throwable -> L7c
            if (r5 != 0) goto L6a
            goto L7a
        L6a:
            int r5 = r3.length     // Catch: java.lang.Throwable -> L7c
            if (r4 >= r5) goto L78
            r5 = r3[r4]     // Catch: java.lang.Throwable -> L7c
            com.alipay.ma.decode.DecodeResult r5 = b(r5)     // Catch: java.lang.Throwable -> L7c
            r3[r4] = r5     // Catch: java.lang.Throwable -> L7c
            int r4 = r4 + 1
            goto L6a
        L78:
            monitor-exit(r0)
            return r3
        L7a:
            monitor-exit(r0)
            return r2
        L7c:
            r3 = move-exception
            monitor-exit(r0)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.ma.decode.MaDecode.codeDecodeBinarizedData(byte[], int, int, int, android.graphics.Rect, int, int, java.lang.String, java.lang.String[]):com.alipay.ma.decode.DecodeResult[]");
    }

    public static synchronized DecodeResult[] codeDecodePictureWithQr(String str, int i, boolean z) {
        DecodeResult[] codeDecodePictureWithQr;
        synchronized (MaDecode.class) {
            codeDecodePictureWithQr = codeDecodePictureWithQr(str, i, 4, z);
        }
        return codeDecodePictureWithQr;
    }

    private static native DecodeResult[] codeDecodeWithBinary(byte[] bArr, int i, int i2, int i3, Rect rect, int i4, int i5, String str, String[] strArr);

    private static native DecodeResult[] codeDecodeWithQr(byte[] bArr, int i, int i2, int i3, int i4, int i5, boolean z);

    private static void d(int i, String str, int i2, int i3, int i4) {
        Map hashMap;
        if (i != -1 && i != -2 && i != -3) {
            hashMap = getDecodeInfoJ();
        } else {
            hashMap = new HashMap();
        }
        if (hashMap == null) {
            return;
        }
        hashMap.put("scanMode", Integer.valueOf(i2));
        hashMap.put("resultCode", Integer.valueOf(i));
        if (str != null) {
            hashMap.put(AbstractC3893a.V, str);
        }
        if (i3 > 0 && i4 > 0) {
            hashMap.put("originWidth", Integer.valueOf(i3));
            hashMap.put(C9796v.TAK_ABILITY_SHOW_POP_INIT_SHOW_HEIGHT, Integer.valueOf(i4));
        }
        if (i == 0) {
            MaBuryRecord.recordScanDecodeTrack("SCAN_IMAGE_CODE", "SCAN_IMAGE_SUCCEED", hashMap);
        } else {
            MaBuryRecord.recordScanDecodeTrack("SCAN_IMAGE_CODE", "SCAN_IMAGE_FAILED", hashMap);
        }
    }

    public static void decodeInit() {
        MaLogger.d(TAG, "decodeInit()");
        firstFrameIn = -1L;
        frameEngineIn = -1L;
        cameraDecodeInitJ();
    }

    public static void decodeUnInit() {
        MaLogger.d(TAG, "decodeUnInit()");
        firstFrameIn = -1L;
        frameEngineIn = -1L;
        cameraDecodeUnInitJ();
    }

    private static native Object enableFastBitmapDecode();

    public static Object enableFastBitmapDecodeJ() {
        MaLogger.d(TAG, "enableFastBitmapDecodeJ()");
        try {
            enableFastBitmapDecode();
            return null;
        } catch (Throwable th) {
            MaLogger.e(TAG, "enableFastBitmapDecodeJ call native exception", th);
            return null;
        }
    }

    public static native Map getDecodeInfo();

    public static Map getDecodeInfoJ() {
        try {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            Map decodeInfo = getDecodeInfo();
            long elapsedRealtime2 = SystemClock.elapsedRealtime() - elapsedRealtime;
            a("function=getDecodeInfoJ^duration=" + elapsedRealtime2);
            return decodeInfo;
        } catch (UnsatisfiedLinkError e) {
            MaLogger.e(TAG, "getDecodeInfoJ: " + e.getMessage());
            return null;
        } catch (Error e2) {
            MaLogger.e(TAG, "getDecodeInfoJ: " + e2.getMessage());
            return null;
        }
    }

    public static native Map getFrameReadInfo();

    public static Map getFrameReadInfoJ() {
        try {
            return getFrameReadInfo();
        } catch (UnsatisfiedLinkError e) {
            MaLogger.e(TAG, "getFrameReadInfoJ: " + e);
            return null;
        } catch (Error e2) {
            MaLogger.e(TAG, "getFrameReadInfoJ: " + e2);
            return null;
        }
    }

    public static native Map getImageInfo(byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6, int i7);

    public static Map getImageInfoJ(byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        try {
            return getImageInfo(bArr, i, i2, i3, i4, i5, i6, i7);
        } catch (UnsatisfiedLinkError e) {
            MaLogger.e(TAG, "getImageInfoJ: " + e.getMessage());
            return null;
        } catch (Error e2) {
            MaLogger.e(TAG, "getImageInfoJ: " + e2.getMessage());
            return null;
        }
    }

    public static int getLastFrameAverageGray() {
        try {
            return getLastFrameAvgGray();
        } catch (Exception e) {
            MaLogger.e(TAG, e.getMessage());
            return 0;
        } catch (UnsatisfiedLinkError e2) {
            MaLogger.e(TAG, "Failed to load decode100198, " + e2.getMessage());
            init();
            return 0;
        }
    }

    public static native int getLastFrameAvgGray();

    public static native float getLimitZoomFactor();

    public static float getLimitZoomFactorJ() {
        try {
            return getLimitZoomFactor();
        } catch (Exception unused) {
            return -1.0f;
        }
    }

    public static native float getMaProportion();

    public static float getMaProportionJ() {
        try {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            float maProportion = getMaProportion();
            long elapsedRealtime2 = SystemClock.elapsedRealtime() - elapsedRealtime;
            a("function=getMaProportionJ^duration=" + elapsedRealtime2);
            return maProportion;
        } catch (UnsatisfiedLinkError e) {
            MaLogger.e(TAG, "getMaProportionJ: " + e.getMessage());
            return -1.0f;
        } catch (Error e2) {
            MaLogger.e(TAG, "getMaProportionJ: " + e2.getMessage());
            return -1.0f;
        }
    }

    public static native int getMaProportionSource();

    public static int getMaProportionSourceJ() {
        try {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            int maProportionSource = getMaProportionSource();
            long elapsedRealtime2 = SystemClock.elapsedRealtime() - elapsedRealtime;
            a("function=getMaProportionSourceJ^duration=" + elapsedRealtime2);
            return maProportionSource;
        } catch (UnsatisfiedLinkError e) {
            MaLogger.e(TAG, "getMaProportionSourceJ: " + e.getMessage());
            return -1;
        } catch (Error e2) {
            MaLogger.e(TAG, "getMaProportionSourceJ: " + e2.getMessage());
            return -1;
        }
    }

    public static native int getQrSizeAndCenter(float[] fArr);

    public static int getQrSizeAndCenterJ(float[] fArr) {
        try {
            return getQrSizeAndCenter(fArr);
        } catch (UnsatisfiedLinkError e) {
            MaLogger.e(TAG, "getQrSizeAndCenterJ: " + e.getMessage());
            return 0;
        } catch (Error e2) {
            MaLogger.e(TAG, "getQrSizeAndCenterJ: " + e2.getMessage());
            return 0;
        }
    }

    public static native String getReaderParams();

    public static String getReaderParamsJ() {
        try {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            String readerParams = getReaderParams();
            long elapsedRealtime2 = SystemClock.elapsedRealtime() - elapsedRealtime;
            a("function=getReaderParamsJ^duration=" + elapsedRealtime2);
            return readerParams;
        } catch (UnsatisfiedLinkError e) {
            MaLogger.e(TAG, "getReaderParmasJ: " + e.getMessage());
            return null;
        } catch (Error e2) {
            MaLogger.e(TAG, "getReaderParmasJ: " + e2.getMessage());
            return null;
        }
    }

    public static void init() {
        long currentTimeMillis = System.currentTimeMillis();
        try {
            Class.forName("com.alipay.mobile.common.utils.load.LibraryLoadUtils").getDeclaredMethod("loadLibrary", String.class, Boolean.TYPE).invoke(null, SO_NAME, Boolean.FALSE);
            long currentTimeMillis2 = System.currentTimeMillis();
            sEngineSoLoadedTimestamp = currentTimeMillis2;
            long j = currentTimeMillis2 - currentTimeMillis;
            MaBuryRecord.reportSoLoadResult(0, j);
            MaEngineAPI.sEngineSoLoaded = true;
            Log.e(TAG, "decode so load duration " + j);
            MaLogger.w(TAG, "decode so load duration " + j);
        } catch (Throwable unused) {
            MaLogger.w(TAG, "so load with framework failed, fall back: decode100198");
            try {
                System.loadLibrary(SO_NAME);
                long currentTimeMillis3 = System.currentTimeMillis();
                sEngineSoLoadedTimestamp = currentTimeMillis3;
                MaBuryRecord.reportSoLoadResult(1, currentTimeMillis3 - currentTimeMillis);
                MaEngineAPI.sEngineSoLoaded = true;
            } catch (UnsatisfiedLinkError e) {
                MaLogger.e(TAG, "Failed to load decode100198, " + e.getMessage());
                MaBuryRecord.reportSoLoadResult(-1, -1L);
            }
        }
    }

    public static boolean isIntercepted(byte[] bArr) {
        MaInterceptOperation maInterceptOperation = a;
        if (maInterceptOperation != null) {
            return maInterceptOperation.isIntercepted(bArr);
        }
        return false;
    }

    public static void markEngineFrameIn(long j) {
        frameEngineIn = j;
    }

    public static void markFirstFrameIn(long j) {
        firstFrameIn = j;
    }

    public static native String needA();

    public static String needAJ() {
        try {
            return needA();
        } catch (UnsatisfiedLinkError e) {
            MaLogger.e(TAG, "needAJ: " + e.getMessage());
            return null;
        } catch (Error e2) {
            MaLogger.e(TAG, "needAJ: " + e2.getMessage());
            return null;
        }
    }

    public static native void needDownGradeSdkMemoryAllocate();

    public static void needDownGradeSdkMemoryAllocateJ() {
        MaLogger.d(TAG, "needDownGradeSdkMemoryAllocate()");
        try {
            needDownGradeSdkMemoryAllocate();
        } catch (Throwable th) {
            MaLogger.e(TAG, "needDownGradeSdkMemoryAllocate call native exception", th);
        }
    }

    public static void recordScanDecodeLog(String str, String str2) {
        MaLogger.d(str, str2);
    }

    public static void recordScanDecodeTrack(String str, String str2, HashMap hashMap) {
        if (hashMap != null) {
            hashMap.put("scanUIType", scanUIType);
            hashMap.put("scan_SourceId", scanSourceId);
        }
        MaBuryRecord.recordScanDecodeTrack(str, str2, hashMap);
    }

    public static void refreshInitedReaderParams() {
        sInitedReaderParams = getReaderParamsJ();
    }

    public static native int setBinarizerOrder(int[][] iArr);

    public static native int setReaderParams(String str, String str2);

    public static int setReaderParamsJ(String str, String str2) {
        try {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            int readerParams = setReaderParams(str, str2);
            a("function=setReaderParamsJ^duration=" + (SystemClock.elapsedRealtime() - elapsedRealtime));
            return readerParams;
        } catch (UnsatisfiedLinkError e) {
            MaLogger.e(TAG, "setReaderParams: " + e.getMessage());
            return 0;
        } catch (Error e2) {
            MaLogger.e(TAG, "setReaderParams: " + e2.getMessage());
            return 0;
        }
    }

    public static DecodeResult[] yuvcodeDecode(YuvImage yuvImage, Rect rect, int i, String str, String[] strArr) {
        return codeDecode(yuvImage.getYuvData(), yuvImage.getWidth(), yuvImage.getHeight(), yuvImage.getStrides()[0], rect, i, str, strArr, 1.0f);
    }

    private static native DecodeResult[] yuvcodeDecode(byte[] bArr, int i, int i2, int i3, Rect rect, int i4, String str, String[] strArr, float f);

    public static synchronized DecodeResult[] codeDecodePictureWithQr(String str, int i, int i2, boolean z) {
        DecodeResult[] codeDecodePictureWithQr;
        synchronized (MaDecode.class) {
            codeDecodePictureWithQr = codeDecodePictureWithQr(str, i, i2, z, (MaInterceptOperation) null);
        }
        return codeDecodePictureWithQr;
    }

    public static synchronized DecodeResult[] codeDecodePictureWithQr(String str, int i, int i2, boolean z, MaInterceptOperation maInterceptOperation) {
        synchronized (MaDecode.class) {
            try {
                if (TextUtils.isEmpty(str)) {
                    d(-1, str, i, 0, 0);
                    return null;
                }
                File file = new File(str);
                if (!file.exists()) {
                    d(-2, str, i, 0, 0);
                    return null;
                }
                return codeDecodePictureWithQr(ImageTool.createThumbnail(file, 1500, 1500), i, str, i2, z, maInterceptOperation);
            } catch (Exception unused) {
                return null;
            }
        }
    }

    public static long RegistDSLReaderJ(String str) {
        return RegistDSLReaderJ(str, false);
    }

    public static long UnRegistDSLReaderJ(long j) {
        return UnRegistDSLReaderJ(false);
    }

    public static synchronized DecodeResult[] codeDecodePictureWithQr(String str, Context context, int i, boolean z) {
        DecodeResult[] codeDecodePictureWithQr;
        synchronized (MaDecode.class) {
            codeDecodePictureWithQr = codeDecodePictureWithQr(str, context, i, 4, z);
        }
        return codeDecodePictureWithQr;
    }

    public static synchronized DecodeResult[] codeDecodePictureWithQr(String str, Context context, int i, int i2, boolean z) {
        DecodeResult[] codeDecodePictureWithQr;
        synchronized (MaDecode.class) {
            codeDecodePictureWithQr = codeDecodePictureWithQr(str, context, i, i2, z, (MaInterceptOperation) null);
        }
        return codeDecodePictureWithQr;
    }

    public static synchronized DecodeResult[] codeDecodePictureWithQr(String str, Context context, int i, int i2, boolean z, MaInterceptOperation maInterceptOperation) {
        ParcelFileDescriptor parcelFileDescriptor;
        synchronized (MaDecode.class) {
            ParcelFileDescriptor parcelFileDescriptor2 = null;
            if (TextUtils.isEmpty(str)) {
                d(-1, str, i, 0, 0);
                return null;
            }
            try {
                MaLogger.d(TAG, "codeDecodePictureWithQr uriStr=" + str);
                parcelFileDescriptor = context.getContentResolver().openFileDescriptor(Uri.parse(str), UploadQueueMgr.MSGTYPE_REALTIME);
            } catch (Exception unused) {
                parcelFileDescriptor = null;
            } catch (Throwable th) {
                th = th;
            }
            try {
                if (parcelFileDescriptor == null) {
                    d(-2, str, i, 0, 0);
                    if (parcelFileDescriptor != null) {
                        try {
                            parcelFileDescriptor.close();
                        } catch (Exception e) {
                            MaLogger.e(TAG, "error:" + e.getMessage());
                        }
                    }
                    return null;
                }
                DecodeResult[] codeDecodePictureWithQr = codeDecodePictureWithQr(ImageTool.createThumbnail(parcelFileDescriptor.getFileDescriptor(), 1500, 1500), i, str, i2, z, maInterceptOperation);
                try {
                    parcelFileDescriptor.close();
                } catch (Exception e2) {
                    MaLogger.e(TAG, "error:" + e2.getMessage());
                }
                return codeDecodePictureWithQr;
            } catch (Exception unused2) {
                if (parcelFileDescriptor != null) {
                    try {
                        parcelFileDescriptor.close();
                    } catch (Exception e3) {
                        MaLogger.e(TAG, "error:" + e3.getMessage());
                    }
                }
                return null;
            } catch (Throwable th2) {
                th = th2;
                parcelFileDescriptor2 = parcelFileDescriptor;
                if (parcelFileDescriptor2 != null) {
                    try {
                        parcelFileDescriptor2.close();
                    } catch (Exception e4) {
                        MaLogger.e(TAG, "error:" + e4.getMessage());
                    }
                }
                throw th;
            }
        }
    }

    public static synchronized DecodeResult[] codeDecodePictureWithQr(Bitmap bitmap, int i, boolean z) {
        DecodeResult[] codeDecodePictureWithQr;
        synchronized (MaDecode.class) {
            codeDecodePictureWithQr = codeDecodePictureWithQr(bitmap, i, 4, z);
        }
        return codeDecodePictureWithQr;
    }

    public static synchronized DecodeResult[] codeDecodePictureWithQr(Bitmap bitmap, int i, int i2, boolean z) {
        DecodeResult[] codeDecodePictureWithQr;
        synchronized (MaDecode.class) {
            codeDecodePictureWithQr = codeDecodePictureWithQr(bitmap, i, (String) null, i2, z);
        }
        return codeDecodePictureWithQr;
    }

    public static synchronized DecodeResult[] codeDecodePictureWithQr(Bitmap bitmap, int i, String str, boolean z) {
        DecodeResult[] codeDecodePictureWithQr;
        synchronized (MaDecode.class) {
            codeDecodePictureWithQr = codeDecodePictureWithQr(bitmap, i, str, 4, z);
        }
        return codeDecodePictureWithQr;
    }

    public static synchronized DecodeResult[] codeDecodePictureWithQr(Bitmap bitmap, int i, String str, int i2, boolean z) {
        DecodeResult[] codeDecodePictureWithQr;
        synchronized (MaDecode.class) {
            codeDecodePictureWithQr = codeDecodePictureWithQr(bitmap, i, str, i2, z, (MaInterceptOperation) null);
        }
        return codeDecodePictureWithQr;
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x00d5 A[Catch: all -> 0x0013, OutOfMemoryError -> 0x0112, TryCatch #0 {, blocks: (B:7:0x000e, B:12:0x0016, B:14:0x001e, B:16:0x0028, B:19:0x0032, B:41:0x00d5, B:45:0x00da, B:47:0x00dd, B:49:0x00e0, B:52:0x00f9, B:53:0x0106, B:50:0x00eb, B:23:0x003b, B:25:0x0047, B:26:0x0066, B:27:0x0080, B:28:0x009c, B:56:0x0113, B:37:0x00ab, B:39:0x00b6), top: B:61:0x000b }] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00f9 A[Catch: all -> 0x0013, OutOfMemoryError -> 0x0112, TryCatch #0 {, blocks: (B:7:0x000e, B:12:0x0016, B:14:0x001e, B:16:0x0028, B:19:0x0032, B:41:0x00d5, B:45:0x00da, B:47:0x00dd, B:49:0x00e0, B:52:0x00f9, B:53:0x0106, B:50:0x00eb, B:23:0x003b, B:25:0x0047, B:26:0x0066, B:27:0x0080, B:28:0x009c, B:56:0x0113, B:37:0x00ab, B:39:0x00b6), top: B:61:0x000b }] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0106 A[Catch: all -> 0x0013, OutOfMemoryError -> 0x0112, TRY_LEAVE, TryCatch #0 {, blocks: (B:7:0x000e, B:12:0x0016, B:14:0x001e, B:16:0x0028, B:19:0x0032, B:41:0x00d5, B:45:0x00da, B:47:0x00dd, B:49:0x00e0, B:52:0x00f9, B:53:0x0106, B:50:0x00eb, B:23:0x003b, B:25:0x0047, B:26:0x0066, B:27:0x0080, B:28:0x009c, B:56:0x0113, B:37:0x00ab, B:39:0x00b6), top: B:61:0x000b }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static synchronized com.alipay.ma.decode.DecodeResult[] codeDecodePictureWithQr(android.graphics.Bitmap r14, int r15, java.lang.String r16, int r17, boolean r18, com.alipay.ma.strategies.MaInterceptOperation r19) {
        /*
            Method dump skipped, instructions count: 317
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.ma.decode.MaDecode.codeDecodePictureWithQr(android.graphics.Bitmap, int, java.lang.String, int, boolean, com.alipay.ma.strategies.MaInterceptOperation):com.alipay.ma.decode.DecodeResult[]");
    }
}
