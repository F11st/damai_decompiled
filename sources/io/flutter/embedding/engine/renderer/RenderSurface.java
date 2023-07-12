package io.flutter.embedding.engine.renderer;

import android.os.Build;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public interface RenderSurface {

    /* compiled from: Taobao */
    @Keep
    /* loaded from: classes3.dex */
    public static class Helper {
        static final String TAG = "RenderSurface";
        static boolean sDisableImageView;

        @VisibleForTesting
        public static void setDisableImageView(boolean z) {
            sDisableImageView = z;
        }

        public static boolean suggestUseImageView() {
            return !sDisableImageView && Build.VERSION.SDK_INT >= 29;
        }
    }

    void attachToRenderer(@NonNull FlutterRenderer flutterRenderer);

    void detachFromRenderer();

    @Nullable
    FlutterRenderer getAttachedRenderer();

    boolean hasContent();

    boolean isPreRenderSurface();

    boolean isSurfaceAvailableForRendering();

    void onPresentSurface();

    void onPresentSurfaceCompleted();

    void pause();

    void setRenderTransparently(boolean z);

    void updateAndInvalidate();
}
