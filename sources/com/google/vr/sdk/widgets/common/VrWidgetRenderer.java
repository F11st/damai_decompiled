package com.google.vr.sdk.widgets.common;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
import tb.v;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public abstract class VrWidgetRenderer implements GLSurfaceView.Renderer {
    private static final String TAG = VrWidgetRenderer.class.getSimpleName();
    public static boolean disableRenderingForTesting;
    private final Context context;
    private float currentYaw;
    private final Display display;
    private final GLThreadScheduler glThreadScheduler;
    private volatile SetPureTouchTrackingRequest lastSetPureTouchTrackingRequest;
    private volatile SetStereoModeRequest lastSetStereoModeRequest;
    private long nativeRenderer;
    private float[] tmpHeadAngles = new float[2];
    private float xMetersPerPixel;
    private float yMetersPerPixel;

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public interface ApiRequest {
        void execute();
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public interface GLThreadScheduler {
        void queueGlThreadEvent(Runnable runnable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public class SetPureTouchTrackingRequest implements ApiRequest {
        public final boolean setPureTouchTracking;

        public SetPureTouchTrackingRequest(boolean z) {
            this.setPureTouchTracking = z;
        }

        @Override // com.google.vr.sdk.widgets.common.VrWidgetRenderer.ApiRequest
        public void execute() {
            VrWidgetRenderer vrWidgetRenderer = VrWidgetRenderer.this;
            vrWidgetRenderer.nativeSetPureTouchTracking(vrWidgetRenderer.nativeRenderer, this.setPureTouchTracking);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public class SetStereoModeRequest implements ApiRequest {
        public final boolean stereoMode;

        public SetStereoModeRequest(boolean z) {
            this.stereoMode = z;
        }

        @Override // com.google.vr.sdk.widgets.common.VrWidgetRenderer.ApiRequest
        public void execute() {
            VrWidgetRenderer vrWidgetRenderer = VrWidgetRenderer.this;
            vrWidgetRenderer.nativeSetStereoMode(vrWidgetRenderer.nativeRenderer, this.stereoMode);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public VrWidgetRenderer(Context context, GLThreadScheduler gLThreadScheduler, float f, float f2) {
        this.context = context;
        this.glThreadScheduler = gLThreadScheduler;
        this.xMetersPerPixel = f;
        this.yMetersPerPixel = f2;
        this.display = ((WindowManager) context.getSystemService(v.ATTACH_MODE_WINDOW)).getDefaultDisplay();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void executeApiRequestOnGlThread(ApiRequest apiRequest) {
        if (disableRenderingForTesting) {
            Log.i(TAG, "disableRenderingForTesting");
        } else if (this.nativeRenderer == 0) {
            Log.i(TAG, "Native renderer has just been destroyed. Dropping request.");
        } else {
            apiRequest.execute();
        }
    }

    public void getHeadRotation(float[] fArr) {
        long j = this.nativeRenderer;
        if (j != 0) {
            nativeGetHeadRotation(j, fArr);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public long getNativeRenderer() {
        return this.nativeRenderer;
    }

    protected abstract long nativeCreate(ClassLoader classLoader, Context context, float f);

    protected abstract void nativeDestroy(long j);

    protected abstract void nativeGetHeadRotation(long j, float[] fArr);

    protected abstract void nativeOnPanningEvent(long j, float f, float f2);

    protected abstract void nativeOnPause(long j);

    protected abstract void nativeOnResume(long j);

    protected abstract void nativeRenderFrame(long j);

    protected abstract void nativeResize(long j, int i, int i2, float f, float f2, int i3);

    protected abstract void nativeSetPureTouchTracking(long j, boolean z);

    protected abstract void nativeSetStereoMode(long j, boolean z);

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onDrawFrame(GL10 gl10) {
        long j = this.nativeRenderer;
        if (j != 0) {
            nativeRenderFrame(j);
        }
    }

    public void onPanningEvent(float f, float f2) {
        long j = this.nativeRenderer;
        if (j != 0) {
            nativeOnPanningEvent(j, f, f2);
        }
    }

    public void onPause() {
        long j = this.nativeRenderer;
        if (j != 0) {
            nativeOnPause(j);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onRestoreInstanceState(Bundle bundle) {
        this.currentYaw = bundle.getFloat("currentYaw");
    }

    public void onResume() {
        long j = this.nativeRenderer;
        if (j != 0) {
            nativeOnResume(j);
        }
    }

    public Bundle onSaveInstanceState() {
        updateCurrentYaw();
        Bundle bundle = new Bundle();
        bundle.putFloat("currentYaw", this.currentYaw);
        return bundle;
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onSurfaceChanged(GL10 gl10, int i, int i2) {
        nativeResize(this.nativeRenderer, i, i2, this.xMetersPerPixel, this.yMetersPerPixel, VrWidgetView.getScreenRotationInDegrees(this.display.getRotation()));
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
        long j = this.nativeRenderer;
        if (j != 0) {
            nativeDestroy(j);
        }
        this.nativeRenderer = nativeCreate(getClass().getClassLoader(), this.context.getApplicationContext(), this.currentYaw);
        if (this.lastSetPureTouchTrackingRequest != null) {
            executeApiRequestOnGlThread(this.lastSetPureTouchTrackingRequest);
        }
        if (this.lastSetStereoModeRequest != null) {
            executeApiRequestOnGlThread(this.lastSetStereoModeRequest);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onViewDetach() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void postApiRequestToGlThread(final ApiRequest apiRequest) {
        this.glThreadScheduler.queueGlThreadEvent(new Runnable() { // from class: com.google.vr.sdk.widgets.common.VrWidgetRenderer.1
            @Override // java.lang.Runnable
            public void run() {
                VrWidgetRenderer.this.executeApiRequestOnGlThread(apiRequest);
            }
        });
    }

    public void setPureTouchTracking(boolean z) {
        this.lastSetPureTouchTrackingRequest = new SetPureTouchTrackingRequest(z);
        postApiRequestToGlThread(this.lastSetPureTouchTrackingRequest);
    }

    public void setStereoMode(boolean z) {
        this.lastSetStereoModeRequest = new SetStereoModeRequest(z);
        postApiRequestToGlThread(this.lastSetStereoModeRequest);
    }

    public void shutdown() {
        long j = this.nativeRenderer;
        if (j != 0) {
            nativeDestroy(j);
            this.nativeRenderer = 0L;
        }
    }

    public void updateCurrentYaw() {
        getHeadRotation(this.tmpHeadAngles);
        this.currentYaw = this.tmpHeadAngles[0];
    }
}
