package com.youku.resource.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.text.SpannableStringBuilder;
import android.text.SpannedString;
import android.text.TextUtils;
import android.text.style.ReplacementSpan;
import android.util.AttributeSet;
import android.view.animation.LinearInterpolator;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.youku.resource.utils.AppPerfABUtils;
import com.youku.resource.widget.YKTitleTabIndicator;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public abstract class YKTitleTabItemViewRv extends RelativeLayout implements YKTitleTabIndicator.ItemSelectListener {
    protected ValueAnimator bigToSmall;
    protected int endColor;
    protected YKTitleTabIndicatorRv indicator;
    protected boolean isSelected;
    protected int mPosition;
    protected String mText;
    protected TextView mTextView;
    protected ValueAnimator smallToBig;
    protected int startColor;

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public class LinearGradientFontSpan extends ReplacementSpan {
        private int endColor;
        LinearGradient lg = null;
        private int mSize;
        private int startColor;

        public LinearGradientFontSpan(int i, int i2) {
            this.startColor = i;
            this.endColor = i2;
        }

        @Override // android.text.style.ReplacementSpan
        public void draw(Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, Paint paint) {
            YKTitleTabIndicatorRv yKTitleTabIndicatorRv = YKTitleTabItemViewRv.this.indicator;
            if (yKTitleTabIndicatorRv != null && yKTitleTabIndicatorRv.isDefaultColor) {
                this.lg = null;
                LinearGradient linearGradient = new LinearGradient(0.0f, 0.0f, this.mSize, 0.0f, this.startColor, this.endColor, Shader.TileMode.CLAMP);
                this.lg = linearGradient;
                paint.setShader(linearGradient);
            } else if (yKTitleTabIndicatorRv != null) {
                this.lg = null;
                paint.setShader(null);
            }
            canvas.drawText(charSequence, i, i2, f, i4, paint);
        }

        @Override // android.text.style.ReplacementSpan
        public int getSize(Paint paint, CharSequence charSequence, int i, int i2, Paint.FontMetricsInt fontMetricsInt) {
            this.mSize = (int) paint.measureText(charSequence, i, i2);
            Paint.FontMetricsInt fontMetricsInt2 = paint.getFontMetricsInt();
            if (fontMetricsInt != null) {
                fontMetricsInt.top = fontMetricsInt2.top;
                fontMetricsInt.ascent = fontMetricsInt2.ascent;
                fontMetricsInt.descent = fontMetricsInt2.descent;
                fontMetricsInt.bottom = fontMetricsInt2.bottom;
            }
            return this.mSize;
        }
    }

    public YKTitleTabItemViewRv(Context context) {
        super(context);
        this.isSelected = false;
        this.startColor = Integer.MAX_VALUE;
        this.endColor = Integer.MAX_VALUE;
    }

    public abstract void bindData(Object obj);

    public abstract TextView findTextView();

    public SpannableStringBuilder getRadiusGradientSpan(String str, int i, int i2) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        spannableStringBuilder.setSpan(new LinearGradientFontSpan(i, i2), 0, spannableStringBuilder.length(), 33);
        return spannableStringBuilder;
    }

    public TextView getTextView() {
        return this.mTextView;
    }

    protected boolean hasGradientText() {
        return false;
    }

    protected boolean hasImage() {
        return false;
    }

    public void initView(YKTitleTabIndicatorRv yKTitleTabIndicatorRv) {
        this.indicator = yKTitleTabIndicatorRv;
        TextView findTextView = findTextView();
        this.mTextView = findTextView;
        findTextView.setGravity(17);
        this.mTextView.setIncludeFontPadding(false);
        this.mTextView.setTextSize(0, yKTitleTabIndicatorRv.getTextSizeDef());
        this.mTextView.setPadding(0, 0, 0, 0);
    }

    public boolean needUpdate(Object obj) {
        return true;
    }

    @Override // com.youku.resource.widget.YKTitleTabIndicator.ItemSelectListener
    public void onSelected() {
        ValueAnimator valueAnimator;
        if (this.isSelected) {
            return;
        }
        this.isSelected = true;
        if (AppPerfABUtils.isOpenDegrade()) {
            getTextView().setTextSize(0, this.indicator.mTextSizeSelected);
            return;
        }
        YKTitleTabIndicatorRv yKTitleTabIndicatorRv = this.indicator;
        if (yKTitleTabIndicatorRv.ableTextAnim) {
            final int i = yKTitleTabIndicatorRv.mTextSizeDef;
            final int i2 = yKTitleTabIndicatorRv.mTextSizeSelected;
            if (!hasImage() && ((valueAnimator = this.smallToBig) == null || !valueAnimator.isRunning())) {
                ValueAnimator ofFloat = ValueAnimator.ofFloat(i, i2);
                this.smallToBig = ofFloat;
                ofFloat.setDuration(this.indicator.textAnimDuring);
                this.smallToBig.setInterpolator(new LinearInterpolator());
                this.smallToBig.setRepeatCount(0);
                this.smallToBig.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.youku.resource.widget.YKTitleTabItemViewRv.1
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator2) {
                        YKTitleTabItemViewRv.this.getTextView().setTextSize(0, ((Float) valueAnimator2.getAnimatedValue()).floatValue());
                    }
                });
                this.smallToBig.addListener(new AnimatorListenerAdapter() { // from class: com.youku.resource.widget.YKTitleTabItemViewRv.2
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animator) {
                        super.onAnimationCancel(animator);
                        YKTitleTabItemViewRv.this.getTextView().setTextSize(0, i2);
                        YKTitleTabItemViewRv.this.smallToBig = null;
                    }

                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        super.onAnimationEnd(animator);
                        YKTitleTabItemViewRv.this.getTextView().setTextSize(0, i2);
                        YKTitleTabItemViewRv.this.smallToBig = null;
                    }

                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                        super.onAnimationStart(animator);
                        YKTitleTabItemViewRv.this.getTextView().setTextSize(0, i);
                    }
                });
                this.smallToBig.start();
            }
            this.mTextView.setGravity(80);
            this.mTextView.setPadding(0, 0, 0, this.indicator.mTextSelectedBottomPadding);
        }
        if (hasImage() || this.mTextView == null || !hasGradientText() || TextUtils.isEmpty(this.mText)) {
            return;
        }
        this.mTextView.setText(getRadiusGradientSpan(this.mText, this.startColor, this.endColor));
    }

    @Override // com.youku.resource.widget.YKTitleTabIndicator.ItemSelectListener
    public void onUnSelected() {
        TextView textView;
        ValueAnimator valueAnimator;
        if (this.isSelected) {
            this.isSelected = false;
            if (AppPerfABUtils.isOpenDegrade()) {
                getTextView().setTextSize(0, this.indicator.mTextSizeDef);
                return;
            }
            YKTitleTabIndicatorRv yKTitleTabIndicatorRv = this.indicator;
            if (yKTitleTabIndicatorRv.ableTextAnim) {
                final int i = yKTitleTabIndicatorRv.mTextSizeSelected;
                final int i2 = yKTitleTabIndicatorRv.mTextSizeDef;
                if (!hasImage() && ((valueAnimator = this.bigToSmall) == null || !valueAnimator.isRunning())) {
                    ValueAnimator ofFloat = ValueAnimator.ofFloat(i, i2);
                    this.bigToSmall = ofFloat;
                    ofFloat.setDuration(this.indicator.textAnimDuring);
                    this.bigToSmall.setInterpolator(new LinearInterpolator());
                    this.bigToSmall.setRepeatCount(0);
                    this.bigToSmall.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.youku.resource.widget.YKTitleTabItemViewRv.3
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator2) {
                            YKTitleTabItemViewRv.this.getTextView().setTextSize(0, ((Float) valueAnimator2.getAnimatedValue()).floatValue());
                        }
                    });
                    this.bigToSmall.addListener(new AnimatorListenerAdapter() { // from class: com.youku.resource.widget.YKTitleTabItemViewRv.4
                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationCancel(Animator animator) {
                            super.onAnimationCancel(animator);
                            YKTitleTabItemViewRv.this.getTextView().setTextSize(0, i2);
                            YKTitleTabItemViewRv.this.bigToSmall = null;
                        }

                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animator) {
                            super.onAnimationEnd(animator);
                            YKTitleTabItemViewRv.this.getTextView().setTextSize(0, i2);
                            YKTitleTabItemViewRv.this.bigToSmall = null;
                        }

                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationStart(Animator animator) {
                            super.onAnimationStart(animator);
                            YKTitleTabItemViewRv.this.getTextView().setTextSize(0, i);
                        }
                    });
                    this.bigToSmall.start();
                }
                this.mTextView.setGravity(17);
                this.mTextView.setPadding(0, 0, 0, 0);
            }
            if (hasImage() || (textView = this.mTextView) == null || !(textView.getText() instanceof SpannedString) || TextUtils.isEmpty(this.mText)) {
                return;
            }
            this.mTextView.setText(this.mText);
        }
    }

    public void sendClickTracker(int i, int i2) {
    }

    public void setText(String str) {
        this.mText = str;
        this.mTextView.setText(str);
    }

    public void setTextGradientColors(int i, int i2) {
        this.startColor = i;
        this.endColor = i2;
    }

    public YKTitleTabItemViewRv(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.isSelected = false;
        this.startColor = Integer.MAX_VALUE;
        this.endColor = Integer.MAX_VALUE;
    }

    public YKTitleTabItemViewRv(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.isSelected = false;
        this.startColor = Integer.MAX_VALUE;
        this.endColor = Integer.MAX_VALUE;
    }
}
