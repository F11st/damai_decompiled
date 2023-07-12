package io.flutter.embedding.engine;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.ColorSpace;
import android.graphics.ImageDecoder;
import android.graphics.Rect;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Process;
import android.util.Base64;
import android.util.Size;
import android.view.Surface;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import androidx.annotation.VisibleForTesting;
import com.youku.arch.solid.monitor.SolidMonitor;
import io.flutter.Log;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.embedding.engine.FlutterJNI;
import io.flutter.embedding.engine.dart.PlatformMessageHandler;
import io.flutter.embedding.engine.deferredcomponents.DeferredComponentManager;
import io.flutter.embedding.engine.mutatorsstack.FlutterMutatorsStack;
import io.flutter.embedding.engine.renderer.FlutterUiDisplayListener;
import io.flutter.embedding.engine.renderer.PlatformViewDisplayListener;
import io.flutter.embedding.engine.renderer.SurfaceTextureWrapper;
import io.flutter.plugin.common.StandardMessageCodec;
import io.flutter.plugin.localization.LocalizationPlugin;
import io.flutter.plugin.platform.PlatformViewsController;
import io.flutter.stat.StatServices;
import io.flutter.util.Preconditions;
import io.flutter.util.Trace;
import io.flutter.view.AccessibilityBridge;
import io.flutter.view.FlutterCallbackInformation;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.X509EncodedKeySpec;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/* compiled from: Taobao */
@Keep
/* loaded from: classes3.dex */
public class FlutterJNI {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final String TAG = "FlutterJNI";
    private static final int THREAD_PRIORITY_URGENT_DISPLAY = -8;
    private static final int THREAD_PRIORITY_VIDEO = -10;
    @Nullable
    private static AsyncWaitForVsyncDelegate asyncWaitForVsyncDelegate = null;
    private static boolean initCalled = false;
    private static boolean loadLibraryCalled = false;
    @Nullable
    private static String observatoryUri = null;
    private static boolean prefetchDefaultFontManagerCalled = false;
    private static float refreshRateFPS = 60.0f;
    private static Handler sVSyncHandler;
    private static HandlerThread sVSyncThread;
    @Nullable
    private static Handler warmUpDartVMCallbackHandle;
    @Nullable
    private static Runnable warmUpDartVMCallbackRunnable;
    @Nullable
    private AccessibilityDelegate accessibilityDelegate;
    @Nullable
    private DeferredComponentManager deferredComponentManager;
    @Nullable
    private LocalizationPlugin localizationPlugin;
    @Nullable
    private Long nativeShellHolderId;
    @Nullable
    private PlatformMessageHandler platformMessageHandler;
    @Nullable
    private PlatformViewsController platformViewsController;
    @Nullable
    private PresentSurfaceCallback presentSurfaceCallback;
    @NonNull
    private final Set<FlutterEngine.EngineLifecycleListener> engineLifecycleListeners = new CopyOnWriteArraySet();
    @NonNull
    private final Set<FlutterUiDisplayListener> flutterUiDisplayListeners = new CopyOnWriteArraySet();
    @NonNull
    private final Set<PlatformViewDisplayListener> platformViewDisplayListeners = new CopyOnWriteArraySet();
    @NonNull
    private final Looper mainLooper = Looper.getMainLooper();

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public interface AccessibilityDelegate {
        void updateCustomAccessibilityActions(@NonNull ByteBuffer byteBuffer, @NonNull String[] strArr);

        void updateSemantics(@NonNull ByteBuffer byteBuffer, @NonNull String[] strArr, @NonNull ByteBuffer[] byteBufferArr);
    }

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public interface AsyncWaitForVsyncDelegate {
        void asyncWaitForVsync(long j);
    }

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public static class Factory {
        public FlutterJNI provideFlutterJNI() {
            return new FlutterJNI();
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public interface PresentSurfaceCallback {
        void onPresentSurface(long j);

        void onPresentSurfaceCompleted(long j);
    }

    private static void asyncWaitForVsync(long j) {
        AsyncWaitForVsyncDelegate asyncWaitForVsyncDelegate2 = asyncWaitForVsyncDelegate;
        if (asyncWaitForVsyncDelegate2 != null) {
            asyncWaitForVsyncDelegate2.asyncWaitForVsync(j);
            return;
        }
        throw new IllegalStateException("An AsyncWaitForVsyncDelegate must be registered with FlutterJNI before asyncWaitForVsync() is invoked.");
    }

    private static void asyncWaitForVsyncEx(final long j) {
        initVSyncThread();
        sVSyncHandler.post(new Runnable() { // from class: io.flutter.embedding.engine.FlutterJNI.2
            @Override // java.lang.Runnable
            public void run() {
                if (FlutterJNI.asyncWaitForVsyncDelegate != null) {
                    FlutterJNI.asyncWaitForVsyncDelegate.asyncWaitForVsync(j);
                    return;
                }
                throw new IllegalStateException("An AsyncWaitForVsyncDelegate must be registered with FlutterJNI before asyncWaitForVsync() is invoked.");
            }
        });
    }

    public static void beginSection(String str) {
        Trace.beginSection(str);
    }

    public static void checkUIThreadPriority() {
        try {
            if (Process.getThreadPriority(0) > -8) {
                Log.e(TAG, "UI thread id=" + Process.myTid() + ", priority=" + Process.getThreadPriority(0) + ", need to raise!");
                Process.setThreadPriority(-10);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Nullable
    @VisibleForTesting
    public static Bitmap decodeImage(@NonNull ByteBuffer byteBuffer, final long j) {
        if (Build.VERSION.SDK_INT >= 28) {
            try {
                return ImageDecoder.decodeBitmap(ImageDecoder.createSource(byteBuffer), new ImageDecoder.OnHeaderDecodedListener() { // from class: tb.ko0
                    @Override // android.graphics.ImageDecoder.OnHeaderDecodedListener
                    public final void onHeaderDecoded(ImageDecoder imageDecoder, ImageDecoder.ImageInfo imageInfo, ImageDecoder.Source source) {
                        FlutterJNI.lambda$decodeImage$0(j, imageDecoder, imageInfo, source);
                    }
                });
            } catch (IOException e) {
                Log.e(TAG, "Failed to decode image", e);
            }
        }
        return null;
    }

    @Nullable
    @VisibleForTesting
    public static void decodeImageUsingExtendImageDecoder(@NonNull ByteBuffer byteBuffer, int i, String str, int i2, int i3, int i4, int i5, long j, long j2) {
        FlutterEngine.ExtendImageDecoder findExtendImageDecoder = FlutterEngine.findExtendImageDecoder(byteBuffer);
        FlutterEngine.ExtendImageDecoderResponser extendImageDecoderResponser = new FlutterEngine.ExtendImageDecoderResponser(j, j2, findExtendImageDecoder == null ? i2 : findExtendImageDecoder.fallbackWidth(), findExtendImageDecoder == null ? i3 : findExtendImageDecoder.fallbackHeight(), findExtendImageDecoder == null ? i4 : findExtendImageDecoder.fallbackColorType(), findExtendImageDecoder == null ? i5 : findExtendImageDecoder.fallbackAlphaType(), findExtendImageDecoder == null ? null : findExtendImageDecoder.fallbackBitmap(), findExtendImageDecoder == null ? false : findExtendImageDecoder.fallbackCanRecycle(), findExtendImageDecoder == null ? false : findExtendImageDecoder.fallbackCanCache());
        boolean z = findExtendImageDecoder != null && findExtendImageDecoder.supportSync() && (findExtendImageDecoder.preferSync() || !findExtendImageDecoder.preferAsync());
        boolean z2 = (findExtendImageDecoder == null || !findExtendImageDecoder.supportAsync() || z) ? false : true;
        boolean z3 = j2 == 0;
        if (z2) {
            if (findExtendImageDecoder.preferIgnoreException()) {
                try {
                    findExtendImageDecoder.decodeImageAsync(byteBuffer, null, extendImageDecoderResponser, z3);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                findExtendImageDecoder.decodeImageAsync(byteBuffer, null, extendImageDecoderResponser, z3);
            }
            extendImageDecoderResponser.fallbackIfNeeded(z3 ? findExtendImageDecoder.fallbackHeaderDelayMillis() : findExtendImageDecoder.fallbackBitmapDelayMillis());
        } else if (z) {
            if (findExtendImageDecoder.preferIgnoreException()) {
                try {
                    findExtendImageDecoder.decodeImageSync(byteBuffer, null, extendImageDecoderResponser, z3);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            } else {
                findExtendImageDecoder.decodeImageSync(byteBuffer, null, extendImageDecoderResponser, z3);
            }
            extendImageDecoderResponser.fallbackIfNeeded(0L);
        } else {
            extendImageDecoderResponser.fallbackIfNeeded(0L);
        }
    }

    public static void endSection() {
        Trace.endSection();
    }

    private void ensureAttachedToNative() {
        if (this.nativeShellHolderId == null) {
            throw new RuntimeException("Cannot execute operation because FlutterJNI is not attached to native.");
        }
    }

    private void ensureNotAttachedToNative() {
        if (this.nativeShellHolderId != null) {
            throw new RuntimeException("Cannot execute operation because FlutterJNI is attached to native.");
        }
    }

    private void ensureRunningOnMainThread() {
        if (Looper.myLooper() == this.mainLooper) {
            return;
        }
        throw new RuntimeException("Methods marked with @UiThread must be executed on the main thread. Current thread: " + Thread.currentThread().getName());
    }

    @Nullable
    public static String getObservatoryUri() {
        return observatoryUri;
    }

    private void handlePlatformMessageResponse(int i, ByteBuffer byteBuffer) {
        PlatformMessageHandler platformMessageHandler = this.platformMessageHandler;
        if (platformMessageHandler != null) {
            platformMessageHandler.handlePlatformMessageResponse(i, byteBuffer);
        }
    }

    private static synchronized void initVSyncThread() {
        synchronized (FlutterJNI.class) {
            if (sVSyncThread == null) {
                HandlerThread handlerThread = new HandlerThread("1.vsync", 10);
                sVSyncThread = handlerThread;
                handlerThread.start();
                Handler handler = new Handler(sVSyncThread.getLooper());
                sVSyncHandler = handler;
                handler.post(new Runnable() { // from class: io.flutter.embedding.engine.FlutterJNI.1
                    @Override // java.lang.Runnable
                    public void run() {
                        Process.setThreadPriority(-10);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$decodeImage$0(long j, ImageDecoder imageDecoder, ImageDecoder.ImageInfo imageInfo, ImageDecoder.Source source) {
        imageDecoder.setTargetColorSpace(ColorSpace.get(ColorSpace.Named.SRGB));
        imageDecoder.setAllocator(1);
        Size size = imageInfo.getSize();
        nativeImageHeaderCallback(j, size.getWidth(), size.getHeight());
    }

    private native long nativeAttach(@NonNull FlutterJNI flutterJNI, boolean z);

    private native void nativeDeferredComponentInstallFailure(int i, @NonNull String str, boolean z);

    private native void nativeDestroy(long j);

    private native void nativeDestroyPointerDataPacket(long j);

    private native void nativeDispatchEmptyPlatformMessage(long j, @NonNull String str, int i);

    private native void nativeDispatchPlatformMessage(long j, @NonNull String str, @Nullable ByteBuffer byteBuffer, int i, int i2);

    private native void nativeDispatchPointerDataPacket(long j, @NonNull ByteBuffer byteBuffer, int i);

    private native void nativeDispatchSemanticsAction(long j, int i, int i2, @Nullable ByteBuffer byteBuffer, int i3);

    private native long nativeDrawLastLayerTree(long j, boolean z);

    private native void nativeEnableDebugPreRenderDisplay(long j, boolean z);

    public static native void nativeExtendImageDecoderOnBitmapReady(long j, long j2, Bitmap bitmap, boolean z, boolean z2);

    public static native void nativeExtendImageDecoderOnHeaderReady(long j, int i, int i2, int i3, int i4);

    @VisibleForTesting
    public static native String nativeGetAXServiceWhiteList();

    private native Bitmap nativeGetBitmap(long j);

    public static native String nativeGetCurrentMapsGroup(boolean z);

    private native String nativeGetCurrentRouteName(long j);

    private native boolean nativeGetIsSoftwareRenderingEnabled();

    public static native void nativeImageHeaderCallback(long j, int i, int i2);

    @Deprecated
    public static native void nativeInit(@NonNull Context context, @NonNull String str, @NonNull String[] strArr, @Nullable String str2, @NonNull String str3, @NonNull String str4, long j);

    private native void nativeInvokePlatformMessageEmptyResponseCallback(long j, int i);

    private native void nativeInvokePlatformMessageResponseCallback(long j, int i, @Nullable ByteBuffer byteBuffer, int i2);

    private native void nativeLoadDartDeferredLibrary(long j, int i, @NonNull String[] strArr);

    @NonNull
    public static native FlutterCallbackInformation nativeLookupCallbackInformation(long j);

    private native void nativeMarkTextureFrameAvailable(long j, long j2);

    private native void nativeNotifyLowMemoryWarning(long j);

    @Deprecated
    public static native void nativePrefetchDefaultFontManager();

    private native void nativeRegisterTexture(long j, long j2, @NonNull WeakReference<SurfaceTextureWrapper> weakReference);

    private native void nativeRunBundleAndSnapshotFromLibrary(long j, @NonNull String str, @Nullable String str2, @Nullable String str3, @NonNull AssetManager assetManager);

    private native void nativeSetAccessibilityFeatures(long j, int i);

    public static native void nativeSetMapsGroupParams(boolean z, String str, String str2, String str3, String str4, String str5, long j);

    private native void nativeSetSemanticsEnabled(long j, boolean z);

    private native void nativeSetViewportMetrics(long j, float f, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12, int i13, int i14, int i15);

    private native FlutterJNI nativeSpawn(long j, @Nullable String str, @Nullable String str2);

    private native void nativeStartPreRendering(long j);

    private native void nativeSurfaceChanged(long j, int i, int i2);

    private native void nativeSurfaceCreated(long j, @NonNull Surface surface);

    private native void nativeSurfaceDestroyed(long j);

    private native void nativeSurfaceWindowChanged(long j, @NonNull Surface surface);

    private native long nativeSurfaceWindowChangedWithNewSurfaceId(long j, @NonNull Surface surface, boolean z, boolean z2);

    private native void nativeUnregisterTexture(long j, long j2);

    private native void nativeUpdateJavaAssetManager(long j, @NonNull AssetManager assetManager, @NonNull String str);

    private native void nativeWaitDrawLastLayerTree(long j);

    private native boolean nativeWaitPresentSurfaceCompleted(long j, int i);

    private native void nativeWarmUpSkSL(long j, @NonNull AssetManager assetManager);

    private void onPreEngineRestart() {
        for (FlutterEngine.EngineLifecycleListener engineLifecycleListener : this.engineLifecycleListeners) {
            engineLifecycleListener.onPreEngineRestart();
        }
    }

    public static void onWarmUpDartVMFinished() {
        Runnable runnable;
        Handler handler = warmUpDartVMCallbackHandle;
        if (handler != null && (runnable = warmUpDartVMCallbackRunnable) != null) {
            handler.post(runnable);
        }
        warmUpDartVMCallbackHandle = null;
        warmUpDartVMCallbackRunnable = null;
    }

    @Nullable
    @VisibleForTesting
    public static void recycleBitmap(@NonNull Bitmap bitmap) {
        bitmap.recycle();
    }

    public static void registerWarmUpDartVMCallback(@NonNull Handler handler, @NonNull Runnable runnable) {
        warmUpDartVMCallbackHandle = handler;
        warmUpDartVMCallbackRunnable = runnable;
    }

    @UiThread
    public static boolean rsaVerify(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        try {
            PublicKey generatePublic = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.decode(bArr3, 0)));
            Signature signature = Signature.getInstance("SHA256withRSA");
            signature.initVerify(generatePublic);
            signature.update(bArr);
            try {
                return signature.verify(Base64.decode(bArr2, 0));
            } catch (Throwable unused) {
                return false;
            }
        } catch (Throwable unused2) {
            return true;
        }
    }

    @UiThread
    private void updateCustomAccessibilityActions(@NonNull ByteBuffer byteBuffer, @NonNull String[] strArr) {
        ensureRunningOnMainThread();
        AccessibilityDelegate accessibilityDelegate = this.accessibilityDelegate;
        if (accessibilityDelegate != null) {
            accessibilityDelegate.updateCustomAccessibilityActions(byteBuffer, strArr);
        }
    }

    @UiThread
    private void updateSemantics(@NonNull ByteBuffer byteBuffer, @NonNull String[] strArr, @NonNull ByteBuffer[] byteBufferArr) {
        ensureRunningOnMainThread();
        AccessibilityDelegate accessibilityDelegate = this.accessibilityDelegate;
        if (accessibilityDelegate != null) {
            accessibilityDelegate.updateSemantics(byteBuffer, strArr, byteBufferArr);
        }
    }

    @UiThread
    public void addEngineLifecycleListener(@NonNull FlutterEngine.EngineLifecycleListener engineLifecycleListener) {
        ensureRunningOnMainThread();
        this.engineLifecycleListeners.add(engineLifecycleListener);
    }

    @UiThread
    public void addIsDisplayingFlutterUiListener(@NonNull FlutterUiDisplayListener flutterUiDisplayListener) {
        ensureRunningOnMainThread();
        this.flutterUiDisplayListeners.add(flutterUiDisplayListener);
    }

    public void addPlatformViewDisplayListener(@NonNull PlatformViewDisplayListener platformViewDisplayListener) {
        ensureRunningOnMainThread();
        this.platformViewDisplayListeners.add(platformViewDisplayListener);
    }

    @UiThread
    public void attachToNative(boolean z) {
        ensureRunningOnMainThread();
        ensureNotAttachedToNative();
        this.nativeShellHolderId = Long.valueOf(performNativeAttach(this, z));
    }

    @VisibleForTesting
    String[] computePlatformResolvedLocale(@NonNull String[] strArr) {
        if (this.localizationPlugin == null) {
            return new String[0];
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < strArr.length; i += 3) {
            String str = strArr[i + 0];
            String str2 = strArr[i + 1];
            String str3 = strArr[i + 2];
            if (Build.VERSION.SDK_INT >= 21) {
                Locale.Builder builder = new Locale.Builder();
                if (!str.isEmpty()) {
                    builder.setLanguage(str);
                }
                if (!str2.isEmpty()) {
                    builder.setRegion(str2);
                }
                if (!str3.isEmpty()) {
                    builder.setScript(str3);
                }
                arrayList.add(builder.build());
            } else {
                arrayList.add(new Locale(str, str2));
            }
        }
        Locale resolveNativeLocale = this.localizationPlugin.resolveNativeLocale(arrayList);
        if (resolveNativeLocale == null) {
            return new String[0];
        }
        String[] strArr2 = new String[3];
        strArr2[0] = resolveNativeLocale.getLanguage();
        strArr2[1] = resolveNativeLocale.getCountry();
        if (Build.VERSION.SDK_INT >= 21) {
            strArr2[2] = resolveNativeLocale.getScript();
        } else {
            strArr2[2] = "";
        }
        return strArr2;
    }

    @UiThread
    public FlutterOverlaySurface createOverlaySurface() {
        ensureRunningOnMainThread();
        PlatformViewsController platformViewsController = this.platformViewsController;
        if (platformViewsController != null) {
            return platformViewsController.createOverlaySurface();
        }
        throw new RuntimeException("platformViewsController must be set before attempting to position an overlay surface");
    }

    @UiThread
    public void deferredComponentInstallFailure(int i, @NonNull String str, boolean z) {
        ensureRunningOnMainThread();
        nativeDeferredComponentInstallFailure(i, str, z);
    }

    @UiThread
    public void destroyOverlaySurfaces() {
        ensureRunningOnMainThread();
        PlatformViewsController platformViewsController = this.platformViewsController;
        if (platformViewsController != null) {
            platformViewsController.destroyOverlaySurfaces();
            return;
        }
        throw new RuntimeException("platformViewsController must be set before attempting to destroy an overlay surface");
    }

    @UiThread
    public void destroyPointerDataPacket() {
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        nativeDestroyPointerDataPacket(this.nativeShellHolderId.longValue());
    }

    @UiThread
    public void detachFromNativeAndReleaseResources() {
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        nativeDestroy(this.nativeShellHolderId.longValue());
        this.nativeShellHolderId = null;
    }

    @UiThread
    public void dispatchEmptyPlatformMessage(@NonNull String str, int i) {
        ensureRunningOnMainThread();
        if (isAttached()) {
            nativeDispatchEmptyPlatformMessage(this.nativeShellHolderId.longValue(), str, i);
            return;
        }
        Log.w(TAG, "Tried to send a platform message to Flutter, but FlutterJNI was detached from native C++. Could not send. Channel: " + str + ". Response ID: " + i);
    }

    @UiThread
    public void dispatchPlatformMessage(@NonNull String str, @Nullable ByteBuffer byteBuffer, int i, int i2) {
        ensureRunningOnMainThread();
        if (isAttached()) {
            nativeDispatchPlatformMessage(this.nativeShellHolderId.longValue(), str, byteBuffer, i, i2);
            return;
        }
        Log.w(TAG, "Tried to send a platform message to Flutter, but FlutterJNI was detached from native C++. Could not send. Channel: " + str + ". Response ID: " + i2);
    }

    @UiThread
    public void dispatchPointerDataPacket(@NonNull ByteBuffer byteBuffer, int i) {
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        nativeDispatchPointerDataPacket(this.nativeShellHolderId.longValue(), byteBuffer, i);
    }

    public void dispatchSemanticsAction(int i, @NonNull AccessibilityBridge.Action action) {
        dispatchSemanticsAction(i, action, null);
    }

    @UiThread
    public long drawLastLayerTree(boolean z) {
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        beginSection("FlutterJNI.DrawLastLayerTree");
        long nativeDrawLastLayerTree = nativeDrawLastLayerTree(this.nativeShellHolderId.longValue(), z);
        endSection();
        return nativeDrawLastLayerTree;
    }

    @UiThread
    public void enableDebugPreRenderDisplay(boolean z) {
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        nativeEnableDebugPreRenderDisplay(this.nativeShellHolderId.longValue(), z);
    }

    @UiThread
    public Bitmap getBitmap() {
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        return nativeGetBitmap(this.nativeShellHolderId.longValue());
    }

    @UiThread
    public String getCurrentRouteName() {
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        return nativeGetCurrentRouteName(this.nativeShellHolderId.longValue());
    }

    @UiThread
    public boolean getIsSoftwareRenderingEnabled() {
        return nativeGetIsSoftwareRenderingEnabled();
    }

    @VisibleForTesting
    public void handlePlatformMessage(@NonNull String str, ByteBuffer byteBuffer, int i) {
        PlatformMessageHandler platformMessageHandler = this.platformMessageHandler;
        if (platformMessageHandler != null) {
            platformMessageHandler.handleMessageFromDart(str, byteBuffer, i);
        }
    }

    public void init(@NonNull Context context, @NonNull String str, @NonNull String[] strArr, @Nullable String str2, @NonNull String str3, @NonNull String str4, long j) {
        if (initCalled) {
            Log.w(TAG, "FlutterJNI.init called more than once");
        }
        nativeInit(context, str, strArr, str2, str3, str4, j);
        initCalled = true;
    }

    @UiThread
    public void invokePlatformMessageEmptyResponseCallback(int i) {
        ensureRunningOnMainThread();
        if (isAttached()) {
            nativeInvokePlatformMessageEmptyResponseCallback(this.nativeShellHolderId.longValue(), i);
            return;
        }
        Log.w(TAG, "Tried to send a platform message response, but FlutterJNI was detached from native C++. Could not send. Response ID: " + i);
    }

    @UiThread
    public void invokePlatformMessageResponseCallback(int i, @NonNull ByteBuffer byteBuffer, int i2) {
        ensureRunningOnMainThread();
        if (byteBuffer.isDirect()) {
            if (isAttached()) {
                nativeInvokePlatformMessageResponseCallback(this.nativeShellHolderId.longValue(), i, byteBuffer, i2);
                return;
            }
            Log.w(TAG, "Tried to send a platform message response, but FlutterJNI was detached from native C++. Could not send. Response ID: " + i);
            return;
        }
        throw new IllegalArgumentException("Expected a direct ByteBuffer.");
    }

    public boolean isAttached() {
        return this.nativeShellHolderId != null;
    }

    @UiThread
    public void loadDartDeferredLibrary(int i, @NonNull String[] strArr) {
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        nativeLoadDartDeferredLibrary(this.nativeShellHolderId.longValue(), i, strArr);
    }

    public void loadLibrary() {
        if (loadLibraryCalled) {
            Log.w(TAG, "FlutterJNI.loadLibrary called more than once");
        }
        System.loadLibrary(StatServices.EVENTCATEGORY);
        loadLibraryCalled = true;
    }

    @UiThread
    public void markTextureFrameAvailable(long j) {
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        nativeMarkTextureFrameAvailable(this.nativeShellHolderId.longValue(), j);
    }

    public native boolean nativeFlutterTextUtilsIsEmoji(int i);

    public native boolean nativeFlutterTextUtilsIsEmojiModifier(int i);

    public native boolean nativeFlutterTextUtilsIsEmojiModifierBase(int i);

    public native boolean nativeFlutterTextUtilsIsRegionalIndicator(int i);

    public native boolean nativeFlutterTextUtilsIsVariationSelector(int i);

    public native void nativeOnVsync(long j, long j2, long j3);

    @UiThread
    public void notifyLowMemoryWarning() {
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        nativeNotifyLowMemoryWarning(this.nativeShellHolderId.longValue());
    }

    @UiThread
    public void onBeginFrame() {
        ensureRunningOnMainThread();
        PlatformViewsController platformViewsController = this.platformViewsController;
        if (platformViewsController != null) {
            platformViewsController.onBeginFrame();
            return;
        }
        throw new RuntimeException("platformViewsController must be set before attempting to begin the frame");
    }

    @UiThread
    void onCancelFrame() {
        ensureRunningOnMainThread();
        for (PlatformViewDisplayListener platformViewDisplayListener : this.platformViewDisplayListeners) {
            platformViewDisplayListener.onCancelFrame();
        }
    }

    @UiThread
    public void onDisplayOverlaySurface(int i, int i2, int i3, int i4, int i5) {
        ensureRunningOnMainThread();
        PlatformViewsController platformViewsController = this.platformViewsController;
        if (platformViewsController != null) {
            platformViewsController.onDisplayOverlaySurface(i, i2, i3, i4, i5);
            return;
        }
        throw new RuntimeException("platformViewsController must be set before attempting to position an overlay surface");
    }

    @UiThread
    public void onDisplayPlatformView(int i, int i2, int i3, int i4, int i5, int i6, int i7, FlutterMutatorsStack flutterMutatorsStack) {
        ensureRunningOnMainThread();
        PlatformViewsController platformViewsController = this.platformViewsController;
        if (platformViewsController != null) {
            platformViewsController.onDisplayPlatformView(i, i2, i3, i4, i5, i6, i7, flutterMutatorsStack);
            return;
        }
        throw new RuntimeException("platformViewsController must be set before attempting to position a platform view");
    }

    @UiThread
    public void onEndFrame() {
        ensureRunningOnMainThread();
        PlatformViewsController platformViewsController = this.platformViewsController;
        if (platformViewsController != null) {
            platformViewsController.onEndFrame();
            return;
        }
        throw new RuntimeException("platformViewsController must be set before attempting to end the frame");
    }

    @UiThread
    @VisibleForTesting
    public void onFirstFrame() {
        ensureRunningOnMainThread();
        for (FlutterUiDisplayListener flutterUiDisplayListener : this.flutterUiDisplayListeners) {
            flutterUiDisplayListener.onFlutterUiDisplayed();
        }
    }

    @UiThread
    void onPlatformViewDisplayedUpdated(int i, float f, int i2, int i3, int i4, int i5) {
        ensureRunningOnMainThread();
        Rect rect = new Rect(i2, i3, i4, i5);
        for (PlatformViewDisplayListener platformViewDisplayListener : this.platformViewDisplayListeners) {
            platformViewDisplayListener.onPlatformViewDisplayedUpdated(i, rect, f);
        }
    }

    @UiThread
    void onPresentSurface(long j) {
        ensureRunningOnMainThread();
        PresentSurfaceCallback presentSurfaceCallback = this.presentSurfaceCallback;
        if (presentSurfaceCallback != null) {
            presentSurfaceCallback.onPresentSurface(j);
        }
    }

    @UiThread
    void onPresentSurfaceCompleted(long j) {
        ensureRunningOnMainThread();
        PresentSurfaceCallback presentSurfaceCallback = this.presentSurfaceCallback;
        if (presentSurfaceCallback != null) {
            presentSurfaceCallback.onPresentSurfaceCompleted(j);
        }
    }

    @UiThread
    @VisibleForTesting
    void onRenderingStopped() {
        ensureRunningOnMainThread();
        for (FlutterUiDisplayListener flutterUiDisplayListener : this.flutterUiDisplayListeners) {
            flutterUiDisplayListener.onFlutterUiNoLongerDisplayed();
        }
    }

    @UiThread
    void onSubmitFrame() {
        ensureRunningOnMainThread();
        for (PlatformViewDisplayListener platformViewDisplayListener : this.platformViewDisplayListeners) {
            platformViewDisplayListener.onSubmitFrame();
        }
    }

    @UiThread
    public void onSurfaceChanged(int i, int i2) {
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        nativeSurfaceChanged(this.nativeShellHolderId.longValue(), i, i2);
    }

    @UiThread
    public void onSurfaceCreated(@NonNull Surface surface) {
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        nativeSurfaceCreated(this.nativeShellHolderId.longValue(), surface);
    }

    @UiThread
    public void onSurfaceDestroyed() {
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        onRenderingStopped();
        nativeSurfaceDestroyed(this.nativeShellHolderId.longValue());
    }

    @UiThread
    public void onSurfaceWindowChanged(@NonNull Surface surface) {
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        nativeSurfaceWindowChanged(this.nativeShellHolderId.longValue(), surface);
    }

    @UiThread
    public long onSurfaceWindowChangedWithNewSurfaceId(@NonNull Surface surface, boolean z, boolean z2) {
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        return nativeSurfaceWindowChangedWithNewSurfaceId(this.nativeShellHolderId.longValue(), surface, z, z2);
    }

    @VisibleForTesting
    public long performNativeAttach(@NonNull FlutterJNI flutterJNI, boolean z) {
        return nativeAttach(flutterJNI, z);
    }

    public void prefetchDefaultFontManager() {
        if (prefetchDefaultFontManagerCalled) {
            Log.w(TAG, "FlutterJNI.prefetchDefaultFontManager called more than once");
        }
        nativePrefetchDefaultFontManager();
        prefetchDefaultFontManagerCalled = true;
    }

    @UiThread
    public void registerTexture(long j, @NonNull SurfaceTextureWrapper surfaceTextureWrapper) {
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        nativeRegisterTexture(this.nativeShellHolderId.longValue(), j, new WeakReference<>(surfaceTextureWrapper));
    }

    @UiThread
    public void removeEngineLifecycleListener(@NonNull FlutterEngine.EngineLifecycleListener engineLifecycleListener) {
        ensureRunningOnMainThread();
        this.engineLifecycleListeners.remove(engineLifecycleListener);
    }

    @UiThread
    public void removeIsDisplayingFlutterUiListener(@NonNull FlutterUiDisplayListener flutterUiDisplayListener) {
        ensureRunningOnMainThread();
        this.flutterUiDisplayListeners.remove(flutterUiDisplayListener);
    }

    public void removePlatformViewDisplayListener(@NonNull PlatformViewDisplayListener platformViewDisplayListener) {
        ensureRunningOnMainThread();
        this.platformViewDisplayListeners.remove(platformViewDisplayListener);
    }

    @UiThread
    public void requestDartDeferredLibrary(int i) {
        DeferredComponentManager deferredComponentManager = this.deferredComponentManager;
        if (deferredComponentManager != null) {
            deferredComponentManager.installDeferredComponent(i, null);
        } else {
            Log.e(TAG, "No DeferredComponentManager found. Android setup must be completed before using split AOT deferred components.");
        }
    }

    @UiThread
    public void runBundleAndSnapshotFromLibrary(@NonNull String str, @Nullable String str2, @Nullable String str3, @NonNull AssetManager assetManager) {
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        nativeRunBundleAndSnapshotFromLibrary(this.nativeShellHolderId.longValue(), str, str2, str3, assetManager);
    }

    @UiThread
    public void setAccessibilityDelegate(@Nullable AccessibilityDelegate accessibilityDelegate) {
        ensureRunningOnMainThread();
        this.accessibilityDelegate = accessibilityDelegate;
    }

    @UiThread
    public void setAccessibilityFeatures(int i) {
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        nativeSetAccessibilityFeatures(this.nativeShellHolderId.longValue(), i);
    }

    public void setAsyncWaitForVsyncDelegate(@Nullable AsyncWaitForVsyncDelegate asyncWaitForVsyncDelegate2) {
        asyncWaitForVsyncDelegate = asyncWaitForVsyncDelegate2;
    }

    @UiThread
    public void setDeferredComponentManager(@Nullable DeferredComponentManager deferredComponentManager) {
        ensureRunningOnMainThread();
        this.deferredComponentManager = deferredComponentManager;
        if (deferredComponentManager != null) {
            deferredComponentManager.setJNI(this);
        }
    }

    @UiThread
    public void setLocalizationPlugin(@Nullable LocalizationPlugin localizationPlugin) {
        ensureRunningOnMainThread();
        this.localizationPlugin = localizationPlugin;
    }

    @UiThread
    public void setPlatformMessageHandler(@Nullable PlatformMessageHandler platformMessageHandler) {
        ensureRunningOnMainThread();
        this.platformMessageHandler = platformMessageHandler;
    }

    @UiThread
    public void setPlatformViewsController(@NonNull PlatformViewsController platformViewsController) {
        ensureRunningOnMainThread();
        this.platformViewsController = platformViewsController;
    }

    @UiThread
    public void setPresentSurfaceCallback(@Nullable PresentSurfaceCallback presentSurfaceCallback) {
        ensureRunningOnMainThread();
        this.presentSurfaceCallback = presentSurfaceCallback;
    }

    public void setRefreshRateFPS(float f) {
        refreshRateFPS = f;
    }

    @UiThread
    public void setSemanticsEnabled(boolean z) {
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        nativeSetSemanticsEnabled(this.nativeShellHolderId.longValue(), z);
    }

    @UiThread
    public void setViewportMetrics(float f, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12, int i13, int i14, int i15) {
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        nativeSetViewportMetrics(this.nativeShellHolderId.longValue(), f, i, i2, i3, i4, i5, i6, i7, i8, i9, i10, i11, i12, i13, i14, i15);
    }

    @NonNull
    @UiThread
    public FlutterJNI spawn(@Nullable String str, @Nullable String str2) {
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        FlutterJNI nativeSpawn = nativeSpawn(this.nativeShellHolderId.longValue(), str, str2);
        Long l = nativeSpawn.nativeShellHolderId;
        Preconditions.checkState((l == null || l.longValue() == 0) ? false : true, "Failed to spawn new JNI connected shell from existing shell.");
        return nativeSpawn;
    }

    @UiThread
    public void startPreRendering() {
        nativeStartPreRendering(this.nativeShellHolderId.longValue());
    }

    @UiThread
    public void unregisterTexture(long j) {
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        nativeUnregisterTexture(this.nativeShellHolderId.longValue(), j);
    }

    @UiThread
    public void updateJavaAssetManager(@NonNull AssetManager assetManager, @NonNull String str) {
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        nativeUpdateJavaAssetManager(this.nativeShellHolderId.longValue(), assetManager, str);
    }

    @UiThread
    public void waitDrawLastLayerTree() {
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        beginSection("FlutterJNI.WaitDrawLastLayerTree");
        nativeWaitDrawLastLayerTree(this.nativeShellHolderId.longValue());
        endSection();
    }

    @UiThread
    public boolean waitPresentSurfaceCompleted() {
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        beginSection("FlutterJNI.WaitPresentSurfaceCompleted");
        float f = refreshRateFPS;
        boolean nativeWaitPresentSurfaceCompleted = nativeWaitPresentSurfaceCompleted(this.nativeShellHolderId.longValue(), f > 91.0f ? 2 : f > 61.0f ? 3 : 6);
        endSection();
        return nativeWaitPresentSurfaceCompleted;
    }

    @UiThread
    public void warmUpSkSL(@NonNull AssetManager assetManager) {
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        nativeWarmUpSkSL(this.nativeShellHolderId.longValue(), assetManager);
    }

    public void dispatchSemanticsAction(int i, @NonNull AccessibilityBridge.Action action, @Nullable Object obj) {
        ByteBuffer byteBuffer;
        int i2;
        ensureAttachedToNative();
        if (obj != null) {
            byteBuffer = StandardMessageCodec.INSTANCE.encodeMessage(obj);
            i2 = byteBuffer.position();
        } else {
            byteBuffer = null;
            i2 = 0;
        }
        dispatchSemanticsAction(i, action.value, byteBuffer, i2);
    }

    public static void loadLibrary(String str) {
        if (str == null) {
            return;
        }
        try {
            int indexOf = str.indexOf(SolidMonitor.CHECK_TYPE_LIB);
            int lastIndexOf = str.lastIndexOf(".so");
            if (indexOf != -1 && lastIndexOf != -1) {
                System.loadLibrary(str.substring(indexOf + 3, lastIndexOf));
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @UiThread
    public void dispatchSemanticsAction(int i, int i2, @Nullable ByteBuffer byteBuffer, int i3) {
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        nativeDispatchSemanticsAction(this.nativeShellHolderId.longValue(), i, i2, byteBuffer, i3);
    }
}
