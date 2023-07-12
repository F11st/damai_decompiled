package com.google.vr.ndk.base;

import android.app.PendingIntent;
import android.app.Presentation;
import android.content.Context;
import android.content.res.Configuration;
import android.hardware.display.DisplayManager;
import android.opengl.GLSurfaceView;
import android.os.Build;
import android.os.Looper;
import android.os.SystemClock;
import android.util.Log;
import android.view.Choreographer;
import android.view.Display;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.google.common.logging.nano.Vr$VREvent;
import com.google.vr.cardboard.DisplaySynchronizer;
import com.google.vr.cardboard.EglReadyListener;
import com.google.vr.cardboard.ScanlineRacingRenderer;
import com.google.vr.ndk.base.GvrApi;
import com.google.vr.vrcore.logging.api.IVrCoreLoggingService;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import tb.co;
import tb.ei1;
import tb.ga0;
import tb.sd0;
import tb.wm2;
import tb.zy2;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class GvrLayoutImpl extends FrameLayout {
    private static final int ASYNC_REPROJECTION_FLAGS_UNKNOWN = -1;
    private static final boolean DEBUG = false;
    private static final int EXTERNAL_PRESENTATION_MIN_API = 16;
    private static final int SHOW_RENDERING_VIEWS_DELAY_FOR_FADE = 50;
    private static final String TAG = "GvrLayoutImpl";
    private static PresentationFactory sOptionalPresentationFactory;
    private int asyncReprojectionFlags;
    private boolean autoFadeEnabled;
    private CardboardEmulator cardboardEmulator;
    private SdkDaydreamTouchListener daydreamTouchListener;
    private DaydreamUtilsWrapper daydreamUtils;
    private DisplaySynchronizer displaySynchronizer;
    private sd0 eglFactory;
    private EglReadyListener eglReadyListener;
    private ExtensionManager extensionManager;
    private FadeOverlayView fadeOverlayView;
    private FrameFlushWorkaround frameFlushWorkaround;
    private GvrApi gvrApi;
    private boolean isResumed;
    private PresentationHelper presentationHelper;
    private FrameLayout presentationLayout;
    private View presentationView;
    private ScanlineRacingRenderer scanlineRacingRenderer;
    private AsyncReprojectionSurfaceView scanlineRacingView;
    private ScreenOnManager screenOnManager;
    private final Runnable showRenderingViewsRunnable;
    private boolean stereoModeEnabled;
    private GvrUiLayoutImpl uiLayout;
    private ExternalSurface videoSurface;
    private VrCoreSdkClient vrCoreSdkClient;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public static class AsyncReprojectionSurfaceView extends GvrSurfaceView {
        private ScanlineRacingRenderer scanlineRacingRenderer;

        AsyncReprojectionSurfaceView(Context context) {
            super(context);
        }

        public void setRenderer(ScanlineRacingRenderer scanlineRacingRenderer) {
            this.scanlineRacingRenderer = scanlineRacingRenderer;
            super.setRenderer((GLSurfaceView.Renderer) scanlineRacingRenderer);
        }

        @Override // com.google.vr.ndk.base.GvrSurfaceView, android.view.SurfaceHolder.Callback
        public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            if (!isDetachedFromWindow() && this.scanlineRacingRenderer != null) {
                final CountDownLatch countDownLatch = new CountDownLatch(1);
                queueEvent(new Runnable() { // from class: com.google.vr.ndk.base.GvrLayoutImpl.AsyncReprojectionSurfaceView.1
                    @Override // java.lang.Runnable
                    public void run() {
                        AsyncReprojectionSurfaceView.this.scanlineRacingRenderer.b();
                        countDownLatch.countDown();
                    }
                });
                try {
                    countDownLatch.await();
                } catch (InterruptedException e) {
                    Log.e(GvrLayoutImpl.TAG, "Interrupted during surface destroyed: ", e);
                }
            }
            super.surfaceDestroyed(surfaceHolder);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public static class FrameFlushWorkaround implements Choreographer.FrameCallback {
        private final Choreographer choreographer = Choreographer.getInstance();
        private int framesRemaining;

        @Override // android.view.Choreographer.FrameCallback
        public void doFrame(long j) {
            int i = this.framesRemaining - 1;
            this.framesRemaining = i;
            if (i > 0) {
                this.choreographer.postFrameCallback(this);
            }
        }

        public void onResume() {
            if (this.framesRemaining > 0) {
                this.choreographer.removeFrameCallback(this);
            }
            this.framesRemaining = 5;
            this.choreographer.postFrameCallback(this);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    static class NullExtensionManager implements ExtensionManager {
        private NullExtensionManager() {
        }

        @Override // com.google.vr.ndk.base.ExtensionManager
        public void initialize(ViewGroup viewGroup, GvrApi gvrApi) {
        }

        @Override // com.google.vr.ndk.base.ExtensionManager
        public void onPause() {
        }

        @Override // com.google.vr.ndk.base.ExtensionManager
        public void onResume() {
        }

        @Override // com.google.vr.ndk.base.ExtensionManager
        public void reportTelemetry(IVrCoreLoggingService iVrCoreLoggingService) {
        }

        @Override // com.google.vr.ndk.base.ExtensionManager
        public void shutdown() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public interface PresentationFactory {
        Presentation create(Context context, Display display);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public static class PresentationHelper implements DisplayManager.DisplayListener {
        private final Context context;
        private final DisplayManager displayManager;
        private final DisplaySynchronizer displaySynchronizer;
        private String externalDisplayName;
        private final RelativeLayout.LayoutParams layout = new RelativeLayout.LayoutParams(-1, -1);
        private final List<PresentationListener> listeners = new ArrayList();
        private final FrameLayout originalParent;
        private Presentation presentation;
        private final View view;

        PresentationHelper(Context context, FrameLayout frameLayout, View view, DisplaySynchronizer displaySynchronizer, String str) {
            this.context = context;
            this.originalParent = frameLayout;
            this.view = view;
            this.displaySynchronizer = displaySynchronizer;
            this.externalDisplayName = str;
            this.displayManager = (DisplayManager) context.getSystemService("display");
        }

        private static void detachViewFromParent(View view) {
            ViewGroup viewGroup = (ViewGroup) view.getParent();
            if (viewGroup != null) {
                viewGroup.removeView(view);
            }
        }

        private boolean hasCurrentPresentationExpired() {
            Presentation presentation = this.presentation;
            if (presentation == null) {
                return false;
            }
            return (presentation.isShowing() && this.presentation.getDisplay().isValid()) ? false : true;
        }

        private boolean isValidExternalDisplay(Display display) {
            return display != null && display.isValid() && display.getName().equals(this.externalDisplayName);
        }

        /* JADX WARN: Removed duplicated region for block: B:28:0x008b  */
        /* JADX WARN: Removed duplicated region for block: B:29:0x0090  */
        /* JADX WARN: Removed duplicated region for block: B:32:0x009b  */
        /* JADX WARN: Removed duplicated region for block: B:38:0x00b5  */
        /* JADX WARN: Removed duplicated region for block: B:42:0x00d1 A[ORIG_RETURN, RETURN] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private void setDisplay(android.view.Display r5) {
            /*
                r4 = this;
                android.app.Presentation r0 = r4.presentation
                r1 = 0
                if (r0 == 0) goto La
                android.view.Display r0 = r0.getDisplay()
                goto Lb
            La:
                r0 = r1
            Lb:
                boolean r2 = r4.hasCurrentPresentationExpired()
                if (r2 != 0) goto L18
                boolean r0 = tb.ga0.g(r5, r0)
                if (r0 == 0) goto L18
                return
            L18:
                android.app.Presentation r0 = r4.presentation
                if (r0 == 0) goto L21
                r0.dismiss()
                r4.presentation = r1
            L21:
                android.view.View r2 = r4.view
                detachViewFromParent(r2)
                if (r5 == 0) goto L7d
                com.google.vr.ndk.base.GvrLayoutImpl$PresentationFactory r2 = com.google.vr.ndk.base.GvrLayoutImpl.access$600()
                if (r2 == 0) goto L39
                com.google.vr.ndk.base.GvrLayoutImpl$PresentationFactory r2 = com.google.vr.ndk.base.GvrLayoutImpl.access$600()
                android.content.Context r3 = r4.context
                android.app.Presentation r5 = r2.create(r3, r5)
                goto L41
            L39:
                android.app.Presentation r2 = new android.app.Presentation
                android.content.Context r3 = r4.context
                r2.<init>(r3, r5)
                r5 = r2
            L41:
                r4.presentation = r5
                android.view.View r2 = r4.view
                android.widget.RelativeLayout$LayoutParams r3 = r4.layout
                r5.addContentView(r2, r3)
                android.app.Presentation r5 = r4.presentation     // Catch: android.view.WindowManager.InvalidDisplayException -> L50
                r5.show()     // Catch: android.view.WindowManager.InvalidDisplayException -> L50
                goto L85
            L50:
                r5 = move-exception
                java.lang.String r5 = java.lang.String.valueOf(r5)
                int r2 = r5.length()
                int r2 = r2 + 57
                java.lang.StringBuilder r3 = new java.lang.StringBuilder
                r3.<init>(r2)
                java.lang.String r2 = "Attaching Cardboard View to the external display failed: "
                r3.append(r2)
                r3.append(r5)
                java.lang.String r5 = r3.toString()
                java.lang.String r2 = "GvrLayoutImpl"
                android.util.Log.e(r2, r5)
                android.app.Presentation r5 = r4.presentation
                r5.cancel()
                r4.presentation = r1
                android.view.View r5 = r4.view
                detachViewFromParent(r5)
            L7d:
                android.widget.FrameLayout r5 = r4.originalParent
                android.view.View r1 = r4.view
                r2 = 0
                r5.addView(r1, r2)
            L85:
                com.google.vr.cardboard.DisplaySynchronizer r5 = r4.displaySynchronizer
                android.app.Presentation r1 = r4.presentation
                if (r1 == 0) goto L90
                android.view.Display r1 = r1.getDisplay()
                goto L96
            L90:
                android.content.Context r1 = r4.context
                android.view.Display r1 = tb.ga0.b(r1)
            L96:
                r5.h(r1)
                if (r0 == 0) goto Lb1
                java.util.List<com.google.vr.ndk.base.GvrLayoutImpl$PresentationListener> r5 = r4.listeners
                java.util.Iterator r5 = r5.iterator()
            La1:
                boolean r0 = r5.hasNext()
                if (r0 == 0) goto Lb1
                java.lang.Object r0 = r5.next()
                com.google.vr.ndk.base.GvrLayoutImpl$PresentationListener r0 = (com.google.vr.ndk.base.GvrLayoutImpl.PresentationListener) r0
                r0.onPresentationStopped()
                goto La1
            Lb1:
                android.app.Presentation r5 = r4.presentation
                if (r5 == 0) goto Ld1
                java.util.List<com.google.vr.ndk.base.GvrLayoutImpl$PresentationListener> r5 = r4.listeners
                java.util.Iterator r5 = r5.iterator()
            Lbb:
                boolean r0 = r5.hasNext()
                if (r0 == 0) goto Ld1
                java.lang.Object r0 = r5.next()
                com.google.vr.ndk.base.GvrLayoutImpl$PresentationListener r0 = (com.google.vr.ndk.base.GvrLayoutImpl.PresentationListener) r0
                android.app.Presentation r1 = r4.presentation
                android.view.Display r1 = r1.getDisplay()
                r0.onPresentationStarted(r1)
                goto Lbb
            Ld1:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.vr.ndk.base.GvrLayoutImpl.PresentationHelper.setDisplay(android.view.Display):void");
        }

        public void addListener(PresentationListener presentationListener) {
            if (this.listeners.contains(presentationListener)) {
                return;
            }
            this.listeners.add(presentationListener);
            Presentation presentation = this.presentation;
            if (presentation != null) {
                presentationListener.onPresentationStarted(presentation.getDisplay());
            }
        }

        public boolean isPresenting() {
            Presentation presentation = this.presentation;
            return presentation != null && presentation.isShowing();
        }

        public void onDetachedFromWindow() {
            this.displayManager.unregisterDisplayListener(this);
            setDisplay(null);
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public void onDisplayAdded(int i) {
            Display display = this.displayManager.getDisplay(i);
            if (isValidExternalDisplay(display)) {
                setDisplay(display);
            }
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public void onDisplayChanged(int i) {
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public void onDisplayRemoved(int i) {
            Presentation presentation = this.presentation;
            if (presentation == null || presentation.getDisplay().getDisplayId() != i) {
                return;
            }
            setDisplay(null);
        }

        public void onPause() {
            this.displayManager.unregisterDisplayListener(this);
        }

        public void onResume() {
            String e = ga0.e(this.context);
            this.externalDisplayName = e;
            Display display = null;
            if (e == null) {
                setDisplay(null);
                return;
            }
            this.displayManager.registerDisplayListener(this, null);
            Display[] displays = this.displayManager.getDisplays();
            int length = displays.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                }
                Display display2 = displays[i];
                if (isValidExternalDisplay(display2)) {
                    display = display2;
                    break;
                }
                i++;
            }
            setDisplay(display);
        }

        public void shutdown() {
            this.displayManager.unregisterDisplayListener(this);
            Presentation presentation = this.presentation;
            if (presentation != null) {
                presentation.cancel();
                this.presentation = null;
                for (PresentationListener presentationListener : this.listeners) {
                    presentationListener.onPresentationStopped();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public interface PresentationListener {
        void onPresentationStarted(Display display);

        void onPresentationStopped();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public static class ScreenOnManager implements GvrApi.IdleListener {
        private static final long QUIET_PERIOD_AFTER_RESUME_MILLIS = TimeUnit.SECONDS.toMillis(5);
        private boolean isEnabled = true;
        private boolean isIdle;
        private boolean isResumed;
        private long lastResumeTimeMillis;
        private final View parentView;

        public ScreenOnManager(View view) {
            this.parentView = view;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void updateSetScreenOn() {
            this.parentView.setKeepScreenOn(this.isEnabled && this.isResumed && !this.isIdle);
        }

        @Override // com.google.vr.ndk.base.GvrApi.IdleListener
        public void onIdleChanged(final boolean z) {
            wm2.a(new Runnable() { // from class: com.google.vr.ndk.base.GvrLayoutImpl.ScreenOnManager.2
                @Override // java.lang.Runnable
                public void run() {
                    TraceCompat.beginSection("GvrLayoutImpl.onIdleChanged");
                    try {
                        if (SystemClock.elapsedRealtime() - ScreenOnManager.this.lastResumeTimeMillis >= ScreenOnManager.QUIET_PERIOD_AFTER_RESUME_MILLIS) {
                            boolean z2 = ScreenOnManager.this.isIdle;
                            boolean z3 = z;
                            if (z2 != z3) {
                                StringBuilder sb = new StringBuilder(36);
                                sb.append("Idle status change to isIdle = ");
                                sb.append(z3);
                                Log.d(GvrLayoutImpl.TAG, sb.toString());
                            }
                            ScreenOnManager.this.isIdle = z;
                            ScreenOnManager.this.updateSetScreenOn();
                            return;
                        }
                        boolean z4 = z;
                        StringBuilder sb2 = new StringBuilder(80);
                        sb2.append("Quiet period after onResume() -- ignoring idle status change with isIdle = ");
                        sb2.append(z4);
                        Log.d(GvrLayoutImpl.TAG, sb2.toString());
                    } finally {
                        TraceCompat.endSection();
                    }
                }
            });
        }

        public void onPause() {
            this.isResumed = false;
            updateSetScreenOn();
        }

        public void onResume() {
            this.isResumed = true;
            this.isIdle = false;
            this.lastResumeTimeMillis = SystemClock.elapsedRealtime();
            updateSetScreenOn();
        }

        public void setEnabled(final boolean z) {
            wm2.a(new Runnable() { // from class: com.google.vr.ndk.base.GvrLayoutImpl.ScreenOnManager.1
                @Override // java.lang.Runnable
                public void run() {
                    boolean z2 = ScreenOnManager.this.isEnabled;
                    boolean z3 = z;
                    if (z2 == z3) {
                        return;
                    }
                    ScreenOnManager.this.isEnabled = z3;
                    ScreenOnManager.this.updateSetScreenOn();
                }
            });
        }
    }

    public GvrLayoutImpl(Context context) {
        this(context, new NullExtensionManager());
    }

    private void addScanlineRacingView() {
        if (this.scanlineRacingView != null) {
            return;
        }
        sd0 sd0Var = new sd0();
        this.eglFactory = sd0Var;
        sd0Var.d(true);
        this.eglFactory.e((this.asyncReprojectionFlags & 1) != 0);
        this.eglFactory.a(2);
        AsyncReprojectionSurfaceView asyncReprojectionSurfaceView = new AsyncReprojectionSurfaceView(getContext());
        this.scanlineRacingView = asyncReprojectionSurfaceView;
        asyncReprojectionSurfaceView.setEGLConfigChooser(new ei1());
        this.scanlineRacingView.setZOrderMediaOverlay(true);
        this.scanlineRacingView.setEGLContextFactory(this.eglFactory);
        this.scanlineRacingView.setEGLWindowSurfaceFactory(this.eglFactory);
        if (isContextSharingEnabled()) {
            this.scanlineRacingView.setEglReadyListener(this.eglReadyListener);
        }
        if (!this.stereoModeEnabled) {
            Log.w(TAG, "Disabling stereo mode with async reprojection enabled may not work properly.");
            this.scanlineRacingView.setVisibility(8);
        }
        if (this.scanlineRacingRenderer == null) {
            this.scanlineRacingRenderer = new ScanlineRacingRenderer(this.gvrApi);
        }
        this.scanlineRacingRenderer.e(this.scanlineRacingView);
        this.scanlineRacingView.setRenderer(this.scanlineRacingRenderer);
        this.scanlineRacingView.setSwapMode(1);
        if (!this.isResumed) {
            this.scanlineRacingView.onPause();
        }
        this.presentationLayout.addView(this.scanlineRacingView, 0);
    }

    private void init(ExtensionManager extensionManager) {
        DisplaySynchronizer createDefaultDisplaySynchronizer = GvrApi.createDefaultDisplaySynchronizer(getContext());
        initWithInjectedObjects(new GvrApi(getContext(), createDefaultDisplaySynchronizer), createDefaultDisplaySynchronizer, new EglReadyListener(), null, new DaydreamUtilsWrapper(), extensionManager);
    }

    private void initWithInjectedObjects(GvrApi gvrApi, DisplaySynchronizer displaySynchronizer, EglReadyListener eglReadyListener, FadeOverlayView fadeOverlayView, DaydreamUtilsWrapper daydreamUtilsWrapper, ExtensionManager extensionManager) {
        this.gvrApi = gvrApi;
        if (isContextSharingEnabled()) {
            gvrApi.requestContextSharing(eglReadyListener);
        }
        Runnable runnable = new Runnable() { // from class: com.google.vr.ndk.base.GvrLayoutImpl.2
            @Override // java.lang.Runnable
            public void run() {
                if (GvrLayoutImpl.this.vrCoreSdkClient != null) {
                    GvrLayoutImpl.this.vrCoreSdkClient.onExitingFromVr();
                }
            }
        };
        this.daydreamUtils = daydreamUtilsWrapper;
        this.presentationLayout = new FrameLayout(getContext());
        this.uiLayout = new GvrUiLayoutImpl(getContext(), runnable);
        this.displaySynchronizer = displaySynchronizer;
        this.eglReadyListener = eglReadyListener;
        this.presentationHelper = tryCreatePresentationHelper();
        this.frameFlushWorkaround = new FrameFlushWorkaround();
        boolean z = false;
        addView(this.presentationLayout, 0);
        addView(this.uiLayout.getRoot(), 1);
        updateUiLayout();
        boolean isDaydreamPhone = daydreamUtilsWrapper.isDaydreamPhone(getContext());
        if (isDaydreamPhone) {
            this.daydreamTouchListener = createDaydreamTouchListener();
            this.uiLayout.getRoot().setOnTouchListener(this.daydreamTouchListener);
        }
        int componentDaydreamCompatibility = daydreamUtilsWrapper.getComponentDaydreamCompatibility(getContext());
        boolean z2 = componentDaydreamCompatibility != 1;
        if ((isDaydreamPhone || (componentDaydreamCompatibility == 3)) ? true : true) {
            if (z2) {
                if (getContext() instanceof zy2) {
                    this.autoFadeEnabled = ((zy2) getContext()).a();
                }
                if (fadeOverlayView == null) {
                    fadeOverlayView = new FadeOverlayView(getContext(), this.autoFadeEnabled);
                }
                this.fadeOverlayView = fadeOverlayView;
                addView(fadeOverlayView, 2);
            }
            this.vrCoreSdkClient = createVrCoreSdkClient(getContext(), gvrApi, daydreamUtilsWrapper, this.fadeOverlayView);
        }
        this.screenOnManager = new ScreenOnManager(this);
        if (isDeviceDetectionEnabled()) {
            gvrApi.setIdleListener(this.screenOnManager);
        }
        this.extensionManager = extensionManager;
        if (extensionManager != null) {
            extensionManager.initialize(this, gvrApi);
        }
    }

    private boolean isContextSharingEnabled() {
        Long l;
        GvrApi gvrApi = this.gvrApi;
        if (gvrApi != null) {
            Vr$VREvent.SdkConfigurationParams.AsyncReprojectionConfig asyncReprojectionConfig = gvrApi.getSdkConfigurationParams().asyncReprojectionConfig;
            return (asyncReprojectionConfig == null || (l = asyncReprojectionConfig.flags) == null || (l.longValue() & 16) == 0) ? false : true;
        }
        throw new IllegalStateException("GvrApi must be ready before isContextSharingEnabled is called");
    }

    private boolean isDeviceDetectionEnabled() {
        if (this.gvrApi.getSdkConfigurationParams().useDeviceIdleDetection == null) {
            return false;
        }
        return this.gvrApi.getSdkConfigurationParams().useDeviceIdleDetection.booleanValue();
    }

    static void setPresentationFactory(PresentationFactory presentationFactory) {
        sOptionalPresentationFactory = presentationFactory;
    }

    private PresentationHelper tryCreatePresentationHelper() {
        if (Build.VERSION.SDK_INT <= 16) {
            return null;
        }
        String e = ga0.e(getContext());
        if (e == null) {
            Log.e(TAG, "HDMI display name could not be found, disabling external presentation support");
            return null;
        }
        return new PresentationHelper(getContext(), this, this.presentationLayout, this.displaySynchronizer, e);
    }

    private void updateFadeVisibility() {
        FadeOverlayView fadeOverlayView = this.fadeOverlayView;
        if (fadeOverlayView == null) {
            return;
        }
        if (!this.autoFadeEnabled) {
            if (this.isResumed) {
                fadeOverlayView.onVisible();
                return;
            } else {
                fadeOverlayView.onInvisible();
                return;
            }
        }
        boolean z = getWindowVisibility() == 0;
        if (z && this.isResumed) {
            this.fadeOverlayView.onVisible();
            removeCallbacks(this.showRenderingViewsRunnable);
            postDelayed(this.showRenderingViewsRunnable, 50L);
        } else if (z || this.isResumed) {
        } else {
            this.fadeOverlayView.onInvisible();
            updateRenderingViewsVisibility(4);
            removeCallbacks(this.showRenderingViewsRunnable);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateRenderingViewsVisibility(int i) {
        View view = this.presentationView;
        if (view != null) {
            view.setVisibility(this.stereoModeEnabled ? i : 0);
        }
        AsyncReprojectionSurfaceView asyncReprojectionSurfaceView = this.scanlineRacingView;
        if (asyncReprojectionSurfaceView != null) {
            if (!this.stereoModeEnabled) {
                i = 8;
            }
            asyncReprojectionSurfaceView.setVisibility(i);
        }
    }

    private void updateUiLayout() {
        this.uiLayout.setDaydreamModeEnabled(this.gvrApi.getViewerType() == 1);
    }

    void addPresentationListener(PresentationListener presentationListener) {
        PresentationHelper presentationHelper = this.presentationHelper;
        if (presentationHelper != null) {
            presentationHelper.addListener(presentationListener);
        }
    }

    SdkDaydreamTouchListener createDaydreamTouchListener() {
        return new SdkDaydreamTouchListener(this);
    }

    protected VrCoreSdkClient createVrCoreSdkClient(Context context, GvrApi gvrApi, DaydreamUtilsWrapper daydreamUtilsWrapper, FadeOverlayView fadeOverlayView) {
        return new VrCoreSdkClient(context, gvrApi, co.b(context), daydreamUtilsWrapper, new Runnable() { // from class: com.google.vr.ndk.base.GvrLayoutImpl.4
            @Override // java.lang.Runnable
            public void run() {
                GvrLayoutImpl.this.uiLayout.invokeCloseButtonListener();
            }
        }, fadeOverlayView);
    }

    public boolean enableAsyncReprojection(int i) {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            int i2 = this.asyncReprojectionFlags;
            if (i2 != -1) {
                if ((i2 & i) == i) {
                    StringBuilder sb = new StringBuilder(58);
                    sb.append("Async reprojection already enabled with flags: ");
                    sb.append(i2);
                    Log.d(TAG, sb.toString());
                    return true;
                }
                throw new UnsupportedOperationException("Async reprojection flags cannot be added once initialized.");
            } else if (this.scanlineRacingView != null) {
                return true;
            } else {
                if (this.daydreamUtils.isDaydreamPhone(getContext())) {
                    if (!this.gvrApi.setAsyncReprojectionEnabled(true)) {
                        Log.e(TAG, "Failed to initialize async reprojection, unsupported device.");
                        return false;
                    }
                    this.asyncReprojectionFlags = i;
                    if (!this.gvrApi.usingVrDisplayService()) {
                        addScanlineRacingView();
                    }
                    return true;
                }
                return false;
            }
        }
        throw new IllegalStateException("Async reprojection may only be enabled from the UI thread");
    }

    public boolean enableCardboardTriggerEmulation(Runnable runnable) {
        if (runnable != null) {
            if (this.cardboardEmulator != null) {
                return true;
            }
            if (this.daydreamUtils.isDaydreamPhone(getContext())) {
                this.cardboardEmulator = new CardboardEmulator(getContext(), runnable);
                return true;
            }
            return false;
        }
        throw new IllegalArgumentException("The Cardboard trigger listener must not be null.");
    }

    FadeOverlayView getFadeOverlayView() {
        return this.fadeOverlayView;
    }

    public GvrApi getGvrApi() {
        return this.gvrApi;
    }

    public GvrUiLayoutImpl getUiLayoutImpl() {
        return this.uiLayout;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public VrCoreSdkClient getVrCoreSdkClient() {
        return this.vrCoreSdkClient;
    }

    boolean isPresenting() {
        PresentationHelper presentationHelper;
        return (this.presentationView == null || (presentationHelper = this.presentationHelper) == null || !presentationHelper.isPresenting()) ? false : true;
    }

    public void onBackPressed() {
        this.uiLayout.invokeCloseButtonListener();
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.displaySynchronizer.e();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        PresentationHelper presentationHelper = this.presentationHelper;
        if (presentationHelper != null) {
            presentationHelper.onDetachedFromWindow();
        }
    }

    public void onPause() {
        VrCoreSdkClient vrCoreSdkClient;
        if (this.extensionManager != null && (vrCoreSdkClient = this.vrCoreSdkClient) != null && vrCoreSdkClient.getLoggingService() != null) {
            this.extensionManager.reportTelemetry(this.vrCoreSdkClient.getLoggingService());
        }
        this.gvrApi.pause();
        AsyncReprojectionSurfaceView asyncReprojectionSurfaceView = this.scanlineRacingView;
        if (asyncReprojectionSurfaceView != null) {
            asyncReprojectionSurfaceView.queueEvent(new Runnable() { // from class: com.google.vr.ndk.base.GvrLayoutImpl.3
                @Override // java.lang.Runnable
                public void run() {
                    GvrLayoutImpl.this.scanlineRacingRenderer.c();
                }
            });
            this.scanlineRacingView.onPause();
        }
        PresentationHelper presentationHelper = this.presentationHelper;
        if (presentationHelper != null) {
            presentationHelper.onPause();
        }
        this.displaySynchronizer.f();
        VrCoreSdkClient vrCoreSdkClient2 = this.vrCoreSdkClient;
        if (vrCoreSdkClient2 != null) {
            vrCoreSdkClient2.onPause();
        }
        CardboardEmulator cardboardEmulator = this.cardboardEmulator;
        if (cardboardEmulator != null) {
            cardboardEmulator.onPause();
        }
        ExtensionManager extensionManager = this.extensionManager;
        if (extensionManager != null) {
            extensionManager.onPause();
        }
        this.screenOnManager.onPause();
        this.isResumed = false;
        updateFadeVisibility();
    }

    public void onResume() {
        this.gvrApi.resume();
        SdkDaydreamTouchListener sdkDaydreamTouchListener = this.daydreamTouchListener;
        if (sdkDaydreamTouchListener != null) {
            sdkDaydreamTouchListener.refreshViewerProfile();
        }
        this.displaySynchronizer.g();
        PresentationHelper presentationHelper = this.presentationHelper;
        if (presentationHelper != null) {
            presentationHelper.onResume();
        }
        AsyncReprojectionSurfaceView asyncReprojectionSurfaceView = this.scanlineRacingView;
        if (asyncReprojectionSurfaceView != null) {
            asyncReprojectionSurfaceView.onResume();
        }
        VrCoreSdkClient vrCoreSdkClient = this.vrCoreSdkClient;
        if (vrCoreSdkClient != null) {
            vrCoreSdkClient.onResume();
        }
        if (this.cardboardEmulator != null && this.gvrApi.getViewerType() == 1) {
            this.cardboardEmulator.onResume();
        }
        ExtensionManager extensionManager = this.extensionManager;
        if (extensionManager != null) {
            extensionManager.onResume();
        }
        this.screenOnManager.onResume();
        this.frameFlushWorkaround.onResume();
        this.isResumed = true;
        updateFadeVisibility();
        updateUiLayout();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.presentationView != null && isPresenting() && this.presentationView.dispatchTouchEvent(motionEvent)) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        updateFadeVisibility();
    }

    public void setPresentationView(View view) {
        View view2 = this.presentationView;
        if (view2 != null) {
            this.presentationLayout.removeView(view2);
        }
        this.presentationLayout.addView(view, 0);
        this.presentationView = view;
    }

    public void setReentryIntent(PendingIntent pendingIntent) {
        VrCoreSdkClient vrCoreSdkClient = this.vrCoreSdkClient;
        if (vrCoreSdkClient != null) {
            vrCoreSdkClient.setReentryIntent(pendingIntent);
        }
    }

    public void setStereoModeEnabled(boolean z) {
        if (this.stereoModeEnabled == z) {
            return;
        }
        this.stereoModeEnabled = z;
        this.uiLayout.setEnabled(z);
        VrCoreSdkClient vrCoreSdkClient = this.vrCoreSdkClient;
        if (vrCoreSdkClient != null) {
            vrCoreSdkClient.setEnabled(z);
        }
        FadeOverlayView fadeOverlayView = this.fadeOverlayView;
        if (fadeOverlayView != null) {
            fadeOverlayView.setEnabled(z);
        }
        SdkDaydreamTouchListener sdkDaydreamTouchListener = this.daydreamTouchListener;
        if (sdkDaydreamTouchListener != null) {
            sdkDaydreamTouchListener.setEnabled(z);
        }
        this.screenOnManager.setEnabled(z);
        updateRenderingViewsVisibility(0);
    }

    public void shutdown() {
        this.displaySynchronizer.i();
        SdkDaydreamTouchListener sdkDaydreamTouchListener = this.daydreamTouchListener;
        if (sdkDaydreamTouchListener != null) {
            sdkDaydreamTouchListener.shutdown();
        }
        removeView(this.presentationLayout);
        removeView(this.uiLayout.getRoot());
        this.scanlineRacingRenderer = null;
        ExternalSurface externalSurface = this.videoSurface;
        if (externalSurface != null) {
            externalSurface.shutdown();
            this.videoSurface = null;
        }
        this.scanlineRacingView = null;
        this.presentationView = null;
        PresentationHelper presentationHelper = this.presentationHelper;
        if (presentationHelper != null) {
            presentationHelper.shutdown();
            this.presentationHelper = null;
        }
        VrCoreSdkClient vrCoreSdkClient = this.vrCoreSdkClient;
        if (vrCoreSdkClient != null) {
            vrCoreSdkClient.onPause();
            this.vrCoreSdkClient = null;
        }
        CardboardEmulator cardboardEmulator = this.cardboardEmulator;
        if (cardboardEmulator != null) {
            cardboardEmulator.onPause();
            this.cardboardEmulator = null;
        }
        ExtensionManager extensionManager = this.extensionManager;
        if (extensionManager != null) {
            extensionManager.shutdown();
            this.extensionManager = null;
        }
        GvrApi gvrApi = this.gvrApi;
        if (gvrApi != null) {
            gvrApi.shutdown();
            this.gvrApi = null;
        }
    }

    public GvrLayoutImpl(Context context, ExtensionManager extensionManager) {
        super(context);
        this.asyncReprojectionFlags = -1;
        this.autoFadeEnabled = true;
        this.isResumed = false;
        this.stereoModeEnabled = true;
        this.showRenderingViewsRunnable = new Runnable() { // from class: com.google.vr.ndk.base.GvrLayoutImpl.1
            @Override // java.lang.Runnable
            public void run() {
                GvrLayoutImpl.this.updateRenderingViewsVisibility(0);
            }
        };
        if (!(context instanceof zy2) && co.a(context) == null) {
            throw new IllegalArgumentException("An Activity Context is required for VR functionality.");
        }
        init(extensionManager);
    }

    GvrLayoutImpl(Context context, GvrApi gvrApi, DisplaySynchronizer displaySynchronizer, EglReadyListener eglReadyListener, FadeOverlayView fadeOverlayView, DaydreamUtilsWrapper daydreamUtilsWrapper, ExtensionManager extensionManager) {
        super(context);
        this.asyncReprojectionFlags = -1;
        this.autoFadeEnabled = true;
        this.isResumed = false;
        this.stereoModeEnabled = true;
        this.showRenderingViewsRunnable = new Runnable() { // from class: com.google.vr.ndk.base.GvrLayoutImpl.1
            @Override // java.lang.Runnable
            public void run() {
                GvrLayoutImpl.this.updateRenderingViewsVisibility(0);
            }
        };
        initWithInjectedObjects(gvrApi, displaySynchronizer, eglReadyListener, fadeOverlayView, daydreamUtilsWrapper, extensionManager);
    }
}
