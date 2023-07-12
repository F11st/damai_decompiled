package io.flutter.embedding.android;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorSpace;
import android.graphics.Paint;
import android.hardware.HardwareBuffer;
import android.media.Image;
import android.media.ImageReader;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Parcel;
import android.os.Process;
import android.os.Trace;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.youku.live.livesdk.monitor.performance.AbsPerformance;
import io.flutter.Log;
import io.flutter.embedding.android.FlutterImageView;
import io.flutter.embedding.engine.renderer.FlutterRenderer;
import io.flutter.embedding.engine.renderer.RenderSurface;
import java.nio.ByteBuffer;
import java.util.LinkedList;
import java.util.List;

/* compiled from: Taobao */
@TargetApi(19)
/* loaded from: classes3.dex */
public class FlutterImageView extends View implements ImageReader.OnImageAvailableListener, RenderSurface {
    private static final long BITMAP_CACHE_MAX_LIVE_PERIOD = 1000000000;
    private static final boolean DEBUG = false;
    private static final boolean DEBUG_DRAW = false;
    private static final String TAG = "FlutterImageView";
    private static final int THREAD_PRIORITY_VIDEO = -10;
    private static Handler sAcquireImageHandler;
    private static HandlerThread sAcquireImageThread;
    private static long sIdGenerator;
    private static Handler sUIHandler;
    @NonNull
    private List<BitmapCache> bitmapsCache;
    @Nullable
    private Bitmap currentBitmap;
    @Nullable
    private Image currentImage;
    @Nullable
    private Runnable delayReleaseCallback;
    @Nullable
    private FlutterRenderer flutterRenderer;
    private final long id;
    private final Object imageLock;
    @NonNull
    private ImageReader imageReader;
    private boolean isAttachedToFlutterRenderer;
    private final SurfaceKind kind;
    private long lastCacheTimestamp;
    @Nullable
    private Image pendingImage;
    @Nullable
    private ImageReader pendingReader;
    private boolean surfaceHasContent;

    /* compiled from: Taobao */
    /* renamed from: io.flutter.embedding.android.FlutterImageView$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$flutter$embedding$android$FlutterImageView$SurfaceKind;

        static {
            int[] iArr = new int[SurfaceKind.values().length];
            $SwitchMap$io$flutter$embedding$android$FlutterImageView$SurfaceKind = iArr;
            try {
                iArr[SurfaceKind.surface.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$flutter$embedding$android$FlutterImageView$SurfaceKind[SurfaceKind.background.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$io$flutter$embedding$android$FlutterImageView$SurfaceKind[SurfaceKind.overlay.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$io$flutter$embedding$android$FlutterImageView$SurfaceKind[SurfaceKind.preRender.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public static final class BitmapCache implements Comparable<BitmapCache> {
        Bitmap bitmap;
        long nativeBuffer;
        long timestamp;

        BitmapCache(Bitmap bitmap, long j, long j2) {
            this.bitmap = bitmap;
            this.timestamp = j;
            this.nativeBuffer = j2;
        }

        @Override // java.lang.Comparable
        public int compareTo(BitmapCache bitmapCache) {
            long j = this.timestamp;
            long j2 = bitmapCache.timestamp;
            if (j > j2) {
                return 1;
            }
            return j < j2 ? -1 : 0;
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public static final class DelayReleaseCallback implements Runnable {
        private Image pendingReleaseImage;

        DelayReleaseCallback(Image image) {
            this.pendingReleaseImage = image;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.pendingReleaseImage != null) {
                Trace.beginSection("FlutterImageView.closeOldImage");
                this.pendingReleaseImage.close();
                this.pendingReleaseImage = null;
                Trace.endSection();
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public enum SurfaceKind {
        surface,
        background,
        overlay,
        preRender
    }

    public FlutterImageView(@NonNull Context context, int i, int i2, SurfaceKind surfaceKind) {
        this(context, createImageReader(i, i2), surfaceKind);
    }

    private void clearCachedBitmapsLocked() {
        releaseCachedBitmapsLocked(0, AbsPerformance.LONG_NIL);
    }

    private void closeCurrentBitmapLocked() {
        Bitmap bitmap = this.currentBitmap;
        if (bitmap != null) {
            bitmap.recycle();
            this.currentBitmap = null;
        }
    }

    private void closeCurrentImageLocked() {
        setCurrentImageLocked(null);
    }

    private void closePendingImageLocked() {
        setPendingImageLocked(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: closePendingReader */
    public void lambda$resizeIfNeeded$1() {
        synchronized (this.imageLock) {
            ImageReader imageReader = this.pendingReader;
            if (imageReader != null) {
                imageReader.close();
                this.pendingReader = null;
            }
        }
    }

