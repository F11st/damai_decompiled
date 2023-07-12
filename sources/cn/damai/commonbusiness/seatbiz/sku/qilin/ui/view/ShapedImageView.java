package cn.damai.commonbusiness.seatbiz.sku.qilin.ui.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatImageView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.q60;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class ShapedImageView extends AppCompatImageView {
    private static transient /* synthetic */ IpChange $ipChange;
    private Path mPath;
    private float[] mRadius;
    private RectF rectF;

    public ShapedImageView(Context context) {
        super(context);
        this.mRadius = new float[8];
        init(null);
    }

    private void init(AttributeSet attributeSet) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "152737317")) {
            ipChange.ipc$dispatch("152737317", new Object[]{this, attributeSet});
            return;
        }
        setLayerType(2, null);
        this.mPath = new Path();
        this.mRadius = new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, q60.a(getContext(), 6.0f), q60.a(getContext(), 6.0f)};
        this.rectF = new RectF(0.0f, 0.0f, 0.0f, 0.0f);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "800615023")) {
            ipChange.ipc$dispatch("800615023", new Object[]{this, canvas});
            return;
        }
        this.rectF.right = getMeasuredWidth();
        this.rectF.bottom = getMeasuredHeight();
        this.mPath.addRoundRect(this.rectF, this.mRadius, Path.Direction.CW);
        canvas.clipPath(this.mPath);
        super.onDraw(canvas);
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "545298628")) {
            ipChange.ipc$dispatch("545298628", new Object[]{this, Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)});
            return;
        }
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            int measuredWidth = getMeasuredWidth();
            int measuredHeight = getMeasuredHeight();
            RectF rectF = this.rectF;
            rectF.right = measuredWidth;
            rectF.bottom = measuredHeight;
        }
    }

    public void setRadius(float[] fArr) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2069098872")) {
            ipChange.ipc$dispatch("-2069098872", new Object[]{this, fArr});
            return;
        }
        this.mRadius = fArr;
        invalidate();
    }

    public ShapedImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mRadius = new float[8];
        init(attributeSet);
    }

    public ShapedImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mRadius = new float[8];
        init(attributeSet);
    }
}
