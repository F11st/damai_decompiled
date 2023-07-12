package com.google.vr.ndk.base;

import android.app.PendingIntent;
import android.content.Context;
import android.os.Handler;
import android.os.RemoteException;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Surface;
import android.view.View;
import android.widget.FrameLayout;
import com.google.vr.cardboard.annotations.UsedByReflection;
import com.google.vr.vrcore.library.api.IGvrLayout;
import com.google.vr.vrcore.library.api.ObjectWrapper;
import tb.co;
import tb.zy2;

/* compiled from: Taobao */
@UsedByReflection("Unity")
/* loaded from: classes10.dex */
public class GvrLayout extends FrameLayout {
    private static final String TAG = "GvrLayout";
    private GvrApi gvrApi;
    private IGvrLayout impl;
    private GvrUiLayout uiLayout;
    private ExternalSurface videoSurface;

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public interface ExternalSurfaceListener {
        void onFrameAvailable();

        void onSurfaceAvailable(Surface surface);
    }

    public GvrLayout(Context context) {
        super(context);
        if (co.a(context) != null) {
            init();
            return;
        }
        throw new IllegalArgumentException("An Activity Context is required for VR functionality.");
    }

    private void init() {
        TraceCompat.beginSection("GvrLayout.init");
        try {
            try {
                if (this.impl == null) {
                    this.impl = GvrLayoutFactory.create(getContext());
                }
                this.uiLayout = new GvrUiLayout(this.impl.getUiLayout());
                if (this.gvrApi == null) {
                    this.gvrApi = new GvrApi(getContext(), this.impl.getNativeGvrContext());
                }
                addView((View) ObjectWrapper.unwrap(this.impl.getRootView(), View.class));
            } catch (RemoteException e) {
                throw new RuntimeException(e);
            }
        } finally {
            TraceCompat.endSection();
        }
    }

    @UsedByReflection("Unity")
    public boolean enableAsyncReprojectionProtected() {
        try {
            return this.impl.enableAsyncReprojection(1);
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean enableAsyncReprojectionVideoSurface(ExternalSurfaceListener externalSurfaceListener, Handler handler, boolean z) {
        try {
            if (this.impl.enableAsyncReprojection(z ? 1 : 0)) {
                if (!this.gvrApi.isFeatureSupported(2)) {
                    Log.e(TAG, "External Surfaces are unsupported. Cannot enable video Surface.");
                    return false;
                }
                this.videoSurface = this.gvrApi.createExternalSurface(externalSurfaceListener, handler);
                return true;
            }
            return false;
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean enableCardboardTriggerEmulation(Runnable runnable) {
        try {
            return this.impl.enableCardboardTriggerEmulation(ObjectWrapper.wrap(runnable));
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }

    public Surface getAsyncReprojectionVideoSurface() {
        ExternalSurface externalSurface = this.videoSurface;
        if (externalSurface == null) {
            Log.w(TAG, "Async reprojection video is not enabled. Did you call enableAsyncReprojectionVideoSurface()?");
            return null;
        }
        return externalSurface.getSurface();
    }

    public int getAsyncReprojectionVideoSurfaceId() {
        ExternalSurface externalSurface = this.videoSurface;
        if (externalSurface == null) {
            Log.w(TAG, "Async reprojection video is not enabled. Did you call enableAsyncReprojectionVideoSurface()?");
            return -1;
        }
        return externalSurface.getId();
    }

    @UsedByReflection("Unity")
    public GvrApi getGvrApi() {
        return this.gvrApi;
    }

    @UsedByReflection("Unity")
    public GvrUiLayout getUiLayout() {
        return this.uiLayout;
    }

    public void onBackPressed() {
        try {
            this.impl.onBackPressed();
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }

    @UsedByReflection("Unity")
    public void onPause() {
        TraceCompat.beginSection("GvrLayout.onPause");
        try {
            try {
                this.impl.onPause();
            } catch (RemoteException e) {
                throw new RuntimeException(e);
            }
        } finally {
            TraceCompat.endSection();
        }
    }

    @UsedByReflection("Unity")
    public void onResume() {
        TraceCompat.beginSection("GvrLayout.onResume");
        try {
            try {
                this.impl.onResume();
            } catch (RemoteException e) {
                throw new RuntimeException(e);
            }
        } finally {
            TraceCompat.endSection();
        }
    }

    @UsedByReflection("Unity")
    public boolean setAsyncReprojectionEnabled(boolean z) {
        if (!z) {
            if (this.gvrApi.getAsyncReprojectionEnabled()) {
                throw new UnsupportedOperationException("Async reprojection cannot be disabled once enabled.");
            }
            return true;
        }
        try {
            return this.impl.enableAsyncReprojection(0);
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }

    public void setFixedPresentationSurfaceSize(int i, int i2) {
        getGvrApi().setSurfaceSize(i, i2);
    }

    @UsedByReflection("Unity")
    public void setPresentationView(View view) {
        try {
            this.impl.setPresentationView(ObjectWrapper.wrap(view));
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }

    public void setReentryIntent(PendingIntent pendingIntent) {
        try {
            this.impl.setReentryIntent(ObjectWrapper.wrap(pendingIntent));
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }

    public void setStereoModeEnabled(boolean z) {
        try {
            this.impl.setStereoModeEnabled(z);
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }

    @UsedByReflection("Unity")
    public void shutdown() {
        TraceCompat.beginSection("GvrLayout.shutdown");
        try {
            try {
                this.impl.shutdown();
            } catch (RemoteException e) {
                throw new RuntimeException(e);
            }
        } finally {
            TraceCompat.endSection();
        }
    }

    public GvrLayout(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        if (co.a(context) != null) {
            init();
            return;
        }
        throw new IllegalArgumentException("An Activity Context is required for VR functionality.");
    }

    public GvrLayout(zy2 zy2Var) {
        super(zy2Var);
        init();
    }

    GvrLayout(Context context, GvrLayoutImpl gvrLayoutImpl, GvrApi gvrApi) {
        super(context);
        this.impl = new GvrLayoutImplWrapper(gvrLayoutImpl);
        this.gvrApi = gvrApi;
        init();
    }
}
