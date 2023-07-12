package com.google.vr.cardboard;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.OrientationEventListener;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import com.autonavi.amap.mapcore.AMapEngineUtils;
import tb.ht2;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class TransitionView extends FrameLayout implements View.OnTouchListener {
    public static final int ALREADY_LANDSCAPE_LEFT_TRANSITION_DELAY_MS = 2000;
    private static final int LANDSCAPE_TOLERANCE_DEGREES = 5;
    private static final int PORTRAIT_TOLERANCE_DEGREES = 45;
    public static final int TRANSITION_ANIMATION_DURATION_MS = 500;
    public static final int TRANSITION_BACKGROUND_COLOR = -12232092;
    private static final int VIEW_CORRECTION_ROTATION_DEGREES = 90;
    private ImageButton backButton;
    private Runnable backButtonListener;
    private int orientation;
    private OrientationEventListener orientationEventListener;
    private boolean rotationChecked;
    private Runnable transitionListener;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.google.vr.cardboard.TransitionView$a */
    /* loaded from: classes10.dex */
    public class View$OnClickListenerC5425a implements View.OnClickListener {
        View$OnClickListenerC5425a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ht2.b(TransitionView.this.getContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.google.vr.cardboard.TransitionView$b */
    /* loaded from: classes10.dex */
    public class View$OnClickListenerC5426b implements View.OnClickListener {
        View$OnClickListenerC5426b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TransitionView.this.fadeOutAndRemove(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.google.vr.cardboard.TransitionView$c */
    /* loaded from: classes10.dex */
    public class C5427c extends OrientationEventListener {
        C5427c(Context context) {
            super(context);
        }

        @Override // android.view.OrientationEventListener
        public void onOrientationChanged(int i) {
            TransitionView.this.orientation = i;
            if (!TransitionView.this.rotationChecked) {
                TransitionView.this.rotateViewIfNeeded();
            } else if (TransitionView.isLandscapeLeft(i)) {
                TransitionView.this.fadeOutAndRemove(false);
            } else {
                TransitionView.isLandscapeRight(i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.google.vr.cardboard.TransitionView$d  reason: invalid class name */
    /* loaded from: classes10.dex */
    public class animationAnimation$AnimationListenerC5428d implements Animation.AnimationListener {
        animationAnimation$AnimationListenerC5428d() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            TransitionView.this.setVisibility(8);
            ((ViewGroup) TransitionView.this.getParent()).removeView(TransitionView.this);
            if (TransitionView.this.transitionListener != null) {
                TransitionView.this.transitionListener.run();
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.google.vr.cardboard.TransitionView$e */
    /* loaded from: classes10.dex */
    public class View$OnClickListenerC5429e implements View.OnClickListener {
        View$OnClickListenerC5429e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TransitionView.this.backButtonListener.run();
        }
    }

    public TransitionView(Context context) {
        super(context);
        this.orientation = -1;
        setOnTouchListener(this);
        setBackground(new ColorDrawable(TRANSITION_BACKGROUND_COLOR));
        inflateContentView(R$layout.transition_view);
        super.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fadeOutAndRemove(boolean z) {
        stopOrientationMonitor();
        Animation animation = getAnimation();
        if (animation != null) {
            if (z || animation.getStartOffset() == 0) {
                return;
            }
            animation.setAnimationListener(null);
            clearAnimation();
        }
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setInterpolator(new AccelerateInterpolator());
        alphaAnimation.setRepeatCount(0);
        alphaAnimation.setDuration(500L);
        if (z) {
            alphaAnimation.setStartOffset(2000L);
        }
        alphaAnimation.setAnimationListener(new animationAnimation$AnimationListenerC5428d());
        startAnimation(alphaAnimation);
    }

    private void inflateContentView(int i) {
        removeAllViews();
        LayoutInflater.from(getContext()).inflate(i, (ViewGroup) this, true);
        findViewById(R$id.transition_switch_action).setOnClickListener(new View$OnClickListenerC5425a());
        ((ImageView) findViewById(R$id.transition_icon)).setOnClickListener(new View$OnClickListenerC5426b());
        updateBackButtonVisibility();
        if (getResources().getConfiguration().orientation == 2) {
            findViewById(R$id.transition_bottom_frame).setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean isLandscapeLeft(int i) {
        return Math.abs(i + (-270)) < 5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean isLandscapeRight(int i) {
        return Math.abs(i + (-90)) < 5;
    }

    private static boolean isPortrait(int i) {
        return Math.abs(i + AMapEngineUtils.MIN_LONGITUDE_DEGREE) > 135;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rotateViewIfNeeded() {
        if (getWidth() <= 0 || getHeight() <= 0 || this.orientation == -1 || this.orientationEventListener == null || this.rotationChecked) {
            return;
        }
        boolean z = getWidth() < getHeight();
        boolean isPortrait = isPortrait(this.orientation);
        if (z != isPortrait) {
            View findViewById = findViewById(R$id.transition_frame);
            int width = findViewById.getWidth();
            int height = findViewById.getHeight();
            if (Build.VERSION.SDK_INT >= 17 && getLayoutDirection() == 1) {
                findViewById.setPivotX(height - findViewById.getPivotX());
                findViewById.setPivotY(width - findViewById.getPivotY());
            }
            if (z) {
                findViewById.setRotation(90.0f);
            } else {
                findViewById.setRotation(-90.0f);
            }
            findViewById.setTranslationX((width - height) / 2);
            findViewById.setTranslationY((height - width) / 2);
            ViewGroup.LayoutParams layoutParams = findViewById.getLayoutParams();
            layoutParams.height = width;
            layoutParams.width = height;
            findViewById.requestLayout();
        }
        if (!isPortrait) {
            findViewById(R$id.transition_bottom_frame).setVisibility(8);
        } else {
            findViewById(R$id.transition_bottom_frame).setVisibility(0);
        }
        this.rotationChecked = true;
        if (isLandscapeLeft(this.orientation)) {
            fadeOutAndRemove(true);
        }
    }

    private void startOrientationMonitor() {
        if (this.orientationEventListener != null) {
            return;
        }
        C5427c c5427c = new C5427c(getContext());
        this.orientationEventListener = c5427c;
        c5427c.enable();
    }

    private void stopOrientationMonitor() {
        OrientationEventListener orientationEventListener = this.orientationEventListener;
        if (orientationEventListener == null) {
            return;
        }
        this.orientation = -1;
        orientationEventListener.disable();
        this.orientationEventListener = null;
    }

    private void updateBackButtonVisibility() {
        ImageButton imageButton = (ImageButton) ((ViewGroup) findViewById(R$id.transition_frame)).findViewById(R$id.back_button);
        this.backButton = imageButton;
        Runnable runnable = this.backButtonListener;
        if (runnable == null) {
            imageButton.setVisibility(8);
            this.backButton.setTag(null);
            this.backButton.setOnClickListener(null);
            return;
        }
        imageButton.setTag(runnable);
        this.backButton.setVisibility(0);
        this.backButton.setOnClickListener(new View$OnClickListenerC5429e());
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        OrientationEventListener orientationEventListener = this.orientationEventListener;
        if (orientationEventListener != null) {
            orientationEventListener.enable();
        }
        rotateViewIfNeeded();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        OrientationEventListener orientationEventListener = this.orientationEventListener;
        if (orientationEventListener != null) {
            this.orientation = -1;
            orientationEventListener.disable();
        }
        super.onDetachedFromWindow();
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        return true;
    }

    public void setBackButtonListener(Runnable runnable) {
        this.backButtonListener = runnable;
        updateBackButtonVisibility();
    }

    public void setTransitionListener(Runnable runnable) {
        this.transitionListener = runnable;
    }

    public void setViewerName(String str) {
        TextView textView = (TextView) findViewById(R$id.transition_text);
        if (str != null) {
            textView.setText(getContext().getString(R$string.place_your_viewer_into_viewer_format, str));
        } else {
            textView.setText(getContext().getString(R$string.place_your_phone_into_cardboard));
        }
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        int visibility = getVisibility();
        super.setVisibility(i);
        if (visibility != i) {
            if (i == 0) {
                startOrientationMonitor();
            } else {
                stopOrientationMonitor();
            }
        }
    }
}
