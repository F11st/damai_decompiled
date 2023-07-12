package com.google.vr.ndk.base;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.view.animation.AnimationUtils;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
class FadeOverlayView extends View {
    static final long AUTO_FADE_DURATION_MILLIS = 350;
    static final int AUTO_FADE_QUICK_START_DELAY_MILLIS = 200;
    static final long AUTO_FADE_START_DELAY_MILLIS = 1000;
    private static final int BACKGROUND_COLOR = -16777216;
    private static final boolean DEBUG = false;
    private static final int MSG_AUTO_FADE = 77337733;
    private static final String TAG = "FadeOverlayView";
    private final boolean autoFadeEnabled;
    private final Handler autoFadeHandler;
    private long fadeDurationMillis;
    private long fadeStartTimeMillis;
    private int fadeType;
    private final Runnable fadeUpdateRunnable;
    private boolean flushAutoFadeOnVisible;
    private boolean visible;

    public FadeOverlayView(Context context, boolean z) {
        super(context);
        this.fadeType = 0;
        this.fadeUpdateRunnable = new Runnable() { // from class: com.google.vr.ndk.base.FadeOverlayView.1
            @Override // java.lang.Runnable
            public void run() {
                FadeOverlayView.this.updateFade();
            }
        };
        this.autoFadeHandler = new Handler(Looper.getMainLooper()) { // from class: com.google.vr.ndk.base.FadeOverlayView.2
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.what == FadeOverlayView.MSG_AUTO_FADE) {
                    FadeOverlayView.this.startFade(1, FadeOverlayView.AUTO_FADE_DURATION_MILLIS);
                } else {
                    super.handleMessage(message);
                }
            }
        };
        setBackgroundColor(-16777216);
        this.autoFadeEnabled = z;
    }

    private void endFade() {
        int i = this.fadeType;
        if (i == 0) {
            return;
        }
        setVisibility(i == 2 ? 0 : 8);
        setAlpha(this.fadeType == 2 ? 1.0f : 0.0f);
        removeCallbacks(this.fadeUpdateRunnable);
        this.fadeType = 0;
        this.flushAutoFadeOnVisible = false;
    }

    private void removeFadeCallbacks() {
        this.autoFadeHandler.removeMessages(MSG_AUTO_FADE);
        removeCallbacks(this.fadeUpdateRunnable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateFade() {
        long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis() - this.fadeStartTimeMillis;
        float f = ((float) currentAnimationTimeMillis) / ((float) this.fadeDurationMillis);
        if (this.fadeType != 2) {
            f = 1.0f - f;
        }
        setAlpha(Math.min(Math.max(f, 0.0f), 1.0f));
        if (currentAnimationTimeMillis < this.fadeDurationMillis && getVisibility() != 0) {
            setVisibility(0);
        }
        if (currentAnimationTimeMillis < this.fadeDurationMillis) {
            postOnAnimation(this.fadeUpdateRunnable);
        } else {
            endFade();
        }
    }

    public void flushAutoFade() {
        if (this.autoFadeEnabled) {
            if (this.autoFadeHandler.hasMessages(MSG_AUTO_FADE)) {
                this.autoFadeHandler.removeMessages(MSG_AUTO_FADE);
                this.autoFadeHandler.sendEmptyMessageDelayed(MSG_AUTO_FADE, 200L);
            } else if (this.visible) {
            } else {
                this.flushAutoFadeOnVisible = true;
            }
        }
    }

    int getFadeType() {
        return this.fadeType;
    }

    boolean isVisible() {
        return this.visible;
    }

    public void onInvisible() {
        if (this.visible) {
            this.visible = false;
            if (isEnabled() && this.autoFadeEnabled) {
                removeFadeCallbacks();
                this.fadeType = 2;
                endFade();
            }
        }
    }

    public void onVisible() {
        if (this.visible && getAlpha() == 0.0f) {
            return;
        }
        this.visible = true;
        if (isEnabled() && this.autoFadeEnabled) {
            this.autoFadeHandler.removeMessages(MSG_AUTO_FADE);
            this.autoFadeHandler.sendEmptyMessageDelayed(MSG_AUTO_FADE, this.flushAutoFadeOnVisible ? 200L : 1000L);
            return;
        }
        this.fadeType = 1;
        endFade();
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        if (isEnabled() == z) {
            return;
        }
        super.setEnabled(z);
        if (z) {
            return;
        }
        removeFadeCallbacks();
        this.fadeType = 1;
        endFade();
    }

    public void startFade(int i, long j) {
        if (!isEnabled()) {
            Log.w(TAG, "Ignoring fade request while disabled.");
        } else if (!this.visible) {
            Log.w(TAG, "Ignoring fade request while invisible.");
        } else {
            removeFadeCallbacks();
            this.fadeType = i;
            this.fadeDurationMillis = j;
            this.fadeStartTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            updateFade();
        }
    }
}
