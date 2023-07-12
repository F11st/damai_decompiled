package com.alipay.camera2.util;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraManager;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.os.Build;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Range;
import android.util.Size;
import com.alipay.mobile.bqcscanservice.BQCCameraParam;
import com.alipay.mobile.bqcscanservice.BQCScanError;
import com.alipay.mobile.bqcscanservice.MPaasLogger;
import java.util.Arrays;
import java.util.List;

/* compiled from: Taobao */
@TargetApi(26)
/* loaded from: classes12.dex */
public class Camera2CharacteristicsCache {
    private static String M;
    private static boolean N;
    private List<CaptureRequest.Key<?>> A;
    private List<CaptureRequest.Key<?>> B;
    private int[] C;
    private int[] D;
    private int[] E;
    private int[] F;
    private int[] G;
    private int[] H;
    private boolean I;
    private CameraCharacteristics J;
    private boolean K;
    private Integer L;
    private final int a;
    private final int b;
    private int c;
    private int d;
    List<Point> e;
    List<Point> f;
    private Rect g;
    private BQCScanError h;
    private CameraManager i;
    private String[] j;
    private int[] k;
    private int[] l;
    private int[] m;
    private int[] n;
    private boolean[] o;
    private int[] p;
    private float q;
    private boolean r;
    private float s;
    private int t;
    private int u;
    private int v;
    private float w;
    private int[] x;
    private Range<Integer>[] y;
    private StreamConfigurationMap z;

    public Camera2CharacteristicsCache(Context context) {
        this.c = -1;
        this.d = 35;
        this.K = false;
        this.a = 0;
        this.b = g(0);
        o(context);
        initCamera2CharacteristicsCache();
    }

    private BQCScanError a(String str) {
        return new BQCScanError(BQCScanError.ErrorType.ERROR_CAMERA_INIT, t(str), 1102, BQCScanError.CameraAPIType.API2);
    }

    private BQCScanError b(String str) {
        return new BQCScanError(BQCScanError.ErrorType.ERROR_CAMERA_INIT, t(str), 1101, BQCScanError.CameraAPIType.API2);
    }

    private BQCScanError c(String str) {
        return new BQCScanError(BQCScanError.ErrorType.ERROR_CAMERA_INIT, t(str), 1100, BQCScanError.CameraAPIType.API2);
    }

    private BQCScanError d(String str) {
        return new BQCScanError(BQCScanError.ErrorType.ERROR_CAMERA_INIT, t(str), 1103, BQCScanError.CameraAPIType.API2);
    }

    private boolean e(CameraCharacteristics cameraCharacteristics) {
        int[] iArr;
        return (cameraCharacteristics == null || (iArr = (int[]) cameraCharacteristics.get(CameraCharacteristics.CONTROL_AF_AVAILABLE_MODES)) == null || iArr.length <= 1) ? false : true;
    }

    private boolean f(int[] iArr, int i) {
        if (iArr == null) {
            return false;
        }
        for (int i2 : iArr) {
            if (i2 == i) {
                return true;
            }
        }
        return false;
    }

    private int g(int i) {
        return i == 1 ? 0 : 1;
    }

    private int h(CameraCharacteristics cameraCharacteristics) {
        Integer num;
        if (cameraCharacteristics == null || (num = (Integer) cameraCharacteristics.get(CameraCharacteristics.CONTROL_MAX_REGIONS_AE)) == null) {
            return 0;
        }
        return num.intValue();
    }

    private static int i(CameraCharacteristics cameraCharacteristics) {
        Integer num;
        if (cameraCharacteristics == null || (num = (Integer) cameraCharacteristics.get(CameraCharacteristics.CONTROL_MAX_REGIONS_AF)) == null) {
            return 0;
        }
        return num.intValue();
    }

    private float j(CameraCharacteristics cameraCharacteristics) {
        Float f = (Float) cameraCharacteristics.get(CameraCharacteristics.SCALER_AVAILABLE_MAX_DIGITAL_ZOOM);
        if (f == null) {
            return 1.0f;
        }
        return f.floatValue();
    }