    @NonNull
    @TargetApi(19)
    private static ImageReader createImageReader(int i, int i2) {
        if (i > 0 && i2 > 0) {
            if (Build.VERSION.SDK_INT >= 29) {
                return ImageReader.newInstance(i, i2, 1, 3, 768L);
            }
            return ImageReader.newInstance(i, i2, 1, 3);
        }
        return createImageReader(1, 1);
    }

    private void drawCurrentBitmapLocked(Canvas canvas) {
        if (this.currentImage != null) {
            updateCurrentBitmapLocked();
        }
        if (this.currentBitmap != null) {
            FlutterViewOverlay.onRenderViewDraw();
            if (Build.VERSION.SDK_INT < 29 || canvas.isHardwareAccelerated()) {
                Trace.beginSection("FlutterImageView.drawCurrentBitmap");
                canvas.drawBitmap(this.currentBitmap, 0.0f, 0.0f, (Paint) null);
                Trace.endSection();
            }
        }
    }

    private Bitmap getCachedBitmapLocked(Image image) {
        HardwareBuffer hardwareBuffer = image.getHardwareBuffer();
        Parcel obtain = Parcel.obtain();
        hardwareBuffer.writeToParcel(obtain, 0);
        obtain.setDataPosition(0);
        obtain.readInt();
        obtain.readInt();
        int readInt = obtain.readInt();
        obtain.readInt();
        obtain.readInt();
        obtain.readInt();
        obtain.readInt();
        obtain.readInt();
        obtain.readInt();
        long readInt2 = obtain.readInt();
        obtain.readInt();
        long j = (readInt == 1195520049 && readInt2 == ((long) Process.myPid())) ? -1L : -1L;
        obtain.recycle();
        for (BitmapCache bitmapCache : this.bitmapsCache) {
            if (bitmapCache.nativeBuffer == j) {
                hardwareBuffer.close();
                long timestamp = image.getTimestamp();
                bitmapCache.timestamp = timestamp;
                this.lastCacheTimestamp = timestamp;
                return bitmapCache.bitmap;
            }
        }
        Bitmap wrapHardwareBuffer = Bitmap.wrapHardwareBuffer(hardwareBuffer, ColorSpace.get(ColorSpace.Named.SRGB));
        hardwareBuffer.close();
        if (j >= 0) {
            this.bitmapsCache.add(new BitmapCache(wrapHardwareBuffer, image.getTimestamp(), j));
        }
        return wrapHardwareBuffer;
    }

