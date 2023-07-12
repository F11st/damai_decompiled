package com.google.vr.ndk.base;

import android.content.Context;
import android.graphics.Point;
import android.graphics.RectF;
import android.os.Build;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.Surface;
import com.google.common.logging.nano.Vr$VREvent;
import com.google.vr.cardboard.DisplaySynchronizer;
import com.google.vr.cardboard.EglReadyListener;
import com.google.vr.cardboard.UsedByNative;
import com.google.vr.cardboard.VrParamsProvider;
import com.google.vr.cardboard.annotations.UsedByReflection;
import com.google.vr.ndk.base.GvrLayout;
import com.google.vr.sdk.proto.nano.Phone;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import tb.az2;
import tb.ga0;

/* compiled from: Taobao */
@UsedByReflection("Unity")
/* loaded from: classes10.dex */
public class GvrApi {
    private static final boolean IS_ROBOLECTRIC_BUILD = "robolectric".equals(Build.FINGERPRINT);
    private static final String TAG = "GvrApi";
    private static PoseTracker sPoseTrackerForTesting;
    private final Context context;
    private final DisplaySynchronizer displaySynchronizer;
    private long nativeGvrContext;
    private final boolean ownsNativeGvrContext;
    private ArrayList<WeakReference<SwapChain>> swapChainRefs;
    private final VrParamsProvider vrParamsProvider;

    /* compiled from: Taobao */
    @UsedByNative
    /* loaded from: classes10.dex */
    interface IdleListener {
        @UsedByNative
        void onIdleChanged(boolean z);
    }

    /* compiled from: Taobao */
    @UsedByNative
    /* loaded from: classes10.dex */
    public interface PoseTracker {
        @UsedByNative
        void getHeadPoseInStartSpace(float[] fArr, long j);
    }

    static {
        try {
            System.loadLibrary("gvr");
        } catch (UnsatisfiedLinkError unused) {
        }
    }

