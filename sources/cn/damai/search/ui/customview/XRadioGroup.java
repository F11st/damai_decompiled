package cn.damai.search.ui.customview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.l62;
import tb.mu0;

/* compiled from: Taobao */
/* loaded from: classes15.dex */
public class XRadioGroup extends RadioGroup {
    private static transient /* synthetic */ IpChange $ipChange;
    private int mIndicatorH;
    private int mIndicatorW;
    private Paint mPaint;
    private int mRadius;
    private RectF mRectF;
    public OnTouchL mTouchL;

    /* compiled from: Taobao */
    /* loaded from: classes15.dex */
    public interface OnTouchL {
        void onTouch();
    }

    public XRadioGroup(Context context) {
        this(context, null);
    }

    private void drawIndicator(RadioButton radioButton, Canvas canvas) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-598719928")) {
            ipChange.ipc$dispatch("-598719928", new Object[]{this, radioButton, canvas});
            return;
        }
        int left = radioButton.getLeft();
        int width = radioButton.getWidth();
        int height = getHeight();
        int i = this.mIndicatorW;
        float f = left + ((width - i) / 2.0f);
        int i2 = this.mIndicatorH;
        float f2 = height - i2;
        this.mRectF.set(f, f2, i + f, i2 + f2);
        RectF rectF = this.mRectF;
        int i3 = this.mRadius;
        canvas.drawRoundRect(rectF, i3, i3, this.mPaint);
    }

    @Override // android.widget.RadioGroup
    public void check(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "435176016")) {
            ipChange.ipc$dispatch("435176016", new Object[]{this, Integer.valueOf(i)});
        } else {
            super.check(i);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1661534956")) {
            ipChange.ipc$dispatch("-1661534956", new Object[]{this, canvas});
            return;
        }
        super.dispatchDraw(canvas);
        int childCount = getChildCount();
        if (childCount > 0) {
            for (int i = 0; i < childCount; i++) {
                View childAt = getChildAt(i);
                if (childAt instanceof RadioButton) {
                    RadioButton radioButton = (RadioButton) childAt;
                    if (radioButton.isChecked()) {
                        drawIndicator(radioButton, canvas);
                    }
                }
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-483874221")) {
            return ((Boolean) ipChange.ipc$dispatch("-483874221", new Object[]{this, motionEvent})).booleanValue();
        }
        OnTouchL onTouchL = this.mTouchL;
        if (onTouchL != null) {
            onTouchL.onTouch();
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public XRadioGroup(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mRectF = new RectF();
        this.mIndicatorH = l62.a(mu0.a(), 4.0f);
        this.mRadius = l62.a(mu0.a(), 3.0f);
        this.mIndicatorW = l62.a(mu0.a(), 18.0f);
        Paint paint = new Paint(1);
        this.mPaint = paint;
        paint.setColor(Color.parseColor("#FF2869"));
        this.mPaint.setStyle(Paint.Style.FILL);
        setWillNotDraw(false);
    }
}