    private void init() {
        Trace.beginSection("FlutterImageView.init-" + this.id);
        setAlpha(0.0f);
        if (isSurfaceKind() && sAcquireImageHandler == null) {
            HandlerThread handlerThread = new HandlerThread("1.imagereader", 10);
            sAcquireImageThread = handlerThread;
            handlerThread.start();
            Handler handler = new Handler(sAcquireImageThread.getLooper());
            sAcquireImageHandler = handler;
            handler.post(new Runnable() { // from class: tb.ho0
                @Override // java.lang.Runnable
                public final void run() {
                    Process.setThreadPriority(-10);
                }
            });
            sUIHandler = new Handler(Looper.getMainLooper());
        }
        Trace.endSection();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onImageAvailable$2() {
        invalidate();
    }

    private void releaseCachedBitmapsLocked(int i, long j) {
        if (this.bitmapsCache.size() > i) {
            this.bitmapsCache.sort(null);
            while (this.bitmapsCache.size() > i) {
                BitmapCache bitmapCache = this.bitmapsCache.get(0);
                if (bitmapCache.timestamp >= j) {
                    return;
                }
                this.bitmapsCache.remove(0);
                Bitmap bitmap = bitmapCache.bitmap;
                if (bitmap != this.currentBitmap) {
                    bitmap.recycle();
                }
            }
        }
    }

    private void setCurrentImageLocked(Image image) {
        setCurrentImageLocked(image, false);
    }

    private void setPendingImageLocked(Image image) {
        Trace.beginSection("FlutterImageView.setPendingImage-" + this.id);
        Image image2 = this.pendingImage;
        if (image2 != null) {
            image2.close();
        }
        this.pendingImage = image;
        Trace.endSection();
    }

    private void swapImageLocked(boolean z) {
        if (this.pendingImage != null) {
            Trace.beginSection("FlutterImageView.swapImage-" + this.id);
            setCurrentImageLocked(this.pendingImage, z);
            this.pendingImage = null;
            Trace.endSection();
        }
    }

    @TargetApi(29)
    private void updateCurrentBitmapLocked() {
        if (Build.VERSION.SDK_INT >= 29) {
            this.currentBitmap = getCachedBitmapLocked(this.currentImage);
            releaseCachedBitmapsLocked(3, this.lastCacheTimestamp - BITMAP_CACHE_MAX_LIVE_PERIOD);
            return;
        }
        Image.Plane[] planes = this.currentImage.getPlanes();
        if (planes.length != 1) {
            return;
        }
        Image.Plane plane = planes[0];
        int rowStride = plane.getRowStride() / plane.getPixelStride();
        int height = this.currentImage.getHeight();
        Bitmap bitmap = this.currentBitmap;
        if (bitmap == null || bitmap.getWidth() != rowStride || this.currentBitmap.getHeight() != height) {
            this.currentBitmap = Bitmap.createBitmap(rowStride, height, Bitmap.Config.ARGB_8888);
        }
        ByteBuffer buffer = plane.getBuffer();
        buffer.rewind();
        this.currentBitmap.copyPixelsFromBuffer(buffer);
    }

    private void waitPresentSurfaceCompleted() {
        FlutterRenderer flutterRenderer = this.flutterRenderer;
        if (flutterRenderer != null) {
            flutterRenderer.waitPresentSurfaceCompleted();
        }
    }

    @TargetApi(19)
    public boolean acquireLatestImage() {
        boolean z;
        if (this.isAttachedToFlutterRenderer) {
            synchronized (this.imageLock) {
                Image acquireLatestImage = this.imageReader.acquireLatestImage();
                if (acquireLatestImage != null) {
                    setCurrentImageLocked(acquireLatestImage);
                    invalidate();
                }
                z = acquireLatestImage != null;
            }
            return z;
        }
        return false;
    }

    @Override // io.flutter.embedding.engine.renderer.RenderSurface
    public void attachToRenderer(@NonNull FlutterRenderer flutterRenderer) {
        Trace.beginSection("FlutterImageView.attachToRenderer-" + this.id);
        setAlpha(1.0f);
        this.flutterRenderer = flutterRenderer;
        this.isAttachedToFlutterRenderer = true;
        int i = AnonymousClass1.$SwitchMap$io$flutter$embedding$android$FlutterImageView$SurfaceKind[this.kind.ordinal()];
        if (i == 1) {
            flutterRenderer.attachRenderSurface(this);
            if (getWidth() > 0 && getHeight() > 0) {
                resizeIfNeeded(getWidth(), getHeight());
                try {
                    Image acquireLatestImage = this.imageReader.acquireLatestImage();
                    if (acquireLatestImage != null) {
                        Log.e(TAG, "ImageView.attachToRenderer - has pending image");
                        acquireLatestImage.close();
                    }
                } catch (Throwable unused) {
                }
                this.imageReader.setOnImageAvailableListener(this, sAcquireImageHandler);
                flutterRenderer.startRenderingToSurface(this.imageReader.getSurface());
                lambda$resizeIfNeeded$1();
            }
            FlutterViewOverlay.createOverlay(this, "IV");
        } else if (i == 2) {
            flutterRenderer.swapSurface(this.imageReader.getSurface());
        } else if (i == 4) {
            flutterRenderer.attachRenderSurface(this);
            flutterRenderer.startRenderingToSurface(this.imageReader.getSurface());
            flutterRenderer.startPreRendering();
        }
        Trace.endSection();
    }

    @Override // io.flutter.embedding.engine.renderer.RenderSurface
    public void detachFromRenderer() {
        if (this.isAttachedToFlutterRenderer) {
            Trace.beginSection("FlutterImageView.detachFromRenderer-" + this.id);
            if (isSurfaceKind()) {
                this.imageReader.setOnImageAvailableListener(null, null);
                FlutterRenderer flutterRenderer = this.flutterRenderer;
                if (flutterRenderer != null) {
                    flutterRenderer.detachRenderSurface();
                    this.flutterRenderer.stopRenderingToSurface();
                    this.flutterRenderer = null;
                }
                synchronized (this.imageLock) {
                    swapImageLocked(false);
                    Image acquireLatestImage = this.imageReader.acquireLatestImage();
                    if (acquireLatestImage != null) {
                        setCurrentImageLocked(acquireLatestImage);
                    }
                    if (this.currentImage != null) {
                        updateCurrentBitmapLocked();
                        invalidate();
                    }
                    closeCurrentImageLocked();
                    clearCachedBitmapsLocked();
                }
                if (Build.VERSION.SDK_INT >= 28) {
                    this.imageReader.discardFreeBuffers();
                }
                FlutterViewOverlay.removeOverlay();
            } else {
                setAlpha(0.0f);
                acquireLatestImage();
                synchronized (this.imageLock) {
                    clearCachedBitmapsLocked();
                    closeCurrentBitmapLocked();
                    closeCurrentImageLocked();
                }
                invalidate();
            }
            this.isAttachedToFlutterRenderer = false;
            Trace.endSection();
        }
    }

    @Override // io.flutter.embedding.engine.renderer.RenderSurface
    @Nullable
    public FlutterRenderer getAttachedRenderer() {
        return this.flutterRenderer;
    }

    @NonNull
    public Surface getSurface() {
        return this.imageReader.getSurface();
    }

    @Override // io.flutter.embedding.engine.renderer.RenderSurface
    public boolean hasContent() {
        boolean z;
        synchronized (this.imageLock) {
            z = this.surfaceHasContent;
        }
        return z;
    }

    @Override // io.flutter.embedding.engine.renderer.RenderSurface
    public boolean isPreRenderSurface() {
        return this.kind == SurfaceKind.preRender;
    }

    @Override // io.flutter.embedding.engine.renderer.RenderSurface
    public boolean isSurfaceAvailableForRendering() {
        return true;
    }

    public boolean isSurfaceKind() {
        return this.kind == SurfaceKind.surface;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        Trace.beginSection("FlutterImageView.onDraw-" + this.id);
        waitPresentSurfaceCompleted();
        synchronized (this.imageLock) {
            swapImageLocked(true);
            drawCurrentBitmapLocked(canvas);
        }
        Trace.endSection();
    }

    @Override // android.media.ImageReader.OnImageAvailableListener
    /* renamed from: onImageAvailable */
    public void lambda$onImageAvailable$3(final ImageReader imageReader) {
        synchronized (this.imageLock) {
            if (imageReader != this.pendingReader && this.flutterRenderer != null) {
                sUIHandler.postAtFrontOfQueue(new Runnable() { // from class: tb.fo0
                    @Override // java.lang.Runnable
                    public final void run() {
                        FlutterImageView.this.lambda$onImageAvailable$2();
                    }
                });
                this.surfaceHasContent = true;
                try {
                    Trace.beginSection("FlutterImageView.onImageAvailable-" + this.id);
                    closePendingImageLocked();
                    Image acquireNextImage = imageReader.acquireNextImage();
                    if (acquireNextImage != null) {
                        setPendingImageLocked(acquireNextImage);
                    }
                    Trace.endSection();
                    Thread.sleep(0L, 100000);
                } catch (IllegalStateException e) {
                    Trace.beginSection("FlutterImageView.onImageAvailable::ISE");
                    Log.e(TAG, "ImageView.onImageAvailable IllegalStateException=" + e);
                    sAcquireImageHandler.postDelayed(new Runnable() { // from class: tb.go0
                        @Override // java.lang.Runnable
                        public final void run() {
                            FlutterImageView.this.lambda$onImageAvailable$3(imageReader);
                        }
                    }, 16L);
                    Trace.endSection();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }
    }

    @Override // io.flutter.embedding.engine.renderer.RenderSurface
    public void onPresentSurface() {
        if (this.kind == SurfaceKind.preRender) {
            return;
        }
        invalidate();
    }

    @Override // io.flutter.embedding.engine.renderer.RenderSurface
    public void onPresentSurfaceCompleted() {
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        if (i == this.imageReader.getWidth() && i2 == this.imageReader.getHeight()) {
            return;
        }
        SurfaceKind surfaceKind = this.kind;
        if ((surfaceKind == SurfaceKind.surface || surfaceKind == SurfaceKind.background) && this.isAttachedToFlutterRenderer) {
            resizeIfNeeded(i, i2);
            if (isSurfaceKind()) {
                this.imageReader.setOnImageAvailableListener(this, sAcquireImageHandler);
            }
            this.flutterRenderer.swapSurfaceOrStartRendering(this.imageReader.getSurface());
            lambda$resizeIfNeeded$1();
        }
    }

    @Override // io.flutter.embedding.engine.renderer.RenderSurface
    public void pause() {
    }

    public void resizeIfNeeded(int i, int i2) {
        if (this.flutterRenderer == null) {
            return;
        }
        if (i == this.imageReader.getWidth() && i2 == this.imageReader.getHeight()) {
            return;
        }
        synchronized (this.imageLock) {
            clearCachedBitmapsLocked();
            closePendingImageLocked();
            closeCurrentImageLocked();
            this.pendingReader = this.imageReader;
            post(new Runnable() { // from class: tb.eo0
                @Override // java.lang.Runnable
                public final void run() {
                    FlutterImageView.this.lambda$resizeIfNeeded$1();
                }
            });
        }
        this.imageReader = createImageReader(i, i2);
    }

    @Override // io.flutter.embedding.engine.renderer.RenderSurface
    public void setRenderTransparently(boolean z) {
    }

    @Override // io.flutter.embedding.engine.renderer.RenderSurface
    public void updateAndInvalidate() {
        invalidate();
    }

    public FlutterImageView(@NonNull Context context) {
        this(context, 1, 1, SurfaceKind.surface);
    }

    private void setCurrentImageLocked(Image image, boolean z) {
        Image image2 = this.currentImage;
        if (image2 != null) {
            if (z) {
                Runnable runnable = this.delayReleaseCallback;
                if (runnable != null) {
                    runnable.run();
                }
                DelayReleaseCallback delayReleaseCallback = new DelayReleaseCallback(this.currentImage);
                this.delayReleaseCallback = delayReleaseCallback;
                sUIHandler.postAtFrontOfQueue(delayReleaseCallback);
            } else {
                image2.close();
            }
        }
        this.currentImage = image;
    }

    public FlutterImageView(@NonNull Context context, @NonNull AttributeSet attributeSet) {
        this(context, 1, 1, SurfaceKind.surface);
    }

    @VisibleForTesting
    FlutterImageView(@NonNull Context context, @NonNull ImageReader imageReader, SurfaceKind surfaceKind) {
        super(context, null);
        long j = sIdGenerator + 1;
        sIdGenerator = j;
        this.id = j;
        this.imageLock = new Object();
        this.bitmapsCache = new LinkedList();
        this.isAttachedToFlutterRenderer = false;
        this.imageReader = imageReader;
        this.kind = surfaceKind;
        init();
    }
}