    private int k(CameraCharacteristics cameraCharacteristics) {
        Integer num = (Integer) cameraCharacteristics.get(CameraCharacteristics.LENS_INFO_FOCUS_DISTANCE_CALIBRATION);
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    private float l(CameraCharacteristics cameraCharacteristics) {
        Float f = (Float) cameraCharacteristics.get(CameraCharacteristics.LENS_INFO_HYPERFOCAL_DISTANCE);
        if (f == null) {
            return -1.0f;
        }
        return f.floatValue();
    }

    private float m(CameraCharacteristics cameraCharacteristics) {
        Float f;
        if (cameraCharacteristics == null || (f = (Float) cameraCharacteristics.get(CameraCharacteristics.LENS_INFO_MINIMUM_FOCUS_DISTANCE)) == null) {
            return 0.0f;
        }
        if (f.floatValue() < 0.0f) {
            f = Float.valueOf(0.0f);
        }
        return f.floatValue();
    }

    private CameraCharacteristics n() {
        CameraCharacteristics cameraCharacteristics;
        Exception e;
        try {
            boolean z = Looper.myLooper() == Looper.getMainLooper();
            if (N && z) {
                try {
                    cameraCharacteristics = this.i.getCameraCharacteristics("0");
                } catch (Exception e2) {
                    MPaasLogger.e("Camera2Characteristics", new Object[]{"initCameraCharacteristics exception:", e2.getMessage()});
                    cameraCharacteristics = null;
                }
                try {
                    Integer num = -1;
                    if (cameraCharacteristics != null && e(cameraCharacteristics)) {
                        num = (Integer) cameraCharacteristics.get(CameraCharacteristics.LENS_FACING);
                    }
                    if (this.b == num.intValue()) {
                        M = "0";
                        return cameraCharacteristics;
                    }
                } catch (Exception e3) {
                    e = e3;
                    MPaasLogger.e("Camera2Characteristics", new Object[]{"initCameraCharacteristics with error:"}, e);
                    return cameraCharacteristics;
                }
            } else {
                cameraCharacteristics = null;
            }
            String[] cameraIdList = this.i.getCameraIdList();
            this.j = cameraIdList;
            if (cameraIdList == null) {
                MPaasLogger.e("Camera2Characteristics", new Object[]{"initCameraCharacteristics cameraIdList == null."});
                this.h = b("cameraIdList == null");
                return cameraCharacteristics;
            }
            String str = null;
            CameraCharacteristics cameraCharacteristics2 = null;
            for (String str2 : cameraIdList) {
                if (!N || !"0".equalsIgnoreCase(str2)) {
                    SystraceWrapper.beginTrace("getCameraCharacteristics:" + str2);
                    CameraCharacteristics cameraCharacteristics3 = this.i.getCameraCharacteristics(str2);
                    SystraceWrapper.endTrace();
                    if (this.b == ((Integer) cameraCharacteristics3.get(CameraCharacteristics.LENS_FACING)).intValue()) {
                        if (str == null) {
                            cameraCharacteristics2 = cameraCharacteristics3;
                            str = str2;
                        }
                        if (!N) {
                            M = str2;
                            return cameraCharacteristics3;
                        } else if (e(cameraCharacteristics3)) {
                            M = str2;
                            return cameraCharacteristics3;
                        }
                    }
                }
            }
            M = str;
            return cameraCharacteristics2;
        } catch (Exception e4) {
            cameraCharacteristics = null;
            e = e4;
        }
    }

    private void o(Context context) {
        if (context == null) {
            MPaasLogger.w("Camera2Characteristics", new Object[]{"checkWhetherSupportApi2 with context == null."});
            return;
        }
        try {
            SystraceWrapper.beginTrace("initSystemCameraManager");
            CameraManager cameraManager = (CameraManager) context.getSystemService("camera");
            this.i = cameraManager;
            if (cameraManager == null) {
                return;
            }
            SystraceWrapper.endTrace();
            SystraceWrapper.beginTrace("getCameraCharacteristics");
            CameraCharacteristics n = n();
            this.J = n;
            r(n);
            p(this.J);
            q(this.J);
            SystraceWrapper.endTrace();
        } catch (Exception e) {
            MPaasLogger.d("Camera2Characteristics", new Object[]{"initCameraManager with exception:", e});
        }
    }

    private void p(CameraCharacteristics cameraCharacteristics) {
        if (cameraCharacteristics == null) {
            return;
        }
        SystraceWrapper.beginTrace("Get-Hardware-Level");
        this.c = ((Integer) cameraCharacteristics.get(CameraCharacteristics.INFO_SUPPORTED_HARDWARE_LEVEL)).intValue();
        SystraceWrapper.endTrace();
    }

    private void q(CameraCharacteristics cameraCharacteristics) {
        if (cameraCharacteristics != null) {
            this.L = (Integer) cameraCharacteristics.get(CameraCharacteristics.SENSOR_ORIENTATION);
        }
    }

    private void r(CameraCharacteristics cameraCharacteristics) {
        if (cameraCharacteristics == null) {
            return;
        }
        SystraceWrapper.beginTrace("Get-Stream-Configuration-Map");
        this.z = (StreamConfigurationMap) cameraCharacteristics.get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP);
        SystraceWrapper.endTrace();
    }

