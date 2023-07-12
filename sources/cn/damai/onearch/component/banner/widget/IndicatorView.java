package cn.damai.onearch.component.banner.widget;

import android.content.Context;
import android.graphics.Canvas;
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
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class IndicatorView extends View implements Indicator {
    private static transient /* synthetic */ IpChange $ipChange;
    private Interpolator accelerateInterpolator;
    private final Paint indicatorPaint;
    private float indicatorRadius;
    private float indicatorRatio;
    private float indicatorSelectedRadius;
    private float indicatorSelectedRatio;
    private float indicatorSpacing;
    private int indicatorStyle;
    private final Interpolator interpolator;
    private float offset;
    private int pagerCount;
    private RelativeLayout.LayoutParams params;
    private Path path;
    private final RectF rectF;
    private int selectedColor;
    private int selectedPage;
    private int unColor;

    /* compiled from: Taobao */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes15.dex */
    public @interface IndicatorStyle {
        public static final int INDICATOR_BEZIER = 2;
        public static final int INDICATOR_BIG_CIRCLE = 4;
        public static final int INDICATOR_CIRCLE = 0;
        public static final int INDICATOR_CIRCLE_RECT = 1;
        public static final int INDICATOR_DASH = 3;
    }

    public IndicatorView(Context context) {
        this(context, null);
    }

    private int dip2px(float f) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-310366015") ? ((Integer) ipChange.ipc$dispatch("-310366015", new Object[]{this, Float.valueOf(f)})).intValue() : (int) (f * getContext().getResources().getDisplayMetrics().density);
    }

    private void drawBezier(Canvas canvas, float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "165100601")) {
            ipChange.ipc$dispatch("165100601", new Object[]{this, canvas, Float.valueOf(f)});
            return;
        }
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
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-677481288")) {
            ipChange.ipc$dispatch("-677481288", new Object[]{this, canvas, Float.valueOf(f)});
            return;
        }
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
            this.rectF.set(indicatorStartX - f5, (f - f2) + f7, indicatorStartX + f5, (f2 + f) - f7);
            canvas.drawRoundRect(this.rectF, f5, f5, this.indicatorPaint);
        }
        if (interpolatedOffset > 0.1f) {
            float f8 = this.indicatorRadius;
            this.rectF.set(indicatorStartX2 - f6, (f - f8) - f7, indicatorStartX2 + f6, f + f8 + f7);
            canvas.drawRoundRect(this.rectF, f6, f6, this.indicatorPaint);
        }
    }

    private void drawCircle(Canvas canvas, float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-823627800")) {
            ipChange.ipc$dispatch("-823627800", new Object[]{this, canvas, Float.valueOf(f)});
            return;
        }
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
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-989891484")) {
            ipChange.ipc$dispatch("-989891484", new Object[]{this, canvas, Float.valueOf(f)});
            return;
        }
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
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1708978586")) {
            ipChange.ipc$dispatch("-1708978586", new Object[]{this, canvas, Float.valueOf(f)});
            return;
        }
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

    private void drawPagerCountCircle(Canvas canvas, float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "7298876")) {
            ipChange.ipc$dispatch("7298876", new Object[]{this, canvas, Float.valueOf(f)});
            return;
        }
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
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "800966698") ? ((Float) ipChange.ipc$dispatch("800966698", new Object[]{this})).floatValue() : this.indicatorRadius * this.indicatorRatio;
    }

    private float getRatioSelectedRadius() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-936039217") ? ((Float) ipChange.ipc$dispatch("-936039217", new Object[]{this})).floatValue() : this.indicatorSelectedRadius * this.indicatorSelectedRatio;
    }

    private float indicatorStartX(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-793301713")) {
            return ((Float) ipChange.ipc$dispatch("-793301713", new Object[]{this, Integer.valueOf(i)})).floatValue();
        }
        float ratioRadius = getRatioRadius();
        float max = Math.max(ratioRadius, getRatioSelectedRadius());
        return getPaddingLeft() + max + (((max * 2.0f) + this.indicatorSpacing) * i) + (this.indicatorStyle == 3 ? 0.0f : (max - ratioRadius) / 2.0f);
    }

    private float interpolatedOffset() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1881616101") ? ((Float) ipChange.ipc$dispatch("-1881616101", new Object[]{this})).floatValue() : this.interpolator.getInterpolation(this.offset);
    }

    private int measureHeight(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1795756338")) {
            return ((Integer) ipChange.ipc$dispatch("1795756338", new Object[]{this, Integer.valueOf(i)})).intValue();
        }
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        if (mode == Integer.MIN_VALUE || mode == 0) {
            return (int) ((Math.max(getRatioSelectedRadius(), getRatioRadius()) * 2.0f) + getPaddingTop() + getPaddingBottom());
        }
        if (mode != 1073741824) {
            return 0;
        }
        return size;
    }

    private int measureWidth(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1012816323")) {
            return ((Integer) ipChange.ipc$dispatch("-1012816323", new Object[]{this, Integer.valueOf(i)})).intValue();
        }
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        if (mode != Integer.MIN_VALUE && mode != 0) {
            if (mode != 1073741824) {
                return 0;
            }
            return size;
        }
        float ratioSelectedRadius = getRatioSelectedRadius();
        float ratioRadius = getRatioRadius();
        int i2 = this.pagerCount;
        return (int) ((Math.max(ratioSelectedRadius, ratioRadius) * 2.0f * i2) + ((i2 - 1) * this.indicatorSpacing) + (ratioSelectedRadius - ratioRadius) + getPaddingLeft() + getPaddingRight());
    }

    @Override // cn.damai.onearch.component.banner.widget.Indicator
    public RelativeLayout.LayoutParams getParams() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-336453179")) {
            return (RelativeLayout.LayoutParams) ipChange.ipc$dispatch("-336453179", new Object[]{this});
        }
        if (this.params == null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            this.params = layoutParams;
            layoutParams.addRule(12);
            this.params.addRule(14);
            this.params.bottomMargin = dip2px(10.0f);
        }
        return this.params;
    }

    @Override // cn.damai.onearch.component.banner.widget.Indicator
    public View getView() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-697634992") ? (View) ipChange.ipc$dispatch("-697634992", new Object[]{this}) : this;
    }

    @Override // cn.damai.onearch.component.banner.widget.Indicator
    public void initIndicatorCount(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2055360623")) {
            ipChange.ipc$dispatch("-2055360623", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
            return;
        }
        this.pagerCount = i;
        setVisibility(i <= 1 ? 8 : 0);
        requestLayout();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1272253209")) {
            ipChange.ipc$dispatch("-1272253209", new Object[]{this, canvas});
            return;
        }
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
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1531025802")) {
            ipChange.ipc$dispatch("1531025802", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
        } else {
            setMeasuredDimension(measureWidth(i), measureHeight(i2));
        }
    }

    @Override // cn.damai.onearch.component.banner.widget.Indicator
    public void onPageScrollStateChanged(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-865780672")) {
            ipChange.ipc$dispatch("-865780672", new Object[]{this, Integer.valueOf(i)});
        }
    }

    @Override // cn.damai.onearch.component.banner.widget.Indicator
    public void onPageScrolled(int i, float f, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1778644769")) {
            ipChange.ipc$dispatch("-1778644769", new Object[]{this, Integer.valueOf(i), Float.valueOf(f), Integer.valueOf(i2)});
            return;
        }
        this.selectedPage = i;
        this.offset = f;
        invalidate();
    }

    @Override // cn.damai.onearch.component.banner.widget.Indicator
    public void onPageSelected(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "127363979")) {
            ipChange.ipc$dispatch("127363979", new Object[]{this, Integer.valueOf(i)});
        }
    }

    public IndicatorView setIndicatorColor(@ColorInt int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1988193015")) {
            return (IndicatorView) ipChange.ipc$dispatch("-1988193015", new Object[]{this, Integer.valueOf(i)});
        }
        this.unColor = i;
        return this;
    }

    public IndicatorView setIndicatorRadius(float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "115882811")) {
            return (IndicatorView) ipChange.ipc$dispatch("115882811", new Object[]{this, Float.valueOf(f)});
        }
        int dip2px = dip2px(f);
        if (this.indicatorRadius == this.indicatorSelectedRadius) {
            this.indicatorSelectedRadius = dip2px;
        }
        this.indicatorRadius = dip2px;
        return this;
    }

    public IndicatorView setIndicatorRatio(float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "699639300")) {
            return (IndicatorView) ipChange.ipc$dispatch("699639300", new Object[]{this, Float.valueOf(f)});
        }
        if (this.indicatorRatio == this.indicatorSelectedRatio) {
            this.indicatorSelectedRatio = f;
        }
        this.indicatorRatio = f;
        return this;
    }

    public IndicatorView setIndicatorSelectedRadius(float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "14247136")) {
            return (IndicatorView) ipChange.ipc$dispatch("14247136", new Object[]{this, Float.valueOf(f)});
        }
        this.indicatorSelectedRadius = dip2px(f);
        return this;
    }

    public IndicatorView setIndicatorSelectedRatio(float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1943286719")) {
            return (IndicatorView) ipChange.ipc$dispatch("1943286719", new Object[]{this, Float.valueOf(f)});
        }
        this.indicatorSelectedRatio = f;
        return this;
    }

    public IndicatorView setIndicatorSelectorColor(@ColorInt int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "972227592")) {
            return (IndicatorView) ipChange.ipc$dispatch("972227592", new Object[]{this, Integer.valueOf(i)});
        }
        this.selectedColor = i;
        return this;
    }

    public IndicatorView setIndicatorSpacing(float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1828892020")) {
            return (IndicatorView) ipChange.ipc$dispatch("-1828892020", new Object[]{this, Float.valueOf(f)});
        }
        this.indicatorSpacing = dip2px(f);
        return this;
    }

    public IndicatorView setIndicatorStyle(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "989191675")) {
            return (IndicatorView) ipChange.ipc$dispatch("989191675", new Object[]{this, Integer.valueOf(i)});
        }
        this.indicatorStyle = i;
        return this;
    }

    public IndicatorView setParams(RelativeLayout.LayoutParams layoutParams) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1390945732")) {
            return (IndicatorView) ipChange.ipc$dispatch("-1390945732", new Object[]{this, layoutParams});
        }
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
        this.indicatorRadius = dip2px(3.5f);
        this.indicatorRatio = 1.0f;
        this.indicatorSelectedRadius = dip2px(3.5f);
        this.indicatorSelectedRatio = 1.0f;
        this.indicatorSpacing = dip2px(10.0f);
        this.rectF = new RectF();
        this.indicatorPaint = new Paint(1);
    }
}
