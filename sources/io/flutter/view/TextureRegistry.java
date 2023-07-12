package io.flutter.view;

import android.graphics.SurfaceTexture;
import androidx.annotation.Nullable;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public interface TextureRegistry {

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public interface OnFrameConsumedListener {
        void onFrameConsumed();
    }

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public interface OnLowMemoryListener {
        void onLowMemory(int i);
    }

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public interface SurfaceTextureEntry {
        long id();

        void release();

        void setOnFrameConsumedListener(@Nullable OnFrameConsumedListener onFrameConsumedListener);

        void setOnLowMemoryListener(@Nullable OnLowMemoryListener onLowMemoryListener);

        SurfaceTexture surfaceTexture();
    }

    SurfaceTextureEntry createSurfaceTexture();

    void onTrimMemory(int i);
}
