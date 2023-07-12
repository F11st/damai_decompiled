package io.flutter.embedding.engine.renderer;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.os.Build;
import android.os.Handler;
import android.view.Surface;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import io.flutter.Log;
import io.flutter.embedding.engine.FlutterJNI;
import io.flutter.util.SourceLocation;
import io.flutter.util.Trace;
import io.flutter.view.TextureRegistry;
import java.nio.ByteBuffer;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicLong;

/* compiled from: Taobao */
@TargetApi(16)
/* loaded from: classes3.dex */
public class FlutterRenderer implements TextureRegistry {
    private static final String TAG = "FlutterRenderer";
    private Runnable drawLastLayerTreeCallback;
    private long drawLastLayerTreeSurfaceId;
    private boolean drawLastLayerTreeSync;
    private boolean drawLastLayerTreeWhenSwapSurface;
    @NonNull
    private final FlutterJNI flutterJNI;
    @Nullable
    private FlutterRenderingListener flutterRenderingListener;
    @NonNull
    private final FlutterUiDisplayListener flutterUiDisplayListener;
    @NonNull
    private final Set<TextureRegistry.OnLowMemoryListener> onLowMemoryListeners;
    private boolean presentingSurface;
    private long presentingSurfaceId;
    @Nullable
    private RenderSurface renderSurface;
    @Nullable
    private Surface surface;
    private boolean useSwapInsteadOfDetachAttach;
    @NonNull
    private final AtomicLong nextTextureId = new AtomicLong(0);
    private boolean isDisplayingFlutterUi = false;

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public interface FlutterRenderingListener {
        void onStartRenderingToSurface();
    }

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    final class SurfaceTextureRegistryEntry implements TextureRegistry.OnLowMemoryListener, TextureRegistry.SurfaceTextureEntry {
        private final long id;
        @Nullable
        private TextureRegistry.OnFrameConsumedListener listener;
        @Nullable
        private TextureRegistry.OnLowMemoryListener lowMemoryListener;
        private final Runnable onFrameConsumed;
        private SurfaceTexture.OnFrameAvailableListener onFrameListener;
        private boolean released;
        @NonNull
        private final SurfaceTextureWrapper textureWrapper;

        SurfaceTextureRegistryEntry(long j, @NonNull SurfaceTexture surfaceTexture) {
            Runnable runnable = new Runnable() { // from class: io.flutter.embedding.engine.renderer.FlutterRenderer.SurfaceTextureRegistryEntry.1
                @Override // java.lang.Runnable
                public void run() {
                    if (SurfaceTextureRegistryEntry.this.listener != null) {
                        SurfaceTextureRegistryEntry.this.listener.onFrameConsumed();
                    }
                }
            };
            this.onFrameConsumed = runnable;
            this.onFrameListener = new SurfaceTexture.OnFrameAvailableListener() { // from class: io.flutter.embedding.engine.renderer.FlutterRenderer.SurfaceTextureRegistryEntry.2
                @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
                public void onFrameAvailable(@NonNull SurfaceTexture surfaceTexture2) {
                    if (SurfaceTextureRegistryEntry.this.released || !FlutterRenderer.this.flutterJNI.isAttached()) {
                        return;
                    }
                    SurfaceTextureRegistryEntry surfaceTextureRegistryEntry = SurfaceTextureRegistryEntry.this;
                    FlutterRenderer.this.markTextureFrameAvailable(surfaceTextureRegistryEntry.id);
                }
            };
            this.id = j;
            this.textureWrapper = new SurfaceTextureWrapper(surfaceTexture, runnable);
            if (Build.VERSION.SDK_INT >= 21) {
                surfaceTexture().setOnFrameAvailableListener(this.onFrameListener, new Handler());
            } else {
                surfaceTexture().setOnFrameAvailableListener(this.onFrameListener);
            }
        }

        private void removeListener() {
            FlutterRenderer.this.removeOnLowMemoryListener(this);
        }

        @Override // io.flutter.view.TextureRegistry.SurfaceTextureEntry
        public long id() {
            return this.id;
        }

        @Override // io.flutter.view.TextureRegistry.OnLowMemoryListener
        public void onLowMemory(int i) {
            TextureRegistry.OnLowMemoryListener onLowMemoryListener = this.lowMemoryListener;
            if (onLowMemoryListener != null) {
                onLowMemoryListener.onLowMemory(i);
            }
        }

        @Override // io.flutter.view.TextureRegistry.SurfaceTextureEntry
        public void release() {
            if (this.released) {
                return;
            }
            Log.v(FlutterRenderer.TAG, "Releasing a SurfaceTexture (" + this.id + ").");
            this.textureWrapper.release();
            FlutterRenderer.this.unregisterTexture(this.id);
            removeListener();
            this.released = true;
        }

        @Override // io.flutter.view.TextureRegistry.SurfaceTextureEntry
        public void setOnFrameConsumedListener(@Nullable TextureRegistry.OnFrameConsumedListener onFrameConsumedListener) {
            this.listener = onFrameConsumedListener;
        }

        @Override // io.flutter.view.TextureRegistry.SurfaceTextureEntry
        public void setOnLowMemoryListener(@Nullable TextureRegistry.OnLowMemoryListener onLowMemoryListener) {
            this.lowMemoryListener = onLowMemoryListener;
        }

        @Override // io.flutter.view.TextureRegistry.SurfaceTextureEntry
        @NonNull
        public SurfaceTexture surfaceTexture() {
            return this.textureWrapper.surfaceTexture();
        }

        @NonNull
        public SurfaceTextureWrapper textureWrapper() {
            return this.textureWrapper;
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public static final class ViewportMetrics {
        public static final int unsetValue = -1;
        public float devicePixelRatio = 1.0f;
        public int width = 0;
        public int height = 0;
        public int viewPaddingTop = 0;
        public int viewPaddingRight = 0;
        public int viewPaddingBottom = 0;
        public int viewPaddingLeft = 0;
        public int viewInsetTop = 0;
        public int viewInsetRight = 0;
        public int viewInsetBottom = 0;
        public int viewInsetLeft = 0;
        public int systemGestureInsetTop = 0;
        public int systemGestureInsetRight = 0;
        public int systemGestureInsetBottom = 0;
        public int systemGestureInsetLeft = 0;
        public int physicalTouchSlop = -1;

        boolean validate() {
            return this.width > 0 && this.height > 0 && this.devicePixelRatio > 0.0f;
        }
    }

    public FlutterRenderer(@NonNull FlutterJNI flutterJNI) {
        FlutterUiDisplayListener flutterUiDisplayListener = new FlutterUiDisplayListener() { // from class: io.flutter.embedding.engine.renderer.FlutterRenderer.1
            @Override // io.flutter.embedding.engine.renderer.FlutterUiDisplayListener
            public void onFlutterUiDisplayed() {
                FlutterRenderer.this.isDisplayingFlutterUi = true;
            }

            @Override // io.flutter.embedding.engine.renderer.FlutterUiDisplayListener
            public void onFlutterUiNoLongerDisplayed() {
                FlutterRenderer.this.isDisplayingFlutterUi = false;
            }
        };
        this.flutterUiDisplayListener = flutterUiDisplayListener;
        this.onLowMemoryListeners = new CopyOnWriteArraySet();
        this.flutterJNI = flutterJNI;
        flutterJNI.addIsDisplayingFlutterUiListener(flutterUiDisplayListener);
        flutterJNI.setPresentSurfaceCallback(new FlutterJNI.PresentSurfaceCallback() { // from class: io.flutter.embedding.engine.renderer.FlutterRenderer.2
            @Override // io.flutter.embedding.engine.FlutterJNI.PresentSurfaceCallback
            public void onPresentSurface(long j) {
                FlutterRenderer.this.onPresentSurface(j);
            }

            @Override // io.flutter.embedding.engine.FlutterJNI.PresentSurfaceCallback
            public void onPresentSurfaceCompleted(long j) {
                FlutterRenderer.this.onPresentSurfaceCompleted(j);
            }
        });
    }

    private void drawLastLayerTreeDone() {
        Runnable runnable = this.drawLastLayerTreeCallback;
        if (runnable != null) {
            runnable.run();
            this.drawLastLayerTreeCallback = null;
            this.drawLastLayerTreeSurfaceId = 0L;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void markTextureFrameAvailable(long j) {
        this.flutterJNI.markTextureFrameAvailable(j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onPresentSurface(long j) {
        this.presentingSurface = true;
        this.presentingSurfaceId = j;
        RenderSurface renderSurface = this.renderSurface;
        if (renderSurface != null) {
            renderSurface.onPresentSurface();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onPresentSurfaceCompleted(long j) {
        if (this.presentingSurface) {
            this.presentingSurface = false;
            RenderSurface renderSurface = this.renderSurface;
            if (renderSurface != null) {
                renderSurface.onPresentSurfaceCompleted();
            }
            if (j == this.drawLastLayerTreeSurfaceId) {
                drawLastLayerTreeDone();
            }
        }
    }

    private void registerTexture(long j, @NonNull SurfaceTextureWrapper surfaceTextureWrapper) {
        this.flutterJNI.registerTexture(j, surfaceTextureWrapper);
    }

    private void swapSurfaceWithNewSurfaceId(@NonNull Surface surface, boolean z, boolean z2) {
        FlutterJNI.beginSection("FlutterRenderer.swapSurfaceWithNewSurfaceId");
        this.surface = surface;
        this.drawLastLayerTreeSurfaceId = this.flutterJNI.onSurfaceWindowChangedWithNewSurfaceId(surface, z, z2);
        if (!z || z2) {
            drawLastLayerTreeDone();
        }
        FlutterJNI.endSection();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void unregisterTexture(long j) {
        this.flutterJNI.unregisterTexture(j);
    }

    public void addIsDisplayingFlutterUiListener(@NonNull FlutterUiDisplayListener flutterUiDisplayListener) {
        this.flutterJNI.addIsDisplayingFlutterUiListener(flutterUiDisplayListener);
        if (this.isDisplayingFlutterUi) {
            flutterUiDisplayListener.onFlutterUiDisplayed();
        }
    }

    public void addOnLowMemoryListener(@NonNull TextureRegistry.OnLowMemoryListener onLowMemoryListener) {
        this.onLowMemoryListeners.add(onLowMemoryListener);
    }

    public void addPlatformViewDisplayListener(@NonNull PlatformViewDisplayListener platformViewDisplayListener) {
        this.flutterJNI.addPlatformViewDisplayListener(platformViewDisplayListener);
    }

    public void attachRenderSurface(RenderSurface renderSurface) {
        RenderSurface renderSurface2 = this.renderSurface;
        if (renderSurface2 != null && renderSurface2 != renderSurface) {
            renderSurface2.detachFromRenderer();
        }
        this.renderSurface = renderSurface;
    }

    @Override // io.flutter.view.TextureRegistry
    public TextureRegistry.SurfaceTextureEntry createSurfaceTexture() {
        Log.v(TAG, "Creating a SurfaceTexture.");
        SurfaceTexture surfaceTexture = new SurfaceTexture(0);
        surfaceTexture.detachFromGLContext();
        SurfaceTextureRegistryEntry surfaceTextureRegistryEntry = new SurfaceTextureRegistryEntry(this.nextTextureId.getAndIncrement(), surfaceTexture);
        Log.v(TAG, "New SurfaceTexture ID: " + surfaceTextureRegistryEntry.id());
        registerTexture(surfaceTextureRegistryEntry.id(), surfaceTextureRegistryEntry.textureWrapper());
        addOnLowMemoryListener(surfaceTextureRegistryEntry);
        return surfaceTextureRegistryEntry;
    }

    public void destroyPointerDataPacket() {
        this.flutterJNI.destroyPointerDataPacket();
    }

    public void detachRenderSurface() {
        this.renderSurface = null;
    }

    public void dispatchPointerDataPacket(@NonNull ByteBuffer byteBuffer, int i) {
        this.flutterJNI.dispatchPointerDataPacket(byteBuffer, i);
    }

    public void dispatchSemanticsAction(int i, int i2, @Nullable ByteBuffer byteBuffer, int i3) {
        this.flutterJNI.dispatchSemanticsAction(i, i2, byteBuffer, i3);
    }

    public void drawLastLayerTree(boolean z, @Nullable Runnable runnable) {
        if (this.drawLastLayerTreeCallback != null) {
            Log.w(TAG, "FlutterRenderer drawLastLayerTree with last draw not done yet.");
        }
        this.drawLastLayerTreeCallback = runnable;
        this.drawLastLayerTreeSurfaceId = this.flutterJNI.drawLastLayerTree(z);
        if (z) {
            drawLastLayerTreeDone();
        }
    }

    public void enableDebugPreRenderDisplay(boolean z) {
        this.flutterJNI.enableDebugPreRenderDisplay(z);
    }

    public Bitmap getBitmap() {
        return this.flutterJNI.getBitmap();
    }

    public RenderSurface getRenderSurface() {
        return this.renderSurface;
    }

    public boolean isDisplayingFlutterUi() {
        return this.isDisplayingFlutterUi;
    }

    public boolean isSoftwareRenderingEnabled() {
        return this.flutterJNI.getIsSoftwareRenderingEnabled();
    }

    @Override // io.flutter.view.TextureRegistry
    public void onTrimMemory(int i) {
        for (TextureRegistry.OnLowMemoryListener onLowMemoryListener : this.onLowMemoryListeners) {
            onLowMemoryListener.onLowMemory(i);
        }
    }

    public void registerFlutterRenderingListener(@NonNull FlutterRenderingListener flutterRenderingListener) {
        this.flutterRenderingListener = flutterRenderingListener;
    }

    public void removeIsDisplayingFlutterUiListener(@NonNull FlutterUiDisplayListener flutterUiDisplayListener) {
        this.flutterJNI.removeIsDisplayingFlutterUiListener(flutterUiDisplayListener);
    }

    public void removeOnLowMemoryListener(@NonNull TextureRegistry.OnLowMemoryListener onLowMemoryListener) {
        this.onLowMemoryListeners.remove(onLowMemoryListener);
    }

    public void removePlatformViewDisplayListener(@NonNull PlatformViewDisplayListener platformViewDisplayListener) {
        this.flutterJNI.removePlatformViewDisplayListener(platformViewDisplayListener);
    }

    public void setAccessibilityFeatures(int i) {
        this.flutterJNI.setAccessibilityFeatures(i);
    }

    public void setFallbackBehavior(boolean z, boolean z2, boolean z3, Runnable runnable) {
        this.useSwapInsteadOfDetachAttach = z;
        this.drawLastLayerTreeWhenSwapSurface = z2;
        this.drawLastLayerTreeSync = z3;
        this.drawLastLayerTreeCallback = runnable;
    }

    public void setPromoteBehavior(boolean z) {
        this.useSwapInsteadOfDetachAttach = z;
        this.drawLastLayerTreeWhenSwapSurface = false;
        this.drawLastLayerTreeSync = false;
    }

    public void setSemanticsEnabled(boolean z) {
        this.flutterJNI.setSemanticsEnabled(z);
    }

    public void setViewportMetrics(@NonNull ViewportMetrics viewportMetrics) {
        if (viewportMetrics.validate()) {
            Log.v(TAG, "Setting viewport metrics\nSize: " + viewportMetrics.width + " x " + viewportMetrics.height + "\nPadding - L: " + viewportMetrics.viewPaddingLeft + ", T: " + viewportMetrics.viewPaddingTop + ", R: " + viewportMetrics.viewPaddingRight + ", B: " + viewportMetrics.viewPaddingBottom + "\nInsets - L: " + viewportMetrics.viewInsetLeft + ", T: " + viewportMetrics.viewInsetTop + ", R: " + viewportMetrics.viewInsetRight + ", B: " + viewportMetrics.viewInsetBottom + "\nSystem Gesture Insets - L: " + viewportMetrics.systemGestureInsetLeft + ", T: " + viewportMetrics.systemGestureInsetTop + ", R: " + viewportMetrics.systemGestureInsetRight + ", B: " + viewportMetrics.viewInsetBottom);
            this.flutterJNI.setViewportMetrics(viewportMetrics.devicePixelRatio, viewportMetrics.width, viewportMetrics.height, viewportMetrics.viewPaddingTop, viewportMetrics.viewPaddingRight, viewportMetrics.viewPaddingBottom, viewportMetrics.viewPaddingLeft, viewportMetrics.viewInsetTop, viewportMetrics.viewInsetRight, viewportMetrics.viewInsetBottom, viewportMetrics.viewInsetLeft, viewportMetrics.systemGestureInsetTop, viewportMetrics.systemGestureInsetRight, viewportMetrics.systemGestureInsetBottom, viewportMetrics.systemGestureInsetLeft, viewportMetrics.physicalTouchSlop);
        }
    }

    public void startPreRendering() {
        this.flutterJNI.startPreRendering();
    }

    public void startRenderingToSurface(@NonNull Surface surface) {
        FlutterRenderingListener flutterRenderingListener;
        if (this.useSwapInsteadOfDetachAttach && this.surface != null) {
            this.useSwapInsteadOfDetachAttach = false;
            swapSurfaceWithNewSurfaceId(surface, this.drawLastLayerTreeWhenSwapSurface, this.drawLastLayerTreeSync);
            return;
        }
        Trace.beginSection(SourceLocation.clazz(this) + "." + SourceLocation.method());
        RenderSurface renderSurface = this.renderSurface;
        if ((renderSurface == null || !renderSurface.isPreRenderSurface()) && (flutterRenderingListener = this.flutterRenderingListener) != null) {
            flutterRenderingListener.onStartRenderingToSurface();
        }
        if (this.surface != null) {
            stopRenderingToSurface();
        }
        this.surface = surface;
        this.flutterJNI.onSurfaceCreated(surface);
        Trace.endSection();
    }

    public void stopRenderingToSurface() {
        if (this.useSwapInsteadOfDetachAttach && this.surface != null) {
            this.isDisplayingFlutterUi = false;
            return;
        }
        this.flutterJNI.onSurfaceDestroyed();
        this.surface = null;
        if (this.isDisplayingFlutterUi) {
            this.flutterUiDisplayListener.onFlutterUiNoLongerDisplayed();
        }
        this.isDisplayingFlutterUi = false;
    }

    public void surfaceChanged(int i, int i2) {
        if (this.surface == null) {
            Log.e(TAG, "AONE(29109102) => call surfaceChanged() on a detached surface.");
        } else {
            this.flutterJNI.onSurfaceChanged(i, i2);
        }
    }

    public void swapSurface(@NonNull Surface surface) {
        this.surface = surface;
        this.flutterJNI.onSurfaceWindowChanged(surface);
    }

    public void swapSurfaceOrStartRendering(@NonNull Surface surface) {
        FlutterJNI.beginSection("FlutterRenderer.swapSurfaceOrStartRendering");
        if (this.surface == null) {
            startRenderingToSurface(surface);
        } else {
            this.surface = surface;
            this.flutterJNI.onSurfaceWindowChanged(surface);
        }
        FlutterJNI.endSection();
    }

    public void unRegisterFlutterRenderingListener() {
        this.flutterRenderingListener = null;
    }

    public void waitDrawLastLayerTree() {
        if (this.drawLastLayerTreeSurfaceId > 0) {
            this.flutterJNI.waitDrawLastLayerTree();
            drawLastLayerTreeDone();
        }
    }

    public void waitPresentSurfaceCompleted() {
        if (this.presentingSurface && this.flutterJNI.waitPresentSurfaceCompleted()) {
            onPresentSurfaceCompleted(this.presentingSurfaceId);
        }
        waitDrawLastLayerTree();
    }
}
