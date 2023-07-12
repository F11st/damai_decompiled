package com.alipay.camera.base;

import com.alipay.camera.util.CameraLog;
import com.alipay.camera.util.WalletBehaviorBury;
import com.youku.live.livesdk.monitor.performance.AbsPerformance;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class CameraStateTracer {
    private static int a;
    private static CameraOperation c;
    private static ConcurrentLinkedQueue<CameraOperation> b = new ConcurrentLinkedQueue<>();
    private static ConcurrentLinkedQueue<CameraErrorDescription> d = new ConcurrentLinkedQueue<>();
    private static ConcurrentHashMap<String, CameraEvent> e = new ConcurrentHashMap<>();
    private static boolean f = true;
    private static String g = null;

    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    public enum CameraEvent {
        GET_CAMERA_INFO,
        GET_NUMBER_OF_CAMERAS,
        OPEN,
        ADD_CALLBACK_BUFFER,
        AUTO_FOCUS,
        CANCEL_AUTO_FOCUS,
        ENABLE_SHUTTER_SOUND,
        GET_PARAMETERS,
        LOCK,
        RECONNECT,
        RELEASE,
        SET_AUTO_FOCUS_MOVE_CALLBACK,
        SET_DISPLAY_ORIENTATION,
        SET_ERROR_CALLBACK,
        SET_FACE_DETECTION_LISTENER,
        SET_ONE_SHOT_PREVIEW_CALLBACK,
        SET_PARAMETERS,
        SET_PREVIEW_CALLBACK,
        SET_PREVIEW_CALLBACK_WITH_BUFFER,
        SET_PREVIEW_DISPLAY,
        SET_PREVIEW_TEXTURE,
        SET_ZOOM_CHANGE_LISTENER,
        START_FACE_DETECTION,
        START_PREVIEW,
        START_SMOOTH_ZOOM,
        STOP_FACE_DETECTION,
        STOP_PREVIEW,
        STOP_SMOOTH_ZOOM,
        TAKE_PICTURE,
        UNLOCK,
        ON_ERROR,
        CAMERA_AVAILABLE,
        CAMERA_UNAVAILABLE,
        START_PREVIEW_EXCEPTION,
        SET_PARAMETERS_EXCEPTION,
        GET_PARAMETERS_EXCEPTION,
        SET_PREVIEW_TEXTURE_EXCEPTION,
        SET_PREVIEW_DISPLAY_EXCEPTION,
        AUTO_FOCUS_EXCEPTION,
        CANCEL_AUTO_FOCUS_EXCEPTION,
        STOP_PREVIEW_EXCEPTION,
        CLOSE_CAMERA_EXCEPTION,
        GET_CAMERA_INFO_EXCEPTION,
        GET_NUMBER_OF_CAMERAS_EXCEPTION
    }

    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    public static class CameraOperation {
        private long a;
        private String b;
        private String c;
        private CameraEvent d;

        public CameraOperation(String str, String str2, long j, CameraEvent cameraEvent) {
            this.b = str;
            this.c = str2;
            this.a = j;
            this.d = cameraEvent;
        }

        public String getCallingThreadName() {
            return this.c;
        }

        public CameraEvent getCameraEvent() {
            return this.d;
        }

        public String getFrom() {
            return this.b;
        }

        public long getTimeStamp() {
            return this.a;
        }

        public String toString() {
            return "^timeStamp=" + String.valueOf(this.a) + "^owner=" + this.b + "^callingThreadName=" + this.c + "^event=" + String.valueOf(this.d);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    public enum ErrorType {
        EVICT_ERROR,
        CALLBACK_ERROR,
        RUNTIME_ERROR,
        UNKNOWN_ERROR
    }

    private static void a(CameraErrorDescription cameraErrorDescription) {
        if (d.size() >= 5) {
            d.poll();
        }
        d.offer(cameraErrorDescription);
    }

    private static synchronized String b(String str) {
        synchronized (CameraStateTracer.class) {
            String str2 = null;
            if (c != null && CameraEvent.RELEASE == c.getCameraEvent()) {
                CameraLog.d("CameraStateTracer", "isEvictedHappens with release event in last.");
                return null;
            }
            CameraOperation[] cameraOperationArr = (CameraOperation[]) b.toArray(new CameraOperation[b.size()]);
            boolean z = true;
            int length = cameraOperationArr.length - 1;
            String str3 = null;
            boolean z2 = false;
            boolean z3 = false;
            while (true) {
                if (length < 0) {
                    break;
                }
                CameraOperation cameraOperation = cameraOperationArr[length];
                CameraEvent cameraEvent = cameraOperation.getCameraEvent();
                String from = cameraOperation.getFrom();
                if (!CameraEvent.ON_ERROR.equals(cameraEvent) && !CameraEvent.CAMERA_AVAILABLE.equals(cameraEvent) && !CameraEvent.CAMERA_UNAVAILABLE.equals(cameraEvent)) {
                    if (!str.equals(from)) {
                        z3 = true;
                    }
                    CameraLog.d("CameraStateTracer", "Owner:" + from + ", event:" + cameraEvent);
                    if (CameraEvent.OPEN == cameraEvent) {
                        str3 = from;
                        break;
                    } else if (CameraEvent.RELEASE == cameraEvent) {
                        str3 = from;
                        z2 = true;
                    } else {
                        str3 = from;
                    }
                }
                length--;
            }
            boolean z4 = !z2 && z3;
            if (z4) {
                StringBuilder sb = new StringBuilder();
                sb.append("^BeenEvicted=");
                sb.append(str3);
                sb.append("^EvictOwner=");
                sb.append(str);
                sb.append("^HasCameraAvailable=");
                if (e.size() == 0) {
                    z = false;
                }
                sb.append(String.valueOf(z));
                str2 = sb.toString();
            }
            CameraLog.d("CameraStateTracer", "isEvictedHappens:" + z4 + ", evictMsg:" + str2);
            return str2;
        }
    }

    private static synchronized void c(CameraOperation cameraOperation) {
        synchronized (CameraStateTracer.class) {
            if (a >= 200) {
                b.poll();
                a--;
            }
            b.offer(cameraOperation);
            CameraEvent cameraEvent = cameraOperation.getCameraEvent();
            if (!CameraEvent.ON_ERROR.equals(cameraEvent) && !CameraEvent.CAMERA_AVAILABLE.equals(cameraEvent) && !CameraEvent.CAMERA_UNAVAILABLE.equals(cameraEvent)) {
                c = cameraOperation;
            }
            a++;
        }
    }

    public static void enableRecordCameraOperations(boolean z) {
        f = z;
    }

    public static String getCameraAvailableStatusMap() {
        return e.toString();
    }

    public static CameraErrorDescription getCameraErrorDescription(long j) {
        CameraOperation cameraOperation;
        CameraErrorDescription cameraErrorDescription = null;
        try {
            CameraLog.d("CameraStateTracer", "getCameraErrorDescription, timestamp:" + j);
            if (j <= 0) {
                j = AbsPerformance.LONG_NIL;
            }
            Iterator<CameraErrorDescription> it = d.iterator();
            while (it.hasNext()) {
                CameraErrorDescription next = it.next();
                if (next.getTimeStamp() == j) {
                    CameraLog.d("CameraStateTracer", "getCameraErrorDescription, same timestamp:" + next);
                    return new CameraErrorDescription(next);
                }
                cameraErrorDescription = new CameraErrorDescription(next);
            }
            if (cameraErrorDescription == null && (cameraOperation = c) != null) {
                cameraErrorDescription = new CameraErrorDescription(cameraOperation.getTimeStamp(), c.getFrom(), "unknown-error", ErrorType.UNKNOWN_ERROR, b);
            }
        } catch (Throwable th) {
            CameraLog.d("CameraStateTracer", "getCameraErrorDescription with exception:" + th.toString());
        }
        CameraLog.d("CameraStateTracer", "getCameraErrorDescription, resultCameraErrorDescription:" + cameraErrorDescription);
        return cameraErrorDescription;
    }

    public static String getLatestEvictOwner() {
        return g;
    }

    public static boolean isAllCameraUnAvailable() {
        return e.size() == 0;
    }

    public static void recordCameraAvailable(long j, String str) {
        try {
            if (!f) {
                CameraLog.d("TAG", "recordCameraAvailable but trace disabled.");
                return;
            }
            CameraLog.d("CameraStateTracer", "recordCameraAvailable, cameraId:" + str);
            String name = Thread.currentThread().getName();
            CameraEvent cameraEvent = CameraEvent.CAMERA_AVAILABLE;
            c(new CameraOperation(str, name, j, cameraEvent));
            e.put(str, cameraEvent);
        } catch (Throwable th) {
            CameraLog.e("CameraStateTracer", "recordCameraAvailable with error:" + th.toString());
        }
    }

    public static void recordCameraUnAvailable(long j, String str) {
        try {
            if (!f) {
                CameraLog.d("TAG", "recordCameraUnAvailable but trace disabled.");
                return;
            }
            CameraLog.d("CameraStateTracer", "recordCameraUnAvailable, cameraId:" + str);
            c(new CameraOperation(str, Thread.currentThread().getName(), j, CameraEvent.CAMERA_UNAVAILABLE));
            e.remove(str);
        } catch (Throwable th) {
            CameraLog.e("CameraStateTracer", "recordCameraUnAvailable with error:" + th.toString());
        }
    }

    public static void recordEvent(String str, String str2, CameraEvent cameraEvent) {
        try {
            if (!f) {
                CameraLog.d("TAG", "recordEvent but trace disabled.");
                return;
            }
            CameraLog.d(str + "-" + str2, "" + cameraEvent);
            c(new CameraOperation(str2, Thread.currentThread().getName(), System.currentTimeMillis(), cameraEvent));
        } catch (Throwable th) {
            CameraLog.e("CameraStateTracer", "recordEvent with exception:" + th.toString());
        }
    }

    public static void recordOnErrorEvent(String str, String str2, CameraEvent cameraEvent, int i) {
        try {
            if (!f) {
                CameraLog.d("TAG", "recordOnErrorEvent but trace disabled.");
                return;
            }
            CameraLog.d(str + "-" + str2, "" + cameraEvent + " error:" + i);
            CameraOperation cameraOperation = new CameraOperation(str2, Thread.currentThread().getName(), System.currentTimeMillis(), cameraEvent);
            c(cameraOperation);
            StringBuilder sb = new StringBuilder();
            sb.append("^ErrorCode=");
            sb.append(i);
            sb.append("^HasCameraAvailable=");
            sb.append(String.valueOf(e.size() != 0));
            CameraErrorDescription cameraErrorDescription = new CameraErrorDescription(cameraOperation.getTimeStamp(), str2, sb.toString(), ErrorType.CALLBACK_ERROR, b);
            a(cameraErrorDescription);
            WalletBehaviorBury.bury("recordCameraOperations", new Class[]{String.class, String.class, String.class, String.class}, new Object[]{cameraErrorDescription.getOwner(), String.valueOf(cameraErrorDescription.getCameraStateErrorType()), cameraErrorDescription.getErrorMsg(), String.valueOf(cameraErrorDescription.getHistoryCameraStateErrorType())});
        } catch (Throwable th) {
            CameraLog.e("CameraStateTracer", "recordOnErrorEvent with exception:" + th.toString());
        }
    }

    public static void recordOpenEvent(String str, String str2, CameraEvent cameraEvent) {
        try {
            if (!f) {
                CameraLog.d("TAG", "recordOpenEvent but trace disabled.");
                return;
            }
            CameraLog.d(str + "-" + str2, "" + cameraEvent);
            if (CameraEvent.OPEN != cameraEvent) {
                return;
            }
            String b2 = b(str2);
            CameraOperation cameraOperation = new CameraOperation(str2, Thread.currentThread().getName(), System.currentTimeMillis(), cameraEvent);
            c(cameraOperation);
            if (b2 != null) {
                g = str2;
                CameraErrorDescription cameraErrorDescription = new CameraErrorDescription(cameraOperation.getTimeStamp(), cameraOperation.getFrom(), b2, ErrorType.EVICT_ERROR, b);
                a(cameraErrorDescription);
                WalletBehaviorBury.bury("recordCameraOperations", new Class[]{String.class, String.class, String.class, String.class}, new Object[]{cameraErrorDescription.getOwner(), String.valueOf(cameraErrorDescription.getCameraStateErrorType()), cameraErrorDescription.getErrorMsg(), String.valueOf(cameraErrorDescription.getHistoryCameraStateErrorType())});
                return;
            }
            g = null;
        } catch (Throwable unused) {
            CameraLog.e("CameraStateTracer", "recordOpenEvent with exception.");
        }
    }

    public static void recordRuntimeExceptionEvent(String str, String str2, CameraEvent cameraEvent, String str3) {
        try {
            if (!f) {
                CameraLog.d("TAG", "recordRuntimeExceptionEvent but trace disabled.");
                return;
            }
            CameraLog.d(str + "-" + str2, "" + cameraEvent + " errorMsg:" + str3);
            CameraOperation cameraOperation = new CameraOperation(str2, Thread.currentThread().getName(), System.currentTimeMillis(), cameraEvent);
            c(cameraOperation);
            StringBuilder sb = new StringBuilder();
            sb.append("^ErrorMsg=");
            sb.append(str3);
            sb.append("^HasCameraAvailable=");
            sb.append(String.valueOf(e.size() != 0));
            sb.append("^CameraEvent=");
            sb.append(String.valueOf(cameraEvent));
            CameraErrorDescription cameraErrorDescription = new CameraErrorDescription(cameraOperation.getTimeStamp(), str2, sb.toString(), ErrorType.RUNTIME_ERROR, b);
            a(cameraErrorDescription);
            WalletBehaviorBury.bury("recordCameraOperations", new Class[]{String.class, String.class, String.class, String.class}, new Object[]{cameraErrorDescription.getOwner(), String.valueOf(cameraErrorDescription.getCameraStateErrorType()), cameraErrorDescription.getErrorMsg(), String.valueOf(cameraErrorDescription.getHistoryCameraStateErrorType())});
        } catch (Throwable th) {
            CameraLog.e("CameraStateTracer", "recordRuntimeExceptionEvent with exception:" + th.toString());
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    public static class CameraErrorDescription {
        private long a;
        private String b;
        private String c;
        private ErrorType d;
        private ArrayList<CameraOperation> e;

        public CameraErrorDescription(CameraErrorDescription cameraErrorDescription) {
            this.a = cameraErrorDescription.a;
            this.b = cameraErrorDescription.b;
            this.c = cameraErrorDescription.c;
            this.d = cameraErrorDescription.d;
            this.e = new ArrayList<>(cameraErrorDescription.e);
        }

        public ErrorType getCameraStateErrorType() {
            return this.d;
        }

        public String getErrorMsg() {
            return this.c;
        }

        public ArrayList<CameraOperation> getHistoryCameraStateErrorType() {
            return this.e;
        }

        public String getOwner() {
            return this.b;
        }

        public long getTimeStamp() {
            return this.a;
        }

        public String toString() {
            return "^timeStamp=" + String.valueOf(this.a) + "^owner=" + this.b + "^errorMsg=" + this.c + "^errorType=" + String.valueOf(this.d) + "^historyOps=" + String.valueOf(this.e);
        }

        public CameraErrorDescription(long j, String str, String str2, ErrorType errorType, ConcurrentLinkedQueue<CameraOperation> concurrentLinkedQueue) {
            this.a = j;
            this.b = str;
            this.c = str2;
            this.d = errorType;
            this.e = new ArrayList<>(concurrentLinkedQueue);
        }
    }
}
