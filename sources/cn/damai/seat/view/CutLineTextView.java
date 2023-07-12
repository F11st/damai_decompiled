package cn.damai.seat.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class CutLineTextView extends AppCompatTextView {
    private static transient /* synthetic */ IpChange $ipChange;
    Paint mPaint;

    public CutLineTextView(Context context) {
        this(context, null);
    }

    private void init() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1635187790")) {
            ipChange.ipc$dispatch("-1635187790", new Object[]{this});
            return;
        }
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setStrokeWidth(2.0f);
        this.mPaint.setColor(Color.parseColor("#999999"));
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "183820646")) {
            ipChange.ipc$dispatch("183820646", new Object[]{this, canvas});
            return;
        }
        super.onDraw(canvas);
        int width = getWidth();
        float height = (getHeight() * 3.0f) / 5.0f;
        canvas.drawLine(0.0f, height, width, height, this.mPaint);
    }

    public CutLineTextView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CutLineTextView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mPaint = new Paint(1);
        init();
    }
}