    public GvrApi(Context context, DisplaySynchronizer displaySynchronizer) {
        this.context = context;
        this.displaySynchronizer = displaySynchronizer;
        long c = displaySynchronizer == null ? 0L : displaySynchronizer.c();
        VrParamsProvider a = az2.a(context);
        this.vrParamsProvider = a;
        Phone.PhoneParams readPhoneParams = a.readPhoneParams();
        this.swapChainRefs = new ArrayList<>();
        DisplayMetrics computeCurrentDisplayMetrics = computeCurrentDisplayMetrics(readPhoneParams);
        this.ownsNativeGvrContext = true;
        if (IS_ROBOLECTRIC_BUILD) {
            return;
        }
        long nativeCreate = nativeCreate(getClass().getClassLoader(), context.getApplicationContext(), c, com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getwidthPixels(computeCurrentDisplayMetrics), com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getheightPixels(computeCurrentDisplayMetrics), computeCurrentDisplayMetrics.xdpi, computeCurrentDisplayMetrics.ydpi, sPoseTrackerForTesting);
        this.nativeGvrContext = nativeCreate;
        if (nativeCreate == 0) {
            throw new IllegalStateException("Native GVR context creation failed, implementation unavailable.");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static DisplaySynchronizer createDefaultDisplaySynchronizer(Context context) {
        return new DisplaySynchronizer(context, ga0.b(context));
    }

    static native byte[] nativeAnalyticsCreateSample(long j, byte[] bArr);

    static native long nativeBufferSpecCreate(long j);

    static native void nativeBufferSpecDestroy(long j);

    static native int nativeBufferSpecGetSamples(long j);

    static native void nativeBufferSpecGetSize(long j, Point point);

    static native void nativeBufferSpecSetColorFormat(long j, int i);

    static native void nativeBufferSpecSetDepthStencilFormat(long j, int i);

    static native void nativeBufferSpecSetMultiviewLayers(long j, int i);

    static native void nativeBufferSpecSetSamples(long j, int i);

    static native void nativeBufferSpecSetSize(long j, int i, int i2);

    static native long nativeBufferViewportCreate(long j);

    static native void nativeBufferViewportDestroy(long j);

    static native boolean nativeBufferViewportEqual(long j, long j2);

    static native int nativeBufferViewportGetExternalSurfaceId(long j);

    static native float nativeBufferViewportGetOpacity(long j);

    static native int nativeBufferViewportGetReprojection(long j);

    static native int nativeBufferViewportGetSourceBufferIndex(long j);

    static native void nativeBufferViewportGetSourceFov(long j, RectF rectF);

    static native void nativeBufferViewportGetSourceUv(long j, RectF rectF);

    static native int nativeBufferViewportGetTargetEye(long j);

    static native void nativeBufferViewportGetTransform(long j, float[] fArr);

    private native long nativeBufferViewportListCreate(long j);

    static native void nativeBufferViewportListDestroy(long j);

    static native void nativeBufferViewportListGetItem(long j, int i, long j2);

    static native int nativeBufferViewportListGetSize(long j);

    static native void nativeBufferViewportListSetItem(long j, int i, long j2);

    static native void nativeBufferViewportSetExternalSurface(long j, long j2);

    static native void nativeBufferViewportSetExternalSurfaceId(long j, int i);

    static native void nativeBufferViewportSetOpacity(long j, float f);

    static native void nativeBufferViewportSetReprojection(long j, int i);

    static native void nativeBufferViewportSetSourceBufferIndex(long j, int i);

    static native void nativeBufferViewportSetSourceFov(long j, float f, float f2, float f3, float f4);

    static native void nativeBufferViewportSetSourceLayer(long j, int i);

    static native void nativeBufferViewportSetSourceUv(long j, float f, float f2, float f3, float f4);

    static native void nativeBufferViewportSetTargetEye(long j, int i);

    static native void nativeBufferViewportSetTransform(long j, float[] fArr);

    private native int nativeClearError(long j);

    private native float[] nativeComputeDistortedPoint(long j, int i, float[] fArr);

    private native long nativeCreate(ClassLoader classLoader, Context context, long j, int i, int i2, float f, float f2, PoseTracker poseTracker);

    private native void nativeDistortToScreen(long j, int i, long j2, float[] fArr, long j3);

    private native void nativeDumpDebugData(long j);

    static native long nativeExternalSurfaceCreate(long j);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native long nativeExternalSurfaceCreateWithListeners(long j, Runnable runnable, Runnable runnable2, Handler handler);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native void nativeExternalSurfaceDestroy(long j);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native int nativeExternalSurfaceGetId(long j);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native Surface nativeExternalSurfaceGetSurface(long j);

    static native void nativeFrameBindBuffer(long j, int i);

    static native void nativeFrameGetBufferSize(long j, int i, Point point);

    static native int nativeFrameGetFramebufferObject(long j, int i);

    static native void nativeFrameSubmit(long j, long j2, float[] fArr);

    static native void nativeFrameUnbind(long j);

    private native boolean nativeGetAsyncReprojectionEnabled(long j);

    private native float nativeGetBorderSizeMeters(long j);

    private native int nativeGetError(long j);

    private static native String nativeGetErrorString(int i);

    private native void nativeGetEyeFromHeadMatrix(long j, int i, float[] fArr);

    private native void nativeGetHeadSpaceFromStartSpaceRotation(long j, float[] fArr, long j2);

    private native void nativeGetHeadSpaceFromStartSpaceTransform(long j, float[] fArr, long j2);

    private native void nativeGetMaximumEffectiveRenderTargetSize(long j, Point point);

    private native void nativeGetRecommendedBufferViewports(long j, long j2);

    private native void nativeGetScreenBufferViewports(long j, long j2);

    private native void nativeGetScreenTargetSize(long j, Point point);

    private native long nativeGetUserPrefs(long j);

    private native String nativeGetViewerModel(long j);

    private native int nativeGetViewerType(long j);

    private native String nativeGetViewerVendor(long j);

    private native int[] nativeGetWindowBounds(long j);

    private native void nativeInitializeGl(long j);

    private native boolean nativeIsFeatureSupported(long j, int i);

    private native void nativeOnPauseReprojectionThread(long j);

    private native void nativeOnSurfaceChangedReprojectionThread(long j);

    private native void nativeOnSurfaceCreatedReprojectionThread(long j);

    private native void nativePause(long j);

    private native void nativePauseTracking(long j);

    private native byte[] nativePauseTrackingGetState(long j);

    private native void nativeRecenterTracking(long j);

    private native void nativeReconnectSensors(long j);

    private native void nativeReleaseGvrContext(long j);

    private native Point nativeRenderReprojectionThread(long j);

    private native void nativeRequestContextSharing(long j, EglReadyListener eglReadyListener);

    private native void nativeResetTracking(long j);

    private native void nativeResume(long j);

    private native void nativeResumeTracking(long j);

    private native void nativeResumeTrackingSetState(long j, byte[] bArr);

    private static native void nativeSetApplicationState(ClassLoader classLoader, Context context);

    private native boolean nativeSetAsyncReprojectionEnabled(long j, boolean z);

    private native void nativeSetDefaultFramebufferActive(long j);

    private native boolean nativeSetDefaultViewerProfile(long j, String str);

    private native void nativeSetDisplayMetrics(long j, int i, int i2, float f, float f2);

    private static native void nativeSetDynamicLibraryLoadingEnabled(boolean z);

    private native void nativeSetIdleListener(long j, IdleListener idleListener);

    private native void nativeSetIgnoreManualPauseResumeTracker(long j, boolean z);

    private native void nativeSetLensOffset(long j, float f, float f2, float f3);

    private native void nativeSetSurfaceSize(long j, int i, int i2);

    private native boolean nativeSetViewerParams(long j, byte[] bArr);

    static native long nativeSwapChainAcquireFrame(long j);

    static native long nativeSwapChainCreate(long j, long[] jArr);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native void nativeSwapChainDestroy(long j);

    static native int nativeSwapChainGetBufferCount(long j);

    static native void nativeSwapChainGetBufferSize(long j, int i, Point point);

    static native void nativeSwapChainResizeBuffer(long j, int i, int i2, int i3);

    static native int nativeUserPrefsGetControllerHandedness(long j);

    static native boolean nativeUserPrefsGetPerformanceHudEnabled(long j);

    static native boolean nativeUserPrefsGetPerformanceMonitoringEnabled(long j);

    private static native boolean nativeUsingDynamicLibrary();

    private native boolean nativeUsingVrDisplayService(long j);

    private static void setApplicationState(Context context) {
        if (IS_ROBOLECTRIC_BUILD) {
            return;
        }
        nativeSetApplicationState(GvrApi.class.getClassLoader(), context.getApplicationContext());
    }

    public static boolean usingDynamicLibrary(Context context) {
        setApplicationState(context);
        return nativeUsingDynamicLibrary();
    }

    DisplayMetrics computeCurrentDisplayMetrics(Phone.PhoneParams phoneParams) {
        Display b;
        DisplaySynchronizer displaySynchronizer = this.displaySynchronizer;
        if (displaySynchronizer == null) {
            b = ga0.b(this.context);
        } else {
            b = displaySynchronizer.b();
        }
        return ga0.d(b, phoneParams);
    }

    public ExternalSurface createExternalSurface(GvrLayout.ExternalSurfaceListener externalSurfaceListener, Handler handler) {
        return new ExternalSurface(this, externalSurfaceListener, handler);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void dumpDebugData() {
        nativeDumpDebugData(this.nativeGvrContext);
    }

    protected void finalize() throws Throwable {
        try {
            if (this.nativeGvrContext != 0) {
                Log.w(TAG, "GvrApi.shutdown() should be called to ensure resource cleanup");
                shutdown();
            }
        } finally {
            super.finalize();
        }
    }

    public boolean getAsyncReprojectionEnabled() {
        return nativeGetAsyncReprojectionEnabled(this.nativeGvrContext);
    }

    @UsedByReflection("Unity")
    public long getNativeGvrContext() {
        return this.nativeGvrContext;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Vr$VREvent.SdkConfigurationParams getSdkConfigurationParams() {
        return SdkConfigurationReader.getParams(this.context);
    }

    public int getViewerType() {
        return nativeGetViewerType(this.nativeGvrContext);
    }

    public boolean isFeatureSupported(int i) {
        return nativeIsFeatureSupported(this.nativeGvrContext, i);
    }

    public void onPauseReprojectionThread() {
        nativeOnPauseReprojectionThread(this.nativeGvrContext);
    }

    public void onSurfaceChangedReprojectionThread() {
        nativeOnSurfaceChangedReprojectionThread(this.nativeGvrContext);
    }

    public void onSurfaceCreatedReprojectionThread() {
        nativeOnSurfaceCreatedReprojectionThread(this.nativeGvrContext);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void pause() {
        nativePause(this.nativeGvrContext);
    }

    public byte[] pauseTrackingGetState() {
        return nativePauseTrackingGetState(this.nativeGvrContext);
    }

    public void recenterTracking() {
        nativeRecenterTracking(this.nativeGvrContext);
    }

    public Point renderReprojectionThread() {
        return nativeRenderReprojectionThread(this.nativeGvrContext);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void requestContextSharing(EglReadyListener eglReadyListener) {
        nativeRequestContextSharing(this.nativeGvrContext, eglReadyListener);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void resume() {
        nativeResume(this.nativeGvrContext);
    }

    public void resumeTrackingSetState(byte[] bArr) {
        nativeResumeTrackingSetState(this.nativeGvrContext, bArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean setAsyncReprojectionEnabled(boolean z) {
        return nativeSetAsyncReprojectionEnabled(this.nativeGvrContext, z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setIdleListener(IdleListener idleListener) {
        nativeSetIdleListener(this.nativeGvrContext, idleListener);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setIgnoreManualTrackerPauseResume(boolean z) {
        nativeSetIgnoreManualPauseResumeTracker(this.nativeGvrContext, z);
    }

    public void setLensOffset(float f, float f2, float f3) {
        nativeSetLensOffset(this.nativeGvrContext, f, f2, f3);
    }

    public void setSurfaceSize(int i, int i2) {
        if ((i == 0) == (i2 == 0)) {
            nativeSetSurfaceSize(this.nativeGvrContext, i, i2);
            return;
        }
        throw new IllegalArgumentException("Custom surface dimensions should both either be zero or non-zero");
    }

    public void shutdown() {
        ArrayList<WeakReference<SwapChain>> arrayList = this.swapChainRefs;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            WeakReference<SwapChain> weakReference = arrayList.get(i);
            i++;
            SwapChain swapChain = weakReference.get();
            if (swapChain != null) {
                swapChain.shutdown();
            }
        }
        if (this.nativeGvrContext != 0) {
            this.vrParamsProvider.close();
            if (this.ownsNativeGvrContext) {
                nativeReleaseGvrContext(this.nativeGvrContext);
            }
            this.nativeGvrContext = 0L;
        }
    }

    public boolean usingVrDisplayService() {
        return nativeUsingVrDisplayService(this.nativeGvrContext);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public GvrApi(Context context, long j) {
        if (j != 0) {
            this.context = context;
            this.ownsNativeGvrContext = false;
            this.nativeGvrContext = j;
            this.vrParamsProvider = az2.a(context);
            this.displaySynchronizer = null;
            this.swapChainRefs = new ArrayList<>();
            setApplicationState(context);
            return;
        }
        throw new IllegalArgumentException("Invalid wrapped native GVR context.");
    }
}
