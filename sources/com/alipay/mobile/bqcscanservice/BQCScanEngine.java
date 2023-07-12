package com.alipay.mobile.bqcscanservice;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Rect;
import android.hardware.Camera;
import com.alipay.camera2.operation.callback.OnReadImageListener;
import com.alipay.mobile.bqcscanservice.BQCCameraParam;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public abstract class BQCScanEngine {
    public static final String AR_ENGINE = "AR";
    public static final String COUPON_ENGINE = "COUPON";
    public static final String MA_ENGINE = "MA";
    public static final String THINGS_ENGINE = "things";
    public static final String TRANSLATOR_ENGINE = "translate";

    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    public interface EngineCallback {
    }

    public abstract void destroy();

    public float getCodeSize() {
        return 0.0f;
    }

    public BaseFrameMetaInfo getCurrentCameraFrame() {
        return null;
    }

    public long getDurationOfBlur() {
        return -1L;
    }

    public long getDurationOfNonNeedCheckBlur() {
        return 0L;
    }

    public long[] getRecognizeResult() {
        return null;
    }

    public Map<String, String> getResultExtInfo() {
        return null;
    }

    public Map<String, String> getRunningInfo() {
        return null;
    }

    public abstract boolean init(Context context, Map<String, Object> map);

    public boolean isQrCodeEngine() {
        return false;
    }

    public void markEachEngineFrameIn(long j) {
    }

    public void markFirstFrameIn(long j) {
    }

    public abstract boolean onProcessFinish(BQCScanResult bQCScanResult);

    public abstract BQCScanResult process(Bitmap bitmap);

    public BQCScanResult process(byte[] bArr, Rect rect, Point point, int i, int i2) {
        return null;
    }

    public abstract BQCScanResult process(byte[] bArr, Camera camera, Rect rect, Camera.Size size, int i);

    public BQCScanResult process(OnReadImageListener.ScanImagePlanes[] scanImagePlanesArr, Rect rect, Point point, int i) {
        return null;
    }

    public void setEngineMemoryDownGrade() {
    }

    public void setExtInfo(String str, Object obj) {
    }

    public abstract void setResultCallback(EngineCallback engineCallback);

    public void setSubScanType(BQCCameraParam.MaEngineType maEngineType) {
        setSubScanType(maEngineType, null);
    }

    public void setSubScanType(BQCCameraParam.MaEngineType maEngineType, String str) {
    }

    public void setWhetherFirstSetup(boolean z) {
    }

    public abstract void start();

    public boolean whetherBqcScanCallbackRegisted() {
        return true;
    }
}
