package com.taobao.weex.ui.view.border;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Build;
import androidx.annotation.NonNull;
import tb.jk0;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
abstract class BorderCorner {
    static final float SWEEP_ANGLE = 45.0f;
    protected float mAngleBisector;
    private RectF mBorderBox;
    private float mOvalBottom;
    private float mOvalLeft;
    private float mOvalRight;
    private float mOvalTop;
    private float mRoundCornerEndX;
    private float mRoundCornerEndY;
    private float mRoundCornerStartX;
    private float mRoundCornerStartY;
    private float mCornerRadius = 0.0f;
    private float mPreBorderWidth = 0.0f;
    private float mPostBorderWidth = 0.0f;
    private boolean hasInnerCorner = false;
    private boolean hasOuterCorner = false;

    public final void drawRoundedCorner(@NonNull Canvas canvas, @NonNull Paint paint, float f) {
        if (hasOuterCorner()) {
            if (Build.VERSION.SDK_INT >= 21) {
                canvas.drawArc(this.mOvalLeft, this.mOvalTop, this.mOvalRight, this.mOvalBottom, f, SWEEP_ANGLE, false, paint);
                return;
            } else {
                canvas.drawArc(new RectF(this.mOvalLeft, this.mOvalTop, this.mOvalRight, this.mOvalBottom), f, SWEEP_ANGLE, false, paint);
                return;
            }
        }
        canvas.drawLine(getRoundCornerStartX(), getRoundCornerStartY(), getRoundCornerEndX(), getRoundCornerEndY(), paint);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final float getAngleBisectorDegree() {
        return this.mAngleBisector;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final RectF getBorderBox() {
        return this.mBorderBox;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final float getOuterCornerRadius() {
        return this.mCornerRadius;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final float getPostBorderWidth() {
        return this.mPostBorderWidth;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final float getPreBorderWidth() {
        return this.mPreBorderWidth;
    }

    public final float getRoundCornerEndX() {
        return this.mRoundCornerEndX;
    }

    public final float getRoundCornerEndY() {
        return this.mRoundCornerEndY;
    }

    public final float getRoundCornerStartX() {
        return this.mRoundCornerStartX;
    }

    public final float getRoundCornerStartY() {
        return this.mRoundCornerStartY;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean hasInnerCorner() {
        return this.hasInnerCorner;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean hasOuterCorner() {
        return this.hasOuterCorner;
    }

    protected abstract void prepareOval();

    protected abstract void prepareRoundCorner();

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void set(float f, float f2, float f3, @NonNull RectF rectF, float f4) {
        RectF rectF2;
        boolean z = false;
        if ((jk0.a(this.mCornerRadius, f) && jk0.a(this.mPreBorderWidth, f2) && jk0.a(this.mPostBorderWidth, f3) && jk0.a(this.mAngleBisector, f4) && ((rectF2 = this.mBorderBox) == null || !rectF2.equals(rectF))) ? false : true) {
            this.mCornerRadius = f;
            this.mPreBorderWidth = f2;
            this.mPostBorderWidth = f3;
            this.mBorderBox = rectF;
            this.mAngleBisector = f4;
            boolean z2 = f > 0.0f && !jk0.a(0.0f, f);
            this.hasOuterCorner = z2;
            if (z2 && getPreBorderWidth() >= 0.0f && getPostBorderWidth() >= 0.0f && getOuterCornerRadius() > getPreBorderWidth() && getOuterCornerRadius() > getPostBorderWidth()) {
                z = true;
            }
            this.hasInnerCorner = z;
            if (this.hasOuterCorner) {
                prepareOval();
            }
            prepareRoundCorner();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void setOvalBottom(float f) {
        this.mOvalBottom = f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void setOvalLeft(float f) {
        this.mOvalLeft = f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void setOvalRight(float f) {
        this.mOvalRight = f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void setOvalTop(float f) {
        this.mOvalTop = f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void setRoundCornerEndX(float f) {
        this.mRoundCornerEndX = f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void setRoundCornerEndY(float f) {
        this.mRoundCornerEndY = f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void setRoundCornerStartX(float f) {
        this.mRoundCornerStartX = f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void setRoundCornerStartY(float f) {
        this.mRoundCornerStartY = f;
    }
}
