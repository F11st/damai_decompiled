package com.alipay.mobile.bqcscanservice;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Debug;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.MessageQueue;
import android.os.Process;
import android.os.SystemClock;
import com.alipay.mobile.bqcscanservice.behavior.WalletBury;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.taobao.alivfssdk.utils.AVFSCacheConstants;
import com.uc.webview.export.extension.UCCore;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class CameraHandler implements Handler.Callback {
    public static final String TAG = "CameraScanHandler";
    public static final String TAG_COST = "CAMERA_HANDLER_COST";
    private static volatile long g;
    private HandlerThread a;
    private Handler b;
    private MPaasScanService c;
    private long e;
    public static final Integer AUTO_FOCUS_MESSAGE = 1;
    public static final Integer SECOND_FOCUS_DELAY_MESSAGE = 2;
    public static final Integer AUTO_FOCUS_CHECK = 3;
    public static final Integer SET_FOCUS_AREA = 4;
    public static final Integer CLICK_FOCUS_AREA = 5;
    public static final Integer SET_EXPOSURE_STATE = 6;
    public static final Integer ADJUST_EXPOSURE_STATE = 7;
    public static final Integer AUTO_MANUAL_FOCUS = 8;
    public static final Integer SET_METERING_AREA = 9;
    public static boolean mConsiderContext = false;
    private volatile int d = 0;
    public volatile long mInitRunDuringTime = -2;
    private volatile boolean f = false;
    public volatile int mThreadRunState = -1;
    public Map<Integer, WeakReference<OnMessageHandleCallback>> callbacks = new HashMap();

    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    class CameraPostRunnable implements Runnable {
        long curTimeStamp;
        private Runnable innerRunnable;

        public CameraPostRunnable(long j, Runnable runnable) {
            this.curTimeStamp = j;
            this.innerRunnable = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.curTimeStamp == CameraHandler.this.e && this.innerRunnable != null && CameraHandler.this.curCameraStateValid()) {
                try {
                    this.innerRunnable.run();
                } catch (Throwable th) {
                    MPaasLogger.e(CameraHandler.TAG, new Object[]{th.getMessage()});
                }
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    public interface OnMessageHandleCallback {
        void onHandleMessage(Message message);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    public class RunnableWrapper implements Runnable {
        private Runnable runnable;
        private String runnableName;

        public RunnableWrapper(String str, Runnable runnable) {
            this.runnableName = str;
            this.runnable = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                Runnable runnable = this.runnable;
                if (runnable != null) {
                    runnable.run();
                }
            } catch (Throwable th) {
                CameraHandler.this.f = true;
                WalletBury.addWalletBury("recordCameraHandlerException", new Class[]{String.class, String.class}, new Object[]{this.runnableName, th.getMessage()});
                MPaasLogger.e(CameraHandler.TAG, new Object[]{"Camera-Handler ", this.runnableName, " is error: "}, th);
            }
        }
    }

    public CameraHandler() {
        l();
    }

    public static long getTid() {
        return g;
    }

    private int k() {
        MessageQueue messageQueue;
        Looper looper = this.b.getLooper();
        if (looper == null) {
            return -9;
        }
        int i = Build.VERSION.SDK_INT;
        if (i >= 23) {
            messageQueue = looper.getQueue();
        } else {
            try {
                Field declaredField = Looper.class.getDeclaredField("mQueue");
                declaredField.setAccessible(true);
                messageQueue = (MessageQueue) declaredField.get(looper);
            } catch (Throwable unused) {
                return -1;
            }
        }
        if (messageQueue == null) {
            return -1;
        }
        m(UCCore.LEGACY_EVENT_INIT);
        if (i >= 23) {
            return messageQueue.isIdle() ? 0 : 3;
        }
        long uptimeMillis = SystemClock.uptimeMillis();
        try {
            Field declaredField2 = MessageQueue.class.getDeclaredField("mMessages");
            if (declaredField2 == null) {
                return -2;
            }
            declaredField2.setAccessible(true);
            Object obj = declaredField2.get(messageQueue);
            if (obj == null) {
                return 1;
            }
            Field declaredField3 = Message.class.getDeclaredField(RemoteMessageConst.Notification.WHEN);
            if (declaredField3 == null) {
                return -3;
            }
            declaredField3.setAccessible(true);
            Object obj2 = declaredField3.get(obj);
            if (obj2 == null) {
                return -4;
            }
            return uptimeMillis < ((Long) obj2).longValue() ? 2 : 3;
        } catch (Exception unused2) {
            return -10;
        }
    }

    private void l() {
        this.f = false;
        String str = com.alibaba.wireless.security.aopsdk.replace.android.os.Build.getBRAND() + "/" + com.alibaba.wireless.security.aopsdk.replace.android.os.Build.getMODEL();
        if (str != null) {
            if (str.toLowerCase().startsWith("xiaomi/redmi")) {
                this.a = new HandlerThread("Camera-Handler");
            } else {
                this.a = new HandlerThread("Camera-Handler", -8);
            }
        } else {
            this.a = new HandlerThread("Camera-Handler");
        }
        this.a.start();
        Handler handler = new Handler(this.a.getLooper(), this);
        this.b = handler;
        handler.post(new RunnableWrapper("tid", new Runnable() { // from class: com.alipay.mobile.bqcscanservice.CameraHandler.1
            @Override // java.lang.Runnable
            public void run() {
                long unused = CameraHandler.g = Process.myTid();
                MPaasLogger.d(CameraHandler.TAG, new Object[]{"Camera-Handler sTid: ", Long.valueOf(CameraHandler.g)});
            }
        }));
        MPaasLogger.d(TAG, new Object[]{"initCameraHandler"});
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x01a0, code lost:
        r2 = r3.isIdle();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void m(java.lang.String r28) {
        /*
            Method dump skipped, instructions count: 664
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.mobile.bqcscanservice.CameraHandler.m(java.lang.String):void");
    }

    public void addCallback(Integer num, OnMessageHandleCallback onMessageHandleCallback) {
        if (num == null || onMessageHandleCallback == null) {
            return;
        }
        this.callbacks.put(num, new WeakReference<>(onMessageHandleCallback));
    }

    public void addTraceRunnable(final Runnable runnable) {
        this.b.post(new RunnableWrapper("addTraceRunnable", new Runnable() { // from class: com.alipay.mobile.bqcscanservice.CameraHandler.6
            @Override // java.lang.Runnable
            public void run() {
                runnable.run();
            }
        }));
    }

    public void clearMessages(int i) {
        Handler handler = this.b;
        if (handler != null) {
            handler.removeMessages(i);
        }
    }

    public void closeCamera(Context context) {
        closeCamera(context, false);
    }

    public void configAndOpenCamera(final Context context, final Map<String, Object> map) {
        this.b.post(new RunnableWrapper("configAndOpenCamera", new Runnable() { // from class: com.alipay.mobile.bqcscanservice.CameraHandler.7
            @Override // java.lang.Runnable
            public void run() {
                CameraHandler.this.mThreadRunState = 2;
                long currentTimeMillis = System.currentTimeMillis();
                long threadCpuTimeNanos = Debug.threadCpuTimeNanos();
                MPaasLogger.d(CameraHandler.TAG, new Object[]{"In configAndOpenCamera(): ", Integer.valueOf(CameraHandler.this.d), ", considerContext: ", Boolean.valueOf(CameraHandler.mConsiderContext), AVFSCacheConstants.COMMA_SEP, context});
                if (CameraHandler.mConsiderContext) {
                    if (context == CameraHandler.this.c.getContext()) {
                        CameraHandler.this.configAndOpenCamera(map);
                    }
                } else {
                    CameraHandler.this.configAndOpenCamera(map);
                }
                long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                long threadCpuTimeNanos2 = (Debug.threadCpuTimeNanos() - threadCpuTimeNanos) / 1000000;
                MPaasLogger.d(CameraHandler.TAG_COST, new Object[]{"configAndOpenCamera cost time: ", Long.valueOf(currentTimeMillis2), " cpu cost time: ", Long.valueOf(threadCpuTimeNanos2)});
                Class cls = Long.TYPE;
                WalletBury.addWalletBury("recordCameraHandlerRunnableCost", new Class[]{String.class, cls, cls}, new Object[]{"configAndOpenCamera", Long.valueOf(currentTimeMillis2), Long.valueOf(threadCpuTimeNanos2)});
            }
        }));
    }

    public boolean curCameraStateValid() {
        return this.d == 3;
    }

    public void destroy() {
        this.a.quit();
        MPaasLogger.e(TAG, new Object[]{"cameraHandlerThread is quit"});
    }

    public Handler getCameraHandler() {
        return this.b;
    }

    public int getCameraHandlerState() {
        if (this.a.isAlive()) {
            return this.mThreadRunState;
        }
        return -2;
    }

    public String getStackTrace() {
        StackTraceElement[] stackTrace;
        try {
            HandlerThread handlerThread = this.a;
            if (handlerThread == null || (stackTrace = handlerThread.getStackTrace()) == null) {
                return null;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("dump Camera-Handler stackTrace: ");
            for (StackTraceElement stackTraceElement : stackTrace) {
                sb.append(String.valueOf(stackTraceElement));
                sb.append(StringUtils.LF);
            }
            return sb.toString();
        } catch (Throwable unused) {
            return null;
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (this.d != 3) {
            MPaasLogger.d(TAG, new Object[]{"handleMessage while camera state is not 3: ", message});
            return true;
        }
        try {
            WeakReference<OnMessageHandleCallback> weakReference = this.callbacks.get(Integer.valueOf(message.what));
            if (weakReference == null) {
                MPaasLogger.d(TAG, new Object[]{"handleMessage, weakReference is null. The what is ", Integer.valueOf(message.what)});
                return true;
            }
            OnMessageHandleCallback onMessageHandleCallback = weakReference.get();
            if (onMessageHandleCallback == null) {
                MPaasLogger.d(TAG, new Object[]{"handleMessage, callback is null. The what is ", Integer.valueOf(message.what)});
                return true;
            }
            onMessageHandleCallback.onHandleMessage(message);
            return true;
        } catch (Exception e) {
            MPaasLogger.e(TAG, new Object[]{"handleMessage: "}, e);
            return false;
        }
    }

    public void init(Context context, BQCScanCallback bQCScanCallback) {
        init(context, bQCScanCallback, 0);
    }

    public void onSurfaceViewAvailable() {
        this.b.post(new RunnableWrapper("surfaceViewAvailable", new Runnable() { // from class: com.alipay.mobile.bqcscanservice.CameraHandler.12
            @Override // java.lang.Runnable
            public void run() {
                MPaasLogger.d(CameraHandler.TAG, new Object[]{"In onSurfaceViewAvailable()", Integer.valueOf(CameraHandler.this.d)});
                if (CameraHandler.this.d == 3) {
                    CameraHandler.this.mThreadRunState = 3;
                    CameraHandler.this.c.onSurfaceAvailable();
                }
            }
        }));
    }

    public void openCamera() {
        MPaasLogger.d(TAG, new Object[]{"In openCamera()", Integer.valueOf(this.d)});
        if (Looper.myLooper() == this.b.getLooper()) {
            if (3 <= this.d) {
                return;
            }
            this.e = System.currentTimeMillis();
            this.c.startPreview();
            this.d = 3;
            return;
        }
        this.b.post(new RunnableWrapper("openCamera", new Runnable() { // from class: com.alipay.mobile.bqcscanservice.CameraHandler.11
            @Override // java.lang.Runnable
            public void run() {
                MPaasLogger.d(CameraHandler.TAG, new Object[]{"post In openCamera()", Integer.valueOf(CameraHandler.this.d)});
                if (3 <= CameraHandler.this.d) {
                    return;
                }
                CameraHandler.this.e = System.currentTimeMillis();
                CameraHandler.this.c.startPreview();
                CameraHandler.this.d = 3;
            }
        }));
    }

    public void post(Runnable runnable) {
        this.b.post(new RunnableWrapper("post1", new CameraPostRunnable(this.e, runnable)));
    }

    public void postCloseCamera() {
        this.b.post(new RunnableWrapper("postCloseCamera", new Runnable() { // from class: com.alipay.mobile.bqcscanservice.CameraHandler.4
            @Override // java.lang.Runnable
            public void run() {
                MPaasLogger.d(CameraHandler.TAG, new Object[]{"In postCloseCamera()", Integer.valueOf(CameraHandler.this.d)});
                if (CameraHandler.this.d != 0) {
                    return;
                }
                CameraHandler.this.mThreadRunState = 6;
                CameraHandler.this.c.tryPostCloseCamera();
                CameraHandler.this.d = 0;
            }
        }));
    }

    public void postDelayed(final Runnable runnable, long j) {
        this.b.postDelayed(new Runnable() { // from class: com.alipay.mobile.bqcscanservice.CameraHandler.15
            @Override // java.lang.Runnable
            public void run() {
                if (CameraHandler.this.d == 3) {
                    MPaasLogger.d(CameraHandler.TAG, new Object[]{"The curCameraState is ", Integer.valueOf(CameraHandler.this.d)});
                    runnable.run();
                }
            }
        }, j);
    }

    public void postRunnableToCameraThread(Runnable runnable, long j) {
        if (runnable != null) {
            this.b.postDelayed(new CameraPostRunnable(this.e, runnable), j);
        }
    }

    public void postViewFrameToRecognize(final Bitmap bitmap) {
        if (Looper.myLooper() == this.b.getLooper()) {
            MPaasLogger.d(TAG, new Object[]{"In postViewFrameToRecognize()"});
            MPaasScanService mPaasScanService = this.c;
            if (mPaasScanService != null) {
                mPaasScanService.useViewFrameToRecognize(bitmap);
                return;
            }
            return;
        }
        this.b.post(new RunnableWrapper("postViewFrameToRecognize", new Runnable() { // from class: com.alipay.mobile.bqcscanservice.CameraHandler.9
            @Override // java.lang.Runnable
            public void run() {
                MPaasLogger.d(CameraHandler.TAG, new Object[]{"In postViewFrameToRecognize()", Integer.valueOf(CameraHandler.this.d)});
                if (CameraHandler.this.c != null) {
                    CameraHandler.this.c.useViewFrameToRecognize(bitmap);
                }
            }
        }));
    }

    public void preOpenCamera() {
        this.b.post(new RunnableWrapper("preOpenCamera", new Runnable() { // from class: com.alipay.mobile.bqcscanservice.CameraHandler.3
            @Override // java.lang.Runnable
            public void run() {
                MPaasLogger.d(CameraHandler.TAG, new Object[]{"In PreOpenCamera()", Integer.valueOf(CameraHandler.this.d)});
                if (CameraHandler.this.d != 0) {
                    return;
                }
                CameraHandler.this.mThreadRunState = 0;
                long currentTimeMillis = System.currentTimeMillis();
                long threadCpuTimeNanos = Debug.threadCpuTimeNanos();
                CameraHandler.this.c.tryPreOpenCamera();
                CameraHandler.this.d = 0;
                long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                long threadCpuTimeNanos2 = (Debug.threadCpuTimeNanos() - threadCpuTimeNanos) / 1000000;
                MPaasLogger.d(CameraHandler.TAG_COST, new Object[]{"preOpenCamera cost time: ", Long.valueOf(currentTimeMillis2), " cpu cost time: ", Long.valueOf(threadCpuTimeNanos2)});
                Class cls = Long.TYPE;
                WalletBury.addWalletBury("recordCameraHandlerRunnableCost", new Class[]{String.class, cls, cls}, new Object[]{"preOpenCamera", Long.valueOf(currentTimeMillis2), Long.valueOf(threadCpuTimeNanos2)});
            }
        }));
    }

    public void preProcessScanPageQuit() {
        if (Looper.myLooper() == this.b.getLooper()) {
            MPaasLogger.d(TAG, new Object[]{"In processScanPagePreQuit()", Integer.valueOf(this.d)});
            MPaasScanService mPaasScanService = this.c;
            if (mPaasScanService != null) {
                mPaasScanService.release();
                return;
            }
            return;
        }
        this.b.post(new RunnableWrapper("processScanPagePreQuit", new Runnable() { // from class: com.alipay.mobile.bqcscanservice.CameraHandler.10
            @Override // java.lang.Runnable
            public void run() {
                MPaasLogger.d(CameraHandler.TAG, new Object[]{"In processScanPagePreQuit()", Integer.valueOf(CameraHandler.this.d)});
                if (CameraHandler.this.c != null) {
                    CameraHandler.this.c.release();
                }
            }
        }));
    }

    public void release(final Context context, final long j) {
        this.b.post(new RunnableWrapper("release", new Runnable() { // from class: com.alipay.mobile.bqcscanservice.CameraHandler.16
            @Override // java.lang.Runnable
            public void run() {
                CameraHandler.this.mThreadRunState = 5;
                MPaasLogger.d(CameraHandler.TAG, new Object[]{"In release()", Integer.valueOf(CameraHandler.this.d), ", considerContext: ", Boolean.valueOf(CameraHandler.mConsiderContext), AVFSCacheConstants.COMMA_SEP, context});
                if (CameraHandler.mConsiderContext) {
                    if (context == CameraHandler.this.c.getContext() || CameraHandler.this.c.getContext() == null) {
                        CameraHandler.this.release(j);
                        return;
                    }
                    return;
                }
                CameraHandler.this.release(j);
            }
        }));
    }

    public void removeCallback(Integer num) {
        if (num == null) {
            return;
        }
        this.callbacks.remove(num);
    }

    public void removeCallbacks(Runnable runnable) {
        Handler handler = this.b;
        if (handler != null) {
            handler.removeCallbacks(runnable);
        }
    }

    public void sendMessage(int i) {
        Handler handler = this.b;
        if (handler != null) {
            handler.sendEmptyMessage(i);
        }
    }

    public void sendMessageDelayed(int i, long j) {
        Handler handler = this.b;
        if (handler != null) {
            handler.sendEmptyMessageDelayed(i, j);
        }
    }

    public void setBqcScanService(final MPaasScanService mPaasScanService) {
        this.b.post(new RunnableWrapper("setBqcScanService", new Runnable() { // from class: com.alipay.mobile.bqcscanservice.CameraHandler.2
            @Override // java.lang.Runnable
            public void run() {
                CameraHandler.this.c = mPaasScanService;
            }
        }));
    }

    public void closeCamera(final Context context, final boolean z) {
        MPaasScanService mPaasScanService = this.c;
        if (mPaasScanService != null) {
            mPaasScanService.setOpenRetryStopFlag(true);
            this.c.stopWatchDogMonitor();
        }
        if (z) {
            MPaasLogger.d(TAG, new Object[]{"AvoidBlock In closeCamera() remove Camera Thread Task"});
            this.b.removeCallbacksAndMessages(null);
        }
        this.b.post(new RunnableWrapper("closeCamera", new Runnable() { // from class: com.alipay.mobile.bqcscanservice.CameraHandler.13
            @Override // java.lang.Runnable
            public void run() {
                CameraHandler.this.mThreadRunState = 4;
                long currentTimeMillis = System.currentTimeMillis();
                long threadCpuTimeNanos = Debug.threadCpuTimeNanos();
                MPaasLogger.d(CameraHandler.TAG, new Object[]{" In closeCamera()", Integer.valueOf(CameraHandler.this.d), ", considerContext: ", Boolean.valueOf(CameraHandler.mConsiderContext), AVFSCacheConstants.COMMA_SEP + context + " ,removeTask: ", Boolean.valueOf(z)});
                if (CameraHandler.mConsiderContext) {
                    if (context == CameraHandler.this.c.getContext()) {
                        CameraHandler.this.closeCamera();
                    }
                } else {
                    CameraHandler.this.closeCamera();
                }
                long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                long threadCpuTimeNanos2 = (Debug.threadCpuTimeNanos() - threadCpuTimeNanos) / 1000000;
                MPaasLogger.d(CameraHandler.TAG_COST, new Object[]{"closeCamera cost time: ", Long.valueOf(currentTimeMillis2), " cpu cost time: ", Long.valueOf(threadCpuTimeNanos2)});
                Class cls = Long.TYPE;
                WalletBury.addWalletBury("recordCameraHandlerRunnableCost", new Class[]{String.class, cls, cls}, new Object[]{"closeCamera", Long.valueOf(currentTimeMillis2), Long.valueOf(threadCpuTimeNanos2)});
            }
        }));
        if (this.mInitRunDuringTime == -1) {
            String stackTrace = getStackTrace();
            MPaasLogger.d(TAG, new Object[]{stackTrace});
            if (stackTrace != null) {
                WalletBury.addWalletBury("recordCameraHandlerConsumeTimeCallStack", new Class[]{Integer.TYPE, String.class}, new Object[]{Integer.valueOf(this.mThreadRunState), stackTrace});
            }
        }
    }

    public void configAndOpenCamera(final Map<String, Object> map) {
        MPaasScanService mPaasScanService = this.c;
        if (mPaasScanService != null) {
            mPaasScanService.setOpenRetryStopFlag(false);
        }
        if (Looper.myLooper() == this.b.getLooper()) {
            MPaasLogger.d(TAG, new Object[]{"In configAndOpenCamera()", Integer.valueOf(this.d)});
            if (2 <= this.d) {
                return;
            }
            if (map != null) {
                for (String str : map.keySet()) {
                    this.c.setCameraParam(str, map.get(str));
                }
            }
            this.d = 2;
            openCamera();
            return;
        }
        this.b.post(new RunnableWrapper("configAndOpenCamera2", new Runnable() { // from class: com.alipay.mobile.bqcscanservice.CameraHandler.8
            @Override // java.lang.Runnable
            public void run() {
                MPaasLogger.d(CameraHandler.TAG, new Object[]{"In configAndOpenCamera()", Integer.valueOf(CameraHandler.this.d)});
                if (2 <= CameraHandler.this.d) {
                    return;
                }
                Map map2 = map;
                if (map2 != null) {
                    for (String str2 : map2.keySet()) {
                        CameraHandler.this.c.setCameraParam(str2, map.get(str2));
                    }
                }
                CameraHandler.this.d = 2;
                CameraHandler.this.openCamera();
            }
        }));
    }

    public void init(final Context context, final BQCScanCallback bQCScanCallback, final int i) {
        boolean z;
        if (this.a.isAlive()) {
            z = true;
        } else {
            MPaasLogger.e(TAG, new Object[]{"WARNING! Camera-Handler Thread is died, reStart it"});
            l();
            z = false;
        }
        this.mInitRunDuringTime = -1L;
        final long currentTimeMillis = System.currentTimeMillis();
        final int k = k();
        boolean post = this.b.post(new RunnableWrapper(UCCore.LEGACY_EVENT_INIT, new Runnable() { // from class: com.alipay.mobile.bqcscanservice.CameraHandler.5
            @Override // java.lang.Runnable
            public void run() {
                CameraHandler.this.mThreadRunState = 1;
                CameraHandler.this.mInitRunDuringTime = System.currentTimeMillis() - currentTimeMillis;
                MPaasLogger.d(CameraHandler.TAG, new Object[]{"mInitRunDuringTime: ", Long.valueOf(CameraHandler.this.mInitRunDuringTime), ", state = ", Integer.valueOf(k)});
                WalletBury.addWalletBury("recordCameraHandlerState", new Class[]{Long.TYPE, Integer.TYPE}, new Object[]{Long.valueOf(CameraHandler.this.mInitRunDuringTime), Integer.valueOf(k)});
                Context context2 = CameraHandler.this.c.getContext();
                MPaasLogger.d(CameraHandler.TAG, new Object[]{"In init()", Integer.valueOf(CameraHandler.this.d), "isException ", Boolean.valueOf(CameraHandler.this.f), ", considerContext: ", Boolean.valueOf(CameraHandler.mConsiderContext), ", oldBqcContext:" + context2, ", context:", context});
                if ((CameraHandler.mConsiderContext && context2 != null) || CameraHandler.this.f) {
                    CameraHandler.this.f = false;
                    if (CameraHandler.this.d >= 1) {
                        CameraHandler.this.closeCamera();
                        CameraHandler.this.release(0L);
                    }
                }
                MPaasLogger.d(CameraHandler.TAG, new Object[]{"In init()", Integer.valueOf(CameraHandler.this.d), ", context: ", context, " cameraFacingType: ", Integer.valueOf(i)});
                if (1 <= CameraHandler.this.d) {
                    return;
                }
                CameraHandler.this.c.setup(context, bQCScanCallback, i);
                CameraHandler.this.d = 1;
            }
        }));
        Class cls = Boolean.TYPE;
        WalletBury.addWalletBury("recordCameraHandlerDeadState", new Class[]{cls, cls}, new Object[]{Boolean.valueOf(z), Boolean.valueOf(post)});
        MPaasLogger.d(TAG, new Object[]{"init runnable post result: ", Boolean.valueOf(post)});
    }

    public void release(final long j) {
        if (Looper.myLooper() == this.b.getLooper()) {
            MPaasLogger.d(TAG, new Object[]{"In release()", Integer.valueOf(this.d)});
            if (5 <= this.d) {
                return;
            }
            this.c.cleanup(j);
            this.d = 0;
            return;
        }
        this.b.post(new RunnableWrapper("release2", new Runnable() { // from class: com.alipay.mobile.bqcscanservice.CameraHandler.17
            @Override // java.lang.Runnable
            public void run() {
                MPaasLogger.d(CameraHandler.TAG, new Object[]{"In release()", Integer.valueOf(CameraHandler.this.d)});
                if (5 <= CameraHandler.this.d) {
                    return;
                }
                CameraHandler.this.c.cleanup(j);
                CameraHandler.this.d = 0;
            }
        }));
    }

    public void post(Runnable runnable, boolean z) {
        if (this.d == 3) {
            if (z) {
                this.b.removeCallbacks(runnable);
            }
            this.b.post(new RunnableWrapper("post2", runnable));
        }
    }

    public void sendMessage(Message message) {
        Handler handler = this.b;
        if (handler == null || message == null) {
            return;
        }
        handler.sendMessage(message);
    }

    public void closeCamera() {
        if (Looper.myLooper() == this.b.getLooper()) {
            MPaasLogger.d(TAG, new Object[]{"In closeCamera()", Integer.valueOf(this.d)});
            if (4 <= this.d) {
                return;
            }
            this.e = System.currentTimeMillis();
            this.d = 4;
            this.c.stopPreview();
            this.d = 1;
            return;
        }
        this.b.post(new RunnableWrapper("closeCamera2", new Runnable() { // from class: com.alipay.mobile.bqcscanservice.CameraHandler.14
            @Override // java.lang.Runnable
            public void run() {
                MPaasLogger.d(CameraHandler.TAG, new Object[]{" In closeCamera()", Integer.valueOf(CameraHandler.this.d)});
                if (4 <= CameraHandler.this.d) {
                    return;
                }
                CameraHandler.this.e = System.currentTimeMillis();
                CameraHandler.this.d = 4;
                CameraHandler.this.c.stopPreview();
                CameraHandler.this.d = 1;
            }
        }));
    }
}
