package com.alipay.camera2.operation.callback;

import android.annotation.TargetApi;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import com.alipay.camera.base.CameraFocusPerformanceHelper;
import com.alipay.camera2.CameraFocusStateDescription;
import com.alipay.camera2.operation.Camera2FocusManager;
import com.alipay.camera2.util.Camera2CharacteristicsCache;
import com.alipay.camera2.util.Camera2Utils;
import com.alipay.mobile.bqcscanservice.MPaasLogger;
import com.taobao.alivfssdk.utils.AVFSCacheConstants;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

/* compiled from: Taobao */
@TargetApi(21)
/* loaded from: classes12.dex */
public class Camera2CaptureCallback extends CameraCaptureSession.CaptureCallback {
    public static final String TAG = "Camera2CaptureCallback";
    private final Camera2CharacteristicsCache b;
    private final Camera2FocusManager c;
    private final Camera2CaptureCallbackListener d;
    private LimitedFrameRecord a = new LimitedFrameRecord(150);
    private PHONE_MOVEMENT_STATE f = PHONE_MOVEMENT_STATE.UNKNOWN;
    private long e = 0;

    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    public interface Camera2CaptureCallbackListener {
        long getDurationOfBlur();

        long getDurationOfNonNeedCheckBlur();
    }

    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    public class LimitedFrameRecord {
        private int a;
        private int f;
        private int g;
        private int h;
        private boolean i;
        private ConcurrentLinkedQueue<String> b = new ConcurrentLinkedQueue<>();
        private float c = -1.0f;
        private int j = Integer.MAX_VALUE;
        private ConcurrentHashMap<Integer, Long> k = new ConcurrentHashMap<>();
        private long l = 0;
        private float m = -1.0f;
        private float n = -1.0f;
        private long o = 0;
        private CameraFocusPerformanceHelper p = new CameraFocusPerformanceHelper();
        private int d = 0;
        private int e = 0;

        public LimitedFrameRecord(int i) {
            this.a = i;
        }

        private String b() {
            try {
                ConcurrentHashMap<Integer, Long> concurrentHashMap = this.k;
                if (concurrentHashMap != null && concurrentHashMap.size() != 0 && Camera2CaptureCallback.this.e != 0) {
                    StringBuilder sb = new StringBuilder(256);
                    for (Integer num : this.k.keySet()) {
                        Long l = this.k.get(num);
                        sb.append(num);
                        sb.append("=");
                        sb.append(l);
                        sb.append("-");
                        sb.append(((float) l.longValue()) / ((float) Camera2CaptureCallback.this.e));
                        sb.append(AVFSCacheConstants.COMMA_SEP);
                    }
                    return sb.toString();
                }
                return "NULL";
            } catch (Throwable th) {
                MPaasLogger.e(Camera2CaptureCallback.TAG, new Object[]{"getFocusDistanceStatistics with error:"}, th);
                return "UNKNOWN";
            }
        }

        private void c(float f) {
            Long valueOf;
            int normalizeFocusDistance = Camera2Utils.normalizeFocusDistance(f);
            Long l = this.k.get(Integer.valueOf(normalizeFocusDistance));
            if (l == null) {
                valueOf = 1L;
            } else {
                valueOf = Long.valueOf(l.longValue() + 1);
            }
            this.k.put(Integer.valueOf(normalizeFocusDistance), valueOf);
            if (this.l <= valueOf.longValue()) {
                this.l = valueOf.longValue();
                this.m = normalizeFocusDistance;
            }
            if (Camera2CaptureCallback.this.e > 0) {
                this.n = ((float) this.l) / ((float) Camera2CaptureCallback.this.e);
            }
        }

        public int getActiveScanFrameCount() {
            return this.f;
        }

        public int getFocusFailedFrameCount() {
            return this.d;
        }

        public int getFocusNotStartedFrameCount() {
            return this.e;
        }

        public long getFrameCount() {
            return Camera2CaptureCallback.this.e;
        }

        public boolean getInitFocusDistanceMatched() {
            return this.i;
        }

        public float getLastFocusDistance() {
            return this.c;
        }

        public float getMaxProportion() {
            return this.n;
        }

        public float getMaxProportionFocusDistance() {
            return this.m;
        }

        public int getPassiveScanFrameCount() {
            return this.g;
        }

        public int getSameFocusDistanceFrameCount() {
            return this.h;
        }

        /* JADX WARN: Removed duplicated region for block: B:34:0x0097  */
        /* JADX WARN: Removed duplicated region for block: B:37:0x009c  */
        /* JADX WARN: Removed duplicated region for block: B:38:0x00a2  */
        /* JADX WARN: Removed duplicated region for block: B:40:0x00a6  */
        /* JADX WARN: Removed duplicated region for block: B:41:0x00ac  */
        /* JADX WARN: Removed duplicated region for block: B:55:0x00d2  */
        /* JADX WARN: Removed duplicated region for block: B:60:0x0128  */
        /* JADX WARN: Removed duplicated region for block: B:63:0x0133  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void offer(boolean r22, int r23, float r24, int r25) {
            /*
                Method dump skipped, instructions count: 350
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.alipay.camera2.operation.callback.Camera2CaptureCallback.LimitedFrameRecord.offer(boolean, int, float, int):void");
        }

        public int size() {
            return this.b.size();
        }

        public String toString() {
            return this.b.toString() + this.p.getString() + "###lastFocusDistance=" + this.c + "###FocusDistanceStatistics=" + b();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    public enum PHONE_MOVEMENT_STATE {
        UNKNOWN,
        MOVING,
        STABLE
    }

    public Camera2CaptureCallback(Camera2CharacteristicsCache camera2CharacteristicsCache, Camera2FocusManager camera2FocusManager, Camera2CaptureCallbackListener camera2CaptureCallbackListener) {
        this.b = camera2CharacteristicsCache;
        this.c = camera2FocusManager;
        this.d = camera2CaptureCallbackListener;
    }

    public String getAfState() {
        return this.a.toString();
    }

    public CameraFocusStateDescription getCameraFocusStateDescription() {
        CameraFocusStateDescription cameraFocusStateDescription = new CameraFocusStateDescription(this.a.getFrameCount(), this.b.isManualControlSupport(), this.b.getHyperFocusDistance(), this.a.getLastFocusDistance(), this.a.getFocusNotStartedFrameCount(), this.a.getFocusFailedFrameCount(), this.a.toString(), this.a.getActiveScanFrameCount(), this.a.getPassiveScanFrameCount(), this.a.getSameFocusDistanceFrameCount(), this.a.getInitFocusDistanceMatched(), String.valueOf(this.f));
        cameraFocusStateDescription.setMaxProportion(this.a.getMaxProportion());
        cameraFocusStateDescription.setMaxProportionFocusDistance(this.a.getMaxProportionFocusDistance());
        cameraFocusStateDescription.setMaxFocusDistance(this.b.getMaxFocusDistance());
        return cameraFocusStateDescription;
    }

    public int getFocusFirstTriggerFrameCount() {
        return this.a.j;
    }

    public long getFrameCount() {
        return this.a.getFrameCount();
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0025 A[Catch: all -> 0x0020, TryCatch #0 {all -> 0x0020, blocks: (B:4:0x0010, B:11:0x0025, B:14:0x0045, B:15:0x0052, B:17:0x0058, B:19:0x005e, B:21:0x0068, B:23:0x006c), top: B:28:0x0010 }] */
    @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onCaptureCompleted(android.hardware.camera2.CameraCaptureSession r8, android.hardware.camera2.CaptureRequest r9, android.hardware.camera2.TotalCaptureResult r10) {
        /*
            r7 = this;
            java.lang.String r8 = "onCaptureCompleted"
            com.alipay.camera2.util.SystraceWrapper.beginTrace(r8)
            long r0 = r7.e
            r2 = 1
            long r0 = r0 + r2
            r7.e = r0
            r8 = 1
            r0 = 0
            if (r9 == 0) goto L22
            android.hardware.camera2.CaptureRequest$Key r1 = android.hardware.camera2.CaptureRequest.CONTROL_AF_TRIGGER     // Catch: java.lang.Throwable -> L20
            java.lang.Object r9 = r9.get(r1)     // Catch: java.lang.Throwable -> L20
            java.lang.Integer r9 = (java.lang.Integer) r9     // Catch: java.lang.Throwable -> L20
            int r9 = r9.intValue()     // Catch: java.lang.Throwable -> L20
            if (r9 != r8) goto L22
            r9 = 1
            goto L23
        L20:
            r9 = move-exception
            goto L70
        L22:
            r9 = 0
        L23:
            if (r10 == 0) goto L52
            android.hardware.camera2.CaptureResult$Key r1 = android.hardware.camera2.CaptureResult.CONTROL_AF_MODE     // Catch: java.lang.Throwable -> L20
            java.lang.Object r1 = r10.get(r1)     // Catch: java.lang.Throwable -> L20
            java.lang.Integer r1 = (java.lang.Integer) r1     // Catch: java.lang.Throwable -> L20
            int r1 = r1.intValue()     // Catch: java.lang.Throwable -> L20
            android.hardware.camera2.CaptureResult$Key r4 = android.hardware.camera2.CaptureResult.CONTROL_AF_STATE     // Catch: java.lang.Throwable -> L20
            java.lang.Object r4 = r10.get(r4)     // Catch: java.lang.Throwable -> L20
            java.lang.Integer r4 = (java.lang.Integer) r4     // Catch: java.lang.Throwable -> L20
            android.hardware.camera2.CaptureResult$Key r5 = android.hardware.camera2.CaptureResult.LENS_FOCUS_DISTANCE     // Catch: java.lang.Throwable -> L20
            java.lang.Object r5 = r10.get(r5)     // Catch: java.lang.Throwable -> L20
            java.lang.Float r5 = (java.lang.Float) r5     // Catch: java.lang.Throwable -> L20
            if (r4 == 0) goto L52
            if (r5 == 0) goto L52
            com.alipay.camera2.operation.callback.Camera2CaptureCallback$LimitedFrameRecord r6 = r7.a     // Catch: java.lang.Throwable -> L20
            int r4 = r4.intValue()     // Catch: java.lang.Throwable -> L20
            float r5 = r5.floatValue()     // Catch: java.lang.Throwable -> L20
            r6.offer(r9, r4, r5, r1)     // Catch: java.lang.Throwable -> L20
        L52:
            int r9 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Throwable -> L20
            r1 = 28
            if (r9 < r1) goto L7b
            long r4 = r7.e     // Catch: java.lang.Throwable -> L20
            int r9 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r9 != 0) goto L7b
            android.hardware.camera2.CaptureResult$Key r9 = android.hardware.camera2.CaptureResult.CONTROL_AF_SCENE_CHANGE     // Catch: java.lang.Throwable -> L20
            java.lang.Object r9 = r10.get(r9)     // Catch: java.lang.Throwable -> L20
            java.lang.Integer r9 = (java.lang.Integer) r9     // Catch: java.lang.Throwable -> L20
            if (r9 == 0) goto L7b
            com.alipay.camera2.util.Camera2CharacteristicsCache r9 = r7.b     // Catch: java.lang.Throwable -> L20
            if (r9 == 0) goto L7b
            r9.setSupportAfSceneChangedDetection()     // Catch: java.lang.Throwable -> L20
            goto L7b
        L70:
            java.lang.Object[] r8 = new java.lang.Object[r8]
            java.lang.String r10 = "onCaptureCompleted with error:"
            r8[r0] = r10
            java.lang.String r10 = "Camera2CaptureCallback"
            com.alipay.mobile.bqcscanservice.MPaasLogger.e(r10, r8, r9)
        L7b:
            com.alipay.camera2.util.SystraceWrapper.endTrace()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.camera2.operation.callback.Camera2CaptureCallback.onCaptureCompleted(android.hardware.camera2.CameraCaptureSession, android.hardware.camera2.CaptureRequest, android.hardware.camera2.TotalCaptureResult):void");
    }

    @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
    public void onCaptureProgressed(CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, CaptureResult captureResult) {
    }

    public void onMovementStatusChanged(boolean z) {
        this.f = z ? PHONE_MOVEMENT_STATE.MOVING : PHONE_MOVEMENT_STATE.STABLE;
    }
}
