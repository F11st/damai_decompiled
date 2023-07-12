package cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import cn.damai.trade.R$styleable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class RoundArrowTextView extends AppCompatTextView {
    private static transient /* synthetic */ IpChange $ipChange;
    private float mArrowHeight;
    private float mArrowLocation;
    private int mLastViewHeight;
    private Paint mPaint;
    private RectF mRect;
    private Path mTrianglePath;

    public RoundArrowTextView(Context context) {
        this(context, null);
    }

    private void init(Context context, AttributeSet attributeSet, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1862068811")) {
            ipChange.ipc$dispatch("-1862068811", new Object[]{this, context, attributeSet, Integer.valueOf(i)});
            return;
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.RoundArrowTextView);
        this.mArrowHeight = obtainStyledAttributes.getDimension(R$styleable.RoundArrowTextView_arrow_height, 5.0f);
        int color = obtainStyledAttributes.getColor(R$styleable.RoundArrowTextView_bg_color, Color.parseColor("#CC000000"));
        this.mArrowLocation = obtainStyledAttributes.getDimension(R$styleable.RoundArrowTextView_arrow_location, 0.0f);
        obtainStyledAttributes.recycle();
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mPaint.setColor(color);
        this.mPaint.setStrokeCap(Paint.Cap.ROUND);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-753099888")) {
            ipChange.ipc$dispatch("-753099888", new Object[]{this, canvas});
            return;
        }
        int height = getHeight();
        if (height > 0) {
            float f = this.mArrowHeight;
            float f2 = height;
            if (f < f2) {
                float f3 = f2 - f;
                float f4 = f3 / 2.0f;
                this.mRect.set(0.0f, 0.0f, getWidth(), f3);
                canvas.drawRoundRect(this.mRect, f4, f4, this.mPaint);
                if (this.mArrowHeight > 0.0f) {
                    if (this.mTrianglePath == null || height != this.mLastViewHeight) {
                        this.mTrianglePath = new Path();
                        float tan = (float) (Math.tan(0.5235987755982988d) * this.mArrowHeight);
                        this.mTrianglePath.moveTo(this.mArrowLocation - tan, f3);
                        this.mTrianglePath.lineTo(this.mArrowLocation + tan, f3);
                        this.mTrianglePath.lineTo(this.mArrowLocation, f2);
                        this.mTrianglePath.close();
                    }
                    canvas.drawPath(this.mTrianglePath, this.mPaint);
                }
            }
        }
        this.mLastViewHeight = height;
        super.onDraw(canvas);
    }

    public RoundArrowTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RoundArrowTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mRect = new RectF();
        this.mPaint = new Paint(1);
        init(context, attributeSet, i);
    }
}
