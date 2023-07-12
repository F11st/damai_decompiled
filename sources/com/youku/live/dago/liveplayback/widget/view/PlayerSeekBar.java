package com.youku.live.dago.liveplayback.widget.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.Shader;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.ColorInt;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class PlayerSeekBar extends View {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final int DEFAULT_THUMB_SIZE_DP = 16;
    public static final int DEFAULT_THUMB_SIZE_ON_DRAGGING_DP = 28;
    private final int INVALID_COLOR;
    private float dx;
    private boolean isDown;
    private boolean isRtl;
    private boolean isShowThumbText;
    private boolean isThumbOnDragging;
    private boolean isTouchToSeek;
    private boolean isTouchToSeekAnimEnd;
    private float mBackButtonHeight;
    private float mBackButtonWidth;
    private Bitmap mBackToLive;
    private int mBackgroundColor;
    private float mDelta;
    private boolean mIsLiveMode;
    private float mLeft;
    private float mMax;
    private float mMin;
    private OnSeekBarChangeListener mOnSeekBarChangeListener;
    private Paint mPaint;
    private Paint mPlayerBarPaint;
    private float mProgress;
    private Rect mRectText;
    private float mRight;
    private int mSecondTrackColor;
    private float mSecondTrackSize;
    private float mSecondXRight;
    private float mSecondaryProgress;
    private int mStarTrackColor;
    private Rect mTempRect;
    private float mTextSpace;
    private float mThumbCenterX;
    private int mThumbColor;
    private Bitmap mThumbImage;
    private float mThumbSize;
    private float mThumbSizeOnDragging;
    private int mThumbTextColor;
    private float mThumbTextSize;
    private int mTrackColor;
    private int mTrackEndColor;
    private float mTrackLength;
    private float mTrackPadding;
    private float mTrackSize;

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public interface OnSeekBarChangeListener {
        void onBackClicked(long j, long j2);

        void onProgressChanged(PlayerSeekBar playerSeekBar, long j, boolean z);

        void onStartTrackingTouch(PlayerSeekBar playerSeekBar);

        void onStopTrackingTouch(PlayerSeekBar playerSeekBar, long j, boolean z, boolean z2, long j2);

        void onTrackingPressDown(PlayerSeekBar playerSeekBar);
    }

    public PlayerSeekBar(Context context) {
        this(context, null);
    }

    private float calculateProgress() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "293230628")) {
            return ((Float) ipChange.ipc$dispatch("293230628", new Object[]{this})).floatValue();
        }
        if (this.isRtl) {
            return (((this.mRight - this.mThumbCenterX) * this.mDelta) / this.mTrackLength) + this.mMin;
        }
        return (((this.mThumbCenterX - this.mLeft) * this.mDelta) / this.mTrackLength) + this.mMin;
    }

    private float dp2px(float f) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1607897975") ? ((Float) ipChange.ipc$dispatch("1607897975", new Object[]{this, Float.valueOf(f)})).floatValue() : TypedValue.applyDimension(1, f, Resources.getSystem().getDisplayMetrics());
    }

    private boolean drawStarSegmentsLine(float f, float f2, float f3, float f4, Canvas canvas) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "341844976")) {
            return ((Boolean) ipChange.ipc$dispatch("341844976", new Object[]{this, Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), canvas})).booleanValue();
        }
        return false;
    }

    private void drawTrack(float f, float f2, float f3, float f4, Canvas canvas) {
        int i;
        int i2;
        int i3;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1198365083")) {
            ipChange.ipc$dispatch("-1198365083", new Object[]{this, Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), canvas});
            return;
        }
        this.mPaint.setShader(null);
        if (drawStarSegmentsLine(f, f2, f3, f4, canvas)) {
            return;
        }
        int i4 = this.mTrackColor;
        if (i4 == -1 || (i3 = this.mTrackEndColor) == -1) {
            i = -15885313;
            i2 = -16722945;
        } else {
            i = i4;
            i2 = i3;
        }
        this.mPaint.setShader(new LinearGradient(f, 0.0f, f3, 0.0f, i, i2, Shader.TileMode.CLAMP));
        canvas.drawLine(f, f2, f3, f4, this.mPaint);
    }

    private void initSomeValues() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1605600573")) {
            ipChange.ipc$dispatch("1605600573", new Object[]{this});
            return;
        }
        if (this.mMin == this.mMax) {
            this.mMin = 0.0f;
            this.mMax = 100.0f;
        }
        float f = this.mMin;
        float f2 = this.mMax;
        if (f > f2) {
            this.mMax = f;
            this.mMin = f2;
        }
        float f3 = this.mProgress;
        float f4 = this.mMin;
        if (f3 < f4) {
            this.mProgress = f4;
        }
        float f5 = this.mProgress;
        float f6 = this.mMax;
        if (f5 > f6) {
            this.mProgress = f6;
        }
        float f7 = this.mSecondTrackSize;
        float f8 = this.mTrackSize;
        if (f7 < f8) {
            this.mSecondTrackSize = f8 + dp2px(2.0f);
        }
        this.mDelta = this.mMax - this.mMin;
    }

    private boolean isThumbTouched(MotionEvent motionEvent) {
        int measuredHeight;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2126831946")) {
            return ((Boolean) ipChange.ipc$dispatch("2126831946", new Object[]{this, motionEvent})).booleanValue();
        }
        if (isEnabled()) {
            if (this.mIsLiveMode) {
                measuredHeight = (getMeasuredHeight() / 2) + (((int) this.mBackButtonHeight) / 2);
            } else {
                measuredHeight = getMeasuredHeight() / 2;
            }
            return motionEvent.getX() > this.mThumbCenterX - 40.0f && motionEvent.getX() < this.mThumbCenterX + 40.0f && motionEvent.getY() > ((float) (measuredHeight + (-40))) && motionEvent.getY() < ((float) (measuredHeight + 40));
        }
        return false;
    }

    private boolean isTrackTouched(MotionEvent motionEvent) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "361318975") ? ((Boolean) ipChange.ipc$dispatch("361318975", new Object[]{this, motionEvent})).booleanValue() : isEnabled() && motionEvent.getX() >= 0.0f && motionEvent.getX() <= ((float) getMeasuredWidth()) && motionEvent.getY() >= 0.0f && motionEvent.getY() <= ((float) getMeasuredHeight());
    }

    private float sp2px(float f) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "265884806") ? ((Float) ipChange.ipc$dispatch("265884806", new Object[]{this, Float.valueOf(f)})).floatValue() : TypedValue.applyDimension(2, f, Resources.getSystem().getDisplayMetrics());
    }

    public boolean getLiveMode() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1473310214") ? ((Boolean) ipChange.ipc$dispatch("1473310214", new Object[]{this})).booleanValue() : this.mIsLiveMode;
    }

    public synchronized int getMax() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "209218664")) {
            return ((Integer) ipChange.ipc$dispatch("209218664", new Object[]{this})).intValue();
        }
        return Math.round(this.mMax);
    }

    public float getMin() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "216308919") ? ((Float) ipChange.ipc$dispatch("216308919", new Object[]{this})).floatValue() : this.mMin;
    }

    public int getProgress() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1729373257") ? ((Integer) ipChange.ipc$dispatch("-1729373257", new Object[]{this})).intValue() : Math.round(this.mProgress);
    }

    public Bitmap getThumbImage() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1371926102") ? (Bitmap) ipChange.ipc$dispatch("-1371926102", new Object[]{this}) : this.mThumbImage;
    }

    public PointF getThumbPoint() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1033145938") ? (PointF) ipChange.ipc$dispatch("-1033145938", new Object[]{this}) : new PointF(this.mThumbCenterX + this.mLeft, getMeasuredHeight() / 2);
    }

    public float getTrackLength() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-143450472") ? ((Float) ipChange.ipc$dispatch("-143450472", new Object[]{this})).floatValue() : this.mTrackLength;
    }

    public float getTrackPadding() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1221450501") ? ((Float) ipChange.ipc$dispatch("-1221450501", new Object[]{this})).floatValue() : this.mTrackPadding;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        float measuredHeight;
        Bitmap bitmap;
        float f;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1397594789")) {
            ipChange.ipc$dispatch("1397594789", new Object[]{this, canvas});
            return;
        }
        super.onDraw(canvas);
        float f2 = 0.0f;
        float measuredWidth = getMeasuredWidth();
        if (this.mIsLiveMode) {
            measuredHeight = ((getMeasuredHeight() / 2) - this.mSecondTrackSize) + (this.mBackButtonHeight / 2.0f);
        } else {
            measuredHeight = (getMeasuredHeight() / 2) - this.mSecondTrackSize;
        }
        boolean z = this.isShowThumbText;
        if (z) {
            f2 = this.mLeft;
            measuredWidth = this.mRight;
        }
        if (!z) {
            if (this.mIsLiveMode) {
                f = this.mTrackPadding;
            } else {
                f = this.mTrackPadding;
            }
            f2 += f;
            measuredWidth -= f;
        }
        float f3 = measuredWidth;
        boolean z2 = this.isThumbOnDragging;
        if (!z2) {
            if (this.isRtl) {
                this.mThumbCenterX = f3 - ((int) (((this.mTrackLength * 1.0f) / this.mDelta) * (this.mProgress - this.mMin)));
            } else {
                this.mThumbCenterX = ((int) (((this.mTrackLength * 1.0f) / this.mDelta) * (this.mProgress - this.mMin))) + f2;
            }
        }
        if (z && !z2 && this.isTouchToSeekAnimEnd) {
            this.mPaint.setColor(this.mThumbTextColor);
            this.mPaint.setTextSize(this.mThumbTextSize);
            this.mPaint.getTextBounds("0123456789", 0, 10, this.mRectText);
            canvas.drawText(String.valueOf(getProgress()), this.mThumbCenterX, com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.height(this.mRectText) + measuredHeight + this.mThumbSizeOnDragging + this.mTextSpace, this.mPaint);
        }
        if (this.mIsLiveMode) {
            this.mBackgroundColor = Color.parseColor("#59d2d2d2");
        } else {
            this.mBackgroundColor = Color.parseColor("#59d2d2d2");
        }
        this.mPaint.setColor(this.mBackgroundColor);
        this.mPaint.setStrokeWidth(this.mSecondTrackSize);
        float f4 = measuredHeight;
        float f5 = measuredHeight;
        canvas.drawLine(f2, f4, f3, f5, this.mPaint);
        this.mSecondXRight = (((this.mTrackLength * 1.0f) / this.mDelta) * (this.mSecondaryProgress - this.mMin)) + f2;
        this.mPaint.setColor(this.mSecondTrackColor);
        this.mPaint.setStrokeWidth(this.mSecondTrackSize);
        float f6 = f2;
        canvas.drawLine(f6, f4, f2 + (((this.mTrackLength * 1.0f) / this.mDelta) * (this.mSecondaryProgress - this.mMin)), f5, this.mPaint);
        drawTrack(f6, f4, this.mThumbCenterX, f5, canvas);
        if (this.isThumbOnDragging) {
            this.mPaint.setColor(this.mThumbColor);
            float f7 = this.mThumbCenterX;
            float f8 = this.mThumbSizeOnDragging;
            int i = this.mThumbColor;
            this.mPaint.setShader(new RadialGradient(f7, measuredHeight, f8, new int[]{(-1711276033) & i, 16777215 & i}, (float[]) null, Shader.TileMode.CLAMP));
            canvas.drawCircle(this.mThumbCenterX, measuredHeight, this.mThumbSizeOnDragging, this.mPaint);
        }
        this.mPaint.setShader(null);
        float f9 = this.mThumbSize;
        float f10 = this.mThumbCenterX - (f9 / 2.0f);
        float f11 = measuredHeight - (f9 / 2.0f);
        if (this.mThumbImage == null) {
            if (this.mPlayerBarPaint == null) {
                Paint paint = new Paint();
                this.mPlayerBarPaint = paint;
                paint.setAntiAlias(true);
            }
            this.mPlayerBarPaint.setColor(-2147429377);
            float f12 = (int) f10;
            float f13 = this.mThumbSize;
            float f14 = (int) f11;
            canvas.drawCircle((f13 / 2.0f) + f12, (f13 / 2.0f) + f14, f13 / 2.0f, this.mPlayerBarPaint);
            this.mPlayerBarPaint.setColor(-16722945);
            float f15 = this.mThumbSize;
            canvas.drawCircle(f12 + (f15 / 2.0f), f14 + (f15 / 2.0f), (((int) this.mThumbSize) * 9) / 32, this.mPlayerBarPaint);
        } else {
            this.mTempRect.set((int) f10, (int) f11, (int) (f10 + f9), (int) (f9 + f11));
            canvas.drawBitmap(this.mThumbImage, (Rect) null, this.mTempRect, (Paint) null);
        }
        if (!this.mIsLiveMode || this.mProgress >= this.mSecondaryProgress || (bitmap = this.mBackToLive) == null) {
            return;
        }
        float f16 = this.mSecondXRight;
        float f17 = this.mBackButtonWidth;
        int i2 = (int) f11;
        canvas.drawBitmap(bitmap, (Rect) null, new Rect((int) (f16 - (f17 / 2.0f)), i2 - ((int) this.mBackButtonHeight), (int) (f16 + (f17 / 2.0f)), i2), (Paint) null);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-680129976")) {
            ipChange.ipc$dispatch("-680129976", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
            return;
        }
        super.onMeasure(i, i2);
        float f = this.mThumbSizeOnDragging * 2.0f;
        if (this.isShowThumbText) {
            this.mPaint.setTextSize(this.mThumbTextSize);
            this.mPaint.getTextBounds("j", 0, 1, this.mRectText);
            f += com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.height(this.mRectText);
        }
        float f2 = f + (this.mTextSpace * 2.0f);
        if (this.mIsLiveMode) {
            f2 += this.mBackButtonHeight;
        }
        setMeasuredDimension(View.resolveSize((int) dp2px(180.0f), i), (int) f2);
        this.mLeft = this.mTrackPadding;
        this.mRight = getMeasuredWidth() - this.mTrackPadding;
        if (this.isShowThumbText) {
            this.mPaint.setTextSize(this.mThumbTextSize);
            this.mLeft = Math.max(this.mThumbSizeOnDragging, com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.width(this.mRectText) / 2) + ((int) this.mTextSpace);
            this.mRight = (getMeasuredWidth() - Math.max(this.mThumbSizeOnDragging, com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.width(this.mRectText) / 2)) - ((int) this.mTextSpace);
        }
        this.mTrackLength = this.mRight - this.mLeft;
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "316813405")) {
            ipChange.ipc$dispatch("316813405", new Object[]{this, parcelable});
        } else if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            this.mProgress = bundle.getFloat("progress");
            super.onRestoreInstanceState(bundle.getParcelable("save_instance"));
            setProgress(this.mProgress);
        } else {
            super.onRestoreInstanceState(parcelable);
        }
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1938895446")) {
            return (Parcelable) ipChange.ipc$dispatch("-1938895446", new Object[]{this});
        }
        Bundle bundle = new Bundle();
        bundle.putParcelable("save_instance", super.onSaveInstanceState());
        bundle.putFloat("progress", this.mProgress);
        return bundle;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0029, code lost:
        if (r0 != 3) goto L12;
     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onTouchEvent(android.view.MotionEvent r15) {
        /*
            Method dump skipped, instructions count: 331
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.youku.live.dago.liveplayback.widget.view.PlayerSeekBar.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public void setIsDragging(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1100580088")) {
            ipChange.ipc$dispatch("-1100580088", new Object[]{this, Boolean.valueOf(z)});
        } else {
            this.isThumbOnDragging = z;
        }
    }

    public void setLiveMode(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-661225442")) {
            ipChange.ipc$dispatch("-661225442", new Object[]{this, Boolean.valueOf(z)});
        } else {
            this.mIsLiveMode = z;
        }
    }

    public synchronized void setMax(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-167319965")) {
            ipChange.ipc$dispatch("-167319965", new Object[]{this, Long.valueOf(j)});
            return;
        }
        if (j < 0) {
            j = 0;
        }
        float f = (float) j;
        if (f != this.mMax) {
            this.mMax = f;
            this.mDelta = f - this.mMin;
            postInvalidate();
        }
    }

    public void setOnSeekBarChangeListener(OnSeekBarChangeListener onSeekBarChangeListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1192956874")) {
            ipChange.ipc$dispatch("1192956874", new Object[]{this, onSeekBarChangeListener});
        } else {
            this.mOnSeekBarChangeListener = onSeekBarChangeListener;
        }
    }

    public void setProgress(float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1160183928")) {
            ipChange.ipc$dispatch("-1160183928", new Object[]{this, Float.valueOf(f)});
        } else if (this.isDown) {
        } else {
            this.mProgress = f;
            OnSeekBarChangeListener onSeekBarChangeListener = this.mOnSeekBarChangeListener;
            if (onSeekBarChangeListener != null) {
                onSeekBarChangeListener.onProgressChanged(this, getProgress(), false);
            }
            postInvalidate();
        }
    }

    public void setSecondTrackColor(@ColorInt int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1792189834")) {
            ipChange.ipc$dispatch("1792189834", new Object[]{this, Integer.valueOf(i)});
        } else if (this.mSecondTrackColor != i) {
            this.mSecondTrackColor = i;
            invalidate();
        }
    }

    public void setSecondaryProgress(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "445420096")) {
            ipChange.ipc$dispatch("445420096", new Object[]{this, Long.valueOf(j)});
            return;
        }
        this.mSecondaryProgress = (float) j;
        postInvalidate();
    }

    public void setThumbColor(@ColorInt int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1098149941")) {
            ipChange.ipc$dispatch("-1098149941", new Object[]{this, Integer.valueOf(i)});
        } else if (this.mThumbColor != i) {
            this.mThumbColor = i;
            invalidate();
        }
    }

    public void setThumbImage(Bitmap bitmap) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1958824722")) {
            ipChange.ipc$dispatch("-1958824722", new Object[]{this, bitmap});
        } else {
            this.mThumbImage = bitmap;
        }
    }

    public void setThumbSize(float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1331867790")) {
            ipChange.ipc$dispatch("-1331867790", new Object[]{this, Float.valueOf(f)});
        } else if (this.mThumbSize != f) {
            this.mThumbSize = f;
            invalidate();
        }
    }

    public void setThumbSizeOnDragging(float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1849198624")) {
            ipChange.ipc$dispatch("1849198624", new Object[]{this, Float.valueOf(f)});
        } else {
            this.mThumbSizeOnDragging = f;
        }
    }

    public void setTrackColor(@ColorInt int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "997123062")) {
            ipChange.ipc$dispatch("997123062", new Object[]{this, Integer.valueOf(i)});
        } else if (this.mTrackColor != i) {
            this.mTrackColor = i;
            this.mTrackEndColor = i;
            this.mStarTrackColor = i;
            invalidate();
        }
    }

    public void setTrackLineColor(@ColorInt int i, @ColorInt int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1941398369")) {
            ipChange.ipc$dispatch("1941398369", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
        } else if (this.mTrackColor == i && this.mTrackEndColor == i2) {
        } else {
            this.mTrackColor = i;
            this.mTrackEndColor = i2;
            this.mStarTrackColor = i;
            invalidate();
        }
    }

    public void setTrackPadding(float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-753960671")) {
            ipChange.ipc$dispatch("-753960671", new Object[]{this, Float.valueOf(f)});
        } else {
            this.mTrackPadding = f;
        }
    }

    public PlayerSeekBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x00c7, code lost:
        if (r9 == null) goto L5;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public PlayerSeekBar(android.content.Context r9, android.util.AttributeSet r10, int r11) {
        /*
            r8 = this;
            r8.<init>(r9, r10, r11)
            r0 = 1073741824(0x40000000, float:2.0)
            float r1 = r8.dp2px(r0)
            r8.mTrackSize = r1
            float r1 = r8.dp2px(r0)
            r8.mSecondTrackSize = r1
            java.lang.String r1 = "#59d2d2d2"
            int r1 = android.graphics.Color.parseColor(r1)
            r8.mBackgroundColor = r1
            r1 = -1
            r8.INVALID_COLOR = r1
            r8.mTrackColor = r1
            r8.mTrackEndColor = r1
            r2 = 0
            r8.isShowThumbText = r2
            r3 = 1096810496(0x41600000, float:14.0)
            float r3 = r8.sp2px(r3)
            r8.mThumbTextSize = r3
            java.lang.String r3 = "#FF00D3FF"
            int r3 = android.graphics.Color.parseColor(r3)
            r8.mThumbColor = r3
            android.content.res.Resources r3 = r8.getResources()
            int r4 = com.youku.live.dago.liveplayback.R.dimen.seek_bar_padding
            float r3 = r3.getDimension(r4)
            r8.mTrackPadding = r3
            android.graphics.Rect r3 = new android.graphics.Rect
            r3.<init>()
            r8.mTempRect = r3
            r3 = 0
            r8.mThumbImage = r3
            r4 = 1105199104(0x41e00000, float:28.0)
            float r4 = r8.dp2px(r4)
            r8.mThumbSizeOnDragging = r4
            r4 = 1098907648(0x41800000, float:16.0)
            float r4 = r8.dp2px(r4)
            r8.mThumbSize = r4
            r4 = 1
            r8.isTouchToSeekAnimEnd = r4
            r8.isRtl = r2
            r5 = 0
            r8.dx = r5
            r8.isDown = r2
            android.content.res.Resources r6 = r8.getResources()
            int r7 = com.youku.live.dago.liveplayback.R.drawable.dago_back_to_live
            android.graphics.Bitmap r6 = android.graphics.BitmapFactory.decodeResource(r6, r7)
            r8.mBackToLive = r6
            r6 = 1104150528(0x41d00000, float:26.0)
            float r6 = r8.dp2px(r6)
            r8.mBackButtonHeight = r6
            r6 = 1116995584(0x42940000, float:74.0)
            float r6 = r8.dp2px(r6)
            r8.mBackButtonWidth = r6
            r8.mOnSeekBarChangeListener = r3
            int[] r3 = com.youku.live.dago.liveplayback.R.styleable.LivePlayerSeekBar
            android.content.res.TypedArray r9 = r9.obtainStyledAttributes(r10, r3, r11, r2)
            int r10 = com.youku.live.dago.liveplayback.R.styleable.LivePlayerSeekBar_min     // Catch: java.lang.Throwable -> Lbf java.lang.Exception -> Lc6
            float r10 = r9.getFloat(r10, r5)     // Catch: java.lang.Throwable -> Lbf java.lang.Exception -> Lc6
            r8.mMin = r10     // Catch: java.lang.Throwable -> Lbf java.lang.Exception -> Lc6
            int r10 = com.youku.live.dago.liveplayback.R.styleable.LivePlayerSeekBar_track_color     // Catch: java.lang.Throwable -> Lbf java.lang.Exception -> Lc6
            int r11 = r9.getColor(r10, r1)     // Catch: java.lang.Throwable -> Lbf java.lang.Exception -> Lc6
            r8.mTrackColor = r11     // Catch: java.lang.Throwable -> Lbf java.lang.Exception -> Lc6
            r11 = -15885313(0xffffffffff0d9bff, float:-1.8823113E38)
            int r10 = r9.getColor(r10, r11)     // Catch: java.lang.Throwable -> Lbf java.lang.Exception -> Lc6
            r8.mStarTrackColor = r10     // Catch: java.lang.Throwable -> Lbf java.lang.Exception -> Lc6
            int r10 = com.youku.live.dago.liveplayback.R.styleable.LivePlayerSeekBar_second_track_color     // Catch: java.lang.Throwable -> Lbf java.lang.Exception -> Lc6
            java.lang.String r11 = "#CCCCCC"
            int r11 = android.graphics.Color.parseColor(r11)     // Catch: java.lang.Throwable -> Lbf java.lang.Exception -> Lc6
            int r10 = r9.getColor(r10, r11)     // Catch: java.lang.Throwable -> Lbf java.lang.Exception -> Lc6
            r8.mSecondTrackColor = r10     // Catch: java.lang.Throwable -> Lbf java.lang.Exception -> Lc6
            int r11 = com.youku.live.dago.liveplayback.R.styleable.LivePlayerSeekBar_thumb_text_color     // Catch: java.lang.Throwable -> Lbf java.lang.Exception -> Lc6
            int r10 = r9.getColor(r11, r10)     // Catch: java.lang.Throwable -> Lbf java.lang.Exception -> Lc6
            r8.mThumbTextColor = r10     // Catch: java.lang.Throwable -> Lbf java.lang.Exception -> Lc6
            int r10 = com.youku.live.dago.liveplayback.R.styleable.LivePlayerSeekBar_touch_to_seek     // Catch: java.lang.Throwable -> Lbf java.lang.Exception -> Lc6
            boolean r10 = r9.getBoolean(r10, r4)     // Catch: java.lang.Throwable -> Lbf java.lang.Exception -> Lc6
            r8.isTouchToSeek = r10     // Catch: java.lang.Throwable -> Lbf java.lang.Exception -> Lc6
            goto Lc9
        Lbf:
            r10 = move-exception
            if (r9 == 0) goto Lc5
            r9.recycle()
        Lc5:
            throw r10
        Lc6:
            if (r9 == 0) goto Lcc
        Lc9:
            r9.recycle()
        Lcc:
            android.graphics.Paint r9 = new android.graphics.Paint
            r9.<init>()
            r8.mPaint = r9
            r9.setAntiAlias(r4)
            android.graphics.Paint r9 = r8.mPaint
            android.graphics.Paint$Cap r10 = android.graphics.Paint.Cap.ROUND
            r9.setStrokeCap(r10)
            android.graphics.Paint r9 = r8.mPaint
            android.graphics.Paint$Align r10 = android.graphics.Paint.Align.CENTER
            r9.setTextAlign(r10)
            android.graphics.Rect r9 = new android.graphics.Rect
            r9.<init>()
            r8.mRectText = r9
            float r9 = r8.dp2px(r0)
            r8.mTextSpace = r9
            r8.initSomeValues()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.youku.live.dago.liveplayback.widget.view.PlayerSeekBar.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }
}
