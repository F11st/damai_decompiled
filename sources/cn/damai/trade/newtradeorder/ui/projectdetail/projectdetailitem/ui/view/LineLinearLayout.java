package cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.m62;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public class LineLinearLayout extends LinearLayout {
    private static transient /* synthetic */ IpChange $ipChange;
    private Paint mPaint;
    private int offset;

    public LineLinearLayout(Context context) {
        this(context, null);
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onDraw(Canvas canvas) {
        int i;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1253823046")) {
            ipChange.ipc$dispatch("-1253823046", new Object[]{this, canvas});
            return;
        }
        super.onDraw(canvas);
        int height = getHeight();
        int width = getWidth();
        float f = height - 1;
        canvas.drawLine(this.offset, f, width - i, f, this.mPaint);
    }

    public LineLinearLayout(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public LineLinearLayout(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mPaint = new Paint(1);
        setWillNotDraw(false);
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setStrokeWidth(1.0f);
        this.mPaint.setColor(Color.parseColor("#19000000"));
        this.offset = m62.a(context, 21.0f);
    }
}
