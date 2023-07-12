package cn.damai.uikit.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Region;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.q60;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class CornersLinearLayout extends LinearLayout {
    private static transient /* synthetic */ IpChange $ipChange;
    private float round;

    public CornersLinearLayout(Context context) {
        super(context);
        this.round = q60.a(getContext(), 6.0f);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-177896197")) {
            ipChange.ipc$dispatch("-177896197", new Object[]{this, canvas});
            return;
        }
        if (this.round > 0.0f) {
            Path path = new Path();
            RectF rectF = new RectF(getPaddingLeft(), getPaddingTop(), getWidth() - getPaddingRight(), getHeight() - getPaddingBottom());
            float f = this.round;
            path.addRoundRect(rectF, f, f, Path.Direction.CW);
            canvas.clipPath(path, Region.Op.INTERSECT);
        }
        super.dispatchDraw(canvas);
    }

    public void setRound(float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1687443012")) {
            ipChange.ipc$dispatch("1687443012", new Object[]{this, Float.valueOf(f)});
        } else {
            this.round = f;
        }
    }

    public CornersLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.round = q60.a(getContext(), 6.0f);
    }

    public CornersLinearLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.round = q60.a(getContext(), 6.0f);
    }
}
