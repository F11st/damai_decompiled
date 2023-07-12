package com.alient.onearch.adapter.widget.banner;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.RelativeLayout;
import androidx.annotation.ColorInt;
import androidx.annotation.Nullable;
import com.alient.onearch.adapter.R;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class IndicatorView extends View implements Indicator {
    private Interpolator accelerateInterpolator;
    private final Paint indicatorPaint;
    private float indicatorRadius;
    private float indicatorRatio;
    private float indicatorSelectedRadius;
    private float indicatorSelectedRatio;
    private float indicatorSpacing;
    private int indicatorStyle;
    private final Interpolator interpolator;
    private RectF lineBgRectF;
    private int lineHeight;
    private Path lineIndicatorBgPath;
    private Path lineIndicatorCurrPath;
    private int lineIndicatorRadius;
    private int lineIndicatorStroke;
    private int lineLength;
    private int lineWidth;
    private float offset;
    private int pagerCount;
    private Paint paintBgFill;
    private Paint paintFill;
    private Paint paintStroke;
    private RelativeLayout.LayoutParams params;
    private Path path;
    private final RectF rectF;
    private int selectedColor;
    private RectF selectedLineRectF;
    private int selectedPage;
    private int unColor;

    /* compiled from: Taobao */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes12.dex */
    public @interface IndicatorStyle {
        public static final int INDICATOR_BEZIER = 2;
        public static final int INDICATOR_BIG_CIRCLE = 4;
        public static final int INDICATOR_CIRCLE = 0;
        public static final int INDICATOR_CIRCLE_RECT = 1;
        public static final int INDICATOR_DASH = 3;
        public static final int INDICATOR_LINE = 5;
    }

    public IndicatorView(Context context) {
        this(context, null);
    }

    private int dip2px(float f) {
        return (int) (f * getContext().getResources().getDisplayMetrics().density);
    }

    private void drawBezier(Canvas canvas, float f) {
        drawPagerCountCircle(canvas, f);
        if (this.path == null) {
            this.path = new Path();
        }
        if (this.accelerateInterpolator == null) {
            this.accelerateInterpolator = new AccelerateInterpolator();
        }
        float indicatorStartX = indicatorStartX(this.selectedPage);
        float indicatorStartX2 = indicatorStartX((this.selectedPage + 1) % this.pagerCount) - indicatorStartX;
        float interpolation = (this.accelerateInterpolator.getInterpolation(this.offset) * indicatorStartX2) + indicatorStartX;
        float interpolatedOffset = indicatorStartX + (indicatorStartX2 * interpolatedOffset());
        float ratioSelectedRadius = getRatioSelectedRadius();
        float f2 = this.indicatorSelectedRadius * 0.57f;
        float f3 = this.indicatorSelectedRatio * f2;
        float interpolatedOffset2 = ((f3 - ratioSelectedRadius) * interpolatedOffset()) + ratioSelectedRadius;
        float interpolation2 = f3 + ((ratioSelectedRadius - f3) * this.accelerateInterpolator.getInterpolation(this.offset));
        float interpolatedOffset3 = (this.indicatorSelectedRadius - f2) * interpolatedOffset();
        float interpolation3 = (this.indicatorSelectedRadius - f2) * this.accelerateInterpolator.getInterpolation(this.offset);
        this.indicatorPaint.setColor(this.selectedColor);
        float f4 = this.indicatorSelectedRadius;
        this.rectF.set(interpolation - interpolatedOffset2, (f - f4) + interpolatedOffset3, interpolation + interpolatedOffset2, (f4 + f) - interpolatedOffset3);
        canvas.drawRoundRect(this.rectF, interpolatedOffset2, interpolatedOffset2, this.indicatorPaint);
        float f5 = (f - f2) - interpolation3;
        float f6 = f2 + f + interpolation3;
        this.rectF.set(interpolatedOffset - interpolation2, f5, interpolatedOffset + interpolation2, f6);
        canvas.drawRoundRect(this.rectF, interpolation2, interpolation2, this.indicatorPaint);
        this.path.reset();
        this.path.moveTo(interpolatedOffset, f);
        this.path.lineTo(interpolatedOffset, f5);
        float f7 = ((interpolation - interpolatedOffset) / 2.0f) + interpolatedOffset;
        this.path.quadTo(f7, f, interpolation, (f - this.indicatorSelectedRadius) + interpolatedOffset3);
        this.path.lineTo(interpolation, (this.indicatorSelectedRadius + f) - interpolatedOffset3);
        this.path.quadTo(f7, f, interpolatedOffset, f6);
        this.path.close();
        canvas.drawPath(this.path, this.indicatorPaint);
    }

    private void drawBigCircle(Canvas canvas, float f) {
        drawPagerCountCircle(canvas, f);
        float interpolatedOffset = interpolatedOffset();
        float indicatorStartX = indicatorStartX(this.selectedPage);
        float indicatorStartX2 = indicatorStartX((this.selectedPage + 1) % this.pagerCount);
        float ratioRadius = getRatioRadius();
        float f2 = this.indicatorSelectedRadius;
        float f3 = this.indicatorSelectedRatio * f2;
        float f4 = (f3 - ratioRadius) * interpolatedOffset;
        float f5 = f3 - f4;
        float f6 = ratioRadius + f4;
        float f7 = (f2 - this.indicatorRadius) * interpolatedOffset;
        this.indicatorPaint.setColor(this.selectedColor);
        if (interpolatedOffset < 0.99f) {
            RectF rectF = this.rectF;
            rectF.set(indicatorStartX - f5, (f - f2) + f7, indicatorStartX + f5, (f2 + f) - f7);
            canvas.drawRoundRect(this.rectF, f5, f5, this.indicatorPaint);
        }
        if (interpolatedOffset > 0.1f) {
            float f8 = this.indicatorRadius;
            RectF rectF2 = this.rectF;
            rectF2.set(indicatorStartX2 - f6, (f - f8) - f7, indicatorStartX2 + f6, f + f8 + f7);
            canvas.drawRoundRect(this.rectF, f6, f6, this.indicatorPaint);
        }
    }

    private void drawCircle(Canvas canvas, float f) {
        drawPagerCountCircle(canvas, f);
        float indicatorStartX = indicatorStartX(this.selectedPage);
        float indicatorStartX2 = indicatorStartX((this.selectedPage + 1) % this.pagerCount);
        float ratioSelectedRadius = getRatioSelectedRadius();
        float f2 = indicatorStartX - ratioSelectedRadius;
        float f3 = indicatorStartX + ratioSelectedRadius;
        float f4 = indicatorStartX2 - ratioSelectedRadius;
        float interpolatedOffset = f3 + (((indicatorStartX2 + ratioSelectedRadius) - f3) * interpolatedOffset());
        RectF rectF = this.rectF;
        float f5 = this.indicatorSelectedRadius;
        rectF.set(f2 + ((f4 - f2) * interpolatedOffset()), f - f5, interpolatedOffset, f + f5);
        this.indicatorPaint.setColor(this.selectedColor);
        RectF rectF2 = this.rectF;
        float f6 = this.indicatorSelectedRadius;
        canvas.drawRoundRect(rectF2, f6, f6, this.indicatorPaint);
    }

    private void drawCircleRect(Canvas canvas, float f) {
        float max;
        float min;
        drawPagerCountCircle(canvas, f);
        float indicatorStartX = indicatorStartX(this.selectedPage);
        float ratioSelectedRadius = getRatioSelectedRadius();
        float f2 = indicatorStartX - ratioSelectedRadius;
        float f3 = indicatorStartX + ratioSelectedRadius;
        float interpolatedOffset = interpolatedOffset();
        float max2 = this.indicatorSpacing + (Math.max(getRatioRadius(), ratioSelectedRadius) * 2.0f);
        int i = this.selectedPage;
        if ((i + 1) % this.pagerCount == 0) {
            float f4 = max2 * (-i);
            max = f2 + Math.max(f4 * interpolatedOffset * 2.0f, f4);
            min = Math.min(f4 * (interpolatedOffset - 0.5f) * 2.0f, 0.0f);
        } else {
            max = f2 + Math.max((interpolatedOffset - 0.5f) * max2 * 2.0f, 0.0f);
            min = Math.min(interpolatedOffset * max2 * 2.0f, max2);
        }
        float f5 = f3 + min;
        RectF rectF = this.rectF;
        float f6 = this.indicatorSelectedRadius;
        rectF.set(max, f - f6, f5, f + f6);
        this.indicatorPaint.setColor(this.selectedColor);
        RectF rectF2 = this.rectF;
        float f7 = this.indicatorSelectedRadius;
        canvas.drawRoundRect(rectF2, f7, f7, this.indicatorPaint);
    }

    private void drawDash(Canvas canvas, float f) {
        float interpolatedOffset = interpolatedOffset();
        float ratioSelectedRadius = getRatioSelectedRadius();
        float ratioRadius = getRatioRadius();
        float f2 = ratioSelectedRadius - ratioRadius;
        float f3 = f2 * interpolatedOffset;
        int i = (this.selectedPage + 1) % this.pagerCount;
        boolean z = i == 0;
        this.indicatorPaint.setColor(this.unColor);
        for (int i2 = 0; i2 < this.pagerCount; i2++) {
            float indicatorStartX = indicatorStartX(i2);
            if (z) {
                indicatorStartX += f3;
            }
            float f4 = indicatorStartX - ratioRadius;
            float f5 = this.indicatorRadius;
            float f6 = f - f5;
            float f7 = indicatorStartX + ratioRadius;
            float f8 = f + f5;
            if (this.selectedPage + 1 <= i2) {
                this.rectF.set(f4 + f2, f6, f7 + f2, f8);
            } else {
                this.rectF.set(f4, f6, f7, f8);
            }
            RectF rectF = this.rectF;
            float f9 = this.indicatorRadius;
            canvas.drawRoundRect(rectF, f9, f9, this.indicatorPaint);
        }
        this.indicatorPaint.setColor(this.selectedColor);
        if (interpolatedOffset < 0.99f) {
            float indicatorStartX2 = indicatorStartX(this.selectedPage) - ratioSelectedRadius;
            if (z) {
                indicatorStartX2 += f3;
            }
            RectF rectF2 = this.rectF;
            float f10 = this.indicatorSelectedRadius;
            rectF2.set(indicatorStartX2, f - f10, (((ratioSelectedRadius * 2.0f) + indicatorStartX2) + f2) - f3, f + f10);
            RectF rectF3 = this.rectF;
            float f11 = this.indicatorSelectedRadius;
            canvas.drawRoundRect(rectF3, f11, f11, this.indicatorPaint);
        }
        if (interpolatedOffset > 0.1f) {
            float indicatorStartX3 = indicatorStartX(i) + ratioSelectedRadius;
            if (z) {
                f2 = f3;
            }
            float f12 = indicatorStartX3 + f2;
            RectF rectF4 = this.rectF;
            float f13 = this.indicatorSelectedRadius;
            rectF4.set((f12 - (ratioSelectedRadius * 2.0f)) - f3, f - f13, f12, f + f13);
            RectF rectF5 = this.rectF;
            float f14 = this.indicatorSelectedRadius;
            canvas.drawRoundRect(rectF5, f14, f14, this.indicatorPaint);
        }
    }

    private void drawLineIndicator(Canvas canvas) {
        int i;
        float width = getWidth();
        this.paintBgFill.setColor(this.unColor);
        this.paintFill.setColor(this.selectedColor);
        canvas.drawPath(this.lineIndicatorBgPath, this.paintBgFill);
        if (this.lineIndicatorStroke > 0) {
            canvas.drawPath(this.lineIndicatorBgPath, this.paintStroke);
        }
        int i2 = this.selectedPage;
        int i3 = this.pagerCount;
        if (i2 % i3 < i3 - 1) {
            float f = (i + 1) * (width / i3);
            if (this.selectedLineRectF == null) {
                this.selectedLineRectF = new RectF();
            }
            RectF rectF = this.selectedLineRectF;
            RectF rectF2 = this.lineBgRectF;
            rectF.set(0.0f, rectF2.top, f, rectF2.bottom);
            if (this.lineIndicatorCurrPath == null) {
                this.lineIndicatorCurrPath = new Path();
            }
            this.lineIndicatorCurrPath.reset();
            Path path = this.lineIndicatorCurrPath;
            RectF rectF3 = this.selectedLineRectF;
            int i4 = this.lineIndicatorRadius;
            path.addRoundRect(rectF3, i4, i4, Path.Direction.CW);
            canvas.drawPath(this.lineIndicatorCurrPath, this.paintFill);
            return;
        }
        canvas.drawPath(this.lineIndicatorBgPath, this.paintFill);
    }

    private void drawPagerCountCircle(Canvas canvas, float f) {
        this.indicatorPaint.setColor(this.unColor);
        for (int i = 0; i < this.pagerCount; i++) {
            float indicatorStartX = indicatorStartX(i);
            float ratioRadius = getRatioRadius();
            float f2 = this.indicatorRadius;
            this.rectF.set(indicatorStartX - ratioRadius, f - f2, indicatorStartX + ratioRadius, f2 + f);
            RectF rectF = this.rectF;
            float f3 = this.indicatorRadius;
            canvas.drawRoundRect(rectF, f3, f3, this.indicatorPaint);
        }
    }

    private float getRatioRadius() {
        return this.indicatorRadius * this.indicatorRatio;
    }

    private float getRatioSelectedRadius() {
        return this.indicatorSelectedRadius * this.indicatorSelectedRatio;
    }

    private float indicatorStartX(int i) {
        float ratioRadius = getRatioRadius();
        float max = Math.max(ratioRadius, getRatioSelectedRadius());
        return getPaddingLeft() + max + (((max * 2.0f) + this.indicatorSpacing) * i) + (this.indicatorStyle == 3 ? 0.0f : (max - ratioRadius) / 2.0f);
    }

    private float interpolatedOffset() {
        return this.interpolator.getInterpolation(this.offset);
    }

    private int measureHeight(int i) {
        int i2;
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        if (mode == Integer.MIN_VALUE || mode == 0) {
            size = (int) ((Math.max(getRatioSelectedRadius(), getRatioRadius()) * 2.0f) + getPaddingTop() + getPaddingBottom());
        } else if (mode != 1073741824) {
            size = 0;
        }
        return (this.indicatorStyle != 5 || size >= (i2 = this.lineWidth)) ? size : i2;
    }

    private int measureWidth(int i) {
        int i2;
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        if (mode == Integer.MIN_VALUE || mode == 0) {
            float ratioSelectedRadius = getRatioSelectedRadius();
            float ratioRadius = getRatioRadius();
            int i3 = this.pagerCount;
            size = (int) ((Math.max(ratioSelectedRadius, ratioRadius) * 2.0f * i3) + ((i3 - 1) * this.indicatorSpacing) + (ratioSelectedRadius - ratioRadius) + getPaddingLeft() + getPaddingRight());
        } else if (mode != 1073741824) {
            size = 0;
        }
        return (this.indicatorStyle != 5 || size >= (i2 = this.lineLength)) ? size : i2;
    }

    private void updateLineIndicatorPath() {
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        int i = this.lineHeight;
        float f = i > measuredHeight ? measuredHeight : i;
        float f2 = measuredHeight;
        this.lineBgRectF = new RectF(0.0f, (f2 - f) / 2.0f, measuredWidth, (f2 + f) / 2.0f);
        Path path = new Path();
        this.lineIndicatorBgPath = path;
        RectF rectF = this.lineBgRectF;
        int i2 = this.lineIndicatorRadius;
        path.addRoundRect(rectF, i2, i2, Path.Direction.CW);
    }

    @Override // com.alient.onearch.adapter.widget.banner.Indicator
    public RelativeLayout.LayoutParams getParams() {
        if (this.params == null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            this.params = layoutParams;
            layoutParams.addRule(12);
            this.params.addRule(14);
            this.params.bottomMargin = dip2px(10.0f);
        }
        return this.params;
    }

    @Override // com.alient.onearch.adapter.widget.banner.Indicator
    public View getView() {
        return this;
    }

    @Override // com.alient.onearch.adapter.widget.banner.Indicator
    public void initIndicatorCount(int i, int i2) {
        this.pagerCount = i;
        setVisibility(i > 1 ? 0 : 8);
        requestLayout();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.pagerCount == 0) {
            return;
        }
        float height = (getHeight() / 2.0f) + 0.5f;
        int i = this.indicatorStyle;
        if (i == 0) {
            drawCircle(canvas, height);
        } else if (i == 1) {
            drawCircleRect(canvas, height);
        } else if (i == 2) {
            drawBezier(canvas, height);
        } else if (i == 3) {
            drawDash(canvas, height);
        } else if (i == 4) {
            drawBigCircle(canvas, height);
        } else if (i == 5) {
            drawLineIndicator(canvas);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        setMeasuredDimension(measureWidth(i), measureHeight(i2));
        updateLineIndicatorPath();
    }

    @Override // com.alient.onearch.adapter.widget.banner.Indicator
    public void onPageScrollStateChanged(int i) {
    }

    @Override // com.alient.onearch.adapter.widget.banner.Indicator
    public void onPageScrolled(int i, float f, int i2) {
        this.selectedPage = i;
        this.offset = f;
        invalidate();
    }

    @Override // com.alient.onearch.adapter.widget.banner.Indicator
    public void onPageSelected(int i) {
    }

    public IndicatorView setIndicatorColor(@ColorInt int i) {
        this.unColor = i;
        return this;
    }

    public IndicatorView setIndicatorRadius(float f) {
        int dip2px = dip2px(f);
        if (this.indicatorRadius == this.indicatorSelectedRadius) {
            this.indicatorSelectedRadius = dip2px;
        }
        this.indicatorRadius = dip2px;
        return this;
    }

    public IndicatorView setIndicatorRatio(float f) {
        if (this.indicatorRatio == this.indicatorSelectedRatio) {
            this.indicatorSelectedRatio = f;
        }
        this.indicatorRatio = f;
        return this;
    }

    public IndicatorView setIndicatorSelectedRadius(float f) {
        this.indicatorSelectedRadius = dip2px(f);
        return this;
    }

    public IndicatorView setIndicatorSelectedRatio(float f) {
        this.indicatorSelectedRatio = f;
        return this;
    }

    public IndicatorView setIndicatorSelectorColor(@ColorInt int i) {
        this.selectedColor = i;
        return this;
    }

    public IndicatorView setIndicatorSpacing(float f) {
        this.indicatorSpacing = dip2px(f);
        return this;
    }

    public IndicatorView setIndicatorStyle(int i) {
        this.indicatorStyle = i;
        return this;
    }

    public IndicatorView setParams(RelativeLayout.LayoutParams layoutParams) {
        this.params = layoutParams;
        return this;
    }

    public IndicatorView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public IndicatorView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.interpolator = new DecelerateInterpolator();
        this.unColor = -7829368;
        this.selectedColor = -1;
        this.paintBgFill = new Paint(1);
        this.paintStroke = new Paint(1);
        this.paintFill = new Paint(1);
        this.lineIndicatorRadius = dip2px(2.0f);
        this.lineIndicatorStroke = 0;
        this.lineHeight = dip2px(2.0f);
        this.indicatorRadius = dip2px(3.5f);
        this.indicatorRatio = 1.0f;
        this.indicatorSelectedRadius = dip2px(3.5f);
        this.indicatorSelectedRatio = 1.0f;
        this.indicatorSpacing = dip2px(10.0f);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.IndicatorView);
        this.indicatorStyle = obtainStyledAttributes.getInt(R.styleable.IndicatorView_indicatorStyle, 0);
        this.unColor = obtainStyledAttributes.getColor(R.styleable.IndicatorView_unselectedColor, Color.parseColor("#99FF0000"));
        this.selectedColor = obtainStyledAttributes.getColor(R.styleable.IndicatorView_selectedColor, Color.parseColor("#FFFF0000"));
        this.lineLength = obtainStyledAttributes.getDimensionPixelSize(R.styleable.IndicatorView_indicatorLineLength, dip2px(150.0f));
        this.lineWidth = obtainStyledAttributes.getDimensionPixelSize(R.styleable.IndicatorView_indicatorLineWidth, dip2px(2.0f));
        this.lineIndicatorStroke = obtainStyledAttributes.getDimensionPixelSize(R.styleable.IndicatorView_lineStrokeWidth, 0);
        setIndicatorSpacing(obtainStyledAttributes.getDimensionPixelSize(R.styleable.IndicatorView_indicatorSpacing, 10));
        setIndicatorSelectedRadius(obtainStyledAttributes.getDimension(R.styleable.IndicatorView_indicatorSelectedRadius, 3.5f));
        setIndicatorRadius(obtainStyledAttributes.getDimension(R.styleable.IndicatorView_indicatorRadius, 3.5f));
        setIndicatorSelectedRatio(obtainStyledAttributes.getFloat(R.styleable.IndicatorView_indicatorSelectedRatio, 1.0f));
        setIndicatorRatio(obtainStyledAttributes.getFloat(R.styleable.IndicatorView_indicatorRatio, 1.0f));
        obtainStyledAttributes.recycle();
        this.rectF = new RectF();
        this.indicatorPaint = new Paint(1);
        this.paintBgFill.setColor(this.unColor);
        this.paintFill.setColor(this.selectedColor);
        this.paintStroke.setStyle(Paint.Style.STROKE);
    }
}