    private boolean s(CameraCharacteristics cameraCharacteristics) {
        Boolean bool;
        if (cameraCharacteristics == null || (bool = (Boolean) cameraCharacteristics.get(CameraCharacteristics.FLASH_INFO_AVAILABLE)) == null) {
            return false;
        }
        return bool.booleanValue();
    }

    public static void setEnableChooseCameraIdOptimize(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        N = BQCCameraParam.VALUE_YES.equalsIgnoreCase(str);
    }

    private String t(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("CameraId:" + M + ",Facing:" + Camera2Utils.cameraFacingToString(this.b) + "," + str);
        sb.append("^ErrorTime=");
        sb.append(Camera2Utils.getCurrentTime());
        return sb.toString();
    }

    public boolean containRequestKeys(CaptureRequest.Key<?> key) {
        List<CaptureRequest.Key<?>> list = this.B;
        if (list == null || list.size() <= 0) {
            return false;
        }
        return this.B.contains(key);
    }

    public int getAPI1Facing() {
        return this.a;
    }

    public Rect getActiveArraySize() {
        return this.g;
    }

    public int[] getAvailableAfModes() {
        return this.k;
    }

    public int[] getAvailableAwbModes() {
        return this.l;
    }

    public int[] getAvailableFdModes() {
        return this.m;
    }

    public Range<Integer>[] getAvailableFpsRangeList() {
        return this.y;
    }

    public boolean[] getAvailableHotPixelMapModes() {
        return this.o;
    }

    public int[] getAvailableLensShadingMapModes() {
        return this.n;
    }

    public int[] getAvailableOisDataModes() {
        return this.p;
    }

    public List<CaptureRequest.Key<?>> getAvailableSessionKeys() {
        return this.A;
    }

    public BQCScanError getBQCScanError() {
        return this.h;
    }

    public String getCameraIdStr() {
        return M;
    }

    public Rect getCropRegionForNonZoom() {
        if (this.g == null) {
            return null;
        }
        return new Rect(0, 0, com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.width(this.g), com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.height(this.g));
    }

    public Range<Integer> getFpsRange(Size size) {
        StreamConfigurationMap streamConfigurationMap;
        Range<Integer>[] rangeArr;
        Range<Integer>[] rangeArr2;
        Range<Integer> range = null;
        if (this.z != null && (rangeArr = this.y) != null && rangeArr.length != 0) {
            try {
                int outputMinFrameDuration = ((int) (1.0E9d / streamConfigurationMap.getOutputMinFrameDuration(this.d, size))) + 1;
                int i = 0;
                for (Range<Integer> range2 : this.y) {
                    if (range2.getUpper().intValue() <= outputMinFrameDuration && range2.getUpper().intValue() <= 30) {
                        if (range == null) {
                            range = range2;
                        }
                        int intValue = range2.getUpper().intValue() - range2.getLower().intValue();
                        if (intValue > i || (intValue == i && range.getLower().intValue() > range2.getLower().intValue())) {
                            range = range2;
                            i = intValue;
                        }
                    }
                }
            } catch (Throwable th) {
                MPaasLogger.e("Camera2Characteristics", new Object[]{"getFpsRange with exception:"}, th);
            }
        }
        return range;
    }

    public int getHardwareLevel() {
        return this.c;
    }

    public float getHyperFocusDistance() {
        return this.w;
    }

    public int getMaxAeRegionNum() {
        return this.u;
    }

    public int getMaxAfRegionNum() {
        return this.t;
    }

    public float getMaxFocusDistance() {
        return this.q;
    }

    public float getMaxZoom() {
        return this.s;
    }

    public List<Point> getOrderedOutputJpegSizeList() {
        return this.f;
    }

    public List<Point> getOrderedOutputYuvSizeList() {
        return this.e;
    }

    public Integer getSensorOrientation() {
        return this.L;
    }

    public CameraManager getSystemCameraManager() {
        return this.i;
    }

    public int getYuvFormat() {
        return this.d;
    }

    public boolean hasFocuser() {
        return this.q > 0.0f;
    }

