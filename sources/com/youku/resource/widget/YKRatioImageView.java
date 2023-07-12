package com.youku.resource.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.ImageView;
import com.taobao.uikit.extend.feature.view.TUrlImageView;
import com.youku.asyncview.ViewContext;
import com.youku.resource.R;
import com.youku.resource.utils.AppPerfABUtils;
import com.youku.resource.utils.DimenUtils;
import com.youku.resource.utils.ImageViewUtils;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class YKRatioImageView extends TUrlImageView {
    public static final int RATIO_P1 = 1;
    public static final int RATIO_P16 = 16;
    public static final int RATIO_P16_S1 = 161;
    public static final int RATIO_P16_S2 = 162;
    public static final int RATIO_P16_S3 = 163;
    public static final int RATIO_P1_S1 = 11;
    public static final int RATIO_P1_S2 = 12;
    public static final int RATIO_P1_S3 = 13;
    public static final int RATIO_P1_S4 = 14;
    public static final int RATIO_P2 = 2;
    public static final int RATIO_P2_S1 = 21;
    public static final int RATIO_P2_S2 = 22;
    public static final int RATIO_P2_S3 = 23;
    public static final int RATIO_P3 = 3;
    public static final int RATIO_P3_S1 = 31;
    public static final int RATIO_P3_S2 = 32;
    public static final int RATIO_P3_S3 = 33;
    public static final int RATIO_P3_S4 = 34;
    public static final int RATIO_P4 = 4;
    public static final int RATIO_P4_S1 = 41;
    public static final int RATIO_P4_S2 = 42;
    public static final int RATIO_P9 = 9;
    public static final int RATIO_P9_S1 = 91;
    public static final int RATIO_PB = 998;
    public static final int RATIO_PV = 999;
    private static final String TAG = "YKRatioImageView";
    public static int defaultRadius = -1;
    private static final Paint imagePaint;
    private static final Paint roundPaint;
    private static boolean sDegrade;
    private static boolean sNoEnableLayoutOptimize;
    private static boolean sNoOptLessRequestLayout;
    private int D;
    private int M;
    protected int height;
    private boolean isLeftBottomCorner;
    private boolean isLeftTopCorner;
    private boolean isRightBottomCorner;
    private boolean isRightTopCorner;
    private Path mDrawCornerPath;
    private boolean mFadeIn;
    private boolean mFixedFadeIn;
    protected boolean mForceSkipRequestLayout;
    protected boolean mOptLessRequestLayout;
    private int[] mSize;
    protected volatile boolean mWaitImageDrawable;
    private int ratio_type;
    private RectF rectF;
    private boolean roundCorner;
    private int roundLeftBottomCornerRadius;
    private int roundLeftTopCornerRadius;
    private int roundRightBottomRadius;
    private int roundRightTopCornerRadius;
    protected int width;

    static {
        Paint paint = new Paint();
        roundPaint = paint;
        paint.setColor(-1);
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.FILL);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        Paint paint2 = new Paint();
        imagePaint = paint2;
        paint2.setXfermode(null);
        sNoOptLessRequestLayout = AppPerfABUtils.isNoOptLessRequestLayout();
        sNoEnableLayoutOptimize = AppPerfABUtils.isNoSetEnableLayoutOptimize();
        sDegrade = AppPerfABUtils.isOpenDegrade();
    }

    public YKRatioImageView(Context context) {
        super(context);
        this.mForceSkipRequestLayout = false;
        this.mOptLessRequestLayout = false;
        this.mWaitImageDrawable = false;
        this.mFadeIn = false;
        this.mFixedFadeIn = false;
        this.mSize = new int[2];
        init(context, null);
    }

    private void drawCorner(Canvas canvas) {
        drawLeftUp(canvas);
        drawRightUp(canvas);
        drawLeftDown(canvas);
        drawRightDown(canvas);
    }

    private int getDefaultRadius() {
        int i = defaultRadius;
        if (i >= 0) {
            return i;
        }
        int dimensionPixelOffset = getResources().getDimensionPixelOffset(R.dimen.yk_img_round_radius);
        defaultRadius = dimensionPixelOffset;
        return dimensionPixelOffset;
    }

    private Path getDrawCornerPath() {
        Path path = this.mDrawCornerPath;
        if (path == null) {
            this.mDrawCornerPath = new Path();
        } else {
            path.reset();
        }
        return this.mDrawCornerPath;
    }

    private void init(Context context, AttributeSet attributeSet) {
        int i;
        enableLoadOnFling(false);
        this.mFadeIn = true;
        setFadeIn(true);
        setScaleType(ImageView.ScaleType.CENTER_CROP);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.YKImageView, 0, 0);
            this.ratio_type = obtainStyledAttributes.getInt(R.styleable.YKImageView_picRatio, 0);
            int i2 = R.styleable.YKImageView_D;
            int i3 = R.dimen.dim_6;
            int resourceId = obtainStyledAttributes.getResourceId(i2, i3);
            if (resourceId == i3) {
                this.D = DimenUtils.getDimensionPixelSize(getContext(), i3);
            } else {
                this.D = getResources().getDimensionPixelOffset(resourceId);
            }
            int i4 = R.styleable.YKImageView_M;
            int i5 = R.dimen.dim_9;
            int resourceId2 = obtainStyledAttributes.getResourceId(i4, i5);
            if (resourceId2 == i5) {
                this.M = DimenUtils.getDimensionPixelSize(getContext(), i5);
            } else {
                this.M = getResources().getDimensionPixelOffset(resourceId2);
            }
            int i6 = R.styleable.YKImageView_roundCorner;
            if (obtainStyledAttributes.getResourceId(i6, 0) != 0) {
                this.roundCorner = getResources().getBoolean(obtainStyledAttributes.getResourceId(i6, 0));
            } else {
                this.roundCorner = obtainStyledAttributes.getBoolean(i6, true);
            }
            int i7 = R.styleable.YKImageView_roundLeftTopCornerRadius;
            if (obtainStyledAttributes.getResourceId(i7, 0) != 0) {
                setRoundLeftTopCornerRadius(getResources().getDimensionPixelOffset(obtainStyledAttributes.getResourceId(i7, 0)));
            } else {
                setRoundLeftTopCornerRadius(getDefaultRadius());
            }
            int i8 = R.styleable.YKImageView_roundLeftBottomCornerRadius;
            if (obtainStyledAttributes.getResourceId(i8, 0) != 0) {
                setRoundLeftBottomCornerRadius(getResources().getDimensionPixelOffset(obtainStyledAttributes.getResourceId(i8, 0)));
            } else {
                setRoundLeftBottomCornerRadius(getDefaultRadius());
            }
            int i9 = R.styleable.YKImageView_roundRightTopCornerRadius;
            if (obtainStyledAttributes.getResourceId(i9, 0) != 0) {
                setRoundRightTopCornerRadius(getResources().getDimensionPixelOffset(obtainStyledAttributes.getResourceId(i9, 0)));
            } else {
                setRoundRightTopCornerRadius(getDefaultRadius());
            }
            int i10 = R.styleable.YKImageView_roundRightBottomCornerRadius;
            if (obtainStyledAttributes.getResourceId(i10, 0) != 0) {
                setRoundRightBottomRadius(getResources().getDimensionPixelOffset(obtainStyledAttributes.getResourceId(i10, 0)));
            } else {
                setRoundRightBottomRadius(getDefaultRadius());
            }
            if (this.roundCorner) {
                setCorner(true, true, true, true);
                int i11 = this.roundLeftBottomCornerRadius;
                int i12 = this.roundLeftTopCornerRadius;
                if (i11 == i12 && i12 == (i = this.roundRightTopCornerRadius) && i == this.roundRightBottomRadius) {
                    setViewRoundedCorner(this, i12, 0.0f);
                }
            }
            this.mOptLessRequestLayout = obtainStyledAttributes.getBoolean(R.styleable.YKImageView_optLessRequestLayout, false);
            obtainStyledAttributes.recycle();
        }
    }

    private boolean needDrawCorner() {
        return (this.isLeftTopCorner && this.roundLeftTopCornerRadius > 0) || (this.isLeftBottomCorner && this.roundLeftBottomCornerRadius > 0) || ((this.isRightBottomCorner && this.roundRightBottomRadius > 0) || (this.isRightTopCorner && this.roundRightTopCornerRadius > 0));
    }

    @Override // com.taobao.uikit.feature.view.TImageView, android.view.View
    public void draw(Canvas canvas) {
        boolean z = needDrawCorner() || !AppPerfABUtils.isOpenPerf();
        if (z) {
            RectF rectF = this.rectF;
            if (rectF == null) {
                this.rectF = new RectF(0.0f, 0.0f, getWidth(), getHeight());
            } else {
                rectF.set(0.0f, 0.0f, getWidth(), getHeight());
            }
            canvas.saveLayer(this.rectF, imagePaint, 31);
        }
        drawBackgroud(canvas);
        super.draw(canvas);
        drawImageAfter(canvas);
        drawDebugInfo(canvas);
        if (z) {
            drawCorner(canvas);
            drawCorners(canvas);
            canvas.restore();
        }
    }

    protected void drawBackgroud(Canvas canvas) {
    }

    @Deprecated
    protected void drawCorners(Canvas canvas) {
    }

    protected void drawDebugInfo(Canvas canvas) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void drawImageAfter(Canvas canvas) {
    }

    protected void drawLeftDown(Canvas canvas) {
        if (!this.isLeftBottomCorner || this.roundLeftBottomCornerRadius <= 0) {
            return;
        }
        int height = getHeight();
        Path drawCornerPath = getDrawCornerPath();
        drawCornerPath.moveTo(0.0f, height - this.roundLeftBottomCornerRadius);
        float f = height;
        drawCornerPath.lineTo(0.0f, f);
        drawCornerPath.lineTo(this.roundLeftBottomCornerRadius, f);
        int i = this.roundLeftBottomCornerRadius;
        drawCornerPath.arcTo(new RectF(0.0f, height - (i * 2), i * 2, f), 90.0f, 90.0f);
        drawCornerPath.close();
        canvas.drawPath(drawCornerPath, roundPaint);
    }

    protected void drawLeftUp(Canvas canvas) {
        if (!this.isLeftTopCorner || this.roundLeftTopCornerRadius <= 0) {
            return;
        }
        Path drawCornerPath = getDrawCornerPath();
        drawCornerPath.moveTo(0.0f, this.roundLeftTopCornerRadius);
        drawCornerPath.lineTo(0.0f, 0.0f);
        drawCornerPath.lineTo(this.roundLeftTopCornerRadius, 0.0f);
        int i = this.roundLeftTopCornerRadius;
        drawCornerPath.arcTo(new RectF(0.0f, 0.0f, i * 2, i * 2), -90.0f, -90.0f);
        drawCornerPath.close();
        canvas.drawPath(drawCornerPath, roundPaint);
    }

    protected void drawRightDown(Canvas canvas) {
        if (!this.isRightBottomCorner || this.roundRightBottomRadius <= 0) {
            return;
        }
        int height = getHeight();
        int width = getWidth();
        Path drawCornerPath = getDrawCornerPath();
        float f = height;
        drawCornerPath.moveTo(width - this.roundRightBottomRadius, f);
        float f2 = width;
        drawCornerPath.lineTo(f2, f);
        drawCornerPath.lineTo(f2, height - this.roundRightBottomRadius);
        int i = this.roundRightBottomRadius;
        drawCornerPath.arcTo(new RectF(width - (i * 2), height - (i * 2), f2, f), 0.0f, 90.0f);
        drawCornerPath.close();
        canvas.drawPath(drawCornerPath, roundPaint);
    }

    protected void drawRightUp(Canvas canvas) {
        if (!this.isRightTopCorner || this.roundRightTopCornerRadius <= 0) {
            return;
        }
        int width = getWidth();
        Path drawCornerPath = getDrawCornerPath();
        drawCornerPath.moveTo(width - this.roundRightTopCornerRadius, 0.0f);
        float f = width;
        drawCornerPath.lineTo(f, 0.0f);
        drawCornerPath.lineTo(f, this.roundRightTopCornerRadius);
        int i = this.roundRightTopCornerRadius;
        drawCornerPath.arcTo(new RectF(width - (i * 2), 0.0f, f, i * 2), 0.0f, -90.0f);
        drawCornerPath.close();
        canvas.drawPath(drawCornerPath, roundPaint);
    }

    public boolean getOptLessRequestLayout() {
        return this.mOptLessRequestLayout;
    }

    public boolean getRoundCorner() {
        return this.roundCorner;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.uikit.extend.feature.view.TUrlImageView, android.widget.ImageView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.mFadeIn && sDegrade && !this.mFixedFadeIn) {
            Context context = getContext();
            if (context instanceof ViewContext) {
                context = ((ViewContext) context).getCurrentContext();
            }
            if (context != null && "HomePageEntry".equals(context.getClass().getSimpleName())) {
                this.mFadeIn = false;
                setFadeIn(false);
            }
            this.mFixedFadeIn = true;
        }
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.uikit.feature.view.TImageView, android.widget.ImageView, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.ratio_type != 0) {
            setMeasuredDimension(ImageView.getDefaultSize(0, i), ImageView.getDefaultSize(0, i2));
            int[] iArr = this.mSize;
            iArr[1] = 0;
            iArr[0] = 0;
            ImageViewUtils.getCalculatedSize(getContext(), this.ratio_type, getMeasuredWidth(), getMeasuredHeight(), this.M, this.D, this.mSize);
            int[] iArr2 = this.mSize;
            int i3 = iArr2[0];
            this.width = i3;
            this.height = iArr2[1];
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(i3, 1073741824), View.MeasureSpec.makeMeasureSpec(this.height, 1073741824));
            return;
        }
        this.width = getMeasuredWidth();
        this.height = getMeasuredHeight();
    }

    @Override // com.taobao.uikit.extend.feature.view.TUrlImageView, android.view.View
    public void requestLayout() {
        if (this.mForceSkipRequestLayout) {
            return;
        }
        if (!this.mOptLessRequestLayout || sNoOptLessRequestLayout || !this.mWaitImageDrawable || getLayoutParams() == null || getLayoutParams().height == -2 || getLayoutParams().width == -2) {
            super.requestLayout();
        }
    }

    public void seClipMethod(boolean z) {
        if (z) {
            setViewRoundedCorner(this, 0, 0.0f);
            setCorner(true, true, true, true);
            return;
        }
        setViewRoundedCorner(this, this.roundLeftTopCornerRadius, 0.0f);
        setCorner(false, false, false, false);
    }

    public void setCorner(boolean z, boolean z2, boolean z3, boolean z4) {
        this.isLeftTopCorner = z;
        this.isRightTopCorner = z2;
        this.isRightBottomCorner = z3;
        this.isLeftBottomCorner = z4;
        invalidate();
    }

    @Deprecated
    public void setCornerRoundColor(String str) {
    }

    @Override // com.taobao.uikit.extend.feature.view.TUrlImageView, com.taobao.uikit.feature.view.TImageView, android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        if (this.mOptLessRequestLayout && !sNoOptLessRequestLayout) {
            if (drawable != null && !(drawable instanceof ColorDrawable)) {
                this.mWaitImageDrawable = false;
            } else {
                this.mForceSkipRequestLayout = true;
            }
        }
        super.setImageDrawable(drawable);
        if (this.mForceSkipRequestLayout) {
            this.mForceSkipRequestLayout = false;
        }
    }

    @Override // com.taobao.uikit.extend.feature.view.TUrlImageView
    public void setImageUrl(String str) {
        if (!sNoEnableLayoutOptimize) {
            setEnableLayoutOptimize(true);
        }
        if (this.mOptLessRequestLayout && !sNoOptLessRequestLayout && !TextUtils.isEmpty(str)) {
            this.mWaitImageDrawable = true;
        }
        super.setImageUrl(str);
    }

    public void setOptLessRequestLayout(boolean z) {
        this.mOptLessRequestLayout = z;
    }

    public void setRatioType(int i) {
        this.ratio_type = i;
    }

    public void setRoundCorner(boolean z) {
        this.roundCorner = z;
    }

    public void setRoundLeftBottomCornerRadius(int i) {
        this.roundLeftBottomCornerRadius = i;
    }

    public void setRoundLeftTopCornerRadius(int i) {
        this.roundLeftTopCornerRadius = i;
    }

    public void setRoundRightBottomRadius(int i) {
        this.roundRightBottomRadius = i;
    }

    public void setRoundRightTopCornerRadius(int i) {
        this.roundRightTopCornerRadius = i;
    }

    @TargetApi(21)
    public void setViewRoundedCorner(View view, final int i, final float f) {
        if (Build.VERSION.SDK_INT < 21 || view == null || i < 0) {
            return;
        }
        if (i > 0) {
            view.setClipToOutline(true);
        } else {
            view.setClipToOutline(false);
        }
        view.setOutlineProvider(new ViewOutlineProvider() { // from class: com.youku.resource.widget.YKRatioImageView.1
            @Override // android.view.ViewOutlineProvider
            public void getOutline(View view2, Outline outline) {
                float f2 = f;
                if (f2 >= 0.0f) {
                    outline.setAlpha(f2);
                }
                outline.setRoundRect(0, 0, view2.getWidth(), view2.getHeight(), i);
            }
        });
    }

    public YKRatioImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mForceSkipRequestLayout = false;
        this.mOptLessRequestLayout = false;
        this.mWaitImageDrawable = false;
        this.mFadeIn = false;
        this.mFixedFadeIn = false;
        this.mSize = new int[2];
        init(context, attributeSet);
    }
}
