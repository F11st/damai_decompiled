package com.google.vr.sdk.widgets.common;

import android.content.Context;
import android.view.OrientationEventListener;
import android.view.View;
import android.view.ViewGroup;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
class ViewRotator {
    private int currentViewOrientation90Inc;
    private final int initialRotationDegrees;
    private OrientationEventListener orientationEventListener;
    private int originalViewHeight;
    private int originalViewWidth;
    private final View view;

    public ViewRotator(Context context, View view, int i, final boolean z) {
        if (isViewProperlyConfigured(view)) {
            if (i < 180) {
                this.initialRotationDegrees = i;
            } else {
                this.initialRotationDegrees = i - 180;
            }
            this.view = view;
            this.orientationEventListener = new OrientationEventListener(context) { // from class: com.google.vr.sdk.widgets.common.ViewRotator.1
                @Override // android.view.OrientationEventListener
                public void onOrientationChanged(int i2) {
                    if (z && i2 != -1) {
                        int i3 = i2 + ViewRotator.this.initialRotationDegrees;
                        if (i3 > 180) {
                            i3 -= 360;
                        }
                        int i4 = i3 - ViewRotator.this.currentViewOrientation90Inc;
                        if (i4 > 180) {
                            i4 = 360 - i4;
                        }
                        if (i4 < -180) {
                            i4 += 360;
                        }
                        if (Math.abs(i4) > 70) {
                            ViewRotator.this.rotateView(i3);
                        }
                    }
                }
            };
            return;
        }
        throw new IllegalArgumentException("View should have MATCH_PARENT layout and no translation.");
    }

    static int getNearestOrientationWith90Inc(int i) {
        return (int) (Math.signum(i) * Math.round(Math.abs(i) / 90.0d) * 90.0d);
    }

    private static boolean isViewProperlyConfigured(View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        return (layoutParams == null || (layoutParams.height == -1 && layoutParams.width == -1)) && view.getTranslationX() == 0.0f && view.getTranslationY() == 0.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rotateView(int i) {
        if (this.view.getParent() == null) {
            return;
        }
        if (this.originalViewWidth == 0 || this.originalViewHeight == 0) {
            this.originalViewWidth = this.view.getWidth();
            int height = this.view.getHeight();
            this.originalViewHeight = height;
            if (this.originalViewWidth == 0 || height == 0) {
                return;
            }
        }
        int nearestOrientationWith90Inc = getNearestOrientationWith90Inc(i);
        this.currentViewOrientation90Inc = nearestOrientationWith90Inc;
        this.view.setRotation(-nearestOrientationWith90Inc);
        ViewGroup.LayoutParams layoutParams = this.view.getLayoutParams();
        if (this.currentViewOrientation90Inc % 180 != 0) {
            int i2 = this.originalViewWidth;
            layoutParams.height = i2;
            int i3 = this.originalViewHeight;
            layoutParams.width = i3;
            this.view.setTranslationX((i2 - i3) / 2);
            this.view.setTranslationY((this.originalViewHeight - this.originalViewWidth) / 2);
        } else {
            layoutParams.height = this.originalViewHeight;
            layoutParams.width = this.originalViewWidth;
            this.view.setTranslationY(0.0f);
            this.view.setTranslationX(0.0f);
        }
        this.view.requestLayout();
    }

    public void disable() {
        this.orientationEventListener.disable();
        ViewGroup.LayoutParams layoutParams = this.view.getLayoutParams();
        layoutParams.height = -1;
        layoutParams.width = -1;
        this.view.setTranslationY(0.0f);
        this.view.setTranslationX(0.0f);
        this.view.setRotation(0.0f);
        this.originalViewWidth = 0;
        this.originalViewHeight = 0;
    }

    public void enable() {
        this.orientationEventListener.enable();
    }
}
