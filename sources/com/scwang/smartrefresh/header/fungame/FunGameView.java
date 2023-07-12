package com.scwang.smartrefresh.header.fungame;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.core.graphics.ColorUtils;
import com.scwang.smartrefresh.header.R$string;
import com.scwang.smartrefresh.header.R$styleable;
import com.scwang.smartrefresh.header.fungame.FunGameView;
import com.scwang.smartrefresh.layout.api.RefreshKernel;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import com.scwang.smartrefresh.layout.util.DensityUtil;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public abstract class FunGameView<T extends FunGameView> extends FunGameBase {
    protected static final int STATUS_GAME_FAIL = 4;
    protected static final int STATUS_GAME_FINISHED = 3;
    protected static final int STATUS_GAME_OVER = 2;
    protected static final int STATUS_GAME_PLAY = 1;
    protected static final int STATUS_GAME_PREPARE = 0;
    protected static final float VIEW_HEIGHT_RATIO = 0.161f;
    protected float DIVIDING_LINE_SIZE;
    protected float controllerPosition;
    protected int controllerSize;
    protected int lModelColor;
    protected int mBackColor;
    protected int mBoundaryColor;
    protected int mHalfHeaderHeight;
    public String mMaskTextBottom;
    public String mMaskTextTopPull;
    public String mMaskTextTopRelease;
    protected TextView mMaskViewBottom;
    protected TextView mMaskViewTop;
    protected int mModelColor;
    protected Paint mPaint;
    protected Paint mPaintText;
    protected View mShadowView;
    public String mTextGameOver;
    public String mTextLoading;
    public String mTextLoadingFailed;
    public String mTextLoadingFinish;
    protected int rModelColor;
    protected int status;

    /* compiled from: Taobao */
    /* loaded from: classes6.dex */
    class a extends AnimatorListenerAdapter {
        final /* synthetic */ View a;
        final /* synthetic */ View b;
        final /* synthetic */ View c;

        a(View view, View view2, View view3) {
            this.a = view;
            this.b = view2;
            this.c = view3;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.a.setVisibility(8);
            this.b.setVisibility(8);
            this.c.setVisibility(8);
            FunGameView.this.postStatus(1);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes6.dex */
    static /* synthetic */ class b {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[RefreshState.values().length];
            a = iArr;
            try {
                iArr[RefreshState.PullDownToRefresh.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[RefreshState.ReleaseToRefresh.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public FunGameView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.DIVIDING_LINE_SIZE = 1.0f;
        this.status = 0;
        this.mBoundaryColor = -10461088;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.FunGameView);
        this.mMaskTextBottom = getResources().getString(R$string.fgh_mask_bottom);
        this.mMaskTextTopPull = getResources().getString(R$string.fgh_mask_top_pull);
        this.mMaskTextTopRelease = getResources().getString(R$string.fgh_mask_top_release);
        int i2 = R$styleable.FunGameView_fghMaskTextTop;
        if (obtainStyledAttributes.hasValue(i2)) {
            String string = obtainStyledAttributes.getString(i2);
            this.mMaskTextTopRelease = string;
            this.mMaskTextTopPull = string;
        }
        int i3 = R$styleable.FunGameView_fghMaskTextTopPull;
        if (obtainStyledAttributes.hasValue(i3)) {
            this.mMaskTextTopPull = obtainStyledAttributes.getString(i3);
        }
        int i4 = R$styleable.FunGameView_fghMaskTextTopRelease;
        if (obtainStyledAttributes.hasValue(i4)) {
            this.mMaskTextTopRelease = obtainStyledAttributes.getString(i4);
        }
        int i5 = R$styleable.FunGameView_fghMaskTextBottom;
        if (obtainStyledAttributes.hasValue(i5)) {
            this.mMaskTextBottom = obtainStyledAttributes.getString(i5);
        }
        int applyDimension = (int) TypedValue.applyDimension(2, 16.0f, getResources().getDisplayMetrics());
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(R$styleable.FunGameView_fghMaskTextSizeTop, applyDimension);
        int dimensionPixelSize2 = obtainStyledAttributes.getDimensionPixelSize(R$styleable.FunGameView_fghMaskTextSizeBottom, (applyDimension * 14) / 16);
        RelativeLayout relativeLayout = new RelativeLayout(context);
        RelativeLayout relativeLayout2 = new RelativeLayout(context);
        this.mShadowView = relativeLayout2;
        relativeLayout2.setBackgroundColor(-12961222);
        this.mMaskViewTop = createMaskView(context, this.mMaskTextTopPull, dimensionPixelSize, 80);
        this.mMaskViewBottom = createMaskView(context, this.mMaskTextBottom, dimensionPixelSize2, 48);
        if (!isInEditMode()) {
            int dp2px = DensityUtil.dp2px(100.0f);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, dp2px);
            addView(this.mShadowView, layoutParams);
            addView(relativeLayout, layoutParams);
            this.mHalfHeaderHeight = (int) (dp2px * 0.5f);
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, this.mHalfHeaderHeight);
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, this.mHalfHeaderHeight);
            layoutParams3.topMargin = dp2px - this.mHalfHeaderHeight;
            relativeLayout.addView(this.mMaskViewTop, layoutParams2);
            relativeLayout.addView(this.mMaskViewBottom, layoutParams3);
        }
        this.DIVIDING_LINE_SIZE = Math.max(1, DensityUtil.dp2px(0.5f));
        Paint paint = new Paint(1);
        this.mPaint = paint;
        paint.setStrokeWidth(this.DIVIDING_LINE_SIZE);
        this.controllerPosition = this.DIVIDING_LINE_SIZE;
        TextPaint textPaint = new TextPaint(1);
        this.mPaintText = textPaint;
        textPaint.setColor(-4078910);
        this.mTextGameOver = context.getString(R$string.fgh_text_game_over);
        this.mTextLoading = context.getString(R$string.fgh_text_loading);
        this.mTextLoadingFinish = context.getString(R$string.fgh_text_loading_finish);
        this.mTextLoadingFailed = context.getString(R$string.fgh_text_loading_failed);
        this.mBackColor = obtainStyledAttributes.getColor(R$styleable.FunGameView_fghBackColor, 0);
        this.lModelColor = obtainStyledAttributes.getColor(R$styleable.FunGameView_fghLeftColor, -16777216);
        this.mModelColor = obtainStyledAttributes.getColor(R$styleable.FunGameView_fghMiddleColor, -16777216);
        this.rModelColor = obtainStyledAttributes.getColor(R$styleable.FunGameView_fghRightColor, -5921371);
        int i6 = R$styleable.FunGameView_fghTextGameOver;
        if (obtainStyledAttributes.hasValue(i6)) {
            this.mTextGameOver = obtainStyledAttributes.getString(i6);
        }
        int i7 = R$styleable.FunGameView_fghTextLoading;
        if (obtainStyledAttributes.hasValue(i7)) {
            this.mTextLoading = obtainStyledAttributes.getString(i7);
        }
        int i8 = R$styleable.FunGameView_fghTextLoadingFinished;
        if (obtainStyledAttributes.hasValue(i8)) {
            this.mTextLoadingFinish = obtainStyledAttributes.getString(i8);
        }
        int i9 = R$styleable.FunGameView_fghTextLoadingFailed;
        if (obtainStyledAttributes.hasValue(i9)) {
            this.mTextLoadingFailed = obtainStyledAttributes.getString(i9);
        }
        obtainStyledAttributes.recycle();
    }

    private void drawBoundary(Canvas canvas, int i, int i2) {
        this.mPaint.setColor(this.mBackColor);
        float f = i;
        float f2 = i2;
        canvas.drawRect(0.0f, 0.0f, f, f2, this.mPaint);
        this.mPaint.setColor(this.mBoundaryColor);
        canvas.drawLine(0.0f, 0.0f, f, 0.0f, this.mPaint);
        float f3 = this.DIVIDING_LINE_SIZE;
        canvas.drawLine(0.0f, f2 - f3, f, f2 - f3, this.mPaint);
    }

    private void drawText(Canvas canvas, int i, int i2) {
        int i3 = this.status;
        if (i3 == 0 || i3 == 1) {
            this.mPaintText.setTextSize(DensityUtil.dp2px(25.0f));
            promptText(canvas, this.mTextLoading, i, i2);
        } else if (i3 == 2) {
            this.mPaintText.setTextSize(DensityUtil.dp2px(25.0f));
            promptText(canvas, this.mTextGameOver, i, i2);
        } else if (i3 == 3) {
            this.mPaintText.setTextSize(DensityUtil.dp2px(20.0f));
            promptText(canvas, this.mTextLoadingFinish, i, i2);
        } else if (i3 != 4) {
        } else {
            this.mPaintText.setTextSize(DensityUtil.dp2px(20.0f));
            promptText(canvas, this.mTextLoadingFailed, i, i2);
        }
    }

    private void promptText(Canvas canvas, String str, int i, int i2) {
        canvas.drawText(str, (i - this.mPaintText.measureText(str)) * 0.5f, (i2 * 0.5f) - ((this.mPaintText.ascent() + this.mPaintText.descent()) * 0.5f), this.mPaintText);
    }

    protected TextView createMaskView(Context context, String str, int i, int i2) {
        TextView textView = new TextView(context);
        textView.setTextColor(-16777216);
        textView.setGravity(i2 | 1);
        textView.setTextSize(0, i);
        textView.setText(str);
        textView.setBackgroundColor(-1);
        return textView;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        int width = getWidth();
        int i = this.mHeaderHeight;
        drawBoundary(canvas, width, i);
        drawText(canvas, width, i);
        drawGame(canvas, width, i);
        super.dispatchDraw(canvas);
    }

    protected abstract void drawGame(Canvas canvas, int i, int i2);

    @Override // com.scwang.smartrefresh.header.fungame.FunGameBase, com.scwang.smartrefresh.layout.internal.InternalAbstract, com.scwang.smartrefresh.layout.api.RefreshInternal
    public int onFinish(@NonNull RefreshLayout refreshLayout, boolean z) {
        if (this.mManualOperation) {
            postStatus(z ? 3 : 4);
        } else {
            postStatus(0);
            TextView textView = this.mMaskViewTop;
            TextView textView2 = this.mMaskViewBottom;
            View view = this.mShadowView;
            textView.setTranslationY(textView.getTranslationY() + this.mHalfHeaderHeight);
            textView2.setTranslationY(textView2.getTranslationY() - this.mHalfHeaderHeight);
            view.setAlpha(1.0f);
            textView.setVisibility(0);
            textView2.setVisibility(0);
            view.setVisibility(0);
        }
        return super.onFinish(refreshLayout, z);
    }

    @Override // com.scwang.smartrefresh.header.fungame.FunGameBase, com.scwang.smartrefresh.layout.internal.InternalAbstract, com.scwang.smartrefresh.layout.api.RefreshInternal
    public void onInitialized(@NonNull RefreshKernel refreshKernel, int i, int i2) {
        if (this.mHeaderHeight != i && !isInEditMode()) {
            TextView textView = this.mMaskViewTop;
            TextView textView2 = this.mMaskViewBottom;
            this.mHalfHeaderHeight = (int) (i * 0.5f);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) textView.getLayoutParams();
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) textView2.getLayoutParams();
            int i3 = this.mHalfHeaderHeight;
            layoutParams2.height = i3;
            layoutParams.height = i3;
            layoutParams2.topMargin = i - i3;
            textView.setLayoutParams(layoutParams);
            textView2.setLayoutParams(layoutParams2);
        }
        super.onInitialized(refreshKernel, i, i2);
        postStatus(0);
    }

    @Override // com.scwang.smartrefresh.header.fungame.FunGameBase
    protected void onManualOperationMove(float f, int i, int i2, int i3) {
        float max = Math.max(i, 0);
        float f2 = (this.mHeaderHeight - (this.DIVIDING_LINE_SIZE * 2.0f)) - this.controllerSize;
        if (max > f2) {
            max = f2;
        }
        this.controllerPosition = max;
        postInvalidate();
    }

    @Override // com.scwang.smartrefresh.header.fungame.FunGameBase, com.scwang.smartrefresh.layout.internal.InternalAbstract, com.scwang.smartrefresh.layout.api.RefreshInternal
    public void onStartAnimator(@NonNull RefreshLayout refreshLayout, int i, int i2) {
        super.onStartAnimator(refreshLayout, i, i2);
        TextView textView = this.mMaskViewTop;
        TextView textView2 = this.mMaskViewBottom;
        View view = this.mShadowView;
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(ObjectAnimator.ofFloat(textView, "translationY", textView.getTranslationY(), -this.mHalfHeaderHeight)).with(ObjectAnimator.ofFloat(textView2, "translationY", textView2.getTranslationY(), this.mHalfHeaderHeight)).with(ObjectAnimator.ofFloat(view, "alpha", view.getAlpha(), 0.0f));
        animatorSet.addListener(new a(textView, textView2, view));
        animatorSet.setDuration(800L);
        animatorSet.setStartDelay(200L);
        animatorSet.start();
    }

    @Override // com.scwang.smartrefresh.header.fungame.FunGameBase, com.scwang.smartrefresh.layout.internal.InternalAbstract, com.scwang.smartrefresh.layout.listener.OnStateChangedListener
    public void onStateChanged(@NonNull RefreshLayout refreshLayout, @NonNull RefreshState refreshState, @NonNull RefreshState refreshState2) {
        super.onStateChanged(refreshLayout, refreshState, refreshState2);
        int i = b.a[refreshState2.ordinal()];
        if (i == 1) {
            this.mMaskViewTop.setText(this.mMaskTextTopPull);
        } else if (i != 2) {
        } else {
            this.mMaskViewTop.setText(this.mMaskTextTopRelease);
        }
    }

    public void postStatus(int i) {
        this.status = i;
        if (i == 0) {
            resetConfigParams();
        }
        postInvalidate();
    }

    protected abstract void resetConfigParams();

    @Override // com.scwang.smartrefresh.layout.internal.InternalAbstract, com.scwang.smartrefresh.layout.api.RefreshInternal
    @Deprecated
    public void setPrimaryColors(@ColorInt int... iArr) {
        super.setPrimaryColors(iArr);
        if (iArr.length > 0) {
            this.mMaskViewTop.setTextColor(iArr[0]);
            this.mMaskViewBottom.setTextColor(iArr[0]);
            int i = iArr[0];
            this.mBackColor = i;
            this.mBoundaryColor = i;
            if (i == 0 || i == -1) {
                this.mBoundaryColor = -10461088;
            }
            if (iArr.length > 1) {
                TextView textView = this.mMaskViewTop;
                TextView textView2 = this.mMaskViewBottom;
                this.mShadowView.setBackgroundColor(iArr[1]);
                textView.setBackgroundColor(iArr[1]);
                textView2.setBackgroundColor(iArr[1]);
                this.mModelColor = iArr[1];
                this.lModelColor = ColorUtils.setAlphaComponent(iArr[1], 225);
                this.rModelColor = ColorUtils.setAlphaComponent(iArr[1], 200);
                this.mPaintText.setColor(ColorUtils.setAlphaComponent(iArr[1], 150));
            }
        }
    }
}
