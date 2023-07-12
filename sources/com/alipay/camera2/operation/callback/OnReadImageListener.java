package com.alipay.camera2.operation.callback;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.media.Image;
import android.media.ImageReader;
import android.os.Debug;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.collection.ArrayMap;
import com.alipay.camera2.util.SystraceWrapper;
import com.alipay.mobile.bqcscanservice.BQCCameraParam;
import com.alipay.mobile.bqcscanservice.BQCScanCallback;
import com.alipay.mobile.bqcscanservice.BQCScanEngine;
import com.alipay.mobile.bqcscanservice.BQCScanError;
import com.alipay.mobile.bqcscanservice.BQCScanResult;
import com.alipay.mobile.bqcscanservice.MPaasLogger;
import com.alipay.mobile.bqcscanservice.behavior.WalletBury;
import com.alipay.mobile.bqcscanservice.executor.ScanRecognizedExecutor;
import com.alipay.mobile.bqcscanservice.impl.BQCScanTask;
import com.alipay.mobile.bqcscanservice.monitor.ScanCodeState;
import java.nio.ByteBuffer;
import java.util.Map;
import tb.jn1;

/* compiled from: Taobao */
@SuppressLint({"NewApi"})
/* loaded from: classes12.dex */
public class OnReadImageListener implements ImageReader.OnImageAvailableListener {
    public static final String TAG = "OnReadImageListener";
    private boolean A;
    private long B;
    private int C;
    private BQCScanCallback a;
    private ArrayMap<String, Class<? extends BQCScanEngine>> b;
    private ArrayMap<String, BQCScanEngine.EngineCallback> c;
    private Context d;
    private BQCScanEngine e;
    private Map<String, Map<String, Object>> f;
    private boolean g;
    private String h;
    private boolean i;
    private Rect j;
    private ScanTask l;
    private boolean m;
    private Point n;
    private byte[] o;
    private ScanImagePlanes[] p;
    private boolean t;
    private final FirstFrameCallback v;
    private ScanCodeState x;
    private long y;
    private boolean z;
    private boolean q = false;
    private boolean r = false;
    private volatile boolean s = false;
    private TaskPool k = new TaskPool(this);
    private long u = 0;
    private int w = 0;

    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    public interface FirstFrameCallback {
        void onFirstFrameArrived(long j);
    }

    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    public static class ScanImagePlanes {
        int a;
        int b;
        byte[] c;

        public byte[] getBuffer() {
            return this.c;
        }

        public int getPixelStride() {
            return this.b;
        }

        public int getRowStride() {
            return this.a;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public class ScanTask extends BQCScanTask<BQCScanResult> {
        private boolean autoDestroy = false;
        private long curFrameTimestamp;
        private BQCScanEngine engine;
        private boolean firstFrameIn;
        private boolean isBusy;

        public ScanTask() {
        }

        public void autoDestroyEngine() {
            if (!this.isBusy) {
                OnReadImageListener.this.r(this.engine);
            } else {
                this.autoDestroy = true;
            }
        }

        protected BQCScanResult doInBackground() {
            Rect s;
            BQCScanResult process;
            if (MPaasLogger.isDebuggable()) {
                SystraceWrapper.beginTrace("Recognize-Frame");
            }
            if (!OnReadImageListener.this.s && OnReadImageListener.this.i && this.engine != null && OnReadImageListener.this.n != null) {
                try {
                    if (OnReadImageListener.this.j != null) {
                        s = OnReadImageListener.this.j;
                    } else {
                        OnReadImageListener onReadImageListener = OnReadImageListener.this;
                        s = onReadImageListener.s(com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(onReadImageListener.n), com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(OnReadImageListener.this.n));
                    }
                    byte[] bArr = this.mData;
                    if (bArr != null && this.strideWidth > 0) {
                        process = this.engine.process(bArr, s, OnReadImageListener.this.n, this.strideWidth, this.mPreviewFormat);
                    } else {
                        ScanImagePlanes[] scanImagePlanesArr = this.planes;
                        process = scanImagePlanesArr != null ? this.engine.process(scanImagePlanesArr, s, OnReadImageListener.this.n, this.mPreviewFormat) : null;
                    }
                    SystraceWrapper.endTrace();
                    if (OnReadImageListener.this.x != null) {
                        if (OnReadImageListener.this.n != null) {
                            OnReadImageListener.this.x.setPreviewSize(com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(OnReadImageListener.this.n) * com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(OnReadImageListener.this.n));
                        }
                        if (s != null) {
                            OnReadImageListener.this.x.setCodeSize(s.bottom * s.right);
                        }
                    }
                    return process;
                } catch (Exception e) {
                    MPaasLogger.e(OnReadImageListener.TAG, new Object[]{"scan task doInBackground exception"}, e);
                }
            }
            SystraceWrapper.endTrace();
            return null;
        }

        @Override // com.alipay.mobile.bqcscanservice.impl.BQCScanTask
        protected void onPreExecute() {
            if ("MA".equals(OnReadImageListener.this.h) && !OnReadImageListener.this.A && OnReadImageListener.this.B > 0) {
                try {
                    if (SystemClock.elapsedRealtime() - OnReadImageListener.this.B >= 1000) {
                        if (OnReadImageListener.this.z) {
                            this.engine.setEngineMemoryDownGrade();
                        }
                        OnReadImageListener.this.A = true;
                    }
                } catch (Exception e) {
                    MPaasLogger.d(OnReadImageListener.TAG, new Object[]{"onPreExecute: onPreExecute Exception, ", e.getMessage()});
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            long threadCpuTimeNanos = Debug.threadCpuTimeNanos();
            onPreExecute();
            BQCScanResult doInBackground = doInBackground();
            long threadCpuTimeNanos2 = Debug.threadCpuTimeNanos();
            long elapsedRealtime2 = SystemClock.elapsedRealtime();
            if (OnReadImageListener.this.x != null) {
                OnReadImageListener.this.x.accumulateFrameRecognize(elapsedRealtime - this.curFrameTimestamp, elapsedRealtime2 - elapsedRealtime, (threadCpuTimeNanos2 - threadCpuTimeNanos) / 1000000);
            }
            onPostExecute(doInBackground);
        }

        public void setCurFrameTimestamp(long j) {
            this.curFrameTimestamp = j;
        }

        public void setEngine(BQCScanEngine bQCScanEngine) {
            this.engine = bQCScanEngine;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.alipay.mobile.bqcscanservice.impl.BQCScanTask
        public void onPostExecute(BQCScanResult bQCScanResult) {
            BQCScanEngine bQCScanEngine;
            if (OnReadImageListener.this.i && (bQCScanEngine = this.engine) != null) {
                try {
                    if (bQCScanEngine.onProcessFinish(bQCScanResult)) {
                        OnReadImageListener.this.i = false;
                        OnReadImageListener.this.t = true;
                    }
                } catch (Exception unused) {
                    MPaasLogger.e(OnReadImageListener.TAG, new Object[]{"scan task onPostExecute exception"});
                }
            }
            if (this.autoDestroy) {
                OnReadImageListener.this.r(this.engine);
            }
            this.isBusy = false;
            this.mData = null;
            this.mCamera = null;
            this.mPreviewSize = null;
            if (OnReadImageListener.this.k != null) {
                OnReadImageListener.this.k.returnTask();
            }
        }

        public ScanTask(BQCScanEngine bQCScanEngine) {
            this.engine = bQCScanEngine;
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    public class TaskPool {
        private ScanTask[] c = new ScanTask[3];
        private volatile int a = 3;
        private volatile int b = 0;

        public TaskPool(OnReadImageListener onReadImageListener) {
            for (int i = 0; i < 3; i++) {
                this.c[i] = new ScanTask();
            }
        }

        public ScanTask getTask() {
            if (this.a == 0) {
                return null;
            }
            this.a--;
            int i = this.b;
            this.b = (this.b + 1) % 3;
            this.c[i].firstFrameIn = false;
            return this.c[i];
        }

        public void returnTask() {
            this.a++;
        }
    }

    public OnReadImageListener(Context context, Map<String, Map<String, Object>> map, boolean z, FirstFrameCallback firstFrameCallback, ScanCodeState scanCodeState) {
        this.d = context;
        this.f = map;
        this.g = z;
        this.v = firstFrameCallback;
        this.x = scanCodeState;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(BQCScanEngine bQCScanEngine) {
        this.A = false;
        this.B = -1L;
        if (bQCScanEngine != null) {
            try {
                bQCScanEngine.destroy();
            } catch (Exception unused) {
                MPaasLogger.e(TAG, new Object[]{"engine destroy exception"});
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Rect s(int i, int i2) {
        int i3 = (i / 2) - 400;
        int i4 = (i2 / 2) - 400;
        if (i3 < 0) {
            i3 = 0;
        }
        if (i4 < 0) {
            i4 = 0;
        }
        Rect rect = new Rect(i3, i4, 800, 800);
        MPaasLogger.d(TAG, new Object[]{"scanRegion is null, getDefaultRect rect: ", rect.toString()});
        return rect;
    }

    public boolean checkEngineRegister(String str) {
        ArrayMap<String, Class<? extends BQCScanEngine>> arrayMap;
        return (TextUtils.isEmpty(str) || (arrayMap = this.b) == null || arrayMap.get(str) == null) ? false : true;
    }

    public void cleanUp() {
        ScanTask scanTask = this.l;
        if (scanTask != null) {
            scanTask.autoDestroyEngine();
        } else {
            r(this.e);
        }
        this.l = null;
        this.e = null;
        this.d = null;
        this.a = null;
        this.b = null;
        this.c = null;
        this.u = 0L;
    }

    public long getDurationOfBlur() {
        try {
            BQCScanEngine bQCScanEngine = this.e;
            if (bQCScanEngine != null) {
                return bQCScanEngine.getDurationOfBlur();
            }
            return -1L;
        } catch (Throwable unused) {
            return -1L;
        }
    }

    public long getDurationOfNonNeedCheckBlur() {
        try {
            BQCScanEngine bQCScanEngine = this.e;
            if (bQCScanEngine != null) {
                return bQCScanEngine.getDurationOfNonNeedCheckBlur();
            }
            return 0L;
        } catch (Throwable unused) {
            return 0L;
        }
    }

    public Map<String, String> getEngineRunningInfo(String str) {
        BQCScanEngine bQCScanEngine;
        if (TextUtils.isEmpty(str) || !TextUtils.equals(this.h, str) || (bQCScanEngine = this.e) == null) {
            return null;
        }
        return bQCScanEngine.getRunningInfo();
    }

    public long getFrameCountInCamera() {
        return this.u;
    }

    public long[] getRecognizeResult() {
        BQCScanEngine bQCScanEngine = this.e;
        if (bQCScanEngine == null || !bQCScanEngine.isQrCodeEngine()) {
            return null;
        }
        return this.e.getRecognizeResult();
    }

    public Map<String, String> getSpecEngineExtInfo(String str) {
        BQCScanEngine bQCScanEngine;
        if (TextUtils.isEmpty(str) || !TextUtils.equals(this.h, str) || (bQCScanEngine = this.e) == null) {
            return null;
        }
        return bQCScanEngine.getResultExtInfo();
    }

    public boolean isScanEnable() {
        return this.i;
    }

    public void needDowngrade(boolean z) {
        this.z = z;
    }

    @Override // android.media.ImageReader.OnImageAvailableListener
    public void onImageAvailable(ImageReader imageReader) {
        Image acquireLatestImage;
        int i;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long j = this.y;
        if (j != 0) {
            long j2 = elapsedRealtime - j;
            ScanCodeState scanCodeState = this.x;
            if (scanCodeState != null) {
                scanCodeState.accumulateFrameGap(j2);
            }
        } else {
            ScanCodeState scanCodeState2 = this.x;
            if (scanCodeState2 != null) {
                scanCodeState2.accumulateFrameGap(0L);
            }
        }
        this.u++;
        if (MPaasLogger.isDebuggable()) {
            SystraceWrapper.beginTrace("onImageAvailable-No." + this.u);
        }
        Image image = null;
        Image.Plane[] planeArr = null;
        try {
            if (!this.q) {
                MPaasLogger.d(TAG, new Object[]{"onImageAvailable()"});
                this.v.onFirstFrameArrived(System.currentTimeMillis());
                BQCScanCallback bQCScanCallback = this.a;
                if (bQCScanCallback != null && this.r) {
                    bQCScanCallback.onPreviewFrameShow();
                }
                this.q = true;
                this.C = 0;
            }
            acquireLatestImage = imageReader.acquireLatestImage();
            try {
            } catch (Exception e) {
                e = e;
                image = acquireLatestImage;
                MPaasLogger.e(TAG, new Object[]{"onImageAvailable"}, e);
                if (image != null) {
                    try {
                        image.close();
                    } catch (Exception unused) {
                        MPaasLogger.e(TAG, new Object[]{"onImageAvailable: ", "image.close() failed"});
                    }
                }
                SystraceWrapper.endTrace();
                return;
            }
        } catch (Exception e2) {
            e = e2;
        }
        if (acquireLatestImage == null) {
            SystraceWrapper.endTrace();
            MPaasLogger.d(TAG, new Object[]{"onImageAvailable: image=null"});
            this.y = 0L;
        } else if (!this.m) {
            acquireLatestImage.close();
            SystraceWrapper.endTrace();
            MPaasLogger.d(TAG, new Object[]{"onImageAvailable: mCameraValid = false"});
            this.y = 0L;
        } else {
            boolean z = this.i;
            if (z && this.h != null) {
                if (this.t) {
                    this.q = true;
                    SystraceWrapper.endTrace();
                    MPaasLogger.d(TAG, new Object[]{"onPreviewFrame mRecognizeEnd = true"});
                    this.y = 0L;
                    return;
                }
                int format = acquireLatestImage.getFormat();
                if (this.n == null) {
                    Point point = new Point(acquireLatestImage.getWidth(), acquireLatestImage.getHeight());
                    this.n = point;
                    if (com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(point) <= 0 || com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(point) <= 0 || format <= 0) {
                        MPaasLogger.d(TAG, new Object[]{"onImageAvailable: mPreviewSizeP is invalid"});
                        acquireLatestImage.close();
                        this.n = null;
                        SystraceWrapper.endTrace();
                        this.y = 0L;
                        return;
                    }
                }
                if (!ScanRecognizedExecutor.isEmpty(false)) {
                    SystraceWrapper.endTrace();
                    MPaasLogger.d(TAG, new Object[]{"ScanRecognizedExecutor is not empty"});
                    this.y = 0L;
                    int i2 = this.C + 1;
                    this.C = i2;
                    if (i2 >= 20) {
                        WalletBury.addWalletBury("recordScanFrameOmit", new Class[0], new Object[0]);
                        this.C = 0;
                    }
                    acquireLatestImage.close();
                    return;
                }
                this.C = 0;
                try {
                    planeArr = acquireLatestImage.getPlanes();
                } catch (Exception e3) {
                    MPaasLogger.e(TAG, new Object[]{"getPlanes with exception:"}, e3);
                }
                if (planeArr != null && planeArr.length != 0) {
                    if (this.h.equals("MA")) {
                        ByteBuffer buffer = planeArr[0].getBuffer();
                        i = planeArr[0].getRowStride();
                        int remaining = buffer.remaining();
                        byte[] bArr = this.o;
                        if (bArr == null || remaining != bArr.length) {
                            this.o = new byte[buffer.remaining()];
                        }
                        byte[] bArr2 = this.o;
                        buffer.get(bArr2, 0, bArr2.length);
                        acquireLatestImage.close();
                        if (this.o == null) {
                            MPaasLogger.d(TAG, new Object[]{"onImageAvailable: data is null"});
                            SystraceWrapper.endTrace();
                            this.y = 0L;
                            return;
                        }
                    } else if (planeArr.length != 3) {
                        acquireLatestImage.close();
                        return;
                    } else {
                        if (this.p == null) {
                            ScanImagePlanes[] scanImagePlanesArr = new ScanImagePlanes[3];
                            this.p = scanImagePlanesArr;
                            scanImagePlanesArr[0] = new ScanImagePlanes();
                            this.p[1] = new ScanImagePlanes();
                            this.p[2] = new ScanImagePlanes();
                        }
                        for (int i3 = 0; i3 < 3; i3++) {
                            this.p[i3].a = planeArr[i3].getRowStride();
                            this.p[i3].b = planeArr[i3].getPixelStride();
                            ScanImagePlanes[] scanImagePlanesArr2 = this.p;
                            if (scanImagePlanesArr2[i3].c == null || scanImagePlanesArr2[i3].c.length != planeArr[i3].getBuffer().remaining()) {
                                this.p[i3].c = new byte[planeArr[i3].getBuffer().remaining()];
                            }
                            ByteBuffer buffer2 = planeArr[i3].getBuffer();
                            ScanImagePlanes[] scanImagePlanesArr3 = this.p;
                            buffer2.get(scanImagePlanesArr3[i3].c, 0, scanImagePlanesArr3[i3].c.length);
                        }
                        acquireLatestImage.close();
                        i = 0;
                    }
                    TaskPool taskPool = this.k;
                    if (taskPool != null) {
                        ScanTask task = taskPool.getTask();
                        this.l = task;
                        if (task != null) {
                            if (MPaasLogger.isDebuggable()) {
                                SystraceWrapper.beginTrace("execute-scan-task");
                            }
                            this.l.setEngine(this.e);
                            if (this.h.equals("MA")) {
                                this.l.setData(this.o, this.n, i, format);
                            } else {
                                this.l.setData(this.p, this.n, format);
                            }
                            this.l.setCurFrameTimestamp(elapsedRealtime);
                            if (this.w == 1) {
                                this.l.firstFrameIn = true;
                            }
                            ScanRecognizedExecutor.execute(false, this.l, this.w == 5);
                            SystraceWrapper.endTrace();
                        }
                        this.w++;
                    }
                    this.y = SystemClock.elapsedRealtime();
                    SystraceWrapper.endTrace();
                    return;
                }
                MPaasLogger.d(TAG, new Object[]{"onImageAvailable: image.planes is invalid"});
                acquireLatestImage.close();
                SystraceWrapper.endTrace();
                this.y = 0L;
                return;
            }
            MPaasLogger.d(TAG, new Object[]{"onImageAvailable: mScanEnable=", Boolean.valueOf(z), ", mScanType=", this.h});
            acquireLatestImage.close();
            SystraceWrapper.endTrace();
            this.y = 0L;
        }
    }

    public void processWhetherStopMaRecognize(final boolean z, final Runnable runnable) {
        ScanRecognizedExecutor.execute(false, new Runnable() { // from class: com.alipay.camera2.operation.callback.OnReadImageListener.1
            @Override // java.lang.Runnable
            public void run() {
                OnReadImageListener.this.s = z;
                if (runnable != null && !OnReadImageListener.this.t) {
                    runnable.run();
                }
                MPaasLogger.d(OnReadImageListener.TAG, new Object[]{"ScanNetworkChangeMonitor mRecognizeEnd=", Boolean.valueOf(OnReadImageListener.this.t), "^stopMaRecognize=", Boolean.valueOf(OnReadImageListener.this.s)});
            }
        }, false);
    }

    public void regScanEngine(String str, Class<? extends BQCScanEngine> cls, BQCScanEngine.EngineCallback engineCallback) {
        if (str == null || cls == null) {
            return;
        }
        if (this.b == null) {
            this.b = new ArrayMap<>();
        }
        this.b.put(str, cls);
        if (this.c == null) {
            this.c = new ArrayMap<>();
        }
        this.c.put(str, engineCallback);
    }

    public void setCameraValid(boolean z) {
        this.m = z;
    }

    public void setEngineExtInfo(String str, Object obj) {
        BQCScanEngine bQCScanEngine = this.e;
        if (bQCScanEngine != null) {
            bQCScanEngine.setExtInfo(str, obj);
        }
    }

    public void setEngineParams(String str, Map<String, Object> map) {
        if (str == null) {
            return;
        }
        if (map == null) {
            this.f.remove(str);
        } else {
            this.f.put(str, map);
        }
    }

    public void setNeedReportPreviewGot(boolean z) {
        this.r = z;
    }

    public void setResultCallback(BQCScanCallback bQCScanCallback) {
        this.a = bQCScanCallback;
    }

    public void setScanEnable(boolean z) {
        BQCScanEngine bQCScanEngine;
        this.i = z;
        if (z && (bQCScanEngine = this.e) != null) {
            this.t = false;
            bQCScanEngine.start();
            this.B = SystemClock.elapsedRealtime();
        } else {
            this.B = SystemClock.elapsedRealtime();
            this.A = false;
        }
        MPaasLogger.e(TAG, new Object[]{"setScanEnable(", Boolean.valueOf(z), jn1.BRACKET_END_STR});
    }

    public void setScanRegion(Rect rect) {
        Object[] objArr = new Object[2];
        objArr[0] = "setScanRegion:";
        objArr[1] = rect != null ? rect.toString() : "null";
        MPaasLogger.d(TAG, objArr);
        this.j = rect;
    }

    public boolean setScanType(String str, BQCCameraParam.MaEngineType maEngineType) {
        return setScanType(str, maEngineType, null);
    }

    public boolean setScanType(String str, BQCCameraParam.MaEngineType maEngineType, String str2) {
        boolean z;
        BQCScanError bQCScanError;
        Object[] objArr = new Object[8];
        objArr[0] = "setScanType(): curScanType: ";
        objArr[1] = this.h;
        objArr[2] = ",setScanType: ";
        objArr[3] = str;
        objArr[4] = ", subEngineType: ";
        objArr[5] = maEngineType == null ? "null" : maEngineType.name();
        objArr[6] = " ,extraType: ";
        objArr[7] = str2;
        MPaasLogger.d(TAG, objArr);
        if (str == null || this.b == null || this.f == null) {
            return false;
        }
        if (str.equals(this.h)) {
            return true;
        }
        try {
            Class<? extends BQCScanEngine> cls = this.b.get(str);
            if (cls == null) {
                return false;
            }
            if (this.i) {
                this.i = false;
                z = true;
            } else {
                z = false;
            }
            try {
                ScanTask scanTask = this.l;
                if (scanTask != null) {
                    scanTask.autoDestroyEngine();
                } else {
                    r(this.e);
                }
                MPaasLogger.d(TAG, new Object[]{"setScanType(): Begin to init engine class"});
                this.e = cls.newInstance();
                MPaasLogger.d(TAG, new Object[]{"setScanType(): End to init engine class"});
                if (!this.e.init(this.d, this.f.get(str))) {
                    this.e = null;
                    bQCScanError = new BQCScanError(BQCScanError.ErrorType.ERROR_INIT_ENGINE, "init engine fail", 1000, BQCScanError.CameraAPIType.API2);
                } else {
                    ArrayMap<String, BQCScanEngine.EngineCallback> arrayMap = this.c;
                    if (arrayMap != null) {
                        this.e.setResultCallback(arrayMap.get(str));
                    }
                    bQCScanError = null;
                }
                MPaasLogger.d(TAG, new Object[]{"setScanType(): end to init the engine"});
            } catch (Exception e) {
                this.e = null;
                bQCScanError = new BQCScanError(BQCScanError.ErrorType.ERROR_INIT_ENGINE, "init engine fail:" + e.getMessage(), 1000, BQCScanError.CameraAPIType.API2);
            }
            if (bQCScanError != null) {
                BQCScanCallback bQCScanCallback = this.a;
                if (bQCScanCallback != null) {
                    bQCScanCallback.onError(bQCScanError);
                }
                return false;
            }
            this.h = str;
            BQCScanEngine bQCScanEngine = this.e;
            if (bQCScanEngine != null) {
                bQCScanEngine.setSubScanType(maEngineType, str2);
                this.e.setWhetherFirstSetup(this.g);
            }
            if (z) {
                this.i = true;
            }
            if (this.i) {
                this.t = false;
                this.e.start();
            }
            return true;
        } catch (Exception e2) {
            MPaasLogger.e(TAG, new Object[]{"Set ScanType failed"}, e2);
            return false;
        }
    }
}