    public void initCamera2CharacteristicsCache() {
        if (this.K) {
            MPaasLogger.d("Camera2Characteristics", new Object[]{"initCamera2CharacteristicsCache already init."});
            return;
        }
        SystraceWrapper.beginTrace("Cache-Init");
        MPaasLogger.d("Camera2Characteristics", new Object[]{"init begin."});
        CameraCharacteristics cameraCharacteristics = this.J;
        try {
        } catch (Exception e) {
            if (this.i == null) {
                this.h = c(e.toString());
            } else if (cameraCharacteristics == null) {
                this.h = a(e.toString());
            }
            MPaasLogger.e("Camera2Characteristics", new Object[]{"init exception:"}, e);
        }
        if (this.i == null) {
            MPaasLogger.e("Camera2Characteristics", new Object[]{"init CameraManager == null."});
            this.h = c("mCameraManager == null");
        } else if (M == null && this.b == 1) {
            MPaasLogger.d("Camera2Characteristics", new Object[]{"mCameraIdStr == null"});
            this.h = d("init mCameraIdStr == null");
        } else if (cameraCharacteristics == null) {
            MPaasLogger.d("Camera2Characteristics", new Object[]{"init cameraCharacteristics == null"});
            this.h = a("cameraCharacteristics == null");
        } else {
            Size[] outputSizes = this.z.getOutputSizes(35);
            Size[] outputSizes2 = this.z.getOutputSizes(256);
            this.e = Camera2Utils.sortedByDesc(outputSizes);
            this.f = Camera2Utils.sortedByDesc(outputSizes2);
            this.g = (Rect) cameraCharacteristics.get(CameraCharacteristics.SENSOR_INFO_ACTIVE_ARRAY_SIZE);
            this.k = (int[]) cameraCharacteristics.get(CameraCharacteristics.CONTROL_AF_AVAILABLE_MODES);
            this.l = (int[]) cameraCharacteristics.get(CameraCharacteristics.CONTROL_AWB_AVAILABLE_MODES);
            this.m = (int[]) cameraCharacteristics.get(CameraCharacteristics.STATISTICS_INFO_AVAILABLE_FACE_DETECT_MODES);
            this.n = (int[]) cameraCharacteristics.get(CameraCharacteristics.STATISTICS_INFO_AVAILABLE_LENS_SHADING_MAP_MODES);
            this.o = (boolean[]) cameraCharacteristics.get(CameraCharacteristics.STATISTICS_INFO_AVAILABLE_HOT_PIXEL_MAP_MODES);
            this.r = s(cameraCharacteristics);
            this.q = m(cameraCharacteristics);
            this.s = j(cameraCharacteristics);
            this.t = i(cameraCharacteristics);
            this.u = h(cameraCharacteristics);
            this.v = k(cameraCharacteristics);
            this.w = l(cameraCharacteristics);
            this.x = (int[]) cameraCharacteristics.get(CameraCharacteristics.REQUEST_AVAILABLE_CAPABILITIES);
            this.y = (Range[]) cameraCharacteristics.get(CameraCharacteristics.CONTROL_AE_AVAILABLE_TARGET_FPS_RANGES);
            if (Build.VERSION.SDK_INT >= 28) {
                this.p = (int[]) cameraCharacteristics.get(CameraCharacteristics.STATISTICS_INFO_AVAILABLE_OIS_DATA_MODES);
                this.A = cameraCharacteristics.getAvailableSessionKeys();
                this.H = (int[]) cameraCharacteristics.get(CameraCharacteristics.DISTORTION_CORRECTION_AVAILABLE_MODES);
            }
            this.B = cameraCharacteristics.getAvailableCaptureRequestKeys();
            this.C = (int[]) cameraCharacteristics.get(CameraCharacteristics.HOT_PIXEL_AVAILABLE_HOT_PIXEL_MODES);
            this.D = (int[]) cameraCharacteristics.get(CameraCharacteristics.EDGE_AVAILABLE_EDGE_MODES);
            this.E = (int[]) cameraCharacteristics.get(CameraCharacteristics.NOISE_REDUCTION_AVAILABLE_NOISE_REDUCTION_MODES);
            this.F = (int[]) cameraCharacteristics.get(CameraCharacteristics.SHADING_AVAILABLE_MODES);
            this.G = (int[]) cameraCharacteristics.get(CameraCharacteristics.TONEMAP_AVAILABLE_TONE_MAP_MODES);
            this.h = null;
            this.K = true;
            this.J = null;
            MPaasLogger.d("Camera2Characteristics", new Object[]{"init end."});
            SystraceWrapper.endTrace();
        }
    }

