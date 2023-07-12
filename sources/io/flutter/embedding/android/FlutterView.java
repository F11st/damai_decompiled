package io.flutter.embedding.android;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Insets;
import android.graphics.Rect;
import android.os.Build;
import android.text.format.DateFormat;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.DisplayCutout;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.PointerIcon;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewStructure;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeProvider;
import android.view.autofill.AutofillValue;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import io.flutter.Log;
import io.flutter.embedding.android.FlutterImageView;
import io.flutter.embedding.android.FlutterView;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.embedding.engine.FlutterJNI;
import io.flutter.embedding.engine.renderer.FlutterRenderer;
import io.flutter.embedding.engine.renderer.FlutterUiDisplayListener;
import io.flutter.embedding.engine.renderer.RenderSurface;
import io.flutter.embedding.engine.systemchannels.SettingsChannel;
import io.flutter.plugin.editing.TextInputPlugin;
import io.flutter.plugin.localization.LocalizationPlugin;
import io.flutter.plugin.mouse.MouseCursorPlugin;
import io.flutter.util.SourceLocation;
import io.flutter.util.Trace;
import io.flutter.view.AccessibilityBridge;
import io.flutter.view.VsyncWaiter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Set;
import tb.C9796v;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class FlutterView extends FrameLayout implements MouseCursorPlugin.MouseCursorViewDelegate {
    public static final int PROMOTE_RENDER_SURFACE_HAS_PLATFORM_VIEW = 3;
    public static final int PROMOTE_RENDER_SURFACE_NO_ENGINE = 1;
    public static final int PROMOTE_RENDER_SURFACE_NO_SURFACE = 2;
    public static final int PROMOTE_RENDER_SURFACE_RENDER_TRANSPARENTLY = 4;
    public static final int PROMOTE_RENDER_SURFACE_SUCCESS = 0;
    private static final boolean REMOVE_SURFACE_VIEW_WHEN_FALLBACK;
    private static final String TAG = "FlutterView";
    @Nullable
    private AccessibilityBridge accessibilityBridge;
    @Nullable
    private AndroidTouchProcessor androidTouchProcessor;
    @Nullable
    private RenderSurface fallbackRenderSurface;
    @Nullable
    private FlutterEngine flutterEngine;
    @NonNull
    private final Set<FlutterEngineAttachmentListener> flutterEngineAttachmentListeners;
    @Nullable
    private FlutterImageView flutterImageView;
    @Nullable
    private FlutterSurfaceView flutterSurfaceView;
    @Nullable
    private FlutterTextureView flutterTextureView;
    private final FlutterUiDisplayListener flutterUiDisplayListener;
    private final Set<FlutterUiDisplayListener> flutterUiDisplayListeners;
    private boolean hasPlatformView;
    private boolean isFlutterUiDisplayed;
    @Nullable
    private KeyboardManager keyboardManager;
    @Nullable
    private LocalizationPlugin localizationPlugin;
    @Nullable
    private MouseCursorPlugin mouseCursorPlugin;
    private final AccessibilityBridge.OnAccessibilityChangeListener onAccessibilityChangeListener;
    @Nullable
    private PendingPromoteCallback pendingPromoteCallback;
    @Nullable
    private RenderSurface previousRenderSurface;
    @Nullable
    private RenderSurface renderSurface;
    private boolean renderTransparently;
    @Nullable
    private TextInputPlugin textInputPlugin;
    private final FlutterRenderer.ViewportMetrics viewportMetrics;
    private boolean waitingFallbackDone;

    /* compiled from: Taobao */
    @VisibleForTesting
    /* loaded from: classes3.dex */
    public interface FlutterEngineAttachmentListener {
        void onFlutterEngineAttachedToFlutterView(@NonNull FlutterEngine flutterEngine);

        void onFlutterEngineDetachedFromFlutterView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public class PendingPromoteCallback implements FlutterUiDisplayListener {
        private PendingPromoteCallback() {
        }

        @Override // io.flutter.embedding.engine.renderer.FlutterUiDisplayListener
        public void onFlutterUiDisplayed() {
            FlutterView.this.pendingPromoteCallback = null;
            if (FlutterView.this.flutterEngine != null) {
                FlutterView.this.promoteRenderSurface();
                FlutterView.this.flutterEngine.getRenderer().removeIsDisplayingFlutterUiListener(this);
            }
        }

        @Override // io.flutter.embedding.engine.renderer.FlutterUiDisplayListener
        public void onFlutterUiNoLongerDisplayed() {
        }
    }

    /* compiled from: Taobao */
    @Deprecated
    /* loaded from: classes3.dex */
    public enum RenderMode {
        surface,
        texture,
        image
    }

    /* compiled from: Taobao */
    @Deprecated
    /* loaded from: classes3.dex */
    public enum TransparencyMode {
        opaque,
        transparent
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public enum ZeroSides {
        NONE,
        LEFT,
        RIGHT,
        BOTH
    }

    static {
        REMOVE_SURFACE_VIEW_WHEN_FALLBACK = Build.VERSION.SDK_INT < 26;
    }

    public FlutterView(@NonNull Context context) {
        this(context, (AttributeSet) null, new FlutterSurfaceView(context));
    }

    private void addPendingPromoteRenderSurface() {
        FlutterEngine flutterEngine;
        if (this.pendingPromoteCallback != null || (flutterEngine = this.flutterEngine) == null || flutterEngine.getRenderer().isDisplayingFlutterUi()) {
            return;
        }
        FlutterJNI.beginSection("FlutterView.AddPendingPromoteRenderSurface");
        this.pendingPromoteCallback = new PendingPromoteCallback();
        this.flutterEngine.getRenderer().addIsDisplayingFlutterUiListener(this.pendingPromoteCallback);
        FlutterJNI.endSection();
    }

    private ZeroSides calculateShouldZeroSides() {
        Context context = getContext();
        int i = context.getResources().getConfiguration().orientation;
        int rotation = ((WindowManager) context.getSystemService(C9796v.ATTACH_MODE_WINDOW)).getDefaultDisplay().getRotation();
        if (i == 2) {
            if (rotation == 1) {
                return ZeroSides.RIGHT;
            }
            if (rotation == 3) {
                return Build.VERSION.SDK_INT >= 23 ? ZeroSides.LEFT : ZeroSides.RIGHT;
            } else if (rotation == 0 || rotation == 2) {
                return ZeroSides.BOTH;
            }
        }
        return ZeroSides.NONE;
    }

    @SuppressLint({"PrivateApi"})
    private View findViewByAccessibilityIdRootedAtCurrentView(int i, View view) {
        int i2;
        Method declaredMethod;
        try {
            i2 = 0;
            declaredMethod = View.class.getDeclaredMethod("getAccessibilityViewId", new Class[0]);
            declaredMethod.setAccessible(true);
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
        }
        if (declaredMethod.invoke(view, new Object[0]).equals(Integer.valueOf(i))) {
            return view;
        }
        if (view instanceof ViewGroup) {
            while (true) {
                ViewGroup viewGroup = (ViewGroup) view;
                if (i2 >= viewGroup.getChildCount()) {
                    break;
                }
                View findViewByAccessibilityIdRootedAtCurrentView = findViewByAccessibilityIdRootedAtCurrentView(i, viewGroup.getChildAt(i2));
                if (findViewByAccessibilityIdRootedAtCurrentView != null) {
                    return findViewByAccessibilityIdRootedAtCurrentView;
                }
                i2++;
            }
        }
        return null;
    }

    @RequiresApi(20)
    @TargetApi(20)
    private int guessBottomKeyboardInset(WindowInsets windowInsets) {
        if (windowInsets.getSystemWindowInsetBottom() < getRootView().getHeight() * 0.18d) {
            return 0;
        }
        return windowInsets.getSystemWindowInsetBottom();
    }

    private void init() {
        Log.v(TAG, "Initializing FlutterView");
        if (this.flutterSurfaceView != null) {
            Log.v(TAG, "Internally using a FlutterSurfaceView.");
            addView(this.flutterSurfaceView);
        } else if (this.flutterTextureView != null) {
            Log.v(TAG, "Internally using a FlutterTextureView.");
            addView(this.flutterTextureView);
        } else {
            Log.v(TAG, "Internally using a FlutterImageView.");
            addView(this.flutterImageView);
        }
        setFocusable(true);
        setFocusableInTouchMode(true);
        if (Build.VERSION.SDK_INT >= 26) {
            setImportantForAutofill(4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fallbackRenderSurface$1(boolean z) {
        FlutterJNI.beginSection("FlutterView.FallbackRenderSurface.Done");
        if (this.waitingFallbackDone) {
            if (z) {
                removePromotedSurfaceView();
            }
            this.waitingFallbackDone = false;
        }
        FlutterJNI.endSection();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$null$2(FlutterSurfaceView flutterSurfaceView) {
        if (flutterSurfaceView == null || flutterSurfaceView.getParent() != this) {
            return;
        }
        FlutterJNI.beginSection("FlutterView.RemovePromotedSurfaceView.Done");
        removeView(flutterSurfaceView);
        FlutterJNI.endSection();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$promoteRenderSurface$0(FlutterRenderer flutterRenderer) {
        FlutterJNI.beginSection("FlutterView.PromoteRenderSurface.SwapSurface");
        this.fallbackRenderSurface = this.renderSurface;
        FlutterSurfaceView flutterSurfaceView = this.flutterSurfaceView;
        this.renderSurface = flutterSurfaceView;
        flutterRenderer.setPromoteBehavior(flutterSurfaceView.hasSurface());
        this.fallbackRenderSurface.detachFromRenderer();
        this.flutterSurfaceView.attachToRenderer(flutterRenderer);
        FlutterJNI.endSection();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$removePromotedSurfaceView$3(final FlutterSurfaceView flutterSurfaceView) {
        FlutterJNI.beginSection("FlutterView.RemovePromotedSurfaceView");
        postOnAnimation(new Runnable() { // from class: tb.oo0
            @Override // java.lang.Runnable
            public final void run() {
                FlutterView.this.lambda$null$2(flutterSurfaceView);
            }
        });
        FlutterJNI.endSection();
    }

    private void removePendingPromoteRenderSurface() {
        if (this.pendingPromoteCallback != null) {
            Log.w(TAG, "FlutterView.removePendingPromoteRenderSurface has pending promote");
            FlutterEngine flutterEngine = this.flutterEngine;
            if (flutterEngine != null) {
                flutterEngine.getRenderer().removeIsDisplayingFlutterUiListener(this.pendingPromoteCallback);
            }
            this.pendingPromoteCallback = null;
        }
        FlutterSurfaceView flutterSurfaceView = this.flutterSurfaceView;
        if (flutterSurfaceView != null) {
            flutterSurfaceView.cancelPromote();
        }
    }

    private void removePromotedSurfaceView() {
        final FlutterSurfaceView flutterSurfaceView = this.flutterSurfaceView;
        this.flutterSurfaceView = null;
        postOnAnimation(new Runnable() { // from class: tb.no0
            @Override // java.lang.Runnable
            public final void run() {
                FlutterView.this.lambda$removePromotedSurfaceView$3(flutterSurfaceView);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetWillNotDraw(boolean z, boolean z2) {
        FlutterEngine flutterEngine = this.flutterEngine;
        if (flutterEngine == null) {
            return;
        }
        boolean z3 = false;
        if (!flutterEngine.getRenderer().isSoftwareRenderingEnabled()) {
            if (!z && !z2) {
                z3 = true;
            }
            setWillNotDraw(z3);
            return;
        }
        setWillNotDraw(false);
    }

    private void sendViewportMetricsToFlutter() {
        if (!isAttachedToFlutterEngine()) {
            Log.w(TAG, "Tried to send viewport metrics from Android to Flutter but this FlutterView was not attached to a FlutterEngine.");
            return;
        }
        this.viewportMetrics.devicePixelRatio = getResources().getDisplayMetrics().density;
        this.viewportMetrics.physicalTouchSlop = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.flutterEngine.getRenderer().setViewportMetrics(this.viewportMetrics);
    }

    private void waitFallbackRenderSurfaceDone() {
        if (!this.waitingFallbackDone || this.flutterEngine == null) {
            return;
        }
        FlutterJNI.beginSection("FlutterView.WaitFallbackRenderSurfaceDone");
        this.flutterEngine.getRenderer().waitDrawLastLayerTree();
        FlutterJNI.endSection();
    }

    public boolean acquireLatestImageViewFrame() {
        FlutterImageView flutterImageView = this.flutterImageView;
        if (flutterImageView != null) {
            return flutterImageView.acquireLatestImage();
        }
        return false;
    }

    @VisibleForTesting
    public void addFlutterEngineAttachmentListener(@NonNull FlutterEngineAttachmentListener flutterEngineAttachmentListener) {
        this.flutterEngineAttachmentListeners.add(flutterEngineAttachmentListener);
    }

    public void addOnFirstFrameRenderedListener(@NonNull FlutterUiDisplayListener flutterUiDisplayListener) {
        this.flutterUiDisplayListeners.add(flutterUiDisplayListener);
    }

    public void attachOverlaySurfaceToRender(FlutterImageView flutterImageView) {
        FlutterEngine flutterEngine = this.flutterEngine;
        if (flutterEngine != null) {
            flutterImageView.attachToRenderer(flutterEngine.getRenderer());
        }
    }

    public void attachToFlutterEngine(@NonNull FlutterEngine flutterEngine) {
        Log.v(TAG, "Attaching to a FlutterEngine: " + flutterEngine);
        if (isAttachedToFlutterEngine()) {
            if (flutterEngine == this.flutterEngine) {
                Log.v(TAG, "Already attached to this engine. Doing nothing.");
                return;
            } else {
                Log.v(TAG, "Currently attached to a different engine. Detaching and then attaching to new engine.");
                detachFromFlutterEngine();
            }
        }
        Trace.beginSection(SourceLocation.clazz(this) + "." + SourceLocation.method());
        this.flutterEngine = flutterEngine;
        FlutterRenderer renderer = flutterEngine.getRenderer();
        this.isFlutterUiDisplayed = renderer.isDisplayingFlutterUi();
        this.renderSurface.attachToRenderer(renderer);
        renderer.addIsDisplayingFlutterUiListener(this.flutterUiDisplayListener);
        if (Build.VERSION.SDK_INT >= 24) {
            this.mouseCursorPlugin = new MouseCursorPlugin(this, this.flutterEngine.getMouseCursorChannel());
        }
        this.textInputPlugin = new TextInputPlugin(this, this.flutterEngine.getTextInputChannel(), this.flutterEngine.getPlatformViewsController());
        this.localizationPlugin = this.flutterEngine.getLocalizationPlugin();
        this.keyboardManager = new KeyboardManager(this, this.textInputPlugin, new KeyChannelResponder[]{new KeyChannelResponder(flutterEngine.getKeyEventChannel())});
        this.androidTouchProcessor = new AndroidTouchProcessor(this.flutterEngine.getRenderer(), false);
        AccessibilityBridge accessibilityBridge = new AccessibilityBridge(this, flutterEngine.getAccessibilityChannel(), (AccessibilityManager) getContext().getSystemService("accessibility"), getContext().getContentResolver(), this.flutterEngine.getPlatformViewsController());
        this.accessibilityBridge = accessibilityBridge;
        accessibilityBridge.setOnAccessibilityChangeListener(this.onAccessibilityChangeListener);
        resetWillNotDraw(this.accessibilityBridge.isAccessibilityEnabled(), this.accessibilityBridge.isTouchExplorationEnabled());
        this.flutterEngine.getPlatformViewsController().attachAccessibilityBridge(this.accessibilityBridge);
        this.flutterEngine.getPlatformViewsController().attachToFlutterRenderer(this.flutterEngine.getRenderer());
        this.textInputPlugin.getInputMethodManager().restartInput(this);
        sendUserSettingsToFlutter();
        this.localizationPlugin.sendLocalesToFlutter(getResources().getConfiguration());
        sendViewportMetricsToFlutter();
        flutterEngine.getPlatformViewsController().attachToView(this);
        for (FlutterEngineAttachmentListener flutterEngineAttachmentListener : this.flutterEngineAttachmentListeners) {
            flutterEngineAttachmentListener.onFlutterEngineAttachedToFlutterView(flutterEngine);
        }
        if (this.isFlutterUiDisplayed) {
            this.flutterUiDisplayListener.onFlutterUiDisplayed();
        }
        Trace.endSection();
    }

    public void attachToFlutterEngineForPreRendering(@NonNull FlutterEngine flutterEngine) {
        Log.v(TAG, "Attaching to a FlutterEngine: " + flutterEngine + " for pre-rendering");
        if (isAttachedToFlutterEngine()) {
            if (flutterEngine == this.flutterEngine) {
                Log.v(TAG, "Already attached to this engine. Doing nothing.");
                return;
            } else {
                Log.v(TAG, "Currently attached to a different engine. Detaching and then attaching to new engine.");
                detachFromFlutterEngine();
            }
        }
        Trace.beginSection(SourceLocation.clazz(this) + "." + SourceLocation.method());
        this.flutterEngine = flutterEngine;
        this.renderSurface.attachToRenderer(flutterEngine.getRenderer());
        sendUserSettingsToFlutter();
        LocalizationPlugin localizationPlugin = this.flutterEngine.getLocalizationPlugin();
        this.localizationPlugin = localizationPlugin;
        localizationPlugin.sendLocalesToFlutter(getResources().getConfiguration());
        sendViewportMetricsToFlutter();
        Trace.endSection();
    }

    @Override // android.view.View
    public void autofill(SparseArray<AutofillValue> sparseArray) {
        TextInputPlugin textInputPlugin = this.textInputPlugin;
        if (textInputPlugin == null) {
            return;
        }
        textInputPlugin.autofill(sparseArray);
    }

    public void convertToImageView() {
        fallbackRenderSurfaceForPlatformView(false);
        this.renderSurface.pause();
        FlutterImageView flutterImageView = this.flutterImageView;
        if (flutterImageView != null && !flutterImageView.isSurfaceKind()) {
            this.flutterImageView.resizeIfNeeded(getWidth(), getHeight());
        } else {
            FlutterImageView createImageView = createImageView();
            this.flutterImageView = createImageView;
            addView(createImageView);
        }
        this.previousRenderSurface = this.renderSurface;
        FlutterImageView flutterImageView2 = this.flutterImageView;
        this.renderSurface = flutterImageView2;
        FlutterEngine flutterEngine = this.flutterEngine;
        if (flutterEngine != null) {
            flutterImageView2.attachToRenderer(flutterEngine.getRenderer());
        }
    }

    @NonNull
    @VisibleForTesting
    public FlutterImageView createImageView() {
        return new FlutterImageView(getContext(), getWidth(), getHeight(), FlutterImageView.SurfaceKind.background);
    }

    public void detachFromFlutterEngine() {
        Log.v(TAG, "Detaching from a FlutterEngine: " + this.flutterEngine);
        if (!isAttachedToFlutterEngine()) {
            Log.v(TAG, "FlutterView not attached to an engine. Not detaching.");
            return;
        }
        for (FlutterEngineAttachmentListener flutterEngineAttachmentListener : this.flutterEngineAttachmentListeners) {
            flutterEngineAttachmentListener.onFlutterEngineDetachedFromFlutterView();
        }
        this.flutterEngine.getPlatformViewsController().detachFromView();
        this.flutterEngine.getPlatformViewsController().detachAccessibiltyBridge();
        this.accessibilityBridge.release();
        this.accessibilityBridge = null;
        this.textInputPlugin.getInputMethodManager().restartInput(this);
        this.textInputPlugin.destroy();
        this.keyboardManager.destroy();
        this.androidTouchProcessor.destroy();
        MouseCursorPlugin mouseCursorPlugin = this.mouseCursorPlugin;
        if (mouseCursorPlugin != null) {
            mouseCursorPlugin.destroy();
        }
        FlutterRenderer renderer = this.flutterEngine.getRenderer();
        this.isFlutterUiDisplayed = false;
        renderer.removeIsDisplayingFlutterUiListener(this.flutterUiDisplayListener);
        renderer.stopRenderingToSurface();
        renderer.setSemanticsEnabled(false);
        this.renderSurface.detachFromRenderer();
        RenderSurface renderSurface = this.previousRenderSurface;
        if (renderSurface != null) {
            RenderSurface renderSurface2 = this.renderSurface;
            FlutterImageView flutterImageView = this.flutterImageView;
            if (renderSurface2 == flutterImageView) {
                this.renderSurface = renderSurface;
                removeView(flutterImageView);
            }
        }
        this.flutterImageView = null;
        this.previousRenderSurface = null;
        this.flutterEngine = null;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
            getKeyDispatcherState().startTracking(keyEvent, this);
        } else if (keyEvent.getAction() == 1) {
            getKeyDispatcherState().handleUpEvent(keyEvent);
        }
        return (isAttachedToFlutterEngine() && this.keyboardManager.handleEvent(keyEvent)) || super.dispatchKeyEvent(keyEvent);
    }

    public void fallbackRenderSurface() {
        fallbackRenderSurface(REMOVE_SURFACE_VIEW_WHEN_FALLBACK, true, false);
    }

    public void fallbackRenderSurfaceForPlatformView(boolean z) {
        this.hasPlatformView = true;
        fallbackRenderSurface(true, z, false);
    }

    public void fallbackRenderSurfaceSync() {
        fallbackRenderSurface(REMOVE_SURFACE_VIEW_WHEN_FALLBACK, true, true);
    }

    @SuppressLint({"PrivateApi"})
    public View findViewByAccessibilityIdTraversal(int i) {
        if (Build.VERSION.SDK_INT < 29) {
            return findViewByAccessibilityIdRootedAtCurrentView(i, this);
        }
        try {
            Method declaredMethod = View.class.getDeclaredMethod("findViewByAccessibilityIdTraversal", Integer.TYPE);
            declaredMethod.setAccessible(true);
            return (View) declaredMethod.invoke(this, Integer.valueOf(i));
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
            return null;
        }
    }

    @Override // android.view.View
    protected boolean fitSystemWindows(@NonNull Rect rect) {
        if (Build.VERSION.SDK_INT <= 19) {
            FlutterRenderer.ViewportMetrics viewportMetrics = this.viewportMetrics;
            viewportMetrics.viewPaddingTop = rect.top;
            viewportMetrics.viewPaddingRight = rect.right;
            viewportMetrics.viewPaddingBottom = 0;
            viewportMetrics.viewPaddingLeft = rect.left;
            viewportMetrics.viewInsetTop = 0;
            viewportMetrics.viewInsetRight = 0;
            viewportMetrics.viewInsetBottom = rect.bottom;
            viewportMetrics.viewInsetLeft = 0;
            Log.v(TAG, "Updating window insets (fitSystemWindows()):\nStatus bar insets: Top: " + this.viewportMetrics.viewPaddingTop + ", Left: " + this.viewportMetrics.viewPaddingLeft + ", Right: " + this.viewportMetrics.viewPaddingRight + "\nKeyboard insets: Bottom: " + this.viewportMetrics.viewInsetBottom + ", Left: " + this.viewportMetrics.viewInsetLeft + ", Right: " + this.viewportMetrics.viewInsetRight);
            sendViewportMetricsToFlutter();
            return true;
        }
        return super.fitSystemWindows(rect);
    }

    @Override // android.view.View
    @Nullable
    public AccessibilityNodeProvider getAccessibilityNodeProvider() {
        AccessibilityBridge accessibilityBridge = this.accessibilityBridge;
        if (accessibilityBridge == null || !accessibilityBridge.isAccessibilityEnabled()) {
            return null;
        }
        return this.accessibilityBridge;
    }

    @Nullable
    @VisibleForTesting
    public FlutterEngine getAttachedFlutterEngine() {
        return this.flutterEngine;
    }

    @Override // io.flutter.plugin.mouse.MouseCursorPlugin.MouseCursorViewDelegate
    @NonNull
    @RequiresApi(24)
    @TargetApi(24)
    public PointerIcon getSystemPointerIcon(int i) {
        return PointerIcon.getSystemIcon(getContext(), i);
    }

    public boolean hasRenderedFirstFrame() {
        return this.isFlutterUiDisplayed;
    }

    @VisibleForTesting
    public boolean isAttachedToFlutterEngine() {
        FlutterEngine flutterEngine = this.flutterEngine;
        return flutterEngine != null && flutterEngine.getRenderer() == this.renderSurface.getAttachedRenderer();
    }

    public boolean isRenderSurfacePromoted() {
        return this.fallbackRenderSurface != null;
    }

    public boolean isSurfaceAvailableForRendering() {
        RenderSurface renderSurface = this.renderSurface;
        return renderSurface != null && renderSurface.isSurfaceAvailableForRendering();
    }

    @Override // android.view.View
    @NonNull
    @SuppressLint({"InlinedApi", "NewApi"})
    @RequiresApi(20)
    @TargetApi(20)
    public final WindowInsets onApplyWindowInsets(@NonNull WindowInsets windowInsets) {
        WindowInsets onApplyWindowInsets = super.onApplyWindowInsets(windowInsets);
        int i = Build.VERSION.SDK_INT;
        if (i == 29) {
            Insets systemGestureInsets = windowInsets.getSystemGestureInsets();
            FlutterRenderer.ViewportMetrics viewportMetrics = this.viewportMetrics;
            viewportMetrics.systemGestureInsetTop = systemGestureInsets.top;
            viewportMetrics.systemGestureInsetRight = systemGestureInsets.right;
            viewportMetrics.systemGestureInsetBottom = systemGestureInsets.bottom;
            viewportMetrics.systemGestureInsetLeft = systemGestureInsets.left;
        }
        boolean z = (getWindowSystemUiVisibility() & 4) == 0;
        boolean z2 = (getWindowSystemUiVisibility() & 2) == 0;
        if (i >= 30) {
            int navigationBars = z2 ? 0 | WindowInsets.Type.navigationBars() : 0;
            if (z) {
                navigationBars |= WindowInsets.Type.statusBars();
            }
            Insets insets = windowInsets.getInsets(navigationBars);
            FlutterRenderer.ViewportMetrics viewportMetrics2 = this.viewportMetrics;
            viewportMetrics2.viewPaddingTop = insets.top;
            viewportMetrics2.viewPaddingRight = insets.right;
            viewportMetrics2.viewPaddingBottom = insets.bottom;
            viewportMetrics2.viewPaddingLeft = insets.left;
            Insets insets2 = windowInsets.getInsets(WindowInsets.Type.ime());
            FlutterRenderer.ViewportMetrics viewportMetrics3 = this.viewportMetrics;
            viewportMetrics3.viewInsetTop = insets2.top;
            viewportMetrics3.viewInsetRight = insets2.right;
            viewportMetrics3.viewInsetBottom = insets2.bottom;
            viewportMetrics3.viewInsetLeft = insets2.left;
            Insets insets3 = windowInsets.getInsets(WindowInsets.Type.systemGestures());
            FlutterRenderer.ViewportMetrics viewportMetrics4 = this.viewportMetrics;
            viewportMetrics4.systemGestureInsetTop = insets3.top;
            viewportMetrics4.systemGestureInsetRight = insets3.right;
            viewportMetrics4.systemGestureInsetBottom = insets3.bottom;
            viewportMetrics4.systemGestureInsetLeft = insets3.left;
            DisplayCutout displayCutout = windowInsets.getDisplayCutout();
            if (displayCutout != null) {
                Insets waterfallInsets = displayCutout.getWaterfallInsets();
                FlutterRenderer.ViewportMetrics viewportMetrics5 = this.viewportMetrics;
                viewportMetrics5.viewPaddingTop = Math.max(Math.max(viewportMetrics5.viewPaddingTop, waterfallInsets.top), displayCutout.getSafeInsetTop());
                FlutterRenderer.ViewportMetrics viewportMetrics6 = this.viewportMetrics;
                viewportMetrics6.viewPaddingRight = Math.max(Math.max(viewportMetrics6.viewPaddingRight, waterfallInsets.right), displayCutout.getSafeInsetRight());
                FlutterRenderer.ViewportMetrics viewportMetrics7 = this.viewportMetrics;
                viewportMetrics7.viewPaddingBottom = Math.max(Math.max(viewportMetrics7.viewPaddingBottom, waterfallInsets.bottom), displayCutout.getSafeInsetBottom());
                FlutterRenderer.ViewportMetrics viewportMetrics8 = this.viewportMetrics;
                viewportMetrics8.viewPaddingLeft = Math.max(Math.max(viewportMetrics8.viewPaddingLeft, waterfallInsets.left), displayCutout.getSafeInsetLeft());
            }
        } else {
            ZeroSides zeroSides = ZeroSides.NONE;
            if (!z2) {
                zeroSides = calculateShouldZeroSides();
            }
            this.viewportMetrics.viewPaddingTop = z ? windowInsets.getSystemWindowInsetTop() : 0;
            this.viewportMetrics.viewPaddingRight = (zeroSides == ZeroSides.RIGHT || zeroSides == ZeroSides.BOTH) ? 0 : windowInsets.getSystemWindowInsetRight();
            this.viewportMetrics.viewPaddingBottom = (z2 && guessBottomKeyboardInset(windowInsets) == 0) ? windowInsets.getSystemWindowInsetBottom() : 0;
            this.viewportMetrics.viewPaddingLeft = (zeroSides == ZeroSides.LEFT || zeroSides == ZeroSides.BOTH) ? 0 : windowInsets.getSystemWindowInsetLeft();
            FlutterRenderer.ViewportMetrics viewportMetrics9 = this.viewportMetrics;
            viewportMetrics9.viewInsetTop = 0;
            viewportMetrics9.viewInsetRight = 0;
            viewportMetrics9.viewInsetBottom = guessBottomKeyboardInset(windowInsets);
            this.viewportMetrics.viewInsetLeft = 0;
        }
        Log.v(TAG, "Updating window insets (onApplyWindowInsets()):\nStatus bar insets: Top: " + this.viewportMetrics.viewPaddingTop + ", Left: " + this.viewportMetrics.viewPaddingLeft + ", Right: " + this.viewportMetrics.viewPaddingRight + "\nKeyboard insets: Bottom: " + this.viewportMetrics.viewInsetBottom + ", Left: " + this.viewportMetrics.viewInsetLeft + ", Right: " + this.viewportMetrics.viewInsetRight + "System Gesture Insets - Left: " + this.viewportMetrics.systemGestureInsetLeft + ", Top: " + this.viewportMetrics.systemGestureInsetTop + ", Right: " + this.viewportMetrics.systemGestureInsetRight + ", Bottom: " + this.viewportMetrics.viewInsetBottom);
        sendViewportMetricsToFlutter();
        return onApplyWindowInsets;
    }

    @Override // android.view.View
    protected void onConfigurationChanged(@NonNull Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.flutterEngine != null) {
            Log.v(TAG, "Configuration changed. Sending locales and user settings to Flutter.");
            this.localizationPlugin.sendLocalesToFlutter(configuration);
            sendUserSettingsToFlutter();
        }
    }

    @Override // android.view.View
    @Nullable
    public InputConnection onCreateInputConnection(@NonNull EditorInfo editorInfo) {
        if (!isAttachedToFlutterEngine()) {
            return super.onCreateInputConnection(editorInfo);
        }
        return this.textInputPlugin.createInputConnection(this, this.keyboardManager, editorInfo);
    }

    @Override // android.view.View
    public boolean onGenericMotionEvent(@NonNull MotionEvent motionEvent) {
        if (isAttachedToFlutterEngine() && this.androidTouchProcessor.onGenericMotionEvent(motionEvent)) {
            return true;
        }
        return super.onGenericMotionEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean onHoverEvent(@NonNull MotionEvent motionEvent) {
        if (!isAttachedToFlutterEngine()) {
            return super.onHoverEvent(motionEvent);
        }
        return this.accessibilityBridge.onAccessibilityHoverEvent(motionEvent);
    }

    @Override // android.view.View
    public void onProvideAutofillVirtualStructure(ViewStructure viewStructure, int i) {
        super.onProvideAutofillVirtualStructure(viewStructure, i);
        TextInputPlugin textInputPlugin = this.textInputPlugin;
        if (textInputPlugin == null) {
            return;
        }
        textInputPlugin.onProvideAutofillVirtualStructure(viewStructure, i);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        Log.v(TAG, "Size changed. Sending Flutter new viewport metrics. FlutterView was " + i3 + " x " + i4 + ", it is now " + i + " x " + i2);
        FlutterRenderer.ViewportMetrics viewportMetrics = this.viewportMetrics;
        viewportMetrics.width = i;
        viewportMetrics.height = i2;
        sendViewportMetricsToFlutter();
    }

    @Override // android.view.View
    public boolean onTouchEvent(@NonNull MotionEvent motionEvent) {
        if (!isAttachedToFlutterEngine()) {
            return super.onTouchEvent(motionEvent);
        }
        if (Build.VERSION.SDK_INT >= 21) {
            requestUnbufferedDispatch(motionEvent);
        }
        return this.androidTouchProcessor.onTouchEvent(motionEvent);
    }

    public int promoteRenderSurface() {
        removePendingPromoteRenderSurface();
        if (this.flutterEngine == null) {
            Log.e(TAG, "FlutterView.promoteRenderSurface failed - PROMOTE_RENDER_SURFACE_NO_ENGINE");
            return 1;
        }
        RenderSurface renderSurface = this.renderSurface;
        if (renderSurface == null) {
            Log.e(TAG, "FlutterView.promoteRenderSurface failed - PROMOTE_RENDER_SURFACE_NO_SURFACE");
            return 2;
        } else if (this.hasPlatformView) {
            Log.w(TAG, "FlutterView.promoteRenderSurface failed - PROMOTE_RENDER_SURFACE_HAS_PLATFORM_VIEW");
            return 3;
        } else if (this.renderTransparently) {
            Log.w(TAG, "FlutterView.promoteRenderSurface failed - PROMOTE_RENDER_SURFACE_RENDER_TRANSPARENTLY");
            return 4;
        } else if (renderSurface == this.flutterSurfaceView) {
            return 0;
        } else {
            if (!renderSurface.hasContent()) {
                Log.w(TAG, "FlutterView.promoteRenderSurface without content currently");
                addPendingPromoteRenderSurface();
                return 0;
            }
            FlutterJNI.beginSection("FlutterView.PromoteRenderSurface");
            waitFallbackRenderSurfaceDone();
            if (this.flutterSurfaceView == null) {
                FlutterSurfaceView flutterSurfaceView = new FlutterSurfaceView(getContext());
                this.flutterSurfaceView = flutterSurfaceView;
                addView(flutterSurfaceView);
            }
            final FlutterRenderer renderer = this.flutterEngine.getRenderer();
            Runnable runnable = new Runnable() { // from class: tb.po0
                @Override // java.lang.Runnable
                public final void run() {
                    FlutterView.this.lambda$promoteRenderSurface$0(renderer);
                }
            };
            if (this.flutterSurfaceView.hasSurface()) {
                runnable.run();
            } else {
                this.flutterSurfaceView.initForPromote(runnable);
            }
            FlutterJNI.endSection();
            return 0;
        }
    }

    @VisibleForTesting
    public void removeFlutterEngineAttachmentListener(@NonNull FlutterEngineAttachmentListener flutterEngineAttachmentListener) {
        this.flutterEngineAttachmentListeners.remove(flutterEngineAttachmentListener);
    }

    public void removeOnFirstFrameRenderedListener(@NonNull FlutterUiDisplayListener flutterUiDisplayListener) {
        this.flutterUiDisplayListeners.remove(flutterUiDisplayListener);
    }

    public void revertImageView(@NonNull final Runnable runnable) {
        FlutterImageView flutterImageView = this.flutterImageView;
        if (flutterImageView == null) {
            Log.v(TAG, "Tried to revert the image view, but no image view is used.");
            return;
        }
        RenderSurface renderSurface = this.previousRenderSurface;
        if (renderSurface == null) {
            Log.v(TAG, "Tried to revert the image view, but no previous surface was used.");
            return;
        }
        this.renderSurface = renderSurface;
        this.previousRenderSurface = null;
        FlutterEngine flutterEngine = this.flutterEngine;
        if (flutterEngine == null) {
            flutterImageView.detachFromRenderer();
            runnable.run();
            return;
        }
        final FlutterRenderer renderer = flutterEngine.getRenderer();
        if (renderer == null) {
            this.flutterImageView.detachFromRenderer();
            runnable.run();
            return;
        }
        this.renderSurface.attachToRenderer(renderer);
        renderer.addIsDisplayingFlutterUiListener(new FlutterUiDisplayListener() { // from class: io.flutter.embedding.android.FlutterView.3
            @Override // io.flutter.embedding.engine.renderer.FlutterUiDisplayListener
            public void onFlutterUiDisplayed() {
                renderer.removeIsDisplayingFlutterUiListener(this);
                runnable.run();
                if (!(FlutterView.this.renderSurface instanceof FlutterImageView) || ((FlutterImageView) FlutterView.this.renderSurface).isSurfaceKind()) {
                    FlutterView.this.flutterImageView.detachFromRenderer();
                }
            }

            @Override // io.flutter.embedding.engine.renderer.FlutterUiDisplayListener
            public void onFlutterUiNoLongerDisplayed() {
            }
        });
    }

    @VisibleForTesting
    void sendUserSettingsToFlutter() {
        this.flutterEngine.getSettingsChannel().startMessage().setTextScaleFactor(getResources().getConfiguration().fontScale).setUse24HourFormat(DateFormat.is24HourFormat(getContext())).setPlatformBrightness((getResources().getConfiguration().uiMode & 48) == 32 ? SettingsChannel.PlatformBrightness.dark : SettingsChannel.PlatformBrightness.light).send();
    }

    public void setupViewportMetrics(FlutterRenderer.ViewportMetrics viewportMetrics) {
        FlutterRenderer.ViewportMetrics viewportMetrics2 = this.viewportMetrics;
        viewportMetrics2.width = viewportMetrics.width;
        viewportMetrics2.height = viewportMetrics.height;
        viewportMetrics2.viewPaddingTop = viewportMetrics.viewPaddingTop;
        viewportMetrics2.viewPaddingRight = viewportMetrics.viewPaddingRight;
        viewportMetrics2.viewPaddingBottom = viewportMetrics.viewPaddingBottom;
        viewportMetrics2.viewPaddingLeft = viewportMetrics.viewPaddingLeft;
        viewportMetrics2.viewInsetTop = viewportMetrics.viewInsetTop;
        viewportMetrics2.viewInsetRight = viewportMetrics.viewInsetRight;
        viewportMetrics2.viewInsetBottom = viewportMetrics.viewInsetBottom;
        viewportMetrics2.viewInsetLeft = viewportMetrics.viewInsetLeft;
        viewportMetrics2.systemGestureInsetTop = viewportMetrics.systemGestureInsetTop;
        viewportMetrics2.systemGestureInsetRight = viewportMetrics.systemGestureInsetRight;
        viewportMetrics2.systemGestureInsetBottom = viewportMetrics.systemGestureInsetBottom;
        viewportMetrics2.systemGestureInsetLeft = viewportMetrics.systemGestureInsetLeft;
    }

    public void setupViewportSize(int i, int i2) {
        FlutterRenderer.ViewportMetrics viewportMetrics = this.viewportMetrics;
        viewportMetrics.width = i;
        viewportMetrics.height = i2;
    }

    @Deprecated
    public FlutterView(@NonNull Context context, @NonNull RenderMode renderMode) {
        super(context, null);
        this.flutterUiDisplayListeners = new HashSet();
        this.flutterEngineAttachmentListeners = new HashSet();
        this.viewportMetrics = new FlutterRenderer.ViewportMetrics();
        this.onAccessibilityChangeListener = new AccessibilityBridge.OnAccessibilityChangeListener() { // from class: io.flutter.embedding.android.FlutterView.1
            @Override // io.flutter.view.AccessibilityBridge.OnAccessibilityChangeListener
            public void onAccessibilityChanged(boolean z, boolean z2) {
                FlutterView.this.resetWillNotDraw(z, z2);
            }
        };
        this.flutterUiDisplayListener = new FlutterUiDisplayListener() { // from class: io.flutter.embedding.android.FlutterView.2
            @Override // io.flutter.embedding.engine.renderer.FlutterUiDisplayListener
            public void onFlutterUiDisplayed() {
                FlutterView.this.isFlutterUiDisplayed = true;
                for (FlutterUiDisplayListener flutterUiDisplayListener : FlutterView.this.flutterUiDisplayListeners) {
                    flutterUiDisplayListener.onFlutterUiDisplayed();
                }
            }

            @Override // io.flutter.embedding.engine.renderer.FlutterUiDisplayListener
            public void onFlutterUiNoLongerDisplayed() {
                FlutterView.this.isFlutterUiDisplayed = false;
                for (FlutterUiDisplayListener flutterUiDisplayListener : FlutterView.this.flutterUiDisplayListeners) {
                    flutterUiDisplayListener.onFlutterUiNoLongerDisplayed();
                }
            }
        };
        VsyncWaiter.setPreferredRefreshRateAsStartRefreshRate(context);
        RenderMode renderMode2 = RenderMode.image;
        renderMode = (renderMode == renderMode2 || renderMode == RenderMode.texture) ? RenderSurface.Helper.suggestUseImageView() ? renderMode2 : RenderMode.texture : renderMode;
        if (renderMode == RenderMode.surface) {
            FlutterSurfaceView flutterSurfaceView = new FlutterSurfaceView(context);
            this.flutterSurfaceView = flutterSurfaceView;
            this.renderSurface = flutterSurfaceView;
        } else if (renderMode == RenderMode.texture) {
            FlutterTextureView flutterTextureView = new FlutterTextureView(context);
            this.flutterTextureView = flutterTextureView;
            this.renderSurface = flutterTextureView;
        } else if (renderMode == renderMode2) {
            FlutterImageView flutterImageView = new FlutterImageView(context);
            this.flutterImageView = flutterImageView;
            this.renderSurface = flutterImageView;
        } else {
            throw new IllegalArgumentException(String.format("RenderMode not supported with this constructor: %s", renderMode));
        }
        init();
    }

    private void fallbackRenderSurface(final boolean z, boolean z2, boolean z3) {
        RenderSurface renderSurface;
        FlutterSurfaceView flutterSurfaceView;
        removePendingPromoteRenderSurface();
        RenderSurface renderSurface2 = this.renderSurface;
        if (renderSurface2 != null && (renderSurface = this.fallbackRenderSurface) != null && renderSurface2 == (flutterSurfaceView = this.flutterSurfaceView) && !this.waitingFallbackDone) {
            this.renderSurface = renderSurface;
            this.fallbackRenderSurface = null;
            if (this.flutterEngine == null) {
                flutterSurfaceView.detachFromRenderer();
                return;
            }
            FlutterJNI.beginSection("FlutterView.FallbackRenderSurface");
            FlutterRenderer renderer = this.flutterEngine.getRenderer();
            this.waitingFallbackDone = true;
            renderer.setFallbackBehavior(true, z2, z3, new Runnable() { // from class: tb.qo0
                @Override // java.lang.Runnable
                public final void run() {
                    FlutterView.this.lambda$fallbackRenderSurface$1(z);
                }
            });
            this.flutterSurfaceView.hideSurface();
            this.flutterSurfaceView.detachFromRenderer();
            this.renderSurface.attachToRenderer(renderer);
            this.renderSurface.updateAndInvalidate();
            FlutterJNI.endSection();
            return;
        }
        waitFallbackRenderSurfaceDone();
    }

    @Deprecated
    public FlutterView(@NonNull Context context, @NonNull TransparencyMode transparencyMode) {
        this(context, (AttributeSet) null, new FlutterSurfaceView(context, transparencyMode == TransparencyMode.transparent));
    }

    public FlutterView(@NonNull Context context, @NonNull FlutterSurfaceView flutterSurfaceView) {
        this(context, (AttributeSet) null, flutterSurfaceView);
    }

    public FlutterView(@NonNull Context context, @NonNull FlutterTextureView flutterTextureView) {
        this(context, (AttributeSet) null, flutterTextureView);
    }

    @TargetApi(19)
    public FlutterView(@NonNull Context context, @NonNull FlutterImageView flutterImageView) {
        this(context, (AttributeSet) null, flutterImageView);
    }

    public FlutterView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, new FlutterSurfaceView(context));
    }

    @Deprecated
    public FlutterView(@NonNull Context context, @NonNull RenderMode renderMode, @NonNull TransparencyMode transparencyMode) {
        super(context, null);
        this.flutterUiDisplayListeners = new HashSet();
        this.flutterEngineAttachmentListeners = new HashSet();
        this.viewportMetrics = new FlutterRenderer.ViewportMetrics();
        this.onAccessibilityChangeListener = new AccessibilityBridge.OnAccessibilityChangeListener() { // from class: io.flutter.embedding.android.FlutterView.1
            @Override // io.flutter.view.AccessibilityBridge.OnAccessibilityChangeListener
            public void onAccessibilityChanged(boolean z, boolean z2) {
                FlutterView.this.resetWillNotDraw(z, z2);
            }
        };
        this.flutterUiDisplayListener = new FlutterUiDisplayListener() { // from class: io.flutter.embedding.android.FlutterView.2
            @Override // io.flutter.embedding.engine.renderer.FlutterUiDisplayListener
            public void onFlutterUiDisplayed() {
                FlutterView.this.isFlutterUiDisplayed = true;
                for (FlutterUiDisplayListener flutterUiDisplayListener : FlutterView.this.flutterUiDisplayListeners) {
                    flutterUiDisplayListener.onFlutterUiDisplayed();
                }
            }

            @Override // io.flutter.embedding.engine.renderer.FlutterUiDisplayListener
            public void onFlutterUiNoLongerDisplayed() {
                FlutterView.this.isFlutterUiDisplayed = false;
                for (FlutterUiDisplayListener flutterUiDisplayListener : FlutterView.this.flutterUiDisplayListeners) {
                    flutterUiDisplayListener.onFlutterUiNoLongerDisplayed();
                }
            }
        };
        VsyncWaiter.setPreferredRefreshRateAsStartRefreshRate(context);
        RenderMode renderMode2 = RenderMode.image;
        renderMode = (renderMode == renderMode2 || renderMode == RenderMode.texture) ? RenderSurface.Helper.suggestUseImageView() ? renderMode2 : RenderMode.texture : renderMode;
        TransparencyMode transparencyMode2 = TransparencyMode.transparent;
        this.renderTransparently = transparencyMode == transparencyMode2;
        if (renderMode == RenderMode.surface) {
            FlutterSurfaceView flutterSurfaceView = new FlutterSurfaceView(context, transparencyMode == transparencyMode2);
            this.flutterSurfaceView = flutterSurfaceView;
            this.renderSurface = flutterSurfaceView;
        } else if (renderMode == RenderMode.texture) {
            FlutterTextureView flutterTextureView = new FlutterTextureView(context);
            this.flutterTextureView = flutterTextureView;
            this.renderSurface = flutterTextureView;
        } else if (renderMode == renderMode2) {
            FlutterImageView flutterImageView = new FlutterImageView(context);
            this.flutterImageView = flutterImageView;
            this.renderSurface = flutterImageView;
        } else {
            throw new IllegalArgumentException(String.format("RenderMode not supported with this constructor: %s", renderMode));
        }
        init();
    }

    private FlutterView(@NonNull Context context, @Nullable AttributeSet attributeSet, @NonNull FlutterSurfaceView flutterSurfaceView) {
        super(context, attributeSet);
        this.flutterUiDisplayListeners = new HashSet();
        this.flutterEngineAttachmentListeners = new HashSet();
        this.viewportMetrics = new FlutterRenderer.ViewportMetrics();
        this.onAccessibilityChangeListener = new AccessibilityBridge.OnAccessibilityChangeListener() { // from class: io.flutter.embedding.android.FlutterView.1
            @Override // io.flutter.view.AccessibilityBridge.OnAccessibilityChangeListener
            public void onAccessibilityChanged(boolean z, boolean z2) {
                FlutterView.this.resetWillNotDraw(z, z2);
            }
        };
        this.flutterUiDisplayListener = new FlutterUiDisplayListener() { // from class: io.flutter.embedding.android.FlutterView.2
            @Override // io.flutter.embedding.engine.renderer.FlutterUiDisplayListener
            public void onFlutterUiDisplayed() {
                FlutterView.this.isFlutterUiDisplayed = true;
                for (FlutterUiDisplayListener flutterUiDisplayListener : FlutterView.this.flutterUiDisplayListeners) {
                    flutterUiDisplayListener.onFlutterUiDisplayed();
                }
            }

            @Override // io.flutter.embedding.engine.renderer.FlutterUiDisplayListener
            public void onFlutterUiNoLongerDisplayed() {
                FlutterView.this.isFlutterUiDisplayed = false;
                for (FlutterUiDisplayListener flutterUiDisplayListener : FlutterView.this.flutterUiDisplayListeners) {
                    flutterUiDisplayListener.onFlutterUiNoLongerDisplayed();
                }
            }
        };
        this.flutterSurfaceView = flutterSurfaceView;
        this.renderSurface = flutterSurfaceView;
        init();
    }

    private FlutterView(@NonNull Context context, @Nullable AttributeSet attributeSet, @NonNull FlutterTextureView flutterTextureView) {
        super(context, attributeSet);
        this.flutterUiDisplayListeners = new HashSet();
        this.flutterEngineAttachmentListeners = new HashSet();
        this.viewportMetrics = new FlutterRenderer.ViewportMetrics();
        this.onAccessibilityChangeListener = new AccessibilityBridge.OnAccessibilityChangeListener() { // from class: io.flutter.embedding.android.FlutterView.1
            @Override // io.flutter.view.AccessibilityBridge.OnAccessibilityChangeListener
            public void onAccessibilityChanged(boolean z, boolean z2) {
                FlutterView.this.resetWillNotDraw(z, z2);
            }
        };
        this.flutterUiDisplayListener = new FlutterUiDisplayListener() { // from class: io.flutter.embedding.android.FlutterView.2
            @Override // io.flutter.embedding.engine.renderer.FlutterUiDisplayListener
            public void onFlutterUiDisplayed() {
                FlutterView.this.isFlutterUiDisplayed = true;
                for (FlutterUiDisplayListener flutterUiDisplayListener : FlutterView.this.flutterUiDisplayListeners) {
                    flutterUiDisplayListener.onFlutterUiDisplayed();
                }
            }

            @Override // io.flutter.embedding.engine.renderer.FlutterUiDisplayListener
            public void onFlutterUiNoLongerDisplayed() {
                FlutterView.this.isFlutterUiDisplayed = false;
                for (FlutterUiDisplayListener flutterUiDisplayListener : FlutterView.this.flutterUiDisplayListeners) {
                    flutterUiDisplayListener.onFlutterUiNoLongerDisplayed();
                }
            }
        };
        if (RenderSurface.Helper.suggestUseImageView() && flutterTextureView.getClass().isAssignableFrom(FlutterTextureView.class)) {
            FlutterImageView flutterImageView = new FlutterImageView(context);
            this.flutterImageView = flutterImageView;
            this.renderSurface = flutterImageView;
        } else {
            this.flutterTextureView = flutterTextureView;
            this.renderSurface = flutterTextureView;
        }
        init();
    }

    @TargetApi(19)
    private FlutterView(@NonNull Context context, @Nullable AttributeSet attributeSet, @NonNull FlutterImageView flutterImageView) {
        super(context, attributeSet);
        this.flutterUiDisplayListeners = new HashSet();
        this.flutterEngineAttachmentListeners = new HashSet();
        this.viewportMetrics = new FlutterRenderer.ViewportMetrics();
        this.onAccessibilityChangeListener = new AccessibilityBridge.OnAccessibilityChangeListener() { // from class: io.flutter.embedding.android.FlutterView.1
            @Override // io.flutter.view.AccessibilityBridge.OnAccessibilityChangeListener
            public void onAccessibilityChanged(boolean z, boolean z2) {
                FlutterView.this.resetWillNotDraw(z, z2);
            }
        };
        this.flutterUiDisplayListener = new FlutterUiDisplayListener() { // from class: io.flutter.embedding.android.FlutterView.2
            @Override // io.flutter.embedding.engine.renderer.FlutterUiDisplayListener
            public void onFlutterUiDisplayed() {
                FlutterView.this.isFlutterUiDisplayed = true;
                for (FlutterUiDisplayListener flutterUiDisplayListener : FlutterView.this.flutterUiDisplayListeners) {
                    flutterUiDisplayListener.onFlutterUiDisplayed();
                }
            }

            @Override // io.flutter.embedding.engine.renderer.FlutterUiDisplayListener
            public void onFlutterUiNoLongerDisplayed() {
                FlutterView.this.isFlutterUiDisplayed = false;
                for (FlutterUiDisplayListener flutterUiDisplayListener : FlutterView.this.flutterUiDisplayListeners) {
                    flutterUiDisplayListener.onFlutterUiNoLongerDisplayed();
                }
            }
        };
        this.flutterImageView = flutterImageView;
        this.renderSurface = flutterImageView;
        init();
    }
}
