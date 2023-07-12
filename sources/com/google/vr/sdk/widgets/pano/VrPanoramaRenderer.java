package com.google.vr.sdk.widgets.pano;

import android.content.Context;
import android.graphics.Bitmap;
import com.google.vr.sdk.widgets.common.VrEventListener;
import com.google.vr.sdk.widgets.common.VrWidgetRenderer;
import com.google.vr.sdk.widgets.pano.VrPanoramaView;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
class VrPanoramaRenderer extends VrWidgetRenderer {
    private static final String TAG = VrPanoramaRenderer.class.getSimpleName();
    private volatile VrWidgetRenderer.ApiRequest lastLoadImageRequest;

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    private class LoadBitmapRequest implements VrWidgetRenderer.ApiRequest {
        public final Bitmap bitmap;
        public final VrEventListener eventListener;
        public final VrPanoramaView.Options options;

        public LoadBitmapRequest(Bitmap bitmap, VrPanoramaView.Options options, VrEventListener vrEventListener) {
            this.bitmap = bitmap;
            this.options = options;
            this.eventListener = vrEventListener;
        }

        @Override // com.google.vr.sdk.widgets.common.VrWidgetRenderer.ApiRequest
        public void execute() {
            VrPanoramaRenderer vrPanoramaRenderer = VrPanoramaRenderer.this;
            vrPanoramaRenderer.nativeLoadImageFromBitmap(vrPanoramaRenderer.getNativeRenderer(), this.bitmap, this.options, this.eventListener);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    private class LoadImageFromByteArrayRequest implements VrWidgetRenderer.ApiRequest {
        public final VrEventListener eventListener;
        public final byte[] jpegImageData;
        public final VrPanoramaView.Options options;

        public LoadImageFromByteArrayRequest(byte[] bArr, VrPanoramaView.Options options, VrEventListener vrEventListener) {
            this.jpegImageData = bArr;
            this.options = options;
            this.eventListener = vrEventListener;
        }

        @Override // com.google.vr.sdk.widgets.common.VrWidgetRenderer.ApiRequest
        public void execute() {
            VrPanoramaRenderer vrPanoramaRenderer = VrPanoramaRenderer.this;
            vrPanoramaRenderer.nativeLoadImageFromByteArray(vrPanoramaRenderer.getNativeRenderer(), this.jpegImageData, this.options, this.eventListener);
        }
    }

    public VrPanoramaRenderer(Context context, VrWidgetRenderer.GLThreadScheduler gLThreadScheduler, float f, float f2) {
        super(context, gLThreadScheduler, f, f2);
        System.loadLibrary("panorenderer");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public native void nativeLoadImageFromBitmap(long j, Bitmap bitmap, VrPanoramaView.Options options, VrEventListener vrEventListener);

    /* JADX INFO: Access modifiers changed from: private */
    public native void nativeLoadImageFromByteArray(long j, byte[] bArr, VrPanoramaView.Options options, VrEventListener vrEventListener);

    public void loadImageFromBitmap(Bitmap bitmap, VrPanoramaView.Options options, VrEventListener vrEventListener) {
        this.lastLoadImageRequest = new LoadBitmapRequest(bitmap, options, vrEventListener);
        postApiRequestToGlThread(this.lastLoadImageRequest);
    }

    public void loadImageFromByteArray(byte[] bArr, VrPanoramaView.Options options, VrEventListener vrEventListener) {
        this.lastLoadImageRequest = new LoadImageFromByteArrayRequest(bArr, options, vrEventListener);
        postApiRequestToGlThread(this.lastLoadImageRequest);
    }

    @Override // com.google.vr.sdk.widgets.common.VrWidgetRenderer
    protected native long nativeCreate(ClassLoader classLoader, Context context, float f);

    @Override // com.google.vr.sdk.widgets.common.VrWidgetRenderer
    protected native void nativeDestroy(long j);

    @Override // com.google.vr.sdk.widgets.common.VrWidgetRenderer
    protected native void nativeGetHeadRotation(long j, float[] fArr);

    @Override // com.google.vr.sdk.widgets.common.VrWidgetRenderer
    protected native void nativeOnPanningEvent(long j, float f, float f2);

    @Override // com.google.vr.sdk.widgets.common.VrWidgetRenderer
    protected native void nativeOnPause(long j);

    @Override // com.google.vr.sdk.widgets.common.VrWidgetRenderer
    protected native void nativeOnResume(long j);

    @Override // com.google.vr.sdk.widgets.common.VrWidgetRenderer
    protected native void nativeRenderFrame(long j);

    @Override // com.google.vr.sdk.widgets.common.VrWidgetRenderer
    protected native void nativeResize(long j, int i, int i2, float f, float f2, int i3);

    @Override // com.google.vr.sdk.widgets.common.VrWidgetRenderer
    protected native void nativeSetPureTouchTracking(long j, boolean z);

    @Override // com.google.vr.sdk.widgets.common.VrWidgetRenderer
    protected native void nativeSetStereoMode(long j, boolean z);

    @Override // com.google.vr.sdk.widgets.common.VrWidgetRenderer, android.opengl.GLSurfaceView.Renderer
    public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
        super.onSurfaceCreated(gl10, eGLConfig);
        if (this.lastLoadImageRequest != null) {
            executeApiRequestOnGlThread(this.lastLoadImageRequest);
        }
    }
}
