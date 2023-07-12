package com.alibaba.security.biometrics.jni;

import android.content.Context;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.Base64;
import com.alibaba.security.biometrics.jni.listener.OnSgProcessListener;
import com.alibaba.security.common.c.a;
import com.alibaba.security.common.d.n;
import com.alibaba.security.common.d.p;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class ALBiometricsJni {
    private static final int BOOLEAN_VALUE_COUNT = 9;
    private static final int CONTINUE_FLOAT_VALUE_COUNT = 36;
    private static final int CONTINUE_IMAGE_OUT_COUNT = 1;
    private static final int CONTINUE_INT_VALUE_COUNT = 6;
    private static final int FLOAT_VALUE_COUNT = 88;
    private static final int IMAGE_OUT_COUNT = 8;
    private static final int INT_VALUE_COUNT = 50;
    private static final int LOG_OUT_COUNT = 4;
    private static final int LONG_VALUE_COUNT = 1;
    private static final String TAG = "ALBiometricsJni";
    private static final int TRACK_KEYPOINT_NUM = 18;
    private static boolean bLoaded;

    static {
        try {
            if (isLoaded()) {
                return;
            }
            System.loadLibrary(TAG);
            bLoaded = true;
        } catch (Throwable unused) {
            a.b();
        }
    }

    private static native int ChangeDetectTypeJni(int i, boolean z);

    static native int CheckLicense(Context context, byte[] bArr, int i, byte[] bArr2, int i2);

    static native String CollectLicenseInfo(Context context);

    private static native int DoDetectContinueJni(byte[] bArr, float[] fArr, int[] iArr, byte[][] bArr2, String str, String str2);

    private static native int DoDetectJni(byte[] bArr, boolean[] zArr, float[] fArr, int[] iArr, long[] jArr, byte[][] bArr2, byte[][] bArr3, String str, String str2);

    public static native int GetCombinedRecapScore(float[] fArr);

    static native int GetExpireDate(Context context, byte[] bArr, int i, long[] jArr);

    public static native int GetRecapPatch(byte[] bArr);

    private static native int Init(int i, int i2, int i3, String str, String str2, String str3, String str4, String str5, int i4);

    public static native boolean IsEnabled();

    private static native int Release();

    public static native int Replay(byte[] bArr, byte[] bArr2, int[] iArr, float[] fArr);

    public static native int Reset(boolean z);

    public static native int SetParameter(int i, float f);

    public static native int SetRecapResult(float[] fArr, float f, float f2, float f3, float f4);

    private static native void bh(int i, String str);

    public static void bhL(int i, String str) {
        if (str == null) {
            str = "";
        }
        if (isLoaded()) {
            bh(i, str);
        }
    }

    public static int changeDetectType(ABJniDetectType aBJniDetectType, boolean z) {
        return ChangeDetectTypeJni(aBJniDetectType.getValue(), z);
    }

    public static int checkLicense(Context context, OnSgProcessListener onSgProcessListener) {
        if (loadSo(context)) {
            if (getLicenseResult() != 0) {
                return checkLicense(onSgProcessListener);
            }
            return 0;
        }
        return -1;
    }

    static native int checkSign(byte[] bArr, int i, byte[] bArr2, int i2);

    public static int doDetect(byte[] bArr, ABJniDetectResult aBJniDetectResult, String str) {
        boolean[] zArr = new boolean[9];
        float[] fArr = new float[88];
        int[] iArr = new int[50];
        long[] jArr = new long[1];
        byte[][] bArr2 = new byte[8];
        byte[][] bArr3 = new byte[4];
        iArr[0] = aBJniDetectResult.reflectCmd;
        iArr[1] = aBJniDetectResult.reflectDetectType;
        fArr[0] = aBJniDetectResult.iso;
        fArr[1] = aBJniDetectResult.illuminance;
        int DoDetectJni = DoDetectJni(bArr, zArr, fArr, iArr, jArr, bArr2, bArr3, String.valueOf(System.currentTimeMillis()), str);
        if (DoDetectJni != 0) {
            return DoDetectJni;
        }
        aBJniDetectResult.faceExist = zArr[0];
        aBJniDetectResult.outOfRegion = zArr[1];
        aBJniDetectResult.tooSmall = zArr[2];
        aBJniDetectResult.tooBig = zArr[3];
        aBJniDetectResult.still = zArr[4];
        aBJniDetectResult.faceChange = zArr[5];
        aBJniDetectResult.mouthOcclusion = zArr[6];
        aBJniDetectResult.eyeOcclusionOnce = zArr[7];
        aBJniDetectResult.confirm3D = zArr[8];
        System.arraycopy(fArr, 0, aBJniDetectResult.faceKeyPoint, 0, 36);
        aBJniDetectResult.brightness = fArr[36];
        aBJniDetectResult.quality = fArr[37];
        aBJniDetectResult.staticQuality = fArr[38];
        aBJniDetectResult.pitchScore = fArr[39];
        aBJniDetectResult.yawScore = fArr[40];
        aBJniDetectResult.mouthScore = fArr[41];
        aBJniDetectResult.blinkScore = fArr[42];
        aBJniDetectResult.landmarkScore = fArr[43];
        aBJniDetectResult.brightDiff = fArr[44];
        aBJniDetectResult.backHightlight = fArr[45];
        aBJniDetectResult.faceSpeed = fArr[46];
        aBJniDetectResult.gestureProgress = fArr[51];
        aBJniDetectResult.initTime = jArr[0];
        aBJniDetectResult.iDetectType = iArr[0];
        aBJniDetectResult.iDetectTypeOld = iArr[1];
        aBJniDetectResult.iDetectState = iArr[2];
        aBJniDetectResult.msecChangeDetectType = iArr[3];
        aBJniDetectResult.msecCurrentTime = iArr[4];
        aBJniDetectResult.countPitch = iArr[5];
        aBJniDetectResult.countYaw = iArr[6];
        aBJniDetectResult.countMouth = iArr[7];
        aBJniDetectResult.countBlink = iArr[8];
        aBJniDetectResult.countFaceDisappear = iArr[9];
        aBJniDetectResult.msecLeft = iArr[10];
        aBJniDetectResult.faceRectSmooth = new Rect(iArr[25], iArr[26], iArr[25] + iArr[27], iArr[26] + iArr[28]);
        aBJniDetectResult.iPromptMessage = iArr[11];
        aBJniDetectResult.iFailReason = iArr[12];
        if (bArr2[0] != null) {
            aBJniDetectResult.bigImgBuffer = bArr2[0];
            aBJniDetectResult.bigImgWidth = iArr[13];
            aBJniDetectResult.bigImgHeight = iArr[14];
            aBJniDetectResult.faceLeft = iArr[19];
            aBJniDetectResult.faceTop = iArr[20];
            aBJniDetectResult.faceWidth = iArr[21];
            aBJniDetectResult.faceHeight = iArr[22];
            System.arraycopy(fArr, 52, aBJniDetectResult.faceKeyPointInBigImg, 0, 36);
        }
        if (bArr2[1] != null && bArr2[2] != null) {
            aBJniDetectResult.actionImgBuffer = r8;
            byte[][] bArr4 = {bArr2[1], bArr2[2]};
            aBJniDetectResult.actionImgWidth = iArr[15];
            aBJniDetectResult.actionImgHeight = iArr[16];
        }
        if (bArr2[3] != null) {
            aBJniDetectResult.globalImgBuffer = bArr2[3];
            aBJniDetectResult.globalImgWidth = iArr[17];
            aBJniDetectResult.globalImgHeight = iArr[18];
        }
        if (bArr2[4] != null) {
            aBJniDetectResult.localImgBuffer = bArr2[4];
            aBJniDetectResult.localImgWidth = iArr[17];
            aBJniDetectResult.localImgHeight = iArr[18];
        }
        if (bArr2[5] != null) {
            aBJniDetectResult.frameBuffer = bArr2[5];
            aBJniDetectResult.frameWidth = iArr[23];
            aBJniDetectResult.frameHeight = iArr[24];
        }
        if (bArr3[0] != null) {
            aBJniDetectResult.failLog = new String(bArr3[0]);
        }
        aBJniDetectResult.reflectResult = iArr[29];
        aBJniDetectResult.reflectFrames = iArr[30];
        aBJniDetectResult.reflectScore = fArr[47];
        aBJniDetectResult.reflectBrightnessResult = iArr[31];
        aBJniDetectResult.reflectBrightnessFrames = iArr[32];
        aBJniDetectResult.reflectBrightnessScore = fArr[48];
        aBJniDetectResult.reflectEyeResult = iArr[33];
        aBJniDetectResult.reflectLeftEyeResult = iArr[34];
        aBJniDetectResult.reflectRightEyeResult = iArr[35];
        aBJniDetectResult.reflectEyeFrames = iArr[36];
        aBJniDetectResult.reflectEyeValidFrames = iArr[37];
        aBJniDetectResult.reflectCmd = iArr[38];
        aBJniDetectResult.leftEyeDataWidth = iArr[39];
        aBJniDetectResult.leftEyeDataHeight = iArr[40];
        aBJniDetectResult.rightEyeDataWidth = iArr[41];
        aBJniDetectResult.rightEyeDataHeight = iArr[42];
        aBJniDetectResult.leftEyeData = bArr2[6];
        aBJniDetectResult.rightEyeData = bArr2[7];
        aBJniDetectResult.ec = iArr[43];
        aBJniDetectResult.ecpc = iArr[44];
        aBJniDetectResult.etcc = iArr[45];
        if (bArr3[1] != null) {
            aBJniDetectResult.brightnessScores = new String(bArr3[1]);
        }
        if (bArr3[2] != null) {
            aBJniDetectResult.brightnessHistory = new String(bArr3[2]);
        }
        if (bArr3[3] != null) {
            aBJniDetectResult.ecResult = Base64.encodeToString(bArr3[3], 2);
        }
        return DoDetectJni;
    }

    public static int doDetectContinue(byte[] bArr, ABJniDetectResult aBJniDetectResult, String str) {
        float[] fArr = new float[36];
        int[] iArr = new int[6];
        byte[][] bArr2 = new byte[1];
        int DoDetectContinueJni = DoDetectContinueJni(bArr, fArr, iArr, bArr2, String.valueOf(System.currentTimeMillis()), str);
        if (DoDetectContinueJni != 0) {
            return DoDetectContinueJni;
        }
        if (bArr2[0] != null) {
            aBJniDetectResult.faceExist = true;
            aBJniDetectResult.bigImgBuffer = bArr2[0];
            aBJniDetectResult.bigImgWidth = iArr[0];
            aBJniDetectResult.bigImgHeight = iArr[1];
            aBJniDetectResult.faceLeft = iArr[2];
            aBJniDetectResult.faceTop = iArr[3];
            aBJniDetectResult.faceWidth = iArr[4];
            aBJniDetectResult.faceHeight = iArr[5];
            System.arraycopy(fArr, 0, aBJniDetectResult.faceKeyPointInBigImg, 0, 36);
        } else {
            aBJniDetectResult.faceExist = false;
        }
        return DoDetectContinueJni;
    }

    public static String dp(byte[] bArr) {
        if (isLoaded()) {
            return dp(bArr, bArr.length);
        }
        return null;
    }

    private static native String dp(byte[] bArr, int i);

    public static byte[] dumpBeh(boolean z) {
        if (isLoaded()) {
            return dumpBh(z);
        }
        return null;
    }

    private static native byte[] dumpBh(boolean z);

    private static native byte[] genKeyToken(String str);

    public static byte[] genVersionTag(Context context, String str) {
        if (loadSo(context)) {
            return genVersionTag(str, VersionKey.RP_SDK_VERSION, VersionKey.FL_SDK_VERSION);
        }
        return null;
    }

    private static native byte[] genVersionTag(String str, String str2, String str3);

    public static byte[] generateKeyToken(String str) {
        if (isLoaded()) {
            return genKeyToken(str);
        }
        return null;
    }

    static native int getLicenseResult();

    static native int getToken(byte[] bArr, int[] iArr);

    public static String getVersion() {
        return VersionKey.FL_SDK_VERSION;
    }

    public static int init(int i, int i2, int i3, String str, String str2, String str3, String str4, String str5, int i4) {
        return Init(i, i2, i3, str, str2, str3, str4, str5, i4);
    }

    private static native void initToken(String str);

    public static void initialToken(String str) {
        if (isLoaded()) {
            initToken(str);
        }
    }

    public static boolean isLoaded() {
        return bLoaded;
    }

    public static boolean loadSo(Context context) {
        if (!bLoaded && p.f()) {
            bLoaded = n.a(context).a("ALBiometricsJni_x86");
        }
        if (!bLoaded) {
            bLoaded = n.a(context).a(TAG);
        }
        return bLoaded;
    }

    public static byte[] makeResult(String str) {
        if (!isLoaded() || TextUtils.isEmpty(str)) {
            return null;
        }
        return makeStrResult(str);
    }

    public static native byte[] makeResult(byte[] bArr, String str, String str2);

    private static native byte[] makeStrResult(String str);

    static native int nativeCheckLicenseIsForever(Context context, byte[] bArr, int i, boolean[] zArr);

    static native byte[] nativeGetFeature(Context context, byte[] bArr, int i);

    public static void release() {
        Release();
    }

    private static int checkLicense(OnSgProcessListener onSgProcessListener) {
        String appKey = onSgProcessListener.getAppKey();
        if (TextUtils.isEmpty(appKey)) {
            return ABJniDetectCodes.ERROR_SG_LICENSE_NO_APPKEY;
        }
        byte[] bArr = new byte[32];
        int token = getToken(bArr, new int[1]);
        if (token != 0) {
            return token;
        }
        String sign = onSgProcessListener.sign(new String(bArr));
        return TextUtils.isEmpty(sign) ? ABJniDetectCodes.ERROR_SG_LICENSE_SG_SIGN : checkSign(appKey.getBytes(), appKey.getBytes().length, sign.getBytes(), sign.getBytes().length);
    }

    public static int checkLicense(Context context, byte[] bArr, byte[] bArr2) {
        if (loadSo(context)) {
            return CheckLicense(context, bArr, bArr == null ? 0 : bArr.length, bArr2, bArr2 != null ? bArr2.length : 0);
        }
        return -1;
    }
}
