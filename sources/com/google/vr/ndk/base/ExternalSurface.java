package com.google.vr.ndk.base;

import android.os.Handler;
import android.util.Log;
import android.view.Surface;
import com.google.vr.ndk.base.GvrLayout;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class ExternalSurface {
    private static final String TAG = "ExternalSurface";
    private long nativeExternalSurface;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ExternalSurface(GvrApi gvrApi, final GvrLayout.ExternalSurfaceListener externalSurfaceListener, Handler handler) {
        if (externalSurfaceListener == null) {
            throw new IllegalArgumentException("ExternalSurface creation requires a valid listener.");
        }
        if (handler != null) {
            long nativeExternalSurfaceCreateWithListeners = GvrApi.nativeExternalSurfaceCreateWithListeners(gvrApi.getNativeGvrContext(), new Runnable() { // from class: com.google.vr.ndk.base.ExternalSurface.1
                @Override // java.lang.Runnable
                public void run() {
                    externalSurfaceListener.onSurfaceAvailable(ExternalSurface.this.getSurface());
                }
            }, new Runnable(this) { // from class: com.google.vr.ndk.base.ExternalSurface.2
                @Override // java.lang.Runnable
                public void run() {
                    externalSurfaceListener.onFrameAvailable();
                }
            }, handler);
            this.nativeExternalSurface = nativeExternalSurfaceCreateWithListeners;
            if (nativeExternalSurfaceCreateWithListeners == 0) {
                throw new IllegalStateException("ExternalSurface creation failed. Is reprojection enabled?");
            }
            return;
        }
        throw new IllegalArgumentException("ExternalSurface creation requires a valid Handler.");
    }

    protected void finalize() throws Throwable {
        try {
            if (this.nativeExternalSurface != 0) {
                Log.w(TAG, "ExternalSurface.shutdown() should be called to ensure resource cleanup");
                shutdown();
            }
        } finally {
            super.finalize();
        }
    }

    public int getId() {
        return GvrApi.nativeExternalSurfaceGetId(this.nativeExternalSurface);
    }

    public Surface getSurface() {
        return GvrApi.nativeExternalSurfaceGetSurface(this.nativeExternalSurface);
    }

    public void shutdown() {
        long j = this.nativeExternalSurface;
        if (j != 0) {
            GvrApi.nativeExternalSurfaceDestroy(j);
            this.nativeExternalSurface = 0L;
        }
    }
}
