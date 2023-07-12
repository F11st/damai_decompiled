package cn.damai.tetris.component.music.viewholder;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.ViewFlipper;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public class ClipViewFlipper extends ViewFlipper {
    private static transient /* synthetic */ IpChange $ipChange;
    private Path mPath;

    public ClipViewFlipper(Context context) {
        super(context);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2075936442")) {
            ipChange.ipc$dispatch("2075936442", new Object[]{this, canvas});
            return;
        }
        try {
            if (this.mPath != null) {
                canvas.save();
                canvas.clipPath(this.mPath);
            }
            super.dispatchDraw(canvas);
            if (this.mPath != null) {
                canvas.restore();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1794057107")) {
            ipChange.ipc$dispatch("-1794057107", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)});
            return;
        }
        super.onSizeChanged(i, i2, i3, i4);
        this.mPath = new Path();
        float f = i;
        float f2 = i2;
        this.mPath.addRoundRect(new RectF(0.0f, 0.0f, f, f2), f / 2.0f, f2 / 2.0f, Path.Direction.CW);
    }

    public ClipViewFlipper(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
