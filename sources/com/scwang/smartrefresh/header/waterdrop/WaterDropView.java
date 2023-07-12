package com.scwang.smartrefresh.header.waterdrop;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import androidx.annotation.ColorInt;
import com.scwang.smartrefresh.layout.util.DensityUtil;
import com.youku.live.livesdk.wkit.component.common.utils.SystemBarTintManager;
import tb.qi;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class WaterDropView extends View {
    protected static final int BACK_ANIM_DURATION = 180;
    protected static int STROKE_WIDTH = 2;
    protected qi bottomCircle;
    protected int mMaxCircleRadius;
    protected int mMinCircleRadius;
    protected Paint mPaint;
    protected Path mPath;
    protected qi topCircle;

    /* compiled from: Taobao */
    /* renamed from: com.scwang.smartrefresh.header.waterdrop.WaterDropView$a */
    /* loaded from: classes6.dex */
    class C6173a implements ValueAnimator.AnimatorUpdateListener {
        C6173a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            WaterDropView.this.updateCompleteState(((Float) valueAnimator.getAnimatedValue()).floatValue());
            WaterDropView.this.postInvalidate();
        }
    }

    public WaterDropView(Context context) {
        super(context);
        this.topCircle = new qi();
        this.bottomCircle = new qi();
        this.mPath = new Path();
        Paint paint = new Paint();
        this.mPaint = paint;
        paint.setColor(-7829368);
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        Paint paint2 = this.mPaint;
        int dp2px = DensityUtil.dp2px(1.0f);
        STROKE_WIDTH = dp2px;
        paint2.setStrokeWidth(dp2px);
        Paint paint3 = this.mPaint;
        int i = STROKE_WIDTH;
        paint3.setShadowLayer(i, i / 2, i, SystemBarTintManager.DEFAULT_TINT_COLOR);
        setLayerType(1, null);
        int i2 = STROKE_WIDTH * 4;
        setPadding(i2, i2, i2, i2);
        this.mPaint.setColor(-7829368);
        int dp2px2 = DensityUtil.dp2px(20.0f);
        this.mMaxCircleRadius = dp2px2;
        this.mMinCircleRadius = dp2px2 / 5;
        qi qiVar = this.topCircle;
        qiVar.c = dp2px2;
        qi qiVar2 = this.bottomCircle;
        qiVar2.c = dp2px2;
        int i3 = STROKE_WIDTH;
        qiVar.a = i3 + dp2px2;
        qiVar.b = i3 + dp2px2;
        qiVar2.a = i3 + dp2px2;
        qiVar2.b = i3 + dp2px2;
    }

    private double getAngle() {
        qi qiVar = this.bottomCircle;
        float f = qiVar.c;
        qi qiVar2 = this.topCircle;
        float f2 = qiVar2.c;
        if (f > f2) {
            return 0.0d;
        }
        return Math.asin((f2 - f) / (qiVar.b - qiVar2.b));
    }

    private void makeBezierPath() {
        this.mPath.reset();
        Path path = this.mPath;
        qi qiVar = this.topCircle;
        path.addCircle(qiVar.a, qiVar.b, qiVar.c, Path.Direction.CCW);
        if (this.bottomCircle.b > this.topCircle.b + DensityUtil.dp2px(1.0f)) {
            Path path2 = this.mPath;
            qi qiVar2 = this.bottomCircle;
            path2.addCircle(qiVar2.a, qiVar2.b, qiVar2.c, Path.Direction.CCW);
            double angle = getAngle();
            qi qiVar3 = this.topCircle;
            float cos = (float) (qiVar3.a - (qiVar3.c * Math.cos(angle)));
            qi qiVar4 = this.topCircle;
            float sin = (float) (qiVar4.b + (qiVar4.c * Math.sin(angle)));
            qi qiVar5 = this.topCircle;
            float cos2 = (float) (qiVar5.a + (qiVar5.c * Math.cos(angle)));
            qi qiVar6 = this.bottomCircle;
            float cos3 = (float) (qiVar6.a - (qiVar6.c * Math.cos(angle)));
            qi qiVar7 = this.bottomCircle;
            float sin2 = (float) (qiVar7.b + (qiVar7.c * Math.sin(angle)));
            qi qiVar8 = this.bottomCircle;
            float cos4 = (float) (qiVar8.a + (qiVar8.c * Math.cos(angle)));
            Path path3 = this.mPath;
            qi qiVar9 = this.topCircle;
            path3.moveTo(qiVar9.a, qiVar9.b);
            this.mPath.lineTo(cos, sin);
            Path path4 = this.mPath;
            qi qiVar10 = this.bottomCircle;
            path4.quadTo(qiVar10.a - qiVar10.c, (qiVar10.b + this.topCircle.b) / 2.0f, cos3, sin2);
            this.mPath.lineTo(cos4, sin2);
            Path path5 = this.mPath;
            qi qiVar11 = this.bottomCircle;
            path5.quadTo(qiVar11.a + qiVar11.c, (qiVar11.b + sin) / 2.0f, cos2, sin);
        }
        this.mPath.close();
    }

    public ValueAnimator createAnimator() {
        ValueAnimator duration = ValueAnimator.ofFloat(1.0f, 0.001f).setDuration(180L);
        duration.setInterpolator(new DecelerateInterpolator());
        duration.addUpdateListener(new C6173a());
        return duration;
    }

    public qi getBottomCircle() {
        return this.bottomCircle;
    }

    public int getIndicatorColor() {
        return this.mPaint.getColor();
    }

    public int getMaxCircleRadius() {
        return this.mMaxCircleRadius;
    }

    public qi getTopCircle() {
        return this.topCircle;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int paddingTop = getPaddingTop();
        int paddingLeft = getPaddingLeft();
        int paddingBottom = getPaddingBottom();
        int height = getHeight();
        canvas.save();
        float f = height;
        float f2 = this.topCircle.c;
        float f3 = paddingTop;
        float f4 = paddingBottom;
        if (f <= (f2 * 2.0f) + f3 + f4) {
            canvas.translate(paddingLeft, (f - (f2 * 2.0f)) - f4);
            qi qiVar = this.topCircle;
            canvas.drawCircle(qiVar.a, qiVar.b, qiVar.c, this.mPaint);
        } else {
            canvas.translate(paddingLeft, f3);
            makeBezierPath();
            canvas.drawPath(this.mPath, this.mPaint);
        }
        canvas.restore();
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        updateCompleteState(getHeight());
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int i3 = this.mMaxCircleRadius;
        int i4 = STROKE_WIDTH;
        qi qiVar = this.bottomCircle;
        super.setMeasuredDimension(((i3 + i4) * 2) + getPaddingLeft() + getPaddingRight(), View.resolveSize(((int) Math.ceil(qiVar.b + qiVar.c + (i4 * 2))) + getPaddingTop() + getPaddingBottom(), i2));
    }

    public void setIndicatorColor(@ColorInt int i) {
        this.mPaint.setColor(i);
    }

    public void updateCompleteState(float f) {
        int i = this.mMaxCircleRadius;
        float f2 = f * 4.0f * i;
        qi qiVar = this.topCircle;
        qiVar.c = (float) (i - ((f * 0.25d) * i));
        qi qiVar2 = this.bottomCircle;
        qiVar2.c = ((this.mMinCircleRadius - i) * f) + i;
        qiVar2.b = qiVar.b + f2;
    }

    public void updateCompleteState(int i, int i2) {
    }

    public void updateCompleteState(int i) {
        float f;
        float f2;
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int i2 = this.mMaxCircleRadius;
        if (i < (i2 * 2) + paddingTop + paddingBottom) {
            qi qiVar = this.topCircle;
            qiVar.c = i2;
            qi qiVar2 = this.bottomCircle;
            qiVar2.c = i2;
            qiVar2.b = qiVar.b;
            return;
        }
        float pow = (float) ((i2 - this.mMinCircleRadius) * (1.0d - Math.pow(100.0d, (-Math.max(0.0f, f2 - f)) / DensityUtil.dp2px(200.0f))));
        qi qiVar3 = this.topCircle;
        int i3 = this.mMaxCircleRadius;
        qiVar3.c = i3 - (pow / 4.0f);
        qi qiVar4 = this.bottomCircle;
        float f3 = i3 - pow;
        qiVar4.c = f3;
        qiVar4.b = ((i - paddingTop) - paddingBottom) - f3;
    }
}