    public boolean isDistortionCorrectionSupport() {
        if (Build.VERSION.SDK_INT < 28) {
            return false;
        }
        return containRequestKeys(CaptureRequest.DISTORTION_CORRECTION_MODE);
    }

    public boolean isEdgeSupport() {
        return containRequestKeys(CaptureRequest.EDGE_MODE);
    }

    public boolean isHotPixelSupport() {
        return containRequestKeys(CaptureRequest.HOT_PIXEL_MODE);
    }

    public boolean isManualControlSupport() {
        return f(this.x, 1);
    }

    public boolean isNoiseReductionSupport() {
        return containRequestKeys(CaptureRequest.NOISE_REDUCTION_MODE);
    }

    public boolean isSessionKeys(CaptureRequest.Key<?> key) {
        List<CaptureRequest.Key<?>> list;
        if (key == null || (list = this.A) == null || list.size() <= 0) {
            return false;
        }
        return this.A.contains(key);
    }

    public boolean isShadingSupport() {
        return containRequestKeys(CaptureRequest.SHADING_MODE);
    }

    public boolean isSupportAfSceneChangedDetection() {
        return this.I;
    }

    public boolean isSupportDistortionCorrectionMode(int i) {
        return Camera2Utils.contains(this.H, i);
    }

    public boolean isSupportEdgeMode(int i) {
        return Camera2Utils.contains(this.D, i);
    }

    public boolean isSupportHotPixelMode(int i) {
        return Camera2Utils.contains(this.C, i);
    }

    public boolean isSupportNoiseReductionMode(int i) {
        return Camera2Utils.contains(this.E, i);
    }

    public boolean isSupportShadingMode(int i) {
        return Camera2Utils.contains(this.F, i);
    }

    public boolean isSupportToneMapMode(int i) {
        return Camera2Utils.contains(this.G, i);
    }

    public boolean isToneMapSupport() {
        return containRequestKeys(CaptureRequest.TONEMAP_MODE);
    }

    public void setSupportAfSceneChangedDetection() {
        this.I = true;
    }

    public boolean supportCamera2() {
        int i = this.c;
        return (i < 0 || this.z == null || i == 2) ? false : true;
    }

    public boolean supportCamera2Torch() {
        return this.r;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("API2Facing=" + Camera2Utils.cameraFacingToString(this.b));
        sb.append(", CameraId=" + M);
        sb.append(", HardwareLevel=" + Camera2Utils.hardwareLevelToString(this.c));
        sb.append(", activeArraySize=" + this.g);
        sb.append(", YuvFormat=" + this.d);
        sb.append(", OutputYuvSizeList=" + this.e);
        sb.append(", OutputJpegSizeList=" + this.f);
        sb.append(", mAvailableAfModes=" + Arrays.toString(this.k));
        sb.append(", mAvailableAwbModes=" + Arrays.toString(this.l));
        sb.append(", mAvailableFdModes=" + Arrays.toString(this.m));
        sb.append(", mMaxFocusDistance=" + this.q);
        sb.append(", mSupportTorch=" + this.r);
        sb.append(", mMaxZoom=" + this.s);
        sb.append(", mMaxAfRegionNum=" + this.t);
        sb.append(", mMaxAeRegionNum=" + this.u);
        sb.append(", mHyperFocusDistance=" + this.w);
        sb.append(", mAvailableCapabilities=" + Camera2Utils.capabilitiesToString(this.x));
        sb.append(", mAvailableFpsRangeArray=" + Camera2Utils.rangeArrayToString(this.y));
        sb.append(", mAvailableSessionKeys=" + String.valueOf(this.A));
        sb.append(", mFocusDistanceCalibration=" + Camera2Utils.focusDistanceCalibrationToString(this.v));
        return sb.toString();
    }

    public boolean valid() {
        return (this.i == null || this.a < 0 || M == null || this.c <= -1 || this.d <= -1 || this.e == null || this.f == null || this.g == null) ? false : true;
    }

    public Camera2CharacteristicsCache(Context context, boolean z) {
        this.c = -1;
        this.d = 35;
        this.K = false;
        this.a = 0;
        this.b = g(0);
        o(context);
        if (z) {
            initCamera2CharacteristicsCache();
        }
    }

    public Camera2CharacteristicsCache(Context context, int i, boolean z) {
        this.c = -1;
        this.d = 35;
        this.K = false;
        this.a = i;
        this.b = g(i);
        o(context);
        if (z) {
            initCamera2CharacteristicsCache();
        }
    }
}
