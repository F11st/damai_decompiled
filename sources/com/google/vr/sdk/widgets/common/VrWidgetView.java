package com.google.vr.sdk.widgets.common;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.google.vr.cardboard.UiLayer;
import com.google.vr.cardboard.VrParamsProvider;
import com.google.vr.sdk.proto.nano.CardboardDevice;
import com.google.vr.sdk.widgets.common.TouchTracker;
import com.google.vr.sdk.widgets.common.VrWidgetRenderer;
import com.google.vr.widgets.common.R$id;
import com.google.vr.widgets.common.R$layout;
import com.youku.live.dago.liveplayback.widget.plugins.resize.AntiShakeOrientationEventListener;
import tb.C9201h5;
import tb.C9796v;
import tb.az2;
import tb.n62;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public abstract class VrWidgetView extends FrameLayout {
    private static final boolean DEBUG = false;
    private static final int DEFAULT_DISPLAY_MODE = 1;
    private static final float METERS_PER_INCH = 0.0254f;
    private static final String STATE_KEY_DISPLAY_MODE = "displayMode";
    private static final String STATE_KEY_ORIENTATION_HELPER = "orientationHelperState";
    private static final String STATE_KEY_SUPER_CLASS = "superClassState";
    private static final String STATE_KEY_WIDGET_RENDERER = "widgetRendererState";
    private Activity activity;
    private DisplayMetrics displayMetrics;
    private int displayMode;
    private ImageButton enterFullscreenButton;
    private ImageButton enterStereoModeButton;
    private VrEventListener eventListener;
    private FullScreenDialog fullScreenDialog;
    private ImageButton fullscreenBackButton;
    private ImageButton infoButton;
    private ViewGroup innerWidgetView;
    private boolean isFullscreenButtonEnabled;
    private boolean isInfoButtonEnabled;
    private boolean isPaused;
    private boolean isPureTouchTrackingEnabled;
    private boolean isStereoModeButtonEnabled;
    private boolean isTouchTrackingEnabled;
    private boolean isTransitionViewEnabled;
    private OrientationHelper orientationHelper;
    private VrWidgetRenderer renderer;
    private GLSurfaceView renderingView;
    private n62 screenOnFlagHelper;
    private TrackingSensorsHelper sensorsHelper;
    private TouchTracker touchTracker;
    private View uiView;
    private ViewRotator viewRotator;
    private VrParamsProvider viewerParamsProvider;
    UiLayer vrUiLayer;
    private static final String TAG = VrWidgetView.class.getSimpleName();
    private static final Uri INFO_BUTTON_URL = Uri.parse("https://g.co/vr/view");

    public VrWidgetView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.eventListener = new VrEventListener();
        if (isInEditMode()) {
            return;
        }
        checkContextIsActivity(context);
        init();
    }

    private void checkContextIsActivity(Context context) {
        if (context instanceof Activity) {
            this.activity = (Activity) context;
            return;
        }
        throw new RuntimeException("Context must be an instance of activity");
    }

    static Intent getInfoButtonIntent() {
        return new Intent("android.intent.action.VIEW", INFO_BUTTON_URL);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int getScreenRotationInDegrees(int i) {
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    return 0;
                }
                return AntiShakeOrientationEventListener.SCREEN_ORIENTATION_LANDSCAPE;
            }
            return 180;
        }
        return 90;
    }

    private void init() {
        this.displayMode = 1;
        this.viewerParamsProvider = az2.a(getContext());
        TrackingSensorsHelper trackingSensorsHelper = new TrackingSensorsHelper(getContext().getPackageManager());
        this.sensorsHelper = trackingSensorsHelper;
        this.isStereoModeButtonEnabled = trackingSensorsHelper.areTrackingSensorsAvailable() || this.sensorsHelper.showStereoModeButtonForTesting();
        this.isFullscreenButtonEnabled = true;
        this.isInfoButtonEnabled = true;
        this.isTouchTrackingEnabled = true;
        this.isTransitionViewEnabled = true;
        this.screenOnFlagHelper = new n62(this.activity);
        Display defaultDisplay = ((WindowManager) getContext().getSystemService(C9796v.ATTACH_MODE_WINDOW)).getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        this.displayMetrics = displayMetrics;
        com.alibaba.wireless.security.aopsdk.replace.android.view.Display.getRealMetrics(defaultDisplay, displayMetrics);
        initializeRenderingView();
        FrameLayout frameLayout = new FrameLayout(getContext());
        this.innerWidgetView = frameLayout;
        frameLayout.setId(R$id.vrwidget_inner_view);
        this.innerWidgetView.addView(this.renderingView);
        setPadding(0, 0, 0, 0);
        addView(this.innerWidgetView);
        this.orientationHelper = new OrientationHelper(this.activity);
        FullScreenDialog fullScreenDialog = new FullScreenDialog(getContext(), this.innerWidgetView, this.renderer);
        this.fullScreenDialog = fullScreenDialog;
        fullScreenDialog.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.google.vr.sdk.widgets.common.VrWidgetView.1
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                VrWidgetView.this.setDisplayMode(1);
            }
        });
        this.uiView = FrameLayout.inflate(getContext(), R$layout.ui_view_embed, null);
        this.viewRotator = new ViewRotator(getContext(), this.uiView, getScreenRotationInDegrees(defaultDisplay.getRotation()), this.sensorsHelper.areTrackingSensorsAvailable());
        this.innerWidgetView.addView(this.uiView);
        this.innerWidgetView.addView(new View(getContext()));
        UiLayer uiLayer = new UiLayer(getContext());
        this.vrUiLayer = uiLayer;
        uiLayer.v(true);
        this.vrUiLayer.u(true);
        this.innerWidgetView.addView(this.vrUiLayer.o());
        updateTouchTracker();
        initializeUiButtons();
    }

    private void initializeRenderingView() {
        GLSurfaceView gLSurfaceView = new GLSurfaceView(getContext());
        this.renderingView = gLSurfaceView;
        gLSurfaceView.setEGLContextClientVersion(2);
        this.renderingView.setEGLConfigChooser(8, 8, 8, 8, 16, 8);
        this.renderingView.setPreserveEGLContextOnPause(true);
        DisplayMetrics displayMetrics = this.displayMetrics;
        float f = METERS_PER_INCH / displayMetrics.xdpi;
        float f2 = METERS_PER_INCH / displayMetrics.ydpi;
        VrWidgetRenderer createRenderer = createRenderer(getContext(), new VrWidgetRenderer.GLThreadScheduler() { // from class: com.google.vr.sdk.widgets.common.VrWidgetView.3
            @Override // com.google.vr.sdk.widgets.common.VrWidgetRenderer.GLThreadScheduler
            public void queueGlThreadEvent(Runnable runnable) {
                VrWidgetView.this.renderingView.queueEvent(runnable);
            }
        }, f, f2);
        this.renderer = createRenderer;
        this.renderingView.setRenderer(createRenderer);
    }

    private void initializeUiButtons() {
        ImageButton imageButton = (ImageButton) this.uiView.findViewById(R$id.fullscreen_button);
        this.enterFullscreenButton = imageButton;
        imageButton.setOnClickListener(new View.OnClickListener() { // from class: com.google.vr.sdk.widgets.common.VrWidgetView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VrWidgetView.this.setDisplayMode(2);
            }
        });
        ImageButton imageButton2 = (ImageButton) this.uiView.findViewById(R$id.vr_mode_button);
        this.enterStereoModeButton = imageButton2;
        imageButton2.setOnClickListener(new View.OnClickListener() { // from class: com.google.vr.sdk.widgets.common.VrWidgetView.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VrWidgetView.this.setDisplayMode(3);
            }
        });
        ImageButton imageButton3 = (ImageButton) this.uiView.findViewById(R$id.fullscreen_back_button);
        this.fullscreenBackButton = imageButton3;
        imageButton3.setOnClickListener(new View.OnClickListener() { // from class: com.google.vr.sdk.widgets.common.VrWidgetView.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VrWidgetView.this.setDisplayMode(1);
            }
        });
        ImageButton imageButton4 = (ImageButton) this.uiView.findViewById(R$id.info_button);
        this.infoButton = imageButton4;
        imageButton4.setOnClickListener(new View.OnClickListener() { // from class: com.google.vr.sdk.widgets.common.VrWidgetView.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VrWidgetView.this.activity.startActivity(VrWidgetView.getInfoButtonIntent());
            }
        });
        updateButtonVisibility();
    }

    private boolean isFullScreen() {
        int i = this.displayMode;
        return i == 2 || i == 3;
    }

    private void updateButtonVisibility() {
        int i = 8;
        if (this.isFullscreenButtonEnabled && this.displayMode != 2) {
            this.enterFullscreenButton.setVisibility(0);
        } else {
            this.enterFullscreenButton.setVisibility(8);
        }
        if (this.isStereoModeButtonEnabled && this.displayMode != 3) {
            this.enterStereoModeButton.setVisibility(0);
        } else {
            this.enterStereoModeButton.setVisibility(8);
        }
        boolean z = true;
        this.vrUiLayer.w(this.displayMode == 3);
        this.vrUiLayer.r(this.displayMode == 3);
        this.vrUiLayer.y((this.displayMode == 3 && this.isTransitionViewEnabled) ? false : false);
        if (!isFullScreen()) {
            this.fullscreenBackButton.setVisibility(8);
            this.vrUiLayer.t(null);
        } else if (this.displayMode == 3) {
            this.fullscreenBackButton.setVisibility(8);
            this.vrUiLayer.t(new Runnable() { // from class: com.google.vr.sdk.widgets.common.VrWidgetView.8
                @Override // java.lang.Runnable
                public void run() {
                    VrWidgetView.this.setDisplayMode(1);
                }
            });
        } else {
            this.fullscreenBackButton.setVisibility(0);
            this.vrUiLayer.t(null);
        }
        ImageButton imageButton = this.infoButton;
        if (this.isInfoButtonEnabled && this.displayMode != 3) {
            i = 0;
        }
        imageButton.setVisibility(i);
    }

    private void updateControlsLayout() {
        LinearLayout linearLayout = (LinearLayout) this.innerWidgetView.findViewById(R$id.control_layout);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) linearLayout.getLayoutParams();
        if (this.displayMode == 3 && this.orientationHelper.isInPortraitOrientation()) {
            layoutParams.addRule(9);
            layoutParams.addRule(11, 0);
        } else {
            layoutParams.addRule(9, 0);
            layoutParams.addRule(11);
        }
        linearLayout.setLayoutParams(layoutParams);
        if (this.displayMode == 2) {
            this.viewRotator.enable();
        } else {
            this.viewRotator.disable();
        }
    }

    private void updateStereoMode() {
        this.renderer.setStereoMode(this.displayMode == 3);
        C9201h5.i(this.activity, this.displayMode == 3, 0);
        if (this.displayMode == 3) {
            this.screenOnFlagHelper.b();
        } else {
            this.screenOnFlagHelper.c();
        }
        updateButtonVisibility();
        updateViewerName();
    }

    private void updateTouchTracker() {
        if (this.touchTracker == null) {
            TouchTracker touchTracker = new TouchTracker(getContext(), this, new TouchTracker.TouchEnabledVrView() { // from class: com.google.vr.sdk.widgets.common.VrWidgetView.2
                @Override // com.google.vr.sdk.widgets.common.TouchTracker.TouchEnabledVrView
                public VrEventListener getEventListener() {
                    return VrWidgetView.this.eventListener;
                }

                @Override // com.google.vr.sdk.widgets.common.TouchTracker.TouchEnabledVrView
                public void onPanningEvent(float f, float f2) {
                    VrWidgetView.this.renderer.onPanningEvent(f, f2);
                }
            });
            this.touchTracker = touchTracker;
            setOnTouchListener(touchTracker);
        }
        boolean z = true;
        this.touchTracker.setTouchTrackingEnabled(this.isTouchTrackingEnabled && this.displayMode != 3);
        TouchTracker touchTracker2 = this.touchTracker;
        if (!isFullScreen() && !this.isPureTouchTrackingEnabled) {
            z = false;
        }
        touchTracker2.setVerticalTrackingEnabled(z);
    }

    private void updateViewerName() {
        CardboardDevice.DeviceParams readDeviceParams = this.viewerParamsProvider.readDeviceParams();
        this.vrUiLayer.A(readDeviceParams == null ? null : readDeviceParams.getModel());
    }

    protected abstract VrWidgetRenderer createRenderer(Context context, VrWidgetRenderer.GLThreadScheduler gLThreadScheduler, float f, float f2);

    public int getDisplayMode() {
        return this.displayMode;
    }

    public void getHeadRotation(float[] fArr) {
        if (fArr.length >= 2) {
            this.renderer.getHeadRotation(fArr);
            return;
        }
        throw new IllegalArgumentException("Array should have at least 2 elements.");
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        this.renderer.onViewDetach();
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            this.orientationHelper.onRestoreInstanceState(bundle.getBundle(STATE_KEY_ORIENTATION_HELPER));
            this.renderer.onRestoreInstanceState(bundle.getBundle(STATE_KEY_WIDGET_RENDERER));
            this.displayMode = bundle.getInt(STATE_KEY_DISPLAY_MODE);
            parcelable = bundle.getParcelable(STATE_KEY_SUPER_CLASS);
        }
        super.onRestoreInstanceState(parcelable);
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putParcelable(STATE_KEY_SUPER_CLASS, super.onSaveInstanceState());
        bundle.putBundle(STATE_KEY_ORIENTATION_HELPER, this.orientationHelper.onSaveInstanceState());
        bundle.putBundle(STATE_KEY_WIDGET_RENDERER, this.renderer.onSaveInstanceState());
        bundle.putInt(STATE_KEY_DISPLAY_MODE, this.displayMode);
        return bundle;
    }

    public void pauseRendering() {
        this.renderingView.onPause();
        this.renderer.onPause();
        this.screenOnFlagHelper.c();
        this.isPaused = true;
        this.viewRotator.disable();
    }

    public void resumeRendering() {
        this.renderingView.onResume();
        this.renderer.onResume();
        updateStereoMode();
        if (isFullScreen()) {
            this.fullScreenDialog.show();
        }
        updateButtonVisibility();
        updateControlsLayout();
        this.isPaused = false;
    }

    public void setDisplayMode(int i) {
        if (i == this.displayMode) {
            return;
        }
        this.renderer.updateCurrentYaw();
        if (i <= 0 || i >= 4) {
            String str = TAG;
            StringBuilder sb = new StringBuilder(38);
            sb.append("Invalid DisplayMode value: ");
            sb.append(i);
            Log.e(str, sb.toString());
            i = 1;
        }
        this.displayMode = i;
        updateStereoMode();
        if (isFullScreen()) {
            this.orientationHelper.lockOrientation();
            this.fullScreenDialog.show();
        } else {
            this.fullScreenDialog.dismiss();
            this.orientationHelper.restoreOriginalOrientation();
        }
        updateControlsLayout();
        updateTouchTracker();
        this.eventListener.onDisplayModeChanged(this.displayMode);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setEventListener(VrEventListener vrEventListener) {
        this.eventListener = vrEventListener;
    }

    public void setFlingingEnabled(boolean z) {
        this.touchTracker.setFlingingEnabled(z);
    }

    public void setFullscreenButtonEnabled(boolean z) {
        this.isFullscreenButtonEnabled = z;
        updateButtonVisibility();
    }

    public void setInfoButtonEnabled(boolean z) {
        this.isInfoButtonEnabled = z;
        updateButtonVisibility();
    }

    @Override // android.view.View
    public void setOnTouchListener(View.OnTouchListener onTouchListener) {
        this.innerWidgetView.setOnTouchListener(onTouchListener);
    }

    public void setPureTouchTracking(boolean z) {
        this.isPureTouchTrackingEnabled = z;
        updateTouchTracker();
        this.renderer.setPureTouchTracking(z);
    }

    public void setStereoModeButtonEnabled(boolean z) {
        boolean areTrackingSensorsAvailable = this.sensorsHelper.areTrackingSensorsAvailable();
        if (z && !areTrackingSensorsAvailable) {
            Log.w(TAG, "This phone doesn't have the necessary sensors for head tracking, stereo Mode button will be disabled.");
        }
        this.isStereoModeButtonEnabled = z && areTrackingSensorsAvailable;
        updateButtonVisibility();
    }

    public void setTouchTrackingEnabled(boolean z) {
        if (this.isTouchTrackingEnabled == z) {
            return;
        }
        this.isTouchTrackingEnabled = z;
        updateTouchTracker();
    }

    public void setTransitionViewEnabled(boolean z) {
        this.isTransitionViewEnabled = z;
        updateButtonVisibility();
    }

    public void shutdown() {
        if (this.isPaused) {
            this.viewerParamsProvider.close();
            this.renderer.shutdown();
            return;
        }
        throw new IllegalStateException("pauseRendering() must be called before calling shutdown().");
    }

    public VrWidgetView(Context context) {
        super(context);
        this.eventListener = new VrEventListener();
        checkContextIsActivity(context);
        init();
    }
}
