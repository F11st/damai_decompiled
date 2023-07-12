package com.alipay.mobile.bqcscanservice.impl;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.hardware.Camera;
import android.os.Debug;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.collection.ArrayMap;
import com.alipay.camera.base.AntCamera;
import com.alipay.mobile.bqcscanservice.BQCCameraParam;
import com.alipay.mobile.bqcscanservice.BQCScanCallback;
import com.alipay.mobile.bqcscanservice.BQCScanEngine;
import com.alipay.mobile.bqcscanservice.BQCScanError;
import com.alipay.mobile.bqcscanservice.BQCScanResult;
import com.alipay.mobile.bqcscanservice.CameraHandler;
import com.alipay.mobile.bqcscanservice.MPaasLogger;
import com.alipay.mobile.bqcscanservice.MPaasScanService;
import com.alipay.mobile.bqcscanservice.behavior.WalletBury;
import com.alipay.mobile.bqcscanservice.executor.ScanRecognizedExecutor;
import com.alipay.mobile.bqcscanservice.monitor.ScanCodeState;
import com.alipay.mobile.bqcscanservice.monitor.ScanResultMonitor;
import java.util.Map;
import tb.jn1;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class BQCScanController extends AntCamera.PreviewCallbackProxy {
    public static int cameraFrameDelay;
    public static boolean gcFirstFrame;
    public static PerfCompute mPerfCompute = new PerfCompute();
    private boolean A;
    private Camera.Parameters D;
    private int E;
    private final FrameCallback H;
    private ScanCodeState I;
    private long J;
    private boolean K;
    private MPaasScanService L;
    private Context a;
    private BQCScanCallback b;
    private ArrayMap<String, Class<? extends BQCScanEngine>> c;
    private ArrayMap<String, BQCScanEngine.EngineCallback> d;
    private ScanTask f;
    private Map<String, Map<String, Object>> m;
    public long mEngineWaitDuration;
    public long mTaskEndTimestamp;
    private Camera.Size n;
    private CameraHandler p;
    private AntCamera q;
    private boolean r;
    private boolean t;
    private volatile boolean v;
    private boolean w;
    private boolean x;
    private volatile boolean y;
    private volatile boolean z;
    private BQCScanEngine e = null;
    private String g = null;
    private Rect h = null;
    private volatile boolean i = false;
    private volatile byte[] j = null;
    private volatile byte[] k = null;
    private int l = 1;
    private int o = -1;
    public long mFirstFrameTimestamp = -1;
    private volatile long B = -1;
    private volatile boolean C = false;
    private volatile boolean F = false;
    private volatile boolean G = false;
    private volatile ScanResultMonitor s = new ScanResultMonitor();
    private TaskPool u = new TaskPool(this);

    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    public interface FrameCallback {
        void onPreviewFrame(AntCamera antCamera);
    }

    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    public static class PerfCompute {
        long a;
        long b;
        long c;
        String d;

        public PerfCompute() {
            reset();
        }

        public void addFrame() {
            if (this.a == 0) {
                this.a = System.currentTimeMillis();
            }
            this.b++;
            long currentTimeMillis = System.currentTimeMillis();
            String str = this.d;
            if (str != null && str.length() < 120) {
                long j = this.c;
                if (j == 0) {
                    if (currentTimeMillis - this.a >= 1000) {
                        this.d += "0,";
                    }
                } else {
                    long j2 = this.a;
                    if ((currentTimeMillis - j2) / 1000 > (j - j2) / 1000) {
                        this.d += this.b + ",";
                    }
                }
            }
            this.c = currentTimeMillis;
        }

        public long getFrameNumPerSecond() {
            long j = this.c;
            if (j > 0) {
                long j2 = this.a;
                if (j2 > 0 && j - j2 > 0) {
                    long j3 = this.b;
                    if (j3 > 1) {
                        return (j3 * 1000) / (j - j2);
                    }
                }
            }
            return 0L;
        }

        public String getFrameRecord() {
            long j = this.c;
            if (j > 0) {
                long j2 = this.a;
                if (j2 <= 0 || j - j2 <= 0 || this.b <= 1) {
                    return null;
                }
                return this.d;
            }
            return null;
        }

        public void reset() {
            this.a = 0L;
            this.b = 0L;
            this.c = 0L;
            this.d = "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public class ScanTask extends BQCScanTask<BQCScanResult> {
        private long curFrameTimestamp;
        private BQCScanEngine engine;
        private boolean isFirstTask;

        public ScanTask() {
        }

        private Rect getDefaultRect(int i, int i2) {
            int i3 = (i / 2) - 400;
            int i4 = (i2 / 2) - 400;
            if (i3 < 0) {
                i3 = 0;
            }
            if (i4 < 0) {
                i4 = 0;
            }
            Rect rect = new Rect(i3, i4, 800, 800);
            MPaasLogger.d("BQCScanController", new Object[]{"scanRegion is null, getDefaultRect rect: ", rect});
            return rect;
        }

        public void autoDestroyEngine() {
            BQCScanController.this.y(this.engine);
        }

        protected BQCScanResult doInBackground() {
            BQCScanEngine bQCScanEngine;
            Rect defaultRect;
            if (BQCScanController.this.F || !BQCScanController.this.i || (bQCScanEngine = this.engine) == null) {
                Object[] objArr = new Object[6];
                objArr[0] = "ScanNetworkChangeMonitor ScanTask scanEnable=";
                objArr[1] = Boolean.valueOf(BQCScanController.this.i);
                objArr[2] = "^stopMaRecognize=";
                objArr[3] = Boolean.valueOf(BQCScanController.this.F);
                objArr[4] = "^engineisNull=";
                objArr[5] = Boolean.valueOf(this.engine != null);
                MPaasLogger.d("BQCScanController", objArr);
                return null;
            }
            try {
                if (!bQCScanEngine.whetherBqcScanCallbackRegisted()) {
                    try {
                        this.engine.setResultCallback((BQCScanEngine.EngineCallback) BQCScanController.this.d.get(BQCScanController.this.g));
                    } catch (Exception e) {
                        MPaasLogger.e("BQCScanController", new Object[]{e.getMessage()});
                    }
                }
                if (BQCScanController.this.h != null) {
                    defaultRect = BQCScanController.this.h;
                } else {
                    Camera.Size size = this.mPreviewSize;
                    defaultRect = getDefaultRect(size.width, size.height);
                }
                Rect rect = defaultRect;
                if (BQCScanController.this.I != null && rect != null) {
                    BQCScanController.this.I.setCodeSize(rect.bottom * rect.right);
                }
                if (BQCScanController.this.I != null && this.mPreviewSize != null) {
                    ScanCodeState scanCodeState = BQCScanController.this.I;
                    Camera.Size size2 = this.mPreviewSize;
                    scanCodeState.setPreviewSize(size2.width * size2.height);
                }
                if (BQCScanController.this.w) {
                    long currentTimeMillis = System.currentTimeMillis();
                    BQCScanResult process = this.engine.process(this.mData, this.mCamera, rect, this.mPreviewSize, this.mPreviewFormat);
                    BQCScanController.this.reportCameraFrameRecognized(process != null, System.currentTimeMillis() - currentTimeMillis);
                    return process;
                }
                return this.engine.process(this.mData, this.mCamera, rect, this.mPreviewSize, this.mPreviewFormat);
            } catch (Exception unused) {
                MPaasLogger.e("BQCScanController", new Object[]{"scan task doInBackground exception"});
                return null;
            }
        }

        @Override // com.alipay.mobile.bqcscanservice.impl.BQCScanTask
        protected void onPreExecute() {
            if ("MA".equals(BQCScanController.this.g) && !BQCScanController.this.C && BQCScanController.this.B > 0) {
                try {
                    if (SystemClock.elapsedRealtime() - BQCScanController.this.B >= 1000) {
                        if (BQCScanController.this.K) {
                            BQCScanController.this.e.setEngineMemoryDownGrade();
                        }
                        BQCScanController.this.C = true;
                    }
                } catch (Exception e) {
                    MPaasLogger.e("BQCScanController", new Object[]{"onPreExecute: ", e.getMessage()});
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            onPreExecute();
            long elapsedRealtime = SystemClock.elapsedRealtime();
            long threadCpuTimeNanos = Debug.threadCpuTimeNanos();
            BQCScanResult doInBackground = doInBackground();
            MPaasLogger.d("BQCScanController", new Object[]{"ScanResult == ", doInBackground});
            long threadCpuTimeNanos2 = Debug.threadCpuTimeNanos();
            long elapsedRealtime2 = SystemClock.elapsedRealtime();
            if (BQCScanController.this.I != null) {
                BQCScanController.this.I.accumulateFrameRecognize(elapsedRealtime - this.curFrameTimestamp, elapsedRealtime2 - elapsedRealtime, (threadCpuTimeNanos2 - threadCpuTimeNanos) / 1000000);
            }
            onPostExecute(doInBackground);
        }

        public void setCurFrameTimeStamp(long j) {
            this.curFrameTimestamp = j;
        }

        public void setEngine(BQCScanEngine bQCScanEngine) {
            this.engine = bQCScanEngine;
        }

        public ScanTask(BQCScanEngine bQCScanEngine) {
            this.engine = bQCScanEngine;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.alipay.mobile.bqcscanservice.impl.BQCScanTask
        public void onPostExecute(BQCScanResult bQCScanResult) {
            if (BQCScanController.this.i && this.engine != null) {
                try {
                    BQCScanController.this.s.setCodeSize(this.engine.getCodeSize());
                    if (this.engine.onProcessFinish(bQCScanResult)) {
                        long j = BQCScanController.this.mEngineWaitDuration;
                        if (j > 0) {
                            WalletBury.addWalletBury("recordEngineWaitDuration", new Class[]{Long.TYPE}, new Object[]{Long.valueOf(j)});
                            MPaasLogger.d("BQCScanController", new Object[]{"recordEngineWaitDuration: ", Long.valueOf(BQCScanController.this.mEngineWaitDuration)});
                        }
                        BQCScanController.this.i = false;
                        BQCScanController.this.y = true;
                        BQCScanController.this.s.endScan(true);
                    } else if (this.isFirstTask) {
                        BQCScanController.this.reportFrameFirstRecognized();
                    }
                } catch (Exception unused) {
                    MPaasLogger.e("BQCScanController", new Object[]{"scan task onPostExecute exception"});
                }
            }
            this.mData = null;
            this.mCamera = null;
            this.mPreviewSize = null;
            if (BQCScanController.this.u != null) {
                BQCScanController.this.u.returnTask();
            }
            BQCScanController.this.mTaskEndTimestamp = System.currentTimeMillis();
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    public class TaskPool {
        private ScanTask[] c = new ScanTask[3];
        private volatile int a = 3;
        private volatile int b = 0;

        public TaskPool(BQCScanController bQCScanController) {
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
            this.c[i].isFirstTask = false;
            return this.c[i];
        }

        public void returnTask() {
            this.a++;
        }
    }

    public BQCScanController(Context context, Map<String, Map<String, Object>> map, CameraHandler cameraHandler, boolean z, boolean z2, FrameCallback frameCallback, ScanCodeState scanCodeState) {
        this.a = context;
        this.m = map;
        this.p = cameraHandler;
        this.t = z;
        this.r = !z;
        this.A = z2;
        this.H = frameCallback;
        this.I = scanCodeState;
    }

    private void x(long j) {
        CameraHandler cameraHandler = this.p;
        if (cameraHandler != null) {
            cameraHandler.postDelayed(new Runnable() { // from class: com.alipay.mobile.bqcscanservice.impl.BQCScanController.3
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        byte[] z = BQCScanController.this.z();
                        if (!BQCScanController.this.z || BQCScanController.this.q == null || z == null || !BQCScanController.this.v) {
                            return;
                        }
                        BQCScanController.this.q.addCallbackBuffer(z);
                    } catch (Exception e) {
                        MPaasLogger.e("BQCScanController", new Object[]{"Add Preview Buffer Error"}, e);
                    }
                }
            }, j);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y(BQCScanEngine bQCScanEngine) {
        if (bQCScanEngine != null) {
            try {
                MPaasLogger.d("BQCScanController", new Object[]{"setScanType: old engine.destroy()"});
                bQCScanEngine.destroy();
            } catch (Exception unused) {
                MPaasLogger.e("BQCScanController", new Object[]{"engine destroy exception"});
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public byte[] z() {
        if (this.r && this.k != null) {
            if (this.l % 2 == 0) {
                return this.j;
            }
            return this.k;
        }
        return this.j;
    }

    public boolean checkEngineRegister(String str) {
        ArrayMap<String, Class<? extends BQCScanEngine>> arrayMap;
        return (TextUtils.isEmpty(str) || (arrayMap = this.c) == null || arrayMap.get(str) == null) ? false : true;
    }

    public void destroy() {
        ScanTask scanTask = this.f;
        if (scanTask != null) {
            scanTask.autoDestroyEngine();
        } else {
            y(this.e);
        }
        this.e = null;
        this.a = null;
        this.f = null;
        this.b = null;
        this.d = null;
        this.q = null;
        this.j = null;
        this.k = null;
        this.z = false;
        this.C = false;
        this.B = -1L;
    }

    public boolean getDoubleBufferEnable() {
        return this.r;
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

    public long getDurationOfNoNeedCheck() {
        try {
            BQCScanEngine bQCScanEngine = this.e;
            if (bQCScanEngine != null) {
                return bQCScanEngine.getDurationOfNonNeedCheckBlur();
            }
            return -1L;
        } catch (Throwable unused) {
            return -1L;
        }
    }

    public Map<String, String> getEngineRunningInfo(String str) {
        MPaasLogger.d("BQCScanController", new Object[]{"getEngineRunningInfo: type=", str, ", scanType=", this.g});
        if (!TextUtils.isEmpty(str) && TextUtils.equals(this.g, str)) {
            MPaasLogger.d("BQCScanController", new Object[]{"getEngineRunningInfo: curEngine=", this.e});
            BQCScanEngine bQCScanEngine = this.e;
            if (bQCScanEngine != null) {
                return bQCScanEngine.getRunningInfo();
            }
            return null;
        }
        return null;
    }

    public long getFrameCountInCamera() {
        PerfCompute perfCompute = mPerfCompute;
        if (perfCompute != null) {
            return perfCompute.b;
        }
        return -1L;
    }

    public long[] getRecognizeResult() {
        BQCScanEngine bQCScanEngine = this.e;
        if (bQCScanEngine == null || !bQCScanEngine.isQrCodeEngine()) {
            return null;
        }
        return this.e.getRecognizeResult();
    }

    public ScanResultMonitor getScanResultMonitor() {
        return this.s;
    }

    public Map<String, String> getSpecEngineExtInfo(String str) {
        BQCScanEngine bQCScanEngine;
        if (TextUtils.isEmpty(str) || !TextUtils.equals(this.g, str) || (bQCScanEngine = this.e) == null) {
            return null;
        }
        return bQCScanEngine.getResultExtInfo();
    }

    public boolean isScanEnable() {
        return this.i;
    }

    public void needDowngrade(boolean z) {
        this.K = z;
    }

    @Override // com.alipay.camera.base.AntCamera.PreviewCallbackProxy
    public void onPreviewFrameProxy(byte[] bArr, AntCamera antCamera) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long j = this.J;
        long j2 = j != 0 ? elapsedRealtime - j : 0L;
        ScanCodeState scanCodeState = this.I;
        if (scanCodeState != null) {
            scanCodeState.accumulateFrameGap(j2);
        }
        if (!this.G) {
            this.G = true;
        }
        PerfCompute perfCompute = mPerfCompute;
        if (perfCompute != null) {
            perfCompute.addFrame();
        }
        if (!this.x) {
            reportPreviewFrameShow();
            this.E = 0;
        }
        if (!this.v) {
            this.q = null;
            this.x = true;
            MPaasLogger.d("BQCScanController", new Object[]{"onPreviewFrame cameraValid:", Boolean.valueOf(this.v)});
            this.J = 0L;
            return;
        }
        this.q = antCamera;
        if (bArr != null && antCamera != null) {
            if (this.p == null) {
                this.x = true;
                MPaasLogger.d("BQCScanController", new Object[]{"onPreviewFrame mCameraHandler == null"});
                this.J = 0L;
                return;
            } else if (this.y) {
                this.x = true;
                MPaasLogger.d("BQCScanController", new Object[]{"onPreviewFrame mRecognizeEnd = true"});
                this.J = 0L;
                return;
            } else if (this.i && this.g != null) {
                this.s.startScan();
                if (this.n == null || this.o < 0) {
                    if (!this.p.curCameraStateValid()) {
                        this.x = true;
                        MPaasLogger.d("BQCScanController", new Object[]{"onPreviewFrame !mCameraHandler.curCameraStateValid()"});
                        this.J = SystemClock.elapsedRealtime();
                        return;
                    }
                    Camera.Parameters parameters = this.D;
                    if (parameters == null) {
                        parameters = antCamera.getParameters();
                    }
                    this.n = parameters.getPreviewSize();
                    this.o = parameters.getPreviewFormat();
                }
                if (!ScanRecognizedExecutor.isEmpty(this.A)) {
                    x(cameraFrameDelay);
                    int i = this.E + 1;
                    this.E = i;
                    this.x = true;
                    if (i >= 20) {
                        WalletBury.addWalletBury("recordScanFrameOmit", new Class[0], new Object[0]);
                        this.E = 0;
                    }
                    this.J = SystemClock.elapsedRealtime();
                    return;
                }
                this.E = 0;
                TaskPool taskPool = this.u;
                if (taskPool != null) {
                    ScanTask task = taskPool.getTask();
                    this.f = task;
                    if (task != null) {
                        try {
                            task.setCurFrameTimeStamp(elapsedRealtime);
                            long j3 = this.mFirstFrameTimestamp;
                            if (j3 > 0) {
                                this.e.markFirstFrameIn(j3);
                            }
                            FrameCallback frameCallback = this.H;
                            if (frameCallback != null) {
                                frameCallback.onPreviewFrame(antCamera);
                            }
                            this.e.markEachEngineFrameIn(System.currentTimeMillis());
                            this.f.setEngine(this.e);
                            this.f.setData(bArr, antCamera.getCamera(), this.n, this.o);
                            if (this.l == 1) {
                                this.f.isFirstTask = true;
                            }
                            ScanRecognizedExecutor.execute(this.A, this.f, this.l == 5);
                            if (this.mTaskEndTimestamp > 0) {
                                this.mEngineWaitDuration += System.currentTimeMillis() - this.mTaskEndTimestamp;
                                this.mTaskEndTimestamp = 0L;
                            }
                            this.l++;
                        } catch (Exception unused) {
                            this.u.returnTask();
                        }
                    } else {
                        MPaasLogger.e("BQCScanController", new Object[]{"scanTask is null"});
                    }
                }
                x(cameraFrameDelay);
                if (!this.x) {
                    this.x = true;
                    if (gcFirstFrame) {
                        System.gc();
                        MPaasLogger.d("BQCScanController", new Object[]{"Start to SCAN_GC"});
                    }
                }
                this.J = SystemClock.elapsedRealtime();
                return;
            } else {
                x(cameraFrameDelay);
                this.x = true;
                MPaasLogger.d("BQCScanController", new Object[]{"onPreviewFrame scanEnable=", Boolean.valueOf(this.i), " scanType = ", this.g});
                this.J = SystemClock.elapsedRealtime();
                return;
            }
        }
        this.x = true;
        MPaasLogger.d("BQCScanController", new Object[]{"onPreviewFrame bytes == null || antCamera == null"});
        this.J = 0L;
    }

    public void preSetScanRegion(Rect rect) {
        if (this.h == null) {
            this.h = rect;
        }
    }

    public void processWhetherStopMaRecognize(final boolean z, final Runnable runnable) {
        Runnable runnable2 = new Runnable() { // from class: com.alipay.mobile.bqcscanservice.impl.BQCScanController.1
            @Override // java.lang.Runnable
            public void run() {
                BQCScanController.this.F = z;
                if (runnable != null && !BQCScanController.this.y) {
                    runnable.run();
                }
                MPaasLogger.d("BQCScanController", new Object[]{"ScanNetworkChangeMonitor mRecognizeEnd=", Boolean.valueOf(BQCScanController.this.y), "^stopMaRecognize=", Boolean.valueOf(BQCScanController.this.F)});
            }
        };
        if (this.A) {
            CameraHandler cameraHandler = this.p;
            if (cameraHandler != null) {
                cameraHandler.post(runnable2);
                return;
            }
            return;
        }
        ScanRecognizedExecutor.execute(false, runnable2, false);
    }

    public void regScanEngine(String str, Class<? extends BQCScanEngine> cls, BQCScanEngine.EngineCallback engineCallback) {
        if (str == null || cls == null) {
            return;
        }
        if (this.c == null) {
            this.c = new ArrayMap<>();
        }
        this.c.put(str, cls);
        if (this.d == null) {
            this.d = new ArrayMap<>();
        }
        this.d.put(str, engineCallback);
        MPaasLogger.d("BQCScanController", new Object[]{"regScanEngine type=", str, ",engine=", cls.toString()});
    }

    public void reportCameraClosed() {
        try {
            BQCScanCallback bQCScanCallback = this.b;
            if (bQCScanCallback != null) {
                bQCScanCallback.onCameraClose();
            }
        } catch (Exception e) {
            MPaasLogger.e("BQCScanController", new Object[]{e.getMessage()});
        }
    }

    public void reportCameraErrorResult(int i) {
        try {
            BQCScanCallback bQCScanCallback = this.b;
            if (bQCScanCallback != null) {
                bQCScanCallback.onCameraErrorResult(i);
            }
        } catch (Exception e) {
            MPaasLogger.e("BQCScanController", new Object[]{"reportCameraErrorResult: "}, e);
        }
    }

    public void reportCameraFrameRecognized(boolean z, long j) {
        try {
            BQCScanCallback bQCScanCallback = this.b;
            if (bQCScanCallback != null) {
                bQCScanCallback.onCameraFrameRecognized(z, j);
            }
        } catch (NullPointerException e) {
            MPaasLogger.e("BQCScanController", new Object[]{e.getMessage()});
        }
    }

    public void reportCameraOpened() {
        BQCScanCallback bQCScanCallback = this.b;
        if (bQCScanCallback != null) {
            bQCScanCallback.onCameraOpened();
            mPerfCompute.reset();
        }
    }

    public void reportCameraParametersSetFailed() {
        try {
            BQCScanCallback bQCScanCallback = this.b;
            if (bQCScanCallback != null) {
                Object[] objArr = new Object[2];
                objArr[0] = "reportCameraParametersSetFailed: callback=null?";
                objArr[1] = Boolean.valueOf(bQCScanCallback == null);
                MPaasLogger.d("BQCScanController", objArr);
                this.b.onCameraParametersSetFailed();
            }
        } catch (Exception e) {
            MPaasLogger.e("BQCScanController", new Object[]{e.getMessage()});
        }
    }

    public void reportCameraReady() {
        try {
            BQCScanCallback bQCScanCallback = this.b;
            if (bQCScanCallback != null) {
                Object[] objArr = new Object[2];
                objArr[0] = "reportCameraReady: callback=null?";
                objArr[1] = Boolean.valueOf(bQCScanCallback == null);
                MPaasLogger.d("BQCScanController", objArr);
                this.b.onCameraReady();
            }
        } catch (NullPointerException e) {
            MPaasLogger.e("BQCScanController", new Object[]{e.getMessage()});
        }
    }

    public void reportError(BQCScanError bQCScanError) {
        try {
            BQCScanCallback bQCScanCallback = this.b;
            if (bQCScanCallback != null) {
                Object[] objArr = new Object[2];
                objArr[0] = "The bqcCallBack is null?";
                objArr[1] = Boolean.valueOf(bQCScanCallback == null);
                MPaasLogger.d("BQCScanController", objArr);
                this.b.onError(bQCScanError);
            }
            MPaasScanService mPaasScanService = this.L;
            if (mPaasScanService != null) {
                mPaasScanService.stopWatchDogMonitor();
            }
        } catch (Exception e) {
            MPaasLogger.e("BQCScanController", new Object[]{"reportError msg: "}, e);
        }
    }

    public void reportFrameFirstRecognized() {
        try {
            BQCScanCallback bQCScanCallback = this.b;
            if (bQCScanCallback != null) {
                Object[] objArr = new Object[2];
                objArr[0] = "reportFrameFirstRecognized: callback=null?";
                objArr[1] = Boolean.valueOf(bQCScanCallback == null);
                MPaasLogger.d("BQCScanController", objArr);
                this.b.onFirstFrameRecognized();
            }
        } catch (Exception e) {
            MPaasLogger.e("BQCScanController", new Object[]{e.getMessage()});
        }
    }

    public void reportOnEngineLoad() {
        try {
            BQCScanCallback bQCScanCallback = this.b;
            if (bQCScanCallback != null) {
                Object[] objArr = new Object[2];
                objArr[0] = "reportOnEngineLoad: callback=null?";
                objArr[1] = Boolean.valueOf(bQCScanCallback == null);
                MPaasLogger.d("BQCScanController", objArr);
                this.b.onEngineLoadSuccess();
            }
        } catch (Exception e) {
            MPaasLogger.e("BQCScanController", new Object[]{e.getMessage()});
        }
    }

    public void reportOnManualFocusResult(boolean z) {
        try {
            BQCScanCallback bQCScanCallback = this.b;
            if (bQCScanCallback != null) {
                Object[] objArr = new Object[2];
                objArr[0] = "reportOnManualFocusResult: callback=null?";
                objArr[1] = Boolean.valueOf(bQCScanCallback == null);
                MPaasLogger.d("BQCScanController", objArr);
                this.b.onCameraManualFocusResult(z);
            }
        } catch (Exception e) {
            MPaasLogger.e("BQCScanController", new Object[]{e.getMessage()});
        }
    }

    public void reportOnSetEnable() {
        try {
            BQCScanCallback bQCScanCallback = this.b;
            if (bQCScanCallback != null) {
                Object[] objArr = new Object[2];
                objArr[0] = "reportOnSetEnable: callback=null?";
                objArr[1] = Boolean.valueOf(bQCScanCallback == null);
                MPaasLogger.d("BQCScanController", objArr);
                this.b.onSetEnable();
            }
        } catch (Exception e) {
            MPaasLogger.e("BQCScanController", new Object[]{e.getMessage()});
        }
    }

    public void reportParametersSet(long j) {
        BQCScanCallback bQCScanCallback = this.b;
        if (bQCScanCallback != null) {
            bQCScanCallback.onParametersSetted(j);
        }
    }

    public void reportPreOpenCamera() {
        try {
            BQCScanCallback bQCScanCallback = this.b;
            if (bQCScanCallback != null) {
                bQCScanCallback.onPreOpenCamera();
            }
        } catch (Exception e) {
            MPaasLogger.e("BQCScanController", new Object[]{"reportPreOpenCamera: "}, e);
        }
    }

    public void reportPreviewFrameShow() {
        try {
            MPaasLogger.d("BQCScanController", new Object[]{"CAMERA_STEP_3_1 onPreviewFrameShow"});
            BQCScanCallback bQCScanCallback = this.b;
            if (bQCScanCallback != null) {
                bQCScanCallback.onPreviewFrameShow();
            }
            MPaasScanService mPaasScanService = this.L;
            if (mPaasScanService != null) {
                mPaasScanService.stopWatchDogMonitor();
            }
        } catch (NullPointerException e) {
            MPaasLogger.e("BQCScanController", new Object[]{e.getMessage()});
        }
    }

    public void reportStartingPreview() {
        this.z = true;
        BQCScanCallback bQCScanCallback = this.b;
        if (bQCScanCallback != null) {
            bQCScanCallback.onStartingPreview();
        }
    }

    public void reportSurfaceTextureUpdated() {
        try {
            BQCScanCallback bQCScanCallback = this.b;
            if (bQCScanCallback != null) {
                bQCScanCallback.onSurfaceUpdated();
            }
        } catch (NullPointerException e) {
            MPaasLogger.e("BQCScanController", new Object[]{e.getMessage()});
        }
    }

    public void reportSurfaceViewAvailable() {
        BQCScanCallback bQCScanCallback = this.b;
        if (bQCScanCallback != null) {
            bQCScanCallback.onSurfaceAvaliable();
        }
    }

    public void setCameraBuffers(byte[] bArr, byte[] bArr2) {
        this.j = bArr;
        this.k = bArr2;
    }

    public void setCameraValid(boolean z) {
        this.mFirstFrameTimestamp = -1L;
        this.v = z;
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
        if (map != null) {
            this.m.put(str, map);
        } else {
            this.m.remove(str);
        }
    }

    public void setFistFrameTimestamp(long j) {
        this.mFirstFrameTimestamp = j;
    }

    public void setResultCallback(BQCScanCallback bQCScanCallback) {
        this.b = bQCScanCallback;
    }

    public void setScanEnable(boolean z) {
        MPaasLogger.d("BQCScanController", new Object[]{"setScanEnable(enable=", Boolean.valueOf(z), ", scanEnable=", Boolean.valueOf(this.i), jn1.BRACKET_END_STR});
        if (z) {
            this.mEngineWaitDuration = 0L;
        }
        this.mTaskEndTimestamp = 0L;
        this.i = z;
        if (this.i && this.e != null) {
            this.y = false;
            this.e.start();
            this.B = SystemClock.elapsedRealtime();
        } else {
            this.B = -1L;
            this.C = false;
        }
        if (!this.i) {
            this.s.disableScan();
        } else {
            this.y = false;
            x(0L);
            this.s.startScan();
        }
        if (z) {
            reportOnSetEnable();
        }
    }

    public void setScanRegion(Rect rect) {
        this.h = rect;
    }

    public boolean setScanType(String str, BQCCameraParam.MaEngineType maEngineType) {
        return setScanType(str, maEngineType, null);
    }

    public void setSupportFrameCallback(boolean z) {
        this.w = z;
    }

    public void setmCurParameters(Camera.Parameters parameters) {
        this.D = parameters;
    }

    public void setmPaasScanService(MPaasScanService mPaasScanService) {
        this.L = mPaasScanService;
    }

    public void useViewFrameToRecognize(final Bitmap bitmap) {
        Object[] objArr = new Object[2];
        objArr[0] = "useViewFrameToRecognize() bitmap=";
        objArr[1] = Boolean.valueOf(bitmap == null);
        MPaasLogger.d("BQCScanController", objArr);
        if (this.G) {
            MPaasLogger.d("BQCScanController", new Object[]{"useViewFrameToRecognize systemFrameCallback  is got,return"});
        } else if (bitmap == null) {
        } else {
            if (this.y) {
                MPaasLogger.d("BQCScanController", new Object[]{"useViewFrameToRecognize mRecognizeEnd = true"});
            } else if (!this.i || !"MA".equals(this.g)) {
                MPaasLogger.d("BQCScanController", new Object[]{"useViewFrameToRecognize scanEnable=", Boolean.valueOf(this.i), " scanType = ", this.g});
            } else if (!ScanRecognizedExecutor.isEmpty(this.A)) {
                MPaasLogger.d("BQCScanController", new Object[]{"useViewFrameToRecognize mSyncScanRecognize is not empty"});
            } else {
                ScanRecognizedExecutor.execute(this.A, new Runnable() { // from class: com.alipay.mobile.bqcscanservice.impl.BQCScanController.2
                    @Override // java.lang.Runnable
                    public void run() {
                        if (!BQCScanController.this.F && BQCScanController.this.i && "MA".equals(BQCScanController.this.g)) {
                            try {
                                MPaasLogger.d("BQCScanController", new Object[]{"useViewFrameToRecognize scan engine process"});
                                long elapsedRealtime = SystemClock.elapsedRealtime();
                                if (BQCScanController.this.e != null) {
                                    boolean onProcessFinish = BQCScanController.this.e.onProcessFinish(BQCScanController.this.e.process(bitmap));
                                    if (onProcessFinish) {
                                        BQCScanController.this.i = false;
                                        BQCScanController.this.y = true;
                                    }
                                    MPaasLogger.d("BQCScanController", new Object[]{"useViewFrameToRecognize, BitmapRecognize isSuccess=", Boolean.valueOf(onProcessFinish), "cost: ", Long.valueOf(SystemClock.elapsedRealtime() - elapsedRealtime)});
                                    bitmap.recycle();
                                    return;
                                }
                                return;
                            } catch (Exception e) {
                                MPaasLogger.e("BQCScanController", new Object[]{"useViewFrameToRecognize scan task doInBackground exception:"}, e);
                                return;
                            }
                        }
                        MPaasLogger.d("BQCScanController", new Object[]{"useViewFrameToRecognize ScanTask scanEnable=", Boolean.valueOf(BQCScanController.this.i), "^stopMaRecognize=", Boolean.valueOf(BQCScanController.this.F)});
                    }
                }, false);
            }
        }
    }

    public boolean setScanType(String str, BQCCameraParam.MaEngineType maEngineType, String str2) {
        boolean z;
        MPaasLogger.d("BQCScanController", new Object[]{"setScanType=", this.g, ", type=", str, ", engineClassMap=", this.c, ", extraType=", str2});
        if (str != null && this.c != null) {
            if (this.m == null) {
                MPaasLogger.d("BQCScanController", new Object[]{"setScanType engineParams == null"});
                return false;
            } else if (str.equals(this.g)) {
                MPaasLogger.d("BQCScanController", new Object[]{"setScanType scanType is exist"});
                return true;
            } else {
                try {
                    Class<? extends BQCScanEngine> cls = this.c.get(str);
                    if (cls == null) {
                        MPaasLogger.d("BQCScanController", new Object[]{"setScanType EngineClazz is null : type = ", str});
                        return false;
                    }
                    if (this.i) {
                        this.i = false;
                        z = true;
                    } else {
                        z = false;
                    }
                    BQCScanError bQCScanError = null;
                    try {
                        ScanTask scanTask = this.f;
                        if (scanTask != null) {
                            MPaasLogger.d("BQCScanController", new Object[]{"setScanType(): scanTask:", scanTask});
                            this.f.autoDestroyEngine();
                        } else {
                            y(this.e);
                        }
                        MPaasLogger.d("BQCScanController", new Object[]{"setScanType(), new engine.constructor()"});
                        this.e = cls.newInstance();
                        this.s.enabled = this.e.isQrCodeEngine();
                        MPaasLogger.d("BQCScanController", new Object[]{"setScanType(), new engine.init()"});
                        if (!this.e.init(this.a, this.m.get(str))) {
                            this.e = null;
                            bQCScanError = new BQCScanError(BQCScanError.ErrorType.initEngineError, "init engine fail", 0, BQCScanError.CameraAPIType.API1);
                        } else {
                            ArrayMap<String, BQCScanEngine.EngineCallback> arrayMap = this.d;
                            if (arrayMap != null) {
                                this.e.setResultCallback(arrayMap.get(str));
                            }
                        }
                    } catch (Exception e) {
                        this.e = null;
                        BQCScanError.ErrorType errorType = BQCScanError.ErrorType.initEngineError;
                        bQCScanError = new BQCScanError(errorType, "init engine fail:" + e.getMessage(), 0, BQCScanError.CameraAPIType.API1);
                    }
                    if (bQCScanError != null) {
                        reportError(bQCScanError);
                        MPaasLogger.d("BQCScanController", new Object[]{"setScanType error != null"});
                        return false;
                    }
                    this.g = str;
                    BQCScanEngine bQCScanEngine = this.e;
                    if (bQCScanEngine != null) {
                        bQCScanEngine.setSubScanType(maEngineType, str2);
                        this.e.setWhetherFirstSetup(this.t);
                    }
                    if (z) {
                        this.i = true;
                    }
                    if (this.i) {
                        this.y = false;
                        this.e.start();
                    }
                    MPaasLogger.d("BQCScanController", new Object[]{"setScanType: new engine.start()"});
                    this.s.startScan();
                    reportOnEngineLoad();
                    return true;
                } catch (Exception unused) {
                    MPaasLogger.e("BQCScanController", new Object[]{"Set ScanType failed"});
                    return false;
                }
            }
        }
        MPaasLogger.d("BQCScanController", new Object[]{"setScanType engineClassMap == null"});
        return false;
    }
}
