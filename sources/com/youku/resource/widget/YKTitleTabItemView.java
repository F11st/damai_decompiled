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
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewpager.widget.ViewPager;
import com.youku.resource.utils.AppPerfABUtils;
import com.youku.resource.widget.YKTitleTabIndicator;
import com.youku.style.IStyle;
import com.youku.style.StyleVisitor;
import java.util.HashMap;
import java.util.Map;
import tb.qb1;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public abstract class YKTitleTabItemView extends RelativeLayout implements YKTitleTabIndicator.ItemSelectListener, IStyle {
    protected ValueAnimator bigToSmall;
    protected int endColor;
    protected YKTitleTabIndicator indicator;
    protected boolean isSelected;
    private int mCurrentEndColor;
    private int mCurrentStartColor;
    protected int mPosition;
    protected View.OnClickListener mTabOnClickListener;
    protected String mText;
    protected TextView mTextView;
    protected ValueAnimator smallToBig;
    protected int startColor;
    Map styleMap;
    protected StyleVisitor styleVisitor;

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
            if (YKTitleTabItemView.this.indicator != null) {
                this.lg = null;
                LinearGradient linearGradient = new LinearGradient(0.0f, 0.0f, this.mSize, paint.descent() - paint.ascent(), this.startColor, this.endColor, Shader.TileMode.CLAMP);
                this.lg = linearGradient;
                paint.setShader(linearGradient);
            } else {
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

    public YKTitleTabItemView(Context context) {
        super(context);
        this.isSelected = false;
        this.mTabOnClickListener = new View.OnClickListener() { // from class: com.youku.resource.widget.YKTitleTabItemView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                YKTitleTabIndicator yKTitleTabIndicator = YKTitleTabItemView.this.indicator;
                qb1.a("YKTitleTabIndicator", "position = " + YKTitleTabItemView.this.indicator.mContainer.indexOfChild(view) + " is clicked", new Object[0]);
                YKTitleTabIndicator yKTitleTabIndicator2 = YKTitleTabItemView.this.indicator;
                if (yKTitleTabIndicator2 == null) {
                    return;
                }
                int indexOfChild = yKTitleTabIndicator2.mContainer.indexOfChild(view);
                YKTitleTabIndicator yKTitleTabIndicator3 = YKTitleTabItemView.this.indicator;
                if (indexOfChild == yKTitleTabIndicator3.mClickedPosition) {
                    return;
                }
                yKTitleTabIndicator3.mIsClicked = true;
                yKTitleTabIndicator3.mClickedPosition = indexOfChild;
                ViewPager viewPager = yKTitleTabIndicator3.mViewPager;
                if (viewPager != null) {
                    int currentItem = viewPager.getCurrentItem();
                    YKTitleTabItemView yKTitleTabItemView = YKTitleTabItemView.this;
                    YKTitleTabIndicator yKTitleTabIndicator4 = yKTitleTabItemView.indicator;
                    if (currentItem != yKTitleTabIndicator4.mClickedPosition) {
                        yKTitleTabItemView.sendClickTracker(yKTitleTabIndicator4.mViewPager.getCurrentItem(), YKTitleTabItemView.this.indicator.mClickedPosition);
                        YKTitleTabIndicator yKTitleTabIndicator5 = YKTitleTabItemView.this.indicator;
                        yKTitleTabIndicator5.mViewPager.setCurrentItem(yKTitleTabIndicator5.mClickedPosition, yKTitleTabIndicator5.enableSmoothScroll);
                    }
                }
                YKTitleTabIndicator yKTitleTabIndicator6 = YKTitleTabItemView.this.indicator;
                YKTitleTabIndicator.OnTabClickListener onTabClickListener = yKTitleTabIndicator6.mOnTabClickListener;
                if (onTabClickListener != null) {
                    onTabClickListener.onTabClick(view, yKTitleTabIndicator6.mClickedPosition);
                }
            }
        };
        this.startColor = 0;
        this.endColor = 0;
        this.mCurrentStartColor = 0;
        this.mCurrentEndColor = 0;
        this.styleMap = new HashMap();
    }

    public abstract void bindData(Object obj);

    public abstract TextView findTextView();

    public YKTitleTabIndicator getIndicator() {
        return this.indicator;
    }

    public int getMainRight() {
        return getRight();
    }

    public int getMainWidth() {
        return getWidth();
    }

    public SpannableStringBuilder getRadiusGradientSpan(String str, int i, int i2) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        if (i == 0 || i2 == 0) {
            i = this.indicator.getGradientTextStartColorDef();
            i2 = this.indicator.getGradientTextEndColorDef();
        }
        this.mCurrentStartColor = i;
        this.mCurrentEndColor = i2;
        spannableStringBuilder.setSpan(new LinearGradientFontSpan(this.mCurrentStartColor, this.mCurrentEndColor), 0, spannableStringBuilder.length(), 33);
        return spannableStringBuilder;
    }

    public TextView getTextView() {
        return this.mTextView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean hasGradientText() {
        YKTitleTabIndicator yKTitleTabIndicator;
        StyleVisitor styleVisitor = this.styleVisitor;
        return (styleVisitor != null && styleVisitor.hasStyleStringValue(IStyle.NAV_TEXT_SELECT_START_COLOR) && this.styleVisitor.hasStyleStringValue(IStyle.NAV_TEXT_SELECT_END_COLOR)) || !((yKTitleTabIndicator = this.indicator) == null || yKTitleTabIndicator.getGradientTextStartColorDef() == 0 || this.indicator.getGradientTextEndColorDef() == 0);
    }

    protected boolean hasImage() {
        return false;
    }

    public void initView(YKTitleTabIndicator yKTitleTabIndicator) {
        this.indicator = yKTitleTabIndicator;
        TextView findTextView = findTextView();
        this.mTextView = findTextView;
        findTextView.setGravity(17);
        this.mTextView.setIncludeFontPadding(false);
        this.mTextView.setTextSize(0, yKTitleTabIndicator.getTextSizeDef());
        this.mTextView.setPadding(0, 0, 0, 0);
        setOnClickListener(this.mTabOnClickListener);
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
        YKTitleTabIndicator yKTitleTabIndicator = this.indicator;
        if (yKTitleTabIndicator.ableTextAnim) {
            final int i = yKTitleTabIndicator.mTextSizeDef;
            final int i2 = yKTitleTabIndicator.mTextSizeSelected;
            if (!hasImage() && ((valueAnimator = this.smallToBig) == null || !valueAnimator.isRunning())) {
                ValueAnimator ofFloat = ValueAnimator.ofFloat(i, i2);
                this.smallToBig = ofFloat;
                ofFloat.setDuration(this.indicator.textAnimDuring);
                this.smallToBig.setInterpolator(new LinearInterpolator());
                this.smallToBig.setRepeatCount(0);
                this.smallToBig.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.youku.resource.widget.YKTitleTabItemView.2
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator2) {
                        YKTitleTabItemView.this.getTextView().setTextSize(0, ((Float) valueAnimator2.getAnimatedValue()).floatValue());
                    }
                });
                this.smallToBig.addListener(new AnimatorListenerAdapter() { // from class: com.youku.resource.widget.YKTitleTabItemView.3
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animator) {
                        super.onAnimationCancel(animator);
                        YKTitleTabItemView.this.getTextView().setTextSize(0, i2);
                        YKTitleTabItemView.this.smallToBig = null;
                    }

                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        super.onAnimationEnd(animator);
                        YKTitleTabItemView.this.getTextView().setTextSize(0, i2);
                        YKTitleTabItemView.this.smallToBig = null;
                    }

                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                        super.onAnimationStart(animator);
                        YKTitleTabItemView.this.getTextView().setTextSize(0, i);
                    }
                });
                this.smallToBig.start();
            }
            this.mTextView.setGravity(80);
            this.mTextView.setPadding(0, 0, 0, this.indicator.mTextSelectedBottomPadding);
        }
        if (this.mTextView == null || !hasGradientText() || TextUtils.isEmpty(this.mText)) {
            return;
        }
        this.mTextView.setText(getRadiusGradientSpan(this.mText, this.startColor, this.endColor));
    }

    @Override // com.youku.resource.widget.YKTitleTabIndicator.ItemSelectListener
    public void onUnSelected() {
        ValueAnimator valueAnimator;
        if (this.isSelected) {
            this.isSelected = false;
            if (AppPerfABUtils.isOpenDegrade()) {
                getTextView().setTextSize(0, this.indicator.mTextSizeDef);
                return;
            }
            YKTitleTabIndicator yKTitleTabIndicator = this.indicator;
            if (yKTitleTabIndicator.ableTextAnim) {
                final int i = yKTitleTabIndicator.mTextSizeSelected;
                final int i2 = yKTitleTabIndicator.mTextSizeDef;
                if (!hasImage() && ((valueAnimator = this.bigToSmall) == null || !valueAnimator.isRunning())) {
                    ValueAnimator ofFloat = ValueAnimator.ofFloat(i, i2);
                    this.bigToSmall = ofFloat;
                    ofFloat.setDuration(this.indicator.textAnimDuring);
                    this.bigToSmall.setInterpolator(new LinearInterpolator());
                    this.bigToSmall.setRepeatCount(0);
                    this.bigToSmall.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.youku.resource.widget.YKTitleTabItemView.4
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator2) {
                            YKTitleTabItemView.this.getTextView().setTextSize(0, ((Float) valueAnimator2.getAnimatedValue()).floatValue());
                        }
                    });
                    this.bigToSmall.addListener(new AnimatorListenerAdapter() { // from class: com.youku.resource.widget.YKTitleTabItemView.5
                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationCancel(Animator animator) {
                            super.onAnimationCancel(animator);
                            YKTitleTabItemView.this.getTextView().setTextSize(0, i2);
                            YKTitleTabItemView.this.bigToSmall = null;
                        }

                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animator) {
                            super.onAnimationEnd(animator);
                            YKTitleTabItemView.this.getTextView().setTextSize(0, i2);
                            YKTitleTabItemView.this.bigToSmall = null;
                        }

                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationStart(Animator animator) {
                            super.onAnimationStart(animator);
                            YKTitleTabItemView.this.getTextView().setTextSize(0, i);
                        }
                    });
                    this.bigToSmall.start();
                }
                this.mTextView.setGravity(17);
                this.mTextView.setPadding(0, 0, 0, 0);
            }
            TextView textView = this.mTextView;
            if (textView == null || !(textView.getText() instanceof SpannedString) || TextUtils.isEmpty(this.mText)) {
                return;
            }
            this.mCurrentStartColor = 0;
            this.mCurrentEndColor = 0;
            this.mTextView.setText(this.mText);
        }
    }

    @Override // com.youku.style.IStyle
    public void resetStyle() {
        this.startColor = 0;
        this.endColor = 0;
        this.mCurrentStartColor = 0;
        this.mCurrentEndColor = 0;
        this.mTextView.setText(this.mText);
        this.styleVisitor = null;
        Map map = this.styleMap;
        if (map != null) {
            map.clear();
        }
    }

    public void sendClickTracker(int i, int i2) {
    }

    @Override // com.youku.style.IStyle
    public void setStyle(Map map) {
        if (this.indicator == null) {
            return;
        }
        if (map != null && map.size() > 0) {
            this.styleMap.clear();
            this.styleMap.putAll(map);
            this.styleVisitor = new StyleVisitor(this.styleMap);
            if (hasGradientText()) {
                this.startColor = this.styleVisitor.hasStyleValue(IStyle.NAV_TEXT_SELECT_START_COLOR) ? this.styleVisitor.getStyleColor(IStyle.NAV_TEXT_SELECT_START_COLOR) : this.indicator.getGradientTextStartColorDef();
                int styleColor = this.styleVisitor.hasStyleValue(IStyle.NAV_TEXT_SELECT_END_COLOR) ? this.styleVisitor.getStyleColor(IStyle.NAV_TEXT_SELECT_END_COLOR) : this.indicator.getGradientTextEndColorDef();
                this.endColor = styleColor;
                setTextGradientColors(this.startColor, styleColor);
                return;
            }
            this.startColor = 0;
            this.endColor = 0;
            this.mCurrentStartColor = 0;
            this.mCurrentEndColor = 0;
            this.mTextView.setText(this.mText);
            return;
        }
        Map map2 = this.styleMap;
        if (map2 != null) {
            map2.clear();
        }
        this.styleVisitor = null;
        if (hasGradientText()) {
            this.startColor = this.indicator.getGradientTextStartColorDef();
            int gradientTextEndColorDef = this.indicator.getGradientTextEndColorDef();
            this.endColor = gradientTextEndColorDef;
            setTextGradientColors(this.startColor, gradientTextEndColorDef);
            return;
        }
        this.startColor = 0;
        this.endColor = 0;
        this.mCurrentStartColor = 0;
        this.mCurrentEndColor = 0;
        this.mTextView.setText(this.mText);
    }

    public void setText(String str) {
        this.mText = str;
        this.mTextView.setText(str);
    }

    public void setTextGradientColors(int i, int i2) {
        YKTitleTabIndicator yKTitleTabIndicator = this.indicator;
        if (yKTitleTabIndicator == null) {
            return;
        }
        if (i == 0 || i2 == 0) {
            i = yKTitleTabIndicator.getGradientTextStartColorDef();
            i2 = this.indicator.getGradientTextEndColorDef();
        }
        if ((this.mCurrentStartColor == i && this.mCurrentEndColor == i2) || !this.isSelected || this.mTextView == null || !hasGradientText() || TextUtils.isEmpty(this.mText)) {
            return;
        }
        this.mTextView.setText(getRadiusGradientSpan(this.mText, i, i2));
    }

    public YKTitleTabItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.isSelected = false;
        this.mTabOnClickListener = new View.OnClickListener() { // from class: com.youku.resource.widget.YKTitleTabItemView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                YKTitleTabIndicator yKTitleTabIndicator = YKTitleTabItemView.this.indicator;
                qb1.a("YKTitleTabIndicator", "position = " + YKTitleTabItemView.this.indicator.mContainer.indexOfChild(view) + " is clicked", new Object[0]);
                YKTitleTabIndicator yKTitleTabIndicator2 = YKTitleTabItemView.this.indicator;
                if (yKTitleTabIndicator2 == null) {
                    return;
                }
                int indexOfChild = yKTitleTabIndicator2.mContainer.indexOfChild(view);
                YKTitleTabIndicator yKTitleTabIndicator3 = YKTitleTabItemView.this.indicator;
                if (indexOfChild == yKTitleTabIndicator3.mClickedPosition) {
                    return;
                }
                yKTitleTabIndicator3.mIsClicked = true;
                yKTitleTabIndicator3.mClickedPosition = indexOfChild;
                ViewPager viewPager = yKTitleTabIndicator3.mViewPager;
                if (viewPager != null) {
                    int currentItem = viewPager.getCurrentItem();
                    YKTitleTabItemView yKTitleTabItemView = YKTitleTabItemView.this;
                    YKTitleTabIndicator yKTitleTabIndicator4 = yKTitleTabItemView.indicator;
                    if (currentItem != yKTitleTabIndicator4.mClickedPosition) {
                        yKTitleTabItemView.sendClickTracker(yKTitleTabIndicator4.mViewPager.getCurrentItem(), YKTitleTabItemView.this.indicator.mClickedPosition);
                        YKTitleTabIndicator yKTitleTabIndicator5 = YKTitleTabItemView.this.indicator;
                        yKTitleTabIndicator5.mViewPager.setCurrentItem(yKTitleTabIndicator5.mClickedPosition, yKTitleTabIndicator5.enableSmoothScroll);
                    }
                }
                YKTitleTabIndicator yKTitleTabIndicator6 = YKTitleTabItemView.this.indicator;
                YKTitleTabIndicator.OnTabClickListener onTabClickListener = yKTitleTabIndicator6.mOnTabClickListener;
                if (onTabClickListener != null) {
                    onTabClickListener.onTabClick(view, yKTitleTabIndicator6.mClickedPosition);
                }
            }
        };
        this.startColor = 0;
        this.endColor = 0;
        this.mCurrentStartColor = 0;
        this.mCurrentEndColor = 0;
        this.styleMap = new HashMap();
    }

    public YKTitleTabItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.isSelected = false;
        this.mTabOnClickListener = new View.OnClickListener() { // from class: com.youku.resource.widget.YKTitleTabItemView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                YKTitleTabIndicator yKTitleTabIndicator = YKTitleTabItemView.this.indicator;
                qb1.a("YKTitleTabIndicator", "position = " + YKTitleTabItemView.this.indicator.mContainer.indexOfChild(view) + " is clicked", new Object[0]);
                YKTitleTabIndicator yKTitleTabIndicator2 = YKTitleTabItemView.this.indicator;
                if (yKTitleTabIndicator2 == null) {
                    return;
                }
                int indexOfChild = yKTitleTabIndicator2.mContainer.indexOfChild(view);
                YKTitleTabIndicator yKTitleTabIndicator3 = YKTitleTabItemView.this.indicator;
                if (indexOfChild == yKTitleTabIndicator3.mClickedPosition) {
                    return;
                }
                yKTitleTabIndicator3.mIsClicked = true;
                yKTitleTabIndicator3.mClickedPosition = indexOfChild;
                ViewPager viewPager = yKTitleTabIndicator3.mViewPager;
                if (viewPager != null) {
                    int currentItem = viewPager.getCurrentItem();
                    YKTitleTabItemView yKTitleTabItemView = YKTitleTabItemView.this;
                    YKTitleTabIndicator yKTitleTabIndicator4 = yKTitleTabItemView.indicator;
                    if (currentItem != yKTitleTabIndicator4.mClickedPosition) {
                        yKTitleTabItemView.sendClickTracker(yKTitleTabIndicator4.mViewPager.getCurrentItem(), YKTitleTabItemView.this.indicator.mClickedPosition);
                        YKTitleTabIndicator yKTitleTabIndicator5 = YKTitleTabItemView.this.indicator;
                        yKTitleTabIndicator5.mViewPager.setCurrentItem(yKTitleTabIndicator5.mClickedPosition, yKTitleTabIndicator5.enableSmoothScroll);
                    }
                }
                YKTitleTabIndicator yKTitleTabIndicator6 = YKTitleTabItemView.this.indicator;
                YKTitleTabIndicator.OnTabClickListener onTabClickListener = yKTitleTabIndicator6.mOnTabClickListener;
                if (onTabClickListener != null) {
                    onTabClickListener.onTabClick(view, yKTitleTabIndicator6.mClickedPosition);
                }
            }
        };
        this.startColor = 0;
        this.endColor = 0;
        this.mCurrentStartColor = 0;
        this.mCurrentEndColor = 0;
        this.styleMap = new HashMap();
    }
}
